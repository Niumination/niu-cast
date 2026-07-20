package tn;

import nm.v0;

/* JADX INFO: loaded from: classes3.dex */
public class j implements Iterable<Integer>, ln.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final a f15910d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15913c;

    public static final class a {
        public a() {
        }

        @os.l
        public final j a(int i10, int i11, int i12) {
            return new j(i10, i11, i12);
        }

        public a(kn.w wVar) {
        }
    }

    public j(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f15911a = i10;
        this.f15912b = an.n.c(i10, i11, i12);
        this.f15913c = i12;
    }

    public final int e() {
        return this.f15911a;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof j) {
            if (!isEmpty() || !((j) obj).isEmpty()) {
                j jVar = (j) obj;
                if (this.f15911a != jVar.f15911a || this.f15912b != jVar.f15912b || this.f15913c != jVar.f15913c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f15912b;
    }

    public final int g() {
        return this.f15913c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f15913c + (((this.f15911a * 31) + this.f15912b) * 31);
    }

    @Override // java.lang.Iterable
    @os.l
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public v0 iterator() {
        return new k(this.f15911a, this.f15912b, this.f15913c);
    }

    public boolean isEmpty() {
        if (this.f15913c > 0) {
            if (this.f15911a <= this.f15912b) {
                return false;
            }
        } else if (this.f15911a >= this.f15912b) {
            return false;
        }
        return true;
    }

    @os.l
    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f15913c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f15911a);
            sb2.append("..");
            sb2.append(this.f15912b);
            sb2.append(" step ");
            i10 = this.f15913c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f15911a);
            sb2.append(" downTo ");
            sb2.append(this.f15912b);
            sb2.append(" step ");
            i10 = -this.f15913c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
