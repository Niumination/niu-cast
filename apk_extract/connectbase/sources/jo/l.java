package jo;

import eo.a1;
import kn.l0;
import ko.p;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements to.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final l f8768a = new l();

    public static final class a implements to.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final p f8769b;

        public a(@os.l p pVar) {
            l0.p(pVar, "javaElement");
            this.f8769b = pVar;
        }

        @Override // eo.z0
        @os.l
        public a1 b() {
            a1 a1Var = a1.f4590a;
            l0.o(a1Var, "NO_SOURCE_FILE");
            return a1Var;
        }

        @Override // to.a
        public uo.l c() {
            return this.f8769b;
        }

        @os.l
        public p d() {
            return this.f8769b;
        }

        @os.l
        public String toString() {
            return a.class.getName() + ": " + this.f8769b;
        }
    }

    @Override // to.b
    @os.l
    public to.a a(@os.l uo.l lVar) {
        l0.p(lVar, "javaElement");
        return new a((p) lVar);
    }
}
