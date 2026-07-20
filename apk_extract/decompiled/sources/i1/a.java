package i1;

import af.t1;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import ck.c;
import ck.h;
import ef.o;
import ek.g;
import ik.s;
import j3.z;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PublicKey;
import javax.crypto.Cipher;
import k3.zc;
import kotlin.jvm.internal.Intrinsics;
import m3.sa;
import r2.w;
import se.e;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f5522d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f5525c;

    public /* synthetic */ a(int i8) {
        this.f5523a = i8;
    }

    public static synchronized a a(Context context) {
        try {
            if (f5522d == null) {
                a aVar = new a(0);
                aVar.f5525c = context.getApplicationContext();
                f5522d = aVar;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f5522d;
    }

    public void b(int i8, String str) {
        Context context = (Context) this.f5525c;
        if (context == null) {
            return;
        }
        if (((SharedPreferences) this.f5524b) == null) {
            this.f5524b = f(context);
        }
        SharedPreferences sharedPreferences = (SharedPreferences) this.f5524b;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putInt(str, i8).apply();
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }

    public void c(String str) throws Exception {
        Context context = (Context) this.f5525c;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (((SharedPreferences) this.f5524b) == null) {
            this.f5524b = f(context);
        }
        if (((SharedPreferences) this.f5524b) == null) {
            throw new Exception("sp is null");
        }
        synchronized (bd.b.class) {
        }
        if (!bd.a.f1269a.e()) {
            throw new Exception("keystore encrypt error");
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        keyStore.getKey("crypto", null);
        PublicKey publicKey = keyStore.getCertificate("crypto").getPublicKey();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, publicKey);
        String str2 = new String(Base64.encode(cipher.doFinal(bytes), 2));
        if (TextUtils.isEmpty(str2)) {
            throw new Exception("rsaCrypter encrypt error");
        }
        SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f5524b).edit();
        editorEdit.putString("athena_ea", str2);
        editorEdit.apply();
    }

    @Override // ek.g
    public Object call(Object obj) {
        c cVar = (c) ((g) this.f5524b).call((c) obj);
        cVar.getClass();
        int i8 = s.f5906b;
        h hVar = (h) this.f5525c;
        o oVar = new o();
        oVar.f4952b = hVar;
        if (i8 <= 0) {
            i8 = s.f5906b;
        }
        oVar.f4951a = i8;
        return cVar.a(oVar);
    }

    public void d(c6.a task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (((c6.a) this.f5524b) == null) {
            this.f5524b = task;
        }
        c6.a aVar = (c6.a) this.f5525c;
        if (aVar != null) {
            aVar.f1435c = task;
        }
        this.f5525c = task;
    }

    public int e(String str) {
        Context context = (Context) this.f5525c;
        if (context == null) {
            return -1;
        }
        if (((SharedPreferences) this.f5524b) == null) {
            this.f5524b = f(context);
        }
        SharedPreferences sharedPreferences = (SharedPreferences) this.f5524b;
        if (sharedPreferences == null) {
            return -1;
        }
        try {
            return sharedPreferences.getInt(str, 0);
        } catch (Exception e) {
            z6.a.c(e.getMessage());
            return -1;
        }
    }

    public SharedPreferences f(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("tcrypto", 0);
            this.f5524b = sharedPreferences;
            return sharedPreferences;
        } catch (Exception e) {
            z6.a.c(e.getMessage());
            return null;
        }
    }

    public void g(String str, String str2) {
        Context context = (Context) this.f5525c;
        if (context == null) {
            return;
        }
        if (((SharedPreferences) this.f5524b) == null) {
            this.f5524b = f(context);
        }
        SharedPreferences sharedPreferences = (SharedPreferences) this.f5524b;
        if (sharedPreferences == null) {
            return;
        }
        try {
            sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }

    public String h() throws Exception {
        Context context = (Context) this.f5525c;
        if (context == null) {
            throw new Exception("context is null");
        }
        if (((SharedPreferences) this.f5524b) == null) {
            this.f5524b = f(context);
        }
        if (((SharedPreferences) this.f5524b) == null) {
            throw new Exception("sp is null");
        }
        synchronized (bd.b.class) {
        }
        if (!bd.a.f1269a.e()) {
            throw new Exception("keystore decrypt error");
        }
        String string = ((SharedPreferences) this.f5524b).getString("athena_ea", "");
        if (TextUtils.isEmpty(string) || string.contains("_")) {
            return "";
        }
        String str = new String(new u6.a(3, false).y(Base64.decode(string, 2)));
        if (TextUtils.isEmpty(str)) {
            throw new Exception("rsaCrypter decrypt error");
        }
        return str;
    }

    public String i(String str) {
        Context context = (Context) this.f5525c;
        if (context == null) {
            return "";
        }
        if (((SharedPreferences) this.f5524b) == null) {
            this.f5524b = f(context);
        }
        SharedPreferences sharedPreferences = (SharedPreferences) this.f5524b;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
            return "";
        }
    }

    public void j() {
        e eVar;
        aa.a aVar;
        p9.a aVar2;
        UserHandle userHandle = z8.a.f11265a;
        if (l9.b.a(l9.a.f)) {
            j9.a.c("a", "TranThubLocationManager");
            aVar2 = (p9.a) this.f5524b;
            if (aVar2 == null) {
                aVar = aVar2;
                p9.a aVar3 = new p9.a();
                this.f5524b = aVar3;
                aVar = aVar3;
            }
        } else {
            j9.a.c("a", "TranAospLocationManager");
            eVar = (e) this.f5525c;
            if (eVar == null) {
                aVar = eVar;
                e eVar2 = new e(13);
                eVar2.f9720b = (LocationManager) z.f6093b.getSystemService("location");
                this.f5525c = eVar2;
                aVar = eVar2;
            }
        }
        aVar = eVar;
        aVar = aVar2;
        aVar.a();
    }

    public String toString() {
        switch (this.f5523a) {
            case 2:
                return "Request{url=" + ((ff.a) this.f5524b) + '}';
            default:
                return super.toString();
        }
    }

    public a(w wVar, AlertDialog alertDialog) {
        this.f5523a = 5;
        this.f5525c = wVar;
        this.f5524b = alertDialog;
    }

    public a(u6.a aVar) {
        this.f5523a = 4;
        this.f5525c = new zc();
        this.f5524b = aVar;
        sa.b();
    }

    public a(f5.a aVar) {
        this.f5523a = 2;
        this.f5524b = (ff.a) aVar.f4984a;
        t1 t1Var = (t1) aVar.f4985b;
        t1Var.getClass();
        this.f5525c = new e(t1Var);
    }

    public a(g gVar, h hVar) {
        this.f5523a = 3;
        this.f5524b = gVar;
        this.f5525c = hVar;
    }
}
