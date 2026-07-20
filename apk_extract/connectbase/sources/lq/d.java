package lq;

import kn.l0;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.9")
@p2(markerClass = {l.class})
public interface d extends r, Comparable<d> {

    public static final class a {
        public static int a(@os.l d dVar, @os.l d dVar2) {
            l0.p(dVar2, "other");
            long j10 = dVar.j(dVar2);
            e.f10247b.getClass();
            return e.m(j10, e.f10248c);
        }

        public static boolean b(@os.l d dVar) {
            return r.a.a(dVar);
        }

        public static boolean c(@os.l d dVar) {
            return r.a.b(dVar);
        }

        @os.l
        public static d d(@os.l d dVar, long j10) {
            return dVar.c(e.z0(j10));
        }
    }

    @Override // lq.r
    @os.l
    d c(long j10);

    @Override // lq.r
    @os.l
    d e(long j10);

    boolean equals(@os.m Object obj);

    int hashCode();

    int i(@os.l d dVar);

    long j(@os.l d dVar);
}
