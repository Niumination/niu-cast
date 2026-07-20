package r0;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f9243a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f9243a.post(runnable);
    }
}
