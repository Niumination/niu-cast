package y4;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f11051d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Constructor f11052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f11053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f11054c;

    static {
        HashMap map = new HashMap();
        map.put(Byte.TYPE, (byte) 0);
        map.put(Short.TYPE, (short) 0);
        map.put(Integer.TYPE, 0);
        map.put(Long.TYPE, 0L);
        map.put(Float.TYPE, Float.valueOf(0.0f));
        map.put(Double.TYPE, Double.valueOf(0.0d));
        map.put(Character.TYPE, (char) 0);
        map.put(Boolean.TYPE, Boolean.FALSE);
        f11051d = map;
    }

    public f0(Class cls, e0 e0Var, boolean z2) {
        super(e0Var);
        this.f11054c = new HashMap();
        Constructor canonicalRecordConstructor = a5.d.getCanonicalRecordConstructor(cls);
        this.f11052a = canonicalRecordConstructor;
        if (z2) {
            g0.checkAccessible(null, canonicalRecordConstructor);
        } else {
            a5.d.makeAccessible(canonicalRecordConstructor);
        }
        String[] recordComponentNames = a5.d.getRecordComponentNames(cls);
        for (int i8 = 0; i8 < recordComponentNames.length; i8++) {
            this.f11054c.put(recordComponentNames[i8], Integer.valueOf(i8));
        }
        Class<?>[] parameterTypes = this.f11052a.getParameterTypes();
        this.f11053b = new Object[parameterTypes.length];
        for (int i9 = 0; i9 < parameterTypes.length; i9++) {
            this.f11053b[i9] = f11051d.get(parameterTypes[i9]);
        }
    }

    @Override // y4.b0
    public final Object a() {
        return (Object[]) this.f11053b.clone();
    }

    @Override // y4.b0
    public final Object b(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.f11052a;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e) {
            throw a5.d.createExceptionForUnexpectedIllegalAccess(e);
        } catch (IllegalArgumentException | InstantiationException e4) {
            throw new RuntimeException("Failed to invoke constructor '" + a5.d.constructorToString(constructor) + "' with args " + Arrays.toString(objArr), e4);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException("Failed to invoke constructor '" + a5.d.constructorToString(constructor) + "' with args " + Arrays.toString(objArr), e10.getCause());
        }
    }

    @Override // y4.b0
    public final void c(Object obj, d5.b bVar, c0 c0Var) throws IOException {
        Object[] objArr = (Object[]) obj;
        HashMap map = this.f11054c;
        String str = c0Var.f11039c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            throw new IllegalStateException("Could not find the index in the constructor '" + a5.d.constructorToString(this.f11052a) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
        int iIntValue = num.intValue();
        a0 a0Var = (a0) c0Var;
        Object obj2 = a0Var.f11031g.read(bVar);
        if (obj2 != null || !a0Var.f11032h) {
            objArr[iIntValue] = obj2;
            return;
        }
        throw new v4.y("null is not allowed as value for record component '" + a0Var.f11039c + "' of primitive type; at path " + bVar.getPath());
    }
}
