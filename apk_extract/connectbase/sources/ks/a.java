package ks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Appendable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char f9444c = 27;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char f9445d = '[';

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9446e = a.class.getName().concat(".disable");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Callable<Boolean> f9447f = new CallableC0249a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final InheritableThreadLocal<Boolean> f9448g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f9449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f9450b;

    /* JADX INFO: renamed from: ks.a$a, reason: collision with other inner class name */
    public class CallableC0249a implements Callable<Boolean> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(!Boolean.getBoolean(a.f9446e));
        }
    }

    public class b extends InheritableThreadLocal<Boolean> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            return Boolean.valueOf(a.L0());
        }
    }

    public enum c {
        RESET(0, "RESET"),
        INTENSITY_BOLD(1, "INTENSITY_BOLD"),
        INTENSITY_FAINT(2, "INTENSITY_FAINT"),
        ITALIC(3, "ITALIC_ON"),
        UNDERLINE(4, "UNDERLINE_ON"),
        BLINK_SLOW(5, "BLINK_SLOW"),
        BLINK_FAST(6, "BLINK_FAST"),
        NEGATIVE_ON(7, "NEGATIVE_ON"),
        CONCEAL_ON(8, "CONCEAL_ON"),
        STRIKETHROUGH_ON(9, "STRIKETHROUGH_ON"),
        UNDERLINE_DOUBLE(21, "UNDERLINE_DOUBLE"),
        INTENSITY_BOLD_OFF(22, "INTENSITY_BOLD_OFF"),
        ITALIC_OFF(23, "ITALIC_OFF"),
        UNDERLINE_OFF(24, "UNDERLINE_OFF"),
        BLINK_OFF(25, "BLINK_OFF"),
        NEGATIVE_OFF(27, "NEGATIVE_OFF"),
        CONCEAL_OFF(28, "CONCEAL_OFF"),
        STRIKETHROUGH_OFF(29, "STRIKETHROUGH_OFF");

        private final String name;
        private final int value;

        c(int i10, String str) {
            this.value = i10;
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public int value() {
            return this.value;
        }
    }

    public enum d {
        BLACK(0, "BLACK"),
        RED(1, "RED"),
        GREEN(2, "GREEN"),
        YELLOW(3, "YELLOW"),
        BLUE(4, "BLUE"),
        MAGENTA(5, "MAGENTA"),
        CYAN(6, "CYAN"),
        WHITE(7, "WHITE"),
        DEFAULT(9, "DEFAULT");

        private final String name;
        private final int value;

        d(int i10, String str) {
            this.value = i10;
            this.name = str;
        }

        public int bg() {
            return this.value + 40;
        }

        public int bgBright() {
            return this.value + 100;
        }

        public int fg() {
            return this.value + 30;
        }

        public int fgBright() {
            return this.value + 90;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public int value() {
            return this.value;
        }
    }

    public interface e {
        void a(a aVar);
    }

    public enum f {
        FORWARD(0, "FORWARD"),
        BACKWARD(1, "BACKWARD"),
        ALL(2, "ALL");

        private final String name;
        private final int value;

        f(int i10, String str) {
            this.value = i10;
            this.name = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }

        public int value() {
            return this.value;
        }
    }

    public static class g extends a {
        public g() {
        }

        @Override // ks.a
        public a C(int i10) {
            return this;
        }

        @Override // ks.a
        public a D(d dVar) {
            return this;
        }

        @Override // ks.a
        public a E(d dVar) {
            return this;
        }

        @Override // ks.a
        public a H0(int i10, int i11, int i12) {
            return this;
        }

        @Override // ks.a
        public a S(int i10, int i11, int i12) {
            return this;
        }

        @Override // ks.a
        public a S0() {
            return this;
        }

        @Override // ks.a
        @Deprecated
        public a T0() {
            return this;
        }

        @Override // ks.a
        public a U0() {
            return this;
        }

        @Override // ks.a
        public a V0() {
            return this;
        }

        @Override // ks.a
        public a W(int i10, int i11) {
            return this;
        }

        @Override // ks.a
        public a W0(int i10) {
            return this;
        }

        @Override // ks.a
        public a X(int i10) {
            return this;
        }

        @Override // ks.a
        public a X0(int i10) {
            return this;
        }

        @Override // ks.a
        public a Z() {
            return this;
        }

        @Override // ks.a, java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            this.f9449a.append(charSequence);
            return this;
        }

        @Override // ks.a
        public a b0(int i10) {
            return this;
        }

        @Override // ks.a
        public a c0(int i10) {
            return this;
        }

        @Override // ks.a
        public a e0(int i10) {
            return this;
        }

        @Override // ks.a
        public a f0(int i10) {
            return this;
        }

        @Override // ks.a
        public a g0(int i10) {
            return this;
        }

        @Override // ks.a
        public a i0() {
            return this;
        }

        @Override // ks.a
        public a j0(int i10) {
            return this;
        }

        @Override // ks.a
        public a k0() {
            return this;
        }

        @Override // ks.a
        public a l0(f fVar) {
            return this;
        }

        @Override // ks.a
        public a m0() {
            return this;
        }

        @Override // ks.a
        public a n(c cVar) {
            return this;
        }

        @Override // ks.a
        public a n0(f fVar) {
            return this;
        }

        @Override // ks.a
        public a o0(int i10) {
            return this;
        }

        @Override // ks.a
        public a p0(d dVar) {
            return this;
        }

        @Override // ks.a
        public a s0(d dVar) {
            return this;
        }

        public g(int i10) {
            super(i10);
        }

        @Override // ks.a, java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i10, int i11) throws IOException {
            this.f9449a.append(charSequence, i10, i11);
            return this;
        }

        public g(StringBuilder sb2) {
            super(sb2);
        }

        @Override // ks.a, java.lang.Appendable
        public Appendable append(char c10) throws IOException {
            this.f9449a.append(c10);
            return this;
        }
    }

    public a() {
        this(new StringBuilder(80));
    }

    public static boolean L0() {
        try {
            return f9447f.call().booleanValue();
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean N0() {
        return f9448g.get().booleanValue();
    }

    public static void Y0(Callable<Boolean> callable) {
        if (callable == null) {
            throw new IllegalArgumentException();
        }
        f9447f = callable;
    }

    public static void Z0(boolean z10) {
        f9448g.set(Boolean.valueOf(z10));
    }

    public static a r() {
        return N0() ? new a() : new g();
    }

    public static a s(int i10) {
        return N0() ? new a(i10) : new g(i10);
    }

    public static a t(StringBuilder sb2) {
        return N0() ? new a(sb2) : new g(sb2);
    }

    public a A(e eVar) {
        eVar.a(this);
        return this;
    }

    public a A0() {
        return s0(d.YELLOW);
    }

    public a B0() {
        return p0(d.CYAN);
    }

    public a C(int i10) {
        this.f9450b.add(48);
        this.f9450b.add(5);
        this.f9450b.add(Integer.valueOf(i10 & 255));
        return this;
    }

    public a C0() {
        return p0(d.DEFAULT);
    }

    public a D(d dVar) {
        this.f9450b.add(Integer.valueOf(dVar.bg()));
        return this;
    }

    public a D0() {
        return p0(d.GREEN);
    }

    public a E(d dVar) {
        this.f9450b.add(Integer.valueOf(dVar.bgBright()));
        return this;
    }

    public a E0() {
        return p0(d.MAGENTA);
    }

    public a F0() {
        return p0(d.RED);
    }

    public a G() {
        return E(d.CYAN);
    }

    public a G0(int i10) {
        return H0(i10 >> 16, i10 >> 8, i10);
    }

    public a H() {
        return E(d.DEFAULT);
    }

    public a H0(int i10, int i11, int i12) {
        this.f9450b.add(38);
        this.f9450b.add(2);
        this.f9450b.add(Integer.valueOf(i10 & 255));
        this.f9450b.add(Integer.valueOf(i11 & 255));
        this.f9450b.add(Integer.valueOf(i12 & 255));
        return this;
    }

    public a I() {
        return E(d.GREEN);
    }

    public a I0() {
        return p0(d.YELLOW);
    }

    public a J() {
        return E(d.MAGENTA);
    }

    public final void J0() {
        if (this.f9450b.isEmpty()) {
            return;
        }
        if (this.f9450b.size() == 1 && this.f9450b.get(0).intValue() == 0) {
            this.f9449a.append(f9444c);
            this.f9449a.append(f9445d);
            this.f9449a.append(kl.f.f9271d);
        } else {
            a(kl.f.f9271d, this.f9450b.toArray());
        }
        this.f9450b.clear();
    }

    public a K() {
        return E(d.RED);
    }

    public a K0(String str, Object... objArr) {
        J0();
        this.f9449a.append(String.format(str, objArr));
        return this;
    }

    public a L() {
        return E(d.YELLOW);
    }

    public a M() {
        return D(d.CYAN);
    }

    public a N() {
        return D(d.DEFAULT);
    }

    public a O() {
        return D(d.GREEN);
    }

    public a O0() {
        J0();
        this.f9449a.append(System.getProperty("line.separator"));
        return this;
    }

    public a P() {
        return D(d.MAGENTA);
    }

    public a P0(String str) {
        l(ks.g.b(str));
        return this;
    }

    public a Q() {
        return D(d.RED);
    }

    public a Q0(String str, Object... objArr) {
        l(String.format(ks.g.b(str), objArr));
        return this;
    }

    public a R(int i10) {
        return S(i10 >> 16, i10 >> 8, i10);
    }

    public a S(int i10, int i11, int i12) {
        this.f9450b.add(48);
        this.f9450b.add(2);
        this.f9450b.add(Integer.valueOf(i10 & 255));
        this.f9450b.add(Integer.valueOf(i11 & 255));
        this.f9450b.add(Integer.valueOf(i12 & 255));
        return this;
    }

    public a S0() {
        return n(c.RESET);
    }

    public a T() {
        return D(d.YELLOW);
    }

    @Deprecated
    public a T0() {
        return x('u');
    }

    public a U() {
        return n(c.INTENSITY_BOLD);
    }

    public a U0() {
        return x('u');
    }

    public a V() {
        return n(c.INTENSITY_BOLD_OFF);
    }

    public a V0() {
        return x(kl.f.f9270c);
    }

    public a W(int i10, int i11) {
        return z('H', Integer.valueOf(Math.max(1, i10)), Integer.valueOf(Math.max(1, i11)));
    }

    public a W0(int i10) {
        if (i10 > 0) {
            return y('T', i10);
        }
        return i10 < 0 ? X0(-i10) : this;
    }

    public a X(int i10) {
        if (i10 > 0) {
            return y('B', i10);
        }
        return i10 < 0 ? g0(-i10) : this;
    }

    public a X0(int i10) {
        if (i10 > 0) {
            return y('S', i10);
        }
        return i10 < 0 ? W0(-i10) : this;
    }

    public a Z() {
        return x('E');
    }

    public final a a(char c10, Object... objArr) {
        this.f9449a.append(f9444c);
        this.f9449a.append(f9445d);
        int length = objArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                this.f9449a.append(';');
            }
            Object obj = objArr[i10];
            if (obj != null) {
                this.f9449a.append(obj);
            }
        }
        this.f9449a.append(c10);
        return this;
    }

    public a b(char c10) {
        J0();
        this.f9449a.append(c10);
        return this;
    }

    public a b0(int i10) {
        return i10 < 0 ? j0(-i10) : y('E', i10);
    }

    public a c(double d10) {
        J0();
        this.f9449a.append(d10);
        return this;
    }

    public a c0(int i10) {
        if (i10 > 0) {
            return y('D', i10);
        }
        return i10 < 0 ? e0(-i10) : this;
    }

    public a d(float f10) {
        J0();
        this.f9449a.append(f10);
        return this;
    }

    public a d0(int i10, int i11) {
        return e0(i10).X(i11);
    }

    public a e(int i10) {
        J0();
        this.f9449a.append(i10);
        return this;
    }

    public a e0(int i10) {
        if (i10 > 0) {
            return y(y5.a.I, i10);
        }
        return i10 < 0 ? c0(-i10) : this;
    }

    public a f(long j10) {
        J0();
        this.f9449a.append(j10);
        return this;
    }

    public a f0(int i10) {
        return y('G', Math.max(1, i10));
    }

    public a g0(int i10) {
        if (i10 > 0) {
            return y(y5.a.G, i10);
        }
        return i10 < 0 ? X(-i10) : this;
    }

    public a h(CharSequence charSequence) {
        J0();
        this.f9449a.append(charSequence);
        return this;
    }

    public a i(CharSequence charSequence, int i10, int i11) {
        J0();
        this.f9449a.append(charSequence, i10, i11);
        return this;
    }

    public a i0() {
        return x('F');
    }

    public a j0(int i10) {
        return i10 < 0 ? b0(-i10) : y('F', i10);
    }

    public a k(Object obj) {
        J0();
        this.f9449a.append(obj);
        return this;
    }

    public a k0() {
        return x('K');
    }

    public a l(String str) {
        J0();
        this.f9449a.append(str);
        return this;
    }

    public a l0(f fVar) {
        return y('K', fVar.value());
    }

    public a m(StringBuffer stringBuffer) {
        J0();
        this.f9449a.append(stringBuffer);
        return this;
    }

    public a m0() {
        return y('J', f.ALL.value());
    }

    public a n(c cVar) {
        this.f9450b.add(Integer.valueOf(cVar.value()));
        return this;
    }

    public a n0(f fVar) {
        return y('J', fVar.value());
    }

    public a o(boolean z10) {
        J0();
        this.f9449a.append(z10);
        return this;
    }

    public a o0(int i10) {
        this.f9450b.add(38);
        this.f9450b.add(5);
        this.f9450b.add(Integer.valueOf(i10 & 255));
        return this;
    }

    public a p(char[] cArr) {
        J0();
        this.f9449a.append(cArr);
        return this;
    }

    public a p0(d dVar) {
        this.f9450b.add(Integer.valueOf(dVar.fg()));
        return this;
    }

    public a q(char[] cArr, int i10, int i11) {
        J0();
        this.f9449a.append(cArr, i10, i11);
        return this;
    }

    public a q0() {
        return p0(d.BLACK);
    }

    public a r0() {
        return p0(d.BLUE);
    }

    public a s0(d dVar) {
        this.f9450b.add(Integer.valueOf(dVar.fgBright()));
        return this;
    }

    public a t0() {
        return s0(d.BLACK);
    }

    public String toString() {
        J0();
        return this.f9449a.toString();
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public a append(char c10) {
        this.f9449a.append(c10);
        return this;
    }

    public a u0() {
        return s0(d.BLUE);
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public a append(CharSequence charSequence) {
        this.f9449a.append(charSequence);
        return this;
    }

    public a v0() {
        return s0(d.CYAN);
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public a append(CharSequence charSequence, int i10, int i11) {
        this.f9449a.append(charSequence, i10, i11);
        return this;
    }

    public a w0() {
        return s0(d.DEFAULT);
    }

    public final a x(char c10) {
        J0();
        this.f9449a.append(f9444c);
        this.f9449a.append(f9445d);
        this.f9449a.append(c10);
        return this;
    }

    public a x0() {
        return s0(d.GREEN);
    }

    public final a y(char c10, int i10) {
        J0();
        this.f9449a.append(f9444c);
        this.f9449a.append(f9445d);
        this.f9449a.append(i10);
        this.f9449a.append(c10);
        return this;
    }

    public a y0() {
        return s0(d.MAGENTA);
    }

    public final a z(char c10, Object... objArr) {
        J0();
        return a(c10, objArr);
    }

    public a z0() {
        return s0(d.RED);
    }

    public a(a aVar) {
        this(new StringBuilder(aVar.f9449a));
        this.f9450b.addAll(aVar.f9450b);
    }

    public a(int i10) {
        this(new StringBuilder(i10));
    }

    public a(StringBuilder sb2) {
        this.f9450b = new ArrayList<>(5);
        this.f9449a = sb2;
    }
}
