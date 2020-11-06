package au.edu.unsw.infs3634.gamifiedlearning;

import java.util.ArrayList;

public class Places {

    private String placesName;
    private String placeDesc;
    private String placeDetail;
    private Integer placePicture;
    private Integer placePicture1;
    private Integer placePicture2;
    private Integer placePicture3;
    private String placeDuration;
    private String placeRoughLc;
    private String placeAddress;
    private Integer placeScore;
    private Integer reviewPopulation;

    public Places(String placesName, Integer placePicture, Integer placePicture1, Integer placePicture2, Integer placePicture3, String placeAddress, String placeRoughLc, String placeDesc, String placeDuration, Integer reviewPopulation, Integer placeScore, String placeDetail) {
        this.placesName = placesName;
        this.placeDesc = placeDesc;
        this.placeDetail = placeDetail;
        this.placeScore = placeScore;
        this.placePicture = placePicture;
        this.placePicture1 = placePicture1;
        this.placePicture2 = placePicture2;
        this.placePicture3 = placePicture3;
        this.placeDuration = placeDuration;
        this.placeRoughLc = placeRoughLc;
        this.placeAddress = placeAddress;
        this.reviewPopulation = reviewPopulation;

    }

    public static ArrayList<Places> getPlaces() {
        ArrayList<Places> destinations = new ArrayList<>();
        destinations.add(new Places("Bondi Beach", R.drawable.bb2, R.drawable.bb1, R.drawable.bb, R.drawable.bb3, "Queen Elizabeth Drive, Sydney, NSW 2026", "East of Sydney CBD", "Iconic surf beach & Hall Street cafes", "2-3", 2356, 46, "Bondi Beach is a popular beach and the name of the surrounding suburb in Sydney, New South Wales, Australia. It is located 7 km east of the Sydney central business district, in the local government area of Waverley Council, in the Eastern Suburbs. It has a population of 11,656 residents. Its post code is 2026. \nBondi, North Bondi, and Bondi Junction are neighbouring suburbs. Bondi Beach is one of the most visited tourist sites in Australia. (Wikipedia)"));
        return destinations;
    }

    public String getPlacesName() {
        return placesName;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public String getPlaceDetail() {
        return placeDetail;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public Integer getPlacePicture() {
        return placePicture;
    }

    public Integer getPlacePicture1() {
        return placePicture1;
    }

    public Integer getPlacePicture2() {
        return placePicture2;
    }

    public Integer getPlacePicture3() {
        return placePicture3;
    }

    public String getPlaceRoughLc() {
        return placeRoughLc;
    }

    public String getPlaceDuration() {
        return placeDuration;
    }

    public Integer getPlaceScore() {
        return placeScore;
    }

    public Integer getReviewPopulation() {
        return reviewPopulation;
    }
}