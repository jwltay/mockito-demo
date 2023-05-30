package com.flooring;

public class Service {
	private AddCalculator calculator;
	
	public int getAnswer(int int1, int int2) {
		return calculator.add(int1, int2);
	}

	public void setCalculator(AddCalculator calculator) {
		this.calculator = calculator;
	}
	
	

}
