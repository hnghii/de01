package com.example.baovemon.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baovemon.DAO.XEDAO;
import com.example.de01.R;
import com.example.baovemon.models.XE;

import java.util.ArrayList;


public class XeAdapter extends RecyclerView.Adapter<XeAdapter.ViewHolder>{
    private Context context;
    private ArrayList<XE> list;
    private XEDAO XEDAO;


    public XeAdapter(Context context, ArrayList<XE> list, XEDAO XEDAO) {
        this.context = context;
        this.list = list;
        this.XEDAO = XEDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.one_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtmand.setText("ma xe =" + list.get(position).getMaxe());
        holder.tvCCCD.setText("ten xe :"+list.get(position).getTenxe());
        holder.tvTen.setText("gia :"+list.get(position).getGiaban());
        holder.tvngay1.setText("hang xe: "+list.get(position).getHangxe());
        holder.tvngay2.setText("trang thai: "+list.get(position).getTrangthai());
//xoa
        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = XEDAO.xoaThongTin(list.get(holder.getAdapterPosition()).getMaxe());
                switch (check){
                    case -1:
                        Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        loadData();
                        break;
                }
            }
        });
        //xong xoa
    }

    @Override
            public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtmand,tvCCCD,tvTen,tvngay1,tvngay2;
        ImageView ivDel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtmand = itemView.findViewById(R.id.txtmand);
            tvCCCD = itemView.findViewById(R.id.tvCCCD);
            tvTen = itemView.findViewById(R.id.tvTen);
            tvngay1 = itemView.findViewById(R.id.tvNgay1);
            tvngay2 = itemView.findViewById(R.id.tvNgay2);
            ivDel = itemView.findViewById(R.id.ivDel);
        }
    }
    private void loadData(){
        list.clear();
        list = XEDAO.getNguoiDung();
        notifyDataSetChanged();
    }
}
