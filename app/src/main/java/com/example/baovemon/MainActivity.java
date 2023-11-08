package com.example.baovemon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.baovemon.DAO.XEDAO;
import com.example.de01.R;
import com.example.baovemon.adapter.XeAdapter;
import com.example.baovemon.models.XE;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private XEDAO XEDAO;
    private RecyclerView recyclerView;
    private ArrayList<XE> list;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.Recycleview);
        relativeLayout = findViewById(R.id.relativenguoidung);
        FloatingActionButton floatAdd = findViewById(R.id.FloatAdd);
        XEDAO = new XEDAO(this);
        list = XEDAO.getNguoiDung();

        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialogAdd();
            }
        });

        capnhatgiaodien();

    }
//them
    private void showdialogAdd() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog,null);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCancelable(false);
        alertDialog.show();

        EditText edttenxe= view.findViewById(R.id.edttenxe);
        EditText edtGia = view.findViewById(R.id.edtGia);
        EditText edtHang = view.findViewById(R.id.edtHang);
        EditText edtTrangthai = view.findViewById(R.id.edtTrangthai);
        Button btnThem = view.findViewById(R.id.btnThem);
        Button btnHuy = view.findViewById(R.id.btnHuy);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int maxe = 1;
                String tenxe = edttenxe.getText().toString();
                Integer giaban = Integer.valueOf(edtGia.getText().toString());
                String hangxe = edtHang.getText().toString();
                Integer trangthai = Integer.valueOf(edtTrangthai.getText().toString());

                XE XE = new XE(maxe,tenxe,giaban,hangxe,trangthai);

                if (tenxe.equals("") && giaban.equals("") && hangxe.equals("") && trangthai.equals("")){
                    Toast.makeText(MainActivity.this, "Nhập đầy đủ thông tin để thêm!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean check = XEDAO.ThemThongTin(XE);
                if (check){
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    capnhatgiaodien();
                    alertDialog.dismiss();
                }else {
                    Toast.makeText(MainActivity.this, "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }
    //xong them
    private void capnhatgiaodien() {
        list = XEDAO.getNguoiDung();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
         XeAdapter xeAdapter = new XeAdapter(this,list,XEDAO);
        recyclerView.setAdapter(xeAdapter);
        list = XEDAO.getNguoiDung();
    }

}