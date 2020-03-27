package com.example.myapp;

import android.app.Activity;
import android.app.ApplicationErrorReport;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;

public class Server {
    private final String URL_GET_USERS = "https://jsonplaceholder.typicode.com/users";
    private RequestQueue requestQueue;
    private Context context;
    //singleton = "1 class creates ONLY 1 object"
    private static Server instance;
    public static synchronized Server getInstance(Context context) {
        if (instance == null) {
            instance = new Server();
        }
        instance.context = context;
        return instance;
    }
    private Server() {
      System.out.println("constructor...");
    }
    private  <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public void sendGETRequest(final IMyActivity activity) {
        final ArrayList<User> users = new ArrayList<>();
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, URL_GET_USERS, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray responseArray) {
                        try {
                            System.out.println("haha");
                            for (int i = 0; i < responseArray.length(); i++) {
                                User user = User.createFromJSONObject(responseArray.getJSONObject(i));
                                users.add(user);
                            }
                            ((Activity)activity).runOnUiThread(new Runnable() {
                                public void run() {
                                    activity.getResponse(users, null);
                                }
                            });
                        } catch (final Exception e){

                            ((Activity)activity).runOnUiThread(new Runnable() {
                                public void run() {
                                    //error ? result is NULL and e is NOT NULL
                                    System.out.println("failed sending request"+e.toString());
                                    activity.getResponse(null, e.toString());
                                }
                            });
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(final VolleyError error) {
                        ((Activity)activity).runOnUiThread(new Runnable() {
                            public void run() {
                                //error ? result is NULL and e is NOT NULL
                                System.out.println("failed sending request"+error.toString());
                                activity.getResponse(null, error.toString());
                            }
                        });
                    }
                });
        this.addToRequestQueue(jsonObjectRequest);
    }
    /*
    public void sendGETRequest(final IMyActivity activity) {
        Request request = new Request.Builder()
                .url(URL_GET_USERS)
                .build();
        Call call = client.newCall(request);
        final ArrayList<User> users = new ArrayList<>();
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response) {
                if(response.code() == 404 ) {
                    ((Activity)activity).runOnUiThread(new Runnable() {
                        public void run() {
                            activity.getResponse(null, "Address not found");
                        }
                    });
                    return;
                }
                //success
                System.out.println("success");//success, but I want to get a list of Photo's object ?
                try {
                    String jsonString = response.body().string();
                    JSONArray responseArray = new JSONArray(jsonString);
                    for (int i = 0; i < responseArray.length(); i++) {
                        User user = User.createFromJSONObject(responseArray.getJSONObject(i));
                        users.add(user);
                    }
                    ((Activity)activity).runOnUiThread(new Runnable() {
                        public void run() {
                            activity.getResponse(users, null);
                        }
                    });
                } catch (final Exception e){

                    ((Activity)activity).runOnUiThread(new Runnable() {
                        public void run() {
                            //error ? result is NULL and e is NOT NULL
                            System.out.println("failed sending request"+e.toString());
                            activity.getResponse(null, e.toString());
                        }
                    });
                }

            }

            public void onFailure(Call call, final IOException e) {
                ((Activity)activity).runOnUiThread(new Runnable() {
                    public void run() {
                        //error ? result is NULL and e is NOT NULL
                        System.out.println("failed sending request"+e.toString());
                        activity.getResponse(null, e.toString());
                    }
                });
            }
        });
    }
    */
}
