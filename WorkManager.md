### Dependency

```gradle
implementation "androidx.work:work-runtime:2.3.3"
implementation "androidx.concurrent:concurrent-futures:1.1.0"
// https://stackoverflow.com/questions/56639529/duplicate-class-com-google-common-util-concurrent-listenablefuture-found-in-modu
implementation 'com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava'
```

```Period Worker
PeriodicWorkRequest workRequest = new PeriodicWorkRequest.Builder(WorkerClass.class, 1, TimeUnit.MINUTES).build();
WorkManager.getInstance(AppContext).enqueue(workRequest);
```
