## com.rey.material.widget.Spinner

# Remove Arrow Image

```XML
<style name="SpinnerStyle2" parent="Material.Widget.Spinner">
  <item name="spn_arrowSize">0dp</item>
  <item name="android:background">@android:color/transparent</item>
</style>
```

## ImageView

# Change Width/Height

```Java
mBtnSticker.getLayoutParams().height = getResources ().getDimensionPixelSize (R.dimen.px_60);
mBtnSticker.requestLayout();
```

## TextView

# Remove font padding

```Java
android:includeFontPadding="false"
```
