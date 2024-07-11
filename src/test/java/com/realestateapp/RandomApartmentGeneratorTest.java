package com.realestateapp;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomApartmentGeneratorTest {

    @Test
    public void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice1(){
        RandomApartmentGenerator randomApartmentGenerator = new RandomApartmentGenerator();
        assertTrue(randomApartmentGenerator.generate().getArea()>=30);
    }

    @Test
    public void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice2(){
        RandomApartmentGenerator randomApartmentGenerator = new RandomApartmentGenerator();
        assertTrue(randomApartmentGenerator.generate().getPrice().intValue() > BigDecimal.valueOf(3000.0).intValue());
    }

    @Test
    public void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice1(){
        RandomApartmentGenerator rag = new RandomApartmentGenerator(3200,new BigDecimal(29000));
        double delta = 0.0001;
        assertEquals(3200.0, rag.minArea, delta);
    }

    @Test
    public void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice2(){
        RandomApartmentGenerator rag = new RandomApartmentGenerator(3200,new BigDecimal(29000));
        assertEquals(new BigDecimal(29000), rag.minPricePerSquareMeter);
    }

}
