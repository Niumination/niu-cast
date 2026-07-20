package j1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import k3.sc;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f5989a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet f5990b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f5991c = {80, 75, 3, 4};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f5992d = {31, -117, 8};

    public static e0 a(final String str, Callable callable, a4.c cVar) {
        j jVarA = str == null ? null : p1.h.f8640b.a(str);
        e0 e0Var = jVarA != null ? new e0(jVarA) : null;
        HashMap map = f5989a;
        if (str != null && map.containsKey(str)) {
            e0Var = (e0) map.get(str);
        }
        if (e0Var != null) {
            if (cVar != null) {
                cVar.run();
            }
            return e0Var;
        }
        e0 e0Var2 = new e0(callable, false);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final int i8 = 0;
            e0Var2.b(new a0() { // from class: j1.m
                @Override // j1.a0
                public final void onResult(Object obj) {
                    switch (i8) {
                        case 0:
                            HashMap map2 = o.f5989a;
                            map2.remove(str);
                            atomicBoolean.set(true);
                            if (map2.size() == 0) {
                                o.i();
                            }
                            break;
                        default:
                            HashMap map3 = o.f5989a;
                            map3.remove(str);
                            atomicBoolean.set(true);
                            if (map3.size() == 0) {
                                o.i();
                            }
                            break;
                    }
                }
            });
            final int i9 = 1;
            e0Var2.a(new a0() { // from class: j1.m
                @Override // j1.a0
                public final void onResult(Object obj) {
                    switch (i9) {
                        case 0:
                            HashMap map2 = o.f5989a;
                            map2.remove(str);
                            atomicBoolean.set(true);
                            if (map2.size() == 0) {
                                o.i();
                            }
                            break;
                        default:
                            HashMap map3 = o.f5989a;
                            map3.remove(str);
                            atomicBoolean.set(true);
                            if (map3.size() == 0) {
                                o.i();
                            }
                            break;
                    }
                }
            });
            if (!atomicBoolean.get()) {
                map.put(str, e0Var2);
                if (map.size() == 1) {
                    i();
                }
            }
        }
        return e0Var2;
    }

    public static c0 b(Context context, String str, String str2) {
        int i8 = 3;
        j jVarA = str2 == null ? null : p1.h.f8640b.a(str2);
        if (jVarA != null) {
            return new c0(jVarA);
        }
        try {
            qj.t tVarB = sc.b(sc.e(context.getAssets().open(str)));
            if (h(tVarB, f5991c).booleanValue()) {
                return f(context, new ZipInputStream(new mh.b(tVarB, i8)), str2);
            }
            if (h(tVarB, f5992d).booleanValue()) {
                return c(new GZIPInputStream(new mh.b(tVarB, i8)), str2);
            }
            String[] strArr = v1.d.e;
            return d(new v1.e(tVarB), str2, true);
        } catch (IOException e) {
            return new c0(e);
        }
    }

    public static c0 c(InputStream inputStream, String str) {
        qj.t tVarB = sc.b(sc.e(inputStream));
        String[] strArr = v1.d.e;
        return d(new v1.e(tVarB), str, true);
    }

    public static c0 d(v1.e eVar, String str, boolean z2) {
        try {
            j jVarA = str == null ? null : p1.h.f8640b.a(str);
            if (jVarA != null) {
                return new c0(jVarA);
            }
            j jVarA2 = u1.t.a(eVar);
            if (str != null) {
                p1.h.f8640b.f8641a.put(str, jVarA2);
            }
            return new c0(jVarA2);
        } catch (Exception e) {
            return new c0(e);
        } finally {
            if (z2) {
                w1.g.b(eVar);
            }
        }
    }

    public static c0 e(Context context, int i8, String str) {
        int i9 = 3;
        j jVarA = str == null ? null : p1.h.f8640b.a(str);
        if (jVarA != null) {
            return new c0(jVarA);
        }
        try {
            qj.t tVarB = sc.b(sc.e(context.getResources().openRawResource(i8)));
            if (h(tVarB, f5991c).booleanValue()) {
                return f(context, new ZipInputStream(new mh.b(tVarB, i9)), str);
            }
            if (!h(tVarB, f5992d).booleanValue()) {
                String[] strArr = v1.d.e;
                return d(new v1.e(tVarB), str, true);
            }
            try {
                return c(new GZIPInputStream(new mh.b(tVarB, i9)), str);
            } catch (IOException e) {
                return new c0(e);
            }
        } catch (Resources.NotFoundException e4) {
            return new c0(e4);
        }
    }

    public static c0 f(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return g(context, zipInputStream, str);
        } finally {
            w1.g.b(zipInputStream);
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x014a A[Catch: IOException -> 0x001d, TryCatch #5 {IOException -> 0x001d, blocks: (B:7:0x0017, B:11:0x0020, B:14:0x0029, B:16:0x0035, B:77:0x017a, B:17:0x003a, B:19:0x0046, B:20:0x004b, B:22:0x0057, B:23:0x006e, B:26:0x0078, B:28:0x0080, B:30:0x0088, B:33:0x0092, B:35:0x009a, B:38:0x00a3, B:39:0x00a8, B:41:0x00ba, B:43:0x00db, B:72:0x0140, B:74:0x014a, B:75:0x0167, B:71:0x011f, B:76:0x016b, B:5:0x000f, B:44:0x00e4, B:55:0x0105, B:70:0x011e, B:69:0x011b, B:66:0x0116, B:45:0x00e9, B:54:0x0102, B:65:0x0115, B:64:0x0112), top: B:138:0x000f, inners: #2 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:74:0x014a, please report this as an issue */
    public static c0 g(Context context, ZipInputStream zipInputStream, String str) {
        j jVarA;
        z zVar;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            jVarA = null;
        } else {
            try {
                jVarA = p1.h.f8640b.a(str);
            } catch (IOException e) {
                return new c0(e);
            }
        }
        if (jVarA != null) {
            return new c0(jVarA);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        j jVar = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                qj.t tVarB = sc.b(sc.e(zipInputStream));
                String[] strArr = v1.d.e;
                jVar = d(new v1.e(tVarB), null, false).f5943a;
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split("/");
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split("/");
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split("\\.")[0];
                if (context == null) {
                    return new c0(new IllegalStateException("Unable to extract font " + str3 + " please pass a non-null Context parameter"));
                }
                File file = new File(context.getCacheDir(), str2);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i8 = zipInputStream.read(bArr);
                                if (i8 == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i8);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            fileOutputStream.close();
                            Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                w1.b.b("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            map2.put(str3, typefaceCreateFromFile);
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                        }
                        throw th4;
                    }
                } catch (Throwable th6) {
                    w1.b.c("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th6);
                    Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                    if (!file.delete()) {
                        w1.b.b("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                    }
                    map2.put(str3, typefaceCreateFromFile2);
                    nextEntry = zipInputStream.getNextEntry();
                }
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (jVar == null) {
            return new c0(new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            String str4 = (String) entry.getKey();
            Iterator it = ((HashMap) jVar.c()).values().iterator();
            do {
                if (!it.hasNext()) {
                    zVar = null;
                    break;
                }
                zVar = (z) it.next();
            } while (!zVar.f6034d.equals(str4));
            if (zVar != null) {
                zVar.f = w1.g.d((Bitmap) entry.getValue(), zVar.f6031a, zVar.f6032b);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z2 = false;
            for (p1.d dVar : jVar.f.values()) {
                if (dVar.f8629a.equals(entry2.getKey())) {
                    dVar.f8632d = (Typeface) entry2.getValue();
                    z2 = true;
                }
            }
            if (!z2) {
                w1.b.b("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator it2 = ((HashMap) jVar.c()).entrySet().iterator();
            while (it2.hasNext()) {
                z zVar2 = (z) ((Map.Entry) it2.next()).getValue();
                if (zVar2 == null) {
                    return null;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                String str5 = zVar2.f6034d;
                if (str5.startsWith("data:") && str5.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(str5.substring(str5.indexOf(44) + 1), 0);
                        zVar2.f = w1.g.d(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options), zVar2.f6031a, zVar2.f6032b);
                    } catch (IllegalArgumentException e4) {
                        w1.b.c("data URL did not have correct base64 format.", e4);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            p1.h.f8640b.f8641a.put(str, jVar);
        }
        return new c0(jVar);
    }

    public static Boolean h(qj.t tVar, byte[] bArr) {
        try {
            qj.t tVarB = sc.b(new qj.r(tVar));
            for (byte b9 : bArr) {
                if (tVarB.readByte() != b9) {
                    return Boolean.FALSE;
                }
            }
            tVarB.close();
            return Boolean.TRUE;
        } catch (Exception unused) {
            w1.b.f10628a.getClass();
            a aVar = d.f5945a;
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused2) {
            return Boolean.FALSE;
        }
    }

    public static void i() {
        ArrayList arrayList = new ArrayList(f5990b);
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    public static String j(Context context, int i8) {
        StringBuilder sb2 = new StringBuilder("rawRes");
        sb2.append((context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_");
        sb2.append(i8);
        return sb2.toString();
    }
}
