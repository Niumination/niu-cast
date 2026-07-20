package com.transsion.widgetslib.view;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
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
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.transsion.widgetslib.R;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPagerTabs extends HorizontalScrollView {
    public static final int S = 0;
    public static final int T = 2;
    public static final int U = 4;
    public static final float V = 0.35f;
    public static final String W = "ViewPagerTabs";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f2428a0 = -1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f2429b0 = 3;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f2430c0 = -65536;
    public int[] H;
    public int I;
    public Paint J;
    public ViewPager K;
    public ViewPager.OnPageChangeListener L;
    public View.OnScrollChangeListener M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f2431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2437g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<Float> f2438i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f2439n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f2440p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f2441v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f2442w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2443x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2444y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2445z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2446a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2446a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2446a = parcel.readInt();
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2447a;

        public a(int i10) {
            this.f2447a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPagerTabs.this.D(this.f2447a);
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f2449a;

        public b(ViewPager viewPager) {
            this.f2449a = viewPager;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewPagerTabs.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (ViewPagerTabs.this.K != null) {
                this.f2449a.setOnPageChangeListener(ViewPagerTabs.this.new f());
                ViewPagerTabs.this.H();
                this.f2449a.setCurrentItem(ViewPagerTabs.this.getDefaultViewPagerItemIndex(), false);
            }
        }
    }

    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f2451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2452b;

        public c(ViewPager viewPager, int i10) {
            this.f2451a = viewPager;
            this.f2452b = i10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewPagerTabs.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (ViewPagerTabs.this.K != null) {
                this.f2451a.setOnPageChangeListener(ViewPagerTabs.this.new f());
                ViewPagerTabs.this.H();
                this.f2451a.setCurrentItem(ViewPagerTabs.this.w(this.f2452b), false);
                ViewPagerTabs.this.f2431a.f2456a = this.f2452b;
                ViewPagerTabs.this.f2431a.invalidate();
                ViewPagerTabs.this.A(0);
            }
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2454a;

        public d(int i10) {
            this.f2454a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPagerTabs.this.D(this.f2454a);
        }
    }

    public class e extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LinearInterpolator f2458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArgbEvaluator f2459d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f2460e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2461f;

        public e(Context context) {
            super(context);
            this.f2461f = true;
            Paint paint = new Paint(1);
            this.f2460e = paint;
            paint.setColor(ViewPagerTabs.this.f2432b.getColor(R.color.os_gray_tertiary_color));
            this.f2460e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            this.f2460e.setStyle(Paint.Style.STROKE);
            this.f2460e.setStrokeWidth(ViewPagerTabs.this.f2436f);
            this.f2460e.setStrokeCap(Paint.Cap.ROUND);
            this.f2460e.setDither(true);
            this.f2458c = new LinearInterpolator();
            this.f2459d = new ArgbEvaluator();
            setWillNotDraw(false);
        }

        public final void d(TextView textView, int i10, int[] iArr) {
            if (textView == null || iArr == null) {
                return;
            }
            if (iArr.length != 2) {
                throw new IllegalArgumentException("Wrong arguments, array's length must be 2!");
            }
            int width = ((textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) - i10;
            int i11 = width / 2;
            iArr[0] = textView.getPaddingLeft() + textView.getLeft() + i11;
            iArr[1] = (textView.getRight() - textView.getPaddingRight()) - i11;
        }

        public void e(int i10, float f10) {
            this.f2456a = i10;
            this.f2457b = f10;
            ViewPagerTabs.this.K();
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.f2461f && ViewPagerTabs.this.f2437g) {
                ViewPagerTabs.this.fullScroll(66);
                this.f2461f = false;
            }
            int childCount = getChildCount();
            if (childCount > 0) {
                CheckedTextView checkedTextView = (CheckedTextView) getChildAt(this.f2456a);
                d(checkedTextView, (int) ((Float) ViewPagerTabs.this.f2438i.get(this.f2456a)).floatValue(), ViewPagerTabs.this.f2440p);
                boolean z10 = !ViewPagerTabs.this.f2437g ? this.f2456a >= childCount - 1 : this.f2456a <= 0;
                float f10 = this.f2457b;
                if (f10 > 0.0f && z10) {
                    float interpolation = this.f2458c.getInterpolation(f10);
                    CheckedTextView checkedTextView2 = (CheckedTextView) getChildAt(this.f2456a + (ViewPagerTabs.this.f2437g ? -1 : 1));
                    ViewPagerTabs viewPagerTabs = ViewPagerTabs.this;
                    d(checkedTextView2, (int) viewPagerTabs.f2438i.get(this.f2456a + (viewPagerTabs.f2437g ? -1 : 1)).floatValue(), ViewPagerTabs.this.f2441v);
                    ViewPagerTabs viewPagerTabs2 = ViewPagerTabs.this;
                    int[] iArr = viewPagerTabs2.f2440p;
                    int[] iArr2 = viewPagerTabs2.f2441v;
                    float f11 = 1.0f - interpolation;
                    iArr[0] = (int) ((iArr[0] * f11) + (iArr2[0] * interpolation));
                    iArr[1] = (int) ((f11 * iArr[1]) + (interpolation * iArr2[1]));
                    checkedTextView2.setChecked(false);
                    checkedTextView2.setTextAppearance(R.style.os_regular_fontweight);
                }
                checkedTextView.setChecked(true);
                checkedTextView.setTextAppearance(R.style.os_medium_fontweight);
                getBottom();
                int i10 = ViewPagerTabs.this.f2436f;
                canvas.drawLine(0.0f, getBottom(), ViewPagerTabs.this.O, getBottom(), this.f2460e);
            }
        }
    }

    public class f implements ViewPager.OnPageChangeListener {
        public f() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            ViewPagerTabs.h(ViewPagerTabs.this, i10);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            ViewPagerTabs.e(ViewPagerTabs.this, i10, f10, i11);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            ViewPagerTabs.this.Q = i10;
            ViewPagerTabs.this.C(i10);
            ViewPagerTabs viewPagerTabs = ViewPagerTabs.this;
            e eVar = viewPagerTabs.f2431a;
            if (eVar != null) {
                eVar.e(viewPagerTabs.w(i10), 0.0f);
            }
        }

        public /* synthetic */ f(ViewPagerTabs viewPagerTabs, a aVar) {
            this();
        }
    }

    public interface g {
        void a(int i10);
    }

    public ViewPagerTabs(Context context) {
        this(context, null);
    }

    public static void e(ViewPagerTabs viewPagerTabs, int i10, float f10, int i11) {
        viewPagerTabs.B(i10, f10, i11);
    }

    public static void g(ViewPagerTabs viewPagerTabs, int i10) {
        viewPagerTabs.C(i10);
    }

    public static void h(ViewPagerTabs viewPagerTabs, int i10) {
        viewPagerTabs.A(i10);
    }

    public void A(int i10) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.L;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i10);
        }
        if (i10 == 0) {
            K();
        }
    }

    public void B(int i10, float f10, int i11) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.L;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i10, f10, i11);
        }
    }

    public void C(int i10) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.L;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i10);
        }
    }

    public void D(int i10) {
        int iW = w(i10);
        g gVar = this.f2439n;
        if (gVar != null) {
            gVar.a(iW);
        }
        this.K.setCurrentItem(iW, false);
    }

    public final void E(int i10) {
        A(i10);
    }

    public final void F(int i10, float f10, int i11) {
        B(i10, f10, i11);
    }

    public final void G(int i10) {
        C(i10);
    }

    public final void H() {
        int count = this.K.getAdapter().getCount();
        this.f2445z = count;
        int[] iArr = this.f2442w;
        if (iArr != null && iArr.length != count) {
            int[] iArr2 = new int[count];
            int i10 = 0;
            while (i10 < this.f2445z) {
                int[] iArr3 = this.f2442w;
                iArr2[i10] = i10 <= iArr3.length + (-1) ? iArr3[i10] : -1;
                i10++;
            }
            this.f2442w = iArr2;
        }
        q();
        setHorizontalScrollBarEnabled(false);
    }

    public void I(int i10, boolean z10) {
        e eVar = this.f2431a;
        if (eVar != null) {
            int childCount = eVar.getChildCount();
            if (i10 < 0 || i10 >= childCount) {
                return;
            }
            this.f2431a.getChildAt(i10).setEnabled(z10);
        }
    }

    public void J(ViewPager viewPager, int i10) {
        this.K = viewPager;
        getViewTreeObserver().addOnGlobalLayoutListener(new c(viewPager, i10));
    }

    public final void K() {
        for (int i10 = 0; i10 < this.f2431a.getChildCount(); i10++) {
            CheckedTextView checkedTextView = (CheckedTextView) this.f2431a.getChildAt(i10);
            if (i10 != this.f2431a.f2456a) {
                checkedTextView.setChecked(false);
                checkedTextView.setTextAppearance(R.style.os_regular_fontweight);
            } else {
                checkedTextView.setChecked(true);
                checkedTextView.setTextAppearance(R.style.os_medium_fontweight);
            }
        }
    }

    public int getDefaultViewPagerItemIndex() {
        e eVar = this.f2431a;
        if (eVar == null) {
            return 0;
        }
        return w(eVar.f2456a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2437g = y();
        A(0);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public final void q() {
        if (this.f2432b == null) {
            return;
        }
        this.f2431a.removeAllViews();
        PagerAdapter adapter = this.K.getAdapter();
        int count = adapter.getCount();
        t(count);
        ArrayList<Float> arrayList = this.f2438i;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f2438i = new ArrayList<>(count);
        }
        int i10 = this.P / count;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, -1);
        for (int i11 = 0; i11 < count; i11++) {
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(this.f2432b).inflate(R.layout.tab_textview, (ViewGroup) null);
            CharSequence pageTitle = adapter.getPageTitle(i11);
            if (pageTitle == null) {
                pageTitle = "";
            }
            checkedTextView.setText(pageTitle.toString().trim());
            checkedTextView.setChecked(false);
            checkedTextView.setTextAppearance(R.style.os_regular_fontweight);
            checkedTextView.setSingleLine(true);
            checkedTextView.setGravity(17);
            if (this.f2444y) {
                s(checkedTextView, i10 - (this.f2434d * 2));
            }
            float fZ = z(checkedTextView);
            this.f2438i.add(Float.valueOf(fZ));
            if (this.f2444y) {
                checkedTextView.setWidth(i10);
            } else {
                checkedTextView.setWidth((int) ((this.f2433c * 2) + fZ));
                int i12 = this.f2433c;
                checkedTextView.setPadding(i12, 0, i12, 0);
            }
            checkedTextView.setTypeface(Typeface.create("sans-serif-medium", 0));
            checkedTextView.setOnClickListener(new d(i11));
            if (i11 == this.f2431a.f2456a) {
                checkedTextView.setChecked(true);
                checkedTextView.setTextAppearance(R.style.os_medium_fontweight);
            }
            this.f2431a.addView(checkedTextView, layoutParams);
        }
    }

    public final void r(CharSequence[] charSequenceArr) {
        this.f2431a.removeAllViews();
        int length = charSequenceArr.length;
        t(length);
        ArrayList<Float> arrayList = this.f2438i;
        if (arrayList != null) {
            arrayList.clear();
        } else {
            this.f2438i = new ArrayList<>(length);
        }
        int i10 = this.P / length;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, -1);
        for (int i11 = 0; i11 < length; i11++) {
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(this.f2432b).inflate(R.layout.tab_textview, (ViewGroup) null);
            if (charSequenceArr[i11] == null) {
                charSequenceArr[i11] = "";
            }
            checkedTextView.setText(charSequenceArr[i11].toString().trim());
            checkedTextView.setChecked(false);
            checkedTextView.setTextAppearance(R.style.os_regular_fontweight);
            checkedTextView.setSingleLine(true);
            checkedTextView.setGravity(17);
            if (this.f2444y) {
                s(checkedTextView, i10 - (this.f2434d * 2));
            }
            float fZ = z(checkedTextView);
            this.f2438i.add(Float.valueOf(fZ));
            if (this.f2444y) {
                checkedTextView.setWidth(i10);
            } else {
                checkedTextView.setWidth((int) ((this.f2433c * 2) + fZ));
                int i12 = this.f2433c;
                checkedTextView.setPadding(i12, 0, i12, 0);
            }
            checkedTextView.setTypeface(Typeface.create("sans-serif-medium", 0));
            checkedTextView.setOnClickListener(new a(i11));
            if (i11 == this.f2431a.f2456a) {
                checkedTextView.setChecked(true);
                checkedTextView.setTextAppearance(R.style.os_medium_fontweight);
            }
            this.f2431a.addView(checkedTextView, layoutParams);
        }
    }

    public final void s(TextView textView, float f10) {
        String str;
        int iBreakText;
        if (textView == null || (str = (String) textView.getText()) == null) {
            return;
        }
        TextPaint paint = textView.getPaint();
        if (paint.measureText(str) <= f10 || (iBreakText = paint.breakText(str, 0, str.length(), true, f10, null)) <= 0) {
            return;
        }
        try {
            textView.setText(str.substring(0, iBreakText - 1) + "..");
        } catch (StringIndexOutOfBoundsException e10) {
            Log.w(W, "OS ViewPagerTabs # breakTitleText() Catch Exception e = " + e10);
        }
    }

    public void setItemClickListener(g gVar) {
        this.f2439n = gVar;
    }

    public void setLineColor(int i10) {
        e eVar;
        if (this.f2432b == null || (eVar = this.f2431a) == null || eVar.f2460e == null) {
            return;
        }
        this.f2431a.f2460e.setColor(this.f2432b.getColor(i10));
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.L = onPageChangeListener;
    }

    public void setOnScrollListener(View.OnScrollChangeListener onScrollChangeListener) {
        this.M = onScrollChangeListener;
    }

    public void setSelectTextColor(int i10) {
    }

    public void setSelectedTabColors(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        int length = iArr.length;
        int i10 = this.f2445z;
        if (i10 != -1 && length != i10) {
            length = i10;
        }
        if (this.f2442w == null) {
            this.f2442w = new int[length];
        }
        int i11 = 0;
        while (i11 < length) {
            this.f2442w[i11] = i11 <= iArr.length - 1 ? iArr[i11] : -1;
            i11++;
        }
        this.f2443x = true;
        this.f2431a.invalidate();
    }

    public void setTabBalanced(boolean z10) {
        this.f2444y = z10;
    }

    public void setTabChildEnable(boolean z10) {
        try {
            e eVar = this.f2431a;
            if (eVar != null) {
                int childCount = eVar.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    this.f2431a.getChildAt(i10).setFocusable(false);
                    this.f2431a.getChildAt(i10).setEnabled(z10);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setTabHeight(int i10) {
        if (this.f2431a == null) {
            return;
        }
        this.f2435e = (int) TypedValue.applyDimension(1, i10, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2431a.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f2435e;
            this.f2431a.setLayoutParams(layoutParams);
        } else {
            this.f2431a.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f2435e));
        }
    }

    public void setTabs(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            return;
        }
        int length = charSequenceArr.length;
        this.f2445z = length;
        int[] iArr = this.f2442w;
        if (iArr != null && iArr.length != length) {
            int[] iArr2 = new int[length];
            int i10 = 0;
            while (i10 < this.f2445z) {
                int[] iArr3 = this.f2442w;
                iArr2[i10] = i10 <= iArr3.length + (-1) ? iArr3[i10] : -1;
                i10++;
            }
            this.f2442w = iArr2;
        }
        r(charSequenceArr);
        setHorizontalScrollBarEnabled(false);
    }

    public void setUnSelectTextColor(int i10) {
    }

    public void setUnreadTip(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        this.H = iArr;
        e eVar = this.f2431a;
        if (eVar != null) {
            eVar.invalidate();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.K = viewPager;
        getViewTreeObserver().addOnGlobalLayoutListener(new b(viewPager));
    }

    public final void t(int i10) {
        if (i10 < 2 || i10 > 4) {
            this.f2444y = false;
        }
    }

    public final LinearLayout.LayoutParams u(int i10) {
        boolean z10;
        if (i10 <= 0) {
            return null;
        }
        if (i10 == 2 || !(z10 = this.f2444y)) {
            return new LinearLayout.LayoutParams(-2, -1);
        }
        if (z10) {
            return new LinearLayout.LayoutParams(0, -1, 1.0f);
        }
        return null;
    }

    public final int v(int i10) {
        return (int) TypedValue.applyDimension(1, i10, this.f2432b.getResources().getDisplayMetrics());
    }

    public final int w(int i10) {
        return this.f2437g ? (this.f2431a.getChildCount() - 1) - i10 : i10;
    }

    public final void x(AttributeSet attributeSet) {
        Resources resources = getResources();
        this.f2432b.getTheme();
        this.f2433c = resources.getDimensionPixelOffset(R.dimen.os_viewpager_tab_text_padding);
        this.f2434d = resources.getDimensionPixelOffset(R.dimen.os_viewpager_average_tab_text_padding);
        this.f2435e = resources.getDimensionPixelOffset(R.dimen.os_tab_height);
        this.f2436f = resources.getDimensionPixelOffset(R.dimen.os_foot_bar_line_height);
        this.P = this.f2432b.getResources().getDisplayMetrics().widthPixels;
        this.N = v(16);
        this.O = this.P - v(16);
        this.P -= this.N * 2;
        TypedArray typedArrayObtainStyledAttributes = this.f2432b.obtainStyledAttributes(attributeSet, R.styleable.ViewPagerTabs);
        this.f2435e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ViewPagerTabs_osTabHeight, this.f2435e);
        typedArrayObtainStyledAttributes.recycle();
        this.f2431a = new e(this.f2432b);
        this.I = (int) (resources.getDisplayMetrics().density * 3.0f);
        Paint paint = new Paint();
        this.J = paint;
        paint.setAntiAlias(true);
        this.J.setColor(-65536);
        TypedArray typedArrayObtainStyledAttributes2 = this.f2432b.obtainStyledAttributes(new int[]{R.attr.OsBgPrimary});
        setBackgroundColor(typedArrayObtainStyledAttributes2.getColor(0, ContextCompat.getColor(this.f2432b, R.color.os_bg_primary_color)));
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final boolean y() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public final float z(TextView textView) {
        return textView.getPaint().measureText((String) textView.getText());
    }

    public ViewPagerTabs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2440p = new int[2];
        this.f2441v = new int[2];
        this.f2445z = -1;
        this.H = new int[0];
        this.f2432b = context;
        x(attributeSet);
        this.f2437g = y();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f2435e);
        int i10 = this.N;
        layoutParams.setMargins(i10, 0, i10, 0);
        addView(this.f2431a, layoutParams);
        setFillViewport(true);
    }
}
