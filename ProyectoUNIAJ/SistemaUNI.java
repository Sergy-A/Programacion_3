import java.util.*;
public class SistemaUNI {
    
 //usamos el hashmap para los estudiantes con ID para que sea mas rapido
    private HashMap<String, Estudiante> estudianteMap;
 // usamos el treemap para ordenar las aulas por el nombre
    private TreeMap<String, Aula>aulaMap;
 //en esta vamos a ver las materias registradas
    private HashMap<String , Materia> materiaMap;
    
    
    // distancia entre edificios
    private int[][]matrizAdyacencia;
    private List<String> nombreEdificios;
    
    public SistemaUNI(){
    estudianteMap = new HashMap<>();
    aulaMap = new TreeMap<>();
    materiaMap = new HashMap<>();
    nombreEdificios = new ArrayList<>();  
    
    //colocamos 5 edificios como pide la rubrica
    inicializarEdificiosPredeterminados();
    }
    
    private void inicializarEdificiosPredeterminados(){
    nombreEdificios.add("Ingenieria");
    nombreEdificios.add("Bliblioteca");
    nombreEdificios.add("Cafeteria");
    nombreEdificios.add("Rectoria");
    nombreEdificios.add("Laboratorios");
    
    int a = 5;
    matrizAdyacencia = new int[a][a];
    // rellenar con infinito por defecto (9999)
    for(int i = 0; i<a; i++){
    Arrays.fill(matrizAdyacencia[a],9999);
    matrizAdyacencia[i][i]=0;
    }
     // conexiones de ejemplo
    agregarConexionEdificios(0, 2, 150); // Ingenieria -> Cafeteria (150m)
    agregarConexionEdificios(2, 3, 180); // Cafeteria -> Rectoria (180m)
    agregarConexionEdificios(0, 1, 100); // Ingenieria -> Biblioteca (100m)
    agregarConexionEdificios(1, 4, 200); // Biblioteca -> Laboratorios (200m)
    agregarConexionEdificios(3, 4, 90);  // Rectoria -> Laboratorios (90m)
    
    }
    
    public void agregarConexionEdificios(int origen, int destino, int distancia){
    matrizAdyacencia[origen][destino]= distancia;
    matrizAdyacencia[origen][destino]= distancia;
    }
    
    public void registroEstudiante(String id, String nombre, String email,String semestre){
    Estudiante est = new Estudiante(id, nombre, email, Integer.parseInt(semestre));
    estudianteMap.put(id,est);
    }
    
    public Estudiante buscarEstudiante(String id) throws NoSuchElementException{
    Estudiante est = estudianteMap.get(id);
    if (est== null){
    throw new NoSuchElementException("No existe este estudiante con ID" + id);
    }
    return est;
    }
    
   public void calcularRutaDijkstra(int origen, int destino) {
    int n = nombreEdificios.size();
    int[] distancias = new int[n];
    boolean[] visitados = new boolean[n];
    int[] padres = new int[n];
    int[] indicesNodos = crearRangoIndices(n);

    Arrays.fill(distancias, 9999);
    Arrays.fill(padres, -1);
    distancias[origen] = 0;

    // Se realizan n - 1 iteraciones.
    for (int paso = 0; paso < n - 1; paso++) {
        int u = minDistance(distancias, visitados, n);
        if (u == -1) {
            break;
        }
        visitados[u] = true;

        for (int v : indicesNodos) {
            if (!visitados[v] && matrizAdyacencia[u][v] != 9999 &&
                distancias[u] + matrizAdyacencia[u][v] < distancias[v]) {
                distancias[v] = distancias[u] + matrizAdyacencia[u][v];
                padres[v] = u;
            }
        }
    }

    mostrarResultadoDijkstra(origen, destino, distancias, padres);
}

private int minDistance(int[] distancias, boolean[] visitados, int n) {
    int min = 9999;
    int minIndex = -1;

    for (int v : crearRangoIndices(n)) {
        if (!visitados[v] && distancias[v] <= min) {
            min = distancias[v];
            minIndex = v;
        }
    }
    return minIndex;
}

private void mostrarResultadoDijkstra(int origen, int destino, int[] distancias, int[] padres) {
    System.out.println("Ruta mas corta:");
    List<Integer> camino = new ArrayList<>();
    int actual = destino;
    while (actual != -1) {
        camino.add(0, actual);
        actual = padres[actual];
    }

    StringBuilder sb = new StringBuilder();
    int posicion = 0;
    for (int idEdificioActual : camino) {
        sb.append(nombreEdificios.get(idEdificioActual));
        if (posicion < camino.size() - 1) {
            int idEdificioSiguiente = camino.get(posicion + 1);
            int d = matrizAdyacencia[idEdificioActual][idEdificioSiguiente];
            sb.append(" -> (").append(d).append("m) -> ");
        }
        posicion++;
    }

    System.out.println(sb.toString());
    System.out.println("Distancia TOTAL: " + distancias[destino] + " metros");
}

// Auxiliar para recorrer índices de 0 a limite - 1 mediante for-each
private int[] crearRangoIndices(int limite) {
    int[] indices = new int[Math.max(0, limite)];
    for (int i = 0; i < indices.length; i++) {
        indices[i] = i;
    }
    return indices;
}
}
