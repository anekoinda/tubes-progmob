package id.aryad.sipasar;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class daoUser {
    List<User> listUser = new ArrayList<>();

    public daoUser(){
        listUser.add(new User(1, "shiltainda", "shilta123"));
        listUser.add(new User(2, "rezafaby", "reza123"));
        listUser.add(new User(3, "mangwahyu", "wahyu123"));
    }

    public void Validasi(User user){
        for(User cekUser : listUser)
            if(cekUser.getUsername().equals(user.getUsername()) && cekUser.getPassword().equals(user.getPassword()))
                user.setValid(true);
                user.setUsername(user.getUsername());
    }
}
