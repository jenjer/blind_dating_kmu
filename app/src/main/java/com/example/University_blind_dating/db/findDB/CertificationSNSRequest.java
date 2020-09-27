package com.example.University_blind_dating.db.findDB;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CertificationSNSRequest extends StringRequest {

    //서버 URL설정
    final static private String URL = "http://dating.dothome.co.kr/php/find/CertificationSNSRequest.php";
    private Map<String, String> map;

    public CertificationSNSRequest(String userPhone, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userPhone", userPhone);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
