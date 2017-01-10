package me.system.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.comuto.flag.Flaggr;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String FLAGGR_CONFIG_URI = "http://conouchcdn.oss-cn-qingdao.aliyuncs.com/feature/feature.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Flaggr.with(this).loadConfig(FLAGGR_CONFIG_URI);


        SampleFlagContext.FlagContextBuilder builder = new SampleFlagContext.FlagContextBuilder()
                .setLocale(Locale.getDefault().getDisplayCountry());
        if (!Flaggr.with(this).isActive("android_main_hello", builder.build())) {
            TextView view = (TextView) this.findViewById(R.id.hello_text);

            view.setText("DISABLED");
        }
    }
}
