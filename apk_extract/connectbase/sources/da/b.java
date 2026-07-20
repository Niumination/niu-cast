package da;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3632c = "b";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3633d = 43;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3634e = 95;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3635f = 24;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ed.b f3636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m7.b f3637b;

    public interface a {
        void a(int i10, int i11, String str, String str2, boolean z10, int i12, int i13);
    }

    public static /* synthetic */ void h(a aVar, int i10, int i11, String str, String str2, boolean z10, int i12, int i13) {
        if (aVar != null) {
            aVar.a(i10, i11, str, str2, z10, i12, i13);
        }
    }

    @yb.a(level = 1)
    public int b(int i10, int i11, String str) {
        return g(fc.b.a.f5989i).f(i10, i11, str);
    }

    public List<h> c(i iVar) throws ac.a {
        return g(fc.b.a.f5987g).a(iVar);
    }

    public List<i> d(int i10, String str, int[] iArr) {
        return g(fc.b.a.f5987g).d(i10, str, iArr);
    }

    public int e(h hVar) throws ac.a {
        return g(fc.b.a.f5987g).e(hVar);
    }

    public int f(int i10, int i11, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return g(fc.b.a.F).h(i10, i11, str);
    }

    public xf.a g(String str) {
        if (fc.b.b(str)) {
            ed.b bVar = this.f3636a;
            if (bVar != null) {
                return bVar;
            }
            ed.b bVar2 = new ed.b();
            this.f3636a = bVar2;
            return bVar2;
        }
        m7.b bVar3 = this.f3637b;
        if (bVar3 != null) {
            return bVar3;
        }
        m7.b bVar4 = new m7.b();
        this.f3637b = bVar4;
        return bVar4;
    }

    public void i(int i10, int i11, String str, int i12) {
        g(fc.b.a.f5984d).c(i10, i11, str, i12);
    }

    public void j(int i10, int i11, String str, int i12) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g(fc.b.a.F).g(i10, i11, str, i12);
    }

    public void k(int[] iArr, final a aVar) {
        g(fc.b.a.f5989i).b(iArr, new m7.c.a() { // from class: da.a
            @Override // m7.c.a
            public final void a(int i10, int i11, String str, String str2, boolean z10, int i12, int i13) {
                b.h(aVar, i10, i11, str, str2, z10, i12, i13);
            }
        });
    }
}
