package ej1;

public class Main {
    public static void main(String[] args) {
        //Clase anónima
        Operacion s1 = new Operacion() {
            @Override
            public int aplicar(int a, int b) {
                return a + b;
            }
        };

        //Lambda
        Operacion s2 = (int a, int b) -> a + b;

        //Añadir resta
        Operacion r1 = (int a, int b) -> a - b;
        //Añadir multiplicación
        Operacion m1 = (int a, int b) -> a * b;

        System.out.println("Suma usando clase anónima");
        int suma1 = s1.aplicar(2,3);
        System.out.println(suma1);

        System.out.println("Suma usando expresión lambda");
        int suma2 = s2.aplicar(2,3);
        System.out.println(suma2);

        System.out.println("Resta usando expresión lambda");
        int resta1 = r1.aplicar(5,3);
        System.out.println(resta1);

        System.out.println("Multiplicación usando expresión lambda");
        int multiplicacion1 = m1.aplicar(2,3);
        System.out.println(multiplicacion1);
    }
}
