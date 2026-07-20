package x3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.tencent.mmkv.MMKV;
import com.transsion.athena.data.AppIdData;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import ik.y0;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k6.i;
import k6.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w3.j;
import w3.k;
import w3.q;

/* JADX INFO: loaded from: classes2.dex */
public class h extends x3.c implements Handler.Callback {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @b.a({"StaticFieldLeak"})
    public static volatile h f20006r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<t3.a> f20012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f20013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SparseArray<String> f20014j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f20015k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20016l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f20017m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f20018n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f20019o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final n3.a f20020p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Runnable f20021q;

    public class a implements l6.c.InterfaceC0255c {
        public a(h hVar) {
        }

        @Override // l6.c.InterfaceC0255c
        public void a(Map<String, String> map) {
        }

        @Override // l6.c.InterfaceC0255c
        public void b() {
        }
    }

    public class b implements l6.c.InterfaceC0255c {
        public b() {
        }

        @Override // l6.c.InterfaceC0255c
        public void a(Map<String, String> map) {
            h.this.f20015k = map == null ? "" : map.toString();
        }

        @Override // l6.c.InterfaceC0255c
        public void b() {
        }
    }

    public class c implements l6.c.InterfaceC0255c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s3.f f20025c;

        public c(String str, int i10, s3.f fVar) {
            this.f20023a = str;
            this.f20024b = i10;
            this.f20025c = fVar;
        }

        @Override // l6.c.InterfaceC0255c
        public void a(Map<String, String> map) {
            h.this.v(this.f20023a, this.f20024b, this.f20025c, map == null ? "" : map.toString());
        }

