package com.aulas.junit.cm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void test() {
		// Apenas um teste para ver se JUnit está funcionando
		int a = 1 + 1;
		
		assertEquals(2, a);
	}

}
