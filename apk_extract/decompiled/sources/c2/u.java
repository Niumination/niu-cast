package c2;

import android.util.SparseArray;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public enum u {
    UNKNOWN_MOBILE_SUBTYPE(0),
    GPRS(1),
    EDGE(2),
    UMTS(3),
    CDMA(4),
    /* JADX INFO: Fake field, exist only in values array */
    EVDO_0(5),
    /* JADX INFO: Fake field, exist only in values array */
    EVDO_A(6),
    RTT(7),
    HSDPA(8),
    HSUPA(9),
    HSPA(10),
    IDEN(11),
    EVDO_B(12),
    LTE(13),
    EHRPD(14),
    HSPAP(15),
    GSM(16),
    TD_SCDMA(17),
    IWLAN(18),
    LTE_CA(19),
    COMBINED(100);

    public static final u EVDO_0;
    public static final u EVDO_A;
    private static final SparseArray<u> valueMap;
    private final int value;

    static {
        u uVar = UNKNOWN_MOBILE_SUBTYPE;
        u uVar2 = GPRS;
        u uVar3 = EDGE;
        u uVar4 = UMTS;
        u uVar5 = CDMA;
        u uVar6 = EVDO_0;
        EVDO_0 = uVar6;
        u uVar7 = EVDO_A;
        EVDO_A = uVar7;
        u uVar8 = RTT;
        u uVar9 = HSDPA;
        u uVar10 = HSUPA;
        u uVar11 = HSPA;
        u uVar12 = IDEN;
        u uVar13 = EVDO_B;
        u uVar14 = LTE;
        u uVar15 = EHRPD;
        u uVar16 = HSPAP;
        u uVar17 = GSM;
        u uVar18 = TD_SCDMA;
        u uVar19 = IWLAN;
        u uVar20 = LTE_CA;
        SparseArray<u> sparseArray = new SparseArray<>();
        valueMap = sparseArray;
        sparseArray.put(0, uVar);
        sparseArray.put(1, uVar2);
        sparseArray.put(2, uVar3);
        sparseArray.put(3, uVar4);
        sparseArray.put(4, uVar5);
        sparseArray.put(5, uVar6);
        sparseArray.put(6, uVar7);
        sparseArray.put(7, uVar8);
        sparseArray.put(8, uVar9);
        sparseArray.put(9, uVar10);
        sparseArray.put(10, uVar11);
        sparseArray.put(11, uVar12);
        sparseArray.put(12, uVar13);
        sparseArray.put(13, uVar14);
        sparseArray.put(14, uVar15);
        sparseArray.put(15, uVar16);
        sparseArray.put(16, uVar17);
        sparseArray.put(17, uVar18);
        sparseArray.put(18, uVar19);
        sparseArray.put(19, uVar20);
    }

    u(int i8) {
        this.value = i8;
    }

    @Nullable
    public static u forNumber(int i8) {
        return valueMap.get(i8);
    }

    public int getValue() {
        return this.value;
    }
}
