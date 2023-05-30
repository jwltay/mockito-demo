package com.flooring;

public class Thrower {
	public void fling() {
		throw new NullPointerException();
	}
	
	public boolean chuck() {
		if (2 < 1)
			throw new NullPointerException();
		return false;
	}
}
