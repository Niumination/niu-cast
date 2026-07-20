package i4;

import java.util.Arrays;
import k3.d9;
import k3.g9;

/* JADX INFO: loaded from: classes.dex */
public abstract class z extends g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f5712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5714c;

    public z(int i8) {
        d9.b(i8, "initialCapacity");
        this.f5712a = new Object[i8];
        this.f5713b = 0;
    }

    public final void b(Object obj) {
        obj.getClass();
        c(this.f5713b + 1);
        Object[] objArr = this.f5712a;
        int i8 = this.f5713b;
        this.f5713b = i8 + 1;
        objArr[i8] = obj;
    }

    public final void c(int i8) {
        Object[] objArr = this.f5712a;
        if (objArr.length < i8) {
            this.f5712a = Arrays.copyOf(objArr, g9.a(objArr.length, i8));
            this.f5714c = false;
        } else if (this.f5714c) {
            this.f5712a = (Object[]) objArr.clone();
            this.f5714c = false;
        }
    }
}
