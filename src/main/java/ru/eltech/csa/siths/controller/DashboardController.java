package ru.eltech.csa.siths.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value="/")
public class DashboardController {

    @RequestMapping(method=RequestMethod.GET)
    public String getDashboardAction(Model model) {
        return "dashboardView";
    }

}
