package com.curso.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.curso.agenda.DAO.StudentDAO;
import com.curso.agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

//O AppCompatActiviy é uma boa prática pois dá suporte a versões antigas do android
public class StudendListActivity extends AppCompatActivity {

    public static final String TITLE_LIST_STUDENT = "Lista de Alunos";
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITLE_LIST_STUDENT);
        setContentView(R.layout.activity_lista_alunos);
        configureFABStudent();
    }

    private void configureFABStudent() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_floatingActionButton_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormStudentActivity();
            }
        });
    }

    private void openFormStudentActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configureDAO();
    }

    private void configureDAO() {
        ListView studentList = findViewById(R.id.activity_student_list_listview);
        studentList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}
