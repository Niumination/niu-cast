package com.transsion.widgetslib.blur.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import bj.b;
import yi.a;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBlurView extends View {
    public boolean H;
    public Bitmap I;
    public boolean J;
    public final int[] K;
    public final int[] L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f2321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f2322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Canvas f2323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f2324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2325g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2326i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f2327n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2328p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2329v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2330w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2331x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2332y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Path f2333z;

    public DynamicBlurView(Context context) {
        super(context);
        this.f2325g = 0;
        this.f2326i = 4;
        this.f2327n = 1.0f;
        this.f2328p = 2;
        this.f2329v = 1001;
        this.f2330w = 0;
        this.f2331x = 0;
        this.f2332y = 0;
        this.f2333z = new Path();
        this.H = false;
        this.J = false;
        this.K = new int[2];
        this.L = new int[2];
        a(context);
    }

    public final void a(Context context) {
        this.f2324f = a.a(context).f(this.f2329v).h();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0078 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0079 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0094 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0095 A[RETURN] */
    public final boolean b() {
        boolean z10;
        int width = getWidth();
        int height = getHeight();
        b bVar = this.f2324f;
        if (bVar != null) {
            bVar.j(this.f2328p);
            this.f2324f.m(this.f2325g);
            this.f2324f.o(this.f2327n);
        }
        int iCeil = (int) Math.ceil(width / this.f2326i);
        int iCeil2 = (int) Math.ceil(height / this.f2326i);
        if (iCeil < 1 || iCeil2 < 1) {
            return false;
        }
        Bitmap bitmap = this.f2322d;
        if (bitmap != null) {
            if (iCeil == bitmap.getWidth() && iCeil2 == this.f2322d.getHeight()) {
                z10 = false;
            } else {
                if (!this.f2322d.isRecycled()) {
                    this.f2322d.recycle();
                    this.f2322d = null;
                }
                this.f2322d = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
            }
            if (this.f2322d == null) {
                return false;
            }
            if (z10) {
                Canvas canvas = new Canvas(this.f2322d);
                this.f2323e = canvas;
                int i10 = this.f2326i;
                canvas.scale(1.0f / i10, 1.0f / i10);
            }
            if (this.f2323e == null) {
                return false;
            }
            return true;
        }
        this.f2322d = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
        z10 = true;
        if (this.f2322d == null) {
            return false;
        }
        if (z10) {
            Canvas canvas2 = new Canvas(this.f2322d);
            this.f2323e = canvas2;
            int i11 = this.f2326i;
            canvas2.scale(1.0f / i11, 1.0f / i11);
        }
        if (this.f2323e == null) {
            return false;
        }
        return true;
    }

    public DynamicBlurView c() {
        Bitmap bitmap = this.f2322d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f2322d.recycle();
        }
        Bitmap bitmap2 = this.I;
        if (bitmap2 != null && bitmap2 != this.f2322d && !bitmap2.isRecycled()) {
            this.I.recycle();
        }
        this.f2321c = null;
        return this;
    }

    public DynamicBlurView d(boolean z10) {
        this.J = z10;
        return this;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f2332y > 0) {
            this.f2333z.rewind();
            Path path = this.f2333z;
            float width = getWidth();
            float height = getHeight();
            int i10 = this.f2332y;
            path.addRoundRect(0.0f, 0.0f, width, height, i10, i10, Path.Direction.CW);
            canvas.clipPath(this.f2333z);
        }
        super.draw(canvas);
    }

    public DynamicBlurView e(int i10) {
        this.f2328p = i10;
        return this;
    }

    public DynamicBlurView f(b bVar) {
        if (bVar != null) {
            this.f2324f = bVar;
        }
        return this;
    }

    public DynamicBlurView g(int i10) {
        if (i10 >= 0) {
            this.f2325g = i10;
        }
        return this;
    }

    public DynamicBlurView h(View view) {
        this.f2321c = view;
        return this;
    }

    public DynamicBlurView i(int i10) {
        if (i10 >= 1) {
            this.f2326i = i10;
        }
        return this;
    }

    public DynamicBlurView j(boolean z10) {
        this.H = z10;
        return this;
    }

    public DynamicBlurView k(int i10) {
        if (i10 >= 0) {
            this.f2332y = i10;
        }
        return this;
    }

    public DynamicBlurView l(int i10) {
        this.f2330w = i10;
        return this;
    }

    public DynamicBlurView m(int i10) {
        this.f2331x = i10;
        return this;
    }

    public DynamicBlurView n() {
        boolean zB = b();
        View view = this.f2321c;
        Bitmap bitmap = this.f2322d;
        Canvas canvas = this.f2323e;
        if (zB && view != null && bitmap != null && canvas != null) {
            if (view.getBackground() == null || !(view.getBackground() instanceof ColorDrawable)) {
                bitmap.eraseColor(Color.argb(255, 255, 0, 0));
            } else {
                bitmap.eraseColor(((ColorDrawable) view.getBackground()).getColor());
            }
            canvas.save();
            view.getLocationOnScreen(this.K);
            getLocationOnScreen(this.L);
            int[] iArr = this.K;
            int i10 = iArr[0];
            int[] iArr2 = this.L;
            canvas.translate((i10 - iArr2[0]) - this.f2330w, (iArr[1] - iArr2[1]) - this.f2331x);
            view.draw(canvas);
            canvas.restore();
            Bitmap bitmap2 = this.I;
            if (bitmap2 != null && bitmap2 != this.f2322d && !bitmap2.isRecycled()) {
                this.I.recycle();
            }
            this.I = this.f2324f.a(bitmap);
        }
        return this;
    }

    public DynamicBlurView o() {
        if (!this.J) {
            n();
        }
        invalidate();
        return this;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.I == null || this.J) {
            n();
        }
        Bitmap bitmap = this.I;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        int i10 = this.f2326i;
        canvas.scale(i10, i10);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
        if (bitmap == this.f2322d || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.H) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f2319a = motionEvent.getRawX();
                this.f2320b = motionEvent.getRawY();
                return true;
            }
            if (actionMasked == 2) {
                float rawX = motionEvent.getRawX() - this.f2319a;
                float rawY = motionEvent.getRawY() - this.f2320b;
                offsetLeftAndRight((int) rawX);
                offsetTopAndBottom((int) rawY);
                this.f2319a = motionEvent.getRawX();
                this.f2320b = motionEvent.getRawY();
                if (!this.J) {
                    n();
                }
                invalidate();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public DynamicBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2325g = 0;
        this.f2326i = 4;
        this.f2327n = 1.0f;
        this.f2328p = 2;
        this.f2329v = 1001;
        this.f2330w = 0;
        this.f2331x = 0;
        this.f2332y = 0;
        this.f2333z = new Path();
        this.H = false;
        this.J = false;
        this.K = new int[2];
        this.L = new int[2];
        a(context);
    }
}
