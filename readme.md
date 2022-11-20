##### List
* [AndroidListView](#androidlistview)
##### Alert
* [自定义AlertDialog](#自定义alertdialog)
* [使用XML定义菜单](#使用xml定义菜单)
* [上下文菜单](#上下文菜单)



# List
## AndroidListView
#### 思路：
创建数组分别存放动物名字和图片序列，并且对所有数组内容进行标志、定义background颜色单击时改变颜色，并在下方弹出自定义Toast（附带图片）。
```xml
         <!-- 定义一个ImageView，用于作为列表项的一部分。 -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingRight="20dp"
        android:orientation="horizontal">
        <!-- 定义一个TextView，用于作为列表项的一部分。 -->
        <TextView
            android:id="@+id/name"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:paddingLeft="10dp"
            android:gravity="center"
            android:textColor="#f0f"
            android:textSize="20dp" />
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:paddingRight="20dp"
            android:orientation="vertical">
        <ImageView
            android:id="@+id/header"
            android:layout_gravity="right"
            android:layout_width="80dp"
            android:layout_height="80dp"
            android:paddingRight="10dp" />
    </LinearLayout>
    </LinearLayout>
 ```
```java
    //定义数组存放名字和图片
    private String[] names = new String[]
            { "Lion", "Tiger", "Monkey", "Dog","Cat"};
    private int[] imageIds = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //定义颜色
        final int color1=0xFFCCCCFF;
        final int color2=0xFFFFFFFF;
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
                            //自定义Toast
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
```

#### 实验截图
未选择：
![P1](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/1.png?raw=true)

点击老虎：
![P2](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/2.png?raw=true)

取消选择：
![P3](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/3.png?raw=true)

多选：
![P4](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/4.png?raw=true)
*********************************************
# Alert
设置初始页面单击自定义对话框，弹出登录窗口，点击SIGN IN,显示XML定义菜单，点击三个小点进行XML定义菜单的操作，单击中间的测试文本进行上下文菜单的操作。
## 自定义AlertDialog
#### 思路
使用TableLayout包裹4个Tablerow，第一个包裹标题，最后一个包裹两个按钮。
##### alert.xml
```xml
    <TableLayout
        android:id="@+id/alert"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">
         <!-- 标题 -->
        <TableRow
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            <TextView
                android:id="@+id/alert_title"
                android:layout_width="match_parent"
                android:layout_height="80dp"
                android:layout_weight="1"
                android:background="#FFE600"
                android:fontFamily="serif"
                android:gravity="center"
                android:textColor="#fff"
                android:text="ANDROID APP"
                android:textSize="24sp" />
        </TableRow>
        <!-- 用户名 -->
        <TableRow
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center">
            <EditText
                android:id="@+id/alert_username"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="5dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:layout_weight="1"
                android:ems="10"
                android:hint="Username"
                android:inputType="text"
                />
        </TableRow>
        <!-- 密码 -->
        <TableRow
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            <EditText
                android:id="@+id/alert_password"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="5dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:layout_weight="1"
                android:ems="10"
                android:hint="Password"
                android:inputType="textWebPassword" />         <!-- android:inputType="textWebPassword"输入密码时不可见 -->
        </TableRow>
         <!-- 按钮 -->
        <TableRow
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_marginTop="5dp">
            <Button
                android:id="@+id/alert_btn_sign"
                android:layout_width="0dp"
                android:layout_height="60dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:layout_weight="1"
                android:onClick="click_to_next"
                android:text="@string/Sign_in" />
            <Button
                android:id="@+id/alert_btn_cancel"
                android:layout_width="0dp"
                android:layout_height="60dp"
                android:layout_marginLeft="10dp"
                android:layout_marginRight="10dp"
                android:layout_weight="1"
                android:onClick="click_to_cancel"
                android:text="@string/Cancel"
                tools:ignore="ButtonOrder" />
        </TableRow>

    </TableLayout>
```

#### 实验截图
![P5](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/5.png?raw=true)
*********************************************
## 使用XML定义菜单
#### 思路
创建menu_blank.xml包裹menu_demo.xml,在menu_demo.xml对文本进行修改。

##### menu_demo.xml
```xml
    <item android:title="字体大小">
        <menu >
            <item
                android:id="@+id/font_small"
                android:title="小" />
            <item
                android:id="@+id/font_mid"
                android:title="中" />
            <item
                android:id="@+id/font_big"
                android:title="大" />
        </menu>
    </item>
    <item
        android:id="@+id/mi_normal"
        android:title="普通菜单项" />
    <item android:title="字体颜色" >
        <menu >
            <item
                android:id="@+id/font_red"
                android:title="红色" />
            <item
                android:id="@+id/font_black"
                android:title="黑色" />
        </menu>
    </item>
```
##### MenuActivity.java
```java
    //被选择后的文本的改变
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.font_small:
                smallFont();
                break;
            case R.id.font_mid:
                midFont();
                break;
            case R.id.font_big:
                bigFont();
                break;
            case R.id.mi_normal:
                toast();
                break;
            case R.id.font_red:
                red();
                break;
            case R.id.font_black:
                black();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //  定义函数和Toast
    public void smallFont()
    {
        mu_test.setTextSize(10);
    }
    public void midFont()
    {
        mu_test.setTextSize(16);
    }
    public void bigFont()
    {
        mu_test.setTextSize(20);
    }
    public void toast()
    {
        Toast toast = Toast.makeText(this, "这是普通菜单项", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void red()
    {
        mu_test.setTextColor(Color.RED);
    }
    public void black()
    {
        mu_test.setTextColor(Color.BLACK);
    }
```
        
#### 实验截图
未改变前：
![P6](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/6.png?raw=true)
显示上下文菜单:
![P7](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/7.png?raw=true)
选择中等字体和红色：
![P8](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/8.png?raw=true)
普通菜单项：
![P9](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/9.png?raw=true)
*********************************************
## 上下文菜单
#### 思路：
将名字和图片存入数组，设置一个count变量，每选择一个count+1，取消一个count-1，在菜单显示。
##### activity_actionmode.xml
```xml
    <!--列表布局-->>
    <LinearLayout
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:orientation="horizontal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:onClick="click_select">

        <ImageView
            android:id="@+id/list_img"
            android:layout_width="70dp"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            android:contentDescription="@string/app_name"
            android:scaleType="centerCrop" />

        <TextView
            android:id="@+id/list_name"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_gravity="fill"
            android:layout_weight="1"
            android:gravity="center_vertical|start"
            android:textSize="18sp" />
    </LinearLayout>
```
##### ActionModeActivity
```java
//计数
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
    //设置菜单
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
```
#### 实验截图
未选择时：
![P10](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/10.png?raw=true)
选择多个：
![P11](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/11.png?raw=true)
取消选择：
![P12](https://github.com/Jianlingxi/Exp_03/blob/master/DRAW/12.png?raw=true)
