package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PembayaranLapak extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView tvName;
    String namaLapak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran_lapak);

        tvName = findViewById(R.id.tvName);
        namaLapak=getIntent().getStringExtra("tvName");

        tvName.setText(namaLapak);

        //Spinner spinner = (Spinner) findViewById(R.id.pilihPeriode);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.periode, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}