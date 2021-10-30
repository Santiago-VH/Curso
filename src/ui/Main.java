package ui;

import java.util.Scanner;

import model.Curso;

public class Main {
	
	private Curso curso;
	
	public Main() {
		curso = new Curso("",0);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		int option = 0;
		System.out.println("Select an option \n"
							+ "1: add student");
		option = sc.nextInt();
		sc.nextLine();
		main.menu(option);
	}
	
	public void menu(int num) {
		switch(num) {
		case 1:
			curso.pintarEstudiantes();
			break;
		default:
			System.out.println("proceso finalizado");
			
		}
	}
}
