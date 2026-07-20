package vq;

/* JADX INFO: loaded from: classes3.dex */
public class q0<T> extends nq.a<T> implements xm.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @in.f
    @os.l
    public final um.d<T> f17874d;

    /* JADX WARN: Multi-variable type inference failed */
    public q0(@os.l um.g gVar, @os.l um.d<? super T> dVar) {
        super(gVar, true, true);
        this.f17874d = dVar;
    }

    @Override // nq.a
    public void O1(@os.m Object obj) {
        um.d<T> dVar = this.f17874d;
        dVar.resumeWith(nq.j0.a(obj, dVar));
    }

    @Override // nq.t2
    public void X(@os.m Object obj) {
        n.e(wm.c.e(this.f17874d), nq.j0.a(obj, this.f17874d), null, 2, null);
    }

    @Override // nq.t2
    public final boolean b1() {
        return true;
    }

    @Override // xm.e
    @os.m
    public final xm.e getCallerFrame() {
        um.d<T> dVar = this.f17874d;
        if (dVar instanceof xm.e) {
            return (xm.e) dVar;
        }
        return null;
    }

    @Override // xm.e
    @os.m
    public final StackTraceElement getStackTraceElement() {
        return null;
    }
}
