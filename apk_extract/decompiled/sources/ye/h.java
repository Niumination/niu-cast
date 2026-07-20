package ye;

import android.net.wifi.WifiManager;
import android.os.RemoteException;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.transsion.widgetsliquid.view.OSLiquidSearchBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WifiManager f11191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f11192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f11193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f11194d;
    public static Boolean e;
    public static Boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer[] f11195g = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Integer[] f11196h = {36, 40, 44, 48, 52, 56, 60, 64, 100, 104, 108, Integer.valueOf(DeviceType.INFRARED_HEATER), 116, 120, Integer.valueOf(OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION), 128, 132, 136, 140, 144, 149, 153, 157, 161, 165};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Integer[] f11197i = {1, 5, 9, 13, 17, 21, 25, 29, 33, 37, 41, 45, 49, 53, 57, 61, 65, 69, 73, 77, 81, 85, 89, 93, 97, 101, Integer.valueOf(DeviceType.INFRARED_AIR_CONDITION), 109, Integer.valueOf(DeviceType.INFRARED_ELECTRIC_HEATER), 117, 121, 125, 129, 133, 137, 141, 145, 149, 153, 157, 161, 165, 169, 173, 177, 181, 185, 189, 193, 197, Integer.valueOf(l5.a.CODE_SCANNER_CANCELLED), Integer.valueOf(l5.a.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR), 209, 213, 217, 221, 225, 229, 233};

    public static int a(int i8) {
        if (i8 != 0 && !f(i8) && c(i8) != 0) {
            return i8;
        }
        if (1 <= i8 && i8 < 15) {
            return ((i8 - 1) * 5) + 2412;
        }
        if (36 <= i8 && i8 < 166) {
            return ((i8 - 36) * 5) + 5180;
        }
        if (1 > i8 || i8 >= 234) {
            return 0;
        }
        return ((i8 - 1) * 5) + 5955;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0027, code lost:
    
        if (r4 == 5000) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(int r4) {
        /*
            r0 = 2412(0x96c, float:3.38E-42)
            r1 = 1
            if (r0 > r4) goto La
            r0 = 2485(0x9b5, float:3.482E-42)
            if (r4 >= r0) goto La
            goto L2a
        La:
            r0 = 5180(0x143c, float:7.259E-42)
            r2 = 2
            if (r0 > r4) goto L15
            r0 = 5886(0x16fe, float:8.248E-42)
            if (r4 >= r0) goto L15
        L13:
            r1 = r2
            goto L2a
        L15:
            r0 = 5955(0x1743, float:8.345E-42)
            r3 = 0
            if (r0 > r4) goto L20
            r0 = 7116(0x1bcc, float:9.972E-42)
            if (r4 >= r0) goto L20
        L1e:
            r1 = r3
            goto L2a
        L20:
            r0 = 2400(0x960, float:3.363E-42)
            if (r4 != r0) goto L25
            goto L2a
        L25:
            r0 = 5000(0x1388, float:7.006E-42)
            if (r4 != r0) goto L1e
            goto L13
        L2a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ye.h.b(int):int");
    }

    public static int c(int i8) {
        if (2412 <= i8 && i8 < 2485) {
            return a1.a.d(i8, 2412, 5, 1);
        }
        if (5180 <= i8 && i8 < 5886) {
            return a1.a.d(i8, 5180, 5, 36);
        }
        if (5955 > i8 || i8 >= 7116) {
            return 0;
        }
        return a1.a.d(i8, 5955, 5, 1);
    }

    public static String d() {
        tc.d dVarH = tc.d.h();
        String strG = null;
        if (!dVarH.k()) {
            vc.a.b("KolunScannerManager", "mKolunScanner is dead");
        } else if (dVarH.i().isEmpty()) {
            vc.a.b("KolunScannerManager", "mContext is null");
        } else {
            try {
                strG = ((tc.a) ((tc.c) dVarH.f10209a)).g(dVarH.i());
            } catch (RemoteException e4) {
                vc.a.a(5, "KolunScannerManager", "getIpAddress,err:", e4);
            }
        }
        we.h.g("获取热点的ip地址 : " + strG);
        Intrinsics.checkNotNull(strG);
        return strG;
    }

    public static ArrayList e() {
        ArrayList arrayList = new ArrayList();
        Boolean bool = f11193c;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            arrayList.add("5G");
        }
        if (Intrinsics.areEqual(f11192b, bool2)) {
            arrayList.add("2.4G");
        }
        if (Intrinsics.areEqual(f11194d, bool2)) {
            arrayList.add("6G");
        }
        if (Intrinsics.areEqual(e, bool2)) {
            arrayList.add("60G");
        }
        if (Intrinsics.areEqual(f, bool2)) {
            arrayList.add("P2P");
        }
        return arrayList;
    }

    public static boolean f(int i8) {
        if (i8 == 0 || ArraysKt.contains(f11195g, Integer.valueOf(i8)) || ArraysKt.contains(f11196h, Integer.valueOf(i8))) {
            return true;
        }
        ArraysKt.contains(f11197i, Integer.valueOf(i8));
        return false;
    }

    public static String g(int i8) {
        if (i8 < 8) {
            i8 = 8;
        }
        IntRange intRange = new IntRange(1, i8);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(intRange));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            Character ch2 = (Character) CollectionsKt___CollectionsKt.random(CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'f'), (Iterable) new CharRange('A', 'Z')), (Iterable) new CharRange('0', '9')), Random.INSTANCE);
            ch2.getClass();
            arrayList.add(ch2);
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
    }

    public abstract void h(String str, String str2, String str3, boolean z2, int i8);
}
