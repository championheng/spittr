package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by hg_yi on 17-10-11.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = GET)
    public String home() {
        return "home";
    }
}
