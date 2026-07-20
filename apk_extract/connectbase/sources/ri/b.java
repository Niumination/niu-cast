package ri;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import d5.f;
import ui.c;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14501a = "com.hoffnung.cloudControl.RemoteConfigProvider";

    public static class a extends Exception {
    }

    public static boolean a(Context context, String str) throws Throwable {
        String strC = c(context, str);
        if ("true".equals(strC)) {
            return true;
        }
        if ("false".equals(strC)) {
            return false;
        }
        throw new a();
    }

    public static int b(Context context, String str) throws a {
        try {
            return Integer.valueOf(c(context, str)).intValue();
        } catch (Exception unused) {
            throw new a();
        }
    }

    public static String c(Context context, String str) throws Throwable {
        Cursor cursorQuery;
        Throwable th2;
        String string;
        try {
            cursorQuery = context.getContentResolver().query(d(str), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    try {
                        if (cursorQuery.moveToFirst() && (string = cursorQuery.getString(cursorQuery.getColumnIndex(str))) != null) {
                            if (!cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            return string;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        c.m(ri.a.f14497a, "get configName fail, cause" + e.getMessage(), null, null, null);
                        if (cursorQuery == null || cursorQuery.isClosed()) {
                            return "";
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    throw th2;
                }
            }
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return "";
            }
        } catch (Exception e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th4) {
            cursorQuery = null;
            th2 = th4;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
        cursorQuery.close();
        return "";
    }

    public static Uri d(String str) {
        return Uri.parse(f.f3542j + str);
    }
}
