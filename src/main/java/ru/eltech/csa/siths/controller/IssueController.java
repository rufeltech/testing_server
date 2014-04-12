package ru.eltech.csa.siths.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import ru.eltech.csa.siths.service.behaviour.IssueService;
import ru.eltech.csa.siths.entity.node.Issue;

import ru.eltech.csa.siths.service.behaviour.ObjectMessageDigestService;

@Controller
public class IssueController {

    @Autowired
    IssueService issueService;

    @Autowired
    ObjectMessageDigestService md5ObjectMessageDigestService;

	@RequestMapping(value="/issue/create", method=RequestMethod.GET)
    public String getIssueCreationFormAction(Model model) {
        model.addAttribute("issue", new Issue());
        return "issueCreateView";
    }

    @RequestMapping(value="/issue/create", method=RequestMethod.POST)
    public String createIssueAction( @Valid Issue issue, BindingResult bindingResult ) {

        if ( bindingResult.hasErrors() ) {
            return "issueCreateView";
        }
        if ( this.issueService.isIssueExists( issue ) ) {
            bindingResult.reject("error.issue", "That issue is already registered in the system");
        }
        if ( bindingResult.hasErrors() ) {
            return "issueCreateView";
        }

        Issue registeredIssue = this.issueService.createIssue(issue);
        if (registeredIssue == null) {
            bindingResult.reject("error.issue", "An error occured while creating an issue");
            return "issueCreateView";
        }

        return "redirect:/";
    }

    @RequestMapping(value="/issue/view/{issueId}", method=RequestMethod.GET)
    public String viewIssueAction( Model model,
                                   @PathVariable("issueId") long issueId ) {
        model.addAttribute("greeting", new String("Here u will view the issue #" + issueId));
        return "issueViewView";
    }

    @RequestMapping(value="/issue/delete/{issueId}", method=RequestMethod.POST)
    public String deleteIssueAction( Model model,
                                     @PathVariable("issueId") long issueId ) {
        model.addAttribute("greeting", new String("U just have to delete the issue #" + issueId));
        return "helloTmpl";
    }

    @RequestMapping(value="/issue/edit/{issueId}", method=RequestMethod.GET)
    public String getIssueEditFormAction( Model model,
                                          @PathVariable("issueId") long issueId ) {
        model.addAttribute("greeting", new String("Here u will edit the issue #" + issueId));
        return "helloTmpl";
    }

    @RequestMapping(value="/issue/edit/{issueId}", method=RequestMethod.POST)
    public String editIssueAction( Model model, 
                                   @PathVariable("issueId") long issueId) {
        model.addAttribute("greeting", new String("U just have to edit the issue #" + issueId));
        return "helloTmpl";
    }

}
