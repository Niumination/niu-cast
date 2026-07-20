package dp;

import el.b0;
import jq.e0;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final C0088a f3798e = new C0088a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    @l
    public static final f f3799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    @l
    public static final c f3800g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final c f3801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public final c f3802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final f f3803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public final c f3804d;

    /* JADX INFO: renamed from: dp.a$a, reason: collision with other inner class name */
    public static final class C0088a {
        public C0088a() {
        }

        public C0088a(w wVar) {
        }
    }

    static {
        f fVar = h.f3835l;
        f3799f = fVar;
        c cVarK = c.k(fVar);
        l0.o(cVarK, "topLevel(LOCAL_NAME)");
        f3800g = cVarK;
    }

    public a(@l c cVar, @m c cVar2, @l f fVar, @m c cVar3) {
        l0.p(cVar, "packageName");
        l0.p(fVar, "callableName");
        this.f3801a = cVar;
        this.f3802b = cVar2;
        this.f3803c = fVar;
        this.f3804d = cVar3;
    }

    @l
    public final f a() {
        return this.f3803c;
    }

    @m
    public final c b() {
        return this.f3802b;
    }

    @l
    public final c c() {
        return this.f3801a;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return l0.g(this.f3801a, aVar.f3801a) && l0.g(this.f3802b, aVar.f3802b) && l0.g(this.f3803c, aVar.f3803c) && l0.g(this.f3804d, aVar.f3804d);
    }

    public int hashCode() {
        int iHashCode = this.f3801a.hashCode() * 31;
        c cVar = this.f3802b;
        int iHashCode2 = (this.f3803c.hashCode() + ((iHashCode + (cVar == null ? 0 : cVar.hashCode())) * 31)) * 31;
        c cVar2 = this.f3804d;
        return iHashCode2 + (cVar2 != null ? cVar2.hashCode() : 0);
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String strB = this.f3801a.b();
        l0.o(strB, "packageName.asString()");
        sb2.append(e0.h2(strB, n1.e.f11183c, b0.f4502a, false, 4, null));
        sb2.append("/");
        c cVar = this.f3802b;
        if (cVar != null) {
            sb2.append(cVar);
            sb2.append(".");
        }
        sb2.append(this.f3803c);
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public /* synthetic */ a(c cVar, c cVar2, f fVar, c cVar3, int i10, w wVar) {
        this(cVar, cVar2, fVar, (i10 & 8) != 0 ? null : cVar3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@l c cVar, @l f fVar) {
        this(cVar, null, fVar, null, 8, null);
        l0.p(cVar, "packageName");
        l0.p(fVar, "callableName");
    }
}
