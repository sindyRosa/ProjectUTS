package com.example.projectuts.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class session {
        private static final String USERNAME_KEY = "key_username";
        private static final String TOKEN_KEY = "key_token";
        private static final String KEEP_USERNAME_KEY = "key_keep_username";
    private static final String KEY_CART = "key_cart";

    private static SharedPreferences preferences;

        public session(Context context) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    public void addCart(List<TeamMenu> list){
        Gson gson = new Gson();
        String json = gson.toJson(list);
        preferences.edit().putString(KEY_CART, json).apply();
    }


    public List<TeamMenu> getCart(){
        Gson gson = new Gson();
        String json = preferences.getString(KEY_CART, null);
        Type type = new TypeToken<List<TeamMenu>>() {}.getType();
        return gson.fromJson(json, type);
    }

        public String getUsername() {
            return preferences.getString(USERNAME_KEY, null);
        }

        public void setUsername(String username) {
            preferences.edit().putString(USERNAME_KEY, username)
                    .apply();
        }

        public void setSession(String token) {
            preferences.edit().putString(TOKEN_KEY, token)
                    .apply();
        }
        public boolean isKeepUsername() {
            return preferences.getBoolean(KEEP_USERNAME_KEY, false);
        }

        public boolean isLoggedIn() {
            String token = preferences.getString(TOKEN_KEY, null);
            return (token != null);
        }

        public boolean validate(String username, String password) {
            if (username.equals("admin") && password.equals("admin")) {
                setSession(username);
                return true;
            }
            return false;
        }
        public static void logout() {
            preferences.edit().remove(TOKEN_KEY)
                    .apply();
        }
}
