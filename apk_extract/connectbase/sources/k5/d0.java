package k5;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.transsion.streamServer.IServerStreamData;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d0 implements IServerStreamData {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8991o = "k5.d0";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MediaCodec f8995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HandlerThread f8996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f8997f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Future<?> f8999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Surface f9000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9002k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f8992a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingDeque<Integer> f8993b = new LinkedBlockingDeque<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingDeque<b> f8994c = new LinkedBlockingDeque<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ExecutorService f8998g = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue(1), new ThreadPoolExecutor.DiscardOldestPolicy());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9003l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9004m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MediaCodec.Callback f9005n = new a();

    public class a extends MediaCodec.Callback {
        public a() {
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            k4.m.c(d0.f8991o, "mVideoDecoderCallback, OnError" + codecException.getMessage());
            k4.m.d(d0.f8991o, codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10) {
            d0.this.f8993b.offer(Integer.valueOf(i10));
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10, @NonNull MediaCodec.BufferInfo bufferInfo) {
            try {
                mediaCodec.releaseOutputBuffer(i10, true);
            } catch (IllegalStateException e10) {
                k4.m.c(d0.f8991o, "mVideoDecoderCallback, onOutputBufferAvailable" + e10.getMessage());
                k4.m.d(d0.f8991o, e10);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f9008b;

        public b(long j10, byte[] bArr) {
            this.f9007a = j10;
            this.f9008b = bArr;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Throwable e10;
            Integer num = null;
            b bVar2 = null;
            while (d0.this.f8992a) {
                try {
                    Integer numTake = d0.this.f8993b.take();
                    try {
                        b bVarTake = d0.this.f8994c.take();
                        try {
                            ByteBuffer inputBuffer = d0.this.f8995d.getInputBuffer(numTake.intValue());
                            if (inputBuffer != null && bVarTake != null) {
                                inputBuffer.clear();
                                inputBuffer.put(bVarTake.f9008b);
                                d0.this.f8995d.queueInputBuffer(numTake.intValue(), 0, bVarTake.f9008b.length, bVarTake.f9007a, 0);
                            }
                            bVar2 = bVarTake;
                            num = numTake;
                        } catch (IllegalStateException | InterruptedException e11) {
                            e10 = e11;
                            bVar = bVarTake;
                            num = numTake;
                            String str = d0.f8991o;
                            k4.m.c(str, "[EXTEND] Worker decoder exception" + e10.getMessage());
                            k4.m.e(str, "mediacodec deal fail, need reprocess");
                            if (num != null) {
                                d0.this.f8993b.offer(num);
                            }
                            if (bVar != null) {
                                d0.this.f8994c.offer(bVar);
                            }
                            bVar2 = bVar;
                        }
                    } catch (IllegalStateException | InterruptedException e12) {
                        b bVar3 = bVar2;
                        e10 = e12;
                        num = numTake;
                        bVar = bVar3;
                    }
                } catch (IllegalStateException | InterruptedException e13) {
                    bVar = bVar2;
                    e10 = e13;
                }
            }
        }
    }

    @Override // com.transsion.streamServer.IServerStreamData
    public synchronized void dataListener(long j10, byte[] bArr) {
        if (this.f8992a) {
            this.f8994c.offer(new b(System.currentTimeMillis(), bArr));
        }
    }

    public int f() {
        return this.f9002k;
    }

    public int g() {
        return this.f9001j;
    }

    public synchronized void h(int i10, int i11, Surface surface, int i12) {
        if (i(i10, i11, surface, i12)) {
            k4.m.e(f8991o, "init: same param info, not reload decoder");
            return;
        }
        this.f9000i = surface;
        if (!surface.isValid()) {
            k4.m.e(f8991o, "[EXTEND] startConfiguration mSurface is not available");
            return;
        }
        k4.m.e(f8991o, "init: width:" + i10 + "; height:" + i11 + "; orientation:" + i12);
        this.f9003l = i12;
        if (i12 == 0 || i12 == 2) {
            this.f9001j = Math.min(i10, i11);
            this.f9002k = Math.max(i10, i11);
        } else {
            this.f9001j = Math.max(i10, i11);
            this.f9002k = Math.min(i10, i11);
        }
        p();
        if (this.f8996e == null) {
            HandlerThread handlerThread = new HandlerThread("video-decoder");
            this.f8996e = handlerThread;
            handlerThread.start();
            this.f8997f = new Handler(this.f8996e.getLooper());
        }
        n(this.f9001j, this.f9002k);
    }

    public final boolean i(int i10, int i11, Surface surface, int i12) {
        return this.f8995d != null && this.f8999h != null && i12 == this.f9003l && surface == this.f9000i && i10 * i11 == this.f9001j * this.f9002k;
    }

    public void j() {
        k4.m.e(f8991o, "pauseDecoder");
        this.f8992a = false;
        if (this.f8999h != null) {
            this.f8999h.cancel(true);
            this.f8999h = null;
        }
    }

    public void k() {
        if (this.f8995d != null) {
            k4.m.e(f8991o, "releaseResources: decoder release");
            this.f8995d.release();
            this.f8995d = null;
        }
        HandlerThread handlerThread = this.f8996e;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f8996e = null;
        }
        this.f8998g.shutdown();
        this.f8993b.clear();
        this.f8994c.clear();
    }

    public void l(Surface surface, int i10, int i11, int i12) {
        this.f9000i = surface;
        String str = f8991o;
        k4.m.e(str, "restartDecoder");
        if (!this.f9000i.isValid()) {
            k4.m.e(str, "[EXTEND] restartDecoder: mSurface is not available");
            return;
        }
        if (this.f8995d == null) {
            k4.m.e(str, "restartDecoder: decoder null, to init");
            this.f8992a = false;
            h(i10, i11, surface, i12);
            return;
        }
        k4.m.e(str, "restartDecoder: update surface");
        try {
            this.f8995d.setOutputSurface(surface);
            o();
        } catch (IllegalStateException e10) {
            String str2 = f8991o;
            k4.m.c(str2, "mediacodec set surface fail" + e10.getMessage());
            k4.m.d(str2, e10);
            this.f8995d = null;
            h(i10, i11, surface, i12);
        }
    }

    public final void m(MediaFormat mediaFormat) {
        if (this.f9004m) {
            this.f9004m = false;
            return;
        }
        int i10 = this.f9003l;
        if (i10 == 0) {
            mediaFormat.setInteger("rotation-degrees", 90);
            return;
        }
        if (i10 == 1) {
            mediaFormat.setInteger("rotation-degrees", 0);
        } else if (i10 == 2) {
            mediaFormat.setInteger("rotation-degrees", 270);
        } else {
            if (i10 != 3) {
                return;
            }
            mediaFormat.setInteger("rotation-degrees", 180);
        }
    }

    public final void n(int i10, int i11) {
        k4.m.e(f8991o, "[EXTEND] Configuration videoWidth: " + i10 + ",height:" + i11);
        if (this.f8992a) {
            return;
        }
        if (this.f8995d == null) {
            try {
                this.f8995d = MediaCodec.createDecoderByType("video/avc");
            } catch (IOException e10) {
                k4.m.c(f8991o, "[EXTEND] create decoder Exception" + e10.getMessage());
                return;
            }
        }
        try {
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", i10, i11);
            mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
            mediaFormatCreateVideoFormat.setInteger("bitrate", i10 * i11 * 2);
            mediaFormatCreateVideoFormat.setInteger("sample-rate", 1);
            m(mediaFormatCreateVideoFormat);
            this.f8995d.setCallback(this.f9005n, this.f8997f);
            this.f8995d.configure(mediaFormatCreateVideoFormat, this.f9000i, (MediaCrypto) null, 0);
            this.f8995d.start();
            o();
        } catch (IllegalArgumentException e11) {
            String str = f8991o;
            k4.m.c(str, "[EXTEND] initDecoder Exception" + e11.getMessage());
            k4.m.d(str, e11);
        }
    }

    public final synchronized void o() {
        k4.m.e(f8991o, "[EXTEND] startVideoDecode: ");
        this.f8992a = true;
        this.f8999h = this.f8998g.submit(new c());
    }

    public synchronized void p() {
        try {
            this.f8992a = false;
            if (this.f8999h != null) {
                this.f8999h.cancel(true);
                this.f8999h = null;
            }
            if (this.f8995d != null) {
                k4.m.e(f8991o, "stopTask: decoder stop");
                try {
                    this.f8995d.stop();
                    this.f8995d.reset();
                } catch (IllegalStateException e10) {
                    String str = f8991o;
                    k4.m.c(str, "[EXTEND] stopTask IllegalStateException" + e10.getMessage());
                    k4.m.d(str, e10);
                }
            }
            this.f8993b.clear();
            this.f8994c.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
