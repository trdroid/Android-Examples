### Creating a custom TextView

Create a custom TextView and set breakpoints

*CustomTextView\app\src\main\java\com\gruprog\customtextview\CustomTextView.java*

```java
package com.gruprog.customtextview;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);     <---------------
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);      <---------------
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);     <---------------
    }
}
```

*CustomTextView\app\src\main\java\com\gruprog\customtextview\MainActivity.java*

Instantiate the custom view and set it as the MainActivity's content view; also set a break point

```java
package com.gruprog.customtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomTextView customTextView = new CustomTextView(this);
        customTextView.setText("Hello World!");
        setContentView(customTextView);     <--------------
    }
}
```

### Start debugging

On debug, the following break point is first hit:

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomTextView customTextView = new CustomTextView(this);
        customTextView.setText("Hello World!");
        setContentView(customTextView);    <----
    }
}
```

the stack trace for which is given below:

```
"main@3972" prio=5 runnable
  java.lang.Thread.State: RUNNABLE
	  at com.gruprog.customtextview.MainActivity.onCreate(MainActivity.java:13)
	  at android.app.Activity.performCreate(Activity.java:6237)
	  at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1107)
	  at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:2369)
	  at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2476)
	  at android.app.ActivityThread.-wrap11(ActivityThread.java:-1)
	  at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1344)
	  at android.os.Handler.dispatchMessage(Handler.java:102)
	  at android.os.Looper.loop(Looper.java:148)
	  at android.app.ActivityThread.main(ActivityThread.java:5417)
	  at java.lang.reflect.Method.invoke(Method.java:-1)
	  at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
	  at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
```

On resume, the following break point is hit:

```java
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);         <---------------------
    }
}
```

the stack trace for which is:

```
"main@3972" prio=5 runnable
  java.lang.Thread.State: RUNNABLE
	  at com.gruprog.customtextview.CustomTextView.onMeasure(CustomTextView.java:24)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at android.support.v7.widget.ContentFrameLayout.onMeasure(ContentFrameLayout.java:135)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.support.v7.widget.ActionBarOverlayLayout.onMeasure(ActionBarOverlayLayout.java:391)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1465)
	  at android.widget.LinearLayout.measureVertical(LinearLayout.java:748)
	  at android.widget.LinearLayout.onMeasure(LinearLayout.java:630)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at com.android.internal.policy.PhoneWindow$DecorView.onMeasure(PhoneWindow.java:2643)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewRootImpl.performMeasure(ViewRootImpl.java:2100)
	  at android.view.ViewRootImpl.measureHierarchy(ViewRootImpl.java:1216)
	  at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1452)
	  at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1107)
	  at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6013)
	  at android.view.Choreographer$CallbackRecord.run(Choreographer.java:858)
	  at android.view.Choreographer.doCallbacks(Choreographer.java:670)
	  at android.view.Choreographer.doFrame(Choreographer.java:606)
	  at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
	  at android.os.Handler.handleCallback(Handler.java:739)
	  at android.os.Handler.dispatchMessage(Handler.java:95)
	  at android.os.Looper.loop(Looper.java:148)
	  at android.app.ActivityThread.main(ActivityThread.java:5417)
	  at java.lang.reflect.Method.invoke(Method.java:-1)
	  at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
	  at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
```

On resume, the same breakpoint is hit:

```java
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);         <---------------------
    }
}
```

the stack trace for which is:

```
"main@3972" prio=5 runnable
  java.lang.Thread.State: RUNNABLE
	  at com.gruprog.customtextview.CustomTextView.onMeasure(CustomTextView.java:24)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at android.support.v7.widget.ContentFrameLayout.onMeasure(ContentFrameLayout.java:135)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.support.v7.widget.ActionBarOverlayLayout.onMeasure(ActionBarOverlayLayout.java:391)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1465)
	  at android.widget.LinearLayout.measureVertical(LinearLayout.java:748)
	  at android.widget.LinearLayout.onMeasure(LinearLayout.java:630)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at com.android.internal.policy.PhoneWindow$DecorView.onMeasure(PhoneWindow.java:2643)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewRootImpl.performMeasure(ViewRootImpl.java:2100)
	  at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1864)
	  at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1107)
	  at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6013)
	  at android.view.Choreographer$CallbackRecord.run(Choreographer.java:858)
	  at android.view.Choreographer.doCallbacks(Choreographer.java:670)
	  at android.view.Choreographer.doFrame(Choreographer.java:606)
	  at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
	  at android.os.Handler.handleCallback(Handler.java:739)
	  at android.os.Handler.dispatchMessage(Handler.java:95)
	  at android.os.Looper.loop(Looper.java:148)
	  at android.app.ActivityThread.main(ActivityThread.java:5417)
	  at java.lang.reflect.Method.invoke(Method.java:-1)
	  at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
	  at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
