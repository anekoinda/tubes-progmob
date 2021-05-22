package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView btnMulaiSession = (TextView) findViewById(R.id.btnLogin);
        btnMulaiSession.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MulaiSession();
            }
        });
    }

    private void MulaiSession(){
        daoUser daoUser = new daoUser();

        EditText username_input = (EditText) findViewById(R.id.username_input);
        EditText pass_input = (EditText) findViewById(R.id.pass_input);

        String username = username_input.getText().toString();
        String password = pass_input.getText().toString();

        daoUser auth = daoUser.getInstance();
        User tryLogin = auth.login(getApplicationContext(), username, password);

        if (tryLogin == null) {
            // Gagal login
            Toast.makeText(getApplicationContext(), "Username atau password salah.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (tryLogin.getRole() != AdminRole.PEGAWAI) {
            // Salah role
            Toast.makeText(getApplicationContext(), "Maaf, Anda bukan pegawai.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Berhasil login
        Intent _intent = new Intent(getApplicationContext(), SearchLapak.class);
        startActivity(_intent);
        finish();
    }
}