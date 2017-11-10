package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public String processRegistration(@Valid @ModelAttribute("spitter") Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        MultipartFile profilePicturee = spitter.getProfilePicture();
        try {
            profilePicturee.transferTo(new File("/tmp/uploads/"
                    + profilePicturee.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        spitterRepository.save(spitter);

        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("username") String username, Model model) {
        List<Spitter> spitters = spitterRepository.findByUsername(username);
        model.addAttribute("spitterList", spitters);

        return "profile";
    }
}
