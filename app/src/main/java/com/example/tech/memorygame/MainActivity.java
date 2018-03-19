package com.example.tech.memorygame;
/**
 * Card Memory Game, Madalyn Kendrick and Michael Noseworthy, March 16, 2018, Card game where player selects a card and tries to match that card with another selected card.
 */
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    TextView tv_p1, tv_p2;

    ImageView card11, card12, card13, card14, card21, card22, card23, card24, card31, card32, card33, card34;

    Integer[] cardsArray = {101,102,103,104,105,106,201,202,203,204,205,206};

    int image101, image102,image103,image104, image105,image106,
            image201, image202,image203,image204, image205,image206;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_p1 = findViewById(R.id.tv_p1);
        tv_p2 = findViewById(R.id.tv_p2);

        card11 = findViewById(R.id.card1);
        card12 = findViewById(R.id.card2);
        card13 = findViewById(R.id.card3);
        card14 = findViewById(R.id.card4);
        card21 = findViewById(R.id.card5);
        card22 = findViewById(R.id.card6);
        card23 = findViewById(R.id.card7);
        card24 = findViewById(R.id.card8);
        card31 = findViewById(R.id.card9);
        card32 = findViewById(R.id.card10);
        card33 = findViewById(R.id.card11);
        card34 = findViewById(R.id.card12);

        card11.setTag("0");
        card12.setTag("1");
        card13.setTag("2");
        card14.setTag("3");
        card21.setTag("4");
        card22.setTag("5");
        card23.setTag("6");
        card24.setTag("7");
        card31.setTag("8");
        card32.setTag("9");
        card33.setTag("10");
        card34.setTag("11");

        //load the card images
        frontOfCardsResources();

        //shuffle
        Collections.shuffle(Arrays.asList(cardsArray));

        //changing the color of the second player(inactive)
        tv_p2.setTextColor(Color.GRAY);

        card11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card11, theCard);
            }
        });

        card12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card12, theCard);
            }
        });

        card13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card13, theCard);
            }
        });

        card14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card14, theCard);
            }
        });

        card21.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card21, theCard);
            }
        });

        card22.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card22, theCard);
            }
        });

        card23.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card23, theCard);
            }
        });

        card24.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card24, theCard);
            }
        });

        card31.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card31, theCard);
            }
        });

        card32.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card32, theCard);
            }
        });

        card33.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card33, theCard);
            }
        });

        card34.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(card34, theCard);
            }
        });
    }

    private void doStuff(ImageView iv, int card){
        //set the correct image to the imageview
        if(cardsArray[card]==101) {
            iv.setImageResource(image101);
        }
        else if(cardsArray[card]==102){
            iv.setImageResource(image102);
        }
        else if(cardsArray[card]==103){
            iv.setImageResource(image103);
        }
        else if(cardsArray[card]==104){
            iv.setImageResource(image104);
        }
        else if(cardsArray[card]==105){
            iv.setImageResource(image105);
        }
        else if(cardsArray[card]==106){
            iv.setImageResource(image106);
        }
        else if(cardsArray[card]==201){
            iv.setImageResource(image201);
        }
        else if(cardsArray[card]==202){
            iv.setImageResource(image202);
        }
        else if(cardsArray[card]==203){
            iv.setImageResource(image203);
        }
        else if(cardsArray[card]==204){
            iv.setImageResource(image204);
        }
        else if(cardsArray[card]==205){
            iv.setImageResource(image205);
        }
        else if(cardsArray[card]==206) {
            iv.setImageResource(image206);
        }
        //check wich image is selected and save it to temporary variable
        if(cardNumber ==1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber == 2){
            secondCard = cardsArray [card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            secondCard = card;

            card11.setEnabled(false);
            card12.setEnabled(false);
            card13.setEnabled(false);
            card14.setEnabled(false);
            card21.setEnabled(false);
            card22.setEnabled(false);
            card23.setEnabled(false);
            card23.setEnabled(false);
            card31.setEnabled(false);
            card32.setEnabled(false);
            card33.setEnabled(false);
            card34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if th selected images are equal
                    calculate();
                }
            }, 1000);
        }
    }

    private void calculate(){
        //if images are equal remove them and add points
        if(firstCard == secondCard) {
            if (clickedFirst == 0) {
                card11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 0) {
                card12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                card13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                card14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                card21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                card22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                card23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                card24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                card31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                card32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                card33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                card34.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                card11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 0) {
                card12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                card13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                card14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                card21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                card22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                card23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                card24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                card31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                card32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                card33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                card34.setVisibility(View.INVISIBLE);
            }

            if (turn == 1) {
                playerPoints++;
                tv_p1.setText("P1: " + playerPoints);
            } else if (turn == 2) {
                cpuPoints++;
                tv_p2.setText("P2: " + cpuPoints);
            }
        } else {
            card11.setImageResource(R.drawable.cardback);
            card12.setImageResource(R.drawable.cardback);
            card13.setImageResource(R.drawable.cardback);
            card14.setImageResource(R.drawable.cardback);
            card21.setImageResource(R.drawable.cardback);
            card22.setImageResource(R.drawable.cardback);
            card23.setImageResource(R.drawable.cardback);
            card24.setImageResource(R.drawable.cardback);
            card31.setImageResource(R.drawable.cardback);
            card32.setImageResource(R.drawable.cardback);
            card33.setImageResource(R.drawable.cardback);
            card34.setImageResource(R.drawable.cardback);

            //change the player turn
            if(turn == 1){
                turn = 2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLACK);
            } else if(turn == 2){
                turn = 1;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLACK);
            }
        }

        card11.setEnabled(true);
        card12.setEnabled(true);
        card13.setEnabled(true);
        card14.setEnabled(true);
        card21.setEnabled(true);
        card22.setEnabled(true);
        card23.setEnabled(true);
        card24.setEnabled(true);
        card31.setEnabled(true);
        card32.setEnabled(true);
        card33.setEnabled(true);
        card34.setEnabled(true);

        //check if the game is over
        checkEnd();
    }

    private void checkEnd(){
        if(card11.getVisibility()== View.INVISIBLE &&
                card12.getVisibility()== View.INVISIBLE &&
                card13.getVisibility()== View.INVISIBLE &&
                card14.getVisibility()== View.INVISIBLE &&
                card21.getVisibility()== View.INVISIBLE &&
                card22.getVisibility()== View.INVISIBLE &&
                card23.getVisibility()== View.INVISIBLE &&
                card24.getVisibility()== View.INVISIBLE &&
                card31.getVisibility()== View.INVISIBLE &&
                card32.getVisibility()== View.INVISIBLE &&
                card33.getVisibility()== View.INVISIBLE &&
                card34.getVisibility()== View.INVISIBLE){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("GAME OVER\nP1: " + playerPoints + "\nP2: " + cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();


    }


    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    private void frontOfCardsResources(){
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
        image205 = R.drawable.ic_image205;
        image206 = R.drawable.ic_image206;
    }


}

