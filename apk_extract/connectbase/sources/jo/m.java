package jo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final m f8770a = new m();

    @os.l
    public final String a(@os.l Constructor<?> constructor) {
        l0.p(constructor, "constructor");
        StringBuilder sb2 = new StringBuilder("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        l0.o(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i10 = 0;
        while (i10 < length) {
            Class<?> cls = parameterTypes[i10];
            i10++;
            l0.o(cls, "parameterType");
            sb2.append(ko.d.b(cls));
        }
        sb2.append(")V");
        String string = sb2.toString();
        l0.o(string, "sb.toString()");
        return string;
    }

    @os.l
    public final String b(@os.l Field field) {
        l0.p(field, "field");
        Class<?> type = field.getType();
        l0.o(type, "field.type");
        return ko.d.b(type);
    }

    @os.l
    public final String c(@os.l Method method) {
        l0.p(method, "method");
        StringBuilder sb2 = new StringBuilder("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        l0.o(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i10 = 0;
        while (i10 < length) {
            Class<?> cls = parameterTypes[i10];
            i10++;
            l0.o(cls, "parameterType");
            sb2.append(ko.d.b(cls));
        }
        sb2.append(")");
        Class<?> returnType = method.getReturnType();
        l0.o(returnType, "method.returnType");
        sb2.append(ko.d.b(returnType));
        String string = sb2.toString();
        l0.o(string, "sb.toString()");
        return string;
    }
}
