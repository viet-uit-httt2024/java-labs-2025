/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01_24522003_truongquangviet;

import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class IO {
    
    public static String nhapID(){
        return JOptionPane.showInputDialog(null,"Enter Student ID: ");
    }
    
    public static String nhapTen(){
        return JOptionPane.showInputDialog(null, "Enter Student Name: ");
    }
    
    public static int nhapTuoi(){
        String age = JOptionPane.showInputDialog(null, "Enter age: ");
        return Integer.parseInt(age);
    }
    
    public static double nhapGPA(){
        String gpa = JOptionPane.showInputDialog(null, "Enter GPA: ");
        return Double.parseDouble(gpa);
    }
    
    public static int chonMenu(){
        String select = JOptionPane.showInputDialog(null, "Chọn chức năng: ");
        return Integer.parseInt(select);
    }
}
