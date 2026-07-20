package x4;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Method f10843a;

    public g0(Method method) {
        this.f10843a = method;
    }

    @Override // x4.i0
    public final Object newInstance(Class cls) {
        i0.assertInstantiable(cls);
        return this.f10843a.invoke(null, cls, Object.class);
    }
}
