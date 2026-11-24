package Proyecto_UNIAJC;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {

    private int semestre;
    // Arreglo estricto de 10 semestres y 20 materias máximas por semestre
    private Double[][] notas;
    private List<String> historialMaterias;

    public Estudiante(String id, String nombre, String email, int semestre) {
        super(id, nombre, email);
        this.semestre = semestre;
        this.notas = new Double[10][20];
        this.historialMaterias = new ArrayList<>();
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Double[][] getNotas() {
        return notas;
    }

    public void registrarNota(int semIndex, int matIndex, double nota) {
        if (semIndex >= 0 && semIndex < 10 && matIndex >= 0 && matIndex < 20) {
            notas[semIndex][matIndex] = nota;
        }
    }

    public List<String> getHistorialMaterias() {
        return historialMaterias;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ID:" + getId());
        System.out.println("Nombre:" + getNombre());
        System.out.println("Email:" + getEmail());
        System.out.println("Semestre:" + getSemestre());
    }
}
