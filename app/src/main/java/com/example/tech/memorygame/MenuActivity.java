package com.example.tech.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Card Memory Game, Madalyn Kendrick and Michael Noseworthy, March 16, 2018, Card game where player selects a card and tries to match that card with another selected card.
 */


public class MenuActivity extends AppCompatActivity {

    private Button button4x4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button4x4 = (Button)findViewById(R.id.button_4x4_game);

        button4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, Game4x4Activity.class);
                startActivity(intent);
            }

        });


    }




}