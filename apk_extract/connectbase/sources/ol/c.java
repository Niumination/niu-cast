package ol;

import ik.y0;
import java.lang.reflect.Type;
import kn.l0;
import kn.w;
import os.l;
import os.m;
import un.s;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final un.d<?> f12302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final Type f12303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public final s f12304c;

    public c(@l un.d<?> dVar, @l Type type, @m s sVar) {
        l0.p(dVar, y0.a.f8215h);
        l0.p(type, "reifiedType");
        this.f12302a = dVar;
        this.f12303b = type;
        this.f12304c = sVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c g(c cVar, un.d dVar, Type type, s sVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = cVar.f12302a;
        }
        if ((i10 & 2) != 0) {
            type = cVar.f12303b;
        }
        if ((i10 & 4) != 0) {
            sVar = cVar.f12304c;
        }
        return cVar.f(dVar, type, sVar);
    }

    @Override // ol.b
    @m
    public s a() {
        return this.f12304c;
    }

    @Override // ol.b
    @l
    public Type b() {
        return this.f12303b;
    }

    @l
    public final un.d<?> c() {
        return this.f12302a;
    }

    @l
    public final Type d() {
        return this.f12303b;
    }

    @m
    public final s e() {
        return this.f12304c;
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return l0.g(this.f12302a, cVar.f12302a) && l0.g(this.f12303b, cVar.f12303b) && l0.g(this.f12304c, cVar.f12304c);
    }

    @l
    public final c f(@l un.d<?> dVar, @l Type type, @m s sVar) {
        l0.p(dVar, y0.a.f8215h);
        l0.p(type, "reifiedType");
        return new c(dVar, type, sVar);
    }

    @Override // ol.b
    @l
    public un.d<?> getType() {
        return this.f12302a;
    }

    public int hashCode() {
        int iHashCode = (this.f12303b.hashCode() + (this.f12302a.hashCode() * 31)) * 31;
        s sVar = this.f12304c;
        return iHashCode + (sVar == null ? 0 : sVar.hashCode());
    }

    @l
    public String toString() {
        return "TypeInfoImpl(type=" + this.f12302a + ", reifiedType=" + this.f12303b + ", kotlinType=" + this.f12304c + ')';
    }

    public /* synthetic */ c(un.d dVar, Type type, s sVar, int i10, w wVar) {
        this(dVar, type, (i10 & 4) != 0 ? null : sVar);
    }
}
