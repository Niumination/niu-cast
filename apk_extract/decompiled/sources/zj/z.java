package zj;

import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f11724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f11726d;

    public z(Method method, int i8, j jVar) {
        this.f11724b = method;
        this.f11725c = i8;
        this.f11726d = jVar;
    }

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) {
        int i8 = this.f11725c;
        Method method = this.f11724b;
        if (obj == null) {
            throw s.l(method, i8, "Body parameter value must not be null.", new Object[0]);
        }
        try {
            l0Var.f11654k = (dj.h0) this.f11726d.convert(obj);
        } catch (IOException e) {
            throw s.m(method, e, i8, "Unable to convert " + obj + " to RequestBody", new Object[0]);
        }
    }
}
