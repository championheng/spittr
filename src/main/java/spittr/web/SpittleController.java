package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.DAOImpl.SpittleRepository;
import spittr.model.Spittle;

import java.util.List;

/**
 * Created by hg_yi on 17-10-12.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam(value = "max", defaultValue = "20") long max,
                           @RequestParam(value = "count", defaultValue = "20") int count,
                           Model model) {
        model.addAttribute("spittleList", spittleRepository.findSpittles(max, count));

        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        List<Spittle> spittleList = spittleRepository.findOne(spittleId);
        if (spittleList.size() == 0) {
            throw new SpittleNotFoundException();
        }

        model.addAttribute("spittleList", spittleList);

        return "spittles";
    }
}

