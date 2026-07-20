package gp;

import java.util.Set;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface f {

    public static final class a {
        public static boolean a(@os.l f fVar) {
            l0.p(fVar, "this");
            return fVar.i().getIncludeAnnotationArguments();
        }

        public static boolean b(@os.l f fVar) {
            l0.p(fVar, "this");
            return fVar.i().getIncludeEmptyAnnotationArguments();
        }
    }

    void a(boolean z10);

    void b(boolean z10);

    boolean c();

    void d(@os.l b bVar);

    void e(boolean z10);

    void f(boolean z10);

    @os.l
    Set<dp.c> g();

    boolean h();

    @os.l
    gp.a i();

    void j(@os.l gp.a aVar);

    void k(@os.l Set<dp.c> set);

    void l(@os.l Set<? extends e> set);

    void m(boolean z10);

    void n(@os.l m mVar);

    void o(boolean z10);

    void p(boolean z10);

    void q(@os.l k kVar);

    void r(boolean z10);
}
