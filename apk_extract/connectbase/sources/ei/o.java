package ei;

/* JADX INFO: loaded from: classes2.dex */
public class o extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f4320a;

    public o(n nVar) {
        this.f4320a = nVar;
    }

    @Override // ei.n
    public void a(Object obj) {
        c().t().addFirst(obj);
        this.f4320a.a(obj);
        c().t().removeFirst();
    }

    @Override // ei.a, ei.g
    public Boolean b() {
        n nVar = this.f4320a;
        return Boolean.valueOf((nVar instanceof g) && ((g) nVar).b().booleanValue());
    }
}
