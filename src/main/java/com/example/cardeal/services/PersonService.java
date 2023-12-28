package com.example.cardeal.services;

import com.example.cardeal.exceptions.personexceptions.*;
import com.example.cardeal.exceptions.personexceptions.PersonIdNotFoundException;
import com.example.cardeal.exceptions.ServiceException;
import com.example.cardeal.model.entities.Person;
import com.example.cardeal.model.enums.Role;
import com.example.cardeal.model.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements BaseServiceMethods<PersonRepository, Person>
{
    @Autowired
    private PersonRepository personRepository;


    @Override
    public Person add(Person person) throws ServiceException
    {
        if( person == null )
        {
            throw new ServiceException();
        }
        else
        {
            return personRepository.save(person);
        }
    }

    @Override
    public Person update(Person person) throws ServiceException
    {
        if( person == null )
        {
            throw new ServiceException();
        }
        else
        {
            return personRepository.save(person);
        }
    }

    @Override
    public void deleteById(Long id) throws ServiceException
    {
        if( id != personRepository.findById(id).get().getId() )
        {
            throw new ServiceException();
        }
        else
        {
            personRepository.deleteById(id);
        }
    }

    @Override
    public List<Person> findAll() throws ServiceException
    {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) throws ServiceException
    {
        Optional<Person> person = personRepository.findById(id);

        if( !person.isPresent() )
        {
            throw new PersonIdNotFoundException();
        }
        else
        {
            return personRepository.findById(id).get();
        }
    }
    public List<Person> findPersonByFirstName(String name) throws ServiceException
    {
        Person person = new Person();

        if( !name.equals(personRepository.findPersonByName(person.getName())) )
        {
            throw new NameNotFoundException();
        }
        else
        {
            return personRepository.findPersonByName(name);
        }
    }
    public List<Person> findPersonByLastName(String family) throws ServiceException
    {
        Person person = new Person();

        if( !family.equals(personRepository.findPersonByFamily(person.getFamily())) )
        {
            throw new FamilyNotFoundException();
        }
        else
        {
            return personRepository.findPersonByFamily(family);
        }
    }
    public List<Person> findPersonByNameAndFamily(String name, String family) throws ServiceException
    {
        return personRepository.findPersonByNameAndFamily(name, family);
    }

    public List<Person> findAllPeopleByRole(Role role) throws ServiceException
    {
        switch( role )
        {
            case BUYER:
                return personRepository.findPersonByRole(Role.BUYER);

            case SELLER:
                return personRepository.findPersonByRole(Role.SELLER);

            default:
                throw new ServiceException();
        }
    }

    public Person findPersonByNationalCode(String nationalCode) throws ServiceException
    {
        Person person = new Person();

        if( !nationalCode.equals(personRepository.findPersonByNationalCode(person.getNationalCode())) )
        {
            throw new NationalCodeNotFoundException();
        }
        else
        {
            return personRepository.findPersonByNationalCode(nationalCode);
        }
    }

    public Person findPersonByPhoneNumber(String phoneNumber) throws ServiceException
    {
        Person person = new Person();

        if( !phoneNumber.equals(personRepository.findPersonByPhoneNumber(person.getPhoneNumber())) )
        {
            throw new PhoneNumberNotFoundException();
        }
        else
        {
            return personRepository.findPersonByPhoneNumber(phoneNumber);
        }
    }

    public Person findPersonByEmail(String email) throws ServiceException
    {
        Person person = new Person();

        if( !email.equals(personRepository.findPersonByEmail(person.getEmail())) )
        {
            throw new EmailNotFoundException();
        }
        else
        {
            return personRepository.findPersonByEmail(email);
        }
    }
}