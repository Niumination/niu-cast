package g3;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f5099d = null;
    public static String e = null;
    public static boolean f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f5100g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f5101h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static k f5105l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static l f5106m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5107a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ThreadLocal f5102i = new ThreadLocal();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final h f5103j = new h(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final p2.d f5104k = new p2.d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ph.c f5097b = new ph.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q5.a f5098c = new q5.a();

    public e(Context context) {
        u2.l.e(context);
        this.f5107a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (u2.l.h(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e4) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e4.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01db A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x01ec A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:105:0x01f8 A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0209 A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x021f A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TRY_LEAVE, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x022c  */
    /* JADX WARN: Code duplicated, block: B:114:0x0230  */
    /* JADX WARN: Code duplicated, block: B:117:0x0237  */
    /* JADX WARN: Code duplicated, block: B:120:0x023e A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TRY_ENTER, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0247 A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0250 A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x025f  */
    /* JADX WARN: Code duplicated, block: B:164:0x0303 A[Catch: all -> 0x007e, TryCatch #15 {all -> 0x007e, blocks: (B:3:0x002c, B:7:0x0075, B:15:0x0086, B:18:0x008c, B:29:0x00be, B:134:0x026d, B:139:0x027a, B:140:0x0282, B:138:0x0273, B:148:0x0292, B:150:0x02b2, B:152:0x02c4, B:162:0x02fa, B:163:0x0302, B:143:0x0285, B:144:0x0286, B:145:0x028e, B:164:0x0303, B:165:0x0317, B:166:0x0318, B:167:0x0345), top: B:192:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:177:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:18:0x008c A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #15 {all -> 0x007e, blocks: (B:3:0x002c, B:7:0x0075, B:15:0x0086, B:18:0x008c, B:29:0x00be, B:134:0x026d, B:139:0x027a, B:140:0x0282, B:138:0x0273, B:148:0x0292, B:150:0x02b2, B:152:0x02c4, B:162:0x02fa, B:163:0x0302, B:143:0x0285, B:144:0x0286, B:145:0x028e, B:164:0x0303, B:165:0x0317, B:166:0x0318, B:167:0x0345), top: B:192:0x002c }] */
    /* JADX WARN: Code duplicated, block: B:21:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:22:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c9 A[Catch: all -> 0x025b, TryCatch #13 {all -> 0x025b, blocks: (B:32:0x00c3, B:34:0x00c9, B:35:0x00cb), top: B:188:0x00c3 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ce A[Catch: all -> 0x0174, a -> 0x0178, RemoteException -> 0x017d, TRY_ENTER, TryCatch #14 {RemoteException -> 0x017d, a -> 0x0178, all -> 0x0174, blocks: (B:31:0x00c2, B:37:0x00ce, B:39:0x00d4, B:40:0x00ef, B:44:0x00f5, B:46:0x00fd, B:48:0x0101, B:49:0x010f), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d4 A[Catch: all -> 0x0174, a -> 0x0178, RemoteException -> 0x017d, TryCatch #14 {RemoteException -> 0x017d, a -> 0x0178, all -> 0x0174, blocks: (B:31:0x00c2, B:37:0x00ce, B:39:0x00d4, B:40:0x00ef, B:44:0x00f5, B:46:0x00fd, B:48:0x0101, B:49:0x010f), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f5 A[Catch: all -> 0x0174, a -> 0x0178, RemoteException -> 0x017d, TRY_ENTER, TryCatch #14 {RemoteException -> 0x017d, a -> 0x0178, all -> 0x0174, blocks: (B:31:0x00c2, B:37:0x00ce, B:39:0x00d4, B:40:0x00ef, B:44:0x00f5, B:46:0x00fd, B:48:0x0101, B:49:0x010f), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x018d A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x019f A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01c0 A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01d3 A[Catch: all -> 0x0136, a -> 0x0138, RemoteException -> 0x013b, TryCatch #13 {RemoteException -> 0x013b, a -> 0x0138, all -> 0x0136, blocks: (B:57:0x011d, B:66:0x0153, B:68:0x015b, B:70:0x0164, B:71:0x016c, B:65:0x013e, B:77:0x0173, B:84:0x0182, B:85:0x018c, B:86:0x018d, B:87:0x0197, B:91:0x019c, B:94:0x019f, B:96:0x01c0, B:98:0x01d3, B:100:0x01db, B:107:0x0219, B:109:0x021f, B:120:0x023e, B:121:0x0246, B:101:0x01ec, B:102:0x01f4, B:105:0x01f8, B:106:0x0209, B:122:0x0247, B:123:0x024f, B:124:0x0250, B:125:0x025a, B:133:0x026c), top: B:178:0x00c2 }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:72:0x016d
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static g3.e c(android.content.Context r20, g3.d r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.e.c(android.content.Context, g3.d, java.lang.String):g3.e");
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0095 A[Catch: all -> 0x0036, TryCatch #4 {all -> 0x0036, blocks: (B:9:0x0027, B:11:0x0033, B:48:0x009e, B:16:0x003a, B:18:0x0040, B:20:0x0046, B:25:0x004c, B:27:0x0050, B:30:0x0059, B:32:0x0061, B:35:0x0068, B:39:0x007d, B:40:0x0085, B:38:0x006f, B:43:0x0088, B:46:0x008b, B:47:0x0095, B:17:0x003d), top: B:137:0x0027, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x015d  */
    public static int d(Context context, String str, boolean z2) {
        Throwable th2;
        RemoteException e4;
        int i8;
        Cursor cursor;
        try {
            synchronized (e.class) {
                Boolean bool = f5099d;
                boolean z3 = true;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteModule$DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else {
                                    if (classLoader == null) {
                                        if (!g(context)) {
                                            return 0;
                                        }
                                        if (f) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        } else {
                                            Boolean bool2 = Boolean.TRUE;
                                            if (bool2.equals(null)) {
                                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                                bool = Boolean.FALSE;
                                            } else {
                                                try {
                                                    int iE = e(context, str, z2, true);
                                                    String str2 = e;
                                                    if (str2 != null && !str2.isEmpty()) {
                                                        ClassLoader classLoaderB = g.b();
                                                        if (classLoaderB == null) {
                                                            String str3 = e;
                                                            u2.l.e(str3);
                                                            classLoaderB = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                                        }
                                                        f(classLoaderB);
                                                        declaredField.set(null, classLoaderB);
                                                        f5099d = bool2;
                                                        return iE;
                                                    }
                                                    return iE;
                                                } catch (a unused) {
                                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                                    bool = Boolean.FALSE;
                                                }
                                            }
                                        }
                                        try {
                                            u2.l.e(context);
                                        } catch (Exception e10) {
                                            Log.e("CrashUtils", "Error adding exception to DropBox!", e10);
                                        }
                                        throw th;
                                    }
                                    try {
                                        f(classLoader);
                                    } catch (a unused2) {
                                    }
                                    bool = Boolean.TRUE;
                                }
                                f5099d = bool;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e11) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e11.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return e(context, str, z2, false);
                    } catch (a e12) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e12.getMessage());
                        return 0;
                    }
                }
                k kVarH = h(context);
                try {
                    if (kVarH == null) {
                        return 0;
                    }
                    try {
                        Parcel parcelG = kVarH.g(kVarH.i(), 6);
                        int i9 = parcelG.readInt();
                        parcelG.recycle();
                        if (i9 >= 3) {
                            ThreadLocal threadLocal = f5102i;
                            i iVar = (i) threadLocal.get();
                            if (iVar != null && (cursor = iVar.f5111a) != null) {
                                return cursor.getInt(0);
                            }
                            Cursor cursor3 = (Cursor) f3.b.l(kVarH.o(new f3.b(context), str, z2, ((Long) f5103j.get()).longValue()));
                            if (cursor3 != null) {
                                try {
                                    if (cursor3.moveToFirst()) {
                                        i8 = cursor3.getInt(0);
                                        if (i8 > 0) {
                                            i iVar2 = (i) threadLocal.get();
                                            if (iVar2 == null || iVar2.f5111a != null) {
                                                z3 = false;
                                            } else {
                                                iVar2.f5111a = cursor3;
                                            }
                                            cursor2 = z3 ? null : cursor3;
                                        }
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                    }
                                } catch (RemoteException e13) {
                                    e4 = e13;
                                    cursor2 = cursor3;
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e4.getMessage());
                                    if (cursor2 == null) {
                                        return 0;
                                    }
                                    cursor2.close();
                                    return 0;
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    cursor2 = cursor3;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th2;
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            if (cursor3 == null) {
                                return 0;
                            }
                            cursor3.close();
                            return 0;
                        }
                        if (i9 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                            f3.b bVar = new f3.b(context);
                            Parcel parcelI = kVarH.i();
                            i3.a.c(parcelI, bVar);
                            parcelI.writeString(str);
                            parcelI.writeInt(z2 ? 1 : 0);
                            Parcel parcelG2 = kVarH.g(parcelI, 5);
                            i8 = parcelG2.readInt();
                            parcelG2.recycle();
                        } else {
                            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                            f3.b bVar2 = new f3.b(context);
                            Parcel parcelI2 = kVarH.i();
                            i3.a.c(parcelI2, bVar2);
                            parcelI2.writeString(str);
                            parcelI2.writeInt(z2 ? 1 : 0);
                            Parcel parcelG3 = kVarH.g(parcelI2, 3);
                            i8 = parcelG3.readInt();
                            parcelG3.recycle();
                        }
                        return i8;
                    } catch (RemoteException e14) {
                        e4 = e14;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                }
            }
        } catch (Throwable th6) {
            u2.l.e(context);
            throw th6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00dd  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public static int e(Context context, String str, boolean z2, boolean z3) throws Throwable {
        Throwable th2;
        Exception e4;
        boolean z5;
        ?? r7 = 0;
        try {
            try {
                boolean z10 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z2 ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) f5103j.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z11 = false;
                            int i8 = cursorQuery.getInt(0);
                            if (i8 > 0) {
                                synchronized (e.class) {
                                    try {
                                        e = cursorQuery.getString(2);
                                        int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            f5100g = cursorQuery.getInt(columnIndex);
                                        }
                                        int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                        if (columnIndex2 >= 0) {
                                            z5 = cursorQuery.getInt(columnIndex2) != 0;
                                            f = z5;
                                        } else {
                                            z5 = false;
                                        }
                                    } catch (Throwable th3) {
                                        throw th3;
                                    }
                                }
                                i iVar = (i) f5102i.get();
                                if (iVar == null || iVar.f5111a != null) {
                                    z10 = false;
                                } else {
                                    iVar.f5111a = cursorQuery;
                                }
                                if (z10) {
                                    cursorQuery = null;
                                }
                                z11 = z5;
                            }
                            if (z3 && z11) {
                                throw new a("forcing fallback to container DynamiteLoader impl", null);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i8;
                        }
                    } catch (Exception e10) {
                        e4 = e10;
                        if (e4 instanceof a) {
                            throw e4;
                        }
                        throw new a("V2 version check failed", e4, null);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new a("Failed to connect to dynamite module ContentResolver.", null);
            } catch (Throwable th4) {
                th2 = th4;
                r7 = context;
                if (r7 != 0) {
                    r7.close();
                }
                throw th2;
            }
        } catch (Exception e11) {
            e4 = e11;
        } catch (Throwable th5) {
            th2 = th5;
            if (r7 != 0) {
                r7.close();
            }
            throw th2;
        }
    }

    public static void f(ClassLoader classLoader) throws a {
        l lVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                lVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                lVar = iInterfaceQueryLocalInterface instanceof l ? (l) iInterfaceQueryLocalInterface : new l(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 1);
            }
            f5106m = lVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e4) {
            throw new a("Failed to instantiate dynamite loader", e4, null);
        }
    }

    public static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f5101h)) {
            return true;
        }
        boolean z2 = false;
        if (f5101h == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (p2.b.f8650b.c(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z2 = true;
            }
            f5101h = Boolean.valueOf(z2);
            if (z2 && providerInfoResolveContentProvider != null && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f = true;
            }
        }
        if (!z2) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z2;
    }

    public static k h(Context context) {
        k kVar;
        synchronized (e.class) {
            k kVar2 = f5105l;
            if (kVar2 != null) {
                return kVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    kVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    kVar = iInterfaceQueryLocalInterface instanceof k ? (k) iInterfaceQueryLocalInterface : new k(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 1);
                }
                if (kVar != null) {
                    f5105l = kVar;
                    return kVar;
                }
            } catch (Exception e4) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e4.getMessage());
            }
            return null;
        }
    }

    public final IBinder b(String str) {
        try {
            return (IBinder) this.f5107a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e4) {
            throw new a("Failed to instantiate module class: ".concat(str), e4, null);
        }
    }
}
