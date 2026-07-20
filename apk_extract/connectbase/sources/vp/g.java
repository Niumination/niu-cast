package vp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g f17688a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    public static boolean f17689b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17691b;

        static {
            int[] iArr = new int[yp.w.values().length];
            iArr[yp.w.INV.ordinal()] = 1;
            iArr[yp.w.OUT.ordinal()] = 2;
            iArr[yp.w.IN.ordinal()] = 3;
            f17690a = iArr;
            int[] iArr2 = new int[z0.a.values().length];
            iArr2[z0.a.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[z0.a.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[z0.a.SKIP_LOWER.ordinal()] = 3;
            f17691b = iArr2;
        }
    }

    public static final boolean b(yp.r rVar, yp.k kVar) {
        yp.o oVarB = rVar.b(kVar);
        if (oVarB instanceof yp.h) {
            Collection<yp.i> collectionR = rVar.r(oVarB);
            if (!(collectionR instanceof Collection) || !collectionR.isEmpty()) {
                Iterator<T> it = collectionR.iterator();
                while (it.hasNext()) {
                    yp.k kVarD = rVar.d((yp.i) it.next());
                    if (kVarD != null && rVar.X(kVarD)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean c(yp.r rVar, z0 z0Var, yp.k kVar, yp.k kVar2, boolean z10) {
        Collection<yp.i> collectionS = rVar.S(kVar);
        if ((collectionS instanceof Collection) && collectionS.isEmpty()) {
            return false;
        }
        for (yp.i iVar : collectionS) {
            if (kn.l0.g(rVar.s0(iVar), rVar.b(kVar2)) || (z10 && q(f17688a, z0Var, kVar2, iVar, false, 8, null))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean q(g gVar, z0 z0Var, yp.i iVar, yp.i iVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return gVar.p(z0Var, iVar, iVar2, z10);
    }

    public final Boolean a(z0 z0Var, yp.k kVar, yp.k kVar2) {
        yp.r rVar = z0Var.f17778d;
        if (!rVar.X(kVar) && !rVar.X(kVar2)) {
            return null;
        }
        if (rVar.X(kVar) && rVar.X(kVar2)) {
            return Boolean.TRUE;
        }
        if (rVar.X(kVar)) {
            if (c(rVar, z0Var, kVar, kVar2, false)) {
                return Boolean.TRUE;
            }
        } else if (rVar.X(kVar2) && (b(rVar, kVar) || c(rVar, z0Var, kVar2, kVar, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0123  */
    /* JADX WARN: Code duplicated, block: B:82:0x012d  */
    public final Boolean d(z0 z0Var, yp.k kVar, yp.k kVar2) {
        yp.p pVarK;
        yp.r rVar = z0Var.f17778d;
        boolean z10 = false;
        if (rVar.J(kVar) || rVar.J(kVar2)) {
            if (z0Var.f17775a) {
                return Boolean.TRUE;
            }
            return (!rVar.Y(kVar) || rVar.Y(kVar2)) ? Boolean.valueOf(e.f17673a.b(rVar, rVar.c(kVar, false), rVar.c(kVar2, false))) : Boolean.FALSE;
        }
        if (rVar.M(kVar) && rVar.M(kVar2)) {
            return Boolean.valueOf(f17688a.n(rVar, kVar, kVar2) || z0Var.f17776b);
        }
        if (rVar.s(kVar) || rVar.s(kVar2)) {
            return Boolean.valueOf(z0Var.f17776b);
        }
        yp.e eVarQ0 = rVar.q0(kVar2);
        yp.d dVarF = rVar.f(eVarQ0 == null ? kVar2 : rVar.N(eVarQ0));
        yp.i iVarC = dVarF == null ? null : rVar.C(dVarF);
        if (dVarF != null && iVarC != null) {
            if (rVar.Y(kVar2)) {
                iVarC = rVar.x0(iVarC, true);
            } else if (rVar.f0(kVar2)) {
                iVarC = rVar.y0(iVarC);
            }
            yp.i iVar = iVarC;
            int i10 = a.f17691b[z0Var.g(kVar, dVarF).ordinal()];
            if (i10 == 1) {
                return Boolean.valueOf(q(f17688a, z0Var, kVar, iVar, false, 8, null));
            }
            if (i10 == 2 && q(f17688a, z0Var, kVar, iVar, false, 8, null)) {
                return Boolean.TRUE;
            }
        }
        yp.o oVarB = rVar.b(kVar2);
        if (rVar.W(oVarB)) {
            rVar.Y(kVar2);
            Collection<yp.i> collectionR = rVar.r(oVarB);
            if ((collectionR instanceof Collection) && collectionR.isEmpty()) {
                z10 = true;
            } else {
                Iterator<T> it = collectionR.iterator();
                while (it.hasNext()) {
                    if (!q(f17688a, z0Var, kVar, (yp.i) it.next(), false, 8, null)) {
                    }
                }
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
        yp.o oVarB2 = rVar.b(kVar);
        if (kVar instanceof yp.d) {
            pVarK = f17688a.k(z0Var.f17778d, kVar2, kVar);
            if (pVarK != null && rVar.c0(pVarK, rVar.b(kVar2))) {
                return Boolean.TRUE;
            }
        } else if (rVar.W(oVarB2)) {
            Collection<yp.i> collectionR2 = rVar.r(oVarB2);
            if ((collectionR2 instanceof Collection) && collectionR2.isEmpty()) {
                pVarK = f17688a.k(z0Var.f17778d, kVar2, kVar);
                if (pVarK != null) {
                    return Boolean.TRUE;
                }
            } else {
                Iterator<T> it2 = collectionR2.iterator();
                while (it2.hasNext()) {
                    if (!(((yp.i) it2.next()) instanceof yp.d)) {
                    }
                }
                pVarK = f17688a.k(z0Var.f17778d, kVar2, kVar);
                if (pVarK != null) {
                    return Boolean.TRUE;
                }
            }
        }
        return null;
    }

    public final List<yp.k> e(z0 z0Var, yp.k kVar, yp.o oVar) {
        z0.b bVarY;
        yp.r rVar = z0Var.f17778d;
        List<yp.k> listT = rVar.T(kVar, oVar);
        if (listT == null) {
            if (!rVar.v0(oVar) && rVar.h(kVar)) {
                return nm.k0.INSTANCE;
            }
            if (rVar.m(oVar)) {
                if (!rVar.V(rVar.b(kVar), oVar)) {
                    return nm.k0.INSTANCE;
                }
                yp.k kVarL0 = rVar.l0(kVar, yp.b.FOR_SUBTYPING);
                if (kVarL0 != null) {
                    kVar = kVarL0;
                }
                return nm.x.k(kVar);
            }
            listT = new eq.e<>();
            z0Var.k();
            ArrayDeque<yp.k> arrayDeque = z0Var.f17783i;
            kn.l0.m(arrayDeque);
            Set<yp.k> set = z0Var.f17784j;
            kn.l0.m(set);
            arrayDeque.push(kVar);
            while (!arrayDeque.isEmpty()) {
                if (set.size() > 1000) {
                    StringBuilder sbA = c.a("Too many supertypes for type: ", kVar, ". Supertypes = ");
                    sbA.append(nm.h0.m3(set, null, null, null, 0, null, null, 63, null));
                    throw new IllegalStateException(sbA.toString().toString());
                }
                yp.k kVarPop = arrayDeque.pop();
                kn.l0.o(kVarPop, "current");
                if (set.add(kVarPop)) {
                    yp.k kVarL1 = rVar.l0(kVarPop, yp.b.FOR_SUBTYPING);
                    if (kVarL1 == null) {
                        kVarL1 = kVarPop;
                    }
                    if (rVar.V(rVar.b(kVarL1), oVar)) {
                        listT.add(kVarL1);
                        bVarY = z0.b.c.f17787a;
                    } else {
                        bVarY = rVar.j(kVarL1) == 0 ? z0.b.C0464b.f17786a : z0Var.f17778d.y(kVarL1);
                    }
                    if (kn.l0.g(bVarY, z0.b.c.f17787a)) {
                        bVarY = null;
                    }
                    if (bVarY != null) {
                        yp.r rVar2 = z0Var.f17778d;
                        Iterator<yp.i> it = rVar2.r(rVar2.b(kVarPop)).iterator();
                        while (it.hasNext()) {
                            arrayDeque.add(bVarY.a(z0Var, it.next()));
                        }
                    }
                }
            }
            z0Var.e();
        }
        return listT;
    }

    public final List<yp.k> f(z0 z0Var, yp.k kVar, yp.o oVar) {
        return t(z0Var, e(z0Var, kVar, oVar));
    }

    public final boolean g(z0 z0Var, yp.i iVar, yp.i iVar2, boolean z10) {
        yp.r rVar = z0Var.f17778d;
        yp.i iVarO = z0Var.o(z0Var.p(iVar));
        yp.i iVarO2 = z0Var.o(z0Var.p(iVar2));
        g gVar = f17688a;
        Boolean boolD = gVar.d(z0Var, rVar.u0(iVarO), rVar.G(iVarO2));
        if (boolD == null) {
            Boolean boolC = z0Var.c(iVarO, iVarO2, z10);
            return boolC == null ? gVar.r(z0Var, rVar.u0(iVarO), rVar.G(iVarO2)) : boolC.booleanValue();
        }
        boolean zBooleanValue = boolD.booleanValue();
        z0Var.c(iVarO, iVarO2, z10);
        return zBooleanValue;
    }

    @os.m
    public final yp.w h(@os.l yp.w wVar, @os.l yp.w wVar2) {
        kn.l0.p(wVar, "declared");
        kn.l0.p(wVar2, "useSite");
        yp.w wVar3 = yp.w.INV;
        if (wVar == wVar3) {
            return wVar2;
        }
        if (wVar2 == wVar3 || wVar == wVar2) {
            return wVar;
        }
        return null;
    }

    public final boolean i(@os.l z0 z0Var, @os.l yp.i iVar, @os.l yp.i iVar2) {
        kn.l0.p(z0Var, "state");
        kn.l0.p(iVar, "a");
        kn.l0.p(iVar2, "b");
        yp.r rVar = z0Var.f17778d;
        if (iVar == iVar2) {
            return true;
        }
        g gVar = f17688a;
        if (gVar.m(rVar, iVar) && gVar.m(rVar, iVar2)) {
            yp.i iVarO = z0Var.o(z0Var.p(iVar));
            yp.i iVarO2 = z0Var.o(z0Var.p(iVar2));
            yp.k kVarU0 = rVar.u0(iVarO);
            if (!rVar.V(rVar.s0(iVarO), rVar.s0(iVarO2))) {
                return false;
            }
            if (rVar.j(kVarU0) == 0) {
                return rVar.Q(iVarO) || rVar.Q(iVarO2) || rVar.Y(kVarU0) == rVar.Y(rVar.u0(iVarO2));
            }
        }
        return q(gVar, z0Var, iVar, iVar2, false, 8, null) && q(gVar, z0Var, iVar2, iVar, false, 8, null);
    }

    @os.l
    public final List<yp.k> j(@os.l z0 z0Var, @os.l yp.k kVar, @os.l yp.o oVar) {
        z0.b bVar;
        kn.l0.p(z0Var, "state");
        kn.l0.p(kVar, "subType");
        kn.l0.p(oVar, "superConstructor");
        yp.r rVar = z0Var.f17778d;
        if (rVar.h(kVar)) {
            return f17688a.f(z0Var, kVar, oVar);
        }
        if (!rVar.v0(oVar) && !rVar.B(oVar)) {
            return f17688a.e(z0Var, kVar, oVar);
        }
        eq.e<yp.k> eVar = new eq.e();
        z0Var.k();
        ArrayDeque<yp.k> arrayDeque = z0Var.f17783i;
        kn.l0.m(arrayDeque);
        Set<yp.k> set = z0Var.f17784j;
        kn.l0.m(set);
        arrayDeque.push(kVar);
        while (!arrayDeque.isEmpty()) {
            if (set.size() > 1000) {
                StringBuilder sbA = c.a("Too many supertypes for type: ", kVar, ". Supertypes = ");
                sbA.append(nm.h0.m3(set, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sbA.toString().toString());
            }
            yp.k kVarPop = arrayDeque.pop();
            kn.l0.o(kVarPop, "current");
            if (set.add(kVarPop)) {
                if (rVar.h(kVarPop)) {
                    eVar.add(kVarPop);
                    bVar = z0.b.c.f17787a;
                } else {
                    bVar = z0.b.C0464b.f17786a;
                }
                if (kn.l0.g(bVar, z0.b.c.f17787a)) {
                    bVar = null;
                }
                if (bVar != null) {
                    yp.r rVar2 = z0Var.f17778d;
                    Iterator<yp.i> it = rVar2.r(rVar2.b(kVarPop)).iterator();
                    while (it.hasNext()) {
                        arrayDeque.add(bVar.a(z0Var, it.next()));
                    }
                }
            }
        }
        z0Var.e();
        ArrayList arrayList = new ArrayList();
        for (yp.k kVar2 : eVar) {
            g gVar = f17688a;
            kn.l0.o(kVar2, "it");
            nm.d0.r0(arrayList, gVar.f(z0Var, kVar2, oVar));
        }
        return arrayList;
    }

    public final yp.p k(yp.r rVar, yp.i iVar, yp.i iVar2) {
        int iJ = rVar.j(iVar);
        int i10 = 0;
        while (true) {
            if (i10 >= iJ) {
                return null;
            }
            int i11 = i10 + 1;
            yp.n nVarO = rVar.O(iVar, i10);
            yp.n nVar = rVar.w0(nVarO) ? null : nVarO;
            if (nVar != null) {
                yp.i iVarO = rVar.o(nVar);
                boolean z10 = rVar.w(rVar.u0(iVarO)) && rVar.w(rVar.u0(iVar2));
                if (kn.l0.g(iVarO, iVar2) || (z10 && kn.l0.g(rVar.s0(iVarO), rVar.s0(iVar2)))) {
                    return rVar.h0(rVar.s0(iVar), i10);
                }
                yp.p pVarK = k(rVar, iVarO, iVar2);
                if (pVarK != null) {
                    return pVarK;
                }
            }
            i10 = i11;
        }
    }

    public final boolean l(z0 z0Var, yp.k kVar) {
        yp.r rVar = z0Var.f17778d;
        yp.o oVarB = rVar.b(kVar);
        if (rVar.v0(oVarB)) {
            return rVar.k0(oVarB);
        }
        if (rVar.k0(rVar.b(kVar))) {
            return true;
        }
        z0Var.k();
        ArrayDeque<yp.k> arrayDeque = z0Var.f17783i;
        kn.l0.m(arrayDeque);
        Set<yp.k> set = z0Var.f17784j;
        kn.l0.m(set);
        arrayDeque.push(kVar);
        while (!arrayDeque.isEmpty()) {
            if (set.size() > 1000) {
                StringBuilder sbA = c.a("Too many supertypes for type: ", kVar, ". Supertypes = ");
                sbA.append(nm.h0.m3(set, null, null, null, 0, null, null, 63, null));
                throw new IllegalStateException(sbA.toString().toString());
            }
            yp.k kVarPop = arrayDeque.pop();
            kn.l0.o(kVarPop, "current");
            if (set.add(kVarPop)) {
                z0.b bVar = rVar.h(kVarPop) ? z0.b.c.f17787a : z0.b.C0464b.f17786a;
                if (kn.l0.g(bVar, z0.b.c.f17787a)) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    yp.r rVar2 = z0Var.f17778d;
                    Iterator<yp.i> it = rVar2.r(rVar2.b(kVarPop)).iterator();
                    while (it.hasNext()) {
                        yp.k kVarA = bVar.a(z0Var, it.next());
                        if (rVar.k0(rVar.b(kVarA))) {
                            z0Var.e();
                            return true;
                        }
                        arrayDeque.add(kVarA);
                    }
                }
            }
        }
        z0Var.e();
        return false;
    }

    public final boolean m(yp.r rVar, yp.i iVar) {
        return rVar.D(rVar.s0(iVar)) && !rVar.U(iVar) && !rVar.f0(iVar) && kn.l0.g(rVar.b(rVar.u0(iVar)), rVar.b(rVar.G(iVar)));
    }

    public final boolean n(yp.r rVar, yp.k kVar, yp.k kVar2) {
        yp.e eVarQ0 = rVar.q0(kVar);
        yp.k kVarN = eVarQ0 == null ? kVar : rVar.N(eVarQ0);
        yp.e eVarQ1 = rVar.q0(kVar2);
        if (rVar.b(kVarN) != rVar.b(eVarQ1 == null ? kVar2 : rVar.N(eVarQ1))) {
            return false;
        }
        if (rVar.f0(kVar) || !rVar.f0(kVar2)) {
            return !rVar.Y(kVar) || rVar.Y(kVar2);
        }
        return false;
    }

    public final boolean o(@os.l z0 z0Var, @os.l yp.m mVar, @os.l yp.k kVar) {
        boolean zI;
        kn.l0.p(z0Var, "<this>");
        kn.l0.p(mVar, "capturedSubArguments");
        kn.l0.p(kVar, "superType");
        yp.r rVar = z0Var.f17778d;
        yp.o oVarB = rVar.b(kVar);
        int iQ = rVar.q(mVar);
        int iD0 = rVar.d0(oVarB);
        if (iQ != iD0 || iQ != rVar.j(kVar)) {
            return false;
        }
        int i10 = 0;
        while (i10 < iD0) {
            int i11 = i10 + 1;
            yp.n nVarO = rVar.O(kVar, i10);
            if (!rVar.w0(nVarO)) {
                yp.i iVarO = rVar.o(nVarO);
                yp.n nVarX = rVar.x(mVar, i10);
                rVar.p0(nVarX);
                yp.w wVar = yp.w.INV;
                yp.i iVarO2 = rVar.o(nVarX);
                g gVar = f17688a;
                yp.w wVarH = gVar.h(rVar.z(rVar.h0(oVarB, i10)), rVar.p0(nVarO));
                if (wVarH == null) {
                    return z0Var.f17775a;
                }
                if (wVarH != wVar || (!gVar.s(rVar, iVarO2, iVarO, oVarB) && !gVar.s(rVar, iVarO, iVarO2, oVarB))) {
                    int i12 = z0Var.f17781g;
                    if (i12 > 100) {
                        throw new IllegalStateException(kn.l0.C("Arguments depth is too high. Some related argument: ", iVarO2).toString());
                    }
                    z0Var.f17781g = i12 + 1;
                    int i13 = a.f17690a[wVarH.ordinal()];
                    if (i13 == 1) {
                        zI = gVar.i(z0Var, iVarO2, iVarO);
                    } else if (i13 == 2) {
                        zI = q(gVar, z0Var, iVarO2, iVarO, false, 8, null);
                    } else {
                        if (i13 != 3) {
                            throw new lm.i0();
                        }
                        zI = q(gVar, z0Var, iVarO, iVarO2, false, 8, null);
                    }
                    z0Var.f17781g--;
                    if (!zI) {
                        return false;
                    }
                }
            }
            i10 = i11;
        }
        return true;
    }

    public final boolean p(@os.l z0 z0Var, @os.l yp.i iVar, @os.l yp.i iVar2, boolean z10) {
        kn.l0.p(z0Var, "state");
        kn.l0.p(iVar, "subType");
        kn.l0.p(iVar2, "superType");
        if (iVar == iVar2) {
            return true;
        }
        if (z0Var.f(iVar, iVar2)) {
            return g(z0Var, iVar, iVar2, z10);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00fd A[LOOP:2: B:48:0x00d6->B:57:0x00fd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x010b A[SYNTHETIC] */
    public final boolean r(z0 z0Var, yp.k kVar, yp.k kVar2) {
        yp.o oVar;
        yp.o oVar2;
        yp.r rVar = z0Var.f17778d;
        if (f17689b) {
            if (!rVar.a(kVar) && !rVar.W(rVar.b(kVar))) {
                z0Var.l(kVar);
            }
            if (!rVar.a(kVar2)) {
                z0Var.l(kVar2);
            }
        }
        boolean z10 = false;
        if (!d.f17669a.d(z0Var, kVar, kVar2)) {
            return false;
        }
        g gVar = f17688a;
        Boolean boolA = gVar.a(z0Var, rVar.u0(kVar), rVar.G(kVar2));
        if (boolA != null) {
            boolean zBooleanValue = boolA.booleanValue();
            z0.d(z0Var, kVar, kVar2, false, 4, null);
            return zBooleanValue;
        }
        yp.o oVarB = rVar.b(kVar2);
        boolean z11 = true;
        if ((rVar.V(rVar.b(kVar), oVarB) && rVar.d0(oVarB) == 0) || rVar.v(rVar.b(kVar2))) {
            return true;
        }
        List<yp.k> listJ = gVar.j(z0Var, kVar, oVarB);
        int i10 = 10;
        ArrayList<yp.k> arrayList = new ArrayList(nm.z.b0(listJ, 10));
        for (yp.k kVar3 : listJ) {
            yp.k kVarD = rVar.d(z0Var.o(kVar3));
            if (kVarD != null) {
                kVar3 = kVarD;
            }
            arrayList.add(kVar3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return f17688a.l(z0Var, kVar);
        }
        if (size == 1) {
            return f17688a.o(z0Var, rVar.l((yp.k) nm.h0.B2(arrayList)), kVar2);
        }
        yp.a aVar = new yp.a(rVar.d0(oVarB));
        int iD0 = rVar.d0(oVarB);
        int i11 = 0;
        boolean z12 = false;
        while (i11 < iD0) {
            int i12 = i11 + 1;
            z12 = (z12 || rVar.z(rVar.h0(oVarB, i11)) != yp.w.OUT) ? z11 : z10;
            if (z12) {
                oVar = oVarB;
            } else {
                ArrayList arrayList2 = new ArrayList(nm.z.b0(arrayList, i10));
                for (yp.k kVar4 : arrayList) {
                    yp.n nVarA = rVar.A(kVar4, i11);
                    if (nVarA == null) {
                        oVar2 = oVarB;
                    } else {
                        oVar2 = oVarB;
                        if (rVar.p0(nVarA) != yp.w.INV) {
                        }
                        if (nVarA != null) {
                            throw new IllegalStateException(("Incorrect type: " + kVar4 + ", subType: " + kVar + ", superType: " + kVar2).toString());
                        }
                        arrayList2.add(rVar.o(nVarA));
                        oVarB = oVar2;
                    }
                    nVarA = null;
                    if (nVarA != null) {
                        throw new IllegalStateException(("Incorrect type: " + kVar4 + ", subType: " + kVar + ", superType: " + kVar2).toString());
                    }
                    arrayList2.add(rVar.o(nVarA));
                    oVarB = oVar2;
                }
                oVar = oVarB;
                aVar.add(rVar.H(rVar.e0(arrayList2)));
            }
            i11 = i12;
            oVarB = oVar;
            z10 = false;
            z11 = true;
            i10 = 10;
        }
        if (!z12 && f17688a.o(z0Var, aVar, kVar2)) {
            return true;
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (f17688a.o(z0Var, rVar.l((yp.k) it.next()), kVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean s(yp.r rVar, yp.i iVar, yp.i iVar2, yp.o oVar) {
        yp.p pVarO0;
        yp.k kVarD = rVar.d(iVar);
        if (!(kVarD instanceof yp.d)) {
            return false;
        }
        yp.d dVar = (yp.d) kVarD;
        if (rVar.F(dVar) || !rVar.w0(rVar.n(rVar.t(dVar))) || rVar.K(dVar) != yp.b.FOR_SUBTYPING) {
            return false;
        }
        yp.o oVarS0 = rVar.s0(iVar2);
        yp.v vVar = oVarS0 instanceof yp.v ? (yp.v) oVarS0 : null;
        return (vVar == null || (pVarO0 = rVar.o0(vVar)) == null || !rVar.c0(pVarO0, oVar)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<yp.k> t(z0 z0Var, List<? extends yp.k> list) {
        yp.r rVar = z0Var.f17778d;
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            yp.m mVarL = rVar.l((yp.k) obj);
            int iQ = rVar.q(mVarL);
            int i10 = 0;
            while (true) {
                if (i10 >= iQ) {
                    arrayList.add(obj);
                    break;
                }
                int i11 = i10 + 1;
                if (rVar.b0(rVar.o(rVar.x(mVarL, i10))) != null) {
                    break;
                }
                i10 = i11;
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }
}
