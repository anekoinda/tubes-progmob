package id.aryad.sipasar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataLapak {


    public static String[][] data = new String[][]{
            {"Lapak Ableh", "Pak Abdul Ableh", "Blok A No 12", "2021-05-01"},
            {"Warung Aya", "Bu Aya Ningsih","Blok B No 24", "2021-05-01"},
            {"Lapak Bu Indah", "Bu Indah","Blok C No 67", "2021-05-01"},
            {"Warung Pak Eko", "Pak Eko Mustofa", "Blok B No 8", "2021-05-01"},
            {"Babi Guling Men Agus", "Bu Agus", "Blok D No 10", "2021-05-01"},
            {"Warung Betutu Galuh", "Pak Solihin", "Blok A No 42", "2021-05-01"},
            {"Grosiran Nana", "Bu Nananini", "Blok B No 32", "2021-05-01"},
            {"Perkakas Jaya", "Pak Kim", "Blok C No 54", "2021-05-01"},
            {"Elektronik Koh Atong", "Pak Atong", "Blok A No 99", "2021-05-01"},
            {"Pisang Keju Ceria", "Bu Dewi", "Blok A No 55", "2021-05-01"},
            {"Lapak Pak Nasri", "Pak Nasri", "Blok C No 42", "2021-05-01"},
            {"Lapak Bu Sumerni", "Bu Wayan Sumerni", "Blok E No 10", "2021-05-01"}
    };

    public static ArrayList<Lapak> getListData(){
        ArrayList<Lapak> list = new ArrayList<>();
        for (String[] aData : data) {
            Lapak lapak = new Lapak();
            lapak.setNama_lapak(aData[0]);
            lapak.setLokasi(aData[1]);
            lapak.setNama_pemilik(aData[2]);
            lapak.setTanggal(aData[3]);
            list.add(lapak);
        }
        return list;
    }
}
