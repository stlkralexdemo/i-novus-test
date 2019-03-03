package ru.inovus.carnumbergenerator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.carnumbergenerator.model.CarNumber;

import static ru.inovus.carnumbergenerator.service.CarNumberService.nextNumber;
import static ru.inovus.carnumbergenerator.service.CarNumberService.randomNumber;


@RestController
public class CarNumberController {

    private CarNumber carNumber;

    @RequestMapping("/number")
    public String welcome() {
        return "Welcome to Car Number Generator";
    }

    @RequestMapping(value = "/number/random")
    public String random() {
        carNumber = randomNumber();
        return carNumber.toString();
    }

    @RequestMapping(value = "/number/next")
    public String next() {
        return nextNumber(carNumber).toString();
    }
}
