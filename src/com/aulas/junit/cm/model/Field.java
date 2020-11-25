package com.aulas.junit.cm.model;

import java.util.ArrayList;
import java.util.List;

public class Field {

	private final int x; // linha
	private final int y; // coluna

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

	boolean addNeighbor(Field neighbor) {
		boolean xDifferent = x != neighbor.x; // se x é diferente do x vizinho
		boolean yDifferent = y != neighbor.y; // se y é diferente do y vizinho
		boolean diagonal = xDifferent && yDifferent; // diagonal se xy forem diferentes do vizinho xy

		int deltaX = Math.abs(x - neighbor.x); // verifica a diferença absoluta entre x e x do vizinho
		int deltaY = Math.abs(y - neighbor.y); // verifica a diferença absoluta entre y e y do vizinho
		int deltaGeneral = deltaX + deltaY; // verifica a diferença geral entre xy e xy do vizinho

		if (deltaGeneral == 1 && !diagonal) { // se o delta geral é 1 e nao está na diagonal, adiciona o vizinho
			neighbors.add(neighbor);
			return true;
		} else if (deltaGeneral == 2 && diagonal) { // se o delta geral é 2 e está na diagonal, adiciona o vizinho
			neighbors.add(neighbor);
			return true;
		} else { // se não retorna falso
			return false;
		}
	}
}





