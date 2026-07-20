package a6;

import android.database.Cursor;
import android.net.Uri;
import com.transsion.connectx.mirror.source.SourceApplication;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final g f65a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final String f66b = "GameModeUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final String f67c = "com.transsion.gamemode.provider";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final String f68d = "listapp";

    @b.a({"Recycle"})
    public final boolean a(@os.l String str) {
        l0.p(str, "packageName");
        try {
            Cursor cursorQuery = SourceApplication.b().getContentResolver().query(Uri.parse("content://com.transsion.gamemode.provider/listapp"), new String[]{"packagename", "ischeck"}, "packagename = ?", new String[]{str}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                return false;
            }
            int columnIndex = cursorQuery.getColumnIndex("packagename");
            int columnIndex2 = cursorQuery.getColumnIndex("ischeck");
            String string = cursorQuery.getString(columnIndex);
            l0.o(string, "getString(...)");
            boolean z10 = Boolean.parseBoolean(cursorQuery.getString(columnIndex2));
            k4.m.b(f66b, "Package: " + str + ", isCheck: " + z10);
            return l0.g(str, string) && z10;
        } catch (SecurityException e10) {
            k4.m.b(f66b, "err: " + e10);
            return false;
        }
    }
}
