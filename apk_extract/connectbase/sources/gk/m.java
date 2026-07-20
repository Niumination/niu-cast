package gk;

import nq.k1;

/* JADX INFO: loaded from: classes2.dex */
public interface m {

    public static final class a {
        public static /* synthetic */ pl.k a(m mVar, pl.k kVar, um.g gVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: compress");
            }
            if ((i10 & 2) != 0) {
                gVar = k1.g();
            }
            return mVar.b(kVar, gVar);
        }

        public static /* synthetic */ pl.n b(m mVar, pl.n nVar, um.g gVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: compress");
            }
            if ((i10 & 2) != 0) {
                gVar = k1.g();
            }
            return mVar.a(nVar, gVar);
        }

        @os.m
        public static Long c(@os.l m mVar, long j10) {
            kn.l0.p(mVar, "this");
            return null;
        }
    }

    @os.l
    pl.n a(@os.l pl.n nVar, @os.l um.g gVar);

    @os.l
    pl.k b(@os.l pl.k kVar, @os.l um.g gVar);

    @os.m
    Long c(long j10);
}
