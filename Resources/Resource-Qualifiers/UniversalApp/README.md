### Goals

The application should be customized to run on all *screen sizes* and *orientations*. 

*UniversalApp\app\src\main\res\layout\activity_main.xml*

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.gruprog.universalapp.MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="Default Layout ... Loaded from res/layout/" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text = "One" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text = "Two" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text = "Three" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text = "Four" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text = "Five" />

</LinearLayout>
```

*UniversalApp\app\src\main\res\layout-land\activity_main.xml*

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.gruprog.universalapp.MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="Landscape Layout ... Loaded from res/layout-land/" />

    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <Button
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:text = "One"
            android:layout_weight = "1"/>

        <Button
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:text = "Two"
            android:layout_weight = "1"/>

        <Button
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:text = "Three"
            android:layout_weight = "1"/>

        <Button
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:text = "Four"
            android:layout_weight = "1"/>

        <Button
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:text = "Five"
            android:layout_weight = "1"/>
    </LinearLayout>
</LinearLayout>
```
