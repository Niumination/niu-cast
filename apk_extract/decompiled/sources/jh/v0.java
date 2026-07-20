package jh;

import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f6306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g2 f6307b;

    public v0(k channel, g2 job) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(job, "job");
        this.f6306a = channel;
        this.f6307b = job;
    }

    @Override // jh.q0
    public final p1 a() {
        return this.f6307b;
    }
}
