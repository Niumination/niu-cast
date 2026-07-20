package c1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public abstract class b<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0047b f1103a = EnumC0047b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public T f1104b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1105a;

        static {
            int[] iArr = new int[EnumC0047b.values().length];
            f1105a = iArr;
            try {
                iArr[EnumC0047b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1105a[EnumC0047b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: c1.b$b, reason: collision with other inner class name */
    public enum EnumC0047b {
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
        this.f1103a = EnumC0047b.DONE;
        return null;
    }

    public final boolean c() {
        this.f1103a = EnumC0047b.FAILED;
        this.f1104b = a();
        if (this.f1103a == EnumC0047b.DONE) {
            return false;
        }
        this.f1103a = EnumC0047b.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        h0.g0(this.f1103a != EnumC0047b.FAILED);
        int i10 = a.f1105a[this.f1103a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    @e0
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f1103a = EnumC0047b.NOT_READY;
        T t10 = this.f1104b;
        this.f1104b = null;
        return t10;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
