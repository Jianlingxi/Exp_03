package com.example.alertdialog;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ActionModeActivity extends AppCompatActivity {
    String[] names = {"One", "Two", "Three", "Four"};
    private int[] imgs =
            {R.drawable.lion,
                    R.drawable.tiger,
                    R.drawable.monkey,
                    R.drawable.cat,
                    };
    HashMap<View, Boolean> vis;
    int selected_items = 0;
    ActionMode am;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionmode);

        vis = new HashMap<>();

        ListView LV_am_demo = findViewById(R.id.LV_am_demo);
        ArrayList<HashMap<String, Object>> lst = new ArrayList<>();
        for (int i = 0; i <= 3; i++)
        {
            HashMap<String, Object> mp = new HashMap<>();
            mp.put("name", names[i]);
            mp.put("img", imgs[i]);
            lst.add(mp);
        }

        SimpleAdapter sa = new SimpleAdapter(this, lst, R.layout.list, new String[]{"name", "img"}, new int[]{R.id.list_name, R.id.list_img});
        LV_am_demo.setAdapter(sa);
    }

    public void click_select(View V)
    {
        if (am == null)
            am = startActionMode(callback);

        LinearLayout line_lay = (LinearLayout) V;
        if (vis.get(V) == null || !vis.get(V))
        {
            line_lay.setBackgroundColor(Color.CYAN);
            vis.put(V, true);
            selected_items++;
        }
        else
        {
            line_lay.setBackgroundColor(Color.WHITE);
            vis.put(V, false);
            selected_items--;
        }
        callback.onActionItemClicked(am, null);

    }

    ActionMode.Callback callback = new ActionMode.Callback()
    {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu)
        {
            getMenuInflater().inflate(R.menu.menu_blank, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu)
        {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem)
        {
            actionMode.setTitle(selected_items + " selected");
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode)
        {

        }
    };
}