```

On resume, the following breakpoint is hit:

```java
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);          <-------------------
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
```

the stack trace of which is:

```
"main@3972" prio=5 runnable
  java.lang.Thread.State: RUNNABLE
	  at com.gruprog.customtextview.CustomTextView.onLayout(CustomTextView.java:19)
	  at android.view.View.layout(View.java:16630)
	  at android.widget.FrameLayout.layoutChildren(FrameLayout.java:336)
	  at android.widget.FrameLayout.onLayout(FrameLayout.java:273)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.support.v7.widget.ActionBarOverlayLayout.onLayout(ActionBarOverlayLayout.java:435)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.widget.FrameLayout.layoutChildren(FrameLayout.java:336)
	  at android.widget.FrameLayout.onLayout(FrameLayout.java:273)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1743)
	  at android.widget.LinearLayout.layoutVertical(LinearLayout.java:1586)
	  at android.widget.LinearLayout.onLayout(LinearLayout.java:1495)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.widget.FrameLayout.layoutChildren(FrameLayout.java:336)
	  at android.widget.FrameLayout.onLayout(FrameLayout.java:273)
	  at com.android.internal.policy.PhoneWindow$DecorView.onLayout(PhoneWindow.java:2678)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.view.ViewRootImpl.performLayout(ViewRootImpl.java:2171)
	  at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1931)
	  at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1107)
	  at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6013)
	  at android.view.Choreographer$CallbackRecord.run(Choreographer.java:858)
	  at android.view.Choreographer.doCallbacks(Choreographer.java:670)
	  at android.view.Choreographer.doFrame(Choreographer.java:606)
	  at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
	  at android.os.Handler.handleCallback(Handler.java:739)
	  at android.os.Handler.dispatchMessage(Handler.java:95)
	  at android.os.Looper.loop(Looper.java:148)
	  at android.app.ActivityThread.main(ActivityThread.java:5417)
	  at java.lang.reflect.Method.invoke(Method.java:-1)
	  at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
	  at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
```

On resume, the following break point is hit:

```java
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);     <-------------------
    }
}
```

and the stack trace is:

```
"main@3972" prio=5 runnable
  java.lang.Thread.State: RUNNABLE
	  at com.gruprog.customtextview.CustomTextView.onMeasure(CustomTextView.java:24)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at android.support.v7.widget.ContentFrameLayout.onMeasure(ContentFrameLayout.java:135)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.support.v7.widget.ActionBarOverlayLayout.onMeasure(ActionBarOverlayLayout.java:391)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.LinearLayout.measureChildBeforeLayout(LinearLayout.java:1465)
	  at android.widget.LinearLayout.measureVertical(LinearLayout.java:748)
	  at android.widget.LinearLayout.onMeasure(LinearLayout.java:630)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewGroup.measureChildWithMargins(ViewGroup.java:5951)
	  at android.widget.FrameLayout.onMeasure(FrameLayout.java:194)
	  at com.android.internal.policy.PhoneWindow$DecorView.onMeasure(PhoneWindow.java:2643)
	  at android.view.View.measure(View.java:18788)
	  at android.view.ViewRootImpl.performMeasure(ViewRootImpl.java:2100)
	  at android.view.ViewRootImpl.measureHierarchy(ViewRootImpl.java:1216)
	  at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1452)
	  at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1107)
	  at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6013)
	  at android.view.Choreographer$CallbackRecord.run(Choreographer.java:858)
	  at android.view.Choreographer.doCallbacks(Choreographer.java:670)
	  at android.view.Choreographer.doFrame(Choreographer.java:606)
	  at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
	  at android.os.Handler.handleCallback(Handler.java:739)
	  at android.os.Handler.dispatchMessage(Handler.java:95)
	  at android.os.Looper.loop(Looper.java:148)
	  at android.app.ActivityThread.main(ActivityThread.java:5417)
	  at java.lang.reflect.Method.invoke(Method.java:-1)
	  at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
	  at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
