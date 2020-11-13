package au.edu.unsw.infs3634.gamifiedlearning;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FunFactsMain extends AppCompatActivity {

    List<FunFacts> funfacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfacts_recyclerview);



        funfacts = new ArrayList<>();
        funfacts.add(new FunFacts("Mars and Earth have approximately the same landmass","Even though" +
                " Mars has only 15% of the Earth’s volume and just over 10% of the Earth’s mass, around " +
                "two thirds of the Earth’s surface is covered in water. Martian surface gravity is only " +
                "37% of the Earth’s (meaning you could leap nearly three times higher on Mars).",R.drawable.funfact1));
        funfacts.add(new FunFacts("Mars is home to the tallest mountain in the solar system","Olympus Mons, a shield volcano," +
                " is 21km high and 600km in diameter. Despite having formed over billions of years, evidence from volcanic lava " +
                "flows is so recent many scientists believe it could still be active.",R.drawable.funfact2));
        funfacts.add(new FunFacts("Only 18 missions to Mars have been successful","As of September 2014, there have been 40 missions to Mars," +
                " including orbiters, landers and rovers but not counting flybys. The most recent arrivals include the Mars Curiosity mission in 2012, " +
                "the MAVEN mission, which arrived on September 22, 2014, followed by the Indian Space Research Organization’s MOM Mangalyaan orbiter, " +
                "which arrived on September 24, 2014. The next missions to arrive will be the European Space Agency’s ExoMars mission, comprising an orbiter, " +
                "lander, and a rover, followed by NASA’s Insight robotic lander mission, slated for launch in March 2016 and a planned arrival in September, 2016.",
                R.drawable.funfact3));

        funfacts.add(new FunFacts("Mars has the largest dust storms in the solar system","They can last for months and cover the entire planet. " +
                "The seasons are extreme because its elliptical (oval-shaped) orbital path around the Sun is more elongated than most other planets in the solar system."
                ,R.drawable.funfact4));

        funfacts.add(new FunFacts("On Mars the Sun appears around half the size as it does on Earth","At the closest point to the Sun, the Martian southern hemisphere leans towards the Sun, " +
                "causing a short, intensely hot summer, while the northern hemisphere endures a brief, cold winter: at its farthest point from the Sun, the Martian northern hemisphere leans" +
                " towards the Sun, causing a long, mild summer, while the southern hemisphere endures a lengthy, cold winter.",R.drawable.funfact5));

        funfacts.add(new FunFacts("Pieces of Mars have fallen to Earth","Scientists have found tiny traces of Martian atmosphere within meteorites violently ejected from Mars, then orbiting the solar system amongst galactic" +
                " debris for millions of years, before crash landing on Earth. This allowed scientists to begin studying Mars prior to launching space missions.",R.drawable.funfact6));
        funfacts.add(new FunFacts("Mars takes its name from the Roman god of war","The ancient Greeks called the planet Ares, after their god of war; the Romans then did, likewise, associating the planet’s blood-red colour " +
                "with Mars, their own god of war. Interestingly, other ancient cultures also focused on colour – to China’s astronomers it was ‘the fire star’, whilst Egyptian priests called on ‘Her Desher’, or ‘the red one’." +
                " The red colour Mars is known for is due to the rock and dust covering its surface being rich in iron.",R.drawable.funfact7));
        funfacts.add(new FunFacts("There are signs of liquid water on Mars","For years Mars has been known to have water in the form of ice. The first signs of trickling water are dark stripes or stains on crater wall and cliffs seen in satellite images." +
                " Due to Mars’ atmosphere this water would have to be salty to prevent it from freezing or vaporising.",R.drawable.funfact8));
        funfacts.add(new FunFacts("One day Mars will have a ring","In the next 20-40 million years Mars’ largest moon Phobos will be torn apart by gravitational forces leading to the creation of a ring that could last up to 100 million years.",R.drawable.funfact9));
        funfacts.add(new FunFacts("Sunsets on Mars are blue","During the Martian day the sky is pinkish-red, this is the opposite of the Earth’s skies.",R.drawable.funfact10));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.tv_funfactlist);
        FunFactsAdapter myAdapter = new FunFactsAdapter(this,funfacts);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
    }
}
