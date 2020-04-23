public abstract class ToggleScrollListenerWithAppbar extends RecyclerView.OnScrollListener {
    private static float HIDE_THRESHOLD = 10;
    private int scrolledDistance = 0;
    private boolean controlsVisible = true;

    private TabLayout tabLayout;
    private LinearLayout header;
    private AppBarLayout appBar;
    private int appbar_height;
    private int inline_height;

    public ToggleScrollListenerWithAppbar (LinearLayout _header, AppBarLayout _appBar, int height) {
        header = _header;
        appBar = _appBar;
        HIDE_THRESHOLD = height;
        appbar_height = appBar.getMeasuredHeight ();
        inline_height = appbar_height - height;
    }

    @Override
    public void onScrollStateChanged (RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged (recyclerView, newState);
    }

    @Override
    public void onScrolled (RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled (recyclerView, dx, dy);

        int computeY = recyclerView.computeVerticalScrollOffset ();

        if (header != null) {
            if (computeY < HIDE_THRESHOLD) {
                onShow ();
                controlsVisible = true;
                scrolledDistance = - header.getHeight ();
            } else if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
                onHide ();
                controlsVisible = false;
                scrolledDistance = header.getHeight ();
            } else if (scrolledDistance < - HIDE_THRESHOLD && ! controlsVisible) {
                onShow ();
                controlsVisible = true;
                scrolledDistance = - header.getHeight ();
            }

            if (controlsVisible) {
                if (scrolledDistance > 0) {
                    header.animate ().translationY (- scrolledDistance).setInterpolator (new AccelerateInterpolator (0)).setDuration (0);

                    int resizeHeight = (appbar_height - scrolledDistance);

                    if (inline_height < resizeHeight) {
                        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams ();
                        params.height = resizeHeight;
                        appBar.setLayoutParams (params);
                    }
                }
            } else {
                if (scrolledDistance < 0) {
                    onShow ();
                    int moveDistance = - (appbar_height - (- scrolledDistance));
                    header.animate ().translationY (inline_height + moveDistance).setInterpolator (new AccelerateInterpolator (0)).setDuration (0);
                    int resizeHeight = (inline_height + (appbar_height + moveDistance));

                    if (inline_height < resizeHeight) {
                        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams ();
                        params.height = resizeHeight;
                        appBar.setLayoutParams (params);
                    } else {
                        onHide ();
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
