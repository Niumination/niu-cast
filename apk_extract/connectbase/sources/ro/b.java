package ro;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kn.l0;
import nm.k0;
import nm.m0;
import uo.n;
import uo.r;
import uo.w;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f14604a = new a();

        @Override // ro.b
        @os.m
        public n b(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            return null;
        }

        @Override // ro.b
        @os.l
        public Set<dp.f> c() {
            return m0.INSTANCE;
        }

        @Override // ro.b
        @os.l
        public Set<dp.f> d() {
            return m0.INSTANCE;
        }

        @Override // ro.b
        @os.l
        public Set<dp.f> e() {
            return m0.INSTANCE;
        }

        @Override // ro.b
        @os.m
        public w f(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            return null;
        }

        @Override // ro.b
        @os.l
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public List<r> a(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            return k0.INSTANCE;
        }
    }

    @os.l
    Collection<r> a(@os.l dp.f fVar);

    @os.m
    n b(@os.l dp.f fVar);

    @os.l
    Set<dp.f> c();

    @os.l
    Set<dp.f> d();

    @os.l
    Set<dp.f> e();

    @os.m
    w f(@os.l dp.f fVar);
}
