package nm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n204#1:208\n204#1:209\n204#1:210\n1#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n106#1:208\n175#1:209\n188#1:210\n*E\n"})
public final class l1<T> extends c<T> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Object[] f11651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11654e;

    @kn.r1({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n+ 2 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n1#1,206:1\n204#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n*L\n121#1:207\n*E\n"})
    public static final class a extends b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ l1<T> f11657e;

        public a(l1<T> l1Var) {
            this.f11657e = l1Var;
            this.f11655c = l1Var.size();
            this.f11656d = l1Var.f11653d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // nm.b
        public void a() {
            if (this.f11655c == 0) {
                this.f11609a = s1.Done;
                return;
            }
            e(this.f11657e.f11651b[this.f11656d]);
            this.f11656d = (this.f11656d + 1) % this.f11657e.f11652c;
            this.f11655c--;
        }
    }

    public l1(@os.l Object[] objArr, int i10) {
        kn.l0.p(objArr, "buffer");
        this.f11651b = objArr;
        if (i10 < 0) {
            throw new IllegalArgumentException(h.a.a("ring buffer filled size should not be negative but it is ", i10).toString());
        }
        if (i10 <= objArr.length) {
            this.f11652c = objArr.length;
            this.f11654e = i10;
        } else {
            StringBuilder sbA = h.b.a("ring buffer filled size: ", i10, " cannot be larger than the buffer size: ");
            sbA.append(objArr.length);
            throw new IllegalArgumentException(sbA.toString().toString());
        }
    }

    public final void f(T t10) {
        if (j()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f11651b[(size() + this.f11653d) % this.f11652c] = t10;
        this.f11654e = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public final l1<T> g(int i10) {
        Object[] array;
        int i11 = this.f11652c;
        int i12 = i11 + (i11 >> 1) + 1;
        if (i12 <= i10) {
            i10 = i12;
        }
        if (this.f11653d == 0) {
            array = Arrays.copyOf(this.f11651b, i10);
            kn.l0.o(array, "copyOf(...)");
        } else {
            array = toArray(new Object[i10]);
        }
        return new l1<>(array, size());
    }

    @Override // nm.c, java.util.List
    public T get(int i10) {
        c.Companion.b(i10, size());
        return (T) this.f11651b[(this.f11653d + i10) % this.f11652c];
    }

    @Override // nm.c, nm.a
    public int getSize() {
        return this.f11654e;
    }

    public final int i(int i10, int i11) {
        return (i10 + i11) % this.f11652c;
    }

    @Override // nm.c, nm.a, java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final boolean j() {
        return size() == this.f11652c;
    }

    public final void l(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(h.a.a("n shouldn't be negative but it is ", i10).toString());
        }
        if (i10 > size()) {
            StringBuilder sbA = h.b.a("n shouldn't be greater than the buffer size: n = ", i10, ", size = ");
            sbA.append(size());
            throw new IllegalArgumentException(sbA.toString().toString());
        }
        if (i10 > 0) {
            int i11 = this.f11653d;
            int i12 = this.f11652c;
            int i13 = (i11 + i10) % i12;
            if (i11 > i13) {
                p.M1(this.f11651b, null, i11, i12);
                p.M1(this.f11651b, null, 0, i13);
            } else {
                p.M1(this.f11651b, null, i11, i13);
            }
            this.f11653d = i13;
            this.f11654e = size() - i10;
        }
    }

    @Override // nm.a, java.util.Collection
    @os.l
    public <T> T[] toArray(@os.l T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        int length = tArr.length;
        Object[] objArr = tArr;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(tArr, size());
            kn.l0.o(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = this.f11653d; i11 < size && i12 < this.f11652c; i12++) {
            objArr[i11] = this.f11651b[i12];
            i11++;
        }
        while (i11 < size) {
            objArr[i11] = this.f11651b[i10];
            i11++;
            i10++;
        }
        return (T[]) x.n(size, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nm.a, java.util.Collection
    @os.l
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public l1(int i10) {
        this(new Object[i10], 0);
    }
}
