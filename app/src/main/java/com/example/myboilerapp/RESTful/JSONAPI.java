package com.example.myboilerapp.RESTful;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class JSONAPI {

    private static final String TAG = "JSONAPI";

    RequestListener mResultCallback = null;
    Context mContext;
    int ID;

    public interface RequestListener {
        void onFinished(String result, int ID);
    }

    public JSONAPI(RequestListener resultCallback, Context context, int ID){
        mResultCallback = resultCallback;
        mContext = context;
        this.ID = ID;
    }

    public void getDataVolley(String url){
        try {
            RequestQueue queue = Volley.newRequestQueue(mContext);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            mResultCallback.onFinished(response,ID);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            queue.add(stringRequest);
        }catch(Exception e){

        }
    }
}

