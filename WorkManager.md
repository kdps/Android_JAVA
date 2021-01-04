### oneTimeWorkRequest

```OneTimeWorkRequest
OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
WorkManager.getInstance().enqueue(oneTimeWorkRequest);
```

```PeriodicWorkRequest
Constraints         constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
PeriodicWorkRequest build       = new PeriodicWorkRequest.Builder (MyWorker.class, 1, TimeUnit.HOURS).addTag ("Worker").setConstraints (constraints).build ();
WorkManager         instance    = WorkManager.getInstance();
if (instance != null) {
    instance.enqueueUniquePeriodicWork(TAG, ExistingPeriodicWorkPolicy.REPLACE, build);
}
```
