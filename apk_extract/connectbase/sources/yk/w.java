package yk;

import ik.y0;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public class w implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final q f21434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public String f21435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21436c;

    public w() {
        this(null, 1, null);
    }

    @Override // yk.x
    public int a() {
        return this.f21436c;
    }

    @Override // yk.x
    @os.l
    public String b() {
        return this.f21435b;
    }

    @Override // yk.x
    @os.l
    public q getType() {
        return this.f21434a;
    }

    public void h(@os.l String str) {
        l0.p(str, "<set-?>");
        this.f21435b = str;
    }

    public void i(int i10) {
        this.f21436c = i10;
    }

    @os.l
    public String toString() {
        return getType().f21431a + ' ' + b() + n1.e.f11184d + a();
    }

    public w(@os.l q qVar) {
        l0.p(qVar, y0.a.f8215h);
        this.f21434a = qVar;
        this.f21435b = "0.0.0.0";
        this.f21436c = 80;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public w(q qVar, int i10, kn.w wVar) {
        if ((i10 & 1) != 0) {
            q.f21428b.getClass();
            qVar = q.f21429c;
        }
        this(qVar);
    }
}
