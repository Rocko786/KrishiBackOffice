package com.utsav.krishibackoffice.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utsav.krishibackoffice.Model.DataEntryReportListModel;
import com.utsav.krishibackoffice.Model.VegListModel;
import com.utsav.krishibackoffice.R;

import java.util.ArrayList;

public class DataEntryAdapter extends RecyclerView.Adapter<DataEntryAdapter.DataEntryViewHolder>{

    Context context;
    ArrayList<VegListModel> dataentries;

    public DataEntryAdapter(Context context, ArrayList<VegListModel> dataentries) {
        this.context = context;
        this.dataentries = dataentries;
        setHasStableIds(true);
    }


    @NonNull
    @Override
    public DataEntryAdapter.DataEntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_dataentry, parent, false);
        return new DataEntryAdapter.DataEntryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataEntryAdapter.DataEntryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int count=position+1;
        holder.txt_serial.setText(Integer.toString(count));
        holder.txt_fosol_name.setText(dataentries.get(position).getVegName());
        holder.edit_quantity.setText(dataentries.get(position).getQuantity());
        holder.edit_quantity.addTextChangedListener(new TextWatcher() {
            String Qunantity="";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                    Qunantity=holder.edit_quantity.getText().toString();
                    dataentries.get(position).setQuantity(Qunantity);


            }

            @Override
            public void afterTextChanged(Editable s) {
                /*if(holder.edit_quantity.getText().toString().equals("") || holder.edit_quantity.getText().toString().isEmpty()){
                    holder.edit_quantity.setText("0");
                    Qunantity=holder.edit_quantity.getText().toString();
                    dataentries.get(position).setQuantity(Qunantity);
                }
                else {
                    Qunantity=holder.edit_quantity.getText().toString();
                    dataentries.get(position).setQuantity(Qunantity);
                }*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataentries.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    public class DataEntryViewHolder extends RecyclerView.ViewHolder{

        TextView txt_serial,txt_fosol_name;
        EditText edit_quantity;



        public DataEntryViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_serial = itemView.findViewById(R.id.txt_serial);
            txt_fosol_name = itemView.findViewById(R.id.txt_fosol_name);
            edit_quantity = itemView.findViewById(R.id.edit_quantity);

        }
    }

}
