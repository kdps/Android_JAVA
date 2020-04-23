public abstract class ToggleScrollListenerWithAppbar extends RecyclerView.OnScrollListener {
    private static float HIDE_THRESHOLD = 10;
    private boolean controlsVisible = true;
    private int scrolledDistance = 0;
    private int appbarHeight;
    private int inlineHeight;
    private int headerHeight;
    private LinearLayout header;
    private AppBarLayout appBar;

    public ToggleScrollListenerWithAppbar (LinearLayout _header, AppBarLayout _appBar, int height) {
        header = _header;
        appBar = _appBar;
        HIDE_THRESHOLD = height;
        appbarHeight = appBar.getMeasuredHeight ();
        inlineHeight = appbarHeight - height;
        headerHeight = header.getHeight ();
    }

    @Override
    public void onScrollStateChanged (RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged (recyclerView, newState);
    }

    private void hiddenAppbar () {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams ();
        params.height = inlineHeight;
        appBar.setLayoutParams (params);
    }

    private void restoreAppbar () {
        header.animate ().translationY (0).setInterpolator (new AccelerateInterpolator (0)).setDuration (0);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams ();
        params.height = appbarHeight;
        appBar.setLayoutParams (params);
    }

    private void setStatePosition (boolean isHidden) {
        controlsVisible = ! isHidden;
        scrolledDistance = isHidden ? headerHeight : - headerHeight;
    }

    @Override
    public void onScrolled (final RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled (recyclerView, dx, dy);

        boolean scrollToUp = (dy > 0);
        int     computeY   = recyclerView.computeVerticalScrollOffset ();

        if (header != null) {
            if (computeY < HIDE_THRESHOLD) {
                onShow ();
                restoreAppbar ();
                setStatePosition (false);
            } else if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
                onHide ();
                hiddenAppbar ();
                setStatePosition (true);
            } else if (scrolledDistance < - HIDE_THRESHOLD && ! controlsVisible) {
                onShow ();
                restoreAppbar ();
                setStatePosition (false);
            }

            if (controlsVisible && scrolledDistance < - HIDE_THRESHOLD) {
                if (! scrollToUp) {
                    scrolledDistance = scrolledDistance + (dy);
                }

                if (scrolledDistance > 0) {
                    header.animate ().translationY (- scrolledDistance).setInterpolator (new AccelerateInterpolator (0)).setDuration (0);

                    int     resizeHeight = (appbarHeight - scrolledDistance);
                    boolean isEnough     = inlineHeight < resizeHeight;

                    if (isEnough) {
                        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams ();
                        params.height = resizeHeight;
                        appBar.setLayoutParams (params);
                    } else {
                        onHide ();
                        hiddenAppbar ();
                        controlsVisible = false;
                        scrolledDistance = - headerHeight;
                    }
                }
            } else {
                if (scrollToUp && scrolledDistance > HIDE_THRESHOLD) {
                    scrolledDistance = scrolledDistance + (dy);
                }

                if (scrolledDistance < 0) {
                    onShow ();
                    int moveDistance = inlineHeight + (- (appbarHeight - (- scrolledDistance)));
                    header.animate ().translationY (moveDistance).setInterpolator (new AccelerateInterpolator (0)).setDuration (0);
                    int resizeHeight = ((appbarHeight + moveDistance));

                    if (inlineHeight < resizeHeight) {
                        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams ();
                        params.height = resizeHeight;
                        appBar.setLayoutParams (params);
                    }
                }
            }

            if ((controlsVisible && dy > 0) || (! controlsVisible && dy < 0)) {
                scrolledDistance += dy;
            }
        }
    }

    public abstract void onShow ();

    public abstract void onHide ();

}
