package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchLapak extends AppCompatActivity {
    EditText search_input;
    RecyclerView rvLapak;
    ArrayList<Lapak> list = new ArrayList<>();
    ListLapakAdapter lapakAdapter;

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
        ListLapakAdapter listLapakAdapter = new ListLapakAdapter(this, list);
        rvLapak.setAdapter(listLapakAdapter);
        rvLapak.setLayoutManager(new LinearLayoutManager(this));

        listLapakAdapter.setOnItemClickCallback(new ListLapakAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Lapak data) {
                showSelectedLapak(data);
            }
        });

        search_input = (EditText) findViewById(R.id.search_input);
        search_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text){
        ArrayList<Lapak> filteredList= new ArrayList<>();

        for(Lapak item: list){
            if(item.getNama_lapak().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        lapakAdapter.filterList(filteredList);
    }

    private void showSelectedLapak(Lapak lapak) {
        Toast.makeText(this, "Kamu memilih " + lapak.getNama_lapak(), Toast.LENGTH_SHORT).show();
    }
}