package p5;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes2.dex */
public class u0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f12908p = "PhoneScreenDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile MediaCodec f12909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f12910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f12911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f12912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f12913e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MediaCodec.Callback f12920l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Runnable f12923o;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12914f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12915g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12916h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Queue<byte[]> f12917i = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedBlockingDeque<byte[]> f12918j = new LinkedBlockingDeque<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedBlockingDeque<Integer> f12919k = new LinkedBlockingDeque<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12921m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12922n = true;

    public class a extends MediaCodec.Callback {
        public a() {
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            k4.m.c(u0.f12908p, "onError:" + codecException.getMessage());
            k4.m.d(u0.f12908p, codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10) {
            u0.this.j(i10, mediaCodec);
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10, @NonNull MediaCodec.BufferInfo bufferInfo) {
            if (u0.this.f12921m) {
                try {
                    mediaCodec.releaseOutputBuffer(i10, true);
                } catch (Exception e10) {
                    k4.m.c(u0.f12908p, "onOutputBufferAvailable exception:" + e10);
                    k4.m.d(u0.f12908p, e10);
                }
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
        }
    }

    public u0(Surface surface) {
        this.f12912d = surface;
        HandlerThread handlerThread = new HandlerThread("VideoDecoderThread");
        this.f12910b = handlerThread;
        handlerThread.start();
        this.f12911c = new Handler(handlerThread.getLooper());
        this.f12920l = new a();
    }

    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final void o(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        byte b10 = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        try {
            if (b10 == 10) {
                x(bArr2);
            } else if (b10 != 30) {
                k4.m.c(f12908p, "Unknown data flag: " + ((int) b10));
            } else {
                k4.m.b(f12908p, "Received retry encoder flag, reinitializing decoder");
                x(bArr2);
                Runnable runnable = this.f12923o;
                if (runnable != null) {
                    this.f12911c.removeCallbacks(runnable);
                    this.f12911c.postDelayed(new Runnable() { // from class: p5.p0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f12895a.p();
                        }
                    }, 1000L);
                }
            }
        } catch (Exception e10) {
            k4.m.c(f12908p, "processData error: " + e10.getMessage());
        }
    }

    public void B(Runnable runnable) {
        this.f12923o = runnable;
    }

    public void C() {
        k4.m.e(f12908p, "release");
        this.f12923o = null;
        D();
        this.f12917i.clear();
        this.f12918j.clear();
        this.f12919k.clear();
        this.f12910b.quitSafely();
    }

    public synchronized void D() {
        this.f12921m = false;
        if (this.f12909a != null) {
            try {
                try {
                    this.f12909a.stop();
                    this.f12909a.release();
                } catch (Exception e10) {
                    k4.m.c(f12908p, "releaseDecoder exception:" + e10);
                    k4.m.d(f12908p, e10);
                    this.f12909a.release();
                }
                this.f12909a = null;
            } catch (Throwable th2) {
                this.f12909a.release();
                this.f12909a = null;
                throw th2;
            }
        }
        this.f12919k.clear();
        this.f12918j.clear();
        k4.m.b(f12908p, "Decoder released");
        Handler handler = this.f12911c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void E(final int i10) {
        this.f12911c.post(new Runnable() { // from class: p5.s0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12902a.t(i10);
            }
        });
    }

    public void F(final Surface surface) {
        this.f12911c.post(new Runnable() { // from class: p5.o0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12891a.q(surface);
            }
        });
    }

    public final void G() {
        this.f12911c.postDelayed(new Runnable() { // from class: p5.n0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12890a.u();
            }
        }, 100L);
    }

    public final synchronized void H() {
        k4.m.e("Request Refresh", "requestRefresh");
        m0.f12861a.W();
    }

    public void I(int i10, int i11, int i12) {
        StringBuilder sbA = i0.a.a("setVideoInfo:width = ", i10, ", height = ", i11, ", orientation = ");
        sbA.append(i12);
        k4.m.e(f12908p, sbA.toString());
        this.f12915g = i10;
        this.f12916h = i11;
        this.f12914f = i12;
    }

    public final void j(int i10, MediaCodec mediaCodec) {
        if (!this.f12921m) {
            k4.m.e(f12908p, "not running");
            return;
        }
        byte[] bArrPoll = this.f12918j.poll();
        try {
            if (bArrPoll == null) {
                this.f12919k.offer(Integer.valueOf(i10));
                return;
            }
            ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i10);
            if (inputBuffer != null) {
                inputBuffer.clear();
                inputBuffer.put(bArrPoll);
                mediaCodec.queueInputBuffer(i10, 0, bArrPoll.length, SystemClock.elapsedRealtimeNanos(), 0);
            }
        } catch (Exception e10) {
            k4.m.c(f12908p, "decode exception:" + e10.getMessage());
            this.f12918j.addFirst(bArrPoll);
            k4.m.d(f12908p, e10);
        }
    }

    public final boolean k(byte[] bArr, int i10, int i11) {
        int i12;
        if (bArr != null) {
            try {
                if (bArr.length >= 4) {
                    int iY = y(bArr);
                    if (iY >= i10 && iY <= i11) {
                        return true;
                    }
                    for (int i13 = 4; i13 < bArr.length - 3; i13++) {
                        if (bArr[i13] == 0 && bArr[i13 + 1] == 0) {
                            byte b10 = bArr[i13 + 2];
                            int i14 = b10 == 1 ? i13 + 3 : (b10 == 0 && bArr[i13 + 3] == 1) ? i13 + 4 : -1;
                            if (i14 > 0 && i14 < bArr.length && (i12 = (bArr[i14] & 126) >> 1) >= i10 && i12 <= i11) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            } catch (Exception e10) {
                k4.m.c(f12908p, "hasNalUnitType error: " + e10);
            }
        }
        return false;
    }

    public final void l() {
        k4.m.e(f12908p, "initDecoder");
        try {
            if (this.f12909a != null) {
                k4.m.e(f12908p, "releaseDecoder");
                D();
            }
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/hevc", this.f12915g, this.f12916h);
            byte[] bArr = this.f12913e;
            if (bArr != null) {
                mediaFormatCreateVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
            }
            mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
            k4.m.e(f12908p, "initDecoder:mOrientationAngle = " + this.f12914f);
            mediaFormatCreateVideoFormat.setInteger("rotation-degrees", this.f12914f);
            this.f12909a = MediaCodec.createDecoderByType("video/hevc");
            this.f12909a.configure(mediaFormatCreateVideoFormat, this.f12912d, (MediaCrypto) null, 0);
            this.f12909a.setCallback(this.f12920l, this.f12911c);
            this.f12909a.start();
            this.f12921m = true;
            this.f12922n = true;
            k4.m.b(f12908p, "Decoder initialized");
        } catch (Exception e10) {
            k4.m.c(f12908p, "Failed to initialize decoder: " + e10.getMessage());
        }
    }

    public final boolean m(byte[] bArr) {
        return k(bArr, 32, 34);
    }

    public final boolean n(byte[] bArr) {
        return k(bArr, 16, 21);
    }

    public final /* synthetic */ void p() {
        this.f12923o.run();
    }

    public final /* synthetic */ void q(Surface surface) {
        this.f12912d = surface;
        if (this.f12909a != null) {
            D();
        }
        this.f12913e = null;
        this.f12917i.clear();
        G();
    }

    public final /* synthetic */ void r() {
        this.f12923o.run();
    }

    public final /* synthetic */ void s() {
        this.f12923o.run();
    }

    public final /* synthetic */ void t(int i10) {
        m2.b.a("reload:orientationAngle = ", i10, f12908p);
        int i11 = this.f12914f;
        if (i11 != i10) {
            if (Math.abs(i11 - i10) == 180) {
                this.f12914f = i10;
                l();
                G();
                this.f12911c.postDelayed(new Runnable() { // from class: p5.q0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12897a.r();
                    }
                }, 2000L);
                return;
            }
            this.f12917i.clear();
            this.f12914f = i10;
            l();
        }
        this.f12911c.removeCallbacks(this.f12923o);
        this.f12911c.postDelayed(new Runnable() { // from class: p5.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12899a.s();
            }
        }, 2000L);
    }

    public final /* synthetic */ void u() {
        k4.m.e(f12908p, "force refresh last video stream");
        boolean z10 = false;
        for (byte[] bArr : this.f12917i) {
            if (!z10 && n(bArr)) {
                this.f12922n = false;
                z10 = true;
            }
            if (z10) {
                k4.m.e(f12908p, "force refresh");
                w(bArr);
            }
        }
        if (!z10 || (this.f12909a == null && this.f12913e == null)) {
            if (z10) {
                k4.m.e(f12908p, "Found keyframe but missing CSD, requesting refresh to get parameters");
            } else {
                k4.m.e(f12908p, "no key frame found in cache, request refresh");
            }
            this.f12922n = true;
            H();
        }
    }

    public void v(final byte[] bArr) {
        this.f12911c.post(new Runnable() { // from class: p5.t0
            @Override // java.lang.Runnable
            public final void run() {
                this.f12905a.o(bArr);
            }
        });
    }

    public final int w(byte[] bArr) {
        try {
            int iY = y(bArr);
            if (m(bArr)) {
                k4.m.e(f12908p, "New CSD received, updating header");
                this.f12913e = bArr;
            }
            if (this.f12909a == null) {
                if (this.f12913e == null) {
                    k4.m.e(f12908p, "Decoder not initialized and no CSD available. Dropping packet type: " + iY);
                    if (n(bArr)) {
                        k4.m.e(f12908p, "Received Keyframe but missing CSD, requesting refresh");
                        H();
                    }
                    return iY;
                }
                k4.m.e(f12908p, "Initializing decoder with valid CSD");
                l();
            }
            if (this.f12922n) {
                if (n(bArr)) {
                    k4.m.e(f12908p, "Key frame received, start decoding");
                    this.f12922n = false;
                } else {
                    if (!m(bArr)) {
                        k4.m.e(f12908p, "Waiting for key frame, drop P frame");
                        H();
                        return iY;
                    }
                    k4.m.e(f12908p, "CSD received while waiting for key frame, pass through");
                }
            }
            Integer numPoll = this.f12919k.poll();
            this.f12918j.offer(bArr);
            if (numPoll != null) {
                j(numPoll.intValue(), this.f12909a);
            }
            return iY;
        } catch (Exception e10) {
            k4.m.c(f12908p, "Decode error: " + e10.getMessage());
            D();
            return -1;
        }
    }

    public final void x(byte[] bArr) {
        this.f12917i.offer(bArr);
        w(bArr);
        if (this.f12917i.size() > 65) {
            this.f12917i.poll();
        }
    }

    public final int y(byte[] bArr) {
        return (bArr[bArr[2] == 1 ? (char) 3 : (char) 4] & 126) >> 1;
    }

    public final synchronized void z(MediaCodec mediaCodec, int i10, long j10) {
        int i11 = 0;
        while (!r5.a.f14282a.a(j10)) {
            try {
                Thread.sleep(10L);
                i11++;
                if (i11 > 20) {
                    k4.m.c(f12908p, "playVideo retryCount > 20");
                    break;
                }
                continue;
            } catch (InterruptedException e10) {
                k4.m.c(f12908p, "playVideo exception:" + e10);
            }
        }
        mediaCodec.releaseOutputBuffer(i10, true);
    }
}
