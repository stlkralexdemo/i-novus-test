package ru.inovus.carnumbergenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.carnumbergenerator.service.CarNumberService;


@RestController
@RequestMapping("/number")
public class CarNumberController {

    private final CarNumberService service;

    @Autowired
    public CarNumberController(CarNumberService service) {
        this.service = service;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to Car Number Generator";
    }

    @GetMapping(value = "/random")
    public String random() {
        return service.randomNumber();
    }

    @GetMapping(value = "/next")
    public String next() {
        return service.nextNumber();
    }
}
