package com.example.cardeal.controllers;

import com.example.cardeal.exceptions.ServiceException;
import com.example.cardeal.services.BaseServiceMethods;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
public abstract class AbstractBaseController<S extends BaseServiceMethods<?, E>, E>
{
    @Autowired
    private S service;
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractBaseController.class);


    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public E add(@Valid @RequestBody E entity) throws ServiceException
    {
        return service.add(entity);
    }

    @PutMapping()
    public E update(@Valid @RequestBody E entity) throws ServiceException
    {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) throws ServiceException
    {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public E findById(@PathVariable("id") Long id) throws ServiceException
    {
        return service.findById(id);
    }

    @GetMapping()
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<E> findAll() throws ServiceException
    {
        return service.findAll();
    }
}