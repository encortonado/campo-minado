package com.aulas.junit.cm;

import com.aulas.junit.cm.model.Tabletop;
import com.aulas.junit.cm.view.TableTopConsole;

public class Aplication {

	public static void main(String[] args) {
		Tabletop table = new Tabletop(6, 6, 4);
		
		new TableTopConsole(table);
		
	}
	
}
