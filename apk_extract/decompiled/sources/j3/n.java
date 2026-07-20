package j3;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.Arrays;
import k3.w9;
import k3.y9;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class n extends g {
    static final g zza = new n(new Object[0], 0, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient Object f6081d;
    public final transient int e;
    final transient Object[] zzb;

    public n(Object[] objArr, int i8, Object obj) {
        this.f6081d = obj;
        this.zzb = objArr;
        this.e = i8;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x012b A[PHI: r3
      0x012b: PHI (r3v5 ??) = (r3v2 ??), (r3v6 short[]) binds: [B:74:0x0191, B:57:0x0129] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    public static n zzg(int i8, Object[] objArr, f fVar) {
        int iHighestOneBit;
        short[] sArr;
        char c9;
        char c10;
        ?? r7;
        ?? r10;
        int i9 = i8;
        Object[] objArrCopyOf = objArr;
        if (i9 == 0) {
            return (n) zza;
        }
        int i10 = 1;
        e eVar = null;
        ?? r11 = 0;
        e eVar2 = null;
        e eVar3 = null;
        if (i9 == 1) {
            objArrCopyOf[0].getClass();
            objArrCopyOf[1].getClass();
            return new n(objArrCopyOf, 1, null);
        }
        w9.b(i9, objArrCopyOf.length >> 1);
        int iMax = Math.max(i9, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = BasicMeasure.EXACTLY;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i9 == 1) {
            objArrCopyOf[0].getClass();
            objArrCopyOf[1].getClass();
            c9 = 1;
            c10 = 2;
        } else {
            int i11 = iHighestOneBit - 1;
            byte b9 = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i12 = 0;
                int i13 = 0;
                while (i12 < i9) {
                    int i14 = i13 + i13;
                    int i15 = i12 + i12;
                    Object obj = objArrCopyOf[i15];
                    obj.getClass();
                    Object obj2 = objArrCopyOf[i15 ^ i10];
                    obj2.getClass();
                    int iA = y9.a(obj.hashCode());
                    while (true) {
                        int i16 = iA & i11;
                        int i17 = bArr[i16] & UByte.MAX_VALUE;
                        if (i17 == 255) {
                            bArr[i16] = (byte) i14;
                            if (i13 < i12) {
                                objArrCopyOf[i14] = obj;
                                objArrCopyOf[i14 ^ 1] = obj2;
                            }
                            i13++;
                            break;
                        }
                        if (obj.equals(objArrCopyOf[i17 == true ? 1 : 0])) {
                            int i18 = ~i17;
                            Object obj3 = objArrCopyOf[i18 == true ? 1 : 0];
                            obj3.getClass();
                            eVar2 = new e(obj, obj2, obj3);
                            objArrCopyOf[i18 == true ? 1 : 0] = obj2;
                            break;
                        }
                        iA = i16 + 1;
                    }
                    i12++;
                    i10 = 1;
                }
                if (i13 == i9) {
                    r7 = bArr;
                } else {
                    r10 = new Object[]{bArr, Integer.valueOf(i13), eVar2};
                    c10 = 2;
                }
                c9 = 1;
                r11 = r10;
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i19 = 0;
                for (int i20 = 0; i20 < i9; i20++) {
                    int i21 = i19 + i19;
                    int i22 = i20 + i20;
                    Object obj4 = objArrCopyOf[i22];
                    obj4.getClass();
                    Object obj5 = objArrCopyOf[i22 ^ 1];
                    obj5.getClass();
                    int iA2 = y9.a(obj4.hashCode());
                    while (true) {
                        int i23 = iA2 & i11;
                        char c11 = (char) sArr[i23];
                        if (c11 == 65535) {
                            sArr[i23] = (short) i21;
                            if (i19 < i20) {
                                objArrCopyOf[i21] = obj4;
                                objArrCopyOf[i21 ^ 1] = obj5;
                            }
                            i19++;
                            break;
                        }
                        if (obj4.equals(objArrCopyOf[c11])) {
                            int i24 = c11 ^ 1;
                            Object obj6 = objArrCopyOf[i24 == true ? 1 : 0];
                            obj6.getClass();
                            e eVar4 = new e(obj4, obj5, obj6);
                            objArrCopyOf[i24 == true ? 1 : 0] = obj5;
                            eVar3 = eVar4;
                            break;
                        }
                        iA2 = i23 + 1;
                    }
                }
                if (i19 == i9) {
                    r7 = sArr;
                } else {
                    c10 = 2;
                    r11 = new Object[]{sArr, Integer.valueOf(i19), eVar3};
                    c9 = 1;
                }
            } else {
                int i25 = 1;
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i26 = 0;
                int i27 = 0;
                while (i26 < i9) {
                    int i28 = i27 + i27;
                    int i29 = i26 + i26;
                    Object obj7 = objArrCopyOf[i29];
                    obj7.getClass();
                    Object obj8 = objArrCopyOf[i29 ^ i25];
                    obj8.getClass();
                    int iA3 = y9.a(obj7.hashCode());
                    while (true) {
                        int i30 = iA3 & i11;
                        ?? r15 = sArr[i30];
                        if (r15 == b9) {
                            sArr[i30] = i28;
                            if (i27 < i26) {
                                objArrCopyOf[i28] = obj7;
                                objArrCopyOf[i28 ^ 1] = obj8;
                            }
                            i27++;
                            break;
                        }
                        if (obj7.equals(objArrCopyOf[r15])) {
                            int i31 = r15 ^ 1;
                            Object obj9 = objArrCopyOf[i31 == true ? 1 : 0];
                            obj9.getClass();
                            e eVar5 = new e(obj7, obj8, obj9);
                            objArrCopyOf[i31 == true ? 1 : 0] = obj8;
                            eVar = eVar5;
                            break;
                        }
                        iA3 = i30 + 1;
                        b9 = -1;
                    }
                    i26++;
                    b9 = -1;
                    i25 = 1;
                }
                if (i27 == i9) {
                    r7 = sArr;
                } else {
                    c9 = 1;
                    c10 = 2;
                    r11 = new Object[]{sArr, Integer.valueOf(i27), eVar};
                }
            }
            c10 = 2;
            r10 = r7;
            c9 = 1;
            r11 = r10;
        }
        boolean z2 = r11 instanceof Object[];
        ?? r12 = r11;
        if (z2) {
            Object[] objArr2 = (Object[]) r11;
            e eVar6 = (e) objArr2[c10];
            if (fVar == null) {
                throw eVar6.a();
            }
            fVar.f6069c = eVar6;
            Object obj10 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c9]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r12 = obj10;
            i9 = iIntValue;
        }
        return new n(objArrCopyOf, i9, r12);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0005 A[EDGE_INSN: B:44:0x0005->B:4:0x0005 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0005->B:4:0x0005 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0005->B:4:0x0005 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // j3.g, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Object[] objArr = this.zzb;
        if (obj == null) {
            obj2 = null;
        } else if (this.e == 1) {
            Object obj3 = objArr[0];
            obj3.getClass();
            if (obj3.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        } else {
            Object obj4 = this.f6081d;
            if (obj4 == null) {
                obj2 = null;
            } else if (obj4 instanceof byte[]) {
                byte[] bArr = (byte[]) obj4;
                int length = bArr.length - 1;
                int iA = y9.a(obj.hashCode());
                while (true) {
                    int i8 = iA & length;
                    int i9 = bArr[i8] & UByte.MAX_VALUE;
                    if (i9 == 255) {
                        break;
                    }
                    if (obj.equals(objArr[i9])) {
                        obj2 = objArr[i9 ^ 1];
                    } else {
                        iA = i8 + 1;
                    }
                }
                obj2 = null;
            } else if (obj4 instanceof short[]) {
                short[] sArr = (short[]) obj4;
                int length2 = sArr.length - 1;
                int iA2 = y9.a(obj.hashCode());
                while (true) {
                    int i10 = iA2 & length2;
                    char c9 = (char) sArr[i10];
                    if (c9 == 65535) {
                        break;
                    }
                    if (obj.equals(objArr[c9])) {
                        obj2 = objArr[c9 ^ 1];
                    } else {
                        iA2 = i10 + 1;
                    }
                }
                obj2 = null;
            } else {
                int[] iArr = (int[]) obj4;
                int length3 = iArr.length - 1;
                int iA3 = y9.a(obj.hashCode());
                while (true) {
                    int i11 = iA3 & length3;
                    int i12 = iArr[i11];
                    if (i12 == -1) {
                        break;
                    }
                    if (obj.equals(objArr[i12])) {
                        obj2 = objArr[i12 ^ 1];
                    } else {
                        iA3 = i11 + 1;
                    }
                }
                obj2 = null;
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.e;
    }

    @Override // j3.g
    public final a zza() {
        return new m(this.zzb, 1, this.e);
    }

    @Override // j3.g
    public final h zzd() {
        return new k(this, this.zzb, 0, this.e);
    }

    @Override // j3.g
    public final h zze() {
        return new l(this, new m(this.zzb, 0, this.e));
    }
}
