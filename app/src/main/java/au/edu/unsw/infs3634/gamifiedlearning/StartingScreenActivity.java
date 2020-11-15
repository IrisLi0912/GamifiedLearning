package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static au.edu.unsw.infs3634.gamifiedlearning.Question.CHAPTER_1;
import static au.edu.unsw.infs3634.gamifiedlearning.Question.CHAPTER_2;
import static au.edu.unsw.infs3634.gamifiedlearning.Question.CHAPTER_3;
import static au.edu.unsw.infs3634.gamifiedlearning.Question.CHAPTER_4;
import static au.edu.unsw.infs3634.gamifiedlearning.Question.CHAPTER_5;

public class StartingScreenActivity extends AppCompatActivity {
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";
    private static final int REQUEST_CODE_QUIZ = 1; //value here dose not matter
    private TextView textViewHighscore; //reference the textview and show the high score
    private int highscore;
    private Spinner spinnerDifficulty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        //initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnBottomBar);

        //set home selected, later change to set whatever page selected
        bottomNavigationView.setSelectedItemId(R.id.journey);

        //Perform ItemSelectListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.topic:
                        startActivity(new Intent(getApplicationContext(), MainTopicMain.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), User.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainPage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.journey:
                        startActivity(new Intent(getApplicationContext(), StartingScreenActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


        //below is the spinner stuff
        spinnerDifficulty = findViewById(R.id.spinner_difficulty);
        //calling the difficulty list in question class
        String[] difficultyLevels = Question.getAllDifficultyLevels();
        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapterDifficulty);
        //spinner end

        textViewHighscore = findViewById(R.id.tvHighScore);
        loadHighscore();

        Button buttonStartQuiz = findViewById(R.id.btStartQuiz);//Temporarily hidden from app interface
        Button buttonStartQuiz1 = findViewById(R.id.btChapter1);
        Button buttonStartQuiz2 = findViewById(R.id.btChapter2);
        Button buttonStartQuiz3 = findViewById(R.id.btChapter3);
        Button buttonStartQuiz4 = findViewById(R.id.btChapter4);
        Button buttonStartQuiz5 = findViewById(R.id.btChapter5);

        //------------------Temporarily hided from app interface ------------------
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
        //-------------------------------------------------------------------------
        buttonStartQuiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizChapter1();
            }
        });
        buttonStartQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizChapter2();
            }
        });
        buttonStartQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizChapter3();
            }
        });
        buttonStartQuiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizChapter4();
            }
        });
        buttonStartQuiz5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizChapter5();
            }
        });
    }

    private void startQuizChapter1() {
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        //send the value to quiz activity
        intent.putExtra(EXTRA_DIFFICULTY, CHAPTER_1);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    private void startQuizChapter2() {
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        //send the value to quiz activity
        intent.putExtra(EXTRA_DIFFICULTY, CHAPTER_2);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    private void startQuizChapter3() {
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        //send the value to quiz activity
        intent.putExtra(EXTRA_DIFFICULTY, CHAPTER_3);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    private void startQuizChapter4() {
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        //send the value to quiz activity
        intent.putExtra(EXTRA_DIFFICULTY, CHAPTER_4);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    private void startQuizChapter5() {
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        //send the value to quiz activity
        intent.putExtra(EXTRA_DIFFICULTY, CHAPTER_5);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    //------------------Temporarily hided from app interface ------------------
    private void startQuiz() {
        //select and record the difficulty selection
        String difficulty = spinnerDifficulty.getSelectedItem().toString();
        Intent intent = new Intent(StartingScreenActivity.this, QuizActivity.class);
        //send the value to quiz activity
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }
    //-------------------------------------------------------------------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //displaying the HIGHEST score
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(QuizActivity.EXTRA_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }
    }

    private void loadHighscore() {
        //modify needed, fetch high score from firebase?

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore: " + highscore);
    }

    private void updateHighscore(int highscoreNew) {
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore: " + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}