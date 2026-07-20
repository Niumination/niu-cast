package io.github.inflationx.calligraphy3;

import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class CalligraphyConfig {
    private static final Map<Class<? extends TextView>, Integer> DEFAULT_STYLES;
    private final Set<Class<?>> hasTypefaceViews;
    private final int mAttrId;
    private final Map<Class<? extends TextView>, Integer> mClassStyleAttributeMap;
    private final boolean mCustomViewTypefaceSupport;
    private final FontMapper mFontMapper;
    private final String mFontPath;
    private final boolean mIsFontSet;

    public static class Builder {
        public static final int INVALID_ATTR_ID = -1;
        private FontMapper fontMapper;
        private boolean customViewTypefaceSupport = false;
        private int attrId = R.attr.fontPath;
        private boolean isFontSet = false;
        private String fontAssetPath = null;
        private Map<Class<? extends TextView>, Integer> mStyleClassMap = new HashMap();
        private Set<Class<?>> mHasTypefaceClasses = new HashSet();

        public Builder addCustomStyle(Class<? extends TextView> cls, int i8) {
            if (cls != null && i8 != 0) {
                this.mStyleClassMap.put(cls, Integer.valueOf(i8));
            }
            return this;
        }

        public Builder addCustomViewWithSetTypeface(Class<?> cls) {
            this.customViewTypefaceSupport = true;
            this.mHasTypefaceClasses.add(cls);
            return this;
        }

        public CalligraphyConfig build() {
            this.isFontSet = !TextUtils.isEmpty(this.fontAssetPath);
            return new CalligraphyConfig(this);
        }

        public Builder setDefaultFontPath(String str) {
            this.isFontSet = !TextUtils.isEmpty(str);
            this.fontAssetPath = str;
            return this;
        }

        public Builder setFontAttrId(int i8) {
            this.attrId = i8;
            return this;
        }

        public Builder setFontMapper(FontMapper fontMapper) {
            this.fontMapper = fontMapper;
            return this;
        }
    }

    static {
        HashMap map = new HashMap();
        DEFAULT_STYLES = map;
        map.put(TextView.class, Integer.valueOf(android.R.attr.textViewStyle));
        map.put(Button.class, Integer.valueOf(android.R.attr.buttonStyle));
        map.put(EditText.class, Integer.valueOf(android.R.attr.editTextStyle));
        Integer numValueOf = Integer.valueOf(android.R.attr.autoCompleteTextViewStyle);
        map.put(AutoCompleteTextView.class, numValueOf);
        map.put(MultiAutoCompleteTextView.class, numValueOf);
        map.put(CheckBox.class, Integer.valueOf(android.R.attr.checkboxStyle));
        map.put(RadioButton.class, Integer.valueOf(android.R.attr.radioButtonStyle));
        map.put(ToggleButton.class, Integer.valueOf(android.R.attr.buttonStyleToggle));
        if (CalligraphyUtils.canAddV7AppCompatViews()) {
            addAppCompatViews();
        }
    }

    private static void addAppCompatViews() {
        Map<Class<? extends TextView>, Integer> map = DEFAULT_STYLES;
        map.put(AppCompatTextView.class, Integer.valueOf(android.R.attr.textViewStyle));
        map.put(AppCompatButton.class, Integer.valueOf(android.R.attr.buttonStyle));
        map.put(AppCompatEditText.class, Integer.valueOf(android.R.attr.editTextStyle));
        Integer numValueOf = Integer.valueOf(android.R.attr.autoCompleteTextViewStyle);
        map.put(AppCompatAutoCompleteTextView.class, numValueOf);
        map.put(AppCompatMultiAutoCompleteTextView.class, numValueOf);
        map.put(AppCompatCheckBox.class, Integer.valueOf(android.R.attr.checkboxStyle));
        map.put(AppCompatRadioButton.class, Integer.valueOf(android.R.attr.radioButtonStyle));
        map.put(AppCompatCheckedTextView.class, Integer.valueOf(android.R.attr.checkedTextViewStyle));
    }

    public int getAttrId() {
        return this.mAttrId;
    }

    public Map<Class<? extends TextView>, Integer> getClassStyles() {
        return this.mClassStyleAttributeMap;
    }

    public FontMapper getFontMapper() {
        return this.mFontMapper;
    }

    public String getFontPath() {
        return this.mFontPath;
    }

    public boolean isCustomViewHasTypeface(View view) {
        return this.hasTypefaceViews.contains(view.getClass());
    }

    public boolean isCustomViewTypefaceSupport() {
        return this.mCustomViewTypefaceSupport;
    }

    public boolean isFontSet() {
        return this.mIsFontSet;
    }

    private CalligraphyConfig(Builder builder) {
        this.mIsFontSet = builder.isFontSet;
        this.mFontPath = builder.fontAssetPath;
        this.mAttrId = builder.attrId;
        this.mCustomViewTypefaceSupport = builder.customViewTypefaceSupport;
        HashMap map = new HashMap(DEFAULT_STYLES);
        map.putAll(builder.mStyleClassMap);
        this.mClassStyleAttributeMap = Collections.unmodifiableMap(map);
        this.hasTypefaceViews = Collections.unmodifiableSet(builder.mHasTypefaceClasses);
        this.mFontMapper = builder.fontMapper;
    }
}
