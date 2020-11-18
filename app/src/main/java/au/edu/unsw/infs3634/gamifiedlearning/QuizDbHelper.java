package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import au.edu.unsw.infs3634.gamifiedlearning.QuizContract.*;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwsomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER," +
                QuestionsTable.COLUMN_CHAPTER + " TEXT" +
                ")";
                //After database change, reinstall or update the database version

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this method is for any changes in the sql database, for example, add another column.
        //that is why we have the database version.

        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        //dummy data stored here for now
        Question q1 = new Question("What is the equation to calculate the gravitational potential energy?", "E=(-GmM)∕r^2", "E = mgh", "E=0.5mv^2", 1,Question.CHAPTER_1);
        addQuestion(q1);
        Question q2 = new Question("Calculate the gravitational potential energy of the entire Earth while it orbits the Sun, given that the Sun has a mass of 2x10^30 kg and the distance of the Earth to the Sun is 1.5x10^11 km.","20*10^22 Joule", "3.56x10^22 Joule", "More information is required for calculation.", 2, Question.CHAPTER_1);
        addQuestion(q2);
        Question q3 = new Question("What is the g-force experienced in a stable orbit","1", "-9.8", "0", 3, Question.CHAPTER_1);
        addQuestion(q3);
        Question q4 = new Question("What was the result of the Michelson–Morley experiment?","Michelson and Morley failed to observe any change in the interference pattern.", "Prove that ether exists", "Determine the accurate speed of light is constant in the same frame of reference. ", 1, Question.CHAPTER_1);
        addQuestion(q4);
        Question q5 = new Question("A satellite orbits Earth with an elliptical orbit, when dose it have the greatest kinetic energy?","Furthest to the Earth", "Closest to the Earth", "The kinetic energy stays the same", 2, Question.CHAPTER_1);
        addQuestion(q5);

        Question q6 = new Question("What is the radius of Mars?","1731.1 KM", "2570 KM", "3390 KM", 3, Question.CHAPTER_2);
        addQuestion(q6);
        Question q7 = new Question("How long is one day on Mars?","24 hours", "24.6 hours", "18.2 hours", 2, Question.CHAPTER_2);
        addQuestion(q7);
        Question q8 = new Question("What is the highest temperature on Mars?","20 degree Celsius", "-8 degree Celsius", "5 degree Celsius", 1, Question.CHAPTER_2);
        addQuestion(q8);
        Question q9 = new Question("Why is understanding the climate on Mars important?","To understand if the Mars will turn into a supernova", "Prepare for Elon Musk's landing", "Understanding the climate of Mars is important to facilitate human exploration and to determine if Mars could have the conditions to support life", 3, Question.CHAPTER_2);
        addQuestion(q9);
        Question q10 = new Question("What had been discovered from the inside of the Martian Meteorite?","Huge amount of Carbon 14", "Tiny gas bubbles, water and organic (carbon-based) compounds in them.", "Only silicon dioxide ", 2, Question.CHAPTER_2);
        addQuestion(q10);

        Question q11 = new Question("When was Aristotle first observed an occultation of Mars?","A", "B", "4 May 357 BCE", 3, Question.CHAPTER_3);
        addQuestion(q11);
        Question q12 = new Question("When was the first standard nomenclature for Martian albedo features was introduced?","1906", "1900", "1960", 3, Question.CHAPTER_3);
        addQuestion(q12);
        Question q13 = new Question("How was the amount of oxygen and water vapor in the atmosphere of Mars measured?","By measuring the weight of the soil relative to the density", "By measuring spectral lines that were redshifted by the orbital motions of Mars and Earth", "By pressurising the air in a chamber and measure the density change", 2, Question.CHAPTER_3);
        addQuestion(q13);
        Question q14 = new Question("How was the thermal energy being radiated by the surface of Mars measured?","Using a reflective telescope attached on the ISS", "Using a vacuum thermocouple attached to the 2.54 m (100 in) Hooker Telescope", "By measuring the temperature change on Mar's surface.", 2, Question.CHAPTER_3);
        addQuestion(q14);
        Question q15 = new Question("When was The Working Group for Planetary System Nomenclature (WGPSN) established?","1973", "1994", "2001", 1, Question.CHAPTER_3);
        addQuestion(q15);

        Question q16= new Question("When will the “Perseverance” be landed?","Sep. 26, 2022", "May. 31, 2025", "Feb. 18, 2021", 3, Question.CHAPTER_4);
        addQuestion(q16);
        Question q17 = new Question("How long is the expected mission duration?","At least 7 Mars year", "36 days Mars day", "At least one Mars year", 3, Question.CHAPTER_4);
        addQuestion(q17);
        Question q18 = new Question("What fuel is used to provide power for the “Persercerance”?","Carbon-14", "Plutonium-238", "Diesel", 2, Question.CHAPTER_4);
        addQuestion(q18);
        Question q19 = new Question("When will/ was the “Perseverance” launched?","Feb. 18, 2022", "July 30, 2020", "C", 2, Question.CHAPTER_4);
        addQuestion(q19);
        Question q20 = new Question("How many cameras are on the “Persercerance”?","19", "B", "C", 1, Question.CHAPTER_4);
        addQuestion(q20);

        Question q21 = new Question("How high is Olympus Mons - the tallest mountain - in the solar system?","190 KM", "77 KM", "21 KM", 3, Question.CHAPTER_5);
        addQuestion(q21);
        Question q22 = new Question("What color is the sunset on Mars?","Yellow", "Same as mars", "Blue", 3, Question.CHAPTER_5);
        addQuestion(q22);
        Question q23 = new Question("How many missions to Mars have been successful (Until 2020)","27", "18", "5", 2, Question.CHAPTER_5);
        addQuestion(q23);
        Question q24 = new Question("Which Planet has the largest dust storms in the solar system?","Jupiter", "Mars", "Earth", 2, Question.CHAPTER_5);
        addQuestion(q24);
        Question q25 = new Question("What is Mar's surface gravity relative to the Earth?","37% of the Earth", "10% of the Earth", "1.3 times of the Earth", 1, Question.CHAPTER_5);
        addQuestion(q25);

    }


    private void addQuestion(Question question) {
        //adding the questions in "fillquestiontable" into the database
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_CHAPTER, question.getDifficulty());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }
    public ArrayList<Question> getAllQuestions(){
        ArrayList<Question> questionList = new ArrayList<>();
        db= getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                //getting the question from database
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CHAPTER)));
                questionList.add(question); //import the question to the array list
            } while (c.moveToNext());
        }
        c.close();
        return questionList;

    } public ArrayList<Question> getQuestions(String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String[] selectionArgs = new String[]{difficulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME +
                " WHERE " + QuestionsTable.COLUMN_CHAPTER + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CHAPTER)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}