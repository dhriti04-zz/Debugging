package com.codepath.debuggingchallenges.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.codepath.debuggingchallenges.R;
import com.codepath.debuggingchallenges.adapters.MoviesAdapter;
import com.codepath.debuggingchallenges.models.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MoviesActivity extends AppCompatActivity {

    private static final String API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed";

    ListView lvMovies;
    MoviesAdapter adapter;
    ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        lvMovies = (ListView) findViewById(R.id.lvMovies);

        movies = new ArrayList<>();
        // Create the adapter to convert the array to views
        adapter = new MoviesAdapter(this, movies);

        // Attach the adapter to a ListView
        lvMovies.setAdapter(adapter);

        fetchMovies();
    }


    private void fetchMovies() {
        String url = " https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY;
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    System.out.println("Hmmmmm is it ?");

                    JSONArray moviesJson = response.getJSONArray("results");
                    movies = Movie.fromJSONArray(moviesJson);
                    adapter.addAll(movies);
                } catch (JSONException e) {
                    System.out.println("Hmmmmm not working");
                    e.printStackTrace();
                }
            }
        });
    }
}
