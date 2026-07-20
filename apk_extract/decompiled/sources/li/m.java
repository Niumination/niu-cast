package li;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7476c = AtomicIntegerFieldUpdater.newUpdater(m.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public m(l lVar, Throwable th2, boolean z2) {
        if (th2 == null) {
            th2 = new CancellationException("Continuation " + lVar + " was cancelled normally");
        }
        super(z2, th2);
        this._resumed$volatile = 0;
    }
}
