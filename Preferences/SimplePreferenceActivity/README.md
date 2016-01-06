
### Flow

<img src="https://github.com/konceptsandcode/Android/blob/master/Preferences/SimplePreferenceActivity/_misc/flow.png"/>

1) on clicking "SET PRFERENCES" button, the onSetPreferencesButtonClick is invoked, which launches the SharedPreferenceActivity activity

2) SharedPreferenceActivity is a PreferenceActivity

2a) The addPreferencesFromResources() method is passed the preferences XML file resource ID (res/xml/preferences.xml) (3). 

4) The addPreferencesFromResources() method displays the UI for these preferences in (3)

5) The addPreferencesFromResources() method also creates a data/data/\<package name\>/shared_prefs/<package name>_preferences.xml file and writes the values of preferences specified in res/xml/preferences.xml (3). 

6) The contents of data/data/\<package name\>/shared_prefs/<package name>_preferences.xml created by the addPreferencesFromResources() method are

```xml
<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <boolean name="allowWiFi" value="false" />
    <boolean name="allowBluetooth" value="false" />
</map>
```
