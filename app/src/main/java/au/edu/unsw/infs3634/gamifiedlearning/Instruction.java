package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Instruction extends AppCompatActivity {
    private TextView mainDisplay;
    private TextView pageNumber;
    private ImageView mainImage;
    private Button nextPage;
    private int clickCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        mainDisplay = findViewById(R.id.tvInstruction);
        pageNumber = findViewById(R.id.tvPage);
        mainImage = findViewById(R.id.ivDisplay);
        nextPage = findViewById(R.id.btNext);

        mainDisplay.setText(R.string.instruction_1); //set initial text
        pageNumber.setText("Page: " + String.valueOf(clickCount)); //display page number
        clickCount++;
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //as the user click through, the page content changes
                if (clickCount == 1) {
                    mainDisplay.setText(R.string.instruction_2);
                    pageNumber.setText(String.valueOf("Page: " + clickCount));
                    clickCount++;
                } else if (clickCount == 2) {
                    mainDisplay.setText(R.string.instruction_3);
                    pageNumber.setText(String.valueOf("Page: " + clickCount));
                    clickCount++;
                } else if (clickCount == 3) {
                    mainDisplay.setText(R.string.instruction_4);
                    pageNumber.setText(String.valueOf("Page: " + clickCount));
                    mainImage.setImageResource(R.drawable.bottom_bar_example);
                    clickCount++;
                } else if (clickCount == 4) {
                    mainDisplay.setText(R.string.instruction_5);
                    pageNumber.setText(String.valueOf("Page: " + clickCount));
                    mainImage.setImageResource(R.drawable.topic_example);
                    clickCount++;
                } else if (clickCount == 5) {
                    mainDisplay.setText(R.string.instruction_6);
                    pageNumber.setText(String.valueOf("Page: " + clickCount));
                    clickCount++;
                    //another image needed
                    mainImage.setImageResource(android.R.color.transparent);
                    nextPage.setText("I am READY for the journey!");
                } else if (clickCount == 6) {
                    mainDisplay.setText(getString(R.string.instruction_7) +
                            "Good luck with your exploration!");
                    pageNumber.setText(String.valueOf("Page: " + clickCount));
                    clickCount++;
                } else if (clickCount == 7) {
                    startActivity(new Intent(getApplicationContext(), StartingScreenActivity.class));
                    clickCount++;
                } else {
                    startActivity(new Intent(getApplicationContext(), StartingScreenActivity.class));
                }
            }
        });
    }
}