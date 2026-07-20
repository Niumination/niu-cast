package tn;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Iterable<Character>, ln.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final C0410a f15890d = new C0410a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f15891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f15892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15893c;

    /* JADX INFO: renamed from: tn.a$a, reason: collision with other inner class name */
    public static final class C0410a {
        public C0410a() {
        }

        @os.l
        public final a a(char c10, char c11, int i10) {
            return new a(c10, c11, i10);
        }

        public C0410a(kn.w wVar) {
        }
    }

    public a(char c10, char c11, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f15891a = c10;
        this.f15892b = (char) an.n.c(c10, c11, i10);
        this.f15893c = i10;
    }

    public final char e() {
        return this.f15891a;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f15891a != aVar.f15891a || this.f15892b != aVar.f15892b || this.f15893c != aVar.f15893c) {
                }
            }
            return true;
        }
        return false;
    }

    public final char f() {
        return this.f15892b;
    }

    public final int g() {
        return this.f15893c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f15893c + (((this.f15891a * s1.c.f14922b) + this.f15892b) * 31);
    }

    @Override // java.lang.Iterable
    @os.l
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public nm.v iterator() {
        return new b(this.f15891a, this.f15892b, this.f15893c);
    }

    public boolean isEmpty() {
        if (this.f15893c > 0) {
            if (l0.t(this.f15891a, this.f15892b) <= 0) {
                return false;
            }
        } else if (l0.t(this.f15891a, this.f15892b) >= 0) {
            return false;
        }
        return true;
    }

    @os.l
    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f15893c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f15891a);
            sb2.append("..");
            sb2.append(this.f15892b);
            sb2.append(" step ");
            i10 = this.f15893c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f15891a);
            sb2.append(" downTo ");
            sb2.append(this.f15892b);
            sb2.append(" step ");
            i10 = -this.f15893c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
