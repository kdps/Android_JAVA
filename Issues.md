# Android_Issues

## Kotlin Not Configured : Android studio

Android studio is Fucking idiot IDE

Try modify gradle dependency and Sync fucking sucks dependencies And update Fucking DICK Gradle (com.fuck.tools.build)

FUCK YOU GOOGLE

## Android Google maps java.lang.NoClassDefFoundError: Failed resolution of: Lorg/apache/http/ProtocolVersion

https://stackoverflow.com/questions/50782806/android-google-maps-java-lang-noclassdeffounderror-failed-resolution-of-lorg-a

Put this in the Manifest <application> tag:
    
```xml
<uses-library android:name="org.apache.http.legacy" android:required="false"/>
```

## Build.VERSION.SDK_INT 19 / Build.VERSION_CODES.KITKAT

PNG background will be black color

### https://github.com/square/picasso/issues/978

just use Glide

### Duplicate class com.google.common.util.concurrent.ListenableFuture

Doesn't need to append 'implementation 'com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava''

Type the below text to Commmand Line When you need debugging
```Command
adb shell am broadcast -a "androidx.work.diagnostics.REQUEST_DIAGNOSTICS" -p "<your_app_package_name>"
```
```xml
// Guava Dependencies
implementation ('com.google.guava:guava:24.1-jre') {
    exclude group: 'com.google.code.findbugs' // Not even Google can keep dependencies straight - Program type already present: javax.annotation.CheckForNull
    exclude group: 'com.google.common.annotations.*'
    exclude module: 'guava-jdk5'
    exclude module: 'com.google.common.annotations.GwtCompatible'
}

// OR
implementation ('com.google.guava:guava:24.1-jre') {
    exclude group: 'com.google.code.findbugs' // Not even Google can keep dependencies straight - Program type already present: javax.annotation.CheckForNull
    exclude group: 'com.google.common.annotations.*'
    exclude module: 'guava-jdk5'
    exclude module: 'com.google.common.annotations.GwtCompatible'
    exclude group: 'com.google.common.util.concurrent'
}

// Work Manager Runtime
implementation ('androidx.work:work-runtime:2.4.0') {
    exclude group: 'com.google.guava', module: 'listenablefuture'
    exclude module: 'com.google.j2objc:j2objc-annotations'
}
```
