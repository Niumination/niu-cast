package se;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum t0 {
    ENABLED_SUCCESS,
    ENABLED_ALREADY,
    ENABLED_BUT_BT_OFF,
    ENABLED_BUT_WIFI_OFF,
    STATE_TURNING_ON,
    STATE_TURNING_OFF,
    DISABLED,
    ENABLE_TIMEOUT,
    DISABLE_TIMEOUT,
    DISABLED_SUCCESS,
    UNKNOWN;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<t0> getEntries() {
        return $ENTRIES;
    }
}
