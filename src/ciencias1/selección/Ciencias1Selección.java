package ciencias1.selección;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

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

    public static int[] ordenSeleccion(int n, int b[]) {
        //int a[] = b;
        int temp = 0;
        int x = 0;
        double N=n;
        int a[] = {8,7,6,5,4, 3, 2, 1};
        int pruebaMejor[] = {1, 2, 3, 4, 5, 6};

        // int formulaSeleccionPeor = 4 * (N * N - (((N - 1) * N) / 2) - N) + 15 * (N - 1) + 3;
        double formulaSeleccionPeor = 4 * (N * N - (((N - 1) * N) /(double) 2) - N) + 15 * (N - 1) + 3 + ((3 * (N * N - (((N - 1) * N) / (double)2) - N)) / (double)2);
        double formulaSeleccionMejor = 4 * (N * N - (((N - 1) * N) / 2) - N) + 10 * (N - 1) + 3;

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
        System.out.println("Fórmula  mejor selección" + formulaSeleccionMejor);
        System.out.println("Contador: " + contador);

        return a;
    }

    public static int[] ordenInsercion(int n, int c[]) {
        double N=(double)n;
        //int a[] = c;
       /* int a[]={0,5,4,3,2,1};
        int i, j;
        int aux;
        int contador=0;
        int formulaPeorInsercion=9*( (N/2)*(N + 1) - N) + 13*(N - 1) + 2;
        contador+=2;
        a[0] = -32767;
        for (i = 2; i <= N; i++) {
            aux = a[i];
            j = i - 1;
            
            while ((j >= 0) && (aux < a[j])) {
                a[j + 1] = a[j];
                j--;
                contador+=9;
            }
            contador+=13;
            a[j + 1] = aux;
        }
        
        System.out.println("Fórmula"+formulaPeorInsercion);
        System.out.println("Contador: "+contador);
        return a;*/
        
  
        
        

 /*int lista[] = {7,6,5, 4, 3, 2, 1};

        int aux;
        int N = n;
        int counter = 1;//asignacion N

        counter += 2;//asignacion i y comparacion inicial del bucle i
        for (int i = 1; i < N; i++) {
            counter += 2;//incremento y comparacion en bucle i

            aux = lista[i];
            counter += 3;//asignacion aux

            counter += 6;//asignacion , resta, comparacion, comparacion, conjuncion
            for (int j = i - 1; j >= 0 && lista[j] > aux; j--) {
                counter += 5;//comparacion, comparacion, conjuncion,incremento

                lista[j + 1] = lista[j];
                counter += 4;//suma y asignacion

                lista[j] = aux;
                counter += 2;//asignacion
            }
        }

        System.out.println("formula = " + (8 * ((N / 2) * (N + 1) - N) + 12 * (N - 1) + 4));//errores?
        System.out.println("counter = " + counter);
        return lista;*/
        //int a[] = {0,15,14,13,12,11,10,9,8,7,6,5, 4, 3, 2, 1};
        int a[] = {0,1,2,3,4,5};
        double formulaPeorInsercion=(double)8 * ((N / 2) * (N + 1) - N) + 12 * (N - 1) + 4 ;
        double formulaPromedioInsercion=(double)(8 * ((N / 2) * (N + 1) - N)/(double)2) + 12 * (N - 1) + 4 ;
        double formulaMejorInsercion=(double) 12 * (N - 1) + 4;        
        int contador=0;
    
        a[0] = -32767;
        int i = 2;
        int j, temp;
        contador=4;
        while (i <= N) {
            j = i - 1;
            temp = a[i];
            while (temp < a[j]) {
                a[j + 1] = a[j];
                j = j - 1;
                contador+=8;
            }
            a[j + 1] = temp;
            i = i + 1;
            contador+=12;
        }
        System.out.println("Fórmula peor caso: "+formulaPeorInsercion);
        System.out.println("Fórmula caso promedio: "+formulaPromedioInsercion);
        System.out.println("Fórmula mejor caso: "+formulaMejorInsercion);
        System.out.println("Contador: "+contador);
       // System.out.println("Contador: "+contador);
        return a;
    }

    public static void main(String[] args) {
        int n = 5; //Se le da cualquier valor

        int a[] = generarArreglo(n);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " / ");
        }

        System.out.println();
        int b[] = ordenInsercion(n, a);
        for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " / ");
        }

    }

}
