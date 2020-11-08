package au.edu.unsw.infs3634.gamifiedlearning;


import android.media.SubtitleData;

import java.util.ArrayList;

//bad naming
//whenever click each of the main topic it will transfer to recyclerview sub-topic page
public class SubTopic {

    private String topicTitle;
    private String topicDes;
    private int formulaImage; //R.drawable
    private String formulaDes;
    private String topicImageName; //image banner
    private int imageMax;//initialization the number of image that will be including in to imagebanner.

    private String topicTitle1;
    private String topicDes1;
    private String formulaDes1;
    private int formulaImage1; //R.drawable
    private String learnMore; //url

    public SubTopic(String topicTitle, String topicDes, int formulaImage, String formulaDes, String topicImageName, int imageMax, String topicTitle1, String topicDes1,
                    String formulaDes1, int formulaImage1, String learnMore) {
        this.topicTitle = topicTitle;
        this.topicDes = topicDes;
        this.formulaImage = formulaImage;
        this.formulaDes = formulaDes;
        this.topicImageName = topicImageName;
        this.topicTitle1 = topicTitle1;
        this.topicDes1 = topicDes1;
        this.formulaDes1 = formulaDes1;
        this.formulaImage1 = formulaImage1;
        this.imageMax = imageMax;
        this.learnMore = learnMore;

    }

    public static ArrayList<SubTopic> getSubTopics() {
        ArrayList<SubTopic> subtopic = new ArrayList<>();
        subtopic.add(new SubTopic(" Earth’s Gravitational Field ",
                "•\tGravity is a force of attraction that exists between any two masses.\n" +
                        "•\tGravitational field: a ‘region of influence’ in which a mass would experience a force due to the presence of another mass.\n",
                R.drawable.grvfor1,
                "Where:\n" +
                "•\t G is the universal gravitation constant\n •\t M^planet is the mass of the planet\n •\t r^planet is the radius of the planet\n",
                "grvlogo", 5, "Gravitational Potential Energy",
                "Gravitational potential energy is the potential energy possessed by a mass due to its position within a gravitational field. By definition, gravitational potential energy is the work (energy) needed to move an object to an infinite distance within a gravitational field. As a result of this definition, all measures of gravitational potential energy are negative values.\n" +
                        "•\tWhen a force is applied to an object and the object moves, we say work has been done on the object\n" +
                        "•\tWork is the product of the force and the displacement in the direction of the force,\n" +
                        "•\tAs we lift an object from the ground to a height above the ground we do work on it. This work is stored in the object as gravitational potential energy.\n" +
                        "•\tGravitational potential energy is also the energy released by letting a mass fall from an infinite distance to its current distance.\n",
                "Where:\n" +
                        "•\tEp is Gravitational potential energy.\n" +
                        "•\tm is the masses of the planet.\n" +
                        "•\tG is the universal gravitation constant.\n" +
                        "•\tr is the distance from the souce of gravity.\n",R.drawable.grvfor2, "https://en.wikipedia.org/wiki/Gravitational_field"));

//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());
//        subtopic.add(new SubTopic());




                return subtopic;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicDes() {
        return topicDes;
    }

    public void setTopicDes(String topicDes) {
        this.topicDes = topicDes;
    }

    public int getFormulaImage() {
        return formulaImage;
    }

    public void setFormulaImage(int formulaImage) {
        this.formulaImage = formulaImage;
    }

    public String getFormulaDes() {
        return formulaDes;
    }

    public void setFormulaDes(String formulaDes) {
        this.formulaDes = formulaDes;
    }

    public String getTopicImageName() {
        return topicImageName;
    }

    public void setTopicImageName(String topicImageName) {
        this.topicImageName = topicImageName;
    }

    public int getImageMax() {
        return imageMax;
    }

    public void setImageMax(int imageMax) {
        this.imageMax = imageMax;
    }

    public String getTopicTitle1() {
        return topicTitle1;
    }

    public void setTopicTitle1(String topicTitle1) {
        this.topicTitle1 = topicTitle1;
    }

    public String getTopicDes1() {
        return topicDes1;
    }

    public void setTopicDes1(String topicDes1) {
        this.topicDes1 = topicDes1;
    }

    public String getFormulaDes1() {
        return formulaDes1;
    }

    public void setFormulaDes1(String formulaDes1) {
        this.formulaDes1 = formulaDes1;
    }

    public int getFormulaImage1() {
        return formulaImage1;
    }

    public void setFormulaImage1(int formulaImage1) {
        this.formulaImage1 = formulaImage1;
    }

    public String getLearnMore() {
        return learnMore;
    }

    public void setLearnMore(String learnMore) {
        this.learnMore = learnMore;
    }
}
