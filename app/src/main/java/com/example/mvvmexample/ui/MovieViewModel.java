package com.example.mvvmexample.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmexample.model.MovieModel;
import com.example.mvvmexample.model.data.MovieRepository;

import java.util.List;


public class MovieViewModel extends ViewModel {
     MutableLiveData<List<MovieModel>> movieNameMutableLiveData = new MutableLiveData<>();
     private MovieRepository movieRepository = MovieRepository.getInstance();

     public void getMovies(){
         movieNameMutableLiveData = movieRepository.getMovies();
     }
}
