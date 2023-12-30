package com.example.cardeal.repositories;

import com.example.cardeal.model.entities.Person;
import com.example.cardeal.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{
    List<Person> findPersonByName(String name);
    List<Person> findPersonByFamily(String family);
    List<Person> findPersonByNameAndFamily(String name, String family);
    List<Person> findPersonByRole(Role role);
    Person findPersonByNationalCode(String nationalCode);
    Person findPersonByPhoneNumber(String phoneNumber);
    Person findPersonByEmail(String email);
}