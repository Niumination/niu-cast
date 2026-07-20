package xa;

import ag.q;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import com.transsion.iotservice.multiscreen.pc.R$string;
import eb.k1;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import li.h0;
import li.l0;
import li.v0;
import m3.u;
import na.k;
import qi.r;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sj.a f10891a = new sj.a(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qi.c f10893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f10894d;
    public static final ConcurrentLinkedQueue e;
    public static int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashSet f10895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f10896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f10897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashSet f10898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static s7.d f10899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f10900l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f10901m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static long f10902n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static long f10903o;
    public static final String p;
    public static final h3.e q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final q f10904r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ob.c f10905s;

    static {
        String packageName = pb.a().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        f10892b = packageName;
        v0 v0Var = v0.f7498a;
        f10893c = h0.a(si.e.f10118a);
        f10894d = 1;
        e = new ConcurrentLinkedQueue();
        f10895g = new HashSet();
        f10898j = new HashSet();
        f10901m = "";
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str = File.separator;
        p = absolutePath + str + "PC Connection" + str;
        q = new h3.e(Looper.getMainLooper(), 4);
        f10904r = new q(20);
        f10905s = new ob.c(24);
    }

    public static final void a(int i8, int i9, String str) {
        gc.a("FileTransferProcessor", "processFileProgress: type:" + i9 + ", progress:" + i8);
        f = i9;
        if (i9 == 3 || i9 == 5) {
            if (TextUtils.equals(f10901m, str) && f10900l == i8) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - f10902n < 1500) {
                return;
            }
            f10900l = i8;
            f10901m = str;
            f10902n = jElapsedRealtime;
            if (e.peek() == null) {
                gc.b("FileTransferProcessor", "processFileProgress：task is null");
                return;
            }
            v0 v0Var = v0.f7498a;
            l0.p(f10893c, r.f9163a, null, new f(i8, i9, null), 2);
        }
    }

    public static final void b(int i8, String str) {
        gc.a("FileTransferProcessor", "processTaskProgress: type:" + i8 + ", fileId:" + str);
        f = i8;
        HashSet hashSet = f10895g;
        if (i8 != 3 && i8 != 5) {
            if (i8 == 1) {
                gc.a("FileTransferProcessor", "processTaskProgress: remove(" + str + ")");
                hashSet.remove(str);
                if (!hashSet.isEmpty()) {
                    gc.c("FileTransferProcessor", "processTaskProgress：drag list no empty");
                    return;
                } else {
                    ob.b.f8417b.r(i8, false, false);
                    d();
                    return;
                }
            }
            return;
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = e;
        q7.h hVar = (q7.h) concurrentLinkedQueue.peek();
        if (hVar == null) {
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter("dealGestureOrAirTransferProgress: task no exist", "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("FileTransferProcessor"), "dealGestureOrAirTransferProgress: task no exist");
                return;
            }
            return;
        }
        int size = hVar.getFileInfoList().size();
        int i9 = f10894d + 1;
        f10894d = i9;
        qi.c cVar = f10893c;
        if (i9 <= size) {
            if (f10896h <= 10000000 || SystemClock.elapsedRealtime() - f10903o < 200) {
                return;
            }
            f10903o = SystemClock.elapsedRealtime();
            v0 v0Var = v0.f7498a;
            l0.p(cVar, r.f9163a, null, new d(i9, size, i8, null), 2);
            return;
        }
        gc.a("FileTransferProcessor", "processTaskProgress: processTaskFinish");
        int i10 = f;
        if (i10 == 3 || i10 == 5) {
            v0 v0Var2 = v0.f7498a;
            l0.p(cVar, r.f9163a, null, new a(false, null), 2);
        }
        fb.b.f5014b.a(f);
        concurrentLinkedQueue.poll();
        if (concurrentLinkedQueue.isEmpty()) {
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter("promoteNextTask : mTaskQueue.isEmpty(): true", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("FileTransferProcessor"), "promoteNextTask : mTaskQueue.isEmpty(): true");
            }
            e(3, false, false);
            return;
        }
        gc.a("FileTransferProcessor", "promoteNextTask : mTaskQueue.isEmpty(): false");
        if (!hashSet.isEmpty()) {
            gc.c("FileTransferProcessor", "promoteNextTask:exist drag task");
            return;
        }
        if (((q7.h) concurrentLinkedQueue.peek()) == null) {
            gc.a("FileTransferProcessor", "promoteNextTask : task == null: true");
            e(3, false, false);
            return;
        }
        gc.a("FileTransferProcessor", "promoteNextTask : task == null: false");
        ob.b.f8417b.r(f, false, false);
        int i11 = f;
        if (i11 == 3 || i11 == 5) {
            v0 v0Var3 = v0.f7498a;
            l0.p(cVar, r.f9163a, null, new a(false, null), 2);
        }
        d();
    }

    public static void c(Integer num, boolean z2, int i8) {
        s7.d dVar;
        if ((i8 & 1) != 0) {
            num = null;
        }
        if ((i8 & 2) != 0) {
            z2 = false;
        }
        String log = "cancelTask : type:" + num;
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), log);
        }
        if (z2 && (dVar = f10899k) != null) {
            dVar.d();
        }
        if (num != null) {
            if (num.intValue() == 3) {
                u.b(pb.a());
            } else if (num.intValue() == 5) {
                u.a(pb.a());
            }
            e(1, false, true);
            return;
        }
        int i9 = f;
        if (i9 == 3) {
            u.b(pb.a());
        } else if (i9 == 5) {
            u.a(pb.a());
        }
        e(1, false, true);
    }

    public static void d() {
        String str;
        q7.h hVar = (q7.h) e.peek();
        if (hVar != null) {
            String strM = o.d.m("executeTask: type:", "FileTransferProcessor", "tag", "log", hVar.getType());
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("FileTransferProcessor"), strM);
            }
            f = hVar.getType();
            l0.p(f10893c, null, null, new h(hVar, null), 3);
            f10894d = 1;
            f10897i = hVar.getFileInfoList().size();
            Application applicationA = pb.a();
            k1 k1Var = k1.f4765a;
            hc.c cVar = k1.e;
            if (cVar == null || (str = cVar.f5287b) == null) {
                str = "";
            }
            int i8 = f10897i;
            Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
            Intrinsics.checkNotNullParameter("toastSending", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("FileTransferProcessor"), "toastSending");
            }
            if (i8 == 1) {
                String string = applicationA.getResources().getString(R$string.module_pc_swift_sending_one_file);
                k kVar = k.f8141a;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Intrinsics.checkNotNull(string);
                kVar.d(applicationA, o.d.q(new Object[]{str}, 1, string, "format(...)"));
                return;
            }
            String string2 = applicationA.getResources().getString(R$string.module_pc_swift_sending);
            k kVar2 = k.f8141a;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNull(string2);
            kVar2.d(applicationA, o.d.q(new Object[]{Integer.valueOf(i8), str}, 2, string2, "format(...)"));
        }
    }

    public static void e(int i8, boolean z2, boolean z3) {
        int i9;
        if ((i8 & 1) != 0) {
            z2 = false;
        }
        if ((i8 & 2) != 0) {
            z3 = false;
        }
        String strO = o.d.o("finishFileTransfer: isDisConnect:", z2, "FileTransferProcessor", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), strO);
        }
        ob.b.f8417b.r(f, z2, z3);
        q.removeMessages(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB);
        int i10 = f;
        if (i10 == 3 || i10 == 5) {
            v0 v0Var = v0.f7498a;
            l0.p(f10893c, r.f9163a, null, new a(z3, null), 2);
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = e;
        if (z2 && !concurrentLinkedQueue.isEmpty() && ((i9 = f) == 3 || i9 == 5)) {
            fb.b.f5014b.e();
        }
        if (z2 || z3) {
            f10895g.clear();
            f10898j.clear();
        }
        concurrentLinkedQueue.clear();
        f10894d = 1;
        f10897i = 0;
        f = 0;
    }

    public static void f() {
        Intrinsics.checkNotNullParameter("FileTransferProcessor", "tag");
        Intrinsics.checkNotNullParameter("notifyDrag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("FileTransferProcessor"), "notifyDrag");
        }
        Intent intent = new Intent("com.transsion.iotservice.action.RECEIVE_DRAG_FILE");
        intent.setComponent(new ComponentName("com.transsion.filemanagerx", "com.transsion.filemanagerx.ui.pcswifttransfer.TransferDragFileReceiver"));
        Application applicationA = pb.a();
        UserHandle CURRENT = z8.a.f11265a;
        Intrinsics.checkNotNullExpressionValue(CURRENT, "CURRENT");
        pb.c(applicationA, intent);
    }
}
