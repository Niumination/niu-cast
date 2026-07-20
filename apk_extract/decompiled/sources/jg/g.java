package jg;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum g {
    UNCOMPRESSED((byte) 0),
    ANSIX962_COMPRESSED_PRIME((byte) 1),
    ANSIX962_COMPRESSED_CHAR2((byte) 2);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final byte code;

    g(byte b9) {
        this.code = b9;
    }

    public static EnumEntries<g> getEntries() {
        return $ENTRIES;
    }

    public final byte getCode() {
        return this.code;
    }
}
