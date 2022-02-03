package com.example.covid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int positionCountry;
    TextView tvCountry, tvCases, tvTodayCases, tvTotalDeaths, tvTodayDeaths, tvRecovered,
            tvTodayRecovered, tvActive, tvCritical, tvCasesPerOneMillion, tvDeathsPerOneMillion,
            tvTests, tvTestsPerOneMillion, tvPopulation, tvContinent, tvOneCasePerPeople, tvOneDeathPerPeople,
            tvActivePerOneMillion, tvRecoveredPerOneMillion, tvCriticalPerOneMillion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Details of " + AffectedCountries.countryModelList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvTodayRecovered = findViewById(R.id.tvTodayRecovered);
        tvActive = findViewById(R.id.tvActive);
        tvCritical = findViewById(R.id.tvCritical);
        tvCasesPerOneMillion = findViewById(R.id.tvCasesPerOneMillion);
        tvDeathsPerOneMillion = findViewById(R.id.tvDeathsPerOneMillion);
        tvTests = findViewById(R.id.tvTests);
        tvTestsPerOneMillion = findViewById(R.id.tvTestsPerOneMillion);
        tvPopulation = findViewById(R.id.tvPopulation);
        tvContinent = findViewById(R.id.tvContinent);
        tvOneCasePerPeople = findViewById(R.id.tvOneCasePerPeople);
        tvOneDeathPerPeople = findViewById(R.id.tvOneDeathPerPeople);
        tvActivePerOneMillion = findViewById(R.id.tvActivePerOneMillion);
        tvRecoveredPerOneMillion = findViewById(R.id.tvRecoveredPerOneMillion);
        tvCriticalPerOneMillion = findViewById(R.id.tvCriticalPerOneMillion);

        tvCountry.setText(AffectedCountries.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelList.get(positionCountry).getCases());
        tvTodayCases.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayCases());
        tvTodayDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayDeaths());
        tvTotalDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getDeaths());
        tvRecovered.setText(AffectedCountries.countryModelList.get(positionCountry).getRecovered());
        tvTodayRecovered.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayRecovered());
        tvActive.setText(AffectedCountries.countryModelList.get(positionCountry).getActive());
        tvCritical.setText(AffectedCountries.countryModelList.get(positionCountry).getCritical());
        tvCasesPerOneMillion.setText(AffectedCountries.countryModelList.get(positionCountry).getCasesPerOneMillion());
        tvDeathsPerOneMillion.setText(AffectedCountries.countryModelList.get(positionCountry).getDeathsPerOneMillion());
        tvTests.setText(AffectedCountries.countryModelList.get(positionCountry).getTests());
        tvTestsPerOneMillion.setText(AffectedCountries.countryModelList.get(positionCountry).getTestsPerOneMillion());
        tvPopulation.setText(AffectedCountries.countryModelList.get(positionCountry).getPopulation());
        tvContinent.setText(AffectedCountries.countryModelList.get(positionCountry).getContinent());
        tvOneCasePerPeople.setText(AffectedCountries.countryModelList.get(positionCountry).getOneCasePerPeople());
        tvOneDeathPerPeople.setText(AffectedCountries.countryModelList.get(positionCountry).getOneDeathPerPeople());
        tvActivePerOneMillion.setText(AffectedCountries.countryModelList.get(positionCountry).getActivePerOneMillion());
        tvRecoveredPerOneMillion.setText(AffectedCountries.countryModelList.get(positionCountry).getRecoveredPerOneMillion());
        tvCriticalPerOneMillion.setText(AffectedCountries.countryModelList.get(positionCountry).getCriticalPerOneMillion());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}
