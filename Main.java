import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> estudiantes = new HashMap<>();
        estudiantes.put(456321, "John");
        estudiantes.put(123421, "Peter");
        estudiantes.put(897600, "Tim");
        System.out.println(estudiantes);
        for (Integer i : estudiantes.keySet()) {
            System.out.println("key: " + i + " value: " + estudiantes.get(i));
        }
    }
}
