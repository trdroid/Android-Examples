### Creating the project

The default activity code generated is 

*app\src\main\java\com\gruprog\basicpreferences\MainActivity.java*

```java
package com.gruprog.basicpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

The default layout file generated 

*app\src\main\res\layout\activity_main.xml*

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.gruprog.basicpreferences.MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!" />
</RelativeLayout>
```

Create the menu resource

*app\src\main\res\menu\menu_main.xml*

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/settings"
        android:title="@string/settings"
        android:showAsAction="never"/>
</menu>
```

![](_misc/namespace%20error.png)

![](_misc/unknown%20attribute%20error.png)

Fixing the error in the resource file

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/settings"
        android:title="@string/settings"
        app:showAsAction="never"/>
</menu>
```

**Inflate the menu**

Override the *onCreateOptionsMenu()* method and inflate the menu "menu_main.xml"

*app\src\main\java\com\gruprog\basicpreferences\MainActivity.java*

```java
package com.gruprog.basicpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override   
    public boolean onCreateOptionsMenu(Menu menu) {             <--------------
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
}
```

Testing it in the emulator

![](_misc/Screenshot%20of%20settings.png)
