package com.aulas.junit.cm.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aulas.junit.cm.exception.ExplosionException;

class FieldTest {

	private Field field;

	@BeforeEach
	void iniciarField() {
		/* <><> Montagem do Cen�rio <><> */
		field = new Field(3, 3);
	}

	@Test
	void testNeighborDistancia1Esquerda() {
		/* <><> Montagem do Cen�rio <><> */
		Field neighbor = new Field(3, 2);

		/* <><> Execu��o <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNeighborDistancia1Direita() {
		/* <><> Montagem do Cen�rio <><> */
		Field neighbor = new Field(3, 4);

		/* <><> Execu��o <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNeighborDistancia1Cima() {
		/* <><> Montagem do Cen�rio <><> */
		Field neighbor = new Field(2, 3);

		/* <><> Execu��o <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNeighborDistancia1Baixo() {
		/* <><> Montagem do Cen�rio <><> */
		Field neighbor = new Field(4, 3);

		/* <><> Execu��o <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNeighborDiagonalDistancia2() {
		/* <><> Montagem do Cen�rio <><> */
		Field neighbor = new Field(2, 2);

		/* <><> Execu��o <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNotNeighbor() {
		/* <><> Montagem do Cen�rio <><> */
		Field neighbor = new Field(1, 1);

		/* <><> Execu��o <><> */
		boolean result = field.addNeighbor(neighbor);

		assertFalse(result);
	}
	
	@Test
	void testDefaultValueMarcation() {
		
		/* <><> Execu��o <><> */
		assertFalse(field.isMarked());
	}
	
	@Test
	void testSwitchMarcation() {
		/* <><> Montagem do Cen�rio <><> */
		
		/* <><> Execu��o <><> */
		field.alternateMarking();
		
		assertTrue(field.isMarked());
	}
	
	@Test
	void testSwitchMarcationTwoCalls() {
		/* <><> Montagem do Cen�rio <><> */
		
		/* <><> Execu��o <><> */
		field.alternateMarking();
		field.alternateMarking();
		
		assertFalse(field.isMarked());
	}
	
	@Test
	void testOpenNotMinedNotMarked() {
		/* <><> Montagem do Cen�rio <><> */
		
		/* <><> Execu��o <><> */
		
		
		assertTrue(field.open());
	}
	@Test
	void testOpenNotMinedMarked() {
		/* <><> Montagem do Cen�rio <><> */
		field.alternateMarking();
		/* <><> Execu��o <><> */
		
		assertFalse(field.open());
	}
	
	@Test
	void testOpenMinedNotMarked() {
		/* <><> Montagem do Cen�rio <><> */
		field.mining();
		/* <><> Execu��o <><> */
		
		assertThrows(ExplosionException.class, () -> field.open());
		
	
		
	}

	@Test
	void testOpenMinedMarked() {
		/* <><> Montagem do Cen�rio <><> */
		field.alternateMarking();
		field.mining();
		
		/* <><> Execu��o <><> */
		
		assertFalse(field.open());
	}
	
	@Test
	void testOpenWithNeighbors1() {
		/* <><> Montagem do Cen�rio <><> */
		
		Field field11 = new Field(1, 1);
		Field field22 = new Field(2, 2); // vizinho field 22
		
		field.addNeighbor(field22);
		
		field22.addNeighbor(field11);
		
		
		/* <><> Execu��o <><> */
		
		field.open();
		
		
		assertTrue(field22.isOpened() && field11.isOpened());
	}

	
	@Test
	void testOpenWithNeighbors2() {
		/* <><> Montagem do Cen�rio <><> */
		
		Field field11 = new Field(1, 1);
		Field field12 = new Field(1, 2);
		
		Field field22 = new Field(2, 2); // vizinho field 22
		
		field.addNeighbor(field22);
		
		field22.addNeighbor(field11);
		field22.addNeighbor(field12);
		
		
		/* <><> Execu��o <><> */
		field12.mining();
		field.open();
		
		
		assertTrue(field22.isOpened() && !field11.isOpened());
	}
	
