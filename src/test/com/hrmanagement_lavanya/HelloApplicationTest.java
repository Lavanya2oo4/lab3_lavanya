package com.hrmanagement_lavanya;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {

    @Test
    void calcSalary() {
        HelloApplication hello=new HelloApplication();
//        assertEquals(hello.calcSalary(2000),24000);
        assertEquals(hello.calcSalary(2000),23000);
    }
}