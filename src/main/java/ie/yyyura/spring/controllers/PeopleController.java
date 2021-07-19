package ie.yyyura.spring.controllers;

import ie.yyyura.spring.dao.PersonDAO;
import ie.yyyura.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //add new person
    //1. GET people/new -> HTML form
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }
//    same as above
//    @GetMapping("/new")
//    public String newPerson(Model model){
//        model.addAttribute("newPerson", new Person());
//        return "people/new";
//    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/people";
    }
//    same as above
//    @PostMapping()
//    public String createPerson(@RequestParam("newName") String nameIN, Model model){
//
//        Person person = new Person();
//        person.setName(nameIN);
//
//        model.addAttribute("person", person);
//        return "people/all";
//    }


}
