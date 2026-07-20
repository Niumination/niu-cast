package cb;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1412a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1413b = "user_setup_complete";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f1414c = "assistant";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1415d = "screen_brightness_float";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f1416e = "show_touches";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1417f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1418g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ce.b f1419h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static m8.b f1420i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f1421j = "managed_profile_contact_remote_search";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f1422k = "cross_profile_calendar_enabled";

    public static final class a extends Settings.NameValueTable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1423a = "low_battery_sound";
    }

    public static final class b extends Settings.NameValueTable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1424a = "managed_profile_contact_remote_search";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f1425b = "cross_profile_calendar_enabled";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f1426c = "user_setup_complete";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f1427d = "back_gesture_inset_scale_right";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f1428e = "back_gesture_inset_scale_left";
    }

    /* JADX INFO: renamed from: cb.c$c, reason: collision with other inner class name */
    public static final class C0063c extends Settings.NameValueTable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f1431c = "volume_voice";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f1430b = "volume_system";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1429a = "volume_ring";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f1432d = "volume_music";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f1433e = "volume_alarm";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f1434f = "volume_notification";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f1435g = "volume_bluetooth_sco";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f1436h = "volume_a11y";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f1437i = "volume_assistant";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String[] f1438j = {f1431c, f1430b, f1429a, f1432d, f1433e, f1434f, f1435g, "", "", "", f1436h, f1437i};
    }

    public static int a(ContentResolver contentResolver, String str, int i10, int i11) {
        return e(fc.b.a.f5989i).b(contentResolver, str, i10, i11);
    }

    public static int b(String str, int i10, int i11) {
        return e(fc.b.a.f5985e).i(str, i10, i11);
    }

    public static String c(ContentResolver contentResolver, String str, int i10) {
        return e(fc.b.a.f5989i).a(contentResolver, str, i10);
    }

    public static wg.b e(String str) {
        if (fc.b.b(str)) {
            e.f(f1412a, "TranThubSettings");
            ce.b bVar = f1419h;
            if (bVar != null) {
                return bVar;
            }
            ce.b bVar2 = new ce.b();
            f1419h = bVar2;
            return bVar2;
        }
        e.f(f1412a, "TranAospSettings");
        m8.b bVar3 = f1420i;
        if (bVar3 != null) {
            return bVar3;
        }
        m8.b bVar4 = new m8.b();
        f1420i = bVar4;
        return bVar4;
    }

    public static float f(ContentResolver contentResolver, String str, float f10, int i10) {
        return e(fc.b.a.f5989i).d(contentResolver, str, f10, i10);
    }

    public static boolean k(ContentResolver contentResolver, String str, int i10, int i11) {
        return e(fc.b.a.f5989i).k(contentResolver, str, i10, i11);
    }

    public static boolean l(String str, int i10, int i11) {
        return e(fc.b.a.f5985e).c(str, i10, i11);
    }

    public static boolean m(ContentResolver contentResolver, String str, String str2, int i10) {
        return e(fc.b.a.f5989i).h(contentResolver, str, str2, i10);
    }

    public static boolean o(ContentResolver contentResolver, String str, float f10, int i10) {
        return e(fc.b.a.f5989i).m(contentResolver, str, f10, i10);
    }

    public String d(String str, int i10) {
        return e(fc.b.a.f5986f).j(str, i10);
    }

    public float g(String str, float f10, int i10) {
        return e(fc.b.a.f5986f).o(str, f10, i10);
    }

    public long h(ContentResolver contentResolver, String str, long j10, int i10) {
        return e(fc.b.a.f6001u).n(contentResolver, str, j10, i10);
    }

    @yb.a(level = 1)
    public boolean i(Context context, String str, int i10) {
        return e(fc.b.a.f5989i).l(context, str, i10);
    }

    @yb.a(level = 1)
    public boolean j(Context context, String str, int i10) {
        return e(fc.b.a.f5989i).g(context, str, i10);
    }

    public boolean n(String str, String str2, int i10) {
        return e(fc.b.a.f5986f).f(str, str2, i10);
    }

    public boolean p(String str, float f10, int i10) {
        return e(fc.b.a.f5986f).e(str, f10, i10);
    }
}
