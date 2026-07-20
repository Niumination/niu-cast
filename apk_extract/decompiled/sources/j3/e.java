package j3;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6066c;

    public e(Object obj, Object obj2, Object obj3) {
        this.f6064a = obj;
        this.f6065b = obj2;
        this.f6066c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f6064a;
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(this.f6065b);
        String strValueOf3 = String.valueOf(obj);
        String strValueOf4 = String.valueOf(this.f6066c);
        StringBuilder sbP = h0.a.p("Multiple entries with same key: ", strValueOf, "=", strValueOf2, " and ");
        sbP.append(strValueOf3);
        sbP.append("=");
        sbP.append(strValueOf4);
        return new IllegalArgumentException(sbP.toString());
    }
}
