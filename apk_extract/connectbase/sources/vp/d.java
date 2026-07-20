package vp;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final d f17669a = new d();

    public final boolean a(@os.l z0 z0Var, @os.l yp.k kVar, @os.l z0.b bVar) {
        kn.l0.p(z0Var, "<this>");
        kn.l0.p(kVar, ik.y0.a.f8215h);
        kn.l0.p(bVar, "supertypesPolicy");
        yp.r rVar = z0Var.f17778d;
        if ((rVar.h(kVar) && !rVar.Y(kVar)) || rVar.f0(kVar)) {
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
                z0.b bVar2 = rVar.Y(kVarPop) ? z0.b.c.f17787a : bVar;
                if (kn.l0.g(bVar2, z0.b.c.f17787a)) {
                    bVar2 = null;
                }
                if (bVar2 == null) {
                    continue;
                } else {
                    yp.r rVar2 = z0Var.f17778d;
                    Iterator<yp.i> it = rVar2.r(rVar2.b(kVarPop)).iterator();
                    while (it.hasNext()) {
                        yp.k kVarA = bVar2.a(z0Var, it.next());
                        if ((rVar.h(kVarA) && !rVar.Y(kVarA)) || rVar.f0(kVarA)) {
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

    public final boolean b(@os.l z0 z0Var, @os.l yp.k kVar, @os.l yp.o oVar) {
        kn.l0.p(z0Var, "state");
        kn.l0.p(kVar, FloatingWindow.f2048b0);
        kn.l0.p(oVar, FloatingWindow.f2049c0);
        yp.r rVar = z0Var.f17778d;
        if (f17669a.c(z0Var, kVar, oVar)) {
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
                z0.b bVar = rVar.Y(kVarPop) ? z0.b.c.f17787a : z0.b.C0464b.f17786a;
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
                        if (f17669a.c(z0Var, kVarA, oVar)) {
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

    public final boolean c(z0 z0Var, yp.k kVar, yp.o oVar) {
        yp.r rVar = z0Var.f17778d;
        if (rVar.j0(kVar)) {
            return true;
        }
        if (rVar.Y(kVar)) {
            return false;
        }
        if (z0Var.f17776b && rVar.s(kVar)) {
            return true;
        }
        return rVar.V(rVar.b(kVar), oVar);
    }

    public final boolean d(@os.l z0 z0Var, @os.l yp.k kVar, @os.l yp.k kVar2) {
        kn.l0.p(z0Var, "state");
        kn.l0.p(kVar, "subType");
        kn.l0.p(kVar2, "superType");
        return e(z0Var, kVar, kVar2);
    }

    public final boolean e(z0 z0Var, yp.k kVar, yp.k kVar2) {
        yp.r rVar = z0Var.f17778d;
        if (g.f17689b) {
            if (!rVar.a(kVar) && !rVar.W(rVar.b(kVar))) {
                z0Var.l(kVar);
            }
            if (!rVar.a(kVar2)) {
                z0Var.l(kVar2);
            }
        }
        if (rVar.Y(kVar2) || rVar.f0(kVar)) {
            return true;
        }
        if ((kVar instanceof yp.d) && rVar.a0((yp.d) kVar)) {
            return true;
        }
        d dVar = f17669a;
        if (dVar.a(z0Var, kVar, z0.b.C0464b.f17786a)) {
            return true;
        }
        if (rVar.f0(kVar2) || dVar.a(z0Var, kVar2, z0.b.d.f17788a) || rVar.h(kVar)) {
            return false;
        }
        return dVar.b(z0Var, kVar, rVar.b(kVar2));
    }
}
