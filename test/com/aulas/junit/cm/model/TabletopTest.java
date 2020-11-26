package com.aulas.junit.cm.model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aulas.junit.cm.exception.ExplosionException;

class TabletopTest {

	private Tabletop table;
	
	@BeforeEach
	void iniciarTable() {
		/* <><> Montagem do Cenário <><> */
		table =  new Tabletop(5, 5, 5);
	}
	
	@Test
	void testGenerateFields() {
		/* <><> Montagem do Cenário <><> */
		
		/* <><> Execução <><> */
		assertEquals(25, table.getFields());
		
	}

	@Test
	void testGetSetLines() {
		/* <><> Montagem do Cenário <><> */
		table.setLines(3);
		/* <><> Execução <><> */
		
		
		assertEquals(3, table.getLines());
	}
	
	@Test
	void testGetSetClums() {
		/* <><> Montagem do Cenário <><> */
		table.setColums(3);
		/* <><> Execução <><> */
		
		
		assertEquals(3, table.getColums());
	}
	
	@Test
	void testGetSetMines() {
		/* <><> Montagem do Cenário <><> */
		table.setMines(3);
		/* <><> Execução <><> */
		
		
		assertEquals(3, table.getMines());
	}
	
	@Test
	void testObjectiveAcomplished() {
		/* <><> Montagem do Cenário <><> */
		table.objectiveAcomplished();
		/* <><> Execução <><> */
		
		
		assertFalse(table.objectiveAcomplished());
		
	}
	
	@Test
	void testOpen() {
		/* <><> Montagem do Cenário <><> */
		table = new Tabletop(5, 5, 0);
		table.reestart();
		table.open(0, 2);
		/* <><> Execução <><> */
		
		assertTrue(table.fields.stream().anyMatch(x -> x.isOpened()));
	}
	
	@Test
	void testToString() {
		/* <><> Montagem do Cenário <><> */
		table = new Tabletop(2, 2, 2);
		table.reestart();
		/* <><> Execução <><> */
		
		assertEquals(table.toString(), table.toString());
		
	}
	
	@Test
	void testOpenException() {
		/* <><> Montagem do Cenário <><> */
		table = new Tabletop(5, 5, 0);
		table.reestart();
		table.fields.forEach(x -> x.mining());
		
		/* <><> Execução <><> */
		
		assertThrows(ExplosionException.class, () -> table.open(0, 0));
	}
	
	@Test
	void testAlternateMarking() {
		/* <><> Montagem do Cenário <><> */
		table = new Tabletop(2, 2, 2);
		table.alternateMark(0, 0);;
		/* <><> Execução <><> */
		
		assertTrue(table.fields.stream().filter(x -> x.isMarked()).allMatch(x -> x.isMarked()));
		
		
	}
}
