package x1;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static final p INSTANCE = create();

    public class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f19992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f19993b;

        public a(Method method, Object obj) {
            this.f19992a = method;
            this.f19993b = obj;
        }

        @Override // x1.p
        public <T> T newInstance(Class<T> cls) throws Exception {
            p.assertInstantiable(cls);
            return (T) this.f19992a.invoke(this.f19993b, cls);
        }
    }

    public class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f19994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f19995b;

        public b(Method method, int i10) {
            this.f19994a = method;
            this.f19995b = i10;
        }

        @Override // x1.p
        public <T> T newInstance(Class<T> cls) throws Exception {
            p.assertInstantiable(cls);
            return (T) this.f19994a.invoke(null, cls, Integer.valueOf(this.f19995b));
        }
    }

    public class c extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f19996a;

        public c(Method method) {
            this.f19996a = method;
        }

        @Override // x1.p
        public <T> T newInstance(Class<T> cls) throws Exception {
            p.assertInstantiable(cls);
            return (T) this.f19996a.invoke(null, cls, Object.class);
        }
    }

    public class d extends p {
        @Override // x1.p
        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertInstantiable(Class<?> cls) {
        String strA = x1.c.a(cls);
        if (strA != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
        }
    }

    private static p create() {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    return new d();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new c(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            return new b(declaredMethod3, iIntValue);
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
