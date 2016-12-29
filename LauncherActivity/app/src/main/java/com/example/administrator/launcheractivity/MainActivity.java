package com.example.administrator.launcheractivity;

import android.app.ExpandableListActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends LauncherActivity {

    //定义activity名称
    String[] name = {"设置程序参数" , "查看星际兵种"};
    //定义activity实现类
    Class<?>[] clazzs = {PreferenceActivityTest.class , ExpandableListActivityTest.class};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        setListAdapter(adapter);

    }
    //根据列表项返回指定Activity 对应的 Intent
    @Override
    public Intent intentForPosition(int position)
    {
        return new Intent(MainActivity.this,clazzs[position]);
    }
}
