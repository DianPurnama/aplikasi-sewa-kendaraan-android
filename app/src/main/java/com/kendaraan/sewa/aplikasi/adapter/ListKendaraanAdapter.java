package com.kendaraan.sewa.aplikasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kendaraan.sewa.aplikasi.Domain.Kendaraan;
import com.kendaraan.sewa.aplikasi.R;

import java.util.ArrayList;
import java.util.List;

public class ListKendaraanAdapter extends BaseAdapter {

    private Context context;
    private List<Kendaraan> listKendaraan = new ArrayList<>();
    private TextView lblNama, lblNopol;

    public ListKendaraanAdapter(Context context, List<Kendaraan> listKendaraan) {
        this.context = context;
        this.listKendaraan = listKendaraan;
    }

    @Override
    public int getCount() {
        return listKendaraan.size();
    }

    @Override
    public Kendaraan getItem(int i) {
        return listKendaraan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_kendaraan_layout, viewGroup, false);
            lblNama = view.findViewById(R.id.lbl_item_kendaraan_nama);
            lblNopol = view.findViewById(R.id.lbl_item_kendaraan_no_polis);
        }



        Kendaraan k = getItem(i);

        lblNama.setText(k.getNama());
        lblNopol.setText(k.getNoPolis());

        return view;
    }
}
