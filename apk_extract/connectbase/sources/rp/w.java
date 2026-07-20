package rp;

import eo.e1;
import eo.h1;
import eo.w0;
import eo.y0;
import eo.z0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kn.l0;
import kn.n0;
import lm.t0;
import nm.d1;
import nm.h0;
import nm.k0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l f14773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final rp.e f14774b;

    public static final class a extends n0 implements jn.a<List<? extends fo.c>> {
        final /* synthetic */ rp.b $kind;
        final /* synthetic */ fp.q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fp.q qVar, rp.b bVar) {
            super(0);
            this.$proto = qVar;
            this.$kind = bVar;
        }

        @Override // jn.a
        @os.l
        public final List<? extends fo.c> invoke() {
            List<? extends fo.c> listV5;
            w wVar = w.this;
            z zVarC = wVar.c(wVar.f14773a.f14750c);
            if (zVarC == null) {
                listV5 = null;
            } else {
                listV5 = h0.V5(w.this.f14773a.f14748a.f14731e.f(zVarC, this.$proto, this.$kind));
            }
            return listV5 == null ? k0.INSTANCE : listV5;
        }
    }

    public static final class b extends n0 implements jn.a<List<? extends fo.c>> {
        final /* synthetic */ boolean $isDelegate;
        final /* synthetic */ yo.a.n $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z10, yo.a.n nVar) {
            super(0);
            this.$isDelegate = z10;
            this.$proto = nVar;
        }

        @Override // jn.a
        @os.l
        public final List<? extends fo.c> invoke() {
            List<? extends fo.c> listV5;
            w wVar = w.this;
            z zVarC = wVar.c(wVar.f14773a.f14750c);
            if (zVarC == null) {
                listV5 = null;
            } else {
                boolean z10 = this.$isDelegate;
                w wVar2 = w.this;
                yo.a.n nVar = this.$proto;
                listV5 = z10 ? h0.V5(wVar2.f14773a.f14748a.f14731e.h(zVarC, nVar)) : h0.V5(wVar2.f14773a.f14748a.f14731e.c(zVarC, nVar));
            }
            return listV5 == null ? k0.INSTANCE : listV5;
        }
    }

    public static final class c extends n0 implements jn.a<List<? extends fo.c>> {
        final /* synthetic */ rp.b $kind;
        final /* synthetic */ fp.q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fp.q qVar, rp.b bVar) {
            super(0);
            this.$proto = qVar;
            this.$kind = bVar;
        }

        @Override // jn.a
        @os.l
        public final List<? extends fo.c> invoke() {
            List<fo.c> listB;
            w wVar = w.this;
            z zVarC = wVar.c(wVar.f14773a.f14750c);
            if (zVarC == null) {
                listB = null;
            } else {
                listB = w.this.f14773a.f14748a.f14731e.b(zVarC, this.$proto, this.$kind);
            }
            return listB == null ? k0.INSTANCE : listB;
        }
    }

    public static final class d extends n0 implements jn.a<jp.g<?>> {
        final /* synthetic */ tp.k $property;
        final /* synthetic */ yo.a.n $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(yo.a.n nVar, tp.k kVar) {
            super(0);
            this.$proto = nVar;
            this.$property = kVar;
        }

        @Override // jn.a
        @os.m
        public final jp.g<?> invoke() {
            w wVar = w.this;
            z zVarC = wVar.c(wVar.f14773a.f14750c);
            l0.m(zVarC);
            rp.c<fo.c, jp.g<?>> cVar = w.this.f14773a.f14748a.f14731e;
            yo.a.n nVar = this.$proto;
            f0 returnType = this.$property.getReturnType();
            l0.o(returnType, "property.returnType");
            return cVar.i(zVarC, nVar, returnType);
        }
    }

    public static final class e extends n0 implements jn.a<List<? extends fo.c>> {
        final /* synthetic */ fp.q $callable;
        final /* synthetic */ z $containerOfCallable;
        final /* synthetic */ int $i;
        final /* synthetic */ rp.b $kind;
        final /* synthetic */ yo.a.u $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(z zVar, fp.q qVar, rp.b bVar, int i10, yo.a.u uVar) {
            super(0);
            this.$containerOfCallable = zVar;
            this.$callable = qVar;
            this.$kind = bVar;
            this.$i = i10;
            this.$proto = uVar;
        }

        @Override // jn.a
        @os.l
        public final List<? extends fo.c> invoke() {
            return h0.V5(w.this.f14773a.f14748a.f14731e.d(this.$containerOfCallable, this.$callable, this.$kind, this.$i, this.$proto));
        }
    }

    public w(@os.l l lVar) {
        l0.p(lVar, "c");
        this.f14773a = lVar;
        j jVar = lVar.f14748a;
        this.f14774b = new rp.e(jVar.f14728b, jVar.f14738l);
    }

    public final z c(eo.m mVar) {
        if (mVar instanceof eo.k0) {
            dp.c cVarE = ((eo.k0) mVar).e();
            l lVar = this.f14773a;
            return new z.b(cVarE, lVar.f14749b, lVar.f14751d, lVar.f14754g);
        }
        if (mVar instanceof tp.e) {
            return ((tp.e) mVar).Q;
        }
        return null;
    }

    public final fo.g d(fp.q qVar, int i10, rp.b bVar) {
        if (ap.b.f641c.d(i10).booleanValue()) {
            return new tp.o(this.f14773a.f14748a.f14727a, new a(qVar, bVar));
        }
        fo.g.f6167h.getClass();
        return fo.g.a.f6169b;
    }

    public final w0 e() {
        eo.m mVar = this.f14773a.f14750c;
        eo.e eVar = mVar instanceof eo.e ? (eo.e) mVar : null;
        if (eVar == null) {
            return null;
        }
        return eVar.D0();
    }

    public final fo.g f(yo.a.n nVar, boolean z10) {
        if (ap.b.f641c.d(nVar.getFlags()).booleanValue()) {
            return new tp.o(this.f14773a.f14748a.f14727a, new b(z10, nVar));
        }
        fo.g.f6167h.getClass();
        return fo.g.a.f6169b;
    }

    public final fo.g g(fp.q qVar, rp.b bVar) {
        return new tp.b(this.f14773a.f14748a.f14727a, new c(qVar, bVar));
    }

    public final void h(tp.l lVar, w0 w0Var, w0 w0Var2, List<? extends e1> list, List<? extends h1> list2, f0 f0Var, eo.e0 e0Var, eo.u uVar, Map<? extends eo.a.InterfaceC0106a<?>, ?> map) {
        lVar.i1(w0Var, w0Var2, list, list2, f0Var, e0Var, uVar, map);
    }

    @os.l
    public final eo.d i(@os.l yo.a.d dVar, boolean z10) {
        l0.p(dVar, "proto");
        eo.e eVar = (eo.e) this.f14773a.f14750c;
        int flags = dVar.getFlags();
        rp.b bVar = rp.b.FUNCTION;
        fo.g gVarD = d(dVar, flags, bVar);
        eo.b.a aVar = eo.b.a.DECLARATION;
        l lVar = this.f14773a;
        tp.d dVar2 = new tp.d(eVar, null, gVarD, z10, aVar, dVar, lVar.f14749b, lVar.f14751d, lVar.f14752e, lVar.f14754g, null, 1024, null);
        w wVar = l.b(this.f14773a, dVar2, k0.INSTANCE, null, null, null, null, 60, null).f14756i;
        List<yo.a.u> valueParameterList = dVar.getValueParameterList();
        l0.o(valueParameterList, "proto.valueParameterList");
        dVar2.j1(wVar.n(valueParameterList, dVar, bVar), b0.a(a0.f14685a, ap.b.f642d.d(dVar.getFlags())));
        dVar2.a1(eVar.q());
        dVar2.N = !ap.b.f652n.d(dVar.getFlags()).booleanValue();
        return dVar2;
    }

    @os.l
    public final y0 j(@os.l yo.a.i iVar) {
        fo.g gVarG;
        ap.h hVar;
        tp.l lVar;
        w0 w0VarF;
        l0.p(iVar, "proto");
        int flags = iVar.hasFlags() ? iVar.getFlags() : k(iVar.getOldFlags());
        rp.b bVar = rp.b.FUNCTION;
        fo.g gVarD = d(iVar, flags, bVar);
        if (ap.f.d(iVar)) {
            gVarG = g(iVar, bVar);
        } else {
            fo.g.f6167h.getClass();
            gVarG = fo.g.a.f6169b;
        }
        fo.g gVar = gVarG;
        if (l0.g(lp.a.i(this.f14773a.f14750c).c(x.b(this.f14773a.f14749b, iVar.getName())), c0.f14698a)) {
            ap.h.f672b.getClass();
            hVar = ap.h.f673c;
        } else {
            hVar = this.f14773a.f14752e;
        }
        ap.h hVar2 = hVar;
        l lVar2 = this.f14773a;
        eo.m mVar = lVar2.f14750c;
        dp.f fVarB = x.b(lVar2.f14749b, iVar.getName());
        a0 a0Var = a0.f14685a;
        eo.b.a aVarB = b0.b(a0Var, ap.b.f653o.d(flags));
        l lVar3 = this.f14773a;
        tp.l lVar4 = new tp.l(mVar, null, gVarD, fVarB, aVarB, iVar, lVar3.f14749b, lVar3.f14751d, hVar2, lVar3.f14754g, null, 1024, null);
        l lVar5 = this.f14773a;
        List<yo.a.s> typeParameterList = iVar.getTypeParameterList();
        l0.o(typeParameterList, "proto.typeParameterList");
        l lVarB = l.b(lVar5, lVar4, typeParameterList, null, null, null, null, 60, null);
        yo.a.q qVarH = ap.f.h(iVar, this.f14773a.f14751d);
        if (qVarH == null) {
            w0VarF = null;
            lVar = lVar4;
        } else {
            lVar = lVar4;
            w0VarF = hp.c.f(lVar, lVarB.f14755h.p(qVarH), gVar);
        }
        w0 w0VarE = e();
        List<e1> listJ = lVarB.f14755h.j();
        w wVar = lVarB.f14756i;
        List<yo.a.u> valueParameterList = iVar.getValueParameterList();
        l0.o(valueParameterList, "proto.valueParameterList");
        lVar.i1(w0VarF, w0VarE, listJ, wVar.n(valueParameterList, iVar, bVar), lVarB.f14755h.p(ap.f.j(iVar, this.f14773a.f14751d)), a0Var.b(ap.b.f643e.d(flags)), b0.a(a0Var, ap.b.f642d.d(flags)), d1.z());
        lVar.f7405w = v.a(ap.b.f654p, flags, "IS_OPERATOR.get(flags)");
        lVar.f7406x = v.a(ap.b.f655q, flags, "IS_INFIX.get(flags)");
        lVar.f7407y = v.a(ap.b.f658t, flags, "IS_EXTERNAL_FUNCTION.get(flags)");
        lVar.f7408z = v.a(ap.b.f656r, flags, "IS_INLINE.get(flags)");
        lVar.H = v.a(ap.b.f657s, flags, "IS_TAILREC.get(flags)");
        lVar.M = v.a(ap.b.f659u, flags, "IS_SUSPEND.get(flags)");
        lVar.I = v.a(ap.b.f660v, flags, "IS_EXPECT_FUNCTION.get(flags)");
        lVar.N = !ap.b.f661w.d(flags).booleanValue();
        l lVar6 = this.f14773a;
        t0<eo.a.InterfaceC0106a<?>, Object> t0VarA = lVar6.f14748a.f14739m.a(iVar, lVar, lVar6.f14751d, lVarB.f14755h);
        if (t0VarA != null) {
            lVar.O0(t0VarA.getFirst(), t0VarA.getSecond());
        }
        return lVar;
    }

    public final int k(int i10) {
        return (i10 & 63) + ((i10 >> 8) << 6);
    }

    @os.l
    public final eo.t0 l(@os.l yo.a.n nVar) {
        yo.a.n nVar2;
        fo.g gVarG;
        tp.k kVar;
        w0 w0VarF;
        ap.b.d<yo.a.x> dVar;
        a0 a0Var;
        tp.k kVar2;
        ho.d0 d0Var;
        tp.k kVar3;
        yo.a.n nVar3;
        boolean z10;
        ho.e0 e0VarC;
        ho.d0 d0VarB;
        l0.p(nVar, "proto");
        int flags = nVar.hasFlags() ? nVar.getFlags() : k(nVar.getOldFlags());
        eo.m mVar = this.f14773a.f14750c;
        fo.g gVarD = d(nVar, flags, rp.b.PROPERTY);
        a0 a0Var2 = a0.f14685a;
        ap.b.d<yo.a.k> dVar2 = ap.b.f643e;
        eo.e0 e0VarB = a0Var2.b(dVar2.d(flags));
        ap.b.d<yo.a.x> dVar3 = ap.b.f642d;
        eo.u uVarA = b0.a(a0Var2, dVar3.d(flags));
        boolean zA = v.a(ap.b.f662x, flags, "IS_VAR.get(flags)");
        dp.f fVarB = x.b(this.f14773a.f14749b, nVar.getName());
        eo.b.a aVarB = b0.b(a0Var2, ap.b.f653o.d(flags));
        boolean zA2 = v.a(ap.b.B, flags, "IS_LATEINIT.get(flags)");
        boolean zA3 = v.a(ap.b.A, flags, "IS_CONST.get(flags)");
        boolean zA4 = v.a(ap.b.D, flags, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean zA5 = v.a(ap.b.E, flags, "IS_DELEGATED.get(flags)");
        boolean zA6 = v.a(ap.b.F, flags, "IS_EXPECT_PROPERTY.get(flags)");
        l lVar = this.f14773a;
        tp.k kVar4 = new tp.k(mVar, null, gVarD, e0VarB, uVarA, zA, fVarB, aVarB, zA2, zA3, zA4, zA5, zA6, nVar, lVar.f14749b, lVar.f14751d, lVar.f14752e, lVar.f14754g);
        l lVar2 = this.f14773a;
        List<yo.a.s> typeParameterList = nVar.getTypeParameterList();
        l0.o(typeParameterList, "proto.typeParameterList");
        l lVarB = l.b(lVar2, kVar4, typeParameterList, null, null, null, null, 60, null);
        boolean zA7 = v.a(ap.b.f663y, flags, "HAS_GETTER.get(flags)");
        if (zA7 && ap.f.e(nVar)) {
            nVar2 = nVar;
            gVarG = g(nVar2, rp.b.PROPERTY_GETTER);
        } else {
            nVar2 = nVar;
            fo.g.f6167h.getClass();
            gVarG = fo.g.a.f6169b;
        }
        f0 f0VarP = lVarB.f14755h.p(ap.f.k(nVar2, this.f14773a.f14751d));
        List<e1> listJ = lVarB.f14755h.j();
        w0 w0VarE = e();
        yo.a.q qVarI = ap.f.i(nVar2, this.f14773a.f14751d);
        if (qVarI == null) {
            kVar = kVar4;
            w0VarF = null;
        } else {
            kVar = kVar4;
            w0VarF = hp.c.f(kVar, lVarB.f14755h.p(qVarI), gVarG);
        }
        kVar.V0(f0VarP, listJ, w0VarE, w0VarF);
        ap.b.d<yo.a.k> dVar4 = dVar2;
        int iB = ap.b.b(v.a(ap.b.f641c, flags, "HAS_ANNOTATIONS.get(flags)"), dVar3.d(flags), dVar4.d(flags), false, false, false);
        if (zA7) {
            int getterFlags = nVar.hasGetterFlags() ? nVar.getGetterFlags() : iB;
            boolean zA8 = v.a(ap.b.J, getterFlags, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean zA9 = v.a(ap.b.K, getterFlags, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean zA10 = v.a(ap.b.L, getterFlags, "IS_INLINE_ACCESSOR.get(getterFlags)");
            fo.g gVarD2 = d(nVar2, getterFlags, rp.b.PROPERTY_GETTER);
            if (zA8) {
                a0Var = a0Var2;
                dVar = dVar3;
                kVar2 = kVar;
                d0VarB = new ho.d0(kVar, gVarD2, a0Var2.b(dVar4.d(getterFlags)), b0.a(a0Var2, dVar3.d(getterFlags)), !zA8, zA9, zA10, kVar.getKind(), null, z0.f4654a);
            } else {
                dVar = dVar3;
                a0Var = a0Var2;
                kVar2 = kVar;
                d0VarB = hp.c.b(kVar2, gVarD2);
                l0.o(d0VarB, "{\n                Descri…nnotations)\n            }");
            }
            d0VarB.K0(kVar2.getReturnType());
            d0Var = d0VarB;
        } else {
            dVar4 = dVar4;
            dVar = dVar3;
            lVarB = lVarB;
            a0Var = a0Var2;
            kVar2 = kVar;
            d0Var = null;
        }
        if (v.a(ap.b.f664z, flags, "HAS_SETTER.get(flags)")) {
            if (nVar.hasSetterFlags()) {
                iB = nVar.getSetterFlags();
            }
            int i10 = iB;
            boolean zA11 = v.a(ap.b.J, i10, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean zA12 = v.a(ap.b.K, i10, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean zA13 = v.a(ap.b.L, i10, "IS_INLINE_ACCESSOR.get(setterFlags)");
            rp.b bVar = rp.b.PROPERTY_SETTER;
            fo.g gVarD3 = d(nVar2, i10, bVar);
            if (zA11) {
                a0 a0Var3 = a0Var;
                ho.e0 e0Var = new ho.e0(kVar2, gVarD3, a0Var3.b(dVar4.d(i10)), b0.a(a0Var3, dVar.d(i10)), !zA11, zA12, zA13, kVar2.getKind(), null, z0.f4654a);
                kVar3 = kVar2;
                z10 = true;
                nVar3 = nVar2;
                e0Var.L0((h1) h0.h5(l.b(lVarB, e0Var, k0.INSTANCE, null, null, null, null, 60, null).f14756i.n(nm.x.k(nVar.getSetterValueParameter()), nVar3, bVar)));
                e0VarC = e0Var;
            } else {
                kVar3 = kVar2;
                nVar3 = nVar2;
                z10 = true;
                fo.g.f6167h.getClass();
                e0VarC = hp.c.c(kVar3, gVarD3, fo.g.a.f6169b);
                l0.o(e0VarC, "{\n                Descri…          )\n            }");
            }
        } else {
            kVar3 = kVar2;
            nVar3 = nVar2;
            z10 = true;
            e0VarC = null;
        }
        if (v.a(ap.b.C, flags, "HAS_CONSTANT.get(flags)")) {
            kVar3.F0(this.f14773a.f14748a.f14727a.g(new d(nVar3, kVar3)));
        }
        kVar3.P0(d0Var, e0VarC, new ho.o(f(nVar3, false), kVar3), new ho.o(f(nVar3, z10), kVar3));
        return kVar3;
    }

    @os.l
    public final eo.d1 m(@os.l yo.a.r rVar) {
        l0.p(rVar, "proto");
        fo.g.a aVar = fo.g.f6167h;
        List<yo.a.b> annotationList = rVar.getAnnotationList();
        l0.o(annotationList, "proto.annotationList");
        List<yo.a.b> list = annotationList;
        ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
        for (yo.a.b bVar : list) {
            rp.e eVar = this.f14774b;
            l0.o(bVar, "it");
            arrayList.add(eVar.a(bVar, this.f14773a.f14749b));
        }
        fo.g gVarA = aVar.a(arrayList);
        eo.u uVarA = b0.a(a0.f14685a, ap.b.f642d.d(rVar.getFlags()));
        l lVar = this.f14773a;
        up.n nVar = lVar.f14748a.f14727a;
        eo.m mVar = lVar.f14750c;
        dp.f fVarB = x.b(lVar.f14749b, rVar.getName());
        l lVar2 = this.f14773a;
        tp.m mVar2 = new tp.m(nVar, mVar, gVarA, fVarB, uVarA, rVar, lVar2.f14749b, lVar2.f14751d, lVar2.f14752e, lVar2.f14754g);
        l lVar3 = this.f14773a;
        List<yo.a.s> typeParameterList = rVar.getTypeParameterList();
        l0.o(typeParameterList, "proto.typeParameterList");
        l lVarB = l.b(lVar3, mVar2, typeParameterList, null, null, null, null, 60, null);
        mVar2.K0(lVarB.f14755h.j(), lVarB.f14755h.l(ap.f.o(rVar, this.f14773a.f14751d), false), lVarB.f14755h.l(ap.f.b(rVar, this.f14773a.f14751d), false));
        return mVar2;
    }

    public final List<h1> n(List<yo.a.u> list, fp.q qVar, rp.b bVar) {
        fo.g oVar;
        eo.a aVar = (eo.a) this.f14773a.f14750c;
        eo.m mVarB = aVar.b();
        l0.o(mVarB, "callableDescriptor.containingDeclaration");
        z zVarC = c(mVarB);
        List<yo.a.u> list2 = list;
        ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
        int i10 = 0;
        for (Object obj : list2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            yo.a.u uVar = (yo.a.u) obj;
            int flags = uVar.hasFlags() ? uVar.getFlags() : 0;
            if (zVarC == null || !v.a(ap.b.f641c, flags, "HAS_ANNOTATIONS.get(flags)")) {
                fo.g.f6167h.getClass();
                oVar = fo.g.a.f6169b;
            } else {
                oVar = new tp.o(this.f14773a.f14748a.f14727a, new e(zVarC, qVar, bVar, i10, uVar));
            }
            dp.f fVarB = x.b(this.f14773a.f14749b, uVar.getName());
            l lVar = this.f14773a;
            f0 f0VarP = lVar.f14755h.p(ap.f.n(uVar, lVar.f14751d));
            boolean zA = v.a(ap.b.G, flags, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean zA2 = v.a(ap.b.H, flags, "IS_CROSSINLINE.get(flags)");
            boolean zA3 = v.a(ap.b.I, flags, "IS_NOINLINE.get(flags)");
            yo.a.q qVarQ = ap.f.q(uVar, this.f14773a.f14751d);
            f0 f0VarP2 = qVarQ == null ? null : this.f14773a.f14755h.p(qVarQ);
            z0 z0Var = z0.f4654a;
            l0.o(z0Var, "NO_SOURCE");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ho.l0(aVar, null, i10, oVar, fVarB, f0VarP, zA, zA2, zA3, f0VarP2, z0Var));
            arrayList = arrayList2;
            i10 = i11;
        }
        return h0.V5(arrayList);
    }
}
