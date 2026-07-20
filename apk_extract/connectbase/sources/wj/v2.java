package wj;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class v2<ReqT, RespT> extends vj.u2.c<ReqT, RespT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.w1<ReqT, RespT> f19403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.a f19404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19405c;

    public v2(vj.w1<ReqT, RespT> w1Var, vj.a aVar, @gm.j String str) {
        this.f19403a = w1Var;
        this.f19404b = aVar;
        this.f19405c = str;
    }

    @Override // vj.u2.c
    public vj.a a() {
        return this.f19404b;
    }

    @Override // vj.u2.c
    @gm.j
    public String b() {
        return this.f19405c;
    }

    @Override // vj.u2.c
    public vj.w1<ReqT, RespT> c() {
        return this.f19403a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v2)) {
            return false;
        }
        v2 v2Var = (v2) obj;
        return c1.b0.a(this.f19403a, v2Var.f19403a) && c1.b0.a(this.f19404b, v2Var.f19404b) && c1.b0.a(this.f19405c, v2Var.f19405c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f19403a, this.f19404b, this.f19405c});
    }
}
