package x4;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Method f10839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10840b;

    public e0(Method method, Object obj) {
        this.f10839a = method;
        this.f10840b = obj;
    }

    @Override // x4.i0
    public final Object newInstance(Class cls) {
        i0.assertInstantiable(cls);
        return this.f10839a.invoke(this.f10840b, cls);
    }
}
