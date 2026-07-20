package zj;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f11689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11690b;

    public o(Method method, ArrayList arrayList) {
        this.f11689a = method;
        this.f11690b = Collections.unmodifiableList(arrayList);
    }

    public final String toString() {
        Method method = this.f11689a;
        return String.format("%s.%s() %s", method.getDeclaringClass().getName(), method.getName(), this.f11690b);
    }
}
