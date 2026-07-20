package pd;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.transsion.widgetslistitemlayout.OSListItemView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f8735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f8736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayerDrawable f8737d;
    public Drawable e;
    public Drawable f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8738g = 100;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f8739h = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8741j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8742k;

    public e(Context context, OSListItemView oSListItemView) {
        this.f8734a = context;
        this.f8735b = oSListItemView;
    }

    public final void a(long j8) {
        if (this.e == null) {
            return;
        }
        if (this.f8736c == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
            this.f8736c = valueAnimatorOfInt;
            valueAnimatorOfInt.addListener(new ke.d(this, 1));
            this.f8736c.addUpdateListener(new ee.k(this, 4));
        }
        if (this.f8736c.isRunning()) {
            return;
        }
        this.e.setAlpha(255);
        this.f8736c.setIntValues(255, 0);
        this.f8736c.setStartDelay(j8);
        this.f8736c.setDuration(this.f8738g);
        this.f8736c.start();
    }

    public int getAnimDuration() {
        return this.f8738g;
    }

    public Drawable getBackground() {
        Drawable drawable;
        if (this.f8737d == null || (drawable = this.e) == null) {
            return null;
        }
        drawable.setAlpha(0);
        return this.f8737d;
    }

    public void setAnimDuration(int i8) {
        this.f8738g = i8;
    }

    public void setDrawableNormal(@NonNull Drawable drawable) {
        this.f = drawable;
        LayerDrawable layerDrawable = this.f8737d;
        if (layerDrawable != null) {
            layerDrawable.setDrawable(0, drawable);
        } else if (this.e != null) {
            this.f8737d = new LayerDrawable(new Drawable[]{this.f, this.e});
        }
    }

    public void setDrawablePress(@NonNull Drawable drawable) {
        this.e = drawable;
        LayerDrawable layerDrawable = this.f8737d;
        if (layerDrawable != null) {
            layerDrawable.setDrawable(1, drawable);
        } else if (this.f != null) {
            this.f8737d = new LayerDrawable(new Drawable[]{this.f, this.e});
        }
    }

    public void setOpenNewPage(boolean z2) {
        this.f8741j = z2;
    }

    public void setView(View view) {
        this.f8735b = view;
    }

    public void setDrawableNormal(@ColorInt int i8) {
        setDrawableNormal(new ColorDrawable(i8));
    }

    public void setDrawablePress(@ColorInt int i8) {
        setDrawablePress(new ColorDrawable(i8));
    }
}
