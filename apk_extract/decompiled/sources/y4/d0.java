package y4;

import java.io.IOException;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x4.t f11043a;

    public d0(x4.t tVar, e0 e0Var) {
        super(e0Var);
        this.f11043a = tVar;
    }

    @Override // y4.b0
    public final Object a() {
        return this.f11043a.construct();
    }

    @Override // y4.b0
    public final Object b(Object obj) {
        return obj;
    }

    @Override // y4.b0
    public final void c(Object obj, d5.b bVar, c0 c0Var) throws IllegalAccessException, IOException {
        a0 a0Var = (a0) c0Var;
        Object obj2 = a0Var.f11031g.read(bVar);
        if (obj2 == null && a0Var.f11032h) {
            return;
        }
        boolean z2 = a0Var.f11030d;
        Field field = a0Var.f11038b;
        if (z2) {
            g0.checkAccessible(obj, field);
        } else if (a0Var.f11033i) {
            throw new v4.v(h0.a.i("Cannot set value of 'static final' ", a5.d.getAccessibleObjectDescription(field, false)));
        }
        field.set(obj, obj2);
    }
}
