package com.example.tech.memorygame;


/**
 * Card Memory Game, Madalyn Kendrick and Michael Noseworthy, March 16, 2018, Card game where player selects a card and tries to match that card with another selected card.
 */


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


//Button setup for the cards.
public class MemoryGameButton extends Button {
    @SuppressLint("RestrictedApi")


    private TextView msg;
    private TextView scoreCountText;
    private TextView countdownText;
    private ImageView card1, card2, card3, card4, card5, card6, card7, card8, card9;

    protected int row;
    protected int column;
    protected int frontDrawableId;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;
    protected Drawable front;
    protected Drawable back;

    int[] cardsArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45,46,47,48,49,50,51,52};


    public MemoryGameButton(Context context, int r, int c, int frontImageDrawableId)
    {
        super(context);

        row = r;
        column = c;
        frontDrawableId = frontImageDrawableId;

        front = AppCompatDrawableManager.get().getDrawable(context, frontImageDrawableId);
        back = AppCompatDrawableManager.get().getDrawable(context, R.drawable.cardback);

        setBackground(back);

        GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(r), GridLayout.spec(c));

        tempParams.width = (int) getResources().getDisplayMetrics().density * 50;
        tempParams.height = (int) getResources().getDisplayMetrics().density * 50;
        setLayoutParams(tempParams);


    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getFrontDrawableId() {
        return frontDrawableId;
    }

    public void flip()
    {
        if(isMatched)
            return;

        if(isFlipped)
        {
            setBackground(back);
            isFlipped = false;
        }

        else
        {
            setBackground(front);
            isFlipped = true;
        }
    }

    private void CardsResources(){


        cardsArray[0]= R.drawable.card_1c;
        cardsArray[1]= R.drawable.card_1d;
        cardsArray[2]= R.drawable.card_1h;
        cardsArray[3]= R.drawable.card_1s;

        cardsArray[4]= R.drawable.card_2c;
        cardsArray[5]= R.drawable.card_2d;
        cardsArray[6]= R.drawable.card_2h;
        cardsArray[7]= R.drawable.card_2s;

        cardsArray[8]= R.drawable.card_3c;
        cardsArray[9]= R.drawable.card_3d;
        cardsArray[10]= R.drawable.card_3h;
        cardsArray[11]= R.drawable.card_3s;

        cardsArray[12]= R.drawable.card_4c;
        cardsArray[13]= R.drawable.card_4d;
        cardsArray[14]= R.drawable.card_4h;
        cardsArray[15]= R.drawable.card_4s;

        cardsArray[16]= R.drawable.card_5c;
        cardsArray[17]= R.drawable.card_5d;
        cardsArray[18]= R.drawable.card_5h;
        cardsArray[19]= R.drawable.card_5s;

        cardsArray[20]= R.drawable.card_6c;
        cardsArray[21]= R.drawable.card_6d;
        cardsArray[22]= R.drawable.card_6h;
        cardsArray[23]= R.drawable.card_6s;

        cardsArray[24]= R.drawable.card_7c;
        cardsArray[25]= R.drawable.card_7d;
        cardsArray[26]= R.drawable.card_7h;
        cardsArray[27]= R.drawable.card_7s;

        cardsArray[28]= R.drawable.card_8c;
        cardsArray[29]= R.drawable.card_8d;
        cardsArray[30]= R.drawable.card_8h;
        cardsArray[31]= R.drawable.card_8s;

        cardsArray[32]= R.drawable.card_9c;
        cardsArray[33]= R.drawable.card_9d;
        cardsArray[34]= R.drawable.card_9h;
        cardsArray[35]= R.drawable.card_9s;

        cardsArray[36]= R.drawable.card_10c;
        cardsArray[37]= R.drawable.card_10d;
        cardsArray[38]= R.drawable.card_10h;
        cardsArray[39]= R.drawable.card_10s;

        cardsArray[40]= R.drawable.card_11c;
        cardsArray[41]= R.drawable.card_11d;
        cardsArray[42]= R.drawable.card_11h;
        cardsArray[43]= R.drawable.card_11s;

        cardsArray[44]= R.drawable.card_12c;
        cardsArray[45]= R.drawable.card_12d;
        cardsArray[46]= R.drawable.card_12h;
        cardsArray[47]= R.drawable.card_12s;

        cardsArray[48]= R.drawable.card_13c;
        cardsArray[49]= R.drawable.card_13d;
        cardsArray[50]= R.drawable.card_13h;
        cardsArray[51]= R.drawable.card_13s;


    }

}
