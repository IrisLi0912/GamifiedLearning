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
        Question q3 = new Question("What is the g-force experienced in a stable orbit","1", "-9.8", "0", 3, Question.CHAPTER_2);
        addQuestion(q3);
        Question q4 = new Question("Hard: A is correct","A", "B", "C", 1, Question.CHAPTER_3);
        addQuestion(q4);
        Question q5 = new Question("Hard: B is correct","A", "B", "C", 2, Question.CHAPTER_3);
        addQuestion(q5);
        Question q6 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q6);
        Question q7 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q7);
        Question q8 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q8);
        Question q9 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q9);
        Question q10 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q10);
        Question q11 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q11);
        Question q12 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q12);
        Question q13 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q13);
        Question q14 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q14);
        Question q15 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q15);
        Question q16= new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q16);
        Question q17 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q17);
        Question q18 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q18);
        Question q19 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q19);
        Question q20 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q20);
        Question q21 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q21);
        Question q22 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q22);
        Question q23 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q23);
        Question q24 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
        addQuestion(q24);
        Question q25 = new Question("Hard: C is correct","A", "B", "C", 3, Question.CHAPTER_3);
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