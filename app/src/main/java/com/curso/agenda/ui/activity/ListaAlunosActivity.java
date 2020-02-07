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
public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de Alunos");

//        Toast.makeText(this, "Rodrigo Conte", Toast.LENGTH_LONG).show();
//        TextView aluno = new TextView(this );
//        aluno.setText("Rodrigo Conte");

        setContentView(R.layout.activity_lista_alunos);

        StudentDAO dao = new StudentDAO();

//        List<String> alunos = new ArrayList<>(
//                Arrays.asList("Alex", "Fran", "Bruno", "Ricardo", "Maria", "Ana"));
//        TextView primeiroAluno = findViewById(R.id.textView);
//        TextView segundoAluno = findViewById(R.id.textView2);
//        TextView terceiroAluno = findViewById(R.id.textView3);
//        TextView quartoAluno = findViewById(R.id.textView4);
//
//        primeiroAluno.setText(alunos.get(0));
//        segundoAluno.setText(alunos.get(1));
//        terceiroAluno.setText(alunos.get(2));
//        quartoAluno.setText(alunos.get(3));

        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_floatingActionButton_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        StudentDAO dao = new StudentDAO();

        ListView studentList = findViewById(R.id.activity_student_list_listview);
        studentList.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.all()));
    }
}
