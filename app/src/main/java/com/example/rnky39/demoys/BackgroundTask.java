package com.example.rnky39.demoys;

/**
 * Created by rnky39 on 7/12/17.
 */
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by ashu on 16-Apr-16.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {

    Context ctx;
    ProgressBar pd;
    private String username;
    private ArrayList<String> user_data;
    private ArrayList<String> user_info;
    BackgroundTask(Context ctx, ProgressBar progress){
        this.ctx=ctx;
        this.pd = progress;
    }

    protected String doInBackground(String... params) {

        if (params.length > 3){ // register new user or save_data
            //Change your IP Address HERE
            Log.v("com.example.rnky39.demo","params length:"+params.length);
            String method= params[0];
            if(method.equals("reguser")) {
                String reg_url="https://damp-oasis-37839.herokuapp.com/register.php";
                Log.v("com.example.rnky39.demo", "In reguser");
                Log.v("com.example.rnky39.demo", "lifestyle:"+params[4]);

                //Toast.makeText(ctx, "In reguser", Toast.LENGTH_LONG).shniralow();
                String name = params[1];
                this.username = name;
                String username = params[2];
                String password = params[3];
                String lifestyle = ""+params[4];
                String current_weight = params[5];
                String goal_weight = params[6];

                Log.v("com.example.rnky39.demo", "Posting");
                Log.v("com.example.rnky39.demo", name);
                try {
                    URL url = new URL(reg_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    //httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    OutputStream out = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new OutputStreamWriter(out, "UTF-8"));
                    String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                            URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                            URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&" +
                            URLEncoder.encode("lifestyle", "UTF-8") + "=" + URLEncoder.encode(lifestyle, "UTF-8")  + "&" +
                            URLEncoder.encode("current_weight", "UTF-8") + "=" + URLEncoder.encode(current_weight, "UTF-8")  + "&" +
                            URLEncoder.encode("goal_weight", "UTF-8") + "=" + URLEncoder.encode(goal_weight, "UTF-8");

                    Log.v("com.example.rnky39.demo", data);
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    out.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK)
                        return "" + responseCode;
                    else {
                        return "" + responseCode;
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } // end reguser method
            else if(method.equals("save_data")){ //begin save_data method
                String reg_url="https://damp-oasis-37839.herokuapp.com/calories.php";
                String username = params[1];
                this.username  = username;
                String food = params[2];
                String calories = params[3];
                Log.v("com.example.rnky39.demo","Save Data");
                Log.v("com.example.rnky39.demo",username);
                Log.v("com.example.rnky39.demo",calories);

                try {
                    URL url = new URL(reg_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    //httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    OutputStream out = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new OutputStreamWriter(out, "UTF-8"));
                    String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                            URLEncoder.encode("food", "UTF-8") + "=" + URLEncoder.encode(food, "UTF-8") + "&" +
                            URLEncoder.encode("calories", "UTF-8") + "=" + URLEncoder.encode(calories, "UTF-8");
                    Log.v("com.example.rnky39.demo", data);
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    out.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK)
                        return "i" + responseCode;
                    else {
                        return "" + responseCode;
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

        } //end params>3
        else{ // sign in or get data
            if(params[0].equals("login")){ // login
                String username = params[1];
                this.username = username;
                String password = params[2];
                Log.v("com.example.rnky39.demo", "Sign-In");
                Log.v("com.example.rnky39.demo", username);
                Log.v("com.example.rnky39.demo", password);
                String reg_url="https://damp-oasis-37839.herokuapp.com/login.php";
                try {
                    URL url = new URL(reg_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    //httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    OutputStream out = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    BufferedWriter bufferedWriter = new BufferedWriter(
                            new OutputStreamWriter(out, "UTF-8"));
                    String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                            URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    Log.v("com.example.rnky39.demo", data);
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    out.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.v("com.example.rnky39.demo","respCode"+responseCode);
                    getUserData(this.username);
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        return ""+responseCode;
                    }
                    else {
                        return ""+ responseCode;
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            } // end login
            else if(params[0].equals("get_data")){//
                getUserData(params[1]);
                return ""+200;
            }
        }//end login or get_data
        return null;
    }// end method

    private void getUserData(String user){
        String usern = user;
        this.username = usern;
        getUserInfo(this.username);
        Log.v("com.example.rnky39.demo", "Get Data");
        Log.v("com.example.rnky39.demo", this.username);
        String reg_url="https://damp-oasis-37839.herokuapp.com/data.php"+"?username="+usern;
        try {
            URL url = new URL(reg_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            String line = "";

            InputStreamReader isr = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            String response = sb.toString();
            Log.v("com.example.rnky39.demo", ""+response);
            isr.close();
            reader.close();
            try {
                ArrayList<String> list = new ArrayList<String>();
                JSONArray jsonArray = new JSONArray(response);
                if (jsonArray != null) {
                    int len = jsonArray.length();
                    for (int i=0;i<len;i++){
                        list.add(jsonArray.get(i).toString());
                    }
                }
                this.user_data = list;
            }catch(JSONException e){
                this.user_data=null;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            this.user_data = null;
        } catch (IOException e) {
            e.printStackTrace();
            this.user_data = null;
        }
    }

    private void getUserInfo(String user){
        String usern = user;
        Log.v("com.example.rnky39.demo", "Get Data");
        Log.v("com.example.rnky39.demo", this.username);
        String reg_url="https://damp-oasis-37839.herokuapp.com/user.php"+"?username="+usern;
        try {
            URL url = new URL(reg_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            String line = "";

            InputStreamReader isr = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            String response = sb.toString();
            Log.v("com.example.rnky39.demo", ""+response);
            isr.close();
            reader.close();
            try {
                ArrayList<String> list = new ArrayList<String>();
                JSONArray jsonArray = new JSONArray(response);
                if (jsonArray != null) {
                    int len = jsonArray.length();
                    for (int i=0;i<len;i++){
                        list.add(jsonArray.get(i).toString());
                    }
                }
                this.user_info = list;
            }catch(JSONException e){
                this.user_info=null;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            this.user_info = null;
        } catch (IOException e) {
            e.printStackTrace();
            this.user_info = null;
        }
    }


    @Override
    protected void onPostExecute(String result) {
        pd.setVisibility(View.GONE);

        if(result !=null){
            if(result.equals("200")){
                Toast.makeText(ctx, "Success", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(ctx,HomeScreen.class);
                intent.putExtra("username",this.username);
                intent.putExtra("user_data",this.user_data);
                intent.putExtra("user_info",this.user_info);
                ctx.startActivity(intent);
            }else if(result.equals("i200")){
                Toast.makeText(ctx, "Saved", Toast.LENGTH_LONG).show();
            }else if(result.equals("304")){
                Toast.makeText(ctx, "Log In Failed", Toast.LENGTH_LONG).show();
            }else{

            }
        }else{
            Toast.makeText(ctx, "Error Failed.", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
