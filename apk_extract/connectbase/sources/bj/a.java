package bj;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class a implements aj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f909a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f910b = 1001;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f911c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f912d = 5.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f913e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f914f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f915g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f916h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public aj.c f917i = cj.a.f1455b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f918j;

    public a(Context context) {
        this.f918j = context;
    }

    @Override // aj.a
    public Bitmap a(Bitmap bitmap) {
        return h().a(bitmap);
    }

    @Override // aj.a
    public Future b(Bitmap bitmap, cj.b.a aVar) {
        return h().b(bitmap, aVar);
    }

    @Override // aj.a
    public Future c(View view, cj.b.a aVar) {
        return h().c(view, aVar);
    }

    @Override // aj.a
    public Bitmap d(View view) {
        return h().d(view);
    }

    @Override // aj.a
    public aj.a e(int i10) {
        this.f911c = i10;
        return this;
    }

    @Override // aj.a
    public aj.a f(int i10) {
        this.f910b = i10;
        return this;
    }

    @Override // aj.a
    public aj.a g(boolean z10) {
        this.f914f = z10;
        return this;
    }

    @Override // aj.a
    public b h() {
        return c.a(this.f910b, this);
    }

    @Override // aj.a
    public aj.a i(int i10) {
        this.f909a = i10;
        return this;
    }

    @Override // aj.a
    public aj.a j(int i10) {
        this.f916h = i10;
        return this;
    }

    @Override // aj.a
    public aj.a k(aj.c cVar) {
        this.f917i = cVar;
        return this;
    }

    @Override // aj.a
    public aj.a l(boolean z10) {
        this.f913e = z10;
        return this;
    }

    @Override // aj.a
    public aj.a m(Context context) {
        this.f918j = context;
        return this;
    }

    @Override // aj.a
    public aj.a n(int i10) {
        this.f915g = i10;
        return this;
    }

    @Override // aj.a
    public aj.a o(float f10) {
        this.f912d = f10;
        return this;
    }
}
