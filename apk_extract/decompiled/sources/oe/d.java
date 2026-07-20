package oe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends c {
    public static boolean j(int i8, List list, re.a aVar, boolean z2) {
        List listSubList;
        int i9 = aVar.f9428b;
        if (i8 - i9 != 1 && (i8 != 0 || i9 != 255)) {
            return false;
        }
        aVar.f9428b = i8;
        if (aVar.f9427a == null) {
            aVar.f9427a = new ArrayList();
        }
        if (aVar instanceof qe.e) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ArrayList arrayList = ((qe.e) aVar).f9427a;
                if (arrayList != null) {
                    arrayList.add(list.get(i10));
                }
                k(i10, list, aVar, z2);
            }
        } else if (aVar instanceof qe.b) {
            int size2 = list.size();
            for (int i11 = 0; i11 < size2; i11++) {
                qe.b bVar = (qe.b) aVar;
                ArrayList arrayList2 = bVar.f9427a;
                if (arrayList2 != null) {
                    arrayList2.add(list.get(i11));
                }
                ArrayList arrayList3 = bVar.f9427a;
                int size3 = arrayList3 != null ? arrayList3.size() : 0;
                if (size3 >= bVar.b()) {
                    if (size3 == bVar.b()) {
                        ArrayList arrayList4 = bVar.f9427a;
                        if (arrayList4 != null && (listSubList = arrayList4.subList(size3 - bVar.c(), size3)) != null) {
                            bVar.d(listSubList);
                        }
                    } else {
                        k(i11, list, aVar, z2);
                    }
                }
            }
        }
        return true;
    }

    public static final boolean k(int i8, List list, re.a aVar, boolean z2) {
        ArrayList arrayList = aVar.f9427a;
        if (arrayList != null && arrayList.size() == aVar.a()) {
            boolean z3 = !z2 && i8 == list.size() - 1;
            ArrayList arrayList2 = aVar.f9427a;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (z3) {
                aVar.f9427a = null;
                aVar.f9428b = -1;
            }
        }
        return true;
    }

    @Override // oe.c
    public final void i(byte b9, int i8, boolean z2, boolean z3, List data) {
        boolean zJ;
        Intrinsics.checkNotNullParameter(data, "data");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        h.g("functionCode is 0x".concat(str));
        if (b9 == 48 || b9 == 49 || b9 == 50) {
            zJ = true;
        } else {
            if (b9 == 51) {
                data.size();
            } else if (b9 == 52) {
                zJ = j(i8, data, qe.c.q, z2);
            } else if (b9 == 53) {
                zJ = j(i8, data, qe.c.f9005m, z2);
            } else if (b9 == 54) {
                zJ = j(i8, data, qe.c.f9000h, z2);
            } else if (b9 == 55) {
                zJ = j(i8, data, qe.c.f9002j, z2);
            } else if (b9 == 56) {
                zJ = j(i8, data, qe.c.f9004l, z2);
            } else if (b9 == 57) {
                zJ = j(i8, data, qe.c.f8997c, z2);
            } else if (b9 == 58) {
                zJ = j(i8, data, qe.c.f8995a, z2);
            } else if (b9 == 59) {
                zJ = j(i8, data, qe.c.f9008r, z2);
            } else if (b9 == 60) {
                zJ = j(i8, data, qe.c.f8999g, z2);
            } else if (b9 == 61) {
                zJ = j(i8, data, qe.c.e, z2);
            } else if (b9 == 112) {
                if (data.size() == 2) {
                    h.g("SET_FILE_TRANSPORT: get remote response, remote response: received package's index is " + (UByte.m177constructorimpl(((Number) data.get(0)).byteValue()) & UByte.MAX_VALUE) + ",receive status is " + ((UByte.m177constructorimpl(((Number) data.get(1)).byteValue()) & UByte.MAX_VALUE) == 0));
                }
            } else if (b9 == 113) {
                if (data.size() == 2) {
                    h.g("SET_BACKGROUND_PICTURE: get remote response, remote response: received package's index is " + (UByte.m177constructorimpl(((Number) data.get(0)).byteValue()) & UByte.MAX_VALUE) + ",receive status is " + ((UByte.m177constructorimpl(((Number) data.get(1)).byteValue()) & UByte.MAX_VALUE) == 0));
                }
            } else if (b9 != -109 && b9 != 84 && b9 != 85 && b9 != 86) {
                if (b9 == 83) {
                    if (data.size() == 1) {
                        UByte.m177constructorimpl(((Number) data.get(0)).byteValue());
                    }
                } else if (b9 != 103) {
                    if (b9 == -110) {
                        data.size();
                    } else if (b9 == -112) {
                        if (data.size() == 2) {
                            h.g("NOTIFY_REALTIME_REPORT_BLOOD_PRESSURE: diastolicPressure is " + ((int) ((Number) data.get(0)).byteValue()) + "mmHg ,systolicPressure is " + ((int) ((Number) data.get(1)).byteValue()) + "mmHg");
                        }
                    } else if (b9 == -111) {
                        if (data.size() == 1) {
                            h.g("NOTIFY_REALTIME_REPORT_HEART_RATE: heartRate is " + ((int) ((Number) data.get(0)).byteValue()));
                        }
                    } else if (b9 == -107) {
                        if (data.size() == 2) {
                            h.g("NOTIFY_REALTIME_REPORT_BLOOD_OXYGEN: veinBloodOxygen is " + ((int) ((Number) data.get(0)).byteValue()) + "% ,arteryBloodOxygen is " + ((int) ((Number) data.get(1)).byteValue()) + "%");
                        }
                    } else if (b9 != -108) {
                        h.d("This functionCode in hex " + o.d.q(new Object[]{Byte.valueOf(b9)}, 1, "%02x", "format(...)") + " is not support yet !!", null);
                        zJ = false;
                    } else if (!data.isEmpty()) {
                        Intrinsics.checkNotNullParameter(data, "<this>");
                        StringBuilder sb2 = new StringBuilder();
                        Iterator it = data.iterator();
                        while (it.hasNext()) {
                            sb2.append(String.valueOf((char) ((Number) it.next()).byteValue()));
                        }
                        String string = sb2.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        h.g("NOTIFY_DIAL: dialNumber is " + string);
                    }
                }
            }
            zJ = true;
        }
        if (z3) {
            if (!zJ) {
                e(b9, i8);
            } else {
                h.g("ResponseReceivedSuccess");
                f(b9, true, new byte[]{(byte) i8, 0});
            }
        }
    }
}
