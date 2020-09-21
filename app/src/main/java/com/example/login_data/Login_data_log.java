package com.example.login_data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.University_blind_dating.MainActivity;
import com.facebook.share.Share;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Login_data_log {
    public static final String PREFERENCES_NAME = "login_data";
    //로그인 데이터를 디자인 패턴을 이용해서 사용함
    private Context mContext;
    private static SharedPreferences prefs;

    private static final Login_data_log login_data = new Login_data_log();

    public static Login_data_log get_login_data(){
        return login_data;
    }
    private Login_data_log(){
    }
    private String id;
    private String name;
    private String e_mail;
    private String outer_login;
    /*
    if(login_data.getString("id_data",null)==null){
        SharedPreferences.Editor editor = login_data.edit();
        editor.putString("id_data",this.id);
    }*/

    public String get_ID(){
        return id;
    }
    public void set_ID(String id){
        this.id = id;
        //로그인 정보를 sharedpreferences 에 저장시킨다. (id저장)

        SharedPreferences login_data = getApplicationContext().getSharedPreferences("id_data",getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = login_data.edit();
        editor.putString("id_data",this.id);
        editor.commit();
    }
    public String get_Name(){return name; }
    public void set_name(String name){
        this.name = name;
        SharedPreferences login_data = getApplicationContext().getSharedPreferences("id_data",getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = login_data.edit();
        editor.putString("name_data",this.name);
        editor.commit();
    }
    public String get_e_mail(){
        return e_mail;
    }
    public void set_e_mail(String e_mail){
        this.e_mail = e_mail;
        SharedPreferences login_data = getApplicationContext().getSharedPreferences("id_data",getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = login_data.edit();
        editor.putString("e_mail_data",this.e_mail);
        editor.commit();
    }
    public String get_outer_login(){return outer_login;}
    public void set_outer_login(String outer_login){
        this.outer_login = outer_login;
        SharedPreferences login_data = getApplicationContext().getSharedPreferences("id_data",getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = login_data.edit();
        editor.putString("outer_login_data",this.outer_login);
        editor.commit();
    }
//로그인 시 set 활용 할 때 자동 저장하게 만들고, 자동로그인 체크할때 사용할 코드는 하단에
    public void Auto_login(){
        SharedPreferences login_data;
        if(getApplicationContext().getSharedPreferences("id_data",getApplicationContext().MODE_PRIVATE)!=null) {
            login_data =getApplicationContext().getSharedPreferences("id_data",getApplicationContext().MODE_PRIVATE);
            if (login_data.getString("id_data", null) == null && login_data.getString("outer_login_data", null) == null) {
                //todo 로그인 정보가 없을시 로그인 페이지로 시작해야된다.
                } else {
                    //todo 로그인 정보가 있는 상태이니 홈화면에서 시작할것
                 //저장되어있던 로그인 데이터로 로그인 정보를 불러옴
                    this.id = login_data.getString("id_data", null);
                    this.name = login_data.getString("name_data", null);
                    this.e_mail = login_data.getString("e_mail_data", null);
                    this.outer_login = login_data.getString("outer_login_data", null);

                }
            }
        else {
        //로그인 정보가 없으니 로그인 화면에서 시작
        }
    }

}
