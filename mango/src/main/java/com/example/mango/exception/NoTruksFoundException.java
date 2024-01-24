package com.example.mango.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Hey !! No Trucks Found")
public class NoTruksFoundException extends RuntimeException {


	public NoTruksFoundException() {
		super("Truck you are looking for may not exist.");
	}

	public NoTruksFoundException(String err) {
		super("Tuck error : " + err);
	}

}
