package id.aryad.sipasar;

import java.util.ArrayList;

public class DataLapak {
    public static String[][] data = new String[][]{
            {"Lapak Ableh", "Blok A No 12"},
            {"Warung Aya", "Blok B No 24"},
            {"Lapak Bu Indah", "Blok C No 67"},
            {"Warung Pak Eko", "Blok B No 8"},
            {"Babi Guling Men Agus", "Blok D No 10"},
            {"Nasi Betutu Galuh", "Blok A No 42"},
            {"Grosiran Nana", "Blok B No 32"},
            {"Perkakas Jaya", "Blok C No 54"},
            {"Elektronik Koh Atong", "Blok A No 99"},
            {"Pisang Keju Ceria", "Blok A No 55"},
            {"Lapak Pak Nasri", "Blok C No 42"},
            {"Lapak Bu Sumerni", "Blok E No 10"}
    };
    public static ArrayList<Lapak> getListData(){
        ArrayList<Lapak> list = new ArrayList<>();
        for (String[] aData : data) {
            Lapak lapak = new Lapak();
            lapak.setNama_lapak(aData[0]);
            lapak.setLokasi(aData[1]);
            list.add(lapak);
        }
        return list;
    }
}
