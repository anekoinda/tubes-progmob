package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PembayaranLapak extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView tvName, harga, btnBayar, tanggal, tvTanggal;
    String namaLapak, tanggalLapak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran_lapak);

        btnBayar = findViewById(R.id.btnBayar);
        tvName = findViewById(R.id.tvName);
        tvTanggal = findViewById(R.id.tvTanggal);
        namaLapak=getIntent().getStringExtra("tvName");
        tanggalLapak=getIntent().getStringExtra("tvTanggal");

        tvName.setText(namaLapak);
        tvTanggal.setText(tanggalLapak);

        Spinner spinner = (Spinner) findViewById(R.id.pilihPeriode);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.periode, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog(){
        SuksesDialog suksesDialog = new SuksesDialog();
        suksesDialog.show(getSupportFragmentManager(), "sukses dialog");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        harga = findViewById(R.id.harga);
        String text = parent.getItemAtPosition(position).toString();
        if (position == 1){
            harga.setText("Rp. 200.000");
        }else if(position == 2) {
            harga.setText("Rp. 1.200.000");
        }else if(position == 3){
            harga.setText("Rp.2.400.000");
        }else if (position == 4){
            harga.setText("Rp. 4.800.000");
        }else {
            harga.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}