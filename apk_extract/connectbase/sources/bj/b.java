package bj;

import android.graphics.Bitmap;
import android.view.View;
import cj.f;
import cj.g;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements aj.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public aj.c f927i;

    public b(a aVar) {
        this.f920b = aVar.f909a;
        this.f921c = aVar.f910b;
        this.f919a = aVar.f911c;
        this.f922d = aVar.f912d;
        this.f923e = aVar.f913e;
        this.f924f = aVar.f914f;
        this.f925g = aVar.f915g;
        this.f926h = aVar.f916h;
        this.f927i = aVar.f917i;
    }

    @Override // aj.b
    public Bitmap a(Bitmap bitmap) {
        return e(bitmap, true);
    }

    @Override // aj.b
    public Future b(Bitmap bitmap, cj.b.a aVar) {
        return f.a().b(new cj.c((aj.b) this, bitmap, aVar, this.f927i));
    }

    @Override // aj.b
    public Future c(View view, cj.b.a aVar) {
        return f.a().b(new g((aj.b) this, view, aVar, this.f927i));
    }

    @Override // aj.b
    public Bitmap d(View view) {
        dj.c.b(view, "You must input a view !");
        Bitmap bitmapF = f(dj.a.b(view, q(), r(), n()), true);
        return this.f924f ? dj.a.a(bitmapF, 1.0f / n()) : bitmapF;
    }

    public final Bitmap e(Bitmap bitmap, boolean z10) {
        dj.c.b(bitmap, "bitmap == null");
        dj.c.a(!bitmap.isRecycled(), "You must input an unrecycled bitmap !");
        if (this.f919a <= 0) {
            this.f919a = 1;
        }
        if (this.f922d < 1.0f) {
            this.f922d = 1.0f;
        }
        if (this.f923e) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        Bitmap bitmapF = f(dj.a.a(dj.a.c(bitmap, q(), r()), n()), z10);
        return this.f924f ? dj.a.a(bitmapF, 1.0f / n()) : bitmapF;
    }

    public abstract Bitmap f(Bitmap bitmap, boolean z10);

    public boolean g() {
        return this.f923e;
    }

    public void h() {
    }

    public int i() {
        return this.f920b;
    }

    public void j(int i10) {
        this.f920b = i10;
    }

    public boolean k() {
        return this.f924f;
    }

    public int l() {
        return this.f919a;
    }

    public void m(int i10) {
        this.f919a = i10;
    }

    public float n() {
        return this.f922d;
    }

    public void o(float f10) {
        this.f922d = f10;
    }

    public int p() {
        return this.f921c;
    }

    public int q() {
        return this.f925g;
    }

    public int r() {
        return this.f926h;
    }
}
