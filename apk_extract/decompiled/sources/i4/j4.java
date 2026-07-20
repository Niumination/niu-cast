package i4;

import k3.u8;

/* JADX INFO: loaded from: classes.dex */
public final class j4 extends d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k4 f5614c;

    public j4(k4 k4Var, int i8) {
        this.f5614c = k4Var;
        this.f5612a = k4Var.f5622a[i8];
        this.f5613b = i8;
    }

    @Override // i4.b4
    public final int getCount() {
        int i8 = this.f5613b;
        k4 k4Var = this.f5614c;
        Object obj = this.f5612a;
        if (i8 == -1 || i8 >= k4Var.f5624c || !u8.a(obj, k4Var.f5622a[i8])) {
            this.f5613b = k4Var.d(obj);
        }
        int i9 = this.f5613b;
        if (i9 == -1) {
            return 0;
        }
        return k4Var.f5623b[i9];
    }

    @Override // i4.b4
    public final Object getElement() {
        return this.f5612a;
    }
}
