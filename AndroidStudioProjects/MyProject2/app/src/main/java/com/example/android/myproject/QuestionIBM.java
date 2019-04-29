package com.example.android.myproject;

public class QuestionIBM {

    public String mQuestions[]={
            "1.A Train,130 metres long travels at speed of 45km/hr crosses a bridge in 30 second.Calculate length of Bridge?",
            "2.What annual installment will discharge a debt of Rs. 4600 due in 4 years at 10% simple interest?",
            "3.If selling price is doubled ,the profit triples.What is the Profit Percent?",
            "4.If 20% of a=b,then b% of 20 is the same as:?",
            "5.A number whose fifth part increased by 5 is equal to its fourth part diminished by 5, is?",
            "6.What percentage of numbers from 1 to 70 have 1 or 9 in the unit's digit?",
            "7.What percent of a day is 6 hours?",
            "8.How many litres of pure acid are there in 8 litres of a 20% solution?",
            "9.Which of the following can be considered to be the central idea of the passage?",
            "10.Three coins are tossed.What is the probability of getting at most two tails? ",
            "11.A is twice as fast as B and B is thrice as fast as C is. The journey covered by C in 42 minutes, will be covered by A in?",
            "12.The Compound Interest on Rs 30,000 at 7% per annum is Rs 4347.The period in years is:",
            "13.Insert the missing number:12,25,49,99,197,395,......",
            "14.What is cube root of 0.000729 ?  ",
            "15.Average of first five multiples of 9?",
            "16.Select the correct one",
            "17.Which is Correct 1. Turcuoise 2. Turcuiose 3. Turquoise",
            "18.Yours mother's father's son has one boy child have what relationship with you? ",
            "19.A person who is obsessed with self",
            "20. 4,3,5,9,12,17,____ ?",
// "21.A man rows downstream 30 km and upstream 18 km, taking 5 hours each time. What is the velocity of the stream (current)?"
    };
    private String mChoices[][]={
            {"245 mtrs","270 mtrs","220 mtrs"},
            {"1000","1009","1900"},
            {"80%","100%","75%"},
            {"4% of a","10% of a","20% of a"},
            {"100","200","300"},
            {"50%","21%","20%"},
            {"11%","30%","25%"},
            {"1.6 litres","3 litres","5 litres"},
            {"Experience made art, but inexperience luck","Art is superior to experience","What actually is Wisdom"},
            {"7/8","1/8","1/7"},
            {"11 min","7 min","8 min"},
            {"1","2","3"},
            {"722","812","789"},
            {"0.9","0.09","0.009"},
            {"20","27","28"},
            {"He has studied English since five years","He has studied English for five years","He has studied English from five years"},
            {"1","2","3"},
            {"brother","uncle","cousin"},
            {"Stunnning","Staggering","Narcissist"},
            {"14","89","26"},
/* {"1.2 km/hr","2.5 km/hr","1.5 km/hr"}*/
    };
    private String correctAnswer[]={"245 mtrs",
            "1000",
            "100%",
            "4% of a",
            "200",
            "20%",
            "25%",
            "1.6 litres",
            "What actually is Wisdom",
            "7/8",
            "7 min",
            "2",
            "789",
            "0.09",
            "27",
            "He has studied English for five years",
            "3",
            "cousin",
            "Narcissist",
            "26",
// "1.2 km/hr"
    };
    public String getQuestions(int a){
        String question=mQuestions[a];
        return question;
    }
    public  String getchoices1(int a){
        String choices1=mChoices[a][0];
        return choices1;
    }
    public  String getchoices2(int a){
        String choices2=mChoices[a][1];
        return choices2;
    }
    public  String getchoices3(int a){
        String choices3=mChoices[a][2];
        return choices3;
    }
    public String getCorrectAnswer(int a){
        String answer=correctAnswer[a];
        return answer;
    }
}
