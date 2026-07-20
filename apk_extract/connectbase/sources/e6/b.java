package e6;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    void a(Runnable runnable);

    void b(WeakReference<Runnable> weakReference);

    void c();

    void destroy();

    void shutdown();
}
