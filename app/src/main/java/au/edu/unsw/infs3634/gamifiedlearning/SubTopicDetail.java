package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
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


        subTopic = (SubTopic) getIntent().getSerializableExtra("data");


        Banner iv_topicLogo = findViewById(R.id.banner); //banner
        TextView tv_topicTitle = findViewById(R.id.tv_topicTitle);
        TextView tv_topicDes = findViewById(R.id.tv_topicDes);
        ImageView iv_formulaImage = findViewById(R.id.iv_formulaImage);
        TextView tv_formulaDes = findViewById(R.id.tv_formulaDes);
        TextView tv_topicTitle1 = findViewById(R.id.tv_topicTitle1);
        TextView tv_topicDes1 = findViewById(R.id.tv_topicDes1);
        TextView tv_formulaDes1 = findViewById(R.id.tv_formulaDes1);
        ImageView iv_formulaImage1 = findViewById(R.id.iv_formulaImage1);
        TextView tv_learnMore = findViewById(R.id.tv_learnMore);


        iv_formulaImage.setImageResource(subTopic.getFormulaImage());
        tv_topicTitle.setText(subTopic.getTopicTitle() + "");
        tv_topicDes.setText(subTopic.getTopicDes() + "");
        tv_formulaDes.setText(subTopic.getFormulaDes());

        tv_topicTitle1.setText(subTopic.getTopicTitle1() + "");
        tv_topicDes1.setText(subTopic.getTopicDes1() + "");
        tv_formulaDes1.setText(subTopic.getFormulaDes1() + "");
        iv_formulaImage1.setImageResource(subTopic.getFormulaImage1());


        tv_learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(subTopic.getLearnMore());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        ImageBanner adapter = new ImageBanner(getImage());
        iv_topicLogo.setAdapter(adapter);

        iv_topicLogo.setIndicator(new CircleIndicator(this));


    }

    public ArrayList<Integer> getImage() {
        ArrayList<Integer> images = new ArrayList<>();

        for (int i = 0; i < subTopic.getImageMax(); i++) {
            int image;

            if (i == 0) {
                //Return a resource identifier for the given resource name
                image = getResources().getIdentifier(subTopic.getTopicImageName(),
                        "drawable", "au.edu.unsw.infs3634.gamifiedlearning");
            } else {
                image = getResources().getIdentifier(subTopic.getTopicImageName() + i,
                        "drawable", "au.edu.unsw.infs3634.gamifiedlearning");
            }
            //add image inside the images arraylist
            images.add(image);
        }
        //show the image
        return images;
    }
}




