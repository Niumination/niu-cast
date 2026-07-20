package jh;

import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.p1;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f6311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g2 f6312b;

    public y0(k channel, g2 job) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(job, "job");
        this.f6311a = channel;
        this.f6312b = job;
    }

    @Override // jh.q0
    public final p1 a() {
        return this.f6312b;
    }
}
