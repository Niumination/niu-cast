package sj;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cf.n0;
import d6.t;
import d6.v;
import j6.l;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ze.y;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f10135d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f10137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f10138c;

    public /* synthetic */ a(int i8) {
        this.f10136a = i8;
    }

    public static synchronized a a(Context context) {
        try {
            if (f10135d == null) {
                a aVar = new a(0);
                aVar.f10138c = context.getApplicationContext();
                f10135d = aVar;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f10135d;
    }

    public void b(int i8, String str) {
        Context context = (Context) this.f10138c;
        if (context == null) {
            return;
        }
        if (((SharedPreferences) this.f10137b) == null) {
            this.f10137b = d(context);
        }
        SharedPreferences sharedPreferences = (SharedPreferences) this.f10137b;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(str, i8).apply();
        } catch (Exception e) {
            ad.c.h(Log.getStackTraceString(e));
        }
    }

    public void c(String str, String str2) {
        Context context = (Context) this.f10138c;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (((SharedPreferences) this.f10137b) == null) {
            this.f10137b = d(context);
        }
        if (((SharedPreferences) this.f10137b) == null) {
            throw new Exception("sp is null");
        }
        try {
            synchronized (bd.b.class) {
            }
            if (!bd.a.f1269a.e()) {
                throw new Exception("keystore encrypt error");
            }
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            keyStore.getKey("crypto", null);
            PublicKey publicKey = keyStore.getCertificate("crypto").getPublicKey();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            String str3 = new String(Base64.encode(cipher.doFinal(bytes), 2));
            if (TextUtils.isEmpty(str3)) {
                throw new Exception("rsaCrypter encrypt error");
            }
            SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f10137b).edit();
            editorEdit.putString(str, str3);
            editorEdit.apply();
        } catch (Exception e) {
            ad.c.h(Log.getStackTraceString(e));
            throw e;
        }
    }

    public SharedPreferences d(Context context) {
        String packageName;
        try {
            try {
                packageName = Application.getProcessName();
            } catch (Exception e) {
                e.printStackTrace();
                packageName = null;
            }
            if (TextUtils.isEmpty(packageName)) {
                packageName = context.getPackageName();
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(packageName + "_tcrypto", 0);
            this.f10137b = sharedPreferences;
            return sharedPreferences;
        } catch (Exception unused) {
            return null;
        }
    }

    public String e(String str) throws Exception {
        Context context = (Context) this.f10138c;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (((SharedPreferences) this.f10137b) == null) {
            this.f10137b = d(context);
        }
        if (((SharedPreferences) this.f10137b) == null) {
            throw new Exception("sp is null");
        }
        try {
            synchronized (bd.b.class) {
            }
            if (!bd.a.f1269a.e()) {
                throw new Exception("keystore decrypt error");
            }
            String string = ((SharedPreferences) this.f10137b).getString(str, "");
            if (!TextUtils.isEmpty(string) && !string.contains("_")) {
                String str2 = new String(new u6.a(3, false).y(Base64.decode(string, 2)));
                if (TextUtils.isEmpty(str2)) {
                    throw new Exception("rsaCrypter decrypt error");
                }
                return str2;
            }
            return "";
        } catch (Exception e) {
            ad.c.h(Log.getStackTraceString(e));
            throw e;
        }
    }

    public void f(String str, String str2) {
        Context context = (Context) this.f10138c;
        if (context == null) {
            return;
        }
        if (((SharedPreferences) this.f10137b) == null) {
            this.f10137b = d(context);
        }
        SharedPreferences sharedPreferences = (SharedPreferences) this.f10137b;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e) {
            ad.c.h(Log.getStackTraceString(e));
        }
    }

    public String g(String str) {
        Context context = (Context) this.f10138c;
        if (context == null) {
            return "";
        }
        if (((SharedPreferences) this.f10137b) == null) {
            this.f10137b = d(context);
        }
        SharedPreferences sharedPreferences = (SharedPreferences) this.f10137b;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception e) {
            ad.c.h(Log.getStackTraceString(e));
            return "";
        }
    }

    public ArrayList h() throws pg.a {
        String str = (String) this.f10138c;
        String strA = pg.c.a(str, "size");
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f10137b;
        String str2 = (String) linkedHashMap.get(strA);
        if (str2 == null) {
            throw new pg.a(h0.a.j("Property ", str, ".size not found."));
        }
        IntRange intRangeUntil = RangesKt.until(0, Integer.parseInt(str2));
        ArrayList arrayList = new ArrayList(CollectionsKt.i(intRangeUntil));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            Object obj = linkedHashMap.get(pg.c.a(str, String.valueOf(((IntIterator) it).nextInt())));
            Intrinsics.checkNotNull(obj);
            arrayList.add((String) obj);
        }
        return arrayList;
    }

    public y9.a i(String str) {
        if (l9.b.a(str)) {
            n9.a aVar = (n9.a) this.f10137b;
            if (aVar != null) {
                return aVar;
            }
            n9.a aVar2 = new n9.a();
            this.f10137b = aVar2;
            return aVar2;
        }
        n5.a aVar3 = (n5.a) this.f10138c;
        if (aVar3 != null) {
            return aVar3;
        }
        n5.a aVar4 = new n5.a();
        this.f10138c = aVar4;
        return aVar4;
    }

    public boolean j(e6.b bVar, int i8, int i9) {
        n0 n0Var;
        d6.a aVar = new d6.a();
        boolean z2 = false;
        aVar.f4300i = new v(0, 0, 0, 0);
        aVar.f4301j = new v(0, 0, 0, 0);
        aVar.f4303l = 1;
        this.f10138c = aVar;
        bVar.a();
        byte[] bArr = new byte[8];
        while (true) {
            if (bVar.b(8, bArr) != 8) {
                n0Var = null;
                break;
            }
            n0Var = new n0();
            n0Var.f1602a = ((bArr[0] & UByte.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE);
            Charset charsetForName = Charset.forName("US-ASCII");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(\"US-ASCII\")");
            if (Intrinsics.areEqual("vapc", new String(bArr, 4, 4, charsetForName))) {
                break;
            }
            bVar.skip(((long) n0Var.f1602a) - 8);
        }
        d6.d dVar = (d6.d) this.f10137b;
        if (n0Var == null) {
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimConfigManager", "tag");
            Intrinsics.checkNotNullParameter("vapc box head not found", NotificationCompat.CATEGORY_MESSAGE);
            aVar.f4302k = true;
            aVar.f4303l = i8;
            aVar.f4298g = i9;
            t tVar = dVar.f4314d;
            if (tVar != null) {
                l lVar = (l) tVar.f4354k.getValue();
                lVar.getClass();
                if (i9 > 0) {
                    lVar.f6125c = 1000000 / ((long) i9);
                }
            }
            dVar.f = i9;
            return true;
        }
        int i10 = n0Var.f1602a - 8;
        byte[] bArr2 = new byte[i10];
        bVar.b(i10, bArr2);
        bVar.c();
        Charset charsetForName2 = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName2, "forName(\"UTF-8\")");
        JSONObject json = new JSONObject(new String(bArr2, 0, i10, charsetForName2));
        Intrinsics.checkNotNullParameter(json, "json");
        try {
            JSONObject jSONObject = json.getJSONObject("info");
            int i11 = jSONObject.getInt("v");
            if (2 != i11) {
                String msg = "current version=2 target=" + i11;
                Intrinsics.checkNotNullParameter("AnimPlayer.AnimConfig", "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
            } else {
                aVar.f4294a = jSONObject.getInt("f");
                aVar.f4295b = jSONObject.getInt("w");
                aVar.f4296c = jSONObject.getInt("h");
                aVar.f4297d = jSONObject.getInt("videoW");
                aVar.e = jSONObject.getInt("videoH");
                aVar.f = jSONObject.getInt("orien");
                aVar.f4298g = jSONObject.getInt("fps");
                aVar.f4299h = jSONObject.getInt("isVapx") == 1;
                JSONArray jSONArray = jSONObject.getJSONArray("aFrame");
                if (jSONArray != null) {
                    v vVar = new v(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
                    Intrinsics.checkNotNullParameter(vVar, "<set-?>");
                    aVar.f4300i = vVar;
                    JSONArray jSONArray2 = jSONObject.getJSONArray("rgbFrame");
                    if (jSONArray2 != null) {
                        v vVar2 = new v(jSONArray2.getInt(0), jSONArray2.getInt(1), jSONArray2.getInt(2), jSONArray2.getInt(3));
                        Intrinsics.checkNotNullParameter(vVar2, "<set-?>");
                        aVar.f4301j = vVar2;
                        z2 = true;
                    }
                }
            }
        } catch (JSONException tr) {
            String msg2 = Intrinsics.stringPlus("json parse fail ", tr);
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimConfig", "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
        }
        if (i9 > 0) {
            aVar.f4298g = i9;
        }
        int i12 = aVar.f4298g;
        t tVar2 = dVar.f4314d;
        if (tVar2 != null) {
            l lVar2 = (l) tVar2.f4354k.getValue();
            lVar2.getClass();
            if (i12 > 0) {
                lVar2.f6125c = 1000000 / ((long) i12);
            }
        }
        dVar.f = i12;
        return z2;
    }

    public int k(e6.b fileContainer, int i8, int i9) {
        Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            boolean zJ = j(fileContainer, i8, i9);
            String msg = "parseConfig cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms enableVersion1=false result=" + zJ;
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimConfigManager", "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (!zJ) {
                return 10005;
            }
            d6.a aVar = (d6.a) this.f10138c;
            if (aVar != null && aVar.f4302k) {
                return 10005;
            }
            if (aVar == null) {
                return 0;
            }
            ((d6.d) this.f10137b).p.b(aVar);
            return 0;
        } catch (Throwable tr) {
            String msg2 = Intrinsics.stringPlus("parseConfig error ", tr);
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimConfigManager", "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return 10005;
        }
    }

    public void l(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        FloatBuffer floatBuffer = (FloatBuffer) this.f10138c;
        floatBuffer.position(0);
        floatBuffer.put(array);
    }

    public void m(int i8) {
        ((FloatBuffer) this.f10138c).position(0);
        GLES20.glVertexAttribPointer(i8, 2, 5126, false, 0, (Buffer) this.f10138c);
        GLES20.glEnableVertexAttribArray(i8);
    }

    public String toString() {
        switch (this.f10136a) {
            case 6:
                return (String) this.f10137b;
            default:
                return super.toString();
        }
    }

    public a() {
        this.f10136a = 3;
        float[] fArr = new float[8];
        this.f10137b = fArr;
        FloatBuffer floatBufferPut = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        Intrinsics.checkNotNullExpressionValue(floatBufferPut, "allocateDirect(array.size * 4)\n            .order(ByteOrder.nativeOrder())\n            .asFloatBuffer()\n            .put(array)");
        this.f10138c = floatBufferPut;
    }

    public a(d6.d player) {
        this.f10136a = 1;
        Intrinsics.checkNotNullParameter(player, "player");
        this.f10137b = player;
    }

    public a(se.e eVar, h4.d dVar) {
        this.f10136a = 2;
        this.f10138c = eVar;
        this.f10137b = dVar;
    }

    public a(LinkedHashMap map, String path) {
        this.f10136a = 4;
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(path, "path");
        this.f10137b = map;
        this.f10138c = path;
    }

    public a(String str, EmptyCoroutineContext emptyCoroutineContext) {
        this.f10136a = 6;
        Logger logger = y.f11473d;
        this.f10137b = str;
        this.f10138c = emptyCoroutineContext;
    }
}
