
    
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Materia {
private String codigo;
private String nombre;
private int cuposMaximos;
private int creditos;
private int cuposDisponibles;

private List<String> preRequisitos;// esta enlazada a los codigos de materias
private List<String> estudiantesInscritos;
private Queue<String> colaDeEspera;// cola para los estudiantes que estan en espera


public Materia(String codigo, String nombre, int cuposMaximos, int creditos){

this.codigo = codigo;
this.nombre = nombre;
this.cuposMaximos = cuposMaximos;
this.cuposDisponibles = cuposMaximos;
this.creditos = creditos;
this.preRequisitos = new LinkedList<>();
this.estudiantesInscritos = new LinkedList<>();
this.colaDeEspera = new LinkedList<>();   
}

public String getCodigo(){return codigo;}
public String getNombre(){return nombre;}
public int getCupoMaximo(){return cuposMaximos;}
public int getCuposDisponibles(){return cuposDisponibles;}
public int getcreditos(){return creditos;}

public List<String> getPrerequisitos(){return preRequisitos;}
public Queue<String> getColaDeEspera(){return colaDeEspera;}
public List<String> getEstudiantesInscritos(){return estudiantesInscritos;}

public void agregarPreRequisito(String codigoMateriaReq){
this.preRequisitos.add(codigoMateriaReq);
}

public void inscribirEstudiante(String idEstudiante){
if(cuposDisponibles > 0){
estudiantesInscritos.add(idEstudiante);
cuposDisponibles--;
}else{
colaDeEspera.add(idEstudiante);
}
}

public String cancelarInscripcion (String idEstudiante){
if (estudiantesInscritos.remove(idEstudiante)){
cuposDisponibles++;
// si alguien esta en la lista de espera se le asignara un sitio automaticamente

if(!colaDeEspera.isEmpty()){
String siguienteId = colaDeEspera.poll();
estudiantesInscritos.add(siguienteId);
cuposDisponibles--;
return siguienteId; // aquien se le fue asignado el cupo va a retornar
}
}
return null;
}
}
