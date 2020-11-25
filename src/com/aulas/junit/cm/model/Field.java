package com.aulas.junit.cm.model;

import java.util.ArrayList;
import java.util.List;

public class Field {

	private final int x;
	private final int y;
	
	private boolean opened = false;
	private boolean mined = false;
	private boolean marked = false;

	// Vizinhos de campos com minas proximas, que podem ser eliminados 
	private List<Field> neighbors = new ArrayList<Field>();
	
	
	public Field(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	
	
}
