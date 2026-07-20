package d6;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import k3.j1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f4327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaExtractor f4328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MediaCodec f4329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioTrack f4330d;
    public final o e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4333i;

    public l(d player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.f4327a = player;
        this.e = new o();
    }

    public final void a() {
        if (this.f4327a.f4318j) {
            Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
            Intrinsics.checkNotNullParameter("destroyThread", NotificationCompat.CATEGORY_MESSAGE);
            o oVar = this.e;
            Handler handler = oVar.f4335b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            HandlerThread handlerThread = oVar.f4334a;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            oVar.f4334a = null;
        }
    }

    public final void b() {
        try {
            MediaCodec mediaCodec = this.f4329c;
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            this.f4329c = null;
            MediaExtractor mediaExtractor = this.f4328b;
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            this.f4328b = null;
            AudioTrack audioTrack = this.f4330d;
            if (audioTrack != null) {
                audioTrack.pause();
                audioTrack.flush();
                audioTrack.stop();
                audioTrack.release();
            }
            this.f4330d = null;
        } catch (Throwable tr) {
            String msg = Intrinsics.stringPlus("release exception=", tr);
            Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
        }
        this.f = false;
        if (this.f4333i) {
            a();
        }
    }

    public final void c(e6.b fileContainer) {
        Intrinsics.checkNotNullParameter(fileContainer, "fileContainer");
        this.f4332h = false;
        this.f4333i = false;
        o oVar = this.e;
        if (j1.a(oVar, "anim_audio_thread")) {
            if (this.f) {
                this.f4332h = true;
            }
            this.f = true;
            Handler handler = oVar.f4335b;
            if (handler == null) {
                return;
            }
            handler.post(new a0.e(6, this, fileContainer));
        }
    }

    public final void d(e6.b file) throws IOException {
        int i8;
        int i9;
        int i10;
        int iDequeueInputBuffer;
        j6.b bVar = j6.b.f6107a;
        Intrinsics.checkNotNullParameter(file, "file");
        MediaExtractor extractor = new MediaExtractor();
        file.d(extractor);
        this.f4328b = extractor;
        Intrinsics.checkNotNullParameter(extractor, "extractor");
        int trackCount = extractor.getTrackCount();
        int i11 = 0;
        if (trackCount <= 0) {
            i8 = -1;
            break;
        }
        i8 = 0;
        while (true) {
            int i12 = i8 + 1;
            MediaFormat trackFormat = extractor.getTrackFormat(i8);
            Intrinsics.checkNotNullExpressionValue(trackFormat, "extractor.getTrackFormat(i)");
            String string = trackFormat.getString("mime");
            if (string == null) {
                string = "";
            }
            if (StringsKt__StringsJVMKt.startsWith$default(string, "audio/", false, 2, null)) {
                String msg = "Extractor selected track " + i8 + " (" + string + "): " + trackFormat;
                Intrinsics.checkNotNullParameter("AnimPlayer.MediaUtil", "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                break;
            }
            if (i12 >= trackCount) {
                i8 = -1;
                break;
            }
            i8 = i12;
        }
        if (i8 < 0) {
            Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
            Intrinsics.checkNotNullParameter("cannot find audio track", NotificationCompat.CATEGORY_MESSAGE);
            b();
            return;
        }
        extractor.selectTrack(i8);
        MediaFormat trackFormat2 = extractor.getTrackFormat(i8);
        Intrinsics.checkNotNullExpressionValue(trackFormat2, "extractor.getTrackFormat(audioIndex)");
        String string2 = trackFormat2.getString("mime");
        String str = string2 != null ? string2 : "";
        String msg2 = Intrinsics.stringPlus("audio mime=", str);
        Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (!j6.b.f6107a.a(str)) {
            String msg3 = "mime=" + str + " not support";
            Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
            Intrinsics.checkNotNullParameter(msg3, "msg");
            b();
            return;
        }
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(str);
        mediaCodecCreateDecoderByType.configure(trackFormat2, (Surface) null, (MediaCrypto) null, 0);
        mediaCodecCreateDecoderByType.start();
        Intrinsics.checkNotNullExpressionValue(mediaCodecCreateDecoderByType, "createDecoderByType(mime).apply {\n            configure(format, null, null, 0)\n            start()\n        }");
        this.f4329c = mediaCodecCreateDecoderByType;
        ByteBuffer[] inputBuffers = mediaCodecCreateDecoderByType.getInputBuffers();
        Intrinsics.checkNotNullExpressionValue(inputBuffers, "decoder.inputBuffers");
        ByteBuffer[] outputBuffers = mediaCodecCreateDecoderByType.getOutputBuffers();
        String str2 = "decoder.outputBuffers";
        Intrinsics.checkNotNullExpressionValue(outputBuffers, "decoder.outputBuffers");
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int integer = trackFormat2.getInteger("sample-rate");
        int integer2 = trackFormat2.getInteger("channel-count");
        char c9 = 2;
        switch (integer2) {
            case 1:
                i9 = 2;
                break;
            case 2:
                i9 = 12;
                break;
            case 3:
                i9 = 28;
                break;
            case 4:
                i9 = l5.a.CODE_SCANNER_TASK_IN_PROGRESS;
                break;
            case 5:
                i9 = 220;
                break;
            case 6:
                i9 = 252;
                break;
            case 7:
                i9 = 1276;
                break;
            default:
                throw new RuntimeException(Intrinsics.stringPlus("Unsupported channel count: ", Integer.valueOf(integer2)));
        }
        AudioTrack audioTrack = new AudioTrack(3, integer, i9, 2, AudioTrack.getMinBufferSize(integer, i9, 2), 1);
        this.f4330d = audioTrack;
        if (audioTrack.getState() != 1) {
            b();
            Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
            Intrinsics.checkNotNullParameter("init audio track failure", NotificationCompat.CATEGORY_MESSAGE);
            return;
        }
        audioTrack.play();
        int i13 = 0;
        ByteBuffer[] byteBufferArr = outputBuffers;
        while (!this.f4332h) {
            if (i13 == 0 && (iDequeueInputBuffer = mediaCodecCreateDecoderByType.dequeueInputBuffer(1000L)) >= 0) {
                ByteBuffer byteBuffer = inputBuffers[iDequeueInputBuffer];
                byteBuffer.clear();
                int sampleData = extractor.readSampleData(byteBuffer, i11);
                if (sampleData < 0) {
                    mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                    i13 = 1;
                } else {
                    mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, 0L, 0);
                    extractor.advance();
                }
            }
            int iDequeueOutputBuffer = mediaCodecCreateDecoderByType.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -2) {
                ByteBuffer[] outputBuffers2 = mediaCodecCreateDecoderByType.getOutputBuffers();
                Intrinsics.checkNotNullExpressionValue(outputBuffers2, str2);
                byteBufferArr = outputBuffers2;
            }
            if (iDequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = byteBufferArr[iDequeueOutputBuffer];
                byte[] bArr = new byte[bufferInfo.size];
                byteBuffer2.get(bArr);
                byteBuffer2.clear();
                int i14 = bufferInfo.size;
                i10 = 0;
                audioTrack.write(bArr, 0, i14);
                mediaCodecCreateDecoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
            } else {
                i10 = 0;
            }
            if (i13 == 0 || (bufferInfo.flags & 4) == 0) {
                c9 = 2;
                i11 = i10;
            } else {
                int i15 = this.f4331g - 1;
                this.f4331g = i15;
                if (i15 <= 0) {
                    Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
                    Intrinsics.checkNotNullParameter("decode finish", NotificationCompat.CATEGORY_MESSAGE);
                    b();
                    b();
                }
                Intrinsics.checkNotNullParameter("AnimPlayer.AudioPlayer", "tag");
                Intrinsics.checkNotNullParameter("Reached EOS, looping -> playLoop", NotificationCompat.CATEGORY_MESSAGE);
                extractor.seekTo(0L, 2);
                mediaCodecCreateDecoderByType.flush();
                c9 = 2;
                i13 = i10;
                i11 = i13;
            }
        }
        b();
    }
}
