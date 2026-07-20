package yj;

import io.netty.channel.unix.DomainSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import vj.x1;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 extends x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x1.e f20940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20941b;

    public e1(String str, String str2) {
        c1.h0.e(str == null, "non-null authority not supported");
        this.f20941b = str2;
    }

    private void f() {
        x1.g.a aVar = new x1.g.a();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new vj.d0(new DomainSocketAddress(this.f20941b)));
        aVar.f17536a = Collections.unmodifiableList(arrayList);
        this.f20940a.c(aVar.a());
    }

    @Override // vj.x1
    public String a() {
        return this.f20941b;
    }

    @Override // vj.x1
    public void b() {
        f();
    }

    @Override // vj.x1
    public void c() {
    }

    @Override // vj.x1
    public void d(x1.e eVar) {
        c1.h0.h0(this.f20940a == null, "already started");
        this.f20940a = (x1.e) c1.h0.F(eVar, "listener");
        f();
    }
}
