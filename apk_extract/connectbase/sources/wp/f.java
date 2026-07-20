package wp;

import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kn.g0;
import kn.l0;
import kn.l1;
import lm.i0;
import nm.k0;
import vp.a1;
import vp.c1;
import vp.e0;
import vp.f0;
import vp.j1;
import vp.n0;
import vp.n1;
import vp.o1;
import vp.z;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends vp.i {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f19852a = new a();
    }

    public /* synthetic */ class b extends g0 implements jn.l<yp.i, n1> {
        public b(Object obj) {
            super(1, obj);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "prepareType";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(f.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
        }

        @Override // jn.l
        @os.l
        public final n1 invoke(@os.l yp.i iVar) {
            l0.p(iVar, "p0");
            return ((f) this.receiver).a(iVar);
        }
    }

    @Override // vp.i
    @os.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n1 a(@os.l yp.i iVar) {
        n1 n1VarD;
        l0.p(iVar, y0.a.f8215h);
        if (!(iVar instanceof f0)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        n1 n1VarJ0 = ((f0) iVar).J0();
        if (n1VarJ0 instanceof n0) {
            n1VarD = c((n0) n1VarJ0);
        } else {
            if (!(n1VarJ0 instanceof z)) {
                throw new i0();
            }
            z zVar = (z) n1VarJ0;
            n0 n0VarC = c(zVar.f17773b);
            n0 n0VarC2 = c(zVar.f17774c);
            n1VarD = (n0VarC == zVar.f17773b && n0VarC2 == zVar.f17774c) ? n1VarJ0 : vp.g0.d(n0VarC, n0VarC2);
        }
        return vp.l1.c(n1VarD, n1VarJ0, new b(this));
    }

    public final n0 c(n0 n0Var) {
        a1 a1VarG0 = n0Var.G0();
        e0 e0VarL = null;
        if (a1VarG0 instanceof ip.c) {
            ip.c cVar = (ip.c) a1VarG0;
            c1 c1Var = cVar.f8349a;
            if (c1Var.c() != o1.IN_VARIANCE) {
                c1Var = null;
            }
            n1 n1VarJ0 = c1Var != null ? c1Var.getType().J0() : null;
            if (cVar.f8350b == null) {
                c1 c1Var2 = cVar.f8349a;
                Collection<f0> collectionA = cVar.a();
                ArrayList arrayList = new ArrayList(nm.z.b0(collectionA, 10));
                Iterator<T> it = collectionA.iterator();
                while (it.hasNext()) {
                    arrayList.add(((f0) it.next()).J0());
                }
                cVar.f8350b = new j(c1Var2, arrayList, null, 4, null);
            }
            yp.b bVar = yp.b.FOR_SUBTYPING;
            j jVar = cVar.f8350b;
            l0.m(jVar);
            return new i(bVar, jVar, n1VarJ0, n0Var.getAnnotations(), n0Var.H0(), false, 32, null);
        }
        boolean z10 = false;
        if (a1VarG0 instanceof jp.p) {
            ArrayList<f0> arrayList2 = ((jp.p) a1VarG0).f8790c;
            ArrayList arrayList3 = new ArrayList(nm.z.b0(arrayList2, 10));
            Iterator<T> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                f0 f0VarQ = j1.q((f0) it2.next(), n0Var.H0());
                l0.o(f0VarQ, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList3.add(f0VarQ);
            }
            return vp.g0.l(n0Var.getAnnotations(), new e0(arrayList3), k0.INSTANCE, false, n0Var.o());
        }
        if (!(a1VarG0 instanceof e0) || !n0Var.H0()) {
            return n0Var;
        }
        e0 e0Var = (e0) a1VarG0;
        LinkedHashSet<f0> linkedHashSet = e0Var.f17675b;
        ArrayList arrayList4 = new ArrayList(nm.z.b0(linkedHashSet, 10));
        Iterator<T> it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            arrayList4.add(zp.a.q((f0) it3.next()));
            z10 = true;
        }
        if (z10) {
            f0 f0Var = e0Var.f17674a;
            e0VarL = new e0(arrayList4).l(f0Var != null ? zp.a.q(f0Var) : null);
        }
        if (e0VarL != null) {
            e0Var = e0VarL;
        }
        return e0Var.g();
    }
}
