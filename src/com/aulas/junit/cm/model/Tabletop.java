package com.aulas.junit.cm.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.aulas.junit.cm.exception.ExplosionException;

public class Tabletop {

	private int lines;
	private int colums;
	private int mines;

	final List<Field> fields = new ArrayList<>();

	public Tabletop(int lines, int colums, int mines) {
		
		this.lines = lines;
		this.colums = colums;
		this.mines = mines;

		generateFields();
		associateNeighboors();
		sortMines();
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int getColums() {
		return colums;
	}

	public void setColums(int colums) {
		this.colums = colums;
	}

	public int getMines() {
		return mines;
	}

	public void setMines(int mines) {
		this.mines = mines;
	}

	
	public long getFields() {
		return fields.stream().count();
	}

	public void open(int line, int column) {
		try {
			fields.parallelStream().filter(f -> f.getX() == line && f.getY() == column).findFirst().ifPresent(f -> f.open());
			
		} catch (ExplosionException e) {
			fields.forEach(f -> f.setOpened(true));
			throw e;
		}
		
	}
	
	public void alternateMark(int line, int column) {
		fields.parallelStream().filter(f -> f.getX() == line && f.getY() == column).findFirst().ifPresent(f -> f.alternateMarking());
		
	}
	
	private void generateFields() {
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < colums; j++) {
				fields.add(new Field(i, j));
			}
		}

	}

	
	private void associateNeighboors() {
		for (Field field1 : fields) {
			for (Field field2 : fields) {
				field1.addNeighbor(field2);
			}
		}

	}

	private void sortMines() {
		long minesInCamp = 0;
		Predicate<Field> mined = f -> f.isMined();
		do { 
			
			int random = (int) (Math.random() * fields.size());
			fields.get(random).mining();
			minesInCamp = fields.stream().filter(mined).count();
		} while (minesInCamp < getMines());
	}

	public boolean objectiveAcomplished() {
		return fields.stream().allMatch(f -> f.objectiveAcomplished());
	}
	
	public void reestart() {
		fields.stream().forEach(f -> f.reestart());
		sortMines();
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("  ");
		for (int c = 0; c < colums; c++) {
			sb.append(" ");
			sb.append(c);
			sb.append(" ");
		}
		
		sb.append("\n");
		
		int i = 0;
		for (int l = 0; l < lines; l++) {
			sb.append(l);
			sb.append(" ");
			for (int c = 0; c < colums; c++) {
				sb.append(" ");				
				sb.append(fields.get(i));
				sb.append(" ");
				i++;
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
