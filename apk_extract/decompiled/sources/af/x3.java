package af;

import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class x3 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f704a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cf.j0 f705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a4 f706c;

    public x3(a4 a4Var) {
        this.f706c = a4Var;
    }

    @Override // java.io.OutputStream
    public final void write(int i8) {
        cf.j0 j0Var = this.f705b;
        if (j0Var == null || j0Var.f1570b <= 0) {
            write(new byte[]{(byte) i8}, 0, 1);
            return;
        }
        j0Var.f1569a.S((byte) i8);
        j0Var.f1570b--;
        j0Var.f1571c++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i8, int i9) {
        cf.j0 j0Var = this.f705b;
        ArrayList arrayList = this.f704a;
        a4 a4Var = this.f706c;
        if (j0Var == null) {
            a4Var.f146g.getClass();
            cf.j0 j0VarB = mg.a0.b(i9);
            this.f705b = j0VarB;
            arrayList.add(j0VarB);
        }
        while (i9 > 0) {
            int iMin = Math.min(i9, this.f705b.f1570b);
            if (iMin == 0) {
                int iMax = Math.max(i9, this.f705b.f1571c * 2);
                a4Var.f146g.getClass();
                cf.j0 j0VarB2 = mg.a0.b(iMax);
                this.f705b = j0VarB2;
                arrayList.add(j0VarB2);
            } else {
                this.f705b.a(bArr, i8, iMin);
                i8 += iMin;
                i9 -= iMin;
            }
        }
    }
}
