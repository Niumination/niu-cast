package ad;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import com.transsion.core.log.ObjectLogUtils;
import com.transsion.core.utils.EncoderUtil;
import com.transsion.sdk.oneid.data.IdChangeInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ObjectLogUtils f94a;

    public static String a(long j8) {
        try {
            if (j8 >= 1073741824) {
                return String.format(Locale.ENGLISH, "%.1fGB", Float.valueOf(j8 / 1073741824));
            }
            if (j8 >= 1048576) {
                float f = j8 / 1048576;
                return String.format(Locale.ENGLISH, f > 100.0f ? "%.0fMB" : "%.1fMB", Float.valueOf(f));
            }
            if (j8 >= 1024) {
                float f4 = j8 / 1024;
                return String.format(Locale.ENGLISH, f4 > 100.0f ? "%.0fKB" : "%.1fKB", Float.valueOf(f4));
            }
            Locale locale = Locale.ENGLISH;
            return j8 + "B";
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static String b(Context context, Handler.Callback callback) {
        Cursor cursorQuery = null;
        try {
            try {
                if (callback == null) {
                    cursorQuery = context.getContentResolver().query(Uri.parse("content://com.transsion.dataservice.provider/property"), null, "prop_key = ?", new String[]{"oneid"}, null);
                    if (cursorQuery != null && cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(0);
                        cursorQuery.close();
                        return string;
                    }
                } else {
                    new f(context, callback).a();
                }
                if (cursorQuery == null) {
                    return "";
                }
                cursorQuery.close();
                return "";
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th2;
        }
    }

    public static String c(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, new String(str));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            int i8 = fileInputStream.read(bArr);
            String str = i8 > 0 ? new String(bArr, 0, i8) : null;
            fileInputStream.close();
            return str;
        } catch (Throwable th2) {
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static String e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b9 : bArrDigest) {
                String hexString = Integer.toHexString(b9 & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb2.append('0');
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    public static void f(Context context, CopyOnWriteArrayList copyOnWriteArrayList) {
        byte b9;
        try {
            Iterator it = copyOnWriteArrayList.iterator();
            JSONObject jSONObject = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            while (it.hasNext()) {
                IdChangeInfo idChangeInfo = (IdChangeInfo) it.next();
                String str5 = idChangeInfo.id_type;
                int iHashCode = str5.hashCode();
                if (iHashCode != 3403373) {
                    if (iHashCode != 3417788) {
                        if (iHashCode != 3569626) {
                            if (iHashCode == 3611910 && str5.equals("vaid")) {
                                b9 = 2;
                            } else {
                                b9 = -1;
                            }
                        } else if (str5.equals("tsid")) {
                            b9 = 0;
                        } else {
                            b9 = -1;
                        }
                    } else if (str5.equals("opid")) {
                        b9 = 3;
                    } else {
                        b9 = -1;
                    }
                } else if (str5.equals("oaid")) {
                    b9 = 1;
                } else {
                    b9 = -1;
                }
                if (b9 == 0) {
                    str = idChangeInfo.new_id;
                } else if (b9 == 1) {
                    str2 = idChangeInfo.new_id;
                } else if (b9 == 2) {
                    str3 = idChangeInfo.new_id;
                } else if (b9 == 3) {
                    str4 = idChangeInfo.new_id;
                }
            }
            sj.a aVarA = sj.a.a(context);
            if (!TextUtils.isEmpty(str)) {
                int iIntValue = Long.valueOf(System.currentTimeMillis() / 1000).intValue();
                try {
                    aVarA.c("oneid", str);
                    aVarA.b(iIntValue, "oneid_time");
                    g("sync tsid success");
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    aVarA.f("oaid", str2);
                    g("sync oaid success");
                } catch (Exception unused2) {
                }
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3)) {
                return;
            }
            File file = new File(e9.c.a());
            if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                if (file.exists()) {
                    String strD = d(file);
                    if (strD != null && strD.length() > 0) {
                        jSONObject = new JSONObject(strD);
                    }
                } else {
                    File file2 = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DOCUMENTS);
                    if ((file2.exists() || file2.mkdirs()) && file.createNewFile()) {
                        g("createNewFile success");
                    }
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String strOptString = jSONObject.optString("opid", "");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("opid", str4);
                    g("sync opid success");
                } else if (!TextUtils.equals(strOptString, str4)) {
                    sj.a.a(context).c("opid", strOptString);
                    g("cover opid success");
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put(context.getPackageName(), str3);
                    g("sync vaid success");
                }
                String string = jSONObject.toString();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(string.getBytes());
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e4) {
            h(e4.getMessage());
        }
    }

    public static void g(String str) {
        ObjectLogUtils objectLogUtils = f94a;
        if (objectLogUtils != null) {
            objectLogUtils.d(str);
        }
    }

    public static void h(Serializable serializable) {
        ObjectLogUtils objectLogUtils = f94a;
        if (objectLogUtils != null) {
            objectLogUtils.e(serializable);
        }
    }

    public static boolean i(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(4) || networkCapabilities.hasTransport(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean j(Context context) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return powerManager != null && powerManager.isScreenOn();
        } catch (Exception unused) {
            return false;
        }
    }
}
