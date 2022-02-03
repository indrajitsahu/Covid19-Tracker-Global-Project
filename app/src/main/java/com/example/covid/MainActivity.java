package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tvCases,tvRecovered, tvTodayRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvAffectedCountries, tvTests, tvPopulation, tvUpdated,
    tvCasesPerOneMillion, tvDeathsPerOneMillion, tvActivePerOneMillion, tvRecoveredPerOneMillion, tvCriticalPerOneMillion, tvTestsPerOneMillion;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            setTheme(R.style.DarkTheme);
//        }
//        else {
//            setTheme(R.style.Theme_Covid);
//        }

        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);
        tvTodayRecovered = findViewById(R.id.tvTodayRecovered);
        tvTests = findViewById(R.id.tvTests);
        tvPopulation = findViewById(R.id.tvPopulation);
        tvUpdated = findViewById(R.id.tvUpdated);
        tvCasesPerOneMillion = findViewById(R.id.tvCasesPerOneMillion);
        tvDeathsPerOneMillion = findViewById(R.id.tvDeathsPerOneMillion);
        tvActivePerOneMillion = findViewById(R.id.tvActivePerOneMillion);
        tvRecoveredPerOneMillion = findViewById(R.id.tvRecoveredPerOneMillion);
        tvCriticalPerOneMillion = findViewById(R.id.tvCriticalPerOneMillion);
        tvTestsPerOneMillion = findViewById(R.id.tvTestsPerOneMillion);

        simpleArcLoader = findViewById(R.id.loader);
        scrollView = findViewById(R.id.scrollStats);
        pieChart = findViewById(R.id.piechart);

        fetchData();
    }

    private void fetchData() {

        String url  = "https://corona.lmao.ninja/v2/all/";

        simpleArcLoader.start();

            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject jsonObject = new JSONObject(response.toString());

                        tvCases.setText(jsonObject.getString("cases"));
                        tvRecovered.setText(jsonObject.getString("recovered"));
                        tvCritical.setText(jsonObject.getString("critical"));
                        tvActive.setText(jsonObject.getString("active"));
                        tvTodayCases.setText(jsonObject.getString("todayCases"));
                        tvTotalDeaths.setText(jsonObject.getString("deaths"));
                        tvTodayDeaths.setText(jsonObject.getString("todayDeaths"));
                        tvAffectedCountries.setText(jsonObject.getString("affectedCountries"));
                        tvTodayRecovered.setText(jsonObject.getString("todayRecovered"));
                        tvTests.setText(jsonObject.getString("tests"));
                        tvPopulation.setText(jsonObject.getString("population"));
                        tvUpdated.setText(jsonObject.getString("updated"));
                        tvTestsPerOneMillion.setText(jsonObject.getString("testsPerOneMillion"));
                        tvCasesPerOneMillion.setText(jsonObject.getString("casesPerOneMillion"));
                        tvDeathsPerOneMillion.setText(jsonObject.getString("deathsPerOneMillion"));
                        tvActivePerOneMillion.setText(jsonObject.getString("activePerOneMillion"));
                        tvRecoveredPerOneMillion.setText(jsonObject.getString("recoveredPerOneMillion"));
                        tvCriticalPerOneMillion.setText(jsonObject.getString("criticalPerOneMillion"));

                        pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                        pieChart.addPieSlice(new PieModel("Recoverd",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
                        pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));
                        pieChart.addPieSlice(new PieModel("Active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
                        pieChart.startAnimation();

                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                        scrollView.setVisibility(View.VISIBLE);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        simpleArcLoader.stop();
                        simpleArcLoader.setVisibility(View.GONE);
                        scrollView.setVisibility(View.VISIBLE);
                    }

                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void goTrackCountries(View view) {
//        Intent intent = new Intent(MainActivity.this, AffectedCountries.class);
//        startActivity(intent);
        // ------- OR -------
        startActivity(new Intent(getApplicationContext(), AffectedCountries.class));
    }
}