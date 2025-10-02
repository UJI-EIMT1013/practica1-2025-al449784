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

//EJERCICIO 3
public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
    Collection<Set<T>> resultado = new ArrayList<>();
    Set<T> actual = new HashSet<>();

    while (it.hasNext()) {
        T elemento = it.next();
        if (actual.contains(elemento)) {
            resultado.add(actual);
            actual = new HashSet<>();
        }
        actual.add(elemento);
    }

    if (!actual.isEmpty()) {
        resultado.add(actual);
    }

    return resultado;
}

//EJERCICIO 4
public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
    Collection<Set<T>> resultado = new ArrayList<>();

    for (int i = 0; i < col.size(); i++) {
        for (int j = i + 1; j < col.size(); j++) {
            Set<T> union = new HashSet<>();
            union.addAll(col.get(i));
            union.addAll(col.get(j));

            if (union.equals(u)) {
                resultado.add(col.get(i));
                resultado.add(col.get(j));
                return resultado;
            }
        }
    }

    return resultado; // Vacío si no se encontró ninguna pareja
}

