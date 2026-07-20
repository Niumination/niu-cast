package x1;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import v1.w;

/* JADX INFO: loaded from: classes.dex */
public class n {

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19986a;

        public class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f19987b;

            public a(Method method) {
                this.f19987b = method;
            }

            @Override // x1.n.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f19987b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* JADX INFO: renamed from: x1.n$b$b, reason: collision with other inner class name */
        public class C0497b extends b {
            @Override // x1.n.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (f.isJava9OrLater()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C0497b();
            }
            f19986a = aVar;
        }

        public b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);

        public b(a aVar) {
        }
    }

    private n() {
    }

    public static boolean canAccess(AccessibleObject accessibleObject, Object obj) {
        return b.f19986a.a(accessibleObject, obj);
    }

    public static w.e getFilterResult(List<w> list, Class<?> cls) {
        Iterator<w> it = list.iterator();
        while (it.hasNext()) {
            w.e eVarCheck = it.next().check(cls);
            if (eVarCheck != w.e.INDECISIVE) {
                return eVarCheck;
            }
        }
        return w.e.ALLOW;
    }

    public static boolean isAndroidType(Class<?> cls) {
        return isAndroidType(cls.getName());
    }

    public static boolean isAnyPlatformType(Class<?> cls) {
        String name = cls.getName();
        return isAndroidType(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static boolean isJavaType(Class<?> cls) {
        return isJavaType(cls.getName());
    }

    private static boolean isAndroidType(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || isJavaType(str);
    }

    private static boolean isJavaType(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }
}
