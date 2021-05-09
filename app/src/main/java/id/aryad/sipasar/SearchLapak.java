package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchLapak extends AppCompatActivity {
    private RecyclerView rvLapak;
    private ArrayList<Lapak> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_lapak);

        rvLapak = findViewById(R.id.rv_lapak);
        rvLapak.setHasFixedSize(true);

        list.addAll(DataLapak.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        ListLapakAdapter listLapakAdapter = new ListLapakAdapter(list);
        rvLapak.setAdapter(listLapakAdapter);
        rvLapak.setLayoutManager(new LinearLayoutManager(this));

        listLapakAdapter.setOnItemClickCallback(new ListLapakAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Lapak data) {
                showSelectedLapak(data);
            }
        });
    }

    private void showSelectedLapak(Lapak lapak) {
        Toast.makeText(this, "Kamu memilih " + lapak.getNama_lapak(), Toast.LENGTH_SHORT).show();
    }
}