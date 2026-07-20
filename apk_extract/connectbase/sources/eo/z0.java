package eo;

/* JADX INFO: loaded from: classes3.dex */
public interface z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0 f4654a = new a();

    public static class a implements z0 {
        public static /* synthetic */ void d(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // eo.z0
        @os.l
        public a1 b() {
            a1 a1Var = a1.f4590a;
            if (a1Var == null) {
                d(0);
            }
            return a1Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    @os.l
    a1 b();
}
