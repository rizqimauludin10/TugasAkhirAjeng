package com.rizqimauludin.tugasakhirajeng.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {

    public static final String SP_MathStack = "spNyuciin";

    public static final String SP_Username = "spUsername";
    public static final String SP_Email = "spEmail";
    public static final String SP_Phone = "spPhone";
    public static final String SP_UserId = "user";
    public static final String SP_Login = "spLogin";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor spEditor;

    public SharedPreferencesUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_MathStack, Context.MODE_PRIVATE);
        spEditor = sharedPreferences.edit();
    }

    public void saveSPString(String keySp, String value) {
        spEditor.putString(keySp, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySp, int value) {
        spEditor.putInt(keySp, value);
        spEditor.commit();
    }

    public void saveSPIntUser(String keySp, int value) {
        spEditor.putInt(keySp, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySp, boolean value) {
        spEditor.putBoolean(keySp, value);
        spEditor.commit();
    }

    public void remove(String keySp) {
        spEditor.remove(keySp);
        spEditor.apply();
    }

    public Boolean getSP_Login() {
        return sharedPreferences.getBoolean(SP_Login, false);
    }

    public String getSp_Username() {
        return sharedPreferences.getString(SP_Username, "");
    }

    public String getSp_Email() {
        return sharedPreferences.getString(SP_Email, "");
    }

    public String getSP_Phone() {
        return sharedPreferences.getString(SP_Phone, "");
    }

    public String getSP_UserId() {
        return sharedPreferences.getString((SP_UserId), "");
    }
}
