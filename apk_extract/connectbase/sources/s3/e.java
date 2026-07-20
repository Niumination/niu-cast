package s3;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.util.Predicate;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static <E> int a(Collection<E> collection, Predicate<E> predicate) {
        int i10 = 0;
        if (j(collection)) {
            return 0;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            if (predicate.test(it.next())) {
                i10++;
            }
        }
        return i10;
    }

    public static Boolean b(Context context, String str, boolean z10) throws IllegalArgumentException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Boolean) clsLoadClass.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(clsLoadClass, str, Boolean.valueOf(z10));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return Boolean.valueOf(z10);
        }
    }

    public static Long c(Context context, String str, long j10) throws IllegalArgumentException {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (Long) clsLoadClass.getMethod("getLong", String.class, Long.TYPE).invoke(clsLoadClass, str, Long.valueOf(j10));
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return Long.valueOf(j10);
        }
    }

    public static String d(InputStream inputStream) {
        try {
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStream.close();
                    return sb2.toString();
                }
                sb2.append(line);
            }
        } catch (IOException e10) {
            d6.b bVar = y3.b.f20688a;
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public static String e(Collection<? extends Object> collection, String str) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (Object obj : collection) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(str);
            }
            sb2.append(obj.toString());
        }
        return sb2.toString();
    }

    public static String f(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : bArrDigest) {
                int i10 = b10 & 255;
                if (Integer.toHexString(i10).length() == 1) {
                    sb2.append(hi.b.f7118g);
                    sb2.append(Integer.toHexString(i10));
                } else {
                    sb2.append(Integer.toHexString(i10));
                }
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static JSONObject g(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("appver", String.valueOf(y3.e.u(context)));
            jSONObject.put("anver", Build.VERSION.RELEASE);
            jSONObject.put("apppkg", y3.e.t(context));
            jSONObject.put("gaid", y3.d.b());
            jSONObject.put("mcc", y3.e.r(context));
            jSONObject.put("lang", Locale.getDefault().getLanguage());
            jSONObject.put("installer", y3.e.q(context));
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
        return jSONObject;
    }

    public static void h(StringBuilder sb2, Object obj) {
        if (sb2.length() == 0) {
            sb2.append(obj);
        } else {
            sb2.append(ks.g.f9491d);
            sb2.append(obj);
        }
    }

    public static void i(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (!next.contains("&")) {
                jSONObject2.put(next, obj);
            } else if (!jSONObject2.has(next)) {
                jSONObject2.put(next, obj);
            } else if (next.endsWith("&add")) {
                jSONObject2.put(next, Long.parseLong(obj.toString()) + jSONObject2.getLong(next));
            } else if (next.endsWith("&append")) {
                Object objPut = jSONObject2.get(next);
                if (objPut instanceof JSONArray) {
                    ((JSONArray) objPut).put(obj);
                } else {
                    objPut = new JSONArray().put(objPut).put(obj);
                }
                jSONObject2.put(next, objPut);
            }
        }
    }

    public static boolean j(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static byte[] k(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i10 = 0; i10 < str.length() / 2; i10++) {
            int i11 = i10 * 2;
            int i12 = i11 + 1;
            bArr[i10] = (byte) ((Integer.parseInt(str.substring(i11, i12), 16) * 16) + Integer.parseInt(str.substring(i12, i11 + 2), 16));
        }
        return bArr;
    }

    public static int l(Context context) {
        StringBuilder sb2 = new StringBuilder();
        try {
            String strQ = y3.e.q(context);
            sb2.append(Build.MODEL);
            sb2.append(Build.BRAND);
            sb2.append(y3.e.u(context));
            sb2.append(Build.VERSION.RELEASE);
            sb2.append(y3.e.t(context));
            sb2.append(y3.e.r(context));
            sb2.append(Locale.getDefault().getLanguage());
            if (strQ == null) {
                strQ = "";
            }
            sb2.append(strQ);
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
        return sb2.toString().hashCode();
    }

    public static boolean m(Collection<?> collection) {
        return (collection == null || collection.isEmpty()) ? false : true;
    }

    public static byte[] n(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            byteArrayOutputStream.reset();
            return byteArray;
        } catch (Exception e10) {
            d6.b bVar = y3.b.f20688a;
            y3.b.d(Log.getStackTraceString(e10));
            return null;
        }
    }

    public static String o(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                hexString = hi.b.f7118g.concat(hexString);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static boolean p(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return powerManager != null && powerManager.isScreenOn();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0065 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #2 {Exception -> 0x0069, blocks: (B:36:0x0060, B:38:0x0065), top: B:45:0x0060 }] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0027: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:15:0x0027 */
    public static byte[] q(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        GZIPInputStream gZIPInputStream3 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int i10 = gZIPInputStream.read(bArr2);
                        if (i10 < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i10);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                    } catch (Exception e10) {
                        d6.b bVar = y3.b.f20688a;
                        y3.b.d(Log.getStackTraceString(e10));
                    }
                    return byteArray;
                } catch (Exception e11) {
                    e = e11;
                    d6.b bVar2 = y3.b.f20688a;
                    y3.b.d(Log.getStackTraceString(e));
                    try {
                        byteArrayOutputStream.close();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Exception e12) {
                        y3.b.d(Log.getStackTraceString(e12));
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream3 = gZIPInputStream2;
                try {
                    byteArrayOutputStream.close();
                    if (gZIPInputStream3 != null) {
                        gZIPInputStream3.close();
                    }
                } catch (Exception e13) {
                    d6.b bVar3 = y3.b.f20688a;
                    y3.b.d(Log.getStackTraceString(e13));
                }
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            gZIPInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream.close();
            if (gZIPInputStream3 != null) {
                gZIPInputStream3.close();
            }
            throw th;
        }
    }
}
