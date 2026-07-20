package qo;

import gq.v;
import java.util.Iterator;
import kn.l0;
import kn.n0;
import kn.w;
import nm.h0;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements fo.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final h f14082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final uo.d f14083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final up.h<uo.a, fo.c> f14085d;

    public static final class a extends n0 implements jn.l<uo.a, fo.c> {
        public a() {
            super(1);
        }

        @Override // jn.l
        @m
        public final fo.c invoke(@os.l uo.a aVar) {
            l0.p(aVar, "annotation");
            oo.c cVar = oo.c.f12337a;
            e eVar = e.this;
            return cVar.e(aVar, eVar.f14082a, eVar.f14084c);
        }
    }

    public e(@os.l h hVar, @os.l uo.d dVar, boolean z10) {
        l0.p(hVar, "c");
        l0.p(dVar, "annotationOwner");
        this.f14082a = hVar;
        this.f14083b = dVar;
        this.f14084c = z10;
        this.f14085d = hVar.f14088a.f14055a.f(new a());
    }

    @Override // fo.g
    @m
    public fo.c d(@os.l dp.c cVar) {
        l0.p(cVar, "fqName");
        uo.a aVarD = this.f14083b.d(cVar);
        fo.c cVarInvoke = aVarD == null ? null : this.f14085d.invoke(aVarD);
        return cVarInvoke == null ? oo.c.f12337a.a(cVar, this.f14083b, this.f14082a) : cVarInvoke;
    }

    @Override // fo.g
    public boolean isEmpty() {
        return this.f14083b.getAnnotations().isEmpty() && !this.f14083b.C();
    }

    @Override // java.lang.Iterable
    @os.l
    public Iterator<fo.c> iterator() {
        return v.v0(v.o2(v.k1(h0.A1(this.f14083b.getAnnotations()), this.f14085d), oo.c.f12337a.a(ao.k.a.f619y, this.f14083b, this.f14082a))).iterator();
    }

    @Override // fo.g
    public boolean p(@os.l dp.c cVar) {
        return fo.g.b.b(this, cVar);
    }

    public /* synthetic */ e(h hVar, uo.d dVar, boolean z10, int i10, w wVar) {
        this(hVar, dVar, (i10 & 4) != 0 ? false : z10);
    }
}
