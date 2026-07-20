package l3;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends r implements RandomAccess, v0, x1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k0 f7255d = new k0(new float[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f7256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7257c;

    public k0(float[] fArr, int i8, boolean z2) {
        super(z2);
        this.f7256b = fArr;
        this.f7257c = i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        int i9;
        float fFloatValue = ((Float) obj).floatValue();
        e();
        if (i8 < 0 || i8 > (i9 = this.f7257c)) {
            throw new IndexOutOfBoundsException(o.d.f(i8, this.f7257c, "Index:", ", Size:"));
        }
        float[] fArr = this.f7256b;
        if (i9 < fArr.length) {
            System.arraycopy(fArr, i8, fArr, i8 + 1, i9 - i8);
        } else {
            float[] fArr2 = new float[((i9 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i8);
            System.arraycopy(this.f7256b, i8, fArr2, i8 + 1, this.f7257c - i8);
            this.f7256b = fArr2;
        }
        this.f7256b[i8] = fFloatValue;
        this.f7257c++;
        ((AbstractList) this).modCount++;
    }

    @Override // l3.r, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        e();
        Charset charset = z0.f7328a;
        collection.getClass();
        if (!(collection instanceof k0)) {
            return super.addAll(collection);
        }
        k0 k0Var = (k0) collection;
        int i8 = k0Var.f7257c;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f7257c;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        float[] fArr = this.f7256b;
        if (i10 > fArr.length) {
            this.f7256b = Arrays.copyOf(fArr, i10);
        }
        System.arraycopy(k0Var.f7256b, 0, this.f7256b, this.f7257c, k0Var.f7257c);
        this.f7257c = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // l3.y0
    public final y0 b(int i8) {
        if (i8 >= this.f7257c) {
            return new k0(Arrays.copyOf(this.f7256b, i8), this.f7257c, true);
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
        if (!(obj instanceof k0)) {
            return super.equals(obj);
        }
        k0 k0Var = (k0) obj;
        if (this.f7257c != k0Var.f7257c) {
            return false;
        }
        float[] fArr = k0Var.f7256b;
        for (int i8 = 0; i8 < this.f7257c; i8++) {
            if (Float.floatToIntBits(this.f7256b[i8]) != Float.floatToIntBits(fArr[i8])) {
                return false;
            }
        }
        return true;
    }

    public final void g(float f) {
        e();
        int i8 = this.f7257c;
        float[] fArr = this.f7256b;
        if (i8 == fArr.length) {
            float[] fArr2 = new float[((i8 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i8);
            this.f7256b = fArr2;
        }
        float[] fArr3 = this.f7256b;
        int i9 = this.f7257c;
        this.f7257c = i9 + 1;
        fArr3[i9] = f;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        h(i8);
        return Float.valueOf(this.f7256b[i8]);
    }

    public final void h(int i8) {
        if (i8 < 0 || i8 >= this.f7257c) {
            throw new IndexOutOfBoundsException(o.d.f(i8, this.f7257c, "Index:", ", Size:"));
        }
    }

    @Override // l3.r, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i8 = 0; i8 < this.f7257c; i8++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f7256b[i8]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i8 = this.f7257c;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.f7256b[i9] == fFloatValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // l3.r, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        e();
        h(i8);
        float[] fArr = this.f7256b;
        float f = fArr[i8];
        int i9 = this.f7257c;
        if (i8 < i9 - 1) {
            System.arraycopy(fArr, i8 + 1, fArr, i8, (i9 - i8) - 1);
        }
        this.f7257c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i8, int i9) {
        e();
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f7256b;
        System.arraycopy(fArr, i9, fArr, i8, this.f7257c - i9);
        this.f7257c -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        e();
        h(i8);
        float[] fArr = this.f7256b;
        float f = fArr[i8];
        fArr[i8] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7257c;
    }

    @Override // l3.r, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        g(((Float) obj).floatValue());
        return true;
    }
}
