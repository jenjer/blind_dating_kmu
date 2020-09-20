package com.example.University_blind_dating.db.splashDB;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL설정
    final static private String URL = "http://dating.dothome.co.kr/php/splash/RegisterRequest.php";
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPW, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPW", userPW);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
