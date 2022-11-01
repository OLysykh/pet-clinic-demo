package oleksandr.spring5.petclinicdemo.controllers;

import oleksandr.spring5.petclinicdemo.model.Owner;
import oleksandr.spring5.petclinicdemo.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

//    @RequestMapping({"", "/", "/index", "/index.html"})
//    public String listOwners(Model model) {
//        model.addAttribute("owners", ownerService.findAll());
//        return "owners/index";
//    }

    @RequestMapping("/find")
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }


    @GetMapping("/{ownerId}")
    public ModelAndView showOner(@PathVariable("ownerId") Long id) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject("owner", ownerService.findById(id));
        return mav;
    }

    @GetMapping
    public String processFindForms(Owner owner, BindingResult result, Model model) {
        //if request is empty all owners will be returned;
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }
        //ok, so we are going to receive a list of owners, it can  be empty if there is no such LastName!
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            //only 1 owner has been found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            //multiole case
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }

    }

}
