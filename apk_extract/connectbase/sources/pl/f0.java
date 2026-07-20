package pl;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(message = "Use read { } instead.")
public interface f0 {

    public static final class a {
        public static /* synthetic */ tl.o0 a(f0 f0Var, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
            }
            if ((i11 & 1) != 0) {
                i10 = 1;
            }
            return f0Var.b(i10);
        }
    }

    @os.m
    tl.o0 b(int i10);

    int b0(int i10);

    int d();
}
