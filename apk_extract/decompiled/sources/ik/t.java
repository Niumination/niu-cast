package ik;

import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5907a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r7) {
        switch (this.f5907a) {
            case 0:
                throw new AssertionError("No threads allowed.");
            case 1:
                Intrinsics.checkNotNullParameter(r7, "r");
                return new Thread(r7, "TranLanController Polling Thread");
            default:
                Thread thread = new Thread(r7, "Athena Dispatcher");
                thread.setDaemon(false);
                return thread;
        }
    }
}
