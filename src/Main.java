import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //todo ghi danh sach hoc vien hien co trong file
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Thái", "Nam Định"));
        students.add(new Student(2, "Xuân Anh", "Chai nọ"));
        students.add(new Student(3, "Lập", "Dơ pen"));
        students.add(new Student(4, "An", "Tây"));
        writeToFile("students.txt", students);
        List<Student> studentList = readDataFromFile("students.txt");
        for (Student student:
             studentList) {
            System.out.println(student);
        }
    }

}
