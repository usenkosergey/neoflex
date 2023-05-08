package ru.test.neoflex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.test.neoflex.service.VacationPayService;

@Log4j2
@RestController("/")
public class Loader {

    private final VacationPayService vacationPayService;

    public Loader(VacationPayService vacationPayService) {
        this.vacationPayService = vacationPayService;
    }

    @GetMapping("calculacte")
    public ResponseEntity<String> vacationPayCalculation(@RequestParam(name = "average-salary") Double averageSalary,
                                                         @RequestParam(name = "vacation-days") Integer vacationDays) {
        return new ResponseEntity<>(vacationPayService.getVacationPay(averageSalary, vacationDays).toString(), HttpStatus.OK);
    }
}
