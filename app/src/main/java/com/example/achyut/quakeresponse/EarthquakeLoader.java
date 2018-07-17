// Copyright (C) 2018 Achyut Ghosh
package com.example.achyut.quakeresponse;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import java.util.List;

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages*/
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL*/
    private String mURL;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mURL = url;
    }

    @Override
    protected void onStartLoading() {

        //Log message
        Log.i(LOG_TAG, "onStartLoading() method loading..");

        //Start loading data
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Earthquake> loadInBackground() {

        //Log message
        Log.i(LOG_TAG, "loadInBackground() method loading..");

        if (mURL == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mURL);
        return earthquakes;

    }
}
