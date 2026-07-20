package com.transsion.widgetslib.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.viewpager.widget.ViewPager;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$integer;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.R$styleable;
import java.util.ArrayList;
import java.util.Locale;
import qd.k;
import qd.l;
import qd.m;
import qd.o;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPagerTabs extends HorizontalScrollView {
    public static final /* synthetic */ int u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f3200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3202d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f3205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f3206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f3207l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3208m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3209n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f3210o;
    public ViewPager p;
    public ViewPager.OnPageChangeListener q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f3211r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f3212s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f3213t;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3214a;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeInt(this.f3214a);
        }
    }

    public ViewPagerTabs(Context context) {
        this(context, null);
    }

    public static void a(CheckedTextView checkedTextView, float f) {
        int iBreakText;
        String str = (String) checkedTextView.getText();
        if (str == null) {
            return;
        }
        TextPaint paint = checkedTextView.getPaint();
        if (paint.measureText(str) <= f || (iBreakText = paint.breakText(str, 0, str.length(), true, f, null)) <= 0) {
            return;
        }
        try {
            checkedTextView.setText(str.substring(0, iBreakText - 1) + "..");
        } catch (StringIndexOutOfBoundsException e) {
            Log.w("ViewPagerTabs", "OS ViewPagerTabs # breakTitleText() Catch Exception e = " + e);
        }
    }

    public final int b(int i8) {
        return this.f3204i ? (this.f3199a.getChildCount() - 1) - i8 : i8;
    }

    public final void c() {
        for (int i8 = 0; i8 < this.f3199a.getChildCount(); i8++) {
            CheckedTextView checkedTextView = (CheckedTextView) this.f3199a.getChildAt(i8);
            if (i8 != this.f3199a.f8987a) {
                checkedTextView.setChecked(false);
                checkedTextView.setTextAppearance(R$style.os_regular_fontweight);
            } else {
                checkedTextView.setChecked(true);
                checkedTextView.setTextAppearance(R$style.os_semibold_font);
            }
        }
    }

    public int getDefaultViewPagerItemIndex() {
        m mVar = this.f3199a;
        if (mVar == null) {
            return 0;
        }
        return b(mVar.f8987a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3204i = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        ViewPager.OnPageChangeListener onPageChangeListener = this.q;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(0);
        }
        c();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
    }

    public void setItemClickListener(o oVar) {
    }

    public void setLineColor(int i8) {
        m mVar;
        Paint paint;
        Context context = this.f3200b;
        if (context == null || (mVar = this.f3199a) == null || (paint = mVar.f8988b) == null) {
            return;
        }
        paint.setColor(context.getColor(i8));
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.q = onPageChangeListener;
    }

    public void setOnScrollListener(View.OnScrollChangeListener onScrollChangeListener) {
    }

    public void setSelectTextColor(int i8) {
    }

    public void setSelectedTabColors(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        int length = iArr.length;
        int i8 = this.f3209n;
        if (i8 != -1 && length != i8) {
            length = i8;
        }
        if (this.f3207l == null) {
            this.f3207l = new int[length];
        }
        int i9 = 0;
        while (i9 < length) {
            this.f3207l[i9] = i9 <= iArr.length + (-1) ? iArr[i9] : -1;
            i9++;
        }
        this.f3199a.invalidate();
    }

    public void setTabBalanced(boolean z2) {
        this.f3208m = z2;
    }

    public void setTabChildEnable(boolean z2) {
        try {
            m mVar = this.f3199a;
            if (mVar != null) {
                int childCount = mVar.getChildCount();
                for (int i8 = 0; i8 < childCount; i8++) {
                    this.f3199a.getChildAt(i8).setFocusable(false);
                    this.f3199a.getChildAt(i8).setEnabled(z2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTabHeight(int i8) {
        if (this.f3199a == null) {
            return;
        }
        this.e = (int) TypedValue.applyDimension(1, i8, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3199a.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.e;
            this.f3199a.setLayoutParams(layoutParams);
        } else {
            this.f3199a.setLayoutParams(new FrameLayout.LayoutParams(-1, this.e));
        }
    }

    public void setTabs(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            return;
        }
        int length = charSequenceArr.length;
        this.f3209n = length;
        int[] iArr = this.f3207l;
        if (iArr != null && iArr.length != length) {
            int[] iArr2 = new int[length];
            int i8 = 0;
            while (i8 < this.f3209n) {
                int[] iArr3 = this.f3207l;
                iArr2[i8] = i8 <= iArr3.length - 1 ? iArr3[i8] : -1;
                i8++;
            }
            this.f3207l = iArr2;
        }
        this.f3199a.removeAllViews();
        int length2 = charSequenceArr.length;
        if (length2 < 2 || length2 > 4) {
            this.f3208m = false;
        }
        ArrayList arrayList = this.f3205j;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f3205j = new ArrayList(length2);
        }
        int i9 = this.f3213t / length2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i9, -1);
        for (int i10 = 0; i10 < length2; i10++) {
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(this.f3200b).inflate(R$layout.tab_textview, (ViewGroup) null);
            if (charSequenceArr[i10] == null) {
                charSequenceArr[i10] = "";
            }
            checkedTextView.setText(charSequenceArr[i10].toString().trim());
            checkedTextView.setChecked(false);
            checkedTextView.setTextAppearance(R$style.os_regular_fontweight);
            checkedTextView.setSingleLine(true);
            checkedTextView.setGravity(17);
            if (this.f3208m) {
                a(checkedTextView, i9 - (this.f3202d * 2));
            }
            float fMeasureText = checkedTextView.getPaint().measureText((String) checkedTextView.getText());
            this.f3205j.add(Float.valueOf(fMeasureText));
            if (this.f3208m) {
                checkedTextView.setWidth(i9);
            } else {
                checkedTextView.setWidth((int) ((this.f3201c * 2) + fMeasureText));
                int i11 = this.f3201c;
                checkedTextView.setPadding(i11, 0, i11, 0);
            }
            checkedTextView.setTypeface(Typeface.create(Typeface.SANS_SERIF, getResources().getInteger(R$integer.OSSemiBoldWeight), false));
            checkedTextView.setOnClickListener(new k(i10, 0, this));
            if (i10 == this.f3199a.f8987a) {
                checkedTextView.setChecked(true);
                checkedTextView.setTextAppearance(R$style.os_semibold_font);
            }
            this.f3199a.addView(checkedTextView, layoutParams);
        }
        setHorizontalScrollBarEnabled(false);
    }

    public void setUnSelectTextColor(int i8) {
    }

    public void setUnreadTip(int... iArr) {
        m mVar;
        if (iArr == null || iArr.length == 0 || (mVar = this.f3199a) == null) {
            return;
        }
        mVar.invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.p = viewPager;
        getViewTreeObserver().addOnGlobalLayoutListener(new l(this, viewPager));
    }

    public ViewPagerTabs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3206k = new int[2];
        this.f3209n = -1;
        this.f3200b = context;
        Resources resources = getResources();
        context.getTheme();
        this.f3201c = resources.getDimensionPixelOffset(R$dimen.os_viewpager_tab_text_padding);
        this.f3202d = resources.getDimensionPixelOffset(R$dimen.os_viewpager_average_tab_text_padding);
        this.e = resources.getDimensionPixelOffset(R$dimen.os_tab_height);
        this.f3203h = resources.getDimensionPixelOffset(R$dimen.os_foot_bar_line_height);
        this.f3213t = context.getResources().getDisplayMetrics().widthPixels;
        float f = 16;
        this.f3211r = (int) TypedValue.applyDimension(1, f, this.f3200b.getResources().getDisplayMetrics());
        this.f3212s = this.f3213t - ((int) TypedValue.applyDimension(1, f, this.f3200b.getResources().getDisplayMetrics()));
        this.f3213t -= this.f3211r * 2;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewPagerTabs);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ViewPagerTabs_osTabHeight, this.e);
        typedArrayObtainStyledAttributes.recycle();
        this.f3199a = new m(this, context);
        float f4 = resources.getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f3210o = paint;
        paint.setAntiAlias(true);
        this.f3210o.setColor(SupportMenu.CATEGORY_MASK);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new int[]{R$attr.OsBgPrimary});
        setBackgroundColor(typedArrayObtainStyledAttributes2.getColor(0, ContextCompat.getColor(context, R$color.os_bg_primary_color)));
        typedArrayObtainStyledAttributes2.recycle();
        this.f3204i = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.e);
        int i8 = this.f3211r;
        layoutParams.setMargins(i8, 0, i8, 0);
        addView(this.f3199a, layoutParams);
        setFillViewport(true);
    }
}
