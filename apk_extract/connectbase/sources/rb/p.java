package rb;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14419c = "p";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.n f14420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.m f14421b;

    public Drawable a(View view, int i10) {
        if (view != null) {
            return c(fc.b.a.f5989i).c(view, i10);
        }
        throw new IllegalArgumentException("param view cannot be null");
    }

    public Drawable b(View view, int i10, int i11, float f10) {
        if (view != null) {
            return c(fc.b.a.f5985e).b(view, i10, i11, f10);
        }
        throw new IllegalArgumentException("View cannot be null");
    }

    public lh.m c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14419c, "TranThubViewRootImpl");
            re.n nVar = this.f14420a;
            if (nVar != null) {
                return nVar;
            }
            re.n nVar2 = new re.n();
            this.f14420a = nVar2;
            return nVar2;
        }
        dc.e.f(f14419c, "TranAospViewRootImpl");
        b9.m mVar = this.f14421b;
        if (mVar != null) {
            return mVar;
        }
        b9.m mVar2 = new b9.m();
        this.f14421b = mVar2;
        return mVar2;
    }

    public void d(View view) {
        if (view == null) {
            throw new IllegalArgumentException("view cannot be null");
        }
        c(fc.b.a.f5987g).a(view);
    }
}
