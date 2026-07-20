package io.github.inflationx.calligraphy3;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
class Calligraphy {
    private static final String ACTION_BAR_SUBTITLE = "action_bar_subtitle";
    private static final String ACTION_BAR_TITLE = "action_bar_title";
    private final int[] mAttributeId;
    private final CalligraphyConfig mCalligraphyConfig;

    public static class ToolbarLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        static String BLANK = " ";
        private final WeakReference<Calligraphy> mCalligraphyFactory;
        private final WeakReference<Context> mContextRef;
        private final WeakReference<Toolbar> mToolbarReference;
        private final CharSequence originalSubTitle;

        private void removeSelf(Toolbar toolbar) {
            toolbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Toolbar toolbar = this.mToolbarReference.get();
            Context context = this.mContextRef.get();
            Calligraphy calligraphy = this.mCalligraphyFactory.get();
            if (toolbar == null) {
                return;
            }
            if (calligraphy == null || context == null) {
                removeSelf(toolbar);
                return;
            }
            int childCount = toolbar.getChildCount();
            if (childCount != 0) {
                for (int i8 = 0; i8 < childCount; i8++) {
                    calligraphy.onViewCreated(toolbar.getChildAt(i8), context, null);
                }
            }
            removeSelf(toolbar);
            toolbar.setSubtitle(this.originalSubTitle);
        }

        private ToolbarLayoutListener(Calligraphy calligraphy, Context context, Toolbar toolbar) {
            this.mCalligraphyFactory = new WeakReference<>(calligraphy);
            this.mContextRef = new WeakReference<>(context);
            this.mToolbarReference = new WeakReference<>(toolbar);
            this.originalSubTitle = toolbar.getSubtitle();
            toolbar.setSubtitle(BLANK);
        }
    }

    public Calligraphy(CalligraphyConfig calligraphyConfig) {
        this.mCalligraphyConfig = calligraphyConfig;
        this.mAttributeId = new int[]{calligraphyConfig.getAttrId()};
    }

    private String applyFontMapper(String str) {
        FontMapper fontMapper = this.mCalligraphyConfig.getFontMapper();
        return fontMapper != null ? fontMapper.map(str) : str;
    }

    private Typeface getDefaultTypeface(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.mCalligraphyConfig.getFontPath();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TypefaceUtils.load(context.getAssets(), str);
    }

    public static boolean isActionBarSubTitle(TextView textView) {
        if (matchesResourceIdName(textView, ACTION_BAR_SUBTITLE)) {
            return true;
        }
        if (parentIsToolbarV7(textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getSubtitle(), textView.getText());
        }
        return false;
    }

    public static boolean isActionBarTitle(TextView textView) {
        if (matchesResourceIdName(textView, ACTION_BAR_TITLE)) {
            return true;
        }
        if (parentIsToolbarV7(textView)) {
            return TextUtils.equals(((Toolbar) textView.getParent()).getTitle(), textView.getText());
        }
        return false;
    }

    public static boolean matchesResourceIdName(View view, String str) {
        if (view.getId() == -1) {
            return false;
        }
        return view.getResources().getResourceEntryName(view.getId()).equalsIgnoreCase(str);
    }

    public static boolean parentIsToolbarV7(View view) {
        return CalligraphyUtils.canCheckForV7Toolbar() && view.getParent() != null && (view.getParent() instanceof Toolbar);
    }

    private String resolveFontPath(Context context, AttributeSet attributeSet) {
        String strPullFontPathFromView = CalligraphyUtils.pullFontPathFromView(context, attributeSet, this.mAttributeId);
        if (TextUtils.isEmpty(strPullFontPathFromView)) {
            strPullFontPathFromView = CalligraphyUtils.pullFontPathFromStyle(context, attributeSet, this.mAttributeId);
        }
        return TextUtils.isEmpty(strPullFontPathFromView) ? CalligraphyUtils.pullFontPathFromTextAppearance(context, attributeSet, this.mAttributeId) : strPullFontPathFromView;
    }

    public int[] getStyleForTextView(TextView textView) {
        int[] iArr = {-1, -1};
        if (isActionBarTitle(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843512;
        } else if (isActionBarSubTitle(textView)) {
            iArr[0] = 16843470;
            iArr[1] = 16843513;
        }
        if (iArr[0] == -1) {
            iArr[0] = this.mCalligraphyConfig.getClassStyles().containsKey(textView.getClass()) ? this.mCalligraphyConfig.getClassStyles().get(textView.getClass()).intValue() : android.R.attr.textAppearance;
        }
        return iArr;
    }

    public View onViewCreated(View view, Context context, AttributeSet attributeSet) {
        if (view != null) {
            Object tag = view.getTag(R.id.calligraphy_tag_id);
            Boolean bool = Boolean.TRUE;
            if (tag != bool) {
                onViewCreatedInternal(view, context, attributeSet);
                view.setTag(R.id.calligraphy_tag_id, bool);
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onViewCreatedInternal(View view, Context context, AttributeSet attributeSet) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (TypefaceUtils.isLoaded(textView.getTypeface())) {
                return;
            }
            String strResolveFontPath = resolveFontPath(context, attributeSet);
            boolean z2 = true;
            if (TextUtils.isEmpty(strResolveFontPath)) {
                int[] styleForTextView = getStyleForTextView(textView);
                int i8 = styleForTextView[1];
                strResolveFontPath = i8 != -1 ? CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], i8, this.mAttributeId) : CalligraphyUtils.pullFontPathFromTheme(context, styleForTextView[0], this.mAttributeId);
            }
            String strApplyFontMapper = applyFontMapper(strResolveFontPath);
            if (!matchesResourceIdName(view, ACTION_BAR_TITLE) && !matchesResourceIdName(view, ACTION_BAR_SUBTITLE)) {
                z2 = false;
            }
            CalligraphyUtils.applyFontToTextView(context, textView, this.mCalligraphyConfig, strApplyFontMapper, z2);
        }
        if (CalligraphyUtils.canCheckForV7Toolbar() && (view instanceof Toolbar)) {
            Toolbar toolbar = (Toolbar) view;
            toolbar.getViewTreeObserver().addOnGlobalLayoutListener(new ToolbarLayoutListener(context, toolbar));
        }
        if (view instanceof HasTypeface) {
            Typeface defaultTypeface = getDefaultTypeface(context, applyFontMapper(resolveFontPath(context, attributeSet)));
            if (defaultTypeface != null) {
                ((HasTypeface) view).setTypeface(defaultTypeface);
                return;
            }
            return;
        }
        if (this.mCalligraphyConfig.isCustomViewTypefaceSupport() && this.mCalligraphyConfig.isCustomViewHasTypeface(view)) {
            Method method = ReflectionUtils.getMethod(view.getClass(), "setTypeface");
            Typeface defaultTypeface2 = getDefaultTypeface(context, applyFontMapper(resolveFontPath(context, attributeSet)));
            if (method == null || defaultTypeface2 == null) {
                return;
            }
            ReflectionUtils.invokeMethod(view, method, defaultTypeface2);
        }
    }
}
