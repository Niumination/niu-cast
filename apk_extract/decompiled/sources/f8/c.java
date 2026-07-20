package f8;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import mg.a0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f5000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f5001b;

    public static String a(String str, boolean z2) {
        if (f5000a == null) {
            e.f5006a.e("GslbSdk is not initialized");
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            e.f5006a.e("url is empty");
            return str;
        }
        String strA = e.a(str);
        a aVarC = a.c();
        String str2 = (String) aVarC.f4993a.get(strA);
        aVarC.a();
        if (str2 != null && !str2.equals("blank")) {
            return str.replace(strA, str2);
        }
        if (str2 == null) {
            e.f5006a.w(strA + " is not in init list ");
        }
        if (z2) {
            return str;
        }
        return null;
    }

    public static void b(String str, a0 a0Var) {
        if (f5000a == null) {
            e.f5006a.e("GslbSdk is not initialized");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            e.f5006a.e("url is empty");
            return;
        }
        String strA = e.a(str);
        a aVarC = a.c();
        String str2 = (String) aVarC.f4993a.get(strA);
        aVarC.a();
        if (str2 == null) {
            e.f5006a.w(strA + " this domain is not in init list ");
            return;
        }
        if (!str2.equals("blank")) {
            if (a0Var != null) {
                str.replace(strA, str2);
                return;
            }
            return;
        }
        f fVar = f5000a;
        d dVar = new d();
        dVar.f5004c = str;
        dVar.f5005d = a0Var;
        fVar.c();
        Message messageObtainMessage = fVar.f5008a.obtainMessage(101);
        messageObtainMessage.obj = dVar;
        fVar.f5008a.sendMessage(messageObtainMessage);
    }

    public static void c(Context context, String[] strArr, b bVar) {
        f5001b = context.getApplicationContext();
        if (f5000a == null) {
            if (f.f5007h == null) {
                synchronized (f.class) {
                    try {
                        if (f.f5007h == null) {
                            f.f5007h = new f();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            f5000a = f.f5007h;
        }
        if (strArr.length <= 0) {
            Log.e("GslbSdk", "Init with invalid domains");
            return;
        }
        f fVar = f5000a;
        d dVar = new d();
        dVar.f5002a = strArr;
        dVar.f5003b = bVar;
        fVar.c();
        Message messageObtainMessage = fVar.f5008a.obtainMessage(101);
        messageObtainMessage.obj = dVar;
        fVar.f5008a.sendMessage(messageObtainMessage);
    }

    public static boolean d(String str) {
        if (f5000a == null) {
            e.f5006a.e("GslbSdk is not initialized");
            return false;
        }
        if (str != null) {
            return !TextUtils.isEmpty(a(str, false));
        }
        return false;
    }
}
