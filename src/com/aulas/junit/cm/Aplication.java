package com.aulas.junit.cm;

import com.aulas.junit.cm.model.Tabletop;

public class Aplication {

	public static void main(String[] args) {
		Tabletop table = new Tabletop(2, 2, 2);
		
		
		table.alternateMark(4, 4);
		table.alternateMark(4, 5);
		table.open(0, 2);
		
		System.out.println(table);
		
	}
	
}
