package com.curso.agenda.ui.activity;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.curso.agenda.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//O AppCompatActiviy é uma boa prática pois dá suporte a versões antigas do android
public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de Alunos");

        ActionBar actionBar;
        actionBar = getActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#9C27B0"));
        actionBar.setBackgroundDrawable(colorDrawable);

//        Toast.makeText(this, "Rodrigo Conte", Toast.LENGTH_LONG).show();
//        TextView aluno = new TextView(this );
//        aluno.setText("Rodrigo Conte");

        setContentView(R.layout.activity_lista_alunos);

        List<String> alunos = new ArrayList<>(
                Arrays.asList("Alex", "Fran", "Bruno", "Ricardo", "Maria", "Ana"));
//        TextView primeiroAluno = findViewById(R.id.textView);
//        TextView segundoAluno = findViewById(R.id.textView2);
//        TextView terceiroAluno = findViewById(R.id.textView3);
//        TextView quartoAluno = findViewById(R.id.textView4);
//
//        primeiroAluno.setText(alunos.get(0));
//        segundoAluno.setText(alunos.get(1));
//        terceiroAluno.setText(alunos.get(2));
//        quartoAluno.setText(alunos.get(3));

        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos));

    }

}
