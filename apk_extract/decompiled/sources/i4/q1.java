package i4;

import java.util.Arrays;
import java.util.Objects;
import k3.f9;

/* JADX INFO: loaded from: classes.dex */
public class q1 extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object[] f5682d;
    public int e;

    public q1 d(Object obj) {
        obj.getClass();
        if (this.f5682d != null) {
            int iChooseTableSize = s1.chooseTableSize(this.f5713b);
            Object[] objArr = this.f5682d;
            if (iChooseTableSize <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iA = f9.a(iHashCode);
                while (true) {
                    int i8 = iA & length;
                    Object[] objArr2 = this.f5682d;
                    Object obj2 = objArr2[i8];
                    if (obj2 == null) {
                        objArr2[i8] = obj;
                        this.e += iHashCode;
                        b(obj);
                        break;
                    }
                    if (obj2.equals(obj)) {
                        break;
                    }
                    iA = i8 + 1;
                }
                return this;
            }
        }
        this.f5682d = null;
        b(obj);
        return this;
    }

    public s1 e() {
        s1 s1VarE;
        int i8 = this.f5713b;
        if (i8 == 0) {
            return s1.of();
        }
        if (i8 == 1) {
            Object obj = this.f5712a[0];
            Objects.requireNonNull(obj);
            return s1.of(obj);
        }
        if (this.f5682d == null || s1.chooseTableSize(i8) != this.f5682d.length) {
            s1VarE = s1.e(this.f5713b, this.f5712a);
            this.f5713b = s1VarE.size();
        } else {
            Object[] objArrCopyOf = s1.access$000(this.f5713b, this.f5712a.length) ? Arrays.copyOf(this.f5712a, this.f5713b) : this.f5712a;
            int i9 = this.e;
            Object[] objArr = this.f5682d;
            s1VarE = new z4(objArrCopyOf, i9, objArr, objArr.length - 1, this.f5713b);
        }
        this.f5714c = true;
        this.f5682d = null;
        return s1VarE;
    }
}
