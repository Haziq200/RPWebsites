package sg.edu.rp.dmsd.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnCategory;
    Spinner spnSubCategory;
    Button btnGo;
    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCategory = findViewById(R.id.spinnerCat);
        spnSubCategory = findViewById(R.id.spinnerSub);
        btnGo = findViewById(R.id.buttonGo);

        alCategory = new ArrayList<>();
        aaCategory = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,alCategory);
        spnCategory.setAdapter(aaCategory);


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos1 = spnCategory.getSelectedItemPosition();
                int pos2 = spnSubCategory.getSelectedItemPosition();
                String [][] site={{"https://www.rp.edu.sg/","https://www.rp.edu.sg/student-life"},{"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"}};
                String siteURL = site[pos1][pos2];
                Intent intent = new Intent(getBaseContext(),WebActivity.class);
                intent.putExtra("URL",siteURL + "");
                startActivity(intent);

                if(pos1 == 0 && pos2 == 0 ){
                    String url = "https://www.rp.edu.sg/";
                    intent.putExtra("URL",url);
                }else if(pos1 == 0 && pos2 == 1){
                    String url = "https://www.rp.edu.sg/student-life";
                    intent.putExtra("URL",url);
                }else if(pos1 == 1 && pos2 == 0){
                    String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    intent.putExtra("URL",url);
                }else{
                    String url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    intent.putExtra("URL",url);
                }
                  startActivity(intent);
            }
        });

       spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               switch (i) {
                   case 0:
                       alCategory.clear();
                       String[] strCategory = getResources().getStringArray(R.array.Category);
                       alCategory.addAll(Arrays.asList(strCategory));
                       aaCategory.notifyDataSetChanged();
                       break;
                   case 1:
                       alCategory.clear();
                       String[] strcategory1 = getResources().getStringArray(R.array.Sub_Category);
                       alCategory.addAll(Arrays.asList(strcategory1));
                       aaCategory.notifyDataSetChanged();
                       break;

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

    }
}
