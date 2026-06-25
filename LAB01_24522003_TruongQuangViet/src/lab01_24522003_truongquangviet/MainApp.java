/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab01_24522003_truongquangviet;

/**
 *
 * @author ADMIN
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class MainApp {    
    public static void main(String[] args){
        StudentManager stm = new StudentManager();
        String menu = "1. Thêm 1 học sinh. " + 
                "\n2. Hiển thị danh sách học sinh." +
                "\n3. Tìm kiếm học sinh bằng mã học sinh." +
                "\n4. sắp xếp danh sách (giảm dần) dựa vào GPA" +
                "\n5. Thống kê " +
                "\n0. Kết thúc";
        
        //tự động sắp xếp theo StudentID tăng dần
        for(int i = 0; i < stm.listStudent.size()-1; i++){
            for(int j = i+1; j < stm.listStudent.size(); j++){
                int IDi = Integer.parseInt(stm.listStudent.get(i).getStudentId());
                int IDj = Integer.parseInt(stm.listStudent.get(j).getStudentId());
                if(IDi > IDj){
                    Student temp = stm.listStudent.get(j);
                    stm.listStudent.set(j, stm.listStudent.get(i));
                    stm.listStudent.set(i,temp);
                }
            }
        }
        while (true){
            JOptionPane.showMessageDialog(null, menu, "Result", JOptionPane.INFORMATION_MESSAGE );
            int select = IO.chonMenu();
            
            switch(select){
                case 0:
                    stm.saveFile();
                    JOptionPane.showMessageDialog(null,"Đã lưu dữ liệu");
                    System.exit(0);
                case 1: 
                    stm.addStudent();
                    break;
                case 2:
                    stm.displayList();
                    break;
                case 3:
                    String StudentID = IO.nhapID();
                    stm.findStudent(StudentID);
                    break;
                case 4:
                    stm.sortList();
                    break;
                case 5:
                    stm.staticsticClass();
                    break;
                default:
                    break;
            }
        }
        
    }
    
    
    
    
    
}