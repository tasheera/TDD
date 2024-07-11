package com.realestateapp;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ApartmentRaterTest {


    @Test
    public void should_ReturnCorrectRating_When_CorrectApartment1(){
        Assertions.assertEquals(1, ApartmentRater.rateApartment(new Apartment(3, new BigDecimal(17999))));
    }

    @Test
    public void should_ReturnCorrectRating_When_CorrectApartment2(){
        Assertions.assertEquals(0, ApartmentRater.rateApartment(new Apartment(30, new BigDecimal(15000))));
    }

    @Test
    public void should_ReturnCorrectRating_When_CorrectApartment3(){
        Assertions.assertEquals(2, ApartmentRater.rateApartment(new Apartment(10, new BigDecimal(179255))));
    }

    @Test
    public void should_ReturnErrorValue_When_IncorrectApartment(){
        assertEquals(-1, ApartmentRater.rateApartment(new Apartment(0,new BigDecimal(10000))));
    }


    @Test
    public void should_CalculateAverageRating_When_CorrectApartmentList(){

        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new Apartment(5000.0, new BigDecimal("300000")));
        apartments.add(new Apartment(7500.0, new BigDecimal("500000")));
        apartments.add(new Apartment(10000.0, new BigDecimal("700000")));
        apartments.add(new Apartment(16000,new BigDecimal(8000)));
        double delta = 0.0001;
        assertEquals(0.0, ApartmentRater.calculateAverageRating(apartments), delta);
    }

    @Test(expected = RuntimeException.class)
    public void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList(){
        List<Apartment> apartments = new ArrayList<>();
        ApartmentRater.calculateAverageRating(apartments);
    }
}
