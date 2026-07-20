package d6;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import k3.ca;
import k3.da;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements SurfaceTexture.OnFrameAvailableListener, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f4346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f4347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f4348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f4349d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f4354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Surface f4355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SurfaceTexture f4356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f4357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4358o;
    public int p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MediaFormat f4359r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4360s;

    public t(d player) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(player, "player");
        this.f4346a = player;
        this.f4348c = new o();
        this.f4349d = new o();
        this.f4354k = LazyKt.lazy(n.INSTANCE);
        this.f4357n = LazyKt.lazy(s.INSTANCE);
        this.f4360s = true;
    }

    public static void j(t tVar, MediaCodec mediaCodec, MediaExtractor mediaExtractor) {
        Handler handler = tVar.f4348c.f4335b;
        if (handler == null) {
            return;
        }
        handler.post(new r(tVar, false, mediaCodec, mediaExtractor));
    }

    @Override // f6.a
    public final void a() {
        Intrinsics.checkNotNullParameter("AnimPlayer.Decoder", "tag");
        Intrinsics.checkNotNullParameter("onVideoComplete", NotificationCompat.CATEGORY_MESSAGE);
        f fVar = this.f4346a.f4313c;
        if (fVar == null) {
            return;
        }
        fVar.a();
    }

    @Override // f6.a
    public final void b() {
        Intrinsics.checkNotNullParameter("AnimPlayer.Decoder", "tag");
        Intrinsics.checkNotNullParameter("onVideoDestroy", NotificationCompat.CATEGORY_MESSAGE);
        f fVar = this.f4346a.f4313c;
        if (fVar == null) {
            return;
        }
        fVar.b();
    }

    @Override // f6.a
    public final void c(int i8, String str) {
        String msg = "onFailed errorType=" + i8 + ", errorMsg=" + ((Object) str);
        Intrinsics.checkNotNullParameter("AnimPlayer.Decoder", "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        f fVar = this.f4346a.f4313c;
        if (fVar == null) {
            return;
        }
        fVar.c(i8, str);
    }

    @Override // f6.a
    public final void d() {
        Intrinsics.checkNotNullParameter("AnimPlayer.Decoder", "tag");
        Intrinsics.checkNotNullParameter("onVideoStart", NotificationCompat.CATEGORY_MESSAGE);
        f fVar = this.f4346a.f4313c;
        if (fVar == null) {
            return;
        }
        fVar.d();
    }

    @Override // f6.a
    public final void e(int i8, a aVar) {
        Intrinsics.checkNotNullParameter("AnimPlayer.Decoder", "tag");
        Intrinsics.checkNotNullParameter("onVideoRender", NotificationCompat.CATEGORY_MESSAGE);
        f fVar = this.f4346a.f4313c;
        if (fVar == null) {
            return;
        }
        fVar.e(i8, aVar);
    }

    @Override // f6.a
    public final boolean f(a config) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(config, "config");
        return true;
    }

    public final void g() {
        Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
        Intrinsics.checkNotNullParameter("destroyInner", NotificationCompat.CATEGORY_MESSAGE);
        Handler handler = this.f4348c.f4335b;
        if (handler == null) {
            return;
        }
        handler.post(new p(this, 0));
    }

    public final void h(int i8, int i9) {
        w wVar;
        d dVar = this.f4346a;
        a aVar = (a) dVar.f4323o.f10138c;
        if ((aVar == null || aVar.f4302k) && aVar != null) {
            aVar.f4297d = i8;
            aVar.e = i9;
            int i10 = aVar.f4303l;
            if (i10 == 1) {
                int i11 = i8 / 2;
                aVar.f4295b = i11;
                aVar.f4296c = i9;
                v vVar = new v(0, 0, i11, i9);
                Intrinsics.checkNotNullParameter(vVar, "<set-?>");
                aVar.f4300i = vVar;
                int i12 = aVar.f4295b;
                v vVar2 = new v(i12, 0, i12, aVar.f4296c);
                Intrinsics.checkNotNullParameter(vVar2, "<set-?>");
                aVar.f4301j = vVar2;
            } else if (i10 == 2) {
                aVar.f4295b = i8;
                int i13 = i9 / 2;
                aVar.f4296c = i13;
                v vVar3 = new v(0, 0, i8, i13);
                Intrinsics.checkNotNullParameter(vVar3, "<set-?>");
                aVar.f4300i = vVar3;
                int i14 = aVar.f4296c;
                v vVar4 = new v(0, i14, aVar.f4295b, i14);
                Intrinsics.checkNotNullParameter(vVar4, "<set-?>");
                aVar.f4301j = vVar4;
            } else if (i10 == 3) {
                int i15 = i8 / 2;
                aVar.f4295b = i15;
                aVar.f4296c = i9;
                v vVar5 = new v(0, 0, i15, i9);
                Intrinsics.checkNotNullParameter(vVar5, "<set-?>");
                aVar.f4301j = vVar5;
                int i16 = aVar.f4295b;
                v vVar6 = new v(i16, 0, i16, aVar.f4296c);
                Intrinsics.checkNotNullParameter(vVar6, "<set-?>");
                aVar.f4300i = vVar6;
            } else if (i10 != 4) {
                int i17 = i8 / 2;
                aVar.f4295b = i17;
                aVar.f4296c = i9;
                v vVar7 = new v(0, 0, i17, i9);
                Intrinsics.checkNotNullParameter(vVar7, "<set-?>");
                aVar.f4300i = vVar7;
                int i18 = aVar.f4295b;
                v vVar8 = new v(i18, 0, i18, aVar.f4296c);
                Intrinsics.checkNotNullParameter(vVar8, "<set-?>");
                aVar.f4301j = vVar8;
            } else {
                aVar.f4295b = i8;
                int i19 = i9 / 2;
                aVar.f4296c = i19;
                v vVar9 = new v(0, 0, i8, i19);
                Intrinsics.checkNotNullParameter(vVar9, "<set-?>");
                aVar.f4301j = vVar9;
                int i20 = aVar.f4296c;
                v vVar10 = new v(0, i20, aVar.f4295b, i20);
                Intrinsics.checkNotNullParameter(vVar10, "<set-?>");
                aVar.f4300i = vVar10;
            }
        }
        a config = (a) dVar.f4323o.f10138c;
        if (config != null && (wVar = this.f4347b) != null) {
            wVar.getClass();
            Intrinsics.checkNotNullParameter(config, "config");
            int i21 = config.f4295b;
            int i22 = config.f4296c;
            v rect = new v(0, 0, i21, i22);
            sj.a aVar2 = wVar.f4365a;
            float[] array = (float[]) aVar2.f10137b;
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(array, "array");
            float f = i21;
            array[0] = ((rect.f4361a / f) * 2.0f) - 1.0f;
            float f4 = rect.f4362b;
            float f10 = i22;
            float f11 = f4 / f10;
            array[1] = da.a(f11);
            float f12 = rect.f4361a;
            array[2] = ((f12 / f) * 2.0f) - 1.0f;
            float f13 = (f4 + rect.f4364d) / f10;
            array[3] = da.a(f13);
            float f14 = (((f12 + rect.f4363c) / f) * 2.0f) - 1.0f;
            array[4] = f14;
            array[5] = da.a(f11);
            array[6] = f14;
            array[7] = da.a(f13);
            aVar2.l(array);
            int i23 = config.f4297d;
            int i24 = config.e;
            v vVar11 = config.f4300i;
            sj.a aVar3 = wVar.f4366b;
            float[] fArr = (float[]) aVar3.f10137b;
            ca.a(i23, i24, vVar11, fArr);
            int i25 = config.f4297d;
            int i26 = config.e;
            v vVar12 = config.f4301j;
            sj.a aVar4 = wVar.f4367c;
            float[] fArr2 = (float[]) aVar4.f10137b;
            ca.a(i25, i26, vVar12, fArr2);
            aVar3.l(fArr);
            aVar4.l(fArr2);
        }
        ef.g gVar = dVar.p;
        gVar.getClass();
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", "tag");
        Intrinsics.checkNotNullParameter("onRenderCreate", NotificationCompat.CATEGORY_MESSAGE);
        gVar.f4921a = 0;
        gVar.f4922b = 0;
        Iterator it = ((List) gVar.e).iterator();
        while (it.hasNext()) {
            ((i6.a) it.next()).f();
        }
    }

    public final boolean i() {
        if (this.f4347b == null) {
            Intrinsics.checkNotNullParameter("AnimPlayer.Decoder", "tag");
            Intrinsics.checkNotNullParameter("prepareRender", NotificationCompat.CATEGORY_MESSAGE);
            SurfaceTexture surfaceTexture = this.f4346a.f4311a.getSurfaceTexture();
            if (surfaceTexture != null) {
                w wVar = new w(surfaceTexture);
                wVar.d(this.e, this.f);
                Unit unit = Unit.INSTANCE;
                this.f4347b = wVar;
            }
        }
        return this.f4347b != null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0253 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x0285 A[LOOP:1: B:103:0x027f->B:105:0x0285, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:109:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:111:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:124:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x022e A[EDGE_INSN: B:138:0x022e->B:95:0x022e BREAK  A[LOOP:2: B:80:0x01eb->B:94:0x0223], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:30:0x0101  */
    /* JADX WARN: Code duplicated, block: B:41:0x0139  */
    /* JADX WARN: Code duplicated, block: B:43:0x0147  */
    /* JADX WARN: Code duplicated, block: B:45:0x014b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0155  */
    /* JADX WARN: Code duplicated, block: B:52:0x015c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0164  */
    /* JADX WARN: Code duplicated, block: B:56:0x0166  */
    /* JADX WARN: Code duplicated, block: B:58:0x0169  */
    /* JADX WARN: Code duplicated, block: B:59:0x016b  */
    /* JADX WARN: Code duplicated, block: B:62:0x0172  */
    /* JADX WARN: Code duplicated, block: B:64:0x0191  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x01da  */
    /* JADX WARN: Code duplicated, block: B:82:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:84:0x0201  */
    /* JADX WARN: Code duplicated, block: B:96:0x023b  */
    public final void k(MediaExtractor mediaExtractor, MediaCodec mediaCodec) {
        String str;
        String str2;
        o oVar;
        Object obj;
        boolean z2;
        Lazy lazy;
        int iDequeueOutputBuffer;
        int i8;
        d dVar;
        int i9;
        Lazy lazy2;
        boolean z3;
        Lazy lazy3;
        int i10;
        int i11;
        long j8;
        d dVar2;
        Iterator it;
        Object obj2;
        MediaExtractor mediaExtractor2;
        int i12;
        Handler handler;
        j6.l lVar;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long jNanoTime;
        long j15;
        long j16;
        t tVar;
        l lVar2;
        boolean z5;
        MediaFormat outputFormat;
        t tVar2 = this;
        MediaExtractor mediaExtractor3 = mediaExtractor;
        MediaCodec mediaCodec2 = mediaCodec;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        Intrinsics.checkNotNullExpressionValue(inputBuffers, "decoder.inputBuffers");
        int i13 = 0;
        boolean z10 = false;
        boolean z11 = false;
        int i14 = 0;
        int i15 = 0;
        boolean z12 = false;
        while (!z11) {
            boolean z13 = tVar2.f4353j;
            o oVar2 = tVar2.f4348c;
            boolean z14 = true;
            if (z13) {
                Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
                Intrinsics.checkNotNullParameter("stop decode", NotificationCompat.CATEGORY_MESSAGE);
                Handler handler2 = oVar2.f4335b;
                if (handler2 == null) {
                    return;
                }
                handler2.post(new r(tVar2, z14, mediaCodec2, mediaExtractor3));
                return;
            }
            if (z10) {
                str = "tag";
                str2 = NotificationCompat.CATEGORY_MESSAGE;
                oVar = oVar2;
                obj = "AnimPlayer.HardDecoder";
            } else {
                int iDequeueInputBuffer = mediaCodec2.dequeueInputBuffer(WorkRequest.MIN_BACKOFF_MILLIS);
                if (iDequeueInputBuffer >= 0) {
                    int sampleData = mediaExtractor3.readSampleData(inputBuffers[iDequeueInputBuffer], i13);
                    if (sampleData < 0) {
                        str = "tag";
                        inputBuffers = inputBuffers;
                        mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                        Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", str);
                        Intrinsics.checkNotNullParameter("decode EOS", NotificationCompat.CATEGORY_MESSAGE);
                        str2 = NotificationCompat.CATEGORY_MESSAGE;
                        oVar = oVar2;
                        z2 = true;
                        obj = "AnimPlayer.HardDecoder";
                    } else {
                        str = "tag";
                        oVar = oVar2;
                        obj = "AnimPlayer.HardDecoder";
                        mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, mediaExtractor.getSampleTime(), 0);
                        String strF = o.d.f(i14, sampleData, "submitted frame ", " to dec, size=");
                        Intrinsics.checkNotNullParameter(obj, str);
                        str2 = NotificationCompat.CATEGORY_MESSAGE;
                        Intrinsics.checkNotNullParameter(strF, str2);
                        i14++;
                        mediaExtractor.advance();
                    }
                    if (!z11) {
                        lazy = tVar2.f4357n;
                        iDequeueOutputBuffer = mediaCodec2.dequeueOutputBuffer((MediaCodec.BufferInfo) lazy.getValue(), WorkRequest.MIN_BACKOFF_MILLIS);
                        if (iDequeueOutputBuffer == -1) {
                            Intrinsics.checkNotNullParameter(obj, str);
                            Intrinsics.checkNotNullParameter("no output from decoder available", str2);
                        } else if (iDequeueOutputBuffer == -3) {
                            Intrinsics.checkNotNullParameter(obj, str);
                            Intrinsics.checkNotNullParameter("decoder output buffers changed", str2);
                        } else if (iDequeueOutputBuffer == -2) {
                            outputFormat = mediaCodec.getOutputFormat();
                            tVar2.f4359r = outputFormat;
                            if (outputFormat != null) {
                                try {
                                    outputFormat.getInteger("stride");
                                    outputFormat.getInteger("slice-height");
                                } catch (Throwable tr) {
                                    String strValueOf = String.valueOf(tr);
                                    Intrinsics.checkNotNullParameter(obj, str);
                                    Intrinsics.checkNotNullParameter(strValueOf, str2);
                                    Intrinsics.checkNotNullParameter(tr, "tr");
                                }
                            }
                            String strStringPlus = Intrinsics.stringPlus("decoder output format changed: ", tVar2.f4359r);
                            Intrinsics.checkNotNullParameter(obj, str);
                            Intrinsics.checkNotNullParameter(strStringPlus, str2);
                        } else {
                            if (iDequeueOutputBuffer >= 0) {
                                throw new RuntimeException(Intrinsics.stringPlus("unexpected result from decoder.dequeueOutputBuffer: ", Integer.valueOf(iDequeueOutputBuffer)));
                            }
                            i8 = ((MediaCodec.BufferInfo) lazy.getValue()).flags & 4;
                            dVar = tVar2.f4346a;
                            if (i8 != 0) {
                                i9 = 0;
                            } else if (tVar2.f4351h) {
                                i9 = 1;
                            } else {
                                i9 = tVar2.f4350g - 1;
                                tVar2.f4350g = i9;
                                tVar = dVar.f4314d;
                                if (tVar != null) {
                                    tVar.f4350g = i9;
                                }
                                lVar2 = dVar.e;
                                if (lVar2 != null) {
                                    lVar2.f4331g = i9;
                                }
                                dVar.f4316h = i9;
                                if (tVar2.f4350g <= 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                z11 = z5;
                            }
                            lazy2 = tVar2.f4354k;
                            z3 = z2;
                            if (z11) {
                                lazy3 = lazy2;
                                i10 = i9;
                                i11 = i14;
                            } else {
                                lVar = (j6.l) lazy2.getValue();
                                lazy3 = lazy2;
                                i10 = i9;
                                j10 = ((MediaCodec.BufferInfo) lazy.getValue()).presentationTimeUs;
                                j11 = lVar.f6124b;
                                i11 = i14;
                                if (j11 == 0) {
                                    lVar.f6124b = System.nanoTime() / ((long) 1000);
                                    lVar.f6123a = j10;
                                } else {
                                    dVar = dVar;
                                    if (lVar.f6126d) {
                                        lVar.f6123a = j10 - (1000000 / ((long) 30));
                                        lVar.f6126d = false;
                                    }
                                    j12 = lVar.f6125c;
                                    j8 = 0;
                                    if (j12 == 0) {
                                        j12 = j10 - lVar.f6123a;
                                    }
                                    if (j12 < 0) {
                                        j12 = 0;
                                    } else if (j12 > ((long) 10) * 1000000) {
                                        j12 = ((long) 5) * 1000000;
                                    }
                                    j13 = j11 + j12;
                                    obj = obj;
                                    j14 = 1000;
                                    jNanoTime = System.nanoTime() / j14;
                                    while (true) {
                                        z11 = z11;
                                        j15 = j12;
                                        if (jNanoTime < j13 - ((long) 100)) {
                                            break;
                                        }
                                        j16 = j13 - jNanoTime;
                                        if (j16 > 500000) {
                                            j16 = 500000;
                                        }
                                        try {
                                            try {
                                                Thread.sleep(j16 / j14, ((int) (j16 % j14)) * 1000);
                                            } catch (InterruptedException e) {
                                                tr = e;
                                                String strStringPlus2 = Intrinsics.stringPlus("e=", tr);
                                                Intrinsics.checkNotNullParameter("AnimPlayer.SpeedControlUtil", str);
                                                Intrinsics.checkNotNullParameter(strStringPlus2, str2);
                                                Intrinsics.checkNotNullParameter(tr, "tr");
                                            }
                                        } catch (InterruptedException e4) {
                                            tr = e4;
                                        }
                                        jNanoTime = System.nanoTime() / j14;
                                        z11 = z11;
                                        j12 = j15;
                                    }
                                    lVar.f6124b += j15;
                                    lVar.f6123a += j15;
                                }
                                mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, !z11);
                                if (i15 == 0 && !z12) {
                                    d();
                                }
                                dVar2 = dVar;
                                ef.g gVar = dVar2.p;
                                gVar.getClass();
                                String strStringPlus3 = Intrinsics.stringPlus("onDecoding decodeIndex=", Integer.valueOf(i15));
                                Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", str);
                                Intrinsics.checkNotNullParameter(strStringPlus3, str2);
                                int i16 = i15;
                                gVar.f4922b = i16;
                                it = ((List) gVar.e).iterator();
                                while (it.hasNext()) {
                                    ((i6.a) it.next()).getClass();
                                }
                                e(i16, (a) dVar2.f4323o.f10138c);
                                i15 = i16 + 1;
                                String strStringPlus4 = Intrinsics.stringPlus("decode frameIndex=", Integer.valueOf(i15));
                                obj2 = obj;
                                Intrinsics.checkNotNullParameter(obj2, str);
                                Intrinsics.checkNotNullParameter(strStringPlus4, str2);
                                if (i10 > 0) {
                                    Intrinsics.checkNotNullParameter(obj2, str);
                                    Intrinsics.checkNotNullParameter("Reached EOD, looping", str2);
                                    ef.g gVar2 = dVar2.p;
                                    gVar2.getClass();
                                    Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", str);
                                    Intrinsics.checkNotNullParameter("onLoopStart", str2);
                                    i12 = 0;
                                    gVar2.f4921a = 0;
                                    gVar2.f4922b = 0;
                                    mediaExtractor2 = mediaExtractor;
                                    long j17 = j8;
                                    mediaExtractor2.seekTo(j17, 2);
                                    mediaCodec.flush();
                                    j6.l lVar3 = (j6.l) lazy3.getValue();
                                    lVar3.f6123a = j17;
                                    lVar3.f6124b = j17;
                                    z10 = false;
                                    i15 = 0;
                                    z12 = true;
                                } else {
                                    mediaExtractor2 = mediaExtractor;
                                    i12 = 0;
                                    z10 = z3;
                                }
                                if (z11 && (handler = oVar.f4335b) != null) {
                                    handler.post(new r(this, true, mediaCodec, mediaExtractor2));
                                }
                                mediaCodec2 = mediaCodec;
                                i13 = i12;
                                mediaExtractor3 = mediaExtractor2;
                                tVar2 = this;
                                i14 = i11;
                                z11 = z11;
                            }
                            i15 = i15;
                            j8 = 0;
                            mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, !z11);
                            if (i15 == 0) {
                                d();
                            }
                            dVar2 = dVar;
                            ef.g gVar3 = dVar2.p;
                            gVar3.getClass();
                            String strStringPlus5 = Intrinsics.stringPlus("onDecoding decodeIndex=", Integer.valueOf(i15));
                            Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", str);
                            Intrinsics.checkNotNullParameter(strStringPlus5, str2);
                            int i17 = i15;
                            gVar3.f4922b = i17;
                            it = ((List) gVar3.e).iterator();
                            while (it.hasNext()) {
                                ((i6.a) it.next()).getClass();
                            }
                            e(i17, (a) dVar2.f4323o.f10138c);
                            i15 = i17 + 1;
                            String strStringPlus6 = Intrinsics.stringPlus("decode frameIndex=", Integer.valueOf(i15));
                            obj2 = obj;
                            Intrinsics.checkNotNullParameter(obj2, str);
                            Intrinsics.checkNotNullParameter(strStringPlus6, str2);
                            if (i10 > 0) {
                                Intrinsics.checkNotNullParameter(obj2, str);
                                Intrinsics.checkNotNullParameter("Reached EOD, looping", str2);
                                ef.g gVar4 = dVar2.p;
                                gVar4.getClass();
                                Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", str);
                                Intrinsics.checkNotNullParameter("onLoopStart", str2);
                                i12 = 0;
                                gVar4.f4921a = 0;
                                gVar4.f4922b = 0;
                                mediaExtractor2 = mediaExtractor;
                                long j18 = j8;
                                mediaExtractor2.seekTo(j18, 2);
                                mediaCodec.flush();
                                j6.l lVar4 = (j6.l) lazy3.getValue();
                                lVar4.f6123a = j18;
                                lVar4.f6124b = j18;
                                z10 = false;
                                i15 = 0;
                                z12 = true;
                            } else {
                                mediaExtractor2 = mediaExtractor;
                                i12 = 0;
                                z10 = z3;
                            }
                            if (z11) {
                                handler.post(new r(this, true, mediaCodec, mediaExtractor2));
                            }
                            mediaCodec2 = mediaCodec;
                            i13 = i12;
                            mediaExtractor3 = mediaExtractor2;
                            tVar2 = this;
                            i14 = i11;
                            z11 = z11;
                        }
                    }
                    mediaCodec2 = mediaCodec2;
                    i13 = 0;
                    mediaExtractor3 = mediaExtractor3;
                    i15 = i15;
                    tVar2 = tVar2;
                    z10 = z2;
                    i14 = i14;
                } else {
                    str = "tag";
                    str2 = NotificationCompat.CATEGORY_MESSAGE;
                    oVar = oVar2;
                    obj = "AnimPlayer.HardDecoder";
                    Intrinsics.checkNotNullParameter(obj, str);
                    Intrinsics.checkNotNullParameter("input buffer not available", str2);
                }
            }
            z2 = z10;
            if (!z11) {
                lazy = tVar2.f4357n;
                iDequeueOutputBuffer = mediaCodec2.dequeueOutputBuffer((MediaCodec.BufferInfo) lazy.getValue(), WorkRequest.MIN_BACKOFF_MILLIS);
                if (iDequeueOutputBuffer == -1) {
                    Intrinsics.checkNotNullParameter(obj, str);
                    Intrinsics.checkNotNullParameter("no output from decoder available", str2);
                } else if (iDequeueOutputBuffer == -3) {
                    Intrinsics.checkNotNullParameter(obj, str);
                    Intrinsics.checkNotNullParameter("decoder output buffers changed", str2);
                } else if (iDequeueOutputBuffer == -2) {
                    outputFormat = mediaCodec.getOutputFormat();
                    tVar2.f4359r = outputFormat;
                    if (outputFormat != null) {
                        outputFormat.getInteger("stride");
                        outputFormat.getInteger("slice-height");
                    }
                    String strStringPlus7 = Intrinsics.stringPlus("decoder output format changed: ", tVar2.f4359r);
                    Intrinsics.checkNotNullParameter(obj, str);
                    Intrinsics.checkNotNullParameter(strStringPlus7, str2);
                } else {
                    if (iDequeueOutputBuffer >= 0) {
                        throw new RuntimeException(Intrinsics.stringPlus("unexpected result from decoder.dequeueOutputBuffer: ", Integer.valueOf(iDequeueOutputBuffer)));
                    }
                    i8 = ((MediaCodec.BufferInfo) lazy.getValue()).flags & 4;
                    dVar = tVar2.f4346a;
                    if (i8 != 0) {
                        i9 = 0;
                    } else if (tVar2.f4351h) {
                        i9 = tVar2.f4350g - 1;
                        tVar2.f4350g = i9;
                        tVar = dVar.f4314d;
                        if (tVar != null) {
                            tVar.f4350g = i9;
                        }
                        lVar2 = dVar.e;
                        if (lVar2 != null) {
                            lVar2.f4331g = i9;
                        }
                        dVar.f4316h = i9;
                        if (tVar2.f4350g <= 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z11 = z5;
                    } else {
                        i9 = 1;
                    }
                    lazy2 = tVar2.f4354k;
                    z3 = z2;
                    if (z11) {
                        lVar = (j6.l) lazy2.getValue();
                        lazy3 = lazy2;
                        i10 = i9;
                        j10 = ((MediaCodec.BufferInfo) lazy.getValue()).presentationTimeUs;
                        j11 = lVar.f6124b;
                        i11 = i14;
                        if (j11 == 0) {
                            lVar.f6124b = System.nanoTime() / ((long) 1000);
                            lVar.f6123a = j10;
                        } else {
                            dVar = dVar;
                            if (lVar.f6126d) {
                                lVar.f6123a = j10 - (1000000 / ((long) 30));
                                lVar.f6126d = false;
                            }
                            j12 = lVar.f6125c;
                            j8 = 0;
                            if (j12 == 0) {
                                j12 = j10 - lVar.f6123a;
                            }
                            if (j12 < 0) {
                                j12 = 0;
                            } else if (j12 > ((long) 10) * 1000000) {
                                j12 = ((long) 5) * 1000000;
                            }
                            j13 = j11 + j12;
                            obj = obj;
                            j14 = 1000;
                            jNanoTime = System.nanoTime() / j14;
                            while (true) {
                                z11 = z11;
                                j15 = j12;
                                if (jNanoTime < j13 - ((long) 100)) {
                                    break;
                                    break;
                                }
                                j16 = j13 - jNanoTime;
                                if (j16 > 500000) {
                                    j16 = 500000;
                                }
                                Thread.sleep(j16 / j14, ((int) (j16 % j14)) * 1000);
                                jNanoTime = System.nanoTime() / j14;
                                z11 = z11;
                                j12 = j15;
                            }
                            lVar.f6124b += j15;
                            lVar.f6123a += j15;
                        }
                        mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, !z11);
                        if (i15 == 0) {
                            d();
                        }
                        dVar2 = dVar;
                        ef.g gVar5 = dVar2.p;
                        gVar5.getClass();
                        String strStringPlus8 = Intrinsics.stringPlus("onDecoding decodeIndex=", Integer.valueOf(i15));
                        Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", str);
                        Intrinsics.checkNotNullParameter(strStringPlus8, str2);
                        int i18 = i15;
                        gVar5.f4922b = i18;
                        it = ((List) gVar5.e).iterator();
                        while (it.hasNext()) {
                            ((i6.a) it.next()).getClass();
                        }
                        e(i18, (a) dVar2.f4323o.f10138c);
                        i15 = i18 + 1;
                        String strStringPlus9 = Intrinsics.stringPlus("decode frameIndex=", Integer.valueOf(i15));
                        obj2 = obj;
                        Intrinsics.checkNotNullParameter(obj2, str);
                        Intrinsics.checkNotNullParameter(strStringPlus9, str2);
                        if (i10 > 0) {
                            Intrinsics.checkNotNullParameter(obj2, str);
                            Intrinsics.checkNotNullParameter("Reached EOD, looping", str2);
                            ef.g gVar6 = dVar2.p;
                            gVar6.getClass();
                            Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", str);
                            Intrinsics.checkNotNullParameter("onLoopStart", str2);
                            i12 = 0;
                            gVar6.f4921a = 0;
                            gVar6.f4922b = 0;
                            mediaExtractor2 = mediaExtractor;
                            long j19 = j8;
                            mediaExtractor2.seekTo(j19, 2);
                            mediaCodec.flush();
                            j6.l lVar5 = (j6.l) lazy3.getValue();
                            lVar5.f6123a = j19;
                            lVar5.f6124b = j19;
                            z10 = false;
                            i15 = 0;
                            z12 = true;
                        } else {
                            mediaExtractor2 = mediaExtractor;
                            i12 = 0;
                            z10 = z3;
                        }
                        if (z11) {
                            handler.post(new r(this, true, mediaCodec, mediaExtractor2));
                        }
                        mediaCodec2 = mediaCodec;
                        i13 = i12;
                        mediaExtractor3 = mediaExtractor2;
                        tVar2 = this;
                        i14 = i11;
                        z11 = z11;
                    } else {
                        lazy3 = lazy2;
                        i10 = i9;
                        i11 = i14;
                    }
                    i15 = i15;
                    j8 = 0;
                    mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, !z11);
                    if (i15 == 0) {
                        d();
                    }
                    dVar2 = dVar;
                    ef.g gVar7 = dVar2.p;
                    gVar7.getClass();
                    String strStringPlus10 = Intrinsics.stringPlus("onDecoding decodeIndex=", Integer.valueOf(i15));
                    Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", str);
                    Intrinsics.checkNotNullParameter(strStringPlus10, str2);
                    int i19 = i15;
                    gVar7.f4922b = i19;
                    it = ((List) gVar7.e).iterator();
                    while (it.hasNext()) {
                        ((i6.a) it.next()).getClass();
                    }
                    e(i19, (a) dVar2.f4323o.f10138c);
                    i15 = i19 + 1;
                    String strStringPlus11 = Intrinsics.stringPlus("decode frameIndex=", Integer.valueOf(i15));
                    obj2 = obj;
                    Intrinsics.checkNotNullParameter(obj2, str);
                    Intrinsics.checkNotNullParameter(strStringPlus11, str2);
                    if (i10 > 0) {
                        Intrinsics.checkNotNullParameter(obj2, str);
                        Intrinsics.checkNotNullParameter("Reached EOD, looping", str2);
                        ef.g gVar8 = dVar2.p;
                        gVar8.getClass();
                        Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", str);
                        Intrinsics.checkNotNullParameter("onLoopStart", str2);
                        i12 = 0;
                        gVar8.f4921a = 0;
                        gVar8.f4922b = 0;
                        mediaExtractor2 = mediaExtractor;
                        long j110 = j8;
                        mediaExtractor2.seekTo(j110, 2);
                        mediaCodec.flush();
                        j6.l lVar6 = (j6.l) lazy3.getValue();
                        lVar6.f6123a = j110;
                        lVar6.f6124b = j110;
                        z10 = false;
                        i15 = 0;
                        z12 = true;
                    } else {
                        mediaExtractor2 = mediaExtractor;
                        i12 = 0;
                        z10 = z3;
                    }
                    if (z11) {
                        handler.post(new r(this, true, mediaCodec, mediaExtractor2));
                    }
                    mediaCodec2 = mediaCodec;
                    i13 = i12;
                    mediaExtractor3 = mediaExtractor2;
                    tVar2 = this;
                    i14 = i11;
                    z11 = z11;
                }
            }
            mediaCodec2 = mediaCodec2;
            i13 = 0;
            mediaExtractor3 = mediaExtractor3;
            i15 = i15;
            tVar2 = tVar2;
            z10 = z2;
            i14 = i14;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.f4353j) {
            return;
        }
        Intrinsics.checkNotNullParameter("AnimPlayer.HardDecoder", "tag");
        Intrinsics.checkNotNullParameter("onFrameAvailable", NotificationCompat.CATEGORY_MESSAGE);
        Handler handler = this.f4348c.f4335b;
        if (handler == null) {
            return;
        }
        handler.post(new p(this, 1));
    }
}
