package go;

import dp.f;
import eo.y0;
import java.util.Collection;
import kn.l0;
import nm.k0;
import os.l;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: go.a$a, reason: collision with other inner class name */
    public static final class C0182a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final C0182a f6752a = new C0182a();

        @Override // go.a
        @l
        public Collection<f0> a(@l eo.e eVar) {
            l0.p(eVar, "classDescriptor");
            return k0.INSTANCE;
        }

        @Override // go.a
        @l
        public Collection<y0> b(@l f fVar, @l eo.e eVar) {
            l0.p(fVar, "name");
            l0.p(eVar, "classDescriptor");
            return k0.INSTANCE;
        }

        @Override // go.a
        @l
        public Collection<f> d(@l eo.e eVar) {
            l0.p(eVar, "classDescriptor");
            return k0.INSTANCE;
        }

        @Override // go.a
        @l
        public Collection<eo.d> e(@l eo.e eVar) {
            l0.p(eVar, "classDescriptor");
            return k0.INSTANCE;
        }
    }

    @l
    Collection<f0> a(@l eo.e eVar);

    @l
    Collection<y0> b(@l f fVar, @l eo.e eVar);

    @l
    Collection<f> d(@l eo.e eVar);

    @l
    Collection<eo.d> e(@l eo.e eVar);
}
