package com.example.cardeal.services;

import com.example.cardeal.exceptions.ServiceException;
import com.example.cardeal.exceptions.carexceptions.CarCompanyNotFoundException;
import com.example.cardeal.exceptions.carexceptions.CarIdNotFoundException;
import com.example.cardeal.exceptions.carexceptions.CarNotFoundException;
import com.example.cardeal.model.entities.Car;
import com.example.cardeal.model.entities.Person;
import com.example.cardeal.model.enums.CarModel;
import com.example.cardeal.model.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements BaseServiceMethods<CarRepository, Car>
{
    @Autowired
    private CarRepository carRepository;


    @Override
    public Car add(Car car) throws ServiceException
    {
        if( car == null )
        {
            throw new ServiceException();
        }
        else
        {
            return carRepository.save(car);
        }
    }

    @Override
    public Car update(Car car) throws ServiceException
    {
        if( car == null )
        {
            throw new ServiceException();
        }
        else
        {
            return carRepository.save(car);
        }
    }

    @Override
    public void deleteById(Long id) throws ServiceException
    {
        if( id != carRepository.findById(id).get().getId() )
        {
            throw new ServiceException();
        }
        else
        {
            carRepository.deleteById(id);
        }
    }

    @Override
    public List<Car> findAll() throws ServiceException {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) throws ServiceException
    {
        Optional<Car> car = carRepository.findById(id);

        if( !car.isPresent() )
        {
            throw new CarIdNotFoundException();
        }
        else
        {
            return carRepository.findById(id).get();
        }
    }

    public List<Car> findAllCarsByName(String name) throws ServiceException
    {
        Car car = new Car();

        if( !name.equals(carRepository.findCarByName(car.getName())) )
        {
            throw new CarNotFoundException();
        }
        else
        {
            return carRepository.findCarByName(name);
        }
    }

    public List<Car> findCarsByCompanyCar(String companyName) throws ServiceException
    {
        Car car = new Car();

        if( !companyName.equals(carRepository.findCarsByCompanyName(car.getCompanyName())) )
        {
            throw new CarCompanyNotFoundException();
        }
        else
        {
            return carRepository.findCarsByCompanyName(companyName);
        }
    }

    public List<Car> findCarsByCarModel(CarModel carModel) throws ServiceException
    {
        switch( carModel )
        {
            case MANUAL:
                return carRepository.findCarsByCarModel(CarModel.MANUAL);

            case AUTOMATIC:
                return carRepository.findCarsByCarModel(CarModel.AUTOMATIC);

            default:
                throw new ServiceException();
        }
    }
}