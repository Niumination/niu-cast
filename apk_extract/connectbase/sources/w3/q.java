package w3;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.transsion.athena.data.AppIdData;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<AppIdData> f17938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<String> f17939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17940g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f17941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Integer> f17943c;

        public a(byte[] bArr, int i10, List<Integer> list, int i11) {
            this.f17941a = bArr;
            this.f17942b = i10;
            this.f17943c = list;
        }

        public static a a(byte[] bArr, int i10, List<Integer> list, int i11) {
            return new a(bArr, i10, list, i11);
        }
    }

    public q(Handler handler, String str, @NonNull List<AppIdData> list, boolean z10, @NonNull SparseArray<String> sparseArray) {
        super(handler);
        this.f17940g = false;
        this.f17937d = str;
        this.f17938e = list;
        this.f17936c = z10;
        this.f17939f = sparseArray;
    }

    public static void g(SparseArray sparseArray) {
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            t3.e eVar = (t3.e) sparseArray.valueAt(i10);
            Bundle bundle = new Bundle();
            bundle.putInt("appid", eVar.f15471a);
            bundle.putString("date", eVar.f15472b);
            bundle.putInt("count", eVar.f15473c);
            bundle.putInt("packet", eVar.f15474d);
            new a4.a("day_up_record", 9999).m(bundle, null).k();
            if (t3.d.d() > 0) {
                new a4.a("day_up_record", t3.d.f15469a).m(bundle, null).k();
            }
        }
    }

    public static /* synthetic */ void l(c cVar) {
        j.d().e(cVar);
    }

    @Override // w3.c
    public void a() throws Throwable {
        long jA = m3.a.f().a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
        int i10 = 0;
        AppIdData appIdData = null;
        for (AppIdData appIdData2 : this.f17938e) {
            if (!TextUtils.isEmpty(appIdData2.f1814c) && TextUtils.equals(appIdData2.f1817f, this.f17937d)) {
                if (appIdData != null) {
                    if (!TextUtils.equals(appIdData.f1814c, appIdData2.f1814c)) {
                        i10++;
                        break;
                    }
                } else {
                    i10++;
                    appIdData = appIdData2;
                }
            }
        }
        if (i10 != 1) {
            if (i10 > 1) {
                ArrayList arrayList = new ArrayList();
                for (AppIdData appIdData3 : this.f17938e) {
                    if (!TextUtils.isEmpty(appIdData3.f1814c) && TextUtils.equals(appIdData3.f1817f, this.f17937d)) {
                        arrayList.add(appIdData3);
                    }
                }
                u3.a.e(k6.g.h0()).j(arrayList);
            }
            appIdData = null;
        }
        long jQ = ((long) n3.b.l().q()) * 1000;
        if (appIdData != null) {
            Pair<String, List<AppIdData>> pairF = f(0L, appIdData.f1814c);
            List<AppIdData> list = (List) pairF.second;
            if (s3.e.m(list)) {
                h(list, (String) pairF.first, jA, jQ, appIdData.f1815d);
                return;
            }
            return;
        }
        Pair<String, List<AppIdData>> pairF2 = f(jA, null);
        String str = (String) pairF2.first;
        List<AppIdData> list2 = (List) pairF2.second;
        if (s3.e.m(list2)) {
            h(list2, str, jA, jQ, 0);
        }
    }

    @Override // w3.c
    public String c() {
        if (TextUtils.isEmpty(this.f17937d)) {
            return "Default";
        }
        try {
            String[] strArrSplit = this.f17937d.split("//");
            if (strArrSplit.length > 0) {
                return strArrSplit[1].split("\\.")[0];
            }
        } catch (Exception e10) {
            y3.b.e("get domain exception : %s", e10.getMessage());
        }
        return "Default";
    }

    public final Pair<String, List<AppIdData>> f(long j10, String str) {
        String string;
        LinkedList linkedList = new LinkedList();
        int i10 = 0;
        int i11 = 0;
        loop0: for (AppIdData appIdData : this.f17938e) {
            if (TextUtils.equals(appIdData.f1817f, this.f17937d)) {
                s3.f fVarN = n3.b.l().n(appIdData.f1812a);
                List<s3.a> listY = fVarN != null ? fVarN.y() : null;
                if (s3.e.m(listY)) {
                    int i12 = i11;
                    int i13 = i10;
                    for (s3.a aVar : listY) {
                        if (aVar.b(j10)) {
                            if (this.f17936c) {
                                try {
                                    u3.a.e(k6.g.h0()).g(aVar.e(), new p());
                                } catch (Exception e10) {
                                    y3.b.e("Upload 1.x events exception : %s", e10.getMessage());
                                    k6.i.a("checkUploadFile", e10);
                                }
                            }
                            t3.c cVarD = u3.a.e(k6.g.h0()).d(aVar.e(), j10, str, 921600 - i12, 2000 - i13);
                            if (cVarD != null && (linkedList.contains(appIdData) || linkedList.add(appIdData))) {
                                appIdData.f1816e.add(cVarD);
                                i13 += cVarD.f15462f;
                                i12 += cVarD.f15463g;
                                if (i13 >= 2000 || i12 >= 921600) {
                                    y3.b.g("Packet size out of limit, packetSize [%d], eventCount [%d]", Integer.valueOf(i12), Integer.valueOf(i13));
                                    break loop0;
                                }
                            }
                        }
                    }
                    i10 = i13;
                    i11 = i12;
                } else {
                    y3.b.e("Appid [%d] checkUpload tid config is null.", Integer.valueOf(appIdData.f1812a));
                }
                if (s3.e.j(appIdData.f1816e)) {
                    u3.a.e(k6.g.h0()).j(Collections.singletonList(appIdData));
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            Random random = new Random();
            StringBuilder sb2 = new StringBuilder();
            for (int i14 = 0; i14 < 8; i14++) {
                sb2.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(36)));
            }
            string = sb2.toString();
            u3.a.e(k6.g.h0()).m(linkedList, string);
        } else {
            string = str;
        }
        return new Pair<>(string, linkedList);
    }

    /* JADX WARN: Code duplicated, block: B:332:0x063e  */
    /* JADX WARN: Code duplicated, block: B:337:0x065d  */
    /* JADX WARN: Code duplicated, block: B:342:0x066c  */
    /* JADX WARN: Code duplicated, block: B:343:0x066f A[Catch: Exception -> 0x0689, TryCatch #3 {Exception -> 0x0689, blocks: (B:333:0x0647, B:335:0x0659, B:338:0x065f, B:340:0x0664, B:344:0x0671, B:346:0x0676, B:348:0x067d, B:343:0x066f), top: B:366:0x0647 }] */
    /* JADX WARN: Code duplicated, block: B:366:0x0647 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:394:0x06ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:397:0x061f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:398:0x06e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:409:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0107 A[Catch: Exception -> 0x0100, TryCatch #9 {Exception -> 0x0100, blocks: (B:32:0x00d5, B:35:0x00da, B:37:0x00e0, B:40:0x00e5, B:42:0x00eb, B:45:0x00f0, B:48:0x00f7, B:51:0x0107, B:53:0x010d, B:55:0x0119, B:58:0x011e, B:54:0x0113), top: B:378:0x00d5 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x010d A[Catch: Exception -> 0x0100, TryCatch #9 {Exception -> 0x0100, blocks: (B:32:0x00d5, B:35:0x00da, B:37:0x00e0, B:40:0x00e5, B:42:0x00eb, B:45:0x00f0, B:48:0x00f7, B:51:0x0107, B:53:0x010d, B:55:0x0119, B:58:0x011e, B:54:0x0113), top: B:378:0x00d5 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0113 A[Catch: Exception -> 0x0100, TryCatch #9 {Exception -> 0x0100, blocks: (B:32:0x00d5, B:35:0x00da, B:37:0x00e0, B:40:0x00e5, B:42:0x00eb, B:45:0x00f0, B:48:0x00f7, B:51:0x0107, B:53:0x010d, B:55:0x0119, B:58:0x011e, B:54:0x0113), top: B:378:0x00d5 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x011d  */
    /* JADX WARN: Code duplicated, block: B:61:0x012c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0131  */
    /* JADX WARN: Code duplicated, block: B:65:0x0136  */
    /* JADX WARN: Code duplicated, block: B:68:0x013c A[Catch: Exception -> 0x0144, TRY_ENTER, TryCatch #16 {Exception -> 0x0144, blocks: (B:94:0x018b, B:68:0x013c, B:90:0x016c, B:91:0x0174, B:92:0x017c, B:93:0x0184, B:73:0x0147, B:76:0x014f, B:79:0x0157), top: B:392:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0147 A[Catch: Exception -> 0x0144, TryCatch #16 {Exception -> 0x0144, blocks: (B:94:0x018b, B:68:0x013c, B:90:0x016c, B:91:0x0174, B:92:0x017c, B:93:0x0184, B:73:0x0147, B:76:0x014f, B:79:0x0157), top: B:392:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:75:0x014d  */
    /* JADX WARN: Code duplicated, block: B:76:0x014f A[Catch: Exception -> 0x0144, TryCatch #16 {Exception -> 0x0144, blocks: (B:94:0x018b, B:68:0x013c, B:90:0x016c, B:91:0x0174, B:92:0x017c, B:93:0x0184, B:73:0x0147, B:76:0x014f, B:79:0x0157), top: B:392:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0155  */
    /* JADX WARN: Code duplicated, block: B:79:0x0157 A[Catch: Exception -> 0x0144, TryCatch #16 {Exception -> 0x0144, blocks: (B:94:0x018b, B:68:0x013c, B:90:0x016c, B:91:0x0174, B:92:0x017c, B:93:0x0184, B:73:0x0147, B:76:0x014f, B:79:0x0157), top: B:392:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:81:0x015d  */
    /* JADX WARN: Code duplicated, block: B:82:0x015f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0163  */
    /* JADX WARN: Code duplicated, block: B:86:0x0166 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0168  */
    /* JADX WARN: Code duplicated, block: B:89:0x016b  */
    /* JADX WARN: Code duplicated, block: B:90:0x016c A[Catch: Exception -> 0x0144, TryCatch #16 {Exception -> 0x0144, blocks: (B:94:0x018b, B:68:0x013c, B:90:0x016c, B:91:0x0174, B:92:0x017c, B:93:0x0184, B:73:0x0147, B:76:0x014f, B:79:0x0157), top: B:392:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0174 A[Catch: Exception -> 0x0144, TryCatch #16 {Exception -> 0x0144, blocks: (B:94:0x018b, B:68:0x013c, B:90:0x016c, B:91:0x0174, B:92:0x017c, B:93:0x0184, B:73:0x0147, B:76:0x014f, B:79:0x0157), top: B:392:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:92:0x017c A[Catch: Exception -> 0x0144, TryCatch #16 {Exception -> 0x0144, blocks: (B:94:0x018b, B:68:0x013c, B:90:0x016c, B:91:0x0174, B:92:0x017c, B:93:0x0184, B:73:0x0147, B:76:0x014f, B:79:0x0157), top: B:392:0x018b }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0184 A[Catch: Exception -> 0x0144, TryCatch #16 {Exception -> 0x0144, blocks: (B:94:0x018b, B:68:0x013c, B:90:0x016c, B:91:0x0174, B:92:0x017c, B:93:0x0184, B:73:0x0147, B:76:0x014f, B:79:0x0157), top: B:392:0x018b }] */
    public final void h(List<AppIdData> list, String str, long j10, long j11, int i10) throws Throwable {
        long j12;
        long j13;
        String str2;
        String str3;
        int i11;
        String str4;
        a aVar;
        String strK;
        String str5;
        String str6;
        l<w3.a> lVarF;
        w3.a aVar2;
        int i12;
        String str7;
        String str8;
        LinkedList linkedList;
        JSONArray jSONArray;
        boolean z10;
        JSONArray jSONArray2;
        AppIdData appIdData;
        String str9;
        JSONObject jSONObject;
        String str10;
        int iHashCode;
        byte b10;
        String str11 = "requestId";
        String str12 = "opid";
        long jA = j10;
        long jMin = j11;
        int i13 = i10;
        while (y3.f.d(k6.g.h0())) {
            boolean zI = y3.d.i(k6.g.f9114q);
            LinkedList linkedList2 = new LinkedList();
            JSONArray jSONArray3 = new JSONArray();
            Iterator<AppIdData> it = list.iterator();
            int i14 = 0;
            while (true) {
                boolean zHasNext = it.hasNext();
                String str13 = "events";
                j12 = jMin;
                String str14 = "net";
                j13 = jA;
                String str15 = "tid";
                String str16 = NotificationCompat.CATEGORY_EVENT;
                str2 = str11;
                str3 = "";
                if (!zHasNext) {
                    break;
                }
                Iterator<AppIdData> it2 = it;
                AppIdData next = it.next();
                int i15 = i13;
                JSONArray jSONArray4 = new JSONArray();
                Iterator<t3.c> it3 = next.f1816e.iterator();
                int i16 = 0;
                while (true) {
                    str8 = str12;
                    linkedList = linkedList2;
                    if (!it3.hasNext()) {
                        break;
                    }
                    t3.c next2 = it3.next();
                    for (t3.c.a aVar3 : next2.f15459c) {
                        int i17 = i14;
                        try {
                            jSONArray2 = jSONArray3;
                            appIdData = next;
                            try {
                                JSONObject jSONObjectPut = new JSONObject().put(str15, next2.f15457a);
                                String str17 = aVar3.f15465a;
                                if (str17 == null) {
                                    str17 = "";
                                }
                                str9 = str13;
                                try {
                                    JSONObject jSONObjectPut2 = jSONObjectPut.put(str16, str17).put("ts", aVar3.f15466b).put(str14, aVar3.f15468d);
                                    String str18 = aVar3.f15467c;
                                    if (str18 == null) {
                                        str18 = "";
                                    }
                                    String str19 = aVar3.f15465a;
                                    if (str19 == null) {
                                        str19 = "";
                                    }
                                    str14 = str14;
                                    zI = zI;
                                    if (str19.equals("app_active")) {
                                        if (TextUtils.isEmpty(str18)) {
                                            jSONObject = new JSONObject();
                                        } else {
                                            jSONObject = new JSONObject(str18);
                                        }
                                        str10 = aVar3.f15465a;
                                        if (str10 == null) {
                                            str10 = "";
                                        }
                                        iHashCode = str10.hashCode();
                                        str16 = str16;
                                        str15 = str15;
                                        if (iHashCode != -1801031586) {
                                            if (iHashCode != 753371876) {
                                                if (iHashCode != 1066479505) {
                                                    if (iHashCode != 1616733480) {
                                                        b10 = -1;
                                                    } else {
                                                        b10 = 1;
                                                    }
                                                } else if (str10.equals("app_launch")) {
                                                    b10 = 2;
                                                } else {
                                                    b10 = -1;
                                                }
                                            } else if (str10.equals("app_active")) {
                                                b10 = 0;
                                            } else {
                                                b10 = -1;
                                            }
                                        } else if (str10.equals("app_heartbeat")) {
                                            b10 = 3;
                                        } else {
                                            b10 = -1;
                                        }
                                        if (b10 != 0) {
                                            i(jSONObjectPut2, jSONObject, s3.g.u());
                                        } else if (b10 != 1) {
                                            i(jSONObjectPut2, jSONObject, s3.g.I());
                                        } else if (b10 != 2) {
                                            i(jSONObjectPut2, jSONObject, s3.g.B());
                                        } else if (b10 != 3) {
                                            i(jSONObjectPut2, jSONObject, s3.g.y());
                                        }
                                    } else {
                                        try {
                                            String str20 = aVar3.f15465a;
                                            if (str20 == null) {
                                                str20 = "";
                                            }
                                            if (str20.equals("page_enter")) {
                                                if (TextUtils.isEmpty(str18)) {
                                                    jSONObject = new JSONObject();
                                                } else {
                                                    jSONObject = new JSONObject(str18);
                                                }
                                                str10 = aVar3.f15465a;
                                                if (str10 == null) {
                                                    str10 = "";
                                                }
                                                iHashCode = str10.hashCode();
                                                str16 = str16;
                                                str15 = str15;
                                                if (iHashCode != -1801031586) {
                                                    if (iHashCode != 753371876) {
                                                        if (iHashCode != 1066479505) {
                                                            if (iHashCode != 1616733480 && str10.equals("page_enter")) {
                                                                b10 = 1;
                                                            } else {
                                                                b10 = -1;
                                                            }
                                                        } else if (str10.equals("app_launch")) {
                                                            b10 = 2;
                                                        } else {
                                                            b10 = -1;
                                                        }
                                                    } else if (str10.equals("app_active")) {
                                                        b10 = 0;
                                                    } else {
                                                        b10 = -1;
                                                    }
                                                } else if (str10.equals("app_heartbeat")) {
                                                    b10 = 3;
                                                } else {
                                                    b10 = -1;
                                                }
                                                if (b10 != 0) {
                                                    i(jSONObjectPut2, jSONObject, s3.g.u());
                                                } else if (b10 != 1) {
                                                    i(jSONObjectPut2, jSONObject, s3.g.I());
                                                } else if (b10 != 2) {
                                                    i(jSONObjectPut2, jSONObject, s3.g.B());
                                                } else if (b10 != 3) {
                                                    i(jSONObjectPut2, jSONObject, s3.g.y());
                                                }
                                            } else {
                                                String str21 = aVar3.f15465a;
                                                if (str21 == null) {
                                                    str21 = "";
                                                }
                                                if (str21.equals("app_launch")) {
                                                    if (TextUtils.isEmpty(str18)) {
                                                        jSONObject = new JSONObject();
                                                    } else {
                                                        jSONObject = new JSONObject(str18);
                                                    }
                                                    str10 = aVar3.f15465a;
                                                    if (str10 == null) {
                                                        str10 = "";
                                                    }
                                                    iHashCode = str10.hashCode();
                                                    str16 = str16;
                                                    str15 = str15;
                                                    if (iHashCode != -1801031586) {
                                                        if (iHashCode != 753371876) {
                                                            if (iHashCode != 1066479505) {
                                                                if (iHashCode != 1616733480) {
                                                                    b10 = -1;
                                                                } else {
                                                                    b10 = 1;
                                                                }
                                                            } else if (str10.equals("app_launch")) {
                                                                b10 = 2;
                                                            } else {
                                                                b10 = -1;
                                                            }
                                                        } else if (str10.equals("app_active")) {
                                                            b10 = 0;
                                                        } else {
                                                            b10 = -1;
                                                        }
                                                    } else if (str10.equals("app_heartbeat")) {
                                                        b10 = 3;
                                                    } else {
                                                        b10 = -1;
                                                    }
                                                    if (b10 != 0) {
                                                        i(jSONObjectPut2, jSONObject, s3.g.u());
                                                    } else if (b10 != 1) {
                                                        i(jSONObjectPut2, jSONObject, s3.g.I());
                                                    } else if (b10 != 2) {
                                                        i(jSONObjectPut2, jSONObject, s3.g.B());
                                                    } else if (b10 != 3) {
                                                        i(jSONObjectPut2, jSONObject, s3.g.y());
                                                    }
                                                } else {
                                                    String str22 = aVar3.f15465a;
                                                    if (str22 == null) {
                                                        str22 = "";
                                                    }
                                                    if (str22.equals("app_heartbeat")) {
                                                        if (TextUtils.isEmpty(str18)) {
                                                            jSONObject = new JSONObject();
                                                        } else {
                                                            jSONObject = new JSONObject(str18);
                                                        }
                                                        str10 = aVar3.f15465a;
                                                        if (str10 == null) {
                                                            str10 = "";
                                                        }
                                                        iHashCode = str10.hashCode();
                                                        str16 = str16;
                                                        str15 = str15;
                                                        if (iHashCode != -1801031586) {
                                                            if (iHashCode != 753371876) {
                                                                if (iHashCode != 1066479505) {
                                                                    if (iHashCode != 1616733480) {
                                                                        b10 = -1;
                                                                    } else {
                                                                        b10 = 1;
                                                                    }
                                                                } else if (str10.equals("app_launch")) {
                                                                    b10 = 2;
                                                                } else {
                                                                    b10 = -1;
                                                                }
                                                            } else if (str10.equals("app_active")) {
                                                                b10 = 0;
                                                            } else {
                                                                b10 = -1;
                                                            }
                                                        } else if (str10.equals("app_heartbeat")) {
                                                            b10 = 3;
                                                        } else {
                                                            b10 = -1;
                                                        }
                                                        if (b10 != 0) {
                                                            i(jSONObjectPut2, jSONObject, s3.g.u());
                                                        } else if (b10 != 1) {
                                                            i(jSONObjectPut2, jSONObject, s3.g.I());
                                                        } else if (b10 != 2) {
                                                            i(jSONObjectPut2, jSONObject, s3.g.B());
                                                        } else if (b10 != 3) {
                                                            i(jSONObjectPut2, jSONObject, s3.g.y());
                                                        }
                                                    } else {
                                                        jSONObjectPut2.put("eparam", str18);
                                                        str15 = str15;
                                                        str16 = str16;
                                                    }
                                                }
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            str15 = str15;
                                            str16 = str16;
                                            y3.b.e("Assemble events packet exception : %s", e.getMessage());
                                            i14 = i17;
                                            jSONArray3 = jSONArray2;
                                            next = appIdData;
                                            str13 = str9;
                                            str14 = str14;
                                            zI = zI;
                                            str16 = str16;
                                            str15 = str15;
                                        }
                                    }
                                    try {
                                        jSONArray4.put(jSONObjectPut2);
                                    } catch (Exception e11) {
                                        e = e11;
                                        y3.b.e("Assemble events packet exception : %s", e.getMessage());
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    str15 = str15;
                                    str16 = str16;
                                    str14 = str14;
                                    zI = zI;
                                }
                            } catch (Exception e13) {
                                e = e13;
                                str9 = str13;
                                y3.b.e("Assemble events packet exception : %s", e.getMessage());
                                i14 = i17;
                                jSONArray3 = jSONArray2;
                                next = appIdData;
                                str13 = str9;
                                str14 = str14;
                                zI = zI;
                                str16 = str16;
                                str15 = str15;
                            }
                        } catch (Exception e14) {
                            e = e14;
                            jSONArray2 = jSONArray3;
                            appIdData = next;
                        }
                        i14 = i17;
                        jSONArray3 = jSONArray2;
                        next = appIdData;
                        str13 = str9;
                        str14 = str14;
                        zI = zI;
                        str16 = str16;
                        str15 = str15;
                    }
                    i16 += next2.f15462f;
                    str12 = str8;
                    linkedList2 = linkedList;
                }
                String str23 = str15;
                String str24 = str16;
                boolean z11 = zI;
                JSONArray jSONArray5 = jSONArray3;
                AppIdData appIdData2 = next;
                String str25 = str13;
                int i18 = i14;
                String str26 = this.f17939f.get(appIdData2.f1812a, "");
                if (!TextUtils.isEmpty(str26)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str26);
                        String string = jSONObject2.has("eparam") ? jSONObject2.getString("eparam") : "";
                        i(jSONObject2, TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string), s3.g.I());
                        if (jSONObject2.getLong(str23) < 9999) {
                            s3.a aVarD = n3.b.l().d(appIdData2.f1812a, jSONObject2.getString(str24));
                            if (aVarD != null) {
                                jSONObject2.put(str23, aVarD.e());
                                jSONArray4.put(jSONObject2);
                            } else {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("appid", appIdData2.f1812a);
                                jSONObject3.put(str24, jSONObject2.getString(str24));
                                y3.b.e("invalid or not registered:%s", jSONObject3.toString());
                            }
                            this.f17940g = true;
                        } else {
                            jSONArray4.put(jSONObject2);
                        }
                        i16++;
                    } catch (Exception e15) {
                        y3.b.e("Insert FPE event exception : %s", e15.getMessage());
                    }
                    this.f17940g = true;
                }
                int i19 = i16;
                try {
                    JSONObject jSONObject4 = TextUtils.isEmpty(appIdData2.f1813b) ? new JSONObject() : new JSONObject(appIdData2.f1813b);
                    JSONObject jSONObjectPut3 = new JSONObject().put("appid", appIdData2.f1812a).put("hostid", t3.d.d());
                    String strOptString = jSONObject4.optString("pkgName");
                    if (strOptString == null) {
                        strOptString = "";
                    }
                    JSONObject jSONObjectPut4 = jSONObjectPut3.put("pkg", strOptString);
                    String strOptString2 = jSONObject4.optString("versionName");
                    if (strOptString2 == null) {
                        strOptString2 = "";
                    }
                    JSONObject jSONObjectPut5 = jSONObjectPut4.put("vn", strOptString2);
                    String strOptString3 = jSONObject4.optString("versionCode");
                    if (strOptString3 == null) {
                        strOptString3 = "";
                    }
                    JSONObject jSONObjectPut6 = jSONObjectPut5.put("vc", strOptString3).put("sdkv", "3.1.1.1-sys");
                    String strOptString4 = jSONObject4.optString("installer");
                    if (strOptString4 != null) {
                        str3 = strOptString4;
                    }
                    JSONObject jSONObjectPut7 = jSONObjectPut6.put("ins", str3);
                    z10 = z11;
                    try {
                        JSONObject jSONObjectPut8 = jSONObjectPut7.put("isfl", z10).put("cnt", i19).put(str25, jSONArray4);
                        jSONArray = jSONArray5;
                        try {
                            jSONArray.put(jSONObjectPut8);
                        } catch (Exception e16) {
                            e = e16;
                            y3.b.e("Assemble events packet exception : %s", e.getMessage());
                        }
                    } catch (Exception e17) {
                        e = e17;
                        jSONArray = jSONArray5;
                    }
                } catch (Exception e18) {
                    e = e18;
                    jSONArray = jSONArray5;
                    z10 = z11;
                }
                i14 = i18 + i19;
                linkedList.add(Integer.valueOf(appIdData2.f1812a));
                jMin = j12;
                linkedList2 = linkedList;
                zI = z10;
                jSONArray3 = jSONArray;
                str11 = str2;
                it = it2;
                i13 = i15;
                str12 = str8;
                jA = j13;
            }
            String str27 = str12;
            int i20 = i13;
            LinkedList linkedList3 = linkedList2;
            JSONArray jSONArray6 = jSONArray3;
            int i21 = i14;
            Context context = k6.g.f9114q;
            try {
                JSONObject jSONObject5 = new JSONObject();
                String strD = s3.g.D();
                if (strD == null) {
                    strD = "";
                }
                JSONObject jSONObjectPut9 = jSONObject5.put("channel", strD);
                str4 = str27;
                try {
                    String strD2 = y3.d.d(k6.g.f9114q, str4);
                    if (strD2 == null) {
                        strD2 = "";
                    }
                    JSONObject jSONObjectPut10 = jSONObjectPut9.put(str4, strD2);
                    String strD3 = y3.d.d(k6.g.f9114q, "oneid");
                    if (strD3 == null) {
                        strD3 = "";
                    }
                    JSONObject jSONObjectPut11 = jSONObjectPut10.put("tsid", strD3);
                    Context context2 = k6.g.f9114q;
                    String strA = y3.a.a();
                    if (strA == null) {
                        strA = "";
                    }
                    JSONObject jSONObjectPut12 = jSONObjectPut11.put("vaid", strA);
                    JSONObject jSONObjectE = s3.g.E();
                    jSONObjectE.put("ossv", y3.g.b(k6.g.f9114q));
                    if (jSONObjectE.length() > 0) {
                        int length = jSONObjectE.toString().getBytes(StandardCharsets.UTF_8).length;
                        if (length > 2000) {
                            String str28 = String.format(Locale.getDefault(), "custom param is too long, limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length));
                            y3.b.e("%s", str28);
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("errorMsg", str28);
                            jSONObjectPut12.put("cparam", jSONObject6.toString());
                        } else {
                            jSONObjectPut12.put("cparam", jSONObjectE.toString());
                        }
                    }
                    JSONObject jSONObjectPut13 = new JSONObject().put("actype", (int) s3.g.p());
                    String str29 = Build.VERSION.RELEASE;
                    if (str29 == null) {
                        str29 = "";
                    }
                    JSONObject jSONObjectPut14 = jSONObjectPut13.put("aver", str29).put("appids", jSONArray6);
                    String str30 = Build.BRAND;
                    if (str30 == null) {
                        str30 = "";
                    }
                    JSONObject jSONObjectPut15 = jSONObjectPut14.put("brand", str30);
                    String str31 = Build.DISPLAY;
                    if (str31 == null) {
                        str31 = "";
                    }
                    JSONObject jSONObjectPut16 = jSONObjectPut15.put("build", str31).put("ekey", jSONObjectPut12.toString());
                    String strC = y3.d.c(k6.g.f9114q);
                    if (strC == null) {
                        strC = "";
                    }
                    JSONObject jSONObjectPut17 = jSONObjectPut16.put("gaid", strC);
                    String language = Locale.getDefault().getLanguage();
                    if (language == null) {
                        language = "";
                    }
                    JSONObject jSONObjectPut18 = jSONObjectPut17.put("lang", language);
                    String strR = y3.e.r(k6.g.f9114q);
                    if (strR == null) {
                        strR = "";
                    }
                    JSONObject jSONObjectPut19 = jSONObjectPut18.put("mcc", strR);
                    String strS = y3.e.s(k6.g.f9114q);
                    if (strS == null) {
                        strS = "";
                    }
                    JSONObject jSONObjectPut20 = jSONObjectPut19.put("mnc", strS);
                    String str32 = Build.MODEL;
                    if (str32 == null) {
                        str32 = "";
                    }
                    JSONObject jSONObjectPut21 = jSONObjectPut20.put("model", str32).put("net", y3.f.a(k6.g.f9114q));
                    String strA2 = y3.g.a();
                    if (strA2 == null) {
                        strA2 = "";
                    }
                    JSONObject jSONObjectPut22 = jSONObjectPut21.put("osver", strA2);
                    String strK2 = s3.g.k();
                    if (strK2 == null) {
                        strK2 = "";
                    }
                    JSONObject jSONObjectPut23 = jSONObjectPut22.put("tuid", strK2);
                    i11 = i20;
                    try {
                        JSONObject jSONObjectPut24 = jSONObjectPut23.put("try", i11);
                        String strJ = y3.e.j();
                        if (strJ == null) {
                            strJ = "";
                        }
                        JSONObject jSONObjectPut25 = jSONObjectPut24.put("tz", strJ).put("uts", System.currentTimeMillis());
                        if (k6.g.z0()) {
                            jSONObjectPut25.put("iid", "");
                        }
                        aVar = new a(jSONObjectPut25.toString().getBytes(StandardCharsets.UTF_8), i21, linkedList3, i11);
                    } catch (Exception e19) {
                        e = e19;
                        y3.b.e("Assemble events packet exception : %s", e.getMessage());
                        aVar = null;
                    }
                } catch (Exception e20) {
                    e = e20;
                    i11 = i20;
                }
            } catch (Exception e21) {
                e = e21;
                i11 = i20;
                str4 = str27;
            }
            String str33 = this.f17937d;
            byte[] bArr = aVar.f17941a;
            int i22 = aVar.f17942b;
            List<Integer> list2 = aVar.f17943c;
            Context context3 = k6.g.f9114q;
            if (TextUtils.isEmpty("")) {
                strK = y3.d.b();
            } else {
                Context context4 = k6.g.f9114q;
                strK = "";
            }
            if (TextUtils.isEmpty(strK)) {
                strK = y3.e.k(context3);
            }
            m mVar = new m(str33, bArr, i22, list2, str, String.format(Locale.getDefault(), "%s_%d", strK, Integer.valueOf(t3.d.d())));
            try {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("host", this.f17937d);
                str6 = str2;
                try {
                    jSONObject7.put(str6, mVar.hashCode());
                    try {
                        jSONObject7.put("packetId", str);
                        JSONArray jSONArray7 = new JSONArray();
                        Iterator<AppIdData> it4 = list.iterator();
                        while (it4.hasNext()) {
                            Iterator<t3.c> it5 = it4.next().f1816e.iterator();
                            while (it5.hasNext()) {
                                t3.c next3 = it5.next();
                                str5 = str3;
                                try {
                                    JSONObject jSONObject8 = new JSONObject();
                                    Iterator<AppIdData> it6 = it4;
                                    Iterator<t3.c> it7 = it5;
                                    jSONObject8.put("tid", next3.f15457a);
                                    jSONObject8.put(NotificationCompat.CATEGORY_EVENT, next3.f15458b);
                                    jSONObject8.put("count", next3.f15462f);
                                    jSONArray7.put(jSONObject8);
                                    str3 = str5;
                                    it4 = it6;
                                    it5 = it7;
                                } catch (Exception e22) {
                                    e = e22;
                                    y3.b.e("exception when print upload events : ", e.getMessage());
                                    lVarF = d.f(mVar.f17930a, mVar.f17931b, mVar.f17932c, mVar.f17933d, mVar.f17934e, mVar.f17935f);
                                    if (lVarF.f17928a == 0) {
                                        k(lVarF.f17929b, list, j13, mVar.hashCode());
                                        if (this.f17912a.hasMessages(298)) {
                                            return;
                                        }
                                        this.f17912a.sendEmptyMessageDelayed(298, 0L);
                                        return;
                                    }
                                    try {
                                        aVar2 = lVarF.f17929b;
                                        JSONObject jSONObject9 = new JSONObject();
                                        jSONObject9.put(str6, mVar.hashCode());
                                        i12 = aVar2.f17904a;
                                        if (i12 == 0) {
                                            i12 = -1;
                                        }
                                        jSONObject9.put("code", i12);
                                        if (TextUtils.isEmpty(aVar2.f17905b)) {
                                            str7 = str5;
                                        } else {
                                            str7 = aVar2.f17905b;
                                        }
                                        jSONObject9.put("message", str7);
                                        jSONObject9.put("ex", aVar2.f17907d);
                                        y3.b.g("<-- upload failed:%s", jSONObject9.toString());
                                    } catch (Exception e23) {
                                        y3.b.e("exception when print upload events success: ", e23.getMessage());
                                    }
                                    i13 = i11 + 1;
                                    u3.a.e(k6.g.f9114q).k(list, i13);
                                    if (!s3.e.p(k6.g.f9114q)) {
                                        return;
                                    }
                                    try {
                                        Thread.sleep(j12);
                                        str11 = str6;
                                        str12 = str4;
                                        jMin = Math.min((2 * j12) + 1000, 1800000L);
                                        jA = m3.a.f().a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                                    } catch (InterruptedException e24) {
                                        y3.b.c("Retry upload interrupted!! : %s", e24.getMessage());
                                        return;
                                    }
                                }
                            }
                        }
                        str5 = str3;
                        jSONObject7.put("events", jSONArray7);
                        y3.b.g("%s:%s", i11 > 0 ? String.format(Locale.getDefault(), "--> retry [%d] times upload", Integer.valueOf(i11)) : "--> upload", jSONObject7.toString());
                    } catch (Exception e25) {
                        e = e25;
                        str5 = str3;
                        y3.b.e("exception when print upload events : ", e.getMessage());
                        lVarF = d.f(mVar.f17930a, mVar.f17931b, mVar.f17932c, mVar.f17933d, mVar.f17934e, mVar.f17935f);
                        if (lVarF.f17928a == 0) {
                            k(lVarF.f17929b, list, j13, mVar.hashCode());
                            if (this.f17912a.hasMessages(298)) {
                                this.f17912a.sendEmptyMessageDelayed(298, 0L);
                                return;
                            }
                            return;
                        }
                        aVar2 = lVarF.f17929b;
                        JSONObject jSONObject10 = new JSONObject();
                        jSONObject10.put(str6, mVar.hashCode());
                        i12 = aVar2.f17904a;
                        if (i12 == 0) {
                            i12 = -1;
                        }
                        jSONObject10.put("code", i12);
                        if (TextUtils.isEmpty(aVar2.f17905b)) {
                            str7 = str5;
                        } else {
                            str7 = aVar2.f17905b;
                        }
                        jSONObject10.put("message", str7);
                        jSONObject10.put("ex", aVar2.f17907d);
                        y3.b.g("<-- upload failed:%s", jSONObject10.toString());
                        i13 = i11 + 1;
                        u3.a.e(k6.g.f9114q).k(list, i13);
                        if (!s3.e.p(k6.g.f9114q)) {
                            return;
                        }
                        Thread.sleep(j12);
                        str11 = str6;
                        str12 = str4;
                        jMin = Math.min((2 * j12) + 1000, 1800000L);
                        jA = m3.a.f().a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                    }
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (Exception e27) {
                e = e27;
                str5 = "";
                str6 = str2;
            }
            lVarF = d.f(mVar.f17930a, mVar.f17931b, mVar.f17932c, mVar.f17933d, mVar.f17934e, mVar.f17935f);
            if (lVarF.f17928a == 0) {
                k(lVarF.f17929b, list, j13, mVar.hashCode());
                if (this.f17912a.hasMessages(298)) {
                    this.f17912a.sendEmptyMessageDelayed(298, 0L);
                    return;
                }
                return;
            }
            aVar2 = lVarF.f17929b;
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put(str6, mVar.hashCode());
            i12 = aVar2.f17904a;
            if (i12 == 0) {
                i12 = -1;
            }
            jSONObject11.put("code", i12);
            if (TextUtils.isEmpty(aVar2.f17905b)) {
                str7 = str5;
            } else {
                str7 = aVar2.f17905b;
            }
            jSONObject11.put("message", str7);
            jSONObject11.put("ex", aVar2.f17907d);
            y3.b.g("<-- upload failed:%s", jSONObject11.toString());
            i13 = i11 + 1;
            u3.a.e(k6.g.f9114q).k(list, i13);
            if (!s3.e.p(k6.g.f9114q)) {
                return;
            }
            Thread.sleep(j12);
            str11 = str6;
            str12 = str4;
            jMin = Math.min((2 * j12) + 1000, 1800000L);
            jA = m3.a.f().a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
        }
        y3.b.c("tryUploadEvents interrupted : %s", "network unavailable");
    }

    public final void i(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
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
                            y3.b.d(str2);
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("errorMsg", str2);
                            jSONObject2.put("_ext", jSONObject5);
                        } else {
                            jSONObject2.put("_ext", jSONObject4);
                        }
                    }
                } catch (Exception e10) {
                    y3.b.e("Insert common params exception : %s", e10.getMessage());
                    return;
                }
            }
            jSONObject.put("eparam", jSONObject2.toString());
        }
    }

    public final void j(s3.f fVar, String str, boolean z10) {
        int iAbs;
        if (z10) {
            try {
                String strB = y3.d.b();
                if (TextUtils.isEmpty(strB)) {
                    strB = y3.e.k(k6.g.h0());
                }
                iAbs = (TextUtils.isEmpty(strB) || strB.hashCode() == 0) ? 1800000 : (Math.abs(strB.hashCode()) % 30) * 60000;
            } catch (Exception e10) {
                y3.b.e("Handle pull config exception after upload : %s", e10.getMessage());
                k6.i.a("handlePullConfig", e10);
                return;
            }
        } else {
            iAbs = 0;
        }
        fVar.q(str);
        fVar.m(0L);
        fVar.j(System.currentTimeMillis() + ((long) iAbs));
        u3.a.e(k6.g.h0()).o(fVar, false);
    }

    public final void k(w3.a aVar, List<AppIdData> list, long j10, int i10) {
        s3.a aVarM;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(n3.b.l().r()));
        u3.a.e(k6.g.h0()).l(list, j10, calendar.get(1) + "-" + (calendar.get(2) + 1) + "-" + calendar.get(5), new o());
        if (y3.d.i(k6.g.f9114q)) {
            m0.a.a(k6.g.f9114q).g("first_launch", "false");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", i10);
            jSONObject.put("code", aVar.f17904a);
            jSONObject.put("message", aVar.f17905b);
            jSONObject.put("app", aVar.f17906c);
            JSONArray jSONArray = new JSONArray();
            Iterator<AppIdData> it = list.iterator();
            while (it.hasNext()) {
                for (t3.c cVar : it.next().f1816e) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tid", cVar.f15457a);
                    jSONObject2.put(NotificationCompat.CATEGORY_EVENT, cVar.f15458b);
                    jSONObject2.put("count", cVar.f15462f);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("events", jSONArray);
            y3.b.g("<-- upload success:%s", jSONObject.toString());
        } catch (Exception e10) {
            y3.b.e("exception when print upload events success: ", e10.getMessage());
        }
        if (this.f17940g) {
            Iterator<AppIdData> it2 = list.iterator();
            while (it2.hasNext()) {
                int i11 = it2.next().f1812a;
                if (this.f17939f.indexOfKey(i11) >= 0) {
                    this.f17939f.put(i11, "");
                    m0.a.a(k6.g.f9114q).g("first_page_enter_" + i11, "");
                }
            }
        }
        Iterator<AppIdData> it3 = list.iterator();
        while (it3.hasNext()) {
            for (t3.c cVar2 : it3.next().f1816e) {
                if (cVar2.f15464h && (aVarM = n3.b.l().m(cVar2.f15457a)) != null) {
                    aVarM.f().k(j10);
                    aVarM.f().c(0);
                }
            }
        }
        List<w3.a.C0466a> list2 = aVar.f17906c;
        if (list2 != null) {
            for (w3.a.C0466a c0466a : list2) {
                s3.f fVarN = n3.b.l().n(c0466a.f17908a);
                if (fVarN != null && !TextUtils.equals(fVarN.u(), c0466a.a())) {
                    int i12 = c0466a.f17909b;
                    if (i12 == 1) {
                        String strA = c0466a.a();
                        try {
                            if (u3.a.e(k6.g.f9114q).q(fVarN.g())) {
                                fVarN.q(strA);
                                fVarN.m(0L);
                                fVarN.j(-1L);
                                u3.a.e(k6.g.f9114q).o(fVarN, false);
                            }
                        } catch (Exception e11) {
                            y3.b.e("Handle cleanup data exception : %s", e11.getMessage());
                            k6.i.a("handleCleanupData", e11);
                        }
                    } else if (i12 == 2) {
                        j(fVarN, c0466a.a(), true);
                    } else if (i12 == 3) {
                        j(fVarN, c0466a.a(), false);
                    }
                }
            }
        }
    }
}
