package com.example.conversor2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private double taxaDeConversao = 5.86;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etDolar = findViewById(R.id.etDolar);
        Button btnConverter = findViewById(R.id.btnConverter);
        TextView tvResultado = findViewById(R.id.tvResultado);

        carregarTaxaDeConversao();

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorDolarString = etDolar.getText().toString();

                if (!valorDolarString.isEmpty()) {
                    double valorDolar = Double.parseDouble(valorDolarString);
                    double resultado = valorDolar * taxaDeConversao;
                    tvResultado.setText(String.format("Resultado: R$ %.2f", resultado));
                } else {
                    tvResultado.setText("Por favor, insira um valor válido.");
                }
            }
        });
    }

    private void carregarTaxaDeConversao() {
        new GetExchangeRateTask().execute("https://openexchangerates.org/api/latest.json?app_id=8cc43a9e88a44c948a7cb81f61200c14");
    }

    private class GetExchangeRateTask extends AsyncTask<String, Void, Double> {
        @Override
        protected Double doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setConnectTimeout(5000);
                urlConnection.setReadTimeout(5000);

                int responseCode = urlConnection.getResponseCode();
                if (responseCode != 200) {
                    return null;
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject jsonResponse = new JSONObject(response.toString());

                return jsonResponse.getJSONObject("rates").getDouble("BRL");

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Double result) {
            if (result != null) {
                taxaDeConversao = result;
            } else {
                
                Toast.makeText(MainActivity.this, "Erro ao obter taxa de conversão. Tente novamente mais tarde.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
