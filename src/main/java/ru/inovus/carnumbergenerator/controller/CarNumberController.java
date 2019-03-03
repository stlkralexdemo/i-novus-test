package ru.inovus.carnumbergenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.carnumbergenerator.model.CarNumber;
import ru.inovus.carnumbergenerator.service.CarNumberService;


@RestController
public class CarNumberController {

    private final CarNumberService service;
    private CarNumber carNumber;

    @Autowired
    public CarNumberController(CarNumberService service) {
        this.service = service;
    }

    @RequestMapping("/number")
    public String welcome() {
        return "Welcome to Car Number Generator";
    }

    @RequestMapping(value = "/number/random")
    public String random() {
        carNumber = service.randomNumber();
        return carNumber.toString();
    }

    @RequestMapping(value = "/number/next")
    public String next() {
        return service.nextNumber(carNumber).toString();
    }
}
