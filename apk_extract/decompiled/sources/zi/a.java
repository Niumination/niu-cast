package zi;

import kotlin.Unit;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final String a(byte[] bArr, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = i8;
        int i18 = 3;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i17 < 0 || i9 > bArr.length || i17 > i9) {
            throw new IndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i17 + " endIndex=" + i9);
        }
        char[] cArr = new char[i9 - i17];
        int i19 = 0;
        while (i17 < i9) {
            byte b9 = bArr[i17];
            if (b9 >= 0) {
                i15 = i19 + 1;
                cArr[i19] = (char) b9;
                i17++;
                while (i17 < i9) {
                    byte b10 = bArr[i17];
                    if (b10 < 0) {
                        break;
                    }
                    i17++;
                    cArr[i15] = (char) b10;
                    i15++;
                }
                Unit unit = Unit.INSTANCE;
            } else {
                if ((b9 >> 5) == -2) {
                    int i20 = i17 + 1;
                    if (i9 <= i20) {
                        i15 = i19 + 1;
                        cArr[i19] = (char) 65533;
                    } else {
                        byte b11 = bArr[i20];
                        if ((b11 & 192) == 128) {
                            int i21 = (b9 << 6) ^ (b11 ^ ByteCompanionObject.MIN_VALUE);
                            if (i21 < 128) {
                                i15 = i19 + 1;
                                cArr[i19] = (char) 65533;
                            } else {
                                i15 = i19 + 1;
                                cArr[i19] = (char) i21;
                            }
                            Unit unit2 = Unit.INSTANCE;
                            i16 = 2;
                        } else {
                            i15 = i19 + 1;
                            cArr[i19] = (char) 65533;
                        }
                        i17 += i16;
                    }
                    Unit unit3 = Unit.INSTANCE;
                    i16 = 1;
                    i17 += i16;
                } else if ((b9 >> 4) == -2) {
                    int i22 = i17 + 2;
                    if (i9 <= i22) {
                        i12 = i19 + 1;
                        cArr[i19] = (char) 65533;
                        Unit unit4 = Unit.INSTANCE;
                        int i23 = i17 + 1;
                        i14 = (i9 <= i23 || (bArr[i23] & 192) != 128) ? 1 : 2;
                    } else {
                        byte b12 = bArr[i17 + 1];
                        if ((b12 & 192) == 128) {
                            byte b13 = bArr[i22];
                            if ((b13 & 192) == 128) {
                                int i24 = ((b13 ^ ByteCompanionObject.MIN_VALUE) ^ (b12 << 6)) ^ (b9 << 12);
                                if (i24 < 2048) {
                                    i13 = i19 + 1;
                                    cArr[i19] = (char) 65533;
                                } else if (55296 > i24 || i24 >= 57344) {
                                    char c9 = (char) i24;
                                    i13 = i19 + 1;
                                    cArr[i19] = c9;
                                } else {
                                    i13 = i19 + 1;
                                    cArr[i19] = (char) 65533;
                                }
                                Unit unit5 = Unit.INSTANCE;
                                i12 = i13;
                                i14 = i18;
                            } else {
                                i12 = i19 + 1;
                                cArr[i19] = (char) 65533;
                                Unit unit6 = Unit.INSTANCE;
                            }
                        } else {
                            i12 = i19 + 1;
                            cArr[i19] = (char) 65533;
                            Unit unit7 = Unit.INSTANCE;
                        }
                    }
                    i17 += i14;
                    i19 = i12;
                } else {
                    if ((b9 >> 3) == -2) {
                        int i25 = i17 + 3;
                        if (i9 <= i25) {
                            i10 = i19 + 1;
                            cArr[i19] = 65533;
                            Unit unit8 = Unit.INSTANCE;
                            int i26 = i17 + 1;
                            if (i9 <= i26 || (bArr[i26] & 192) != 128) {
                                i18 = 1;
                            } else {
                                int i27 = i17 + 2;
                                if (i9 <= i27 || (bArr[i27] & 192) != 128) {
                                    i18 = 2;
                                }
                            }
                        } else {
                            byte b14 = bArr[i17 + 1];
                            if ((b14 & 192) == 128) {
                                byte b15 = bArr[i17 + 2];
                                if ((b15 & 192) == 128) {
                                    byte b16 = bArr[i25];
                                    if ((b16 & 192) == 128) {
                                        int i28 = (((b16 ^ ByteCompanionObject.MIN_VALUE) ^ (b15 << 6)) ^ (b14 << 12)) ^ (b9 << 18);
                                        if (i28 > 1114111) {
                                            i10 = i19 + 1;
                                            cArr[i19] = 65533;
                                        } else {
                                            if ((55296 > i28 || i28 >= 57344) && i28 >= 65536) {
                                                if (i28 != 65533) {
                                                    cArr[i19] = (char) ((i28 >>> 10) + 55232);
                                                    i11 = i19 + 2;
                                                    cArr[i19 + 1] = (char) ((i28 & 1023) + 56320);
                                                } else {
                                                    cArr[i19] = 65533;
                                                    i11 = i19 + 1;
                                                }
                                                Unit unit9 = Unit.INSTANCE;
                                                i10 = i11;
                                            } else {
                                                i10 = i19 + 1;
                                                cArr[i19] = 65533;
                                            }
                                            i18 = 4;
                                        }
                                        Unit unit10 = Unit.INSTANCE;
                                        i18 = 4;
                                    } else {
                                        i10 = i19 + 1;
                                        cArr[i19] = 65533;
                                        Unit unit11 = Unit.INSTANCE;
                                        i18 = 3;
                                    }
                                } else {
                                    i10 = i19 + 1;
                                    cArr[i19] = 65533;
                                    Unit unit12 = Unit.INSTANCE;
                                    i18 = 2;
                                }
                            } else {
                                i10 = i19 + 1;
                                cArr[i19] = 65533;
                                Unit unit13 = Unit.INSTANCE;
                                i18 = 1;
                            }
                        }
                        i17 += i18;
                    } else {
                        i10 = i19 + 1;
                        cArr[i19] = 65533;
                        i17++;
                    }
                    i19 = i10;
                }
                i18 = 3;
            }
            i19 = i15;
            i18 = 3;
        }
        return StringsKt.concatToString(cArr, 0, i19);
    }
}
