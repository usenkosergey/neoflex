package ru.test.neoflex.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Log4j2
@Service
public class VacationPayService {

    public BigDecimal getVacationPay(Double averageSalary, Integer vacationDays) {

        if (averageSalary <= 0 || vacationDays <= 0) {
            log.info("averageSalary - {}, vacationDays - {}", averageSalary, vacationDays);
            throw new ArithmeticException("Данные для расчета не корректные");
        }

        final double averageNumberDaysInMonth = 29.3;
        final BigDecimal NDFL = new BigDecimal("0.13");

        final BigDecimal vacationPayWithTaxes = new BigDecimal(averageSalary / averageNumberDaysInMonth * vacationDays);
        final BigDecimal vacationPay = vacationPayWithTaxes.subtract(vacationPayWithTaxes.multiply(NDFL));

        log.info("----");
        return vacationPay.setScale(2, RoundingMode.FLOOR);
    }
}
