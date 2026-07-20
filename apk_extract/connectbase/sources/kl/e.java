package kl;

import kn.l0;
import os.l;
import os.m;
import y1.o;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m
    public Integer f9263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m
    public Integer f9264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public Integer f9265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public Integer f9266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f9267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public Integer f9268f;

    @l
    public final d a() {
        Integer num = this.f9263a;
        l0.m(num);
        int iIntValue = num.intValue();
        Integer num2 = this.f9264b;
        l0.m(num2);
        int iIntValue2 = num2.intValue();
        Integer num3 = this.f9265c;
        l0.m(num3);
        int iIntValue3 = num3.intValue();
        Integer num4 = this.f9266d;
        l0.m(num4);
        int iIntValue4 = num4.intValue();
        h hVarE = e();
        Integer num5 = this.f9268f;
        l0.m(num5);
        return a.a(iIntValue, iIntValue2, iIntValue3, iIntValue4, hVarE, num5.intValue());
    }

    @m
    public final Integer b() {
        return this.f9266d;
    }

    @m
    public final Integer c() {
        return this.f9265c;
    }

    @m
    public final Integer d() {
        return this.f9264b;
    }

    @l
    public final h e() {
        h hVar = this.f9267e;
        if (hVar != null) {
            return hVar;
        }
        l0.S(o.r.f20670b);
        return null;
    }

    @m
    public final Integer f() {
        return this.f9263a;
    }

    @m
    public final Integer g() {
        return this.f9268f;
    }

    public final void h(@m Integer num) {
        this.f9266d = num;
    }

    public final void i(@m Integer num) {
        this.f9265c = num;
    }

    public final void j(@m Integer num) {
        this.f9264b = num;
    }

    public final void k(@l h hVar) {
        l0.p(hVar, "<set-?>");
        this.f9267e = hVar;
    }

    public final void l(@m Integer num) {
        this.f9263a = num;
    }

    public final void m(@m Integer num) {
        this.f9268f = num;
    }
}
