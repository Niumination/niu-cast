package se;

import androidx.core.view.PointerIconCompat;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceExtension;
import com.welink.protocol.nfbd.WirelessDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.lb;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 {
    public String A;
    public String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9813d;
    public int e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f9815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f9817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f9818k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f9822o;
    public String p;
    public int q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public WirelessDevice f9825t;
    public List u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public NearDeviceExtension f9826v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public byte f9827w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9828x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9829y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9830z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f9819l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f9820m = Integer.valueOf(PointerIconCompat.TYPE_CELL);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9821n = PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public UInt f9823r = UInt.m248boximpl(0);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9824s = -1;

    public final NearDevice a() {
        this.f = b(this.f9813d, false, false);
        this.f9814g = UInt.m254constructorimpl((int) b(this.f9813d, true, true));
        int i8 = this.f9813d;
        ArrayList arrayList = new ArrayList();
        List list = null;
        if (i8 != 0 && i8 != 1 && i8 != 4 && i8 != 5) {
            if (i8 != 251) {
                switch (i8) {
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        String strM = o.d.m("Unsupported service type: ", "NearDevice", "tag", "mes", i8);
                        if (lb.f6529c >= 1) {
                            h0.a.x("TransConnect:", strM, "NearDevice", null);
                        }
                        break;
                }
            } else {
                NearDeviceExtension nearDeviceExtension = this.f9826v;
                List list2 = nearDeviceExtension != null ? nearDeviceExtension.f3905a : null;
                if (list2 != null && list2.size() == 1) {
                    int iIntValue = ((Number) list2.get(0)).intValue();
                    if (iIntValue != 0 && iIntValue != 1 && iIntValue != 4 && iIntValue != 5) {
                        switch (iIntValue) {
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                break;
                            default:
                                if (((Number) list2.get(0)).intValue() > 31) {
                                    we.h.j("NearDevice", "Found Private Service Type, " + list2.get(0));
                                    arrayList.add(list2.get(0));
                                }
                                we.h.h("NearDevice", "Get Service Target, capabilities: " + list2 + ", multi-private-service: " + CollectionsKt.toList(arrayList));
                                list = CollectionsKt.toList(arrayList);
                                break;
                        }
                    }
                } else {
                    if (list2 != null) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Number) it.next()).intValue();
                            if (iIntValue2 != 0 && iIntValue2 != 1 && iIntValue2 != 4 && iIntValue2 != 5) {
                                switch (iIntValue2) {
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                        break;
                                    default:
                                        if (iIntValue2 > 31) {
                                            we.h.j("NearDevice", "Found Private Service Type, " + iIntValue2);
                                            arrayList.add(Integer.valueOf(iIntValue2));
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    we.h.h("NearDevice", "Get Service Target, capabilities: " + list2 + ", multi-service: " + arrayList);
                    list = CollectionsKt.toList(arrayList);
                }
            }
        }
        this.f9815h = list;
        String str = this.f9810a;
        String str2 = this.f9818k;
        String str3 = this.f9811b;
        Integer num = this.f9819l;
        String str4 = this.f9817j;
        int i9 = this.f9812c;
        int i10 = this.f9813d;
        int i11 = this.e;
        int i12 = this.f9816i;
        UInt uInt = this.f9823r;
        String str5 = this.f9822o;
        String str6 = this.p;
        int i13 = this.q;
        int i14 = this.f9824s;
        return new NearDevice(str, str2, str3, num, str4, i9, i10, i11, i12, uInt, str5, str6, i13, i14, this.f9820m, PointerIconCompat.TYPE_ALIAS, this.f9821n, 0, Boolean.valueOf(i14 == 1002), this.f, this.f9814g, this.f9815h, this.f9825t, this.u, this.f9826v, this.f9827w, this.f9828x, this.f9829y, this.f9830z, this.A, this.B);
    }

    public final long b(int i8, boolean z2, boolean z3) {
        int i9;
        long j8;
        long j10;
        long j11;
        int i10;
        long j12;
        long j13;
        long j14;
        long jIntValue;
        int i11;
        long j15;
        if (i8 == 0) {
            return 1L;
        }
        int i12 = 1;
        if (i8 != 1) {
            if (i8 != 4) {
                int i13 = 5;
                if (i8 != 5) {
                    int i14 = 15;
                    if (i8 != 15) {
                        int i15 = 256;
                        int i16 = 512;
                        if (i8 == 251) {
                            NearDeviceExtension nearDeviceExtension = this.f9826v;
                            List list = nearDeviceExtension != null ? nearDeviceExtension.f3905a : null;
                            int i17 = 0;
                            if (list != null && list.size() == 1) {
                                int iIntValue = ((Number) list.get(0)).intValue();
                                if (iIntValue != 0) {
                                    if (iIntValue != 1) {
                                        if (iIntValue == 4) {
                                            j15 = 4;
                                        } else if (iIntValue == 5) {
                                            i11 = 8;
                                        } else if (iIntValue != 15) {
                                            switch (iIntValue) {
                                                case 8:
                                                    i11 = 16;
                                                    break;
                                                case 9:
                                                    j15 = 32;
                                                    break;
                                                case 10:
                                                    i11 = 64;
                                                    break;
                                                case 11:
                                                    i11 = 128;
                                                    break;
                                                case 12:
                                                    j15 = 256;
                                                    break;
                                                case 13:
                                                    j15 = 512;
                                                    break;
                                                default:
                                                    if (((Number) list.get(0)).intValue() > 31 && !z3) {
                                                        we.h.j("NearDevice", "Found Private Service Type, " + list.get(0));
                                                        jIntValue = (long) (((Number) list.get(0)).intValue() << 32);
                                                    } else {
                                                        jIntValue = 0;
                                                    }
                                                    break;
                                            }
                                        } else {
                                            i11 = 1024;
                                        }
                                        jIntValue = j15 & 4294967295L;
                                    } else {
                                        i11 = 2;
                                    }
                                    j15 = i11;
                                    jIntValue = j15 & 4294967295L;
                                } else {
                                    jIntValue = 1;
                                }
                                we.h.h("NearDevice", "Get Service Target, capabilities: " + list + ", single-service: " + jIntValue);
                                return jIntValue;
                            }
                            if (list != null) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    if (((Number) it.next()).intValue() > 31) {
                                        i17++;
                                    }
                                }
                            }
                            if (list != null) {
                                Iterator it2 = list.iterator();
                                long j16 = 0;
                                while (it2.hasNext()) {
                                    int iIntValue2 = ((Number) it2.next()).intValue();
                                    if (iIntValue2 != 0) {
                                        if (iIntValue2 != i12) {
                                            if (iIntValue2 == 4) {
                                                j12 = 4;
                                            } else if (iIntValue2 != i13) {
                                                if (iIntValue2 != i14) {
                                                    switch (iIntValue2) {
                                                        case 8:
                                                            j12 = 16;
                                                            break;
                                                        case 9:
                                                            j16 |= ((long) 32) & 4294967295L;
                                                            break;
                                                        case 10:
                                                            j12 = 64;
                                                            break;
                                                        case 11:
                                                            j13 = 128;
                                                            j14 = j13 & 4294967295L;
                                                            j16 |= j14;
                                                            break;
                                                        case 12:
                                                            j13 = i15;
                                                            j14 = j13 & 4294967295L;
                                                            j16 |= j14;
                                                            break;
                                                        case 13:
                                                            j13 = i16;
                                                            j14 = j13 & 4294967295L;
                                                            j16 |= j14;
                                                            break;
                                                        default:
                                                            if (iIntValue2 > 31 && !z3) {
                                                                we.h.j("NearDevice", "Found Private Service Type, " + iIntValue2);
                                                                if (i17 == i12) {
                                                                    j14 = iIntValue2 << 32;
                                                                    j16 |= j14;
                                                                } else {
                                                                    we.h.j("NearDevice", "Found multi-private-service, " + iIntValue2);
                                                                }
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    i10 = 1024;
                                                }
                                                i12 = 1;
                                                i15 = 256;
                                                i16 = 512;
                                                i13 = 5;
                                                i14 = 15;
                                            } else {
                                                i10 = 8;
                                            }
                                            j11 = j12 & 4294967295L;
                                        } else {
                                            i10 = 2;
                                        }
                                        j11 = ((long) i10) & 4294967295L;
                                    } else {
                                        j11 = 1;
                                    }
                                    j16 |= j11;
                                    i12 = 1;
                                    i15 = 256;
                                    i16 = 512;
                                    i13 = 5;
                                    i14 = 15;
                                }
                                j10 = j16;
                            } else {
                                j10 = 0;
                            }
                            we.h.h("NearDevice", "Get Service Target, capabilities: " + list + ", multi-service: " + j10);
                            if (z2) {
                                return j10;
                            }
                            return 0L;
                        }
                        switch (i8) {
                            case 8:
                                j8 = 16;
                                break;
                            case 9:
                                j8 = 32;
                                break;
                            case 10:
                                j8 = 64;
                                break;
                            case 11:
                                j8 = 128;
                                break;
                            case 12:
                                j8 = 256;
                                break;
                            case 13:
                                j8 = 512;
                                break;
                            default:
                                String strM = o.d.m("Unsupported service type: ", "NearDevice", "tag", "mes", i8);
                                if (lb.f6529c >= 1) {
                                    h0.a.x("TransConnect:", strM, "NearDevice", null);
                                }
                                return 0L;
                        }
                    } else {
                        i9 = 1024;
                    }
                } else {
                    i9 = 8;
                }
            } else {
                j8 = 4;
            }
            return j8 & 4294967295L;
        }
        i9 = 2;
        j8 = i9;
        return j8 & 4294967295L;
    }

    public final void c(Integer num) {
        int i8;
        if (num.intValue() == 10) {
            i8 = 1000;
        } else {
            i8 = (num.intValue() == 11 || num.intValue() == 12) ? 1001 : -1;
        }
        this.f9824s = i8;
    }
}
