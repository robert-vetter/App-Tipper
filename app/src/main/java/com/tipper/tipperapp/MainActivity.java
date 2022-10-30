package com.tipper.tipperapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button start;
    public int notification = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        //Start Button
        start=findViewById(R.id.Start);

        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lvl_of_difficulty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Title Spinner
        TextView lbl_lvldifficulty = findViewById(R.id.lvldifficulty);

        spinner.setOnItemSelectedListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item2:
                Intent intent = new Intent(MainActivity.this, GameDescription.class);
                startActivity(intent);
            /*case R.id.shareButton:
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_SUBJECT, "Check out Tipper!");
                //intent1.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.rvdevelopment");
                startActivity(Intent.createChooser(intent1, "Share Via"));
                return true;*/
            case R.id.notificationsub1:
                Toast.makeText(this, "You'll never receive a notification", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.notificationsub2:
                Toast.makeText(this, "You'll receive a notification monthly", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contact:
                Intent intent2 = new Intent(MainActivity.this, Contact.class);
                startActivity(intent2);
                return true;
            case R.id.privacypolicy:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.addCategory(Intent.CATEGORY_BROWSABLE);
                intent1.setData(Uri.parse("https://zroby05.github.io/datenschutztipper1/home.html"));
                startActivity(intent1);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}