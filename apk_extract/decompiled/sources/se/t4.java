package se;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum t4 {
    LE_DEVICE,
    BT_DEVICE,
    MDNS_DEVICE,
    WIFI_DEVICE,
    P2P_DEVICE,
    NAN_DEVICE,
    COAP_DEVICE,
    MQTT_DEVICE,
    NFC_DEVICE,
    UWB_DEVICE,
    THREAD_DEVICE,
    UNKNOWN_DEVICE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<t4> getEntries() {
        return $ENTRIES;
    }
}
