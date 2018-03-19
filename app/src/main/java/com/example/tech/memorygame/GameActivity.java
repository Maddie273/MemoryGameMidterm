package com.example.tech.memorygame;

/**
 * Card Memory Game, Madalyn Kendrick and Michael Noseworthy, March 16, 2018, Card game where player selects a card and tries to match that card with another selected card.
 */

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

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
        setContentView(R.layout.activity_game4x4);


        GridLayout gridLayout = findViewById(R.id.grid_layout_4x4);

        int numColums = gridLayout.getColumnCount();
        int numRows = gridLayout.getRowCount();

        numberOfElements = numColums * numRows;

        buttons = new MemoryGameButton[numberOfElements];

        buttonGraphics = new int[numberOfElements / 2];

        buttonGraphics[0] = R.drawable.button_1;
        buttonGraphics[1] = R.drawable.button_2;
        buttonGraphics[2] = R.drawable.button_3;
        buttonGraphics[3] = R.drawable.button_4;
        buttonGraphics[4] = R.drawable.button_5;
        buttonGraphics[5] = R.drawable.button_6;
        buttonGraphics[6] = R.drawable.button_7;
        buttonGraphics[7] = R.drawable.button_8;

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
