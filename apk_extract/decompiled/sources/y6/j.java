package y6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.transsion.athena.data.AppIdData;
import com.transsion.message.bank.MessageBank;
import df.m;
import ef.o;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.dd;
import m3.d0;
import m3.f0;
import m3.g0;
import m3.h0;
import m3.i0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11104d;
    public final ArrayList e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray f11105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11106i;

    public j(Handler handler, String str, ArrayList arrayList, boolean z2, SparseArray sparseArray) {
        super(handler);
        this.f11106i = false;
        this.f11104d = str;
        this.e = arrayList;
        this.f11103c = z2;
        this.f11105h = sparseArray;
    }

    public static void f(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject3 != null) {
                try {
                    if (jSONObject3.length() > 0) {
                        JSONObject jSONObject4 = new JSONObject();
                        if (jSONObject2.has("_ext")) {
                            jSONObject4 = jSONObject2.getJSONObject("_ext");
                        }
                        Iterator<String> itKeys = jSONObject3.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            String str = "_" + next;
                            Object obj = jSONObject3.get(next);
                            if (!jSONObject4.has(str)) {
                                jSONObject4.putOpt(str, obj);
                            }
                        }
                        int length = jSONObject4.toString().getBytes(StandardCharsets.UTF_8).length;
                        if (length > 2000) {
                            String str2 = String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                            z6.a.c(str2);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("errorMsg", str2);
                            jSONObject2.put("_ext", jSONObject5);
                        } else {
                            jSONObject2.put("_ext", jSONObject4);
                        }
                    }
                } catch (Exception e) {
                    z6.a.d("Insert common params exception : %s", e.getMessage());
                    return;
                }
            }
            jSONObject.put("eparam", jSONObject2.toString());
        }
    }

    public static void g(s6.c cVar, String str, boolean z2) {
        int iAbs;
        if (z2) {
            try {
                String strB = z6.b.b();
                if (TextUtils.isEmpty(strB)) {
                    strB = g0.h(e8.b.f4712i);
                }
                iAbs = (TextUtils.isEmpty(strB) || strB.hashCode() == 0) ? 1800000 : (Math.abs(strB.hashCode()) % 30) * 60000;
            } catch (Exception e) {
                z6.a.d("Handle pull config exception after upload : %s", e.getMessage());
                e8.d.a("handlePullConfig", e);
                return;
            }
        } else {
            iAbs = 0;
        }
        cVar.f9533g = str;
        cVar.f9532d = 0L;
        cVar.c(System.currentTimeMillis() + ((long) iAbs));
        u6.a.h(e8.b.f4712i).s(cVar, false);
    }

    @Override // y6.d
    public final void a() throws Throwable {
        String str;
        int iNextInt;
        w6.a aVarC = w6.a.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (aVarC.f10668c) {
            w6.b bVar = aVarC.f10666a;
            jCurrentTimeMillis = (bVar.f10670a + jElapsedRealtime) - bVar.f10671b;
        }
        long j8 = jCurrentTimeMillis;
        ArrayList<AppIdData> arrayList = this.e;
        Iterator it = arrayList.iterator();
        int i8 = 0;
        AppIdData appIdData = null;
        while (true) {
            boolean zHasNext = it.hasNext();
            str = this.f11104d;
            if (!zHasNext) {
                break;
            }
            AppIdData appIdData2 = (AppIdData) it.next();
            if (!TextUtils.isEmpty(appIdData2.f2315c) && TextUtils.equals(appIdData2.f2317h, str)) {
                if (appIdData != null) {
                    if (!TextUtils.equals(appIdData.f2315c, appIdData2.f2315c)) {
                        i8++;
                        break;
                    }
                } else {
                    i8++;
                    appIdData = appIdData2;
                }
            }
        }
        if (i8 != 1) {
            if (i8 > 1) {
                ArrayList arrayList2 = new ArrayList();
                for (AppIdData appIdData3 : arrayList) {
                    if (!TextUtils.isEmpty(appIdData3.f2315c) && TextUtils.equals(appIdData3.f2317h, str)) {
                        arrayList2.add(appIdData3);
                    }
                }
                u6.a.h(e8.b.f4712i).r(arrayList2);
            }
            appIdData = null;
        }
        s6.e eVar = (s6.e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a;
        eVar.getClass();
        try {
            int iIntValue = ((Integer) eVar.f9569m.first).intValue();
            int iIntValue2 = ((Integer) eVar.f9569m.second).intValue();
            String str2 = z6.b.f11259a;
            iNextInt = new Random().nextInt((iIntValue2 - iIntValue) + 1) + iIntValue;
        } catch (Exception e) {
            e.printStackTrace();
            iNextInt = 6;
        }
        long j10 = 1000 * ((long) iNextInt);
        if (appIdData != null) {
            Pair pairD = d(appIdData.f2315c, 0L);
            List list = (List) pairD.second;
            if (dd.i(list)) {
                e(list, (String) pairD.first, j8, j10, appIdData.f2316d);
                return;
            }
            return;
        }
        Pair pairD2 = d(null, j8);
        String str3 = (String) pairD2.first;
        List list2 = (List) pairD2.second;
        if (dd.i(list2)) {
            e(list2, str3, j8, j10, 0);
        }
    }

    @Override // y6.d
    public final String c() {
        String str = this.f11104d;
        if (TextUtils.isEmpty(str)) {
            return "Default";
        }
        try {
            String[] strArrSplit = str.split("//");
            if (strArrSplit.length > 0) {
                return strArrSplit[1].split("\\.")[0];
            }
        } catch (Exception e) {
            z6.a.d("get domain exception : %s", e.getMessage());
        }
        return "Default";
    }

    public final Pair d(String str, long j8) {
        String string;
        t6.c cVarD;
        NetworkCapabilities networkCapabilities;
        NetworkCapabilities networkCapabilities2;
        LinkedList linkedList = new LinkedList();
        int i8 = 0;
        int i9 = 0;
        loop0: for (AppIdData appIdData : this.e) {
            if (TextUtils.equals(appIdData.f2317h, this.f11104d)) {
                s6.c cVarC = ((i1.b) m6.a.f().f7948a.f8123c).c(appIdData.f2313a);
                CopyOnWriteArrayList<s6.a> copyOnWriteArrayList = cVarC != null ? cVarC.f : null;
                if (dd.i(copyOnWriteArrayList)) {
                    int i10 = i9;
                    int i11 = i8;
                    for (s6.a aVar : copyOnWriteArrayList) {
                        s6.b bVar = aVar.f9515c;
                        long j10 = bVar.f9523i;
                        long jB = bVar.b();
                        if (j10 != -1 && jB != -1) {
                            boolean z2 = Math.abs(j8 - j10) >= jB;
                            int i12 = bVar.f9524j;
                            boolean z3 = i12 > 0 && i12 <= bVar.f9525k;
                            int i13 = bVar.e;
                            if (i13 != 0) {
                                if (i13 == 1) {
                                    Context context = e8.b.f4712i;
                                    try {
                                        if (f0.d(context)) {
                                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                            Network activeNetwork = connectivityManager.getActiveNetwork();
                                            if (!((activeNetwork == null || (networkCapabilities2 = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) ? false : networkCapabilities2.hasTransport(1))) {
                                                Network activeNetwork2 = connectivityManager.getActiveNetwork();
                                                if (!((activeNetwork2 == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork2)) == null) ? false : networkCapabilities.hasTransport(3))) {
                                                    continue;
                                                }
                                            }
                                        }
                                    } catch (Exception unused) {
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            if (z2 || z3) {
                                if (this.f11103c) {
                                    try {
                                        u6.a.h(e8.b.f4712i).k(aVar.f9513a, new e0.b(24));
                                    } catch (Exception e) {
                                        z6.a.d("Upload 1.x events exception : %s", e.getMessage());
                                        e8.d.a("checkUploadFile", e);
                                    }
                                }
                                u6.a aVarH = u6.a.h(e8.b.f4712i);
                                long j11 = aVar.f9513a;
                                int i14 = 921600 - i10;
                                int i15 = 2000 - i11;
                                synchronized (aVarH) {
                                    try {
                                        cVarD = ((u6.c) aVarH.f10379c).d(u6.b.f10381a, j11, j8, str, i14, i15);
                                    } catch (e8.d e4) {
                                        int i16 = e8.d.f4719a;
                                        e8.g.f4735b.a(e4);
                                        cVarD = null;
                                    }
                                }
                                if (cVarD != null && (linkedList.contains(appIdData) || linkedList.add(appIdData))) {
                                    appIdData.e.add(cVarD);
                                    i11 += cVarD.f;
                                    i10 += cVarD.f10182g;
                                    if (i11 >= 2000 || i10 >= 921600) {
                                        z6.a.f("Packet size out of limit, packetSize [%d], eventCount [%d]", Integer.valueOf(i10), Integer.valueOf(i11));
                                        break loop0;
                                    }
                                }
                            }
                        }
                    }
                    i8 = i11;
                    i9 = i10;
                } else {
                    z6.a.d("Appid [%d] checkUpload tid config is null.", Integer.valueOf(appIdData.f2313a));
                }
                if (dd.g(appIdData.e)) {
                    u6.a.h(e8.b.f4712i).r(Collections.singletonList(appIdData));
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            Random random = new Random();
            StringBuilder sb2 = new StringBuilder();
            for (int i17 = 0; i17 < 8; i17++) {
                sb2.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(36)));
            }
            string = sb2.toString();
            u6.a aVarH2 = u6.a.h(e8.b.f4712i);
            synchronized (aVarH2) {
                try {
                    ((u6.c) aVarH2.f10379c).k(u6.b.f10381a, linkedList, string);
                } catch (e8.d e10) {
                    int i18 = e8.d.f4719a;
                    e8.g.f4735b.a(e10);
                }
            }
        } else {
            string = str;
        }
        return new Pair(string, linkedList);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00eb A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f1 A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f7 A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0101  */
    /* JADX WARN: Code duplicated, block: B:63:0x010d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0112  */
    /* JADX WARN: Code duplicated, block: B:67:0x0117  */
    /* JADX WARN: Code duplicated, block: B:69:0x011c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:70:0x011d A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0127 A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x012f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0131 A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0139  */
    /* JADX WARN: Code duplicated, block: B:79:0x013b A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0143  */
    /* JADX WARN: Code duplicated, block: B:82:0x0145  */
    /* JADX WARN: Code duplicated, block: B:84:0x0149  */
    /* JADX WARN: Code duplicated, block: B:86:0x014c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x014e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0151  */
    /* JADX WARN: Code duplicated, block: B:90:0x0152 A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0158 A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x015e A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0164 A[Catch: Exception -> 0x00e8, TryCatch #8 {Exception -> 0x00e8, blocks: (B:18:0x0080, B:20:0x0088, B:23:0x008e, B:25:0x0094, B:27:0x009c, B:30:0x00a8, B:33:0x00ae, B:35:0x00b6, B:38:0x00bc, B:40:0x00c4, B:43:0x00ca, B:45:0x00d2, B:48:0x00d8, B:51:0x00e1, B:94:0x0169, B:54:0x00eb, B:56:0x00f1, B:58:0x00fd, B:61:0x0103, B:90:0x0152, B:91:0x0158, B:92:0x015e, B:93:0x0164, B:70:0x011d, B:73:0x0127, B:76:0x0131, B:79:0x013b, B:57:0x00f7), top: B:406:0x0080 }] */
    public final void e(List list, String str, long j8, long j10, int i8) throws Throwable {
        m mVar;
        JSONObject jSONObject;
        String string;
        boolean z2;
        long j11;
        JSONObject jSONObject2;
        String str2;
        int iHashCode;
        byte b9;
        long j12 = j8;
        long j13 = j10;
        int i9 = i8;
        while (f0.d(e8.b.f4712i)) {
            boolean zH = z6.b.h(e8.b.f4712i);
            LinkedList linkedList = new LinkedList();
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            int i10 = 0;
            while (true) {
                s6.a aVar = null;
                if (!it.hasNext()) {
                    break;
                }
                AppIdData appIdData = (AppIdData) it.next();
                JSONArray jSONArray2 = new JSONArray();
                int i11 = 0;
                for (t6.c cVar : appIdData.e) {
                    Iterator it2 = it;
                    for (t6.b bVar : cVar.f10180c) {
                        long j14 = j13;
                        try {
                            j11 = j12;
                            try {
                                JSONObject jSONObjectPut = new JSONObject().put("tid", cVar.f10178a);
                                String str3 = bVar.f10174a;
                                if (str3 == null) {
                                    str3 = "";
                                }
                                JSONObject jSONObjectPut2 = jSONObjectPut.put(NotificationCompat.CATEGORY_EVENT, str3).put("ts", bVar.f10175b).put("net", bVar.f10177d);
                                String str4 = bVar.f10176c;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                String str5 = bVar.f10174a;
                                if (str5 == null) {
                                    str5 = "";
                                }
                                if (str5.equals("app_active")) {
                                    if (TextUtils.isEmpty(str4)) {
                                        jSONObject2 = new JSONObject();
                                    } else {
                                        jSONObject2 = new JSONObject(str4);
                                    }
                                    str2 = bVar.f10174a;
                                    if (str2 == null) {
                                        str2 = "";
                                    }
                                    iHashCode = str2.hashCode();
                                    if (iHashCode != -1801031586) {
                                        if (iHashCode != 753371876) {
                                            if (iHashCode != 1066479505) {
                                                if (iHashCode == 1616733480 && str2.equals("page_enter")) {
                                                    b9 = 1;
                                                } else {
                                                    b9 = -1;
                                                }
                                            } else if (str2.equals("app_launch")) {
                                                b9 = 2;
                                            } else {
                                                b9 = -1;
                                            }
                                        } else if (str2.equals("app_active")) {
                                            b9 = 0;
                                        } else {
                                            b9 = -1;
                                        }
                                    } else if (str2.equals("app_heartbeat")) {
                                        b9 = 3;
                                    } else {
                                        b9 = -1;
                                    }
                                    if (b9 != 0) {
                                        f(jSONObjectPut2, jSONObject2, s6.d.f9555w);
                                    } else if (b9 != 1) {
                                        f(jSONObjectPut2, jSONObject2, s6.d.f9556x);
                                    } else if (b9 != 2) {
                                        f(jSONObjectPut2, jSONObject2, s6.d.f9557y);
                                    } else if (b9 != 3) {
                                        f(jSONObjectPut2, jSONObject2, s6.d.f9558z);
                                    }
                                } else {
                                    String str6 = bVar.f10174a;
                                    if (str6 == null) {
                                        str6 = "";
                                    }
                                    if (str6.equals("page_enter")) {
                                        if (TextUtils.isEmpty(str4)) {
                                            jSONObject2 = new JSONObject();
                                        } else {
                                            jSONObject2 = new JSONObject(str4);
                                        }
                                        str2 = bVar.f10174a;
                                        if (str2 == null) {
                                            str2 = "";
                                        }
                                        iHashCode = str2.hashCode();
                                        if (iHashCode != -1801031586) {
                                            if (iHashCode != 753371876) {
                                                if (iHashCode != 1066479505) {
                                                    if (iHashCode == 1616733480) {
                                                        b9 = 1;
                                                    }
                                                    b9 = -1;
                                                } else if (str2.equals("app_launch")) {
                                                    b9 = 2;
                                                } else {
                                                    b9 = -1;
                                                }
                                            } else if (str2.equals("app_active")) {
                                                b9 = 0;
                                            } else {
                                                b9 = -1;
                                            }
                                        } else if (str2.equals("app_heartbeat")) {
                                            b9 = 3;
                                        } else {
                                            b9 = -1;
                                        }
                                        if (b9 != 0) {
                                            f(jSONObjectPut2, jSONObject2, s6.d.f9555w);
                                        } else if (b9 != 1) {
                                            f(jSONObjectPut2, jSONObject2, s6.d.f9556x);
                                        } else if (b9 != 2) {
                                            f(jSONObjectPut2, jSONObject2, s6.d.f9557y);
                                        } else if (b9 != 3) {
                                            f(jSONObjectPut2, jSONObject2, s6.d.f9558z);
                                        }
                                    } else {
                                        String str7 = bVar.f10174a;
                                        if (str7 == null) {
                                            str7 = "";
                                        }
                                        if (str7.equals("app_launch")) {
                                            if (TextUtils.isEmpty(str4)) {
                                                jSONObject2 = new JSONObject();
                                            } else {
                                                jSONObject2 = new JSONObject(str4);
                                            }
                                            str2 = bVar.f10174a;
                                            if (str2 == null) {
                                                str2 = "";
                                            }
                                            iHashCode = str2.hashCode();
                                            if (iHashCode != -1801031586) {
                                                if (iHashCode != 753371876) {
                                                    if (iHashCode != 1066479505) {
                                                        if (iHashCode == 1616733480) {
                                                            b9 = 1;
                                                        }
                                                        b9 = -1;
                                                    } else if (str2.equals("app_launch")) {
                                                        b9 = 2;
                                                    } else {
                                                        b9 = -1;
                                                    }
                                                } else if (str2.equals("app_active")) {
                                                    b9 = 0;
                                                } else {
                                                    b9 = -1;
                                                }
                                            } else if (str2.equals("app_heartbeat")) {
                                                b9 = 3;
                                            } else {
                                                b9 = -1;
                                            }
                                            if (b9 != 0) {
                                                f(jSONObjectPut2, jSONObject2, s6.d.f9555w);
                                            } else if (b9 != 1) {
                                                f(jSONObjectPut2, jSONObject2, s6.d.f9556x);
                                            } else if (b9 != 2) {
                                                f(jSONObjectPut2, jSONObject2, s6.d.f9557y);
                                            } else if (b9 != 3) {
                                                f(jSONObjectPut2, jSONObject2, s6.d.f9558z);
                                            }
                                        } else {
                                            String str8 = bVar.f10174a;
                                            if (str8 == null) {
                                                str8 = "";
                                            }
                                            if (str8.equals("app_heartbeat")) {
                                                if (TextUtils.isEmpty(str4)) {
                                                    jSONObject2 = new JSONObject();
                                                } else {
                                                    jSONObject2 = new JSONObject(str4);
                                                }
                                                str2 = bVar.f10174a;
                                                if (str2 == null) {
                                                    str2 = "";
                                                }
                                                iHashCode = str2.hashCode();
                                                if (iHashCode != -1801031586) {
                                                    if (iHashCode != 753371876) {
                                                        if (iHashCode != 1066479505) {
                                                            if (iHashCode == 1616733480) {
                                                                b9 = 1;
                                                            }
                                                            b9 = -1;
                                                        } else if (str2.equals("app_launch")) {
                                                            b9 = 2;
                                                        } else {
                                                            b9 = -1;
                                                        }
                                                    } else if (str2.equals("app_active")) {
                                                        b9 = 0;
                                                    } else {
                                                        b9 = -1;
                                                    }
                                                } else if (str2.equals("app_heartbeat")) {
                                                    b9 = 3;
                                                } else {
                                                    b9 = -1;
                                                }
                                                if (b9 != 0) {
                                                    f(jSONObjectPut2, jSONObject2, s6.d.f9555w);
                                                } else if (b9 != 1) {
                                                    f(jSONObjectPut2, jSONObject2, s6.d.f9556x);
                                                } else if (b9 != 2) {
                                                    f(jSONObjectPut2, jSONObject2, s6.d.f9557y);
                                                } else if (b9 != 3) {
                                                    f(jSONObjectPut2, jSONObject2, s6.d.f9558z);
                                                }
                                            } else {
                                                jSONObjectPut2.put("eparam", str4);
                                            }
                                        }
                                    }
                                }
                                jSONArray2.put(jSONObjectPut2);
                            } catch (Exception e) {
                                e = e;
                                z6.a.d("Assemble events packet exception : %s", e.getMessage());
                            }
                        } catch (Exception e4) {
                            e = e4;
                            j11 = j12;
                        }
                        j13 = j14;
                        j12 = j11;
                    }
                    i11 += cVar.f;
                    it = it2;
                }
                long j15 = j12;
                long j16 = j13;
                Iterator it3 = it;
                String str9 = (String) this.f11105h.get(appIdData.f2313a, "");
                if (!TextUtils.isEmpty(str9)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str9);
                        String string2 = jSONObject3.has("eparam") ? jSONObject3.getString("eparam") : "";
                        f(jSONObject3, TextUtils.isEmpty(string2) ? new JSONObject() : new JSONObject(string2), s6.d.f9556x);
                        if (jSONObject3.getLong("tid") < 9999) {
                            m6.a aVarF = m6.a.f();
                            int i12 = appIdData.f2313a;
                            String string3 = jSONObject3.getString(NotificationCompat.CATEGORY_EVENT);
                            s6.c cVarC = ((i1.b) aVarF.f7948a.f8123c).c(i12);
                            if (cVarC != null) {
                                for (s6.a aVar2 : cVarC.f) {
                                    if (TextUtils.equals(aVar2.f9514b, string3)) {
                                        aVar = aVar2;
                                        break;
                                    }
                                }
                            }
                            s6.a aVar3 = aVar;
                            if (aVar3 != null) {
                                jSONObject3.put("tid", aVar3.f9513a);
                                jSONArray2.put(jSONObject3);
                            } else {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("appid", appIdData.f2313a);
                                jSONObject4.put(NotificationCompat.CATEGORY_EVENT, jSONObject3.getString(NotificationCompat.CATEGORY_EVENT));
                                z6.a.d("invalid or not registered:%s", jSONObject4.toString());
                                z2 = true;
                                this.f11106i = z2;
                            }
                        } else {
                            jSONArray2.put(jSONObject3);
                        }
                        z2 = true;
                        i11++;
                    } catch (Exception e10) {
                        z6.a.d("Insert FPE event exception : %s", e10.getMessage());
                    }
                    this.f11106i = z2;
                }
                int i13 = i11;
                try {
                    JSONObject jSONObject5 = TextUtils.isEmpty(appIdData.f2314b) ? new JSONObject() : new JSONObject(appIdData.f2314b);
                    JSONObject jSONObjectPut3 = new JSONObject().put("appid", appIdData.f2313a).put("hostid", t6.d.f10184a);
                    String strOptString = jSONObject5.optString("pkgName");
                    if (strOptString == null) {
                        strOptString = "";
                    }
                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("pkg", strOptString);
                    String strOptString2 = jSONObject5.optString("versionName");
                    if (strOptString2 == null) {
                        strOptString2 = "";
                    }
                    JSONObject jSONObjectPut5 = jSONObjectPut4.put("vn", strOptString2);
                    String strOptString3 = jSONObject5.optString("versionCode");
                    if (strOptString3 == null) {
                        strOptString3 = "";
                    }
                    JSONObject jSONObjectPut6 = jSONObjectPut5.put("vc", strOptString3).put("sdkv", "3.1.1.0");
                    String strOptString4 = jSONObject5.optString("installer");
                    if (strOptString4 == null) {
                        strOptString4 = "";
                    }
                    jSONArray.put(jSONObjectPut6.put("ins", strOptString4).put("isfl", zH).put("cnt", i13).put("events", jSONArray2));
                } catch (Exception e11) {
                    z6.a.d("Assemble events packet exception : %s", e11.getMessage());
                }
                i10 += i13;
                linkedList.add(Integer.valueOf(appIdData.f2313a));
                it = it3;
                j13 = j16;
                j12 = j15;
            }
            long j17 = j12;
            long j18 = j13;
            String strC = g0.c(e8.b.f4712i, 0);
            try {
                JSONObject jSONObject6 = new JSONObject();
                String str10 = s6.d.f9538a;
                JSONObject jSONObjectPut7 = jSONObject6.put("channel", "");
                String strG = z6.b.g(e8.b.f4712i, "opid");
                if (strG == null) {
                    strG = "";
                }
                JSONObject jSONObjectPut8 = jSONObjectPut7.put("opid", strG);
                String strG2 = z6.b.g(e8.b.f4712i, "oneid");
                if (strG2 == null) {
                    strG2 = "";
                }
                JSONObject jSONObjectPut9 = jSONObjectPut8.put("tsid", strG2);
                String strA = h0.a();
                if (strA == null) {
                    strA = "";
                }
                JSONObject jSONObjectPut10 = jSONObjectPut9.put("vaid", strA);
                synchronized (s6.d.class) {
                    try {
                        jSONObject = s6.d.f9554v;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                Context context = e8.b.f4712i;
                if (TextUtils.isEmpty(i0.f7708b)) {
                    try {
                        string = Settings.Global.getString(context.getContentResolver(), "os_small_version");
                        i0.f7708b = string;
                    } catch (Exception e12) {
                        z6.a.c(Log.getStackTraceString(e12));
                        string = "";
                    }
                } else {
                    string = i0.f7708b;
                }
                jSONObject.put("ossv", string);
                if (jSONObject.length() > 0) {
                    int length = jSONObject.toString().getBytes(StandardCharsets.UTF_8).length;
                    if (length > 2000) {
                        String str11 = String.format(Locale.getDefault(), "custom param is too long, limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                        z6.a.d("%s", str11);
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("errorMsg", str11);
                        jSONObjectPut10.put("cparam", jSONObject7.toString());
                    } else {
                        jSONObjectPut10.put("cparam", jSONObject.toString());
                    }
                }
                JSONObject jSONObject8 = new JSONObject();
                String str12 = s6.d.f9538a;
                JSONObject jSONObjectPut11 = jSONObject8.put("actype", 0);
                String str13 = Build.VERSION.RELEASE;
                if (str13 == null) {
                    str13 = "";
                }
                JSONObject jSONObjectPut12 = jSONObjectPut11.put("aver", str13).put("appids", jSONArray);
                String str14 = Build.BRAND;
                if (str14 == null) {
                    str14 = "";
                }
                JSONObject jSONObjectPut13 = jSONObjectPut12.put("brand", str14);
                String str15 = Build.DISPLAY;
                if (str15 == null) {
                    str15 = "";
                }
                JSONObject jSONObjectPut14 = jSONObjectPut13.put("build", str15).put("ekey", jSONObjectPut10.toString());
                String strD = z6.b.d(e8.b.f4712i);
                if (strD == null) {
                    strD = "";
                }
                JSONObject jSONObjectPut15 = jSONObjectPut14.put("gaid", strD);
                String language = Locale.getDefault().getLanguage();
                if (language == null) {
                    language = "";
                }
                JSONObject jSONObjectPut16 = jSONObjectPut15.put("lang", language);
                String strM = g0.m(e8.b.f4712i);
                if (strM == null) {
                    strM = "";
                }
                JSONObject jSONObjectPut17 = jSONObjectPut16.put("mcc", strM);
                String strN = g0.n(e8.b.f4712i);
                if (strN == null) {
                    strN = "";
                }
                JSONObject jSONObjectPut18 = jSONObjectPut17.put("mnc", strN);
                String str16 = Build.MODEL;
                if (str16 == null) {
                    str16 = "";
                }
                JSONObject jSONObjectPut19 = jSONObjectPut18.put("model", str16).put("net", f0.b(e8.b.f4712i));
                String strA2 = i0.a();
                if (strA2 == null) {
                    strA2 = "";
                }
                JSONObject jSONObjectPut20 = jSONObjectPut19.put("osver", strA2).put("tuid", "").put("try", i9);
                String strG3 = g0.g();
                if (strG3 == null) {
                    strG3 = "";
                }
                JSONObject jSONObjectPut21 = jSONObjectPut20.put("tz", strG3).put("uts", System.currentTimeMillis());
                if (e8.b.j()) {
                    if (strC == null) {
                        strC = "";
                    }
                    jSONObjectPut21.put("iid", strC);
                }
                byte[] bytes = jSONObjectPut21.toString().getBytes(StandardCharsets.UTF_8);
                mVar = new m(10);
                mVar.f4460d = bytes;
                mVar.f4459c = i10;
                mVar.f4458b = linkedList;
            } catch (Exception e13) {
                z6.a.d("Assemble events packet exception : %s", e13.getMessage());
                mVar = null;
            }
            String str17 = this.f11104d;
            byte[] bArr = (byte[]) mVar.f4460d;
            int i14 = mVar.f4459c;
            LinkedList linkedList2 = (LinkedList) mVar.f4458b;
            Context context2 = e8.b.f4712i;
            String strB = TextUtils.isEmpty(g0.c(context2, 0)) ? z6.b.b() : g0.c(e8.b.f4712i, 0);
            if (TextUtils.isEmpty(strB)) {
                strB = g0.h(context2);
            }
            String str18 = String.format(Locale.getDefault(), "%s_%d", strB, Integer.valueOf(t6.d.f10184a));
            i iVar = new i();
            iVar.f11099a = str17;
            iVar.f11100b = bArr;
            iVar.f11101c = i14;
            iVar.f11102d = linkedList2;
            iVar.e = str;
            iVar.f = str18;
            try {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("host", this.f11104d);
                jSONObject9.put("requestId", iVar.hashCode());
                jSONObject9.put("packetId", str);
                JSONArray jSONArray3 = new JSONArray();
                Iterator it4 = list.iterator();
                while (it4.hasNext()) {
                    for (t6.c cVar2 : ((AppIdData) it4.next()).e) {
                        JSONObject jSONObject10 = new JSONObject();
                        jSONObject10.put("tid", cVar2.f10178a);
                        jSONObject10.put(NotificationCompat.CATEGORY_EVENT, cVar2.f10179b);
                        jSONObject10.put("count", cVar2.f);
                        jSONArray3.put(jSONObject10);
                    }
                }
                jSONObject9.put("events", jSONArray3);
                z6.a.f("%s:%s", i9 > 0 ? String.format(Locale.getDefault(), "--> retry [%d] times upload", Integer.valueOf(i9)) : "--> upload", jSONObject9.toString());
            } catch (Exception e14) {
                z6.a.d("exception when print upload events : ", e14.getMessage());
            }
            o oVarA = d0.a(iVar.f11099a, iVar.f11100b, iVar.f11101c, iVar.f11102d, iVar.e, iVar.f);
            if (oVarA.f4951a == 0) {
                h((b) oVarA.f4952b, list, j17, iVar.hashCode());
                if (this.f11087a.hasMessages(298)) {
                    return;
                }
                this.f11087a.sendEmptyMessageDelayed(298, 0L);
                return;
            }
            try {
                b bVar2 = (b) oVarA.f4952b;
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("requestId", iVar.hashCode());
                int i15 = bVar2.f11082a;
                if (i15 == 0) {
                    i15 = -1;
                }
                jSONObject11.put("code", i15);
                jSONObject11.put(MessageBank.KEY_MESSAGE, TextUtils.isEmpty(bVar2.f11083b) ? "" : bVar2.f11083b);
                jSONObject11.put("ex", bVar2.f11085d);
                z6.a.f("<-- upload failed:%s", jSONObject11.toString());
            } catch (Exception e15) {
                z6.a.d("exception when print upload events success: ", e15.getMessage());
            }
            i9++;
            u6.a aVarH = u6.a.h(e8.b.f4712i);
            synchronized (aVarH) {
                try {
                    try {
                        ((u6.c) aVarH.f10379c).m(u6.b.f10384d, list, i9);
                    } catch (e8.d e16) {
                        e = e16;
                        int i16 = e8.d.f4719a;
                        e8.g.f4735b.a(e);
                    }
                } catch (e8.d e17) {
                    e = e17;
                }
            }
            if (!dd.l(e8.b.f4712i)) {
                return;
            }
            try {
                Thread.sleep(j18);
                long jMin = Math.min((2 * j18) + 1000, 1800000L);
                w6.a aVarC = w6.a.c();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (aVarC.f10668c) {
                    w6.b bVar3 = aVarC.f10666a;
                    jCurrentTimeMillis = (bVar3.f10670a + jElapsedRealtime) - bVar3.f10671b;
                }
                j13 = jMin;
                j12 = jCurrentTimeMillis;
            } catch (InterruptedException e18) {
                z6.a.b("Retry upload interrupted!! : %s", e18.getMessage());
                return;
            }
        }
        z6.a.b("tryUploadEvents interrupted : %s", "network unavailable");
    }

    public final void h(b bVar, List list, long j8, int i8) {
        boolean zP;
        s6.a aVarE;
        s6.e eVar = (s6.e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(TextUtils.isEmpty(eVar.f9570n) ? "Asia/Shanghai" : eVar.f9570n));
        String str = calendar.get(1) + "-" + (calendar.get(2) + 1) + "-" + calendar.get(5);
        u6.a aVarH = u6.a.h(e8.b.f4712i);
        e0.b bVar2 = new e0.b(25);
        synchronized (aVarH) {
            try {
                ((u6.c) aVarH.f10379c).n(u6.b.f10381a, list, j8, str, bVar2);
            } catch (e8.d e) {
                int i9 = e8.d.f4719a;
                e8.g.f4735b.a(e);
            }
        }
        if (z6.b.h(e8.b.f4712i)) {
            i1.a.a(e8.b.f4712i).g("first_launch", "false");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", i8);
            jSONObject.put("code", bVar.f11082a);
            jSONObject.put(MessageBank.KEY_MESSAGE, bVar.f11083b);
            jSONObject.put("app", bVar.f11084c);
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                for (t6.c cVar : ((AppIdData) it.next()).e) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tid", cVar.f10178a);
                    jSONObject2.put(NotificationCompat.CATEGORY_EVENT, cVar.f10179b);
                    jSONObject2.put("count", cVar.f);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("events", jSONArray);
            z6.a.f("<-- upload success:%s", jSONObject.toString());
        } catch (Exception e4) {
            z6.a.d("exception when print upload events success: ", e4.getMessage());
        }
        if (this.f11106i) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int i10 = ((AppIdData) it2.next()).f2313a;
                if (this.f11105h.indexOfKey(i10) >= 0) {
                    this.f11105h.put(i10, "");
                    i1.a.a(e8.b.f4712i).g("first_page_enter_" + i10, "");
                }
            }
        }
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            for (t6.c cVar2 : ((AppIdData) it3.next()).e) {
                if (cVar2.f10183h && (aVarE = m6.a.f().e(cVar2.f10178a)) != null) {
                    s6.b bVar3 = aVarE.f9515c;
                    bVar3.f9523i = j8;
                    bVar3.f9525k = 0;
                }
            }
        }
        ArrayList<a> arrayList = bVar.f11084c;
        if (arrayList != null) {
            for (a aVar : arrayList) {
                s6.c cVarC = ((i1.b) m6.a.f().f7948a.f8123c).c(aVar.f11079a);
                if (cVarC != null && !TextUtils.equals(cVarC.f9533g, aVar.a())) {
                    int i11 = aVar.f11080b;
                    if (i11 == 1) {
                        String strA = aVar.a();
                        try {
                            u6.a aVarH2 = u6.a.h(e8.b.f4712i);
                            int i12 = cVarC.f9529a;
                            synchronized (aVarH2) {
                                try {
                                    try {
                                        zP = ((u6.c) aVarH2.f10379c).p(u6.b.f10381a, i12);
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                } catch (e8.d e10) {
                                    int i13 = e8.d.f4719a;
                                    e8.g.f4735b.a(e10);
                                    zP = false;
                                }
                            }
                            if (zP) {
                                cVarC.f9533g = strA;
                                cVarC.f9532d = 0L;
                                cVarC.c(-1L);
                                u6.a.h(e8.b.f4712i).s(cVarC, false);
                            }
                        } catch (Exception e11) {
                            z6.a.d("Handle cleanup data exception : %s", e11.getMessage());
                            e8.d.a("handleCleanupData", e11);
                        }
                    } else if (i11 == 2) {
                        g(cVarC, aVar.a(), true);
                    } else if (i11 == 3) {
                        g(cVarC, aVar.a(), false);
                    }
                }
            }
        }
    }
}
