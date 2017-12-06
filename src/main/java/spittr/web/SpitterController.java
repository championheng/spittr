package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.DAOImpl.SpitterRepository;
import spittr.model.Spitter;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by hg_yi on 17-11-8.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter", new Spitter());

        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    //校验表单输入
    public String processRegistration(@RequestParam("profilePicture") MultipartFile profilePicture,
                                      @Valid Spitter spitter, RedirectAttributes model, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        try {
            if (!profilePicture.isEmpty()) {
                profilePicture.transferTo(new File("tmp/uploads/" + profilePicture.getOriginalFilename()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        spitterRepository.save(spitter);
        model.addAttribute("username", spitter.getUsername());
        model.addFlashAttribute("spitter", spitter);

        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("username") String username, Model model) {
        if (!model.containsAttribute(username)) {
            List<Spitter> spitters = spitterRepository.findByUsername(username);
            model.addAttribute("spitterList", spitters);
        }

        return "profile";
    }
}
