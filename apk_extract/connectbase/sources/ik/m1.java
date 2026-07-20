package ik;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f8118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8119b;

    public m1(@os.l String str) {
        kn.l0.p(str, "source");
        this.f8118a = str;
    }

    public final boolean a(@os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(lVar, "predicate");
        boolean zH = h(lVar);
        if (zH) {
            this.f8119b++;
        }
        return zH;
    }

    public final boolean b(@os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(lVar, "predicate");
        if (!h(lVar)) {
            return false;
        }
        while (h(lVar)) {
            this.f8119b++;
        }
        return true;
    }

    @os.l
    public final String c(@os.l jn.l<? super m1, l2> lVar) {
        kn.l0.p(lVar, "block");
        int i10 = this.f8119b;
        lVar.invoke(this);
        String strSubstring = this.f8118a.substring(i10, this.f8119b);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean d() {
        return this.f8119b < this.f8118a.length();
    }

    public final int e() {
        return this.f8119b;
    }

    @os.l
    public final String f() {
        return this.f8118a;
    }

    public final void g(int i10) {
        this.f8119b = i10;
    }

    public final boolean h(@os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(lVar, "predicate");
        return this.f8119b < this.f8118a.length() && lVar.invoke(Character.valueOf(this.f8118a.charAt(this.f8119b))).booleanValue();
    }
}
