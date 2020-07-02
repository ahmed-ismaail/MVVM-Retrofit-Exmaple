package com.example.mvvmexample.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmexample.R;
import com.example.mvvmexample.databinding.MovieItemBinding;
import com.example.mvvmexample.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<MovieModel> moviesList = new ArrayList<>();

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemBinding movieItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.movie_item, parent, false);
        return new MovieViewHolder(movieItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
          MovieModel movieModel = moviesList.get(position);
          holder.bind(movieModel);
//        holder.movieName.setText(moviesList.get(position).getMovieName());
//        holder.movieYear.setText(moviesList.get(position).getMovieYear());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setMoviesList(List<MovieModel> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        // Since our layout file is movie_item.xml, our auto generated binding class is MovieItemBinding
        private MovieItemBinding itemBinding;

        //constructor taking a MovieItemBinding as its parameter
        public MovieViewHolder(MovieItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        //use this function to bind instance of Movie to the row
        public void bind(MovieModel movieModel) {
            itemBinding.setMovie(movieModel);
            itemBinding.executePendingBindings();
        }
    }
}
