package r2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14193g;

    public /* synthetic */ m(long j10, kn.w wVar) {
        this(j10);
    }

    @Override // r2.o
    public long b() {
        return this.f14193g;
    }

    @Override // r2.o
    public void f(long j10) {
        this.f14193g = j10;
    }

    public m(long j10) {
        super(0, j10, 1, null);
        this.f14193g = j10;
    }
}
