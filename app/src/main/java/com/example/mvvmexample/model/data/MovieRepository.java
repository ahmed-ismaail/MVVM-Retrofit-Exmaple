package com.example.mvvmexample.model.data;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmexample.model.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository moviesRespository;

    public static MovieRepository getInstance() {
        if (moviesRespository == null) {
            moviesRespository = new MovieRepository();
        }
        return moviesRespository;
    }

    public MutableLiveData<List<MovieModel>>  getMovies() {
        final MutableLiveData<List<MovieModel>> movieNameMutableLiveData = new MutableLiveData<>();
        final List<MovieModel> moviesList = new ArrayList<>();

        RetrofitHelper.getInstance().getMovies().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                try {
                    JSONObject jsonObject = new JSONObject(Objects.requireNonNull(response.body()));
                    String statusCode = jsonObject.getString("status");

                    if (statusCode.equals("ok")) {

                        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("movies");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            MovieModel movieModel = new MovieModel();

                            movieModel.setMovieName(jsonArray.getJSONObject(i).getString("title"));
                            movieModel.setMovieYear(jsonArray.getJSONObject(i).getString("year"));

                            moviesList.add(movieModel);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                movieNameMutableLiveData.setValue(moviesList);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                movieNameMutableLiveData.setValue(null);
            }
        });
        return movieNameMutableLiveData;
    }
}
