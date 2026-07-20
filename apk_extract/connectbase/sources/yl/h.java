package yl;

import kn.l0;
import lm.y;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements f<Thread> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final h f21460a = new h();

    @Override // yl.f
    public void a(long j10) {
        d();
        throw new y();
    }

    public final Void d() {
        throw new UnsupportedOperationException("Parking is prohibited on this thread. Most likely you are using blocking operation on the wrong thread/dispatcher that doesn't allow blocking. Consider wrapping you blocking code withContext(Dispatchers.IO) {...}.");
    }

    @Override // yl.f
    @l
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Thread b() {
        d();
        throw new y();
    }

    @Override // yl.f
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void c(@l Thread thread) {
        l0.p(thread, "token");
        c.f21447a.c(thread);
    }
}
