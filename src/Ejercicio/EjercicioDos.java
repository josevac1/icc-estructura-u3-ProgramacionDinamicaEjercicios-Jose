package Ejercicio;

import java.util.ArrayList;
import java.util.List;

/*
 * Dados n pares de paréntesis, implementa un algoritmo para generar todas las combinaciones
 * válidas de paréntesis.
 *
 * Ejemplo 1:
 *  Input:
 *    n: 1
 *  Output:
 *    ["()"]
 *
 * Ejemplo 2:
 *  Input:
 *    n: 3
 *  Output:
 *    ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Ecoja la mejor estructura de datos para que sea mas eficiente
 * Se debe usar StringBuilder
 */
public class EjercicioDos {
    public List<String> generateParenthesis(int n) {
        // Inicializa la lista que contendrá todas las combinaciones de paréntesis
        List<String> result = new ArrayList<>();
        // Llama al método recursivo para generar las combinaciones
        generate(result, new StringBuilder(), 0, 0, n);
        // Devuelve la lista de combinaciones de paréntesis
        return result;
    }

    // Método recursivo para generar combinaciones de paréntesis
    private void generate(List<String> result, StringBuilder current, int open, int close, int max) {
        // Si la longitud de la cadena actual es igual a max * 2, se ha generado una combinación válida
        if (current.length() == max * 2) {
            // Añade la combinación generada a la lista de resultados
            result.add(current.toString());
            return;
        }

        // Si el número de paréntesis abiertos es menor que max, añade un paréntesis abierto
        if (open < max) {
            // Añade un paréntesis abierto a la cadena actual
            current.append('(');
            // Llama recursivamente con un paréntesis abierto adicional
            generate(result, current, open + 1, close, max);
            // Elimina el último carácter añadido (retroceso)
            current.deleteCharAt(current.length() - 1);
        }
        // Si el número de paréntesis cerrados es menor que el número de abiertos, añade un paréntesis cerrado
        if (close < open) {
            // Añade un paréntesis cerrado a la cadena actual
            current.append(')');
            // Llama recursivamente con un paréntesis cerrado adicional
            generate(result, current, open, close + 1, max);
            // Elimina el último carácter añadido (retroceso)
            current.deleteCharAt(current.length() - 1);
        }
    }

}