package com.example.windows.week3_exercise.data.models;

import android.content.Context;

import com.example.windows.week3_exercise.R;
import com.example.windows.week3_exercise.Week3_ExerciseApp;
import com.example.windows.week3_exercise.data.vos.JokeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by windows on 6/25/2016.
 */
public class JokeModel {
    private static JokeModel objInstance;

    private List<JokeVO> jokeList;

    private JokeModel(){jokeList = setUpInitialJokes();}

    public static JokeModel getInstance(){
        if(objInstance==null)
        {
            objInstance=new JokeModel();
        }
        return objInstance;
    }

    private  List<JokeVO> setUpInitialJokes(){
        Context context= Week3_ExerciseApp.getContext();

        List<JokeVO> jokeList=new ArrayList<>();
        jokeList.add(new JokeVO(context.getString(R.string.joke1_title),context.getString(R.string.joke1_text),R.drawable.joke_1));
        jokeList.add(new JokeVO(context.getString(R.string.joke2_title),context.getString(R.string.joke2_text),R.drawable.joke_2));
        jokeList.add(new JokeVO(context.getString(R.string.joke3_title),context.getString(R.string.joke3_text),R.drawable.joke_3));
        return  jokeList;
    }

    public JokeVO getJoke(int index){
        return jokeList.get(index);
    }


}
