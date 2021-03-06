package barryalan.ediary70;

/**
 * Created by Al on 9/20/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



class databaseHelper extends SQLiteOpenHelper {


    //CLASS VARIABLES-------------------------------------------------------------------------------
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "LoginManager";
    public static final String TABLE_USER = "users";

    //CLASS VARIABLES FOR HEALTH AND CARE TABLE
    private static final String DATABASE_NAME2 = "HealthCare";
    private static final String HEALTH_TABLE= "health";



    //USER TABLE COLUMN NAMES-----------------------------------------------------------------------
    public static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_USERNAME = "user_username";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    //TABLE COLUMN NAMES FOR HEALTH
    private static final String COLUMN_USER_ALLERGIES = "allergies_name";
    private static final String COLUMN_USER_MEDICATION = "med_name";
    private static final String COLUMN_USER_VITALSIGNS = "vital_name";
    private static final String COLUMN_USER_DIET = "diet_name";
    private static final String COLUMN_USER_EXCERCISEPLAN = "excercise_plan";

    //TABLE COLUMN NAMES FOR PERSONAL GOALS
    public static final String COLUMN_USER_SGOALSNAME = "short_goal1";
    private static final String COLUMN_USER_SGOALSDEP = "short_goal2";
    private static final String COLUMN_USER_SGOALSTIME = "short_goal3";
    private static final String COLUMN_USER_GOALS4 = "short_goal4";
    private static final String COLUMN_USER_LONGGOALS = "long_goals";

    //NETWORKS & CONTACTS TABLE---------------------------------------------------------------------
    //table name
    private static final String TABLE_NC = "networks & contacts";
    private static final String COLUMN_NC_USER_ID = COLUMN_USER_ID;
    private static final String COLUMN_NC_USER_NAME = COLUMN_USER_NAME;
    public static final String COLUMN_NC_NAME = "nc_contact_name";
    public static final String COLUMN_NC_AFFILIATION = "nc_affiliation";
    public static final String COLUMN_NC_DATE = "nc_date";
    public static final String COLUMN_NC_NUMBER_USAGES = "nc_usages";
    public static final String COLUMN_NC_COMMENTS = "nc_comments";

    //FINANCIAL GOALS TABLE
    private static final String TABLE_FG = "financial goals";
    private static final String COLUMN_FG_USER_ID = COLUMN_USER_ID;
    private static final String COLUMN_FG_USER_NAME = COLUMN_USER_NAME;
    public static final String COLUMN_FG_CASH = "fg_cash";
    public static final String COLUMN_FG_ASSETS = "fg_assets";
    public static final String COLUMN_FG_LIABILITIES = "fg_liabilities";
    public static final String COLUMN_FG_CREDITCARD1 = "fg_creditcard1";
    public static final String COLUMN_FG_CREDITCARD1_B = "fg_creditcard1_b";
    public static final String COLUMN_FG_CREDITCARD2 = "fg_creditcard2";
    public static final String COLUMN_FG_CREDITCARD2_B = "fg_creditcard2_b";
    public static final String COLUMN_FG_STOCKS = "fg_stocks";
    public static final String COLUMN_FG_SGOALSNAME = "fg_shortgoal_name";
    public static final String COLUMN_FG_SGOALSDEP = "fg_shortgoal_dep";
    public static final String COLUMN_FG_SGOALSDTIME = "fg_shortgoal_time";
    public static final String COLUMN_FG_LGOALSNAME = "fg_longtermgoal_name";
    public static final String COLUMN_FG_LGOALSDEP = "fg_longtermgoal_dep";
    public static final String COLUMN_FG_LGOALSTIME = "fg_longtermgoal_time";

    //CAREER & EDUCATIONAL GOALS
    private static final String TABLE_CE = "career & education goals";
    private static final String COLUMN_CE_USER_ID = COLUMN_USER_ID;
    private static final String COLUMN_CE_USER_NAME = COLUMN_USER_NAME;
    private static final String COLUMN_CE_GOAL = "goal";

    //Constructor
    databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATES QUERY
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER
                + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_USERNAME + " TEXT,"
                + COLUMN_USER_EMAIL + " TEXT,"
                + COLUMN_USER_PASSWORD + " TEXT,"
                + COLUMN_USER_ALLERGIES + " TEXT,"
                + COLUMN_USER_MEDICATION + " TEXT,"
                + COLUMN_USER_DIET + " TEXT,"
                + COLUMN_USER_EXCERCISEPLAN + " TEXT,"
                + COLUMN_USER_VITALSIGNS + " TEXT,"
                + COLUMN_USER_SGOALSNAME + " TEXT,"
                + COLUMN_USER_SGOALSDEP + " TEXT,"
                + COLUMN_USER_SGOALSTIME + " TEXT,"
                + COLUMN_USER_GOALS4 + " TEXT,"
                + COLUMN_USER_LONGGOALS + " TEXT"
                + ")";

        //CREATES NETWORKS & CONTACTS TABLE
        String CREATE_NETWORKS_CONTACTS_TABLE = " CREATE TABLE " + TABLE_NC
                + "("
                + COLUMN_NC_USER_ID  + " INTEGER PRIMARY KEY,"
                + COLUMN_NC_USER_NAME + " TEXT,"
                + COLUMN_NC_NAME + " TEXT,"
                + COLUMN_NC_AFFILIATION + " TEXT,"
                + COLUMN_NC_DATE  + " TEXT,"
                + COLUMN_NC_NUMBER_USAGES + " TEXT,"
                + COLUMN_NC_COMMENTS + " TEXT"
                + ")";

        //CREATES FINANCIAL GOALS TABLE
        String CREATE_FINANCIAL_GOALS_TABLE = " CREATE TABLE " + TABLE_FG
                + "("
                + COLUMN_FG_USER_ID   + " INTEGER PRIMARY KEY,"
                + COLUMN_FG_USER_NAME + " TEXT,"
                + COLUMN_FG_CASH + " TEXT,"
                + COLUMN_FG_ASSETS + " TEXT,"
                + COLUMN_FG_LIABILITIES  + " TEXT,"
                + COLUMN_FG_CREDITCARD1 + " TEXT,"
                + COLUMN_FG_CREDITCARD1_B + " TEXT,"
                + COLUMN_FG_CREDITCARD2 + " TEXT,"
                + COLUMN_FG_CREDITCARD2_B + " TEXT,"
                + COLUMN_FG_STOCKS  + " TEXT,"
                + COLUMN_FG_SGOALSNAME + " TEXT,"
                + COLUMN_FG_SGOALSDEP + " TEXT,"
                + COLUMN_FG_SGOALSDTIME + " TEXT,"
                + COLUMN_FG_LGOALSNAME  + " TEXT,"
                + COLUMN_FG_LGOALSDEP  + " TEXT,"
                +  COLUMN_FG_LGOALSTIME+ " TEXT"
                + ")";

        //CREATES CAREER & EDUCATION GOALS
        String CREATE_CE_GOALS_TABLE = " CREATE TABLE " + TABLE_CE
                + "("
                + COLUMN_CE_USER_ID   + " INTEGER PRIMARY KEY,"
                + COLUMN_CE_USER_NAME + " TEXT,"
                + COLUMN_CE_GOAL + " TEXT"
                + ")";

        //CREATES TABLE IN THE DATABASE USING THE QUERY
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_NETWORKS_CONTACTS_TABLE);
        db.execSQL(CREATE_FINANCIAL_GOALS_TABLE );
        db.execSQL(CREATE_CE_GOALS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
        String DROP_NETWORKS_CONTACTS_TABLE = "DROP TABLE IF EXISTS " + TABLE_NC;
        String DROP_FINANCIAL_GOALS_TABLE = "DROP TABLE IF EXISTS " + TABLE_NC;
        String DROP_CE_GOALS_TABLE = "DROP TABLE IF EXISTS " + TABLE_CE;
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_NETWORKS_CONTACTS_TABLE);
        db.execSQL(DROP_FINANCIAL_GOALS_TABLE);
        db.execSQL(DROP_CE_GOALS_TABLE);

        onCreate(db);
    }

    void addUser(user user) {

        SQLiteDatabase db = this.getWritableDatabase();

        //Creating columns with information and inputting them into values
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUserName());
        values.put(COLUMN_USER_USERNAME, user.getUserUsername());
        values.put(COLUMN_USER_EMAIL, user.getUserEmail());
        values.put(COLUMN_USER_PASSWORD, user.getuserPassword());
        values.put(COLUMN_USER_ALLERGIES, user.getUserAllergies());
        values.put(COLUMN_USER_MEDICATION, user.getUserMedications());
        values.put(COLUMN_USER_DIET, user.getUserDiet());
        values.put(COLUMN_USER_EXCERCISEPLAN, user.getUserExcercisePlan());
        values.put(COLUMN_USER_VITALSIGNS, user.getUserVitalSigns());
        values.put(COLUMN_USER_SGOALSNAME, user.getUserGoalNames());
        values.put(COLUMN_USER_SGOALSDEP, user.getUserGoalDescriptions());
        values.put(COLUMN_USER_SGOALSTIME, user.getUserGoalTimes());

        //Inserting values into the database under the user
        db.insert(TABLE_USER, null, values);
        //Closing database
        db.close();
    }

    //create networks and Contacts columns----------------------------------------------------------
    void addNetworksContacts(networksandcontactsDAO networksandcontactsDAO) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NC_NAME, networksandcontactsDAO.getNcContactsName());
        values.put(COLUMN_NC_AFFILIATION, networksandcontactsDAO.getNcAffiliation());
        values.put(COLUMN_NC_DATE, networksandcontactsDAO.getNcDate());
        values.put(COLUMN_NC_NUMBER_USAGES, networksandcontactsDAO.getNcUsages());
        values.put(COLUMN_NC_COMMENTS, networksandcontactsDAO.getNcComments());

        //INSERTING VALUES INTO THE DATABASE UNDER THE USER
        db.insert(TABLE_NC, null, values);
        //CLOSING DATABASE
        db.close();
    }

    public int updateUser(user user) {

        SQLiteDatabase db = this.getWritableDatabase();

        //Creating columns with information from the parameter and inputting them into values
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getUserName());
        values.put(COLUMN_USER_USERNAME, user.getUserUsername());
        values.put(COLUMN_USER_EMAIL, user.getUserEmail());
        values.put(COLUMN_USER_ALLERGIES, user.getUserAllergies());
        values.put(COLUMN_USER_MEDICATION, user.getUserMedications());
        values.put(COLUMN_USER_VITALSIGNS, user.getUserVitalSigns());
        values.put(COLUMN_USER_DIET, user.getUserDiet());
        values.put(COLUMN_USER_EXCERCISEPLAN, user.getUserExcercisePlan());
        values.put(COLUMN_USER_SGOALSNAME, user.getUserGoalNames());
        values.put(COLUMN_USER_SGOALSDEP, user.getUserGoalDescriptions());
        values.put(COLUMN_USER_SGOALSTIME, user.getUserGoalTimes());
        values.put(COLUMN_USER_GOALS4, user.getUserGoal4());
        values.put(COLUMN_USER_LONGGOALS, user.getUserLongGoal());


        //Update rows in database with values
        return db.update(TABLE_USER, values, COLUMN_USER_ID + "= ?", new String[]{String.valueOf(user.getId())});
    }

    public void deleteUser(int userID) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_USER, COLUMN_USER_ID + "= ?", new String[]{Integer.toString(userID)});

        db.close();
    }

    List<user> getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();

        //Creates new list
        List<user> userArrayList = new ArrayList<>();

        //Select all from query
        String selectQuery = " SELECT * FROM " + TABLE_USER;

        Cursor cursor = db.rawQuery(selectQuery, null);

        //If the database has at least one user on it
        if(cursor.moveToFirst()){
            do {
                //Create new user and fill it with the information from the table which the cursor is on
                user user = new user();
                user.setUserId(Integer.parseInt(cursor.getString(0)));
                user.setUserName(cursor.getString(1));
                user.setUserUsername(cursor.getString(2));
                user.setUserEmail(cursor.getString(3));
                user.setUserPassword(cursor.getString(4));
                user.setUserAllergies(cursor.getString(5));
                user.setUserMedications(cursor.getString(6));
                user.setUserDiet(cursor.getString(7));
                user.setUserExcercisePlan(cursor.getString(8));
                user.setUserVitalSigns(cursor.getString(9));
                user.setUserGoalNames(cursor.getString(10));
                user.setUserGoalDescriptions(cursor.getString(11));
                user.setUserGoalTimes(cursor.getString(12));

                //Add user to the list
                userArrayList.add(user);

                //If there is another user on the database to it and repeat the loop
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userArrayList;
    }

    //Returns the amount of users in the database
    public Cursor getUserCount(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(" SELECT * FROM " + TABLE_USER, null);
        return res;
    }

    String getUserPassword(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Create cursor which iterates through database's username table looking for the username provided
        Cursor cursor = db.query(TABLE_USER, null, COLUMN_USER_USERNAME + " =?", new String[]{userName}, null, null, null);

        //If the username is not found in the database at least once
        if(cursor.getCount()<1) {
            cursor.close();
            return "Username does not exist";
        }
        cursor.moveToFirst();

        //Assign the password assigned to this username to the variable password
        String password = cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD));
        cursor.close();
        return password;
    }

    boolean isUsernameTaken(EditText et_username) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Create cursor which iterates through database looking for the username
        Cursor cursor=db.query(TABLE_USER, null, COLUMN_USER_USERNAME + " =?", new String[]{et_username.getText().toString()}, null, null, null);

        //If the username is not found meaning it is found less than 1 times
        if(cursor.getCount()<1) {
            cursor.close();
            return false;
        }
        cursor.moveToFirst();
        cursor.close();
        et_username.setError("Username is already taken");
        return true;
    }

    boolean isEmailTaken(EditText et_email) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Create cursor which iterates through database looking for the username
        Cursor cursor=db.query(TABLE_USER, null, COLUMN_USER_EMAIL + " =?", new String[]{et_email.getText().toString()}, null, null, null);

        //If the username is not found meaning it is found less than 1 times
        if(cursor.getCount()<1) {
            cursor.close();
            return false;
        }
        cursor.moveToFirst();
        cursor.close();
        et_email.setError("Email address is already in use");//message is chosen on switch statement above
        return true;
    }

    public Cursor getGoals() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USER;
        Cursor data = db.rawQuery(query, null);
        return data;

    }

    public boolean updateGoals(String goalName, String goalDescription, String goalTime, String username){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_USER_SGOALSNAME, goalName);
        values.put(COLUMN_USER_SGOALSDEP, goalDescription);
        values.put(COLUMN_USER_SGOALSTIME, goalTime);
        db.update(TABLE_USER, values, "user_username =?",new String[] {username} );

        return true;
    }

    //Passes user name, user goal description, user goal time, and username into columns of database
    public boolean addNewGoal(String goalName, String goalDescription, String goalTime, String username){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        user User1 = new user();
        String goals;
        String goalDes;
        String goalTi;

        //Get a list of all user objects in the database
        List<user> usersArrayList = new ArrayList<>(this.getUsers());
        if(TextUtils.isEmpty(usersArrayList.get(User1.currentUserID - 1).getUserGoalNames())){
            goals = "&" + goalName + "&";
            goalDes = "&" + goalDescription + "&";
            goalTi = "&" + goalTime + "&";

        }
        else {
            //Make a new string with the old goals and the new goals separated by &&&
            goals = usersArrayList.get(User1.currentUserID - 1).getUserGoalNames() + goalName + "&";
            goalDes = usersArrayList.get(User1.currentUserID - 1).getUserGoalDescriptions() + goalDescription + "&";
            goalTi = usersArrayList.get(User1.currentUserID - 1).getUserGoalTimes() + goalTime + "&";
        }

        values.put(COLUMN_USER_SGOALSNAME, goals);
        values.put(COLUMN_USER_SGOALSDEP, goalDes);
        values.put(COLUMN_USER_SGOALSTIME, goalTi);

        db.update(TABLE_USER, values, "user_username =?",new String[] {username} );

        return true;
    }

}