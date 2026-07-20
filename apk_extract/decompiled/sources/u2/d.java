package u2;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final tc.d f10328b = new tc.d("LibraryVersion", "");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f10329c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f10330a;

    static {
        d dVar = new d();
        dVar.f10330a = new ConcurrentHashMap();
        f10329c = dVar;
    }

    public final String a(String str) throws Throwable {
        IOException e;
        String str2;
        tc.d dVar = f10328b;
        l.d(str, "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = this.f10330a;
        if (concurrentHashMap.containsKey(str)) {
            return (String) concurrentHashMap.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        property = null;
        property = null;
        String property = null;
        inputStream = null;
        try {
            try {
                InputStream resourceAsStream = d.class.getResourceAsStream("/" + str + ".properties");
                try {
                    if (resourceAsStream != null) {
                        properties.load(resourceAsStream);
                        property = properties.getProperty("version", null);
                        String str3 = str + " version is " + property;
                        if (Log.isLoggable((String) dVar.f10209a, 2)) {
                            Log.v("LibraryVersion", dVar.l(str3));
                        }
                    } else {
                        String str4 = "Failed to get app version for libraryName: " + str;
                        if (Log.isLoggable((String) dVar.f10209a, 5)) {
                            Log.w("LibraryVersion", dVar.l(str4));
                        }
                    }
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    String str5 = property;
                    inputStream = resourceAsStream;
                    str2 = str5;
                    String str6 = "Failed to get app version for libraryName: " + str;
                    if (Log.isLoggable((String) dVar.f10209a, 6)) {
                        Log.e("LibraryVersion", dVar.l(str6), e);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    property = str2;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = resourceAsStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                str2 = null;
            }
            if (property == null) {
                if (Log.isLoggable((String) dVar.f10209a, 3)) {
                    Log.d("LibraryVersion", dVar.l(".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"));
                }
                property = "UNKNOWN";
            }
            concurrentHashMap.put(str, property);
            return property;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
