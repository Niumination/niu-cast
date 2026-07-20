package zj;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f11624c;

    public c0(String str) {
        a aVar = a.f11610b;
        Objects.requireNonNull(str, "name == null");
        this.f11623b = str;
        this.f11624c = aVar;
    }

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) {
        if (obj == null) {
            return;
        }
        this.f11624c.getClass();
        String string = obj.toString();
        if (string == null) {
            return;
        }
        l0Var.b(this.f11623b, string);
    }
}
