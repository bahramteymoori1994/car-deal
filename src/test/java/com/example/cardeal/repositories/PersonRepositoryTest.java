package com.example.cardeal.repositories;

import com.example.cardeal.model.entities.Car;
import com.example.cardeal.model.entities.Person;
import com.example.cardeal.model.enums.CarModel;
import com.example.cardeal.model.enums.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.AutoConfigureGraphQl;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void shouldSavePersonIntoRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi@gamil.com")
                .phoneNumber("09123233931")
                .nationalCode("1234567890")
                .cars(Arrays.asList(car))
                .build();

        Person savedPerson = personRepository.save(person);

        Assertions.assertThat(savedPerson).isNotNull();
    }

    @Test
    public void deletePersonByIdFromRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi1@gamil.com")
                .phoneNumber("09123233930")
                .nationalCode("1234567891")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        personRepository.deleteById(person.getId());

        Optional<Person> deletedPerson = personRepository.findById(person.getId());

        Assertions.assertThat(deletedPerson).isEmpty();
    }

    @Test
    public void getAllPeopleFromRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi11@gamil.com")
                .phoneNumber("09123233939")
                .nationalCode("1234567892")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        List<Person> getAllPeople = personRepository.findAll();

        Assertions.assertThat(getAllPeople).isNotNull();
    }

    @Test
    public void shouldGetOnePersonFromRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi111@gamil.com")
                .phoneNumber("09123233938")
                .nationalCode("1234567893")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);

        Optional<Person> optionalPerson = personRepository.findById(person.getId());

        Assertions.assertThat(optionalPerson).isPresent();
    }

    @Test
    void shouldFindPersonByNameFromRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi2@gamil.com")
                .phoneNumber("09123233937")
                .nationalCode("1234567894")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        List<Person> findPersonByName = personRepository.findPersonByName(person.getName());

        Assertions.assertThat(findPersonByName).isNotEmpty();
    }

    @Test
    void shouldFindPersonByFamilyFromRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi2@gamil.com")
                .phoneNumber("09123233937")
                .nationalCode("1234567894")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        List<Person> findPersonByFamily = personRepository.findPersonByFamily(person.getFamily());

        Assertions.assertThat(findPersonByFamily).isNotEmpty();
    }

    @Test
    void findPersonByNameAndFamily()
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi2@gamil.com")
                .phoneNumber("09123233937")
                .nationalCode("1234567894")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        List<Person> findPersonByNameAndFamily = personRepository.findPersonByNameAndFamily(
                person.getName(), person.getFamily()
        );

        Assertions.assertThat(findPersonByNameAndFamily).isNotEmpty();
    }

    @Test
    void shouldFindPersonByRoleFromRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi2@gamil.com")
                .phoneNumber("09123233937")
                .nationalCode("1234567894")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        List<Person> findPeopleRole = personRepository.findPersonByRole(person.getRole());

        Assertions.assertThat(findPeopleRole).isNotEmpty();
    }

    @Test
    void shouldFindPersonByNationalCodeFromRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi2@gamil.com")
                .phoneNumber("09123233937")
                .nationalCode("1234567894")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        Person findPersonByNationalCode = personRepository.findPersonByNationalCode(person.getNationalCode());

        Assertions.assertThat(findPersonByNationalCode).isNotNull();
    }

    @Test
    void shouldFindPersonByPhoneNumberFromRepository() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi2@gamil.com")
                .phoneNumber("09123233937")
                .nationalCode("1234567894")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        Person findPersonByPhoneNumber = personRepository.findPersonByPhoneNumber(person.getPhoneNumber());

        Assertions.assertThat(findPersonByPhoneNumber).isNotNull();
    }

    @Test
    void findPersonByEmail() throws Exception
    {
        Car car = Car.builder()
                .companyName("IKCO")
                .carModel(CarModel.MANUAL)
                .name("dena+")
                .carCount(100)
                .carBuyPrice(1500000L)
                .build();

        Person person = Person.builder()
                .name("reza")
                .family("rezayi")
                .role(Role.SELLER)
                .email("reza.rezayi2@gamil.com")
                .phoneNumber("09123233937")
                .nationalCode("1234567894")
                .cars(Arrays.asList(car))
                .build();

        personRepository.save(person);
        Person findPersonByEmail = personRepository.findPersonByEmail(person.getEmail());

        Assertions.assertThat(findPersonByEmail).isNotNull();
    }
}