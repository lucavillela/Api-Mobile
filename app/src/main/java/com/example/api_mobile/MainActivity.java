package com.example.api_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView ResultadoApi;

    TextView InputCep;
    Button BtnPedirApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResultadoApi = (TextView) findViewById(R.id.ResultadoApi);
        BtnPedirApi = (Button) findViewById(R.id.BtnPedirApi);
        InputCep = (TextView)  findViewById(R.id.InputCep);

        BtnPedirApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DutoIter task = new DutoIter();
                String url = "https://viacep.com.br/ws/"+ InputCep.getText().toString() +"/json/";
                task.execute(url);
            }
        });
    }

    class DutoIter extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader reader = null;
            StringBuffer buffer;
            try {
                URL url = new URL(stringUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                inputStream = connection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                reader = new BufferedReader(inputStreamReader);
                buffer = new StringBuffer();
                String linha = "";

                while((linha=reader.readLine()) != null) {
                    buffer.append(linha);
                }

            } catch (MalformedURLException e){
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ResultadoApi.setText(s);
        }
    }
}