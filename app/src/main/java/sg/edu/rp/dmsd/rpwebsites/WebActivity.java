package sg.edu.rp.dmsd.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class WebActivity extends AppCompatActivity {
    WebView wvPage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        wvPage = findViewById(R.id.webView);
        wvPage.setWebViewClient(new WebViewClient());

        Intent intentreceived = getIntent();

        String URL = intentreceived.getStringExtra("URL");
        Log.i("URL",URL+"");
        wvPage.loadUrl(URL);
    }
}
