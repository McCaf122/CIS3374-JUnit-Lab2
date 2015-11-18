package com.lab2.calculator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lab2.transit.FareCalculator;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FareCalcTest {

	private static final double DELTA = 1e-15;
	
	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;
	
	public FareCalcTest(double expected, int age, String time, boolean isHoliday) 
	{
		this.expected = expected;
		this.age = age;
		this.time = time;
		this.isHoliday = isHoliday;
	}
	
	@Parameters
	public static Collection<Object[]> testParams()
	{
		return Arrays.asList(new Object[][]{
				{0.0, 5, "13:00", false},
				{2.5, 6, "13:00", false},
				{2.5, 64, "13:00", false},
				{0.0, 65, "13:00", false},
				
				{0.0, 5, "13:00", true},
				{2.5, 6, "13:00", true},
				{2.5, 64, "13:00", true},
				{0.0, 65, "13:00", true},
				

				{2.5, 21, "6:59", false},
				{2.5, 21, "7:00", false},
				{2.5, 21, "8:59", false},
				{2.5, 21, "9:00", false},
				
				{0.0, 80, "13:00", true},
				{2.5, 21, "8:00", false}
				}); 
		
	}
	
	@Test
	public void calculateFareTest(){
		assertEquals(expected, FareCalculator.calculateFare(age, time, isHoliday), DELTA);
	}
}