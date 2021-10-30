package ui;

import java.util.Scanner;

import model.Curso;
import model.Estudiante;

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
			addEstudiante();
			break;
			
		case 2:
			eliminarEstudiantes();
			break;
			
		case 3:
			System.out.println(curso.pintarEstudiantes());
			break;
		default:
			System.out.println("proceso finalizado");
			
		}
	}
	
	public void addEstudiante() {
		System.out.println("Codigo: ");
		String codigo = sc.nextLine();
		
		System.out.println("Nombre: ");
		String nombre = sc.nextLine();
		
		Estudiante s = new Estudiante(codigo, nombre);
		
		curso.addEstudianteOrdenadamente(s);
	}
}
