/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MAI THY
 */
public class Calculator_Model {
     public double calculate(double a, double b, String op){

        switch(op){

            case "+" -> {
                return a+b;
             }

            case "-" -> {
                return a-b;
             }

            case "*" -> {
                return a*b;
             }

            case "/" -> {
                return a/b;
             }
        }

        return 0;
    }

}
