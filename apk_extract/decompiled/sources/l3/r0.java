package l3;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class r0 extends r implements RandomAccess, w0, x1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r0 f7287d = new r0(new int[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f7288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7289c;

    public r0(int[] iArr, int i8, boolean z2) {
        super(z2);
        this.f7288b = iArr;
        this.f7289c = i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        int i9;
        int iIntValue = ((Integer) obj).intValue();
        e();
        if (i8 < 0 || i8 > (i9 = this.f7289c)) {
            throw new IndexOutOfBoundsException(o.d.f(i8, this.f7289c, "Index:", ", Size:"));
        }
        int[] iArr = this.f7288b;
        if (i9 < iArr.length) {
            System.arraycopy(iArr, i8, iArr, i8 + 1, i9 - i8);
        } else {
            int[] iArr2 = new int[((i9 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i8);
            System.arraycopy(this.f7288b, i8, iArr2, i8 + 1, this.f7289c - i8);
            this.f7288b = iArr2;
        }
        this.f7288b[i8] = iIntValue;
        this.f7289c++;
        ((AbstractList) this).modCount++;
    }

    @Override // l3.r, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e();
        Charset charset = z0.f7328a;
        collection.getClass();
        if (!(collection instanceof r0)) {
            return super.addAll(collection);
        }
        r0 r0Var = (r0) collection;
        int i8 = r0Var.f7289c;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f7289c;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        int[] iArr = this.f7288b;
        if (i10 > iArr.length) {
            this.f7288b = Arrays.copyOf(iArr, i10);
        }
        System.arraycopy(r0Var.f7288b, 0, this.f7288b, this.f7289c, r0Var.f7289c);
        this.f7289c = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // l3.y0
    public final /* bridge */ /* synthetic */ y0 b(int i8) {
        if (i8 >= this.f7289c) {
            return new r0(Arrays.copyOf(this.f7288b, i8), this.f7289c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // l3.r, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return super.equals(obj);
        }
        r0 r0Var = (r0) obj;
        if (this.f7289c != r0Var.f7289c) {
            return false;
        }
        int[] iArr = r0Var.f7288b;
        for (int i8 = 0; i8 < this.f7289c; i8++) {
            if (this.f7288b[i8] != iArr[i8]) {
                return false;
            }
        }
        return true;
    }

    public final void g(int i8) {
        e();
        int i9 = this.f7289c;
        int[] iArr = this.f7288b;
        if (i9 == iArr.length) {
            int[] iArr2 = new int[((i9 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i9);
            this.f7288b = iArr2;
        }
        int[] iArr3 = this.f7288b;
        int i10 = this.f7289c;
        this.f7289c = i10 + 1;
        iArr3[i10] = i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        h(i8);
        return Integer.valueOf(this.f7288b[i8]);
    }

    public final void h(int i8) {
        if (i8 < 0 || i8 >= this.f7289c) {
            throw new IndexOutOfBoundsException(o.d.f(i8, this.f7289c, "Index:", ", Size:"));
        }
    }

    @Override // l3.r, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f7289c; i9++) {
            i8 = (i8 * 31) + this.f7288b[i9];
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i8 = this.f7289c;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.f7288b[i9] == iIntValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // l3.r, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        e();
        h(i8);
        int[] iArr = this.f7288b;
        int i9 = iArr[i8];
        int i10 = this.f7289c;
        if (i8 < i10 - 1) {
            System.arraycopy(iArr, i8 + 1, iArr, i8, (i10 - i8) - 1);
        }
        this.f7289c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i9);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i8, int i9) {
        e();
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f7288b;
        System.arraycopy(iArr, i9, iArr, i8, this.f7289c - i9);
        this.f7289c -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        e();
        h(i8);
        int[] iArr = this.f7288b;
        int i9 = iArr[i8];
        iArr[i8] = iIntValue;
        return Integer.valueOf(i9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7289c;
    }

    @Override // l3.r, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Integer) obj).intValue());
        return true;
    }
}
