Glide 4

```Java
Glide.with (mActivity.this).load (imageUrl).dontAnimate ().apply (RequestOptions.bitmapTransform (new BlurTransformation (mActivity.this, 2))).into (new CustomTarget <Drawable> () {

    @Override
    public void onResourceReady (@NonNull final Drawable resource, @Nullable final Transition<? super Drawable> transition) {
        imageView.setImageDrawable ( resource);
    }

    @Override
    public void onLoadCleared (@Nullable Drawable placeholder) { }
});
```

Glide 3

```Java
Glide.with (mActivity.this).load (imageUrl).dontAnimate ().bitmapTransform (new BlurTransformation (mActivity.this))into (new SimpleTarget<GlideDrawable> () {
    @Override
    public void onResourceReady (GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
        imageView.setScaleX (2.0f);
        imageView.setScaleY (2.0f);
        imageView.setImageDrawable (resource);
    }
});
```
