package com.example.deepakrattan.mvvmdemo.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.deepakrattan.mvvmdemo.model.MovieResponse;
import com.example.deepakrattan.mvvmdemo.repository.MovieRepository;

/* A ViewModel object provides the data for a specific UI component,
   such as a fragment or activity.For example, the ViewModel can call other components(Repository)
   to load the data, and it can forward user requests to modify the data.
   The ViewModel doesn't know about UI components, so it isn't affected by
   configuration changes, such as recreating an activity when rotating the device.


   Source : https://developer.android.com/jetpack/docs/guide

   */

public class MovieListViewModel extends ViewModel {
    MovieRepository movieRepository;
    MutableLiveData<MovieResponse> movieResponseMutableLiveData;

    public MovieListViewModel() {
        movieRepository = new MovieRepository();
    }

    public void init() {
        if (movieResponseMutableLiveData != null) {
            return;
        }

        // MovieListViewModel communicate with MovieRepository to get the data
        movieResponseMutableLiveData = movieRepository.getMovies();
    }

    public MutableLiveData<MovieResponse> getMovies() {
        return this.movieResponseMutableLiveData;
    }


}
