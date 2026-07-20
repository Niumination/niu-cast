package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class w3<U, T extends U> extends vq.q0<T> implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @in.f
    public final long f11983e;

    public w3(long j10, @os.l um.d<? super U> dVar) {
        super(dVar.getContext(), dVar);
        this.f11983e = j10;
    }

    @Override // nq.a, nq.t2
    @os.l
    public String l1() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(x0.a(this));
        sb2.append("(timeMillis=");
        return n2.k0.a(sb2, this.f11983e, ')');
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        c0(x3.a(this.f11983e, d1.d(this.f11822c), this));
    }
}
