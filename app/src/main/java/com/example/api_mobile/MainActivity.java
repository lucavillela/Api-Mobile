package com.example.api_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ResultadoApi;
    Button BtnPedirApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResultadoApi = (TextView) findViewById(R.id.ResultadoApi);
        BtnPedirApi = (Button) findViewById(R.id.BtnPedirApi);

        BtnPedirApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    //class DutoIter extends AsyncTask{ }
}