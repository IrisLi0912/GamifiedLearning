package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;

public class SubTopicDetail extends AppCompatActivity {

    private SubTopic subTopic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);

        // modify the toolbar, set title and  text color
//    Toolbar mToolbar = findViewById(R.id.toolbar);
//        mToolbar.setTitle(" Sight Detail ");
//        mToolbar.setTitleTextColor(Color.BLACK);
//        mToolbar.setBackgroundColor(Color.CYAN);


        // adding a message
        // to get the sight data from intent object
        subTopic = (SubTopic) getIntent().getSerializableExtra("data");

        // find all the view that was identified in XML file
//    Banner iv_topicLogo = findViewById(R.id.iv_topicLogo);
//    TextView tv_topicTitle = findViewById(R.id.tv_topicTitle);
//    TextView tv_topicDes = findViewById(R.id.tv_topicDes);
//    ImageView iv_formulaImage  = findViewById(R.id.iv_formulaImage);
//    TextView tv_ratingdes = findViewById(R.id.tv_ratingdes);
//    TextView tv_des = findViewById(R.id.tv_des);
//    TextView tv_guest1 = findViewById(R.id.tv_guest1);
//    TextView tv_guest2 = findViewById(R.id.tv_guest2);
//
//
//    // through setText method to retrieve data from Sight.java file
//    // use id as a identifier , to put relate data into correct place
//        tv_name.setText(sight.getSightName() + "");
//        tv_rating.setText(sight.getRating() + "");
//        tv_ratingdes.setText(sight.getRatingDescription());
//        tv_des.setText(sight.getSightDescription() + "");
//        tv_guest1.setText(sight.getGuestReviews1() + "");
//        tv_guest2.setText(sight.getGuestReviews2() + "");
//
//    // set learn more as a clickable text
//    // redirect to correlated url.(to gain additional information from outside website via google chrome)
//        tv_learn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Uri uri = Uri.parse(sight.getLearnMore());
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
//        }
//    });
//
//    // use image banner to show the sight picture in the place of 'ivLoge' image view
//    ImageBanner adapter = new ImageBanner(getImage());
//        ivLogo.setAdapter(adapter);
//    //allow the image to play circlely
//        ivLogo.setIndicator(new CircleIndicator(this));
//}
//
//
//    // Define an arraylist, then traverse all the pictures in the resource, put them into this list, and then return to the user
//    public ArrayList<Integer> getImage() {
//        ArrayList<Integer> images = new ArrayList<>();
//
//        for (int i = 0; i < sight.getImageMax(); i++) {
//            int image;
//
//            if (i == 0) {
//                //Return a resource identifier for the given resource name
//                image = getResources().getIdentifier(sight.getImageName(),
//                        "drawable", "com.example.attractions");
//            } else {
//                image = getResources().getIdentifier(sight.getImageName() + i,
//                        "drawable", "com.example.attractions");
//            }
//            //add image inside the images arraylist
//            images.add(image);
//        }
//        //show the image
//        return images;
//    }
//}
//}
    }

}
