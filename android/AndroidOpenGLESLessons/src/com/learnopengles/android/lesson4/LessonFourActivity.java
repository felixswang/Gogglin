package com.learnopengles.android.lesson4;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.learnopengles.android.R;

public class LessonFourActivity extends CardboardActivity 
{
	private Vibrator mVibrator;
	
	private CardboardOverlayView mOverlayView;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.common_ui);
        CardboardView cardboardView = (CardboardView) findViewById(R.id.cardboard_view);
        cardboardView.setRenderer(new LessonFourRenderer(this));
        setCardboardView(cardboardView);
        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        
        mOverlayView = (CardboardOverlayView) findViewById(R.id.overlay);
	}
	
	/**
	* Increment the score, hide the object, and give feedback if the user pulls the magnet while
	* looking at the object. Otherwise, remind the user what to do.
	*/
	    @Override
	    public void onCardboardTrigger() {
	        // Always give user feedback
	    	NetworkUtils.getQuestion(0, new Callback<CardBoardQuestion>() {
	            @Override
	            public void success(CardBoardQuestion question, Response response) {
	                Log.e("new question", question.question);
	                mOverlayView.show3DToast(question.question);
	            }

	            @Override
	            public void failure(RetrofitError error) {
	                Log.e("new question", error.toString());
	            }
	        });
	    }
}