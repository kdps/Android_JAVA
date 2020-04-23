public class RatioDimentionImageView extends AppCompatImageView {

    public RatioDimentionImageView (Context context, AttributeSet attrs) {
        super (context, attrs);
    }

    public RatioDimentionImageView (Context context) {
        super (context);
    }

    @Override
    protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
        int width     = MeasureSpec.getSize (widthMeasureSpec);
        int maxHeight = (width / 16) * 9;

        this.setMaxHeight (maxHeight);

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
        super.onMeasure (widthMeasureSpec, heightMeasureSpec);
    }
}
