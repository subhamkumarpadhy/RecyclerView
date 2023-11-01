package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContact = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.viewRecycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContact.add(new ContactModel(R.drawable.a, "A", "5468746578"));
        arrContact.add(new ContactModel(R.drawable.b, "B", "8461254964"));
        arrContact.add(new ContactModel(R.drawable.c, "C", "5471235455"));
        arrContact.add(new ContactModel(R.drawable.d, "D", "5314642587"));
        arrContact.add(new ContactModel(R.drawable.e, "E", "1235486344"));
        arrContact.add(new ContactModel(R.drawable.f, "F", "8741253648"));
        arrContact.add(new ContactModel(R.drawable.g, "G", "9741254635"));
        arrContact.add(new ContactModel(R.drawable.h, "H", "6370156488"));
        arrContact.add(new ContactModel(R.drawable.i, "I", "8472016454"));
        arrContact.add(new ContactModel(R.drawable.j, "J", "8454512545"));
        arrContact.add(new ContactModel(R.drawable.k, "K", "9842455145"));
        arrContact.add(new ContactModel(R.drawable.l, "L", "9422841254"));
        arrContact.add(new ContactModel(R.drawable.m, "M", "8251254154"));
        arrContact.add(new ContactModel(R.drawable.n, "N", "9522585545"));
        arrContact.add(new ContactModel(R.drawable.o, "O", "6258584525"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContact);
        recyclerView.setAdapter(adapter);

    }
}