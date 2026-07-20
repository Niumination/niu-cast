package ng;

import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m3.p6;
import zf.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements zf.d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g0 f8276c;

    public s(g0 g0Var) {
        this.f8276c = g0Var;
    }

    @Override // zg.t
    public final Set a() {
        return this.f8276c.a();
    }

    @Override // zg.t
    public final List b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f8276c.b(name);
    }

    @Override // zg.t
    public final void c(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        p6.a(this, body);
    }

    @Override // zg.t
    public final boolean d() {
        return true;
    }

    @Override // zg.t
    public final boolean isEmpty() {
        return this.f8276c.f11607c.isEmpty();
    }

    @Override // zg.t
    public final Set names() {
        return this.f8276c.names();
    }
}
