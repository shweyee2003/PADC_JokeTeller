package com.example.windows.week3_exercise.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windows.week3_exercise.R;
import com.example.windows.week3_exercise.data.models.JokeModel;
import com.example.windows.week3_exercise.data.vos.JokeVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    private static final String BARG_JOKE_INDEX = "BARG_JOKE_INDEX";

    private int jokeindex;
    private JokeVO joke;

    public  static MainFragment newInstance(int jokeIndex) {
        MainFragment fragment=new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BARG_JOKE_INDEX, jokeIndex);
        fragment.setArguments(bundle);
        return fragment;
    }
    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null){
            jokeindex=bundle.getInt(BARG_JOKE_INDEX);
            joke= JokeModel.getInstance().getJoke(jokeindex);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_main, container, false);

        TextView tvJokeTitle=(TextView)view.findViewById(R.id.tv_title);
        tvJokeTitle.setText(joke.getJokeTitle());

        TextView tvJokeContent=(TextView)view.findViewById(R.id.tv_body);
        tvJokeContent.setText(joke.getJokeContent());

        ImageView ivJoke=(ImageView)view.findViewById(R.id.imgv_joke);
        ivJoke.setImageResource(joke.getJokeImage());

        return view;
    }
}
