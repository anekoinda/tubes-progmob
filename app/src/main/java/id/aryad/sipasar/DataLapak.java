package id.aryad.sipasar;

import java.util.ArrayList;

public class DataLapak {
    public static String[][] data = new String[][]{
            {"Lapak Ableh", "Blok A No 12"},
            {"Warung Aya", "Blok B No 12"}
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