        @Override // l6.c.InterfaceC0255c
        public void b() {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!s3.g.O()) {
                y3.b.f("Athena SDK isAthenaEnable = false");
                return;
            }
            try {
                MMKV mmkvMmkvWithID = MMKV.mmkvWithID("AthenaKV", 2);
                String[] strArrAllKeys = mmkvMmkvWithID.allKeys();
                if (strArrAllKeys != null && strArrAllKeys.length > 0) {
                    h.this.t(mmkvMmkvWithID);
                }
                h.this.f20004b.postDelayed(this, 300000L);
            } catch (Exception e10) {
                y3.b.d(Log.getStackTraceString(e10));
            }
        }
    }

    public class e extends n3.a {
        public e() {
        }

        @Override // n3.a
        public void a(int i10, boolean z10) {
            try {
                if (i10 > 0) {
                    h.this.r(i10, z10);
                } else {
                    h.C(h.this);
                }
            } catch (Exception e10) {
                y3.b.e("onConfigChanged exception : %s", e10.getMessage());
            }
        }
    }

    public class f implements l6.c.d {
        public f(h hVar) {
        }

        @Override // l6.c.d
        public void a(String str) {
        }

        @Override // l6.c.d
        public void b() {
        }
    }

    public class g implements u3.d<String> {
        public g(h hVar) {
        }

        @Override // u3.d
        public void a(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("v", str);
            l.f9150b.c(new i("cleanupEvents_oom", bundle));
        }
    }

    public h(Context context) {
        super(context);
        this.f20007c = false;
        this.f20008d = false;
        this.f20014j = new SparseArray<>();
        this.f20019o = 0L;
        this.f20020p = new e();
        this.f20021q = new d();
        HandlerThread handlerThread = new HandlerThread("Athena-Worker", 10);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f20004b = handler;
        handler.sendEmptyMessage(303);
    }

    public static void C(h hVar) {
        if (!hVar.f20010f) {
            hVar.f20009e = n3.b.l().s() * 1000;
        }
        hVar.M();
    }

    public static void H(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("v", str);
        l.f9150b.c(new i("cleanupEvents_oom", bundle));
    }

    private void K() {
        Cursor cursorQuery = null;
        try {
            String strT = y3.e.t(this.f20003a);
            cursorQuery = this.f20003a.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/authorize"), null, "pkg = ?", new String[]{strT}, null);
            if (cursorQuery != null) {
                boolean z10 = true;
                if (cursorQuery.getCount() != 1) {
                    z10 = false;
                }
                this.f20018n = z10;
                y3.b.g("Pkg [%s] DCS authorize [%s]", strT, z10 ? hi.b.f7122k : "disable");
            } else {
                y3.b.g("Cursor is null, Pkg [%s] may not on the DCS white list", strT);
            }
        } catch (Exception e10) {
            y3.b.e("Dcs applyForAccess exception : %s", e10.getMessage());
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public static h p(Context context) {
        if (f20006r == null) {
            synchronized (h.class) {
                try {
                    if (f20006r == null) {
                        f20006r = new h(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f20006r;
    }

    private void q(int i10, String str) {
        n3.b.l().f(i10);
        if (u3.a.e(this.f20003a) != null) {
            if (str == null) {
                u3.a.e(this.f20003a).h(AppIdData.a(this.f20003a, i10));
                return;
            }
            u3.a aVarE = u3.a.e(this.f20003a);
            AppIdData appIdData = new AppIdData();
            appIdData.f1812a = i10;
            appIdData.f1813b = str;
            aVarE.h(appIdData);
        }
    }

    public static /* synthetic */ void s(SparseArray sparseArray) {
        ArrayList arrayList = new ArrayList(sparseArray.size());
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            arrayList.add((s3.f) sparseArray.valueAt(i10));
        }
        n3.b.l().i(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("v", str);
        l.f9150b.c(new i("cleanupEvents_off", bundle));
        y3.b.g("handleTidChange cleanupList : %s", str);
    }

    public static /* synthetic */ void y(List list, LongSparseArray longSparseArray) {
        y3.b.f("saveMemCacheToDb tidCountArray = " + longSparseArray);
        list.clear();
        for (int i10 = 0; i10 < longSparseArray.size(); i10++) {
            long jKeyAt = longSparseArray.keyAt(i10);
            s3.a aVarM = n3.b.l().m(jKeyAt);
            if (aVarM != null) {
                aVarM.f().c(((Integer) longSparseArray.valueAt(i10)).intValue());
                if ("device".equals(aVarM.d()) && 9999 == y3.d.a(jKeyAt)) {
                    n3.b.l().w();
                }
            }
        }
    }

    public final void A(t3.a aVar) {
        s3.a aVarD;
        int iA = y3.d.a(aVar.e());
        if (!"".equals(this.f20014j.get(iA, null)) && "page_enter".equals(aVar.b())) {
            try {
                String string = new JSONObject().put(NotificationCompat.CATEGORY_EVENT, aVar.b()).put("ts", aVar.i()).put("tid", aVar.e()).put("net", aVar.c().getInt("net")).put("eparam", aVar.c().getJSONObject("_eparam").toString()).toString();
                this.f20014j.put(iA, string);
                m0.a.a(this.f20003a).g("first_page_enter_" + iA, string);
                y3.b.c("save [%d] fpe to sp : %s", Integer.valueOf(iA), string);
                return;
            } catch (Exception e10) {
                y3.b.e("saveFpeForAppId exception : %s", e10.getMessage());
            }
        }
        if (!s3.g.O()) {
            y3.b.g("%s", "Athena SDK Enable : [false]");
            return;
        }
        String string2 = aVar.c().toString();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", y3.d.a(aVar.e()));
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
            jSONObject.put("ts", aVar.i());
            jSONObject.put("params", aVar.c());
            y3.b.g("track event:%s", jSONObject.toString());
        } catch (Exception e11) {
            y3.b.e("handleSaveData exception:%s", e11.getMessage());
        }
        if (string2.length() >= 716800) {
            y3.b.e("track [%d]-[%s], save2DB failed due to eparam out of limit [%d]", Long.valueOf(aVar.e()), aVar.b(), 716800);
            return;
        }
        if (J(aVar)) {
            if (aVar.e() > 9999) {
                aVarD = n3.b.l().m(aVar.e());
            } else {
                aVarD = n3.b.l().d((int) aVar.e(), aVar.b());
                if (aVarD != null) {
                    aVar.n(aVarD.e());
                }
            }
            boolean z10 = false;
            if (aVar.h() == 0 && aVarD != null && aVarD.h()) {
                z10 = true;
            }
            int i10 = s3.g.f14992y;
            if (i10 <= 0 || !z10) {
                B(aVar, aVarD);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("tid", aVar.e());
                jSONObject2.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
                y3.b.g("save event to memory:%s", jSONObject2.toString());
            } catch (Exception e12) {
                y3.b.e("print saveTrack2Mem exception:%s", e12.getMessage());
            }
            if (this.f20012h == null) {
                this.f20012h = new ArrayList<>();
            }
            if (this.f20012h.size() >= i10 - 1) {
                this.f20012h.add(aVar);
                x(this.f20012h);
                this.f20013i = 0L;
                return;
            }
            long jI = aVar.i();
            if (!aVarD.a(jI)) {
                y3.b.g("save [%d]-[%s] to DB failed due to limit in one-life-cycle", Long.valueOf(aVar.e()), aVar.b());
                return;
            }
            aVarD.k(jI);
            this.f20012h.add(aVar);
            long j10 = this.f20013i;
            if (j10 == 0) {
                this.f20013i = jI;
            } else if (jI - j10 >= 600000) {
                x(this.f20012h);
                this.f20013i = 0L;
            }
        }
    }

    public final void B(t3.a aVar, s3.a aVar2) {
        int iC;
        int iB = aVar.e() > 9999 ? n3.b.l().b(aVar.e(), aVar.f().r()) : n3.b.l().a((int) aVar.e(), aVar.b(), aVar.f().r());
        if (iB != 0) {
            y3.b.e("recordTrackFailed reason : %d", Integer.valueOf(iB));
            return;
        }
        if (aVar2 == null || aVar2.a(aVar.i())) {
            m3.a.f().c(aVar);
            iC = u3.a.e(this.f20003a).c(aVar);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tid", aVar.e());
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
                jSONObject.put("ts", aVar.i());
                jSONObject.put("db_count", iC);
                y3.b.g("save event to DB:%s", jSONObject.toString());
            } catch (Exception e10) {
                y3.b.e("saveTrack2DB exception:%s", e10.getMessage());
            }
        } else {
            y3.b.e("save [%d]-[%s] to DB failed due to limit in one-life-cycle", Long.valueOf(aVar.e()), aVar.b());
            iC = 0;
        }
        if (iC == -1) {
            y3.b.d("DB_UPDATE_ERROR");
        } else if (iC == -2) {
            y3.b.g("save [%d]-[%s] to DB failed due to DB_OUT_OF_MEMORY_ERROR", Long.valueOf(aVar.e()), aVar.b());
            y3.b.g("Clean up DB due to DB_OUT_OF_MEMORY_ERROR, Count [%d]", Integer.valueOf(u3.a.e(this.f20003a).a(1000, new x3.e())));
        }
        if ("ev_athena".equals(aVar.b())) {
            return;
        }
        if (iC > 0) {
            if (aVar2 != null) {
                aVar2.k(aVar.i());
                aVar2.f().c(iC);
            }
            if ("device".equals(aVar.b()) && 9999 == y3.d.a(aVar.e())) {
                n3.b.l().w();
            }
        }
        G(false, this.f20009e);
    }

    public final void G(boolean z10, long j10) {
        if (this.f20004b.hasMessages(298)) {
            return;
        }
        Message messageObtainMessage = this.f20004b.obtainMessage(298);
        if (z10) {
            messageObtainMessage.arg1 = 1;
            this.f20004b.sendMessage(messageObtainMessage);
        } else {
            messageObtainMessage.arg1 = 0;
            this.f20004b.sendMessageDelayed(messageObtainMessage, j10);
        }
    }

    public final void I(t3.a aVar) {
        if (!s3.g.O()) {
            y3.b.f("Athena SDK isAthenaEnable = false");
            return;
        }
        if (J(aVar)) {
            int iA = y3.d.a(aVar.e());
            String str = "";
            if (this.f20014j.indexOfKey(iA) >= 0) {
                String str2 = this.f20014j.get(iA, "");
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        String string = jSONObject.has("eparam") ? jSONObject.getString("eparam") : "";
                        JSONObject jSONObject2 = TextUtils.isEmpty(string) ? new JSONObject() : new JSONObject(string);
                        t3.a aVar2 = new t3.a();
                        aVar2.f15446a = jSONObject.getString(NotificationCompat.CATEGORY_EVENT);
                        aVar2.f15449d = jSONObject.getLong("tid");
                        aVar2.f15451f = jSONObject.getLong("ts");
                        aVar2.f15452g = SystemClock.elapsedRealtime();
                        aVar2.f15448c = jSONObject2;
                        this.f20014j.put(iA, "");
                        m0.a.a(k6.g.h0()).g("first_page_enter_" + iA, "");
                        I(aVar2);
                    } catch (Exception unused) {
                    }
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
                jSONObject3.put("tid", aVar.e());
                jSONObject3.put(y0.a.f8215h, aVar.h());
                JSONObject jSONObjectD = aVar.d();
                z(jSONObjectD, "_apkg", y3.e.t(this.f20003a));
                z(jSONObjectD, "_avn", y3.e.v(this.f20003a));
                z(jSONObjectD, "_avc", Integer.valueOf(y3.e.u(this.f20003a)));
                z(jSONObjectD, "_atutp", Short.valueOf(s3.g.f14993z));
                String str3 = s3.g.A;
                if (str3 != null) {
                    str = str3;
                }
                z(jSONObjectD, "_atuid", str);
                z(jSONObjectD, "_achannel", s3.g.f14986s);
                z(jSONObjectD, "_ainstallchnl", TextUtils.isEmpty(y3.e.q(this.f20003a)) ? " " : y3.e.q(this.f20003a));
                String str4 = s3.g.f14975h;
                jSONObject3.put("_eparam", jSONObjectD);
            } catch (JSONException e10) {
                y3.b.e("Track by DCS exception : ", e10.getMessage());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("trackObject", jSONObject3.toString());
            this.f20003a.getContentResolver().insert(Uri.parse("content://com.transsion.dataservice.provider/track"), contentValues);
            y3.b.g("track by DCS:%s", jSONObject3.toString());
        }
    }

    public final boolean J(t3.a aVar) {
        if (!"app_launch".equals(aVar.b())) {
            return true;
        }
        m0.a aVarA = m0.a.a(this.f20003a);
        String str = "app_launch_" + y3.d.a(aVar.e());
        int iE = aVarA.e(str);
        if (iE != 0 && Math.abs((aVar.i() / 1000) - ((long) iE)) <= 7200) {
            return false;
        }
        aVarA.b(str, Long.valueOf(aVar.i() / 1000).intValue());
        return true;
    }

    public final boolean L() {
        List<s3.f> listC = n3.b.l().c();
        if (s3.e.j(listC)) {
            return false;
        }
        for (s3.f fVar : listC) {
            if (fVar != null && fVar.e()) {
                return true;
            }
        }
        return false;
    }

    public final void M() {
        if (!y3.f.d(this.f20003a)) {
            y3.b.g("%s", "CheckConfig cancel, network is not available");
        } else if (l6.c.m(s3.g.c(false))) {
            n3.b.l().g(this.f20004b, this.f20020p);
        } else {
            y3.b.g("%s", "CheckConfig cancel, GslbSdk is not inited");
        }
    }

    public final void N() {
        if (!y3.f.d(this.f20003a)) {
            y3.b.c("%s", "checkUpload network unavailable");
            return;
        }
        if (m3.a.f().j()) {
            if (m3.a.f().i()) {
                return;
            }
            y3.b.c("%s", "checkUpload sync baseTime");
            m3.a.f().d(true);
            j.d().e(new k(this.f20004b));
            return;
        }
        if (!s3.g.O()) {
            y3.b.c("%s", "checkUpload sdk disable or gaid invalid");
            String strI = m0.a.a(this.f20003a).i("gdpr_close");
            if (TextUtils.isEmpty(strI)) {
                return;
            }
            j.d().e(new w3.b(this.f20004b, strI));
            return;
        }
        if (!l6.c.m(s3.g.L())) {
            y3.b.c("%s", "checkUpload GSLB is not ready");
            return;
        }
        if (s3.e.j(n3.b.l().o())) {
            y3.b.c("%s", "checkUpload global config is not ready");
            return;
        }
        List<AppIdData> listR = u3.a.e(this.f20003a).r();
        if (s3.e.j(listR)) {
            List<s3.f> listC = n3.b.l().c();
            if (s3.e.j(listC)) {
                y3.b.c("%s", "checkUpload appid config list is null");
                return;
            }
            Iterator<s3.f> it = listC.iterator();
            while (it.hasNext()) {
                AppIdData appIdDataA = AppIdData.a(this.f20003a, it.next().g());
                if (listR == null) {
                    listR = new ArrayList<>();
                }
                listR.add(appIdDataA);
                u3.a.e(this.f20003a).h(appIdDataA);
            }
        }
        HashSet hashSet = new HashSet();
        for (AppIdData appIdData : listR) {
            s3.f fVarN = n3.b.l().n(appIdData.f1812a);
            if (fVarN != null) {
                String strD = TextUtils.isEmpty(fVarN.w()) ? l6.c.d(s3.g.L(), true) : l6.c.d(s3.g.l(fVarN.w()), true);
                appIdData.f1817f = strD;
                hashSet.add(strD);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            j.d().e(new q(this.f20004b, (String) it2.next(), listR, this.f20008d, this.f20014j));
        }
    }

    public final void O() throws Throwable {
        this.f20017m = System.currentTimeMillis();
        this.f20016l = y3.f.d(this.f20003a);
        m3.a.f().h();
        n3.b.l().t();
        u3.a.e(this.f20003a).p(new x3.d());
        if (k6.g.g0() != null) {
            k6.g.f9109l.a(n3.b.l().p(-1));
        }
        int iD = t3.d.d();
        if (iD != 0) {
            s3.g.A(n3.b.l().a(iD, "page_view", 1.0f) == 0);
        }
        if (y3.d.j(this.f20003a) && L() && s3.g.O()) {
            y3.b.g("%s", "Dcs available");
            K();
        } else {
            y3.b.g("%s", "Dcs unavailable because of not support or conf disable");
        }
        l6.c.l(this.f20003a, r3.a.f14213a, new b());
        Handler handler = this.f20004b;
        handler.postDelayed(new x3.b(handler), 7200000L);
        if (k6.g.B0()) {
            this.f20004b.post(this.f20021q);
        }
        try {
            m0.a aVarA = m0.a.a(this.f20003a);
            for (Integer num : t3.d.f15470b) {
                String str = "first_page_enter_" + num;
                if (aVarA.d(str)) {
                    this.f20014j.put(num.intValue(), aVarA.i(str));
                }
            }
            File filesDir = this.f20003a.getFilesDir();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(filesDir);
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(s3.g.f14978k);
            File file = new File(sb2.toString());
            File file2 = new File(filesDir + str2 + s3.g.f14979l);
            if (k6.g.w0()) {
                this.f20008d = true;
            } else if (file.exists()) {
                String[] list = file.list();
                if (list != null && list.length != 0) {
                    this.f20008d = true;
                } else if (file.delete()) {
                    y3.b.c("%s", "dataFile deleted");
                }
            }
            if (file2.exists()) {
                y3.e.h(this.f20003a, file2.getPath());
            }
        } catch (Exception e10) {
            y3.b.c("%s", e10.getMessage());
            w("handleInit", e10);
        }
        if (this.f20010f) {
            return;
        }
        this.f20009e = n3.b.l().s() * 1000;
    }

    @Override // x3.c
    public void a() {
        Handler handler = this.f20004b;
        if (handler != null) {
            this.f20004b.sendMessageAtFrontOfQueue(handler.obtainMessage(308));
        }
    }

    @Override // x3.c
    public void b(int i10) {
        this.f20009e = Math.max(i10, 2000);
        this.f20010f = true;
    }

    @Override // x3.c
    public void c(Message message, long j10) {
        Handler handler = this.f20004b;
        if (handler != null) {
            if (j10 > 0) {
                handler.removeMessages(message.what);
            }
            this.f20004b.sendMessageDelayed(message, j10);
        }
    }

    @Override // x3.c
    public void d(Runnable runnable) {
        Handler handler = this.f20004b;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override // x3.c
    public void e(Runnable runnable, long j10) {
        Handler handler = this.f20004b;
        if (handler != null) {
            handler.postDelayed(runnable, j10);
        }
    }

    @Override // x3.c
    public void f(String str, TrackData trackData, long j10) {
        t3.a aVar = new t3.a();
        aVar.f15446a = str;
        aVar.f15449d = j10;
        aVar.f15451f = System.currentTimeMillis();
        aVar.f15452g = SystemClock.elapsedRealtime();
        aVar.f15454i = trackData;
        int i10 = this.f20011g;
        if (i10 < 5000) {
            this.f20011g = i10 + 1;
            Message messageObtainMessage = this.f20004b.obtainMessage(302);
            messageObtainMessage.obj = aVar;
            this.f20004b.sendMessage(messageObtainMessage);
        }
    }

    @Override // x3.c
    public boolean h() {
        return !this.f20007c;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x01f8 A[Catch: Exception -> 0x0064, TryCatch #2 {Exception -> 0x0064, blocks: (B:3:0x0008, B:19:0x002e, B:21:0x0040, B:23:0x0054, B:25:0x005a, B:28:0x0067, B:29:0x006f, B:36:0x0095, B:37:0x009c, B:39:0x00a9, B:40:0x00ba, B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:76:0x0179, B:78:0x018c, B:79:0x0196, B:81:0x019f, B:83:0x01a3, B:85:0x01a7, B:87:0x01ad, B:89:0x01bf, B:91:0x01c5, B:98:0x01db, B:100:0x01df, B:102:0x01e3, B:104:0x01e7, B:106:0x01eb, B:108:0x01f8, B:110:0x0203, B:112:0x020a, B:114:0x0212, B:94:0x01cb, B:96:0x01d5, B:97:0x01d8, B:58:0x010c, B:59:0x0110, B:75:0x016e, B:48:0x00e3, B:115:0x0216, B:116:0x021a, B:118:0x021e, B:119:0x0221, B:121:0x0229, B:123:0x023b, B:126:0x0241, B:127:0x0265, B:31:0x007a, B:33:0x0089, B:41:0x00c2, B:43:0x00ce, B:45:0x00d4), top: B:139:0x0008, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x021a A[Catch: Exception -> 0x0064, TryCatch #2 {Exception -> 0x0064, blocks: (B:3:0x0008, B:19:0x002e, B:21:0x0040, B:23:0x0054, B:25:0x005a, B:28:0x0067, B:29:0x006f, B:36:0x0095, B:37:0x009c, B:39:0x00a9, B:40:0x00ba, B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:76:0x0179, B:78:0x018c, B:79:0x0196, B:81:0x019f, B:83:0x01a3, B:85:0x01a7, B:87:0x01ad, B:89:0x01bf, B:91:0x01c5, B:98:0x01db, B:100:0x01df, B:102:0x01e3, B:104:0x01e7, B:106:0x01eb, B:108:0x01f8, B:110:0x0203, B:112:0x020a, B:114:0x0212, B:94:0x01cb, B:96:0x01d5, B:97:0x01d8, B:58:0x010c, B:59:0x0110, B:75:0x016e, B:48:0x00e3, B:115:0x0216, B:116:0x021a, B:118:0x021e, B:119:0x0221, B:121:0x0229, B:123:0x023b, B:126:0x0241, B:127:0x0265, B:31:0x007a, B:33:0x0089, B:41:0x00c2, B:43:0x00ce, B:45:0x00d4), top: B:139:0x0008, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x021e A[Catch: Exception -> 0x0064, TryCatch #2 {Exception -> 0x0064, blocks: (B:3:0x0008, B:19:0x002e, B:21:0x0040, B:23:0x0054, B:25:0x005a, B:28:0x0067, B:29:0x006f, B:36:0x0095, B:37:0x009c, B:39:0x00a9, B:40:0x00ba, B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:76:0x0179, B:78:0x018c, B:79:0x0196, B:81:0x019f, B:83:0x01a3, B:85:0x01a7, B:87:0x01ad, B:89:0x01bf, B:91:0x01c5, B:98:0x01db, B:100:0x01df, B:102:0x01e3, B:104:0x01e7, B:106:0x01eb, B:108:0x01f8, B:110:0x0203, B:112:0x020a, B:114:0x0212, B:94:0x01cb, B:96:0x01d5, B:97:0x01d8, B:58:0x010c, B:59:0x0110, B:75:0x016e, B:48:0x00e3, B:115:0x0216, B:116:0x021a, B:118:0x021e, B:119:0x0221, B:121:0x0229, B:123:0x023b, B:126:0x0241, B:127:0x0265, B:31:0x007a, B:33:0x0089, B:41:0x00c2, B:43:0x00ce, B:45:0x00d4), top: B:139:0x0008, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0229 A[Catch: Exception -> 0x0064, TryCatch #2 {Exception -> 0x0064, blocks: (B:3:0x0008, B:19:0x002e, B:21:0x0040, B:23:0x0054, B:25:0x005a, B:28:0x0067, B:29:0x006f, B:36:0x0095, B:37:0x009c, B:39:0x00a9, B:40:0x00ba, B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:76:0x0179, B:78:0x018c, B:79:0x0196, B:81:0x019f, B:83:0x01a3, B:85:0x01a7, B:87:0x01ad, B:89:0x01bf, B:91:0x01c5, B:98:0x01db, B:100:0x01df, B:102:0x01e3, B:104:0x01e7, B:106:0x01eb, B:108:0x01f8, B:110:0x0203, B:112:0x020a, B:114:0x0212, B:94:0x01cb, B:96:0x01d5, B:97:0x01d8, B:58:0x010c, B:59:0x0110, B:75:0x016e, B:48:0x00e3, B:115:0x0216, B:116:0x021a, B:118:0x021e, B:119:0x0221, B:121:0x0229, B:123:0x023b, B:126:0x0241, B:127:0x0265, B:31:0x007a, B:33:0x0089, B:41:0x00c2, B:43:0x00ce, B:45:0x00d4), top: B:139:0x0008, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0265 A[Catch: Exception -> 0x0064, TRY_LEAVE, TryCatch #2 {Exception -> 0x0064, blocks: (B:3:0x0008, B:19:0x002e, B:21:0x0040, B:23:0x0054, B:25:0x005a, B:28:0x0067, B:29:0x006f, B:36:0x0095, B:37:0x009c, B:39:0x00a9, B:40:0x00ba, B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:76:0x0179, B:78:0x018c, B:79:0x0196, B:81:0x019f, B:83:0x01a3, B:85:0x01a7, B:87:0x01ad, B:89:0x01bf, B:91:0x01c5, B:98:0x01db, B:100:0x01df, B:102:0x01e3, B:104:0x01e7, B:106:0x01eb, B:108:0x01f8, B:110:0x0203, B:112:0x020a, B:114:0x0212, B:94:0x01cb, B:96:0x01d5, B:97:0x01d8, B:58:0x010c, B:59:0x0110, B:75:0x016e, B:48:0x00e3, B:115:0x0216, B:116:0x021a, B:118:0x021e, B:119:0x0221, B:121:0x0229, B:123:0x023b, B:126:0x0241, B:127:0x0265, B:31:0x007a, B:33:0x0089, B:41:0x00c2, B:43:0x00ce, B:45:0x00d4), top: B:139:0x0008, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00f6 A[Catch: Exception -> 0x0064, JSONException -> 0x010a, TryCatch #0 {JSONException -> 0x010a, blocks: (B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:58:0x010c, B:59:0x0110), top: B:135:0x00ea, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x010c A[Catch: Exception -> 0x0064, JSONException -> 0x010a, TryCatch #0 {JSONException -> 0x010a, blocks: (B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:58:0x010c, B:59:0x0110), top: B:135:0x00ea, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0110 A[Catch: Exception -> 0x0064, JSONException -> 0x010a, TryCatch #0 {JSONException -> 0x010a, blocks: (B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:58:0x010c, B:59:0x0110), top: B:135:0x00ea, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x012a A[Catch: Exception -> 0x0064, JSONException -> 0x010a, LOOP:0: B:65:0x0124->B:67:0x012a, LOOP_END, TryCatch #0 {JSONException -> 0x010a, blocks: (B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:58:0x010c, B:59:0x0110), top: B:135:0x00ea, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x018c A[Catch: Exception -> 0x0064, TryCatch #2 {Exception -> 0x0064, blocks: (B:3:0x0008, B:19:0x002e, B:21:0x0040, B:23:0x0054, B:25:0x005a, B:28:0x0067, B:29:0x006f, B:36:0x0095, B:37:0x009c, B:39:0x00a9, B:40:0x00ba, B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:76:0x0179, B:78:0x018c, B:79:0x0196, B:81:0x019f, B:83:0x01a3, B:85:0x01a7, B:87:0x01ad, B:89:0x01bf, B:91:0x01c5, B:98:0x01db, B:100:0x01df, B:102:0x01e3, B:104:0x01e7, B:106:0x01eb, B:108:0x01f8, B:110:0x0203, B:112:0x020a, B:114:0x0212, B:94:0x01cb, B:96:0x01d5, B:97:0x01d8, B:58:0x010c, B:59:0x0110, B:75:0x016e, B:48:0x00e3, B:115:0x0216, B:116:0x021a, B:118:0x021e, B:119:0x0221, B:121:0x0229, B:123:0x023b, B:126:0x0241, B:127:0x0265, B:31:0x007a, B:33:0x0089, B:41:0x00c2, B:43:0x00ce, B:45:0x00d4), top: B:139:0x0008, inners: #0, #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:96:0x01d5 A[Catch: Exception -> 0x0064, TryCatch #2 {Exception -> 0x0064, blocks: (B:3:0x0008, B:19:0x002e, B:21:0x0040, B:23:0x0054, B:25:0x005a, B:28:0x0067, B:29:0x006f, B:36:0x0095, B:37:0x009c, B:39:0x00a9, B:40:0x00ba, B:49:0x00ea, B:51:0x00f6, B:53:0x00fe, B:55:0x0104, B:60:0x0115, B:62:0x0119, B:64:0x011f, B:65:0x0124, B:67:0x012a, B:68:0x013e, B:70:0x014c, B:72:0x0157, B:76:0x0179, B:78:0x018c, B:79:0x0196, B:81:0x019f, B:83:0x01a3, B:85:0x01a7, B:87:0x01ad, B:89:0x01bf, B:91:0x01c5, B:98:0x01db, B:100:0x01df, B:102:0x01e3, B:104:0x01e7, B:106:0x01eb, B:108:0x01f8, B:110:0x0203, B:112:0x020a, B:114:0x0212, B:94:0x01cb, B:96:0x01d5, B:97:0x01d8, B:58:0x010c, B:59:0x0110, B:75:0x016e, B:48:0x00e3, B:115:0x0216, B:116:0x021a, B:118:0x021e, B:119:0x0221, B:121:0x0229, B:123:0x023b, B:126:0x0241, B:127:0x0265, B:31:0x007a, B:33:0x0089, B:41:0x00c2, B:43:0x00ce, B:45:0x00d4), top: B:139:0x0008, inners: #0, #1, #3 }] */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        Context context;
        long jCurrentTimeMillis;
        long j10;
        long j11;
        JSONObject jSONObjectA;
        Object jSONObject;
        JSONArray jSONArrayNames;
        int i10;
        this.f20007c = true;
        try {
            int i11 = message.what;
            if (i11 == 298) {
                if (message.arg1 == 1) {
                    M();
                }
                if (!this.f20004b.hasMessages(299)) {
                    context = this.f20003a;
                    int i12 = y3.d.f20693e;
                    if (TextUtils.isEmpty(m0.a.a(context).i("first_init")) || !s3.g.K) {
                        Handler handler = this.f20004b;
                        handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 299));
                    } else {
                        y3.b.c("First init delay %d s upload!", Integer.valueOf(k6.g.f9117t));
                        this.f20004b.sendEmptyMessageDelayed(299, ((long) k6.g.f9117t) * 1000);
                        m0.a.a(this.f20003a).g("first_init", "false");
                    }
                }
            } else if (i11 == 299) {
                N();
            } else if (i11 == 302) {
                t3.a aVar = (t3.a) message.obj;
                TrackData trackDataF = aVar.f();
                try {
                    if (!aVar.b().equals("page_enter") || y3.e.o() == null) {
                        try {
                            jSONObjectA = trackDataF.a();
                            String str = s3.g.f14975h;
                            if (jSONObjectA.has("_eparam")) {
                                jSONObject = jSONObjectA.get("_eparam");
                                if ((jSONObject instanceof JSONArray) || jSONObjectA.length() <= 1) {
                                    jSONObjectA.remove("_eparam");
                                } else {
                                    jSONObject = new JSONObject();
                                }
                            } else {
                                jSONObject = new JSONObject();
                            }
                            if ((jSONObject instanceof JSONObject) && jSONObjectA.length() > 0) {
                                jSONArrayNames = jSONObjectA.names();
                                for (i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                                    String string = jSONArrayNames.getString(i10);
                                    ((JSONObject) jSONObject).put(string, jSONObjectA.get(string));
                                    jSONObjectA.remove(string);
                                }
                            }
                            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                            jSONObjectA.put("_eparam", jSONObject);
                            jSONObjectA.put("net", y3.f.a(this.f20003a));
                            jSONObjectA.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
                            aVar.l(jSONObjectA);
                            aVar.m(jSONObject2);
                            aVar.q(trackDataF.t());
                        } catch (JSONException e10) {
                            y3.b.e("Record track exception : %s", e10.getMessage());
                        }
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (Math.abs(jCurrentTimeMillis - this.f20017m) > 3600000) {
                            this.f20017m = jCurrentTimeMillis;
                            this.f20016l = y3.f.d(this.f20003a);
                        }
                        this.f20011g--;
                        if (this.f20016l && this.f20018n && s3.g.R && !k6.g.w0()) {
                            s3.f fVarN = n3.b.l().n(y3.d.a(aVar.e()));
                            if (fVarN == null || !fVarN.e()) {
                                if (!"ev_athena".equals(aVar.b())) {
                                    M();
                                }
                                A(aVar);
                            } else {
                                I(aVar);
                            }
                        } else {
                            if (!"ev_athena".equals(aVar.b())) {
                                M();
                            }
                            A(aVar);
                        }
                        if (!this.f20016l && !this.f20018n && s3.g.R && s3.g.f14988u) {
                            this.f20019o++;
                            if (L()) {
                                j10 = this.f20019o;
                                j11 = 20;
                                if (j10 % j11 == 0 && j10 / j11 <= 3 && y3.d.j(this.f20003a)) {
                                    K();
                                }
                            }
                        }
                    } else {
                        trackDataF.e("fromsite", y3.e.a(y3.e.o()));
                        jSONObjectA = trackDataF.a();
                        String str2 = s3.g.f14975h;
                        if (jSONObjectA.has("_eparam")) {
                            jSONObject = jSONObjectA.get("_eparam");
                            if (jSONObject instanceof JSONArray) {
                                jSONObjectA.remove("_eparam");
                            } else {
                                jSONObjectA.remove("_eparam");
                            }
                        } else {
                            jSONObject = new JSONObject();
                        }
                        if (jSONObject instanceof JSONObject) {
                            jSONArrayNames = jSONObjectA.names();
                            while (i10 < jSONArrayNames.length()) {
                                String string2 = jSONArrayNames.getString(i10);
                                ((JSONObject) jSONObject).put(string2, jSONObjectA.get(string2));
                                jSONObjectA.remove(string2);
                            }
                        }
                        JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                        jSONObjectA.put("_eparam", jSONObject);
                        jSONObjectA.put("net", y3.f.a(this.f20003a));
                        jSONObjectA.put(NotificationCompat.CATEGORY_EVENT, aVar.b());
                        aVar.l(jSONObjectA);
                        aVar.m(jSONObject3);
                        aVar.q(trackDataF.t());
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (Math.abs(jCurrentTimeMillis - this.f20017m) > 3600000) {
                            this.f20017m = jCurrentTimeMillis;
                            this.f20016l = y3.f.d(this.f20003a);
                        }
                        this.f20011g--;
                        if (this.f20016l) {
                            if (!"ev_athena".equals(aVar.b())) {
                                M();
                            }
                            A(aVar);
                        } else {
                            if (!"ev_athena".equals(aVar.b())) {
                                M();
                            }
                            A(aVar);
                        }
                        if (!this.f20016l) {
                            this.f20019o++;
                            if (L()) {
                                j10 = this.f20019o;
                                j11 = 20;
                                if (j10 % j11 == 0) {
                                    K();
                                }
                            }
                        }
                    }
                } catch (Exception e11) {
                    y3.b.d(Log.getStackTraceString(e11));
                }
            } else if (i11 == 303) {
                y3.b.f20688a.f3600m.w(s3.g.N());
                y3.b.g("Athena init, SDK Version is [%s]", "3.1.1.1-sys");
                O();
                M();
            } else if (i11 == 308) {
                try {
                    n3.b.l().v();
                    if (u3.a.e(this.f20003a) != null) {
                        u3.a.e(this.f20003a).f();
                    }
                } catch (Exception e12) {
                    w("handleCleanupData", e12);
                }
            } else if (i11 == 400) {
                q(message.arg1, (String) message.obj);
            } else if (i11 == 503) {
                if (m3.a.f().e(((Long) message.obj).longValue())) {
                    String strB = m3.a.f().b();
                    long jG = m3.a.f().g();
                    if (jG > 0 && !TextUtils.isEmpty(strB)) {
                        u3.a.e(this.f20003a).i(strB, jG);
                    }
                }
                G(false, this.f20009e);
            } else if (i11 == 600) {
                if (message.arg1 == 1) {
                    M();
                }
                if (!this.f20004b.hasMessages(299)) {
                    context = this.f20003a;
                    int i13 = y3.d.f20693e;
                    if (TextUtils.isEmpty(m0.a.a(context).i("first_init"))) {
                        Handler handler2 = this.f20004b;
                        handler2.sendMessageAtFrontOfQueue(Message.obtain(handler2, 299));
                    } else {
                        Handler handler3 = this.f20004b;
                        handler3.sendMessageAtFrontOfQueue(Message.obtain(handler3, 299));
                    }
                }
            }
        } catch (Exception e13) {
            if (y3.d.g()) {
                y3.b.e("Worker handle message exception : %s", e13.getMessage());
            }
            w("handleMessage", e13);
        }
        this.f20007c = false;
        return false;
    }

    @Override // x3.c
    public void i() {
        G(true, this.f20009e);
    }

    public final t3.a o(TrackDataWrapper trackDataWrapper) {
        Object jSONObject;
        t3.a aVar = new t3.a();
        aVar.f15446a = trackDataWrapper.a();
        aVar.f15449d = trackDataWrapper.b();
        aVar.f15451f = System.currentTimeMillis();
        aVar.f15452g = SystemClock.elapsedRealtime();
        TrackData trackDataC = trackDataWrapper.c();
        try {
            JSONObject jSONObjectA = trackDataC.a();
            String str = s3.g.f14975h;
            if (jSONObjectA.has("_eparam")) {
                jSONObject = jSONObjectA.get("_eparam");
                if (!(jSONObject instanceof JSONArray) || jSONObjectA.length() <= 1) {
                    jSONObjectA.remove("_eparam");
                } else {
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = new JSONObject();
            }
            if ((jSONObject instanceof JSONObject) && jSONObjectA.length() > 0) {
                JSONArray jSONArrayNames = jSONObjectA.names();
                for (int i10 = 0; i10 < jSONArrayNames.length(); i10++) {
                    String string = jSONArrayNames.getString(i10);
                    ((JSONObject) jSONObject).put(string, jSONObjectA.get(string));
                    jSONObjectA.remove(string);
                }
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            jSONObjectA.put("_eparam", jSONObject);
            jSONObjectA.put("net", y3.f.a(this.f20003a));
            jSONObjectA.put(NotificationCompat.CATEGORY_EVENT, aVar.f15446a);
            aVar.f15447b = jSONObjectA;
            aVar.f15448c = jSONObject2;
            aVar.f15450e = trackDataC.t();
            s3.a aVarD = n3.b.l().d((int) aVar.f15449d, aVar.f15446a);
            if (aVarD != null) {
                aVar.f15449d = aVarD.e();
            }
        } catch (JSONException e10) {
            y3.b.e("Convert to Track exception : %s", e10.getMessage());
        }
        return aVar;
    }

    public final void r(int i10, boolean z10) {
        s3.f fVarN = n3.b.l().n(i10);
        if (fVarN != null) {
            y3.b.c("handleTidChange appconf : %s", fVarN.B());
            u3.a.e(this.f20003a).o(fVarN, z10);
            String strW = fVarN.w();
            if (!TextUtils.isEmpty(strW)) {
                if (l6.c.m(strW)) {
                    v(strW, i10, fVarN, this.f20015k);
                } else {
                    l6.c.l(this.f20003a, new String[]{strW}, new c(strW, i10, fVarN));
                }
                l6.c.f(strW, new f());
            }
            String strK = fVarN.k();
            if (!TextUtils.isEmpty(strK)) {
                l6.c.l(this.f20003a, new String[]{strK}, new a());
                l6.c.f(strK, null);
            }
        }
        if (z10) {
            List<s3.a> listY = fVarN.y();
            if (s3.e.j(listY)) {
                y3.b.g("%s", "handleTidChange tid config is null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (s3.a aVar : listY) {
                if (aVar.f().w() == -1) {
                    arrayList.add(Long.valueOf(aVar.e()));
                }
            }
            if (!arrayList.isEmpty()) {
                try {
                    u3.a.e(this.f20003a).n(arrayList, this.f20008d, new x3.g());
                } catch (Exception e10) {
                    y3.b.e("Handle tid change exception : %s", e10.getMessage());
                    w("handleTidChange", e10);
                }
            }
            if (k6.g.g0() != null) {
                k6.g.f9109l.a(n3.b.l().p(-1));
            }
            if (t3.d.d() == i10) {
                s3.g.A(n3.b.l().a(i10, "page_view", 1.0f) == 0);
            }
        }
    }

    public final void t(MMKV mmkv) {
        try {
            String[] strArrAllKeys = mmkv.allKeys();
            if (strArrAllKeys != null && strArrAllKeys.length >= 1) {
                ArrayList arrayList = new ArrayList();
                String[] strArr = new String[100];
                for (int i10 = 0; i10 < strArrAllKeys.length; i10++) {
                    TrackDataWrapper trackDataWrapper = (TrackDataWrapper) mmkv.decodeParcelable(strArrAllKeys[i10], TrackDataWrapper.class);
                    if (trackDataWrapper != null && arrayList.size() < 100) {
                        arrayList.add(o(trackDataWrapper));
                        strArr[i10] = strArrAllKeys[i10];
                    }
                }
                if (!arrayList.isEmpty()) {
                    x(arrayList);
                    mmkv.removeValuesForKeys(strArr);
                }
                if (mmkv.allKeys() == null || mmkv.allKeys().length <= 0) {
                    return;
                }
                t(mmkv);
            }
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public final void v(String str, int i10, s3.f fVar, String str2) {
        String strD = TextUtils.isEmpty(str) ? l6.c.d(s3.g.L(), true) : l6.c.d(s3.g.l(str), true);
        Bundle bundle = new Bundle();
        bundle.putInt("app_id", i10);
        bundle.putString(RtspHeaders.Values.URL, strD);
        bundle.putLong("ver", fVar.z());
        bundle.putString("gslb_data", str2);
        new a4.a("app_cfg_log", 9999).m(bundle, null).k();
    }

    public final void w(String str, Throwable th2) {
        l.f9150b.c(new i(str, th2));
    }

    public final void x(final List<t3.a> list) {
        ArrayList<t3.a> arrayList = new ArrayList<>();
        for (t3.a aVar : list) {
            if (n3.b.l().b(aVar.e(), aVar.f().r()) == 0) {
                m3.a.f().c(aVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0) {
            int iB = u3.a.e(this.f20003a).b(arrayList, new u3.d() { // from class: x3.f
                @Override // u3.d
                public final void a(Object obj) {
                    h.y(list, (LongSparseArray) obj);
                }
            });
            y3.b.f("saveMemCacheToDb Count = " + iB);
            if (iB == -2) {
                y3.b.d("saveToDB out of memory cleanCount = " + u3.a.e(this.f20003a).a(1000, new g()));
            }
            G(false, this.f20009e);
        }
    }

    public final void z(JSONObject jSONObject, String str, Object obj) throws JSONException {
        try {
            jSONObject.getString(str);
        } catch (JSONException unused) {
            jSONObject.put(str, obj);
        }
    }
}
