package au.edu.unsw.infs3634.gamifiedlearning;


import java.io.Serializable;
import java.util.ArrayList;

public class MainTopicsCategory  implements Serializable {

    private String topicCategory;
    private int imageName;
    private int type;


    public MainTopicsCategory(String topicCategory, int imageName,int type) {
        this.topicCategory = topicCategory;
        this.imageName = imageName;
        this.type = type;

    }



    //input topic category
    public static ArrayList<MainTopicsCategory> getMainTopicsCategory() {
        ArrayList<MainTopicsCategory> maintopics = new ArrayList<>();
        maintopics.add(new MainTopicsCategory("General Knowledge", R.drawable.gk,0));

        maintopics.add(new MainTopicsCategory("Mars exploration", R.drawable.marsexploration,0));

        maintopics.add(new MainTopicsCategory("History Observation", R.drawable.marshistory,0));

        maintopics.add(new MainTopicsCategory("Future Missions", R.drawable.mission,1));

        maintopics.add(new MainTopicsCategory("Fun Facts", R.drawable.funfacts,2));

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}


