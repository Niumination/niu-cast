package f8;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.transsion.core.CoreUtil;
import com.transsion.core.deviceinfo.DeviceInfo;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.core.utils.EncoderUtil;
import com.transsion.gslb.GslbBroadcastReceiver;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.transsion.message.bank.MessageBank;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import k3.e2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Handler.Callback {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static f f5007h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f5008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f5009b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5010c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f5011d = new ReentrantLock();
    public a e;

    public f() {
        c();
        this.f5008a.sendEmptyMessage(100);
    }

    public static String b() {
        SharedPreferences sharedPreferences;
        String string = "";
        try {
            sharedPreferences = c.f5001b.getSharedPreferences("gslb", 0);
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

    public final void a() {
        if (this.f5008a.hasMessages(102)) {
            return;
        }
        this.f5008a.sendEmptyMessageDelayed(102, 1000L);
    }

    public final void c() {
        ReentrantLock reentrantLock = this.f5011d;
        try {
            if (reentrantLock.tryLock()) {
                if (this.f5009b == null) {
                    HandlerThread handlerThread = new HandlerThread("GSLB Worker");
                    this.f5009b = handlerThread;
                    handlerThread.setPriority(10);
                    this.f5009b.start();
                    this.f5008a = new Handler(this.f5009b.getLooper(), this);
                } else if (this.f5008a.hasMessages(DeviceType.INFRARED_LIGHT)) {
                    this.f5008a.removeMessages(DeviceType.INFRARED_LIGHT);
                }
            }
        } catch (Exception e) {
            e.f5006a.e(Log.getStackTraceString(e));
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0259 A[Catch: JSONException -> 0x026b, TryCatch #8 {JSONException -> 0x026b, blocks: (B:99:0x0246, B:101:0x0259, B:105:0x026e, B:123:0x02c2, B:124:0x02ca, B:126:0x02d0, B:129:0x02ea, B:130:0x02f8, B:132:0x02fe, B:133:0x0300, B:122:0x02b9), top: B:159:0x0246 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x026e A[Catch: JSONException -> 0x026b, TRY_LEAVE, TryCatch #8 {JSONException -> 0x026b, blocks: (B:99:0x0246, B:101:0x0259, B:105:0x026e, B:123:0x02c2, B:124:0x02ca, B:126:0x02d0, B:129:0x02ea, B:130:0x02f8, B:132:0x02fe, B:133:0x0300, B:122:0x02b9), top: B:159:0x0246 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x029a A[Catch: Exception -> 0x02aa, LOOP:2: B:111:0x0294->B:113:0x029a, LOOP_END, TryCatch #2 {Exception -> 0x02aa, blocks: (B:110:0x0290, B:111:0x0294, B:113:0x029a, B:116:0x02ac), top: B:148:0x0290 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x02d0 A[Catch: JSONException -> 0x026b, TryCatch #8 {JSONException -> 0x026b, blocks: (B:99:0x0246, B:101:0x0259, B:105:0x026e, B:123:0x02c2, B:124:0x02ca, B:126:0x02d0, B:129:0x02ea, B:130:0x02f8, B:132:0x02fe, B:133:0x0300, B:122:0x02b9), top: B:159:0x0246 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x02e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:132:0x02fe A[Catch: JSONException -> 0x026b, TryCatch #8 {JSONException -> 0x026b, blocks: (B:99:0x0246, B:101:0x0259, B:105:0x026e, B:123:0x02c2, B:124:0x02ca, B:126:0x02d0, B:129:0x02ea, B:130:0x02f8, B:132:0x02fe, B:133:0x0300, B:122:0x02b9), top: B:159:0x0246 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0313  */
    /* JADX WARN: Code duplicated, block: B:167:0x02ea A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x022b  */
    /* JADX WARN: Instruction removed from duplicated block: B:101:0x0259, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:137:0x0313, please report this as an issue */
    public final boolean d(ArrayList arrayList) throws Throwable {
        String strB;
        String strSubstring;
        HttpURLConnection httpURLConnection;
        int i8;
        ObjectLogUtils objectLogUtils;
        a aVar;
        JSONObject jSONObject;
        int i9;
        String string;
        HashMap map;
        long j8;
        boolean z2;
        JSONObject jSONObject2;
        Iterator<String> itKeys;
        eg.a aVar2;
        HttpURLConnection httpURLConnection2 = null;
        try {
            strB = e2.a(CoreUtil.getContext()).f5115a;
        } catch (Exception e) {
            e.f5006a.e(Log.getStackTraceString(e));
            strB = null;
        }
        if (strB == null || TextUtils.isEmpty(strB)) {
            e.f5006a.e("Unable to get the device's gaid");
            strB = b();
        }
        if (strB.contains("00000000-0000-0000-0000-000000000000")) {
            e.f5006a.e("gaid tracking is limited");
            strB = b();
        }
        String str = strB;
        e.f5006a.e("device id is" + str);
        String strEncoderByAlgorithm = EncoderUtil.EncoderByAlgorithm(str);
        if (!TextUtils.isEmpty(null)) {
            strEncoderByAlgorithm = null;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("appId", c.f5001b.getPackageName());
            jSONObject3.put("key", strEncoderByAlgorithm);
            String str2 = this.e.e;
            String string2 = "";
            if (TextUtils.isEmpty(str2) || str.equals(str2)) {
                jSONObject3.put("oldKey", "");
            } else {
                jSONObject3.put("oldKey", EncoderUtil.EncoderByAlgorithm(str2));
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            jSONObject3.put("domains", jSONArray);
            if (TextUtils.isEmpty(null)) {
                String simOperator = DeviceInfo.getSimOperator();
                strSubstring = (TextUtils.isEmpty(simOperator) || simOperator.length() < 3) ? "" : simOperator.substring(0, 3);
            } else {
                strSubstring = null;
            }
            if (strSubstring == null) {
                strSubstring = "";
            }
            jSONObject3.put("mcc", strSubstring);
            String country = Locale.getDefault().getCountry();
            if (country == null) {
                country = "";
            }
            jSONObject3.put("locale", country);
            String language = Locale.getDefault().getLanguage();
            if (language == null) {
                language = "";
            }
            jSONObject3.put("language", language);
            String str3 = Build.MODEL;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject3.put("model", str3);
            String string3 = jSONObject3.toString();
            String strEncoderByAlgorithm2 = EncoderUtil.EncoderByAlgorithm(c.f5001b.getPackageName() + strEncoderByAlgorithm);
            String strI = h0.a.i("begin net connect: ", string3);
            ObjectLogUtils objectLogUtils2 = e.f5006a;
            objectLogUtils2.d(strI);
            eg.a aVar3 = new eg.a(-1, null);
            String str4 = string3 != null ? string3 : "";
            try {
                httpURLConnection = (HttpURLConnection) new URL("https://gslb.shalltry.com/gslb/domain/convert").openConnection();
                try {
                    httpURLConnection.setRequestProperty("accept", "*/*");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str4.length()));
                    httpURLConnection.setRequestProperty("X-Gslb-Sign", strEncoderByAlgorithm2);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                    printWriter.write(str4);
                    printWriter.flush();
                    printWriter.close();
                    int responseCode = httpURLConnection.getResponseCode();
                    objectLogUtils2.i("url:https://gslb.shalltry.com/gslb/domain/convert code:" + responseCode + " Post Data:" + string3 + " " + httpURLConnection.getResponseMessage());
                    if (responseCode == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb2.append(line);
                        }
                        String string4 = sb2.toString();
                        try {
                            if (TextUtils.equals("{}", string4)) {
                                aVar2 = new eg.a(1, null);
                            } else {
                                if (TextUtils.isEmpty(string4)) {
                                    aVar2 = new eg.a(-1, null);
                                } else {
                                    aVar3 = new eg.a(0, string4);
                                }
                                bufferedReader.close();
                                inputStream.close();
                            }
                            bufferedReader.close();
                            inputStream.close();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                objectLogUtils2.e(Log.getStackTraceString(th));
                                if (httpURLConnection != null) {
                                }
                                i8 = aVar3.f4953a;
                                if (i8 != 0) {
                                    e.f5006a.d("get data error " + i8);
                                    return false;
                                }
                                objectLogUtils = e.f5006a;
                                StringBuilder sb3 = new StringBuilder("get data success, data is ");
                                String str5 = aVar3.f4954b;
                                sb3.append(str5);
                                objectLogUtils.d(sb3.toString());
                                aVar = this.e;
                                aVar.e = str;
                                try {
                                    jSONObject = new JSONObject(str5);
                                    i9 = jSONObject.getInt("code");
                                    string = jSONObject.getString(MessageBank.KEY_MESSAGE);
                                    if (i9 != 200) {
                                        objectLogUtils.e("error message is " + string);
                                        return false;
                                    }
                                    map = new HashMap(4);
                                    try {
                                        JSONObject jSONObject4 = jSONObject.getJSONObject("data");
                                        jSONObject2 = jSONObject4.getJSONObject("domainPairs");
                                        z2 = jSONObject4.getBoolean("overrideFlag");
                                        try {
                                            j8 = jSONObject4.getInt("expireTime");
                                            try {
                                                itKeys = jSONObject2.keys();
                                                while (itKeys.hasNext()) {
                                                    String strValueOf = String.valueOf(itKeys.next());
                                                    map.put(strValueOf, jSONObject2.getString(strValueOf));
                                                }
                                                string2 = jSONObject4.getString("country");
                                            } catch (Exception e4) {
                                                e = e4;
                                                e.f5006a.e(Log.getStackTraceString(e));
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            j8 = 86400000;
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        j8 = 86400000;
                                        z2 = false;
                                    }
                                    for (Map.Entry entry : map.entrySet()) {
                                        if (a.d((String) aVar.f4993a.get(entry.getKey()))) {
                                        }
                                        aVar.f4993a.put(entry.getKey(), entry.getValue());
                                    }
                                    aVar.f4996d = j8;
                                    if (j8 < 86400000) {
                                        aVar.f4996d = 86400000L;
                                    }
                                    aVar.f4995c = System.currentTimeMillis();
                                    aVar.f = string2;
                                    aVar.g();
                                    return true;
                                } catch (JSONException e12) {
                                    e12.printStackTrace();
                                }
                            } catch (Throwable th3) {
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th3;
                            }
                        }
                        aVar3 = aVar2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection2 = httpURLConnection;
                    httpURLConnection = httpURLConnection2;
                    objectLogUtils2.e(Log.getStackTraceString(th));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    i8 = aVar3.f4953a;
                    if (i8 != 0) {
                        e.f5006a.d("get data error " + i8);
                        return false;
                    }
                    objectLogUtils = e.f5006a;
                    StringBuilder sb4 = new StringBuilder("get data success, data is ");
                    String str6 = aVar3.f4954b;
                    sb4.append(str6);
                    objectLogUtils.d(sb4.toString());
                    aVar = this.e;
                    aVar.e = str;
                    jSONObject = new JSONObject(str6);
                    i9 = jSONObject.getInt("code");
                    string = jSONObject.getString(MessageBank.KEY_MESSAGE);
                    if (i9 != 200) {
                        objectLogUtils.e("error message is " + string);
                        return false;
                    }
                    map = new HashMap(4);
                    JSONObject jSONObject5 = jSONObject.getJSONObject("data");
                    jSONObject2 = jSONObject5.getJSONObject("domainPairs");
                    z2 = jSONObject5.getBoolean("overrideFlag");
                    j8 = jSONObject5.getInt("expireTime");
                    itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String strValueOf2 = String.valueOf(itKeys.next());
                        map.put(strValueOf2, jSONObject2.getString(strValueOf2));
                    }
                    string2 = jSONObject5.getString("country");
                    while (r0.hasNext()) {
                        if (a.d((String) aVar.f4993a.get(entry.getKey()))) {
                        }
                        aVar.f4993a.put(entry.getKey(), entry.getValue());
                    }
                    aVar.f4996d = j8;
                    if (j8 < 86400000) {
                        aVar.f4996d = 86400000L;
                    }
                    aVar.f4995c = System.currentTimeMillis();
                    aVar.f = string2;
                    aVar.g();
                    return true;
                }
            } catch (Throwable th5) {
                th = th5;
            }
            httpURLConnection.disconnect();
            i8 = aVar3.f4953a;
            if (i8 != 0) {
                e.f5006a.d("get data error " + i8);
                return false;
            }
            objectLogUtils = e.f5006a;
            StringBuilder sb5 = new StringBuilder("get data success, data is ");
            String str7 = aVar3.f4954b;
            sb5.append(str7);
            objectLogUtils.d(sb5.toString());
            aVar = this.e;
            aVar.e = str;
            jSONObject = new JSONObject(str7);
            i9 = jSONObject.getInt("code");
            string = jSONObject.getString(MessageBank.KEY_MESSAGE);
            if (i9 != 200) {
                objectLogUtils.e("error message is " + string);
                return false;
            }
            map = new HashMap(4);
            JSONObject jSONObject6 = jSONObject.getJSONObject("data");
            jSONObject2 = jSONObject6.getJSONObject("domainPairs");
            z2 = jSONObject6.getBoolean("overrideFlag");
            j8 = jSONObject6.getInt("expireTime");
            itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String strValueOf3 = String.valueOf(itKeys.next());
                map.put(strValueOf3, jSONObject2.getString(strValueOf3));
            }
            string2 = jSONObject6.getString("country");
            while (r0.hasNext()) {
                if (a.d((String) aVar.f4993a.get(entry.getKey())) || z2) {
                    aVar.f4993a.put(entry.getKey(), entry.getValue());
                }
            }
            aVar.f4996d = j8;
            if (j8 < 86400000) {
                aVar.f4996d = 86400000L;
            }
            aVar.f4995c = System.currentTimeMillis();
            aVar.f = string2;
            aVar.g();
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        int i8 = message.what;
        if (i8 != 110) {
            switch (i8) {
                case 100:
                    CoreUtil.init(c.f5001b);
                    e.f5006a.i("-->WHAT_INIT.");
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        c.f5001b.registerReceiver(new GslbBroadcastReceiver(), intentFilter);
                    } catch (Exception e) {
                        Log.d("GSLB_SDK", "regiseter gslb sdk error " + e.toString());
                        e.f5006a.e(Log.getStackTraceString(e));
                    }
                    e.f5006a.i("GSLB SDK version is 1.0.2.6");
                    this.e = a.c();
                    break;
                case 101:
                    e.f5006a.i("-->WHAT_ADD_DOMAIN.");
                    d dVar = (d) message.obj;
                    if (dVar.f5002a != null) {
                        this.f5010c = 0;
                    }
                    a aVar = this.e;
                    aVar.getClass();
                    ArrayList arrayList = aVar.f4994b;
                    String[] strArr = dVar.f5002a;
                    if (strArr != null) {
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z5 = true;
                        for (int i9 = 0; i9 < strArr.length; i9++) {
                            String strA = e.a(strArr[i9]);
                            strArr[i9] = strA;
                            if (!TextUtils.isEmpty(strA)) {
                                String str = (String) aVar.f4993a.get(strArr[i9]);
                                if (str == null) {
                                    aVar.f4993a.put(strArr[i9], "blank");
                                    z5 = false;
                                    z2 = true;
                                } else if (a.d(str)) {
                                    z5 = false;
                                } else {
                                    z5 = false;
                                    z3 = true;
                                }
                            }
                        }
                        b bVar = dVar.f5003b;
                        if (z5) {
                            if (bVar != null) {
                                bVar.onInitFail();
                            }
                        } else if (z2) {
                            aVar.g();
                        } else if (!z3 && !TextUtils.isEmpty(aVar.f)) {
                            if (bVar != null) {
                                bVar.onInitSuccess(new HashMap(aVar.f4993a));
                            }
                        }
                        arrayList.add(dVar);
                    } else {
                        String str2 = dVar.f5004c;
                        if (str2 != null && dVar.f5005d != null) {
                            String strA2 = e.a(str2);
                            String str3 = (String) aVar.f4993a.get(strA2);
                            if (a.d(str3)) {
                                str2.replace(strA2, str3);
                            } else {
                                arrayList.add(dVar);
                            }
                        }
                    }
                    a();
                    if (this.f5008a.hasMessages(DeviceType.INFRARED_LIGHT)) {
                        this.f5008a.removeMessages(DeviceType.INFRARED_LIGHT);
                    }
                    break;
                case 102:
                    e.f5006a.i("-->WHAT_CHECK_EMPTY.");
                    if (e.b(c.f5001b)) {
                        a aVar2 = this.e;
                        aVar2.getClass();
                        ArrayList arrayList2 = new ArrayList();
                        for (Map.Entry entry : aVar2.f4993a.entrySet()) {
                            if (!a.d((String) entry.getValue())) {
                                arrayList2.add(entry.getKey());
                            }
                        }
                        if (arrayList2.size() > 0) {
                            ObjectLogUtils objectLogUtils = e.f5006a;
                            objectLogUtils.i("getBlankDomains size > 0");
                            objectLogUtils.i("blankDomains.size()" + arrayList2.size());
                            if (d(arrayList2)) {
                                this.e.e();
                                a();
                            } else {
                                this.e.f();
                                int i10 = this.f5010c + 1;
                                this.f5010c = i10;
                                if (i10 >= 3) {
                                    this.e.e();
                                    this.f5008a.removeMessages(DeviceType.INFRARED_LIGHT);
                                    this.f5008a.sendEmptyMessageDelayed(DeviceType.INFRARED_LIGHT, 15000L);
                                } else {
                                    a();
                                }
                            }
                        } else if (TextUtils.isEmpty(this.e.f)) {
                            if (d(this.e.b())) {
                                Log.d("GSLB_SDK", "net request for country success");
                                this.e.e();
                                this.f5008a.removeMessages(DeviceType.INFRARED_TV_BOX);
                            }
                            this.f5008a.removeMessages(DeviceType.INFRARED_LIGHT);
                            this.f5008a.sendEmptyMessageDelayed(DeviceType.INFRARED_LIGHT, 15000L);
                        } else {
                            Log.d("GSLB_SDK", "getBlankDomains size < 0 ");
                            this.f5008a.removeMessages(DeviceType.INFRARED_LIGHT);
                            this.f5008a.sendEmptyMessageDelayed(DeviceType.INFRARED_LIGHT, 15000L);
                        }
                    } else {
                        this.e.f();
                        this.f5008a.removeMessages(DeviceType.INFRARED_LIGHT);
                        this.f5008a.sendEmptyMessageDelayed(DeviceType.INFRARED_LIGHT, 15000L);
                    }
                    break;
                case DeviceType.INFRARED_TV_BOX /* 103 */:
                    e.f5006a.i("-->WHAT_SYNC_DATA.");
                    if (e.b(c.f5001b)) {
                        ArrayList arrayListB = this.e.b();
                        if (arrayListB.size() > 0) {
                            d(arrayListB);
                        }
                        this.f5008a.removeMessages(DeviceType.INFRARED_TV_BOX);
                    }
                    this.f5008a.removeMessages(DeviceType.INFRARED_LIGHT);
                    this.f5008a.sendEmptyMessageDelayed(DeviceType.INFRARED_LIGHT, 15000L);
                    break;
            }
        } else {
            e.f5006a.i("-->WHAT_QUIT.");
            ReentrantLock reentrantLock = this.f5011d;
            if (reentrantLock.tryLock()) {
                try {
                    HandlerThread handlerThread = this.f5009b;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.f5009b = null;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        return false;
    }
}
