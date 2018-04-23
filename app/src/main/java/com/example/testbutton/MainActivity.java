package com.example.testbutton;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.id.button2;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text_view);

        // 匿名クラス
        final Button button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (flag) {
                    textView.setText("Type0: Hello");
                    flag = false;
                }
                else {
                    textView.setText("Type0: World");
                    flag = true;
                }
            }
        });
        // 変数でまとめる
        final Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(buttonClick);

        // OnClickListener を implementsして onClick を定義
        final Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        // カスタムクラス
        final Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new buttonClick());

    }

    // 変数でまとめる
    private View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_1:
                    if (flag) {
                        textView.setText("Type1: Hello");
                        flag = false;
                    }
                    else {
                        textView.setText("Type1: World");
                        flag = true;
                    }
                    break;
            }
        }
    };

    // OnClickListener を implementsして onClick を定義
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.button_2:
                if (flag) {
                    textView.setText("Type2: Hello");
                    flag = false;
                }
                else {
                    textView.setText("Type2: World");
                    flag = true;
                }
                break;
        }
    }

    // カスタムクラス
    class buttonClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_3:
                    if (flag) {
                        textView.setText("Type3: Hello");
                        flag = false;
                    } else {
                        textView.setText("Type3: World");
                        flag = true;
                    }
                    break;
            }
        }
    }

    // android:onClick
    public void selfDestruct(View view) {
        switch (view.getId()) {
            case R.id.button_4:
                if (flag) {
                    textView.setText("Type4: Hello");
                    flag = false;
                } else {
                    textView.setText("Type4: World");
                    flag = true;
                }
                break;
        }
    }
}
