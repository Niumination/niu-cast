package p4;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Environment;
import android.util.Log;
import c3.i;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import k4.m;
import k4.t;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12777a = "p4.d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MediaMuxer f12778b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f12779c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f12780d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f12781e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f12782f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static MediaFormat f12783g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f12784h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f12785i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Timer f12786j = new Timer();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static TimerTask f12787k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f12788l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static long f12789m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f12790n = 20;

    public class a extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            d.h();
        }
    }

    public static void a(MediaFormat mediaFormat) {
        Log.d(f12777a, "addAudioFormat");
        synchronized (f12785i) {
            try {
                i(mediaFormat);
                if (f12779c) {
                    return;
                }
                f12782f = f12778b.addTrack(mediaFormat);
                f12779c = true;
                if (f12780d) {
                    g();
                }
                f12783g = mediaFormat;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void b(MediaFormat mediaFormat) {
        Log.d(f12777a, "addVideoFormat");
        synchronized (f12785i) {
            try {
                i(mediaFormat);
                if (f12780d) {
                    return;
                }
                f12781e = f12778b.addTrack(mediaFormat);
                f12780d = true;
                if (f12779c) {
                    g();
                } else {
                    MediaFormat mediaFormat2 = f12783g;
                    if (mediaFormat2 != null) {
                        a(mediaFormat2);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String c(Context context, String str) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + str);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (Exception e10) {
                m.d(f12777a, e10);
            }
        }
        return file.getAbsolutePath();
    }

    public static void d(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        bufferInfo.presentationTimeUs = (System.nanoTime() - f12789m) / 1000;
        synchronized (f12785i) {
            e(byteBuffer, bufferInfo, f12782f);
        }
    }

    public static void e(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i10) {
        if (i10 == -1 || !f12788l) {
            return;
        }
        String str = f12777a;
        StringBuilder sb2 = new StringBuilder("save ");
        sb2.append(i10 == f12782f ? "audio" : "video");
        sb2.append(" index: ");
        sb2.append(i10);
        sb2.append(" length: ");
        sb2.append(bufferInfo.size);
        Log.d(str, sb2.toString());
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        f12778b.writeSampleData(i10, byteBuffer, bufferInfo);
        Log.d(str, "saved " + bufferInfo.size + " bytes to muxer, ts=" + bufferInfo.presentationTimeUs);
    }

    public static void f(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        bufferInfo.presentationTimeUs = (System.nanoTime() - f12789m) / 1000;
        synchronized (f12785i) {
            e(byteBuffer, bufferInfo, f12781e);
        }
    }

    public static void g() {
        f12778b.start();
        t.f("create file: " + f12784h, k4.e.f8930a);
        TimerTask timerTask = f12787k;
        if (timerTask != null) {
            timerTask.cancel();
        }
        a aVar = new a();
        f12787k = aVar;
        f12786j.schedule(aVar, i.S);
        f12788l = true;
        f12789m = System.nanoTime();
    }

    public static void h() {
        f12788l = false;
        MediaMuxer mediaMuxer = f12778b;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            f12778b.release();
            f12778b = null;
            f12780d = false;
            f12779c = false;
            f12782f = -1;
            f12781e = -1;
            t.f("file saved: " + f12784h, k4.e.f8930a);
        }
    }

    public static void i(MediaFormat mediaFormat) {
        if (f12778b != null) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c(k4.e.f8930a, "VD_V_" + simpleDateFormat.format(new Date())));
        sb2.append(".mp4");
        f12784h = sb2.toString();
        Log.d(f12777a, "testCreateFile: " + f12784h);
        try {
            f12778b = new MediaMuxer(f12784h, 0);
        } catch (IOException e10) {
            String str = f12777a;
            Log.d(str, "Create Muxer failed");
            m.d(str, e10);
        }
    }
}
