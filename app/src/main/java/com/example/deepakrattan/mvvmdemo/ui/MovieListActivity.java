package com.example.deepakrattan.mvvmdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.deepakrattan.mvvmdemo.R;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_movie_list);

         /*We need to inflate the binding layout first using the generated binding classes.
          ActivityMainBinding inflates the layout first*/

        DataBindingUtil.setContentView(this, R.layout.activity_movie_list);
        //Load fragment in container
        getSupportFragmentManager().beginTransaction().replace(R.id.container, MovieListFragment.newInstance()).commitNow();
    }
}
