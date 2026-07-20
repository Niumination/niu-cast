package f2;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public static final a f5762j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final String f5763k = "AnimPlayer.AudioPlayer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final g f5764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public MediaExtractor f5765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public MediaCodec f5766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public AudioTrack f5767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final r f5768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5772i;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public m(@os.l g gVar) {
        l0.p(gVar, "player");
        this.f5764a = gVar;
        this.f5768e = new r(null, null);
    }

    public static final void x(m mVar, g2.c cVar) {
        l0.p(mVar, "this$0");
        l0.p(cVar, "$fileContainer");
        try {
            mVar.y(cVar);
        } catch (Throwable th2) {
            l2.a.f9640a.c(f5763k, l0.C("Audio exception=", th2), th2);
            mVar.o();
        }
    }

    public final void b() {
        if (!this.f5769f) {
            c();
        } else {
            this.f5772i = true;
            this.f5771h = true;
        }
    }

    public final void c() {
        if (this.f5764a.f5749m) {
            l2.a.f9640a.e(f5763k, "destroyThread");
            Handler handler = this.f5768e.f5825b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            r rVar = this.f5768e;
            rVar.f5824a = p.f5802x.b(rVar.f5824a);
        }
    }

    @os.m
    public final AudioTrack d() {
        return this.f5767d;
    }

    public final int e(int i10) {
        switch (i10) {
            case 1:
                return 2;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            default:
                throw new RuntimeException(l0.C("Unsupported channel count: ", Integer.valueOf(i10)));
        }
    }

    @os.l
    public final r f() {
        return this.f5768e;
    }

    @os.m
    public final MediaCodec g() {
        return this.f5766c;
    }

    @os.m
    public final MediaExtractor h() {
        return this.f5765b;
    }

    public final boolean i() {
        return this.f5772i;
    }

    public final int j() {
        return this.f5770g;
    }

    @os.l
    public final g k() {
        return this.f5764a;
    }

    public final boolean l() {
        return this.f5769f;
    }

    public final boolean m() {
        return this.f5771h;
    }

    public final boolean n() {
        return p.f5802x.a(this.f5768e, "anim_audio_thread");
    }

    public final void o() {
        try {
            MediaCodec mediaCodec = this.f5766c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            this.f5766c = null;
            MediaExtractor mediaExtractor = this.f5765b;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            this.f5765b = null;
            AudioTrack audioTrack = this.f5767d;
            if (audioTrack != null) {
                audioTrack.pause();
                audioTrack.flush();
                audioTrack.stop();
                audioTrack.release();
            }
            this.f5767d = null;
        } catch (Throwable th2) {
            l2.a.f9640a.c(f5763k, l0.C("release exception=", th2), th2);
        }
        this.f5769f = false;
        if (this.f5772i) {
            c();
        }
    }

    public final void p(@os.m AudioTrack audioTrack) {
        this.f5767d = audioTrack;
    }

    public final void q(@os.m MediaCodec mediaCodec) {
        this.f5766c = mediaCodec;
    }

    public final void r(@os.m MediaExtractor mediaExtractor) {
        this.f5765b = mediaExtractor;
    }

    public final void s(boolean z10) {
        this.f5772i = z10;
    }

    public final void t(int i10) {
        this.f5770g = i10;
    }

    public final void u(boolean z10) {
        this.f5769f = z10;
    }

    public final void v(boolean z10) {
        this.f5771h = z10;
    }

    public final void w(@os.l final g2.c cVar) {
        l0.p(cVar, "fileContainer");
        this.f5771h = false;
        this.f5772i = false;
        if (n()) {
            if (this.f5769f) {
                this.f5771h = true;
            }
            this.f5769f = true;
            Handler handler = this.f5768e.f5825b;
            if (handler == null) {
                return;
            }
            handler.post(new Runnable() { // from class: f2.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.x(this.f5760a, cVar);
                }
            });
        }
    }

    public final void y(g2.c cVar) throws IOException {
        int i10;
        int iDequeueInputBuffer;
        l2.f fVar = l2.f.f9646a;
        MediaExtractor mediaExtractorC = fVar.c(cVar);
        this.f5765b = mediaExtractorC;
        int iE = fVar.e(mediaExtractorC);
        if (iE < 0) {
            l2.a.f9640a.b(f5763k, "cannot find audio track");
            o();
            return;
        }
        mediaExtractorC.selectTrack(iE);
        MediaFormat trackFormat = mediaExtractorC.getTrackFormat(iE);
        l0.o(trackFormat, "extractor.getTrackFormat(audioIndex)");
        String string = trackFormat.getString("mime");
        if (string == null) {
            string = "";
        }
        l2.a aVar = l2.a.f9640a;
        aVar.e(f5763k, l0.C("audio mime=", string));
        if (!fVar.b(string)) {
            aVar.b(f5763k, "mime=" + string + " not support");
            o();
            return;
        }
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(string);
        int i11 = 0;
        mediaCodecCreateDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
        mediaCodecCreateDecoderByType.start();
        l0.o(mediaCodecCreateDecoderByType, "createDecoderByType(mime).apply {\n            configure(format, null, null, 0)\n            start()\n        }");
        this.f5766c = mediaCodecCreateDecoderByType;
        ByteBuffer[] inputBuffers = mediaCodecCreateDecoderByType.getInputBuffers();
        l0.o(inputBuffers, "decoder.inputBuffers");
        ByteBuffer[] outputBuffers = mediaCodecCreateDecoderByType.getOutputBuffers();
        l0.o(outputBuffers, "decoder.outputBuffers");
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int integer = trackFormat.getInteger("sample-rate");
        int iE2 = e(trackFormat.getInteger("channel-count"));
        AudioTrack audioTrack = new AudioTrack(3, integer, iE2, 2, AudioTrack.getMinBufferSize(integer, iE2, 2), 1);
        this.f5767d = audioTrack;
        int i12 = 1;
        if (audioTrack.getState() != 1) {
            o();
            aVar.b(f5763k, "init audio track failure");
            return;
        }
        audioTrack.play();
        ByteBuffer[] outputBuffers2 = outputBuffers;
        int i13 = 0;
        while (!this.f5771h) {
            if (i13 != 0 || (iDequeueInputBuffer = mediaCodecCreateDecoderByType.dequeueInputBuffer(1000L)) < 0) {
                i12 = i12;
            } else {
                ByteBuffer byteBuffer = inputBuffers[iDequeueInputBuffer];
                byteBuffer.clear();
                int sampleData = mediaExtractorC.readSampleData(byteBuffer, i11);
                if (sampleData < 0) {
                    i12 = i12;
                    mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                    i13 = i12;
                } else {
                    i12 = i12;
                    mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, 0L, 0);
                    mediaExtractorC.advance();
                }
            }
            int iDequeueOutputBuffer = mediaCodecCreateDecoderByType.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -2) {
                outputBuffers2 = mediaCodecCreateDecoderByType.getOutputBuffers();
                l0.o(outputBuffers2, "decoder.outputBuffers");
            }
            if (iDequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers2[iDequeueOutputBuffer];
                byte[] bArr = new byte[bufferInfo.size];
                byteBuffer2.get(bArr);
                byteBuffer2.clear();
                int i14 = bufferInfo.size;
                audioTrack = audioTrack;
                i10 = 0;
                audioTrack.write(bArr, 0, i14);
                mediaCodecCreateDecoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
            } else {
                audioTrack = audioTrack;
                i10 = 0;
            }
            if (i13 != 0 && (bufferInfo.flags & 4) != 0) {
                int i15 = this.f5770g - 1;
                this.f5770g = i15;
                if (i15 <= 0) {
                    l2.a.f9640a.e(f5763k, "decode finish");
                    o();
                    break;
                }
                l2.a.f9640a.a(f5763k, "Reached EOS, looping -> playLoop");
                mediaExtractorC.seekTo(0L, 2);
                mediaCodecCreateDecoderByType.flush();
                i13 = i10;
                bufferInfo = bufferInfo;
                i11 = i13;
            } else {
                i11 = i10;
                bufferInfo = bufferInfo;
            }
        }
        o();
    }

    public final void z() {
        this.f5771h = true;
    }
}
