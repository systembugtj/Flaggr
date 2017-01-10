package me.system.sample;

import com.comuto.flag.model.FlagContextInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by albert.li on 1/9/17.
 */

public class SampleFlagContext implements FlagContextInterface<String> {

    private Map<String, String> properties;

    private SampleFlagContext(Map<String, String> prop) {
        properties = prop;
    }

    public Map<String, String> getFlagContext() {
        return properties;
    }

    public String getValue(String key) {
        return properties.get(key);
    }

    public static class FlagContextBuilder {
        private Map<String, String> properties = new HashMap<String, String>();
        SampleFlagContext build() {
            return new SampleFlagContext(properties);
        }

        public FlagContextBuilder setLocale(String locale) {
            properties.put("locale", locale);
            return this;
        }
    }


}
