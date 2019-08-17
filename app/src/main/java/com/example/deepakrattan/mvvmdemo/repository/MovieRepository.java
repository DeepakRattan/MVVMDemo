package com.example.deepakrattan.mvvmdemo.repository;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;

import com.example.deepakrattan.mvvmdemo.model.MovieResponse;
import com.example.deepakrattan.mvvmdemo.network.ApiClient;
import com.example.deepakrattan.mvvmdemo.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/* A first idea for implementing the ViewModel might involve directly calling the Webservice
   to fetch the data and assign this data to our LiveData object. This design works, but by using it,
   our app becomes more and more difficult to maintain as it grows. It gives too much responsibility
   to the MovieListViewModel class, which violates the separation of concerns principle.
   Additionally, the scope of a ViewModel is tied to an Activity or Fragment lifecycle,
   which means that the data from the Webservice is lost when the associated UI object's
   lifecycle ends. This behavior creates an undesirable user experience.

   Instead, our ViewModel delegates the data-fetching process to a new module, a repository.

   Repository modules handle data operations. They provide a clean API so that the rest of
   the app can retrieve this data easily. They know where to get the data from and what API calls
   to make when data is updated. You can consider repositories to be mediators between different
   data sources, such as persistent models, web services, and caches.

   Repository abstracts the data sources from the rest of the app. Now, our MovieListViewModel
   doesn't know how the data is fetched, so we can provide the view model with data obtained from
   several different data-fetching implementations.

   Source : https://developer.android.com/jetpack/docs/guide
*/

public class MovieRepository {

    private ApiInterface apiInterface;
    private MutableLiveData<MovieResponse> movieResponseMutableLiveData;
    public static final String TAG = "test";

    public MovieRepository() {
    }

    public MutableLiveData<MovieResponse> getMovies() {
        if (movieResponseMutableLiveData == null) {
            movieResponseMutableLiveData = new MutableLiveData<MovieResponse>();
            //Load data asynchronously from the server
            loadMovies();
        }

        return movieResponseMutableLiveData;

    }

    private void loadMovies() {
        apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<MovieResponse> call = apiInterface.getMovies();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.body() != null) {
                    MovieResponse movieResponse = response.body();
                    //movieResponse.getMovieList().get(0).getName();
                    movieResponseMutableLiveData.setValue(movieResponse);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });
    }


}
