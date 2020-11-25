package com.aulas.junit.cm.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FieldTest {

	private Field field;

	@BeforeEach
	void iniciarField() {
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
}