	@Test
	void testSetOpened() {
		/* <><> Montagem do Cen�rio <><> */
		
		/* <><> Execu��o <><> */
		field.setOpened(true);
		
		assertTrue(field.isOpened());
	}
	
	@Test
	void testSetMined() {
		/* <><> Montagem do Cen�rio <><> */
		
		/* <><> Execu��o <><> */
		field.setMined(true);
		
		assertTrue(field.isMined());
	}
	
	@Test
	void testSetMarked() {
		/* <><> Montagem do Cen�rio <><> */
		
		/* <><> Execu��o <><> */
		field.setMarked(true);
		
		assertTrue(field.isMarked());
	}
	
	@Test
	void testGetX() {
		/* <><> Montagem do Cen�rio <><> */
		Field field = new Field(2, 3);
		/* <><> Execu��o <><> */
		
		
		assertEquals(2, field.getX());
	}
	
	@Test
	void testGetY() {
		/* <><> Montagem do Cen�rio <><> */
		Field field = new Field(2, 3);
		/* <><> Execu��o <><> */
		
		
		assertEquals(3, field.getY());
	}
	
	@Test
	void testObjectiveAcomplishedUncovered() {
		/* <><> Montagem do Cen�rio <><> */
		field.open();
		
		/* <><> Execu��o <><> */
		field.objectiveAcomplished();
		
		assertTrue(field.objectiveAcomplished());
	}
	
	@Test
	void testObjectiveAcomplishedLocked() {
		/* <><> Montagem do Cen�rio <><> */
		field.alternateMarking();
		field.mining();
		/* <><> Execu��o <><> */
		field.objectiveAcomplished();
		
		assertTrue(field.objectiveAcomplished());
	}
	
	@Test
	void testMinesNeighbored() {
		/* <><> Montagem do Cen�rio <><> */
		
		Field field11 = new Field(1, 1);
		Field field12 = new Field(1, 2);
		
		Field field22 = new Field(2, 2); // vizinho field 22
		Field field23 = new Field(2, 3);
		field.addNeighbor(field22);
		field.addNeighbor(field23);
		
		field.addNeighbor(field11);
		field.addNeighbor(field12);
		
		/* <><> Execu��o <><> */
		field22.mining();
		field23.mining();
		
		
		assertEquals(2, field.minesNeighbored());
	}
	
	@Test
	void testReestart() {
		/* <><> Montagem do Cen�rio <><> */
		field.alternateMarking();
		field.mining();
		field.open();
		
		/* <><> Execu��o <><> */
		field.reestart();
		
		assertFalse(field.isMarked() && field.isMined() && field.isOpened());
		
	}
	
	@Test
	void testToStringMarked() {
		/* <><> Montagem do Cen�rio <><> */
		field.alternateMarking();
		/* <><> Execu��o <><> */
		assertEquals("x", field.toString());
		
	}
	
	@Test
	void testToStringOpenedMined() {
		/* <><> Montagem do Cen�rio <><> */
		field.open();
		field.mining();
		/* <><> Execu��o <><> */
		assertEquals("*", field.toString());
		
	}
	
	@Test
	void testToStringOpenedMinesNeighbored() {
		/* <><> Montagem do Cen�rio <><> */
		Field field11 = new Field(1, 1);
		Field field12 = new Field(1, 2);
		
		Field field22 = new Field(2, 2); // vizinho field 22
		Field field23 = new Field(2, 3);
		field.addNeighbor(field22);
		field.addNeighbor(field23);
		
		field.addNeighbor(field11);
		field.addNeighbor(field12);
		
		/* <><> Execu��o <><> */
		field22.mining();
		field23.mining();
		
		field.open();
		field.minesNeighbored();
		
		/* <><> Execu��o <><> */
		
		assertEquals(Long.toString(2), field.toString());
		
	}
	
	@Test
	void testToStringOpened() {
		/* <><> Montagem do Cen�rio <><> */
		field.open();
		
		/* <><> Execu��o <><> */
		assertEquals(" ", field.toString());
		
	}
	
	@Test
	void testToStringElse() {
		/* <><> Montagem do Cen�rio <><> */
		field.reestart();
		/* <><> Execu��o <><> */
		assertEquals("?", field.toString());
		
	}
}












