package mgh.jinhui365.com.android_mingonghui_sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gzlex.mingonghui.common.MingonghuiManager;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_native).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_native:
                MingonghuiManager.getInstance()
                        .setIsProduct(false)
                        .init(getApplication());
                break;
        }
    }
}
