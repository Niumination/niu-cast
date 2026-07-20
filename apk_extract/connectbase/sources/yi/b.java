package yi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f20832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f20833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f20834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Canvas f20835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public bj.b f20836e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f20844m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BitmapDrawable f20847p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Context f20848q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20837f = 13;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20838g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f20839h = 1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20840i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20841j = 1001;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20842k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20843l = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int[] f20845n = new int[2];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int[] f20846o = new int[2];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20849r = Color.parseColor("#F7F7F7");

    public b(Context context) {
        this.f20848q = context;
        a(context);
    }

    public final void a(Context context) {
        this.f20836e = a.a(context).f(this.f20841j).h();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:33:0x0099 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x009a A[RETURN] */
    public final boolean b() {
        boolean z10;
        View view = this.f20833b;
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        bj.b bVar = this.f20836e;
        if (bVar != null) {
            bVar.j(this.f20840i);
            this.f20836e.m(this.f20837f);
            this.f20836e.o(this.f20839h);
        }
        int iCeil = (int) Math.ceil(width / this.f20838g);
        int iCeil2 = (int) Math.ceil(height / this.f20838g);
        if (iCeil < 1 || iCeil2 < 1) {
            return false;
        }
        Bitmap bitmap = this.f20834c;
        if (bitmap != null) {
            if (iCeil == bitmap.getWidth() && iCeil2 == this.f20834c.getHeight()) {
                z10 = false;
            } else {
                if (!this.f20834c.isRecycled()) {
                    this.f20834c.recycle();
                    this.f20834c = null;
                }
                this.f20834c = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
            }
            if (this.f20834c == null) {
                return false;
            }
            if (z10) {
                Canvas canvas = new Canvas(this.f20834c);
                this.f20835d = canvas;
                int i10 = this.f20838g;
                canvas.scale(1.0f / i10, 1.0f / i10);
            }
            if (this.f20835d == null) {
                return false;
            }
            return true;
        }
        this.f20834c = Bitmap.createBitmap(iCeil, iCeil2, Bitmap.Config.ARGB_8888);
        z10 = true;
        if (this.f20834c == null) {
            return false;
        }
        if (z10) {
            Canvas canvas2 = new Canvas(this.f20834c);
            this.f20835d = canvas2;
            int i11 = this.f20838g;
            canvas2.scale(1.0f / i11, 1.0f / i11);
        }
        if (this.f20835d == null) {
            return false;
        }
        return true;
    }

    public b c() {
        Bitmap bitmap = this.f20834c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f20834c.recycle();
        }
        Bitmap bitmap2 = this.f20844m;
        if (bitmap2 != null && bitmap2 != this.f20834c && !bitmap2.isRecycled()) {
            this.f20844m.recycle();
        }
        this.f20832a = null;
        return this;
    }

    public b d(int i10) {
        this.f20840i = i10;
        return this;
    }

    public b e(bj.b bVar) {
        if (bVar != null) {
            this.f20836e = bVar;
        }
        return this;
    }

    public b f(int i10) {
        if (i10 >= 0) {
            this.f20837f = i10;
        }
        return this;
    }

    public b g(View view) {
        this.f20833b = view;
        return this;
    }

    public b h(View view) {
        this.f20832a = view;
        return this;
    }

    public b i(int i10) {
        if (i10 >= 1) {
            this.f20838g = i10;
        }
        return this;
    }

    public b j(int i10) {
        this.f20849r = i10;
        return this;
    }

    public b k(int i10) {
        this.f20842k = i10;
        return this;
    }

    public b l(int i10) {
        this.f20843l = i10;
        return this;
    }

    public final Bitmap m() {
        boolean zB = b();
        View view = this.f20832a;
        View view2 = this.f20833b;
        Bitmap bitmap = this.f20834c;
        Canvas canvas = this.f20835d;
        if (!zB || view == null || view2 == null || bitmap == null || canvas == null) {
            return null;
        }
        if (view.getBackground() == null || !(view.getBackground() instanceof ColorDrawable)) {
            bitmap.eraseColor(this.f20849r);
        } else {
            bitmap.eraseColor(((ColorDrawable) view.getBackground()).getColor());
        }
        canvas.save();
        view.getLocationOnScreen(this.f20845n);
        view2.getLocationOnScreen(this.f20846o);
        int[] iArr = this.f20845n;
        int i10 = iArr[0];
        int[] iArr2 = this.f20846o;
        canvas.translate((i10 - iArr2[0]) - this.f20842k, (iArr[1] - iArr2[1]) - this.f20843l);
        view.draw(canvas);
        canvas.restore();
        Bitmap bitmap2 = this.f20844m;
        if (bitmap2 != null && bitmap2 != this.f20834c && !bitmap2.isRecycled()) {
            this.f20844m.recycle();
        }
        Bitmap bitmapA = this.f20836e.a(bitmap);
        this.f20844m = bitmapA;
        return bitmapA;
    }

    public b n() {
        Bitmap bitmapM = m();
        View view = this.f20833b;
        if (bitmapM != null && this.f20848q != null && view != null) {
            BitmapDrawable bitmapDrawable = this.f20847p;
            if (bitmapDrawable == null) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.f20848q.getResources(), bitmapM);
                this.f20847p = bitmapDrawable2;
                view.setBackground(bitmapDrawable2);
            } else if (bitmapM != bitmapDrawable.getBitmap()) {
                this.f20847p.setBitmap(bitmapM);
            }
        }
        return this;
    }
}
