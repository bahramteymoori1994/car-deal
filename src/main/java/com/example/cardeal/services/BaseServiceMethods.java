package com.example.cardeal.services;

import com.example.cardeal.exceptions.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BaseServiceMethods<R extends JpaRepository<E, Long>, E>
{
    E add(E entity) throws ServiceException;
    E update(E entity) throws ServiceException;
    void deleteById(Long id) throws ServiceException;
    List<E> findAll() throws ServiceException;
    E findById(Long id) throws ServiceException;
}