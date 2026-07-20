package eb;

import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.AbilityBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k3.gc;
import k3.pb;
import k3.sb;
import k3.ub;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f4742a;

    static {
        f4742a = CollectionsKt.listOf((Object[]) new s7.a[]{new s7.a(0), sb.b() ? new s7.a(1) : new s7.a(2), new s7.a(3)});
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00c7  */
    public static ArrayList a() {
        ArrayList arrayList;
        y yVar = y.f4799a;
        if (sb.b()) {
            gc.c("CapabilityManager", "getPhoneCapabilityList");
            arrayList = new ArrayList();
            if (k3.l1.b()) {
                arrayList.add(new AbilityBean("com.transsion.extendscreen_v3", 0, new o7.b(2)));
            } else {
                arrayList.add(new AbilityBean("com.transsion.audio", 0, new o7.b(1)));
                arrayList.add(new AbilityBean("com.transsion.video", 0, new o7.b(3)));
                arrayList.add(new AbilityBean("com.transsion.copy_files_with_gesture", 0, null, 4, null));
                arrayList.add(new AbilityBean("com.transsion.copy_text_with_gesture", 0, null, 4, null));
                arrayList.add(new AbilityBean("com.transsion.transfer_files_with_gesture", 0, null, 4, null));
                arrayList.add(new AbilityBean("com.transsion.screen_control", 0, null, 4, null));
                if (k3.l1.a("tr_pcconnect.phone_extend_pad.feature.support", null)) {
                    arrayList.add(new AbilityBean("com.transsion.phone_extend_pad", 0, null, 4, null));
                }
                if (na.m.b() != null || na.m.f8145b) {
                    g0 g0Var = g0.f4753a;
                    if (g0.e()) {
                        arrayList.add(new AbilityBean("com.transsion.network_sharing", 0, null, 4, null));
                    } else {
                        gc.c("CapabilityManager", "getLocalCapabilityList: tran net api not supported");
                    }
                } else {
                    gc.c("CapabilityManager", "getLocalCapabilityList: tran net api not supported");
                }
                if (Intrinsics.areEqual(sb.a(pb.a()), "0F")) {
                    arrayList.add(new AbilityBean("com.transsion.video_support_folding", 0, null, 4, null));
                }
            }
            arrayList.add(new AbilityBean("com.transsion.input", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.file", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.heartbeat", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.copy_pictures_taking_photos", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.copy_pictures_with_screenshot", 0, null, 4, null));
            if (k3.l1.a("tr_pcconnect.pc_mouse_button.feature.support", "ro.pc_mouse_button_support") || Intrinsics.areEqual("1", pa.a.f8703a.k("tr_pcconnect.pc_mouse_button.feature.support", "ro.pc_mouse_button_support", "0"))) {
                arrayList.add(new AbilityBean("com.transsion.mouse_button", 0, null, 4, null));
            }
            arrayList.add(new AbilityBean("com.transsion.backup", 0, null, 4, null));
        } else {
            Intrinsics.checkNotNullParameter("CapabilityManager", "tag");
            Intrinsics.checkNotNullParameter("getTabletCapabilityList", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("CapabilityManager"), "getTabletCapabilityList");
            }
            arrayList = new ArrayList();
            if (k3.l1.b()) {
                arrayList.add(new AbilityBean("com.transsion.extendscreen_v3", 0, new o7.b(2)));
            }
            arrayList.add(new AbilityBean("com.transsion.video", 0, new o7.b(3)));
            arrayList.add(new AbilityBean("com.transsion.audio", 0, new o7.b(1)));
            arrayList.add(new AbilityBean("com.transsion.screen_control", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.input", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.heartbeat", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.phone_extend_pad", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.copy_pictures_taking_photos", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.copy_pictures_with_screenshot", 0, null, 4, null));
            arrayList.add(new AbilityBean("com.transsion.backup", 0, null, 4, null));
            if (na.m.b() != null || na.m.f8145b) {
                g0 g0Var2 = g0.f4753a;
                if (g0.e()) {
                    arrayList.add(new AbilityBean("com.transsion.pad_network_sharing", 0, null, 4, null));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0380 A[Catch: all -> 0x0389, TryCatch #0 {all -> 0x0389, blocks: (B:98:0x0369, B:100:0x0380, B:103:0x038b), top: B:113:0x0369 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0369 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x002d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x002d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x008d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x0063  */
    /* JADX WARN: Code duplicated, block: B:20:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0092  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:37:0x010c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0116  */
    /* JADX WARN: Code duplicated, block: B:39:0x0120  */
    /* JADX WARN: Code duplicated, block: B:40:0x012a  */
    /* JADX WARN: Code duplicated, block: B:44:0x013f  */
    /* JADX WARN: Code duplicated, block: B:52:0x017d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0194  */
    /* JADX WARN: Code duplicated, block: B:58:0x019a  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:71:0x0221  */
    /* JADX WARN: Code duplicated, block: B:74:0x023c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0244  */
    /* JADX WARN: Code duplicated, block: B:79:0x027b  */
    /* JADX WARN: Code duplicated, block: B:82:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:86:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:89:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:91:0x0313  */
    /* JADX WARN: Code duplicated, block: B:94:0x033d  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v4 java.lang.Object, still in use, count: 2, list:
          (r4v4 java.lang.Object) from 0x005f: PHI (r4 I:??) = (r4v1 java.lang.Object), (r4v4 java.lang.Object) binds: [B:14:0x005e, B:123:0x005f] A[DONT_GENERATE, DONT_INLINE]
          (r4v4 java.lang.Object) from 0x004d: CHECK_CAST (s7.a) (r4v4 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public static void b(int r12, java.util.List r13) {
        /*
            Method dump skipped, instruction units count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: eb.a.b(int, java.util.List):void");
    }

    public static void c() {
        if (o7.a.b("com.transsion.copy_pictures_with_screenshot") != null) {
            t7.a.f10190a = true;
            Intrinsics.checkNotNullParameter("GalleryChangeMonitorHelper", "tag");
            Intrinsics.checkNotNullParameter("statContentObserver", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("GalleryChangeMonitorHelper"), "statContentObserver");
            }
            h7.a aVar = new h7.a(t7.a.f10191b, 3);
            Iterator it = CollectionsKt.listOf((Object[]) new Uri[]{MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Images.Media.INTERNAL_CONTENT_URI}).iterator();
            while (it.hasNext()) {
                pb.a().getContentResolver().registerContentObserver((Uri) it.next(), true, aVar);
            }
            t7.a.f10192c = aVar;
        }
    }

    public static void d() {
        xa.i.e(2, true, false);
        li.l0.p(xa.i.f10893c, null, null, new xa.g(null), 3);
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        String reason = ub.a(pb.a()) ? "heartbeat_overtime" : "wifi_off";
        k1 k1Var = k1.f4765a;
        hc.c cVar = k1.e;
        String did = ob.b.e(cVar != null ? cVar.f5286a : null, cVar != null ? cVar.f5288c : null);
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter("pc_connection", "workMode");
        Intrinsics.checkNotNullParameter(reason, "reason");
        bVar.f8437a.t(did, reason);
        ConcurrentHashMap concurrentHashMap = o7.a.f8410a;
        Intrinsics.checkNotNullParameter("CapabilityHelperManager", "tag");
        Intrinsics.checkNotNullParameter("clearAllCapability", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("CapabilityHelperManager"), "clearAllCapability");
        }
        ConcurrentHashMap concurrentHashMap2 = o7.a.f8410a;
        Iterator it = concurrentHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            ((o7.c) ((Map.Entry) it.next()).getValue()).a();
        }
        concurrentHashMap2.clear();
        o7.a.a();
        String strO = o.d.o("stopWorker sHasInit:", t7.a.f10190a, "GalleryChangeMonitorHelper", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("GalleryChangeMonitorHelper"), strO);
        }
        if (t7.a.f10190a) {
            t7.a.f10191b.post(new bb.t(9));
        }
        t7.a.f10190a = false;
    }
}
