package nk;

import fl.s0;
import java.io.InputStream;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    public static final class a extends n0 implements jn.a<InputStream> {
        final /* synthetic */ u.b $this_streamProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u.b bVar) {
            super(0);
            this.$this_streamProvider = bVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final InputStream invoke() {
            return s0.a(this.$this_streamProvider.f11549e.invoke());
        }
    }

    @os.l
    public static final jn.a<InputStream> a(@os.l u.b bVar) {
        l0.p(bVar, "<this>");
        return new a(bVar);
    }
}
