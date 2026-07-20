package rd;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.view.OSLoadingView;
import k3.z8;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OSLoadingView f9407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f9408d;
    public Runnable e;
    public final float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f9409g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f9411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ValueAnimator f9412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f9413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9414l;

    public g(Context context) {
        this.f9413k = context;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.f = TypedValue.applyDimension(1, 15.0f, displayMetrics);
        this.f9409g = TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.f9405a = resources.getDimensionPixelSize(R$dimen.os_damping_layout_loading_title);
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.os_damping_layout_loading_view);
        this.f9406b = dimensionPixelSize;
        this.f += dimensionPixelSize;
    }

    public final void a(MotionEvent motionEvent) {
        if (this.f9410h || this.f9411i == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 1 || (action != 2 && action == 3)) {
            if (0.0f < this.f9405a) {
                if (this.e == null) {
                    this.e = new f(this, 3);
                }
                if (this.f9411i.getHandler() != null) {
                    this.f9411i.getHandler().post(this.e);
                    return;
                }
                return;
            }
            this.f9410h = true;
            this.f9408d.setText(R$string.os_dampingl_refreshing);
            this.f9411i.postDelayed(new f(this, 1), 60L);
            d(this.f9405a);
            c(this.f9405a);
            if (this.e == null) {
                this.e = new f(this, 2);
            }
            if (this.f9411i.getHandler() != null) {
                this.f9411i.getHandler().postDelayed(this.e, 2000L);
            }
        }
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f9412j;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        OSLoadingView oSLoadingView = this.f9407c;
        if (oSLoadingView != null) {
            oSLoadingView.g();
        }
        View view = this.f9411i;
        if (view == null || view.getHandler() == null || this.e == null) {
            return;
        }
        this.f9411i.getHandler().removeCallbacks(this.e);
    }

    public final void c(float f) {
        try {
            int i8 = this.f9405a;
            if (f > i8) {
                return;
            }
            float f4 = f / i8;
            this.f9407c.setScaleX((0.8f * f4) + 0.2f);
            OSLoadingView oSLoadingView = this.f9407c;
            oSLoadingView.setScaleY(oSLoadingView.getScaleX());
            float f10 = 0.0f;
            float f11 = (1.0f * f4) + 0.0f;
            this.f9407c.setAlpha(f11);
            this.f9407c.setTranslationY(this.f9409g * f4);
            this.f9407c.setPullPercent(f4);
            TextView textView = this.f9408d;
            textView.setPivotX(textView.getWidth() / 2.0f);
            this.f9408d.setScaleX(f11);
            TextView textView2 = this.f9408d;
            textView2.setScaleY(textView2.getScaleX());
            TextView textView3 = this.f9408d;
            if (f11 > 0.2d) {
                f10 = f11;
            }
            textView3.setAlpha(f10);
            this.f9408d.setTranslationY(this.f * f4);
        } catch (Exception e) {
            z8.c("g", "refresh title layout error", e);
        }
    }

    public final void d(int i8) {
        if (this.f9411i == null) {
            return;
        }
        int iMax = Math.max(i8, this.f9414l);
        this.f9411i.setVisibility(iMax == this.f9414l ? 4 : 0);
        ViewGroup.LayoutParams layoutParams = this.f9411i.getLayoutParams();
        layoutParams.height = iMax;
        this.f9411i.setLayoutParams(layoutParams);
    }

    public View getLayoutHeader() {
        return this.f9411i;
    }

    public OSLoadingView getLoadingView() {
        return this.f9407c;
    }

    public TextView getTextRefreshing() {
        return this.f9408d;
    }

    public void setHeaderLayoutBg(@ColorInt int i8) {
        setHeaderLayoutBg(new ColorDrawable(i8));
    }

    public void setLayoutHeight(int i8) {
        this.f9405a = i8;
    }

    public void setMinHeight(int i8) {
        if (i8 < 0) {
            return;
        }
        this.f9414l = i8;
    }

    public void setOnRefreshListener(h hVar) {
    }

    public void setTextColor(int i8) {
        if (getTextRefreshing() != null) {
            getTextRefreshing().setTextColor(i8);
        }
    }

    public void setHeaderLayoutBg(Drawable drawable) {
        View view = this.f9411i;
        if (view != null) {
            view.setBackground(drawable);
        }
    }
}
