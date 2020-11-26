package com.aulas.junit.cm.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.aulas.junit.cm.exception.ExitException;
import com.aulas.junit.cm.exception.ExplosionException;
import com.aulas.junit.cm.model.Tabletop;

public class TableTopConsole {

	private Tabletop table;
	private Scanner input = new Scanner(System.in);
	
	public TableTopConsole(Tabletop table) {
		super();
		this.table = table;
		
		initGame();
	}


	private void initGame() {
		try {
			boolean keep = true;
			while (keep) {
				gameLoop();
				
				System.out.println("Mais uma partida? (S/n)");
				String resp = input.nextLine();
				
				if ("n".equalsIgnoreCase(resp)) {
					keep = false;
				} else {
					table.reestart();
				}
			}
		} catch (Exception e) {
			System.out.println("Fim de Jogo.");
		} finally {
			input.close();
		}
		
	}


	private void gameLoop() {
		try {
			while (!table.objectiveAcomplished()) {
				System.out.println(table);
				
				String typed = getTypedValue("Digite (Linha, Coluna): ");
				
				Iterator<Integer> xy = Arrays.stream(typed.split(",")).map(x -> Integer.parseInt(x.trim())).iterator();
			
				typed = getTypedValue("1 - Abrir | 2 - marcar ou desmarcar campos: ");
				
				switch (typed) {
				case "1":
					table.open(xy.next(), xy.next());
					break;
				case "2":
					table.alternateMark(xy.next(), xy.next());
					break;
				default:
					System.out.println("Incorreto");
					break;
				}
				
			}
			
			
			System.out.println("Você Ganhou");
		} catch (ExplosionException e) {
			System.out.println(table);
			System.out.println("Você Perdeu...");
		}
	}
	
	private String getTypedValue(String text) {
		System.out.print(text);
		String typed = input.nextLine();
		
		if ("sair".equalsIgnoreCase(typed)) {
			throw new ExitException();
		}
		return typed;
	}
	
}