```

```java
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);          <-------------------
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
```

and the stack trace is:

```
"main@3972" prio=5 runnable
  java.lang.Thread.State: RUNNABLE
	  at com.gruprog.customtextview.CustomTextView.onLayout(CustomTextView.java:19)
	  at android.view.View.layout(View.java:16630)
	  at android.widget.FrameLayout.layoutChildren(FrameLayout.java:336)
	  at android.widget.FrameLayout.onLayout(FrameLayout.java:273)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.support.v7.widget.ActionBarOverlayLayout.onLayout(ActionBarOverlayLayout.java:435)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.widget.FrameLayout.layoutChildren(FrameLayout.java:336)
	  at android.widget.FrameLayout.onLayout(FrameLayout.java:273)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.widget.LinearLayout.setChildFrame(LinearLayout.java:1743)
	  at android.widget.LinearLayout.layoutVertical(LinearLayout.java:1586)
	  at android.widget.LinearLayout.onLayout(LinearLayout.java:1495)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.widget.FrameLayout.layoutChildren(FrameLayout.java:336)
	  at android.widget.FrameLayout.onLayout(FrameLayout.java:273)
	  at com.android.internal.policy.PhoneWindow$DecorView.onLayout(PhoneWindow.java:2678)
	  at android.view.View.layout(View.java:16630)
	  at android.view.ViewGroup.layout(ViewGroup.java:5437)
	  at android.view.ViewRootImpl.performLayout(ViewRootImpl.java:2171)
	  at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:1931)
	  at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1107)
	  at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6013)
	  at android.view.Choreographer$CallbackRecord.run(Choreographer.java:858)
	  at android.view.Choreographer.doCallbacks(Choreographer.java:670)
	  at android.view.Choreographer.doFrame(Choreographer.java:606)
	  at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
	  at android.os.Handler.handleCallback(Handler.java:739)
	  at android.os.Handler.dispatchMessage(Handler.java:95)
	  at android.os.Looper.loop(Looper.java:148)
	  at android.app.ActivityThread.main(ActivityThread.java:5417)
	  at java.lang.reflect.Method.invoke(Method.java:-1)
	  at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
	  at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
```

On resume, the following break point is hit:

```java
public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);       <------------------
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
```

and the stack trace is:

```
"main@3972" prio=5 runnable
  java.lang.Thread.State: RUNNABLE
	  at com.gruprog.customtextview.CustomTextView.onDraw(CustomTextView.java:14)
	  at android.view.View.draw(View.java:16178)
	  at android.view.View.updateDisplayListIfDirty(View.java:15174)
	  at android.view.View.draw(View.java:15948)
	  at android.view.ViewGroup.drawChild(ViewGroup.java:3609)
	  at android.view.ViewGroup.dispatchDraw(ViewGroup.java:3399)
	  at android.view.View.updateDisplayListIfDirty(View.java:15169)
	  at android.view.View.draw(View.java:15948)
	  at android.view.ViewGroup.drawChild(ViewGroup.java:3609)
	  at android.view.ViewGroup.dispatchDraw(ViewGroup.java:3399)
	  at android.view.View.updateDisplayListIfDirty(View.java:15169)
	  at android.view.View.draw(View.java:15948)
	  at android.view.ViewGroup.drawChild(ViewGroup.java:3609)
	  at android.view.ViewGroup.dispatchDraw(ViewGroup.java:3399)
	  at android.view.View.updateDisplayListIfDirty(View.java:15169)
	  at android.view.View.draw(View.java:15948)
	  at android.view.ViewGroup.drawChild(ViewGroup.java:3609)
	  at android.view.ViewGroup.dispatchDraw(ViewGroup.java:3399)
	  at android.view.View.updateDisplayListIfDirty(View.java:15169)
	  at android.view.View.draw(View.java:15948)
	  at android.view.ViewGroup.drawChild(ViewGroup.java:3609)
	  at android.view.ViewGroup.dispatchDraw(ViewGroup.java:3399)
	  at android.view.View.draw(View.java:16181)
	  at com.android.internal.policy.PhoneWindow$DecorView.draw(PhoneWindow.java:2690)
	  at android.view.View.updateDisplayListIfDirty(View.java:15174)
	  at android.view.ThreadedRenderer.updateViewTreeDisplayList(ThreadedRenderer.java:281)
	  at android.view.ThreadedRenderer.updateRootDisplayList(ThreadedRenderer.java:287)
	  at android.view.ThreadedRenderer.draw(ThreadedRenderer.java:322)
	  at android.view.ViewRootImpl.draw(ViewRootImpl.java:2615)
	  at android.view.ViewRootImpl.performDraw(ViewRootImpl.java:2434)
	  at android.view.ViewRootImpl.performTraversals(ViewRootImpl.java:2067)
	  at android.view.ViewRootImpl.doTraversal(ViewRootImpl.java:1107)
	  at android.view.ViewRootImpl$TraversalRunnable.run(ViewRootImpl.java:6013)
	  at android.view.Choreographer$CallbackRecord.run(Choreographer.java:858)
	  at android.view.Choreographer.doCallbacks(Choreographer.java:670)
	  at android.view.Choreographer.doFrame(Choreographer.java:606)
	  at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:844)
	  at android.os.Handler.handleCallback(Handler.java:739)
	  at android.os.Handler.dispatchMessage(Handler.java:95)
	  at android.os.Looper.loop(Looper.java:148)
	  at android.app.ActivityThread.main(ActivityThread.java:5417)
	  at java.lang.reflect.Method.invoke(Method.java:-1)
	  at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:726)
	  at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:616)
```

On resume, the app runs and displays "Hello World!"
