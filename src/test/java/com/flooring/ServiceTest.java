package com.flooring;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ServiceTest {
	
	@Mock
	AddCalculator calculator; // creating mock calculator using annotations
	
	private Service service;
	private Service service2;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.service = new Service();
	}

	@Test
	void test() {
		// mocking object without annotations
//		service2.setCalculator(mock(AddCalculator.class)); // another way to create a mock obj
		
		int int1 = 2;
		int int2 = 3;
		int expected = 5;
		
		// lets you set the expected value without needing any logic
		when(calculator.add(int1, int2)).thenReturn(expected); 
		
		service.setCalculator(calculator);
		int actual = service.getAnswer(int1, int2);
		
		assertEquals(expected, actual);
		
		
		// verify: check that certain behavior happens (e.g. methods are called with x arguments y times)
		List<String> mockList = mock(List.class);
		mockList.add("Cat");
		mockList.size();
		mockList.size();
		
		verify(mockList).add("Cat");
		verify(mockList, times(2)).size();
		
		
		// throwing exceptions
		Thrower thrower = mock(Thrower.class);
		
		when(thrower.chuck()).thenThrow(NullPointerException.class); // for methods with a return type
		doThrow(NullPointerException.class).when(thrower).fling(); // for methods with void return types
		
		assertThrows(NullPointerException.class, ()-> thrower.chuck());
		assertThrows(NullPointerException.class, () -> thrower.fling());
	}

}
