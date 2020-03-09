# Android_JAVA
Android JAVA

> Bug

Expected receiver of type ..., but got android.view.ContextThemeWrapper

https://issuetracker.google.com/issues/37048075

If you define a EditText with an onclick Handler defined in the Layout XML, the onclick crashes when using the appcompat-v7 in Version 22.1.0 and 22.1.1. When using Version 22.0.0 it works. 

# Set Context of Fragment
```JAVA
View view = inflater.inflate (R.layout.fragment_example, container, false
```

```XML
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:focusable="true"
    android:focusableInTouchMode="true"
    >
```

```XML
    android:focusable="true"
    android:focusableInTouchMode="true"
```
