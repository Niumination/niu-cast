package fk;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements ek.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5078a;

    public j(int i8) {
        this.f5078a = i8;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new s(this.f5078a);
    }
}
