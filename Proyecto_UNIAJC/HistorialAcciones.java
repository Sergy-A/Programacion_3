package Proyecto_UNIAJC;

import java.util.Stack;

public class HistorialAcciones {
private Stack<String> pilaDeshacer = new Stack<>();
private Stack<String> pilaRehacer = new Stack<>();

public void registrarAccion(String descripcionAccion){
pilaDeshacer.push(descripcionAccion);
pilaRehacer.clear();
}

public String deshacer() throws IllegalStateException{
if (pilaDeshacer.isEmpty()){
throw new IllegalStateException("No hay operaciones para Deshacer");
}
String accion = pilaDeshacer.pop();
pilaRehacer.push(accion);
return accion;
}
public String rehacer()throws IllegalStateException{
if(pilaRehacer.isEmpty()){
throw new IllegalStateException("No hay operacion para rehacer");
}
String accion = pilaRehacer.pop();
pilaDeshacer.push(accion);
return accion;
        }
}
