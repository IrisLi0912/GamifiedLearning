package au.edu.unsw.infs3634.gamifiedlearning;

import java.util.ArrayList;

public class MainTopicsCategory {

    private String topicCategory;
    private int imageName;


    public MainTopicsCategory(String topicCategory, int imageName) {
        this.topicCategory = topicCategory;
        this.imageName = imageName;

    }


    public static ArrayList<MainTopicsCategory> getMainTopicsCategory() {
        ArrayList<MainTopicsCategory> maintopics = new ArrayList<>();
        maintopics.add(new MainTopicsCategory("General Knowledge", R.drawable.gk));

        maintopics.add(new MainTopicsCategory("Mars exploration", R.drawable.marsexploration));

        maintopics.add(new MainTopicsCategory("History Observation", R.drawable.marshistory));

        maintopics.add(new MainTopicsCategory("Future Missions", R.drawable.mission));

        maintopics.add(new MainTopicsCategory("Fun Facts", R.drawable.funfacts));

        return maintopics;

    }

    public String getTopicCategory() {
        return topicCategory;
    }

    public void setTopicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }
}


