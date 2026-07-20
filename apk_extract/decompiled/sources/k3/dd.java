package k3;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.core.utils.EncoderUtil;
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
import java.util.List;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class dd {
    public static String a(InputStream inputStream) {
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
        } catch (IOException e) {
            ObjectLogUtils objectLogUtils = z6.a.f11258a;
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }

    public static String b(String str, Collection collection) {
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = true;
        for (Object obj : collection) {
            if (z2) {
                z2 = false;
            } else {
                sb2.append(str);
            }
            sb2.append(obj.toString());
        }
        return sb2.toString();
    }

    public static String c(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_MD5);
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b9 : bArrDigest) {
                int i8 = b9 & UByte.MAX_VALUE;
                if (Integer.toHexString(i8).length() == 1) {
                    sb2.append("0");
                    sb2.append(Integer.toHexString(i8));
                } else {
                    sb2.append(Integer.toHexString(i8));
                }
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("appver", String.valueOf(m3.g0.p(context)));
            jSONObject.put("anver", Build.VERSION.RELEASE);
            jSONObject.put("apppkg", m3.g0.o(context));
            jSONObject.put("gaid", z6.b.b());
            jSONObject.put("mcc", m3.g0.m(context));
            jSONObject.put("lang", Locale.getDefault().getLanguage());
            jSONObject.put("installer", m3.g0.l(context));
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
        return jSONObject;
    }

    public static void e(StringBuilder sb2, Integer num) {
        if (sb2.length() == 0) {
            sb2.append(num);
        } else {
            sb2.append(",");
            sb2.append(num);
        }
    }

    public static void f(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
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

    public static boolean g(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static byte[] h(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i8 = 0; i8 < str.length() / 2; i8++) {
            int i9 = i8 * 2;
            int i10 = i9 + 1;
            bArr[i8] = (byte) ((Integer.parseInt(str.substring(i9, i10), 16) * 16) + Integer.parseInt(str.substring(i10, i9 + 2), 16));
        }
        return bArr;
    }

    public static boolean i(List list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static byte[] j(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            byteArrayOutputStream.reset();
            return byteArray;
        } catch (Exception e) {
            ObjectLogUtils objectLogUtils = z6.a.f11258a;
            z6.a.c(Log.getStackTraceString(e));
            return null;
        }
    }

    public static String k(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b9 : bArr) {
            String hexString = Integer.toHexString(b9 & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static boolean l(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return powerManager != null && powerManager.isScreenOn();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0065 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #2 {Exception -> 0x0069, blocks: (B:36:0x0060, B:38:0x0065), top: B:45:0x0060 }] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0027: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:15:0x0027 */
    public static byte[] m(byte[] bArr) throws Throwable {
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
                        int i8 = gZIPInputStream.read(bArr2);
                        if (i8 < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i8);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                    } catch (Exception e) {
                        ObjectLogUtils objectLogUtils = z6.a.f11258a;
                        z6.a.c(Log.getStackTraceString(e));
                    }
                    return byteArray;
                } catch (Exception e4) {
                    e = e4;
                    ObjectLogUtils objectLogUtils2 = z6.a.f11258a;
                    z6.a.c(Log.getStackTraceString(e));
                    try {
                        byteArrayOutputStream.close();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Exception e10) {
                        z6.a.c(Log.getStackTraceString(e10));
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
                } catch (Exception e11) {
                    ObjectLogUtils objectLogUtils3 = z6.a.f11258a;
                    z6.a.c(Log.getStackTraceString(e11));
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
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
