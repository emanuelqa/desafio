package com.emanuel.cadastroCliente.exception;

//Classe de sobrescrita de excessão
public class ObjectNotFoundExcepition extends RuntimeException{
	private static final long serialVersionUID = 1L;
 
	public ObjectNotFoundExcepition(String msg){
		super(msg);
	}
	
}
