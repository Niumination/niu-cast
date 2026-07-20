package m1;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7568a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x1.a f7570c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7571d = -1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x1.a f7569b = d(0.0f);

    public c(List list) {
        this.f7568a = list;
    }

    @Override // m1.b
    public final boolean a(float f) {
        x1.a aVar = this.f7570c;
        x1.a aVar2 = this.f7569b;
        if (aVar == aVar2 && this.f7571d == f) {
            return true;
        }
        this.f7570c = aVar2;
        this.f7571d = f;
        return false;
    }

    @Override // m1.b
    public final x1.a b() {
        return this.f7569b;
    }

    @Override // m1.b
    public final boolean c(float f) {
        x1.a aVar = this.f7569b;
        if (f >= aVar.b() && f < aVar.a()) {
            return !this.f7569b.c();
        }
        this.f7569b = d(f);
        return true;
    }

    public final x1.a d(float f) {
        List list = this.f7568a;
        x1.a aVar = (x1.a) a1.a.j(1, list);
        if (f >= aVar.b()) {
            return aVar;
        }
        for (int size = list.size() - 2; size >= 1; size--) {
            x1.a aVar2 = (x1.a) list.get(size);
            if (this.f7569b != aVar2 && f >= aVar2.b() && f < aVar2.a()) {
                return aVar2;
            }
        }
        return (x1.a) list.get(0);
    }

    @Override // m1.b
    public final float e() {
        return ((x1.a) this.f7568a.get(0)).b();
    }

    @Override // m1.b
    public final float g() {
        return ((x1.a) a1.a.j(1, this.f7568a)).a();
    }

    @Override // m1.b
    public final boolean isEmpty() {
        return false;
    }
}
