/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01_24522003_truongquangviet;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

import java.io.Serializable; // lưu file mỗi lần chạy chương trình


/**
 *
 * @author ADMIN
 */
public class Student implements Serializable {

    private String studentId;
    private String fullName;
    private int age;
    private double gpa;

    
    public Student(String studentId, String fullName, int age, double gpa){
        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.gpa = gpa;
    }
    public Student(){
        studentId = "0";
        fullName = "Null";
        age = 0;
        gpa = 0;
    }
    
    public Student(Student copy){
        this.studentId = copy.getStudentId();
        this.fullName = copy.getName();
        this.age = copy.getAge();
        this.gpa = copy.getGpa();
    }
    
    //Getter & Setter
    public String getStudentId(){
        return studentId;
    }
    
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
    
    
    public String getName() {
        return fullName;
    }
    
    public void setName(String name){
        this.fullName = name;
    }

    public int getAge() {
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return "Student ID: " + studentId + " | Full Name: " + fullName + " | Age: " + age + " | GPA: " + gpa; 
    }
    
    public void nhap(){
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("Nhập thông tin học sinh \n");
        
        studentId = IO.nhapID();
        
        while(studentId.length() == 0){
            JOptionPane.showMessageDialog(null, "Student ID không được rỗng, nhập lại ", "Error", JOptionPane.INFORMATION_MESSAGE );
            studentId = IO.nhapID();
        }
        
        fullName = IO.nhapTen();
        while(fullName.length() == 0){
            JOptionPane.showMessageDialog(null, "Student Name không được rỗng, nhập lại ", "Error", JOptionPane.INFORMATION_MESSAGE);
            fullName = IO.nhapTen();
        }
        
        age = IO.nhapTuoi();
        while(age < 10 || age > 25){
            JOptionPane.showMessageDialog(null, "Age phải thuộc khoảng [10, 25], nhập lại ", "Error", JOptionPane.INFORMATION_MESSAGE);
            age = IO.nhapTuoi();
        }
        
        gpa = IO.nhapGPA();
        while(gpa < 0 || gpa > 10){
            JOptionPane.showMessageDialog(null, "Age phải thuộc khoảng [0.0, 10.0], nhập lại ", "Error", JOptionPane.INFORMATION_MESSAGE);
            gpa = IO.nhapGPA();
        }
    }
}
