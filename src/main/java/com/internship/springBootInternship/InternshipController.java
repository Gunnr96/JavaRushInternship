package com.internship.springBootInternship;

import com.internship.springBootInternship.DAO.Part;
import com.internship.springBootInternship.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/")
public class InternshipController {

    private PartService partService;

    @Autowired
    public void setPartService(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/parts")
    public ModelAndView helloPage(@RequestParam(name = "page", required = false, defaultValue = "1") String page,
                                  @RequestParam(name = "filter", required = false, defaultValue = "all") String filter) {
        ModelAndView model = new ModelAndView("helloPage");

        int pageInt = Integer.parseInt(page);
        if (pageInt <= 0)
            model.addObject("list", partService.getAll());
        else
            model.addObject("list", partService.getPage(pageInt, filter));
            model.addObject("page", page);
            model.addObject("pagesNum", partService.getNumberOfPages(filter));
            model.addObject("filter", filter);
        return model;
    }

    @GetMapping("/")
    public RedirectView redirect(RedirectAttributes attributes) {
        attributes.addAttribute("page", "1");
        return new RedirectView("parts");
    }

    @GetMapping("/{id}/delete")
    public RedirectView delete(@PathVariable(value="id") long id, RedirectAttributes attributes) {

        partService.delete(id);
        return new RedirectView("//localhost:8080");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editPage(@PathVariable(value="id") long id) {
        ModelAndView model = new ModelAndView("edit");
        model.addObject("part", partService.getPart(id));
        return model;
    }

    @GetMapping("/{id}/edit/form")
    public RedirectView editFormProcessing(@PathVariable(value="id") long id,
                                           @RequestParam(value="PartName") String partName,
                                           @RequestParam(value="IsNecessary", required = false, defaultValue = "false") boolean isNecessary,
                                           @RequestParam(value="Amount") int amount) {
        Part toEdit = new Part();
        toEdit.setId(id);
        toEdit.setPartName(partName);
        toEdit.setNecessary(isNecessary);
        toEdit.setAmount(amount);
        partService.editPart(toEdit);
        return new RedirectView("//localhost:8080");
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value="query") String query) {
        ModelAndView model = new ModelAndView("helloPage");

        model.addObject("list", partService.getByName(query));
        model.addObject("page", 1);
        model.addObject("pagesNum", 1);
        model.addObject("filter", "all");
        return model;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("add");
    }

    @GetMapping("/add/form")
    public RedirectView addPartForm(@RequestParam(value="PartName") String partName,
                                    @RequestParam(value="IsNecessary", required = false, defaultValue = "false") boolean isNecessary,
                                    @RequestParam(value="Amount") int amount) {
        Part toAdd = new Part();
        toAdd.setPartName(partName);
        toAdd.setNecessary(isNecessary);
        toAdd.setAmount(amount);
        partService.editPart(toAdd);
        return new RedirectView("//localhost:8080");
    }
}
