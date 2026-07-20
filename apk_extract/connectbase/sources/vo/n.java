package vo;

import eo.e1;
import ik.y0;
import kn.l0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final f0 f17650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final no.q f17651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final e1 f17652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17653d;

    public n(@os.l f0 f0Var, @os.m no.q qVar, @os.m e1 e1Var, boolean z10) {
        l0.p(f0Var, y0.a.f8215h);
        this.f17650a = f0Var;
        this.f17651b = qVar;
        this.f17652c = e1Var;
        this.f17653d = z10;
    }

    @os.l
    public final f0 a() {
        return this.f17650a;
    }

    @os.m
    public final no.q b() {
        return this.f17651b;
    }

    @os.m
    public final e1 c() {
        return this.f17652c;
    }

    public final boolean d() {
        return this.f17653d;
    }

    @os.l
    public final f0 e() {
        return this.f17650a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return l0.g(this.f17650a, nVar.f17650a) && l0.g(this.f17651b, nVar.f17651b) && l0.g(this.f17652c, nVar.f17652c) && this.f17653d == nVar.f17653d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int iHashCode = this.f17650a.hashCode() * 31;
        no.q qVar = this.f17651b;
        int iHashCode2 = (iHashCode + (qVar == null ? 0 : qVar.hashCode())) * 31;
        e1 e1Var = this.f17652c;
        int iHashCode3 = (iHashCode2 + (e1Var != null ? e1Var.hashCode() : 0)) * 31;
        boolean z10 = this.f17653d;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        return iHashCode3 + r10;
    }

    @os.l
    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.f17650a + ", defaultQualifiers=" + this.f17651b + ", typeParameterForArgument=" + this.f17652c + ", isFromStarProjection=" + this.f17653d + ')';
    }
}
