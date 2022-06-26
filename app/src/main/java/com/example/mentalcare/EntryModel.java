package com.example.mentalcare;

public class EntryModel {
    private int EntryId;
    private String InfoText;
    private String MoodValue;
    private int DayValue;


    //constructors
    public EntryModel(int entryId, String moodValue, int dayValue,String infoText ) {
        EntryId = entryId;
        MoodValue = moodValue;
        DayValue = dayValue;
        InfoText = infoText;

    }

    public EntryModel() {
    }

    //toString method
    @Override
    public String toString() {
        return  "Day: " + EntryId + "\n"+ "\n"+
                "Mood of the Day: " + MoodValue + "\n"+ "\n"+
                "Your comment on the day: " + InfoText;
    }

    //getters and setters
    public String getInfoText() {
        return InfoText;
    }

    public void setInfoText(String infoText) {
        InfoText = infoText;
    }

    public String getMoodValue() {
        return MoodValue;
    }

    public void setMoodValue(String moodValue) {
        MoodValue = moodValue;
    }

    public int getDayValue() {
        return DayValue;
    }

    public void setDayValue(int dayValue) {
        DayValue = dayValue;
    }

    public int getEntryId() {
        return EntryId;
    }

    public void setEntryId(int entryId) {
        EntryId = entryId;
    }
}
