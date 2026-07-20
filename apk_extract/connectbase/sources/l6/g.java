package l6;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import fl.c1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;
import wj.v0;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d6.b f9730a = new d6.b.C0083b().t("GSLB_SDK").v(true).n(false).m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SSLSocketFactory f9731b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9732c = "#";

    public static String a(File file) throws Throwable {
        if (file == null) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!file.exists()) {
                    return "";
                }
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr);
                    String str = new String(bArr);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return str;
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        f9730a.m(Log.getStackTraceString(e));
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException unused3) {
            }
        }
        return "";
    }

    public static void b(String str, String str2) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                    try {
                        fileOutputStream2.write(str2.getBytes());
                        fileOutputStream2.close();
                    } catch (Exception e10) {
                        e = e10;
                        fileOutputStream = fileOutputStream2;
                        f9730a.m(Log.getStackTraceString(e));
                        if (fileOutputStream == null) {
                        } else {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused2) {
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static e<String> c(String str, String str2) {
        e<String> eVar;
        String str3 = c.f9713d ? "https://test-gslb.shalltry.com/gslb/domain/convert" : "https://gslb.shalltry.com/gslb/domain/convert";
        f9730a.k("begin net connect: " + str);
        HttpURLConnection httpURLConnection = null;
        e<String> eVar2 = new e<>(-1, null);
        String str4 = str != null ? str : "";
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(str4.length()));
                httpURLConnection2.setRequestProperty("X-Gslb-Sign", str2);
                httpURLConnection2.setRequestMethod(v0.f19370p);
                httpURLConnection2.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                httpURLConnection2.setConnectTimeout(c1.f6021c);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                PrintWriter printWriter = new PrintWriter(httpURLConnection2.getOutputStream());
                printWriter.write(str4);
                printWriter.flush();
                printWriter.close();
                int responseCode = httpURLConnection2.getResponseCode();
                String responseMessage = httpURLConnection2.getResponseMessage();
                f9730a.v("url:" + str3 + " code:" + responseCode + " Post Data:" + str + " " + responseMessage);
                if (responseCode == 200) {
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line);
                    }
                    String string = sb2.toString();
                    try {
                        if (TextUtils.equals("{}", string)) {
                            eVar = new e<>(1, null);
                        } else {
                            if (TextUtils.isEmpty(string)) {
                                eVar = new e<>(-1, null);
                            } else {
                                eVar2 = new e<>(0, string);
                            }
                            bufferedReader.close();
                            inputStream.close();
                        }
                        bufferedReader.close();
                        inputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            f9730a.m(Log.getStackTraceString(th));
                            return eVar2;
                        } finally {
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        }
                    }
                    eVar2 = eVar;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                httpURLConnection2 = httpURLConnection;
                f9730a.m(Log.getStackTraceString(th));
                return eVar2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return eVar2;
    }

    public static String d(Context context) {
        String processName;
        try {
            processName = Application.getProcessName();
        } catch (Exception e10) {
            e10.printStackTrace();
            processName = null;
        }
        return TextUtils.isEmpty(processName) ? context.getPackageName() : processName;
    }

    public static String e(String str) {
        String host;
        if (str == null || !str.startsWith("http")) {
            host = str;
        } else {
            try {
                host = new URL(str).getHost();
            } catch (MalformedURLException e10) {
                e10.printStackTrace();
                host = "";
            }
        }
        if (TextUtils.isEmpty(host)) {
            f9730a.m("the url is illegal->" + str);
        }
        return host;
    }

    public static String f() {
        String strP = c6.b.p();
        return (TextUtils.isEmpty(strP) || strP.length() < 3) ? "" : strP.substring(0, 3);
    }

    public static boolean g(Context context) {
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
        } catch (Exception e10) {
            f9730a.m(Log.getStackTraceString(e10));
        }
        return false;
    }

    public static String h(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append("#");
            sb2.append(entry.getValue());
            sb2.append(ks.g.f9491d);
        }
        return sb2.toString();
    }

    public static Map<String, String> i(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        if (str != null && str.length() != 0) {
            for (String str2 : str.split(ks.g.f9491d)) {
                String[] strArrSplit = str2.split("#");
                if (strArrSplit.length == 2) {
                    concurrentHashMap.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
        return concurrentHashMap;
    }
}
