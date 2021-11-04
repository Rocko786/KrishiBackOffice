package com.utsav.krishibackoffice.StoreInfo;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalStorage {

    public static final String KEY_HASH = "hash";
    public static final String RECIPE_SLIDER = "recipeSlider";
    public static final String KEY_USER = "User";
    public static final String KEY_USER_ADDRESS = "user_address";
    public static final String KEY_PREFERENCES = "preferences";
    public static final String USER_PREFERENCES = "user_preferences";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String SLIDER_IMAGE = "slider_image";
    public static final String ADVERTISE_IMAGE = "advertise_image";
    public static final String CATEGORY = "category";
    public static final String FAVORITE_CATEGORY = "fav_category";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";


    private static LocalStorage instance = null;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    Context _context;

    public LocalStorage(Context context) {
        sharedPreferences = context.getSharedPreferences("Preferences", 0);
    }

    public void createUserLoginSession(String user) {
        editor = sharedPreferences.edit();
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_USER, user);
        editor.commit();
    }

    public static LocalStorage getInstance(Context context) {
        if (instance == null) {
            synchronized (LocalStorage.class) {
                if (instance == null) {
                    instance = new LocalStorage(context);
                }
            }
        }
        return instance;
    }

    public String getUserLogin() {
        return sharedPreferences.getString(KEY_USER, "");
    }


    public void logoutUser() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

}
