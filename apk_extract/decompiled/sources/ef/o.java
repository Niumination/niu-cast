package ef;

import com.google.android.gms.common.ConnectionResult;
import ik.v;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements ck.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4952b;

    public o(int i8, Object obj) {
        this.f4951a = i8;
        this.f4952b = obj;
    }

    public void a(Object obj) {
        int i8 = this.f4951a;
        Object[] objArr = (Object[]) this.f4952b;
        if (objArr == null) {
            objArr = new Object[16];
            this.f4952b = objArr;
        } else if (i8 == objArr.length) {
            Object[] objArr2 = new Object[(i8 >> 2) + i8];
            System.arraycopy(objArr, 0, objArr2, 0, i8);
            this.f4952b = objArr2;
            objArr = objArr2;
        }
        objArr[i8] = obj;
        this.f4951a = i8 + 1;
    }

    public boolean b(int i8) {
        return (this.f4951a & (1 << i8)) != 0;
    }

    public void c(int i8, int i9) {
        int[] iArr = (int[]) this.f4952b;
        if (i8 >= iArr.length) {
            return;
        }
        this.f4951a = (1 << i8) | this.f4951a;
        iArr[i8] = i9;
    }

    @Override // ek.g
    public Object call(Object obj) {
        int i8 = this.f4951a;
        fk.h hVar = new fk.h((ck.h) this.f4952b, (ck.i) obj, i8);
        o5.c cVar = new o5.c(hVar);
        ck.i iVar = hVar.e;
        iVar.b(cVar);
        v vVar = iVar.f1736a;
        vVar.a(hVar.f5070h);
        vVar.a(hVar);
        return hVar;
    }

    public o(ConnectionResult connectionResult, int i8) {
        u2.l.e(connectionResult);
        this.f4952b = connectionResult;
        this.f4951a = i8;
    }

    public o() {
        this.f4952b = new int[10];
    }
}
