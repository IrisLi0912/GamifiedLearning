package au.edu.unsw.infs3634.gamifiedlearning;

import android.os.Parcel;
import android.os.Parcelable;

public class Question implements Parcelable {
    public static final String CHAPTER_1 = "C1";
    public static final String CHAPTER_2 = "C2";
    public static final String CHAPTER_3 = "C3";
    public static final String CHAPTER_4 = "C4";
    public static final String CHAPTER_5 = "C5";
    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;
    private String difficulty;

    public Question() {

    }

    public Question(String question, String option1, String option2, String option3, int answerNr, String difficulty) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
        this.difficulty = difficulty;
        //nr means number, this is storing the number of the correct answer
    }

    protected Question(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        answerNr = in.readInt();
        difficulty = in.readString();
    }

    public static String[] getAllDifficultyLevels() {
        //if we want to get a list of diiffisulty level
        return new String[]{
                CHAPTER_1,
                CHAPTER_2,
                CHAPTER_3,
                CHAPTER_4,
                CHAPTER_5
        };
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeInt(answerNr);
        dest.writeString(difficulty);
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
