package we;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f10727a;

    public i(g handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f10727a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable command) {
        Intrinsics.checkNotNullParameter(command, "command");
        this.f10727a.f(command);
    }
}
