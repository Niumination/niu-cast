package m1;

import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class r extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f7626i;

    public r(x1.c cVar, Object obj) {
        super(Collections.emptyList());
        k(cVar);
        this.f7626i = obj;
    }

    @Override // m1.e
    public final float c() {
        return 1.0f;
    }

    @Override // m1.e
    public final Object f() {
        x1.c cVar = this.e;
        float f = this.f7577d;
        Object obj = this.f7626i;
        return cVar.b(0.0f, 0.0f, obj, obj, f, f, f);
    }

    @Override // m1.e
    public final Object g(x1.a aVar, float f) {
        return f();
    }

    @Override // m1.e
    public final void i() {
        if (this.e != null) {
            super.i();
        }
    }

    @Override // m1.e
    public final void j(float f) {
        this.f7577d = f;
    }
}
