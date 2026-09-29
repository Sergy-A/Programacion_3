package Proyecto_Cine;
public class Main {
    public static void main(String[] args) {
        Teatro teatro = new Teatro();
        MenuPrincipal menu = new MenuPrincipal(teatro);
        menu.iniciar(); // Arranca el programa delegando la navegación
    }
}