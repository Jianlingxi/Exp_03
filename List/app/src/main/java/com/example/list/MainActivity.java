package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]
            { "Lion", "Tiger", "Monkey", "Dog","Cat"};
    private int[] imageIds = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int color1=0xFFCCCCFF;
        final int color2=0xFFFFFFFF;
        setContentView(R.layout.main);
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItem.put("animalName", names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.simple_item,
                new String[] { "header" , "animalName"},
                new int[] { R.id.header , R.id.name});
        ListView list = (ListView) findViewById(R.id.mylist);
        // 为ListView设置Adapter
        list.setAdapter(simpleAdapter);

        // 为ListView的列表项的单击事件绑定事件监听器
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            int[] flag = new int[]{0,0,0,0,0};
            // 第position项被单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                    System.out.println(names[position]
                        + "被单击了");
                    switch (flag[position]) {
                        case 0:
                            view.setSelected(true);
                            view.setBackgroundColor(color1);
                            //此处对应上面布局文件的点击函数
                            CharSequence text = "你选择了" + names[position];
                            //定义一个Toast表示哪一个图片所在item被点击
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast =Toast.makeText(MainActivity.this, text, duration);
                            LinearLayout toastView = (LinearLayout) toast.getView();
                            ImageView imageCodeProject = new ImageView(getApplicationContext());
                            imageCodeProject.setImageResource(imageIds[position]);
                            toastView.addView(imageCodeProject, 0);
                            toast.show();
                            flag[position]= 1;
                            break;
                        case 1:
                            view.setSelected(false);
                            view.setBackgroundColor(color2);
                            CharSequence text1 = names[position];
                            int duration1 = Toast.LENGTH_SHORT;
                            Toast toast1 = Toast.makeText(MainActivity.this, "取消选中" + names[position], duration1);
                            toast1.show();
                            flag[position]= 0;
                            break;

                }
            }
        });
        // 为ListView的列表项的选中事件绑定事件监听器
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            // 第position项被选中时激发该方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id)
            {
                System.out.println(names[position]+position+"被单击");
                //点击则改变状态，改变颜色
          }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
    }



}