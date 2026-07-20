package f1;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f5001a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k0 f5002b = new b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k0 f5003c = new b(1);

    public class a extends k0 {
        @Override // f1.k0
        public k0 d(double left, double right) {
            return o(Double.compare(left, right));
        }

        @Override // f1.k0
        public k0 e(float left, float right) {
            return o(Float.compare(left, right));
        }

        @Override // f1.k0
        public k0 f(int left, int right) {
            return o(o1.l.e(left, right));
        }

        @Override // f1.k0
        public k0 g(long left, long right) {
            return o(o1.n.e(left, right));
        }

        @Override // f1.k0
        public k0 i(Comparable<?> left, Comparable<?> right) {
            return o(left.compareTo(right));
        }

        @Override // f1.k0
        public <T> k0 j(@m5 T left, @m5 T right, Comparator<T> comparator) {
            return o(comparator.compare(left, right));
        }

        @Override // f1.k0
        public k0 k(boolean left, boolean right) {
            return o(o1.a.d(left, right));
        }

        @Override // f1.k0
        public k0 l(boolean left, boolean right) {
            return o(o1.a.d(right, left));
        }

        @Override // f1.k0
        public int m() {
            return 0;
        }

        public k0 o(int result) {
            if (result < 0) {
                return k0.f5002b;
            }
            return result > 0 ? k0.f5003c : k0.f5001a;
        }
    }

    public static final class b extends k0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5004d;

        public b(int result) {
            this.f5004d = result;
        }

        @Override // f1.k0
        public k0 d(double left, double right) {
            return this;
        }

        @Override // f1.k0
        public k0 e(float left, float right) {
            return this;
        }

        @Override // f1.k0
        public k0 f(int left, int right) {
            return this;
        }

        @Override // f1.k0
        public k0 g(long left, long right) {
            return this;
        }

        @Override // f1.k0
        public k0 i(Comparable<?> left, Comparable<?> right) {
            return this;
        }

        @Override // f1.k0
        public <T> k0 j(@m5 T left, @m5 T right, Comparator<T> comparator) {
            return this;
        }

        @Override // f1.k0
        public k0 k(boolean left, boolean right) {
            return this;
        }

        @Override // f1.k0
        public k0 l(boolean left, boolean right) {
            return this;
        }

        @Override // f1.k0
        public int m() {
            return this.f5004d;
        }
    }

    public k0() {
    }

    public static k0 n() {
        return f5001a;
    }

    public abstract k0 d(double left, double right);

    public abstract k0 e(float left, float right);

    public abstract k0 f(int left, int right);

    public abstract k0 g(long left, long right);

    @Deprecated
    public final k0 h(Boolean left, Boolean right) {
        return k(left.booleanValue(), right.booleanValue());
    }

    public abstract k0 i(Comparable<?> left, Comparable<?> right);

    public abstract <T> k0 j(@m5 T left, @m5 T right, Comparator<T> comparator);

    public abstract k0 k(boolean left, boolean right);

    public abstract k0 l(boolean left, boolean right);

    public abstract int m();

    public k0(a aVar) {
    }
}
