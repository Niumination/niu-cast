package fg;

import java.nio.channels.SelectableChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class t implements s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5048d = AtomicIntegerFieldUpdater.newUpdater(t.class, "_interestedOps");
    private volatile /* synthetic */ int _interestedOps;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractSelectableChannel f5049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f5050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f5051c;

    public t(AbstractSelectableChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.f5049a = channel;
        this.f5050b = new AtomicBoolean(false);
        this.f5051c = new m();
        this._interestedOps = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f5050b.compareAndSet(false, true)) {
            this._interestedOps = 0;
            m mVar = this.f5051c;
            r.Companion.getClass();
            for (r interest : r.AllInterests) {
                mVar.getClass();
                Intrinsics.checkNotNullParameter(interest, "interest");
                li.j jVar = (li.j) m.f5041a[interest.ordinal()].getAndSet(mVar, null);
                if (jVar != null) {
                    Result.Companion companion = Result.INSTANCE;
                    jVar.resumeWith(Result.m159constructorimpl(ResultKt.createFailure(new f())));
                }
            }
        }
    }

    @Override // li.x0
    public void dispose() {
        close();
    }

    @Override // fg.s
    public final boolean isClosed() {
        return this.f5050b.get();
    }

    @Override // fg.s
    public final m p() {
        return this.f5051c;
    }

    @Override // fg.s
    public final void q(r interest, boolean z2) {
        int i8;
        Intrinsics.checkNotNullParameter(interest, "interest");
        int flag = interest.getFlag();
        do {
            i8 = this._interestedOps;
        } while (!f5048d.compareAndSet(this, i8, z2 ? i8 | flag : (~flag) & i8));
    }

    @Override // fg.s
    public SelectableChannel u() {
        return this.f5049a;
    }

    @Override // fg.s
    public final int y() {
        return this._interestedOps;
    }
}
