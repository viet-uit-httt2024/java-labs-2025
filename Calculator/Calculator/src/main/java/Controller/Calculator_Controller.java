/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Calculator_Model;
import View.Calculator_GUI;
import Model.Calculator_Model;

/**
 *
 * @author ADMIN
 */
public class Calculator_Controller {
//Attribute

    private Calculator_GUI view;
    private Calculator_Model model;

    private double currrentResult;
    private String currentOperator = "";
    private boolean firstInput = true;

//Method
    //Constructor
    public Calculator_Controller(Calculator_GUI view, Calculator_Model model) {
        this.view = view;
        this.model = model;
        addNumberEvents();
        addOperatorEvents();
        addEqualEvent();
        addClearEvent();
        addDotEvent();
    }
    //Việt
    public void appendNumber(String number){
        
    }

    public void addNumberEvents() {
         view.getBt0().addActionListener(e -> appendNumber("0"));
    }

    public void addOperatorEvents() {

    }

    public void addEqualEvent() {

    }

    
    //Thy
    public void addClearEvent() {
        view.getBtC().addActionListener(e -> {

            currrentResult = 0;
            currentOperator = "";
            firstInput = true;
            view.getTfResult().setText("");

        });
    }

    public void addDotEvent() {
     view.getBtDot().addActionListener(e -> {

            String text = view.getTfResult().getText();
            if (!text.contains(".")) {
                if (text.isEmpty()) {
                    view.getTfResult().setText("0.");
                } else {
                    view.getTfResult().setText(text + ".");
                }
            }
        });
    }
    
}
