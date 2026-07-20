package sk;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.SocketOption;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import nm.c1;
import nm.d1;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g0 f15127a = new g0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final Map<String, Field> f15128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public static final Method f15129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public static final Method f15130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public static final Method f15131e;

    static {
        Map mapZ;
        Method method;
        Method method2;
        Class<?> cls;
        Method[] methods;
        int length;
        int i10;
        Class<?> cls2;
        Method[] methods2;
        int length2;
        int i11;
        Method method3 = null;
        try {
            try {
                try {
                    Field[] fields = Class.forName("java.net.StandardSocketOptions").getFields();
                    if (fields == null) {
                        mapZ = null;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        int length3 = fields.length;
                        int i12 = 0;
                        while (i12 < length3) {
                            Field field = fields[i12];
                            i12++;
                            int modifiers = field.getModifiers();
                            if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isPublic(modifiers)) {
                                arrayList.add(field);
                            }
                        }
                        int iJ = c1.j(nm.z.b0(arrayList, 10));
                        if (iJ < 16) {
                            iJ = 16;
                        }
                        mapZ = new LinkedHashMap(iJ);
                        for (Object obj : arrayList) {
                            String name = ((Field) obj).getName();
                            kn.l0.o(name, "it.name");
                            mapZ.put(name, obj);
                        }
                    }
                    if (mapZ == null) {
                        mapZ = d1.z();
                    }
                    while (true) {
                        if (i11 >= length2) {
                            method = null;
                            break;
                        }
                        method = methods2[i11];
                        i11++;
                        int modifiers2 = method.getModifiers();
                        if (Modifier.isPublic(modifiers2) && !Modifier.isStatic(modifiers2) && kn.l0.g(method.getName(), "setOption") && method.getParameterTypes().length == 2 && kn.l0.g(method.getReturnType(), cls2) && kn.l0.g(method.getParameterTypes()[0], SocketOption.class) && kn.l0.g(method.getParameterTypes()[1], Object.class)) {
                            break;
                        }
                    }
                    while (true) {
                        if (i10 >= length) {
                            method2 = null;
                            break;
                        }
                        method2 = methods[i10];
                        i10++;
                        int modifiers3 = method2.getModifiers();
                        if (Modifier.isPublic(modifiers3) && !Modifier.isStatic(modifiers3) && kn.l0.g(method2.getName(), "setOption") && method2.getParameterTypes().length == 2 && kn.l0.g(method2.getReturnType(), cls) && kn.l0.g(method2.getParameterTypes()[0], SocketOption.class) && kn.l0.g(method2.getParameterTypes()[1], Object.class)) {
                            break;
                        }
                    }
                } catch (Throwable unused) {
                    mapZ = d1.z();
                }
                kn.l0.m(SocketOption.class);
                cls = Class.forName("java.nio.channels.ServerSocketChannel");
                methods = cls.getMethods();
                kn.l0.o(methods, "socketChannelClass.methods");
                length = methods.length;
                i10 = 0;
            } catch (Throwable unused2) {
            }
            kn.l0.m(SocketOption.class);
            cls2 = Class.forName("java.nio.channels.SocketChannel");
            methods2 = cls2.getMethods();
            kn.l0.o(methods2, "socketChannelClass.methods");
            length2 = methods2.length;
            i11 = 0;
        } catch (Throwable unused3) {
        }
        f15128b = mapZ;
        f15129c = method;
        f15130d = method2;
        try {
            kn.l0.m(SocketOption.class);
            Class<?> cls3 = Class.forName("java.nio.channels.DatagramChannel");
            Method[] methods3 = cls3.getMethods();
            kn.l0.o(methods3, "socketChannelClass.methods");
            int length4 = methods3.length;
            int i13 = 0;
            while (i13 < length4) {
                Method method4 = methods3[i13];
                i13++;
                int modifiers4 = method4.getModifiers();
                if (Modifier.isPublic(modifiers4) && !Modifier.isStatic(modifiers4) && kn.l0.g(method4.getName(), "setOption") && method4.getParameterTypes().length == 2 && kn.l0.g(method4.getReturnType(), cls3) && kn.l0.g(method4.getParameterTypes()[0], SocketOption.class) && kn.l0.g(method4.getParameterTypes()[1], Object.class)) {
                    method3 = method4;
                    break;
                }
            }
        } catch (Throwable unused4) {
        }
        f15131e = method3;
    }

    public final void a(@os.l DatagramChannel datagramChannel) throws IllegalAccessException, IOException, InvocationTargetException {
        kn.l0.p(datagramChannel, "channel");
        Object objD = d(w.f15160a);
        Method method = f15131e;
        kn.l0.m(method);
        method.invoke(datagramChannel, objD, Boolean.TRUE);
    }

    public final void b(@os.l ServerSocketChannel serverSocketChannel) throws IllegalAccessException, IOException, InvocationTargetException {
        kn.l0.p(serverSocketChannel, "channel");
        Object objD = d(w.f15160a);
        Method method = f15130d;
        kn.l0.m(method);
        method.invoke(serverSocketChannel, objD, Boolean.TRUE);
    }

    public final void c(@os.l SocketChannel socketChannel) throws IllegalAccessException, IOException, InvocationTargetException {
        kn.l0.p(socketChannel, "channel");
        Object objD = d(w.f15160a);
        Method method = f15129c;
        kn.l0.m(method);
        method.invoke(socketChannel, objD, Boolean.TRUE);
    }

    public final Object d(String str) throws IOException {
        Field field = f15128b.get(str);
        Object obj = field != null ? field.get(null) : null;
        if (obj != null) {
            return obj;
        }
        throw new IOException(n.a.a("Socket option ", str, " is not supported"));
    }
}
