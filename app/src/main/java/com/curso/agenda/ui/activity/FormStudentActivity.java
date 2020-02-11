package com.curso.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.curso.agenda.DAO.StudentDAO;
import com.curso.agenda.R;
import com.curso.agenda.model.Student;

import static com.curso.agenda.ui.activity.ConstantsActivities.STUDENT_KEY;

public class FormStudentActivity extends AppCompatActivity {

    private static final String TITLE_NEW_STUDENT = "Cadastrar novo Aluno";
    private static final String TITLE_EDIT_STUDENT = "Edita aluno";
    private EditText nameField;
    private EditText phoneField;
    private EditText mailField;
    private Student student;

    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        initializationOfFields();
        Intent datas = getIntent();
        loadStudent(datas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_form_student_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_form_student_menu){
            finishForm();
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadStudent(Intent datas) {
        student = (Student) datas.getSerializableExtra(STUDENT_KEY);
        if (datas.hasExtra(STUDENT_KEY)) {
            setTitle(TITLE_EDIT_STUDENT);
            insertFields();
        } else {
            setTitle(TITLE_NEW_STUDENT);
            student = new Student();
        }
    }

    private void insertFields() {
        nameField.setText(student.getName());
        phoneField.setText(student.getPhone());
        mailField.setText(student.getMail());
    }

    private void finishForm() {
        performStudent();
        if (student.hasValidId()) {
            dao.edit(student);
        } else {
            dao.save(student);
        }
        finish();
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
