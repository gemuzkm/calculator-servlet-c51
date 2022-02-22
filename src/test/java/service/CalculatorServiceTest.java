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
    void getResultSum() {
        CalculatorService calculatorService = new CalculatorService();
        User user = new User("admin","admin","admin", "1", 2);

        String result = calculatorService.getResult(new ValueOne(2),new ValueTwo(2),new Operator("sum"), user);
        String testData = String.valueOf(4.0);
        assertEquals(testData, result);
    }

    @Test
    void getResultDif() {
        CalculatorService calculatorService = new CalculatorService();
        User user = new User("admin","admin","admin", "1", 2);

        String result = calculatorService.getResult(new ValueOne(2),new ValueTwo(2),new Operator("dif"), user);
        String testData = String.valueOf(0.0);
        assertEquals(testData, result);
    }

    @Test
    void getResultDiv() {
        CalculatorService calculatorService = new CalculatorService();
        User user = new User("admin","admin","admin", "1", 2);

        String result = calculatorService.getResult(new ValueOne(2),new ValueTwo(2),new Operator("div"), user);
        String testData = String.valueOf(1.0);
        assertEquals(testData, result);
    }

    @Test
    void getResultDivNaN() {
        CalculatorService calculatorService = new CalculatorService();
        User user = new User("admin","admin","admin", "1", 2);

        String result = calculatorService.getResult(new ValueOne(2),new ValueTwo(0),new Operator("div"), user);
        String testData = String.valueOf("NaN");
        assertEquals(testData, result);
    }

    @Test
    void getResultMult() {
        CalculatorService calculatorService = new CalculatorService();
        User user = new User("admin","admin","admin", "1", 2);

        String result = calculatorService.getResult(new ValueOne(2),new ValueTwo(10),new Operator("mult"), user);
        String testData = String.valueOf("20.0");
        assertEquals(testData, result);
    }
}