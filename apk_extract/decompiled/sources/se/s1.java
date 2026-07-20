package se;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class s1 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[t4.values().length];
        try {
            iArr[t4.LE_DEVICE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[t4.MDNS_DEVICE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[t4.NFC_DEVICE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[t4.P2P_DEVICE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[t4.BT_DEVICE.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[t4.WIFI_DEVICE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[t4.NAN_DEVICE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr[t4.COAP_DEVICE.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr[t4.MQTT_DEVICE.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr[t4.UWB_DEVICE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr[t4.THREAD_DEVICE.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr[t4.UNKNOWN_DEVICE.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
