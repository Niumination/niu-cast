package tn;

import java.util.Iterator;
import lm.f1;
import lm.p2;
import lm.w1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.5")
@p2(markerClass = {lm.t.class})
public class v implements Iterable<w1>, ln.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f15934d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15937c;

    public static final class a {
        public a() {
        }

        @os.l
        public final v a(int i10, int i11, int i12) {
            return new v(i10, i11, i12);
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ v(int i10, int i11, int i12, kn.w wVar) {
        this(i10, i11, i12);
    }

    public final int e() {
        return this.f15935a;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof v) {
            if (!isEmpty() || !((v) obj).isEmpty()) {
                v vVar = (v) obj;
                if (this.f15935a != vVar.f15935a || this.f15936b != vVar.f15936b || this.f15937c != vVar.f15937c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f15936b;
    }

    public final int g() {
        return this.f15937c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f15937c + (((this.f15935a * 31) + this.f15936b) * 31);
    }

    public boolean isEmpty() {
        if (this.f15937c > 0) {
            if (Integer.compareUnsigned(this.f15935a, this.f15936b) <= 0) {
                return false;
            }
        } else if (Integer.compareUnsigned(this.f15935a, this.f15936b) >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    @os.l
    public final Iterator<w1> iterator() {
        return new w(this.f15935a, this.f15936b, this.f15937c);
    }

    @os.l
    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f15937c > 0) {
            sb2 = new StringBuilder();
            sb2.append((Object) w1.h0(this.f15935a));
            sb2.append("..");
            sb2.append((Object) w1.h0(this.f15936b));
            sb2.append(" step ");
            i10 = this.f15937c;
        } else {
            sb2 = new StringBuilder();
            sb2.append((Object) w1.h0(this.f15935a));
            sb2.append(" downTo ");
            sb2.append((Object) w1.h0(this.f15936b));
            sb2.append(" step ");
            i10 = -this.f15937c;
        }
        sb2.append(i10);
        return sb2.toString();
    }

    public v(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f15935a = i10;
        this.f15936b = an.r.d(i10, i11, i12);
        this.f15937c = i12;
    }
}
