package com.transsion.sdk.oneid;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.sdk.oneid.data.AppIdInfo;
import com.transsion.sdk.oneid.data.GroupFpInfo;
import com.transsion.sdk.oneid.data.GroupHashInfo;
import com.transsion.sdk.oneid.data.IdChangeInfo;
import com.transsion.sdk.oneid.data.OdIdInfo;
import com.transsion.sdk.oneid.data.UniqueIdInfo;
import dr.g;
import dr.h;
import dr.i;
import dr.j;
import dr.l;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import ki.d;
import ki.e;
import l6.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Handler.Callback {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile a f2283n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f2284a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GroupFpInfo f2286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GroupHashInfo f2287d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f2290g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f2293j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OdIdInfo f2294k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConcurrentHashMap<Integer, AppIdInfo> f2295l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f2285b = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2288e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2289f = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReentrantLock f2292i = new ReentrantLock();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicBoolean f2296m = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<IdChangeInfo> f2291h = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: com.transsion.sdk.oneid.a$a, reason: collision with other inner class name */
    public class C0077a extends c2.a<ConcurrentHashMap<Integer, AppIdInfo>> {
        public C0077a(a aVar) {
        }
    }

    public class b extends c2.a<ConcurrentHashMap<Integer, AppIdInfo>> {
        public b(a aVar) {
        }
    }

    public a(Context context) {
        this.f2293j = context;
        m();
        Handler handler = this.f2284a;
        if (handler != null) {
            handler.sendEmptyMessage(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        }
    }

    public static a a(Context context) {
        if (f2283n == null) {
            synchronized (a.class) {
                try {
                    if (f2283n == null) {
                        f2283n = new a(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f2283n;
    }

    public String b() {
        try {
            GroupFpInfo groupFpInfo = this.f2286c;
            return groupFpInfo != null ? groupFpInfo.dids.oaid : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public void c(int i10) {
        d.i("Check appId record : " + i10);
        HandlerThread handlerThread = this.f2285b;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        Message messageObtain = Message.obtain(this.f2284a, 304);
        messageObtain.obj = Integer.valueOf(i10);
        if (this.f2296m.get()) {
            this.f2284a.sendMessage(messageObtain);
        } else {
            this.f2284a.sendMessageDelayed(messageObtain, ((long) ki.a.f9178d) * 1000);
        }
    }

    public final void d(int i10, AppIdInfo appIdInfo) {
        if (d.q(this.f2293j)) {
            d.i("onOdidRequestRetry");
            appIdInfo.retryTimes++;
            long j10 = appIdInfo.retryRequestDelay;
            if (j10 == 0) {
                appIdInfo.retryRequestDelay = r4.a.O;
            } else {
                appIdInfo.retryRequestDelay = Math.min((j10 * 2) + 1000, 600000L);
            }
            Message messageObtain = Message.obtain(this.f2284a, 303);
            messageObtain.obj = appIdInfo;
            messageObtain.arg1 = i10;
            this.f2284a.sendMessageDelayed(messageObtain, appIdInfo.retryRequestDelay);
        }
    }

    public final void e(Message message) {
        if (d.q(this.f2293j)) {
            long j10 = this.f2288e;
            if (j10 == 0) {
                this.f2288e = r4.a.O;
            } else {
                this.f2288e = Math.min((j10 * 2) + 1000, 600000L);
            }
            this.f2284a.sendMessageDelayed(message, this.f2288e);
        }
    }

    public void f(IdChangeInfo idChangeInfo) {
        IdChangeInfo next;
        d.i("onFpIdChanged type = " + idChangeInfo.id_type);
        List<IdChangeInfo> list = this.f2291h;
        if (list != null) {
            Iterator<IdChangeInfo> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.id_type.equals(idChangeInfo.id_type));
            if (next != null) {
                this.f2291h.remove(next);
            }
            this.f2291h.add(idChangeInfo);
        }
    }

    public final void g(String str) {
        d.i("onFpPostComplete");
        this.f2289f = System.currentTimeMillis();
        try {
            dr.b bVarB = dr.b.b(this.f2293j);
            bVarB.c("last_post_time", Long.valueOf(this.f2289f / 1000).intValue());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            bVarB.d("fp_hash", str);
        } catch (Exception e10) {
            d.m(Log.getStackTraceString(e10));
        }
    }

    public final void h(String str, int i10, AppIdInfo appIdInfo) {
        d.i("onOdidRequestComplete appId : " + i10);
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optInt("code", 0);
            String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
            long jOptLong = jSONObject.optLong(RtspHeaders.Values.TIME, 0L);
            appIdInfo.odid = jSONObject.optString("odid", "");
            appIdInfo.retryTimes = 0;
            appIdInfo.retryRequestDelay = 0L;
            appIdInfo.lastRequestTime = System.currentTimeMillis();
            long j10 = jOptLong * 1000;
            appIdInfo.waitTime = j10;
            appIdInfo.msg = strOptString;
            dr.b bVarB = dr.b.b(this.f2293j);
            String json = new v1.e().toJson(this.f2295l, new b().getType());
            d.i("appIdInfoListJson : " + json);
            bVarB.g("appid_info_list", json);
            Message messageObtain = Message.obtain(this.f2284a, 303);
            messageObtain.obj = appIdInfo;
            messageObtain.arg1 = i10;
            this.f2284a.sendMessageDelayed(messageObtain, j10);
        } catch (Exception e10) {
            d.m(Log.getStackTraceString(e10));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        GroupFpInfo groupFpInfo;
        int i10;
        long j10;
        String strF;
        try {
            int i11 = message.what;
            if (i11 == 100) {
                d.i("-->WHAT_GET_PROP_RET");
                String string = message.getData().getString("oneid");
                if (TextUtils.isEmpty(string) || TextUtils.equals(string, "UNKNOWN") || (groupFpInfo = this.f2286c) == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(groupFpInfo.dids.tsid)) {
                    if (TextUtils.equals(this.f2286c.dids.tsid, string)) {
                        return false;
                    }
                    f(new IdChangeInfo("tsid", this.f2286c.dids.tsid, string));
                    UniqueIdInfo uniqueIdInfo = this.f2286c.dids;
                    uniqueIdInfo.tsid = string;
                    this.f2287d.updateDidsHash(uniqueIdInfo);
                    this.f2294k.tsid = string;
                    return false;
                }
                UniqueIdInfo uniqueIdInfo2 = this.f2286c.dids;
                uniqueIdInfo2.tsid = string;
                this.f2287d.updateDidsHash(uniqueIdInfo2);
                this.f2294k.tsid = string;
                dr.b bVarB = dr.b.b(this.f2293j);
                int iIntValue = Long.valueOf(System.currentTimeMillis() / 1000).intValue();
                try {
                    bVarB.d("oneid", string);
                    bVarB.c("oneid_time", iIntValue);
                    return false;
                } catch (Exception e10) {
                    d.m(Log.getStackTraceString(e10));
                    return false;
                }
            }
            if (i11 == 200) {
                d.o();
                if (TextUtils.isEmpty(dr.b.b(this.f2293j).h("one_id_first_launch")) && ki.a.f9178d > 0) {
                    d.i("First launch delay " + ki.a.f9178d + " sec init");
                    try {
                        Thread.sleep(((long) ki.a.f9178d) * 1000);
                    } catch (InterruptedException unused) {
                    }
                    dr.b.b(this.f2293j).g("one_id_first_launch", String.valueOf(System.currentTimeMillis()));
                }
                d.i("-->WHAT_INIT 2.0.2.1");
                String string2 = this.f2293j.getResources().getString(R.string.oneid_process_name);
                if (TextUtils.isEmpty(string2)) {
                    string2 = this.f2293j.getPackageName();
                }
                if (!TextUtils.equals(string2, d.k(this.f2293j))) {
                    d.i("Only works in the main process");
                    this.f2284a.sendEmptyMessageDelayed(201, 1000L);
                    return false;
                }
                try {
                    if (this.f2290g == null) {
                        this.f2290g = new e();
                        this.f2293j.registerReceiver(this.f2290g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, this.f2284a);
                    }
                } catch (Exception e11) {
                    d.m(Log.getStackTraceString(e11));
                }
                c.l(this.f2293j, new String[]{"ire-oneid.shalltry.com", "oneid-dev-sg.shalltry.com"}, null);
                GroupFpInfo groupFpInfo2 = new GroupFpInfo(this.f2293j, this);
                this.f2286c = groupFpInfo2;
                this.f2287d = new GroupHashInfo(groupFpInfo2);
                this.f2294k = new OdIdInfo(this.f2286c);
                d.i("--> new OdidInfo " + this.f2294k);
                if (this.f2289f == 0) {
                    this.f2289f = ((long) dr.b.b(this.f2293j).a("last_post_time")) * 1000;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j11 = this.f2289f;
                if (jCurrentTimeMillis >= j11 && jCurrentTimeMillis - j11 < 86400000) {
                    d.i("Post time not yet reached");
                } else if (!this.f2284a.hasMessages(300)) {
                    Handler handler = this.f2284a;
                    if (c.m(l.e().d())) {
                        i10 = 300;
                        j10 = r4.a.O;
                    } else {
                        i10 = 300;
                        j10 = 6000;
                    }
                    handler.sendEmptyMessageDelayed(i10, j10);
                }
                this.f2296m.set(true);
                return false;
            }
            if (i11 == 201) {
                d.i("-->WHAT_QUIT");
                if (!this.f2292i.tryLock()) {
                    return false;
                }
                try {
                    HandlerThread handlerThread = this.f2285b;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.f2285b = null;
                    }
                    return false;
                } finally {
                    this.f2292i.unlock();
                }
            }
            switch (i11) {
                case 300:
                    d.i("-->WHAT_POST_FP_HASH");
                    this.f2284a.removeMessages(300);
                    if (ki.a.f9177c && d.p(this.f2293j)) {
                        if (!c.m(l.e().d())) {
                            d.i("GslbSdk new domain is not ready");
                            e(Message.obtain(this.f2284a, 300));
                            return false;
                        }
                        try {
                            strF = dr.b.b(this.f2293j).f("fp_hash");
                            break;
                        } catch (Exception unused2) {
                            strF = "";
                        }
                        String strG = d.g(this.f2287d.toString());
                        d.i(strF + " vs " + strG);
                        if (TextUtils.equals(strF, strG)) {
                            g(null);
                            return false;
                        }
                        Message.obtain(this.f2284a, 301, strG).sendToTarget();
                        return false;
                    }
                    d.i("OneID disable or network unavailable");
                    this.f2288e = 0L;
                    this.f2284a.sendEmptyMessage(201);
                    return false;
                case 301:
                    d.i("-->WHAT_POST_FP_DATA");
                    this.f2284a.removeMessages(301);
                    if (ki.a.f9177c && d.p(this.f2293j)) {
                        String str = (String) message.obj;
                        i<String> iVarA = new g(this.f2286c).a();
                        d.i("code = " + iVarA.f3850a + " data = " + iVarA.f3851b);
                        int i12 = iVarA.f3850a;
                        if (i12 != 0) {
                            if (i12 == 4) {
                                return false;
                            }
                            e(Message.obtain(this.f2284a, 301, str));
                            return false;
                        }
                        this.f2288e = 0L;
                        try {
                            if (new JSONObject(iVarA.f3851b).optInt("code", 0) == 0) {
                                if (this.f2291h.isEmpty()) {
                                    g(str);
                                } else {
                                    Message.obtain(this.f2284a, 302, str).sendToTarget();
                                }
                            }
                            return false;
                        } catch (Exception e12) {
                            d.m(Log.getStackTraceString(e12));
                            return false;
                        }
                    }
                    d.i("OneID disable or network unavailable");
                    this.f2288e = 0L;
                    this.f2284a.sendEmptyMessage(201);
                    return false;
                case 302:
                    d.i("-->WHAT_POST_ID_CHANGE");
                    this.f2284a.removeMessages(302);
                    String str2 = (String) message.obj;
                    ArrayList arrayList = new ArrayList();
                    for (IdChangeInfo idChangeInfo : this.f2291h) {
                        if (!TextUtils.isEmpty(idChangeInfo.pre_id)) {
                            arrayList.add(idChangeInfo);
                        }
                    }
                    if (arrayList.size() <= 0) {
                        if (this.f2291h.size() > 0) {
                            d.h(this.f2293j, this.f2291h);
                            this.f2291h.clear();
                        }
                        g(str2);
                        return false;
                    }
                    try {
                        i<String> iVarA2 = new h(arrayList).a();
                        d.i("code = " + iVarA2.f3850a + " data = " + iVarA2.f3851b);
                        int i13 = iVarA2.f3850a;
                        if (i13 == 0) {
                            this.f2288e = 0L;
                            try {
                                if (new JSONObject(iVarA2.f3851b).optInt("code", 0) == 0) {
                                    d.h(this.f2293j, this.f2291h);
                                    this.f2291h.clear();
                                    g(str2);
                                }
                            } catch (Exception e13) {
                                d.m(Log.getStackTraceString(e13));
                            }
                            break;
                        } else if (i13 != 4) {
                            e(Message.obtain(this.f2284a, 302, str2));
                        }
                        return false;
                    } catch (Exception e14) {
                        d.m(Log.getStackTraceString(e14));
                        return false;
                    }
                case 303:
                    d.i("-->WHAT_REQUEST_ODID");
                    int i14 = message.arg1;
                    AppIdInfo appIdInfo = (AppIdInfo) message.obj;
                    this.f2284a.removeMessages(303, appIdInfo);
                    if (ki.a.f9177c && d.p(this.f2293j)) {
                        OdIdInfo odIdInfo = this.f2294k;
                        if (odIdInfo == null) {
                            return false;
                        }
                        odIdInfo.appid = i14;
                        d.i("--> mOdidInfo set appID :" + this.f2294k.toString());
                        i<String> iVarA3 = new j(this.f2294k).a();
                        d.i("code = " + iVarA3.f3850a + " data = " + iVarA3.f3851b);
                        int i15 = iVarA3.f3850a;
                        if (i15 == 0) {
                            h(iVarA3.f3851b, i14, appIdInfo);
                            return false;
                        }
                        if (i15 != 3) {
                            if (i15 == 4) {
                                return false;
                            }
                            d(i14, appIdInfo);
                            return false;
                        }
                        d.i("onOdidRequestGatewayError");
                        Message messageObtain = Message.obtain(this.f2284a, 303);
                        messageObtain.obj = appIdInfo;
                        messageObtain.arg1 = i14;
                        this.f2284a.sendMessageDelayed(messageObtain, 1000L);
                        return false;
                    }
                    d.i("OneID disable or network unavailable");
                    this.f2284a.sendEmptyMessage(201);
                    return false;
                case 304:
                    Integer num = (Integer) message.obj;
                    int iIntValue2 = num.intValue();
                    this.f2284a.removeMessages(304, num);
                    if (ki.a.f9177c && d.p(this.f2293j)) {
                        n();
                        AppIdInfo appIdInfo2 = this.f2295l.get(num);
                        if (appIdInfo2 == null) {
                            appIdInfo2 = new AppIdInfo();
                            this.f2295l.put(num, appIdInfo2);
                            OdIdInfo odIdInfo2 = this.f2294k;
                            if (odIdInfo2 != null) {
                                odIdInfo2.appid = iIntValue2;
                            }
                        }
                        Message messageObtain2 = Message.obtain(this.f2284a, 303);
                        messageObtain2.arg1 = iIntValue2;
                        messageObtain2.obj = appIdInfo2;
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        long jMax = c.m(l.e().d()) ? r4.a.O : 6000L;
                        long j12 = appIdInfo2.lastRequestTime;
                        if (jCurrentTimeMillis2 >= j12) {
                            long j13 = jCurrentTimeMillis2 - j12;
                            long j14 = appIdInfo2.waitTime;
                            if (j13 < j14) {
                                jMax = Math.max((j12 + j14) - jCurrentTimeMillis2, jMax);
                            }
                        }
                        if (this.f2284a.hasMessages(303, appIdInfo2)) {
                            return false;
                        }
                        this.f2284a.sendMessageDelayed(messageObtain2, jMax);
                        d.i("Appid : " + iIntValue2 + " delay " + jMax + " ms refresh odid ");
                        return false;
                    }
                    d.i("OneID disable or network unavailable");
                    this.f2284a.sendEmptyMessage(201);
                    return false;
                default:
                    return false;
            }
        } catch (Exception e15) {
            d.m(Log.getStackTraceString(e15));
            return false;
        }
        d.m(Log.getStackTraceString(e15));
        return false;
    }

    public void i(String str, String str2) {
        try {
            GroupFpInfo groupFpInfo = this.f2286c;
            if (groupFpInfo != null) {
                groupFpInfo.user.setAccount(str, str2);
                dr.b.b(this.f2293j).d(cb.b.c.f1409p, new v1.e().toJson(this.f2286c.user));
            }
        } catch (Exception e10) {
            d.m(Log.getStackTraceString(e10));
        }
    }

    public String j() {
        try {
            GroupFpInfo groupFpInfo = this.f2286c;
            return groupFpInfo != null ? groupFpInfo.vaid : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public String k(int i10) {
        AppIdInfo appIdInfo;
        String str;
        ConcurrentHashMap<Integer, AppIdInfo> concurrentHashMap = this.f2295l;
        return (concurrentHashMap == null || (appIdInfo = concurrentHashMap.get(Integer.valueOf(i10))) == null || (str = appIdInfo.odid) == null) ? "" : str;
    }

    public void l(String str, String str2) {
        try {
            GroupFpInfo groupFpInfo = this.f2286c;
            if (groupFpInfo != null) {
                groupFpInfo.user.setTripartite(str, str2);
                dr.b.b(this.f2293j).d(cb.b.c.f1409p, new v1.e().toJson(this.f2286c.user));
            }
        } catch (Exception e10) {
            d.m(Log.getStackTraceString(e10));
        }
    }

    public final void m() {
        if (this.f2292i.tryLock()) {
            try {
                try {
                    Handler handler = this.f2284a;
                    if (handler == null || this.f2285b == null) {
                        HandlerThread handlerThread = new HandlerThread("OneID Worker", 10);
                        this.f2285b = handlerThread;
                        handlerThread.start();
                        this.f2284a = new Handler(this.f2285b.getLooper(), this);
                    } else if (handler.hasMessages(201)) {
                        this.f2284a.removeMessages(201);
                    }
                } catch (Exception e10) {
                    d.m(Log.getStackTraceString(e10));
                }
            } finally {
                this.f2292i.unlock();
            }
        }
    }

    public final void n() {
        ConcurrentHashMap<Integer, AppIdInfo> concurrentHashMap = this.f2295l;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            String strH = dr.b.b(this.f2293j).h("appid_info_list");
            if (!TextUtils.isEmpty(strH)) {
                d.i("AppId Records : " + strH);
                try {
                    this.f2295l = (ConcurrentHashMap) new v1.e().fromJson(strH, new C0077a().getType());
                } catch (Exception e10) {
                    d.m(Log.getStackTraceString(e10));
                }
            }
            if (this.f2295l == null) {
                this.f2295l = new ConcurrentHashMap<>();
            }
        }
    }

    public void o() {
        if (d.q(this.f2293j)) {
            d.i("retry");
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z10 = ki.a.f9177c;
            if (z10) {
                long j10 = this.f2289f;
                if (jCurrentTimeMillis < j10 || jCurrentTimeMillis - j10 >= 86400000) {
                    if (this.f2292i.tryLock()) {
                        try {
                            if (this.f2285b == null) {
                                m();
                            }
                            this.f2292i.unlock();
                        } catch (Throwable th2) {
                            this.f2292i.unlock();
                            throw th2;
                        }
                    }
                    Handler handler = this.f2284a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        this.f2284a.sendEmptyMessage(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                        return;
                    }
                    return;
                }
            }
            d.i(z10 ? "Post time not yet reached" : "OneID disable");
        }
    }
}
