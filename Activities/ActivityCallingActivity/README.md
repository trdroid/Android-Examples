### Code Snippets

> MainActivity.java

```java
            @Override
            public void onClick(View v) {
                Intent startSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startSecondActivityIntent.putExtra(SecondActivity.EXTRA_MESSAGE, R.string.message1);
                startSecondActivityIntent.putExtra(SecondActivity.INFORM_MESSAGE, R.string.inform_message);

                startActivity(startSecondActivityIntent);

                Log.d(TAG, "startActivity() is a is an ASYNCHRONOUS call");
            }
        });

        launchButtonForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSecondActivityForResultIntent = new Intent(MainActivity.this, SecondActivity.class);

                startSecondActivityForResultIntent.putExtra(SecondActivity.EXTRA_MESSAGE, R.string.message2);
                startSecondActivityForResultIntent.putExtra(SecondActivity.INFORM_MESSAGE, R.string.inform_message);

                startActivityForResult(startSecondActivityForResultIntent, 0);

                Log.d(TAG, "startActivityForResult() is an ASYNCHRONOUS call");
            }
        });
        
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null) {
            return;
        }

        switch(requestCode) {
            case 0:
                int message = data.getIntExtra(SecondActivity.RESULT, -1);
                Toast.makeText(getApplicationContext(), String.valueOf(message), Toast.LENGTH_SHORT).show();
        }
    }        
```

> SecondActivity.java

```java

```

### Flow Diagram

<img src="https://github.com/gruprog/Android-Examples/blob/master/Activities/ActivityCallingActivity/_misc/block%20diagram.png"/>
