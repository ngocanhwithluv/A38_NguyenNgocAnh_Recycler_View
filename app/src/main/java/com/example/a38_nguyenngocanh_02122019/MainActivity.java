package com.example.a38_nguyenngocanh_02122019;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    public  ArrayList<Contact> contacts;
    public RecyclerView recyclerView;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 ){
            if(resultCode == Activity.RESULT_OK){
                Contact newContact = (Contact) data.getSerializableExtra("newContact");
                contacts.add(newContact);
                contactAdapter.notifyDataSetChanged();
            }
        }
        if(requestCode == 2 ){
            if(resultCode == Activity.RESULT_OK){
                Contact newContact = (Contact) data.getSerializableExtra("contactAfterEdit");
                contacts.add(newContact);
                contactAdapter.notifyDataSetChanged();
            }
        }

    }

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

        recyclerView = findViewById(R.id.recycler_view_contact);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        contacts = new ArrayList<>();
        addContact();

        contactAdapter = new ContactAdapter(contacts, getApplicationContext());
        recyclerView.setAdapter(contactAdapter);

        contactAdapter.setMyOnClick(new MyOnClick() {
            @Override
            public void onClickName(String name) {
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onClickPhone(Contact contact) {
                Intent intent = new Intent(MainActivity.this, EditContact.class);
                intent.putExtra("oldContact", contact);
                startActivityForResult(intent, 2);

            }
        });

        textViewAddContact = findViewById(R.id.text_view_add_contact);
        textViewAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContact.class);
                startActivityForResult(intent, 1);
            }
        });



    }

    private ContactAdapter contactAdapter;
    private Contact contact1, contact2, contact3, contact4;
    private TextView textViewAddContact;
    private void addContact(){
        contact1 = new Contact("nna", "0868967660", "ha noi", R.drawable.assistance);
        contact2 = new Contact("nnb", "0868967660", "ha noi", R.drawable.assistance);
        contact3 = new Contact("nnc", "0868967660", "ha noi", R.drawable.assistance);
        contact4 = new Contact("nnd", "0868967660", "ha noi", R.drawable.assistance);

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
    }
}
