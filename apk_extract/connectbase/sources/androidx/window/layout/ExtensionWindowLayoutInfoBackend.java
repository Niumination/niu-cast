package androidx.window.layout;

import android.app.Activity;
import androidx.annotation.GuardedBy;
import androidx.core.util.Consumer;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kn.l0;
import kn.l1;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class ExtensionWindowLayoutInfoBackend implements WindowBackend {

    @GuardedBy("lock")
    @l
    private final Map<Activity, MulticastConsumer> activityToListeners;

    @l
    private final WindowLayoutComponent component;

    @l
    private final ConsumerAdapter consumerAdapter;

    @GuardedBy("lock")
    @l
    private final Map<MulticastConsumer, ConsumerAdapter.Subscription> consumerToToken;

    @l
    private final ReentrantLock extensionWindowBackendLock;

    @GuardedBy("lock")
    @l
    private final Map<Consumer<WindowLayoutInfo>, Activity> listenerToActivity;

    public static final class MulticastConsumer implements Consumer<androidx.window.extensions.layout.WindowLayoutInfo> {

        @l
        private final Activity activity;

        @m
        @GuardedBy("lock")
        private WindowLayoutInfo lastKnownValue;

        @l
        private final ReentrantLock multicastConsumerLock;

        @GuardedBy("lock")
        @l
        private final Set<Consumer<WindowLayoutInfo>> registeredListeners;

        public MulticastConsumer(@l Activity activity) {
            l0.p(activity, "activity");
            this.activity = activity;
            this.multicastConsumerLock = new ReentrantLock();
            this.registeredListeners = new LinkedHashSet();
        }

        public final void addListener(@l Consumer<WindowLayoutInfo> consumer) {
            l0.p(consumer, "listener");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                WindowLayoutInfo windowLayoutInfo = this.lastKnownValue;
                if (windowLayoutInfo != null) {
                    consumer.accept(windowLayoutInfo);
                }
                this.registeredListeners.add(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean isEmpty() {
            return this.registeredListeners.isEmpty();
        }

        public final void removeListener(@l Consumer<WindowLayoutInfo> consumer) {
            l0.p(consumer, "listener");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                this.registeredListeners.remove(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // androidx.core.util.Consumer
        public void accept(@l androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo) {
            l0.p(windowLayoutInfo, "value");
            ReentrantLock reentrantLock = this.multicastConsumerLock;
            reentrantLock.lock();
            try {
                this.lastKnownValue = ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(this.activity, windowLayoutInfo);
                Iterator<T> it = this.registeredListeners.iterator();
                while (it.hasNext()) {
                    ((Consumer) it.next()).accept(this.lastKnownValue);
                }
                l2 l2Var = l2.f10208a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public ExtensionWindowLayoutInfoBackend(@l WindowLayoutComponent windowLayoutComponent, @l ConsumerAdapter consumerAdapter) {
        l0.p(windowLayoutComponent, "component");
        l0.p(consumerAdapter, "consumerAdapter");
        this.component = windowLayoutComponent;
        this.consumerAdapter = consumerAdapter;
        this.extensionWindowBackendLock = new ReentrantLock();
        this.activityToListeners = new LinkedHashMap();
        this.listenerToActivity = new LinkedHashMap();
        this.consumerToToken = new LinkedHashMap();
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(@l Activity activity, @l Executor executor, @l Consumer<WindowLayoutInfo> consumer) {
        l2 l2Var;
        l0.p(activity, "activity");
        l0.p(executor, "executor");
        l0.p(consumer, "callback");
        ReentrantLock reentrantLock = this.extensionWindowBackendLock;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = this.activityToListeners.get(activity);
            if (multicastConsumer != null) {
                multicastConsumer.addListener(consumer);
                this.listenerToActivity.put(consumer, activity);
                l2Var = l2.f10208a;
            } else {
                l2Var = null;
            }
            if (l2Var == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(activity);
                this.activityToListeners.put(activity, multicastConsumer2);
                this.listenerToActivity.put(consumer, activity);
                multicastConsumer2.addListener(consumer);
                this.consumerToToken.put(multicastConsumer2, this.consumerAdapter.createSubscription(this.component, l1.d(androidx.window.extensions.layout.WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", activity, new ExtensionWindowLayoutInfoBackend$registerLayoutChangeCallback$1$2$disposableToken$1(multicastConsumer2)));
            }
            l2 l2Var2 = l2.f10208a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(@l Consumer<WindowLayoutInfo> consumer) {
        l0.p(consumer, "callback");
        ReentrantLock reentrantLock = this.extensionWindowBackendLock;
        reentrantLock.lock();
        try {
            Activity activity = this.listenerToActivity.get(consumer);
            if (activity == null) {
                return;
            }
            MulticastConsumer multicastConsumer = this.activityToListeners.get(activity);
            if (multicastConsumer == null) {
                return;
            }
            multicastConsumer.removeListener(consumer);
            if (multicastConsumer.isEmpty()) {
                ConsumerAdapter.Subscription subscriptionRemove = this.consumerToToken.remove(multicastConsumer);
                if (subscriptionRemove != null) {
                    subscriptionRemove.dispose();
                }
                this.listenerToActivity.remove(consumer);
                this.activityToListeners.remove(activity);
            }
            l2 l2Var = l2.f10208a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
