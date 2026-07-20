package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f6090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6091b;

    public q(@os.l String str) {
        kn.l0.p(str, t2.a.f15437d);
        this.f6090a = str;
        String lowerCase = str.toLowerCase();
        kn.l0.o(lowerCase, "this as java.lang.String).toLowerCase()");
        this.f6091b = lowerCase.hashCode();
    }

    @os.l
    public final String a() {
        return this.f6090a;
    }

    public boolean equals(@os.m Object obj) {
        String str;
        q qVar = obj instanceof q ? (q) obj : null;
        return (qVar == null || (str = qVar.f6090a) == null || !jq.e0.K1(str, this.f6090a, true)) ? false : true;
    }

    public int hashCode() {
        return this.f6091b;
    }

    @os.l
    public String toString() {
        return this.f6090a;
    }
}
