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
        destinations.add(new Places("Sydney Opera House", R.drawable.soh2, R.drawable.soh1, R.drawable.soh, R.drawable.soh3, "Macquare St., Sydney, NSW, 2000", "Near the harbor bridge and CBD", "Australia's iconic performing-arts venue", "1-2", 57669, 47, "The Sydney Opera House is a multi-venue performing arts centre at Sydney Harbour in Sydney, New South Wales, Australia. It is one of the 20th century's most famous and distinctive buildings. \nDesigned by Danish architect Jørn Utzon, but completed by an Australian architectural team headed up by Peter Hall, the building was formally opened on 20 October 1973 after a gestation beginning with Utzon's 1957 selection as winner of an international design competition. The Government of New South Wales, led by the premier, Joseph Cahill, authorised work to begin in 1958 with Utzon directing construction. The government's decision to build Utzon's design is often overshadowed by circumstances that followed, including cost and scheduling overruns as well as the architect's ultimate resignation. (Wikipedia)"));
        destinations.add(new Places("Sydney Harbour Bridge", R.drawable.shb2, R.drawable.shb1, R.drawable.shb, R.drawable.shb3, "Sydney, New South Wales 2060 Australia", "Right between north shore and city", "Massive steel arched bridge with lookout", "1-2", 15587, 47, "The Sydney Harbour Bridge is an Australian heritage-listed steel through arch bridge across Sydney Harbour that carries rail, vehicular, bicycle, and pedestrian traffic between the Sydney central business district and the North Shore. The view of the bridge, the harbour, and the nearby Sydney Opera House is widely regarded as an iconic image of Sydney, and of Australia itself. The bridge is nicknamed \"The Coathanger\" because of its arch-based design. Under the direction of John Bradfield of the New South Wales Department of Public Works, the bridge was designed and built by British firm Dorman Long of Middlesbrough and opened in 1932. The bridge's general design, which Bradfield tasked the NSW Department of Public Works with producing, was a rough copy of the Hell Gate Bridge in New York City. (Wikipedia)"));
        destinations.add(new Places("Port Jackson Bay", R.drawable.pjb2, R.drawable.pjb1, R.drawable.pjb, R.drawable.pjb3, "Port Jackson Bay, New South Wales", "Sydney north shore", "Picturesque inlet with iconic landmarks", "1-2", 65, 44, "Port Jackson, consisting of the waters of Sydney Harbour, Middle Harbour, North Harbour and the Lane Cove and Parramatta Rivers, is the ria or natural harbour of Sydney, New South Wales, Australia. The harbour is an inlet of the Tasman Sea. It is the location of the Sydney Opera House and Sydney Harbour Bridge. \nThe location of the first European settlement and colony on the Australian mainland, Port Jackson has continued to play a key role in the history and development of Sydney. Port Jackson, in the early days of the colony, was also used as a shorthand for Sydney and its environs. (Wikipedia)"));
        destinations.add(new Places("Darling Harbour", R.drawable.dh2, R.drawable.dh1, R.drawable.dh, R.drawable.dh3, "Darling Harbour, Sydney, New South Wales 2000 Australia", "Near Sydney city, the rocks", "Celebration space & leisure complex", "1-2", 42343, 46, "Darling Harbour is a harbour adjacent to the city centre of Sydney, New South Wales, Australia that is made up of a large recreational and pedestrian precinct that is situated on western outskirts of the Sydney central business district. Originally named Long Cove, the locality extends northwards from Chinatown, along both sides of Cockle Bay to King Street Wharf 3 on the east, and to the suburb of Pyrmont on the west. Cockle Bay is just one of the waterways that makes up Darling Harbour, which opens north into the much larger Port Jackson. The precinct and its immediate surroundings are administered independently of the local government area of the City of Sydney, by Property NSW. (Wikipedia)"));
        destinations.add(new Places("Royal Botanic Garden Sydney", R.drawable.rbgs2, R.drawable.rbgs1, R.drawable.rbgs, R.drawable.rbgs3, "Mrs Macquaries Rd, Sydney, New South Wales 2000 Australia", "East of the Rocks", "Oasislike gardens with glasshouses", "3-4", 23406, 47, "The Royal Botanic Garden, Sydney is a heritage-listed major 30-hectare botanical garden, event venue and public recreation area located at Farm Cove on the eastern fringe of the Sydney central business district, in the City of Sydney local government area of New South Wales, Australia. \nOpened in 1816, the garden is the oldest scientific institution in Australia and one of the most important historic botanical institutions in the world. The overall structure and key elements were designed by Charles Moore and Joseph Maiden, and various other elements designed and built under the supervision of Allan Cunningham, Richard Cunningham, and Carrick Chambers. (Wikipedia)"));
        destinations.add(new Places("Taronga Zoo Sydney", R.drawable.tzs2, R.drawable.tzs1, R.drawable.tzs, R.drawable.tzs3, "Bradleys Head Road, Mosman, New South Wales 2088 Australia", "North shore, near Clifton gardens", "Large zoo divided into different regions", "3-4", 20236, 45, "Taronga Zoo Sydney is Australia's largest zoo, located in Sydney, New South Wales, Australia in the suburb of Mosman, on the shores of Sydney Harbour. It was officially opened on 7 October 1916. \nTaronga Zoo Sydney is managed by the Zoological Parks Board of New South Wales, under the trading name Taronga Conservation Society, along with its sister zoo, the Taronga Western Plains Zoo in Dubbo. Divided into eight zoogeographic regions, the 28-hectare Taronga Zoo Sydney is home to over 4,000 animals of 350 species. It has a zoo shop, a cafe, and information centre. (Wikipedia)"));
        destinations.add(new Places("Sydney Tower Eye", R.drawable.ste2, R.drawable.ste1, R.drawable.ste, R.drawable.ste3, "Westfield Centrepoint 100 Market St Retail Level 5, Westfield Sydney, Sydney, New South Wales 2000 Australia", "Sydney city", "Iconic building with a viewing platform", "1-2", 7034, 43, "Sydney Tower is Sydney's tallest structure and the second tallest observation tower in the Southern Hemisphere. The name Sydney Tower has become common in daily usage; however, the tower has been known as the Sydney Tower Eye, AMP Tower, Flower Tower, Glower Tower, Westfield Centrepoint Tower, Big Poke, Centrepoint Tower or just Centrepoint. \nThe Sydney Tower is a member of the World Federation of Great Towers. The tower stands 309 m above the Sydney central business district, located on Market Street, between Pitt and Castlereagh Streets. It is accessible from the Pitt Street Mall, Market Street or Castlereagh Street and sits above the Westfield Sydney shopping centre. The tower is open to the public, and is one of the most prominent tourist attractions in the city, being visible from a number of vantage points throughout town and from adjoining suburbs. (Wikipedia)"));
        destinations.add(new Places("Manly Beach", R.drawable.mb2, R.drawable.mb1, R.drawable.mb, R.drawable.mb3, "Sydney, New South Wales 2095 Australia", "Northern Beaches", "Recreational beach & popular surf spot", "2-3", 1307, 46, "Manly Beach is a beach situated among the Northern Beaches of Sydney, Australia in Manly, New South Wales. From north to south, the three main sections are Queenscliff, North Steyne, and South Steyne. (Wikipedia)"));
        destinations.add(new Places("Luna Park Sydney", R.drawable.lps2, R.drawable.lps1, R.drawable.lps, R.drawable.lps3, "1 Olympic Dr, Milsons Point, North Sydney, New South Wales 2061 Australia", "North Sydney, next to the harbor", "Amusement park & entertainment venue", "2-3", 10176, 42, "Luna Park Sydney is a heritage-listed amusement park located at 1 Olympic Drive, Milsons Point, North Sydney Council, New South Wales, Australia, on the northern shore of Sydney Harbour. \nThe amusement park is owned by the Luna Park Reserve Trust, an agency of the Government of New South Wales, and was added to the New South Wales State Heritage Register on 5 March 2010. The park was constructed during 1935 approximately 600 metres from the northern approaches of the Sydney Harbour Bridge, and ran for seventy-month seasons until 1972, when it was opened year-round. (Wikipedia)"));
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