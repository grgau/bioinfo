/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import LCS.LCS;
import java.util.Scanner;

/**
 *
 * @author Paulo Paim
 */
public class Main {

    public static void main(String[] args) {
        
        String seq1, seq2;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insira a primeira sequencia:");
        seq1 = scanner.nextLine();
        
        System.out.println("Insira a segunda sequencia:");
        seq2 = scanner.nextLine();
        
        System.out.println(seq1);
        System.out.println(seq2);
        
        LCS lcs = new LCS();
        System.out.println(lcs.lcs(seq1, seq2));
        
        

    }

}
