package com.example.a38_nguyenngocanh_02122019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        setContentView(R.layout.activity_main);

        textViewAddContact = findViewById(R.id.text_view_add_contact);

        textViewAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContact.class);
                startActivity(intent);
            }
        });

        contacts = new ArrayList<>();
        contact1 = new Contact("nna", "0868967660", "ha noi", R.drawable.assistance);
        contact2 = new Contact("nnb", "0868967660", "ha noi", R.drawable.assistance);
        contact3 = new Contact("nnc", "0868967660", "ha noi", R.drawable.assistance);
        contact4 = new Contact("nnd", "0868967660", "ha noi", R.drawable.assistance);

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);

//        Intent intent2 = getIntent();
//        Contact newContact = (Contact) intent2.getSerializableExtra("newContact");
//        contacts.add(newContact);

        adapterContact = new AdapterContact(contacts);
        listViewContact = findViewById(R.id.list_view_contact);
        listViewContact.setAdapter(adapterContact);
    }

    private ListView listViewContact;
    private AdapterContact adapterContact;
    public  List<Contact> contacts;
    private Contact contact1, contact2, contact3, contact4;
    private TextView textViewAddContact;
}
