package com.example.cardeal.services;

import com.example.cardeal.exceptions.ServiceException;
import com.example.cardeal.exceptions.dealexceptions.IdDealNotFoundException;
import com.example.cardeal.model.entities.Deal;
import com.example.cardeal.repositories.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealService implements BaseServiceMethods<DealRepository, Deal>
{
    @Autowired
    private DealRepository dealRepository;

    @Override
    public Deal add(Deal deal) throws ServiceException
    {
        if( deal == null )
        {
            throw new ServiceException();
        }
        else
        {
            return dealRepository.save(deal);
        }
    }

    @Override
    public Deal update(Deal deal) throws ServiceException
    {
        if( deal == null )
        {
            throw new ServiceException();
        }
        else
        {
            return dealRepository.save(deal);
        }
    }

    @Override
    public void deleteById(Long id) throws ServiceException
    {
        if( id != dealRepository.findById(id).get().getId() )
        {
            throw new ServiceException();
        }
        else
        {
            dealRepository.deleteById(id);
        }
    }

    @Override
    public List<Deal> findAll() throws ServiceException {
        return dealRepository.findAll();
    }

    @Override
    public Deal findById(Long id) throws ServiceException
    {
        Optional<Deal> deal = dealRepository.findById(id);

        if( !deal.isPresent() )
        {
            throw new IdDealNotFoundException();
        }
        else
        {
            return dealRepository.findById(id).get();
        }
    }
}