package vk;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.widgetsliquid.utils.Utils;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f10615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f10616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f10617d;
    public static final Method e;
    public static final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Bundle f10618g;

    /* JADX WARN: Code duplicated, block: B:15:0x0069  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fe  */
    static {
        boolean z2;
        boolean z3;
        Class<?> cls;
        Method method;
        String strA = a(Utils.OS_TRANS_VERSION);
        f10614a = strA;
        String strA2 = a("ro.tranos.type");
        Log.e("Utils", "isAfterOS151.version:" + strA + " type:" + strA2);
        if (TextUtils.isEmpty(strA2)) {
            z2 = false;
        } else {
            try {
                if (strA.isEmpty()) {
                    z2 = false;
                } else {
                    String strSubstring = strA.substring(strA2.length());
                    String[] strArrSplit = strSubstring.split("\\.");
                    Log.d("Utils", "OS version($version) :".concat(strSubstring));
                    if (strArrSplit.length >= 2) {
                        int i8 = Integer.parseInt(strArrSplit[0]);
                        int i9 = Integer.parseInt(strArrSplit[1]);
                        if (i8 > 15 || (i8 == 15 && i9 >= 1)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                }
            } catch (Exception unused) {
                Log.e("Utils", "isAfterOS15.1.0: parse faile.version:" + strA + " type:" + strA2);
            }
        }
        f10615b = z2;
        if (TextUtils.isEmpty("16.2.0")) {
            z3 = false;
        } else {
            String str = f10614a;
            if (TextUtils.isEmpty(str)) {
                z3 = false;
            } else {
                Pattern patternCompile = Pattern.compile("[0-9.]+");
                Matcher matcher = patternCompile.matcher(str);
                Matcher matcher2 = patternCompile.matcher("16.2.0");
                String strGroup = "";
                String strGroup2 = "";
                while (matcher.find()) {
                    strGroup2 = matcher.group();
                }
                while (matcher2.find()) {
                    strGroup = matcher2.group();
                }
                if (!strGroup2.equalsIgnoreCase(strGroup)) {
                    String[] strArrSplit2 = strGroup2.split("\\.");
                    String[] strArrSplit3 = strGroup.split("\\.");
                    int i10 = 0;
                    while (true) {
                        if (i10 >= strArrSplit2.length || i10 >= strArrSplit3.length) {
                            if (strArrSplit2.length > strArrSplit3.length) {
                                int length = strArrSplit3.length;
                                while (true) {
                                    if (length < strArrSplit2.length) {
                                        if (Integer.parseInt(strArrSplit2[length]) < 0) {
                                            length++;
                                        }
                                    }
                                }
                            }
                            z3 = false;
                        } else {
                            int i11 = Integer.parseInt(strArrSplit2[i10]);
                            int i12 = Integer.parseInt(strArrSplit3[i10]);
                            if (i11 <= i12) {
                                if (i11 < i12) {
                                    z3 = false;
                                } else {
                                    i10++;
                                }
                            }
                        }
                    }
                }
                z3 = true;
            }
        }
        f10616c = z3;
        f10617d = "true".equals(a("ro.vendor.tran_vib3_support")) || "true".equals(a("ro.tr_vibrate.vibrate30.feature.support"));
        try {
            cls = Class.forName("com.transsion.hubsdk.os.TranVibrator");
        } catch (Exception e4) {
            e4.printStackTrace();
            cls = null;
        }
        try {
            method = cls.getMethod("vibrate", String.class, Bundle.class);
        } catch (Exception e10) {
            e10.printStackTrace();
            method = null;
        }
        e = method;
        f10618g = new Bundle();
        Log.d("Utils", "OPT_BOUNCE_EFFECT:" + f10615b);
        if (cls != null) {
            try {
                f = cls.getConstructor(null).newInstance(null);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
