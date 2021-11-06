package com.utsav.krishibackoffice.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utsav.krishibackoffice.Model.DataEntryReportListModel;
import com.utsav.krishibackoffice.R;

import java.util.ArrayList;

public class DataEntryReportAdapter extends RecyclerView.Adapter<DataEntryReportAdapter.DataEntryReportViewHolder>{

    Context context;
    ArrayList<DataEntryReportListModel>  datareports;


    public DataEntryReportAdapter(Context context, ArrayList<DataEntryReportListModel> datareports) {
        this.context = context;
        this.datareports = datareports;
    }

    @NonNull
    @Override
    public DataEntryReportAdapter.DataEntryReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_dataentry_report, parent, false);
        return new  DataEntryReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataEntryReportAdapter.DataEntryReportViewHolder holder, int position) {
       /* int count=position+1;
        holder.txt_serial.setText(count);*/
        holder.txt_date.setText(datareports.get(position).getVegDateModify());
        holder.txt_quan.setText(datareports.get(position).getQuantity());

    }

    @Override
    public int getItemCount() {
        return datareports.size();
    }

    public class DataEntryReportViewHolder extends RecyclerView.ViewHolder{

        TextView txt_serial,txt_date,txt_quan;



        public DataEntryReportViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_serial = itemView.findViewById(R.id.txt_serial);
            txt_date = itemView.findViewById(R.id.txt_date);
            txt_quan = itemView.findViewById(R.id.txt_quan);

        }
    }
}
