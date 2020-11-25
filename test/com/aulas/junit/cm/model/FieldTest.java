package com.aulas.junit.cm.model;

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
		/* <><> Montagem do Cenário <><> */
		field = new Field(3, 3);
	}

	@Test
	void testNeighborDistancia1Esquerda() {
		/* <><> Montagem do Cenário <><> */
		Field neighbor = new Field(3, 2);

		/* <><> Execução <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNeighborDistancia1Direita() {
		/* <><> Montagem do Cenário <><> */
		Field neighbor = new Field(3, 4);

		/* <><> Execução <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNeighborDistancia1Cima() {
		/* <><> Montagem do Cenário <><> */
		Field neighbor = new Field(2, 3);

		/* <><> Execução <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNeighborDistancia1Baixo() {
		/* <><> Montagem do Cenário <><> */
		Field neighbor = new Field(4, 3);

		/* <><> Execução <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNeighborDiagonalDistancia2() {
		/* <><> Montagem do Cenário <><> */
		Field neighbor = new Field(2, 2);

		/* <><> Execução <><> */
		boolean result = field.addNeighbor(neighbor);

		assertTrue(result);
	}

	@Test
	void testNotNeighbor() {
		/* <><> Montagem do Cenário <><> */
		Field neighbor = new Field(1, 1);

		/* <><> Execução <><> */
		boolean result = field.addNeighbor(neighbor);

		assertFalse(result);
	}
	
	@Test
	void testDefaultValueMarcation() {
		
		/* <><> Execução <><> */
		assertFalse(field.isMarked());
	}
	
	@Test
	void testSwitchMarcation() {
		/* <><> Montagem do Cenário <><> */
		
		/* <><> Execução <><> */
		field.alternateMarking();
		
		assertTrue(field.isMarked());
	}
	
	@Test
	void testSwitchMarcationTwoCalls() {
		/* <><> Montagem do Cenário <><> */
		
		/* <><> Execução <><> */
		field.alternateMarking();
		field.alternateMarking();
		
		assertFalse(field.isMarked());
	}
	
	@Test
	void testOpenNotMinedNotMarked() {
		/* <><> Montagem do Cenário <><> */
		
		/* <><> Execução <><> */
		
		
		assertTrue(field.open());
	}
	@Test
	void testOpenNotMinedMarked() {
		/* <><> Montagem do Cenário <><> */
		field.alternateMarking();
		/* <><> Execução <><> */
		
		assertFalse(field.open());
	}
	
	@Test
	void testOpenMinedNotMarked() {
		/* <><> Montagem do Cenário <><> */
		field.mining();
		/* <><> Execução <><> */
		
		assertThrows(ExplosionException.class, () -> field.open());
		
	
		
	}

	@Test
	void testOpenMinedMarked() {
		/* <><> Montagem do Cenário <><> */
		field.alternateMarking();
		field.mining();
		
		/* <><> Execução <><> */
		
		assertFalse(field.open());
	}
	
	@Test
	void testOpenWithNeighbors1() {
		/* <><> Montagem do Cenário <><> */
		
		Field field11 = new Field(1, 1);
		Field field22 = new Field(2, 2); // vizinho field 22
		
		field.addNeighbor(field22);
		
		field22.addNeighbor(field11);
		
		
		/* <><> Execução <><> */
		
		field.open();
		
		
		assertTrue(field22.isOpened() && field11.isOpened());
	}

	
	@Test
	void testOpenWithNeighbors2() {
		/* <><> Montagem do Cenário <><> */
		
		Field field11 = new Field(1, 1);
		Field field12 = new Field(1, 2);
		
		Field field22 = new Field(2, 2); // vizinho field 22
		
		field.addNeighbor(field22);
		
		field22.addNeighbor(field11);
		field22.addNeighbor(field12);
		
		
		/* <><> Execução <><> */
		field12.mining();
		field.open();
		
		
		assertTrue(field22.isOpened() && !field11.isOpened());
	}
	
	@Test
	void testSetOpened() {
		/* <><> Montagem do Cenário <><> */
		
		/* <><> Execução <><> */
		field.setOpened(true);
		
		assertTrue(field.isOpened());
	}
	
	@Test
	void testSetMined() {
		/* <><> Montagem do Cenário <><> */
		
		/* <><> Execução <><> */
		field.setMined(true);
		
		assertTrue(field.isMined());
	}
	
	@Test
	void testSetMarked() {
		/* <><> Montagem do Cenário <><> */
		
		/* <><> Execução <><> */
		field.setMarked(true);
		
		assertTrue(field.isMarked());
	}
}












