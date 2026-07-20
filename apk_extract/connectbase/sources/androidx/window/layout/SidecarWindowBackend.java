package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.SidecarWindowBackend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kn.l0;
import kn.w;
import lm.l2;
import nm.k0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class SidecarWindowBackend implements WindowBackend {
    public static final boolean DEBUG = false;

    @l
    private static final String TAG = "WindowServer";

    @m
    private static volatile SidecarWindowBackend globalInstance;

    @m
    @GuardedBy("globalLock")
    @VisibleForTesting
    private ExtensionInterfaceCompat windowExtension;

    @l
    private final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> windowLayoutChangeCallbacks = new CopyOnWriteArrayList<>();

    @l
    public static final Companion Companion = new Companion(null);

    @l
    private static final ReentrantLock globalLock = new ReentrantLock();

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        @l
        public final SidecarWindowBackend getInstance(@l Context context) {
            l0.p(context, "context");
            if (SidecarWindowBackend.globalInstance == null) {
                ReentrantLock reentrantLock = SidecarWindowBackend.globalLock;
                reentrantLock.lock();
                try {
                    if (SidecarWindowBackend.globalInstance == null) {
                        SidecarWindowBackend.globalInstance = new SidecarWindowBackend(SidecarWindowBackend.Companion.initAndVerifyExtension(context));
                    }
                    l2 l2Var = l2.f10208a;
                    reentrantLock.unlock();
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            }
            SidecarWindowBackend sidecarWindowBackend = SidecarWindowBackend.globalInstance;
            l0.m(sidecarWindowBackend);
            return sidecarWindowBackend;
        }

        @m
        public final ExtensionInterfaceCompat initAndVerifyExtension(@l Context context) {
            l0.p(context, "context");
            try {
                if (!isSidecarVersionSupported(SidecarCompat.Companion.getSidecarVersion())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (sidecarCompat.validateExtensionInterface()) {
                    return sidecarCompat;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @VisibleForTesting
        public final boolean isSidecarVersionSupported(@m Version version) {
            return version != null && version.compareTo(Version.Companion.getVERSION_0_1()) >= 0;
        }

        @VisibleForTesting
        public final void resetInstance() {
            SidecarWindowBackend.globalInstance = null;
        }

        private Companion() {
        }
    }

    @VisibleForTesting
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        public ExtensionListenerImpl() {
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        @b.a({"SyntheticAccessor"})
        public void onWindowLayoutChanged(@l Activity activity, @l WindowLayoutInfo windowLayoutInfo) {
            l0.p(activity, "activity");
            l0.p(windowLayoutInfo, "newLayout");
            for (WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper : SidecarWindowBackend.this.getWindowLayoutChangeCallbacks()) {
                if (l0.g(windowLayoutChangeCallbackWrapper.getActivity(), activity)) {
                    windowLayoutChangeCallbackWrapper.accept(windowLayoutInfo);
                }
            }
        }
    }

    public static final class WindowLayoutChangeCallbackWrapper {

        @l
        private final Activity activity;

        @l
        private final Consumer<WindowLayoutInfo> callback;

        @l
        private final Executor executor;

        @m
        private WindowLayoutInfo lastInfo;

        public WindowLayoutChangeCallbackWrapper(@l Activity activity, @l Executor executor, @l Consumer<WindowLayoutInfo> consumer) {
            l0.p(activity, "activity");
            l0.p(executor, "executor");
            l0.p(consumer, "callback");
            this.activity = activity;
            this.executor = executor;
            this.callback = consumer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: accept$lambda-0, reason: not valid java name */
        public static final void m13accept$lambda0(WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
            l0.p(windowLayoutChangeCallbackWrapper, "this$0");
            l0.p(windowLayoutInfo, "$newLayoutInfo");
            windowLayoutChangeCallbackWrapper.callback.accept(windowLayoutInfo);
        }

        public final void accept(@l final WindowLayoutInfo windowLayoutInfo) {
            l0.p(windowLayoutInfo, "newLayoutInfo");
            this.lastInfo = windowLayoutInfo;
            this.executor.execute(new Runnable() { // from class: l0.a
                @Override // java.lang.Runnable
                public final void run() {
                    SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m13accept$lambda0(this.f9497a, windowLayoutInfo);
                }
            });
        }

        @l
        public final Activity getActivity() {
            return this.activity;
        }

        @l
        public final Consumer<WindowLayoutInfo> getCallback() {
            return this.callback;
        }

        @m
        public final WindowLayoutInfo getLastInfo() {
            return this.lastInfo;
        }

        public final void setLastInfo(@m WindowLayoutInfo windowLayoutInfo) {
            this.lastInfo = windowLayoutInfo;
        }
    }

    @VisibleForTesting
    public SidecarWindowBackend(@m ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.windowExtension = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.windowExtension;
        if (extensionInterfaceCompat2 != null) {
            extensionInterfaceCompat2.setExtensionCallback(new ExtensionListenerImpl());
        }
    }

    @GuardedBy("sLock")
    private final void callbackRemovedForActivity(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.windowLayoutChangeCallbacks;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (l0.g(((WindowLayoutChangeCallbackWrapper) it.next()).getActivity(), activity)) {
                    return;
                }
            }
        }
        ExtensionInterfaceCompat extensionInterfaceCompat = this.windowExtension;
        if (extensionInterfaceCompat != null) {
            extensionInterfaceCompat.onWindowLayoutChangeListenerRemoved(activity);
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getWindowLayoutChangeCallbacks$annotations() {
    }

    private final boolean isActivityRegistered(Activity activity) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.windowLayoutChangeCallbacks;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (l0.g(((WindowLayoutChangeCallbackWrapper) it.next()).getActivity(), activity)) {
                return true;
            }
        }
        return false;
    }

    @m
    public final ExtensionInterfaceCompat getWindowExtension() {
        return this.windowExtension;
    }

    @l
    public final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> getWindowLayoutChangeCallbacks() {
        return this.windowLayoutChangeCallbacks;
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(@l Activity activity, @l Executor executor, @l Consumer<WindowLayoutInfo> consumer) {
        Object next;
        l0.p(activity, "activity");
        l0.p(executor, "executor");
        l0.p(consumer, "callback");
        ReentrantLock reentrantLock = globalLock;
        reentrantLock.lock();
        try {
            ExtensionInterfaceCompat extensionInterfaceCompat = this.windowExtension;
            if (extensionInterfaceCompat == null) {
                consumer.accept(new WindowLayoutInfo(k0.INSTANCE));
                return;
            }
            boolean zIsActivityRegistered = isActivityRegistered(activity);
            WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(activity, executor, consumer);
            this.windowLayoutChangeCallbacks.add(windowLayoutChangeCallbackWrapper);
            if (zIsActivityRegistered) {
                Iterator<T> it = this.windowLayoutChangeCallbacks.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!l0.g(activity, ((WindowLayoutChangeCallbackWrapper) next).getActivity()));
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) next;
                WindowLayoutInfo lastInfo = windowLayoutChangeCallbackWrapper2 != null ? windowLayoutChangeCallbackWrapper2.getLastInfo() : null;
                if (lastInfo != null) {
                    windowLayoutChangeCallbackWrapper.accept(lastInfo);
                }
            } else {
                extensionInterfaceCompat.onWindowLayoutChangeListenerAdded(activity);
            }
            l2 l2Var = l2.f10208a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setWindowExtension(@m ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.windowExtension = extensionInterfaceCompat;
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(@l Consumer<WindowLayoutInfo> consumer) {
        l0.p(consumer, "callback");
        synchronized (globalLock) {
            try {
                if (this.windowExtension == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper : this.windowLayoutChangeCallbacks) {
                    if (windowLayoutChangeCallbackWrapper.getCallback() == consumer) {
                        l0.o(windowLayoutChangeCallbackWrapper, "callbackWrapper");
                        arrayList.add(windowLayoutChangeCallbackWrapper);
                    }
                }
                this.windowLayoutChangeCallbacks.removeAll(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    callbackRemovedForActivity(((WindowLayoutChangeCallbackWrapper) it.next()).getActivity());
                }
                l2 l2Var = l2.f10208a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
