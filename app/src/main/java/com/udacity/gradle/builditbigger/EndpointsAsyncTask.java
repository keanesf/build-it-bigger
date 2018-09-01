package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.keanesf.androidLibrary.JokeDisplayActivity;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.backend.jokeApi.model.JokeBean;


import java.io.IOException;


class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static final String TAG = "EndpointsAsyncTask";
    private static JokeApi jokeApi = null;
    private Context context;
    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }
    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (jokeApi == null) {
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            jokeApi = builder.build();
        }
        try {
            //return jokeApi.putJoke(new JokeBean()).execute().getJoke();
            return jokeApi.getJoke().execute().getJoke();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            return "";
        }
    }
    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.INTENT_JOKE, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}