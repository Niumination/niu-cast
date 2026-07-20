package nl;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f11594a;

    public j(@os.l String str) {
        l0.p(str, "name");
        this.f11594a = str;
    }

    @os.l
    public final String a() {
        return this.f11594a;
    }

    @os.l
    public String toString() {
        return j.c.a(new StringBuilder("Phase('"), this.f11594a, "')");
    }
}
