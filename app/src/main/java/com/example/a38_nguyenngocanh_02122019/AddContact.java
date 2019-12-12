package com.example.a38_nguyenngocanh_02122019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        setContentView(R.layout.activity_add_contact);

        AnhXa();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if(number.getText().toString().isEmpty() ) {
            complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent returnIntent = new Intent();
                    Contact newContact = new Contact(
                            name.getText().toString(),
                            number.getText().toString(),
                            address.getText().toString(),
                            R.drawable.assistance);
                    returnIntent.putExtra("newContact", newContact);
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }
            });
        }

    }
    private void AnhXa(){
        name = findViewById(R.id.edit_text_name_add_contact);
        number = findViewById(R.id.edit_text_number_add_contact);
        address = findViewById(R.id.edit_text_address_add_contact);
        cancel = findViewById(R.id.text_view_cancel_add_contact);
        complete = findViewById(R.id.text_view_complete_add_contact);
    }

    private TextView name;
    private TextView number;
    private TextView address;
    private TextView cancel;
    private TextView complete;
}
