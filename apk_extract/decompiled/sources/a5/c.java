package a5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f36a = Class.class.getMethod("isRecord", null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f37b = Class.class.getMethod("getRecordComponents", null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f38c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f39d;

    public c() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.f38c = cls.getMethod("getName", null);
        this.f39d = cls.getMethod("getType", null);
    }

    @Override // a5.a
    public final Method a(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e) {
            throw d.createExceptionForRecordReflectionException(e);
        }
    }

    @Override // a5.a
    public final Constructor b(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f37b.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i8 = 0; i8 < objArr.length; i8++) {
                clsArr[i8] = (Class) this.f39d.invoke(objArr[i8], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e) {
            throw d.createExceptionForRecordReflectionException(e);
        }
    }

    @Override // a5.a
    public final String[] c(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f37b.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i8 = 0; i8 < objArr.length; i8++) {
                strArr[i8] = (String) this.f38c.invoke(objArr[i8], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e) {
            throw d.createExceptionForRecordReflectionException(e);
        }
    }

    @Override // a5.a
    public final boolean d(Class cls) {
        try {
            return ((Boolean) this.f36a.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e) {
            throw d.createExceptionForRecordReflectionException(e);
        }
    }
}
