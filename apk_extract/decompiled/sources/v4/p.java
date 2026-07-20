package v4;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class p extends y4.h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p0 f10476a = null;

    @Override // y4.h0
    public final p0 getSerializationDelegate() {
        p0 p0Var = this.f10476a;
        if (p0Var != null) {
            return p0Var;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) {
        p0 p0Var = this.f10476a;
        if (p0Var != null) {
            return p0Var.read(bVar);
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        p0 p0Var = this.f10476a;
        if (p0Var == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        p0Var.write(dVar, obj);
    }
}
