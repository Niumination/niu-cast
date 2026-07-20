package nm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> implements Iterator<T>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public s1 f11609a = s1.NotReady;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public T f11610b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11611a;

        static {
            int[] iArr = new int[s1.values().length];
            try {
                iArr[s1.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[s1.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f11611a = iArr;
        }
    }

    public abstract void a();

    public final void c() {
        this.f11609a = s1.Done;
    }

    public final void e(T t10) {
        this.f11610b = t10;
        this.f11609a = s1.Ready;
    }

    public final boolean f() {
        this.f11609a = s1.Failed;
        a();
        return this.f11609a == s1.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        s1 s1Var = this.f11609a;
        if (s1Var == s1.Failed) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i10 = a.f11611a[s1Var.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return f();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f11609a = s1.NotReady;
        return this.f11610b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
