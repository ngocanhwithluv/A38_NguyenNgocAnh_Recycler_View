package com.example.a38_nguyenngocanh_02122019;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterContact extends BaseAdapter {

    List<Contact> listContact;

    public AdapterContact(List<Contact> listContact) {
        this.listContact = listContact;
    }

    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.layout_item_contact, parent, false);

        TextView textViewNameContact =v.findViewById(R.id.text_view_name_item);
        TextView textViewNumber = v.findViewById(R.id.text_view_number_item);
        TextView textViewaddress = v.findViewById(R.id.text_view_address_item);
        ImageView imageViewContact = v.findViewById(R.id.image_view_item_contact);

        Contact contact = listContact.get(position);

        textViewNameContact.setText(contact.getName());
        textViewNumber.setText(contact.getNumber());
        textViewaddress.setText(contact.getAddress());
        imageViewContact.setImageResource(contact.getImage());

        return v;
    }
}
