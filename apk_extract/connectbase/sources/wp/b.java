package wp;

import androidx.core.app.NotificationCompat;
import eo.d1;
import eo.e1;
import ik.y0;
import java.util.Collection;
import java.util.List;
import kn.l0;
import kn.l1;
import od.c1;
import vp.a1;
import vp.b1;
import vp.e0;
import vp.f0;
import vp.g0;
import vp.h0;
import vp.h1;
import vp.i1;
import vp.j1;
import vp.n0;
import vp.n1;
import vp.o1;
import vp.p0;
import vp.u0;
import vp.z;
import vp.z0;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends i1, yp.t {

    public static final class a {

        /* JADX INFO: renamed from: wp.b$a$a, reason: collision with other inner class name */
        public static final class C0493a extends z0.b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f19849a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h1 f19850b;

            public C0493a(b bVar, h1 h1Var) {
                this.f19849a = bVar;
                this.f19850b = h1Var;
            }

            @Override // vp.z0.b
            @os.l
            public yp.k a(@os.l z0 z0Var, @os.l yp.i iVar) {
                l0.p(z0Var, "state");
                l0.p(iVar, y0.a.f8215h);
                b bVar = this.f19849a;
                f0 f0VarN = this.f19850b.n((f0) bVar.u0(iVar), o1.INVARIANT);
                l0.o(f0VarN, "substitutor.safeSubstitu…VARIANT\n                )");
                yp.k kVarD = bVar.d(f0VarN);
                l0.m(kVarD);
                return kVarD;
            }
        }

        @os.l
        public static yp.w A(@os.l b bVar, @os.l yp.p pVar) {
            l0.p(bVar, "this");
            l0.p(pVar, "receiver");
            if (pVar instanceof e1) {
                o1 o1VarM = ((e1) pVar).m();
                l0.o(o1VarM, "this.variance");
                return yp.s.a(o1VarM);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + pVar + ", " + l1.d(pVar.getClass())).toString());
        }

        @os.l
        public static yp.i A0(@os.l b bVar, @os.l yp.i iVar, boolean z10) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof yp.k) {
                return bVar.c((yp.k) iVar, z10);
            }
            if (!(iVar instanceof yp.g)) {
                throw new IllegalStateException("sealed");
            }
            yp.g gVar = (yp.g) iVar;
            return bVar.i0(bVar.c(bVar.e(gVar), z10), bVar.c(bVar.g(gVar), z10));
        }

        public static boolean B(@os.l b bVar, @os.l yp.i iVar, @os.l dp.c cVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            l0.p(cVar, "fqName");
            if (iVar instanceof f0) {
                return ((f0) iVar).getAnnotations().p(cVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        @os.l
        public static yp.k B0(@os.l b bVar, @os.l yp.k kVar, boolean z10) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (kVar instanceof n0) {
                return ((n0) kVar).N0(z10);
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        public static boolean C(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.d(bVar, iVar);
        }

        public static boolean D(@os.l b bVar, @os.l yp.p pVar, @os.m yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(pVar, "receiver");
            if (!(pVar instanceof e1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + pVar + ", " + l1.d(pVar.getClass())).toString());
            }
            if (oVar == null ? true : oVar instanceof a1) {
                return zp.a.l((e1) pVar, (a1) oVar, null, 4, null);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + pVar + ", " + l1.d(pVar.getClass())).toString());
        }

        public static boolean E(@os.l b bVar, @os.l yp.k kVar, @os.l yp.k kVar2) {
            l0.p(bVar, "this");
            l0.p(kVar, "a");
            l0.p(kVar2, "b");
            if (!(kVar instanceof n0)) {
                StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
                sbA.append(l1.d(kVar.getClass()));
                throw new IllegalArgumentException(sbA.toString().toString());
            }
            if (kVar2 instanceof n0) {
                return ((n0) kVar).F0() == ((n0) kVar2).F0();
            }
            StringBuilder sbA2 = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar2, ", ");
            sbA2.append(l1.d(kVar2.getClass()));
            throw new IllegalArgumentException(sbA2.toString().toString());
        }

        @os.l
        public static yp.i F(@os.l b bVar, @os.l List<? extends yp.i> list) {
            l0.p(bVar, "this");
            l0.p(list, "types");
            return d.a(list);
        }

        public static boolean G(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                return ao.h.u0((a1) oVar, ao.k.a.f573b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static boolean H(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.e(bVar, iVar);
        }

        public static boolean I(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            return yp.t.a.f(bVar, kVar);
        }

        public static boolean J(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                return ((a1) oVar).d() instanceof eo.e;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static boolean K(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                eo.h hVarD = ((a1) oVar).d();
                eo.e eVar = hVarD instanceof eo.e ? (eo.e) hVarD : null;
                return (eVar == null || !eo.f0.a(eVar) || eVar.getKind() == eo.f.ENUM_ENTRY || eVar.getKind() == eo.f.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static boolean L(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.g(bVar, iVar);
        }

        public static boolean M(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                return ((a1) oVar).e();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static boolean N(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.h(bVar, iVar);
        }

        public static boolean O(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof f0) {
                return h0.a((f0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        public static boolean P(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                eo.h hVarD = ((a1) oVar).d();
                eo.e eVar = hVarD instanceof eo.e ? (eo.e) hVarD : null;
                return eVar != null && hp.f.b(eVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static boolean Q(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            return yp.t.a.i(bVar, kVar);
        }

        public static boolean R(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                return oVar instanceof jp.n;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static boolean S(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                return oVar instanceof e0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static boolean T(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.j(bVar, iVar);
        }

        public static boolean U(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (kVar instanceof n0) {
                return ((n0) kVar).H0();
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        public static boolean V(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.k(bVar, iVar);
        }

        public static boolean W(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                return ao.h.u0((a1) oVar, ao.k.a.f575c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static boolean X(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof f0) {
                return j1.m((f0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        public static boolean Y(@os.l b bVar, @os.l yp.d dVar) {
            l0.p(bVar, "this");
            l0.p(dVar, "receiver");
            return dVar instanceof ip.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean Z(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (kVar instanceof f0) {
                return ao.h.q0((f0) kVar);
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        public static boolean a(@os.l b bVar, @os.l yp.o oVar, @os.l yp.o oVar2) {
            l0.p(bVar, "this");
            l0.p(oVar, c1.f12184a);
            l0.p(oVar2, "c2");
            if (!(oVar instanceof a1)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
            }
            if (oVar2 instanceof a1) {
                return l0.g(oVar, oVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar2 + ", " + l1.d(oVar2.getClass())).toString());
        }

        public static boolean a0(@os.l b bVar, @os.l yp.d dVar) {
            l0.p(bVar, "this");
            l0.p(dVar, "receiver");
            if (dVar instanceof i) {
                return ((i) dVar).f19860g;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + l1.d(dVar.getClass())).toString());
        }

        public static int b(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof f0) {
                return ((f0) iVar).F0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean b0(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (!(kVar instanceof n0)) {
                StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
                sbA.append(l1.d(kVar.getClass()));
                throw new IllegalArgumentException(sbA.toString().toString());
            }
            if (!h0.a((f0) kVar)) {
                n0 n0Var = (n0) kVar;
                if (!(n0Var.G0().d() instanceof d1) && (n0Var.G0().d() != null || (kVar instanceof ip.a) || (kVar instanceof i) || (kVar instanceof vp.o) || (n0Var.G0() instanceof jp.n) || c0(bVar, kVar))) {
                    return true;
                }
            }
            return false;
        }

        @os.l
        public static yp.m c(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (kVar instanceof n0) {
                return (yp.m) kVar;
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        public static boolean c0(b bVar, yp.k kVar) {
            return (kVar instanceof p0) && bVar.a(((p0) kVar).f17733b);
        }

        @os.m
        public static yp.d d(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (!(kVar instanceof n0)) {
                StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
                sbA.append(l1.d(kVar.getClass()));
                throw new IllegalArgumentException(sbA.toString().toString());
            }
            if (kVar instanceof p0) {
                return bVar.f(((p0) kVar).f17733b);
            }
            if (kVar instanceof i) {
                return (i) kVar;
            }
            return null;
        }

        public static boolean d0(@os.l b bVar, @os.l yp.n nVar) {
            l0.p(bVar, "this");
            l0.p(nVar, "receiver");
            if (nVar instanceof vp.c1) {
                return ((vp.c1) nVar).a();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + l1.d(nVar.getClass())).toString());
        }

        @os.m
        public static yp.e e(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (kVar instanceof n0) {
                if (kVar instanceof vp.o) {
                    return (vp.o) kVar;
                }
                return null;
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        public static boolean e0(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (kVar instanceof n0) {
                return (kVar instanceof vp.f) || ((kVar instanceof vp.o) && (((vp.o) kVar).f17724b instanceof vp.f));
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        @os.m
        public static yp.f f(@os.l b bVar, @os.l yp.g gVar) {
            l0.p(bVar, "this");
            l0.p(gVar, "receiver");
            if (gVar instanceof z) {
                if (gVar instanceof vp.u) {
                    return (vp.u) gVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + l1.d(gVar.getClass())).toString());
        }

        public static boolean f0(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (kVar instanceof n0) {
                return (kVar instanceof u0) || ((kVar instanceof vp.o) && (((vp.o) kVar).f17724b instanceof u0));
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        @os.m
        public static yp.g g(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof f0) {
                n1 n1VarJ0 = ((f0) iVar).J0();
                if (n1VarJ0 instanceof z) {
                    return (z) n1VarJ0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        public static boolean g0(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return (iVar instanceof n1) && (((n1) iVar).G0() instanceof n);
        }

        @os.m
        public static yp.k h(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof f0) {
                n1 n1VarJ0 = ((f0) iVar).J0();
                if (n1VarJ0 instanceof n0) {
                    return (n0) n1VarJ0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        public static boolean h0(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                eo.h hVarD = ((a1) oVar).d();
                return hVarD != null && ao.h.z0(hVarD);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        @os.l
        public static yp.n i(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof f0) {
                return zp.a.a((f0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        @os.l
        public static yp.k i0(@os.l b bVar, @os.l yp.g gVar) {
            l0.p(bVar, "this");
            l0.p(gVar, "receiver");
            if (gVar instanceof z) {
                return ((z) gVar).f17773b;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + l1.d(gVar.getClass())).toString());
        }

        @os.m
        public static yp.k j(@os.l b bVar, @os.l yp.k kVar, @os.l yp.b bVar2) {
            l0.p(bVar, "this");
            l0.p(kVar, y0.a.f8215h);
            l0.p(bVar2, NotificationCompat.CATEGORY_STATUS);
            if (kVar instanceof n0) {
                return k.b((n0) kVar, bVar2);
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        @os.l
        public static yp.k j0(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.l(bVar, iVar);
        }

        @os.l
        public static yp.b k(@os.l b bVar, @os.l yp.d dVar) {
            l0.p(bVar, "this");
            l0.p(dVar, "receiver");
            if (dVar instanceof i) {
                return ((i) dVar).f19855b;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + l1.d(dVar.getClass())).toString());
        }

        @os.m
        public static yp.i k0(@os.l b bVar, @os.l yp.d dVar) {
            l0.p(bVar, "this");
            l0.p(dVar, "receiver");
            if (dVar instanceof i) {
                return ((i) dVar).f19857d;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + l1.d(dVar.getClass())).toString());
        }

        @os.l
        public static yp.i l(@os.l b bVar, @os.l yp.k kVar, @os.l yp.k kVar2) {
            l0.p(bVar, "this");
            l0.p(kVar, "lowerBound");
            l0.p(kVar2, "upperBound");
            if (!(kVar instanceof n0)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + l1.d(bVar.getClass())).toString());
            }
            if (kVar2 instanceof n0) {
                return g0.d((n0) kVar, (n0) kVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + l1.d(bVar.getClass())).toString());
        }

        @os.l
        public static yp.i l0(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof n1) {
                return c.b((n1) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        @os.m
        public static List<yp.k> m(@os.l b bVar, @os.l yp.k kVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            l0.p(oVar, "constructor");
            return yp.t.a.a(bVar, kVar, oVar);
        }

        @os.l
        public static yp.i m0(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return i1.a.a(bVar, iVar);
        }

        @os.l
        public static yp.n n(@os.l b bVar, @os.l yp.m mVar, int i10) {
            l0.p(bVar, "this");
            l0.p(mVar, "receiver");
            return yp.t.a.b(bVar, mVar, i10);
        }

        @os.l
        public static z0 n0(@os.l b bVar, boolean z10, boolean z11) {
            l0.p(bVar, "this");
            return wp.a.b(z10, z11, bVar, null, null, 24, null);
        }

        @os.l
        public static yp.n o(@os.l b bVar, @os.l yp.i iVar, int i10) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof f0) {
                return ((f0) iVar).F0().get(i10);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        @os.l
        public static yp.k o0(@os.l b bVar, @os.l yp.e eVar) {
            l0.p(bVar, "this");
            l0.p(eVar, "receiver");
            if (eVar instanceof vp.o) {
                return ((vp.o) eVar).f17724b;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + eVar + ", " + l1.d(eVar.getClass())).toString());
        }

        @os.m
        public static yp.n p(@os.l b bVar, @os.l yp.k kVar, int i10) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            return yp.t.a.c(bVar, kVar, i10);
        }

        public static int p0(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                return ((a1) oVar).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        @os.l
        public static dp.d q(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                eo.h hVarD = ((a1) oVar).d();
                if (hVarD != null) {
                    return lp.a.j((eo.e) hVarD);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        @os.l
        public static Collection<yp.i> q0(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            yp.o oVarB = bVar.b(kVar);
            if (oVarB instanceof jp.n) {
                return ((jp.n) oVarB).f8783c;
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        @os.l
        public static yp.p r(@os.l b bVar, @os.l yp.o oVar, int i10) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                e1 e1Var = ((a1) oVar).getParameters().get(i10);
                l0.o(e1Var, "this.parameters[index]");
                return e1Var;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        @os.l
        public static yp.n r0(@os.l b bVar, @os.l yp.c cVar) {
            l0.p(bVar, "this");
            l0.p(cVar, "receiver");
            if (cVar instanceof j) {
                return ((j) cVar).f19861a;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + l1.d(cVar.getClass())).toString());
        }

        @os.m
        public static ao.i s(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                eo.h hVarD = ((a1) oVar).d();
                if (hVarD != null) {
                    return ao.h.P((eo.e) hVarD);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        public static int s0(@os.l b bVar, @os.l yp.m mVar) {
            l0.p(bVar, "this");
            l0.p(mVar, "receiver");
            return yp.t.a.m(bVar, mVar);
        }

        @os.m
        public static ao.i t(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                eo.h hVarD = ((a1) oVar).d();
                if (hVarD != null) {
                    return ao.h.S((eo.e) hVarD);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @os.l
        public static z0.b t0(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, y0.a.f8215h);
            if (kVar instanceof n0) {
                return new C0493a(bVar, b1.f17666c.a((f0) kVar).c());
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        @os.l
        public static yp.i u(@os.l b bVar, @os.l yp.p pVar) {
            l0.p(bVar, "this");
            l0.p(pVar, "receiver");
            if (pVar instanceof e1) {
                return zp.a.i((e1) pVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + pVar + ", " + l1.d(pVar.getClass())).toString());
        }

        @os.l
        public static Collection<yp.i> u0(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                Collection<f0> collectionA = ((a1) oVar).a();
                l0.o(collectionA, "this.supertypes");
                return collectionA;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        @os.m
        public static yp.i v(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            if (iVar instanceof f0) {
                return hp.f.e((f0) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + l1.d(iVar.getClass())).toString());
        }

        @os.l
        public static yp.c v0(@os.l b bVar, @os.l yp.d dVar) {
            l0.p(bVar, "this");
            l0.p(dVar, "receiver");
            if (dVar instanceof i) {
                return ((i) dVar).f19856c;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + dVar + ", " + l1.d(dVar.getClass())).toString());
        }

        @os.l
        public static yp.i w(@os.l b bVar, @os.l yp.n nVar) {
            l0.p(bVar, "this");
            l0.p(nVar, "receiver");
            if (nVar instanceof vp.c1) {
                return ((vp.c1) nVar).getType().J0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + l1.d(nVar.getClass())).toString());
        }

        @os.l
        public static yp.o w0(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.n(bVar, iVar);
        }

        @os.m
        public static yp.p x(@os.l b bVar, @os.l yp.v vVar) {
            l0.p(bVar, "this");
            l0.p(vVar, "receiver");
            if (vVar instanceof n) {
                return ((n) vVar).a();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + vVar + ", " + l1.d(vVar.getClass())).toString());
        }

        @os.l
        public static yp.o x0(@os.l b bVar, @os.l yp.k kVar) {
            l0.p(bVar, "this");
            l0.p(kVar, "receiver");
            if (kVar instanceof n0) {
                return ((n0) kVar).G0();
            }
            StringBuilder sbA = vp.c.a("ClassicTypeSystemContext couldn't handle: ", kVar, ", ");
            sbA.append(l1.d(kVar.getClass()));
            throw new IllegalArgumentException(sbA.toString().toString());
        }

        @os.m
        public static yp.p y(@os.l b bVar, @os.l yp.o oVar) {
            l0.p(bVar, "this");
            l0.p(oVar, "receiver");
            if (oVar instanceof a1) {
                eo.h hVarD = ((a1) oVar).d();
                if (hVarD instanceof e1) {
                    return (e1) hVarD;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + oVar + ", " + l1.d(oVar.getClass())).toString());
        }

        @os.l
        public static yp.k y0(@os.l b bVar, @os.l yp.g gVar) {
            l0.p(bVar, "this");
            l0.p(gVar, "receiver");
            if (gVar instanceof z) {
                return ((z) gVar).f17774c;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + l1.d(gVar.getClass())).toString());
        }

        @os.l
        public static yp.w z(@os.l b bVar, @os.l yp.n nVar) {
            l0.p(bVar, "this");
            l0.p(nVar, "receiver");
            if (nVar instanceof vp.c1) {
                o1 o1VarC = ((vp.c1) nVar).c();
                l0.o(o1VarC, "this.projectionKind");
                return yp.s.a(o1VarC);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + l1.d(nVar.getClass())).toString());
        }

        @os.l
        public static yp.k z0(@os.l b bVar, @os.l yp.i iVar) {
            l0.p(bVar, "this");
            l0.p(iVar, "receiver");
            return yp.t.a.o(bVar, iVar);
        }
    }

    @Override // yp.r
    boolean a(@os.l yp.k kVar);

    @Override // yp.r
    @os.l
    yp.o b(@os.l yp.k kVar);

    @Override // yp.r
    @os.l
    yp.k c(@os.l yp.k kVar, boolean z10);

    @Override // yp.r
    @os.m
    yp.k d(@os.l yp.i iVar);

    @Override // yp.r
    @os.l
    yp.k e(@os.l yp.g gVar);

    @Override // yp.r
    @os.m
    yp.d f(@os.l yp.k kVar);

    @Override // yp.r
    @os.l
    yp.k g(@os.l yp.g gVar);

    @os.l
    yp.i i0(@os.l yp.k kVar, @os.l yp.k kVar2);
}
