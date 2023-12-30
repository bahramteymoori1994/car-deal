package com.example.cardeal.controllers;

import com.example.cardeal.exceptions.ServiceException;
import com.example.cardeal.model.entities.Car;
import com.example.cardeal.model.enums.CarModel;
import com.example.cardeal.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController extends AbstractBaseController<CarService, Car>
{
    @Autowired
    private CarService carService;

    @GetMapping("/search/name")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Car> findCarByName(@RequestParam(name = "name", required = false) String name) throws ServiceException
    {
        return carService.findAllCarsByName(name);
    }

    @GetMapping("/search/company_name")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Car> findAllCarsByCompanyName(@RequestParam(name = "carCompany", required = false) String companyName) throws ServiceException
    {
        return carService.findCarsByCompanyCar(companyName);
    }

    @GetMapping("/search/car_model")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<Car> findAllCarsByCarModel(@RequestParam(name = "carModel", required = false) CarModel carModel) throws ServiceException
    {
        return carService.findCarsByCarModel(carModel);
    }
}