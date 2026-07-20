package lq;

import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.9")
@p2(markerClass = {l.class})
public interface r {

    public static final class a {
        public static boolean a(@os.l r rVar) {
            return e.f0(rVar.a());
        }

        public static boolean b(@os.l r rVar) {
            return !e.f0(rVar.a());
        }

        @os.l
        public static r c(@os.l r rVar, long j10) {
            return rVar.c(e.z0(j10));
        }

        @os.l
        public static r d(@os.l r rVar, long j10) {
            return new c(rVar, j10);
        }
    }

    long a();

    boolean b();

    @os.l
    r c(long j10);

    boolean d();

    @os.l
    r e(long j10);
}
