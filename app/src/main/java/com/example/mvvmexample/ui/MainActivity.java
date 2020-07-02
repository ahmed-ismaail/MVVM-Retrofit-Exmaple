package com.example.mvvmexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmexample.R;
import com.example.mvvmexample.databinding.ActivityMainBinding;
import com.example.mvvmexample.model.MovieModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //databinding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //connect viewModel with main activity
        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.getMovies();

        RecyclerView recyclerView = binding.recycler;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final MovieAdapter movieAdapter = new MovieAdapter();
        recyclerView.setAdapter(movieAdapter);

        movieViewModel.movieNameMutableLiveData.observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                movieAdapter.setMoviesList(movieModels);
            }
        });

    }
}
