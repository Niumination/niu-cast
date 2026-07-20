package l6;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.transsion.gslb.GslbBroadcastReceiver;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9733f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f9734g = 101;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f9735h = 102;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f9736i = 103;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f9737j = 110;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f9738k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static h f9739l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f9740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f9741b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9742c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f9743d = new ReentrantLock();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f9744e;

    public h() {
        e();
        this.f9740a.sendEmptyMessage(100);
    }

    public static h d() {
        if (f9739l == null) {
            synchronized (h.class) {
                try {
                    if (f9739l == null) {
                        f9739l = new h();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f9739l;
    }

    public void a(d dVar) {
        e();
        Message messageObtainMessage = this.f9740a.obtainMessage(101);
        messageObtainMessage.obj = dVar;
        this.f9740a.sendMessage(messageObtainMessage);
    }

    public void b() {
        if (this.f9740a.hasMessages(102)) {
            return;
        }
        this.f9740a.sendEmptyMessageDelayed(102, 1000L);
    }

    public final String c() {
        SharedPreferences sharedPreferences;
        String string = "";
        try {
            sharedPreferences = c.f9711b.getSharedPreferences("gslb", 0);
            try {
                string = sharedPreferences.getString("deviceID", "");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            sharedPreferences = null;
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        if (sharedPreferences != null) {
            try {
                sharedPreferences.edit().putString("deviceID", string2).apply();
            } catch (Exception unused3) {
            }
        }
        return string2;
    }

    public final void e() {
        try {
            if (this.f9743d.tryLock()) {
                if (this.f9741b == null) {
                    HandlerThread handlerThread = new HandlerThread("GSLB Worker");
                    this.f9741b = handlerThread;
                    handlerThread.setPriority(10);
                    this.f9741b.start();
                    this.f9740a = new Handler(this.f9741b.getLooper(), this);
                } else if (this.f9740a.hasMessages(110)) {
                    this.f9740a.removeMessages(110);
                }
            }
        } catch (Exception e10) {
            g.f9730a.m(Log.getStackTraceString(e10));
        } finally {
            this.f9743d.unlock();
        }
    }

    public final boolean f(List<String> list) {
        String strC;
        try {
            strC = m6.a.a(b6.b.a()).f10566a;
        } catch (Exception e10) {
            g.f9730a.m(Log.getStackTraceString(e10));
            strC = null;
        }
        if (strC == null || TextUtils.isEmpty(strC)) {
            g.f9730a.m("Unable to get the device's gaid");
            strC = c();
        }
        if (strC.contains("00000000-0000-0000-0000-000000000000")) {
            g.f9730a.m("gaid tracking is limited");
            strC = c();
        }
        g.f9730a.m("device id is" + strC);
        String strB = f6.c.b(strC, "SHA-256");
        if (!TextUtils.isEmpty(c.f9714e)) {
            strB = c.f9714e;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", c.f9711b.getPackageName());
            jSONObject.put(cb.b.c.f1408o, strB);
            String strI = this.f9744e.i();
            String str = "";
            if (TextUtils.isEmpty(strI) || strC.equals(strI)) {
                jSONObject.put("oldKey", "");
            } else {
                jSONObject.put("oldKey", f6.c.b(strI, "SHA-256"));
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            String strF = c.f9712c;
            jSONObject.put("domains", jSONArray);
            if (TextUtils.isEmpty(strF)) {
                strF = g.f();
            }
            if (strF == null) {
                strF = "";
            }
            jSONObject.put("mcc", strF);
            String country = Locale.getDefault().getCountry();
            if (country == null) {
                country = "";
            }
            jSONObject.put("locale", country);
            String language = Locale.getDefault().getLanguage();
            if (language == null) {
                language = "";
            }
            jSONObject.put("language", language);
            String str2 = Build.MODEL;
            if (str2 != null) {
                str = str2;
            }
            jSONObject.put("model", str);
            e<String> eVarC = g.c(jSONObject.toString(), f6.c.b(c.f9711b.getPackageName() + strB, "SHA-256"));
            if (eVarC == null) {
                g.f9730a.m("net request return null");
            } else {
                if (eVarC.f9724a == 0) {
                    g.f9730a.k("get data success, data is " + eVarC.f9725b);
                    return this.f9744e.t(eVarC.f9725b, strC);
                }
                g.f9730a.k("get data error " + eVarC.f9724a);
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    public final String g(String str) {
        return str == null ? "" : str;
    }

    public void h() {
        e();
        b();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i10 = message.what;
        if (i10 != 110) {
            switch (i10) {
                case 100:
                    b6.b.b(c.f9711b);
                    g.f9730a.v("-->WHAT_INIT.");
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        c.f9711b.registerReceiver(new GslbBroadcastReceiver(), intentFilter);
                    } catch (Exception e10) {
                        Log.d("GSLB_SDK", "regiseter gslb sdk error " + e10.toString());
                        g.f9730a.m(Log.getStackTraceString(e10));
                    }
                    g.f9730a.v("GSLB SDK version is 1.0.2.6");
                    this.f9744e = b.h();
                    break;
                case 101:
                    g.f9730a.v("-->WHAT_ADD_DOMAIN.");
                    d dVar = (d) message.obj;
                    if (dVar.f9715a != null) {
                        this.f9742c = 0;
                    }
                    this.f9744e.a(dVar);
                    b();
                    if (this.f9740a.hasMessages(110)) {
                        this.f9740a.removeMessages(110);
                    }
                    break;
                case 102:
                    g.f9730a.v("-->WHAT_CHECK_EMPTY.");
                    if (!g.g(c.f9711b)) {
                        this.f9744e.m();
                        this.f9740a.removeMessages(110);
                        this.f9740a.sendEmptyMessageDelayed(110, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
                    } else {
                        List<String> listE = this.f9744e.e();
                        if (listE.size() > 0) {
                            g.f9730a.v("getBlankDomains size > 0");
                            g.f9730a.v("blankDomains.size()" + listE.size());
                            if (!f(listE)) {
                                this.f9744e.m();
                                int i11 = this.f9742c + 1;
                                this.f9742c = i11;
                                if (i11 < 3) {
                                    b();
                                } else {
                                    this.f9744e.l();
                                    this.f9740a.removeMessages(110);
                                    this.f9740a.sendEmptyMessageDelayed(110, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
                                }
                            } else {
                                this.f9744e.l();
                                b();
                            }
                        } else if (!TextUtils.isEmpty(this.f9744e.f())) {
                            Log.d("GSLB_SDK", "getBlankDomains size < 0 ");
                            this.f9740a.removeMessages(110);
                            this.f9740a.sendEmptyMessageDelayed(110, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
                        } else {
                            if (f(this.f9744e.d())) {
                                Log.d("GSLB_SDK", "net request for country success");
                                this.f9744e.l();
                                this.f9740a.removeMessages(103);
                            }
                            this.f9740a.removeMessages(110);
                            this.f9740a.sendEmptyMessageDelayed(110, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
                        }
                    }
                    break;
                case 103:
                    g.f9730a.v("-->WHAT_SYNC_DATA.");
                    if (g.g(c.f9711b)) {
                        List<String> listD = this.f9744e.d();
                        if (listD.size() > 0) {
                            f(listD);
                        }
                        this.f9740a.removeMessages(103);
                    }
                    this.f9740a.removeMessages(110);
                    this.f9740a.sendEmptyMessageDelayed(110, AbstractTrafficShapingHandler.DEFAULT_MAX_TIME);
                    break;
            }
        } else {
            g.f9730a.v("-->WHAT_QUIT.");
            if (this.f9743d.tryLock()) {
                try {
                    HandlerThread handlerThread = this.f9741b;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.f9741b = null;
                    }
                } finally {
                    this.f9743d.unlock();
                }
            }
        }
        return false;
    }

    public void i() {
        e();
        if (this.f9740a.hasMessages(103)) {
            return;
        }
        this.f9740a.sendEmptyMessageDelayed(103, 100L);
    }
}
