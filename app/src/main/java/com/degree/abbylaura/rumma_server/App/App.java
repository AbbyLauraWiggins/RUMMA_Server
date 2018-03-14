package com.degree.abbylaura.rumma_server.App;

import android.app.Application;
import android.content.Context;

import com.degree.abbylaura.rumma_server.Database.Data.DatabaseHelper;
import com.degree.abbylaura.rumma_server.Database.Data.DatabaseManager;

/**
 * Created by abbylaura on 02/03/2018.
 */

public class App extends Application {
    private static Context context;
    private static DatabaseHelper dbHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        dbHelper = new DatabaseHelper();
        DatabaseManager.initializeInstance(dbHelper);

    }

    public static Context getContext(){
        return context;
    }

}