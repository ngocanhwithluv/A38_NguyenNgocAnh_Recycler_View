package com.example.a38_nguyenngocanh_02122019;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    ArrayList<Contact> contactArrayList;
    Context context;
    MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }

    public ContactAdapter(ArrayList<Contact> contactArrayList, Context context) {
        this.contactArrayList = contactArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View itemView = layoutInflater.inflate(R.layout.layout_item_contact, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Contact contact = contactArrayList.get(position);

        holder.textViewNameContact.setText(contactArrayList.get(position).getName());
        holder.textViewNumberContact.setText(contactArrayList.get(position).getNumber());
        holder.textViewAddressContact.setText(contactArrayList.get(position).getAddress());
        holder.imageViewContact.setImageResource(R.drawable.assistance);

        holder.textViewNameContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClick.onClickName(contact.getName());
            }
        });

        holder.textViewNumberContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClick.onClickPhone(contact);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewNameContact,
                textViewNumberContact,
                textViewAddressContact;
        ImageView imageViewContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNameContact = itemView.findViewById(R.id.text_view_name_item);
            textViewNumberContact = itemView.findViewById(R.id.text_view_number_item);
            textViewAddressContact = itemView.findViewById(R.id.text_view_address_item);
            imageViewContact = itemView.findViewById(R.id.image_view_item_contact);


        }
    }
}
