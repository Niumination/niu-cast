package k3;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class y extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f6711i = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f6712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f6713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f6714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient w f6715d;
    public transient w e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient i4.n f6716h;
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;

    public y() {
        zzm(3);
    }

    public static /* synthetic */ Object zzh(y yVar) {
        Object obj = yVar.f6712a;
        obj.getClass();
        return obj;
    }

    public final int a() {
        return (1 << (this.f6713b & 31)) - 1;
    }

    public final int b(Object obj) {
        if (zzo()) {
            return -1;
        }
        int iA = qa.a(obj);
        int iA2 = a();
        Object obj2 = this.f6712a;
        obj2.getClass();
        int iB = pa.b(iA & iA2, obj2);
        if (iB != 0) {
            int i8 = ~iA2;
            int i9 = iA & i8;
            do {
                int i10 = iB - 1;
                int[] iArr = this.zza;
                iArr.getClass();
                int i11 = iArr[i10];
                if ((i11 & i8) == i9) {
                    Object[] objArr = this.zzb;
                    objArr.getClass();
                    if (ia.a(obj, objArr[i10])) {
                        return i10;
                    }
                }
                iB = i11 & iA2;
            } while (iB != 0);
        }
        return -1;
    }

    public final int c(int i8, int i9, int i10, int i11) {
        int i12 = i9 - 1;
        Object objC = pa.c(i9);
        if (i11 != 0) {
            pa.d(i10 & i12, i11 + 1, objC);
        }
        Object obj = this.f6712a;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        for (int i13 = 0; i13 <= i8; i13++) {
            int iB = pa.b(i13, obj);
            while (iB != 0) {
                int i14 = iB - 1;
                int i15 = iArr[i14];
                int i16 = ((~i8) & i15) | i13;
                int i17 = i16 & i12;
                int iB2 = pa.b(i17, objC);
                pa.d(i17, iB, objC);
                iArr[i14] = ((~i12) & i16) | (iB2 & i12);
                iB = i15 & i8;
            }
        }
        this.f6712a = objC;
        this.f6713b = ((32 - Integer.numberOfLeadingZeros(i12)) & 31) | (this.f6713b & (-32));
        return i12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzo()) {
            return;
        }
        zzl();
        Map mapZzj = zzj();
        if (mapZzj != null) {
            this.f6713b = Math.min(Math.max(size(), 3), 1073741823);
            mapZzj.clear();
            this.f6712a = null;
            this.f6714c = 0;
            return;
        }
        Object[] objArr = this.zzb;
        objArr.getClass();
        Arrays.fill(objArr, 0, this.f6714c, (Object) null);
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        Arrays.fill(objArr2, 0, this.f6714c, (Object) null);
        Object obj = this.f6712a;
        obj.getClass();
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        int[] iArr = this.zza;
        iArr.getClass();
        Arrays.fill(iArr, 0, this.f6714c, 0);
        this.f6714c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.containsKey(obj);
        }
        return b(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.containsValue(obj);
        }
        for (int i8 = 0; i8 < this.f6714c; i8++) {
            Object[] objArr = this.zzc;
            objArr.getClass();
            if (ia.a(obj, objArr[i8])) {
                return true;
            }
        }
        return false;
    }

    public final Object d(Object obj) {
        boolean zZzo = zzo();
        Object obj2 = f6711i;
        if (zZzo) {
            return obj2;
        }
        int iA = a();
        Object obj3 = this.f6712a;
        obj3.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        int iA2 = pa.a(obj, null, iA, obj3, iArr, objArr, null);
        if (iA2 == -1) {
            return obj2;
        }
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        Object obj4 = objArr2[iA2];
        zzn(iA2, iA);
        this.f6714c--;
        zzl();
        return obj4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        w wVar = this.e;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this, 0);
        this.e = wVar2;
        return wVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.get(obj);
        }
        int iB = b(obj);
        if (iB == -1) {
            return null;
        }
        Object[] objArr = this.zzc;
        objArr.getClass();
        return objArr[iB];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        w wVar = this.f6715d;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this, 1);
        this.f6715d = wVar2;
        return wVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iMin;
        if (zzo()) {
            na.c("Arrays already allocated", zzo());
            int i8 = this.f6713b;
            int iMax = Math.max(i8 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = BasicMeasure.EXACTLY;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.f6712a = pa.c(iMax2);
            this.f6713b = ((32 - Integer.numberOfLeadingZeros(iMax2 - 1)) & 31) | (this.f6713b & (-32));
            this.zza = new int[i8];
            this.zzb = new Object[i8];
            this.zzc = new Object[i8];
        }
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.put(obj, obj2);
        }
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int i9 = this.f6714c;
        int i10 = i9 + 1;
        int iA = qa.a(obj);
        int iA2 = a();
        int i11 = iA & iA2;
        Object obj3 = this.f6712a;
        obj3.getClass();
        int iB = pa.b(i11, obj3);
        if (iB != 0) {
            int i12 = ~iA2;
            int i13 = iA & i12;
            int i14 = 0;
            while (true) {
                int i15 = iB - 1;
                int i16 = iArr[i15];
                int i17 = i16 & i12;
                if (i17 == i13 && ia.a(obj, objArr[i15])) {
                    Object obj4 = objArr2[i15];
                    objArr2[i15] = obj2;
                    return obj4;
                }
                int i18 = i16 & iA2;
                int i19 = i12;
                int i20 = i14 + 1;
                if (i18 == 0) {
                    if (i20 < 9) {
                        if (i10 <= iA2) {
                            iArr[i15] = (i10 & iA2) | i17;
                            break;
                        }
                        iA2 = c(iA2, (iA2 + 1) * (iA2 < 32 ? 4 : 2), iA, i9);
                        break;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(a() + 1, 1.0f);
                    int iZze = zze();
                    while (iZze >= 0) {
                        Object[] objArr3 = this.zzb;
                        objArr3.getClass();
                        Object obj5 = objArr3[iZze];
                        Object[] objArr4 = this.zzc;
                        objArr4.getClass();
                        linkedHashMap.put(obj5, objArr4[iZze]);
                        iZze = zzf(iZze);
                    }
                    this.f6712a = linkedHashMap;
                    this.zza = null;
                    this.zzb = null;
                    this.zzc = null;
                    zzl();
                    return linkedHashMap.put(obj, obj2);
                }
                i14 = i20;
                iB = i18;
                i12 = i19;
            }
        } else if (i10 > iA2) {
            iA2 = c(iA2, (iA2 + 1) * (iA2 < 32 ? 4 : 2), iA, i9);
        } else {
            Object obj6 = this.f6712a;
            obj6.getClass();
            pa.d(i11, i10, obj6);
        }
        int[] iArr2 = this.zza;
        iArr2.getClass();
        int length = iArr2.length;
        if (i10 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            int[] iArr3 = this.zza;
            iArr3.getClass();
            this.zza = Arrays.copyOf(iArr3, iMin);
            Object[] objArr5 = this.zzb;
            objArr5.getClass();
            this.zzb = Arrays.copyOf(objArr5, iMin);
            Object[] objArr6 = this.zzc;
            objArr6.getClass();
            this.zzc = Arrays.copyOf(objArr6, iMin);
        }
        int i21 = (~iA2) & iA;
        int[] iArr4 = this.zza;
        iArr4.getClass();
        iArr4[i9] = i21;
        Object[] objArr7 = this.zzb;
        objArr7.getClass();
        objArr7[i9] = obj;
        Object[] objArr8 = this.zzc;
        objArr8.getClass();
        objArr8[i9] = obj2;
        this.f6714c = i10;
        zzl();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzj = zzj();
        if (mapZzj != null) {
            return mapZzj.remove(obj);
        }
        Object objD = d(obj);
        if (objD == f6711i) {
            return null;
        }
        return objD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzj = zzj();
        return mapZzj != null ? mapZzj.size() : this.f6714c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        i4.n nVar = this.f6716h;
        if (nVar != null) {
            return nVar;
        }
        i4.n nVar2 = new i4.n(this, 3);
        this.f6716h = nVar2;
        return nVar2;
    }

    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzf(int i8) {
        int i9 = i8 + 1;
        if (i9 < this.f6714c) {
            return i9;
        }
        return -1;
    }

    public final Map zzj() {
        Object obj = this.f6712a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzl() {
        this.f6713b += 32;
    }

    public final void zzm(int i8) {
        this.f6713b = Math.min(Math.max(12, 1), 1073741823);
    }

    public final void zzn(int i8, int i9) {
        Object obj = this.f6712a;
        obj.getClass();
        int[] iArr = this.zza;
        iArr.getClass();
        Object[] objArr = this.zzb;
        objArr.getClass();
        Object[] objArr2 = this.zzc;
        objArr2.getClass();
        int size = size();
        int i10 = size - 1;
        if (i8 >= i10) {
            objArr[i8] = null;
            objArr2[i8] = null;
            iArr[i8] = 0;
            return;
        }
        Object obj2 = objArr[i10];
        objArr[i8] = obj2;
        objArr2[i8] = objArr2[i10];
        objArr[i10] = null;
        objArr2[i10] = null;
        iArr[i8] = iArr[i10];
        iArr[i10] = 0;
        int iA = qa.a(obj2) & i9;
        int iB = pa.b(iA, obj);
        if (iB == size) {
            pa.d(iA, i8 + 1, obj);
            return;
        }
        while (true) {
            int i11 = iB - 1;
            int i12 = iArr[i11];
            int i13 = i12 & i9;
            if (i13 == size) {
                iArr[i11] = ((~i9) & i12) | ((i8 + 1) & i9);
                return;
            }
            iB = i13;
        }
    }

    public final boolean zzo() {
        return this.f6712a == null;
    }

    public y(int i8) {
        zzm(12);
    }
}
