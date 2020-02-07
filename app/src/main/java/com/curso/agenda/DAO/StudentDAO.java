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
        idCounter++;
    }

    public void edit(Student student) {
        Student finderStudent = null;
        for (Student a :
                students) {
            if (a.getId() == student.getId()) {
                finderStudent = a;
            }
        }
        if (finderStudent != null) {
            int studentPosition = students.indexOf(finderStudent);
            students.set(studentPosition, student);
        }
    }

    public List<Student> all() {
        return new ArrayList<>(students);
    }
}
