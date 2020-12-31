package com.example.VirtualEnvironmentDetect;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.mcdoodle.envchecksupport.CheckEnv;

import java.io.File;
import java.util.Base64;

import static com.mcdoodle.envchecksupport.CheckEnv.absPath;

public class MainActivity extends AppCompatActivity  {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv2);

        //String pkg = "com.example.dummy";   //convert the package name to base 64 format and store it in variable pkg

        String pkg = "Y29tLmV4YW1wbGUuZHVtbXk=";    //this is base 64 encode of the above package

        Log.d("PACKAGE", pkg);
        Log.d("from function", getPackageName());
        String shared="";
        AppPreferences.savePreferences(this, "test1", "shared_pref");
        AppPreferences.savePreferences(this,"test", "visible");


        //THE CODE
       // String pkg = getPackageName();
        CheckEnv check = new CheckEnv(pkg, this);
        check.options();

        Log.d("location", absPath);

        tv.setText(absPath);

        /*File root = new File("/data/data/"+pkg+"/shared_prefs");
        if (root.isDirectory()) {
            for (File child: root.listFiles()) {
                Toast.makeText(this, child.getPath(), Toast.LENGTH_SHORT).show();
                Log.d("OUTPUT", child.getPath());
                shared += (child.getPath() + "\n");
            }
        }*/

        //check file is shared_prefs

        File direc = getFileStreamPath("DUMMY.xml");
        String absLoc = direc.getAbsolutePath();
        Log.d("OUTPUT", absLoc);

        tv.setText(absLoc);

        //creating a file

        File f = new File(this.getFilesDir(), "validate.txt");

        File loc = getFileStreamPath("validate.txt");
        String absPath = loc.getAbsolutePath();
        Log.d("location", absPath);

        tv.setText(absPath);






        /*if(absPath.equals("/data/user/0/"+pkg+"/files/validate.txt")){
            //Toast.makeText(MainActivity.this, "here", Toast.LENGTH_LONG).show();
            Log.d("match", "true");

        }
        else {
            options();

            //Toast.makeText(MainActivity.this, "Unsafe environment. Exiting", Toast.LENGTH_LONG).show();

            //System.exit(0);
        }*/

    }


}