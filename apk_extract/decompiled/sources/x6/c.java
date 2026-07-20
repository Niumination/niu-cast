package x6;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import bb.o;
import cf.o0;
import com.tencent.mmkv.MMKV;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import com.transsion.message.bank.MessageBank;
import e8.g;
import j3.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.dd;
import m3.f0;
import m3.g0;
import mg.a0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r2.w;
import s6.d;
import s6.e;
import tj.x;
import y6.f;
import y6.h;
import y6.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends c6.a implements Handler.Callback {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile c f10871s;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10872d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseArray f10874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f10877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f10879n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a8.a f10880o;
    public long p;
    public final w q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f10881r;

    public c(Context context) {
        super(context);
        this.f10872d = false;
        this.f10874i = new SparseArray();
        this.f10879n = 0L;
        this.f10880o = new a8.a(this, 20);
        new a(this);
        this.p = 0L;
        this.q = new w(this, 4);
        this.f10881r = new b(this);
        HandlerThread handlerThread = new HandlerThread("Athena-Worker", 10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f1435c = handler;
        handler.sendEmptyMessage(303);
    }

    public static void o(String str, int i8, s6.c cVar, String str2) {
        String strA = TextUtils.isEmpty(str) ? f8.c.a(d.d(), true) : f8.c.a(d.b(str), true);
        Bundle bundle = new Bundle();
        bundle.putInt("app_id", i8);
        bundle.putString("url", strA);
        bundle.putLong("ver", cVar.f9532d);
        bundle.putString("gslb_data", str2);
        a7.a aVar = new a7.a("app_cfg_log", 9999);
        ((TrackData) aVar.f42c).d(0, "eparam", bundle);
        aVar.a();
    }

    public static void q(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.getString(str);
        } catch (JSONException unused) {
            jSONObject.put(str, obj);
        }
    }

    public static void s(c cVar, int i8, boolean z2) {
        cVar.getClass();
        s6.c cVarC = ((i1.b) m6.a.f().f7948a.f8123c).c(i8);
        Context context = (Context) cVar.f1434b;
        if (cVarC != null) {
            z6.a.b("handleTidChange appconf : %s", cVarC.d());
            u6.a.h(context).s(cVarC, z2);
            String str = cVarC.f9534h;
            if (!TextUtils.isEmpty(str)) {
                if (f8.c.d(str)) {
                    o(str, i8, cVarC, cVar.f10875j);
                } else {
                    f8.c.c(context, new String[]{str}, new o0(cVar, str, i8, cVarC));
                }
                f8.c.b(str, new a0());
            }
            String str2 = cVarC.f9537k;
            if (str2 == null) {
                str2 = "";
            }
            if (!TextUtils.isEmpty(str2)) {
                f8.c.c(context, new String[]{str2}, new z());
                f8.c.b(str2, null);
            }
        }
        if (z2) {
            CopyOnWriteArrayList<s6.a> copyOnWriteArrayList = cVarC.f;
            if (dd.g(copyOnWriteArrayList)) {
                z6.a.f("%s", "handleTidChange tid config is null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (s6.a aVar : copyOnWriteArrayList) {
                if (aVar.f9515c.b() == -1) {
                    arrayList.add(Long.valueOf(aVar.f9513a));
                }
            }
            if (!arrayList.isEmpty()) {
                try {
                    u6.a.h(context).o(arrayList, cVar.f10872d, new e0.b(23));
                } catch (Exception e) {
                    z6.a.d("Handle tid change exception : %s", e.getMessage());
                    g.f4735b.a(new e8.d("handleTidChange", e));
                }
            }
            if (t6.d.f10184a == i8) {
                d.u = m6.a.f().a(i8, "page_view", 1.0f) == 0;
            }
        }
    }

    public static boolean z() {
        CopyOnWriteArrayList<s6.c> copyOnWriteArrayList = (CopyOnWriteArrayList) ((i1.b) m6.a.f().f7948a.f8123c).f5528b;
        if (dd.g(copyOnWriteArrayList)) {
            return false;
        }
        for (s6.c cVar : copyOnWriteArrayList) {
            if (cVar != null && cVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final void A() {
        if (!f0.d((Context) this.f1434b)) {
            z6.a.f("%s", "CheckConfig cancel, network is not available");
            return;
        }
        if (!f8.c.d(d.a(false))) {
            z6.a.f("%s", "CheckConfig cancel, GslbSdk is not inited");
            return;
        }
        m6.a aVarF = m6.a.f();
        Handler handler = (Handler) this.f1435c;
        n6.a aVar = aVarF.f7948a;
        aVar.getClass();
        if (d.f9553t) {
            e eVar = (e) ((i1.b) aVar.f8123c).f5527a;
            long j8 = eVar.f9563g;
            a8.a aVar2 = this.f10880o;
            if (j8 == -1 || eVar.f9559a == -1) {
                y6.g.a().b(new y6.e(handler, eVar, aVar2));
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j10 = jCurrentTimeMillis - eVar.f9563g;
                if (Math.abs(j10) >= eVar.f9559a) {
                    eVar.f9563g = jCurrentTimeMillis;
                    eVar.f9564h = 0;
                } else if (j10 >= 0 && eVar.f9564h < 32) {
                }
                y6.g.a().b(new y6.e(handler, eVar, aVar2));
            }
            for (s6.c cVar : (CopyOnWriteArrayList) ((i1.b) aVar.f8123c).f5528b) {
                int i8 = cVar.f9535i;
                long j11 = i8 > 0 ? ((long) i8) * 3600000 : eVar.f9559a;
                if (cVar.f9530b != -1 && j11 != -1) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    long j12 = jCurrentTimeMillis2 - cVar.f9530b;
                    if (Math.abs(j12) >= j11) {
                        cVar.c(jCurrentTimeMillis2);
                    } else if (j12 < 0) {
                        long j13 = cVar.f9530b;
                        Calendar calendar = Calendar.getInstance();
                        calendar.get(1);
                        calendar.get(2);
                        calendar.get(5);
                        calendar.set(11, 0);
                        calendar.set(12, 0);
                        calendar.set(13, 0);
                        calendar.set(14, 0);
                        long timeInMillis = calendar.getTimeInMillis();
                        calendar.add(5, 1);
                        long timeInMillis2 = calendar.getTimeInMillis();
                        if (j13 < timeInMillis || j13 >= timeInMillis2) {
                        }
                    } else if (cVar.f9531c < 32) {
                    }
                }
                y6.g.a().b(new f(cVar, j11, aVar2));
            }
        }
    }

    public final void B() {
        w6.b bVar;
        ArrayList<AppIdData> arrayList;
        if (!f0.d((Context) this.f1434b)) {
            z6.a.b("%s", "checkUpload network unavailable");
            return;
        }
        w6.a aVarC = w6.a.c();
        if ((aVarC.f10669d <= 0 || SystemClock.elapsedRealtime() - aVarC.f10669d <= 60000) && ((bVar = aVarC.f10666a) == null || !TextUtils.equals(bVar.f10672c, aVarC.f10667b))) {
            if (w6.a.c().e) {
                return;
            }
            z6.a.b("%s", "checkUpload sync baseTime");
            w6.a aVarC2 = w6.a.c();
            aVarC2.e = true;
            aVarC2.f10669d = SystemClock.elapsedRealtime();
            y6.g gVarA = y6.g.a();
            h hVar = new h((Handler) this.f1435c);
            hVar.f11098c = 0;
            gVarA.b(hVar);
            return;
        }
        if (!d.f9553t) {
            z6.a.b("%s", "checkUpload sdk disable or gaid invalid");
            String strI = i1.a.a((Context) this.f1434b).i("gdpr_close");
            if (TextUtils.isEmpty(strI)) {
                return;
            }
            y6.g.a().b(new y6.c((Handler) this.f1435c, strI));
            return;
        }
        if (!f8.c.d(d.d())) {
            z6.a.b("%s", "checkUpload GSLB is not ready");
            return;
        }
        if (dd.g(((e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a).f9568l)) {
            z6.a.b("%s", "checkUpload global config is not ready");
            return;
        }
        u6.a aVarH = u6.a.h((Context) this.f1434b);
        aVarH.getClass();
        try {
            arrayList = ((u6.c) aVarH.f10379c).c(u6.b.f10384d);
        } catch (e8.d e) {
            int i8 = e8.d.f4719a;
            g.f4735b.a(e);
            arrayList = null;
        }
        if (dd.g(arrayList)) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) ((i1.b) m6.a.f().f7948a.f8123c).f5528b;
            if (dd.g(copyOnWriteArrayList)) {
                z6.a.b("%s", "checkUpload appid config list is null");
                return;
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                AppIdData appIdDataB = AppIdData.b((Context) this.f1434b, ((s6.c) it.next()).f9529a);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(appIdDataB);
                u6.a.h((Context) this.f1434b).m(appIdDataB);
            }
        }
        HashSet hashSet = new HashSet();
        for (AppIdData appIdData : arrayList) {
            s6.c cVarC = ((i1.b) m6.a.f().f7948a.f8123c).c(appIdData.f2313a);
            if (cVarC != null) {
                String strA = TextUtils.isEmpty(cVarC.f9534h) ? f8.c.a(d.d(), true) : f8.c.a(d.b(cVarC.f9534h), true);
                appIdData.f2317h = strA;
                hashSet.add(strA);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            y6.g.a().b(new j((Handler) this.f1435c, (String) it2.next(), arrayList, this.f10872d, this.f10874i));
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0266 A[Catch: Exception -> 0x0222, TryCatch #8 {Exception -> 0x0222, blocks: (B:86:0x01cd, B:87:0x01db, B:89:0x01e1, B:91:0x01fe, B:92:0x0208, B:94:0x020e, B:96:0x0214, B:99:0x0224, B:101:0x0266, B:103:0x026c, B:106:0x0270, B:107:0x0273, B:109:0x0279, B:110:0x0282, B:112:0x0288), top: B:129:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0273 A[Catch: Exception -> 0x0222, TryCatch #8 {Exception -> 0x0222, blocks: (B:86:0x01cd, B:87:0x01db, B:89:0x01e1, B:91:0x01fe, B:92:0x0208, B:94:0x020e, B:96:0x0214, B:99:0x0224, B:101:0x0266, B:103:0x026c, B:106:0x0270, B:107:0x0273, B:109:0x0279, B:110:0x0282, B:112:0x0288), top: B:129:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0279 A[Catch: Exception -> 0x0222, TryCatch #8 {Exception -> 0x0222, blocks: (B:86:0x01cd, B:87:0x01db, B:89:0x01e1, B:91:0x01fe, B:92:0x0208, B:94:0x020e, B:96:0x0214, B:99:0x0224, B:101:0x0266, B:103:0x026c, B:106:0x0270, B:107:0x0273, B:109:0x0279, B:110:0x0282, B:112:0x0288), top: B:129:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0288 A[Catch: Exception -> 0x0222, TRY_LEAVE, TryCatch #8 {Exception -> 0x0222, blocks: (B:86:0x01cd, B:87:0x01db, B:89:0x01e1, B:91:0x01fe, B:92:0x0208, B:94:0x020e, B:96:0x0214, B:99:0x0224, B:101:0x0266, B:103:0x026c, B:106:0x0270, B:107:0x0273, B:109:0x0279, B:110:0x0282, B:112:0x0288), top: B:129:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:127:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0094  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f0 A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #6 {Exception -> 0x00f3, blocks: (B:40:0x00d9, B:42:0x00f0), top: B:127:0x00d9, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0103 A[DONT_INVERT, PHI: r3
      0x0103: PHI (r3v15 i1.b) = (r3v30 i1.b), (r3v31 i1.b), (r3v14 i1.b) binds: [B:39:0x00d7, B:47:0x00f7, B:46:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x0105 A[Catch: Exception -> 0x0111, TryCatch #11 {Exception -> 0x0111, blocks: (B:38:0x00cc, B:49:0x0105, B:53:0x0115, B:56:0x0122, B:60:0x0137, B:63:0x0140, B:59:0x012d, B:52:0x0113, B:47:0x00f7, B:40:0x00d9, B:42:0x00f0), top: B:135:0x00cc, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0113 A[Catch: Exception -> 0x0111, TryCatch #11 {Exception -> 0x0111, blocks: (B:38:0x00cc, B:49:0x0105, B:53:0x0115, B:56:0x0122, B:60:0x0137, B:63:0x0140, B:59:0x012d, B:52:0x0113, B:47:0x00f7, B:40:0x00d9, B:42:0x00f0), top: B:135:0x00cc, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0121  */
    /* JADX WARN: Code duplicated, block: B:56:0x0122 A[Catch: Exception -> 0x0111, TryCatch #11 {Exception -> 0x0111, blocks: (B:38:0x00cc, B:49:0x0105, B:53:0x0115, B:56:0x0122, B:60:0x0137, B:63:0x0140, B:59:0x012d, B:52:0x0113, B:47:0x00f7, B:40:0x00d9, B:42:0x00f0), top: B:135:0x00cc, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x012a  */
    /* JADX WARN: Code duplicated, block: B:59:0x012d A[Catch: Exception -> 0x0111, TryCatch #11 {Exception -> 0x0111, blocks: (B:38:0x00cc, B:49:0x0105, B:53:0x0115, B:56:0x0122, B:60:0x0137, B:63:0x0140, B:59:0x012d, B:52:0x0113, B:47:0x00f7, B:40:0x00d9, B:42:0x00f0), top: B:135:0x00cc, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x013f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0172  */
    /* JADX WARN: Code duplicated, block: B:75:0x0180  */
    /* JADX WARN: Code duplicated, block: B:84:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e1 A[Catch: Exception -> 0x0222, TryCatch #8 {Exception -> 0x0222, blocks: (B:86:0x01cd, B:87:0x01db, B:89:0x01e1, B:91:0x01fe, B:92:0x0208, B:94:0x020e, B:96:0x0214, B:99:0x0224, B:101:0x0266, B:103:0x026c, B:106:0x0270, B:107:0x0273, B:109:0x0279, B:110:0x0282, B:112:0x0288), top: B:129:0x01cd }] */
    /* JADX WARN: Code duplicated, block: B:91:0x01fe A[Catch: Exception -> 0x0222, TryCatch #8 {Exception -> 0x0222, blocks: (B:86:0x01cd, B:87:0x01db, B:89:0x01e1, B:91:0x01fe, B:92:0x0208, B:94:0x020e, B:96:0x0214, B:99:0x0224, B:101:0x0266, B:103:0x026c, B:106:0x0270, B:107:0x0273, B:109:0x0279, B:110:0x0282, B:112:0x0288), top: B:129:0x01cd }] */
    /* JADX WARN: Instruction removed from duplicated block: B:89:0x01e1, please report this as an issue */
    public final void C() throws Throwable {
        FileInputStream fileInputStream;
        String strTrim;
        n6.a aVar;
        o6.a aVar2;
        int i8;
        i1.a aVarA;
        File file;
        File file2;
        String[] list;
        SharedPreferences sharedPreferences;
        String strI;
        i1.b bVar;
        e eVarA;
        s6.c cVarC;
        CopyOnWriteArrayList copyOnWriteArrayList;
        long j8;
        this.f10877l = System.currentTimeMillis();
        this.f10876k = f0.d((Context) this.f1434b);
        w6.a aVarC = w6.a.c();
        aVarC.getClass();
        try {
            String strI2 = i1.a.a(e8.b.f4712i).i("base_time");
            z6.a.a("baseTimeJs = " + strI2);
            if (!TextUtils.isEmpty(strI2)) {
                aVarC.f10666a = new w6.b(strI2);
            }
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
        FileInputStream fileInputStream2 = null;
        bVar = null;
        i1.b bVar2 = null;
        try {
            fileInputStream = new FileInputStream("/proc/sys/kernel/random/boot_id");
            try {
                byte[] bArr = new byte[1024];
                int i9 = fileInputStream.read(bArr);
                if (i9 > 0) {
                    strTrim = new String(bArr, 0, i9).trim();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                } else {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    strTrim = null;
                }
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                }
                strTrim = null;
                aVarC.f10667b = strTrim;
                if (aVarC.f10666a != null) {
                    if (aVarC.f10667b.equals(aVarC.f10666a.f10672c)) {
                        aVarC.f10666a = null;
                        i1.a.a(e8.b.f4712i).g("base_time", "");
                    } else if (Math.abs(((SystemClock.elapsedRealtime() - aVarC.f10666a.f10671b) + aVarC.f10666a.f10670a) - System.currentTimeMillis()) > 600000) {
                        aVarC.f10668c = true;
                    }
                }
                m6.a aVarF = m6.a.f();
                aVar = aVarF.f7948a;
                aVar2 = (o6.a) aVar.f8122b;
                aVar.h();
                strI = aVar2.i();
                if (TextUtils.isEmpty(strI)) {
                    if (bVar2 == null) {
                        aVar2.h(((i1.b) aVar.f8123c).d());
                    } else {
                        aVar.f8123c = bVar2;
                    }
                    cVarC = ((i1.b) aVar.f8123c).c(t6.d.f10184a);
                    if (cVarC == null) {
                        copyOnWriteArrayList = cVarC.f;
                        if (dd.g(copyOnWriteArrayList)) {
                            j8 = 0;
                        } else {
                            j8 = ((s6.a) copyOnWriteArrayList.get(0)).f9515c.f9526l;
                        }
                        String str = d.f9538a;
                        if (j8 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                            j8 = 30000;
                        }
                        d.f9551r = j8;
                    }
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(strI);
                        bVar = new i1.b(5);
                        eVarA = e.a(jSONObject.getJSONObject("global_config"));
                        if (eVarA != null) {
                            bVar.f5527a = eVarA;
                        }
                        bVar2 = bVar;
                    } catch (Exception e4) {
                        z6.a.c(Log.getStackTraceString(e4));
                        e8.d.a("fromJSON", e4);
                    }
                    if (bVar2 == null) {
                        aVar2.h(((i1.b) aVar.f8123c).d());
                    } else {
                        aVar.f8123c = bVar2;
                    }
                    cVarC = ((i1.b) aVar.f8123c).c(t6.d.f10184a);
                    if (cVarC == null) {
                        copyOnWriteArrayList = cVarC.f;
                        if (dd.g(copyOnWriteArrayList)) {
                            j8 = 0;
                        } else {
                            j8 = ((s6.a) copyOnWriteArrayList.get(0)).f9515c.f9526l;
                        }
                        String str2 = d.f9538a;
                        if (j8 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                            j8 = 30000;
                        }
                        d.f9551r = j8;
                    }
                }
                aVarF.f7949b = true;
                u6.a aVarH = u6.a.h((Context) this.f1434b);
                e0.b bVar3 = new e0.b(21);
                aVarH.getClass();
                ((u6.c) aVarH.f10379c).g(bVar3);
                i8 = t6.d.f10184a;
                if (i8 != 0) {
                    d.u = m6.a.f().a(i8, "page_view", 1.0f) == 0;
                }
                if (!z6.b.i((Context) this.f1434b)) {
                    z6.a.f("%s", "Dcs unavailable because of not support or conf disable");
                } else {
                    z6.a.f("%s", "Dcs unavailable because of not support or conf disable");
                }
                f8.c.c((Context) this.f1434b, r6.a.f9382a, new x(this));
                Handler handler = (Handler) this.f1435c;
                handler.postDelayed(new w(handler, 3), 7200000L);
                aVarA = i1.a.a((Context) this.f1434b);
                for (Integer num : t6.d.f10185b) {
                    String str3 = "first_page_enter_" + num;
                    if (((SharedPreferences) aVarA.f5524b) == null) {
                        aVarA.f5524b = aVarA.f((Context) aVarA.f5525c);
                    }
                    sharedPreferences = (SharedPreferences) aVarA.f5524b;
                    if (sharedPreferences == null) {
                    }
                }
                File filesDir = ((Context) this.f1434b).getFilesDir();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(filesDir);
                String str4 = File.separator;
                sb2.append(str4);
                sb2.append(d.f9546k);
                file = new File(sb2.toString());
                file2 = new File(filesDir + str4 + d.f9547l);
                if (file.exists()) {
                    list = file.list();
                    if (list == null) {
                        if (file.delete()) {
                            z6.a.b("%s", "dataFile deleted");
                        }
                    } else if (file.delete()) {
                        z6.a.b("%s", "dataFile deleted");
                    }
                }
                if (file2.exists()) {
                    g0.e((Context) this.f1434b, file2.getPath());
                }
                Message messageObtainMessage = ((Handler) this.f1435c).obtainMessage(TypedValues.PositionType.TYPE_DRAWPATH);
                messageObtainMessage.arg1 = 1;
                ((Handler) this.f1435c).sendMessageDelayed(messageObtainMessage, 3000L);
                this.e = ((e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a).p * 1000;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
        aVarC.f10667b = strTrim;
        if (aVarC.f10666a != null && !TextUtils.isEmpty(strTrim)) {
            if (aVarC.f10667b.equals(aVarC.f10666a.f10672c)) {
                aVarC.f10666a = null;
                i1.a.a(e8.b.f4712i).g("base_time", "");
            } else if (Math.abs(((SystemClock.elapsedRealtime() - aVarC.f10666a.f10671b) + aVarC.f10666a.f10670a) - System.currentTimeMillis()) > 600000) {
                aVarC.f10668c = true;
            }
        }
        m6.a aVarF2 = m6.a.f();
        aVar = aVarF2.f7948a;
        aVar2 = (o6.a) aVar.f8122b;
        try {
            aVar.h();
            strI = aVar2.i();
            if (TextUtils.isEmpty(strI)) {
                JSONObject jSONObject2 = new JSONObject(strI);
                bVar = new i1.b(5);
                eVarA = e.a(jSONObject2.getJSONObject("global_config"));
                if (eVarA != null) {
                    bVar.f5527a = eVarA;
                }
                bVar2 = bVar;
                if (bVar2 == null) {
                    aVar2.h(((i1.b) aVar.f8123c).d());
                } else {
                    aVar.f8123c = bVar2;
                }
                cVarC = ((i1.b) aVar.f8123c).c(t6.d.f10184a);
                if (cVarC == null) {
                    copyOnWriteArrayList = cVarC.f;
                    if (dd.g(copyOnWriteArrayList)) {
                        j8 = 0;
                    } else {
                        j8 = ((s6.a) copyOnWriteArrayList.get(0)).f9515c.f9526l;
                    }
                    String str5 = d.f9538a;
                    if (j8 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                        j8 = 30000;
                    }
                    d.f9551r = j8;
                }
            } else {
                if (bVar2 == null) {
                    aVar2.h(((i1.b) aVar.f8123c).d());
                } else {
                    aVar.f8123c = bVar2;
                }
                cVarC = ((i1.b) aVar.f8123c).c(t6.d.f10184a);
                if (cVarC == null) {
                    copyOnWriteArrayList = cVarC.f;
                    if (dd.g(copyOnWriteArrayList)) {
                        j8 = 0;
                    } else {
                        j8 = ((s6.a) copyOnWriteArrayList.get(0)).f9515c.f9526l;
                    }
                    String str6 = d.f9538a;
                    if (j8 < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                        j8 = 30000;
                    }
                    d.f9551r = j8;
                }
            }
        } catch (Exception e10) {
            z6.a.c(Log.getStackTraceString(e10));
        }
        aVarF2.f7949b = true;
        u6.a aVarH2 = u6.a.h((Context) this.f1434b);
        e0.b bVar4 = new e0.b(21);
        aVarH2.getClass();
        try {
            ((u6.c) aVarH2.f10379c).g(bVar4);
        } catch (e8.d e11) {
            int i10 = e8.d.f4719a;
            g.f4735b.a(e11);
        }
        i8 = t6.d.f10184a;
        if (i8 != 0) {
            d.u = m6.a.f().a(i8, "page_view", 1.0f) == 0;
        }
        if (!z6.b.i((Context) this.f1434b) && z() && d.f9553t) {
            z6.a.f("%s", "Dcs available");
            y();
        } else {
            z6.a.f("%s", "Dcs unavailable because of not support or conf disable");
        }
        f8.c.c((Context) this.f1434b, r6.a.f9382a, new x(this));
        Handler handler2 = (Handler) this.f1435c;
        handler2.postDelayed(new w(handler2, 3), 7200000L);
        try {
            aVarA = i1.a.a((Context) this.f1434b);
            while (r2.hasNext()) {
                String str7 = "first_page_enter_" + num;
                if (((SharedPreferences) aVarA.f5524b) == null) {
                    aVarA.f5524b = aVarA.f((Context) aVarA.f5525c);
                }
                sharedPreferences = (SharedPreferences) aVarA.f5524b;
                if (sharedPreferences == null && sharedPreferences.contains(str7)) {
                    this.f10874i.put(num.intValue(), aVarA.i(str7));
                }
            }
            File filesDir2 = ((Context) this.f1434b).getFilesDir();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(filesDir2);
            String str8 = File.separator;
            sb3.append(str8);
            sb3.append(d.f9546k);
            file = new File(sb3.toString());
            file2 = new File(filesDir2 + str8 + d.f9547l);
            if (file.exists()) {
                list = file.list();
                if (list == null && list.length != 0) {
                    this.f10872d = true;
                } else if (file.delete()) {
                    z6.a.b("%s", "dataFile deleted");
                }
            }
            if (file2.exists()) {
                g0.e((Context) this.f1434b, file2.getPath());
            }
        } catch (Exception e12) {
            z6.a.b("%s", e12.getMessage());
            g.f4735b.a(new e8.d("handleInit", e12));
        }
        Message messageObtainMessage2 = ((Handler) this.f1435c).obtainMessage(TypedValues.PositionType.TYPE_DRAWPATH);
        messageObtainMessage2.arg1 = 1;
        ((Handler) this.f1435c).sendMessageDelayed(messageObtainMessage2, 3000L);
        this.e = ((e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a).p * 1000;
    }

    @Override // c6.a
    public final void a(long j8, Runnable runnable) {
        Handler handler = (Handler) this.f1435c;
        if (handler != null) {
            handler.postDelayed(runnable, j8);
        }
    }

    @Override // c6.a
    public final void b(Message message, long j8) {
        Handler handler = (Handler) this.f1435c;
        if (handler != null) {
            if (j8 > 0) {
                handler.removeMessages(message.what);
            }
            ((Handler) this.f1435c).sendMessageDelayed(message, j8);
        }
    }

    @Override // c6.a
    public final void c(Runnable runnable) {
        Handler handler = (Handler) this.f1435c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // c6.a
    public final void d(String str, TrackData trackData, long j8) {
        t6.a aVar = new t6.a();
        aVar.f10167a = str;
        aVar.f10170d = j8;
        aVar.f = System.currentTimeMillis();
        aVar.f10171g = SystemClock.elapsedRealtime();
        aVar.f10173i = trackData;
        int i8 = this.f10873h;
        if (i8 < 5000) {
            this.f10873h = i8 + 1;
            Message messageObtainMessage = ((Handler) this.f1435c).obtainMessage(302);
            messageObtainMessage.obj = aVar;
            ((Handler) this.f1435c).sendMessage(messageObtainMessage);
        }
    }

    @Override // c6.a
    public final void e() {
        Handler handler = (Handler) this.f1435c;
        if (handler != null) {
            ((Handler) this.f1435c).sendMessageAtFrontOfQueue(handler.obtainMessage(308));
        }
    }

    @Override // c6.a
    public final void f() {
        l(this.e, true);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x01d8 A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01ed A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0215  */
    /* JADX WARN: Code duplicated, block: B:126:0x021f A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x0229 A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0242 A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x024d A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0266 A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x026a A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0277 A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x028d A[Catch: Exception -> 0x007e, TryCatch #3 {Exception -> 0x007e, blocks: (B:3:0x0002, B:21:0x002c, B:23:0x003e, B:25:0x004c, B:29:0x0057, B:31:0x005d, B:32:0x0065, B:39:0x007a, B:42:0x007d, B:45:0x0081, B:46:0x0089, B:50:0x008f, B:51:0x0094, B:58:0x00be, B:59:0x00cc, B:61:0x00d9, B:62:0x00ea, B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:108:0x01c5, B:110:0x01d8, B:111:0x01e4, B:113:0x01ed, B:115:0x01f1, B:117:0x01f5, B:119:0x020b, B:121:0x0211, B:128:0x0225, B:130:0x0229, B:132:0x022d, B:134:0x0231, B:136:0x0235, B:138:0x0242, B:140:0x024d, B:142:0x0254, B:144:0x025e, B:124:0x0217, B:126:0x021f, B:127:0x0222, B:90:0x015a, B:91:0x0160, B:107:0x01ba, B:80:0x012f, B:145:0x0262, B:146:0x0266, B:148:0x026a, B:149:0x026d, B:151:0x0277, B:153:0x028d, B:154:0x028f, B:33:0x0066, B:38:0x0073, B:63:0x00f0, B:65:0x00fa, B:67:0x00ff, B:69:0x0105, B:72:0x0111, B:74:0x0115, B:76:0x011b, B:77:0x0124, B:53:0x009f, B:55:0x00b0), top: B:168:0x0002, inners: #0, #1, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0142 A[Catch: Exception -> 0x007e, JSONException -> 0x0158, TryCatch #5 {JSONException -> 0x0158, blocks: (B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:90:0x015a, B:91:0x0160), top: B:171:0x0136, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x014c A[Catch: Exception -> 0x007e, JSONException -> 0x0158, TryCatch #5 {JSONException -> 0x0158, blocks: (B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:90:0x015a, B:91:0x0160), top: B:171:0x0136, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x015a A[Catch: Exception -> 0x007e, JSONException -> 0x0158, TryCatch #5 {JSONException -> 0x0158, blocks: (B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:90:0x015a, B:91:0x0160), top: B:171:0x0136, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0160 A[Catch: Exception -> 0x007e, JSONException -> 0x0158, TryCatch #5 {JSONException -> 0x0158, blocks: (B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:90:0x015a, B:91:0x0160), top: B:171:0x0136, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0169 A[Catch: Exception -> 0x007e, JSONException -> 0x0158, TryCatch #5 {JSONException -> 0x0158, blocks: (B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:90:0x015a, B:91:0x0160), top: B:171:0x0136, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x017a A[Catch: Exception -> 0x007e, JSONException -> 0x0158, LOOP:0: B:97:0x0174->B:99:0x017a, LOOP_END, TryCatch #5 {JSONException -> 0x0158, blocks: (B:81:0x0136, B:83:0x0142, B:85:0x014c, B:87:0x0152, B:92:0x0165, B:94:0x0169, B:96:0x016f, B:97:0x0174, B:99:0x017a, B:100:0x018d, B:102:0x019d, B:104:0x01aa, B:90:0x015a, B:91:0x0160), top: B:171:0x0136, outer: #3 }] */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        Context context;
        long jCurrentTimeMillis;
        long j8;
        long j10;
        JSONObject jSONObject;
        Object jSONObject2;
        JSONArray jSONArrayNames;
        int i8;
        boolean z2 = true;
        try {
            int i9 = message.what;
            if (i9 == 298) {
                if (message.arg1 == 1) {
                    A();
                }
                if (!((Handler) this.f1435c).hasMessages(299)) {
                    context = (Context) this.f1434b;
                    String str = z6.b.f11259a;
                    if (TextUtils.isEmpty(i1.a.a(context).i("first_init"))) {
                        String str2 = d.f9538a;
                    }
                    Handler handler = (Handler) this.f1435c;
                    handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 299));
                }
            } else if (i9 == 299) {
                B();
            } else if (i9 == 302) {
                t6.a aVar = (t6.a) message.obj;
                TrackData trackData = aVar.f10173i;
                try {
                    if (aVar.f10167a.equals("page_enter")) {
                        WeakReference weakReference = g0.f7680b;
                        Activity activity = null;
                        if (((weakReference == null || weakReference.get() == null) ? null : (Activity) g0.f7680b.get()) == null) {
                            try {
                                jSONObject = trackData.f2318a;
                                String str3 = d.f9538a;
                                if (jSONObject.has("_eparam")) {
                                    jSONObject2 = jSONObject.get("_eparam");
                                    if ((jSONObject2 instanceof JSONArray) || jSONObject.length() <= 1) {
                                        jSONObject.remove("_eparam");
                                    } else {
                                        jSONObject2 = new JSONObject();
                                    }
                                } else {
                                    jSONObject2 = new JSONObject();
                                }
                                if ((jSONObject2 instanceof JSONObject) && jSONObject.length() > 0) {
                                    jSONArrayNames = jSONObject.names();
                                    for (i8 = 0; i8 < jSONArrayNames.length(); i8++) {
                                        String string = jSONArrayNames.getString(i8);
                                        ((JSONObject) jSONObject2).put(string, jSONObject.get(string));
                                        jSONObject.remove(string);
                                    }
                                }
                                JSONObject jSONObject3 = new JSONObject(jSONObject2.toString());
                                jSONObject.put("_eparam", jSONObject2);
                                jSONObject.put("net", f0.b((Context) this.f1434b));
                                jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a);
                                aVar.f10168b = jSONObject;
                                aVar.f10169c = jSONObject3;
                                aVar.e = trackData.f2319b;
                            } catch (JSONException e) {
                                z6.a.d("Record track exception : %s", e.getMessage());
                            }
                            jCurrentTimeMillis = System.currentTimeMillis();
                            if (Math.abs(jCurrentTimeMillis - this.f10877l) > 3600000) {
                                this.f10877l = jCurrentTimeMillis;
                                this.f10876k = f0.d((Context) this.f1434b);
                            }
                            this.f10873h--;
                            if (this.f10876k && this.f10878m && d.B) {
                                s6.c cVarC = ((i1.b) m6.a.f().f7948a.f8123c).c(z6.b.a(aVar.f10170d));
                                if (cVarC == null || !cVarC.b()) {
                                    if (!"ev_athena".equals(aVar.f10167a)) {
                                        A();
                                    }
                                    r(aVar);
                                } else {
                                    w(aVar);
                                }
                            } else {
                                if (!"ev_athena".equals(aVar.f10167a)) {
                                    A();
                                }
                                r(aVar);
                            }
                            if (!this.f10876k && !this.f10878m && d.B && d.f9553t) {
                                this.f10879n++;
                                if (z()) {
                                    j8 = this.f10879n;
                                    j10 = 20;
                                    if (j8 % j10 == 0 && j8 / j10 <= 3 && z6.b.i((Context) this.f1434b)) {
                                        y();
                                    }
                                }
                            }
                        } else {
                            WeakReference weakReference2 = g0.f7680b;
                            if (weakReference2 != null && weakReference2.get() != null) {
                                activity = (Activity) g0.f7680b.get();
                            }
                            trackData.b(g0.a(activity), 0, "fromsite");
                            jSONObject = trackData.f2318a;
                            String str4 = d.f9538a;
                            if (jSONObject.has("_eparam")) {
                                jSONObject2 = jSONObject.get("_eparam");
                                if (jSONObject2 instanceof JSONArray) {
                                    jSONObject.remove("_eparam");
                                } else {
                                    jSONObject.remove("_eparam");
                                }
                            } else {
                                jSONObject2 = new JSONObject();
                            }
                            if (jSONObject2 instanceof JSONObject) {
                                jSONArrayNames = jSONObject.names();
                                while (i8 < jSONArrayNames.length()) {
                                    String string2 = jSONArrayNames.getString(i8);
                                    ((JSONObject) jSONObject2).put(string2, jSONObject.get(string2));
                                    jSONObject.remove(string2);
                                }
                            }
                            JSONObject jSONObject4 = new JSONObject(jSONObject2.toString());
                            jSONObject.put("_eparam", jSONObject2);
                            jSONObject.put("net", f0.b((Context) this.f1434b));
                            jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a);
                            aVar.f10168b = jSONObject;
                            aVar.f10169c = jSONObject4;
                            aVar.e = trackData.f2319b;
                            jCurrentTimeMillis = System.currentTimeMillis();
                            if (Math.abs(jCurrentTimeMillis - this.f10877l) > 3600000) {
                                this.f10877l = jCurrentTimeMillis;
                                this.f10876k = f0.d((Context) this.f1434b);
                            }
                            this.f10873h--;
                            if (this.f10876k) {
                                if (!"ev_athena".equals(aVar.f10167a)) {
                                    A();
                                }
                                r(aVar);
                            } else {
                                if (!"ev_athena".equals(aVar.f10167a)) {
                                    A();
                                }
                                r(aVar);
                            }
                            if (!this.f10876k) {
                                this.f10879n++;
                                if (z()) {
                                    j8 = this.f10879n;
                                    j10 = 20;
                                    if (j8 % j10 == 0) {
                                        y();
                                    }
                                }
                            }
                        }
                    } else {
                        jSONObject = trackData.f2318a;
                        String str5 = d.f9538a;
                        if (jSONObject.has("_eparam")) {
                            jSONObject2 = jSONObject.get("_eparam");
                            if (jSONObject2 instanceof JSONArray) {
                                jSONObject.remove("_eparam");
                            } else {
                                jSONObject.remove("_eparam");
                            }
                        } else {
                            jSONObject2 = new JSONObject();
                        }
                        if (jSONObject2 instanceof JSONObject) {
                            jSONArrayNames = jSONObject.names();
                            while (i8 < jSONArrayNames.length()) {
                                String string3 = jSONArrayNames.getString(i8);
                                ((JSONObject) jSONObject2).put(string3, jSONObject.get(string3));
                                jSONObject.remove(string3);
                            }
                        }
                        JSONObject jSONObject5 = new JSONObject(jSONObject2.toString());
                        jSONObject.put("_eparam", jSONObject2);
                        jSONObject.put("net", f0.b((Context) this.f1434b));
                        jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a);
                        aVar.f10168b = jSONObject;
                        aVar.f10169c = jSONObject5;
                        aVar.e = trackData.f2319b;
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (Math.abs(jCurrentTimeMillis - this.f10877l) > 3600000) {
                            this.f10877l = jCurrentTimeMillis;
                            this.f10876k = f0.d((Context) this.f1434b);
                        }
                        this.f10873h--;
                        if (this.f10876k) {
                            if (!"ev_athena".equals(aVar.f10167a)) {
                                A();
                            }
                            r(aVar);
                        } else {
                            if (!"ev_athena".equals(aVar.f10167a)) {
                                A();
                            }
                            r(aVar);
                        }
                        if (!this.f10876k) {
                            this.f10879n++;
                            if (z()) {
                                j8 = this.f10879n;
                                j10 = 20;
                                if (j8 % j10 == 0) {
                                    y();
                                }
                            }
                        }
                    }
                } catch (Exception e4) {
                    z6.a.c(Log.getStackTraceString(e4));
                }
            } else if (i9 == 303) {
                z6.a.f11258a.getBuilder().setLogSwitch(d.p);
                z6.a.f("Athena init, SDK Version is [%s]", "3.1.1.0");
                C();
                A();
            } else if (i9 == 308) {
                try {
                    m6.a.f().g();
                    if (u6.a.h((Context) this.f1434b) != null) {
                        u6.a.h((Context) this.f1434b).t();
                    }
                } catch (Exception e10) {
                    g.f4735b.a(new e8.d("handleCleanupData", e10));
                }
            } else if (i9 == 400) {
                v(message.arg1, (String) message.obj);
            } else if (i9 == 600) {
                if (message.arg1 == 1) {
                    A();
                }
                if (!((Handler) this.f1435c).hasMessages(299)) {
                    context = (Context) this.f1434b;
                    String str6 = z6.b.f11259a;
                    if (TextUtils.isEmpty(i1.a.a(context).i("first_init"))) {
                        String str7 = d.f9538a;
                    }
                    Handler handler2 = (Handler) this.f1435c;
                    handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, 299));
                }
            } else if (i9 == 502) {
                if (message.arg1 != 1) {
                    z2 = false;
                }
                u(z2);
            } else if (i9 == 503) {
                if (w6.a.c().b(((Long) message.obj).longValue())) {
                    String str8 = w6.a.c().f10667b;
                    w6.b bVar = w6.a.c().f10666a;
                    long j11 = bVar != null ? bVar.f10670a - bVar.f10671b : 0L;
                    if (j11 > 0 && !TextUtils.isEmpty(str8)) {
                        u6.a aVarH = u6.a.h((Context) this.f1434b);
                        synchronized (aVarH) {
                            try {
                                ((u6.c) aVarH.f10379c).i(u6.b.f10381a, str8, j11);
                            } catch (e8.d e11) {
                                int i10 = e8.d.f4719a;
                                g.f4735b.a(e11);
                            }
                        }
                    }
                }
                l(this.e, false);
            }
        } catch (Exception e12) {
            String str9 = z6.b.f11259a;
            if (d.p || TextUtils.equals(d.q, "test")) {
                z6.a.d("Worker handle message exception : %s", e12.getMessage());
            }
            g.f4735b.a(new e8.d("handleMessage", e12));
        }
        return false;
    }

    public final t6.a k(TrackDataWrapper trackDataWrapper) {
        Object jSONObject;
        t6.a aVar = new t6.a();
        String str = trackDataWrapper.f2321a;
        if (str == null) {
            str = "";
        }
        aVar.f10167a = str;
        aVar.f10170d = trackDataWrapper.f2323c;
        aVar.f = System.currentTimeMillis();
        aVar.f10171g = SystemClock.elapsedRealtime();
        TrackData trackData = trackDataWrapper.f2322b;
        try {
            JSONObject jSONObject2 = trackData.f2318a;
            String str2 = d.f9538a;
            if (jSONObject2.has("_eparam")) {
                jSONObject = jSONObject2.get("_eparam");
                if (!(jSONObject instanceof JSONArray) || jSONObject2.length() <= 1) {
                    jSONObject2.remove("_eparam");
                } else {
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = new JSONObject();
            }
            if ((jSONObject instanceof JSONObject) && jSONObject2.length() > 0) {
                JSONArray jSONArrayNames = jSONObject2.names();
                for (int i8 = 0; i8 < jSONArrayNames.length(); i8++) {
                    String string = jSONArrayNames.getString(i8);
                    ((JSONObject) jSONObject).put(string, jSONObject2.get(string));
                    jSONObject2.remove(string);
                }
            }
            JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
            jSONObject2.put("_eparam", jSONObject);
            jSONObject2.put("net", f0.b((Context) this.f1434b));
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a);
            aVar.f10168b = jSONObject2;
            aVar.f10169c = jSONObject3;
            aVar.e = trackData.f2319b;
            m6.a aVarF = m6.a.f();
            int i9 = (int) aVar.f10170d;
            String str3 = aVar.f10167a;
            s6.c cVarC = ((i1.b) aVarF.f7948a.f8123c).c(i9);
            s6.a aVar2 = null;
            if (cVarC != null) {
                for (s6.a aVar3 : cVarC.f) {
                    if (TextUtils.equals(aVar3.f9514b, str3)) {
                        aVar2 = aVar3;
                        break;
                    }
                }
            }
            if (aVar2 != null) {
                aVar.f10170d = aVar2.f9513a;
            }
        } catch (JSONException e) {
            z6.a.d("Convert to Track exception : %s", e.getMessage());
        }
        return aVar;
    }

    public final void l(long j8, boolean z2) {
        if (((Handler) this.f1435c).hasMessages(298)) {
            return;
        }
        Message messageObtainMessage = ((Handler) this.f1435c).obtainMessage(298);
        if (z2) {
            messageObtainMessage.arg1 = 1;
            ((Handler) this.f1435c).sendMessage(messageObtainMessage);
        } else {
            messageObtainMessage.arg1 = 0;
            ((Handler) this.f1435c).sendMessageDelayed(messageObtainMessage, j8);
        }
    }

    public final void m(Location location) {
        boolean z2;
        String strSubstring;
        String strSubstring2;
        TrackData trackData = new TrackData();
        boolean z3 = true;
        if (location != null) {
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(location.getLongitude());
            RoundingMode roundingMode = RoundingMode.HALF_UP;
            double dDoubleValue = bigDecimalValueOf.setScale(2, roundingMode).doubleValue();
            double dDoubleValue2 = BigDecimal.valueOf(location.getLatitude()).setScale(2, roundingMode).doubleValue();
            try {
                trackData.f2318a.put("_".concat("lng"), dDoubleValue);
            } catch (Exception e) {
                z6.a.c(Log.getStackTraceString(e));
            }
            try {
                trackData.f2318a.put("_".concat("lat"), dDoubleValue2);
            } catch (Exception e4) {
                z6.a.c(Log.getStackTraceString(e4));
            }
            try {
                trackData.g("geono", l6.a.b(((e) ((i1.b) m6.a.f().f7948a.f8123c).f5527a).f9571o, dDoubleValue2, dDoubleValue).a());
            } catch (Exception e10) {
                z6.a.c(Log.getStackTraceString(e10));
            }
            z2 = true;
        } else {
            trackData.b(0, 0, "lng");
            trackData.b(0, 0, "lat");
            z2 = false;
        }
        Context context = (Context) this.f1434b;
        if (z6.b.f(context, "android.permission.ACCESS_FINE_LOCATION")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            String networkOperator = telephonyManager.getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                strSubstring = "";
                strSubstring2 = strSubstring;
            } else {
                strSubstring2 = networkOperator.substring(0, 3);
                strSubstring = networkOperator.substring(3);
            }
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            ArrayList<l6.b> arrayList = new ArrayList();
            if (allCellInfo != null) {
                l6.b bVar = null;
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo instanceof CellInfoGsm) {
                        CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                        int asuLevel = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                        if (cellIdentity.getCid() > 0 && cellIdentity.getLac() > 0 && asuLevel != 99) {
                            bVar = (cellIdentity.getMcc() == Integer.MAX_VALUE || cellIdentity.getMnc() == Integer.MAX_VALUE) ? new l6.b(strSubstring2, cellIdentity.getCid(), strSubstring, cellIdentity.getLac(), asuLevel, cellInfo.isRegistered()) : new l6.b(z6.b.c(cellIdentity.getMcc()), cellIdentity.getCid(), z6.b.c(cellIdentity.getMnc()), cellIdentity.getLac(), asuLevel, cellInfo.isRegistered());
                        }
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity2 = cellInfoWcdma.getCellIdentity();
                        int asuLevel2 = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        if (cellIdentity2.getCid() > 0 && cellIdentity2.getLac() > 0 && asuLevel2 != 99) {
                            bVar = (cellIdentity2.getMcc() == Integer.MAX_VALUE || cellIdentity2.getMnc() == Integer.MAX_VALUE) ? new l6.b(strSubstring2, cellIdentity2.getCid(), strSubstring, cellIdentity2.getLac(), asuLevel2, cellInfo.isRegistered()) : new l6.b(z6.b.c(cellIdentity2.getMcc()), cellIdentity2.getCid(), z6.b.c(cellIdentity2.getMnc()), cellIdentity2.getLac(), asuLevel2, cellInfo.isRegistered());
                        }
                    } else if (cellInfo instanceof CellInfoLte) {
                        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                        CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                        int asuLevel3 = cellInfoLte.getCellSignalStrength().getAsuLevel();
                        if (cellIdentity3.getCi() > 0 && cellIdentity3.getTac() > 0 && asuLevel3 != 99) {
                            bVar = (cellIdentity3.getMcc() == Integer.MAX_VALUE || cellIdentity3.getMnc() == Integer.MAX_VALUE) ? new l6.b(strSubstring2, cellIdentity3.getCi(), strSubstring, cellIdentity3.getTac(), asuLevel3, cellInfo.isRegistered()) : new l6.b(z6.b.c(cellIdentity3.getMcc()), cellIdentity3.getCi(), z6.b.c(cellIdentity3.getMnc()), cellIdentity3.getTac(), asuLevel3, cellInfo.isRegistered());
                        }
                    }
                    if (bVar != null && !arrayList.contains(bVar)) {
                        arrayList.add(bVar);
                    }
                    if (arrayList.size() == 10) {
                        break;
                    }
                }
            }
            Collections.sort(arrayList, new o(6));
            JSONArray jSONArray = new JSONArray();
            for (l6.b bVar2 : arrayList) {
                try {
                    jSONArray.put(new JSONObject().put("cellid", bVar2.a()).put("level", bVar2.e));
                } catch (JSONException e11) {
                    z6.a.d("%s", Log.getStackTraceString(e11));
                }
            }
            if (jSONArray.length() > 0) {
                trackData.g("cellidlist", jSONArray.toString());
            } else {
                trackData.e(0, "cellidlist", "");
                z3 = z2;
            }
        } else {
            z3 = z2;
        }
        if (z3) {
            long j8 = 9999;
            e8.b.n(j8).o("location", trackData, j8);
        }
    }

    public final void n(MMKV mmkv) throws Throwable {
        try {
            String[] strArrAllKeys = mmkv.allKeys();
            if (strArrAllKeys != null && strArrAllKeys.length >= 1) {
                ArrayList arrayList = new ArrayList();
                String[] strArr = new String[100];
                for (int i8 = 0; i8 < strArrAllKeys.length; i8++) {
                    TrackDataWrapper trackDataWrapper = (TrackDataWrapper) mmkv.decodeParcelable(strArrAllKeys[i8], TrackDataWrapper.class);
                    if (trackDataWrapper != null && arrayList.size() < 100) {
                        arrayList.add(k(trackDataWrapper));
                        strArr[i8] = strArrAllKeys[i8];
                    }
                }
                if (!arrayList.isEmpty()) {
                    p(arrayList);
                    mmkv.removeValuesForKeys(strArr);
                }
                if (mmkv.allKeys() == null || mmkv.allKeys().length <= 0) {
                    return;
                }
                n(mmkv);
            }
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }

    public final void p(ArrayList arrayList) throws Throwable {
        int iR;
        int iB;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            t6.a aVar = (t6.a) it.next();
            if (m6.a.f().b(aVar.f10170d, aVar.f10173i.f2320c) == 0) {
                w6.a.c().a(aVar);
                arrayList2.add(aVar);
            }
        }
        if (arrayList2.size() > 0) {
            u6.a aVarH = u6.a.h((Context) this.f1434b);
            a4.b bVar = new a4.b(arrayList, 29);
            aVarH.getClass();
            try {
                iR = ((u6.c) aVarH.f10379c).r(u6.b.f10381a, arrayList2, bVar);
            } catch (e8.d e) {
                int i8 = e8.d.f4719a;
                g.f4735b.a(e);
                iR = 0;
            }
            z6.a.e("saveMemCacheToDb Count = " + iR);
            if (iR == -2) {
                u6.a aVarH2 = u6.a.h((Context) this.f1434b);
                n5.a aVar2 = new n5.a();
                aVarH2.getClass();
                try {
                    iB = ((u6.c) aVarH2.f10379c).b(u6.b.f10381a, aVar2);
                } catch (e8.d e4) {
                    int i9 = e8.d.f4719a;
                    g.f4735b.a(e4);
                    iB = -1;
                }
                z6.a.c("saveToDB out of memory cleanCount = " + iB);
            }
            l(this.e, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d9  */
    public final void r(t6.a aVar) throws Throwable {
        s6.a aVarE;
        int i8;
        int i9;
        int iA;
        int iA2 = z6.b.a(aVar.f10170d);
        s6.a aVar2 = null;
        if (!"".equals((String) this.f10874i.get(iA2, null)) && "page_enter".equals(aVar.f10167a)) {
            try {
                String string = new JSONObject().put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a).put("ts", aVar.f).put("tid", aVar.f10170d).put("net", aVar.f10168b.getInt("net")).put("eparam", aVar.f10168b.getJSONObject("_eparam").toString()).toString();
                this.f10874i.put(iA2, string);
                i1.a.a((Context) this.f1434b).g("first_page_enter_" + iA2, string);
                z6.a.b("save [%d] fpe to sp : %s", Integer.valueOf(iA2), string);
                return;
            } catch (Exception e) {
                z6.a.d("saveFpeForAppId exception : %s", e.getMessage());
            }
        }
        if (!d.f9553t) {
            z6.a.f("%s", "Athena SDK Enable : [false]");
            return;
        }
        String string2 = aVar.f10168b.toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", z6.b.a(aVar.f10170d));
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a);
            jSONObject.put("ts", aVar.f);
            jSONObject.put("params", aVar.f10168b);
            z6.a.f("track event:%s", jSONObject.toString());
        } catch (Exception e4) {
            z6.a.d("handleSaveData exception:%s", e4.getMessage());
        }
        if (string2.length() >= 716800) {
            z6.a.d("track [%d]-[%s], save2DB failed due to eparam out of limit [%d]", Long.valueOf(aVar.f10170d), aVar.f10167a, 716800);
            return;
        }
        if (x(aVar)) {
            if (aVar.f10170d > 9999) {
                aVarE = m6.a.f().e(aVar.f10170d);
            } else {
                m6.a aVarF = m6.a.f();
                int i10 = (int) aVar.f10170d;
                String str = aVar.f10167a;
                s6.c cVarC = ((i1.b) aVarF.f7948a.f8123c).c(i10);
                if (cVarC != null) {
                    for (s6.a aVar3 : cVarC.f) {
                        if (TextUtils.equals(aVar3.f9514b, str)) {
                            aVar2 = aVar3;
                            break;
                        }
                    }
                }
                if (aVar2 != null) {
                    aVar.f10170d = aVar2.f9513a;
                }
                aVarE = aVar2;
            }
            if (aVar.e == 0 && aVarE != null) {
                int i11 = aVarE.f9515c.f9528n;
            }
            String str2 = d.f9538a;
            int iB = aVar.f10170d > 9999 ? m6.a.f().b(aVar.f10170d, aVar.f10173i.f2320c) : m6.a.f().a((int) aVar.f10170d, aVar.f10167a, aVar.f10173i.f2320c);
            if (iB != 0) {
                z6.a.d("recordTrackFailed reason : %d", Integer.valueOf(iB));
                return;
            }
            if (aVarE != null) {
                long j8 = aVar.f;
                long j10 = aVarE.f9515c.f9527m;
                if (j10 != 0 && j8 < aVarE.f9516d + j10) {
                    z6.a.d("save [%d]-[%s] to DB failed due to limit in one-life-cycle", Long.valueOf(aVar.f10170d), aVar.f10167a);
                    iA = 0;
                } else {
                    w6.a.c().a(aVar);
                    u6.a aVarH = u6.a.h((Context) this.f1434b);
                    aVarH.getClass();
                    i8 = aVar.e;
                    if (i8 != 1 || i8 == 2) {
                        i9 = 1;
                    } else {
                        i9 = 0;
                    }
                    try {
                        iA = ((u6.c) aVarH.f10379c).a(u6.b.f10381a, aVar, i9);
                    } catch (e8.d e10) {
                        int i12 = e8.d.f4719a;
                        g.f4735b.a(e10);
                        iA = 0;
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("tid", aVar.f10170d);
                        jSONObject2.put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a);
                        jSONObject2.put("ts", aVar.f);
                        jSONObject2.put("db_count", iA);
                        z6.a.f("save event to DB:%s", jSONObject2.toString());
                    } catch (Exception e11) {
                        z6.a.d("saveTrack2DB exception:%s", e11.getMessage());
                    }
                }
            } else {
                w6.a.c().a(aVar);
                u6.a aVarH2 = u6.a.h((Context) this.f1434b);
                aVarH2.getClass();
                i8 = aVar.e;
                if (i8 != 1) {
                    i9 = 1;
                } else {
                    i9 = 1;
                }
                iA = ((u6.c) aVarH2.f10379c).a(u6.b.f10381a, aVar, i9);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("tid", aVar.f10170d);
                jSONObject3.put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a);
                jSONObject3.put("ts", aVar.f);
                jSONObject3.put("db_count", iA);
                z6.a.f("save event to DB:%s", jSONObject3.toString());
            }
            int iB2 = -1;
            if (iA == -1) {
                z6.a.c("DB_UPDATE_ERROR");
            } else if (iA == -2) {
                z6.a.f("save [%d]-[%s] to DB failed due to DB_OUT_OF_MEMORY_ERROR", Long.valueOf(aVar.f10170d), aVar.f10167a);
                u6.a aVarH3 = u6.a.h((Context) this.f1434b);
                e0.b bVar = new e0.b(22);
                aVarH3.getClass();
                try {
                    iB2 = ((u6.c) aVarH3.f10379c).b(u6.b.f10381a, bVar);
                } catch (e8.d e12) {
                    int i13 = e8.d.f4719a;
                    g.f4735b.a(e12);
                }
                z6.a.f("Clean up DB due to DB_OUT_OF_MEMORY_ERROR, Count [%d]", Integer.valueOf(iB2));
            }
            if ("ev_athena".equals(aVar.f10167a)) {
                return;
            }
            if (iA > 0) {
                if (aVarE != null) {
                    aVarE.f9516d = aVar.f;
                    aVarE.f9515c.f9525k = iA;
                }
                if ("device".equals(aVar.f10167a) && 9999 == z6.b.a(aVar.f10170d)) {
                    n6.a aVar4 = m6.a.f().f7948a;
                    e eVar = (e) ((i1.b) aVar4.f8123c).f5527a;
                    eVar.f9566j = g0.q(e8.b.f4712i);
                    eVar.f9565i = true;
                    ((o6.a) aVar4.f8122b).h(((i1.b) aVar4.f8123c).d());
                }
            }
            l(this.e, false);
        }
    }

    public final void u(boolean z2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((z2 && TextUtils.isEmpty(d.f9552s)) || Math.abs(jCurrentTimeMillis - this.p) < 3600000) {
            if (((Handler) this.f1435c).hasMessages(TypedValues.PositionType.TYPE_DRAWPATH)) {
                return;
            }
            ((Handler) this.f1435c).sendMessageDelayed(((Handler) this.f1435c).obtainMessage(TypedValues.PositionType.TYPE_DRAWPATH), 3600000L);
            return;
        }
        if (m6.a.f().a(9999, "location", 1.0f) == 0) {
            Context context = (Context) this.f1434b;
            if (z6.b.f(context, "android.permission.ACCESS_COARSE_LOCATION") || z6.b.f(context, "android.permission.ACCESS_FINE_LOCATION")) {
                LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                if (locationManager == null) {
                    m(null);
                    return;
                }
                String str = "network";
                if (!locationManager.isProviderEnabled("network")) {
                    str = "passive";
                    if (!locationManager.isProviderEnabled("passive")) {
                        str = "gps";
                        if (!locationManager.isProviderEnabled("gps")) {
                            str = null;
                        }
                    }
                }
                if (str != null) {
                    Handler handler = (Handler) this.f1435c;
                    w wVar = this.q;
                    handler.removeCallbacks(wVar);
                    ((Handler) this.f1435c).postDelayed(wVar, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                    locationManager.requestSingleUpdate(str, this.f10881r, (Looper) null);
                    this.p = jCurrentTimeMillis;
                }
                if (((Handler) this.f1435c).hasMessages(TypedValues.PositionType.TYPE_DRAWPATH)) {
                    return;
                }
                ((Handler) this.f1435c).sendMessageDelayed(((Handler) this.f1435c).obtainMessage(TypedValues.PositionType.TYPE_DRAWPATH), 3600000L);
            }
        }
    }

    public final void v(int i8, String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) ((i1.b) m6.a.f().f7948a.f8123c).f5528b;
        Iterator it = copyOnWriteArrayList.iterator();
        do {
            if (!it.hasNext()) {
                s6.c cVar = new s6.c();
                cVar.f9529a = i8;
                copyOnWriteArrayList.add(cVar);
                break;
            }
        } while (((s6.c) it.next()).f9529a != i8);
        Context context = (Context) this.f1434b;
        if (u6.a.h(context) != null) {
            if (str == null) {
                u6.a.h(context).m(AppIdData.b(context, i8));
                return;
            }
            u6.a aVarH = u6.a.h(context);
            AppIdData appIdData = new AppIdData();
            appIdData.f2313a = i8;
            appIdData.f2314b = str;
            aVarH.m(appIdData);
        }
    }

    public final void w(t6.a aVar) {
        Context context = (Context) this.f1434b;
        if (!d.f9553t) {
            z6.a.e("Athena SDK isAthenaEnable = false");
            return;
        }
        if (x(aVar)) {
            int iA = z6.b.a(aVar.f10170d);
            SparseArray sparseArray = this.f10874i;
            if (sparseArray.indexOfKey(iA) >= 0) {
                String str = (String) sparseArray.get(iA, "");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String string = jSONObject.has("eparam") ? jSONObject.getString("eparam") : "";
                        JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
                        t6.a aVar2 = new t6.a();
                        aVar2.f10167a = jSONObject.getString(NotificationCompat.CATEGORY_EVENT);
                        aVar2.f10170d = jSONObject.getLong("tid");
                        aVar2.f = jSONObject.getLong("ts");
                        aVar2.f10171g = SystemClock.elapsedRealtime();
                        aVar2.f10169c = jSONObject2;
                        sparseArray.put(iA, "");
                        i1.a.a(e8.b.f4712i).g("first_page_enter_" + iA, "");
                        w(aVar2);
                    } catch (Exception unused) {
                    }
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(NotificationCompat.CATEGORY_EVENT, aVar.f10167a);
                jSONObject3.put("tid", aVar.f10170d);
                jSONObject3.put(MessageBank.KEY_TYPE, aVar.e);
                JSONObject jSONObject4 = aVar.f10169c;
                q(jSONObject4, "_apkg", g0.o(context));
                q(jSONObject4, "_avn", g0.q(context));
                q(jSONObject4, "_avc", Integer.valueOf(g0.p(context)));
                String str2 = d.f9538a;
                q(jSONObject4, "_atutp", (short) 0);
                q(jSONObject4, "_atuid", "");
                q(jSONObject4, "_achannel", null);
                q(jSONObject4, "_ainstallchnl", TextUtils.isEmpty(g0.l(context)) ? " " : g0.l(context));
                jSONObject3.put("_eparam", jSONObject4);
            } catch (JSONException e) {
                z6.a.d("Track by DCS exception : ", e.getMessage());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("trackObject", jSONObject3.toString());
            context.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/track"), contentValues);
            z6.a.f("track by DCS:%s", jSONObject3.toString());
        }
    }

    public final boolean x(t6.a aVar) {
        if (!"app_launch".equals(aVar.f10167a)) {
            return true;
        }
        i1.a aVarA = i1.a.a((Context) this.f1434b);
        String str = "app_launch_" + z6.b.a(aVar.f10170d);
        int iE = aVarA.e(str);
        if (iE != 0 && Math.abs((aVar.f / 1000) - ((long) iE)) <= 7200) {
            return false;
        }
        aVarA.b(Long.valueOf(aVar.f / 1000).intValue(), str);
        return true;
    }

    public final void y() {
        Context context = (Context) this.f1434b;
        Cursor cursorQuery = null;
        try {
            String strO = g0.o(context);
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/authorize"), null, "pkg = ?", new String[]{strO}, null);
            if (cursorQuery != null) {
                boolean z2 = true;
                if (cursorQuery.getCount() != 1) {
                    z2 = false;
                }
                this.f10878m = z2;
                z6.a.f("Pkg [%s] DCS authorize [%s]", strO, z2 ? "enable" : "disable");
            } else {
                z6.a.f("Cursor is null, Pkg [%s] may not on the DCS white list", strO);
            }
        } catch (Exception e) {
            z6.a.d("Dcs applyForAccess exception : %s", e.getMessage());
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }
}
