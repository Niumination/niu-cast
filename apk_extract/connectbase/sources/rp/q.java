package rp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f14766a = new a();

    public static class a implements q {
        public static /* synthetic */ void c(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i10 != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // rp.q
        public void a(@os.l eo.e eVar, @os.l List<String> list) {
            if (eVar == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }

        @Override // rp.q
        public void b(@os.l eo.b bVar) {
            if (bVar == null) {
                c(2);
            }
        }
    }

    void a(@os.l eo.e eVar, @os.l List<String> list);

    void b(@os.l eo.b bVar);
}
