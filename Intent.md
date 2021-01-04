### Change Intent to Activity Without Refresh, FragmentManager

https://stackoverflow.com/questions/8336561/saving-activity-state

```Java
Intent intent = new Intent(this, A.class);
intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
startActivity(intent);
```
