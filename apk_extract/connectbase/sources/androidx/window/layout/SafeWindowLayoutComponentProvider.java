package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import in.b;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import os.l;
import os.m;
import un.d;

/* JADX INFO: loaded from: classes.dex */
public final class SafeWindowLayoutComponentProvider {

    @l
    private final ConsumerAdapter consumerAdapter;

    @l
    private final ClassLoader loader;

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1, reason: invalid class name */
    public static final class AnonymousClass1 extends n0 implements jn.a<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:15:0x006c  */
        @Override // jn.a
        @l
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            boolean z10;
            Class foldingFeatureClass = SafeWindowLayoutComponentProvider.this.getFoldingFeatureClass();
            Method method = foldingFeatureClass.getMethod("getBounds", null);
            Method method2 = foldingFeatureClass.getMethod("getType", null);
            Method method3 = foldingFeatureClass.getMethod("getState", null);
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.this;
            l0.o(method, "getBoundsMethod");
            if (safeWindowLayoutComponentProvider.doesReturn(method, (d<?>) l1.d(Rect.class)) && SafeWindowLayoutComponentProvider.this.isPublic(method)) {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.this;
                l0.o(method2, "getTypeMethod");
                Class cls = Integer.TYPE;
                m1 m1Var = l1.f9319a;
                if (safeWindowLayoutComponentProvider2.doesReturn(method2, (d<?>) m1Var.d(cls)) && SafeWindowLayoutComponentProvider.this.isPublic(method2)) {
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.this;
                    l0.o(method3, "getStateMethod");
                    if (safeWindowLayoutComponentProvider3.doesReturn(method3, (d<?>) m1Var.d(cls)) && SafeWindowLayoutComponentProvider.this.isPublic(method3)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } else {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06331 extends n0 implements jn.a<Boolean> {
        public C06331() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Method method = SafeWindowLayoutComponentProvider.this.getWindowExtensionsClass().getMethod("getWindowLayoutComponent", null);
            Class windowLayoutComponentClass = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass();
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.this;
            l0.o(method, "getWindowLayoutComponentMethod");
            return Boolean.valueOf(safeWindowLayoutComponentProvider.isPublic(method) && SafeWindowLayoutComponentProvider.this.doesReturn(method, (Class<?>) windowLayoutComponentClass));
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06341 extends n0 implements jn.a<Boolean> {
        public C06341() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:11:0x0047  */
        @Override // jn.a
        @l
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            boolean z10;
            Class<?> clsConsumerClassOrNull$window_release = SafeWindowLayoutComponentProvider.this.consumerAdapter.consumerClassOrNull$window_release();
            if (clsConsumerClassOrNull$window_release == null) {
                return Boolean.FALSE;
            }
            Class windowLayoutComponentClass = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass();
            Method method = windowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", Activity.class, clsConsumerClassOrNull$window_release);
            Method method2 = windowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", clsConsumerClassOrNull$window_release);
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.this;
            l0.o(method, "addListenerMethod");
            if (safeWindowLayoutComponentProvider.isPublic(method)) {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.this;
                l0.o(method2, "removeListenerMethod");
                if (safeWindowLayoutComponentProvider2.isPublic(method2)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06351 extends n0 implements jn.a<Boolean> {
        public C06351() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @l
        public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
            Method declaredMethod = SafeWindowLayoutComponentProvider.this.getWindowExtensionsProviderClass().getDeclaredMethod("getWindowExtensions", null);
            Class windowExtensionsClass = SafeWindowLayoutComponentProvider.this.getWindowExtensionsClass();
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.this;
            l0.o(declaredMethod, "getWindowExtensionsMethod");
            return Boolean.valueOf(safeWindowLayoutComponentProvider.doesReturn(declaredMethod, (Class<?>) windowExtensionsClass) && SafeWindowLayoutComponentProvider.this.isPublic(declaredMethod));
        }
    }

    public SafeWindowLayoutComponentProvider(@l ClassLoader classLoader, @l ConsumerAdapter consumerAdapter) {
        l0.p(classLoader, "loader");
        l0.p(consumerAdapter, "consumerAdapter");
        this.loader = classLoader;
        this.consumerAdapter = consumerAdapter;
    }

    private final boolean canUseWindowLayoutComponent() {
        return isWindowLayoutProviderValid() && isWindowExtensionsValid() && isWindowLayoutComponentValid() && isFoldingFeatureValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, d<?> dVar) {
        return doesReturn(method, b.e(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getFoldingFeatureClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("androidx.window.extensions.layout.FoldingFeature");
        l0.o(clsLoadClass, "loader.loadClass(\"androi…s.layout.FoldingFeature\")");
        return clsLoadClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getWindowExtensionsClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("androidx.window.extensions.WindowExtensions");
        l0.o(clsLoadClass, "loader.loadClass(\"androi…nsions.WindowExtensions\")");
        return clsLoadClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getWindowExtensionsProviderClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        l0.o(clsLoadClass, "loader.loadClass(\"androi…indowExtensionsProvider\")");
        return clsLoadClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getWindowLayoutComponentClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        l0.o(clsLoadClass, "loader.loadClass(\"androi…t.WindowLayoutComponent\")");
        return clsLoadClass;
    }

    private final boolean isFoldingFeatureValid() {
        return validate(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPublic(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private final boolean isWindowExtensionsValid() {
        return validate(new C06331());
    }

    private final boolean isWindowLayoutComponentValid() {
        return validate(new C06341());
    }

    private final boolean isWindowLayoutProviderValid() {
        return validate(new C06351());
    }

    private final boolean validate(jn.a<Boolean> aVar) {
        try {
            return aVar.invoke().booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    @m
    public final WindowLayoutComponent getWindowLayoutComponent() {
        if (!canUseWindowLayoutComponent()) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }
}
