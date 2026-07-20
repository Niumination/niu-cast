package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.yd;
import m3.b7;
import m3.g7;
import m3.h7;
import m3.ja;
import m3.ka;
import m3.la;
import m3.m7;
import m3.oa;
import m3.qa;
import m3.ra;
import m3.sa;
import o5.c;
import q3.g;
import q3.h;
import q3.k;
import tc.d;
import tj.w;
import u2.l;
import v5.f;
import w5.a;
import x5.e;

/* JADX INFO: loaded from: classes2.dex */
public class MobileVisionBase<DetectionResultT> implements Closeable, LifecycleObserver {
    public static final d e = new d("MobileVisionBase", "");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2277a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f2278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f2279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f2280d;

    public MobileVisionBase(f fVar, Executor executor) {
        this.f2278b = fVar;
        w wVar = new w(14);
        this.f2279c = wVar;
        this.f2280d = executor;
        fVar.f10514b.incrementAndGet();
        k kVarA = fVar.a(executor, e.f10868a, (c) wVar.f10262b);
        x5.c cVar = x5.c.f10864a;
        kVarA.getClass();
        kVarA.e(h.f8951a, cVar);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0166  */
    /* JADX WARN: Code duplicated, block: B:60:0x016a  */
    /* JADX WARN: Code duplicated, block: B:62:0x016f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0173  */
    /* JADX WARN: Code duplicated, block: B:66:0x0177  */
    /* JADX WARN: Code duplicated, block: B:67:0x017a  */
    /* JADX WARN: Code duplicated, block: B:68:0x017d  */
    /* JADX WARN: Code duplicated, block: B:69:0x0180  */
    /* JADX WARN: Code duplicated, block: B:70:0x0183  */
    /* JADX WARN: Code duplicated, block: B:71:0x0186  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x0203 A[Catch: all -> 0x0216, TRY_LEAVE, TryCatch #1 {, blocks: (B:79:0x01fb, B:81:0x0203, B:86:0x0218, B:88:0x021e, B:90:0x0222, B:93:0x0237), top: B:114:0x01fb }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0218 A[Catch: all -> 0x0216, TRY_ENTER, TryCatch #1 {, blocks: (B:79:0x01fb, B:81:0x0203, B:86:0x0218, B:88:0x021e, B:90:0x0222, B:93:0x0237), top: B:114:0x01fb }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0237 A[Catch: all -> 0x0216, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:79:0x01fb, B:81:0x0203, B:86:0x0218, B:88:0x021e, B:90:0x0222, B:93:0x0237), top: B:114:0x01fb }] */
    public final k P(Image image, int i8, Matrix matrix) throws Throwable {
        int iLimit;
        final a aVar;
        oa oaVar;
        m7 m7Var;
        long jElapsedRealtime;
        HashMap map;
        k kVar;
        b7 b7Var;
        k kVar2;
        String strA;
        Bitmap bitmapCreateBitmap;
        l.a("Only YUV_420_888 is supported now", image.getFormat() == 35);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        a.b(i8);
        l.a("Only JPEG and YUV_420_888 are supported now", image.getFormat() == 256 || image.getFormat() == 35);
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() == 256) {
            iLimit = image.getPlanes()[0].getBuffer().limit();
            l.a("Only JPEG is supported now", image.getFormat() == 256);
            Image.Plane[] planes2 = image.getPlanes();
            if (planes2 == null || planes2.length != 1) {
                throw new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
            }
            ByteBuffer buffer = planes2[0].getBuffer();
            buffer.rewind();
            int iRemaining = buffer.remaining();
            byte[] bArr = new byte[iRemaining];
            buffer.get(bArr);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, iRemaining);
            int width = bitmapDecodeByteArray.getWidth();
            int height = bitmapDecodeByteArray.getHeight();
            if (i8 == 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, width, height);
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.postRotate(i8);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, width, height, matrix2, true);
            }
            aVar = new a(bitmapCreateBitmap);
        } else {
            for (Image.Plane plane : planes) {
                if (plane.getBuffer() != null) {
                    plane.getBuffer().rewind();
                }
            }
            a aVar2 = new a(image, image.getWidth(), image.getHeight(), i8, matrix);
            iLimit = (image.getPlanes()[0].getBuffer().limit() * 3) / 2;
            aVar = aVar2;
        }
        int format = image.getFormat();
        int height2 = image.getHeight();
        int width2 = image.getWidth();
        synchronized (qa.class) {
            byte b9 = (byte) (((byte) 1) | 2);
            if (b9 != 3) {
                StringBuilder sb2 = new StringBuilder();
                if ((b9 & 1) == 0) {
                    sb2.append(" enableFirelog");
                }
                if ((b9 & 2) == 0) {
                    sb2.append(" firelogEventType");
                }
                throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
            }
            la laVar = new la();
            synchronized (qa.class) {
                try {
                    if (qa.f7842a == null) {
                        qa.f7842a = new j3.w(2);
                    }
                    oaVar = (oa) qa.f7842a.b(laVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
            m7Var = m7.INPUT_IMAGE_CONSTRUCTION;
            oaVar.getClass();
            jElapsedRealtime = SystemClock.elapsedRealtime();
            map = oaVar.f7827i;
            if (map.get(m7Var) != null || jElapsedRealtime - ((Long) map.get(m7Var)).longValue() > TimeUnit.SECONDS.toMillis(30L)) {
                map.put(m7Var, Long.valueOf(jElapsedRealtime));
                c2.k kVar3 = new c2.k();
                if (format != -1) {
                    b7Var = b7.BITMAP;
                } else if (format != 35) {
                    b7Var = b7.YUV_420_888;
                } else if (format != 842094169) {
                    b7Var = b7.YV12;
                } else if (format != 16) {
                    b7Var = b7.NV16;
                } else if (format != 17) {
                    b7Var = b7.UNKNOWN_FORMAT;
                } else {
                    b7Var = b7.NV21;
                }
                kVar3.f1410d = b7Var;
                kVar3.f1409c = g7.ANDROID_MEDIA_IMAGE;
                kVar3.f1408b = Integer.valueOf(iLimit & Integer.MAX_VALUE);
                kVar3.f = Integer.valueOf(height2 & Integer.MAX_VALUE);
                kVar3.e = Integer.valueOf(width2 & Integer.MAX_VALUE);
                kVar3.f1407a = Long.valueOf(Long.MAX_VALUE & jElapsedRealtime3);
                kVar3.f1411g = Integer.valueOf(i8 & Integer.MAX_VALUE);
                h7 h7Var = new h7(kVar3);
                u6.a aVar3 = new u6.a(11, false);
                aVar3.f10380d = h7Var;
                i1.a aVar4 = new i1.a(aVar3);
                kVar2 = oaVar.e;
                if (kVar2.d()) {
                    strA = (String) kVar2.b();
                } else {
                    strA = u2.d.f10329c.a(oaVar.f7825g);
                }
                p5.l.INSTANCE.execute(new yd(oaVar, aVar4, m7Var, strA, 1));
            }
            synchronized (this) {
                if (this.f2277a.get()) {
                    l5.a aVar5 = new l5.a("This detector is already closed!", 14);
                    kVar = new k();
                    kVar.f(aVar5);
                } else if (aVar.f10663c >= 32 || aVar.f10664d < 32) {
                    l5.a aVar6 = new l5.a("InputImage width and height should be at least 32!", 3);
                    kVar = new k();
                    kVar.f(aVar6);
                } else {
                    kVar = this.f2278b.a(this.f2280d, new Callable() { // from class: x5.d
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            ka kaVar;
                            w5.a aVar7 = aVar;
                            MobileVisionBase mobileVisionBase = this.f10866a;
                            mobileVisionBase.getClass();
                            HashMap map2 = ka.f7764h;
                            sa.b();
                            int i9 = ra.f7849a;
                            sa.b();
                            if (Boolean.parseBoolean("")) {
                                HashMap map3 = ka.f7764h;
                                if (map3.get("detectorTaskWithResource#run") == null) {
                                    map3.put("detectorTaskWithResource#run", new ka("detectorTaskWithResource#run"));
                                }
                                kaVar = (ka) map3.get("detectorTaskWithResource#run");
                            } else {
                                kaVar = ja.f7758i;
                            }
                            kaVar.a();
                            try {
                                List listB = mobileVisionBase.f2278b.b(aVar7);
                                kaVar.close();
                                return listB;
                            } catch (Throwable th3) {
                                try {
                                    kaVar.close();
                                } catch (Throwable th4) {
                                    try {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th3;
                            }
                        }
                    }, (c) this.f2279c.f10262b);
                }
            }
            return kVar;
        }
        long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
        m7Var = m7.INPUT_IMAGE_CONSTRUCTION;
        oaVar.getClass();
        jElapsedRealtime = SystemClock.elapsedRealtime();
        map = oaVar.f7827i;
        if (map.get(m7Var) != null) {
        }
        map.put(m7Var, Long.valueOf(jElapsedRealtime));
        c2.k kVar4 = new c2.k();
        if (format != -1) {
            b7Var = b7.BITMAP;
        } else if (format != 35) {
            b7Var = b7.YUV_420_888;
        } else if (format != 842094169) {
            b7Var = b7.YV12;
        } else if (format != 16) {
            b7Var = b7.NV16;
        } else if (format != 17) {
            b7Var = b7.UNKNOWN_FORMAT;
        } else {
            b7Var = b7.NV21;
        }
        kVar4.f1410d = b7Var;
        kVar4.f1409c = g7.ANDROID_MEDIA_IMAGE;
        kVar4.f1408b = Integer.valueOf(iLimit & Integer.MAX_VALUE);
        kVar4.f = Integer.valueOf(height2 & Integer.MAX_VALUE);
        kVar4.e = Integer.valueOf(width2 & Integer.MAX_VALUE);
        kVar4.f1407a = Long.valueOf(Long.MAX_VALUE & jElapsedRealtime4);
        kVar4.f1411g = Integer.valueOf(i8 & Integer.MAX_VALUE);
        h7 h7Var2 = new h7(kVar4);
        u6.a aVar7 = new u6.a(11, false);
        aVar7.f10380d = h7Var2;
        i1.a aVar8 = new i1.a(aVar7);
        kVar2 = oaVar.e;
        if (kVar2.d()) {
            strA = (String) kVar2.b();
        } else {
            strA = u2.d.f10329c.a(oaVar.f7825g);
        }
        p5.l.INSTANCE.execute(new yd(oaVar, aVar8, m7Var, strA, 1));
        synchronized (this) {
            if (this.f2277a.get()) {
                l5.a aVar9 = new l5.a("This detector is already closed!", 14);
                kVar = new k();
                kVar.f(aVar9);
            } else if (aVar.f10663c >= 32) {
                l5.a aVar10 = new l5.a("InputImage width and height should be at least 32!", 3);
                kVar = new k();
                kVar.f(aVar10);
            } else {
                l5.a aVar11 = new l5.a("InputImage width and height should be at least 32!", 3);
                kVar = new k();
                kVar.f(aVar11);
            }
            return kVar;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.f2277a.getAndSet(true)) {
            return;
        }
        this.f2279c.o();
        f fVar = this.f2278b;
        Executor executor = this.f2280d;
        if (fVar.f10514b.get() <= 0) {
            throw new IllegalStateException();
        }
        fVar.f10513a.j(new i2.e(7, fVar, new g()), executor);
    }
}
