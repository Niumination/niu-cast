package kn;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final T[] f9298c;

    public c1(int i10) {
        this.f9296a = i10;
        this.f9298c = (T[]) new Object[i10];
    }

    public static /* synthetic */ void d() {
    }

    public final void a(@os.l T t10) {
        l0.p(t10, "spreadArgument");
        T[] tArr = this.f9298c;
        int i10 = this.f9297b;
        this.f9297b = i10 + 1;
        tArr[i10] = t10;
    }

    public final int b() {
        return this.f9297b;
    }

    public abstract int c(@os.l T t10);

    public final void e(int i10) {
        this.f9297b = i10;
    }

    public final int f() {
        int iC = 0;
        nm.v0 it = new tn.l(0, this.f9296a - 1, 1).iterator();
        while (it.hasNext()) {
            T t10 = this.f9298c[it.nextInt()];
            iC += t10 != null ? c(t10) : 1;
        }
        return iC;
    }

    @os.l
    public final T g(@os.l T t10, @os.l T t11) {
        l0.p(t10, "values");
        l0.p(t11, "result");
        nm.v0 it = new tn.l(0, this.f9296a - 1, 1).iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            T t12 = this.f9298c[iNextInt];
            if (t12 != null) {
                if (i10 < iNextInt) {
                    int i12 = iNextInt - i10;
                    System.arraycopy(t10, i10, t11, i11, i12);
                    i11 += i12;
                }
                int iC = c(t12);
                System.arraycopy(t12, 0, t11, i11, iC);
                i11 += iC;
                i10 = iNextInt + 1;
            }
        }
        int i13 = this.f9296a;
        if (i10 < i13) {
            System.arraycopy(t10, i10, t11, i11, i13 - i10);
        }
        return t11;
    }
}
