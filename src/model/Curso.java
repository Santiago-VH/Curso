package model;

public class Curso {

	private String nombre;
	private int numEstudiantes;
	
	private Estudiante ultimoEstudiante;
	private Estudiante primerEstudiante;
	
	public Curso(String nombre, int numEstudiantes) {
		this.nombre=nombre;
		this.numEstudiantes=numEstudiantes;
		this.ultimoEstudiante=null;                                                                                                                                         
	}
	
	public Curso(String nombre, int numEstudiantes, Estudiante primerEstudiante) {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumEstudiantes() {
		return numEstudiantes;
	}

	public void setNumEstudiantes(int numEstudiantes) {
		this.numEstudiantes = numEstudiantes;
	}

	public Estudiante getPrimerEstudiante() {
		return primerEstudiante;
	}

	public void setPrimerEstudiante(Estudiante primerEstudiante) {
		this.primerEstudiante = primerEstudiante;
	}
	
	public void addEstudiante (Estudiante newStudent1) {
		Estudiante newStudent = new Estudiante(newStudent1.getCodigo(), newStudent1.getNombre());
		System.out.println("Ingresa metodo");
		@SuppressWarnings("unused")
		Estudiante current=null;
		Estudiante current2=null;
		if(primerEstudiante==null) {
			newStudent.setSiguiente(newStudent);
			newStudent.setAnterior(newStudent);
			primerEstudiante=newStudent;
			ultimoEstudiante=newStudent;
		} else {
			current=primerEstudiante.getAnterior();
			newStudent.setSiguiente(primerEstudiante);
			primerEstudiante.setAnterior(newStudent);
			current2=ultimoEstudiante;
			current2.setSiguiente(newStudent);
			newStudent.setAnterior(current2);
			ultimoEstudiante=newStudent;
		} 
		
			System.out.println("Ciclo");
	}
	
	public void pintarEstudiantes() {
		Estudiante current = primerEstudiante;
		while(current!=null) {
			System.out.println(current.getNombre());
			System.out.println(current.getCodigo()+"\n" );
			current = current.getSiguiente();
			if(current==primerEstudiante) {
				break;
			}
		}
	}
	
	public int eliminarEstudiante(String n) {
		int count = 0;
		Estudiante current = primerEstudiante;
		Estudiante temp = null;
		while(current != null){
			System.out.println("entra while");
			if(primerEstudiante.getNombre().equals(n)) {
				System.out.println("entra en condicional 1");
				temp=current.getAnterior();
				current = current.getSiguiente();
				current.setAnterior(null);
				current.setAnterior(temp);
				temp.setSiguiente(current);
				primerEstudiante = current;
				count++;
				break;
			}else if(current.getNombre().equals(n)) {
				if(current == ultimoEstudiante) {
					System.out.println("entra en condicional 2");
					temp=current.getAnterior();
					current = current.getSiguiente();
					current.setAnterior(null);
					current.setAnterior(temp);
					temp.setSiguiente(current);
					ultimoEstudiante = temp;
					count++;
					break;
				}else {
				System.out.println("entra en condicional 3");
				temp=current.getAnterior();
				current = current.getSiguiente();
				current.setAnterior(null);
				current.setAnterior(temp);
				temp.setSiguiente(current);
				count++;
				break;
				}
			}
			current = current.getSiguiente();
		}
		return count;
	}
	
	
	
	
}
