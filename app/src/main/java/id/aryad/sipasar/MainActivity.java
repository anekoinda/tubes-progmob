package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        User User = new User();

        EditText username_input = (EditText) findViewById(R.id.username_input);
        EditText pass_input = (EditText) findViewById(R.id.pass_input);

        User.setUsername(username_input.getText().toString());
        User.setPassword(pass_input.getText().toString());
        daoUser.Validasi(User);
        Toast.makeText(this, User.isValid() ? "Selamat datang, " + User.getUsername() : "Username atau Password salah", Toast.LENGTH_SHORT).show();

        if (User.isValid() == true) {
            Intent intent = new Intent(MainActivity.this, SearchLapak.class);
            startActivity(intent);
        }
    }


}