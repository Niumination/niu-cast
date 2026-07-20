package rb;

import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14410c = p.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14411d = 4194304;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14412e = 2097152;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14413f = 16777216;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.l f14414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.k f14415b;

    public void a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        e(fc.b.a.E).c(view);
    }

    public boolean b(View view, boolean z10, float f10) {
        if (view != null) {
            return e(fc.b.a.f6001u).e(view, z10, f10);
        }
        throw new IllegalArgumentException("view cannot be null");
    }

    public boolean c(View view, boolean z10, float f10, int i10) {
        if (view != null) {
            return e(fc.b.a.f6004x).b(view, z10, f10, i10);
        }
        throw new IllegalArgumentException("view cannot be null");
    }

    public boolean d(View view, boolean z10) {
        if (view != null) {
            return e(fc.b.a.A).d(view, z10);
        }
        throw new IllegalArgumentException("view cannot be null");
    }

    public lh.k e(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14410c, "TranThubView");
            re.l lVar = this.f14414a;
            if (lVar != null) {
                return lVar;
            }
            re.l lVar2 = new re.l();
            this.f14414a = lVar2;
            return lVar2;
        }
        dc.e.f(f14410c, "TranAospView");
        b9.k kVar = this.f14415b;
        if (kVar != null) {
            return kVar;
        }
        b9.k kVar2 = new b9.k();
        this.f14415b = kVar2;
        return kVar2;
    }

    public l f(View view) {
        if (view != null) {
            return e(fc.b.a.E).j(view);
        }
        throw new IllegalArgumentException("view cannot be null");
    }

    public boolean g(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        if (this.f14415b == null) {
            this.f14415b = new b9.k();
        }
        return this.f14415b.h(view);
    }

    public boolean h(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        if (this.f14415b == null) {
            this.f14415b = new b9.k();
        }
        return this.f14415b.g(view);
    }

    public void i(View view, Bitmap bitmap) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        e(fc.b.a.E).l(view, bitmap);
    }

    public boolean j(View view, Consumer<View> consumer) {
        if (view != null) {
            return e(fc.b.a.G).f(view, consumer);
        }
        throw new IllegalArgumentException("view cannot be null");
    }

    public boolean k(View view, boolean z10) {
        if (view != null) {
            return e(fc.b.a.E).i(view, z10);
        }
        throw new IllegalArgumentException("view cannot be null");
    }

    public void l(Window window, int i10) {
        e(fc.b.a.f5989i).a(window, i10);
    }

    public void m(View view, l lVar) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        e(fc.b.a.E).k(view, lVar);
    }
}
