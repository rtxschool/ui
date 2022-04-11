package com.rtxschool.utility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, loggon.class, null
                    )
                    .commit();
        }
    }

    //get the career summary fragment
    public void get_career(View theView
    ) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);

        transaction.replace(R.id.fragment_container_view
                , career.class, null);

        transaction.commit();
    }

    //get the general summary fragment
    public void get_prim(View theView) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);

        transaction.replace(R.id.fragment_container_view
                , prim.class, null);

        transaction.commit();

    }

    //verify that the user provided > ""
    //toast if not
    //get general summary if
    public void verify_client(View theView) {

        EditText txt_log = (EditText) findViewById(R.id.txt_log);

        if (txt_log.getText().toString().trim().equals("")
        ) {
            Context context = getApplicationContext();

            CharSequence text = "Provide logon";

            int type = Toast.LENGTH_LONG;

            Toast.makeText(context, text, type).show();

            return;
        }

        get_prim(theView);
    }

    //toast the text of the cmd that got tapped
    public void toast_unique_box(View theView) {
        Button cmd_unique = (Button) theView;

        Context context = getApplicationContext();

        CharSequence text = cmd_unique.getText();

        int type = Toast.LENGTH_SHORT;

        Toast.makeText(context, text, type).show();
    }
}