package com.sebastianlundquist.connectthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0 is red, 1 is yellow
    int activePlayer = 0;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropin(View view) {
        ImageView counter = (ImageView)view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCounter] = activePlayer;

        counter.setTranslationY(-1500);
        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.red);
            activePlayer = 1;
        }
        else {
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 0;
        }
        counter.animate().translationYBy(1500).rotation(360).setDuration(500);

        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                String winner = "";
                winner = activePlayer == 1 ? "Red" : "Yellow";
                Toast.makeText(this, winner + " has won!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
