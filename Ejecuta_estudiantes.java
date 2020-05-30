/*
    autor: daivdpillco
    file:Ejecuta_estudiante
 */

package DavidPillco_GestionFilesCSV;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Ejecuta_estudiantes {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner teclado = new Scanner(System.in);
        // Se pide el ingreso de cuantos estuidantes mas desea ingresar
        System.out.println("Ingresa el numero de estudiantes extras a ingresar");
        int n_estudiantes = teclado.nextInt();
        String [] estudiantes_extras = new String[n_estudiantes];
        // Se solicita el ingreso de los nombres de los estudiantes a ingresar
        for (int j = 0; j < n_estudiantes; j++) {
            System.out.println("Ingresa nombre del estudiante: ");
            String val = teclado.next();
            estudiantes_extras[j] = val;
        }
        // Arreglo con los nombres de estudiantes por defecto
        String [] nombres = {"TENE S. MARIA","FAGGIONI L. GIOVANNI","LOPEZ Q. JAIME",
                "AVILA D. GREYS","LUZURIAGA C. DIANA","MENDEZ C. JANETH","CAMPOS D. FRANCISCA","BORJA A. ANDREA",
                "MENDOZA J. FATIMA","SANCHEZ B. CARLA","CASTILLO H. NESTOR","SOLORZANO T. MARIBEL"};
        String [] estudiantes_totales = new String[n_estudiantes+nombres.length];
        // Union del arreglo con los estudiantes por defecto con los nuevos.
        int c = 0;
        for (c = 0; c < nombres.length; c++ ){
            estudiantes_totales[c] = nombres[c];
        }
        for (int a = 0; a < estudiantes_extras.length; a++ ){
            estudiantes_totales[c] = estudiantes_extras[a];
            c++;
        }
        // Declaracion del arreglo
        Double matriz_est [][] = new Double[estudiantes_totales.length][16];
        // Arreglo donde se guardan las calificaciones
        double[] notas = new double[estudiantes_totales.length];
        for (int i = 0; i < matriz_est.length;i++){
            matriz_est[i][0] = (double)Math.round((notas [i]= (Math.random() * 1.1))*100d)/100; // Notas FOR1
            matriz_est[i][1] = (double)Math.round((notas [i]= (Math.random() * 1.1))*100d)/100; // Notas CHA1
            matriz_est[i][2] = (double)Math.round((notas [i]= (Math.random() * 1.1))*100d)/100; // Notas VID1
            matriz_est[i][3] = (double)Math.round((notas [i]= (Math.random() * 6.1))*100d)/100; // Notas TRA1
            matriz_est[i][4] = (double)Math.round((notas [i]= (Math.random() * 14.1))*100d)/100; // Notas PRE1
            matriz_est[i][5] = (double)Math.round((notas [i]= (Math.random() * 1.1))*100d)/100; // Notas FOR2
            matriz_est[i][6] = (double)Math.round((notas [i]= (Math.random() * 1.1))*100d)/100; // Notas CHA2
            matriz_est[i][7] = (double)Math.round((notas [i]= (Math.random() * 1.1))*100d)/100; // Notas VID2
            matriz_est[i][8] = (double)Math.round((notas [i]= (Math.random() * 6.1))*100d)/100; // Notas TRA2
            matriz_est[i][9] = (double)Math.round((notas [i]= (Math.random() * 14.1))*100d)/100; // Notas PRE2
        }
        // Inicializa variables para los porcentajes
        Double[] fin1 = new Double[estudiantes_totales.length];
        Double[] fin2 = new Double[estudiantes_totales.length];
        Double[] total = new Double[estudiantes_totales.length];
        String[] alertas = new String[estudiantes_totales.length];
        String[] prom = new String[estudiantes_totales.length];
        int cont_aprob = 0,cont_reprob = 0,cont_fin1 = 0, cont_fin2=0, cont_fin12 =0 ,cont_trab =0;
        double por_aprob, por_reprob, por_fin1, por_fin2,por_fin12, por_trab;

        // Evaluaciones
        for(int a=0;a<matriz_est.length;a++){
            total[a] =  matriz_est[a][0] +matriz_est[a][1]+matriz_est[a][2]+matriz_est[a][3]+matriz_est[a][4]+
                    matriz_est[a][5]+matriz_est[a][6]+matriz_est[a][7]+matriz_est[a][8]+matriz_est[a][9];
            if(total[a] >= 28.0){
                alertas[a] = "";
                prom[a] = "APROBADO";
            }
            // Si en algun parcial saca menos de 8 la nota final es la fin de ese parcial mas las notas del otro
            if(matriz_est[a][4] < 8){
               fin1[a] =(double)Math.round((notas [a]= (Math.random() * 20.1))*100d)/100;
               fin2[a] = 0.0;
               total[a] = fin1[a]+ matriz_est[a][5]+matriz_est[a][6]+matriz_est[a][7]+matriz_est[a][8]+matriz_est[a][9];
                if(total[a] >= 28){
                    alertas[a] = "Rendir Final 1";
                    prom[a] = "Aprobado";
                }else{
                    alertas[a] = "Rendir Final 1";
                    prom[a] = "Reprobado";
                }
            }else{
                fin2[a] =(double)Math.round((notas [a]= (Math.random() * 20.1))*100d)/100;
                fin1[a] = 0.0;
                total[a] = fin2[a]+ matriz_est[a][0]+matriz_est[a][1]+matriz_est[a][2]+matriz_est[a][3]+matriz_est[a][4];
                if(total[a] >= 28){
                    alertas[a] = "Rendir Final 2";
                    prom[a] = "Aprobado";
                }else{
                    alertas[a] = "Rendir Final 2";
                    prom[a] = "Reprobado";
                }
            }
            // Si las dos presenciales son menores a 8
            if(matriz_est[a][4] < 8 && matriz_est[a][9] < 8){
                fin1[a] =(double)Math.round((notas [a]= (Math.random() * 20.1))*100d)/100;
                fin2[a] =(double)Math.round((notas [a]= (Math.random() * 20.1))*100d)/100;
                total[a] = fin1[a] + fin2[a];
                if(total[a] >= 28){
                    total[a] = fin1[a] + fin2[a];
                    alertas[a] = "Rendir Final 1 y 2";
                    prom[a] = "Aprobado";
                }else{
                    total[a] = fin1[a] + fin2[a];
                    alertas[a] = "Rendir Final 1 y 2";
                    prom[a] = "Reprobado";
                }
                // Si saca mas de 8 en las presenciales pero al final menos de 28
                if(matriz_est[a][4] >= 8 && matriz_est[a][9] >= 8 && total[a]<28){
                    // Si la pre1 es menor a la pre2 da la fin1 mas las notas del primer
                    if(matriz_est[a][4] < matriz_est[a][9]){
                        fin1[a] =(double)Math.round((notas [a]= (Math.random() * 20.1))*100d)/100;
                        fin2[a] = 0.0;
                        total[a] = fin1[a]+ matriz_est[a][0]+matriz_est[a][1]+matriz_est[a][2]+
                                matriz_est[a][3]+matriz_est[a][4];
                        if(total[a] >= 28){
                            alertas[a] = "Rendir Final 1";
                            prom[a] = "Aprobado";
                        }else{
                            alertas[a] = "Rendir Final 1";
                            prom[a] = "Reprobado";
                        }
                    }else{
                        fin2[a] =(double)Math.round((notas [a]= (Math.random() * 20.1))*100d)/100;
                        fin1[a] = 0.0;
                        total[a] = fin2[a]+ matriz_est[a][5]+matriz_est[a][6]+matriz_est[a][7]+
                                matriz_est[a][8]+matriz_est[a][9];
                        if(total[a] >= 28){
                            alertas[a] = "Rendir Final 2";
                            prom[a] = "Aprobado";
                        }else{
                            alertas[a] = "Rendir Final 2";
                            prom[a] = "Reprobado";
                        }
                    }
                }
                if(total[a] >= 28.0){
                    prom[a] = "Aprobado";
                }
                if(total[a]<=28.0){
                    prom[a]= "Reprobado";
                }
                if(matriz_est[a][0] == 0.0 || matriz_est[a][1] == 0.0 || matriz_est[a][2] == 0.0 ||
                        matriz_est[a][3] == 0.0 || matriz_est[a][5] == 0.0||matriz_est[a][6] == 0.0||
                            matriz_est[a][7] == 0.0||matriz_est[a][8] == 0.0){
                    total[a] = 0.0;
                    alertas[a] = "Reprobado Falta Trabajo";
                    prom[a] = "Reprobado";
                    }
            }

            // Evaluacion procentajes

            if(prom[a] == "Aprobado"){
                cont_aprob = cont_aprob +1;

            }else{
                cont_reprob = cont_reprob+1;
            }
            // Rendir Final 1, Rendir Final 2, Rendir Final 1 y 2, y
            // finalmente el porcentaje de estudiantes que han Reprobado falta trabajo.
            if(alertas[a] == "Rendir Final 1"){
                cont_fin1 = cont_fin1+1;
            }
            if(alertas[a] == "Rendir Final 2"){
                cont_fin2 = cont_fin2+1;
            }
            if(alertas[a] == "Rendir Final 1 y 2"){
                cont_fin12 = cont_fin12+1;
            }
            if(alertas[a] == "Reprobado Falta Trabajo"){
                cont_trab = cont_trab+1;
            }

        }
        // Calculo de los porcentajes
        por_aprob = (cont_aprob)*100/estudiantes_totales.length;
        por_reprob = (cont_reprob)*100/estudiantes_totales.length;
        por_fin1 = (cont_fin1)*100/estudiantes_totales.length;
        por_fin2 = (cont_fin2)*100/estudiantes_totales.length;
        por_fin12 = (cont_fin12)*100/estudiantes_totales.length;
        por_trab = (cont_trab)*100/estudiantes_totales.length;
        // Impresion po consola de los porcentajes
        System.out.printf("Porcentaje de estudiantes de esta base de datos:\nAprobados: %.2f\nReprobados: %.2f\n" +
                        "Rendir Final 1: %.2f\nRendir Final 2: %.2f\nRendir Final 1 y 2: %.2f\nFalta Trabajo: %.2f\n",
                por_aprob,por_reprob,por_fin1,por_fin2,por_fin12,por_trab);
        // Guardar todo en una matriz para poder trajarla
        String cadena = "";
        String [][] matrizT = new String[estudiantes_totales.length][16];
        String cadena2;
        for (int i = 0; i < matriz_est.length; i++) {//filas

            cadena = String.format("%s%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%s;%s\n"
                    ,cadena,estudiantes_totales[i],matriz_est[i][0], matriz_est[i][1], matriz_est[i][2],
                    matriz_est[i][3], matriz_est[i][4], matriz_est[i][5], matriz_est[i][6], matriz_est[i][7],
                    matriz_est[i][8], matriz_est[i][9], fin1[i],fin2[i],total[i],alertas[i],prom[i]);

            cadena2 = String.format("%s;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%.2f;%s;%s\n"
                    ,estudiantes_totales[i],matriz_est[i][0], matriz_est[i][1], matriz_est[i][2],
                    matriz_est[i][3], matriz_est[i][4], matriz_est[i][5], matriz_est[i][6], matriz_est[i][7],
                    matriz_est[i][8], matriz_est[i][9], fin1[i],fin2[i],total[i],alertas[i],prom[i]);
            // Se guarda la cadena2 como matriz
            String [] aux = cadena2.split(";");
            for(int  k = 0; k <  matrizT[i].length; k++){
                matrizT[i][k] = aux[k];
            }

        }


        // Ordenamiento de la matriz
        // Ordenamiento por los nombres
        for(int i =0; i < matrizT.length;i++){
            for(int j = 0; j < matrizT.length-i-1;j++){
                if(matrizT[j][0].compareTo(matrizT[j+1][0])>0 ){
                    // Intercambia las filas
                    String [] fila = matrizT[j];
                    matrizT[j] = matrizT[j+1];
                    matrizT[j+1] = fila;
                }
            }
        }
        // Envio del csv de nombres
        Generar_csvNombres(matrizT);

        // Ordenar por total
        for(int i =0; i < matrizT.length;i++){
            for(int j = 0; j < matrizT.length-i-1;j++){
                // Ordenamiento por los total
                if((matrizT[j][13]).compareTo(matrizT[j+1][0])>0 ){
                    // Intercambia las filas
                    String [] fila1 = matrizT[j];
                    matrizT[j] = matrizT[j+1];
                    matrizT[j+1] = fila1;
                }
            }
        }
        // Envio del csv de total
        Generar_csvTotal(matrizT);
        // Ordenar por promocion
        for(int i =0; i < matrizT.length;i++){
            for(int j = 0; j < matrizT.length-i-1;j++){
                // Ordenamiento por los promocion
                if(matrizT[j][15].compareTo(matrizT[j+1][0])>0 ){
                    // Intercambia las filas
                    String [] fila2 = matrizT[j];
                    matrizT[j] = matrizT[j+1];
                    matrizT[j+1] = fila2;
                }
            }
        }
        // Envio del csv de promo
        Generar_csvPromo(matrizT);
    }
    /*
    Metodo para genera el csv con los nombres ordenados
     */
    public static void Generar_csvNombres (String [][] matrizT) throws FileNotFoundException, UnsupportedEncodingException {
        Locale ingles = new Locale("en", "EN");
        // Asignación del formato de guardar archivo
        Formatter outArchivo = new Formatter("dapillcoBdEst_OrdenNomb.csv", "US-ASCII", ingles);
        for(int i =0; i < matrizT.length;i++){
            for(int j = 0; j < matrizT[i].length;j++){
                outArchivo.format(";"+matrizT[i][j]);
            }
        }
        outArchivo.close();
    }
    /*
    Metodo para genera el csv con los totales ordenados
     */
    public static void Generar_csvTotal (String [][] matrizT) throws FileNotFoundException, UnsupportedEncodingException {
        Locale ingles = new Locale("en", "EN");
        // Asignación del formato de guardar archivo
        Formatter outArchivo1 = new Formatter("dapillcoBdEst_OrdenTotal.csv", "US-ASCII", ingles);
        for(int i =0; i < matrizT.length;i++){
            for(int j = 0; j < matrizT[i].length;j++){
                outArchivo1.format(";"+matrizT[i][j]);
            }
        }
        outArchivo1.close();
    }
    /*
    Metodo para genera el csv con las promociones ordenadas
     */
    public static void Generar_csvPromo (String [][] matrizT) throws FileNotFoundException, UnsupportedEncodingException {
        Locale ingles = new Locale("en", "EN");
        // Asignación del formato de guardar archivo
        Formatter outArchivo2 = new Formatter("dapillcoBdEst_OrdenPromo.csv", "US-ASCII", ingles);
        for(int i =0; i < matrizT.length;i++){
            for(int j = 0; j < matrizT[i].length;j++){
                outArchivo2.format(";"+matrizT[i][j]);
            }
        }
        outArchivo2.close();
    }
}
