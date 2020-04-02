```XML
<activity
    android:name=".Activity"
    android:configChanges="orientation|keyboardHidden|keyboard|screenSize"
    android:label="@string/activity"
    android:screenOrientation="portrait"
    android:theme="@style/AppTheme.NoActionBar"
    android:windowSoftInputMode="stateHidden"
    android:launchMode="singleTop"
    android:exported="true"
    android:parentActivityName=".RootActivity"
    >

    **<intent-filter>
        <action android:name="Activity" />
        <category android:name="android.intent.category.DEFAULT"/>
    </intent-filter>**

</activity>
```

```JSON
'to' => Token, //tokens sending for notification
  'notification' => {
    'title' => Title,
    'body' => Body,
    'android_channel_id' => ChannelID,
    'click_action' => ** RedirectActivityName **
  }
]
```
