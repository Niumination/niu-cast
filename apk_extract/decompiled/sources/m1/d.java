package m1;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1.a f7572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f7573b = -1.0f;

    public d(List list) {
        this.f7572a = (x1.a) list.get(0);
    }

    @Override // m1.b
    public final boolean a(float f) {
        if (this.f7573b == f) {
            return true;
        }
        this.f7573b = f;
        return false;
    }

    @Override // m1.b
    public final x1.a b() {
        return this.f7572a;
    }

    @Override // m1.b
    public final boolean c(float f) {
        return !this.f7572a.c();
    }

    @Override // m1.b
    public final float e() {
        return this.f7572a.b();
    }

    @Override // m1.b
    public final float g() {
        return this.f7572a.a();
    }

    @Override // m1.b
    public final boolean isEmpty() {
        return false;
    }
}
