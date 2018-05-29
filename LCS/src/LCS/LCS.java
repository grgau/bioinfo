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

//    private String a;
//    private String b;
//    private String resultado;
//
//    public void setStrings(String a, String b) {
//        this.a = a.toUpperCase().replace(" ","");
//        this.b = b.toUpperCase().replace(" ","");
//    }
    public String lcs(String a, String b) {
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
            return (x.length() > y.length()) ? x : y;
        }
    }

}
