package j1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends FutureTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f5949a;

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        try {
            if (isCancelled()) {
                this.f5949a = null;
                return;
            }
            try {
                this.f5949a.d((c0) get());
            } catch (InterruptedException | ExecutionException e) {
                this.f5949a.d(new c0(e));
            }
            this.f5949a = null;
        } catch (Throwable th2) {
            this.f5949a = null;
            throw th2;
        }
    }
}
