package kotlin.uuid;

import a1.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.HexExtensionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0019\u0010\u0004\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\b\u001a)\u0010\t\u001a\u00020\n*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u000e\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u0012\u001a!\u0010\u0013\u001a\u00020\n*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"uuidFromRandomBytes", "Lkotlin/uuid/Uuid;", "randomBytes", "", "toLong", "", "startIndex", "", "toLong$UuidKt__UuidKt", "formatBytesInto", "", "dst", "dstOffset", "count", "formatBytesInto$UuidKt__UuidKt", "checkHyphenAt", "", "index", "checkHyphenAt$UuidKt__UuidKt", "toByteArray", "toByteArray$UuidKt__UuidKt", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/uuid/UuidKt")
@SourceDebugExtension({"SMAP\nUuid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uuid.kt\nkotlin/uuid/UuidKt__UuidKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,452:1\n1#2:453\n*E\n"})
class UuidKt__UuidKt extends UuidKt__UuidJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkHyphenAt$UuidKt__UuidKt(String str, int i8) {
        if (str.charAt(i8) == '-') {
            return;
        }
        StringBuilder sbU = a.u(i8, "Expected '-' (hyphen) at index ", ", but was '");
        sbU.append(str.charAt(i8));
        sbU.append('\'');
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void formatBytesInto$UuidKt__UuidKt(long j8, byte[] bArr, int i8, int i9) {
        int i10 = (i9 * 2) + i8;
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = HexExtensionsKt.getBYTE_TO_LOWER_CASE_HEX_DIGITS()[(int) (255 & j8)];
            bArr[i10 - 1] = (byte) i12;
            i10 -= 2;
            bArr[i10] = (byte) (i12 >> 8);
            j8 >>= 8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toByteArray$UuidKt__UuidKt(long j8, byte[] bArr, int i8) {
        for (int i9 = 0; i9 < 8; i9++) {
            bArr[i8 + i9] = (byte) (j8 >>> ((7 - i9) * 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toLong$UuidKt__UuidKt(byte[] bArr, int i8) {
        return (((long) bArr[i8 + 7]) & 255) | ((((long) bArr[i8]) & 255) << 56) | ((((long) bArr[i8 + 1]) & 255) << 48) | ((((long) bArr[i8 + 2]) & 255) << 40) | ((((long) bArr[i8 + 3]) & 255) << 32) | ((((long) bArr[i8 + 4]) & 255) << 24) | ((((long) bArr[i8 + 5]) & 255) << 16) | ((((long) bArr[i8 + 6]) & 255) << 8);
    }

    @ExperimentalUuidApi
    public static final Uuid uuidFromRandomBytes(byte[] randomBytes) {
        Intrinsics.checkNotNullParameter(randomBytes, "randomBytes");
        byte b9 = (byte) (randomBytes[6] & 15);
        randomBytes[6] = b9;
        randomBytes[6] = (byte) (b9 | 64);
        byte b10 = (byte) (randomBytes[8] & 63);
        randomBytes[8] = b10;
        randomBytes[8] = (byte) (b10 | ByteCompanionObject.MIN_VALUE);
        return Uuid.INSTANCE.fromByteArray(randomBytes);
    }
}
