/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;

import Controller.Calculator_Controller;
import Model.Calculator_Model;
import View.Calculator_GUI;

/**
 *
 * @author ADMIN
 */
public class Calculator {

    public static void main(String[] args) {
        Calculator_GUI view = new Calculator_GUI();

        Calculator_Model model = new Calculator_Model();

        new Calculator_Controller(view, model);

        view.setVisible(true);
    }
}
