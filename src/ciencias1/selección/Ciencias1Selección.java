package ciencias1.selección;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Ciencias1Selección {

    public static int[] generarArreglo(int N) {
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        return a;
    }

    public static int ordenBurbuja(int N, int b[]) {

        int contador = 0;
        int formulaBurbujaPeor = (6 * (int) (Math.pow(N, 2))) - 3;
        int formulaBurbujaPromedio = (17 * N * N + 7 * N - 12) / 4;
        int formulaBurbujaMejor = 5 * (N * N - (((N - 1) * N) / 2) - N) + 6 * (N - 1) + 3;
        int temp = 0;

        int[] a = b;
        //int a[] = {10,9,8,7,6,5, 4, 3, 2, 1};
        //int a[] = {1, 2, 3, 4,5,6,7,8,9,10};
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

        return formulaBurbujaPromedio;
        //return formulaBurbujaMejor;
        //return formulaBurbujaPeor;
    }

    public static double ordenSeleccion(int n, int b[]) {

        int temp = 0;
        int N = n;

        int a[] = b;
        //int a[] = {10,9,8,7,6,5, 4, 3, 2, 1};
        //int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int contador = 0;

        int t, i, j, x;
        double formulaSeleccionPeor = 7 * ((n * n) / (double) 4) + 16 * (n / (double) 2) + 3;
        double formulaSeleccionMejor = 6 * ((n * n) / (double) 4) + 9 * (n / (double) 2) + 3;
        double formulaSeleccionPromedio = 6 * ((n * n) / (double) 4) + 9 * (n / (double) 2) + 3 + ((((n * n) / (double) 4) + 7 * (n / (double) 2)) / (double) 2);

        for (i = 0; i < N / 2.0; i++) { // N/2
            contador = contador + 9;
            x = i;
            for (j = i + 1; j < N - i; j++) { // N-i
                contador += 6;
                if (a[x] > a[j]) {
                    x = j;
                    contador += 1;
                }
            }

            if (i != x) {
                contador += 7;
                t = a[i];
                a[i] = a[x];
                a[x] = t;
            }
        }
        contador += 3;

        System.out.println("Selección peor caso: " + formulaSeleccionPeor);
        System.out.println("Selección caso promedio: " + formulaSeleccionPromedio);
        System.out.println("Selección mejor caso: " + formulaSeleccionMejor);
        System.out.println("Contador: " + contador);

        return formulaSeleccionPromedio;
        //return formulaSeleccionMejor;
        //return formulaSeleccionPeor;
    }

    public static double ordenInsercion(int n, int c[]) {
        double N = (double) n - 1;
        int a[] = c;
        //int a[] = {0,10,9,8,7,6,5, 4, 3, 2, 1};
        //int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        double formulaPeorInsercion = 8 * ((N / (double) 2) * (N + 1) - N) + 12 * (N - 1) + 4;
        double formulaPromedioInsercion = (double) 12 * (N - 1) + 4 + ((8 * ((N / (double) 2) * (N + 1) - N)) / (double) 2);
        double formulaMejorInsercion = (double) 12 * (N - 1) + 4;
        int contador = 0;

        a[0] = -32767;
        int i = 2;
        int j, temp;
        contador = 4;
        while (i <= N) {
            j = i - 1;
            temp = a[i];
            while (temp < a[j]) {
                a[j + 1] = a[j];
                j = j - 1;
                contador += 8;
            }
            a[j + 1] = temp;
            i = i + 1;
            contador += 12;
        }
        System.out.println("Inserción peor caso: " + formulaPeorInsercion);
        System.out.println("Inserción caso promedio: " + formulaPromedioInsercion);
        System.out.println("Inserción mejor caso: " + formulaMejorInsercion);
        System.out.println("Contador: " + contador);

        return formulaPromedioInsercion;
        //return formulaMejorInsercion;
        //return formulaPeorInsercion;
    }

    public static void main(String[] args) {
        int n = 10; //Se le da cualquier valor

        int a[] = generarArreglo(n);
        /*
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " / ");
        }
         
        System.out.println();*/
//        int b[] = ordenInsercion(n, a);
        /*for (int i = 0; i < n; i++) {
            System.out.print(b[i] + " / ");
        }*/

        //************************************************************
        XYSeries burbuja = new XYSeries("Burbuja");

        for (int i = 1; i <= 500; i++) {
            int c[] = generarArreglo(i);
            burbuja.add(i, ordenBurbuja(i, c));
        }

        XYSeries seleccion = new XYSeries("Seleccion");

        for (int i = 1; i <= 500; i++) {
            int c[] = generarArreglo(i);
            seleccion.add(i, ordenSeleccion(i, c));
        }

        XYSeries insercion = new XYSeries("Insercion");

        for (int i = 1; i <= 500; i++) {
            int c[] = generarArreglo(i);
            insercion.add(i, ordenInsercion(i, c));
        }

        XYSeriesCollection dataSet = new XYSeriesCollection();

        dataSet.addSeries(burbuja);
        dataSet.addSeries(insercion);
        dataSet.addSeries(seleccion);

        JFreeChart xyLineChart = ChartFactory.createXYLineChart("Comparación entre métodos de ordenamiento", "Vehículo", "Puntuación", dataSet, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = xyLineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.ORANGE);
        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        plot.setRenderer(renderer);

        ChartPanel panel = new ChartPanel(xyLineChart);

        JFrame ventana = new JFrame();
        ventana.setVisible(true);
        ventana.setSize(900, 550);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.add(panel);

        //*************************************************************
    }

}
