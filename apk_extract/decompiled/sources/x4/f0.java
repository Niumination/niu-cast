package x4;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Method f10841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10842b;

    public f0(int i8, Method method) {
        this.f10841a = method;
        this.f10842b = i8;
    }

    @Override // x4.i0
    public final Object newInstance(Class cls) {
        i0.assertInstantiable(cls);
        return this.f10841a.invoke(null, cls, Integer.valueOf(this.f10842b));
    }
}
