package com.example.android.miwok;

/**
 * Created by prave on 5/7/2017.
 */

public class Word {

    private String mDefaultTransalation;

    private String mMiwokTransalation;

    public Word(String DefaultTransalation, String MiwokTransalation)
    {
        mDefaultTransalation=DefaultTransalation;
        mMiwokTransalation=MiwokTransalation;
    }
    public String getDefaultTransalation()
    {
        return mDefaultTransalation;

    }

    public String getMiwokTransalation()
    {
        return mMiwokTransalation;
    }
}
