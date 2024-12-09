/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comprog;
import java.util.Scanner;

/**
 *
 * @author Gerald
 */
public class area_of_square {
    public static void main (String[]args){
        Scanner scan = new Scanner (System.in);
        
        int side;
        
        System.out.print("Input Side : ");
        side = scan.nextInt();
        
        int area = side*side;
        
        System.out.println("Area of square is : " + area);
        
    }
}
