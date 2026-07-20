package n1;

import c1.c0;
import c1.h0;
import c1.m0;
import c1.y;
import f1.i3;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@t1.j
@a
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c1.e f11193e = c1.e.d(".。．｡");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m0 f11194f = m0.h(e.f11183c);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y f11195g = y.o(e.f11183c);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f11196h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11197i = -2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f11198j = 127;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f11199k = 253;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f11200l = 63;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c1.e f11201m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c1.e f11202n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c1.e f11203o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c1.e f11204p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3<String> f11206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    public int f11207c = -2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.b
    public int f11208d = -2;

    static {
        c1.e eVarD = c1.e.d("-_");
        f11201m = eVarD;
        c1.e.k kVar = new c1.e.k('0', '9');
        f11202n = kVar;
        c1.e.z zVar = new c1.e.z(new c1.e.k(y5.a.H, 'z'), new c1.e.k(y5.a.G, y5.a.O));
        f11203o = zVar;
        f11204p = kVar.I(zVar).I(eVarD);
    }

    public f(String name) {
        String strG = c1.c.g(f11193e.N(name, e.f11183c));
        strG = strG.endsWith(".") ? c0.b.a(strG, 1, 0) : strG;
        h0.u(strG.length() <= 253, "Domain name too long: '%s':", strG);
        this.f11205a = strG;
        i3<String> i3VarCopyOf = i3.copyOf(f11194f.n(strG));
        this.f11206b = i3VarCopyOf;
        h0.u(i3VarCopyOf.size() <= 127, "Domain has too many parts: '%s'", strG);
        h0.u(y(i3VarCopyOf), "Not a valid domain name: '%s'", strG);
    }

    @t1.a
    public static f d(String domain) {
        domain.getClass();
        return new f(domain);
    }

    public static boolean n(String name) {
        try {
            d(name);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean o(c0<e2.b> desiredType, c0<e2.b> actualType) {
        return desiredType.isPresent() ? desiredType.equals(actualType) : actualType.isPresent();
    }

    public static boolean x(String part, boolean isFinalPart) {
        if (part.length() >= 1 && part.length() <= 63) {
            if (!f11204p.C(c1.e.C0050e.f1151c.P(part))) {
                return false;
            }
            c1.e eVar = f11201m;
            if (!eVar.B(part.charAt(0)) && !eVar.B(part.charAt(part.length() - 1))) {
                return (isFinalPart && f11202n.B(part.charAt(0))) ? false : true;
            }
        }
        return false;
    }

    public static boolean y(List<String> parts) {
        int size = parts.size() - 1;
        if (!x(parts.get(size), true)) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!x(parts.get(i10), false)) {
                return false;
            }
        }
        return true;
    }

    public final f a(int levels) {
        y yVar = f11195g;
        i3<String> i3Var = this.f11206b;
        return d(yVar.k(i3Var.subList(levels, i3Var.size())));
    }

    public f b(String leftParts) {
        StringBuilder sb2 = new StringBuilder();
        leftParts.getClass();
        sb2.append(leftParts);
        sb2.append(".");
        sb2.append(this.f11205a);
        return d(sb2.toString());
    }

    public final int c(c0<e2.b> desiredType) {
        int size = this.f11206b.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strK = f11195g.k(this.f11206b.subList(i10, size));
            if (i10 > 0 && o(desiredType, c0.fromNullable(e2.a.f4040b.get(strK)))) {
                return i10 - 1;
            }
            if (o(desiredType, c0.fromNullable(e2.a.f4039a.get(strK)))) {
                return i10;
            }
            if (e2.a.f4041c.containsKey(strK)) {
                return i10 + 1;
            }
        }
        return -1;
    }

    public boolean e() {
        return this.f11206b.size() > 1;
    }

    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof f) {
            return this.f11205a.equals(((f) object).f11205a);
        }
        return false;
    }

    public boolean f() {
        return s() != -1;
    }

    public boolean g() {
        return u() != -1;
    }

    public boolean h() {
        return s() == 0;
    }

    public int hashCode() {
        return this.f11205a.hashCode();
    }

    public boolean i() {
        return u() == 0;
    }

    public boolean j() {
        return u() == 1;
    }

    public boolean k() {
        return s() == 1;
    }

    public boolean l() {
        return s() > 0;
    }

    public boolean m() {
        return u() > 0;
    }

    public f p() {
        h0.x0(e(), "Domain '%s' has no parent", this.f11205a);
        return a(1);
    }

    public i3<String> q() {
        return this.f11206b;
    }

    @gm.a
    public f r() {
        if (f()) {
            return a(s());
        }
        return null;
    }

    public final int s() {
        int i10 = this.f11207c;
        if (i10 != -2) {
            return i10;
        }
        int iC = c(c0.absent());
        this.f11207c = iC;
        return iC;
    }

    @gm.a
    public f t() {
        if (g()) {
            return a(u());
        }
        return null;
    }

    public String toString() {
        return this.f11205a;
    }

    public final int u() {
        int i10 = this.f11208d;
        if (i10 != -2) {
            return i10;
        }
        int iC = c(c0.of(e2.b.REGISTRY));
        this.f11208d = iC;
        return iC;
    }

    public f v() {
        if (j()) {
            return this;
        }
        h0.x0(m(), "Not under a registry suffix: %s", this.f11205a);
        return a(u() - 1);
    }

    public f w() {
        if (k()) {
            return this;
        }
        h0.x0(l(), "Not under a public suffix: %s", this.f11205a);
        return a(s() - 1);
    }
}
