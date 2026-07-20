package jg;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum j {
    ANON((byte) 0),
    RSA((byte) 1),
    DSA((byte) 2),
    ECDSA((byte) 3),
    ED25519((byte) 7),
    ED448((byte) 8);

    private final byte code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final i Companion = new i();

    j(byte b9) {
        this.code = b9;
    }

    public static EnumEntries<j> getEntries() {
        return $ENTRIES;
    }

    public final byte getCode() {
        return this.code;
    }
}
