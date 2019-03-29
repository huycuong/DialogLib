package com.cuong.awesomelib;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cuong.awesomelib.interfaces.Closure;


/**
 * Created by blennersilva on 21/08/17.
 */

@SuppressWarnings("WeakerAccess")
public class AwesomeErrorDialog extends AwesomeDialogBuilder<AwesomeErrorDialog> {
    private Button btDialogOk;
    private RelativeLayout dialogBody;
    private ImageView banner;

    public AwesomeErrorDialog(Context context) {
        super(context);

        setColoredCircle(R.color.white);
        setDialogIconAndColor(R.drawable.icon_cancel, R.color.red);
        setButtonBackgroundColor();
        setCancelable(false);
    }

    {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Cabin-Bold.otf");
        btDialogOk = findView(R.id.btDialogOk);
        btDialogOk.setTypeface(font);

        dialogBody = findView(R.id.dialog_body);
        banner = findView(R.id.banner);
    }

    public AwesomeErrorDialog setDialogBodyBackgroundColor(int color){
        if (dialogBody != null) {
            dialogBody.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeErrorDialog setErrorButtonClick(@Nullable final Closure selecteOk) {
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

    public AwesomeErrorDialog setButtonBackgroundColor() {
        if (btDialogOk != null) {
            btDialogOk.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.ripple_effect_button_share));
        }
        return this;
    }

    public AwesomeErrorDialog setButtonTextColor(int textColor) {
        if (btDialogOk != null) {
            btDialogOk.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }
        return this;
    }

    public AwesomeErrorDialog setButtonText(String text) {
        if (btDialogOk != null) {
            btDialogOk.setText(text);
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public AwesomeErrorDialog setImage(@Nullable final Drawable drawable) {
        if (banner != null) {
            banner.setVisibility(View.VISIBLE);
            banner.setImageDrawable(drawable);
        }else{
            banner.setVisibility(View.GONE);
        }

        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_error;
    }
}
