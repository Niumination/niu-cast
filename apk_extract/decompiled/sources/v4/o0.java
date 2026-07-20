package v4;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class o0 extends p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f10475a;

    public o0(p0 p0Var) {
        this.f10475a = p0Var;
    }

    @Override // v4.p0
    public final Object read(d5.b bVar) throws IOException {
        if (bVar.peek() != d5.c.NULL) {
            return this.f10475a.read(bVar);
        }
        bVar.nextNull();
        return null;
    }

    public final String toString() {
        return "NullSafeTypeAdapter[" + this.f10475a + "]";
    }

    @Override // v4.p0
    public final void write(d5.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.nullValue();
        } else {
            this.f10475a.write(dVar, obj);
        }
    }
}
