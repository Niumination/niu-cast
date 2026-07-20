package f2;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import kn.k1;
import kn.l0;
import kn.n0;
import lm.l2;

/* JADX INFO: loaded from: classes.dex */
public final class x extends p implements SurfaceTexture.OnFrameAvailableListener {

    @os.l
    public static final a R = new a();

    @os.l
    public static final String S = "AnimPlayer.HardDecoder";

    @os.m
    public SurfaceTexture H;

    @os.l
    public final lm.d0 I;
    public boolean J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;

    @os.m
    public MediaFormat P;
    public boolean Q;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.m
    public Surface f5838z;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends n0 implements jn.a<MediaCodec.BufferInfo> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final MediaCodec.BufferInfo invoke() {
            return new MediaCodec.BufferInfo();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@os.l g gVar) {
        super(gVar);
        l0.p(gVar, "player");
        this.I = lm.f0.b(b.INSTANCE);
        this.Q = true;
    }

    public static final void L(x xVar) {
        l0.p(xVar, "this$0");
        z zVar = xVar.f5805b;
        if (zVar != null) {
            zVar.j();
        }
        xVar.f5804a.f5755s.f();
        z zVar2 = xVar.f5805b;
        if (zVar2 != null) {
            zVar2.g();
        }
        xVar.f5805b = null;
        xVar.b();
        xVar.h();
    }

    public static /* synthetic */ void P(x xVar, MediaCodec mediaCodec, MediaExtractor mediaExtractor, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        xVar.O(mediaCodec, mediaExtractor, z10);
    }

    public static final void Q(x xVar, boolean z10, MediaCodec mediaCodec, MediaExtractor mediaExtractor) {
        z zVar;
        l0.p(xVar, "this$0");
        if ((xVar.Q || !z10) && (zVar = xVar.f5805b) != null) {
            zVar.j();
        }
        try {
            l2.a.f9640a.e(S, "release");
            if (mediaCodec != null) {
                mediaCodec.stop();
                mediaCodec.release();
            }
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
            SurfaceTexture surfaceTexture = xVar.H;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            xVar.H = null;
            xVar.p().b();
            xVar.f5804a.f5755s.i();
            z zVar2 = xVar.f5805b;
            if (zVar2 != null) {
                zVar2.i();
            }
            Surface surface = xVar.f5838z;
            if (surface != null) {
                surface.release();
            }
            xVar.f5838z = null;
        } catch (Throwable th2) {
            l2.a.f9640a.c(S, l0.C("release e=", th2), th2);
        }
        xVar.f5813p = false;
        xVar.a();
        if (xVar.J) {
            xVar.K();
        }
    }

    public static final void S(x xVar) {
        l0.p(xVar, "this$0");
        try {
            SurfaceTexture surfaceTexture = xVar.H;
            if (surfaceTexture == null) {
                return;
            }
            surfaceTexture.updateTexImage();
            z zVar = xVar.f5805b;
            if (zVar != null) {
                zVar.e();
            }
            xVar.f5804a.f5755s.k();
            z zVar2 = xVar.f5805b;
            if (zVar2 == null) {
                return;
            }
            zVar2.b();
        } catch (Throwable th2) {
            l2.a.f9640a.c(S, l0.C("render exception=", th2), th2);
        }
    }

    public static final void U(x xVar, g2.c cVar) {
        l0.p(xVar, "this$0");
        l0.p(cVar, "$fileContainer");
        xVar.W(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void X(x xVar, k1.h hVar, MediaCodec mediaCodec, k1.h hVar2) {
        l0.p(xVar, "this$0");
        l0.p(hVar, "$extractor");
        l0.p(mediaCodec, "$this_apply");
        l0.p(hVar2, "$decoder");
        try {
            xVar.V((MediaExtractor) hVar.element, mediaCodec);
        } catch (Throwable th2) {
            l2.a.f9640a.c(S, l0.C("MediaCodec exception e=", th2), th2);
            xVar.c(o.f5787l, l0.C("0x2 MediaCodec exception e=", th2));
            P(xVar, (MediaCodec) hVar2.element, (MediaExtractor) hVar.element, false, 4, null);
        }
    }

    @Override // f2.p
    public void C(@os.l final g2.c cVar) {
        l0.p(cVar, "fileContainer");
        this.f5814v = false;
        this.J = false;
        this.f5813p = true;
        Handler handler = this.f5806c.f5825b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: f2.t
            @Override // java.lang.Runnable
            public final void run() {
                x.U(this.f5830a, cVar);
            }
        });
    }

