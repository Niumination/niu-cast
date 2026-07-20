package se;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum k1 {
    LOW_LOW,
    LOW_MIDDLE,
    LOW_HIGH,
    MIDDLE_LOW,
    MIDDLE_MIDDLE,
    MIDDLE_HIGH,
    HIGH_LOW,
    HIGH_MIDDLE,
    HIGH_HIGH,
    IMMEDIATE_LOW,
    IMMEDIATE_MIDDLE,
    IMMEDIATE_HIGH,
    FAST_LOW,
    FLASH_MIDDLE,
    FLASH_HIGH,
    DEFAULT;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<k1> getEntries() {
        return $ENTRIES;
    }
}
