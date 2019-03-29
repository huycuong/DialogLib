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
public class AwesomeNoticeDialog extends AwesomeDialogBuilder<AwesomeNoticeDialog> {
    private Button positiveButton, neutralButton, negativeButton;
    private RelativeLayout dialogBody;
    private ImageView banner;
    private Context mContext;

    public AwesomeNoticeDialog(Context context) {
        super(context);
        mContext = context;

//        setColoredCircle(R.color.dialogNoticeBackgroundColor);
//        setDialogIconAndColor(R.drawable.ic_notice, R.color.white);
//        setButtonBackgroundColor(R.color.dialogNoticeBackgroundColor);
        setCancelable(true);
    }

    {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Cabin-Bold.otf");

        positiveButton = findView(R.id.btDialogYes);
        positiveButton.setTypeface(font);

        negativeButton = findView(R.id.btDialogNo);
        negativeButton.setTypeface(font);

        neutralButton = findView(R.id.btDialogNeutral);
        neutralButton.setTypeface(font);

        dialogBody = findView(R.id.dialog_body);
        banner = findView(R.id.banner2);
    }

    public AwesomeNoticeDialog setDialogBodyBackgroundColor(int color){
        if (dialogBody != null) {
            dialogBody.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeNoticeDialog setPositiveButtonClick(@Nullable final Closure selectedYes) {
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedYes != null) {
                    selectedYes.exec();
                }

                hide();
            }
        });

        return this;
    }

    public AwesomeNoticeDialog setNeutralButtonClick(@Nullable final Closure selectedNeutral) {
        neutralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedNeutral != null) {
                    selectedNeutral.exec();
                }

                hide();
            }
        });

        return this;
    }

    public AwesomeNoticeDialog setPositiveButtonText(String text) {
        if (positiveButton != null) {
            positiveButton.setText(text);
            positiveButton.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public AwesomeNoticeDialog setNeutralButtonText(String text) {
        if (neutralButton != null) {
            neutralButton.setText(text);
        }

        return this;
    }

    public AwesomeNoticeDialog setImage(@Nullable final Drawable drawable) {
        if (banner != null) {
            banner.setImageDrawable(drawable);
        }

        return this;
    }

    public AwesomeNoticeDialog setShowBanner(boolean isShow) {
        if (banner != null) {
            if (isShow) {
                banner.setVisibility(View.VISIBLE);
            } else {
                banner.setVisibility(View.GONE);
            }
        }
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_notice;
    }
}
