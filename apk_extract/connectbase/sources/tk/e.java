package tk;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kn.l0;
import kn.n0;
import lm.l2;
import nq.s0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f15787a = Long.MAX_VALUE;

    public static final class a extends n0 implements jn.a<Long> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final Long invoke() {
            return Long.valueOf(kl.a.d());
        }
    }

    @l
    public static final d a(@l s0 s0Var, @l String str, long j10, @l jn.a<Long> aVar, @l jn.l<? super um.d<? super l2>, ? extends Object> lVar) {
        l0.p(s0Var, "<this>");
        l0.p(str, "name");
        l0.p(aVar, RtspHeaders.Values.CLOCK);
        l0.p(lVar, "onTimeout");
        return new d(str, j10, aVar, s0Var, lVar);
    }

    public static /* synthetic */ d b(s0 s0Var, String str, long j10, jn.a aVar, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i10 & 4) != 0) {
            aVar = a.INSTANCE;
        }
        return a(s0Var, str2, j10, aVar, lVar);
    }

    public static final <T> T c(@m d dVar, @l jn.a<? extends T> aVar) {
        l0.p(aVar, "block");
        if (dVar == null) {
            return aVar.invoke();
        }
        dVar.f();
        try {
            return aVar.invoke();
        } finally {
            dVar.isStarted = 0;
        }
    }
}
