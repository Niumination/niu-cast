package rp;

import kn.l0;
import vp.f0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public interface r {

    public static final class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f14767a = new a();

        @Override // rp.r
        @os.l
        public f0 a(@os.l yo.a.q qVar, @os.l String str, @os.l n0 n0Var, @os.l n0 n0Var2) {
            l0.p(qVar, "proto");
            l0.p(str, "flexibleId");
            l0.p(n0Var, "lowerBound");
            l0.p(n0Var2, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    @os.l
    f0 a(@os.l yo.a.q qVar, @os.l String str, @os.l n0 n0Var, @os.l n0 n0Var2);
}
