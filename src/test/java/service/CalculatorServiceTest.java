package service;

import entity.Operator;
import entity.User;
import entity.ValueOne;
import entity.ValueTwo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

//    @BeforeAll
//    static void init() {
//        System.out.println("each");
//    }

//    @AfterEach
//    void del() {
//        System.out.printf(""after);
//    }

//    @Order(1) //порядок

    @Test
    void getResult() {
        CalculatorService calculatorService = new CalculatorService();
        User user = new User("admin","admin","admin", "1", 2);

        String result = calculatorService.getResult(new ValueOne(2),new ValueTwo(2),new Operator("sum"), user);
        String sample = String.valueOf(4.0);
        assertEquals(sample, result);
    }
}