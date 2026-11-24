   // Paquete: modelo

public  abstract class Persona {
  
 private String id;   
 private String nombre;   
 private String email;
 
 public Persona(String id,String nombre,String email ){
 this.id = id;
 this.nombre = nombre;
 this.email = email;
 }
 
 public String getId(){return id;}
 public void setId(String id){this.id = id;}
 
 
 public String getNombre(){return id;}
 public void setNombre(String id){this.id = id;}
 
 
 public String getEmail(){return id;}
 public void setidEmail(String id){this.id = id;}
 
 public abstract void mostrarInformacion();
 
 
}