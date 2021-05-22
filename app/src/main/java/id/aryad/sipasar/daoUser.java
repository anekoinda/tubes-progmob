package id.aryad.sipasar;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class daoUser {
    private ArrayList<User> userData = new ArrayList(Arrays.asList(
            new User(1, 1, "shiltainda", "shilta123", AdminRole.PEGAWAI, 1),
            new User(2, 2, "aryapegawai", "pass123", AdminRole.PEGAWAI, 1),
            new User(3, 3, "aryaadmin", "pass123", AdminRole.ADMIN, 1),
            new User(4, 4, "aryamanager", "pass123", AdminRole.MANAGER, 1)
    ));

    private static daoUser single_instance = null;

    public static daoUser getInstance() {
        if (single_instance == null)
            single_instance = new daoUser();

        return single_instance;
    }

    public User login(Context context, String username, String password) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();

        for (User it : userData) {
            if (it.getUsername().equalsIgnoreCase(username) && it.getPassword().equals(password)) {
                editor.apply();
                return it;
            }
        }

        return null;
    }
}
