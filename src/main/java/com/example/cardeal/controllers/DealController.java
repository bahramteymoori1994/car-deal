package com.example.cardeal.controllers;

import com.example.cardeal.model.entities.Deal;
import com.example.cardeal.services.DealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deal")
public class DealController extends AbstractBaseController<DealService, Deal>{
}
