package id.aryad.sipasar;

public class Lapak {
    public String getNama_lapak() {
        return nama_lapak;
    }

    public void setNama_lapak(String nama_lapak) {
        this.nama_lapak = nama_lapak;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }

    private String nama_lapak;
    private String lokasi;
    private String nama_pemilik;
}
