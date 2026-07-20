package gk;

import androidx.core.app.NotificationCompat;
import ik.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 implements l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l1 f6705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final String f6706b;

    public t0(@os.l l1 l1Var, @os.m String str) {
        kn.l0.p(l1Var, "local");
        this.f6705a = l1Var;
        this.f6706b = str;
    }

    @Override // ik.l1
    public int a() {
        String strL5;
        String str = this.f6706b;
        Integer numX0 = null;
        if (str != null && (strL5 = jq.h0.l5(str, ":", "80")) != null) {
            numX0 = jq.d0.X0(strL5);
        }
        return numX0 == null ? this.f6705a.a() : numX0.intValue();
    }

    @Override // ik.l1
    @os.l
    public String b() {
        String str = this.f6706b;
        String strV5 = str != null ? jq.h0.v5(str, ":", null, 2, null) : null;
        return strV5 == null ? this.f6705a.b() : strV5;
    }

    @Override // ik.l1
    @os.l
    public String c() {
        return this.f6705a.c();
    }

    @Override // ik.l1
    @os.l
    public String d() {
        return this.f6705a.d();
    }

    @Override // ik.l1
    @os.l
    public ik.p0 getMethod() {
        return this.f6705a.getMethod();
    }

    @Override // ik.l1
    @os.l
    public String getUri() {
        return this.f6705a.getUri();
    }

    @Override // ik.l1
    @os.l
    public String getVersion() {
        return this.f6705a.getVersion();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public t0(@os.l dk.b bVar) {
        kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        l1 l1VarG = bVar.d().g();
        uk.d dVarD = bVar.d();
        ik.j0.f8048a.getClass();
        this(l1VarG, uk.e.q(dVarD, ik.j0.F));
    }
}
