package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactModel> arrContacts;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts) {
        this.context = context;
        this.arrContacts = arrContacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.app_update);

                EditText editName = dialog.findViewById(R.id.editName);
                EditText editNum = dialog.findViewById(R.id.editNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView txtTitle = dialog.findViewById(R.id.txtTitle);

                txtTitle.setText("Update Contact");
                btnAction.setText("Update");

                editName.setText((arrContacts.get(position)).name);
                editNum.setText((arrContacts.get(position)).number);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name  =  "",  number = "";
                        if (!editName.getText().toString().equals("")) {
                            name = editName.getText().toString();
                        } else {
                            Toast.makeText(context, "Please Enter Contact Name!!", Toast.LENGTH_SHORT).show();
                        }
                        if (!editNum.getText().toString().equals("")) {
                            number = editNum.getText().toString();
                        } else {
                            Toast.makeText(context, "Please Enter Contact Number!!", Toast.LENGTH_SHORT).show();
                        }
                        arrContacts.set(position, new ContactModel(arrContacts.get(position).img, name, number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Delete Contact")
                .setMessage("Are you sure about it?")
                .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrContacts.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtNumber;
        ImageView imgContact;
        LinearLayout llRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
            llRow = itemView.findViewById(R.id.llRow);
        }

    }
}
