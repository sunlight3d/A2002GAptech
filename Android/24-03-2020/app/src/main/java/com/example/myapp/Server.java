package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Server {
    /*
    IMyActivity activity;

    public IMyActivity getActivity() {
        return activity;
    }

    public void setActivity(IMyActivity activity) {
        this.activity = activity;
    }

     */

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public void sendGETRequest(final IMyActivity activity) {
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/photos")
                .build();
        Call call = client.newCall(request);
        final ArrayList<Photo> photos = new ArrayList<>();
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response) {
                //success
                System.out.println("success");//success, but I want to get a list of Photo's object ?
                try {
                    String jsonString = response.body().string();
                    //JSONObject Jobject = new JSONObject(jsonData);
                    JSONArray responseArray = new JSONArray(jsonString);
                    for (int i = 0; i < responseArray.length(); i++) {
                        Photo photo = Photo.createFromJSONObject(responseArray.getJSONObject(i));
                        //System.out.println("haha"); //ok so now how to add id, title, url,... to my Object
                        photos.add(photo);
                    }
                    ((Activity)activity).runOnUiThread(new Runnable() {
                        public void run() {
                            activity.getResponse(photos, null);
                        }
                    });
                } catch (Exception e){
                    System.out.println("failed sending request"+e.toString());
//                    Toast.makeText(context,
//                            "failed sending request"+e.toString(),
//                            Toast.LENGTH_LONG).show();
                }

            }

            public void onFailure(Call call, IOException e) {
                System.out.println("failed");
            }
        });
    }
}
