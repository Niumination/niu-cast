package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f6017a;

    public b(@os.l String str) {
        kn.l0.p(str, "name");
        this.f6017a = str;
    }

    @os.l
    public final String a() {
        return this.f6017a;
    }

    @os.l
    public String toString() {
        return this.f6017a.length() == 0 ? super.toString() : kn.l0.C("AttributeKey: ", this.f6017a);
    }
}
