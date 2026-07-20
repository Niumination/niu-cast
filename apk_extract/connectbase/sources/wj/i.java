package wj;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f18725a = new AtomicLong();

    @Override // wj.l1
    public void add(long j10) {
        this.f18725a.getAndAdd(j10);
    }

    @Override // wj.l1
    public long value() {
        return this.f18725a.get();
    }
}
