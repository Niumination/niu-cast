package eo;

import java.util.Collection;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public interface c1 {

    public static final class a implements c1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f4596a = new a();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // eo.c1
        @os.l
        public Collection<vp.f0> a(@os.l vp.a1 a1Var, @os.l Collection<? extends vp.f0> collection, @os.l jn.l<? super vp.a1, ? extends Iterable<? extends vp.f0>> lVar, @os.l jn.l<? super vp.f0, l2> lVar2) {
            kn.l0.p(a1Var, "currentTypeConstructor");
            kn.l0.p(collection, "superTypes");
            kn.l0.p(lVar, "neighbors");
            kn.l0.p(lVar2, "reportLoop");
            return collection;
        }
    }

    @os.l
    Collection<vp.f0> a(@os.l vp.a1 a1Var, @os.l Collection<? extends vp.f0> collection, @os.l jn.l<? super vp.a1, ? extends Iterable<? extends vp.f0>> lVar, @os.l jn.l<? super vp.f0, l2> lVar2);
}
