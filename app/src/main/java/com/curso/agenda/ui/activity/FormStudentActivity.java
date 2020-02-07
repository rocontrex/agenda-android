package com.curso.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.curso.agenda.DAO.StudentDAO;
import com.curso.agenda.R;
import com.curso.agenda.model.Student;

import java.io.Serializable;

public class FormStudentActivity extends AppCompatActivity {

    public static final String TITLE_NEW_STUDENT = "Cadastrar novo Aluno";
    private EditText nameField;
    private EditText phoneField;
    private EditText mailField;
    private Student student;

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITLE_NEW_STUDENT);
        initializationOfFields();
        configureButtomSave();
        Intent datas = getIntent();

        student = (Student) datas.getSerializableExtra("student");
        if (datas.hasExtra("student")) {
            nameField.setText(student.getName());
            phoneField.setText(student.getPhone());
            mailField.setText(student.getMail());
        } else {
            student = new Student();
        }
    }

    private void configureButtomSave() {
        Button saveButtom = findViewById(R.id.activity_form_button_student_save);
        saveButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performStudent();
                if (student.hasValidId()){
                    dao.edit(student);
                } else {
                    dao.save(student);
                }
                finish();
            }
        });
    }

    private void initializationOfFields() {
        nameField = findViewById(R.id.activity_form_student_name);
        phoneField = findViewById(R.id.activity_form_student_phone);
        mailField = findViewById(R.id.activity_form_student_mail);
    }

    private void performStudent() {
        String name = nameField.getText().toString();
        String phone = phoneField.getText().toString();
        String mail = mailField.getText().toString();

        student.setName(name);
        student.setPhone(phone);
        student.setMail(mail);

        finish();
    }
}
