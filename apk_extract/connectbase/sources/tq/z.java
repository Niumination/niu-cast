package tq;

/* JADX INFO: loaded from: classes3.dex */
public final class z<T> implements um.d<T>, xm.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final um.d<T> f16068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final um.g f16069b;

    /* JADX WARN: Multi-variable type inference failed */
    public z(@os.l um.d<? super T> dVar, @os.l um.g gVar) {
        this.f16068a = dVar;
        this.f16069b = gVar;
    }

    @Override // xm.e
    @os.m
    public xm.e getCallerFrame() {
        um.d<T> dVar = this.f16068a;
        if (dVar instanceof xm.e) {
            return (xm.e) dVar;
        }
        return null;
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        return this.f16069b;
    }

    @Override // xm.e
    @os.m
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        this.f16068a.resumeWith(obj);
    }
}
