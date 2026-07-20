package y4;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f11030d;
    public final /* synthetic */ Method e;
    public final /* synthetic */ v4.p0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ v4.p0 f11031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f11032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f11033i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(String str, Field field, boolean z2, Method method, v4.p0 p0Var, v4.p0 p0Var2, boolean z3, boolean z5) {
        super(str, field);
        this.f11030d = z2;
        this.e = method;
        this.f = p0Var;
        this.f11031g = p0Var2;
        this.f11032h = z3;
        this.f11033i = z5;
    }

    @Override // y4.c0
    public final void a(d5.d dVar, Object obj) throws IllegalAccessException, IOException {
        Object objInvoke;
        boolean z2 = this.f11030d;
        Field field = this.f11038b;
        Method method = this.e;
        if (z2) {
            if (method == null) {
                g0.checkAccessible(obj, field);
            } else {
                g0.checkAccessible(obj, method);
            }
        }
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, null);
            } catch (InvocationTargetException e) {
                throw new v4.v(h0.a.j("Accessor ", a5.d.getAccessibleObjectDescription(method, false), " threw exception"), e.getCause());
            }
        } else {
            objInvoke = field.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        dVar.name(this.f11037a);
        this.f.write(dVar, objInvoke);
    }
}
