package c6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Message;
import android.provider.Settings;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import com.transsion.athena.data.TrackData;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import k3.vb;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1433a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1435c;

    public a(Context context) {
        this.f1434b = context;
    }

    public abstract void a(long j8, Runnable runnable);

    public abstract void b(Message message, long j8);

    public abstract void c(Runnable runnable);

    public abstract void d(String str, TrackData trackData, long j8);

    public abstract void e();

    public abstract void f();

    public void g() {
        Unit unit;
        a aVar = (a) this.f1435c;
        SharedPreferences sharedPreferences = null;
        if (aVar != null) {
            aVar.i();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ArrayList arrayList = new ArrayList();
            r rVar = (r) this.f1434b;
            arrayList.addAll(rVar.f1444g);
            arrayList.addAll(rVar.f1445h);
            arrayList.addAll(rVar.e);
            if (rVar.f1443d.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                if (a.a.a(rVar.a(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    rVar.f.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                } else {
                    arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                }
            }
            if (rVar.f1443d.contains("android.permission.SYSTEM_ALERT_WINDOW") && rVar.d() >= 23) {
                if (Settings.canDrawOverlays(rVar.a())) {
                    rVar.f.add("android.permission.SYSTEM_ALERT_WINDOW");
                } else {
                    arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
                }
            }
            if (rVar.f1443d.contains("android.permission.WRITE_SETTINGS") && rVar.d() >= 23) {
                if (Settings.System.canWrite(rVar.a())) {
                    rVar.f.add("android.permission.WRITE_SETTINGS");
                } else {
                    arrayList.add("android.permission.WRITE_SETTINGS");
                }
            }
            if (rVar.f1443d.contains("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                if (Environment.isExternalStorageManager()) {
                    rVar.f.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                } else {
                    arrayList.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                }
            }
            if (rVar.f1443d.contains("android.permission.REQUEST_INSTALL_PACKAGES")) {
                if (rVar.d() < 26 || !rVar.a().getPackageManager().canRequestPackageInstalls()) {
                    arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
                } else {
                    rVar.f.add("android.permission.REQUEST_INSTALL_PACKAGES");
                }
            }
            if (rVar.f1443d.contains("android.permission.POST_NOTIFICATIONS")) {
                if (NotificationManagerCompat.from(rVar.a()).areNotificationsEnabled()) {
                    rVar.f.add("android.permission.POST_NOTIFICATIONS");
                } else {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                }
            }
            if (rVar.f1443d.contains("android.permission.BODY_SENSORS_BACKGROUND")) {
                if (a.a.a(rVar.a(), "android.permission.BODY_SENSORS_BACKGROUND")) {
                    rVar.f.add("android.permission.BODY_SENSORS_BACKGROUND");
                } else {
                    arrayList.add("android.permission.BODY_SENSORS_BACKGROUND");
                }
            }
            c1.a aVar2 = rVar.f1447j;
            if (aVar2 != null) {
                Intrinsics.checkNotNull(aVar2);
                boolean zIsEmpty = arrayList.isEmpty();
                Intrinsics.checkNotNullParameter(new ArrayList(rVar.f), "<unused var>");
                Intrinsics.checkNotNullParameter(arrayList, "<unused var>");
                String name = (String) aVar2.f1360a;
                Intrinsics.checkNotNullParameter(name, "name");
                String key = "first_req_permission_tag".concat(name);
                Intrinsics.checkNotNullParameter(key, "key");
                SharedPreferences sharedPreferences2 = vb.f6684a;
                if (sharedPreferences2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                } else {
                    sharedPreferences = sharedPreferences2;
                }
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putBoolean(key, false);
                editorEdit.apply();
                if (zIsEmpty) {
                    ((Function0) aVar2.f1361b).invoke();
                } else {
                    ((Function0) aVar2.f1362c).invoke();
                }
            }
            Fragment fragmentFindFragmentByTag = rVar.b().findFragmentByTag("InvisibleFragment");
            if (fragmentFindFragmentByTag != null) {
                rVar.b().beginTransaction().remove(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
            }
            rVar.a().setRequestedOrientation(rVar.f1441b);
        }
    }

    public String h(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = (List) this.f1435c;
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (lastIndex < 0) {
            return null;
        }
        int i8 = 0;
        while (true) {
            zf.o oVar = (zf.o) list.get(i8);
            if (StringsKt__StringsJVMKt.equals(oVar.f11528a, name, true)) {
                return oVar.f11529b;
            }
            if (i8 == lastIndex) {
                return null;
            }
            i8++;
        }
    }

    public abstract void i();

    public abstract void j(List list);

    /* JADX WARN: Code duplicated, block: B:43:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00f2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:58:0x0104  */
    /* JADX WARN: Code duplicated, block: B:59:0x010a  */
    /* JADX WARN: Code duplicated, block: B:60:0x0110  */
    /* JADX WARN: Code duplicated, block: B:63:0x0127 A[LOOP:4: B:42:0x00bb->B:63:0x0127, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:76:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x00cd A[SYNTHETIC] */
    public String toString() {
        StringBuilder sb2;
        int length;
        int i8;
        char cCharAt;
        int length2;
        int i9;
        switch (this.f1433a) {
            case 2:
                List<zf.o> list = (List) this.f1435c;
                boolean zIsEmpty = list.isEmpty();
                String str = (String) this.f1434b;
                if (zIsEmpty) {
                    return str;
                }
                int length3 = str.length();
                int length4 = 0;
                for (zf.o oVar : list) {
                    length4 += oVar.f11529b.length() + oVar.f11528a.length() + 3;
                }
                StringBuilder sb3 = new StringBuilder(length3 + length4);
                sb3.append(str);
                int lastIndex = CollectionsKt.getLastIndex(list);
                if (lastIndex >= 0) {
                    int i10 = 0;
                    while (true) {
                        zf.o oVar2 = (zf.o) list.get(i10);
                        sb3.append("; ");
                        sb3.append(oVar2.f11528a);
                        sb3.append("=");
                        Set set = zf.p.f11531a;
                        String str2 = oVar2.f11529b;
                        if (str2.length() != 0) {
                            if (str2.length() >= 2 && StringsKt___StringsKt.first(str2) == '\"' && StringsKt.last(str2) == '\"') {
                                int i11 = 1;
                                while (true) {
                                    int iIndexOf$default = StringsKt__StringsKt.indexOf$default(str2, Typography.quote, i11, false, 4, (Object) null);
                                    if (iIndexOf$default != StringsKt.getLastIndex(str2)) {
                                        int i12 = 0;
                                        for (int i13 = iIndexOf$default - 1; str2.charAt(i13) == '\\'; i13--) {
                                            i12++;
                                        }
                                        if (i12 % 2 == 0) {
                                            length2 = str2.length();
                                            i9 = 0;
                                            while (true) {
                                                if (i9 < length2) {
                                                    if (zf.p.f11531a.contains(Character.valueOf(str2.charAt(i9)))) {
                                                        Intrinsics.checkNotNullParameter(str2, "<this>");
                                                        sb2 = new StringBuilder("\"");
                                                        length = str2.length();
                                                        for (i8 = 0; i8 < length; i8++) {
                                                            cCharAt = str2.charAt(i8);
                                                            if (cCharAt == '\t') {
                                                                sb2.append("\\t");
                                                            } else if (cCharAt == '\n') {
                                                                sb2.append("\\n");
                                                            } else if (cCharAt == '\r') {
                                                                sb2.append("\\r");
                                                            } else if (cCharAt == '\"') {
                                                                sb2.append("\\\"");
                                                            } else if (cCharAt != '\\') {
                                                                sb2.append(cCharAt);
                                                            } else {
                                                                sb2.append("\\\\");
                                                            }
                                                        }
                                                        sb2.append("\"");
                                                        String string = sb2.toString();
                                                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                                        sb3.append(string);
                                                    } else {
                                                        i9++;
                                                    }
                                                }
                                            }
                                        } else {
                                            i11 = iIndexOf$default + 1;
                                            if (i11 >= str2.length()) {
                                            }
                                        }
                                    }
                                }
                            } else {
                                length2 = str2.length();
                                i9 = 0;
                                while (true) {
                                    if (i9 < length2) {
                                        if (zf.p.f11531a.contains(Character.valueOf(str2.charAt(i9)))) {
                                            Intrinsics.checkNotNullParameter(str2, "<this>");
                                            sb2 = new StringBuilder("\"");
                                            length = str2.length();
                                            while (i8 < length) {
                                                cCharAt = str2.charAt(i8);
                                                if (cCharAt == '\t') {
                                                    sb2.append("\\t");
                                                } else if (cCharAt == '\n') {
                                                    sb2.append("\\n");
                                                } else if (cCharAt == '\r') {
                                                    sb2.append("\\r");
                                                } else if (cCharAt == '\"') {
                                                    sb2.append("\\\"");
                                                } else if (cCharAt != '\\') {
                                                    sb2.append(cCharAt);
                                                } else {
                                                    sb2.append("\\\\");
                                                }
                                            }
                                            sb2.append("\"");
                                            String string2 = sb2.toString();
                                            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                                            sb3.append(string2);
                                        } else {
                                            i9++;
                                        }
                                    }
                                }
                            }
                            sb3.append(str2);
                        } else {
                            Intrinsics.checkNotNullParameter(str2, "<this>");
                            sb2 = new StringBuilder("\"");
                            length = str2.length();
                            while (i8 < length) {
                                cCharAt = str2.charAt(i8);
                                if (cCharAt == '\t') {
                                    sb2.append("\\t");
                                } else if (cCharAt == '\n') {
                                    sb2.append("\\n");
                                } else if (cCharAt == '\r') {
                                    sb2.append("\\r");
                                } else if (cCharAt == '\"') {
                                    sb2.append("\\\"");
                                } else if (cCharAt != '\\') {
                                    sb2.append(cCharAt);
                                } else {
                                    sb2.append("\\\\");
                                }
                            }
                            sb2.append("\"");
                            String string3 = sb2.toString();
                            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                            sb3.append(string3);
                        }
                        if (i10 != lastIndex) {
                            i10++;
                        }
                    }
                }
                String string4 = sb3.toString();
                Intrinsics.checkNotNull(string4);
                return string4;
            default:
                return super.toString();
        }
    }

    public a(String content, List parameters) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.f1434b = content;
        this.f1435c = parameters;
    }

    public a(r pb2) {
        Intrinsics.checkNotNullParameter(pb2, "pb");
        this.f1434b = pb2;
        Intrinsics.checkNotNullParameter(pb2, "pb");
        Intrinsics.checkNotNullParameter(this, "chainTask");
        Intrinsics.checkNotNullParameter(pb2, "pb");
        Intrinsics.checkNotNullParameter(this, "chainTask");
        Intrinsics.checkNotNullParameter(pb2, "pb");
        Intrinsics.checkNotNullParameter(this, "chainTask");
        Intrinsics.checkNotNullParameter(pb2, "pb");
        Intrinsics.checkNotNullParameter(this, "chainTask");
    }
}
