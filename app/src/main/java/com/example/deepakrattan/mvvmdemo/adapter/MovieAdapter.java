package com.example.deepakrattan.mvvmdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deepakrattan.mvvmdemo.R;
import com.example.deepakrattan.mvvmdemo.databinding.MovieListRowBinding;
import com.example.deepakrattan.mvvmdemo.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<Movie> movieList;


    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MovieListRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.movie_list_row, parent, false);

        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.binding.txtMovieName.setText(movie.getName());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        MovieListRowBinding binding;

        public MovieViewHolder(@NonNull MovieListRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
