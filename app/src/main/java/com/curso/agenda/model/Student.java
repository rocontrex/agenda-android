package com.curso.agenda.model;

import androidx.annotation.Nullable;

public class Student {
    private final String name;
    private final String phone;
    private final String mail;

    public Student(String name, String phone, String mail) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    @Nullable
    @Override
    public String toString() {
        return name;
    }
}
