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

    private double currentResult;
    private String currentOperator = "";
    
    //Kiểm tra có phải là toán tử đầu tiên hay không
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
        view.getTfResult().setText(view.getTfResult().getText() + number);
    }

    public void addNumberEvents() {
         view.getBt0().addActionListener(e -> appendNumber("0"));
         view.getBt1().addActionListener(e->appendNumber("1"));
         view.getBt2().addActionListener(e->appendNumber("2"));
         view.getBt3().addActionListener(e->appendNumber("3"));
         view.getBt4().addActionListener(e->appendNumber("4"));
         view.getBt5().addActionListener(e->appendNumber("5"));
         view.getBt6().addActionListener(e->appendNumber("6"));
         view.getBt7().addActionListener(e->appendNumber("7"));
         view.getBt8().addActionListener(e->appendNumber("8"));
         view.getBt9().addActionListener(e->appendNumber("9"));
    }

    public void processOp(String op){
        
        if(view.getTfResult().getText().isEmpty()){
            return;
        }
        
        double number = Double.parseDouble(view.getTfResult().getText());
        
        if(firstInput){
            currentResult = number;
            firstInput = false;
        } else{
            currentResult = model.calculate(number, currentResult, op);
        }
        currentOperator = op;
        
        view.getTfResult().setText("");
        
    }
    public void addOperatorEvents() {
        view.getBtPlus().addActionListener(e-> processOp("+"));
        view.getBtPlus().addActionListener(e-> processOp("-"));
        view.getBtPlus().addActionListener(e-> processOp("*"));
        view.getBtPlus().addActionListener(e-> processOp("/"));
    }

    public void addEqualEvent() {
        view.getBtEqual().addActionListener(e->{
            if(view.getTfResult().getText().isEmpty()){
                return;
            }
            
            double number = Double.parseDouble(view.getTfResult().getText());
            currentResult = model.calculate(number, currentResult, currentOperator);
            view.getTfResult().setText(String.valueOf(currentResult));
            firstInput = true;
        }
        
        );
    }

    
    //Thy
    public void addClearEvent() {

    }

    public void addDotEvent() {

    }
    
}
