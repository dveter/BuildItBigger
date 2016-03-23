package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import buddyappz.com.jokesactivity.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        progressBar = (ProgressBar) root.findViewById(R.id.progressBar1);
        Button tellJokeButton = (Button) root.findViewById(R.id.tellJokeBtn);

        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke(){

        //   JokesFactory jokes = new JokesFactory();

        progressBar.setVisibility(View.VISIBLE);

        //noinspection unchecked
        new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String result) {

                progressBar.setVisibility(View.GONE);

                if (result != null) {

                    displayJoke(result);

                } else {
                    Toast.makeText(getActivity(), R.string.error_retrieving_joke, Toast.LENGTH_LONG).show();
                }

            }
        }.execute();

    }

    private void displayJoke(String jokeToDisplay) {
        Intent jokeIntent = new Intent(getActivity(), JokeActivity.class);
        jokeIntent.putExtra(JokeActivity.JOKE_INTENT, jokeToDisplay);
        startActivity(jokeIntent);
    }
}
