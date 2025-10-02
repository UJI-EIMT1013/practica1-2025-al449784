package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        List<Integer> lista = new ArrayList<>();

        // Convertimos el iterador en lista
        while (it.hasNext()) {
            int num = it.next();
            if (num != 0) { // Ignorar ceros
                lista.add(num);
            }
        }

        Set<Integer> resultado = new HashSet<>();

        // Comparar cada par de elementos
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (i != j) { // No comparar consigo mismo
                    int a = lista.get(i);
                    int b = lista.get(j);
                    if (a % b == 0) {
                        resultado.add(a);
                    }
                }
            }
        }

        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Set<Integer> todos = new HashSet<>();
        todos.addAll(cuadrados);
        todos.addAll(noCuadrados);

        Set<Integer> posiblesCuadrados = new HashSet<>();
        for (int n : todos) {
            posiblesCuadrados.add(n * n);
        }

        Set<Integer> nuevosCuadrados = new HashSet<>();
        Set<Integer> nuevosNoCuadrados = new HashSet<>();

        for (int n : todos) {
            if (posiblesCuadrados.contains(n)) {
                nuevosCuadrados.add(n);
            } else {
                nuevosNoCuadrados.add(n);
            }
        }

        cuadrados.clear();
        cuadrados.addAll(nuevosCuadrados);

        noCuadrados.clear();
        noCuadrados.addAll(nuevosNoCuadrados);
    }

    }
