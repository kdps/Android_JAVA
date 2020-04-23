import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

public abstract class ToggleScrollListenerWithAppbar extends RecyclerView.OnScrollListener {
    private static float HIDE_THRESHOLD = 10;
    private boolean controlsVisible = true;
    private int scrolledDistance = 0;
    private int appbarHeight;
    private int inlineHeight;
    private int headerHeight;
    private LinearLayout header;
    private AppBarLayout appBar;

    protected ToggleScrollListenerWithAppbar (LinearLayout _header, AppBarLayout _appBar, int height) {
        header = _header;
        appBar = _appBar;
        HIDE_THRESHOLD = height;
        appbarHeight = appBar.getMeasuredHeight ();
        inlineHeight = appbarHeight - height;
        headerHeight = header.getHeight ();
    }

    @Override
    public void onScrollStateChanged (@NonNull final RecyclerView recyclerView, int newState) {
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

        // Null Exception
        if (header != null) {
            // scroll is in top
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

            // Fold
            if (controlsVisible) {
                // Unfold
                if (! scrollToUp && scrolledDistance > 0) {
                    scrolledDistance = scrolledDistance + (dy);
                }

                // stretch view
                if (scrolledDistance > 0) {
                    header.animate ().translationY (- scrolledDistance).setInterpolator (new AccelerateInterpolator (0)).setDuration (0);

                    int     resizeHeight = (appbarHeight - scrolledDistance);
                    boolean isEnough     = inlineHeight < resizeHeight;

                    if (isEnough) {
                        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams ();
                        params.height = resizeHeight;
                        appBar.setLayoutParams (params);
                    } else {
                        // Fold view
                        onHide ();
                        hiddenAppbar ();
                        controlsVisible = false;
                        scrolledDistance = - headerHeight;
                    }
                }

                // Unfold
            } else {
                // Fold
                if (scrollToUp && scrolledDistance < 0) {
                    scrolledDistance = scrolledDistance + (dy);
                }

                // stretch view
                if (scrolledDistance < 0) {
                    onShow ();
                    int moveDistance = inlineHeight + (- (appbarHeight - (- scrolledDistance)));
                    header.animate ().translationY (moveDistance).setInterpolator (new AccelerateInterpolator (0)).setDuration (0);
                    int resizeHeight = ((appbarHeight + moveDistance));

                    if (inlineHeight < resizeHeight) {
                        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBar.getLayoutParams ();
                        params.height = resizeHeight;
                        appBar.setLayoutParams (params);
                    } else {
                        onShow ();
                        restoreAppbar ();

                        controlsVisible = true;
                        scrolledDistance = headerHeight;
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
