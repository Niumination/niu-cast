package pj;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13111c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f13112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13113b;

    public a(T[] tArr, int i10) {
        this.f13112a = tArr;
        this.f13113b = i10;
    }

    @Override // pj.i
    public int a() {
        return this.f13112a.length;
    }

    @Override // pj.i
    public int b() {
        return this.f13113b;
    }

    @Override // pj.i
    public String getItem(int i10) {
        if (i10 < 0) {
            return null;
        }
        T[] tArr = this.f13112a;
        if (i10 < tArr.length) {
            return tArr[i10].toString();
        }
        return null;
    }

    public a(T[] tArr) {
        this(tArr, -1);
    }
}
