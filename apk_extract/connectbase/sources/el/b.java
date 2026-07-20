package el;

import ik.y0;
import kn.l0;
import kn.n0;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class b<S> extends c<S> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public jn.a<String> f4501f;

    public static final class a extends n0 implements jn.a<String> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return i.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @z0
    public b(@os.l un.d<S> dVar, @os.l un.s sVar) {
        super(dVar, sVar);
        l0.p(dVar, y0.a.f8215h);
        l0.p(sVar, "typeInfo");
        this.f4501f = a.INSTANCE;
    }

    @os.l
    public final jn.a<String> h() {
        return this.f4501f;
    }

    public final void i(@os.l jn.a<String> aVar) {
        l0.p(aVar, "f");
        this.f4501f = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(message = "Use builder functions instead.")
    public b(@os.l un.d<S> dVar) {
        this(dVar, vn.g.d(dVar));
        l0.p(dVar, y0.a.f8215h);
    }
}
