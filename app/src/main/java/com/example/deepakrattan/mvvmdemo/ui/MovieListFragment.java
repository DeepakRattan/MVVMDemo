package com.example.deepakrattan.mvvmdemo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deepakrattan.mvvmdemo.R;
import com.example.deepakrattan.mvvmdemo.adapter.MovieAdapter;
import com.example.deepakrattan.mvvmdemo.databinding.FragmentMovieListBinding;
import com.example.deepakrattan.mvvmdemo.model.Movie;
import com.example.deepakrattan.mvvmdemo.model.MovieResponse;
import com.example.deepakrattan.mvvmdemo.view_model.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MovieListFragment extends Fragment {
    RecyclerView.LayoutManager layoutManager;
    MovieAdapter movieAdapter;
    List<Movie> movieList = new ArrayList<>();
    MovieListViewModel movieListViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentMovieListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false);
        View view = binding.getRoot();
        movieAdapter = new MovieAdapter(movieList);
        layoutManager = new LinearLayoutManager(getContext());
        binding.rvMovies.setLayoutManager(layoutManager);
        binding.rvMovies.setAdapter(movieAdapter);
        return view;
    }

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        movieListViewModel.init();
        movieListViewModel.getMovies().observe(this, new Observer<MovieResponse>() {

            // Every time the movie data is updated, the onChanged() callback is
            // invoked, and the UI is refreshed.
            @Override
            public void onChanged(MovieResponse movieResponse) {
                movieList.addAll(movieResponse.getMovieList());
                movieAdapter.notifyDataSetChanged();
            }
        });


    }
}
