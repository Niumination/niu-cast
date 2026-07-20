package l3;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class z1 extends r implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z1 f7330d = new z1(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f7331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7332c;

    public z1(Object[] objArr, int i8, boolean z2) {
        super(z2);
        this.f7331b = objArr;
        this.f7332c = i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        int i9;
        e();
        if (i8 < 0 || i8 > (i9 = this.f7332c)) {
            throw new IndexOutOfBoundsException(o.d.f(i8, this.f7332c, "Index:", ", Size:"));
        }
        Object[] objArr = this.f7331b;
        if (i9 < objArr.length) {
            System.arraycopy(objArr, i8, objArr, i8 + 1, i9 - i8);
        } else {
            Object[] objArr2 = new Object[((i9 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i8);
            System.arraycopy(this.f7331b, i8, objArr2, i8 + 1, this.f7332c - i8);
            this.f7331b = objArr2;
        }
        this.f7331b[i8] = obj;
        this.f7332c++;
        ((AbstractList) this).modCount++;
    }

    @Override // l3.y0
    public final /* bridge */ /* synthetic */ y0 b(int i8) {
        if (i8 >= this.f7332c) {
            return new z1(Arrays.copyOf(this.f7331b, i8), this.f7332c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void g(int i8) {
        if (i8 < 0 || i8 >= this.f7332c) {
            throw new IndexOutOfBoundsException(o.d.f(i8, this.f7332c, "Index:", ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        g(i8);
        return this.f7331b[i8];
    }

    @Override // l3.r, java.util.AbstractList, java.util.List
    public final Object remove(int i8) {
        e();
        g(i8);
        Object[] objArr = this.f7331b;
        Object obj = objArr[i8];
        int i9 = this.f7332c;
        if (i8 < i9 - 1) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, (i9 - i8) - 1);
        }
        this.f7332c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        e();
        g(i8);
        Object[] objArr = this.f7331b;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7332c;
    }

    @Override // l3.r, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        e();
        int i8 = this.f7332c;
        Object[] objArr = this.f7331b;
        if (i8 == objArr.length) {
            this.f7331b = Arrays.copyOf(objArr, ((i8 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f7331b;
        int i9 = this.f7332c;
        this.f7332c = i9 + 1;
        objArr2[i9] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
