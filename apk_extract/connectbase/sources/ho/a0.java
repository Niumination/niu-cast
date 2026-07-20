package ho;

import eo.p0;

/* JADX INFO: loaded from: classes3.dex */
public interface a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f7289a = a.f7290a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f7290a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final eo.g0<a0> f7291b = new eo.g0<>("PackageViewDescriptorFactory");

        @os.l
        public final eo.g0<a0> a() {
            return f7291b;
        }
    }

    public static final class b implements a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final b f7292b = new b();

        @Override // ho.a0
        @os.l
        public p0 a(@os.l x xVar, @os.l dp.c cVar, @os.l up.n nVar) {
            kn.l0.p(xVar, "module");
            kn.l0.p(cVar, "fqName");
            kn.l0.p(nVar, "storageManager");
            return new r(xVar, cVar, nVar);
        }
    }

    @os.l
    p0 a(@os.l x xVar, @os.l dp.c cVar, @os.l up.n nVar);
}
