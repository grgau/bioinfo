/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LCS;

/**
 *
 * @author Paulo Paim
 */
public class LCS {

    public static String lcs(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        if (aLen == 0 || bLen == 0) {
            return "";
        } else if (a.charAt(aLen - 1) == b.charAt(bLen - 1)) {
            return lcs(a.substring(0, aLen - 1), b.substring(0, bLen - 1))
                    + a.charAt(aLen - 1);
        } else {
            String x = lcs(a, b.substring(0, bLen - 1));
            String y = lcs(a.substring(0, aLen - 1), b);
            if (x.length() > y.length()) {
                return x;
            }
            return y;
        }
    }

    private String x;
    private String y;
    private String resultado;

    private int c[][];
    private String b[][];

    public LCS(String a, String b) {
        this.x = a.toUpperCase().replace(" ", "");
        this.y = b.toUpperCase().replace(" ", "");
        this.resultado = "";
        preencheMatriz();
        printC();
        printB();
        printLCS(x.length(),y.length());
    }

    public void printC() {
        for (int i = 0; i < x.length() + 1; i++) {
            for (int j = 0; j < y.length() + 1; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printB() {
        for (int i = 0; i < x.length() + 1; i++) {
            for (int j = 0; j < y.length() + 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printLCS(int i, int j) {

        if (i == 0 || j == 0) {
            System.out.println();
        } else {
            if (b[i][j]== "CE") {
                printLCS(i - 1, j - 1);
                System.out.println(x.charAt(i-1));
            } else if (b[i][j] == "C") {
                printLCS(i - 1, j);
            } else {
                printLCS(i, j - 1);
            }
        }

    }

    public void preencheMatriz() {
        int m = x.length();
        int n = y.length();

        this.c = new int[x.length() + 1][y.length() + 1];
        this.b = new String[x.length() + 1][y.length() + 1];

        for (int i = 0; i < m; i++) {
            c[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "CE";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "C";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "E";
                }
            }
        }
    }

}
