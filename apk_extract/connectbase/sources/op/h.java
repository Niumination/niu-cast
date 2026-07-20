package op;

import eo.t0;
import eo.y0;
import java.util.Collection;
import java.util.Set;
import kn.l0;
import kn.n0;
import nm.m0;

/* JADX INFO: loaded from: classes3.dex */
public interface h extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f12403a = a.f12404a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f12404a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final jn.l<dp.f, Boolean> f12405b = C0317a.INSTANCE;

        /* JADX INFO: renamed from: op.h$a$a, reason: collision with other inner class name */
        public static final class C0317a extends n0 implements jn.l<dp.f, Boolean> {
            public static final C0317a INSTANCE = new C0317a();

            public C0317a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l dp.f fVar) {
                l0.p(fVar, "it");
                return Boolean.TRUE;
            }
        }

        @os.l
        public final jn.l<dp.f, Boolean> a() {
            return f12405b;
        }
    }

    public static final class b {
        public static void a(@os.l h hVar, @os.l dp.f fVar, @os.l mo.b bVar) {
            l0.p(hVar, "this");
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            k.a.b(hVar, fVar, bVar);
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final c f12406b = new c();

        @Override // op.i, op.h
        @os.l
        public Set<dp.f> b() {
            return m0.INSTANCE;
        }

        @Override // op.i, op.h
        @os.l
        public Set<dp.f> d() {
            return m0.INSTANCE;
        }

        @Override // op.i, op.h
        @os.l
        public Set<dp.f> h() {
            return m0.INSTANCE;
        }
    }

    @Override // op.k
    @os.l
    Collection<? extends y0> a(@os.l dp.f fVar, @os.l mo.b bVar);

    @os.l
    Set<dp.f> b();

    @os.l
    Collection<? extends t0> c(@os.l dp.f fVar, @os.l mo.b bVar);

    @os.l
    Set<dp.f> d();

    @os.m
    Set<dp.f> h();
}
