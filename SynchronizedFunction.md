```JAVA
public syncronized void test() {
  AsyncHttpClient client = new AsyncHttpClient ();
  ~~~
  SharedPreferences.Editor sp = prefs.edit ();
  sp.putInt ("test", test);
  sp.apply ();
  
  Log.d(TAG, "RETURN");
}

test();
Log.d(TAG, "AFTER");
```

# RESULT

AFTER
RETURN

because AsyncHttpClient is pass syncronized

```Use This```
public interface Callback {
    void callback (Boolean bool);
}

public void test(Callback callback) {
...
  callback.callback();
}
```
