package c2;

import android.util.SparseArray;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public enum v {
    MOBILE(0),
    WIFI(1),
    MOBILE_MMS(2),
    MOBILE_SUPL(3),
    MOBILE_DUN(4),
    /* JADX INFO: Fake field, exist only in values array */
    MOBILE_HIPRI(5),
    /* JADX INFO: Fake field, exist only in values array */
    WIMAX(6),
    BLUETOOTH(7),
    DUMMY(8),
    ETHERNET(9),
    MOBILE_FOTA(10),
    MOBILE_IMS(11),
    MOBILE_CBS(12),
    WIFI_P2P(13),
    MOBILE_IA(14),
    MOBILE_EMERGENCY(15),
    PROXY(16),
    VPN(17),
    NONE(-1);

    public static final v MOBILE_HIPRI;
    public static final v WIMAX;
    private static final SparseArray<v> valueMap;
    private final int value;

    static {
        v vVar = MOBILE;
        v vVar2 = WIFI;
        v vVar3 = MOBILE_MMS;
        v vVar4 = MOBILE_SUPL;
        v vVar5 = MOBILE_DUN;
        v vVar6 = MOBILE_HIPRI;
        MOBILE_HIPRI = vVar6;
        v vVar7 = WIMAX;
        WIMAX = vVar7;
        v vVar8 = BLUETOOTH;
        v vVar9 = DUMMY;
        v vVar10 = ETHERNET;
        v vVar11 = MOBILE_FOTA;
        v vVar12 = MOBILE_IMS;
        v vVar13 = MOBILE_CBS;
        v vVar14 = WIFI_P2P;
        v vVar15 = MOBILE_IA;
        v vVar16 = MOBILE_EMERGENCY;
        v vVar17 = PROXY;
        v vVar18 = VPN;
        v vVar19 = NONE;
        SparseArray<v> sparseArray = new SparseArray<>();
        valueMap = sparseArray;
        sparseArray.put(0, vVar);
        sparseArray.put(1, vVar2);
        sparseArray.put(2, vVar3);
        sparseArray.put(3, vVar4);
        sparseArray.put(4, vVar5);
        sparseArray.put(5, vVar6);
        sparseArray.put(6, vVar7);
        sparseArray.put(7, vVar8);
        sparseArray.put(8, vVar9);
        sparseArray.put(9, vVar10);
        sparseArray.put(10, vVar11);
        sparseArray.put(11, vVar12);
        sparseArray.put(12, vVar13);
        sparseArray.put(13, vVar14);
        sparseArray.put(14, vVar15);
        sparseArray.put(15, vVar16);
        sparseArray.put(16, vVar17);
        sparseArray.put(17, vVar18);
        sparseArray.put(-1, vVar19);
    }

    v(int i8) {
        this.value = i8;
    }

    @Nullable
    public static v forNumber(int i8) {
        return valueMap.get(i8);
    }

    public int getValue() {
        return this.value;
    }
}
