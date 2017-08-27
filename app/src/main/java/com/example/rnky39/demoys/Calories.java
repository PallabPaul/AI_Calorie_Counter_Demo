package com.example.rnky39.demoys;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;

public class Calories extends Activity {
    String food_item = "";
    String food_cals = "";
    TextView food_text;
    private ProgressBar spinner;
    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        food_text = (TextView)findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        Log.v("com.example.rnky39.demo","saving...");
        Log.v("com.example.rnky39.demo",this.username);

        if (bundle.getString("food_item") !=null){
            String[] food_info=(bundle.getString("food_item")).split(",");
            if(food_info.length == 2){
                this.food_item=food_info[0];
                this.food_cals=food_info[1];
                spinner = (ProgressBar)findViewById(R.id.progressBar2);
                spinner.setVisibility(View.GONE);
            }
            food_text.setText(food_item+":\n"+food_cals);
        }else{
            System.out.println("NULL");
            food_text.setText("NULL");
        }
        username = bundle.getString("username");
        //this.food_item=getIntent().getStringExtra("food_item");
        //System.out.println("food_item"+food_item.toString());

        //Log.v("com.example.rnky39.demo",food_item);

    }
    public void save(View view){
        BackgroundTask backgroundTask=new BackgroundTask(this,spinner);
        backgroundTask.execute("save_data",this.username,food_item,food_cals);
    }
    public void cameraClass(View view){
        Intent intent=new Intent(this,ClassifierActivity.class);
        intent.putExtra("username",this.username);
        startActivity(intent);

    }
    public void doneLog(View view){
        BackgroundTask backgroundTask=new BackgroundTask(this,spinner);
        backgroundTask.execute("get_data",this.username);
//        Intent intent=new Intent(this,HomeScreen.class);
//        intent.putExtra("username",this.username);
//        startActivity(intent);

    }
}
