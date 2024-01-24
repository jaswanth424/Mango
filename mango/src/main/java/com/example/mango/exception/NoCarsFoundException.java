package com.example.mango.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoCarsFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String err;

	public NoCarsFoundException(String err) {
		super(err);
		this.err = err;
	}

	public NoCarsFoundException(String err, Throwable e) {
		super(err, e);
		this.err = err;
	}

}
