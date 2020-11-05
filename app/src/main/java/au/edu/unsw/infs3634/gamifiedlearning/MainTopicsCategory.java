package au.edu.unsw.infs3634.gamifiedlearning;


import java.util.ArrayList;

public class MainTopicsCategory {

    private String topicCategory;
    private String imageName;


    public MainTopicsCategory(String topicCategory, String imageName) {
        this.topicCategory = topicCategory;
        this.imageName = imageName;

    }


    public static ArrayList<MainTopicsCategory> getMainTopicsCategory() {
        ArrayList<MainTopicsCategory> maintopics = new ArrayList<>();
        maintopics.add(new MainTopicsCategory("General Knowledge", "gk"));

        maintopics.add(new MainTopicsCategory("Mars exploration", "marsexploration"));

        maintopics.add(new MainTopicsCategory("History Observation", "marshistory"));

        maintopics.add(new MainTopicsCategory("Future Missions", "mission"));

        maintopics.add(new MainTopicsCategory("Fun Facts", "fun_facts"));

        return maintopics;

    }

    public String getTopicCategory() {
        return topicCategory;
    }

    public void setTopicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}


