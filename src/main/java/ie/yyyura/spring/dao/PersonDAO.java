package ie.yyyura.spring.dao;

import ie.yyyura.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int COUNT;
    private List<Person> peopleList;

    //initialization block
    {
        peopleList = new ArrayList<>();
        //public Person(int id, String name)
        peopleList.add(new Person(++COUNT, "Tom"));
        peopleList.add(new Person(++COUNT, "Bom"));
        peopleList.add(new Person(++COUNT, "Pom"));
    }

    //return all
    public List<Person> all() {
        return peopleList;
    }

    //get one with id
    public Person one(int idIN) {
        return peopleList.stream().filter(p -> p.getId() == idIN).findAny().orElse(null);
    }

    //save
    public void save(Person person){
        person.setId(++COUNT);
        peopleList.add(person);
    }

}
