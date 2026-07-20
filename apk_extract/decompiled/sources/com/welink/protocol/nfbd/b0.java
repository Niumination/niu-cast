package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.work.WorkRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k3.jd;
import k3.lb;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import se.a4;
import se.g2;
import se.g5;
import se.h1;
import se.h4;
import se.i2;
import se.o5;
import se.z6;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends we.g {
    public static final /* synthetic */ int Q = 0;
    public String A;
    public int B;
    public final mg.b0 C;
    public final Object D;
    public final Object E;
    public int F;
    public final h1 G;
    public final o5 H;
    public final o5 I;
    public final o5 J;
    public final o5 K;
    public final o5 L;
    public final o5 M;
    public final o5 N;
    public final o5 O;
    public final oe.a P;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f4053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f4054d;
    public final HashMap e;
    public g5 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f4055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f4056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap f4057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DeviceInfo f4058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BluetoothGatt f4060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BluetoothAdapter f4062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f4063o;
    public final LinkedHashSet p;
    public final a4 q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h4 f4064r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4065s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f4066t;
    public NearDevice u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public i2 f4067v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile boolean f4068w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile boolean f4069x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f4070y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f4071z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(Context mContext, h4 h4Var, a4 nearLaptopManager) {
        super(false, "TranFileSendControllerHandlerThread");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(nearLaptopManager, "nearLaptopManager");
        this.f4053c = mContext;
        this.e = new HashMap();
        this.f4055g = new LinkedHashMap();
        this.f4056h = new LinkedHashMap();
        this.f4057i = new HashMap();
        this.p = new LinkedHashSet();
        this.D = new Object();
        this.f4062n = BluetoothAdapter.getDefaultAdapter();
        this.C = new mg.b0(mContext);
        this.f4064r = h4Var;
        this.q = nearLaptopManager;
        this.G = new h1(this, 2);
        this.H = new o5(this, 0);
        this.I = new o5(this, 4);
        this.J = new o5(this, 5);
        this.K = new o5(this, 6);
        this.L = new o5(this, 7);
        this.M = new o5(this, 8);
        this.N = new o5(this, 9);
        this.O = new o5(this, 10);
        this.P = new oe.a(this, 3);
    }

    public static final void j(b0 b0Var, String str, WifiP2pDevice wifiP2pDevice, String str2, WifiP2pGroup wifiP2pGroup) {
        synchronized (b0Var) {
            try {
                i2 i2Var = b0Var.f4067v;
                NearDevice nearDevice = i2Var != null ? i2Var.f9797g : null;
                if (nearDevice == null && b0Var.u == null) {
                    we.h.c("TranFileSendController", "P2p owner device or mNearDevice is null", null);
                    if (b0Var.f4056h.isEmpty()) {
                        we.h.j("TranFileSendController", "Pending connect request is empty, ignore this event");
                        Unit unit = Unit.INSTANCE;
                    } else {
                        h4 h4Var = b0Var.f4064r;
                        if (h4Var != null) {
                            h4Var.C();
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                } else {
                    if (b0Var.c(b0Var.J)) {
                        b0Var.h(b0Var.J);
                    }
                    b0Var.f4054d = 4;
                    if (b0Var.p.isEmpty()) {
                        we.h.j("TranFileSendController", "Listeners is empty, ignore this event");
                    } else {
                        i2 i2Var2 = b0Var.f4067v;
                        TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(i2Var2 != null ? i2Var2.f9793a : null, i2Var2 != null ? i2Var2.f9796d : null, i2Var2 != null ? i2Var2.f9795c : 0, str, null, 0, 0, wifiP2pDevice, wifiP2pGroup);
                        Iterator it = b0Var.p.iterator();
                        while (it.hasNext()) {
                            ((se.w) it.next()).d(null, wifiP2pDevice, str2, tranConnectionController$P2pDeviceInfo.f3979d, tranConnectionController$P2pDeviceInfo.e, tranConnectionController$P2pDeviceInfo, nearDevice == null ? b0Var.u : nearDevice);
                        }
                        b0Var.f4056h.clear();
                        b0Var.f4067v = null;
                        b0Var.f4054d = 5;
                        b0Var.l();
                    }
                    Unit unit3 = Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void n(final b0 b0Var, final int i8, final int i9, int i10) {
        b0Var.getClass();
        final NearDeviceDataParcel nearDeviceDataParcel = null;
        final WifiP2pDevice wifiP2pDevice = null;
        final String str = null;
        b0Var.f(new Runnable() { // from class: se.p5
            /* JADX WARN: Code duplicated, block: B:105:0x01c1 A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:4:0x0021, B:6:0x002b, B:8:0x002f, B:15:0x0045, B:175:0x02fa, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:36:0x008f, B:50:0x00ae, B:51:0x00b1, B:53:0x00b6, B:54:0x00bc, B:56:0x00c2, B:58:0x00cc, B:60:0x00d2, B:62:0x00d6, B:63:0x00dc, B:65:0x00ee, B:66:0x0100, B:68:0x0115, B:69:0x011f, B:71:0x0125, B:75:0x012f, B:76:0x0135, B:78:0x013b, B:81:0x0147, B:83:0x014f, B:86:0x0159, B:88:0x0170, B:90:0x0174, B:91:0x0178, B:93:0x018a, B:94:0x019c, B:96:0x01a0, B:99:0x01a6, B:101:0x01aa, B:102:0x01ac, B:103:0x01b1, B:104:0x01b8, B:105:0x01c1, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01dd, B:114:0x01e1, B:115:0x01e7, B:117:0x01f9, B:118:0x020b, B:119:0x0211, B:121:0x0217, B:123:0x0221, B:125:0x0227, B:127:0x022b, B:128:0x0231, B:129:0x023b, B:131:0x0241, B:133:0x0257, B:135:0x025d, B:137:0x0263, B:138:0x0267, B:140:0x026b, B:141:0x0275, B:143:0x027b, B:147:0x028d, B:149:0x0291, B:151:0x0297, B:153:0x02a5, B:155:0x02a9, B:156:0x02b2, B:158:0x02b8, B:162:0x02ca, B:165:0x02d3, B:167:0x02da, B:169:0x02de, B:171:0x02e5, B:174:0x02f1, B:10:0x0035, B:12:0x003b, B:14:0x003f), top: B:180:0x0021 }] */
            /* JADX WARN: Code duplicated, block: B:108:0x01cd A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:4:0x0021, B:6:0x002b, B:8:0x002f, B:15:0x0045, B:175:0x02fa, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:36:0x008f, B:50:0x00ae, B:51:0x00b1, B:53:0x00b6, B:54:0x00bc, B:56:0x00c2, B:58:0x00cc, B:60:0x00d2, B:62:0x00d6, B:63:0x00dc, B:65:0x00ee, B:66:0x0100, B:68:0x0115, B:69:0x011f, B:71:0x0125, B:75:0x012f, B:76:0x0135, B:78:0x013b, B:81:0x0147, B:83:0x014f, B:86:0x0159, B:88:0x0170, B:90:0x0174, B:91:0x0178, B:93:0x018a, B:94:0x019c, B:96:0x01a0, B:99:0x01a6, B:101:0x01aa, B:102:0x01ac, B:103:0x01b1, B:104:0x01b8, B:105:0x01c1, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01dd, B:114:0x01e1, B:115:0x01e7, B:117:0x01f9, B:118:0x020b, B:119:0x0211, B:121:0x0217, B:123:0x0221, B:125:0x0227, B:127:0x022b, B:128:0x0231, B:129:0x023b, B:131:0x0241, B:133:0x0257, B:135:0x025d, B:137:0x0263, B:138:0x0267, B:140:0x026b, B:141:0x0275, B:143:0x027b, B:147:0x028d, B:149:0x0291, B:151:0x0297, B:153:0x02a5, B:155:0x02a9, B:156:0x02b2, B:158:0x02b8, B:162:0x02ca, B:165:0x02d3, B:167:0x02da, B:169:0x02de, B:171:0x02e5, B:174:0x02f1, B:10:0x0035, B:12:0x003b, B:14:0x003f), top: B:180:0x0021 }] */
            /* JADX WARN: Code duplicated, block: B:112:0x01dd A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:4:0x0021, B:6:0x002b, B:8:0x002f, B:15:0x0045, B:175:0x02fa, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:36:0x008f, B:50:0x00ae, B:51:0x00b1, B:53:0x00b6, B:54:0x00bc, B:56:0x00c2, B:58:0x00cc, B:60:0x00d2, B:62:0x00d6, B:63:0x00dc, B:65:0x00ee, B:66:0x0100, B:68:0x0115, B:69:0x011f, B:71:0x0125, B:75:0x012f, B:76:0x0135, B:78:0x013b, B:81:0x0147, B:83:0x014f, B:86:0x0159, B:88:0x0170, B:90:0x0174, B:91:0x0178, B:93:0x018a, B:94:0x019c, B:96:0x01a0, B:99:0x01a6, B:101:0x01aa, B:102:0x01ac, B:103:0x01b1, B:104:0x01b8, B:105:0x01c1, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01dd, B:114:0x01e1, B:115:0x01e7, B:117:0x01f9, B:118:0x020b, B:119:0x0211, B:121:0x0217, B:123:0x0221, B:125:0x0227, B:127:0x022b, B:128:0x0231, B:129:0x023b, B:131:0x0241, B:133:0x0257, B:135:0x025d, B:137:0x0263, B:138:0x0267, B:140:0x026b, B:141:0x0275, B:143:0x027b, B:147:0x028d, B:149:0x0291, B:151:0x0297, B:153:0x02a5, B:155:0x02a9, B:156:0x02b2, B:158:0x02b8, B:162:0x02ca, B:165:0x02d3, B:167:0x02da, B:169:0x02de, B:171:0x02e5, B:174:0x02f1, B:10:0x0035, B:12:0x003b, B:14:0x003f), top: B:180:0x0021 }] */
            /* JADX WARN: Code duplicated, block: B:113:0x01e0  */
            /* JADX WARN: Code duplicated, block: B:118:0x020b A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:4:0x0021, B:6:0x002b, B:8:0x002f, B:15:0x0045, B:175:0x02fa, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:36:0x008f, B:50:0x00ae, B:51:0x00b1, B:53:0x00b6, B:54:0x00bc, B:56:0x00c2, B:58:0x00cc, B:60:0x00d2, B:62:0x00d6, B:63:0x00dc, B:65:0x00ee, B:66:0x0100, B:68:0x0115, B:69:0x011f, B:71:0x0125, B:75:0x012f, B:76:0x0135, B:78:0x013b, B:81:0x0147, B:83:0x014f, B:86:0x0159, B:88:0x0170, B:90:0x0174, B:91:0x0178, B:93:0x018a, B:94:0x019c, B:96:0x01a0, B:99:0x01a6, B:101:0x01aa, B:102:0x01ac, B:103:0x01b1, B:104:0x01b8, B:105:0x01c1, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01dd, B:114:0x01e1, B:115:0x01e7, B:117:0x01f9, B:118:0x020b, B:119:0x0211, B:121:0x0217, B:123:0x0221, B:125:0x0227, B:127:0x022b, B:128:0x0231, B:129:0x023b, B:131:0x0241, B:133:0x0257, B:135:0x025d, B:137:0x0263, B:138:0x0267, B:140:0x026b, B:141:0x0275, B:143:0x027b, B:147:0x028d, B:149:0x0291, B:151:0x0297, B:153:0x02a5, B:155:0x02a9, B:156:0x02b2, B:158:0x02b8, B:162:0x02ca, B:165:0x02d3, B:167:0x02da, B:169:0x02de, B:171:0x02e5, B:174:0x02f1, B:10:0x0035, B:12:0x003b, B:14:0x003f), top: B:180:0x0021 }] */
            /* JADX WARN: Code duplicated, block: B:121:0x0217 A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:4:0x0021, B:6:0x002b, B:8:0x002f, B:15:0x0045, B:175:0x02fa, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:36:0x008f, B:50:0x00ae, B:51:0x00b1, B:53:0x00b6, B:54:0x00bc, B:56:0x00c2, B:58:0x00cc, B:60:0x00d2, B:62:0x00d6, B:63:0x00dc, B:65:0x00ee, B:66:0x0100, B:68:0x0115, B:69:0x011f, B:71:0x0125, B:75:0x012f, B:76:0x0135, B:78:0x013b, B:81:0x0147, B:83:0x014f, B:86:0x0159, B:88:0x0170, B:90:0x0174, B:91:0x0178, B:93:0x018a, B:94:0x019c, B:96:0x01a0, B:99:0x01a6, B:101:0x01aa, B:102:0x01ac, B:103:0x01b1, B:104:0x01b8, B:105:0x01c1, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01dd, B:114:0x01e1, B:115:0x01e7, B:117:0x01f9, B:118:0x020b, B:119:0x0211, B:121:0x0217, B:123:0x0221, B:125:0x0227, B:127:0x022b, B:128:0x0231, B:129:0x023b, B:131:0x0241, B:133:0x0257, B:135:0x025d, B:137:0x0263, B:138:0x0267, B:140:0x026b, B:141:0x0275, B:143:0x027b, B:147:0x028d, B:149:0x0291, B:151:0x0297, B:153:0x02a5, B:155:0x02a9, B:156:0x02b2, B:158:0x02b8, B:162:0x02ca, B:165:0x02d3, B:167:0x02da, B:169:0x02de, B:171:0x02e5, B:174:0x02f1, B:10:0x0035, B:12:0x003b, B:14:0x003f), top: B:180:0x0021 }] */
            /* JADX WARN: Code duplicated, block: B:125:0x0227 A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:4:0x0021, B:6:0x002b, B:8:0x002f, B:15:0x0045, B:175:0x02fa, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:36:0x008f, B:50:0x00ae, B:51:0x00b1, B:53:0x00b6, B:54:0x00bc, B:56:0x00c2, B:58:0x00cc, B:60:0x00d2, B:62:0x00d6, B:63:0x00dc, B:65:0x00ee, B:66:0x0100, B:68:0x0115, B:69:0x011f, B:71:0x0125, B:75:0x012f, B:76:0x0135, B:78:0x013b, B:81:0x0147, B:83:0x014f, B:86:0x0159, B:88:0x0170, B:90:0x0174, B:91:0x0178, B:93:0x018a, B:94:0x019c, B:96:0x01a0, B:99:0x01a6, B:101:0x01aa, B:102:0x01ac, B:103:0x01b1, B:104:0x01b8, B:105:0x01c1, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01dd, B:114:0x01e1, B:115:0x01e7, B:117:0x01f9, B:118:0x020b, B:119:0x0211, B:121:0x0217, B:123:0x0221, B:125:0x0227, B:127:0x022b, B:128:0x0231, B:129:0x023b, B:131:0x0241, B:133:0x0257, B:135:0x025d, B:137:0x0263, B:138:0x0267, B:140:0x026b, B:141:0x0275, B:143:0x027b, B:147:0x028d, B:149:0x0291, B:151:0x0297, B:153:0x02a5, B:155:0x02a9, B:156:0x02b2, B:158:0x02b8, B:162:0x02ca, B:165:0x02d3, B:167:0x02da, B:169:0x02de, B:171:0x02e5, B:174:0x02f1, B:10:0x0035, B:12:0x003b, B:14:0x003f), top: B:180:0x0021 }] */
            /* JADX WARN: Code duplicated, block: B:126:0x022a  */
            /* JADX WARN: Code duplicated, block: B:131:0x0241 A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:4:0x0021, B:6:0x002b, B:8:0x002f, B:15:0x0045, B:175:0x02fa, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:36:0x008f, B:50:0x00ae, B:51:0x00b1, B:53:0x00b6, B:54:0x00bc, B:56:0x00c2, B:58:0x00cc, B:60:0x00d2, B:62:0x00d6, B:63:0x00dc, B:65:0x00ee, B:66:0x0100, B:68:0x0115, B:69:0x011f, B:71:0x0125, B:75:0x012f, B:76:0x0135, B:78:0x013b, B:81:0x0147, B:83:0x014f, B:86:0x0159, B:88:0x0170, B:90:0x0174, B:91:0x0178, B:93:0x018a, B:94:0x019c, B:96:0x01a0, B:99:0x01a6, B:101:0x01aa, B:102:0x01ac, B:103:0x01b1, B:104:0x01b8, B:105:0x01c1, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01dd, B:114:0x01e1, B:115:0x01e7, B:117:0x01f9, B:118:0x020b, B:119:0x0211, B:121:0x0217, B:123:0x0221, B:125:0x0227, B:127:0x022b, B:128:0x0231, B:129:0x023b, B:131:0x0241, B:133:0x0257, B:135:0x025d, B:137:0x0263, B:138:0x0267, B:140:0x026b, B:141:0x0275, B:143:0x027b, B:147:0x028d, B:149:0x0291, B:151:0x0297, B:153:0x02a5, B:155:0x02a9, B:156:0x02b2, B:158:0x02b8, B:162:0x02ca, B:165:0x02d3, B:167:0x02da, B:169:0x02de, B:171:0x02e5, B:174:0x02f1, B:10:0x0035, B:12:0x003b, B:14:0x003f), top: B:180:0x0021 }] */
            /* JADX WARN: Code duplicated, block: B:133:0x0257 A[Catch: all -> 0x008c, TryCatch #0 {all -> 0x008c, blocks: (B:4:0x0021, B:6:0x002b, B:8:0x002f, B:15:0x0045, B:175:0x02fa, B:24:0x0068, B:25:0x006e, B:27:0x0074, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:36:0x008f, B:50:0x00ae, B:51:0x00b1, B:53:0x00b6, B:54:0x00bc, B:56:0x00c2, B:58:0x00cc, B:60:0x00d2, B:62:0x00d6, B:63:0x00dc, B:65:0x00ee, B:66:0x0100, B:68:0x0115, B:69:0x011f, B:71:0x0125, B:75:0x012f, B:76:0x0135, B:78:0x013b, B:81:0x0147, B:83:0x014f, B:86:0x0159, B:88:0x0170, B:90:0x0174, B:91:0x0178, B:93:0x018a, B:94:0x019c, B:96:0x01a0, B:99:0x01a6, B:101:0x01aa, B:102:0x01ac, B:103:0x01b1, B:104:0x01b8, B:105:0x01c1, B:106:0x01c7, B:108:0x01cd, B:110:0x01d7, B:112:0x01dd, B:114:0x01e1, B:115:0x01e7, B:117:0x01f9, B:118:0x020b, B:119:0x0211, B:121:0x0217, B:123:0x0221, B:125:0x0227, B:127:0x022b, B:128:0x0231, B:129:0x023b, B:131:0x0241, B:133:0x0257, B:135:0x025d, B:137:0x0263, B:138:0x0267, B:140:0x026b, B:141:0x0275, B:143:0x027b, B:147:0x028d, B:149:0x0291, B:151:0x0297, B:153:0x02a5, B:155:0x02a9, B:156:0x02b2, B:158:0x02b8, B:162:0x02ca, B:165:0x02d3, B:167:0x02da, B:169:0x02de, B:171:0x02e5, B:174:0x02f1, B:10:0x0035, B:12:0x003b, B:14:0x003f), top: B:180:0x0021 }] */
            /* JADX WARN: Code duplicated, block: B:134:0x025c  */
            /* JADX WARN: Code duplicated, block: B:213:0x01e7 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:214:0x01f9 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:215:0x01d7 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:217:0x01c7 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:221:0x0221 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:223:0x0211 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:226:0x0263 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:228:0x023b A[SYNTHETIC] */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                T t3;
                T t8;
                Iterator it;
                String address;
                BluetoothDevice bluetoothDevice;
                String address2;
                T t10;
                g5 g5Var;
                NearDevice nearDevice;
                T t11;
                g5 g5Var2;
                NearDevice nearDevice2;
                Map.Entry entry;
                Pair pair;
                NearDevice nearDevice3;
                T t12;
                NearDevice nearDevice4;
                BluetoothDevice bluetoothDeviceQ;
                int i11 = i9;
                int i12 = i8;
                com.welink.protocol.nfbd.b0 b0Var2 = b0Var;
                NearDeviceDataParcel nearDeviceDataParcel2 = nearDeviceDataParcel;
                WifiP2pDevice wifiP2pDevice2 = wifiP2pDevice;
                String str2 = str;
                TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo(i11, (String) null, i12, 0, 0, 56);
                synchronized (b0Var2.e) {
                    try {
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        g5 g5Var3 = b0Var2.f;
                        if (g5Var3 == null || (nearDevice4 = g5Var3.f9750g) == null || (bluetoothDeviceQ = com.welink.protocol.nfbd.b0.q(nearDevice4)) == null) {
                            t3 = bluetoothDeviceQ;
                            HashMap map = b0Var2.e;
                            g5 g5Var4 = b0Var2.f;
                            t3 = (BluetoothDevice) map.get(g5Var4 != null ? g5Var4.f9746a : null);
                        }
                        t3 = bluetoothDeviceQ;
                        objectRef.element = t3;
                        we.h.h("TranFileSendController", "Notify Active event: " + i11);
                        if (i11 == 1) {
                            if (objectRef.element == 0) {
                                Iterator it2 = b0Var2.f4056h.entrySet().iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        t8 = 0;
                                        break;
                                    }
                                    BluetoothDevice bluetoothDevice2 = ((g2) ((Map.Entry) it2.next()).getValue()).f9743a;
                                    if (bluetoothDevice2 != null) {
                                        t8 = bluetoothDevice2;
                                        break;
                                    }
                                }
                                objectRef.element = t8;
                            }
                            TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = (TranConnectionController$P2pDeviceInfo) (nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null);
                            Pair pair2 = TuplesKt.to(objectRef.element, wifiP2pDevice2);
                            HashMap map2 = b0Var2.f4057i;
                            g5 g5Var5 = b0Var2.f;
                            map2.put(g5Var5 != null ? g5Var5.f9746a : null, pair2);
                            for (w wVar : b0Var2.p) {
                                BluetoothDevice bluetoothDevice3 = (BluetoothDevice) objectRef.element;
                                if (bluetoothDevice3 != null && wifiP2pDevice2 != null) {
                                    String str3 = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.f3979d : null;
                                    String str4 = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.e : null;
                                    g5 g5Var6 = b0Var2.f;
                                    wVar.d(bluetoothDevice3, wifiP2pDevice2, str2, str3, str4, tranConnectionController$P2pDeviceInfo, g5Var6 != null ? g5Var6.f9750g : null);
                                }
                                wifiP2pDevice2 = wifiP2pDevice2;
                            }
                            b0Var2.f4056h.clear();
                            b0Var2.o(false);
                        } else if (i11 != 4) {
                            if (i11 == 10) {
                                we.h.h("TranFileSendController", "Notify Stop Scan event, ignore this event");
                            } else if (i11 == 18) {
                                for (w wVar2 : b0Var2.p) {
                                    g5 g5Var7 = b0Var2.f;
                                    if (g5Var7 != null && (nearDevice3 = g5Var7.f9750g) != null && (t12 = objectRef.element) != 0) {
                                        wVar2.a((BluetoothDevice) t12, nearDevice3);
                                    }
                                }
                            }
                        } else if (i12 == -3 || i12 == -2 || i12 == 0) {
                            for (w wVar3 : b0Var2.p) {
                                t10 = objectRef.element;
                                if (t10 != 0) {
                                    BluetoothDevice bluetoothDevice4 = (BluetoothDevice) t10;
                                    g5Var = b0Var2.f;
                                    if (g5Var != null) {
                                        nearDevice = g5Var.f9750g;
                                    } else {
                                        nearDevice = null;
                                    }
                                    wVar3.b(tranConnectionController$EventInfo.f3966c, bluetoothDevice4, nearDevice);
                                }
                            }
                            it = b0Var2.e.entrySet().iterator();
                            while (it.hasNext()) {
                                address = ((BluetoothDevice) ((Map.Entry) it.next()).getValue()).getAddress();
                                bluetoothDevice = (BluetoothDevice) objectRef.element;
                                if (bluetoothDevice != null) {
                                    address2 = bluetoothDevice.getAddress();
                                } else {
                                    address2 = null;
                                }
                                if (Intrinsics.areEqual(address, address2)) {
                                    it.remove();
                                }
                            }
                        } else if (i12 == 1 || i12 == 3) {
                            for (w wVar4 : b0Var2.p) {
                                t11 = objectRef.element;
                                if (t11 != 0) {
                                    BluetoothDevice bluetoothDevice5 = (BluetoothDevice) t11;
                                    g5Var2 = b0Var2.f;
                                    if (g5Var2 != null) {
                                        nearDevice2 = g5Var2.f9750g;
                                    } else {
                                        nearDevice2 = null;
                                    }
                                    wVar4.b(tranConnectionController$EventInfo.f3966c, bluetoothDevice5, nearDevice2);
                                } else {
                                    Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
                                    Intrinsics.checkNotNullParameter("Bluetooth device is null", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TranFileSendController", "TransConnect:Bluetooth device is null", null);
                                    }
                                }
                            }
                        } else if (i12 == 24) {
                            while (r0.hasNext()) {
                                t10 = objectRef.element;
                                if (t10 != 0) {
                                    BluetoothDevice bluetoothDevice6 = (BluetoothDevice) t10;
                                    g5Var = b0Var2.f;
                                    if (g5Var != null) {
                                        nearDevice = g5Var.f9750g;
                                    } else {
                                        nearDevice = null;
                                    }
                                    wVar3.b(tranConnectionController$EventInfo.f3966c, bluetoothDevice6, nearDevice);
                                }
                            }
                            it = b0Var2.e.entrySet().iterator();
                            while (it.hasNext()) {
                                address = ((BluetoothDevice) ((Map.Entry) it.next()).getValue()).getAddress();
                                bluetoothDevice = (BluetoothDevice) objectRef.element;
                                if (bluetoothDevice != null) {
                                    address2 = bluetoothDevice.getAddress();
                                } else {
                                    address2 = null;
                                }
                                if (Intrinsics.areEqual(address, address2)) {
                                    it.remove();
                                }
                            }
                        } else if (i12 == 5) {
                            b0Var2.f(new o5(b0Var2, 3));
                            b0Var2.f4056h.clear();
                            if (b0Var2.f4057i.isEmpty()) {
                                we.h.j("TranFileSendController", "Connected devices map is empty, p2p connect failed?");
                            } else {
                                Iterator it3 = b0Var2.f4057i.entrySet().iterator();
                                do {
                                    if (!it3.hasNext()) {
                                        entry = null;
                                        break;
                                    }
                                    entry = (Map.Entry) it3.next();
                                } while (entry == null);
                                for (w wVar5 : b0Var2.p) {
                                    if (objectRef.element == 0) {
                                        Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
                                        Intrinsics.checkNotNullParameter("Bluetooth device is null", "mes");
                                        if (lb.f6529c >= 1) {
                                            Log.e("TranFileSendController", "TransConnect:Bluetooth device is null", null);
                                        }
                                    } else if (((entry == null || (pair = (Pair) entry.getValue()) == null) ? null : (WifiP2pDevice) pair.getSecond()) != null) {
                                        BluetoothDevice bluetoothDevice7 = (BluetoothDevice) objectRef.element;
                                        Object second = ((Pair) entry.getValue()).getSecond();
                                        Intrinsics.checkNotNull(second);
                                        WifiP2pDevice wifiP2pDevice3 = (WifiP2pDevice) second;
                                        g5 g5Var8 = b0Var2.f;
                                        wVar5.e(bluetoothDevice7, wifiP2pDevice3, true, g5Var8 != null ? g5Var8.f9750g : null);
                                    }
                                }
                                g5 g5Var9 = b0Var2.f;
                                if ((g5Var9 != null ? g5Var9.f9746a : null) != null) {
                                    b0Var2.f4057i.remove(g5Var9 != null ? g5Var9.f9746a : null);
                                } else {
                                    b0Var2.f4057i.clear();
                                }
                            }
                        } else if (i12 != 6) {
                            switch (i12) {
                                case 9:
                                case 10:
                                case 12:
                                    while (r0.hasNext()) {
                                        t11 = objectRef.element;
                                        if (t11 != 0) {
                                            BluetoothDevice bluetoothDevice8 = (BluetoothDevice) t11;
                                            g5Var2 = b0Var2.f;
                                            if (g5Var2 != null) {
                                                nearDevice2 = g5Var2.f9750g;
                                            } else {
                                                nearDevice2 = null;
                                            }
                                            wVar4.b(tranConnectionController$EventInfo.f3966c, bluetoothDevice8, nearDevice2);
                                        } else {
                                            Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
                                            Intrinsics.checkNotNullParameter("Bluetooth device is null", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("TranFileSendController", "TransConnect:Bluetooth device is null", null);
                                            }
                                        }
                                    }
                                    break;
                                default:
                                    switch (i12) {
                                        case 14:
                                            for (w wVar6 : b0Var2.p) {
                                                T t13 = objectRef.element;
                                                if (t13 != 0) {
                                                    BluetoothDevice bluetoothDevice9 = (BluetoothDevice) t13;
                                                    g5 g5Var10 = b0Var2.f;
                                                    wVar6.b(tranConnectionController$EventInfo.f3966c, bluetoothDevice9, g5Var10 != null ? g5Var10.f9750g : null);
                                                } else {
                                                    Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
                                                    Intrinsics.checkNotNullParameter("Bluetooth device is null", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("TranFileSendController", "TransConnect:Bluetooth device is null", null);
                                                    }
                                                }
                                            }
                                            break;
                                    }
                                case 11:
                                    while (r0.hasNext()) {
                                        t10 = objectRef.element;
                                        if (t10 != 0) {
                                            BluetoothDevice bluetoothDevice10 = (BluetoothDevice) t10;
                                            g5Var = b0Var2.f;
                                            if (g5Var != null) {
                                                nearDevice = g5Var.f9750g;
                                            } else {
                                                nearDevice = null;
                                            }
                                            wVar3.b(tranConnectionController$EventInfo.f3966c, bluetoothDevice10, nearDevice);
                                        }
                                    }
                                    it = b0Var2.e.entrySet().iterator();
                                    while (it.hasNext()) {
                                        address = ((BluetoothDevice) ((Map.Entry) it.next()).getValue()).getAddress();
                                        bluetoothDevice = (BluetoothDevice) objectRef.element;
                                        if (bluetoothDevice != null) {
                                            address2 = bluetoothDevice.getAddress();
                                        } else {
                                            address2 = null;
                                        }
                                        if (Intrinsics.areEqual(address, address2)) {
                                            it.remove();
                                        }
                                    }
                                    break;
                            }
                        } else {
                            while (r0.hasNext()) {
                                t10 = objectRef.element;
                                if (t10 != 0) {
                                    BluetoothDevice bluetoothDevice11 = (BluetoothDevice) t10;
                                    g5Var = b0Var2.f;
                                    if (g5Var != null) {
                                        nearDevice = g5Var.f9750g;
                                    } else {
                                        nearDevice = null;
                                    }
                                    wVar3.b(tranConnectionController$EventInfo.f3966c, bluetoothDevice11, nearDevice);
                                }
                            }
                            it = b0Var2.e.entrySet().iterator();
                            while (it.hasNext()) {
                                address = ((BluetoothDevice) ((Map.Entry) it.next()).getValue()).getAddress();
                                bluetoothDevice = (BluetoothDevice) objectRef.element;
                                if (bluetoothDevice != null) {
                                    address2 = bluetoothDevice.getAddress();
                                } else {
                                    address2 = null;
                                }
                                if (Intrinsics.areEqual(address, address2)) {
                                    it.remove();
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        });
    }

    public static String p(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter("u9ydR8kt65K3cGk1xr7z5m9ft4P4mdq8", "secretKey");
        try {
            Charset charset = Charsets.UTF_8;
            byte[] bytes = "u9ydR8kt65K3cGk1xr7z5m9ft4P4mdq8".getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
            byte[] bytes2 = text.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            String strEncodeToString = Base64.encodeToString(cipher.doFinal(bytes2), 0);
            return Base64.encodeToString(bArr, 0) + ":" + strEncodeToString;
        } catch (Exception e) {
            String mes = "AES encryption failed: " + e.getMessage();
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", mes, null);
            }
            return null;
        }
    }

    public static BluetoothDevice q(NearDevice nearDevice) {
        WirelessDevice wirelessDevice = nearDevice.f3896s;
        if (wirelessDevice instanceof WirelessDevice.Bluetooth) {
            return ((WirelessDevice.Bluetooth) wirelessDevice).f4011d;
        }
        return null;
    }

    public final void k(int i8) {
        h0.a.C(i8, "Send cleanup ", "TranFileSendController");
        int i9 = 0;
        if (i8 <= 3) {
            if (this.f4054d > 2) {
                if (c(this.J)) {
                    h(this.J);
                }
                h4 h4Var = this.f4064r;
                if (h4Var != null) {
                    h4Var.o();
                }
                g(WorkRequest.MIN_BACKOFF_MILLIS, this.L);
            } else if (this.f4054d > 0) {
                if (i8 == 0) {
                    l();
                    g(500L, this.N);
                } else {
                    o(false);
                }
            }
            this.f4054d = 0;
        } else if (i8 == 4) {
            we.h.h("TranFileSendController", "Snd Receive Adapter BT OFF Bypass event");
        } else {
            we.h.h("TranFileSendController", "Snd Receive Unknown Cleanup Event");
        }
        if (this.p.isEmpty()) {
            return;
        }
        if (i8 == 0) {
            i9 = 1;
        } else if (i8 == 1) {
            i9 = 10;
        } else if (i8 == 2) {
            i9 = 3;
        } else if (i8 == 3) {
            i9 = 9;
        } else if (i8 == 4) {
            i9 = 12;
        }
        n(this, i9, 4, 384);
    }

    public final void l() {
        h0.a.C(this.f4054d, "closeBleConnect current state : ", "TranFileSendController");
        this.f4068w = false;
        this.f4069x = false;
        this.f4059k = null;
        if (this.f4054d < 3) {
            this.f4054d = 0;
            h(this.J);
        }
        o(true);
    }

    public final void m() {
        l();
        if (this.p.isEmpty()) {
            return;
        }
        n(this, -2, 4, 384);
    }

    public final void o(boolean z2) {
        synchronized (this.D) {
            try {
                BluetoothGatt bluetoothGatt = this.f4060l;
                if (bluetoothGatt != null && bluetoothGatt != null) {
                    bluetoothGatt.disconnect();
                }
                if (z2) {
                    BluetoothGatt bluetoothGatt2 = this.f4060l;
                    if (bluetoothGatt2 != null) {
                        bluetoothGatt2.close();
                    }
                    this.f4060l = null;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void r(BluetoothGatt bluetoothGatt) {
        String str;
        g5 g5Var = this.f;
        String str2 = g5Var != null ? g5Var.f9746a : null;
        String str3 = this.f4070y;
        String str4 = this.f4071z;
        String str5 = this.A;
        int i8 = this.B;
        String str6 = g5Var != null ? g5Var.f9746a : null;
        DeviceInfo deviceInfo = this.f4058j;
        byte b9 = UByte.MAX_VALUE;
        byte b10 = deviceInfo != null ? deviceInfo.f4220a : (byte) 255;
        if (deviceInfo != null) {
            b9 = deviceInfo.f4221b;
        }
        byte b11 = b9;
        if (deviceInfo == null || (str = deviceInfo.f4222c) == null) {
            str = "0001";
        }
        ConnectRequest connectRequest = new ConnectRequest("1.0", 0, 0, str2, 0, null, 0L, str3, str4, str5, i8, 0, 0, 0, 2, "laptop", str6, b10, b11, str, 0, deviceInfo != null ? deviceInfo.f4227k : 0, 0, null, CollectionsKt.listOf((Object[]) new String[]{"2.4G", "5G", "P2P"}), null, null, 503316480);
        BluetoothDevice device = bluetoothGatt.getDevice();
        Intrinsics.checkNotNullExpressionValue(device, "getDevice(...)");
        this.f4056h.put(bluetoothGatt.getDevice().getAddress(), new g2(device, connectRequest));
        for (se.w wVar : this.p) {
            BluetoothDevice device2 = bluetoothGatt.getDevice();
            Intrinsics.checkNotNullExpressionValue(device2, "getDevice(...)");
            g5 g5Var2 = this.f;
            wVar.j(device2, connectRequest, g5Var2 != null ? g5Var2.f9750g : null);
        }
    }

    public final void s(int i8) {
        h4 h4Var;
        if (i8 == 0) {
            Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
            Intrinsics.checkNotNullParameter("initial ble connect timeout", "mes");
            if (lb.f6529c >= 1) {
                Log.e("TranFileSendController", "TransConnect:initial ble connect timeout", null);
            }
        } else if (i8 == 1) {
            Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
            Intrinsics.checkNotNullParameter("p2p over le connect timeout", "mes");
            if (lb.f6529c >= 1) {
                Log.e("TranFileSendController", "TransConnect:p2p over le connect timeout", null);
            }
        } else if (i8 == 2) {
            Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
            Intrinsics.checkNotNullParameter("remote reject", "mes");
            if (lb.f6529c >= 1) {
                Log.e("TranFileSendController", "TransConnect:remote reject", null);
            }
        }
        l();
        if (this.f4054d > 2 && (h4Var = this.f4064r) != null) {
            h4Var.o();
        }
        this.f4054d = 0;
        if (this.p.isEmpty()) {
            return;
        }
        if (i8 == 0) {
            n(this, 18, 4, 384);
            return;
        }
        if (i8 == 1) {
            n(this, 6, 4, 384);
            return;
        }
        if (i8 != 2) {
            return;
        }
        Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
        Intrinsics.checkNotNullParameter("remote reject handle, disconnect ble connection", "mes");
        if (lb.f6529c >= 1) {
            Log.e("TranFileSendController", "TransConnect:remote reject handle, disconnect ble connection", null);
        }
    }

    public final void t(BluetoothGatt bluetoothGatt) {
        we.h.b("TranFileSendController", "writeTransferCancel");
        UUID uuid = z6.e;
        Intrinsics.checkNotNullExpressionValue(uuid, "<get-FILE_TRANSFER_SEND_UUID>(...)");
        BluetoothGattCharacteristic bluetoothGattCharacteristicB = jd.b(bluetoothGatt, uuid);
        if (bluetoothGattCharacteristicB != null) {
            bluetoothGattCharacteristicB.setValue(new byte[]{-1});
            Integer numValueOf = bluetoothGatt != null ? Integer.valueOf(bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristicB, new byte[]{-1}, 2)) : null;
            if (numValueOf != null && numValueOf.intValue() == 0) {
                return;
            }
            we.h.b("TranFileSendController", "writeCharacteristic fail");
            o(false);
        }
    }
}
