/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab01_24522003_truongquangviet;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.io.*;

/**
 *
 * @author ADMIN
 */
public class StudentManager {

    public ArrayList<Student> listStudent = new ArrayList<>();

    public StudentManager() {

        loadFile();
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("Đã tạo ra danh sách học sinh");
    }

    public void addStudent() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("Thêm một học sinh mới \n");
        Student st = new Student();
        st.nhap();
        for(Student check : listStudent){
            if(check.getStudentId().equals(st.getStudentId())){
                while(check.getStudentId().equals(st.getStudentId())){
                    JOptionPane.showMessageDialog(null, "Đã tồn tại Student ID, vui lòng nhập lại", "Result", JOptionPane.INFORMATION_MESSAGE);
                    st.nhap();
                }
            }
        }
        listStudent.add(st);
        
        for(int i = 0; i < listStudent.size()-1; i++){
            for(int j = i+1; j < listStudent.size(); j++){
                int IDi = Integer.parseInt(listStudent.get(i).getStudentId());
                int IDj = Integer.parseInt(listStudent.get(j).getStudentId());
                if(IDi > IDj){
                    Student temp = listStudent.get(j);
                    listStudent.set(j, listStudent.get(i));
                    listStudent.set(i,temp);
                }
            }
        }
        saveFile();
        return;
    }


    public void displayList() {
        String result = "Danh sách sinh viên:\n";

        if (listStudent.isEmpty()) {
            result += "Danh sách rỗng";
        } else {
            for (Student st : listStudent) {
                result += st.toString() + "\n";
            }

        }

        JOptionPane.showMessageDialog(
                null,
                result,
                "Student List",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void findStudent(String studentID) {
        boolean check = false;
        for (Student t : listStudent) {
            if (t.getStudentId().equals(studentID)) {
                String mess = "Thông tin học sinh có StudentID " + studentID + "\n" + t.toString();
                JOptionPane.showMessageDialog(null, mess, "Result", JOptionPane.INFORMATION_MESSAGE);
                check = true;
                break;
            }
        }
        if (!check) {
            JOptionPane.showMessageDialog(null, "Không tồn tại Student ID: " + studentID, "Result", JOptionPane.INFORMATION_MESSAGE);
        }

        return;
    }

    public void sortList() {
        // tạo danh sách tạm thời để coi sắp xếp tạm thời, khi dùng chức năng coi danh sách thì danh sách ban đầu ko bị đổi
        ArrayList<Student> tempList = new ArrayList<>(listStudent); 
        
        for(int i = 0; i < tempList.size()-1; i++){
            for(int j = i + 1; j < tempList.size() ; j++){
                if(tempList.get(i).getGpa() < tempList.get(j).getGpa()){
                    Student t = tempList.get(j);
                    tempList.set(j, tempList.get(i));
                    tempList.set(i, t);
                }
            }
        }
        String result = "";
        for(Student t : tempList){
            result += t.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, "Danh sách sinh viên có GPA giảm dần \n" + result, "Result",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void staticsticClass(){
        if(listStudent.isEmpty()){
            JOptionPane.showMessageDialog(null, "Danh sách rỗng");
            return;
        }
        
        double max = listStudent.get(0).getGpa();
        double min = listStudent.get(0).getGpa();
        int countExellent = 0;
        double sum = 0;
        
        for(Student t : listStudent){
            if(t.getGpa() >= max){
                max = t.getGpa();
            }
            
            if(t.getGpa() <= min){
                min = t.getGpa();
            }
            
            if(t.getGpa() > 8.0){
                countExellent++;
            }
            
            sum += t.getGpa();
        }
        
        double avg = sum / listStudent.size();
        
        String rs = 
                "GPA Max: " + max +
                "\nGPA Min: " + min +
                "\nSố lượng học sinh Xuất Sắc (GPA > 8.0): " + countExellent +
                "\nĐiểm GPA trung bình: " + avg;
        JOptionPane.showMessageDialog(null,rs,"Result",JOptionPane.INFORMATION_MESSAGE);
    }

    
    
    
    
    
    public void saveFile() {

        try (ObjectOutputStream out
                = new ObjectOutputStream(
                        new FileOutputStream("student.dat"))) {

            out.writeObject(listStudent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFile() {

        try (ObjectInputStream in
                = new ObjectInputStream(
                        new FileInputStream("student.dat"))) {

            listStudent
                    = (ArrayList<Student>) in.readObject();

        } catch (Exception e) {

            listStudent = new ArrayList<>();

        }
    }
}
