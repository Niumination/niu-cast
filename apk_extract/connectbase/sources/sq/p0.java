package sq;

/* JADX INFO: loaded from: classes3.dex */
public interface p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f15321a = a.f15322a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f15322a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final p0 f15323b = new r0();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public static final p0 f15324c = new s0();

        public static p0 b(a aVar, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = 0;
            }
            if ((i10 & 2) != 0) {
                j11 = Long.MAX_VALUE;
            }
            aVar.getClass();
            return new t0(j10, j11);
        }

        @os.l
        public final p0 a(long j10, long j11) {
            return new t0(j10, j11);
        }

        @os.l
        public final p0 c() {
            return f15323b;
        }

        @os.l
        public final p0 d() {
            return f15324c;
        }
    }

    @os.l
    i<n0> a(@os.l u0<Integer> u0Var);
}
