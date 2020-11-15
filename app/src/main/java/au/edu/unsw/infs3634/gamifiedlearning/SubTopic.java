package au.edu.unsw.infs3634.gamifiedlearning;

import java.io.Serializable;
import java.util.ArrayList;

public class SubTopic implements Serializable {

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

    private String key; //url

    public SubTopic(String key,String topicTitle, String topicDes, int formulaImage, String formulaDes, String topicImageName, int imageMax, String topicTitle1, String topicDes1,
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
        this.key = key;


    }
    public static ArrayList<SubTopic> getSubTopics() {
        ArrayList<SubTopic> subtopic = new ArrayList<>();

        //general knowledge  grvlogo
        subtopic.add(new SubTopic("General Knowledge", " Earth’s Gravitational Field ",
                "•\tGravity is a force of attraction that exists between any two masses.\n" +
                        "•\tGravitational field: a ‘region of influence’ in which a mass would experience a force due to the presence of another mass.\n",
                R.drawable.grvfor1,
                "Where:\n" +
                        "•\t G is the universal gravitation constant\n •\t M^planet is the mass of the planet\n •\t r^planet is the radius of the planet\n",
                "grvlogo", 5,
                "Gravitational Potential Energy",
                "Gravitational potential energy is the potential energy possessed by a mass due to its position within a gravitational field. By definition, gravitational potential energy is the work (energy) needed to move an object to an infinite distance within a gravitational field. As a result of this definition, all measures of gravitational potential energy are negative values.\n" +
                        "•\tWhen a force is applied to an object and the object moves, we say work has been done on the object\n" +
                        "•\tWork is the product of the force and the displacement in the direction of the force,\n" +
                        "•\tAs we lift an object from the ground to a height above the ground we do work on it. This work is stored in the object as gravitational potential energy.\n" +
                        "•\tGravitational potential energy is also the energy released by letting a mass fall from an infinite distance to its current distance.\n",
                "Where:\n" +
                        "•\tEp is Gravitational potential energy.\n" +
                        "•\tm is the masses of the planet.\n" +
                        "•\tG is the universal gravitation constant.\n" +
                        "•\tr is the distance from the souce of gravity.\n", R.drawable.grvfor2, "https://en.wikipedia.org/wiki/Gravitational_field"));


        //imagemax  sflogo
        subtopic.add(new SubTopic("General Knowledge", " Space Flight ", "The necessary velocity to leave the earth is called the escape velocity. It is the minimum initial velocity required by a projectile to escape the gravitational field of a planet. Escape velocity depends only on the mass and radius of the planet, and is independent of the mass of the object itself.", R.drawable.spacef1,
                "Suppose an object of mass m is projected vertically upward from the earth’s surface with an initial velocity  . The total energy possessed by the object is:\n" +
                        "Where:\n" +
                        "•\t Ek is the kinetic energy of the projectile\n" +
                        "•\t Ep is the gravitational potential energy of the projectile\n" +
                        "•\t G  is the universal gravitation constant\n" +
                        "•\t M  is the mass of Earth\n" +
                        "•\t m  is the mass of the projectile\n" +
                        "•\t rE is the radius of the Earth\n", "sflogo", 4, "Uniform Circular Motion", "Uniform circular motion is circular motion with a constant speed. The object is kept in its path of uniform circular motion by a force that acts towards the centre of the circular path. Even though its speed is constant, its velocity is always changing as it is constantly changing direction. As a result, the acceleration acts towards the centre of the circle. The net force is termed centripetal force as it acts towards the centre of motion. The net acceleration is similarly termed centripetal acceleration. ",
                "Centripetal force is:\n" +
                        "•\tCentripetal acceleration is: Ac = V^2/r towards the centre.\n" +
                        "•\tNote that this centripetal force can be supplied by different forces.\n" +
                        "•\tIn the case of a satellite in orbit around the Earth, this force is supplied by the force of gravity that acts between the satellite and the Earth.\n" +
                        "•\tCircular motion also commonly occurs for charged particles moving in a magnetic field.\n", R.drawable.spacef2, "https://en.wikipedia.org/wiki/Spaceflight"));

        //imagemax 4 orbitlogo
        subtopic.add(new SubTopic("General Knowledge"," Orbit ","Low Earth orbit\n" +
                "\n" +
                "•\tGenerally an orbital altitude of 250km to 1,000km\n" +
                "•\tUsed by space shuttles and small communication satellites\n" +
                "•\tBelow 250km, atmospheric drag becomes too high for stable orbits to last long\n" +
                "•\tAbove 1,000km are regions of harmful radiation, called Van-Allen belt\n", R.drawable.leo1,
                "Van-Allen belts are regions of high radiation trapped by the earth’s magnetic field and pose significant risk to astronauts as well as to electronic equipment.\n" +
                        "Due to the relatively low altitude of Low Earth orbits, satellites experience a small amount of atmospheric drag (the gas particles are very thin at those altitudes, but still enough to cause orbital decay over a long time).\n","orbitlogo",4," Geostationary orbit ","•\tAltitude of exactly 35,800km\n" +
                "•\tPeriod of orbit is exactly one day, to match the rotation of the Earth\n" +
                "•\tSatellite flies over the equator\n" +
                "•\tSatellite appears to be ‘parked’ over a fixed point on the surface of the Earth, throughout day and night\n" +
                "•\tPrimarily used by communications satellites\n","From the earth such a satellite appears to be stationary in the sky, always located in the same direction regardless of the time of day. This is particularly useful for communications satellites because a receiving dish need only point to a fixed spot in the sky in order to remain contact with the satellite.\n" +
                "Geosynchronous orbit\n" +
                "\n" + "Like geostationary orbits, geosynchronous orbits are carried out at the altitude (35,800km) which allows orbital period to equal exactly 1 day. The only difference is that geostationary orbits must fly over the equator for the satellite to appear ‘parked’ at a fixed point. Satellites undergoing geosynchronous orbits return to the same location in the sky at the same time of day, " +
                "each day. This is particularly useful for GPS satellites, as they allow just a handful of satellites to completely cover the globe.\n", R.drawable.geo2,"https://www.iridium.com/blog/2018/09/11/satellites-101-leo-vs-geo/"));


        //imagemax 5 uglogo
        subtopic.add(new SubTopic("General Knowledge"," Universal Gravitation ","Newton’s Law of Universal Gravitation\n" +
                "Every point of mass attracts every other point of mass with a force of gravity in the direction along the line joining both points. This force is directly proportional to the product of the two masses and inversely proportional to the square of the distance between the point masses:\n", R.drawable.ugf1,"Where:\n" +
                "•\t F is the magnitude of the gravitational force between the two point masses\n" +
                "•\t G is the gravitational constant, equal to 6.67x10^-11 Nm^2kg^-2 This is provided in your formula sheet\n" +
                "•\t m1 is the mass of the first point mass\n" +
                "•\t m2 is the mass of the second point mass\n" +
                "•\t d is the distance between the two-point masses\n","uglogo",5," Slingshot Effect ","The slingshot effect (also called ‘gravity assist’ or ‘gravitational slingshot’) refers to the use of the motion of a planet to alter the path and speed of an interplanetary spacecraft. The slingshot effect is commonly used by space probes to gain a boost in their velocity as they head out to visit distant planets in our solar system.",
                "An extreme form of the maneuver would be to approach a planet head-on at a speed v while the planet is moving directly toward us at a speed U (both speeds defined relative to the \"fixed\" Solar frame). If we aim just right we can loop around behind the planet in an extremely eccentric hyperbolic orbit, making a virtual 180-degree turn, as illustrated below." +
                        "How it works\n" +
                        "The diagram on the right represents an extreme example. As a spacecraft travelling at a velocity  , approaches a planet moving at an orbital velocity of   relative to the Sun, the spacecraft briefly enters the planet’s orbit, then escapes its gravity once its velocity reaches the maximum.\n" +
                        "As a result, the spacecraft moves away from the planet with a speed of v+2U\n" +
                        "Momentum is conserved, since the spacecraft gains what the planet loses in momentum.\n",R.drawable.ugf2,"https://www.physicsclassroom.com/class/circles/Lesson-3/Newton-s-Law-of-Universal-Gravitation"));

        //imagemax 4  stlogo
        subtopic.add(new SubTopic("General Knowledge"," The Aether Model ", "In the 19th century, Thomas Young’s discovery that light rays interfered with each other led physicists to believe that light is a waveform. At the time, all known waves required a medium in which to propagate (e.g. sound waves, surface waves, mechanical waves etc), so it was logically thought that light must also require a medium in which to propagate.\n" +
                "\n" +
                "This belief led to the proposal of the “aether” (pronounced the same as ‘ether’) as the medium that allows light to travel in space. The aether formed an absolute frame of reference in the Universe and light waves were supposed to have a fixed velocity relative to the aether.\n",R.drawable.stf1,"" +
                "A set of properties of the aether were defined. The aether must:\n" +
                "•\tFill all of space: because light can travel anywhere\n" +
                "•\tBe stationary in space: because light travelled in straight lines. If the aether was in motion, its movement would change the path of light travelling through it.\n" +
                "•\tBe perfectly transparent: since we can’t see it\n" +
                "•\tPermeate all matter: since light can travel through matter (e.g. glass, Perspex, water etc)\n" +
                "•\tHave an extremely low density: since it cannot be weighed or felt as we move through it\n" +
                "•\tHave great elasticity in order to propagate light waves: transfer of energy over long distances requires the medium transmitting the wave to be highly elastic otherwise significant amounts of energy will be “lost” to the particles of the medium.\n","stlogo",4," The Michelson-Morley Experiment ","If the aether existed, it was theorised to be stationary, and as the Earth orbited the Sun, the Earth would be moving through the aether at great speeds. This should result in an apparent ‘aether wind’ that will affect the apparent speed of light to an observer on the Earth.",
                "The Experiment\n" +
                        "Michelson and Morley set up their apparatus on a large stone block floating on mercury. This allowed it to be easily rotated. A light ray from a light source enters a half-silvered mirror and is split into two beams – one beam reflected 90° and the other passing through the mirror.\n" +
                        "Because the two beams travel at 90° to each other, one should be heading into the aether wind and the other should be heading perpendicular to it. Both beams are reflected back by mirrors, and recombined through the half-silvered mirror again.\n" +
                        "The recombined beam enters a detector and produces an interference pattern, as some parts of the recombined beam destructively interfere, while other parts constructively interfere. This first interference pattern was recorded.\n", R.drawable.stf2,"https://arxiv.org/pdf/physics/0011003.pdf"));
        //imagemax 3 srlogo
        subtopic.add(new SubTopic("General Knowledge"," Special Relativity ","The Principle of Relativity\n" +
                "The principle of relativity states that no measurement made within an inertial reference frame can be used to determine the velocity of that frame. This means that when within an inertial frame of reference, it is impossible to determine whether the frame is moving or not, unless measurements are taken involving observations outside of the frame. There is no absolute rest frame against which all motion can be measured since all inertial reference frames are equal.\n",R.drawable.srf1,
                "For example, consider a train that is travelling at a constant velocity. From within the train, there is no observation that " +
                        "can be made to determine whether the train is stopped at a station or travelling at a constant velocity. This is because the train is an inertial frame of reference so long as it is travelling at a constant velocity. The only way to determine the motion of the train is to make observations of other frames of reference outside the train, e.g. by looking out of the window at objects outside.","srlogo",
                3," Einstein’s Theory of Special Relativity ","Einstein's equation E = mc2 shows that energy and mass are interchangeable. The theory of special relativity explains how space and time are linked for objects that are moving at a consistent speed in a straight line.","This violation of the principle of relativity prompted Albert Einstein to propose and analyse several thought experiments. The result of which led him to his theory of Special Relativity which contained two postulates and one statement:\n" +
                "1.\tPostulate 1: The laws of physics are the same in all frames of reference.\n" +
                "2.\tPostulate 2: The speed of light in empty space always has the same value, which is independent of the motion of the observer. The speed of light is given the symbol .\n" +
                "3.\tStatement: The luminiferous aether is superfluous – that is, it is no longer needed to explain the behaviour of light.\n",R.drawable.srf2,"https://www.space.com/36273-theory-special-relativity.html#:~:text=Einstein's%20equation%20E%20%3D%20mc2%20shows%20that%20energy%20and%20mass%20are%20interchangeable.&text=The%20theory%20of%20special%20relativity,speed%20in%20a%20straight%20line."));


        // marsexploration
        //imagemax  3 marslogo
        subtopic.add(new SubTopic("Mars exploration", " Exploration ", "No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet's movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n", R.drawable.marsexplor, "•\tSix spacecraft are in orbit at Mars. NASA's scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India's first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n" +
                "•\tTwo robotic spacecraft are at work on the surface. NASA's Curiosity rover is exploring Mount Sharp in Gale Crater. NASA's InSight, a stationary lander, is probing Mars' interior from a site on a flat smooth plain called Elysium Planitia.\n" +
                "•\tBoth NASA and ESA have plans to send new rovers to Mars in 2020.\n", "marslogo", 3, "Mars general knowledge 1", "Size and Distance\n" +
                "With a radius of 2,106 miles (3,390 kilometers), Mars is about half the size of Earth. If Earth were the size of a nickel, Mars would be about as big as a raspberry.\n" +
                "From an average distance of 142 million miles (228 million kilometers), Mars is 1.5 astronomical units away from the Sun. One astronomical unit (abbreviated as AU), is the distance from the Sun to Earth. From this distance, it takes sunlight 13 minutes to travel from the Sun to Mars.\n" +
                "Orbit and Rotation\n" +
                "As Mars orbits the Sun, it completes one rotation every 24.6 hours, which is very similar to one day on Earth (23.9 hours). Martian days are called sols—short for \"solar day.\" A year on Mars lasts 669.6 sols, which is the same as 687 Earth days.\n" +
                "Mars' axis of rotation is tilted 25 degrees with respect to the plane of its orbit around the Sun. This is another similarity with Earth, which has an axial tilt of 23.4 degrees. Like Earth, Mars has distinct seasons, but they last longer than seasons here on Earth since Mars takes longer to orbit the Sun (because it's farther away). And while here on Earth the seasons are evenly spread over the year, lasting 3 months (or one quarter of a year), on Mars the seasons vary in length because of Mars' elliptical, egg-shaped orbit around the Sun.\n" +
                "Spring in the northern hemisphere (autumn in the southern) is the longest season at 194 sols. Autumn in the northern hemisphere (spring in the southern) is the shortest at 142 days. Northern winter/southern summer is 154 sols, and northern summer/southern winter is 178 sols.\n", "Formation\n" +
                "When the solar system settled into its current layout about 4.5 billion years ago, Mars formed when gravity pulled swirling gas and dust in to become the fourth planet from the Sun. Mars is about half the size of Earth, and like its fellow terrestrial planets, it has a central core, a rocky mantle and a solid crust.\n" +
                "Surface\n" +
                "The Red Planet is actually many colors. At the surface we see colors such as brown, gold and tan. The reason Mars looks reddish is due to oxidization—or rusting—of iron in the rocks, regolith (Martian “soil”), and dust of Mars. This dust gets kicked up into the atmosphere and from a distance makes the planet appear mostly red.\n" +
                "Interestingly, while Mars is about half the diameter of Earth, its surface has nearly the same area as Earth’s dry land. Its volcanoes, impact craters, crustal movement, and atmospheric conditions such as dust storms have altered the landscape of Mars over many years, creating some of the solar system's most interesting topographical features.\n" +
                "A large canyon system called Valles Marineris is long enough to stretch from California to New York—more than 3,000 miles (4,800 kilometers). This Martian canyon is 200 miles (320 kilometers) at its widest and 4.3 miles (7 kilometers) at its deepest. That's about 10 times the size of Earth's Grand Canyon.\n", R.drawable.marsurface, "https://courses.lumenlearning.com/astronomy/chapter/the-geology-of-mars/"));

        //3 mgklogo
        subtopic.add(new SubTopic("Mars exploration","Mars General Knowledge 2 ","Structure\n" +
                "Mars has a dense core at its center between 930 and 1,300 miles (1,500 to 2,100 kilometers) in radius. It's made of iron, nickel and sulfur. Surrounding the core is a rocky mantle between 770 and 1,170 miles (1,240 to 1,880 kilometers) thick, and above that, a crust made of iron, magnesium, aluminum, calcium and potassium. This crust is between 6 and 30 miles (10 to 50 kilometers) deep.\n",R.drawable.mgkf1,"Formation\n" +
                "When the solar system settled into its current layout about 4.5 billion years ago, Mars formed when gravity pulled swirling gas and dust in to become the fourth planet from the Sun. Mars is about half the size of Earth, and like its fellow terrestrial planets, it has a central core, a rocky mantle and a solid crust.\n" +
                "\n","mgklogo",3,"Atmosphere and Magnetosphere","Mars has a thin atmosphere made up mostly of carbon dioxide, nitrogen and argon gases. To our eyes, the sky would be hazy and red because of suspended dust instead of the familiar blue tint we see on Earth. Mars' sparse atmosphere doesn't offer much protection from impacts by such objects as meteorites, asteroids and comets.","" +
                "The temperature on Mars can be as high as 70 degrees Fahrenheit (20 degrees Celsius) or as low as about -225 degrees Fahrenheit (-153 degrees Celsius). And because the atmosphere is so thin, heat from the Sun easily escapes this planet. If you were to stand on the surface of Mars on the equator at noon, it would feel like spring at your feet (75 degrees Fahrenheit or 24 degrees Celsius) and winter at your head (32 degrees Fahrenheit or 0 degrees Celsius).",R.drawable.mgkf2,
                "https://www.space.com/16903-mars-atmosphere-climate-weather.html#:~:text=The%20atmosphere%20of%20Mars%20is,Nitrogen%3A%202.7%20percent"));

        // 2 mclogo
        subtopic.add(new SubTopic("Mars exploration"," Characterize the Climate of Mars ","Mars is an extremely cold planet with an average temperature around minus-80 degrees. Temperatures can dip to minus-225 degrees around the poles. Periods of warmth are brief — highs can reach 70 degrees for a brief time around Noon at the equator in the summer.",R.drawable.mcf1,"What's the Martian Climate Like Today?\n" +
                "\n" +
                "The current Martian climate is regulated by seasonal changes of the carbon dioxide ice caps, the movement of large amounts of dust by the atmosphere and the exchange of water vapor between the surface and the atmosphere. One of the most dynamic weather patterns on Mars is the generation of dust storms that generally occur in the southern spring and summer. These storms can grow to encompass the whole planet. Understanding how these storms develop and grow is one goal of future climatic studies.\n","mclogo",2,
                "What Can the Current Climate on Mars Reveal about the Past?"," better understanding of Mars' current climate will help scientists more effectively model its past climatic behavior. To do that, we'll need detailed weather maps of the planet and information about how much dust and water vapor are in the atmosphere.\n" +
                "\n" +
                "Monitoring the planet for this information over one full Martian year (687 Earth days) will help us understand how Mars behaves over its seasonal cycle and guide us toward understanding how the planet changes over millions of years.\n","The layered terrain of the Martian polar regions also holds clues about the planet's past, much like the rings of a tree provide a record of its history. When and how were these polar layers deposited? Was the climate of Mars ever like that of Earth? And if so, what happened to change the planet into the dry, " +
                "cold, barren desert it is today? Those are the questions that our missions still have to answer.",R.drawable.mcf2,"https://www.washingtonpost.com/news/capital-weather-gang/wp/2015/10/18/the-weather-on-mars-is-both-totally-alien-and-somewhat-earth-like-all-at-once/"));

        //4 mglogo
        subtopic.add(new SubTopic("Mars exploration"," Characterize the geology of Mars ","The geology of Mars is the scientific study of the surface, crust, and interior of the planet Mars. It emphasizes the composition, structure, history, and physical processes that shape the planet. It is analogous to the field of terrestrial geology.", R.drawable.mgf1,"Global Properties of Mars\n" +
                "Mars has a diameter of 6790 kilometers, just over half the diameter of Earth, giving it a total surface area very nearly equal to the continental (land) area of our planet. Its overall density of 3.9 g/cm3 suggests a composition consisting primarily of silicates but with a small metal core. The planet has no global magnetic field, although there are areas of strong surface magnetization that indicate that there was a global field billions of years ago. Apparently, the red planet has no liquid material in its core today that would conduct electricity.\n","mglogo",
                4," Volcanoes on Mars ","the lowland plains of Mars look very much like the lunar maria, and they have about the same density of impact craters. Like the lunar maria, they probably formed between 3 and 4 billion years ago. Apparently, Mars experienced extensive volcanic activity at about the same time the Moon did, producing similar basaltic lavas.","Olympus Mons: The largest volcano on Mars, and probably the largest in the solar system, is Olympus Mons, illustrated in this computer-generated rendering based on data from the Mars Global Surveyor’s " +
                "laser altimeter. Placed on Earth, the base of Olympus Mons would completely cover the state of Missouri; the caldera, the circular opening at the top, is 65 kilometers across, about the size of Los Angeles. (credit: NASA/Corbis)",R.drawable.mgf2,"https://mars.nasa.gov/resources/86/goal-3-characterize-the-geology-of-mars/"));



        // history observation  hologo 5
        subtopic.add(new SubTopic("History Observation","Orbital models", "The Greeks used the word planēton to refer to the seven celestial bodies that moved with respect to the background stars and they held a geocentric view that these bodies moved about the Earth. In his work, The Republic (X.616E–617B), the Greek philosopher Plato provided the oldest known statement defining the order of the planets in Greek astronomical " +
                "tradition. His list, in order of the nearest to the most distant from the Earth, was as follows: the Moon, Sun, Venus, Mercury, Mars, Jupiter, Saturn, and the fixed stars. In his dialogue Timaeus, Plato proposed that the progression of these objects across the skies depended on their distance, so that the most distant object moved the slowest.", R.drawable.hof1, "Aristotle, a student of Plato, observed an occultation of Mars by the Moon on 4 May 357 BCE. From this he concluded that Mars must lie further from the Earth than the Moon. " +
                "He noted that other such occultations of stars and planets had been observed by the Egyptians and Babylonians. Aristotle used this observational evidence to support the Greek sequencing of the planets. His work De Caelo presented a model of the universe in which the Sun, Moon, and planets circle about the Earth at fixed distances. A more sophisticated version of the geocentric model was developed by the Greek astronomer Hipparchus when he proposed that Mars moved along a circular track called the epicycle that, in turn, orbited about the Earth along a " +
                "larger circle called the deferent. ", "hologo", 4, "Claudius Ptolemaeus", "In Roman Egypt during the 2nd century CE, Claudius Ptolemaeus (Ptolemy) attempted to address the problem of the orbital motion of Mars. Observations of Mars had shown that the planet appeared to move 40% faster on one side of its orbit than the other, in conflict with the Aristotelian model of uniform motion. Ptolemy modified the model of planetary motion by adding a point offset from the center of the planet's circular orbit about which " +
                "the planet moves at a uniform rate of rotation. He proposed that the order of the planets, by increasing distance, was: the Moon, Mercury, Venus, Sun, Mars, Jupiter, Saturn, and the fixed stars. Ptolemy's model and his collective work on astronomy was presented in the multi-volume collection Almagest, which became the authoritative treatise on Western astronomy for the next fourteen centuries. \n", "In the 5th century CE, the Indian astronomical text Surya Siddhanta estimated the angular size of Mars as 2 arc-minutes (1/30 of a degree) and its " +
                "distance to Earth as 10,433,000 km (1,296,600 yojana, where one yojana is equivalent to eight km in the Surya Siddhanta). From this the diameter of Mars is deduced to be 6,070 km (754.4 yojana), which has an error within 11% of the currently accepted value of 6,788 km. However, this estimate was based upon an inaccurate guess of the planet's angular size. The result may have been influenced by the work of Ptolemy, who listed a value of 1.57 arc-minutes. Both estimates are significantly larger than the value later obtained by telescope. \n", R.drawable.hof2,
                "https://en.wikipedia.org/wiki/History_of_Mars_observation#:~:text=The%20first%20telescopic%20observation%20of,Planum%20and%20polar%20ice%20caps."));

        // 2  refininglogo
        subtopic.add(new SubTopic("History Observation"," Refining planetary parameters ","Surface obscuration caused by yellow clouds had been noted in the 1870s when they were observed by Schiaparelli. Evidence for such clouds was observed during the oppositions of 1892 and 1907. In 1909, Antoniadi noted that the presence of yellow clouds was associated with the obscuration of albedo features. He discovered that Mars appeared more yellow during oppositions when the planet was closest to the Sun and was receiving more energy. He suggested windblown sand or dust as the cause of the clouds",
                R.drawable.refiningf1,"In 1894, American astronomer William W. Campbell found that the spectrum of Mars was identical to the spectrum of the Moon, throwing doubt on the burgeoning theory that the atmosphere of Mars is similar to that of the Earth. Previous detections of water in the atmosphere of Mars were explained by unfavorable conditions, and Campbell determined that the water signature came entirely from the Earth's atmosphere. ","refininglogo",2," Mars History Observation ","Baltic German astronomer Hermann Struve used the observed changes in the orbits of " +
                "the Martian moons to determine the gravitational influence of the planet's oblate shape. In 1895, he used this data to estimate that the equatorial diameter was 1/190 larger than the polar diameter.[36][73] In 1911, he refined the value to 1/192. This result was confirmed by American meteorologist Edgar W. Woolard in 1944.","Using a vacuum thermocouple attached to the 2.54 m (100 in) Hooker Telescope at Mount Wilson Observatory, in 1924 the American astronomers Seth Barnes Nicholson and Edison Pettit were able to measure the thermal energy being radiated by the surface of Mars. They determined that the temperature " +
                "ranged from −68 °C (−90 °F) at the pole up to 7 °C (45 °F) at the midpoint of the disk (corresponding to the equator).",R.drawable.refiningf2,"https://www.wikiwand.com/en/History_of_Mars_observation#/Refining_planetary_parameters"));



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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
