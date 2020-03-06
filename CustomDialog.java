
Dialog dialog;

public void initDialog() {
    dialog = new Dilaog(this);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    View view = View.inflate(this, R.layout.dialog, null);
    dialog.setContentView(view);

    view.findViewById(R.id.btn_example).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // do something
            dialog.dismiss();
        }
    });

    dialog.setCancelable(true);
    dialog.show();
}
