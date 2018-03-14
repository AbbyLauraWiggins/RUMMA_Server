package com.degree.abbylaura.rumma_server.Database.Data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.degree.abbylaura.rumma_server.App.App;
import com.degree.abbylaura.rumma_server.Database.Repo.FixtureRepo;
import com.degree.abbylaura.rumma_server.Database.Repo.KPIRepo;
import com.degree.abbylaura.rumma_server.Database.Repo.MemberRepo;
import com.degree.abbylaura.rumma_server.Database.Repo.NoticeRepo;
import com.degree.abbylaura.rumma_server.Database.Repo.SessionRepo;
import com.degree.abbylaura.rumma_server.Database.Repo.StrengthAndConditioningRepo;
import com.degree.abbylaura.rumma_server.Database.Repo.TeamFixturesRepo;
import com.degree.abbylaura.rumma_server.Database.Repo.TeamRepo;
import com.degree.abbylaura.rumma_server.Database.Schema.Fixture;
import com.degree.abbylaura.rumma_server.Database.Schema.KPI;
import com.degree.abbylaura.rumma_server.Database.Schema.Member;
import com.degree.abbylaura.rumma_server.Database.Schema.Notice;
import com.degree.abbylaura.rumma_server.Database.Schema.Session;
import com.degree.abbylaura.rumma_server.Database.Schema.StrengthAndConditioning;
import com.degree.abbylaura.rumma_server.Database.Schema.Team;
import com.degree.abbylaura.rumma_server.Database.Schema.TeamFixtures;

/**
 * Created by abbylaura on 02/03/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //note: remember each time if you Add, Edit table, you need to change the version number.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "serverDatabase.db";
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    public DatabaseHelper( ) {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + Fixture.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Member.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Session.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + StrengthAndConditioning.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Team.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TeamFixtures.TABLE);

        db.execSQL("DROP TABLE IF EXISTS " + Notice.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + KPI.TABLE);


        //All necessary tables you like to create will create here
        db.execSQL(FixtureRepo.createTable());
        db.execSQL(MemberRepo.createTable());
        db.execSQL(SessionRepo.createTable());
        db.execSQL(StrengthAndConditioningRepo.createTable());
        db.execSQL(TeamRepo.createTable());
        db.execSQL(TeamFixturesRepo.createTable());

        db.execSQL(NoticeRepo.createTable());
        db.execSQL(KPIRepo.createtable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("DBHELPER onUpgrade", oldVersion, newVersion));

        // Drop table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Fixture.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Member.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Session.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + StrengthAndConditioning.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Team.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TeamFixtures.TABLE);

        db.execSQL("DROP TABLE IF EXISTS " + Notice.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + KPI.TABLE);

        onCreate(db);
    }
}
