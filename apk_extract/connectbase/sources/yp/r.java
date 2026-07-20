package yp;

import java.util.Collection;
import java.util.List;
import kn.l0;
import kn.l1;
import vp.z0;

/* JADX INFO: loaded from: classes3.dex */
public interface r extends u {

    public static final class a {
        @os.m
        public static List<k> a(@os.l r rVar, @os.l k kVar, @os.l o oVar) {
            l0.p(rVar, "this");
            l0.p(kVar, "receiver");
            l0.p(oVar, "constructor");
            return null;
        }

        @os.l
        public static n b(@os.l r rVar, @os.l m mVar, int i10) {
            l0.p(rVar, "this");
            l0.p(mVar, "receiver");
            if (mVar instanceof k) {
                return rVar.O((i) mVar, i10);
            }
            if (mVar instanceof yp.a) {
                n nVar = ((yp.a) mVar).get(i10);
                l0.o(nVar, "get(index)");
                return nVar;
            }
            throw new IllegalStateException(("unknown type argument list type: " + mVar + ", " + l1.d(mVar.getClass())).toString());
        }

        @os.m
        public static n c(@os.l r rVar, @os.l k kVar, int i10) {
            l0.p(rVar, "this");
            l0.p(kVar, "receiver");
            if (i10 < 0 || i10 >= rVar.j(kVar)) {
                return null;
            }
            return rVar.O(kVar, i10);
        }

        public static boolean d(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            return rVar.Y(rVar.u0(iVar)) != rVar.Y(rVar.G(iVar));
        }

        public static boolean e(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            k kVarD = rVar.d(iVar);
            return (kVarD == null ? null : rVar.f(kVarD)) != null;
        }

        public static boolean f(@os.l r rVar, @os.l k kVar) {
            l0.p(rVar, "this");
            l0.p(kVar, "receiver");
            return rVar.v0(rVar.b(kVar));
        }

        public static boolean g(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            k kVarD = rVar.d(iVar);
            return (kVarD == null ? null : rVar.q0(kVarD)) != null;
        }

        public static boolean h(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            g gVarB0 = rVar.b0(iVar);
            return (gVarB0 == null ? null : rVar.p(gVarB0)) != null;
        }

        public static boolean i(@os.l r rVar, @os.l k kVar) {
            l0.p(rVar, "this");
            l0.p(kVar, "receiver");
            return rVar.B(rVar.b(kVar));
        }

        public static boolean j(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            return (iVar instanceof k) && rVar.Y((k) iVar);
        }

        public static boolean k(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            return rVar.k0(rVar.s0(iVar)) && !rVar.P(iVar);
        }

        @os.l
        public static k l(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            g gVarB0 = rVar.b0(iVar);
            if (gVarB0 != null) {
                return rVar.e(gVarB0);
            }
            k kVarD = rVar.d(iVar);
            l0.m(kVarD);
            return kVarD;
        }

        public static int m(@os.l r rVar, @os.l m mVar) {
            l0.p(rVar, "this");
            l0.p(mVar, "receiver");
            if (mVar instanceof k) {
                return rVar.j((i) mVar);
            }
            if (mVar instanceof yp.a) {
                return ((yp.a) mVar).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + mVar + ", " + l1.d(mVar.getClass())).toString());
        }

        @os.l
        public static o n(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            k kVarD = rVar.d(iVar);
            if (kVarD == null) {
                kVarD = rVar.u0(iVar);
            }
            return rVar.b(kVarD);
        }

        @os.l
        public static k o(@os.l r rVar, @os.l i iVar) {
            l0.p(rVar, "this");
            l0.p(iVar, "receiver");
            g gVarB0 = rVar.b0(iVar);
            if (gVarB0 != null) {
                return rVar.g(gVarB0);
            }
            k kVarD = rVar.d(iVar);
            l0.m(kVarD);
            return kVarD;
        }
    }

    @os.m
    n A(@os.l k kVar, int i10);

    boolean B(@os.l o oVar);

    @os.m
    i C(@os.l d dVar);

    boolean D(@os.l o oVar);

    boolean E(@os.l i iVar);

    boolean F(@os.l d dVar);

    @os.l
    k G(@os.l i iVar);

    @os.l
    n H(@os.l i iVar);

    boolean J(@os.l i iVar);

    @os.l
    b K(@os.l d dVar);

    boolean L(@os.l k kVar);

    boolean M(@os.l k kVar);

    @os.l
    k N(@os.l e eVar);

    @os.l
    n O(@os.l i iVar, int i10);

    boolean P(@os.l i iVar);

    boolean Q(@os.l i iVar);

    @os.l
    Collection<i> S(@os.l k kVar);

    @os.m
    List<k> T(@os.l k kVar, @os.l o oVar);

    boolean U(@os.l i iVar);

    boolean V(@os.l o oVar, @os.l o oVar2);

    boolean W(@os.l o oVar);

    boolean X(@os.l k kVar);

    boolean Y(@os.l k kVar);

    boolean a(@os.l k kVar);

    boolean a0(@os.l d dVar);

    @os.l
    o b(@os.l k kVar);

    @os.m
    g b0(@os.l i iVar);

    @os.l
    k c(@os.l k kVar, boolean z10);

    boolean c0(@os.l p pVar, @os.m o oVar);

    @os.m
    k d(@os.l i iVar);

    int d0(@os.l o oVar);

    @os.l
    k e(@os.l g gVar);

    @os.l
    i e0(@os.l List<? extends i> list);

    @os.m
    d f(@os.l k kVar);

    boolean f0(@os.l i iVar);

    @os.l
    k g(@os.l g gVar);

    boolean g0(@os.l i iVar);

    boolean h(@os.l k kVar);

    @os.l
    p h0(@os.l o oVar, int i10);

    int j(@os.l i iVar);

    boolean j0(@os.l i iVar);

    boolean k0(@os.l o oVar);

    @os.l
    m l(@os.l k kVar);

    @os.m
    k l0(@os.l k kVar, @os.l b bVar);

    boolean m(@os.l o oVar);

    @os.l
    n n(@os.l c cVar);

    @os.l
    i o(@os.l n nVar);

    @os.m
    p o0(@os.l v vVar);

    @os.m
    f p(@os.l g gVar);

    @os.l
    w p0(@os.l n nVar);

    int q(@os.l m mVar);

    @os.m
    e q0(@os.l k kVar);

    @os.l
    Collection<i> r(@os.l o oVar);

    @os.m
    p r0(@os.l o oVar);

    boolean s(@os.l k kVar);

    @os.l
    o s0(@os.l i iVar);

    @os.l
    c t(@os.l d dVar);

    @os.l
    k u0(@os.l i iVar);

    boolean v(@os.l o oVar);

    boolean v0(@os.l o oVar);

    boolean w(@os.l i iVar);

    boolean w0(@os.l n nVar);

    @os.l
    n x(@os.l m mVar, int i10);

    @os.l
    i x0(@os.l i iVar, boolean z10);

    @os.l
    z0.b y(@os.l k kVar);

    @os.l
    i y0(@os.l i iVar);

    @os.l
    w z(@os.l p pVar);
}
