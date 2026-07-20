package we;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum c {
    BLUETOOTH_CLASSIC,
    BLUETOOTH_LE,
    BLE_MESH,
    WIFI_STA,
    WIFI_P2P,
    WIFI_AP,
    WIFI_NAN,
    ETHERNET_LAN,
    NFC,
    THREAD,
    UWB,
    OTHER;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<c> getEntries() {
        return $ENTRIES;
    }
}
