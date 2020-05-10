package ciencias1.selección;

public class Ciencias1Selección {

    public static int[] generarArreglo(int N) {
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        return a;
    }

    public static int[] ordenBurbuja(int N, int b[]) {

        int contador = 0;
        int formulaBurbujaPeor = (6 * (int) (Math.pow(N, 2))) - 3;
        int formulaBurbujaPromedio = (17 * N * N + 7 * N - 12) / 4;
        int formulaBurbujaMejor = 5 * (N * N - (((N - 1) * N) / 2) - N) + 6 * (N - 1) + 3;

        // int[] a = b;
        int temp = 0;

        int a[] = {5, 4, 3, 2, 1};
        int pruebaMejor[] = {1, 2, 3, 4};

        contador += 3;
        for (int i = 0; i < N - 1; i++) {
            contador += 6;
            for (int j = i + 1; j < N; j++) {
                contador += 5;
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    contador += 7;
                }
            }

        }

        System.out.println("Burbuja peor caso: " + formulaBurbujaPeor);
        System.out.println("Burbuja caso promedio: " + formulaBurbujaPromedio);
        System.out.println("Burbuja mejor caso: " + formulaBurbujaMejor);
        System.out.println("Contador: " + contador);

        return a;
    }

    public static int[] ordenSeleccion(int N, int b[]) {
        //int a[] = b;
        int temp = 0;
        int x = 0;

        int a[] = {4,3, 2, 1};
        int pruebaMejor[] = {1, 2, 3, 4,5,6};

       // int formulaSeleccionPeor = 4 * (N * N - (((N - 1) * N) / 2) - N) + 15 * (N - 1) + 3;
       int formulaSeleccionPeor=4*(N*N-(((N-1)*N)/2)-N)+15*(N-1)+3+ ((3*(N*N-(((N-1)*N)/2)-N))/2);
        int formulaSeleccionMejor = 4 * (N * N - (((N - 1) * N) / 2) - N) + 10 * (N - 1) + 3;

        int contador = 0;
        contador += 3;
        for (int i = 0; i < (N - 1); i++) {
            temp = a[i];
            for (int j = i + 1; j < N; j++) {
                if (temp > a[j]) {
                    System.out.println("1111111");
                    temp = a[j];
                    x = j;
                    contador += 3;
                }
                contador += 4;
            }

            if (a[i] > temp) {
                System.out.println("222222222222");
                a[x] = a[i];
                a[i] = temp;
                contador += 5;
            }
            contador += 10;
        }

        System.out.println("Fórmula peor caso selección" + formulaSeleccionPeor);
        System.out.println("Fórmula promedio selección");
        System.out.println("Fórmula  mejor selección"+formulaSeleccionMejor);
        System.out.println("Contador: " + contador);

        return a;
    }

    public static int[] ordenInsercion(int N, int b[]) {
        int a[] = b;

        int i, j;
        int aux;
        for (i = 1; i < N; i++) {
            aux = a[i];
            j = i - 1;
            while ((j >= 0) && (aux < a[j])) {

                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = aux;
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 4; //Se le da cualquier valor

        int a[] = generarArreglo(n);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " / ");
        }

        System.out.println();
        int b[] = ordenSeleccion(n, a);
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " / ");
        }

    }

}
