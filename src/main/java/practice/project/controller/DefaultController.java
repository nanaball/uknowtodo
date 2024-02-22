package practice.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    @GetMapping(value = "/")
    public ModelAndView root() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Hello");
        mav.addObject("name", "수연");
        mav.addObject("name1", "가연");
        return mav;
    }
}
