package com.sendmail.controller;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@JsonInclude(value = Include.NON_NULL)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

	/*
	 * STATUS CODES
	 * 0=SUCCESS
	 * 1=FAIL
	 * 2=EXCEPTION
	 * 3=DATA NOT AVAILABLE
	 * 4=OTHER
	 * */
	private int status;
	
	private String message;
	
	private Object result;
	
	public ResponseModel(int status, String message){
		this.status = status;
		this.message = message;
	}

	public ResponseModel(int status, Object result) {
		super();
		this.status = status;
		this.result = result;
	}
	
}
