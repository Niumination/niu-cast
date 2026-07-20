package i4;

import java.util.Arrays;
import java.util.Objects;
import k3.f9;
import k3.v8;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public final class u4 extends t0 {
    static final t0 EMPTY = new u4(new Object[0], 0, null);
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    public final transient Object e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient int f5701h;

    public u4(Object[] objArr, int i8, Object obj) {
        this.e = obj;
        this.alternatingKeysAndValues = objArr;
        this.f5701h = i8;
    }

    public static Object a(Object[] objArr, int i8, int i9, int i10) {
        l0 l0Var = null;
        if (i8 == 1) {
            Objects.requireNonNull(objArr[i10]);
            Objects.requireNonNull(objArr[i10 ^ 1]);
            return null;
        }
        int i11 = i9 - 1;
        int i12 = -1;
        if (i9 <= 128) {
            byte[] bArr = new byte[i9];
            Arrays.fill(bArr, (byte) -1);
            int i13 = 0;
            for (int i14 = 0; i14 < i8; i14++) {
                int i15 = (i14 * 2) + i10;
                int i16 = (i13 * 2) + i10;
                Object obj = objArr[i15];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i15 ^ 1];
                Objects.requireNonNull(obj2);
                int iA = f9.a(obj.hashCode());
                while (true) {
                    int i17 = iA & i11;
                    int i18 = bArr[i17] & UByte.MAX_VALUE;
                    if (i18 == 255) {
                        bArr[i17] = (byte) i16;
                        if (i13 < i14) {
                            objArr[i16] = obj;
                            objArr[i16 ^ 1] = obj2;
                        }
                        i13++;
                        break;
                    }
                    if (obj.equals(objArr[i18])) {
                        int i19 = i18 ^ 1;
                        Object obj3 = objArr[i19];
                        Objects.requireNonNull(obj3);
                        l0Var = new l0(obj, obj2, obj3);
                        objArr[i19] = obj2;
                        break;
                    }
                    iA = i17 + 1;
                }
            }
            return i13 == i8 ? bArr : new Object[]{bArr, Integer.valueOf(i13), l0Var};
        }
        if (i9 <= 32768) {
            short[] sArr = new short[i9];
            Arrays.fill(sArr, (short) -1);
            int i20 = 0;
            for (int i21 = 0; i21 < i8; i21++) {
                int i22 = (i21 * 2) + i10;
                int i23 = (i20 * 2) + i10;
                Object obj4 = objArr[i22];
                Objects.requireNonNull(obj4);
                Object obj5 = objArr[i22 ^ 1];
                Objects.requireNonNull(obj5);
                int iA2 = f9.a(obj4.hashCode());
                while (true) {
                    int i24 = iA2 & i11;
                    int i25 = sArr[i24] & UShort.MAX_VALUE;
                    if (i25 == 65535) {
                        sArr[i24] = (short) i23;
                        if (i20 < i21) {
                            objArr[i23] = obj4;
                            objArr[i23 ^ 1] = obj5;
                        }
                        i20++;
                        break;
                    }
                    if (obj4.equals(objArr[i25])) {
                        int i26 = i25 ^ 1;
                        Object obj6 = objArr[i26];
                        Objects.requireNonNull(obj6);
                        l0Var = new l0(obj4, obj5, obj6);
                        objArr[i26] = obj5;
                        break;
                    }
                    iA2 = i24 + 1;
                }
            }
            return i20 == i8 ? sArr : new Object[]{sArr, Integer.valueOf(i20), l0Var};
        }
        int[] iArr = new int[i9];
        Arrays.fill(iArr, -1);
        int i27 = 0;
        int i28 = 0;
        while (i27 < i8) {
            int i29 = (i27 * 2) + i10;
            int i30 = (i28 * 2) + i10;
            Object obj7 = objArr[i29];
            Objects.requireNonNull(obj7);
            Object obj8 = objArr[i29 ^ 1];
            Objects.requireNonNull(obj8);
            int iA3 = f9.a(obj7.hashCode());
            while (true) {
                int i31 = iA3 & i11;
                int i32 = iArr[i31];
                if (i32 == i12) {
                    iArr[i31] = i30;
                    if (i28 < i27) {
                        objArr[i30] = obj7;
                        objArr[i30 ^ 1] = obj8;
                    }
                    i28++;
                    break;
                }
                if (obj7.equals(objArr[i32])) {
                    int i33 = i32 ^ 1;
                    Object obj9 = objArr[i33];
                    Objects.requireNonNull(obj9);
                    l0Var = new l0(obj7, obj8, obj9);
                    objArr[i33] = obj8;
                    break;
                }
                iA3 = i31 + 1;
                i12 = -1;
            }
            i27++;
            i12 = -1;
        }
        return i28 == i8 ? iArr : new Object[]{iArr, Integer.valueOf(i28), l0Var};
    }

    public static <K, V> u4 create(int i8, Object[] objArr) {
        return create(i8, objArr, null);
    }

    public static Object createHashTableOrThrow(Object[] objArr, int i8, int i9, int i10) {
        Object objA = a(objArr, i8, i9, i10);
        if (objA instanceof Object[]) {
            throw ((l0) ((Object[]) objA)[2]).a();
        }
        return objA;
    }

    @Override // i4.t0
    public s1 createEntrySet() {
        return new r4(this, this.alternatingKeysAndValues, 0, this.f5701h);
    }

    @Override // i4.t0
    public s1 createKeySet() {
        return new s4(this, new t4(this.alternatingKeysAndValues, 0, this.f5701h));
    }

    @Override // i4.t0
    public a0 createValues() {
        return new t4(this.alternatingKeysAndValues, 1, this.f5701h);
    }

    @Override // i4.t0, java.util.Map
    public Object get(Object obj) {
        Object obj2 = get(this.e, this.alternatingKeysAndValues, this.f5701h, 0, obj);
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // i4.t0
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f5701h;
    }

    public static <K, V> u4 create(int i8, Object[] objArr, m0 m0Var) {
        if (i8 == 0) {
            return (u4) EMPTY;
        }
        if (i8 == 1) {
            Objects.requireNonNull(objArr[0]);
            Objects.requireNonNull(objArr[1]);
            return new u4(objArr, 1, null);
        }
        v8.j(i8, objArr.length >> 1);
        Object objA = a(objArr, i8, s1.chooseTableSize(i8), 0);
        if (objA instanceof Object[]) {
            Object[] objArr2 = (Object[]) objA;
            l0 l0Var = (l0) objArr2[2];
            if (m0Var == null) {
                throw l0Var.a();
            }
            m0Var.f5645c = l0Var;
            Object obj = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objA = obj;
            i8 = iIntValue;
        }
        return new u4(objArr, i8, objA);
    }

    public static Object get(Object obj, Object[] objArr, int i8, int i9, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i8 == 1) {
            Object obj3 = objArr[i9];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i9 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iA = f9.a(obj2.hashCode());
            while (true) {
                int i10 = iA & length;
                int i11 = bArr[i10] & UByte.MAX_VALUE;
                if (i11 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i11])) {
                    return objArr[i11 ^ 1];
                }
                iA = i10 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iA2 = f9.a(obj2.hashCode());
            while (true) {
                int i12 = iA2 & length2;
                int i13 = sArr[i12] & UShort.MAX_VALUE;
                if (i13 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                iA2 = i12 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iA3 = f9.a(obj2.hashCode());
            while (true) {
                int i14 = iA3 & length3;
                int i15 = iArr[i14];
                if (i15 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i15])) {
                    return objArr[i15 ^ 1];
                }
                iA3 = i14 + 1;
            }
        }
    }
}
