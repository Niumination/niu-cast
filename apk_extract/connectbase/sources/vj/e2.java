package vj;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class e2 {

    public static final class a<K, V> implements d<K, V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ boolean f17110c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K[] f17111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V[] f17112b;

        public a(K k10, V v10, K k11, V v11) {
            this(new Object[]{k10, k11}, new Object[]{v10, v11});
        }

        @Override // vj.e2.d
        public V a(K k10, int i10, int i11) {
            int i12 = 0;
            while (true) {
                K[] kArr = this.f17111a;
                if (i12 >= kArr.length) {
                    return null;
                }
                if (kArr[i12] == k10) {
                    return this.f17112b[i12];
                }
                i12++;
            }
        }

        @Override // vj.e2.d
        public d<K, V> b(K k10, V v10, int i10, int i11) {
            int iHashCode = this.f17111a[0].hashCode();
            if (iHashCode != i10) {
                return b.c(new c(k10, v10), i10, this, iHashCode, i11);
            }
            int iC = c(k10);
            if (iC != -1) {
                K[] kArr = this.f17111a;
                Object[] objArrCopyOf = Arrays.copyOf(kArr, kArr.length);
                Object[] objArrCopyOf2 = Arrays.copyOf(this.f17112b, this.f17111a.length);
                objArrCopyOf[iC] = k10;
                objArrCopyOf2[iC] = v10;
                return new a(objArrCopyOf, objArrCopyOf2);
            }
            K[] kArr2 = this.f17111a;
            Object[] objArrCopyOf3 = Arrays.copyOf(kArr2, kArr2.length + 1);
            Object[] objArrCopyOf4 = Arrays.copyOf(this.f17112b, this.f17111a.length + 1);
            K[] kArr3 = this.f17111a;
            objArrCopyOf3[kArr3.length] = k10;
            objArrCopyOf4[kArr3.length] = v10;
            return new a(objArrCopyOf3, objArrCopyOf4);
        }

        public final int c(K k10) {
            int i10 = 0;
            while (true) {
                K[] kArr = this.f17111a;
                if (i10 >= kArr.length) {
                    return -1;
                }
                if (kArr[i10] == k10) {
                    return i10;
                }
                i10++;
            }
        }

        @Override // vj.e2.d
        public int size() {
            return this.f17112b.length;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("CollisionLeaf(");
            for (int i10 = 0; i10 < this.f17112b.length; i10++) {
                sb2.append("(key=");
                sb2.append(this.f17111a[i10]);
                sb2.append(" value=");
                sb2.append(this.f17112b[i10]);
                sb2.append(") ");
            }
            sb2.append(")");
            return sb2.toString();
        }

        public a(K[] kArr, V[] vArr) {
            this.f17111a = kArr;
            this.f17112b = vArr;
        }
    }

    public static final class b<K, V> implements d<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f17113d = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f17114e = 31;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ boolean f17115f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d<K, V>[] f17117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17118c;

        public b(int i10, d<K, V>[] dVarArr, int i11) {
            this.f17116a = i10;
            this.f17117b = dVarArr;
            this.f17118c = i11;
        }

        public static <K, V> d<K, V> c(d<K, V> dVar, int i10, d<K, V> dVar2, int i11, int i12) {
            int iE = e(i10, i12);
            int iE2 = e(i11, i12);
            if (iE == iE2) {
                d dVarC = c(dVar, i10, dVar2, i11, i12 + 5);
                return new b(iE, new d[]{dVarC}, dVarC.size());
            }
            if (f(i10, i12) > f(i11, i12)) {
                dVar2 = dVar;
                dVar = dVar2;
            }
            return new b(iE | iE2, new d[]{dVar, dVar2}, dVar2.size() + dVar.size());
        }

        public static int e(int i10, int i11) {
            return 1 << f(i10, i11);
        }

        public static int f(int i10, int i11) {
            return (i10 >>> i11) & 31;
        }

        @Override // vj.e2.d
        public V a(K k10, int i10, int i11) {
            int iE = e(i10, i11);
            if ((this.f17116a & iE) == 0) {
                return null;
            }
            return this.f17117b[d(iE)].a(k10, i10, i11 + 5);
        }

        @Override // vj.e2.d
        public d<K, V> b(K k10, V v10, int i10, int i11) {
            int iE = e(i10, i11);
            int iD = d(iE);
            int i12 = this.f17116a;
            if ((i12 & iE) != 0) {
                d<K, V>[] dVarArr = this.f17117b;
                d[] dVarArr2 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length);
                d<K, V> dVarB = this.f17117b[iD].b(k10, v10, i10, i11 + 5);
                dVarArr2[iD] = dVarB;
                return new b(this.f17116a, dVarArr2, (dVarB.size() + this.f17118c) - this.f17117b[iD].size());
            }
            int i13 = i12 | iE;
            d<K, V>[] dVarArr3 = this.f17117b;
            d[] dVarArr4 = new d[dVarArr3.length + 1];
            System.arraycopy(dVarArr3, 0, dVarArr4, 0, iD);
            dVarArr4[iD] = new c(k10, v10);
            d<K, V>[] dVarArr5 = this.f17117b;
            System.arraycopy(dVarArr5, iD, dVarArr4, iD + 1, dVarArr5.length - iD);
            return new b(i13, dVarArr4, this.f17118c + 1);
        }

        public final int d(int i10) {
            return Integer.bitCount(this.f17116a & (i10 - 1));
        }

        @Override // vj.e2.d
        public int size() {
            return this.f17118c;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("CompressedIndex(");
            sb2.append(String.format("bitmap=%s ", Integer.toBinaryString(this.f17116a)));
            for (d<K, V> dVar : this.f17117b) {
                sb2.append(dVar);
                sb2.append(" ");
            }
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class c<K, V> implements d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f17119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f17120b;

        public c(K k10, V v10) {
            this.f17119a = k10;
            this.f17120b = v10;
        }

        @Override // vj.e2.d
        public V a(K k10, int i10, int i11) {
            if (this.f17119a == k10) {
                return this.f17120b;
            }
            return null;
        }

        @Override // vj.e2.d
        public d<K, V> b(K k10, V v10, int i10, int i11) {
            int iHashCode = this.f17119a.hashCode();
            if (iHashCode != i10) {
                return b.c(new c(k10, v10), i10, this, iHashCode, i11);
            }
            return this.f17119a == k10 ? new c(k10, v10) : new a(this.f17119a, this.f17120b, k10, v10);
        }

        @Override // vj.e2.d
        public int size() {
            return 1;
        }

        public String toString() {
            return String.format("Leaf(key=%s value=%s)", this.f17119a, this.f17120b);
        }
    }

    public interface d<K, V> {
        V a(K k10, int i10, int i11);

        d<K, V> b(K k10, V v10, int i10, int i11);

        int size();
    }

    public static <K, V> V a(d<K, V> dVar, K k10) {
        if (dVar == null) {
            return null;
        }
        return dVar.a(k10, k10.hashCode(), 0);
    }

    public static <K, V> d<K, V> b(d<K, V> dVar, K k10, V v10) {
        return dVar == null ? new c(k10, v10) : dVar.b(k10, v10, k10.hashCode(), 0);
    }
}
