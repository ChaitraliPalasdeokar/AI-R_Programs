package com.example.android.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {


    //DB version, table and database name
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "quizdb";
    private static final String DB_TABLE = "quiztable";

    //table column names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "optA";
    private static final String KEY_OPTB = "optB";
    private static final String KEY_OPTC = "optC";

    private SQLiteDatabase dbase;
    private int rowCount = 0;

    public DbHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sqlQuery = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT )", DB_TABLE, KEY_ID, KEY_QUES, KEY_ANSWER, KEY_OPTA, KEY_OPTB, KEY_OPTC);
        //Log.d("TaskDBHelper", "Query to form table" + sqlQuery);
        db.execSQL(sqlQuery);
        addQuestions();
    }

    private void addQuestions() {
        Question q1 = new Question(" A box of 150 packets consists of 1kg packets and 2kg packets. Total weight of box is 264kg. How many 2kg packets are there ?", "114", "100", "90", "114");
        this.addQuestionToDB(q1);
        Question q2 = new Question("Which of the following is NOT an operating system ?", "Linux", "BIOS", "DOS", "BIOS");
        this.addQuestionToDB(q2);
        Question q3 = new Question("My flight takes of at 2am from a place at 18N 10E and landed 10 Hrs later at a place with coordinates 36N70W. What is the local time when my plane landed?", "6:00 AM", "6:40 AM", "7:00 AM", "6:40 AM");
        this.addQuestionToDB(q3);
        Question q4 = new Question("Y catches 5 times more fishes than X. If total number of fishes caught by X and Y is 42, then number of fishes caught by X?", "35", "40", "32", "35");
        this.addQuestionToDB(q4);
        Question q5 = new Question("Complete the following:It is __ absurd story", "a", "an", "the", "an");
        this.addQuestionToDB(q5);
        Question q6 = new Question("Identify the tense:Are you playing tennis?", "simple present", "simple past ", "present continuous ", "present continuous");
        this.addQuestionToDB(q6);
        Question q7 = new Question("One afternoon, Manisha and Madhuri were talking to each other face to face in Bhopal on M.G. Road. If Manisha’s shadow was exactly to the exactly to the left of Madhuri, which direction was Manisha facing?", "East", "North", "South", "North");
        this.addQuestionToDB(q7);
        Question q8 = new Question("Odd man out: 1, 2, 4, 8, 16, 32, 64, 96", "64", "32", "96", "96");
        this.addQuestionToDB(q8);
        Question q9 = new Question("Two of the following four are alike in a certain way and so form a group. Which is the one that does not belong to that group?", "Air: Suffocation ", "Water: Thirst ", "Talent: Education", "Talent: Education");
        this.addQuestionToDB(q9);
        Question q10 = new Question("The sum of four consecutive even numbers is 292. What would be the smallest number?", "74", "70", "60", "70");
        this.addQuestionToDB(q10);
        Question q11 = new Question("A fair price shopkeeper takes 10% profit on his goods. He lost 20% goods during theft. His loss percent is?", "12", "10", "11", "12");
        this.addQuestionToDB(q11);
        Question q12 = new Question("If the sum and difference of two numbers are 20 and 8 respectively, then the difference of their square is?", "180", "160", "28", "160");
        this.addQuestionToDB(q12);
        Question q13 = new Question("The H.C.F and L.C.M of two numbers are 84 and 21 respectively. If the ratio of the two numbers is 1:4, then the larger of the two numbers is?", "48", "12", "84", "84");
        this.addQuestionToDB(q13);
        Question q14 = new Question("Kim can do a work in 3 days while David can do the same work in 2 days. Both of them finish the work together and get Rs. 150. What is the share of Kim?", "Rs.30", "Rs.60", "Rs.70", "Rs.60");
        this.addQuestionToDB(q14);
        Question q15 = new Question("Excluding stoppages, the speed of a bus is 54 km/hr and including stoppages, it is 45 km/hr. For how many minutes does the bus stop per hour?", "9", "10", "12", "10");
        this.addQuestionToDB(q15);
        Question q16 = new Question("Salaries of Ravi and Sumit are in the ratio 2:3. If the salary of each is increased by Rs. 4000, the new ratio becomes 40:57. What is Sumit’s present salary?", "17000", "28000", "None of these", "None of these");
        this.addQuestionToDB(q16);
        Question q17 = new Question("Add a question tag:I never drink Coke________", "did I?", "didn't I?", "do I?", "do I?");
        this.addQuestionToDB(q17);
        Question q18 = new Question("A Train,130 metres long travels at speed of 45km/hr crosses a bridge in 30 second.Calculate length of Bridge?", "245 mtrs", "270 mtrs", "265 mtrs", "245 mtrs");
        this.addQuestionToDB(q18);
        Question q19 = new Question("If selling price is doubled ,the profit triples.What is the Profit Percent?", "80%", "100%", "75%", "100%");
        this.addQuestionToDB(q19);
        Question q20 = new Question("If 20% of a=b,then b% of 20 is the same as:?", "14% of a", "4% of a", "10% of a", "4% of a");
        this.addQuestionToDB(q20);
        Question q21 = new Question("A number whose fifth part increased by 5 is equal to its fourth part diminished by 5, is?", "100", "200", "300", "300");
        this.addQuestionToDB(q21);
        Question q22 = new Question("What percentage of numbers from 1 to 70 have 1 or 9 in the unit's digit?", "50%", "21%", "20%", "20%");
        this.addQuestionToDB(q22);
        Question q23 = new Question("What percent of a day is 6 hours?", "11%", "25%", "35%", "25%");
        this.addQuestionToDB(q23);
        Question q24 = new Question("Three coins are tossed.What is the probability of getting at most two tails?", "7/8", "1/8", "1/7", "7/8");
        this.addQuestionToDB(q24);
        Question q25 = new Question("The Compound Interest on Rs 30,000 at 7% per annum is Rs 4347.The period in years is:", "2", "1", "3", "2");
        this.addQuestionToDB(q25);
        Question q26=new Question("Which is Correct 1. Turcuoise 2. Turcuiose 3. Turquoise","1","2","3","2");
        this.addQuestionToDB(q26);
        Question q27=new Question("Insert the missing number:12,25,49,99,197,395,......","789","722","832","789");
        this.addQuestionToDB(q27);
        Question q28=new Question("Yours mother's father's son has one boy child have what relationship with you?","brother","uncle","cousin","cousin");
        this.addQuestionToDB(q28);
        Question q29=new Question("A is twice as fast as B and B is thrice as fast as C is. The journey covered by C in 42 minutes, will be covered by A in?","11 min","7 min","8 min","7 min");
        this.addQuestionToDB(q29);
        Question q30=new Question("4,3,5,9,12,17,____ ","14","89","26","26");
        this.addQuestionToDB(q30);
        Question q31=new Question("The orator was so ______ that the audience became ______","Soporific, drowsy","Inaudible, elated","Pompous, bombastic","Soporific, drowsy");
        this.addQuestionToDB(q31);
        Question q32=new Question(" Find out the Simple Interest paid for a sum of Rs. 4000 at the rate of 8% per annum for 3 months","800","880","80","80");
        this.addQuestionToDB(q32);
        Question q33=new Question("  ELFA, GLHA, ILJA, _____, MLNA","OLPA","KLLA","KLMA","KLLA");
        this.addQuestionToDB(q33);
        Question q34=new Question("Arrange the words given below in a meaningful sequence. 1. Protect 2. Pressure 3. Relief 4. Rain 5. Flood","2, 4, 5, 1, 3", "2, 4, 3, 1, 5", "2, 5, 4, 1, 3","2, 4, 5, 1, 3");
        this.addQuestionToDB(q34);
        Question q35=new Question("If a selection is to be made among them who would be relatively older and also taller, who among them should be chosen?","A","B","C","B");
        this.addQuestionToDB(q35);
        Question q36=new Question("If 10x coins are added to the number of original coins he has (5y + 1) times more coins. Find out how many coins he had originally in terms of x and y.\n","2x / y", "x / y", "x / y","2x / y");
        this.addQuestionToDB(q36);
        Question q37=new Question("We must try to understand his momentary ______ for he has ______ more strain and anxiety than any among us.","Senility, understood","Vision, forgotten","Aberration, undergone","Aberration, undergone");
        this.addQuestionToDB(q37);
        Question q38=new Question("To 15 liters of water containing 20% alcohol, we add 5 liters of pure water. What is % alcohol?To 15 liters of water containing 20% alcohol, we add 5 liters of pure water. What is % alcohol?","10%", "15%", "20%","15%");
        this.addQuestionToDB(q38);










    }

    public void addQuestionToDB(Question q){
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, q.getQuestion());
        values.put(KEY_ANSWER,q.getAnswer());
        values.put(KEY_OPTA,q.getOptA());
        values.put(KEY_OPTB,q.getOptB());
        values.put(KEY_OPTC,q.getOptC());
        dbase.insert(DB_TABLE, null, values);
    }

    public List<Question> getAllQuestions(){
        List <Question> questionList = new ArrayList<Question>();

        dbase = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+DB_TABLE;
        Cursor cursor = dbase.rawQuery(selectQuery,null);
        //rowCount = cursor.getCount();

        if(cursor.moveToFirst()){
            do{
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion(cursor.getString(1));
                q.setAnswer(cursor.getString(2));
                q.setOptA(cursor.getString(3));
                q.setOptB(cursor.getString(4));
                q.setOptC(cursor.getString(5));

                questionList.add(q);

            }while (cursor.moveToNext());
        }
        return questionList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DB_TABLE);
        onCreate(db);
    }

    public int getRowCount(){
        return rowCount;
    }






    public boolean insert(String question,String optA,String optB,String optC,String correct){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("question",question);
        contentValues.put("answer",correct);
        contentValues.put("optA",optA);
        contentValues.put("optB",optB);
        contentValues.put("optC",optC);
        long ins=db.insert("quiztable",null,contentValues);
        if(ins==-1) return false;
        else
            return true;
    }


    //didnt work
    /*public boolean delete(String question){
        SQLiteDatabase db=this.getWritableDatabase();

        //String s1 []={"question","correct","optA","optB","optC"};
        //long ins=db.delete("quiztable","question",s1);
        //db.execSQL("delete from "+DB_TABLE+" where "+ KEY_QUES+"=" + "'question'");
        int result=db.delete(DB_TABLE,KEY_QUES+"="+"'question'",null);
        if(result==-1)return false;
        else
            return true;

    }*/





}
