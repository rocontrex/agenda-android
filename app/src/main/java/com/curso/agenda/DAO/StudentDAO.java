package com.curso.agenda.DAO;

import com.curso.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();
    private static int idCounter = 1;

    public void save(Student student) {
        student.setId(idCounter);
        students.add(student);
        updateIDs();
    }

    private int updateIDs() {
        return idCounter++;
    }

    public void edit(Student student) {
        Student finderStudent = searchStudentById(student);
        if (finderStudent != null) {
            int studentPosition = students.indexOf(finderStudent);
            students.set(studentPosition, student);
        }
    }

    private Student searchStudentById(Student student) {
        for (Student a :
                students) {
            if (a.getId() == student.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Student> all() {
        return new ArrayList<>(students);
    }

    public void RemoveStudent(Student student) {
        Student studentResponse = searchStudentById(student);
        if (studentResponse != null) {
            students.remove(studentResponse);
        }
    }
}
