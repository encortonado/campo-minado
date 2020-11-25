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
}
