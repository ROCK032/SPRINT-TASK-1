package kz.bitlab.G115sprinttask3.db;

import kz.bitlab.G115sprinttask3.models.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager {
    @Getter
    private static List<Student> students = new ArrayList<>();
    private static Long id = 4L;

    static {
        students.add(new Student(1L, "China", "Dima", 90, "A"));
        students.add(new Student(2L, "GOAT", "Dima", 70, "B"));
        students.add(new Student(3L, "MARGO", "Dima", 60, "C"));
    }

    public static void addStudent(Student student) {
        student.setId(id);
        id++;
        int examScore = student.getExam();
        student.setMark(calculateMark(examScore));
        students.add(student);
    }

    public static Student getStudentById(Long id){
        return students.stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .findFirst()
                .orElseThrow();
    }

    public static void editStudent(Long id, String name, String surname, int exam) {
        Student student = getStudentById(id);
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        student.setMark(calculateMark(exam));
    }

    private static String calculateMark(int examScore) {
        if (examScore >= 90) {
            return "A";
        } else if (examScore >= 75) {
            return "B";
        } else if (examScore >= 60) {
            return "C";
        } else if (examScore >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
    public static void deleteById(Long id){
        students.removeIf(student -> Objects.equals(student.getId(),id));
    }
}

