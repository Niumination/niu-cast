package i4;

/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5632c;

    public l0(Object obj, Object obj2, Object obj3) {
        this.f5630a = obj;
        this.f5631b = obj2;
        this.f5632c = obj3;
    }

    public final IllegalArgumentException a() {
        StringBuilder sb2 = new StringBuilder("Multiple entries with same key: ");
        Object obj = this.f5630a;
        sb2.append(obj);
        sb2.append("=");
        sb2.append(this.f5631b);
        sb2.append(" and ");
        sb2.append(obj);
        sb2.append("=");
        sb2.append(this.f5632c);
        return new IllegalArgumentException(sb2.toString());
    }
}
