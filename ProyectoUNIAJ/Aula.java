

public class Aula implements Comparable<Aula> {
    
    private String codigo;
    private String nombre;
    private int capacidad;
 // esta m atriz es para los 7 dias y las 24 horas, si esta ocupado es TRUE y si esta libre es FALSE
    private boolean[][] matrizHorarios;

public Aula(String codigo,String nombre, int capacidad){
this.codigo = codigo;
this.nombre = nombre;
this.capacidad = capacidad;
this.matrizHorarios = new boolean[7][24];// va aparecer todo en FALSE por que estan libres
}
public String getCodigo() {return codigo;}
public String getNombre() {return nombre;}
public boolean[][] getMatrizHorarios(){return matrizHorarios;}

@Override
public int compareTo(Aula otraAula) {
    return this.codigo.compareTo(otraAula.codigo);
}

//se consultara si hay un lugar disponible
public boolean consultarDisponibilidad(int dia, int hora){
return !matrizHorarios[dia][hora];// si hay uno libre va a retornar TRUE
}

//para reservar un horario con la duracion en horas
public void reservar(int dia, int hora, int duracion) throws HorarioConflictivoException{
int[] horasObjetivo = obtenerRangoHoras(hora, duracion);
for(int horaActual : horasObjetivo){
if (horaActual >= 24 || matrizHorarios[dia][horaActual]){
throw new HorarioConflictivoException(
"El horario en el dia" + dia + "a las" + horaActual + "Ya esta ocupado o esta fuera de rango.");
}
}

for (int horaActual : horasObjetivo){
matrizHorarios[dia][horaActual] = true;
}
}
// liberar un horario que ya esta reservado
public void liberar(int dia , int hora, int duracion){
int[] horasObjetivo = obtenerRangoHoras(hora, duracion);

for(int horaActual: horasObjetivo){
if (horaActual < 24){
    matrizHorarios[dia][horaActual]= false;
}
}
}

//construir el arreglo de horas a procesar
private int[] obtenerRangoHoras(int hotaInicio, int duracion){
int tamaño = Math.max(0, duracion);
int[]rango = new int[tamaño];
for(int i = 0; i < tamaño; i++){
    rango[i] = hotaInicio + i;
}
return rango;
}

public static class HorarioConflictivoException extends Exception {
    public HorarioConflictivoException(String mensaje) {
        super(mensaje);
    }
}
}
