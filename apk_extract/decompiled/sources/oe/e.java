package oe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k3.lb;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import m3.q;
import qe.j;
import qe.k;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends c {
    public static final boolean j(qe.b bVar, boolean z2, List list, int i8) {
        ArrayList arrayList = bVar.f9427a;
        if (arrayList != null && arrayList.size() == bVar.a()) {
            boolean z3 = !z2 && i8 == list.size() - 1;
            ArrayList arrayList2 = bVar.f9427a;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (z3) {
                bVar.f9427a = null;
                bVar.f9428b = -1;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x074f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0751  */
    /* JADX WARN: Code duplicated, block: B:112:0x0766  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    @Override // oe.c
    public final void i(byte b9, int i8, boolean z2, boolean z3, List data) {
        boolean z5;
        int i9;
        boolean z10;
        String str;
        String str2;
        String strH;
        String str3;
        String str4;
        byte b10;
        int i10;
        int i11;
        int i12;
        byte b11;
        boolean z11;
        List listSubList;
        String str5;
        byte b12;
        String str6;
        String strH2;
        String str7;
        String str8;
        byte b13;
        int i13;
        int i14;
        int i15;
        Intrinsics.checkNotNullParameter(data, "data");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str9 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
        h.g("functionCode is 0x".concat(str9));
        if (b9 == 0) {
            data.isEmpty();
            if (data.size() >= 20) {
                boolean z12 = ((Number) data.get(0)).byteValue() == 1;
                if (z12) {
                    String strQ = o.d.q(new Object[]{data.get(1)}, 1, "%02x", "format(...)");
                    String strQ2 = o.d.q(new Object[]{data.get(2)}, 1, "%02x", "format(...)");
                    String strQ3 = o.d.q(new Object[]{data.get(3)}, 1, "%02x", "format(...)");
                    String strQ4 = o.d.q(new Object[]{data.get(4)}, 1, "%02x", "format(...)");
                    String strQ5 = o.d.q(new Object[]{data.get(5)}, 1, "%02x", "format(...)");
                    String strQ6 = o.d.q(new Object[]{data.get(6)}, 1, "%02x", "format(...)");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(strQ);
                    sb2.append(":");
                    sb2.append(strQ2);
                    sb2.append(":");
                    sb2.append(strQ3);
                    o.d.A(sb2, ":", strQ4, ":", strQ5);
                    String strN = h0.a.n(sb2, ":", strQ6);
                    byte bByteValue = ((Number) data.get(7)).byteValue();
                    int iM177constructorimpl = (UByte.m177constructorimpl(((Number) data.get(9)).byteValue()) & UByte.MAX_VALUE) | ((UByte.m177constructorimpl(((Number) data.get(8)).byteValue()) & UByte.MAX_VALUE) << 8);
                    int iM177constructorimpl2 = ((UByte.m177constructorimpl(((Number) data.get(10)).byteValue()) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl(((Number) data.get(11)).byteValue()) & UByte.MAX_VALUE);
                    int iM177constructorimpl3 = UByte.m177constructorimpl(((Number) data.get(12)).byteValue()) & UByte.MAX_VALUE;
                    String str10 = (UByte.m177constructorimpl(((Number) data.get(13)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(14)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(15)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(16)).byteValue()) & UByte.MAX_VALUE);
                    String str11 = (UByte.m177constructorimpl(((Number) data.get(17)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(18)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(19)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(20)).byteValue()) & UByte.MAX_VALUE);
                    byte bByteValue2 = ((Number) data.get(21)).byteValue();
                    int iM177constructorimpl4 = UByte.m177constructorimpl(((Number) data.get(22)).byteValue()) & UByte.MAX_VALUE;
                    int iM177constructorimpl5 = UByte.m177constructorimpl(((Number) data.get(23)).byteValue()) & UByte.MAX_VALUE;
                    int i16 = iM177constructorimpl4 + 24;
                    String strH3 = q.h(CollectionsKt.toByteArray(data.subList(24, i16)));
                    b13 = bByteValue;
                    strH2 = q.h(CollectionsKt.toByteArray(data.subList(i16, iM177constructorimpl5 + i16)));
                    str5 = strN;
                    str8 = str11;
                    i13 = iM177constructorimpl;
                    i14 = iM177constructorimpl2;
                    i15 = iM177constructorimpl3;
                    b12 = bByteValue2;
                    str6 = strH3;
                    str7 = str10;
                } else {
                    str5 = "00:00:00:00:00:00";
                    b12 = 3;
                    str6 = "";
                    strH2 = str6;
                    str7 = "0.0.0.0";
                    str8 = str7;
                    b13 = 0;
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                }
                new k(z12, str5, b13, i13, i14, i15, str7, str8, b12, str6, strH2);
                h.g("tv已经连接上了phone连着的ap，现在断开gatt 连接");
                b();
            }
            Unit unit = Unit.INSTANCE;
        } else {
            if (b9 != 1 && b9 != 2 && b9 != 3 && b9 != 4 && b9 != 5) {
                if (b9 == 6) {
                    data.isEmpty();
                    if (data.size() >= 10) {
                        qe.b bVar = qe.c.f9007o;
                        int i17 = bVar.f9428b;
                        if (i8 - i17 == 1 || (i8 == 0 && i17 == 255)) {
                            bVar.f9428b = i8;
                            if (bVar.f9427a == null) {
                                bVar.f9427a = new ArrayList();
                            }
                            int size = data.size();
                            for (int i18 = 0; i18 < size; i18++) {
                                ArrayList arrayList = bVar.f9427a;
                                if (arrayList != null) {
                                    arrayList.add(data.get(i18));
                                }
                                ArrayList arrayList2 = bVar.f9427a;
                                int size2 = arrayList2 != null ? arrayList2.size() : 0;
                                if (size2 >= bVar.b()) {
                                    if (size2 == bVar.b()) {
                                        ArrayList arrayList3 = bVar.f9427a;
                                        if (arrayList3 != null && (listSubList = arrayList3.subList(size2 - bVar.c(), size2)) != null) {
                                            bVar.d(listSubList);
                                            if (size2 == bVar.a()) {
                                                j(bVar, z2, data, i18);
                                            }
                                        }
                                    } else {
                                        j(bVar, z2, data, i18);
                                    }
                                }
                            }
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else {
                        z11 = true;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    z5 = z11;
                } else if (b9 == 7 || b9 == 8) {
                    data.isEmpty();
                    data.size();
                    Unit unit3 = Unit.INSTANCE;
                } else if (b9 == 9) {
                    if (!data.isEmpty() && data.size() >= 25) {
                        boolean z13 = ((Number) data.get(0)).byteValue() == 1;
                        String strQ7 = o.d.q(new Object[]{data.get(1)}, 1, "%02x", "format(...)");
                        String strQ8 = o.d.q(new Object[]{data.get(2)}, 1, "%02x", "format(...)");
                        String strQ9 = o.d.q(new Object[]{data.get(3)}, 1, "%02x", "format(...)");
                        String strQ10 = o.d.q(new Object[]{data.get(4)}, 1, "%02x", "format(...)");
                        String strQ11 = o.d.q(new Object[]{data.get(5)}, 1, "%02x", "format(...)");
                        String strQ12 = o.d.q(new Object[]{data.get(6)}, 1, "%02x", "format(...)");
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(strQ7);
                        sb3.append(":");
                        sb3.append(strQ8);
                        sb3.append(":");
                        sb3.append(strQ9);
                        o.d.A(sb3, ":", strQ10, ":", strQ11);
                        new j(z13, h0.a.n(sb3, ":", strQ12));
                        boolean z14 = ((Number) data.get(7)).byteValue() == 1;
                        if (z14) {
                            String strQ13 = o.d.q(new Object[]{data.get(8)}, 1, "%02x", "format(...)");
                            String strQ14 = o.d.q(new Object[]{data.get(9)}, 1, "%02x", "format(...)");
                            String strQ15 = o.d.q(new Object[]{data.get(10)}, 1, "%02x", "format(...)");
                            String strQ16 = o.d.q(new Object[]{data.get(11)}, 1, "%02x", "format(...)");
                            String strQ17 = o.d.q(new Object[]{data.get(12)}, 1, "%02x", "format(...)");
                            String strQ18 = o.d.q(new Object[]{data.get(13)}, 1, "%02x", "format(...)");
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(strQ13);
                            sb4.append(":");
                            sb4.append(strQ14);
                            sb4.append(":");
                            sb4.append(strQ15);
                            o.d.A(sb4, ":", strQ16, ":", strQ17);
                            String strN2 = h0.a.n(sb4, ":", strQ18);
                            byte bByteValue3 = ((Number) data.get(14)).byteValue();
                            int iM177constructorimpl6 = ((UByte.m177constructorimpl(((Number) data.get(15)).byteValue()) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl(((Number) data.get(16)).byteValue()) & UByte.MAX_VALUE);
                            int iM177constructorimpl7 = ((UByte.m177constructorimpl(((Number) data.get(17)).byteValue()) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl(((Number) data.get(18)).byteValue()) & UByte.MAX_VALUE);
                            int iM177constructorimpl8 = UByte.m177constructorimpl(((Number) data.get(19)).byteValue()) & UByte.MAX_VALUE;
                            String str12 = (UByte.m177constructorimpl(((Number) data.get(20)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(21)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(22)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(23)).byteValue()) & UByte.MAX_VALUE);
                            lb.f6528b = str12;
                            String str13 = (UByte.m177constructorimpl(((Number) data.get(24)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(25)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(26)).byteValue()) & UByte.MAX_VALUE) + "." + (UByte.m177constructorimpl(((Number) data.get(27)).byteValue()) & UByte.MAX_VALUE);
                            byte bByteValue4 = ((Number) data.get(28)).byteValue();
                            int iM177constructorimpl9 = UByte.m177constructorimpl(((Number) data.get(29)).byteValue()) & UByte.MAX_VALUE;
                            int iM177constructorimpl10 = 255 & UByte.m177constructorimpl(((Number) data.get(30)).byteValue());
                            int i19 = iM177constructorimpl9 + 31;
                            String strH4 = q.h(CollectionsKt.toByteArray(data.subList(31, i19)));
                            b10 = bByteValue3;
                            strH = q.h(CollectionsKt.toByteArray(data.subList(i19, iM177constructorimpl10 + i19)));
                            str = strN2;
                            i10 = iM177constructorimpl6;
                            str4 = str13;
                            i11 = iM177constructorimpl7;
                            i12 = iM177constructorimpl8;
                            b11 = bByteValue4;
                            str2 = strH4;
                            str3 = str12;
                        } else {
                            str = "00:00:00:00:00:00";
                            str2 = "";
                            strH = str2;
                            str3 = "0.0.0.0";
                            str4 = str3;
                            b10 = 0;
                            i10 = 0;
                            i11 = 0;
                            i12 = 0;
                            b11 = 3;
                        }
                        new k(z14, str, b10, i10, i11, i12, str3, str4, b11, str2, strH);
                    }
                    Unit unit4 = Unit.INSTANCE;
                } else if (b9 == 10) {
                    data.isEmpty();
                    if (data.size() >= 9) {
                        int iM177constructorimpl11 = UByte.m177constructorimpl(((Number) data.get(0)).byteValue()) & UByte.MAX_VALUE;
                        if (((Number) data.get(1)).byteValue() == 1) {
                            i9 = 2;
                            z10 = true;
                        } else {
                            i9 = 2;
                            z10 = false;
                        }
                        int iM177constructorimpl12 = UByte.m177constructorimpl(((Number) data.get(i9)).byteValue()) & UByte.MAX_VALUE;
                        int iM177constructorimpl13 = UByte.m177constructorimpl(((Number) data.get(3)).byteValue()) & UByte.MAX_VALUE;
                        int iM177constructorimpl14 = (UByte.m177constructorimpl(((Number) data.get(4)).byteValue()) & UByte.MAX_VALUE) + 9;
                        int iM177constructorimpl15 = (UByte.m177constructorimpl(((Number) data.get(5)).byteValue()) & UByte.MAX_VALUE) + iM177constructorimpl14;
                        int iM177constructorimpl16 = (UByte.m177constructorimpl(((Number) data.get(6)).byteValue()) & UByte.MAX_VALUE) + iM177constructorimpl15;
                        int iM177constructorimpl17 = (UByte.m177constructorimpl(((Number) data.get(7)).byteValue()) & UByte.MAX_VALUE) + iM177constructorimpl16;
                        new qe.h(iM177constructorimpl11, z10, iM177constructorimpl12, iM177constructorimpl13, q.h(CollectionsKt.toByteArray(data.subList(9, iM177constructorimpl14))), q.h(CollectionsKt.toByteArray(data.subList(iM177constructorimpl14, iM177constructorimpl15))), q.h(CollectionsKt.toByteArray(data.subList(iM177constructorimpl15, iM177constructorimpl16))), q.h(CollectionsKt.toByteArray(data.subList(iM177constructorimpl16, iM177constructorimpl17))), q.h(CollectionsKt.toByteArray(data.subList(iM177constructorimpl17, (255 & UByte.m177constructorimpl(((Number) data.get(8)).byteValue())) + iM177constructorimpl17))));
                    }
                    Unit unit5 = Unit.INSTANCE;
                } else if (b9 == 11) {
                    data.isEmpty();
                } else if (b9 == 62) {
                    data.isEmpty();
                    Unit unit6 = Unit.INSTANCE;
                } else {
                    h.d("This functionCode in hex " + o.d.q(new Object[]{Byte.valueOf(b9)}, 1, "%02x", "format(...)") + " is not support yet !!", null);
                    Unit unit7 = Unit.INSTANCE;
                    z5 = false;
                }
                if (z3) {
                    if (z5) {
                        e(b9, i8);
                    } else {
                        h.g("ResponseReceivedSuccess");
                        f(b9, true, new byte[]{(byte) i8, 0});
                    }
                }
            }
            data.isEmpty();
            data.size();
            Unit unit8 = Unit.INSTANCE;
        }
        z5 = true;
        if (z3) {
            if (z5) {
                e(b9, i8);
            } else {
                h.g("ResponseReceivedSuccess");
                f(b9, true, new byte[]{(byte) i8, 0});
            }
        }
    }
}
