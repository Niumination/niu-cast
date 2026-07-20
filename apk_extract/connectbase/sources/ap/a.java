package ap;

import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.w;
import nm.h0;
import nm.k0;
import nm.p;
import nm.r;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final C0018a f633f = new C0018a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final int[] f634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final List<Integer> f638e;

    /* JADX INFO: renamed from: ap.a$a, reason: collision with other inner class name */
    public static final class C0018a {
        public C0018a() {
        }

        public C0018a(w wVar) {
        }
    }

    public a(@l int... iArr) {
        l0.p(iArr, "numbers");
        this.f634a = iArr;
        Integer numNe = r.Ne(iArr, 0);
        this.f635b = numNe == null ? -1 : numNe.intValue();
        Integer numNe2 = r.Ne(iArr, 1);
        this.f636c = numNe2 == null ? -1 : numNe2.intValue();
        Integer numNe3 = r.Ne(iArr, 2);
        this.f637d = numNe3 != null ? numNe3.intValue() : -1;
        this.f638e = iArr.length > 3 ? h0.V5(p.r(iArr).subList(3, iArr.length)) : k0.INSTANCE;
    }

    public final int a() {
        return this.f635b;
    }

    public final int b() {
        return this.f636c;
    }

    public final boolean c(int i10, int i11, int i12) {
        int i13 = this.f635b;
        if (i13 > i10) {
            return true;
        }
        if (i13 < i10) {
            return false;
        }
        int i14 = this.f636c;
        if (i14 > i11) {
            return true;
        }
        return i14 >= i11 && this.f637d >= i12;
    }

    public final boolean d(@l a aVar) {
        l0.p(aVar, lb.f.f9782f);
        return c(aVar.f635b, aVar.f636c, aVar.f637d);
    }

    public final boolean e(int i10, int i11, int i12) {
        int i13 = this.f635b;
        if (i13 < i10) {
            return true;
        }
        if (i13 > i10) {
            return false;
        }
        int i14 = this.f636c;
        if (i14 < i11) {
            return true;
        }
        return i14 <= i11 && this.f637d <= i12;
    }

    public boolean equals(@m Object obj) {
        if (obj != null && l0.g(getClass(), obj.getClass())) {
            a aVar = (a) obj;
            if (this.f635b == aVar.f635b && this.f636c == aVar.f636c && this.f637d == aVar.f637d && l0.g(this.f638e, aVar.f638e)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(@l a aVar) {
        l0.p(aVar, "ourVersion");
        int i10 = this.f635b;
        if (i10 == 0) {
            if (aVar.f635b != 0 || this.f636c != aVar.f636c) {
                return false;
            }
        } else if (i10 != aVar.f635b || this.f636c > aVar.f636c) {
            return false;
        }
        return true;
    }

    @l
    public final int[] g() {
        return this.f634a;
    }

    public int hashCode() {
        int i10 = this.f635b;
        int i11 = (i10 * 31) + this.f636c + i10;
        int i12 = (i11 * 31) + this.f637d + i11;
        return this.f638e.hashCode() + (i12 * 31) + i12;
    }

    @l
    public String toString() {
        int[] iArr = this.f634a;
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = iArr[i10];
            i10++;
            if (i11 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i11));
        }
        return arrayList.isEmpty() ? "unknown" : h0.m3(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
