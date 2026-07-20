package zj;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f11618d;
    public final boolean e;

    public a0(int i8, String str, boolean z2) {
        this.f11616b = i8;
        switch (i8) {
            case 1:
                a aVar = a.f11610b;
                Objects.requireNonNull(str, "name == null");
                this.f11617c = str;
                this.f11618d = aVar;
                this.e = z2;
                break;
            default:
                a aVar2 = a.f11610b;
                Objects.requireNonNull(str, "name == null");
                this.f11617c = str;
                this.f11618d = aVar2;
                this.e = z2;
                break;
        }
    }

    @Override // zj.s
    public final void a(l0 l0Var, Object obj) {
        switch (this.f11616b) {
            case 0:
                if (obj != null) {
                    this.f11618d.getClass();
                    String string = obj.toString();
                    if (string != null) {
                        l0Var.a(this.f11617c, string, this.e);
                        break;
                    }
                }
                break;
            default:
                if (obj != null) {
                    this.f11618d.getClass();
                    String string2 = obj.toString();
                    if (string2 != null) {
                        l0Var.d(this.f11617c, string2, this.e);
                        break;
                    }
                }
                break;
        }
    }
}
