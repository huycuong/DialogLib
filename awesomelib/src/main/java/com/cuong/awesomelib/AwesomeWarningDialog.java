package com.cuong.awesomelib;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cuong.awesomelib.interfaces.Closure;


/**
 * Created by blennersilva on 21/08/17.
 */

@SuppressWarnings("WeakerAccess")
public class AwesomeWarningDialog extends AwesomeDialogBuilder<AwesomeWarningDialog> {
    private Button btDialogOk;
    private RelativeLayout dialogBody;

    public AwesomeWarningDialog(Context context) {
        super(context);

        setColoredCircle(R.color.white);
        setDialogIconAndColor(R.drawable.icon_warning_alert, R.color.orange);
        setButtonBackgroundColor();
        setCancelable(false);
    }

    {
        btDialogOk = findView(R.id.btDialogOk);
        dialogBody = findView(R.id.dialog_body);
    }

    public AwesomeWarningDialog setDialogBodyBackgroundColor(int color){
        if (dialogBody != null) {
            dialogBody.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }


    public AwesomeWarningDialog setWarningButtonClick(@Nullable final Closure selecteOk) {
        btDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selecteOk != null) {
                    selecteOk.exec();
                }

                hide();
            }
        });
        return this;
    }

    public AwesomeWarningDialog setButtonBackgroundColor() {
        if (btDialogOk != null) {
            btDialogOk.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.ripple_effect_button_share));
        }
        return this;
    }

    public AwesomeWarningDialog setButtonTextColor(int textColor) {
        if (btDialogOk != null) {
            btDialogOk.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }
        return this;
    }

    public AwesomeWarningDialog setButtonText(String text) {
        if (btDialogOk != null) {
            btDialogOk.setText(text);
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_warning;
    }
}
