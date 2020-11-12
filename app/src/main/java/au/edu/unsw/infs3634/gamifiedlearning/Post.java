package au.edu.unsw.infs3634.gamifiedlearning;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Post {
//    private int userId;
//    private int id;
//    private String title;

    //decoding the json file
    @SerializedName("av")
    @Expose
    private Double av;
    @SerializedName("ct")
    @Expose
    private Integer ct;
    @SerializedName("mn")
    @Expose
    private Double mn;
    @SerializedName("mx")
    @Expose
    private Double mx;

    public Double getAv() {
        return av;
    }

    public void setAv(Double av) {
        this.av = av;
    }

    public Integer getCt() {
        return ct;
    }

    public void setCt(Integer ct) {
        this.ct = ct;
    }

    public Double getMn() {
        return mn;
    }

    public void setMn(Double mn) {
        this.mn = mn;
    }

    public Double getMx() {
        return mx;
    }

    public void setMx(Double mx) {
        this.mx = mx;
    }



//
//    @SerializedName("body")
//    private String text;
//    public int getUserId() {
//        return userId;
//    }
//    public int getId() {
//        return id;
//    }
//    public String getTitle() {
//        return title;
//    }
//    public String getText() {
//        return text;
//    }
}