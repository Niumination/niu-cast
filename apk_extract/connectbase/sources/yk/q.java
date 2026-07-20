package yk;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f21428b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final q f21429c = new q("HTTP");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final q f21430d = new q("HTTPS");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f21431a;

    public static final class a {
        public a() {
        }

        @os.l
        public final q a() {
            return q.f21429c;
        }

        @os.l
        public final q b() {
            return q.f21430d;
        }

        public a(kn.w wVar) {
        }
    }

    public q(@os.l String str) {
        l0.p(str, "name");
        this.f21431a = str;
    }

    public static /* synthetic */ q e(q qVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qVar.f21431a;
        }
        return qVar.d(str);
    }

    @os.l
    public final String c() {
        return this.f21431a;
    }

    @os.l
    public final q d(@os.l String str) {
        l0.p(str, "name");
        return new q(str);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && l0.g(this.f21431a, ((q) obj).f21431a);
    }

    @os.l
    public final String f() {
        return this.f21431a;
    }

    public int hashCode() {
        return this.f21431a.hashCode();
    }

    @os.l
    public String toString() {
        return l.a.a(new StringBuilder("ConnectorType(name="), this.f21431a, ')');
    }
}
