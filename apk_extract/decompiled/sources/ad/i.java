package ad;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.sdk.oneid.R$string;
import com.transsion.sdk.oneid.data.AppIdInfo;
import com.transsion.sdk.oneid.data.GroupFpInfo;
import com.transsion.sdk.oneid.data.GroupHashInfo;
import com.transsion.sdk.oneid.data.IdChangeInfo;
import com.transsion.sdk.oneid.data.OdIdInfo;
import com.transsion.sdk.oneid.data.UniqueIdInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Handler.Callback {
    public static volatile i p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f103a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GroupFpInfo f105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GroupHashInfo f106d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f108i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f111l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OdIdInfo f112m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConcurrentHashMap f113n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f104b = null;
    public long e = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f107h = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ReentrantLock f110k = new ReentrantLock();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f114o = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f109j = new CopyOnWriteArrayList();

    public i(Context context) {
        this.f111l = context;
        g();
        Handler handler = this.f103a;
        if (handler != null) {
            handler.sendEmptyMessage(200);
        }
    }

    public static i a(Context context) {
        if (p == null) {
            synchronized (i.class) {
                try {
                    if (p == null) {
                        p = new i(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return p;
    }

    public final void b(int i8, AppIdInfo appIdInfo) {
        if (c.j(this.f111l)) {
            c.g("onOdidRequestRetry");
            appIdInfo.retryTimes++;
            long j8 = appIdInfo.retryRequestDelay;
            if (j8 == 0) {
                appIdInfo.retryRequestDelay = 3000L;
            } else {
                appIdInfo.retryRequestDelay = Math.min((j8 * 2) + 1000, 600000L);
            }
            Message messageObtain = Message.obtain(this.f103a, 303);
            messageObtain.obj = appIdInfo;
            messageObtain.arg1 = i8;
            this.f103a.sendMessageDelayed(messageObtain, appIdInfo.retryRequestDelay);
        }
    }

    public final void c(Message message) {
        if (c.j(this.f111l)) {
            long j8 = this.e;
            if (j8 == 0) {
                this.e = 3000L;
            } else {
                this.e = Math.min((j8 * 2) + 1000, 600000L);
            }
            this.f103a.sendMessageDelayed(message, this.e);
        }
    }

    public final void d(IdChangeInfo idChangeInfo) {
        IdChangeInfo idChangeInfo2;
        c.g("onFpIdChanged type = " + idChangeInfo.id_type);
        CopyOnWriteArrayList copyOnWriteArrayList = this.f109j;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            do {
                if (!it.hasNext()) {
                    idChangeInfo2 = null;
                    break;
                }
                idChangeInfo2 = (IdChangeInfo) it.next();
            } while (!idChangeInfo2.id_type.equals(idChangeInfo.id_type));
            if (idChangeInfo2 != null) {
                copyOnWriteArrayList.remove(idChangeInfo2);
            }
            copyOnWriteArrayList.add(idChangeInfo);
        }
    }

    public final void e(String str) {
        c.g("onFpPostComplete");
        this.f107h = System.currentTimeMillis();
        try {
            sj.a aVarA = sj.a.a(this.f111l);
            aVarA.b(Long.valueOf(this.f107h / 1000).intValue(), "last_post_time");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            aVarA.c("fp_hash", str);
        } catch (Exception e) {
            c.h(Log.getStackTraceString(e));
        }
    }

    public final void f(String str, int i8, AppIdInfo appIdInfo) {
        c.g("onOdidRequestComplete appId : " + i8);
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optInt("code", 0);
            String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
            long jOptLong = jSONObject.optLong("time", 0L);
            appIdInfo.odid = jSONObject.optString("odid", "");
            appIdInfo.retryTimes = 0;
            appIdInfo.retryRequestDelay = 0L;
            appIdInfo.lastRequestTime = System.currentTimeMillis();
            long j8 = jOptLong * 1000;
            appIdInfo.waitTime = j8;
            appIdInfo.msg = strOptString;
            sj.a aVarA = sj.a.a(this.f111l);
            String json = new q().toJson(this.f113n, new h().getType());
            c.g("appIdInfoListJson : " + json);
            aVarA.f("appid_info_list", json);
            Message messageObtain = Message.obtain(this.f103a, 303);
            messageObtain.obj = appIdInfo;
            messageObtain.arg1 = i8;
            this.f103a.sendMessageDelayed(messageObtain, j8);
        } catch (Exception e) {
            c.h(Log.getStackTraceString(e));
        }
    }

    public final void g() {
        ReentrantLock reentrantLock = this.f110k;
        if (reentrantLock.tryLock()) {
            try {
                try {
                    Handler handler = this.f103a;
                    if (handler == null || this.f104b == null) {
                        HandlerThread handlerThread = new HandlerThread("OneID Worker", 10);
                        this.f104b = handlerThread;
                        handlerThread.start();
                        this.f103a = new Handler(this.f104b.getLooper(), this);
                    } else if (handler.hasMessages(l5.a.CODE_SCANNER_CANCELLED)) {
                        this.f103a.removeMessages(l5.a.CODE_SCANNER_CANCELLED);
                    }
                } catch (Exception e) {
                    c.h(Log.getStackTraceString(e));
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void h() {
        ConcurrentHashMap concurrentHashMap = this.f113n;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            String strG = sj.a.a(this.f111l).g("appid_info_list");
            if (!TextUtils.isEmpty(strG)) {
                c.g("AppId Records : " + strG);
                try {
                    this.f113n = (ConcurrentHashMap) new q().fromJson(strG, new g().getType());
                } catch (Exception e) {
                    c.h(Log.getStackTraceString(e));
                }
            }
            if (this.f113n == null) {
                this.f113n = new ConcurrentHashMap();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        GroupFpInfo groupFpInfo;
        String packageName;
        String strE;
        try {
            int i8 = message.what;
            Context context = this.f111l;
            if (i8 == 100) {
                c.g("-->WHAT_GET_PROP_RET");
                String string = message.getData().getString("oneid");
                if (!TextUtils.isEmpty(string) && !TextUtils.equals(string, "UNKNOWN") && (groupFpInfo = this.f105c) != null) {
                    if (TextUtils.isEmpty(groupFpInfo.dids.tsid)) {
                        UniqueIdInfo uniqueIdInfo = this.f105c.dids;
                        uniqueIdInfo.tsid = string;
                        this.f106d.updateDidsHash(uniqueIdInfo);
                        this.f112m.tsid = string;
                        sj.a aVarA = sj.a.a(context);
                        int iIntValue = Long.valueOf(System.currentTimeMillis() / 1000).intValue();
                        try {
                            aVarA.c("oneid", string);
                            aVarA.b(iIntValue, "oneid_time");
                        } catch (Exception e) {
                            c.h(Log.getStackTraceString(e));
                        }
                    } else if (!TextUtils.equals(this.f105c.dids.tsid, string)) {
                        d(new IdChangeInfo("tsid", this.f105c.dids.tsid, string));
                        UniqueIdInfo uniqueIdInfo2 = this.f105c.dids;
                        uniqueIdInfo2.tsid = string;
                        this.f106d.updateDidsHash(uniqueIdInfo2);
                        this.f112m.tsid = string;
                    }
                }
            } else if (i8 == 200) {
                c.f94a = new ObjectLogUtils.Builder().setGlobalTag("OneID").setLogHeadSwitch(true).setBorderSwitch(false).create();
                TextUtils.isEmpty(sj.a.a(context).g("one_id_first_launch"));
                c.g("-->WHAT_INIT 2.0.2.0");
                String string2 = context.getResources().getString(R$string.oneid_process_name);
                if (TextUtils.isEmpty(string2)) {
                    string2 = context.getPackageName();
                }
                String str = string2;
                try {
                    packageName = Application.getProcessName();
                } catch (Exception e4) {
                    e4.printStackTrace();
                    packageName = null;
                }
                if (TextUtils.isEmpty(packageName)) {
                    packageName = context.getPackageName();
                }
                if (!TextUtils.equals(str, packageName)) {
                    c.g("Only works in the main process");
                    this.f103a.sendEmptyMessageDelayed(l5.a.CODE_SCANNER_CANCELLED, 1000L);
                    return false;
                }
                try {
                    if (this.f108i == null) {
                        d dVar = new d(0);
                        dVar.f96b = true;
                        this.f108i = dVar;
                        context.registerReceiver(this.f108i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, this.f103a);
                    }
                } catch (Exception e10) {
                    c.h(Log.getStackTraceString(e10));
                }
                f8.c.c(context, new String[]{"ire-oneid.shalltry.com", "oneid-dev-sg.shalltry.com"}, null);
                GroupFpInfo groupFpInfo2 = new GroupFpInfo(context, this);
                this.f105c = groupFpInfo2;
                this.f106d = new GroupHashInfo(groupFpInfo2);
                this.f112m = new OdIdInfo(this.f105c);
                c.g("--> new OdidInfo " + this.f112m);
                if (this.f107h == 0) {
                    sj.a aVarA2 = sj.a.a(context);
                    Context context2 = (Context) aVarA2.f10138c;
                    int i9 = -1;
                    if (context2 != null) {
                        if (((SharedPreferences) aVarA2.f10137b) == null) {
                            aVarA2.f10137b = aVarA2.d(context2);
                        }
                        SharedPreferences sharedPreferences = (SharedPreferences) aVarA2.f10137b;
                        if (sharedPreferences != null) {
                            try {
                                i9 = sharedPreferences.getInt("last_post_time", 0);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    this.f107h = ((long) i9) * 1000;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j8 = this.f107h;
                if (jCurrentTimeMillis >= j8 && jCurrentTimeMillis - j8 < 86400000) {
                    c.g("Post time not yet reached");
                } else if (!this.f103a.hasMessages(300)) {
                    this.f103a.sendEmptyMessageDelayed(300, f8.c.d("https://ire-oneid.shalltry.com") ? 3000L : 6000L);
                }
                this.f114o.set(true);
            } else if (i8 != 201) {
                CopyOnWriteArrayList<IdChangeInfo> copyOnWriteArrayList = this.f109j;
                switch (i8) {
                    case 300:
                        c.g("-->WHAT_POST_FP_HASH");
                        this.f103a.removeMessages(300);
                        if (!c.i(context)) {
                            c.g("OneID disable or network unavailable");
                            this.e = 0L;
                            this.f103a.sendEmptyMessage(l5.a.CODE_SCANNER_CANCELLED);
                            return false;
                        }
                        if (!f8.c.d("https://ire-oneid.shalltry.com")) {
                            c.g("GslbSdk new domain is not ready");
                            c(Message.obtain(this.f103a, 300));
                            return false;
                        }
                        try {
                            strE = sj.a.a(context).e("fp_hash");
                        } catch (Exception unused2) {
                            strE = "";
                        }
                        String strE2 = c.e(this.f106d.toString());
                        c.g(strE + " vs " + strE2);
                        if (TextUtils.equals(strE, strE2)) {
                            e(null);
                        } else {
                            Message.obtain(this.f103a, 301, strE2).sendToTarget();
                        }
                        break;
                        break;
                    case 301:
                        c.g("-->WHAT_POST_FP_DATA");
                        this.f103a.removeMessages(301);
                        if (!c.i(context)) {
                            c.g("OneID disable or network unavailable");
                            this.e = 0L;
                            this.f103a.sendEmptyMessage(l5.a.CODE_SCANNER_CANCELLED);
                            return false;
                        }
                        String str2 = (String) message.obj;
                        eg.a aVarA3 = sj.b.a(0, f8.c.a("https://ire-oneid.shalltry.com", true) + "/one/v1/log", this.f105c.toString());
                        c.g("code = " + aVarA3.f4953a + " data = " + aVarA3.f4954b);
                        int i10 = aVarA3.f4953a;
                        if (i10 == 0) {
                            this.e = 0L;
                            try {
                                if (new JSONObject(aVarA3.f4954b).optInt("code", 0) == 0) {
                                    if (copyOnWriteArrayList.isEmpty()) {
                                        e(str2);
                                    } else {
                                        Message.obtain(this.f103a, 302, str2).sendToTarget();
                                    }
                                }
                            } catch (Exception e11) {
                                c.h(Log.getStackTraceString(e11));
                            }
                        } else if (i10 != 4) {
                            c(Message.obtain(this.f103a, 301, str2));
                        }
                        break;
                        break;
                    case 302:
                        c.g("-->WHAT_POST_ID_CHANGE");
                        this.f103a.removeMessages(302);
                        String str3 = (String) message.obj;
                        ArrayList arrayList = new ArrayList();
                        for (IdChangeInfo idChangeInfo : copyOnWriteArrayList) {
                            if (!TextUtils.isEmpty(idChangeInfo.pre_id)) {
                                arrayList.add(idChangeInfo);
                            }
                        }
                        if (arrayList.size() > 0) {
                            try {
                                eg.a aVarA4 = sj.b.a(0, f8.c.a("https://ire-oneid.shalltry.com", true) + "/one/v1/change", new q().toJson(arrayList));
                                c.g("code = " + aVarA4.f4953a + " data = " + aVarA4.f4954b);
                                int i11 = aVarA4.f4953a;
                                if (i11 == 0) {
                                    this.e = 0L;
                                    try {
                                        if (new JSONObject(aVarA4.f4954b).optInt("code", 0) == 0) {
                                            c.f(context, copyOnWriteArrayList);
                                            copyOnWriteArrayList.clear();
                                            e(str3);
                                        }
                                    } catch (Exception e12) {
                                        c.h(Log.getStackTraceString(e12));
                                    }
                                } else if (i11 != 4) {
                                    c(Message.obtain(this.f103a, 302, str3));
                                }
                            } catch (Exception e13) {
                                c.h(Log.getStackTraceString(e13));
                            }
                        } else {
                            if (copyOnWriteArrayList.size() > 0) {
                                c.f(context, copyOnWriteArrayList);
                                copyOnWriteArrayList.clear();
                            }
                            e(str3);
                        }
                        break;
                    case 303:
                        c.g("-->WHAT_REQUEST_ODID");
                        int i12 = message.arg1;
                        AppIdInfo appIdInfo = (AppIdInfo) message.obj;
                        this.f103a.removeMessages(303, appIdInfo);
                        if (!c.i(context)) {
                            c.g("OneID disable or network unavailable");
                            this.f103a.sendEmptyMessage(l5.a.CODE_SCANNER_CANCELLED);
                            return false;
                        }
                        OdIdInfo odIdInfo = this.f112m;
                        if (odIdInfo != null) {
                            odIdInfo.appid = i12;
                            c.g("--> mOdidInfo set appID :" + this.f112m.toString());
                            OdIdInfo odIdInfo2 = this.f112m;
                            eg.a aVarA5 = sj.b.a(odIdInfo2.appid, f8.c.a("https://ire-oneid.shalltry.com", true) + "/one/v1/odid", odIdInfo2.toString());
                            String str4 = aVarA5.f4954b;
                            int i13 = aVarA5.f4953a;
                            c.g("code = " + i13 + " data = " + str4);
                            if (i13 == 0) {
                                f(str4, i12, appIdInfo);
                            } else if (i13 == 3) {
                                c.g("onOdidRequestGatewayError");
                                Message messageObtain = Message.obtain(this.f103a, 303);
                                messageObtain.obj = appIdInfo;
                                messageObtain.arg1 = i12;
                                this.f103a.sendMessageDelayed(messageObtain, 1000L);
                            } else if (i13 != 4) {
                                b(i12, appIdInfo);
                            }
                        }
                        break;
                        break;
                    case 304:
                        Integer num = (Integer) message.obj;
                        int iIntValue2 = num.intValue();
                        this.f103a.removeMessages(304, num);
                        if (!c.i(context)) {
                            c.g("OneID disable or network unavailable");
                            this.f103a.sendEmptyMessage(l5.a.CODE_SCANNER_CANCELLED);
                            return false;
                        }
                        h();
                        AppIdInfo appIdInfo2 = (AppIdInfo) this.f113n.get(num);
                        if (appIdInfo2 == null) {
                            appIdInfo2 = new AppIdInfo();
                            this.f113n.put(num, appIdInfo2);
                            OdIdInfo odIdInfo3 = this.f112m;
                            if (odIdInfo3 != null) {
                                odIdInfo3.appid = iIntValue2;
                            }
                        }
                        Message messageObtain2 = Message.obtain(this.f103a, 303);
                        messageObtain2.arg1 = iIntValue2;
                        messageObtain2.obj = appIdInfo2;
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        long jMax = f8.c.d("https://ire-oneid.shalltry.com") ? 3000L : 6000L;
                        long j10 = appIdInfo2.lastRequestTime;
                        if (jCurrentTimeMillis2 >= j10) {
                            long j11 = jCurrentTimeMillis2 - j10;
                            long j12 = appIdInfo2.waitTime;
                            if (j11 < j12) {
                                jMax = Math.max((j10 + j12) - jCurrentTimeMillis2, jMax);
                            }
                        }
                        if (!this.f103a.hasMessages(303, appIdInfo2)) {
                            this.f103a.sendMessageDelayed(messageObtain2, jMax);
                            c.g("Appid : " + iIntValue2 + " delay " + jMax + " ms refresh odid ");
                        }
                        break;
                        break;
                    default:
                        return false;
                }
            } else {
                c.g("-->WHAT_QUIT");
                ReentrantLock reentrantLock = this.f110k;
                if (reentrantLock.tryLock()) {
                    try {
                        HandlerThread handlerThread = this.f104b;
                        if (handlerThread != null) {
                            handlerThread.quit();
                            this.f104b = null;
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        } catch (Exception e14) {
            c.h(Log.getStackTraceString(e14));
        }
        return false;
    }

    public final void i() {
        if (c.j(this.f111l)) {
            c.g("retry");
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j8 = this.f107h;
            if (jCurrentTimeMillis >= j8 && jCurrentTimeMillis - j8 < 86400000) {
                c.g("Post time not yet reached");
                return;
            }
            ReentrantLock reentrantLock = this.f110k;
            if (reentrantLock.tryLock()) {
                try {
                    if (this.f104b == null) {
                        g();
                    }
                    reentrantLock.unlock();
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            }
            Handler handler = this.f103a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f103a.sendEmptyMessage(200);
            }
        }
    }
}
