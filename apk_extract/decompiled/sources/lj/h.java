package lj;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7525c;

    public h(ArrayList protocols) {
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        this.f7525c = protocols;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object proxy, Method method, Object[] objArr) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(method, "method");
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (Intrinsics.areEqual(name, "supports") && Intrinsics.areEqual(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(name, "unsupported") && Intrinsics.areEqual(Void.TYPE, returnType)) {
            this.f7523a = true;
            return null;
        }
        boolean zAreEqual = Intrinsics.areEqual(name, "protocols");
        ArrayList arrayList = this.f7525c;
        if (zAreEqual && objArr.length == 0) {
            return arrayList;
        }
        if ((Intrinsics.areEqual(name, "selectProtocol") || Intrinsics.areEqual(name, "select")) && Intrinsics.areEqual(String.class, returnType) && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof List) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                }
                List list = (List) obj;
                int size = list.size();
                if (size >= 0) {
                    int i8 = 0;
                    while (true) {
                        Object obj2 = list.get(i8);
                        if (obj2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        String str = (String) obj2;
                        if (arrayList.contains(str)) {
                            this.f7524b = str;
                            return str;
                        }
                        if (i8 != size) {
                            i8++;
                        }
                    }
                }
                String str2 = (String) arrayList.get(0);
                this.f7524b = str2;
                return str2;
            }
        }
        if ((!Intrinsics.areEqual(name, "protocolSelected") && !Intrinsics.areEqual(name, "selected")) || objArr.length != 1) {
            return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
        }
        Object obj3 = objArr[0];
        if (obj3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        this.f7524b = (String) obj3;
        return null;
    }
}
