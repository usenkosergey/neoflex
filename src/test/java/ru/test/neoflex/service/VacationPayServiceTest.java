package ru.test.neoflex.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VacationPayServiceTest {


    private final VacationPayService vacationPayService = new VacationPayService();

    @Test
    void getVacationPayOk() {
        Double averageSalary = 51666.67;
        Integer vacationDays = 12;

        assertEquals(new BigDecimal("18409.55"), vacationPayService.getVacationPay(averageSalary, vacationDays));
    }
    @Test
    void getVacationPayFail(){
        Double averageSalary = 50000.00;
        Integer vacationDays = 12;

        assertNotEquals(new BigDecimal("18409.55"), vacationPayService.getVacationPay(averageSalary, vacationDays));
    }

    @Test
    void getVacationPayException(){
        Double averageSalary = -5.00;
        Integer vacationDays = 12;

        assertThrows(ArithmeticException.class, () -> vacationPayService.getVacationPay(averageSalary, vacationDays));
    }

}