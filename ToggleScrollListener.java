
// => XML
// <android.support.v7.widget.Toolbar
// <android.support.v7.widget.RecyclerView

public abstract class ToggleScrollListener extends RecyclerView.OnScrollListener {
    private static float HIDE_THRESHOLD = 10;
    private int scrolledDistance = 0;
    private boolean controlsVisible = true;

    private TabLayout tabLayout;

    public ToggleScrollListener (TabLayout tab) {
        tabLayout = tab;
    }

    @Override
    public void onScrollStateChanged (RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged (recyclerView, newState);

    }

    @Override
    public void onScrolled (RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled (recyclerView, dx, dy);

        FactoryLogger.Debug (scrolledDistance);

        if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
            onHide ();
            controlsVisible = false;
            scrolledDistance = tabLayout.getHeight ();
        } else if (scrolledDistance < - HIDE_THRESHOLD && !controlsVisible) {
            onShow ();
            controlsVisible = true;
            scrolledDistance = - tabLayout.getHeight ();
        }

        if ((controlsVisible && dy > 0) || (! controlsVisible && dy < 0)) {
            scrolledDistance += dy;
        }
    }

    public abstract void onShow ();
    public abstract void onHide ();

}

// Listener
recyclerView.addOnScrollListener(new ToggleScrollListener (tab) {
    @Override
    public synchronized void onHide() {
        if (tab != null) {
            tab.setVisibility (View.GONE);
        }
    }

    @Override
    public synchronized void onShow() {
        if (tab != null) {
            tab.setVisibility (View.VISIBLE);
        }
    }
});
