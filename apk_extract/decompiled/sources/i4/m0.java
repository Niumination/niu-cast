package i4;

import java.util.Arrays;
import k3.d9;
import k3.g9;

/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f5643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5644b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0 f5645c;

    public m0(int i8) {
        this.f5643a = new Object[i8 * 2];
    }

    public final u4 a() {
        l0 l0Var = this.f5645c;
        if (l0Var != null) {
            throw l0Var.a();
        }
        u4 u4VarCreate = u4.create(this.f5644b, this.f5643a, this);
        l0 l0Var2 = this.f5645c;
        if (l0Var2 == null) {
            return u4VarCreate;
        }
        throw l0Var2.a();
    }

    public final void b(Object obj, Object obj2) {
        int i8 = (this.f5644b + 1) * 2;
        Object[] objArr = this.f5643a;
        if (i8 > objArr.length) {
            this.f5643a = Arrays.copyOf(objArr, g9.a(objArr.length, i8));
        }
        d9.a(obj, obj2);
        Object[] objArr2 = this.f5643a;
        int i9 = this.f5644b;
        int i10 = i9 * 2;
        objArr2[i10] = obj;
        objArr2[i10 + 1] = obj2;
        this.f5644b = i9 + 1;
    }
}
