package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.os.Build;
import android.util.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.lb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.c f9788a;

    public i0(com.welink.protocol.nfbd.c cVar) {
        this.f9788a = cVar;
    }

    @Override // se.b4
    public final void a(int i8) {
        h4.q.getClass();
        we.h.h("NearBluetoothClient", "onNotifyRemoveGroupSuccess: moduleId: ".concat(u0.c(i8)));
        com.welink.protocol.nfbd.c cVar = this.f9788a;
        if (cVar.e) {
            we.h.j("NearBluetoothClient", "onNotifyRemoveGroupSuccess: mP2pDirectRecovering ignore");
            return;
        }
        if (i8 != 320098819) {
            h4 h4Var = cVar.f4073c;
            we.h.h("NearBluetoothClient", "onNotifyRemoveGroupSuccess: tryCancelSuspendP2pConnectTimer: " + (h4Var != null ? Boolean.valueOf(h4Var.H(320098819, "NearBluetoothClient")) : null));
        }
    }

    /* JADX WARN: Code duplicated, block: B:163:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0129 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x012b A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x012e A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x013c A[Catch: all -> 0x007d, TRY_ENTER, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x014e A[Catch: all -> 0x007d, TRY_ENTER, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0156 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0164 A[Catch: all -> 0x007d, TRY_ENTER, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x016c A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x017a A[Catch: all -> 0x007d, TRY_ENTER, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0182 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0190 A[Catch: all -> 0x007d, TRY_ENTER, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b7 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01c3 A[Catch: all -> 0x007d, TryCatch #0 {all -> 0x007d, blocks: (B:4:0x0036, B:6:0x003e, B:7:0x0048, B:9:0x004e, B:10:0x0060, B:12:0x0066, B:15:0x0080, B:153:0x02f1, B:16:0x0087, B:18:0x008f, B:19:0x0099, B:21:0x009f, B:22:0x00b7, B:24:0x00bd, B:25:0x00cd, B:26:0x00d4, B:28:0x00e2, B:29:0x00ec, B:31:0x00f2, B:32:0x010a, B:34:0x0110, B:41:0x012b, B:42:0x012e, B:44:0x0132, B:47:0x013c, B:76:0x01ab, B:77:0x01b1, B:79:0x01b7, B:81:0x01c3, B:83:0x01c7, B:84:0x01cb, B:86:0x01d5, B:48:0x0144, B:51:0x014e, B:52:0x0156, B:54:0x015a, B:57:0x0164, B:58:0x016c, B:60:0x0170, B:63:0x017a, B:64:0x0182, B:66:0x0186, B:69:0x0190, B:71:0x019b, B:73:0x01a1, B:87:0x01e3, B:88:0x01ec, B:90:0x01f4, B:91:0x01fe, B:93:0x0204, B:97:0x0214, B:99:0x021e, B:103:0x0226, B:104:0x0229, B:106:0x022d, B:109:0x0237, B:139:0x02a6, B:142:0x02b4, B:143:0x02b8, B:145:0x02c6, B:146:0x02cb, B:147:0x02d8, B:149:0x02de, B:151:0x02e6, B:110:0x023f, B:113:0x0249, B:114:0x0251, B:116:0x0255, B:119:0x025f, B:120:0x0267, B:122:0x026b, B:125:0x0275, B:126:0x027d, B:128:0x0281, B:131:0x028a, B:133:0x0295, B:135:0x029b, B:152:0x02ea), top: B:158:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01c6  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v33 java.lang.Object, still in use, count: 2, list:
          (r0v33 java.lang.Object) from 0x0125: PHI (r0 I:??) = (r0v23 java.lang.Object), (r0v33 java.lang.Object) binds: [B:37:0x0124, B:36:0x0123] A[DONT_GENERATE, DONT_INLINE]
          (r0v33 java.lang.Object) from 0x0115: CHECK_CAST (kotlin.Pair) (r0v33 java.lang.Object)
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
    @Override // se.b4
    public final void b(boolean r8, int r9, android.bluetooth.BluetoothDevice r10, android.net.wifi.p2p.WifiP2pDevice r11, com.welink.protocol.nfbd.NearDevice r12) {
        /*
            Method dump skipped, instruction units count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.i0.b(boolean, int, android.bluetooth.BluetoothDevice, android.net.wifi.p2p.WifiP2pDevice, com.welink.protocol.nfbd.NearDevice):void");
    }

    @Override // se.b4
    public final void c(WifiP2pGroup wifiP2pGroupInfo, WifiP2pInfo wifiP2pInfo) {
        Map.Entry entry;
        InetAddress inetAddress;
        Intrinsics.checkNotNullParameter(wifiP2pGroupInfo, "wifiP2pGroupInfo");
        String networkName = wifiP2pGroupInfo.getNetworkName();
        String passphrase = wifiP2pGroupInfo.getPassphrase();
        int frequency = wifiP2pGroupInfo.getFrequency();
        WifiP2pDevice owner = wifiP2pGroupInfo.getOwner();
        String strValueOf = String.valueOf((wifiP2pInfo == null || (inetAddress = wifiP2pInfo.groupOwnerAddress) == null) ? null : inetAddress.getHostAddress());
        StringBuilder sbP = h0.a.p("onNotifyGroupOwnerAvailable: ssid: ", networkName, ", password: ", passphrase, ", freq: ");
        sbP.append(frequency);
        sbP.append(", ownerDevice: ");
        sbP.append(owner);
        sbP.append(", goHostAddress: ");
        sbP.append(strValueOf);
        we.h.h("NearBluetoothClient", sbP.toString());
        com.welink.protocol.nfbd.c cVar = this.f9788a;
        if (cVar.p.isEmpty()) {
            Intrinsics.checkNotNull(networkName);
            Intrinsics.checkNotNull(passphrase);
            Intrinsics.checkNotNull(owner);
            com.welink.protocol.nfbd.c.k(this.f9788a, null, strValueOf, networkName, passphrase, frequency, owner);
            return;
        }
        Iterator it = cVar.p.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                entry = null;
                break;
            }
            entry = (Map.Entry) it.next();
        } while (entry == null);
        if (entry != null) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) entry.getValue();
            Intrinsics.checkNotNull(networkName);
            Intrinsics.checkNotNull(passphrase);
            Intrinsics.checkNotNull(owner);
            com.welink.protocol.nfbd.c.k(this.f9788a, bluetoothDevice, strValueOf, networkName, passphrase, frequency, owner);
            return;
        }
        Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
        Intrinsics.checkNotNullParameter("mPendingCreateGroupOwnerRequest is empty", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearBluetoothClient", "TransConnect:mPendingCreateGroupOwnerRequest is empty", null);
        }
    }

    @Override // se.b4
    public final void d() {
        we.h.h("NearBluetoothClient", "onNotifyCreateGroupSuccess");
    }

    @Override // se.b4
    public final void e() {
        com.welink.protocol.nfbd.c cVar = this.f9788a;
        synchronized (cVar) {
            try {
                we.h.h("NearBluetoothClient", "onNotifyCreateGroupFailed");
                Iterator it = cVar.p.entrySet().iterator();
                while (it.hasNext()) {
                    cVar.m((BluetoothDevice) ((Map.Entry) it.next()).getValue());
                }
                cVar.p.clear();
                cVar.f4086t = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void f(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        String hostAddress;
        BluetoothDevice bluetoothDevice;
        Object next;
        String hostAddress2;
        String hostAddress3;
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        com.welink.protocol.nfbd.c cVar = this.f9788a;
        synchronized (cVar) {
            try {
                we.h.h("NearBluetoothClient", "onNotifyConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                if (wifiP2pGroup != null && !wifiP2pGroup.isGroupOwner() && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    InetAddress inetAddress = wifiP2pInfo.groupOwnerAddress;
                    String string = (inetAddress == null || (hostAddress3 = inetAddress.getHostAddress()) == null) ? null : hostAddress3.toString();
                    Inet4Address inet4AddressD = cVar.f4081m != null ? ye.d.d(wifiP2pGroup) : null;
                    String string2 = (inet4AddressD == null || (hostAddress2 = inet4AddressD.getHostAddress()) == null) ? null : hostAddress2.toString();
                    WifiP2pDevice owner = wifiP2pGroup.getOwner();
                    String networkName = wifiP2pGroup.getNetworkName();
                    Iterator it = cVar.f4083o.entrySet().iterator();
                    do {
                        if (!it.hasNext()) {
                            bluetoothDevice = null;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        g2 g2Var = (g2) entry.getValue();
                        Iterator it2 = cVar.f4075g.iterator();
                        do {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                        } while (!Intrinsics.areEqual(((Pair) next).getFirst(), g2Var.f9743a));
                        bluetoothDevice = next != null ? g2Var.f9743a : null;
                    } while (bluetoothDevice == null);
                    if (bluetoothDevice != null) {
                        LinkedHashMap linkedHashMap = cVar.q;
                        String str = owner.deviceAddress;
                        Intrinsics.checkNotNull(owner);
                        i2 i2Var = cVar.f4082n;
                        linkedHashMap.put(str, new h2(bluetoothDevice, owner, i2Var != null ? i2Var.f9797g : null));
                    }
                    Intrinsics.checkNotNull(owner);
                    com.welink.protocol.nfbd.c.j(cVar, string, string2, owner, networkName);
                } else if (wifiP2pGroup == null && wifiP2pInfo != null && wifiP2pInfo.groupFormed) {
                    InetAddress inetAddress2 = wifiP2pInfo.groupOwnerAddress;
                    String string3 = (inetAddress2 == null || (hostAddress = inetAddress2.getHostAddress()) == null) ? null : hostAddress.toString();
                    Iterator it3 = clientList.iterator();
                    while (it3.hasNext()) {
                        WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) it3.next();
                        we.h.h("NearBluetoothClient", "onConnected clientList: Client address:" + wifiP2pDevice.deviceAddress.toString());
                        if (Build.VERSION.SDK_INT < 35) {
                            cVar.x(wifiP2pDevice, string3 == null ? "192.168.49.1" : string3, null);
                        } else if (wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner) {
                            String str2 = string3 == null ? "192.168.49.1" : string3;
                            InetAddress ipAddress = wifiP2pDevice.getIpAddress();
                            cVar.x(wifiP2pDevice, str2, String.valueOf(ipAddress != null ? ipAddress.getHostAddress() : null));
                        } else {
                            cVar.x(wifiP2pDevice, string3 == null ? "192.168.49.1" : string3, null);
                        }
                    }
                } else {
                    we.h.h("NearBluetoothClient", "onNotifyConnected failed: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // se.b4
    public final void g() {
        we.h.h("NearBluetoothClient", "onResetRecoveryState");
        com.welink.protocol.nfbd.c cVar = this.f9788a;
        if (cVar.e) {
            cVar.e = false;
            we.h.h("NearBluetoothClient", "onResetRecoveryState: P2p direct recovering reset");
        }
    }

    @Override // se.b4
    public final void h(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection clientList) {
        Intrinsics.checkNotNullParameter(clientList, "clientList");
        com.welink.protocol.nfbd.c cVar = this.f9788a;
        synchronized (cVar) {
            try {
                we.h.h("NearBluetoothClient", "onNotifyOtherDeviceConnected: " + wifiP2pGroup + ", " + wifiP2pInfo + ", " + clientList);
                Iterator it = cVar.f4077i.iterator();
                while (it.hasNext()) {
                    ((w) it.next()).k(wifiP2pGroup, wifiP2pInfo, clientList);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        we.h.h("NearBluetoothClient", "onNotifyOtherDeviceConnected: " + clientList);
    }

    @Override // se.b4
    public final void i() {
        we.h.h("NearBluetoothClient", "onNotifyConnectionSuccess");
    }
}
