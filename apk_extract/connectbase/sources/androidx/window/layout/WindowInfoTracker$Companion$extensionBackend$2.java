package androidx.window.layout;

import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kn.l0;
import kn.n0;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInfoTracker$Companion$extensionBackend$2 extends n0 implements jn.a<ExtensionWindowLayoutInfoBackend> {
    public static final WindowInfoTracker$Companion$extensionBackend$2 INSTANCE = new WindowInfoTracker$Companion$extensionBackend$2();

    public WindowInfoTracker$Companion$extensionBackend$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // jn.a
    @m
    public final ExtensionWindowLayoutInfoBackend invoke() {
        WindowLayoutComponent windowLayoutComponent;
        try {
            ClassLoader classLoader = WindowInfoTracker.class.getClassLoader();
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = classLoader != null ? new SafeWindowLayoutComponentProvider(classLoader, new ConsumerAdapter(classLoader)) : null;
            if (safeWindowLayoutComponentProvider == null || (windowLayoutComponent = safeWindowLayoutComponentProvider.getWindowLayoutComponent()) == null) {
                return null;
            }
            l0.o(classLoader, "loader");
            return new ExtensionWindowLayoutInfoBackend(windowLayoutComponent, new ConsumerAdapter(classLoader));
        } catch (Throwable unused) {
            if (!WindowInfoTracker.Companion.DEBUG) {
                return null;
            }
            Log.d(WindowInfoTracker.Companion.TAG, "Failed to load WindowExtensions");
            return null;
        }
    }
}
