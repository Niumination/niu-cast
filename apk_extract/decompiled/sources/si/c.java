package si;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum c {
    CPU_ACQUIRED,
    BLOCKING,
    PARKING,
    DORMANT,
    TERMINATED;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<c> getEntries() {
        return $ENTRIES;
    }
}
