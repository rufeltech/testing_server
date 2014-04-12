package ru.eltech.csa.siths.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CompanyController {

	@RequestMapping(value="/company/create", method=RequestMethod.GET)
    public String getCompanyCreationFormAction(Model model) {
        model.addAttribute("greeting", new String("Here u will create the company"));
        return "helloTmpl";
    }

    @RequestMapping(value="/company/create", method=RequestMethod.POST)
    public String createCompanyAction(Model model) {
        model.addAttribute("greeting", new String("U just have to create the company"));
        return "helloTmpl";
    }

    @RequestMapping(value="/company/view/{companyId}", method=RequestMethod.GET)
    public String viewIssueAction( Model model,
                                   @PathVariable("companyId") long companyId ) {
        model.addAttribute("greeting", new String("Here u will view the company #" + companyId));
        return "helloTmpl";
    }

    @RequestMapping(value="/company/delete/{companyId}", method=RequestMethod.POST)
    public String deleteIssueAction( Model model,
                                     @PathVariable("companyId") long companyId ) {
        model.addAttribute("greeting", new String("U just have to delete the company #" + companyId));
        return "helloTmpl";
    }

    @RequestMapping(value="/company/edit/{companyId}", method=RequestMethod.GET)
    public String getIssueEditFormAction( Model model,
                                          @PathVariable("companyId") long companyId ) {
        model.addAttribute("greeting", new String("Here u will edit the company #" + companyId));
        return "helloTmpl";
    }

    @RequestMapping(value="/company/edit/{companyId}", method=RequestMethod.POST)
    public String editIssueAction( Model model, 
                                   @PathVariable("companyId") long companyId) {
        model.addAttribute("greeting", new String("U just have to edit the company #" + companyId));
        return "helloTmpl";
    }

}
