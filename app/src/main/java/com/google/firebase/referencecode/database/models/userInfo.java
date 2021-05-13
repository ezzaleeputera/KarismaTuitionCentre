package com.google.firebase.referencecode.database.models;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;
@IgnoreExtraProperties
public class userInfo {
    String name,noIC,toUser;
    public userInfo() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoIC() {
        return noIC;
    }

    public void setNoIC(String noIC) {
        this.noIC = noIC;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

//    public Map<String,Object> toMap(){
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("to_user",toUser);
//
//        return result;
//    }
}
