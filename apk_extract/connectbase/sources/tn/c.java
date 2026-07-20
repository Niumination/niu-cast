package tn;

import kn.l0;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends tn.a implements g<Character>, r<Character> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f15900e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final c f15901f = new c(1, 0, 1);

    public static final class a {
        public a() {
        }

        @os.l
        public final c a() {
            return c.f15901f;
        }

        public a(kn.w wVar) {
        }
    }

    public c(char c10, char c11) {
        super(c10, c11, 1);
    }

    @f1(version = "1.9")
    @lm.k(message = "Can throw an exception when it's impossible to represent the value with Char type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @p2(markerClass = {lm.r.class})
    public static /* synthetic */ void n() {
    }

    @Override // tn.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return l(((Character) comparable).charValue());
    }

    @Override // tn.a
    public boolean equals(@os.m Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f15891a != cVar.f15891a || this.f15892b != cVar.f15892b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.g
    public Comparable getEndInclusive() {
        return Character.valueOf(this.f15892b);
    }

    @Override // tn.g
    public Comparable getStart() {
        return Character.valueOf(this.f15891a);
    }

    @Override // tn.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f15892b + (this.f15891a * s1.c.f14922b);
    }

    @Override // tn.a, tn.g
    public boolean isEmpty() {
        return l0.t(this.f15891a, this.f15892b) > 0;
    }

    public boolean l(char c10) {
        return l0.t(this.f15891a, c10) <= 0 && l0.t(c10, this.f15892b) <= 0;
    }

    @Override // tn.r
    @os.l
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Character c() {
        char c10 = this.f15892b;
        if (c10 != 65535) {
            return Character.valueOf((char) (c10 + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    @os.l
    public Character o() {
        return Character.valueOf(this.f15892b);
    }

    @os.l
    public Character q() {
        return Character.valueOf(this.f15891a);
    }

    @Override // tn.a
    @os.l
    public String toString() {
        return this.f15891a + ".." + this.f15892b;
    }
}
