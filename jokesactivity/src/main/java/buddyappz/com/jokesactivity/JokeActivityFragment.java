package buddyappz.com.jokesactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JokeActivityFragment extends Fragment {


    public JokeActivityFragment() {
        // Required empty public constructor
    }

    public static JokeActivityFragment newInstance() {
        JokeActivityFragment fragment = new JokeActivityFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_activity, container, false);


        TextView jokeTextView = (TextView)view.findViewById(R.id.joke_text);

        Bundle extras = getActivity().getIntent().getExtras();

        if (extras != null) {
            String jokeString = extras.getString(JokeActivity.JOKE_INTENT);

            if (jokeTextView != null)
                jokeTextView.setText(jokeString);
        }


        return view;
    }

}