    public final void K() {
        l2.a.f9640a.e(S, "destroyInner");
        Handler handler = this.f5806c.f5825b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: f2.u
            @Override // java.lang.Runnable
            public final void run() {
                x.L(this.f5832a);
            }
        });
    }

    public final boolean M() {
        return this.Q;
    }

    public final MediaCodec.BufferInfo N() {
        return (MediaCodec.BufferInfo) this.I.getValue();
    }

    public final void O(final MediaCodec mediaCodec, final MediaExtractor mediaExtractor, final boolean z10) {
        Handler handler = this.f5806c.f5825b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: f2.s
            @Override // java.lang.Runnable
            public final void run() {
                x.Q(this.f5826a, z10, mediaCodec, mediaExtractor);
            }
        });
    }

    public final void R() {
        Handler handler = this.f5806c.f5825b;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: f2.w
            @Override // java.lang.Runnable
            public final void run() {
                x.S(this.f5837a);
            }
        });
    }

    public final void T(boolean z10) {
        this.Q = z10;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0091  */
    /* JADX WARN: Code duplicated, block: B:22:0x009e  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:25:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:46:0x010c  */
    /* JADX WARN: Code duplicated, block: B:47:0x010e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0111  */
    /* JADX WARN: Code duplicated, block: B:50:0x0113  */
    /* JADX WARN: Code duplicated, block: B:52:0x0116  */
    /* JADX WARN: Code duplicated, block: B:61:0x0134  */
    /* JADX WARN: Code duplicated, block: B:68:0x0162  */
    /* JADX WARN: Code duplicated, block: B:69:0x0183  */
    /* JADX WARN: Code duplicated, block: B:71:0x0186  */
    /* JADX WARN: Code duplicated, block: B:75:0x019f  */
    /* JADX WARN: Code duplicated, block: B:77:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x018f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x018a A[SYNTHETIC] */
    public final void V(MediaExtractor mediaExtractor, MediaCodec mediaCodec) {
        String str;
        boolean z10;
        int iDequeueOutputBuffer;
        int i10;
        boolean z11;
        l2.a aVar;
        boolean z12;
        MediaFormat outputFormat;
        int integer;
        int integer2;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        l0.o(inputBuffers, "decoder.inputBuffers");
        int i11 = 0;
        boolean z13 = false;
        boolean z14 = false;
        int i12 = 0;
        int i13 = 0;
        boolean z15 = false;
        while (!z14) {
            if (this.f5814v) {
                l2.a.f9640a.e(S, "stop decode");
                O(mediaCodec, mediaExtractor, true);
                return;
            }
            if (z13) {
                str = S;
            } else {
                int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
                if (iDequeueInputBuffer >= 0) {
                    int sampleData = mediaExtractor.readSampleData(inputBuffers[iDequeueInputBuffer], i11);
                    if (sampleData < 0) {
                        str = S;
                        inputBuffers = inputBuffers;
                        z10 = true;
                        mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                        l2.a.f9640a.a(str, "decode EOS");
                    } else {
                        str = S;
                        mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, mediaExtractor.getSampleTime(), 0);
                        l2.a.f9640a.a(str, e0.a.a("submitted frame ", i12, " to dec, size=", sampleData));
                        i12++;
                        mediaExtractor.advance();
                    }
                    if (z14) {
                        z13 = z10;
                    } else {
                        iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(N(), 10000L);
                        if (iDequeueOutputBuffer == -1) {
                            l2.a.f9640a.a(str, "no output from decoder available");
                        } else if (iDequeueOutputBuffer == -3) {
                            l2.a.f9640a.a(str, "decoder output buffers changed");
                        } else if (iDequeueOutputBuffer == -2) {
                            outputFormat = mediaCodec.getOutputFormat();
                            this.P = outputFormat;
                            if (outputFormat != null) {
                                try {
                                    integer = outputFormat.getInteger("stride");
                                    integer2 = outputFormat.getInteger("slice-height");
                                    if (integer > 0 && integer2 > 0) {
                                        this.M = integer;
                                        this.N = integer2;
                                    }
                                } catch (Throwable th2) {
                                    l2.a.f9640a.c(str, String.valueOf(th2), th2);
                                }
                            }
                            l2.a.f9640a.e(str, l0.C("decoder output format changed: ", this.P));
                        } else {
                            if (iDequeueOutputBuffer >= 0) {
                                throw new RuntimeException(l0.C("unexpected result from decoder.dequeueOutputBuffer: ", Integer.valueOf(iDequeueOutputBuffer)));
                            }
                            if ((N().flags & 4) != 0) {
                                i10 = 0;
                            } else if (this.f5812n) {
                                i10 = 1;
                            } else {
                                i10 = this.f5811i - 1;
                                this.f5811i = i10;
                                this.f5804a.Q(i10);
                                if (this.f5811i <= 0) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                z14 = z12;
                            }
                            if (!z14) {
                                p().a(N().presentationTimeUs);
                            }
                            if (this.O && !z14) {
                                a0(mediaCodec, iDequeueOutputBuffer);
                            }
                            if (!z14 || this.O) {
                                z11 = false;
                            } else {
                                z11 = true;
                            }
                            mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, z11);
                            if (i13 == 0 && !z15) {
                                d();
                            }
                            this.f5804a.f5755s.e(i13);
                            e(i13, this.f5804a.f5754r.f5673b);
                            i13++;
                            aVar = l2.a.f9640a;
                            aVar.a(str, l0.C("decode frameIndex=", Integer.valueOf(i13)));
                            if (i10 > 0) {
                                aVar.a(str, "Reached EOD, looping");
                                this.f5804a.f5755s.h();
                                mediaExtractor.seekTo(0L, 2);
                                mediaCodec.flush();
                                p().b();
                                z13 = false;
                                i13 = 0;
                                z15 = true;
                            } else {
                                z13 = z10;
                            }
                            if (z14) {
                                O(mediaCodec, mediaExtractor, true);
                            }
                        }
                        z13 = z10;
                    }
                    inputBuffers = inputBuffers;
                    i11 = 0;
                } else {
                    str = S;
                    l2.a.f9640a.a(str, "input buffer not available");
                }
            }
            z10 = z13;
            if (z14) {
                z13 = z10;
            } else {
                iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(N(), 10000L);
                if (iDequeueOutputBuffer == -1) {
                    l2.a.f9640a.a(str, "no output from decoder available");
                } else if (iDequeueOutputBuffer == -3) {
                    l2.a.f9640a.a(str, "decoder output buffers changed");
                } else if (iDequeueOutputBuffer == -2) {
                    outputFormat = mediaCodec.getOutputFormat();
                    this.P = outputFormat;
                    if (outputFormat != null) {
                        integer = outputFormat.getInteger("stride");
                        integer2 = outputFormat.getInteger("slice-height");
                        if (integer > 0) {
                            this.M = integer;
                            this.N = integer2;
                        }
                    }
                    l2.a.f9640a.e(str, l0.C("decoder output format changed: ", this.P));
                } else {
                    if (iDequeueOutputBuffer >= 0) {
                        throw new RuntimeException(l0.C("unexpected result from decoder.dequeueOutputBuffer: ", Integer.valueOf(iDequeueOutputBuffer)));
                    }
                    if ((N().flags & 4) != 0) {
                        i10 = 0;
                    } else if (this.f5812n) {
                        i10 = this.f5811i - 1;
                        this.f5811i = i10;
                        this.f5804a.Q(i10);
                        if (this.f5811i <= 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        z14 = z12;
                    } else {
                        i10 = 1;
                    }
                    if (!z14) {
                        p().a(N().presentationTimeUs);
                    }
                    if (this.O) {
                        a0(mediaCodec, iDequeueOutputBuffer);
                    }
                    if (z14) {
                        z11 = false;
                    } else {
                        z11 = false;
                    }
                    mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, z11);
                    if (i13 == 0) {
                        d();
                    }
                    this.f5804a.f5755s.e(i13);
                    e(i13, this.f5804a.f5754r.f5673b);
                    i13++;
                    aVar = l2.a.f9640a;
                    aVar.a(str, l0.C("decode frameIndex=", Integer.valueOf(i13)));
                    if (i10 > 0) {
                        aVar.a(str, "Reached EOD, looping");
                        this.f5804a.f5755s.h();
                        mediaExtractor.seekTo(0L, 2);
                        mediaCodec.flush();
                        p().b();
                        z13 = false;
                        i13 = 0;
                        z15 = true;
                    } else {
                        z13 = z10;
                    }
                    if (z14) {
                        O(mediaCodec, mediaExtractor, true);
                    }
                }
                z13 = z10;
            }
            inputBuffers = inputBuffers;
            i11 = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, android.media.MediaCodec] */
    /* JADX WARN: Type inference failed for: r13v5, types: [T, android.media.MediaExtractor] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void W(g2.c cVar) {
        final k1.h hVar = new k1.h();
        final k1.h hVar2 = new k1.h();
        try {
            l2.f fVar = l2.f.f9646a;
            ?? C = fVar.c(cVar);
            hVar.element = C;
            int iF = fVar.f(C);
            if (iF < 0) {
                throw new RuntimeException("No video track found");
            }
            ((MediaExtractor) hVar.element).selectTrack(iF);
            MediaFormat trackFormat = ((MediaExtractor) hVar.element).getTrackFormat(iF);
            if (trackFormat == null) {
                throw new RuntimeException("format is null");
            }
            if (fVar.a(trackFormat)) {
                int i10 = Build.VERSION.SDK_INT;
                if (!fVar.b("video/hevc")) {
                    c(o.f5793r, "0x8 hevc not support sdk:" + i10 + ",support hevc:" + fVar.b("video/hevc"));
                    P(this, null, null, false, 4, null);
                    return;
                }
            }
            this.K = trackFormat.getInteger("width");
            int integer = trackFormat.getInteger("height");
            this.L = integer;
            this.M = this.K;
            this.N = integer;
            l2.a aVar = l2.a.f9640a;
            aVar.e(S, "Video size is " + this.K + " x " + this.L);
            boolean z10 = this.K % 16 != 0 && this.f5804a.f5747k;
            this.O = z10;
            try {
                if (!u(z10)) {
                    throw new RuntimeException("render create fail");
                }
                t(this.K, this.L);
                z zVar = this.f5805b;
                if (zVar != null) {
                    SurfaceTexture surfaceTexture = new SurfaceTexture(zVar.h());
                    surfaceTexture.setOnFrameAvailableListener(this);
                    surfaceTexture.setDefaultBufferSize(this.K, this.L);
                    l2 l2Var = l2.f10208a;
                    this.H = surfaceTexture;
                }
                try {
                    String string = trackFormat.getString("mime");
                    if (string == null) {
                        string = "";
                    }
                    aVar.e(S, l0.C("Video MIME is ", string));
                    final ?? CreateDecoderByType = MediaCodec.createDecoderByType(string);
                    if (this.O) {
                        trackFormat.setInteger("color-format", 19);
                        CreateDecoderByType.configure(trackFormat, null, null, 0);
                    } else {
                        Surface surface = new Surface(this.H);
                        this.f5838z = surface;
                        CreateDecoderByType.configure(trackFormat, surface, null, 0);
                    }
                    CreateDecoderByType.start();
                    Handler handler = this.f5807d.f5825b;
                    if (handler != null) {
                        handler.post(new Runnable() { // from class: f2.v
                            @Override // java.lang.Runnable
                            public final void run() {
                                x.X(this.f5833a, hVar, CreateDecoderByType, hVar2);
                            }
                        });
                    }
                    l2 l2Var2 = l2.f10208a;
                    hVar2.element = CreateDecoderByType;
                } catch (Throwable th2) {
                    l2.a.f9640a.c(S, l0.C("MediaCodec configure exception e=", th2), th2);
                    c(o.f5787l, l0.C("0x2 MediaCodec exception e=", th2));
                    P(this, (MediaCodec) hVar2.element, (MediaExtractor) hVar.element, false, 4, null);
                }
            } catch (Throwable th3) {
                c(o.f5789n, l0.C("0x4 render create fail e=", th3));
                P(this, null, null, false, 4, null);
            }
        } catch (Throwable th4) {
            l2.a.f9640a.c(S, l0.C("MediaExtractor exception e=", th4), th4);
            c(10001, l0.C("0x1 MediaExtractor exception e=", th4));
            P(this, (MediaCodec) hVar2.element, (MediaExtractor) hVar.element, false, 4, null);
        }
    }

    public final byte[] Y(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i10 = this.M;
        int i11 = this.N;
        int i12 = i10 * i11;
        System.arraycopy(bArr, 0, bArr2, 0, i10 * i11);
        int i13 = i12;
        int i14 = i13;
        while (i13 < (i12 * 3) / 2) {
            bArr2[i14] = bArr[i13];
            bArr2[(i12 / 4) + i14] = bArr[i13 + 1];
            i13 += 2;
            i14++;
        }
        return bArr2;
    }

    public final void Z(byte[] bArr, int i10, int i11, int i12, byte[] bArr2, int i13, int i14) {
        if (i12 <= 0) {
            return;
        }
        int i15 = 0;
        while (true) {
            int i16 = i15 + 1;
            if (i15 < i14) {
                System.arraycopy(bArr, (i15 * i11) + i10, bArr2, i15 * i13, i13);
            }
            if (i16 >= i12) {
                return;
            } else {
                i15 = i16;
            }
        }
    }

    public final void a0(MediaCodec mediaCodec, int i10) {
        ByteBuffer byteBuffer = mediaCodec.getOutputBuffers()[i10];
        if (byteBuffer == null) {
            return;
        }
        byteBuffer.position(0);
        byteBuffer.limit(N().offset + N().size);
        int iRemaining = byteBuffer.remaining();
        byte[] bArrY = new byte[iRemaining];
        byteBuffer.get(bArrY);
        if (iRemaining == 0) {
            return;
        }
        int i11 = this.K;
        int i12 = this.L;
        byte[] bArr = new byte[i11 * i12];
        byte[] bArr2 = new byte[(i11 * i12) / 4];
        byte[] bArr3 = new byte[(i11 * i12) / 4];
        MediaFormat mediaFormat = this.P;
        if (mediaFormat != null && mediaFormat.getInteger("color-format") == 21) {
            bArrY = Y(bArrY);
        }
        Z(bArrY, 0, this.M, this.N, bArr, this.K, this.L);
        int i13 = this.M;
        int i14 = this.N;
        Z(bArrY, i13 * i14, i13 / 2, i14 / 2, bArr2, this.K / 2, this.L / 2);
        int i15 = this.M;
        int i16 = this.N;
        Z(bArrY, ((i15 * i16) * 5) / 4, i15 / 2, i16 / 2, bArr3, this.K / 2, this.L / 2);
        z zVar = this.f5805b;
        if (zVar != null) {
            zVar.d(this.K, this.L, bArr, bArr2, bArr3);
        }
        R();
    }

    @Override // f2.p
    public void g() {
        if (!this.f5813p) {
            K();
        } else {
            this.J = true;
            this.f5814v = true;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(@os.m SurfaceTexture surfaceTexture) {
        if (this.f5814v) {
            return;
        }
        l2.a.f9640a.a(S, "onFrameAvailable");
        R();
    }
}
