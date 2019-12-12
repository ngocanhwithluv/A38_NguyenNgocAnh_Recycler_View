package com.example.a38_nguyenngocanh_02122019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        setContentView(R.layout.activity_edit_contact);

        AnhXa();

        Intent intent = getIntent();
        Contact contact = (Contact) intent.getSerializableExtra("oldContact");
        name.setText(contact.getName());
        address.setText(contact.getAddress());
        number.setText(contact.getNumber());

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if(number.getText().toString().isEmpty() == false ) {
            complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = getIntent();
                    Contact oldContact = (Contact) intent1.getSerializableExtra("oldContact");
                    name.setText(oldContact.getName());
                    address.setText(oldContact.getAddress());
                    number.setText(oldContact.getNumber());

                    Intent returnIntent = new Intent();
                    Contact contactAfterEdit = new Contact(
                            name.getText().toString(),
                            number.getText().toString(),
                            address.getText().toString(),
                            R.drawable.assistance);
                    returnIntent.putExtra("contactAfterEdit", contactAfterEdit);
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();

                }
            });
        }

    }
    private void AnhXa(){
        name = findViewById(R.id.edit_text_name_edit_contact);
        number = findViewById(R.id.edit_text_number_edit_contact);
        address = findViewById(R.id.edit_text_address_edit_contact);
        cancel = findViewById(R.id.text_view_cancel_edit_contact);
        complete = findViewById(R.id.text_view_complete_edit_contact);
    }

    private TextView name;
    private TextView number;
    private TextView address;
    private TextView cancel;
    private TextView complete;
}
