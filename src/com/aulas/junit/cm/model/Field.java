package com.aulas.junit.cm.model;

import java.util.ArrayList;
import java.util.List;

import com.aulas.junit.cm.exception.ExplosionException;

public class Field {

	private final int x; // linha
	private final int y; // coluna

	private boolean opened = false;
	private boolean mined = false;
	private boolean marked = false;

	// Vizinhos de campos com minas proximas, que podem ser eliminados
	private List<Field> neighbors = new ArrayList<>();

	Field(int x, int y) {
		
		this.x = x;
		this.y = y;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	public boolean isMined() {
		return mined;
	}

	public void setMined(boolean mined) {
		this.mined = mined;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	boolean addNeighbor(Field neighbor) {
		boolean xDifferent = x != neighbor.x; // se x é diferente do x vizinho
		boolean yDifferent = y != neighbor.y; // se y é diferente do y vizinho
		boolean diagonal = xDifferent && yDifferent; // diagonal se xy forem diferentes do vizinho xy

		int deltaX = Math.abs(x - neighbor.x); // verifica a diferença absoluta entre x e x do vizinho
		int deltaY = Math.abs(y - neighbor.y); // verifica a diferença absoluta entre y e y do vizinho
		int deltaGeneral = deltaY + deltaX; // verifica a diferença geral entre xy e xy do vizinho

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

	void alternateMarking() {
		if (!opened) {
			marked = !marked;
		}
	}

	boolean open() {

		if (!opened && !marked) {
			opened = true;

			if (mined) {
				throw new ExplosionException();

			}

			if (safeNeighborhood()) {
				neighbors.forEach(neighbor -> neighbor.open()); 
				// pra cada vizinho ele reabre e verifica se tem mais vizinhos ao redor

			}

			return true;
		} else {
			return false;
		}

	}

	boolean safeNeighborhood() { // garante que nenhum bloco vizinho sera uma bomba
		return neighbors.stream().noneMatch(x -> x.mined); // nenhum valor pode ser igual ao minado
	}
	
	void mining() {
			mined = true;
	}

	boolean objectiveAcomplished() {
		boolean uncovered = !mined && opened; // campo que fora desvendado
		boolean locked = mined && marked; // campo protegido
		return uncovered || locked;
	}
	
	long minesNeighbored() {
		return neighbors.stream().filter(neighbor -> neighbor.mined).count();
	}
	
	void reestart() {
		opened = false;
		mined = false;
		marked = false;
	}
	
	public String toString() {
		if (marked) {
			return "x";
		} else if (opened && mined) {
			return "*";
		} else if (opened && minesNeighbored() > 0) {
			return Long.toString(minesNeighbored());
		} else if (opened) {
			return " ";
		} else {
			return "?";
		}
	}
}





