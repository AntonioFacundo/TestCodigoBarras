package iplace.net.testcodigobarras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button leer;
    private Button generar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leer = findViewById(R.id.btnLeer);
        leer.setOnClickListener(this);
        generar = findViewById(R.id.btnQR);
        generar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLeer:
                leerCodigo();
                break;
            case R.id.btnQR:
                generarQR();
                break;
        }
    }

    private void generarQR() {
        Intent intent = new Intent(getApplicationContext(), GenerarQRActivity.class);
        startActivity(intent);
    }

    private void leerCodigo() {
        Intent intent = new Intent(getApplicationContext(), LeerCodigoActivity.class);
        startActivity(intent);
    }
}
