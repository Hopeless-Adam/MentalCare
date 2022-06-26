package com.example.mentalcare;

public class EntryCoords {
    private int EntryId;
    private String MoodValue;

    public EntryCoords(int entryId, String moodValue) {
        EntryId = entryId;
        MoodValue = moodValue;
    }

    public EntryCoords() {
    }


    @Override
    public String toString() {
        return EntryId +","+ MoodValue + " ";
    }

    public int getEntryId() {
        return EntryId;
    }

    public void setEntryId(int entryId) {
        EntryId = entryId;
    }

    public String getMoodValue() {
        return MoodValue;
    }

    public void setMoodValue(String moodValue) {
        MoodValue = moodValue;
    }
}
