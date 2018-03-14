package com.degree.abbylaura.rumma_server.Database.Repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.degree.abbylaura.rumma_server.Database.Data.DatabaseManager;
import com.degree.abbylaura.rumma_server.Database.Schema.TeamFixtures;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by abbylaura on 02/03/2018.
 */

public class TeamFixturesRepo {
    private TeamFixtures teamFixtures;
    private String whereClause = "";

    public TeamFixturesRepo(){

        teamFixtures = new TeamFixtures();

    }


    public static String createTable(){
        return "CREATE TABLE " + TeamFixtures.TABLE  + "("
                + TeamFixtures.KEY_FixtureId  + "   PRIMARY KEY,"
                + TeamFixtures.KEY_TeamFixtureDate + " TEXT,"
                + TeamFixtures.KEY_TeamFixtureLocation + " TEXT)";
    }


    public int insert(TeamFixtures teamFixtures) {
        int tfID;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(TeamFixtures.KEY_FixtureId, teamFixtures.getFixtureId());
        values.put(TeamFixtures.KEY_TeamFixtureDate, teamFixtures.getFixtureDate());
        values.put(TeamFixtures.KEY_TeamFixtureLocation, teamFixtures.getFixtureLocation());


        // Inserting Row
        tfID=(int)db.insert(TeamFixtures.TABLE, null, values);
        DatabaseManager.getInstance().closeDatabase();

        return tfID;
    }



    public void delete( ) {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        db.delete(TeamFixtures.TABLE,null,null);
        DatabaseManager.getInstance().closeDatabase();
    }



}
