package com.example.cardeal.controllers;

import com.example.cardeal.exceptions.ServiceException;
import com.example.cardeal.model.entities.Person;
import com.example.cardeal.model.enums.Role;
import com.example.cardeal.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController extends AbstractBaseController<PersonService, Person>
{
    @Autowired
    private PersonService personService;


    @GetMapping("/search/first_name")
    public List<Person> findPersonByFirstName(@RequestParam(name = "name", required = false) String name) throws ServiceException
    {
        return personService.findPersonByFirstName(name);
    }

    @GetMapping("/search/last_name")
    public List<Person> findPersonByLastName(@RequestParam(name = "family", required = false) String family) throws ServiceException
    {
        return personService.findPersonByLastName(family);
    }

    @GetMapping("/search/name_family")
    public List<Person> findPersonByNameAndFamily(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "family", required = false) String family) throws ServiceException
    {
        return personService.findPersonByNameAndFamily(name, family);
    }

    @GetMapping("/search/role")
    public List<Person> findPeopleByRole(@RequestParam(value = "role", required = false) Role role) throws ServiceException
    {
        return personService.findAllPeopleByRole(role);
    }

    @GetMapping("/search/national_code")
    public Person findPersonByNationalCode(@RequestParam(name = "nationalCode", required = false) String nationalCode) throws ServiceException
    {
        return personService.findPersonByNationalCode(nationalCode);
    }

    @GetMapping("/search/phone_number")
    public Person findPersonByPhoneNumber(@RequestParam(name = "phoneNumber", required = false) String phoneNumber) throws ServiceException
    {
        return personService.findPersonByPhoneNumber(phoneNumber);
    }

    @GetMapping("/search/email")
    public Person findPersonByEmail(@RequestParam(name = "email", required = false) String email) throws ServiceException
    {
        return personService.findPersonByEmail(email);
    }
}