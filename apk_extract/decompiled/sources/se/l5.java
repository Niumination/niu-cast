package se;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l5 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[we.c.values().length];
        try {
            iArr[we.c.BLUETOOTH_CLASSIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[we.c.BLUETOOTH_LE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[we.c.ETHERNET_LAN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[we.c.BLE_MESH.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[we.c.WIFI_STA.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[we.c.WIFI_P2P.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[we.c.WIFI_AP.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr[we.c.WIFI_NAN.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr[we.c.NFC.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr[we.c.THREAD.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr[we.c.UWB.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr[we.c.OTHER.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
