package lj;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10070i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10071j = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f10074c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10077f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10079h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10078g = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10072a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10075d = hj.h.f7214g[0].equalsIgnoreCase(hj.h.o());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<i> f10073b = new ArrayList(2);

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public g(Context context) {
        this.f10074c = context;
        if (this.f10075d) {
            this.f10076e = ui.a.d(this.f10074c, 9);
            this.f10077f = ui.a.d(this.f10074c, 7);
            this.f10079h = ui.a.d(this.f10074c, 20);
        }
    }

    public void a(i iVar) {
        this.f10073b.add(iVar);
        b();
    }

    public final void b() {
        List<i> list = this.f10073b;
        if (list != null) {
            if (list.size() == 1) {
                r(this.f10073b.get(0).m() == 1);
            }
        }
    }

    public int c() {
        List<i> list = this.f10073b;
        if (list == null || list.size() <= 0) {
            return -1;
        }
        return this.f10073b.get(0).f();
    }

    public Context d() {
        return this.f10074c;
    }

    public float e(int i10) {
        float fO = 0.0f;
        if (i10 < 0 || i10 > this.f10073b.size() - 1) {
            return 0.0f;
        }
        for (int size = this.f10073b.size() - 1; size >= i10; size--) {
            fO += this.f10073b.get(size).o();
        }
        return fO + this.f10076e;
    }

    public int f() {
        return this.f10079h;
    }

    public float g() {
        if (this.f10073b.size() <= 0) {
            return 0.0f;
        }
        return ((this.f10076e + this.f10077f) * 2.0f) / k();
    }

    public int h() {
        return this.f10077f;
    }

    public List<i> i() {
        return this.f10073b;
    }

    public int j() {
        return this.f10076e;
    }

    public int k() {
        int i10 = 0;
        if (this.f10075d && o()) {
            int iO = 0;
            while (i10 < this.f10073b.size()) {
                iO += this.f10073b.get(i10).o();
                i10++;
            }
            return iO > 0 ? iO + (this.f10076e * 2) : iO;
        }
        int iO2 = 0;
        while (i10 < this.f10073b.size()) {
            iO2 += this.f10073b.get(i10).o();
            i10++;
        }
        return iO2;
    }

    public int l() {
        return this.f10072a;
    }

    public boolean m() {
        return !this.f10073b.isEmpty();
    }

    public boolean n() {
        return this.f10075d;
    }

    public boolean o() {
        return this.f10078g;
    }

    public void p(i iVar) {
        this.f10073b.remove(iVar);
    }

    public void q(Context context) {
        this.f10074c = context;
    }

    public void r(boolean z10) {
        this.f10078g = z10;
    }

    public void s(int i10) {
        this.f10072a = i10;
    }
}
