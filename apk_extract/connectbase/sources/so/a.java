package so;

import eo.e1;
import java.util.Set;
import kn.l0;
import kn.w;
import nm.n1;
import nm.p1;
import oo.k;
import os.l;
import os.m;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final k f15174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final b f15175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public final Set<e1> f15177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public final n0 f15178e;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@l k kVar, @l b bVar, boolean z10, @m Set<? extends e1> set, @m n0 n0Var) {
        l0.p(kVar, "howThisTypeIsUsed");
        l0.p(bVar, "flexibility");
        this.f15174a = kVar;
        this.f15175b = bVar;
        this.f15176c = z10;
        this.f15177d = set;
        this.f15178e = n0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a b(a aVar, k kVar, b bVar, boolean z10, Set set, n0 n0Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVar = aVar.f15174a;
        }
        if ((i10 & 2) != 0) {
            bVar = aVar.f15175b;
        }
        b bVar2 = bVar;
        if ((i10 & 4) != 0) {
            z10 = aVar.f15176c;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            set = aVar.f15177d;
        }
        Set set2 = set;
        if ((i10 & 16) != 0) {
            n0Var = aVar.f15178e;
        }
        return aVar.a(kVar, bVar2, z11, set2, n0Var);
    }

    @l
    public final a a(@l k kVar, @l b bVar, boolean z10, @m Set<? extends e1> set, @m n0 n0Var) {
        l0.p(kVar, "howThisTypeIsUsed");
        l0.p(bVar, "flexibility");
        return new a(kVar, bVar, z10, set, n0Var);
    }

    @m
    public final n0 c() {
        return this.f15178e;
    }

    @l
    public final b d() {
        return this.f15175b;
    }

    @l
    public final k e() {
        return this.f15174a;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f15174a == aVar.f15174a && this.f15175b == aVar.f15175b && this.f15176c == aVar.f15176c && l0.g(this.f15177d, aVar.f15177d) && l0.g(this.f15178e, aVar.f15178e);
    }

    @m
    public final Set<e1> f() {
        return this.f15177d;
    }

    public final boolean g() {
        return this.f15176c;
    }

    @l
    public final a h(@m n0 n0Var) {
        return b(this, null, null, false, null, n0Var, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iHashCode = (this.f15175b.hashCode() + (this.f15174a.hashCode() * 31)) * 31;
        boolean z10 = this.f15176c;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        int i10 = (iHashCode + r10) * 31;
        Set<e1> set = this.f15177d;
        int iHashCode2 = (i10 + (set == null ? 0 : set.hashCode())) * 31;
        n0 n0Var = this.f15178e;
        return iHashCode2 + (n0Var != null ? n0Var.hashCode() : 0);
    }

    @l
    public final a i(@l b bVar) {
        l0.p(bVar, "flexibility");
        return b(this, null, bVar, false, null, null, 29, null);
    }

    @l
    public final a j(@l e1 e1Var) {
        l0.p(e1Var, "typeParameter");
        Set<e1> set = this.f15177d;
        return b(this, null, null, false, set != null ? p1.E(set, e1Var) : n1.f(e1Var), null, 23, null);
    }

    @l
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.f15174a + ", flexibility=" + this.f15175b + ", isForAnnotationParameter=" + this.f15176c + ", visitedTypeParameters=" + this.f15177d + ", defaultType=" + this.f15178e + ')';
    }

    public /* synthetic */ a(k kVar, b bVar, boolean z10, Set set, n0 n0Var, int i10, w wVar) {
        this(kVar, (i10 & 2) != 0 ? b.INFLEXIBLE : bVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? null : set, (i10 & 16) != 0 ? null : n0Var);
    }
}
