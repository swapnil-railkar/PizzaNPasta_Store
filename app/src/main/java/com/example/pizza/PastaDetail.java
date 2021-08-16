package com.example.pizza;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class PastaDetail extends AppCompatActivity {
    public static final String EXTRA_PASTA_ID = "pastaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.pasta_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int pasta_id = (Integer) getIntent().getExtras().get(EXTRA_PASTA_ID);
        int past_res = Pasta.pastas[pasta_id].getImageResourceId();
        String pasta_name = Pasta.pastas[pasta_id].getName();

        TextView textView = (TextView)findViewById(R.id.pasta_text);
        textView.setText(pasta_name);

        ImageView imageView = (ImageView) findViewById(R.id.pasta_img);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, past_res));
        imageView.setContentDescription((CharSequence) pasta_name);
    }
}