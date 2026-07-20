package androidx.window.embedding;

import android.app.Activity;
import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kn.l0;
import kn.l1;
import kn.n0;
import kn.w;
import lm.l2;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class EmbeddingCompat implements EmbeddingInterfaceCompat {

    @l
    public static final Companion Companion = new Companion(null);
    public static final boolean DEBUG = true;

    @l
    private static final String TAG = "EmbeddingCompat";

    @l
    private final EmbeddingAdapter adapter;

    @l
    private final ConsumerAdapter consumerAdapter;

    @l
    private final ActivityEmbeddingComponent embeddingExtension;

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: embeddingComponent$lambda-0, reason: not valid java name */
        public static final l2 m10embeddingComponent$lambda0(Object obj, Method method, Object[] objArr) {
            return l2.f10208a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: embeddingComponent$lambda-1, reason: not valid java name */
        public static final l2 m11embeddingComponent$lambda1(Object obj, Method method, Object[] objArr) {
            return l2.f10208a;
        }

        @l
        public final ActivityEmbeddingComponent embeddingComponent() {
            if (!isEmbeddingAvailable()) {
                Object objNewProxyInstance = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new InvocationHandler() { // from class: k0.b
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method, Object[] objArr) {
                        return EmbeddingCompat.Companion.m11embeddingComponent$lambda1(obj, method, objArr);
                    }
                });
                if (objNewProxyInstance != null) {
                    return (ActivityEmbeddingComponent) objNewProxyInstance;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
            }
            ActivityEmbeddingComponent activityEmbeddingComponent = WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent();
            if (activityEmbeddingComponent != null) {
                return activityEmbeddingComponent;
            }
            Object objNewProxyInstance2 = Proxy.newProxyInstance(EmbeddingCompat.class.getClassLoader(), new Class[]{ActivityEmbeddingComponent.class}, new InvocationHandler() { // from class: k0.a
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return EmbeddingCompat.Companion.m10embeddingComponent$lambda0(obj, method, objArr);
                }
            });
            if (objNewProxyInstance2 != null) {
                return (ActivityEmbeddingComponent) objNewProxyInstance2;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.extensions.embedding.ActivityEmbeddingComponent");
        }

        @m
        public final Integer getExtensionApiLevel() {
            try {
                return Integer.valueOf(WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel());
            } catch (NoClassDefFoundError unused) {
                Log.d(EmbeddingCompat.TAG, "Embedding extension version not found");
                return null;
            } catch (UnsupportedOperationException unused2) {
                Log.d(EmbeddingCompat.TAG, "Stub Extension");
                return null;
            }
        }

        public final boolean isEmbeddingAvailable() {
            try {
                return WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent() != null;
            } catch (NoClassDefFoundError unused) {
                Log.d(EmbeddingCompat.TAG, "Embedding extension version not found");
                return false;
            } catch (UnsupportedOperationException unused2) {
                Log.d(EmbeddingCompat.TAG, "Stub Extension");
                return false;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.window.embedding.EmbeddingCompat$setEmbeddingCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 extends n0 implements jn.l<List<?>, l2> {
        final /* synthetic */ EmbeddingInterfaceCompat.EmbeddingCallbackInterface $embeddingCallback;
        final /* synthetic */ EmbeddingCompat this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface, EmbeddingCompat embeddingCompat) {
            super(1);
            this.$embeddingCallback = embeddingCallbackInterface;
            this.this$0 = embeddingCompat;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(List<?> list) {
            invoke2(list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@l List<?> list) {
            l0.p(list, "values");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof androidx.window.extensions.embedding.SplitInfo) {
                    arrayList.add(obj);
                }
            }
            this.$embeddingCallback.onSplitInfoChanged(this.this$0.adapter.translate(arrayList));
        }
    }

    public EmbeddingCompat(@l ActivityEmbeddingComponent activityEmbeddingComponent, @l EmbeddingAdapter embeddingAdapter, @l ConsumerAdapter consumerAdapter) {
        l0.p(activityEmbeddingComponent, "embeddingExtension");
        l0.p(embeddingAdapter, "adapter");
        l0.p(consumerAdapter, "consumerAdapter");
        this.embeddingExtension = activityEmbeddingComponent;
        this.adapter = embeddingAdapter;
        this.consumerAdapter = consumerAdapter;
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public boolean isActivityEmbedded(@l Activity activity) {
        l0.p(activity, "activity");
        return this.embeddingExtension.isActivityEmbedded(activity);
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public void setEmbeddingCallback(@l EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallbackInterface) throws IllegalAccessException, InvocationTargetException {
        l0.p(embeddingCallbackInterface, "embeddingCallback");
        this.consumerAdapter.addConsumer(this.embeddingExtension, l1.d(List.class), "setSplitInfoCallback", new AnonymousClass1(embeddingCallbackInterface, this));
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public void setSplitRules(@l Set<? extends EmbeddingRule> set) {
        l0.p(set, "rules");
        this.embeddingExtension.setEmbeddingRules(this.adapter.translate(set));
    }
}
