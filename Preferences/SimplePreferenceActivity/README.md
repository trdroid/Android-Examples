```xml
<?xml version="1.0" encoding="utf-8"?>

<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
    <PreferenceCategory android:title="Connectivity">

        <!--
            android:key specifies the key that could be used in the code to read/write values
        -->
        <CheckBoxPreference
            android:title="Bluetooth"
            android:defaultValue="false"
            android:summary="Use Bluetooth?"
            android:key="allowBluetooth" />

        <!--
            Brings up another screen
        -->
        <PreferenceScreen
            android:title="Wi-Fi Settings"
            android:summary="Enter Wi-Fi Details"
            android:key="WiFiSettings">

            <CheckBoxPreference
                android:title="Wi-Fi"
                android:defaultValue="false"
                android:summary="Use WiFi?"
                android:key="allowWiFi" />

            <EditTextPreference
                android:summary="SSID"
                android:title="Enter SSID"
                android:key="SSIDName"
                />

        </PreferenceScreen>
    </PreferenceCategory>
</PreferenceScreen>
```

```xml
<?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
    <boolean name="allowWiFi" value="false" />
    <boolean name="allowBluetooth" value="false" />
</map>
```
