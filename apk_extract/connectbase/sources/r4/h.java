package r4;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.ByteBuffer;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public class h implements c {
    public static final String A = "video/hevc";
    public static final boolean B = !Build.HARDWARE.equals("qcom");
    public static final int C = 1920;
    public static final int D = 2;
    public static final int E = 60;
    public static final int F = 5;
    public static final boolean G = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f14256t = "VideoProducerImpl";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f14257u = 19;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f14258v = 32;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final float f14259w = 0.06f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f14260x = 60;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f14261y = 24;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f14262z = 37;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public p4.c f14265f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaCodec f14268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HandlerThread f14269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Handler f14270k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f14271l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f14272m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Surface f14273n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bundle f14275p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bundle f14276q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Bundle f14277r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public r4.a f14278s;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14263d = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14266g = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f14274o = SystemClock.uptimeMillis();

    public class a extends MediaCodec.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f14279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14280b;

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            m.b(h.f14256t, "onError" + codecException.getMessage());
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10) {
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10, @NonNull MediaCodec.BufferInfo bufferInfo) {
            try {
                this.f14280b++;
                if (SystemClock.uptimeMillis() - this.f14279a > h.this.f14264e) {
                    this.f14280b = 0;
                    this.f14279a = SystemClock.uptimeMillis();
                    h hVar = h.this;
                    hVar.f14268i.setParameters(hVar.f14277r);
                }
                if (i10 >= 0) {
                    h.this.y(mediaCodec.getOutputBuffer(i10), bufferInfo);
                    mediaCodec.releaseOutputBuffer(i10, false);
                }
            } catch (Exception e10) {
                m.d(h.f14256t, e10);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
            m.b(h.f14256t, "onOutputFormatChanged " + mediaFormat);
        }

        public a() {
            this.f14279a = -1L;
            this.f14280b = 0;
        }
    }

    public h(@NonNull d dVar) {
        this.f14272m = dVar;
        Bundle bundle = new Bundle();
        this.f14277r = bundle;
        bundle.putInt("request-sync", 0);
        this.f14264e = ((long) dVar.g()) * 1000;
        synchronized (this) {
            u();
        }
    }

    @Override // r4.c
    public void a() {
        StringBuilder sb2 = new StringBuilder("retryEncoder mEncoder is ");
        sb2.append(this.f14268i != null);
        m.b(f14256t, sb2.toString());
        this.f14263d++;
        MediaCodec mediaCodec = this.f14268i;
        if (mediaCodec != null) {
            mediaCodec.setParameters(this.f14277r);
            this.f14267h = true;
            r4.a aVar = this.f14278s;
            if (aVar == null || this.f14263d < 2) {
                return;
            }
            aVar.c();
        }
    }

    @Override // r4.c
    @NonNull
    public d b() {
        return this.f14272m;
    }

    @Override // r4.c
    public Surface c() {
        Surface surface;
        synchronized (this) {
            surface = this.f14273n;
        }
        return surface;
    }

    @Override // r4.c
    public void d(int i10) {
        if (i10 > 60 || i10 < 5) {
            return;
        }
        if (i10 > this.f14272m.b()) {
            i10 = (int) this.f14272m.b();
        }
        synchronized (this) {
            try {
                r4.a aVar = this.f14278s;
                if (aVar != null) {
                    aVar.a(i10);
                }
                this.f14272m.o(i10);
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", (int) (this.f14272m.j() * this.f14272m.f() * i10 * 0.06f));
                this.f14268i.setParameters(bundle);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m.b(f14256t, "onFpsChange, fps = " + i10);
    }

    @Override // p4.b
    public void f(p4.c cVar) {
        this.f14265f = cVar;
    }

    @Override // r4.c
    public synchronized void g(int i10, int i11) {
        try {
            m.b(f14256t, "onFoldFeatureChanged");
            d dVar = this.f14272m;
            if (dVar != null) {
                dVar.t(i10);
                this.f14272m.p(i11);
            }
            Surface surface = this.f14273n;
            if (surface != null) {
                surface.release();
            }
            r4.a aVar = this.f14278s;
            if (aVar != null) {
                aVar.g();
            }
            u();
            this.f14268i.start();
            a();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // r4.c
    @Deprecated
    public void h(boolean z10) {
    }

    @Override // r4.c
    public void j(boolean z10) {
        if (this.f14268i == null || this.f14270k == null) {
            return;
        }
        this.f14278s.i(z10);
    }

    public final void q(MediaFormat mediaFormat) {
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = this.f14268i.getCodecInfo().getCapabilitiesForType("video/hevc").getEncoderCapabilities();
        if (encoderCapabilities.isBitrateModeSupported(2)) {
            m.b(f14256t, "Setting bitrate mode to constant bitrate");
            mediaFormat.setInteger("bitrate-mode", 2);
            mediaFormat.setInteger("video-qp-min", 24);
            mediaFormat.setInteger("video-qp-max", 37);
            return;
        }
        if (encoderCapabilities.isBitrateModeSupported(1)) {
            m.b(f14256t, "Setting bitrate mode to variable bitrate");
            mediaFormat.setInteger("bitrate-mode", 1);
            mediaFormat.setInteger("video-qp-min", 24);
            mediaFormat.setInteger("video-qp-max", 37);
            return;
        }
        if (encoderCapabilities.isBitrateModeSupported(0)) {
            m.b(f14256t, "Setting bitrate mode to constant quality");
            mediaFormat.setInteger("bitrate-mode", 0);
            mediaFormat.setInteger("quality", 60);
        }
    }

    public final void r() {
        Handler handler;
        if (this.f14272m.e() < this.f14272m.b() && (handler = this.f14270k) != null) {
            handler.removeMessages(0);
            this.f14268i.setParameters(this.f14275p);
            this.f14270k.postDelayed(new Runnable() { // from class: r4.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14255a.w();
                }
            }, (1000 / ((long) this.f14272m.e())) - ((long) (1000.0f / this.f14272m.b())));
        }
    }

    public final Size s(int i10, int i11) {
        if (!B) {
            return new Size(i10, i11);
        }
        if (i10 > i11) {
            if (i10 <= 1920) {
                return new Size(i10, i11);
            }
            return new Size(1920, (int) (((double) i11) * (1920.0d / ((double) i10))));
        }
        if (i11 <= 1920) {
            return new Size(i10, i11);
        }
        return new Size((int) (((double) i10) * (1920.0d / ((double) i11))), 1920);
    }

    @Override // p4.b
    public void start() {
        synchronized (this) {
            try {
                this.f14268i.start();
            } catch (Exception e10) {
                m.c(f14256t, "start encoder failed: " + e10);
            }
        }
    }

    @Override // p4.b
    public void stop() {
        if (this.f14270k == null) {
            return;
        }
        HandlerThread handlerThread = this.f14269j;
        if (handlerThread == null || handlerThread.isAlive()) {
            this.f14270k.post(new Runnable() { // from class: r4.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14254a.x();
                }
            });
        } else {
            m.c(f14256t, "encode handler thread is already dead");
        }
    }

    public final MediaFormat t(int i10, int i11) {
        Size sizeS = s(i10, i11);
        m.e(f14256t, "getMediaFormat size: " + sizeS);
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/hevc", sizeS.getWidth(), sizeS.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", this.f14272m.e());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 10000);
        mediaFormatCreateVideoFormat.setInteger("bitrate", (int) (this.f14272m.e() * i10 * i11 * 0.06f));
        mediaFormatCreateVideoFormat.setInteger("allow-frame-drop", 1);
        q(mediaFormatCreateVideoFormat);
        mediaFormatCreateVideoFormat.setLong("repeat-previous-frame-after", 100000L);
        return mediaFormatCreateVideoFormat;
    }

    public final void u() {
        HandlerThread handlerThread = this.f14269j;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f14269j = null;
        }
        Handler handler = this.f14270k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f14270k = null;
        }
        HandlerThread handlerThread2 = new HandlerThread("Virtual Display Video Encoder");
        this.f14269j = handlerThread2;
        handlerThread2.start();
        this.f14270k = new Handler(this.f14269j.getLooper());
        MediaCodec mediaCodec = this.f14268i;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f14268i.release();
        }
        m.e(f14256t, "initMediaCodec: " + this.f14272m.toString());
        int iJ = this.f14272m.j() <= 0 ? 1080 : this.f14272m.j();
        int iF = this.f14272m.f() <= 0 ? 2400 : this.f14272m.f();
        try {
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("video/hevc");
            this.f14268i = mediaCodecCreateEncoderByType;
            mediaCodecCreateEncoderByType.setCallback(new a(), this.f14270k);
            this.f14268i.configure(t(iJ, iF), (Surface) null, (MediaCrypto) null, 1);
            r4.a aVar = new r4.a(this.f14268i.createInputSurface(), iJ, iF, this.f14272m.e());
            this.f14278s = aVar;
            this.f14273n = aVar.d();
        } catch (IOException e10) {
            m.b(f14256t, "initEncode IOException");
            m.d(f14256t, e10);
        } catch (Exception e11) {
            if (this.f14266g) {
                this.f14266g = false;
                u();
            }
            m.d(f14256t, e11);
        }
    }

    public final void v() {
        m.e(f14256t, "重置关键帧请求");
        this.f14263d = 0;
    }

    public final /* synthetic */ void w() {
        this.f14268i.setParameters(this.f14276q);
    }

    public final /* synthetic */ void x() {
        try {
            MediaCodec mediaCodec = this.f14268i;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f14268i.release();
            }
            HandlerThread handlerThread = this.f14269j;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            Surface surface = this.f14273n;
            if (surface != null) {
                surface.release();
            }
            r4.a aVar = this.f14278s;
            if (aVar != null) {
                aVar.g();
            }
        } catch (Exception e10) {
            m.b(f14256t, "virtualDisplay exception" + e10);
        }
    }

    public final void y(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        int i10 = (byteBuffer.get(byteBuffer.get(2) == 1 ? 3 : 4) & 126) >> 1;
        if (i10 == 32) {
            byte[] bArr = new byte[bufferInfo.size];
            this.f14271l = bArr;
            byteBuffer.get(bArr);
        } else if (this.f14267h && i10 == 19) {
            m.e(f14256t, "send csdHeader for retry encoder");
            this.f14267h = false;
            byte[] bArr2 = this.f14271l;
            byte[] bArr3 = new byte[bArr2.length + 1];
            bArr3[0] = c1.c.H;
            System.arraycopy(bArr2, 0, bArr3, 1, bArr2.length);
            p4.c cVar = this.f14265f;
            if (cVar != null) {
                cVar.a(bArr3);
                m.b(f14256t, "onNewData");
                v();
            }
        }
        int i11 = bufferInfo.size;
        byte[] bArr4 = new byte[i11 + 1];
        bArr4[0] = 10;
        if (i10 != 32) {
            byteBuffer.get(bArr4, 1, i11);
        } else {
            byte[] bArr5 = this.f14271l;
            System.arraycopy(bArr5, 0, bArr4, 1, bArr5.length);
        }
        p4.c cVar2 = this.f14265f;
        if (cVar2 != null) {
            cVar2.a(bArr4);
        }
    }
}
