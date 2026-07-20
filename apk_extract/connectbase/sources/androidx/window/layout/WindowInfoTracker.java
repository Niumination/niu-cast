package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.RestrictTo;
import in.i;
import in.n;
import kn.l0;
import kn.l1;
import lm.d0;
import lm.f0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public interface WindowInfoTracker {

    @l
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        private static final boolean DEBUG = false;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @m
        private static final String TAG = l1.d(WindowInfoTracker.class).w();

        @l
        private static final d0<ExtensionWindowLayoutInfoBackend> extensionBackend$delegate = f0.b(WindowInfoTracker$Companion$extensionBackend$2.INSTANCE);

        @l
        private static WindowInfoTrackerDecorator decorator = EmptyDecorator.INSTANCE;

        private Companion() {
        }

        public static /* synthetic */ void getExtensionBackend$window_release$annotations() {
        }

        @m
        public final WindowBackend getExtensionBackend$window_release() {
            return extensionBackend$delegate.getValue();
        }

        @n
        @i(name = "getOrCreate")
        @l
        public final WindowInfoTracker getOrCreate(@l Context context) {
            l0.p(context, "context");
            WindowBackend extensionBackend$window_release = getExtensionBackend$window_release();
            if (extensionBackend$window_release == null) {
                extensionBackend$window_release = SidecarWindowBackend.Companion.getInstance(context);
            }
            return decorator.decorate(new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.INSTANCE, extensionBackend$window_release));
        }

        @n
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void overrideDecorator(@l WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
            l0.p(windowInfoTrackerDecorator, "overridingDecorator");
            decorator = windowInfoTrackerDecorator;
        }

        @n
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void reset() {
            decorator = EmptyDecorator.INSTANCE;
        }
    }

    @n
    @i(name = "getOrCreate")
    @l
    static WindowInfoTracker getOrCreate(@l Context context) {
        return Companion.getOrCreate(context);
    }

    @n
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static void overrideDecorator(@l WindowInfoTrackerDecorator windowInfoTrackerDecorator) {
        Companion.overrideDecorator(windowInfoTrackerDecorator);
    }

    @n
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static void reset() {
        Companion.reset();
    }

    @l
    sq.i<WindowLayoutInfo> windowLayoutInfo(@l Activity activity);
}
