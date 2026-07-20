package ul;

import kn.l0;
import lm.y;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jn.a<String> f16322a;

        public a(jn.a<String> aVar) {
            this.f16322a = aVar;
        }

        @Override // ul.h
        @l
        public Void a() {
            throw new IllegalArgumentException(this.f16322a.invoke());
        }
    }

    @z0
    public static final void a(boolean z10, @l jn.a<String> aVar) {
        l0.p(aVar, "message");
        if (z10) {
            return;
        }
        new a(aVar).a();
        throw new y();
    }
}
