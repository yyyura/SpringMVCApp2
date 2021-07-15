package ie.yyyura.spring.controllers;

import ie.yyyura.spring.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String all(Model model){
        model.addAttribute("allPeople", personDAO.all());
        return "people/all";
    }

    @GetMapping("/{id}")
    public String one(@PathVariable("id") int idIN, Model model){
        model.addAttribute("onePerson", personDAO.one(idIN));
        return "people/one";
    }

}
