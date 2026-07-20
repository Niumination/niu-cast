package f1;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class c<T> extends x7<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f4711a = b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public T f4712b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4713a;

        static {
            int[] iArr = new int[b.values().length];
            f4713a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4713a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    @gm.a
    public abstract T a();

    @gm.a
    @t1.a
    public final T b() {
        this.f4711a = b.DONE;
        return null;
    }

    public final boolean c() {
        this.f4711a = b.FAILED;
        this.f4712b = a();
        if (this.f4711a == b.DONE) {
            return false;
        }
        this.f4711a = b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        c1.h0.g0(this.f4711a != b.FAILED);
        int i10 = a.f4713a[this.f4711a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    @t1.a
    @m5
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f4711a = b.NOT_READY;
        T t10 = this.f4712b;
        this.f4712b = null;
        return t10;
    }

    @m5
    public final T peek() {
        if (hasNext()) {
            return this.f4712b;
        }
        throw new NoSuchElementException();
    }
}
