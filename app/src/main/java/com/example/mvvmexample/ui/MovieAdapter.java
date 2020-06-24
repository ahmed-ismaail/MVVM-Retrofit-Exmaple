package com.example.mvvmexample.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmexample.R;
import com.example.mvvmexample.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    List<MovieModel> moviesList = new ArrayList<>();

    @NonNull
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        holder.movieName.setText(moviesList.get(position).getMovieName());
        holder.movieYear.setText(moviesList.get(position).getMovieYear());
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
        TextView movieName, movieYear;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            movieName = itemView.findViewById(R.id.movieName_textView);
            movieYear = itemView.findViewById(R.id.movieYear_textView);
        }
    }
}
