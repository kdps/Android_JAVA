### Dependency

```gradle
implementation "androidx.work:work-runtime:2.3.3"
implementation "androidx.concurrent:concurrent-futures:1.1.0"
```

```Period Worker
PeriodicWorkRequest workRequest = new PeriodicWorkRequest.Builder(WorkerClass.class, 1, TimeUnit.MINUTES).build();
WorkManager.getInstance(AppContext).enqueue(workRequest);
```
