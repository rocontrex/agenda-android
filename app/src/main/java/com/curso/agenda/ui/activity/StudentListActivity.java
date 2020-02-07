package com.curso.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.curso.agenda.DAO.StudentDAO;
import com.curso.agenda.R;
import com.curso.agenda.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

//O AppCompatActiviy é uma boa prática pois dá suporte a versões antigas do android
public class StudentListActivity extends AppCompatActivity {

    public static final String TITLE_LIST_STUDENT = "Lista de Alunos";
    public static final String STUDENT_KEY = "student";
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITLE_LIST_STUDENT);
        setContentView(R.layout.activity_lista_alunos);
        configureFABStudent();
        dao.save(new Student("Bruno", "92988233703", "rodrigoconte@gmail.com"));
        dao.save(new Student("Fernanda", "92988233703", "fenconte@gmail.com"));
        dao.save(new Student("Marcio", "92988233703", "mconte@gmail.com"));
    }

    private void configureFABStudent() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_floatingActionButton_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormStudentInsertModeActivity();
            }
        });
    }

    private void openFormStudentInsertModeActivity() {
        startActivity(new Intent(this, FormStudentActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configureList();
    }

    private void configureList() {
        ListView studentList = findViewById(R.id.activity_student_list_listview);
        final List<Student> students = dao.all();
        adapterConfigure(studentList, students);
        listenerItemClickConfigure(studentList);
    }

    private void listenerItemClickConfigure(ListView studentList) {
        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student) parent.getItemAtPosition(position);
                Intent goToFormActivity = openFormEditStudentMode(student);
                startActivity(goToFormActivity);
            }
        });
    }

    private Intent openFormEditStudentMode(Student choicedStudent) {
        Log.i("student_position", "" + choicedStudent);
        Intent goToFormActivity = new Intent(StudentListActivity.this, FormStudentActivity.class);
        goToFormActivity.putExtra(STUDENT_KEY, choicedStudent);
        return goToFormActivity;
    }

    private void adapterConfigure(ListView studentList, List<Student> students) {
        studentList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                students));
    }
}
