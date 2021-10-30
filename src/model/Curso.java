package model;

public class Curso {

	private String nombre;
	private int numEstudiantes;
	
	private Estudiante ultimoEstudiante;
	private Estudiante primerEstudiante;
	
	public Curso(String nombre, int numEstudiantes) {
		this.nombre=nombre;
		this.numEstudiantes=numEstudiantes;
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
	
	public void addEstudiante (Estudiante newStudent) { //Añadir estudiante de primeras
		if(primerEstudiante==null) {
			primerEstudiante=newStudent;
			ultimoEstudiante=primerEstudiante;
			primerEstudiante.setSiguiente(ultimoEstudiante);
			ultimoEstudiante.setAnterior(primerEstudiante);
		}else {
			newStudent.setSiguiente(primerEstudiante);
			primerEstudiante.setAnterior(newStudent);
			newStudent.setAnterior(ultimoEstudiante);
			ultimoEstudiante.setSiguiente(newStudent);
			primerEstudiante=newStudent;
		}
	}
	
	public void addEstudianteOrdenadamente (Estudiante newStudent) {
		if(primerEstudiante==null) {
			primerEstudiante=newStudent;
			ultimoEstudiante=primerEstudiante;
			primerEstudiante.setSiguiente(ultimoEstudiante);
			ultimoEstudiante.setAnterior(primerEstudiante);
	} else if(primerEstudiante==ultimoEstudiante) {
		primerEstudiante.setSiguiente(newStudent);
		newStudent.setAnterior(primerEstudiante);
		ultimoEstudiante=newStudent;
		ultimoEstudiante.setSiguiente(primerEstudiante);
		primerEstudiante.setAnterior(ultimoEstudiante);
		} else {
			ultimoEstudiante.setSiguiente(newStudent);
			newStudent.setAnterior(ultimoEstudiante);
			ultimoEstudiante=newStudent;
			ultimoEstudiante.setSiguiente(primerEstudiante);
			primerEstudiante.setAnterior(ultimoEstudiante);
		}
	}
	
	public String pintarEstudiantes() {
		String codigo = "";
		String result = "";
		Estudiante temp = primerEstudiante;
		while(!codigo.equalsIgnoreCase(ultimoEstudiante.getCodigo())) {
			result += temp.toString() + "\n";
			temp = temp.getSiguiente();
			codigo = temp.getCodigo();
		}
		
		result += temp.toString();
		return result;
	}
	
	
}
