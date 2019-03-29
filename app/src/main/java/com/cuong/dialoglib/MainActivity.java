package com.cuong.dialoglib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cuong.awesomelib.AwesomeErrorDialog;
import com.cuong.awesomelib.interfaces.Closure;

public class MainActivity extends AppCompatActivity {

    AwesomeErrorDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new AwesomeErrorDialog(this);

        dialog.setMessage("Co loi xay ra")
                .setErrorButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        dialog.hide();
                    }
                })
                .show();
    }
}
