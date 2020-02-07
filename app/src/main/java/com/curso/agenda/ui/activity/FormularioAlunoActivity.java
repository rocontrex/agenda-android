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

    public static final String TITLE_NEW_STUDENT = "Cadastrar novo Aluno";
    private EditText nameField;
    private EditText phoneField;
    private EditText mailField;

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITLE_NEW_STUDENT);
        initializationOfFields();
        configureButtomSave();
    }

    private void configureButtomSave() {
        Button saveButtom = findViewById(R.id.activity_form_button_student_save);
        saveButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student createdStudent = createStudent();

                save(createdStudent);
            }
        });
    }

    private void initializationOfFields() {
        nameField = findViewById(R.id.activity_form_student_name);
        phoneField = findViewById(R.id.activity_form_student_phone);
        mailField = findViewById(R.id.activity_form_student_mail);
    }

    private void save(Student createdStudent) {
        dao.save(createdStudent);
        finish();
    }

    private Student createStudent() {
        String name = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        String mail = mailField.getText().toString();

        return new Student(name, phone, mail);
    }
}
