package project1.ver06;

import java.util.InputMismatchException;

public class MenuSelectException extends Exception{

	public MenuSelectException(){
		super("1~5사이의 정수를입력하세요"); 
	}
}
