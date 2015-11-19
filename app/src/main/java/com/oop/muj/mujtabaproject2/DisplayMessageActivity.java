package com.oop.muj.mujtabaproject2;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class DisplayMessageActivity extends AppCompatActivity {
    TextView data;
    ImageView image1;
    LinearLayout holdlayout;
    View l1;
    private ArrayList results;
    List<ResolveInfo> list;
    TextView result;
    String str = "";
    Drawable icon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        l1 = findViewById(R.id.Layout1);
        results = new ArrayList();
        PackageManager pm = this.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        list = pm.queryIntentActivities(intent,
                PackageManager.PERMISSION_GRANTED);
        for (ResolveInfo rInfo : list) {
            str = rInfo.activityInfo.applicationInfo.loadLabel(pm).toString()
                    + "\n";
            results.add(rInfo.activityInfo.applicationInfo.loadLabel(pm)
                    .toString());
            Log.w("Installed Applications", rInfo.activityInfo.applicationInfo
                    .loadLabel(pm).toString());
            icon = rInfo.activityInfo.applicationInfo.loadIcon(pm);
            holdlayout = new LinearLayout(getApplicationContext());
            holdlayout.setOrientation(LinearLayout.HORIZONTAL);
            data = new TextView(getApplicationContext());
            data.setText(str);
            image1 = new ImageView(getApplicationContext());
            image1.setBackgroundDrawable(icon);
            ((ViewGroup) holdlayout).addView(image1);
            ((ViewGroup) holdlayout).addView(data);
            ((ViewGroup) l1).addView(holdlayout);

        }

    }




    /*void GetInstalledAppList()
    {

        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        final List pkgAppsList = getPackageManager().queryIntentActivities( mainIntent, 0);
        for (Object object : pkgAppsList)
        {
            ResolveInfo info = (ResolveInfo) object;
            Drawable icon    = getBaseContext().getPackageManager().getApplicationIcon(info.activityInfo.applicationInfo);
            String strAppName  	= info.activityInfo.applicationInfo.publicSourceDir.toString();
            String strPackageName  = info.activityInfo.applicationInfo.packageName.toString();
            final String title 	= (String)((info != null) ? getBaseContext().getPackageManager().getApplicationLabel(info.activityInfo.applicationInfo) : "???");
        }



    } */






}
