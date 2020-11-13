package au.edu.unsw.infs3634.gamifiedlearning;

public class FunFacts {

    private String funfactTitle;
    private String description;
    private int funfactImage;


    public FunFacts (){

    }

    public FunFacts(String funfactTitle, String description, int funfactImage){
        this.funfactTitle = funfactTitle;
        this.description = description;
        this.funfactImage = funfactImage;

    }

    public String getFunfactTitle() {
        return funfactTitle;
    }

    public void setFunfactTitle(String funfactTitle) {
        this.funfactTitle = funfactTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFunfactImage() {
        return funfactImage;
    }

    public void setFunfactImage(int funfactImage) {
        this.funfactImage = funfactImage;
    }
}
