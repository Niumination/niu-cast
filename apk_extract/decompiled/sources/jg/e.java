package jg;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum e {
    sect163k1(1, 163),
    sect163r1(2, 163),
    sect163r2(3, 163),
    sect193r1(4, 193),
    sect193r2(5, 193),
    sect233k1(6, 233),
    sect233r1(7, 233),
    sect239k1(8, 239),
    sect283k1(9, 283),
    sect283r1(10, 283),
    sect409k1(11, 409),
    sect409r1(12, 409),
    sect571k1(13, 571),
    sect571r1(14, 571),
    secp160k1(15, 160),
    secp160r1(16, 160),
    secp160r2(17, 160),
    secp192k1(18, 192),
    secp192r1(19, 192),
    secp224k1(20, 224),
    secp224r1(21, 224),
    secp256k1(22, 256),
    secp256r1(23, 256),
    secp384r1(24, 384),
    secp521r1(25, 521);

    private final short code;
    private final int fieldSize;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final d Companion = new d();

    e(short s2, int i8) {
        this.code = s2;
        this.fieldSize = i8;
    }

    public static EnumEntries<e> getEntries() {
        return $ENTRIES;
    }

    public final short getCode() {
        return this.code;
    }

    public final int getFieldSize() {
        return this.fieldSize;
    }
}
