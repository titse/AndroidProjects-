package com.tiffany.beeradvisor;

        import android.support.v4.widget.TextViewCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Spinner;
        import android.widget.TextView;
        import java.util.List;

public class FindBeer extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }
    public void onClickFindBeer(View view){
        //get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);
        //Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        //Get the selcted item in teh Spinner
        String beerType= String.valueOf(color.getSelectedItem());
        //Get a List of Brands
        List<String> brandList = expert.getBrands(beerType);
        //build a string using the values from a list
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brandMake : brandList){
            brandsFormatted.append(brandMake).append("\n");
        }
        //set the beer type
        brands.setText(brandsFormatted);

    }

}
