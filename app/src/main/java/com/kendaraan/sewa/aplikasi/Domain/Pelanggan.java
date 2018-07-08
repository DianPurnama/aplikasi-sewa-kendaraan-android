package com.kendaraan.sewa.aplikasi.Domain;

public class Pelanggan {

    private String id;
    private String nama;
    private String noKtp;
    private String noSim;
    private String telpon;
    private String alamat;

    @Override
    public String toString() {
        return "Pelanggan{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", noKtp='" + noKtp + '\'' +
                ", noSim='" + noSim + '\'' +
                ", telpon='" + telpon + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getNoSim() {
        return noSim;
    }

    public void setNoSim(String noSim) {
        this.noSim = noSim;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
