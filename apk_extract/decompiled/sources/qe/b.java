package qe;

import java.util.List;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends re.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8994c;

    @Override // re.a
    public final int a() {
        switch (this.f8994c) {
            case 0:
                return 7 + c.f8996b;
            case 1:
                return 7 + c.f8998d;
            case 2:
                return 2 + c.f;
            case 3:
                return 7 + c.f9001i;
            case 4:
                return 4 + c.f9003k;
            case 5:
                return 12 + c.f9006n;
            case 6:
                return 10 + c.p;
            default:
                return 24 + c.f9009s;
        }
    }

    public final int b() {
        switch (this.f8994c) {
            case 0:
                return 7;
            case 1:
                return 7;
            case 2:
                return 2;
            case 3:
                return 7;
            case 4:
                return 4;
            case 5:
                return 12;
            case 6:
                return 10;
            default:
                return 24;
        }
    }

    public final int c() {
        switch (this.f8994c) {
            case 0:
                return 3;
            case 1:
                return 3;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 2;
            case 6:
                return 2;
            default:
                return 1;
        }
    }

    public final void d(List byteList) {
        switch (this.f8994c) {
            case 0:
                Intrinsics.checkNotNullParameter(byteList, "byteList");
                c.f8996b = 0;
                if (byteList.size() == 3) {
                    c.f8996b = (3600 / ((((UByte.m177constructorimpl(((Number) byteList.get(0)).byteValue()) & UByte.MAX_VALUE) << 16) | ((UByte.m177constructorimpl(((Number) byteList.get(1)).byteValue()) & UByte.MAX_VALUE) << 8)) | (UByte.m177constructorimpl(((Number) byteList.get(2)).byteValue()) & UByte.MAX_VALUE))) * 2;
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(byteList, "byteList");
                c.f8998d = 0;
                if (byteList.size() == 3) {
                    c.f8998d = (3600 / ((((UByte.m177constructorimpl(((Number) byteList.get(0)).byteValue()) & UByte.MAX_VALUE) << 16) | ((UByte.m177constructorimpl(((Number) byteList.get(1)).byteValue()) & UByte.MAX_VALUE) << 8)) | (UByte.m177constructorimpl(((Number) byteList.get(2)).byteValue()) & UByte.MAX_VALUE))) * 2;
                }
                break;
            case 2:
                Intrinsics.checkNotNullParameter(byteList, "byteList");
                c.f = 0;
                if (byteList.size() == 2) {
                    int iM177constructorimpl = c.f + (UByte.m177constructorimpl(((Number) byteList.get(0)).byteValue()) & UByte.MAX_VALUE);
                    c.f = iM177constructorimpl;
                    c.f = iM177constructorimpl + (UByte.m177constructorimpl(((Number) byteList.get(1)).byteValue()) & UByte.MAX_VALUE) + 2;
                }
                break;
            case 3:
                Intrinsics.checkNotNullParameter(byteList, "byteList");
                c.f9001i = 0;
                if (byteList.size() == 3) {
                    c.f9001i = 3600 / ((((UByte.m177constructorimpl(((Number) byteList.get(0)).byteValue()) & UByte.MAX_VALUE) << 16) | ((UByte.m177constructorimpl(((Number) byteList.get(1)).byteValue()) & UByte.MAX_VALUE) << 8)) | (UByte.m177constructorimpl(((Number) byteList.get(2)).byteValue()) & UByte.MAX_VALUE));
                }
                break;
            case 4:
                Intrinsics.checkNotNullParameter(byteList, "byteList");
                c.f9003k = 0;
                if (byteList.size() == 4) {
                    int iByteValue = (((byte) (((Number) byteList.get(0)).byteValue() & 15)) * 7) + c.f9003k;
                    c.f9003k = iByteValue;
                    int iM254constructorimpl = (UInt.m254constructorimpl(UInt.m254constructorimpl((byte) (((Number) byteList.get(0)).byteValue() & (-16))) >>> 4) * 9) + iByteValue;
                    c.f9003k = iM254constructorimpl;
                    c.f9003k = (((Number) byteList.get(1)).byteValue() * 5) + iM254constructorimpl;
                    if (((byte) (((Number) byteList.get(2)).byteValue() & 1)) == 1) {
                        c.f9003k += 4;
                    }
                    if ((((byte) (((Number) byteList.get(2)).byteValue() & 2)) >> 1) == 1) {
                        c.f9003k += 2;
                    }
                    if ((((byte) (((Number) byteList.get(2)).byteValue() & 4)) >> 2) == 1) {
                        c.f9003k++;
                    }
                    if ((((byte) (((Number) byteList.get(2)).byteValue() & 8)) >> 3) == 1) {
                        c.f9003k += 9;
                    }
                    if ((((byte) (((Number) byteList.get(2)).byteValue() & 16)) >> 4) == 1) {
                        c.f9003k += 5;
                    }
                    if ((((byte) (((Number) byteList.get(2)).byteValue() & 32)) >> 5) == 1) {
                        c.f9003k += 9;
                    }
                    if ((((byte) (((Number) byteList.get(2)).byteValue() & 64)) >> 6) == 1) {
                        c.f9003k += 5;
                    }
                    if ((((byte) (((Number) byteList.get(2)).byteValue() & ByteCompanionObject.MIN_VALUE)) >> 7) == 1) {
                        c.f9003k += 4;
                    }
                    if (((byte) (((Number) byteList.get(3)).byteValue() & 1)) == 1) {
                        c.f9003k += 10;
                    }
                    if ((((byte) (((Number) byteList.get(3)).byteValue() & 2)) >> 1) == 1) {
                        c.f9003k += 10;
                    }
                    if ((((byte) (((Number) byteList.get(3)).byteValue() & 4)) >> 2) == 1) {
                        c.f9003k += 9;
                    }
                }
                break;
            case 5:
                Intrinsics.checkNotNullParameter(byteList, "byteList");
                c.f9006n = 0;
                if (byteList.size() == 2) {
                    if (((byte) (((Number) byteList.get(0)).byteValue() & 1)) == 1) {
                        c.f9006n += 3;
                    }
                    if ((((byte) (((Number) byteList.get(0)).byteValue() & 2)) >> 1) == 1) {
                        c.f9006n += 2;
                    }
                    if ((((byte) (((Number) byteList.get(0)).byteValue() & 4)) >> 2) == 1) {
                        c.f9006n += 3;
                    }
                    if ((((byte) (((Number) byteList.get(0)).byteValue() & 8)) >> 3) == 1) {
                        c.f9006n += 3;
                    }
                    if ((((byte) (((Number) byteList.get(0)).byteValue() & 16)) >> 4) == 1) {
                        c.f9006n += 3;
                    }
                    if ((((byte) (((Number) byteList.get(0)).byteValue() & 32)) >> 5) == 1) {
                        c.f9006n += 3;
                    }
                    if ((((byte) (((Number) byteList.get(0)).byteValue() & 64)) >> 6) == 1) {
                        c.f9006n += 3;
                    }
                    if ((((byte) (((Number) byteList.get(0)).byteValue() & ByteCompanionObject.MIN_VALUE)) >> 7) == 1) {
                        c.f9006n += 3;
                    }
                }
                break;
            case 6:
                Intrinsics.checkNotNullParameter(byteList, "byteList");
                c.p = 0;
                if (byteList.size() == 2) {
                    c.p = (UByte.m177constructorimpl(((Number) byteList.get(0)).byteValue()) & UByte.MAX_VALUE) + (UByte.m177constructorimpl(((Number) byteList.get(1)).byteValue()) & UByte.MAX_VALUE);
                }
                break;
            default:
                Intrinsics.checkNotNullParameter(byteList, "byteList");
                c.f9009s = 0;
                if (byteList.size() == 1) {
                    c.f9009s = ((Number) byteList.get(0)).byteValue() + c.f9009s;
                }
                break;
        }
    }
}
