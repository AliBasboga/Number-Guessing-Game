package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView numberDisplay;
    private TextView clueTextView;
    private int userNumber = 0;
    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberDisplay = findViewById(R.id.numberDisplay);
        clueTextView = findViewById(R.id.clueTextView);
        Button decreaseButton = findViewById(R.id.decreaseButton);
        Button increaseButton = findViewById(R.id.increaseButton);
        Button selectButton = findViewById(R.id.selectButton);

        randomNumber = new Random().nextInt(201) - 100;

        numberDisplay.setText(String.valueOf(userNumber));

        // İpucu metnini güncelle
        updateClue(randomNumber);

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userNumber > -100) {
                    userNumber--;
                    numberDisplay.setText(String.valueOf(userNumber));
                }
            }
        });

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userNumber < 100) {
                    userNumber++;
                    numberDisplay.setText(String.valueOf(userNumber));
                }
            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userNumber == randomNumber) {
                    Toast.makeText(MainActivity.this, "Tebrikler! Kazandınız!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Maalesef, kaybettiniz. Doğru sayı: " + randomNumber, Toast.LENGTH_SHORT).show();
                }
                randomNumber = new Random().nextInt(201) - 100;
                userNumber = 0;
                numberDisplay.setText(String.valueOf(userNumber));

                // Yeni ipucu
                updateClue(randomNumber);
            }
        });
    }

    // İpucu metnini güncellemek için bir yöntem
    private void updateClue(int randomNumber) {
        // Yakın bir sayı tahmin et
        int clue = randomNumber + new Random().nextInt(11) - 5; // Doğru sayıya + veya - 5 arasından bir şey ekler
        clueTextView.setText("Yakın Sayı: " + clue);
    }
}
