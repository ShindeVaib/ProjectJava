package com.disc.example.customException;

public class InvalidAmount extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6820825459917210533L;

	public InvalidAmount() {
		super();
	}

	public InvalidAmount(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InvalidAmount(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidAmount(String arg0) {
		super(arg0);
	}

	public InvalidAmount(Throwable arg0) {
		super(arg0);
	}

	
	
}
