package mgh.jinhui365.com.android_mingonghui_sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.gzlex.mingonghui.common.MingonghuiManager;
import com.rxhui.utils.StringUtil;
import com.zqpay.zl.util.ToastUtil;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText et_uid;
    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_uid = (EditText) findViewById(R.id.et_uid);
        findViewById(R.id.btn_native).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_native:
                uid = et_uid.getText().toString();
                if(StringUtil.isEmpty(uid)){
                    ToastUtil.showLong(MainActivity.this,"uid不能为空");
                    return;
                }
                MingonghuiManager.getInstance()
                        .setIsProduct(false)
                        .setUid(uid)
                        .setChannelId("11")
                        .open(getApplication(), MainActivity.this);
                break;
        }
    }
}
