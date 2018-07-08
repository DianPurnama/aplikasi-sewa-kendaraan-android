package com.kendaraan.sewa.aplikasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kendaraan.sewa.aplikasi.Domain.Kendaraan;
import com.kendaraan.sewa.aplikasi.Domain.Pelanggan;
import com.kendaraan.sewa.aplikasi.R;

import java.util.ArrayList;
import java.util.List;

public class ListPelangganAdapter extends BaseAdapter {

    private Context context;
    private List<Pelanggan> listPelanggan = new ArrayList<>();
    private TextView lblNamaPelanggan, lblKtp, lblSim, lblTelpon, lblAlamat;

    public ListPelangganAdapter(Context context, List<Pelanggan> listPelanggan) {
        this.context = context;
        this.listPelanggan = listPelanggan;
    }

    @Override
    public int getCount() {
        return listPelanggan.size();
    }

    @Override
    public Pelanggan getItem(int i) {
        return listPelanggan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_pelanggan_layout, viewGroup, false);
            lblNamaPelanggan = view.findViewById(R.id.lbl_item_pelanggan_nama);
            lblKtp = view.findViewById(R.id.lbl_item_pelanggan_no_ktp);
            lblSim = view.findViewById(R.id.lbl_item_pelanggan_no_sim);
            lblTelpon = view.findViewById(R.id.lbl_item_pelanggan_telepon);
            lblAlamat = view.findViewById(R.id.lbl_item_pelanggan_alamat);

        }



        Pelanggan p = getItem(i);

        lblNamaPelanggan.setText(p.getNama());
        lblKtp.setText(p.getNoKtp());
        lblSim.setText(p.getNoSim());
        lblTelpon.setText(p.getTelpon());
        lblAlamat.setText(p.getAlamat());

        return view;
    }
}
