package com.cuong.awesomelib;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.RelativeLayout;

import com.wang.avi.AVLoadingIndicatorView;


/**
 * Created by blennersilva on 23/08/17.
 */

public class AwesomeProgressDialog extends AwesomeDialogBuilder<AwesomeProgressDialog> {

    private RelativeLayout dialogBody;
    private AVLoadingIndicatorView avi;

    public AwesomeProgressDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogProgressBackgroundColor);
        setProgressBarColor(R.color.white);
        setCancelable(false);
    }

    {
        dialogBody = findView(R.id.dialog_body);
        avi= findView(R.id.avi);
        avi.setIndicator("BallPulseIndicator");
    }

    public void hideClick(View view) {
        avi.hide();
        // or avi.smoothToHide();
    }

    public void showClick(View view) {
        avi.show();
        // or avi.smoothToShow();
    }

    public AwesomeProgressDialog setDialogBodyBackgroundColor(int color){
        if (dialogBody != null) {
            dialogBody.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeProgressDialog setProgressBarColor(int color) {
//        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.white), PorterDuff.Mode.SRC_IN);
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_progress;
    }
}
