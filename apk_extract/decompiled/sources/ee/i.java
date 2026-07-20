package ee;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.widget.seekbar.OSSectionSeekbar;
import com.transsion.widgetslib.widget.seekbar.OSSeekbar;
import java.lang.ref.WeakReference;
import k3.a2;
import k3.z1;
import k3.z8;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public int A;
    public boolean B;
    public WeakReference C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSSeekbar f4878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f4880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f4881d;
    public float e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4888m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4889n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4890o;
    public float p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f4891r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4893t;
    public int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f4894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4896x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f4897y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4898z;

    public i(OSSeekbar oSSeekbar) {
        int color;
        this.f4878a = oSSeekbar;
        if (oSSeekbar != null) {
            this.C = new WeakReference(oSSeekbar);
            this.f4880c = 0.0f;
            this.f4881d = 100.0f;
            this.e = 0.0f;
            int i8 = R$attr.os_seekbar_track_width;
            int i9 = OSSeekbar.D0;
            int iA = a2.a(3);
            Context context = oSSeekbar.f3576a;
            this.f = pd.j.f(i8, iA, context);
            this.f4882g = pd.j.f(R$attr.os_seekbar_second_track_width, a2.a(3), context);
            this.f4883h = pd.j.f(R$attr.os_seekbar_t_track_width, a2.a(3), context);
            this.f4884i = pd.j.e(context, R$attr.os_fill_weaker, R$color.os_fill_weaker_hios);
            this.f4885j = pd.j.e(context, R$attr.os_platform_basic_color, R$color.os_platform_basic_color_hios);
            this.f4886k = pd.j.e(context, R$attr.os_platform_basic_color, R$color.os_platform_basic_color_hios);
            this.f4887l = pd.j.e(context, R$attr.os_seekbar_section_thumb_in_color, R$color.os_color_white100);
            this.f4888m = pd.j.f(R$attr.os_seekbar_thumb_in_width, a2.a(8), context);
            this.f4889n = pd.j.f(R$attr.os_seekbar_thumb_out_width, a2.a(14), context);
            this.f4890o = a2.a(20);
            this.p = 1.25f;
            this.q = 1.142857f;
            int iE = pd.j.e(context, R$attr.os_grayfill_base, R$color.os_grayfill_base_hios);
            this.f4892s = iE;
            this.f4893t = iE;
            this.u = pd.j.e(context, R$attr.os_seekbar_thumb_in_disable_color, R$color.os_layer_low_hios);
            this.f4891r = oSSeekbar.getContext().getResources().getDimensionPixelOffset(R$dimen.os_dimen_seekbar_thumb_out_width_hios);
            int i10 = R$attr.os_seekbar_section_dot_size;
            int i11 = OSSectionSeekbar.p0;
            this.f4894v = pd.j.f(i10, z1.a(6), context);
            this.f4895w = pd.j.e(context, R$attr.os_grayfill_strong, R$color.os_grayfill_strong_hios);
            if (pd.j.f8765b) {
                color = context.getResources().getColor(R$color.os_color_white30, context.getTheme());
            } else {
                TypedValue typedValue = new TypedValue();
                color = oSSeekbar.getContext().getTheme().resolveAttribute(R$attr.os_platform_basic_color, typedValue, true) ? context.getResources().getColor(typedValue.resourceId, context.getTheme()) : context.getResources().getColor(R$color.os_platform_basic_color_hios, context.getTheme());
            }
            this.f4896x = color;
            this.f4897y = pd.j.e(context, R$attr.os_seekbar_section_dot_disable_color, R$color.os_grayfill_strong_hios);
        }
    }

    public final void a() {
        WeakReference weakReference = this.C;
        Intrinsics.checkNotNull(weakReference);
        if (weakReference.get() != null) {
            WeakReference weakReference2 = this.C;
            Intrinsics.checkNotNull(weakReference2);
            Object obj = weakReference2.get();
            Intrinsics.checkNotNull(obj);
            OSSeekbar oSSeekbar = (OSSeekbar) obj;
            oSSeekbar.getClass();
            Intrinsics.checkNotNullParameter(this, "builder");
            oSSeekbar.min = getMin();
            oSSeekbar.max = getMax();
            oSSeekbar.f3581d = getProgress();
            oSSeekbar.Q = getTrackColor();
            oSSeekbar.R = getSecondTrackColor();
            oSSeekbar.e = getTrackWidth();
            oSSeekbar.f3585i = getTrackWidth();
            oSSeekbar.T = getThumbOutColor();
            oSSeekbar.U = getThumbInsideColor();
            oSSeekbar.f3577a0 = getSecondTrackColorDisable();
            oSSeekbar.f3579b0 = getThumbOutColorDisable();
            oSSeekbar.c0 = getThumbInsideColorDisable();
            oSSeekbar.f3583h = getSecondTrackWidth();
            oSSeekbar.f3587j = getSecondTrackWidth();
            oSSeekbar.f3588k = getTrackWidthMax();
            float thumbOutWidth = (getThumbOutWidth() - getThumbInWidth()) * 0.5f;
            oSSeekbar.f3605w = thumbOutWidth;
            if (thumbOutWidth < 0.0f) {
                oSSeekbar.f3605w = 0.0f;
            }
            oSSeekbar.f3607x = getThumbInWidth() * 0.5f;
            if (getThumbInMaxWidth() < getThumbInWidth()) {
                setThumbInMaxWidth(getThumbInWidth());
            }
            oSSeekbar.f3609y = getThumbInMaxWidth() * 0.5f;
            float f = oSSeekbar.f3607x;
            oSSeekbar.f3610z = f;
            oSSeekbar.A = f;
            oSSeekbar.D = getThumbInMaxScal();
            if (oSSeekbar.f3605w != 0.0f) {
                oSSeekbar.H = ((getThumbOutMaxScal() * getThumbOutWidth()) - (getThumbInMaxScal() * getThumbInWidth())) / (oSSeekbar.f3605w * 2);
            }
            if (oSSeekbar.H < 1.0f) {
                oSSeekbar.H = 1.0f;
            }
            oSSeekbar.h();
            oSSeekbar.S = getThumbInsideUnAbleColorHios();
            oSSeekbar.f3603u0 = getDotsSize();
            oSSeekbar.f3606w0 = getDotsSelectedColor();
            oSSeekbar.f3608x0 = getDotsSelectedColorDisable();
            oSSeekbar.v0 = getDotsColor();
            oSSeekbar.A0 = getShowMiddlePoint();
            oSSeekbar.f3596o0 = null;
            z8.b("OSSeekbar", "leftIcon = " + getLeftIcon() + " rightIcon = " + getRightIcon());
            if ((getRightIcon() != 0 || getLeftIcon() != 0) && (oSSeekbar.getParent() instanceof ViewGroup)) {
                ViewParent parent = oSSeekbar.getParent();
                LinearLayout linearLayout = new LinearLayout(oSSeekbar.getContext());
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) parent;
                int iIndexOfChild = viewGroup.indexOfChild(oSSeekbar);
                viewGroup.removeViewInLayout(oSSeekbar);
                ViewGroup.LayoutParams layoutParams = oSSeekbar.getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(linearLayout, iIndexOfChild, layoutParams);
                } else {
                    viewGroup.addView(linearLayout, iIndexOfChild);
                }
                if (getLeftIcon() > 0) {
                    ImageView imageViewG = oSSeekbar.g(getLeftIcon());
                    oSSeekbar.p0 = imageViewG;
                    linearLayout.addView(imageViewG);
                }
                linearLayout.addView(oSSeekbar);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.weight = 1.0f;
                oSSeekbar.setLayoutParams(layoutParams2);
                if (getRightIcon() > 0) {
                    ImageView imageViewG2 = oSSeekbar.g(getRightIcon());
                    oSSeekbar.f3597q0 = imageViewG2;
                    linearLayout.addView(imageViewG2);
                }
            }
            oSSeekbar.requestLayout();
        }
    }

    public final int getDotsColor() {
        return this.f4895w;
    }

    public final int getDotsSelectedColor() {
        return this.f4896x;
    }

    public final int getDotsSelectedColorDisable() {
        return this.f4897y;
    }

    public final int getDotsSize() {
        return this.f4894v;
    }

    public final int getLeftIcon() {
        return this.f4898z;
    }

    public final float getMax() {
        return this.f4881d;
    }

    public final float getMin() {
        return this.f4880c;
    }

    public final OSSeekbar getOsWideSeekbarNew() {
        return this.f4878a;
    }

    public final float getProgress() {
        return this.e;
    }

    public final int getRightIcon() {
        return this.A;
    }

    public final int getSecondTrackColor() {
        return this.f4885j;
    }

    public final int getSecondTrackColorDisable() {
        return this.f4892s;
    }

    public final int getSecondTrackWidth() {
        return this.f4882g;
    }

    public final boolean getShowMiddlePoint() {
        return this.B;
    }

    public final float getThumbHeightHios() {
        return this.f4891r;
    }

    public final float getThumbInMaxScal() {
        return this.p;
    }

    public final int getThumbInMaxWidth() {
        return this.f4890o;
    }

    public final int getThumbInWidth() {
        return this.f4888m;
    }

    public final int getThumbInsideColor() {
        return this.f4887l;
    }

    public final int getThumbInsideColorDisable() {
        return this.u;
    }

    public final int getThumbInsideUnAbleColorHios() {
        return this.f4879b;
    }

    public final int getThumbOutColor() {
        return this.f4886k;
    }

    public final int getThumbOutColorDisable() {
        return this.f4893t;
    }

    public final float getThumbOutMaxScal() {
        return this.q;
    }

    public final int getThumbOutWidth() {
        return this.f4889n;
    }

    public final int getTrackColor() {
        return this.f4884i;
    }

    public final int getTrackWidth() {
        return this.f;
    }

    public final int getTrackWidthMax() {
        return this.f4883h;
    }

    public final void setDotsColor(int i8) {
        this.f4895w = i8;
    }

    public final void setDotsSelectedColor(int i8) {
        this.f4896x = i8;
    }

    public final void setDotsSelectedColorDisable(int i8) {
        this.f4897y = i8;
    }

    public final void setDotsSize(int i8) {
        this.f4894v = i8;
    }

    public final void setLeftIcon(int i8) {
        this.f4898z = i8;
    }

    public final void setMax(float f) {
        this.f4881d = f;
    }

    public final void setMin(float f) {
        this.f4880c = f;
    }

    public final void setProgress(float f) {
        this.e = f;
    }

    public final void setRightIcon(int i8) {
        this.A = i8;
    }

    public final void setSecondTrackColor(int i8) {
        this.f4885j = i8;
    }

    public final void setSecondTrackColorDisable(int i8) {
        this.f4892s = i8;
    }

    public final void setSecondTrackWidth(int i8) {
        this.f4882g = i8;
    }

    public final void setShowMiddlePoint(boolean z2) {
        this.B = z2;
    }

    public final void setThumbHeightHios(float f) {
        this.f4891r = f;
    }

    public final void setThumbInMaxScal(float f) {
        this.p = f;
    }

    public final void setThumbInMaxWidth(int i8) {
        this.f4890o = i8;
    }

    public final void setThumbInWidth(int i8) {
        this.f4888m = i8;
    }

    public final void setThumbInsideColor(int i8) {
        this.f4887l = i8;
    }

    public final void setThumbInsideColorDisable(int i8) {
        this.u = i8;
    }

    public final void setThumbInsideUnAbleColorHios(int i8) {
        this.f4879b = i8;
    }

    public final void setThumbOutColor(int i8) {
        this.f4886k = i8;
    }

    public final void setThumbOutColorDisable(int i8) {
        this.f4893t = i8;
    }

    public final void setThumbOutMaxScal(float f) {
        this.q = f;
    }

    public final void setThumbOutWidth(int i8) {
        this.f4889n = i8;
    }

    public final void setTrackColor(int i8) {
        this.f4884i = i8;
    }

    public final void setTrackWidth(int i8) {
        this.f = i8;
    }

    public final void setTrackWidthMax(int i8) {
        this.f4883h = i8;
    }
}
