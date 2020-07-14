package com.lucine.toread;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.lucine.toread.model.ToReadItem;
import com.lucine.toread.model.ToReads;
import com.lucine.toread.utils.Utils;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayAdapter<String> mAdapter;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView gridView = (ListView) findViewById(R.id.listview);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            ToReads toReads = new ToReads(Utils.getToReads());
            ToReadsAdapter toReadsAdapter = new ToReadsAdapter(this, toReads);
            gridView.setAdapter(toReadsAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    private void updateUI(ToReads toReads) {
        ArrayList<String> toReadList = new ArrayList<>();

        for (ToReadItem item : toReads.GetItems()) {
            toReadList.add(item.GetTitle());
        }

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_toread,
                    R.id.toread_grid,
                    toReadList
            );
            mToReadListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(toReadList);
            mAdapter.notifyDataSetChanged();
        }
    }*/
}