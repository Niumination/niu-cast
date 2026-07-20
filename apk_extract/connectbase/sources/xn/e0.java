package xn;

import java.lang.reflect.Method;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    public static final class a extends n0 implements jn.l<Class<?>, CharSequence> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(Class<?> cls) {
            l0.o(cls, "it");
            return ko.d.b(cls);
        }
    }

    public static final String b(Method method) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(method.getName());
        Class<?>[] parameterTypes = method.getParameterTypes();
        l0.o(parameterTypes, "parameterTypes");
        sb2.append(nm.r.lh(parameterTypes, "", "(", ")", 0, null, a.INSTANCE, 24, null));
        Class<?> returnType = method.getReturnType();
        l0.o(returnType, "returnType");
        sb2.append(ko.d.b(returnType));
        return sb2.toString();
    }
}
