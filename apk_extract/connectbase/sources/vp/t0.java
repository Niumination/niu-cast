package vp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 {

    public static final class a extends b1 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List<a1> f17742d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends a1> list) {
            this.f17742d = list;
        }

        @Override // vp.b1
        @os.m
        public c1 k(@os.l a1 a1Var) {
            kn.l0.p(a1Var, cb.b.c.f1408o);
            if (!this.f17742d.contains(a1Var)) {
                return null;
            }
            eo.h hVarD = a1Var.d();
            if (hVarD != null) {
                return j1.t((eo.e1) hVarD);
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    public static final f0 a(List<? extends a1> list, List<? extends f0> list2, ao.h hVar) {
        f0 f0VarP = h1.g(new a(list)).p((f0) nm.h0.B2(list2), o1.OUT_VARIANCE);
        if (f0VarP == null) {
            f0VarP = hVar.y();
        }
        kn.l0.o(f0VarP, "typeParameters: List<Typ… ?: builtIns.defaultBound");
        return f0VarP;
    }

    @os.l
    public static final f0 b(@os.l eo.e1 e1Var) {
        kn.l0.p(e1Var, "<this>");
        eo.m mVarB = e1Var.b();
        kn.l0.o(mVarB, "this.containingDeclaration");
        if (mVarB instanceof eo.i) {
            List<eo.e1> parameters = ((eo.i) mVarB).i().getParameters();
            kn.l0.o(parameters, "descriptor.typeConstructor.parameters");
            List<eo.e1> list = parameters;
            ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a1 a1VarI = ((eo.e1) it.next()).i();
                kn.l0.o(a1VarI, "it.typeConstructor");
                arrayList.add(a1VarI);
            }
            List<f0> upperBounds = e1Var.getUpperBounds();
            kn.l0.o(upperBounds, "upperBounds");
            return a(arrayList, upperBounds, lp.a.g(e1Var));
        }
        if (!(mVarB instanceof eo.y)) {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
        List<eo.e1> typeParameters = ((eo.y) mVarB).getTypeParameters();
        kn.l0.o(typeParameters, "descriptor.typeParameters");
        List<eo.e1> list2 = typeParameters;
        ArrayList arrayList2 = new ArrayList(nm.z.b0(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            a1 a1VarI2 = ((eo.e1) it2.next()).i();
            kn.l0.o(a1VarI2, "it.typeConstructor");
            arrayList2.add(a1VarI2);
        }
        List<f0> upperBounds2 = e1Var.getUpperBounds();
        kn.l0.o(upperBounds2, "upperBounds");
        return a(arrayList2, upperBounds2, lp.a.g(e1Var));
    }
}
