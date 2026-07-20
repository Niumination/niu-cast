package v0;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import t0.j;
import t0.k;
import t0.l;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<u0.b> f16440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0.g f16441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f16443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f16444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f16445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f16446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<u0.g> f16447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f16448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f16449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f16450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f16451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f16452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f16453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f16454o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f16455p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final j f16456q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public final k f16457r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final t0.b f16458s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<a1.a<Float>> f16459t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f16460u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f16461v;

    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public d(List<u0.b> list, n0.g gVar, String str, long j10, a aVar, long j11, @Nullable String str2, List<u0.g> list2, l lVar, int i10, int i11, int i12, float f10, float f11, int i13, int i14, @Nullable j jVar, @Nullable k kVar, List<a1.a<Float>> list3, b bVar, @Nullable t0.b bVar2, boolean z10) {
        this.f16440a = list;
        this.f16441b = gVar;
        this.f16442c = str;
        this.f16443d = j10;
        this.f16444e = aVar;
        this.f16445f = j11;
        this.f16446g = str2;
        this.f16447h = list2;
        this.f16448i = lVar;
        this.f16449j = i10;
        this.f16450k = i11;
        this.f16451l = i12;
        this.f16452m = f10;
        this.f16453n = f11;
        this.f16454o = i13;
        this.f16455p = i14;
        this.f16456q = jVar;
        this.f16457r = kVar;
        this.f16459t = list3;
        this.f16460u = bVar;
        this.f16458s = bVar2;
        this.f16461v = z10;
    }

    public n0.g a() {
        return this.f16441b;
    }

    public long b() {
        return this.f16443d;
    }

    public List<a1.a<Float>> c() {
        return this.f16459t;
    }

    public a d() {
        return this.f16444e;
    }

    public List<u0.g> e() {
        return this.f16447h;
    }

    public b f() {
        return this.f16460u;
    }

    public String g() {
        return this.f16442c;
    }

    public long h() {
        return this.f16445f;
    }

    public int i() {
        return this.f16455p;
    }

    public int j() {
        return this.f16454o;
    }

    @Nullable
    public String k() {
        return this.f16446g;
    }

    public List<u0.b> l() {
        return this.f16440a;
    }

    public int m() {
        return this.f16451l;
    }

    public int n() {
        return this.f16450k;
    }

    public int o() {
        return this.f16449j;
    }

    public float p() {
        return this.f16453n / this.f16441b.e();
    }

    @Nullable
    public j q() {
        return this.f16456q;
    }

    @Nullable
    public k r() {
        return this.f16457r;
    }

    @Nullable
    public t0.b s() {
        return this.f16458s;
    }

    public float t() {
        return this.f16452m;
    }

    public String toString() {
        return w("");
    }

    public l u() {
        return this.f16448i;
    }

    public boolean v() {
        return this.f16461v;
    }

    public String w(String str) {
        StringBuilder sbA = k.a.a(str);
        sbA.append(g());
        sbA.append("\n");
        d dVarV = this.f16441b.v(h());
        if (dVarV != null) {
            sbA.append("\t\tParents: ");
            sbA.append(dVarV.g());
            d dVarV2 = this.f16441b.v(dVarV.h());
            while (dVarV2 != null) {
                sbA.append("->");
                sbA.append(dVarV2.g());
                dVarV2 = this.f16441b.v(dVarV2.h());
            }
            sbA.append(str);
            sbA.append("\n");
        }
        if (!e().isEmpty()) {
            sbA.append(str);
            sbA.append("\tMasks: ");
            sbA.append(e().size());
            sbA.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sbA.append(str);
            sbA.append("\tBackground: ");
            sbA.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.f16440a.isEmpty()) {
            sbA.append(str);
            sbA.append("\tShapes:\n");
            for (u0.b bVar : this.f16440a) {
                sbA.append(str);
                sbA.append("\t\t");
                sbA.append(bVar);
                sbA.append("\n");
            }
        }
        return sbA.toString();
    }
}
