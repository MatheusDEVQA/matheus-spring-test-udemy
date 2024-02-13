package controllers;

import com.matheus.devqa.matheusspringtestudemy.Gretting;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.PersonServices;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(
            @PathVariable(value = "id") String id) throws Exception {
        return services.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return services.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(
            @RequestBody Person person) {
        return services.create(person);
    }

    @RequestMapping(method=RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }


}