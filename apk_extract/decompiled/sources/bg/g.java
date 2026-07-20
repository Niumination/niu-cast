package bg;

import ag.q;
import java.util.ArrayList;
import java.util.Iterator;
import jh.j0;
import jh.o0;
import k3.c1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import zf.x;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final se.e f1321a = c1.a(x.f11558i, new ag.b(4), new q(5));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f1322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f1323c;

    /* JADX WARN: Code duplicated, block: B:14:0x0052 A[PHI: r7
      0x0052: PHI (r7v2 long) = (r7v1 long), (r7v0 long) binds: [B:18:0x0060, B:13:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    static {
        long j8;
        IntRange intRange = new IntRange(0, 255);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(intRange));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            if (48 > iNextInt || iNextInt >= 58) {
                long j10 = iNextInt;
                long j11 = 97;
                if (j10 < 97 || j10 > 102) {
                    j11 = 65;
                    if (j10 < 65 || j10 > 70) {
                        j8 = -1;
                    } else {
                        j8 = ((long) 10) + (j10 - j11);
                    }
                } else {
                    j8 = ((long) 10) + (j10 - j11);
                }
            } else {
                j8 = ((long) iNextInt) - 48;
            }
            arrayList.add(Long.valueOf(j8));
        }
        f1322b = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        IntRange intRange2 = new IntRange(0, 15);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(intRange2));
        Iterator<Integer> it2 = intRange2.iterator();
        while (it2.hasNext()) {
            int iNextInt2 = ((IntIterator) it2).nextInt();
            arrayList2.add(Byte.valueOf((byte) (iNextInt2 < 10 ? iNextInt2 + 48 : (char) (((char) (iNextInt2 + 97)) - '\n'))));
        }
        f1323c = CollectionsKt.toByteArray(arrayList2);
    }

    public static boolean a(CharSequence charSequence, String other) {
        int length = charSequence.length();
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (length != other.length()) {
            return false;
        }
        for (int i8 = 0; i8 < length; i8++) {
            int iCharAt = charSequence.charAt(i8);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            int iCharAt2 = other.charAt(i8);
            if (65 <= iCharAt2 && iCharAt2 < 91) {
                iCharAt2 += 32;
            }
            if (iCharAt != iCharAt2) {
                return false;
            }
        }
        return true;
    }

    public static final int b(CharSequence charSequence, int i8, int i9) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int i10 = 0;
        while (i8 < i9) {
            int iCharAt = charSequence.charAt(i8);
            if (65 <= iCharAt && iCharAt < 91) {
                iCharAt += 32;
            }
            i10 = (i10 * 31) + iCharAt;
            i8++;
        }
        return i10;
    }

    public static final void d(b bVar, int i8) {
        throw new NumberFormatException("Invalid number: " + ((Object) bVar) + ", wrong digit: " + bVar.charAt(i8) + " at position " + i8);
    }

    public static final long e(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int length = bVar.length();
        if (length > 19) {
            throw new NumberFormatException("Invalid number " + ((Object) bVar) + ": too large for Long type");
        }
        int i8 = 0;
        if (length != 19) {
            long j8 = 0;
            while (i8 < length) {
                long jCharAt = ((long) bVar.charAt(i8)) - 48;
                if (jCharAt < 0 || jCharAt > 9) {
                    d(bVar, i8);
                    throw null;
                }
                j8 = (j8 << 3) + (j8 << 1) + jCharAt;
                i8++;
            }
            return j8;
        }
        int length2 = bVar.length();
        long j10 = 0;
        while (i8 < length2) {
            long jCharAt2 = ((long) bVar.charAt(i8)) - 48;
            if (jCharAt2 < 0 || jCharAt2 > 9) {
                d(bVar, i8);
                throw null;
            }
            j10 = (j10 << 3) + (j10 << 1) + jCharAt2;
            if (j10 < 0) {
                throw new NumberFormatException("Invalid number " + ((Object) bVar) + ": too large for Long type");
            }
            i8++;
        }
        return j10;
    }

    public static final long f(StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb2, "<this>");
        int length = sb2.length();
        long j8 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int iCharAt = sb2.charAt(i8) & CharCompanionObject.MAX_VALUE;
            long j10 = iCharAt < 255 ? f1322b[iCharAt] : -1L;
            if (j10 == -1) {
                throw new NumberFormatException("Invalid HEX number: " + ((Object) sb2) + ", wrong digit: " + sb2.charAt(i8));
            }
            j8 = (j8 << 4) | j10;
        }
        return j8;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object g(j0 j0Var, int i8, ContinuationImpl continuationImpl) {
        f fVar;
        int i9;
        byte[] bArr;
        if (continuationImpl instanceof f) {
            fVar = (f) continuationImpl;
            int i10 = fVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fVar.label = i10 - Integer.MIN_VALUE;
            } else {
                fVar = new f(continuationImpl);
            }
        } else {
            fVar = new f(continuationImpl);
        }
        Object obj = fVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = fVar.label;
        if (i11 != 0) {
            if (i11 != 1 && i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i12 = fVar.I$1;
            i8 = fVar.I$0;
            byte[] bArr2 = (byte[]) fVar.L$1;
            j0 j0Var2 = (j0) fVar.L$0;
            ResultKt.throwOnFailure(obj);
            bArr = bArr2;
            i9 = i12;
            j0Var = j0Var2;
            break;
        }
        ResultKt.throwOnFailure(obj);
        if (i8 <= 0) {
            throw new IllegalArgumentException("Does only work for positive numbers");
        }
        int i13 = 0;
        while (true) {
            i9 = i13 + 1;
            bArr = f1323c;
            if (i13 >= 8) {
                break;
            }
            int i14 = i8 >>> 28;
            i8 <<= 4;
            if (i14 != 0) {
                byte b9 = bArr[i14];
                fVar.L$0 = j0Var;
                fVar.L$1 = bArr;
                fVar.I$0 = i8;
                fVar.I$1 = i9;
                fVar.label = 1;
                if (o0.c(j0Var, b9, fVar) != coroutine_suspended) {
                    break;
                }
                return coroutine_suspended;
            }
            i13 = i9;
        }
        while (true) {
            int i15 = i9 + 1;
            if (i9 >= 8) {
                return Unit.INSTANCE;
            }
            int i16 = i8 >>> 28;
            i8 <<= 4;
            byte b10 = bArr[i16];
            fVar.L$0 = j0Var;
            fVar.L$1 = bArr;
            fVar.I$0 = i8;
            fVar.I$1 = i15;
            fVar.label = 2;
            if (o0.c(j0Var, b10, fVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i9 = i15;
        }
    }
}
