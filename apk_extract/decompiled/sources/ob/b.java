package ob;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.transsion.capability.bean.FileInfo;
import eb.g0;
import eb.k1;
import java.util.ArrayList;
import java.util.Iterator;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import tj.w;
import x7.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static int A;
    public static long B;
    public static long C;
    public static int D;
    public static boolean E;
    public static int G;
    public static int H;
    public static long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f8420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f8421h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f8425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f8426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f8427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static long f8428o;
    public static long p;
    public static int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static ArrayList f8429r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static long f8430s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f8431t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f8432v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f8433w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f8434x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static long f8436z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f8437a = d.f8440b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f8417b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f8418c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f8419d = "";
    public static String e = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f8422i = "start_from_phone";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f8423j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ArrayMap f8424k = new ArrayMap();
    public static String u = "other";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ArrayList f8435y = new ArrayList();
    public static String F = "";

    public static String e(String str, String str2) {
        if (str != null && str.length() != 0 && str.length() > 3) {
            String strSubstring = str.substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            str2 = strSubstring + str2;
        }
        return str2 == null ? "" : str2;
    }

    public static String f(ArrayList arrayList) {
        String strF;
        String strF2;
        String strF3;
        String strF4;
        String strF5;
        String strF6;
        String strF7;
        String strF8;
        String strF9;
        String strF10;
        String strF11;
        String strF12;
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            FileInfo fileInfo = (FileInfo) it.next();
            f8432v = fileInfo.getFileSize() + f8432v;
            String strF13 = fileInfo.getName();
            if ((strF13 == null || !StringsKt__StringsJVMKt.endsWith(strF13, ".png", true)) && (((strF = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF, ".jpeg", true)) && (((strF2 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF2, ".jpg", true)) && (((strF3 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF3, ".gif", true)) && ((strF4 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF4, ".webp", true)))))) {
                String strD = fileInfo.getFormat();
                if (strD == null || !StringsKt__StringsKt.contains$default(strD, "video", false, 2, (Object) null)) {
                    String strF14 = fileInfo.getName();
                    if ((strF14 == null || !StringsKt__StringsJVMKt.endsWith(strF14, ".pdf", true)) && (((strF5 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF5, ".csv", true)) && (((strF6 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF6, ".doc", true)) && (((strF7 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF7, ".docx", true)) && (((strF8 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF8, ".pdf", true)) && (((strF9 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF9, ".xls", true)) && (((strF10 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF10, ".xlsx", true)) && (((strF11 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF11, ".ppt", true)) && ((strF12 = fileInfo.getName()) == null || !StringsKt__StringsJVMKt.endsWith(strF12, ".pptx", true)))))))))) {
                        String strF15 = fileInfo.getName();
                        i8 = (strF15 == null || !StringsKt__StringsJVMKt.endsWith(strF15, ".txt", true)) ? i8 | 16 : i8 | 8;
                    } else {
                        i8 |= 4;
                    }
                } else {
                    i8 |= 2;
                }
            } else {
                i8 |= 1;
            }
        }
        if (i8 == 1) {
            return "photo";
        }
        if (i8 == 2) {
            return "video";
        }
        if (i8 != 4) {
            return i8 != 8 ? "other" : "text";
        }
        return "file";
    }

    public static void g() {
        if (TextUtils.equals(e, "scan_device_window")) {
            e = TextUtils.equals(f8418c, "setting_open_click") ? "settings" : "shortcut_center";
        }
        if (e.length() == 0) {
            e = "shortcut_center";
        }
    }

    public static boolean h() {
        try {
            return f.f10882a.getTCCPStatus() == 4;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a(String cancelDevice) {
        Intrinsics.checkNotNullParameter(cancelDevice, "cancelDevice");
        int i8 = G;
        int i9 = H;
        Intrinsics.checkNotNullParameter(cancelDevice, "cancelDevice");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(cancelDevice, "cancelDevice");
        Bundle bundleA = w.A();
        bundleA.putInt("selected_files_num", i8);
        bundleA.putInt("backup_files_num", i9);
        bundleA.putString("cancel_by_which", cancelDevice);
        w.X("iot_pc_con_backup_manual_cancel", bundleA);
    }

    public final void b(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        int i8 = G;
        int i9 = H;
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(reason, "reason");
        Bundle bundleA = w.A();
        bundleA.putInt("selected_files_num", i8);
        bundleA.putInt("backup_files_num", i9);
        bundleA.putString("disconnect_reason", reason);
        w.X("iot_pc_con_backup_disconnect", bundleA);
    }

    public final void c(String str) {
        E = false;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - C;
        d(A, D, jElapsedRealtime, B, "frompc", str);
        A = 0;
        B = 0L;
        C = 0L;
        D = 0;
    }

    public final void d(int i8, int i9, long j8, long j10, String fileSource, String howTransferEnd) {
        Intrinsics.checkNotNullParameter(fileSource, "fileSource");
        Intrinsics.checkNotNullParameter(howTransferEnd, "howTransferEnd");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(fileSource, "fileSource");
        Intrinsics.checkNotNullParameter(howTransferEnd, "howTransferEnd");
        Bundle bundle = new Bundle();
        bundle.putLong("time_cost", j8);
        bundle.putInt("total_file_num", i8);
        bundle.putLong("total_file_size", j10);
        bundle.putString("files_source", fileSource);
        bundle.putString("how_transfer_ends", howTransferEnd);
        bundle.putInt("transfer_success_num", i9);
        w.X("iot_pc_con_files_drag_share_end", bundle);
    }

    public final void i(String nextOrLast) {
        Intrinsics.checkNotNullParameter(nextOrLast, "nextOrLast");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(nextOrLast, "nextOrLast");
        Bundle bundle = new Bundle();
        bundle.putString("next_or_last_page", nextOrLast);
        w.X("iot_pc_con_newtipspage_switch", bundle);
    }

    public final void j(String operate) {
        Intrinsics.checkNotNullParameter(operate, "operate");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(operate, "operate");
        Bundle bundle = new Bundle();
        bundle.putString("operate", operate);
        bundle.putString("device_type", w.B());
        w.X("pad_connection_mirror_toggle_switch", bundle);
    }

    public final void k(String result, long j8) {
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(result, "result");
        Bundle bundle = new Bundle();
        bundle.putString("result", result);
        k1 k1Var = k1.f4765a;
        hc.c cVar = k1.e;
        if (cVar == null || (str = cVar.f5287b) == null) {
            str = "Unknown Device";
        }
        bundle.putString("pad_model", str);
        double d7 = j8 / 1000.0d;
        String log = "formatDuration seconds:" + d7;
        Intrinsics.checkNotNullParameter("AthenaImpl", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("AthenaImpl"), log);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        bundle.putString("phone_connect_time", o.d.q(new Object[]{Double.valueOf(d7)}, 1, "%.1f", "format(...)"));
        w.X("pad_connection_phone_connect_result", bundle);
    }

    public final void l(String exitWay) {
        Intrinsics.checkNotNullParameter(exitWay, "exitWay");
        Intrinsics.checkNotNullParameter(exitWay, "exitWay");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(exitWay, "exitWay");
        Bundle bundleD = w.D();
        bundleD.putString("exit_way", exitWay);
        w.X("iot_multi_con_phonepad_connect_exit_successfully", bundleD);
    }

    public final void m() {
        String str;
        this.f8437a.getClass();
        Bundle bundleA = w.A();
        int i8 = pb.a().getResources().getConfiguration().orientation;
        if (i8 != 1) {
            str = i8 != 2 ? "Undefined" : "landscape";
        } else {
            str = "vertical";
        }
        bundleA.putString("screen_orientation", str);
        g0 g0Var = g0.f4753a;
        bundleA.putString("connected_device_name", g0.b());
        w.X("iot_multi_con_phonepad_connect_widescreen_enable", bundleA);
    }

    public final void n(String str, String str2) {
        String triggerScene = (TextUtils.equals(f8423j, "phone_pick_pc_connect") || TextUtils.equals(f8423j, "phone_accept_pc_connect")) ? f8418c : f8423j;
        String did = e(str2, str);
        String conFailureType = f8423j;
        if (str2 == null) {
            str2 = "";
        }
        String pid = str2;
        String startByPcOrPhone = f8422i;
        Intrinsics.checkNotNullParameter(conFailureType, "conFailureType");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
        Intrinsics.checkNotNullParameter(startByPcOrPhone, "startByPcOrPhone");
        this.f8437a.O(conFailureType, did, pid, triggerScene, startByPcOrPhone);
    }

    public final void o() {
        if (TextUtils.equals("qr_code_connect", f8423j)) {
            g();
            String entry = e;
            Intrinsics.checkNotNullParameter("others_failed", "conStatus");
            Intrinsics.checkNotNullParameter("pc_connection", "workMode");
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.f8437a.U("others_failed", entry);
        }
    }

    public final void p(int i8, int i9, long j8, long j10, String contentType, String result) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(result, "result");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(result, "result");
        Bundle bundle = new Bundle();
        bundle.putString("content_type", contentType);
        bundle.putString("result", result);
        bundle.putInt("total_file_num", i8);
        bundle.putInt("success_file_num", i9);
        bundle.putLong("transfered_size", j8);
        bundle.putLong("time_cost", j10);
        w.X("iot_pc_con_swift_copy_result", bundle);
    }

    public final void q(boolean z2) {
        String switchTo = z2 ? "on" : "off";
        Intrinsics.checkNotNullParameter(switchTo, "switchTo");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(switchTo, "switchTo");
        Bundle bundle = new Bundle();
        bundle.putString("switch_to", switchTo);
        w.X("iot_pc_con_switch_swift_transfer_toggle", bundle);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    /* JADX WARN: Code duplicated, block: B:13:0x001b  */
    /* JADX WARN: Code duplicated, block: B:16:0x0020  */
    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    /* JADX WARN: Code duplicated, block: B:18:0x008a  */
    public final void r(int i8, boolean z2, boolean z3) {
        String result;
        String str;
        if (!z2) {
            if (z3) {
                str = "click_cancel";
            } else {
                result = "succes_end";
            }
            if (i8 != 1) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - f8433w;
                ArrayList arrayList = f8435y;
                d(arrayList.size(), f8434x, jElapsedRealtime, f8436z, "from phone", result);
                f8436z = 0L;
                f8433w = 0L;
                f8434x = 0;
                arrayList.clear();
            } else if (i8 != 3) {
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - p;
                String contentType = u;
                int i9 = q;
                int i10 = f8431t;
                long j8 = f8430s;
                Intrinsics.checkNotNullParameter(contentType, "contentType");
                Intrinsics.checkNotNullParameter(result, "result");
                this.f8437a.getClass();
                Intrinsics.checkNotNullParameter(contentType, "contentType");
                Intrinsics.checkNotNullParameter(result, "result");
                Bundle bundle = new Bundle();
                bundle.putString("content_type", contentType);
                bundle.putString("result", result);
                bundle.putInt("total_file_num", i9);
                bundle.putInt("success_file_num", i10);
                bundle.putLong("transfered_size", j8);
                bundle.putLong("time_cost", jElapsedRealtime2);
                w.X("iot_pc_con_swift_send_result", bundle);
                p = 0L;
                f8431t = 0;
            } else if (i8 == 5) {
                p(q, f8431t, f8430s, SystemClock.elapsedRealtime() - p, u, result);
                p = 0L;
                f8431t = 0;
            }
            if (E || TextUtils.equals(result, "succes_end")) {
            }
            c(result);
            return;
        }
        str = "other_break";
        result = str;
        if (i8 != 1) {
            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - f8433w;
            ArrayList arrayList2 = f8435y;
            d(arrayList2.size(), f8434x, jElapsedRealtime3, f8436z, "from phone", result);
            f8436z = 0L;
            f8433w = 0L;
            f8434x = 0;
            arrayList2.clear();
        } else if (i8 != 3) {
            long jElapsedRealtime4 = SystemClock.elapsedRealtime() - p;
            String contentType2 = u;
            int i11 = q;
            int i12 = f8431t;
            long j10 = f8430s;
            Intrinsics.checkNotNullParameter(contentType2, "contentType");
            Intrinsics.checkNotNullParameter(result, "result");
            this.f8437a.getClass();
            Intrinsics.checkNotNullParameter(contentType2, "contentType");
            Intrinsics.checkNotNullParameter(result, "result");
            Bundle bundle2 = new Bundle();
            bundle2.putString("content_type", contentType2);
            bundle2.putString("result", result);
            bundle2.putInt("total_file_num", i11);
            bundle2.putInt("success_file_num", i12);
            bundle2.putLong("transfered_size", j10);
            bundle2.putLong("time_cost", jElapsedRealtime4);
            w.X("iot_pc_con_swift_send_result", bundle2);
            p = 0L;
            f8431t = 0;
        } else if (i8 == 5) {
            p(q, f8431t, f8430s, SystemClock.elapsedRealtime() - p, u, result);
            p = 0L;
            f8431t = 0;
        }
        if (E) {
        }
    }

    public final void s(String contentType, int i8, long j8, String isConnectedPc, String isMirroring) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(isConnectedPc, "isConnectedPc");
        Intrinsics.checkNotNullParameter(isMirroring, "isMirroring");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(isConnectedPc, "isConnectedPc");
        Intrinsics.checkNotNullParameter(isMirroring, "isMirroring");
        Bundle bundle = new Bundle();
        bundle.putString("content_type", contentType);
        bundle.putInt("file_num", i8);
        bundle.putLong("totle_size", j8);
        bundle.putString("is_connected_pc", isConnectedPc);
        bundle.putString("is_mirroring", isMirroring);
        w.X("iot_pc_con_trigger_swift_copy_guesture", bundle);
    }

    public final void t(ArrayList arrayList, int i8, boolean z2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        String isConnectedPc = z2 ? "yes" : "no";
        String isMirroring = (z2 && h()) ? "yes" : "no";
        f8432v = 0L;
        String contentType = f(arrayList);
        if (i8 != 3) {
            if (i8 != 5) {
                return;
            }
            s(contentType, size, f8432v, isConnectedPc, isMirroring);
            return;
        }
        long j8 = f8432v;
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(isConnectedPc, "isConnectedPc");
        Intrinsics.checkNotNullParameter(isMirroring, "isMirroring");
        this.f8437a.getClass();
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(isConnectedPc, "isConnectedPc");
        Intrinsics.checkNotNullParameter(isMirroring, "isMirroring");
        Bundle bundle = new Bundle();
        bundle.putString("content_type", contentType);
        bundle.putInt("file_num", size);
        bundle.putLong("totle_size", j8);
        bundle.putString("is_connected_pc", isConnectedPc);
        bundle.putString("is_mirroring", isMirroring);
        w.X("iot_pc_con_trigger_swift_send_guesture", bundle);
    }
}
