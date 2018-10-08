package com.example.a10016322.widgetstwopractwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    int userScore = 0;
    int user;
    int comScore = 0;
    TextView volume, rps, textTwo, score;
    RadioGroup radioGroup, rpsgroup;
    RadioButton twentyFive, fifty, seventyFive, hundred, rock, paper, scissors;
    Button play;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volume = (TextView)(findViewById(R.id.volume_id));
        rps = (TextView)(findViewById(R.id.rps_id));
        textTwo = (TextView)(findViewById(R.id.textView2_id));
        score = (TextView)(findViewById(R.id.score_id));
        radioGroup = (RadioGroup)(findViewById(R.id.radioGroup_id));
        rpsgroup = (RadioGroup)(findViewById(R.id.rpsgroup_id));
        twentyFive = (RadioButton)(findViewById(R.id.radioButton));
        fifty = (RadioButton)(findViewById(R.id.radioButton2));
        seventyFive = (RadioButton)(findViewById(R.id.radioButton3));
        hundred = (RadioButton)(findViewById(R.id.radioButton4));
        rock = (RadioButton)(findViewById(R.id.rock_id));
        paper = (RadioButton)(findViewById(R.id.paper_id));
        scissors = (RadioButton)(findViewById(R.id.scisssors_id));
        play = (Button)(findViewById(R.id.play_id));
        imageView = (ImageView)(findViewById(R.id.imageView_id));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId == R.id.radioButton4)
                {
                    Toast message = Toast.makeText(MainActivity.this, "Warning: Higher volumes may damage hearing",Toast.LENGTH_SHORT);
                    message.show();
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!rock.isChecked() && !paper.isChecked() && !scissors.isChecked()))
                    textTwo.setText("Make a selection");
                else textTwo.setText("");

                int randInt = (int)(Math.random()*3)+1;
                if(randInt==1)
                    imageView.setImageResource(R.drawable.rock);
                else if(randInt==2)
                    imageView.setImageResource(R.drawable.paper);
                else if(randInt==3)
                    imageView.setImageResource(R.drawable.scissors);

                if(user == randInt) {
                    textTwo.setText("It's a tie");
                    score.setText("Score: " + userScore + " CPU: " + comScore);
                }
                else if(user==1)
                {
                    if(randInt==2) {
                        textTwo.setText("You lose.");
                        comScore+=1;
                        score.setText("Score: " + userScore + " CPU: " + comScore);
                    }
                    else if(randInt==3) {
                        textTwo.setText("You win!");
                        userScore+=1;
                        score.setText("Score: " + userScore + " CPU: " + comScore);
                    }
                }
                else if(user==2)
                {
                    if(randInt==1) {
                        textTwo.setText("You win!");
                        userScore+=1;
                        score.setText("Score: " + userScore + " CPU: " + comScore);
                    }
                    else if(randInt==3) {
                        textTwo.setText("You lose.");
                        comScore+=1;
                        score.setText("Score: " + userScore + " CPU: " + comScore);
                    }
                }
                else if(user==3)
                {
                    if(randInt==1) {
                        textTwo.setText("You lose.");
                        comScore+=1;
                        score.setText("Score: " + userScore + " CPU: " + comScore);
                    }
                    else if(randInt==2) {
                        textTwo.setText("You win!");
                        userScore += 1;
                        score.setText("Score: " + userScore + " CPU: " + comScore);
                    }
                }

            }
        });

        rpsgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId == R.id.rock_id)
                    user = 1;
                if(checkedId == R.id.paper_id)
                    user = 2;
                if(checkedId == R.id.scisssors_id)
                    user = 3;
            }
        });

    }
}
