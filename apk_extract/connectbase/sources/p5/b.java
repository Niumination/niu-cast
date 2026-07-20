package p5;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final a f12795h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final String f12796i = "AudioPlayer";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12797j = 44100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public HandlerThread f12798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public Handler f12799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public MediaCodec f12800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public AudioTrack f12801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12802e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final MediaCodec.BufferInfo f12803f = new MediaCodec.BufferInfo();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12804g = 2;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public static final void i(long j10, b bVar, byte[] bArr) {
        kn.l0.p(bVar, "this$0");
        kn.l0.p(bArr, "$inputData");
        long jCurrentTimeMillis = System.currentTimeMillis() - j10;
        if (jCurrentTimeMillis > 200) {
            k4.m.c(f12796i, "Audio data timeout: " + jCurrentTimeMillis);
            Handler handler = bVar.f12799b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                return;
            }
            return;
        }
        int length = bArr.length;
        int i10 = bVar.f12802e;
        if (length < i10) {
            k4.m.c(f12796i, "Invalid audio data length");
        } else if ((bArr[0] & 255) != 20) {
            k4.m.c(f12796i, "Not an audio packet");
        } else {
            bVar.g(nm.p.f1(bArr, i10, bArr.length));
        }
    }

    public final MediaFormat b() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", "audio/mp4a-latm");
        mediaFormat.setInteger("channel-count", this.f12804g);
        mediaFormat.setInteger("sample-rate", 44100);
        mediaFormat.setInteger("aac-profile", 2);
        mediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(c()));
        return mediaFormat;
    }

    public final byte[] c() {
        return new byte[]{(byte) 18, (byte) 16};
    }

    public final void d() throws IOException {
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType("audio/mp4a-latm");
        this.f12800c = mediaCodecCreateDecoderByType;
        if (mediaCodecCreateDecoderByType != null) {
            mediaCodecCreateDecoderByType.configure(b(), (Surface) null, (MediaCrypto) null, 0);
        }
        MediaCodec mediaCodec = this.f12800c;
        if (mediaCodec != null) {
            mediaCodec.start();
        }
    }

    public final void e() {
        AudioTrack audioTrackBuild = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).build()).setAudioFormat(new AudioFormat.Builder().setSampleRate(44100).setEncoding(2).setChannelMask(12).build()).setBufferSizeInBytes(AudioTrack.getMinBufferSize(44100, 12, 2)).setTransferMode(1).build();
        this.f12801d = audioTrackBuild;
        if (audioTrackBuild != null) {
            audioTrackBuild.play();
        }
    }

    public final void f() {
        try {
            k4.m.e(f12796i, "init audio player");
            d();
            e();
            HandlerThread handlerThread = new HandlerThread("AudioDecoderThread");
            this.f12798a = handlerThread;
            handlerThread.start();
            this.f12799b = new Handler(handlerThread.getLooper());
            k4.m.e(f12796i, "init audio player success");
        } catch (Exception e10) {
            k4.m.c(f12796i, "init:" + e10.getMessage());
            k4.m.d(f12796i, e10);
        }
    }

    public final void g(byte[] bArr) {
        ByteBuffer inputBuffer;
        try {
            MediaCodec mediaCodec = this.f12800c;
            if (mediaCodec != null) {
                int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
                if (iDequeueInputBuffer >= 0 && (inputBuffer = mediaCodec.getInputBuffer(iDequeueInputBuffer)) != null) {
                    inputBuffer.clear();
                    inputBuffer.put(bArr);
                    mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, bArr.length, System.nanoTime() / ((long) 1000), 0);
                }
                int iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.f12803f, 10000L);
                while (iDequeueOutputBuffer >= 0) {
                    ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(iDequeueOutputBuffer);
                    if (outputBuffer != null) {
                        int i10 = this.f12803f.size;
                        byte[] bArr2 = new byte[i10];
                        outputBuffer.get(bArr2);
                        AudioTrack audioTrack = this.f12801d;
                        if (audioTrack != null) {
                            audioTrack.write(bArr2, 0, i10);
                        }
                    }
                    mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.f12803f, 10000L);
                }
            }
        } catch (Exception e10) {
            k4.m.c(f12796i, "playAudioData:" + e10.getMessage());
            k4.m.d(f12796i, e10);
        }
    }

    public final void h(@os.l final byte[] bArr) {
        kn.l0.p(bArr, "inputData");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Handler handler = this.f12799b;
        if (handler != null) {
            handler.post(new Runnable() { // from class: p5.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.i(jCurrentTimeMillis, this, bArr);
                }
            });
        }
    }

    public final void j() {
        try {
            HandlerThread handlerThread = this.f12798a;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f12798a = null;
            this.f12799b = null;
            MediaCodec mediaCodec = this.f12800c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            this.f12800c = null;
            AudioTrack audioTrack = this.f12801d;
            if (audioTrack != null) {
                audioTrack.stop();
                audioTrack.release();
            }
            this.f12801d = null;
        } catch (Exception e10) {
            k4.m.c(f12796i, "release:" + e10.getMessage());
            k4.m.d(f12796i, e10);
        }
    }
}
