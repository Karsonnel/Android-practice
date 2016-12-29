package com.example.administrator.launcheractivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */

public class PreferenceActivityTest extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //设置标题按钮
        if(hasHeaders())
        {
            Button button = new Button(this);
            button.setText("设置操作");
            //添加按钮到界面
            setListFooter(button);
        }
    }
    //重写方法以加载布局文件
    @Override
    public void onBuildHeaders(List<Header> target)
    {
        //加载布局文件
         loadHeadersFromResource(R.xml.preference_headers,target);
    }
    //重写方法验证Preference Fragment 是否有效
    @Override
    public boolean isValidFragment(String fragmentName)
    {
        return true;
    }
    public static class Prefs1Fragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
    public static class Prefs2Fragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle saveInstanceState)
        {
            super.onCreate(saveInstanceState);
            addPreferencesFromResource(R.xml.display_prefs);
            String website = getArguments().getString("website");
            Toast.makeText(getActivity(),"网站域名是： "+website,Toast.LENGTH_LONG).show();
        }
    }
}

