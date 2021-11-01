package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Curso;
import model.Estudiante;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Curso curso = new Curso("", 0);
		boolean flag = true;
		while(flag) {
			
			String option = "";
			System.out.println("Select an option \n"
								+ "1: add student \n"
								+ "2: delete student by name \n"
								+ "3: Show list \n"
								+ "4: exit");
			option = br.readLine();
			if(option.equals("1")) {
				System.out.println("Digit your name: ");
				String nombre=br.readLine();
				
				System.out.println("Digit the code: ");
				String codigo=br.readLine();
				
				Estudiante s = new Estudiante(codigo, nombre);
				
				curso.addEstudiante(s);
				
			}else if(option.equals("2")) {
				System.out.println("Digit the name: ");
				String nombre=br.readLine();
				System.out.println("Se han eliminado "+curso.eliminarEstudiante(nombre)+"estudiantes");
				
			} else if(option.equals("3")){
				curso.pintarEstudiantes();
				
			} else if(option.equals("4")){
				flag = false;
				System.out.println("Program closed.");
			}
		}
	}
	
}
