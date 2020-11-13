package au.edu.unsw.infs3634.gamifiedlearning;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//    https://codinginflow.com/tutorials/android/retrofit/part-1-simple-get-request
public class Post {
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
