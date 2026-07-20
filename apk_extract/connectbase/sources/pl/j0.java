package pl;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(message = "Use read { } instead.")
public interface j0 extends f0 {

    public static final class a {
        public static /* synthetic */ Object a(j0 j0Var, int i10, um.d dVar, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: await");
            }
            if ((i11 & 1) != 0) {
                i10 = 1;
            }
            return j0Var.w(i10, dVar);
        }
    }

    @os.m
    Object w(int i10, @os.l um.d<? super Boolean> dVar);
}
