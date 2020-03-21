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

## Switch

# Custom Switch

!!! Thumbnail and track color is same when switch is checked

```XML
<?xml version="1.0" encoding="utf-8"?>
<resources xmlns:android="http://schemas.android.com/apk/res/android">
<style name="materialTheme" parent="@style/Theme.AppCompat.Light">
    <item name="colorPrimary">#2e7d32</item>
    <item name="colorPrimaryDark">#005005</item>
    <item name="colorAccent">#80d8ff</item>
    <item name="colorSwitchThumbNormal">#49a7cc</item>
    <item name="android:colorButtonNormal">#49a7cc</item>
    <item name="android:textColorPrimary">#DADADA</item>
    <item name="android:spinnerItemStyle">@style/SpinnerItem</item>
    <item name="android:spinnerDropDownItemStyle">@style/SpinnerDropDownItem</item>
</style>
```
