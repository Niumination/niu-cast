package q4;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import k4.m;

/* JADX INFO: loaded from: classes2.dex */
public class d implements e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f13824o = "AudioProducerImpl";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f13825p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f13826q = 44100;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f13827r = 12;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f13828s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f13829t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f13830u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f13831v = 7;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[] f13832w = {64000, 96000, 128000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13834e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HandlerThread f13836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f13837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f13838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MediaCodec f13839j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f13840k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public p4.c f13841l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AudioRecord f13833d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f13835f = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedBlockingDeque<Integer> f13842m = new LinkedBlockingDeque<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MediaCodec.Callback f13843n = new a();

    public class a extends MediaCodec.Callback {
        public a() {
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            m.b(d.f13824o, "mCallback, onError: " + codecException.getMessage());
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10) {
            d.this.f13842m.offer(Integer.valueOf(i10));
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i10, @NonNull MediaCodec.BufferInfo bufferInfo) {
            try {
                if (!d.this.f13835f) {
                    m.e(d.f13824o, "OutputBufferAvailable But not Recording");
                    return;
                }
                d.this.u(mediaCodec.getOutputBuffer(i10), bufferInfo);
                mediaCodec.releaseOutputBuffer(i10, false);
            } catch (Exception e10) {
                m.d(d.f13824o, e10);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
            m.b(d.f13824o, "mCallback, onOutputFormatChanged: " + mediaFormat.toString());
        }
    }

    public d(q4.a aVar, Context context) {
        HandlerThread handlerThread = new HandlerThread("audio_record");
        this.f13836g = handlerThread;
        handlerThread.start();
        this.f13837h = new Handler(handlerThread.getLooper());
        s(context);
        r();
    }

    @Override // q4.e
    public void e(List<String> list) {
        m.e(f13824o, "updateAudioUid, packageList: " + list);
        this.f13840k.c(list);
    }

    @Override // p4.b
    public void f(p4.c cVar) {
        this.f13841l = cVar;
    }

    @Override // q4.e
    public void i(boolean z10) {
        m.e(f13824o, "changeAudioRecord, isPolicyAudio: " + z10);
        AudioRecord audioRecord = this.f13833d;
        if (audioRecord != null) {
            audioRecord.release();
        }
        if (z10) {
            this.f13833d = this.f13840k.a();
        } else {
            this.f13833d = p();
        }
        try {
            AudioRecord audioRecord2 = this.f13833d;
            if (audioRecord2 == null || audioRecord2.getState() != 1) {
                m.c(f13824o, "changeAudioRecord: AudioRecord not initialized, skip startRecording");
            } else {
                this.f13833d.startRecording();
            }
        } catch (Exception e10) {
            m.d(f13824o, e10);
        }
    }

    public final byte[] o(int i10) {
        int i11 = i10 + 7;
        return new byte[]{-1, -15, (byte) 80, (byte) ((i11 >> 11) | 128), (byte) ((i11 >> 3) & 255), (byte) ((((i11 & 7) << 5) & 255) | 31), -4};
    }

    @b.a({"MissingPermission"})
    public final AudioRecord p() {
        return new AudioRecord(8, 44100, 12, 2, this.f13834e);
    }

    public final MediaFormat q() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", "audio/mp4a-latm");
        mediaFormat.setInteger("channel-count", 2);
        mediaFormat.setInteger("sample-rate", 44100);
        mediaFormat.setInteger("aac-profile", 2);
        mediaFormat.setInteger("max-input-size", this.f13834e);
        mediaFormat.setInteger("bitrate", f13832w[2]);
        return mediaFormat;
    }

    public final void r() {
        try {
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.f13839j = mediaCodecCreateEncoderByType;
            mediaCodecCreateEncoderByType.setCallback(this.f13843n);
            this.f13839j.configure(q(), (Surface) null, (MediaCrypto) null, 1);
        } catch (IOException e10) {
            m.d(f13824o, e10);
        }
    }

    public final void s(Context context) {
        this.f13840k = new b(context);
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 12, 2);
        this.f13834e = minBufferSize;
        if (minBufferSize == -2) {
            return;
        }
        this.f13833d = p();
        this.f13838i = new byte[this.f13834e];
    }

    @Override // p4.b
    public void start() {
        w();
    }

    @Override // p4.b
    public void stop() {
        this.f13835f = false;
    }

    public final /* synthetic */ void t() {
        try {
            try {
                AudioRecord audioRecord = this.f13833d;
                if (audioRecord == null || audioRecord.getState() != 1) {
                    m.c(f13824o, "changeAudioRecord: AudioRecord not initialized, skip startRecording");
                } else {
                    this.f13833d.startRecording();
                }
            } catch (Exception e10) {
                m.d(f13824o, e10);
            }
            this.f13835f = true;
            while (this.f13835f) {
                if (this.f13842m.isEmpty()) {
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e11) {
                        m.d(f13824o, e11);
                    }
                } else {
                    int iIntValue = this.f13842m.peek().intValue();
                    ByteBuffer inputBuffer = this.f13839j.getInputBuffer(iIntValue);
                    int i10 = 0;
                    try {
                        i10 = this.f13833d.read(this.f13838i, 0, this.f13834e);
                    } catch (Exception e12) {
                        m.d(f13824o, e12);
                    }
                    if (i10 <= 0) {
                        m.b(f13824o, "read recording data error");
                        try {
                            Thread.sleep(20L);
                        } catch (InterruptedException e13) {
                            m.d(f13824o, e13);
                        }
                    } else {
                        inputBuffer.clear();
                        inputBuffer.put(this.f13838i);
                        this.f13839j.queueInputBuffer(iIntValue, 0, this.f13838i.length, System.nanoTime() / 1000, 0);
                        this.f13842m.poll();
                    }
                }
            }
            v();
        } catch (Exception e14) {
            m.d(f13824o, e14);
        }
    }

    public final void u(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        int i10 = bufferInfo.size;
        byte[] bArr = new byte[i10 + 8];
        bArr[0] = c1.c.f1130x;
        System.arraycopy(o(i10), 0, bArr, 1, 7);
        byteBuffer.get(bArr, 8, bufferInfo.size);
        p4.c cVar = this.f13841l;
        if (cVar != null) {
            cVar.a(bArr);
        }
    }

    public final void v() {
        try {
            AudioRecord audioRecord = this.f13833d;
            if (audioRecord != null) {
                audioRecord.stop();
                this.f13833d.release();
                this.f13833d = null;
            }
            MediaCodec mediaCodec = this.f13839j;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f13839j.release();
                this.f13839j = null;
            }
            HandlerThread handlerThread = this.f13836g;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            b bVar = this.f13840k;
            if (bVar != null) {
                bVar.b();
            }
        } catch (Exception e10) {
            m.d(f13824o, e10);
        }
    }

    public final void w() {
        try {
            this.f13839j.start();
        } catch (Exception e10) {
            m.d(f13824o, e10);
        }
        this.f13837h.post(new Runnable() { // from class: q4.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f13823a.t();
            }
        });
    }

    public final void x() {
        this.f13835f = false;
    }
}
