package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContact = new ArrayList<>();
    RecyclerContactAdapter adapter;
    FloatingActionButton btnOpenDialog;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.viewRecycle);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.app_update);

                EditText editName = dialog.findViewById(R.id.editName);
                EditText editNum = dialog.findViewById(R.id.editNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name  =  "",  number = "";
                        if (!editName.getText().toString().equals("")) {
                             name = editName.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Contact Name!!", Toast.LENGTH_SHORT).show();
                        }
                        if (!editNum.getText().toString().equals("")) {
                             number = editNum.getText().toString();
                        } else {
                            Toast.makeText(MainActivity.this, "Please Enter Contact Number!!", Toast.LENGTH_SHORT).show();
                        }

                        arrContact.add(new ContactModel(R.drawable.img, name, number));
                        adapter.notifyItemInserted(arrContact.size() - 1);
                        recyclerView.scrollToPosition(arrContact.size() - 1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


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

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerContactAdapter(this, arrContact);
        recyclerView.setAdapter(adapter);

    }
}