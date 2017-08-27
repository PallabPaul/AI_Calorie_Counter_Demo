package com.example.rnky39.demoys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class reguser extends AppCompatActivity implements OnItemSelectedListener, AdapterView.OnItemClickListener {

    EditText e_name, e_username, e_password,e_current_weight, e_goal_weight;
    Spinner e_lifestyle;
    private ProgressBar spinner;
    String name, username, password, lifestyle,current_weight,goal_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reguser);
        System.out.println("reached here1232");
        e_name=(EditText) findViewById(R.id.name);
        e_username=(EditText) findViewById(R.id.r_userName);
        e_password=(EditText) findViewById(R.id.password);
        e_lifestyle=(Spinner) findViewById(R.id.lifestyle);
        e_current_weight = (EditText) findViewById(R.id.cweight);
        e_goal_weight = (EditText) findViewById(R.id.gweight);
        e_lifestyle.setOnItemSelectedListener(this);
        spinner = (ProgressBar)findViewById(R.id.progressBar2);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner.setVisibility(View.GONE);
    }

    public  void reguser1(View view){
        System.out.println("reached here reguser");
        this.name=e_name.getText().toString();
        this.username = e_username.getText().toString();
        this.password=e_password.getText().toString();
        this.current_weight=e_current_weight.getText().toString();
        this.goal_weight=e_goal_weight.getText().toString();

        String method="reguser";
        BackgroundTask backgroundTask=new BackgroundTask(this,spinner);
        backgroundTask.execute(method,name,username,password,lifestyle,current_weight,goal_weight);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        this.lifestyle=""+String.valueOf(e_lifestyle.getSelectedItem());
        Log.v("com.example.rnky39.demo","spinner changed to"+lifestyle);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        this.lifestyle = "Relaxed";
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        this.lifestyle=""+String.valueOf(e_lifestyle.getSelectedItem());
        Log.v("com.example.rnky39.demo","spinner changed to"+lifestyle);
    }
}
