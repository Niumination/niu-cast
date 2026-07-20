package qo;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import lm.h0;
import no.e0;
import no.q;
import no.w;
import os.m;
import uo.z;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: qo.a$a, reason: collision with other inner class name */
    public static final class C0343a extends n0 implements jn.a<w> {
        final /* synthetic */ eo.g $containingDeclaration;
        final /* synthetic */ h $this_childForClassOrPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0343a(h hVar, eo.g gVar) {
            super(0);
            this.$this_childForClassOrPackage = hVar;
            this.$containingDeclaration = gVar;
        }

        @Override // jn.a
        @m
        public final w invoke() {
            return a.g(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
        }
    }

    public static final class b extends n0 implements jn.a<w> {
        final /* synthetic */ fo.g $additionalAnnotations;
        final /* synthetic */ h $this_copyWithNewDefaultTypeQualifiers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, fo.g gVar) {
            super(0);
            this.$this_copyWithNewDefaultTypeQualifiers = hVar;
            this.$additionalAnnotations = gVar;
        }

        @Override // jn.a
        @m
        public final w invoke() {
            return a.g(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
        }
    }

    public static final h a(h hVar, eo.m mVar, z zVar, int i10, d0<w> d0Var) {
        return new h(hVar.f14088a, zVar == null ? hVar.f14089b : new i(hVar, mVar, zVar, i10), d0Var);
    }

    @os.l
    public static final h b(@os.l h hVar, @os.l l lVar) {
        l0.p(hVar, "<this>");
        l0.p(lVar, "typeParameterResolver");
        return new h(hVar.f14088a, lVar, hVar.f14090c);
    }

    @os.l
    public static final h c(@os.l h hVar, @os.l eo.g gVar, @m z zVar, int i10) {
        l0.p(hVar, "<this>");
        l0.p(gVar, "containingDeclaration");
        return a(hVar, gVar, zVar, i10, f0.c(h0.NONE, new C0343a(hVar, gVar)));
    }

    public static /* synthetic */ h d(h hVar, eo.g gVar, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            zVar = null;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return c(hVar, gVar, zVar, i10);
    }

    @os.l
    public static final h e(@os.l h hVar, @os.l eo.m mVar, @os.l z zVar, int i10) {
        l0.p(hVar, "<this>");
        l0.p(mVar, "containingDeclaration");
        l0.p(zVar, "typeParameterOwner");
        return a(hVar, mVar, zVar, i10, hVar.f14090c);
    }

    public static /* synthetic */ h f(h hVar, eo.m mVar, z zVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return e(hVar, mVar, zVar, i10);
    }

    @m
    public static final w g(@os.l h hVar, @os.l fo.g gVar) {
        l0.p(hVar, "<this>");
        l0.p(gVar, "additionalAnnotations");
        if (hVar.f14088a.f14076v.f11789c) {
            return hVar.b();
        }
        ArrayList<q> arrayList = new ArrayList();
        Iterator<fo.c> it = gVar.iterator();
        while (it.hasNext()) {
            q qVarI = i(hVar, it.next());
            if (qVarI != null) {
                arrayList.add(qVarI);
            }
        }
        if (arrayList.isEmpty()) {
            return hVar.b();
        }
        w wVarB = hVar.b();
        EnumMap enumMap = wVarB == null ? new EnumMap(no.a.class) : new EnumMap((EnumMap) wVarB.f11790a);
        boolean z10 = false;
        for (q qVar : arrayList) {
            Iterator<no.a> it2 = qVar.f11769b.iterator();
            while (it2.hasNext()) {
                enumMap.put(it2.next(), qVar);
                z10 = true;
            }
        }
        return !z10 ? hVar.b() : new w(enumMap);
    }

    @os.l
    public static final h h(@os.l h hVar, @os.l fo.g gVar) {
        l0.p(hVar, "<this>");
        l0.p(gVar, "additionalAnnotations");
        return gVar.isEmpty() ? hVar : new h(hVar.f14088a, hVar.f14089b, f0.c(h0.NONE, new b(hVar, gVar)));
    }

    public static final q i(h hVar, fo.c cVar) {
        no.c cVar2 = hVar.f14088a.f14071q;
        q qVarL = cVar2.l(cVar);
        if (qVarL != null) {
            return qVarL;
        }
        no.c.a aVarN = cVar2.n(cVar);
        if (aVarN == null) {
            return null;
        }
        fo.c cVar3 = aVarN.f11729a;
        List<no.a> listB = aVarN.b();
        e0 e0VarK = cVar2.k(cVar);
        if (e0VarK == null) {
            e0VarK = cVar2.j(cVar3);
        }
        if (e0VarK.isIgnore()) {
            return null;
        }
        vo.h hVarH = hVar.f14088a.f14072r.h(cVar3, hVar.f14088a.f14074t.c(), false);
        if (hVarH == null) {
            return null;
        }
        return new q(vo.h.b(hVarH, null, e0VarK.isWarning(), 1, null), listB, false, 4, null);
    }

    @os.l
    public static final h j(@os.l h hVar, @os.l c cVar) {
        l0.p(hVar, "<this>");
        l0.p(cVar, "components");
        return new h(cVar, hVar.f14089b, hVar.f14090c);
    }
}
