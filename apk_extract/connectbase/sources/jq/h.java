package jq;

import java.util.Iterator;
import java.util.NoSuchElementException;
import lm.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements gq.m<tn.l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final CharSequence f8809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.p<CharSequence, Integer, t0<Integer, Integer>> f8812d;

    public static final class a implements Iterator<tn.l>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8813a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.m
        public tn.l f8816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8817e;

        public a() {
            int I = tn.u.I(h.this.f8810b, 0, h.this.f8809a.length());
            this.f8814b = I;
            this.f8815c = I;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0023  */
        /* JADX WARN: Code duplicated, block: B:12:0x0037  */
        /* JADX WARN: Code duplicated, block: B:14:0x004b  */
        /* JADX WARN: Code duplicated, block: B:15:0x005f  */
        /* JADX WARN: Code duplicated, block: B:17:0x0080  */
        /* JADX WARN: Code duplicated, block: B:9:0x001b  */
        private final void a() {
            t0<Integer, Integer> t0VarInvoke;
            int i10 = this.f8815c;
            if (i10 < 0) {
                this.f8813a = 0;
                this.f8816d = null;
                return;
            }
            h hVar = h.this;
            int i11 = hVar.f8811c;
            if (i11 > 0) {
                int i12 = this.f8817e + 1;
                this.f8817e = i12;
                if (i12 >= i11) {
                    this.f8816d = new tn.l(this.f8814b, h0.g3(h.this.f8809a), 1);
                    this.f8815c = -1;
                } else if (i10 > hVar.f8809a.length()) {
                    this.f8816d = new tn.l(this.f8814b, h0.g3(h.this.f8809a), 1);
                    this.f8815c = -1;
                } else {
                    h hVar2 = h.this;
                    t0VarInvoke = hVar2.f8812d.invoke(hVar2.f8809a, Integer.valueOf(this.f8815c));
                    if (t0VarInvoke == null) {
                        this.f8816d = new tn.l(this.f8814b, h0.g3(h.this.f8809a), 1);
                        this.f8815c = -1;
                    } else {
                        int iIntValue = t0VarInvoke.component1().intValue();
                        int iIntValue2 = t0VarInvoke.component2().intValue();
                        this.f8816d = tn.u.W1(this.f8814b, iIntValue);
                        int i13 = iIntValue + iIntValue2;
                        this.f8814b = i13;
                        this.f8815c = i13 + (iIntValue2 == 0 ? 1 : 0);
                    }
                }
            } else if (i10 > hVar.f8809a.length()) {
                this.f8816d = new tn.l(this.f8814b, h0.g3(h.this.f8809a), 1);
                this.f8815c = -1;
            } else {
                h hVar3 = h.this;
                t0VarInvoke = hVar3.f8812d.invoke(hVar3.f8809a, Integer.valueOf(this.f8815c));
                if (t0VarInvoke == null) {
                    this.f8816d = new tn.l(this.f8814b, h0.g3(h.this.f8809a), 1);
                    this.f8815c = -1;
                } else {
                    int iIntValue3 = t0VarInvoke.component1().intValue();
                    int iIntValue4 = t0VarInvoke.component2().intValue();
                    this.f8816d = tn.u.W1(this.f8814b, iIntValue3);
                    int i14 = iIntValue3 + iIntValue4;
                    this.f8814b = i14;
                    this.f8815c = i14 + (iIntValue4 == 0 ? 1 : 0);
                }
            }
            this.f8813a = 1;
        }

        public final int c() {
            return this.f8817e;
        }

        public final int e() {
            return this.f8814b;
        }

        @os.m
        public final tn.l f() {
            return this.f8816d;
        }

        public final int g() {
            return this.f8815c;
        }

        public final int h() {
            return this.f8813a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f8813a == -1) {
                a();
            }
            return this.f8813a == 1;
        }

        @Override // java.util.Iterator
        @os.l
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public tn.l next() {
            if (this.f8813a == -1) {
                a();
            }
            if (this.f8813a == 0) {
                throw new NoSuchElementException();
            }
            tn.l lVar = this.f8816d;
            kn.l0.n(lVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f8816d = null;
            this.f8813a = -1;
            return lVar;
        }

        public final void j(int i10) {
            this.f8817e = i10;
        }

        public final void l(int i10) {
            this.f8814b = i10;
        }

        public final void m(@os.m tn.l lVar) {
            this.f8816d = lVar;
        }

        public final void n(int i10) {
            this.f8815c = i10;
        }

        public final void o(int i10) {
            this.f8813a = i10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@os.l CharSequence charSequence, int i10, int i11, @os.l jn.p<? super CharSequence, ? super Integer, t0<Integer, Integer>> pVar) {
        kn.l0.p(charSequence, "input");
        kn.l0.p(pVar, "getNextMatch");
        this.f8809a = charSequence;
        this.f8810b = i10;
        this.f8811c = i11;
        this.f8812d = pVar;
    }

    @Override // gq.m
    @os.l
    public Iterator<tn.l> iterator() {
        return new a();
    }
}
