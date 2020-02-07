package com.curso.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.curso.agenda.DAO.StudentDAO;
import com.curso.agenda.R;
import com.curso.agenda.model.Student;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        setTitle("Cadastrar novo Aluno");

        final StudentDAO dao = new StudentDAO();

        final EditText nameField = findViewById(R.id.activity_form_student_name);
        final EditText phoneField = findViewById(R.id.activity_form_student_phone);
        final EditText mailField = findViewById(R.id.activity_form_student_mail);

        Button saveButtom = findViewById(R.id.activity_form_button_student_save);
        saveButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                String phone = phoneField.getText().toString();
                String mail = mailField.getText().toString();

                Student createdStudent = new Student(name, phone, mail);

                dao.save(createdStudent);

                finish();
            }
        });

    }
}
