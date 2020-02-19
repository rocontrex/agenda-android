package com.curso.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.curso.agenda.R;
import com.curso.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends BaseAdapter {

    private final List<Student> students = new ArrayList<>();
    private final Context context;

    public StudentListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return students.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View createdView = createView(parent);
        Student getedStudent = students.get(position);

        linkData(createdView, getedStudent);

        return createdView;
    }

    private void linkData(View view, Student student) {
        TextView name = view.findViewById(R.id.student_name_item);
        TextView phone = view.findViewById(R.id.student_phone_item);
        name.setText(student.getName());
        phone.setText(student.getPhone());
    }

    private View createView(ViewGroup parent) {
        return LayoutInflater.from(context).
                inflate(R.layout.item_student, parent, false);
    }

    public void update(List<Student> students){
        this.students.clear();
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    public void remove(Student student) {
        students.remove(student);
        notifyDataSetChanged();
    }
}
