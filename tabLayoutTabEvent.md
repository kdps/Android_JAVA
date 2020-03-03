```JAVA
tabLayout.addOnTabSelectedListener ( new TabLayout.OnTabSelectedListener ( ) {
    @Override public void onTabSelected ( TabLayout.Tab tab ) {
        View view = tabLayout.getTabAt ( tab.getPosition ( ) ).getCustomView ( );
        if ( view != null ) {
            view.setBackgroundResource ( R.drawable.tab_visible );
        }
    }

    @Override public void onTabUnselected ( TabLayout.Tab tab ) {
        View view = tabLayout.getTabAt ( tab.getPosition ( ) ).getCustomView ( );
        if ( view != null ) {
            view.setBackgroundResource ( 0 );
        }
    }

    @Override public void onTabReselected ( TabLayout.Tab tab ) {

    }
} );
```
