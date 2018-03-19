package com.example.tech.memorygame;

/**
 * Card Memory Game, Madalyn Kendrick and Michael Noseworthy, March 16, 2018, Card game where player selects a card and tries to match that card with another selected card.
 */

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    @SuppressLint("RestrictedApi")

    private int numberOfElements;

    private MemoryGameButton[] buttons;
    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;

    private MemoryGameButton selectedButton1;
    private MemoryGameButton selectedButton2;

    private boolean isBusy = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridLayout gridLayout = findViewById(R.id.grid_layout_4x4);

        int numColums = gridLayout.getColumnCount();
        int numRows = gridLayout.getRowCount();

        numberOfElements = numColums * numRows;

        buttons = new MemoryGameButton[numberOfElements];

        buttonGraphics = new int[numberOfElements / 2];

        buttonGraphics[0] = R.drawable.card_1c;
        buttonGraphics[1] = R.drawable.card_2c;
        buttonGraphics[2] = R.drawable.card_3c;
        buttonGraphics[3] = R.drawable.card_4c;
        buttonGraphics[4] = R.drawable.card_5c;
        buttonGraphics[5] = R.drawable.card_6c;
        buttonGraphics[6] = R.drawable.card_7c;
        buttonGraphics[7] = R.drawable.card_8c;

        /*
        Cards101 = R.drawable.card_1c;
        Cards102 = R.drawable.card_2c;
        Cards103 = R.drawable.card_3c;
        Cards104 = R.drawable.card_4c;
        Cards105 = R.drawable.card_5c;
        Cards106 = R.drawable.card_6c;
        Cards201 = R.drawable.card_7c;
        Cards202 = R.drawable.card_8c;
        Cards203 = R.drawable.card_9c;
        Cards204 = R.drawable.card_10c;
        Cards205 = R.drawable.card_11c;
        Cards206 = R.drawable.card_12c;
         */

        buttonGraphicLocations = new int[numberOfElements];

        shuffleButtonGraphics();

        for(int r = 0; r<numRows;r++)
        {
            for(int c =0;c<numColums;c++)
            {
                MemoryGameButton tempButton = new MemoryGameButton(this, r, c, buttonGraphics[buttonGraphicLocations[r*numColums+c]]);
                tempButton.setId(View.generateViewId());
                tempButton.setOnClickListener(this);
                buttons[r*numColums+c] = tempButton;
                gridLayout.addView(tempButton);
            }
        }
    }

    protected void shuffleButtonGraphics(){
        Random rand = new Random();

        for(int i = 0; i < numberOfElements; i++)
        {
            buttonGraphicLocations[i] = i % (numberOfElements / 2);
        }
        for(int i = 0; i < numberOfElements; i++)
        {
            int temp = buttonGraphicLocations[i];

            int swapIndex = rand.nextInt(16);

            buttonGraphicLocations[i] = buttonGraphicLocations[swapIndex];

            buttonGraphicLocations[swapIndex] = temp;
        }
    }

    @Override
    public void onClick(View view) {
        if(isBusy)
            return;
        MemoryGameButton button = (MemoryGameButton) view;

        if(button.isMatched)
            return;

        if(selectedButton1 == null){
            selectedButton1=button;
            selectedButton1.flip();
            return;
        }

        if(selectedButton1.getId()==button.getId())
            return;

        if(selectedButton1.getFrontDrawableId()==button.getFrontDrawableId())
        {
            button.flip();

            button.setMatched(true);
            selectedButton1.setMatched(true);
            selectedButton1.setEnabled(false);

            selectedButton2.setEnabled(false);

            selectedButton1 = null;
            return;
        }

        else{
            selectedButton2 = button;
            selectedButton2.flip();
            isBusy = true;

            final Handler handler = new Handler();

            handler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    selectedButton2.flip();
                    selectedButton1.flip();
                    selectedButton1 = null;
                    selectedButton2 = null;
                    isBusy = false;
                }
            }, 500);
        }
    }
}
