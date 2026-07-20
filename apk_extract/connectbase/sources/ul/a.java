package ul;

import kn.l0;
import lm.y;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final char[] f16301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16303c;

    /* JADX INFO: renamed from: ul.a$a, reason: collision with other inner class name */
    public static final class C0434a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16304a;

        public C0434a(int i10) {
            this.f16304a = i10;
        }

        @Override // ul.h
        @l
        public Void a() {
            throw new IllegalArgumentException(l0.C("startIndex shouldn't be negative: ", Integer.valueOf(this.f16304a)));
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f16306b;

        public b(int i10, a aVar) {
            this.f16305a = i10;
            this.f16306b = aVar;
        }

        @Override // ul.h
        @l
        public Void a() {
            throw new IllegalArgumentException("startIndex is too large: " + this.f16305a + " > " + this.f16306b.f16303c);
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f16308b;

        public c(int i10, a aVar) {
            this.f16307a = i10;
            this.f16308b = aVar;
        }

        @Override // ul.h
        @l
        public Void a() {
            throw new IllegalArgumentException("endIndex is too large: " + this.f16307a + " > " + this.f16308b.f16303c);
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f16309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16310b;

        public d(int i10, int i11) {
            this.f16309a = i10;
            this.f16310b = i11;
        }

        @Override // ul.h
        @l
        public Void a() {
            throw new IllegalArgumentException("endIndex should be greater or equal to startIndex: " + this.f16309a + " > " + this.f16310b);
        }
    }

    public a(@l char[] cArr, int i10, int i11) {
        l0.p(cArr, dc.d.f3685p);
        this.f16301a = cArr;
        this.f16302b = i10;
        this.f16303c = i11;
    }

    public final char a(int i10) {
        if (i10 < this.f16303c) {
            return this.f16301a[i10 + this.f16302b];
        }
        c(i10);
        throw new y();
    }

    public final int b() {
        return this.f16303c;
    }

    public final Void c(int i10) {
        StringBuilder sbA = h.b.a("String index out of bounds: ", i10, " > ");
        sbA.append(this.f16303c);
        throw new IndexOutOfBoundsException(sbA.toString());
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i10) {
        return a(i10);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return this.f16303c;
    }

    @Override // java.lang.CharSequence
    @l
    public final CharSequence subSequence(int i10, int i11) {
        if (!(i10 >= 0)) {
            new C0434a(i10).a();
            throw new y();
        }
        int i12 = this.f16303c;
        if (!(i10 <= i12)) {
            new b(i10, this).a();
            throw new y();
        }
        if (!(i10 + i11 <= i12)) {
            new c(i11, this).a();
            throw new y();
        }
        if (i11 >= i10) {
            return new a(this.f16301a, this.f16302b + i10, i11 - i10);
        }
        new d(i10, i11).a();
        throw new y();
    }
}
