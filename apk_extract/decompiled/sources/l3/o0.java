package l3;

/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a3 f7277b;

    public o0(int i8, a3 a3Var) {
        this.f7276a = i8;
        this.f7277b = a3Var;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.f7276a - ((o0) obj).f7276a;
    }
}
