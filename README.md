# Covid19-Tracker-Global-Project

This is a covid19-tracker API project helps to get the actual data around the globe. All countries with their respective data comes through and API that updates in every 10 minutes.

API link --> https://corona.lmao.ninja/

## Different types of responses:

These two responses we can use for collecting global data or we can use country specific data.

### For Globally Colleted Data

I used this API as global data: https://disease.sh/v3/covid-19/all

**Response:**
```
{
  "updated": 1643870376080,
  "cases": 385460113,
  "todayCases": 349796,
  "deaths": 5719305,
  "todayDeaths": 1163,
  "recovered": 305514949,
  "todayRecovered": 233968,
  "active": 74225859,
  "critical": 91867,
  "casesPerOneMillion": 49451,
  "deathsPerOneMillion": 733.7,
  "tests": 5153827495,
  "testsPerOneMillion": 654108.25,
  "population": 7879166024,
  "oneCasePerPeople": 0,
  "oneDeathPerPeople": 0,
  "oneTestPerPeople": 0,
  "activePerOneMillion": 9420.52,
  "recoveredPerOneMillion": 38775.04,
  "criticalPerOneMillion": 11.66,
  "affectedCountries": 225
}
```

###For Individual Country Data

I used this API as global data: https://disease.sh/v3/covid-19/countries. It will give all the 220+ countries data or the below link which just adds a country name after the link gives you that particular country data.

If we use this api https://disease.sh/v3/covid-19/countries/india 

**As a response we get:**
```
{
  "updated": 1643870376082,
  "country": "India",
  "countryInfo": {
    "_id": 356,
    "iso2": "IN",
    "iso3": "IND",
    "lat": 20,
    "long": 77,
    "flag": "https://disease.sh/assets/img/flags/in.png"
  },
  "cases": 41803318,
  "todayCases": 0,
  "deaths": 498987,
  "todayDeaths": 0,
  "recovered": 39770414,
  "todayRecovered": 0,
  "active": 1533917,
  "critical": 8944,
  "casesPerOneMillion": 29827,
  "deathsPerOneMillion": 356,
  "tests": 734192614,
  "testsPerOneMillion": 523850,
  "population": 1401531962,
  "continent": "Asia",
  "oneCasePerPeople": 34,
  "oneDeathPerPeople": 2809,
  "oneTestPerPeople": 2,
  "activePerOneMillion": 1094.46,
  "recoveredPerOneMillion": 28376.39,
  "criticalPerOneMillion": 6.38
}
```








