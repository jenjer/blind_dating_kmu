package com.example.FacebookLogin;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.login_data.Login_data_log.get_login_data;

public class LoginCallback implements FacebookCallback<LoginResult> {
    ArrayList<String> myarray = new ArrayList<String>();
    //Call when you success login it means Access Tocken making
    @Override
    public void onSuccess(LoginResult loginResult){
        Log.e("Callback::","onSuccess");
        requestMe(loginResult.getAccessToken());
        get_login_data().set_outer_login (loginResult.getAccessToken().getUserId());
    }

    //this will call when you close login
    @Override
    public void onCancel(){
        Log.e("Callback::","onCancel");
    }

    //this will call when you fail to login
    @Override
    public void onError(FacebookException error){
        Log.e("Callback::","onError:"+error.getMessage());
    }

    //ask user data
    public void requestMe(AccessToken token){
        GraphRequest graphRequest = GraphRequest.newMeRequest(token,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        try {
                            Log.e("result", object.toString());
                            String email = response.getJSONObject().getString("email").toString();

                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                    });
        Bundle parameters = new Bundle();
        parameters.putString("fields","id,name,email,gender,birthday");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();

    }

}
