package wp;

import eo.h0;
import ik.y0;
import java.util.Collection;
import kn.l0;
import vp.a1;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends vp.j {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f19853a = new a();

        @Override // wp.g
        @os.m
        public eo.e b(@os.l dp.b bVar) {
            l0.p(bVar, "classId");
            return null;
        }

        @Override // wp.g
        @os.l
        public <S extends op.h> S c(@os.l eo.e eVar, @os.l jn.a<? extends S> aVar) {
            l0.p(eVar, "classDescriptor");
            l0.p(aVar, "compute");
            return aVar.invoke();
        }

        @Override // wp.g
        public boolean d(@os.l h0 h0Var) {
            l0.p(h0Var, "moduleDescriptor");
            return false;
        }

        @Override // wp.g
        public boolean e(@os.l a1 a1Var) {
            l0.p(a1Var, "typeConstructor");
            return false;
        }

        @Override // wp.g
        @os.l
        public Collection<f0> g(@os.l eo.e eVar) {
            l0.p(eVar, "classDescriptor");
            Collection<f0> collectionA = eVar.i().a();
            l0.o(collectionA, "classDescriptor.typeConstructor.supertypes");
            return collectionA;
        }

        @Override // vp.j
        @os.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public f0 a(@os.l yp.i iVar) {
            l0.p(iVar, y0.a.f8215h);
            return (f0) iVar;
        }

        @Override // wp.g
        @os.m
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public eo.e f(@os.l eo.m mVar) {
            l0.p(mVar, "descriptor");
            return null;
        }
    }

    @os.m
    public abstract eo.e b(@os.l dp.b bVar);

    @os.l
    public abstract <S extends op.h> S c(@os.l eo.e eVar, @os.l jn.a<? extends S> aVar);

    public abstract boolean d(@os.l h0 h0Var);

    public abstract boolean e(@os.l a1 a1Var);

    @os.m
    public abstract eo.h f(@os.l eo.m mVar);

    @os.l
    public abstract Collection<f0> g(@os.l eo.e eVar);

    @os.l
    /* JADX INFO: renamed from: h */
    public abstract f0 a(@os.l yp.i iVar);
}
