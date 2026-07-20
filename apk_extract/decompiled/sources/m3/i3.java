package m3;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i3 implements q4.d {
    public static final q4.c A;
    public static final q4.c A0;
    public static final q4.c B;
    public static final q4.c B0;
    public static final q4.c C;
    public static final q4.c C0;
    public static final q4.c D;
    public static final q4.c D0;
    public static final q4.c E;
    public static final q4.c E0;
    public static final q4.c F;
    public static final q4.c F0;
    public static final q4.c G;
    public static final q4.c G0;
    public static final q4.c H;
    public static final q4.c H0;
    public static final q4.c I;
    public static final q4.c I0;
    public static final q4.c J;
    public static final q4.c J0;
    public static final q4.c K;
    public static final q4.c K0;
    public static final q4.c L;
    public static final q4.c L0;
    public static final q4.c M;
    public static final q4.c M0;
    public static final q4.c N;
    public static final q4.c O;
    public static final q4.c P;
    public static final q4.c Q;
    public static final q4.c R;
    public static final q4.c S;
    public static final q4.c T;
    public static final q4.c U;
    public static final q4.c V;
    public static final q4.c W;
    public static final q4.c X;
    public static final q4.c Y;
    public static final q4.c Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final q4.c f7712a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final q4.c f7714b0;
    public static final q4.c c0;
    public static final q4.c d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final q4.c f7717e0;
    public static final q4.c f0;
    public static final q4.c g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final q4.c f7720h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final q4.c f7722i0;
    public static final q4.c j0;
    public static final q4.c k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final q4.c f7726l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final q4.c f7728m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final q4.c f7730n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final q4.c f7732o0;
    public static final q4.c p;
    public static final q4.c p0;
    public static final q4.c q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final q4.c f7733q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final q4.c f7734r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final q4.c f7735r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final q4.c f7736s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final q4.c f7737s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final q4.c f7738t;
    public static final q4.c t0;
    public static final q4.c u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final q4.c f7739u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final q4.c f7740v;
    public static final q4.c v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final q4.c f7741w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final q4.c f7742w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final q4.c f7743x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final q4.c f7744x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final q4.c f7745y;
    public static final q4.c y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final q4.c f7746z;
    public static final q4.c z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i3 f7711a = new i3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q4.c f7713b = new q4.c("systemInfo", h0.a.s(h0.a.r(f.class, new c(1, e.DEFAULT))));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q4.c f7715c = new q4.c("eventName", h0.a.s(h0.a.r(f.class, new c(2, e.DEFAULT))));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q4.c f7716d = new q4.c("isThickClient", h0.a.s(h0.a.r(f.class, new c(37, e.DEFAULT))));
    public static final q4.c e = new q4.c("clientType", h0.a.s(h0.a.r(f.class, new c(61, e.DEFAULT))));
    public static final q4.c f = new q4.c("modelDownloadLogEvent", h0.a.s(h0.a.r(f.class, new c(3, e.DEFAULT))));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q4.c f7718g = new q4.c("customModelLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(20, e.DEFAULT))));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q4.c f7719h = new q4.c("customModelInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(4, e.DEFAULT))));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final q4.c f7721i = new q4.c("customModelCreateLogEvent", h0.a.s(h0.a.r(f.class, new c(29, e.DEFAULT))));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final q4.c f7723j = new q4.c("onDeviceFaceDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(5, e.DEFAULT))));

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final q4.c f7724k = new q4.c("onDeviceFaceLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(59, e.DEFAULT))));

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final q4.c f7725l = new q4.c("onDeviceTextDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(6, e.DEFAULT))));

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final q4.c f7727m = new q4.c("onDeviceTextDetectionLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(79, e.DEFAULT))));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final q4.c f7729n = new q4.c("onDeviceBarcodeDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(7, e.DEFAULT))));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final q4.c f7731o = new q4.c("onDeviceBarcodeLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(58, e.DEFAULT))));

    static {
        c cVar = new c(48, e.DEFAULT);
        HashMap map = new HashMap();
        map.put(f.class, cVar);
        p = new q4.c("onDeviceImageLabelCreateLogEvent", h0.a.s(map));
        q = new q4.c("onDeviceImageLabelLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(49, e.DEFAULT))));
        f7734r = new q4.c("onDeviceImageLabelDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(18, e.DEFAULT))));
        f7736s = new q4.c("onDeviceObjectCreateLogEvent", h0.a.s(h0.a.r(f.class, new c(26, e.DEFAULT))));
        f7738t = new q4.c("onDeviceObjectLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(27, e.DEFAULT))));
        u = new q4.c("onDeviceObjectInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(28, e.DEFAULT))));
        f7740v = new q4.c("onDevicePoseDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(44, e.DEFAULT))));
        f7741w = new q4.c("onDeviceSegmentationLogEvent", Collections.unmodifiableMap(new HashMap(h0.a.r(f.class, new c(45, e.DEFAULT)))));
        f7743x = new q4.c("onDeviceSmartReplyLogEvent", h0.a.s(h0.a.r(f.class, new c(19, e.DEFAULT))));
        f7745y = new q4.c("onDeviceLanguageIdentificationLogEvent", h0.a.s(h0.a.r(f.class, new c(21, e.DEFAULT))));
        f7746z = new q4.c("onDeviceTranslationLogEvent", h0.a.s(h0.a.r(f.class, new c(22, e.DEFAULT))));
        A = new q4.c("cloudFaceDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(8, e.DEFAULT))));
        B = new q4.c("cloudCropHintDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(9, e.DEFAULT))));
        C = new q4.c("cloudDocumentTextDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(10, e.DEFAULT))));
        D = new q4.c("cloudImagePropertiesDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(11, e.DEFAULT))));
        E = new q4.c("cloudImageLabelDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(12, e.DEFAULT))));
        F = new q4.c("cloudLandmarkDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(13, e.DEFAULT))));
        G = new q4.c("cloudLogoDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(14, e.DEFAULT))));
        H = new q4.c("cloudSafeSearchDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(15, e.DEFAULT))));
        I = new q4.c("cloudTextDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(16, e.DEFAULT))));
        J = new q4.c("cloudWebSearchDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(17, e.DEFAULT))));
        K = new q4.c("automlImageLabelingCreateLogEvent", h0.a.s(h0.a.r(f.class, new c(23, e.DEFAULT))));
        c cVar2 = new c(24, e.DEFAULT);
        HashMap map2 = new HashMap();
        map2.put(f.class, cVar2);
        L = new q4.c("automlImageLabelingLoadLogEvent", h0.a.s(map2));
        M = new q4.c("automlImageLabelingInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(25, e.DEFAULT))));
        N = new q4.c("isModelDownloadedLogEvent", h0.a.s(h0.a.r(f.class, new c(39, e.DEFAULT))));
        O = new q4.c("deleteModelLogEvent", h0.a.s(h0.a.r(f.class, new c(40, e.DEFAULT))));
        P = new q4.c("aggregatedAutomlImageLabelingInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(30, e.DEFAULT))));
        Q = new q4.c("aggregatedCustomModelInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(31, e.DEFAULT))));
        R = new q4.c("aggregatedOnDeviceFaceDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(32, e.DEFAULT))));
        S = new q4.c("aggregatedOnDeviceBarcodeDetectionLogEvent", Collections.unmodifiableMap(new HashMap(h0.a.r(f.class, new c(33, e.DEFAULT)))));
        T = new q4.c("aggregatedOnDeviceImageLabelDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(34, e.DEFAULT))));
        U = new q4.c("aggregatedOnDeviceObjectInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(35, e.DEFAULT))));
        V = new q4.c("aggregatedOnDeviceTextDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(36, e.DEFAULT))));
        W = new q4.c("aggregatedOnDevicePoseDetectionLogEvent", h0.a.s(h0.a.r(f.class, new c(46, e.DEFAULT))));
        X = new q4.c("aggregatedOnDeviceSegmentationLogEvent", h0.a.s(h0.a.r(f.class, new c(47, e.DEFAULT))));
        Y = new q4.c("pipelineAccelerationInferenceEvents", h0.a.s(h0.a.r(f.class, new c(69, e.DEFAULT))));
        Z = new q4.c("remoteConfigLogEvent", h0.a.s(h0.a.r(f.class, new c(42, e.DEFAULT))));
        f7712a0 = new q4.c("inputImageConstructionLogEvent", h0.a.s(h0.a.r(f.class, new c(50, e.DEFAULT))));
        f7714b0 = new q4.c("leakedHandleEvent", h0.a.s(h0.a.r(f.class, new c(51, e.DEFAULT))));
        c0 = new q4.c("cameraSourceLogEvent", h0.a.s(h0.a.r(f.class, new c(52, e.DEFAULT))));
        d0 = new q4.c("imageLabelOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(53, e.DEFAULT))));
        f7717e0 = new q4.c("languageIdentificationOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(54, e.DEFAULT))));
        f0 = new q4.c("faceDetectionOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(60, e.DEFAULT))));
        g0 = new q4.c("documentDetectionOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(85, e.DEFAULT))));
        c cVar3 = new c(86, e.DEFAULT);
        HashMap map3 = new HashMap();
        map3.put(f.class, cVar3);
        f7720h0 = new q4.c("documentCroppingOptionalModuleLogEvent", h0.a.s(map3));
        f7722i0 = new q4.c("documentEnhancementOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(87, e.DEFAULT))));
        j0 = new q4.c("nlClassifierOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(55, e.DEFAULT))));
        k0 = new q4.c("nlClassifierClientLibraryLogEvent", h0.a.s(h0.a.r(f.class, new c(56, e.DEFAULT))));
        f7726l0 = new q4.c("accelerationAllowlistLogEvent", h0.a.s(h0.a.r(f.class, new c(57, e.DEFAULT))));
        f7728m0 = new q4.c("toxicityDetectionCreateEvent", h0.a.s(h0.a.r(f.class, new c(62, e.DEFAULT))));
        f7730n0 = new q4.c("toxicityDetectionLoadEvent", h0.a.s(h0.a.r(f.class, new c(63, e.DEFAULT))));
        f7732o0 = new q4.c("toxicityDetectionInferenceEvent", Collections.unmodifiableMap(new HashMap(h0.a.r(f.class, new c(64, e.DEFAULT)))));
        p0 = new q4.c("barcodeDetectionOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(65, e.DEFAULT))));
        f7733q0 = new q4.c("customImageLabelOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(66, e.DEFAULT))));
        f7735r0 = new q4.c("codeScannerScanApiEvent", h0.a.s(h0.a.r(f.class, new c(67, e.DEFAULT))));
        f7737s0 = new q4.c("codeScannerOptionalModuleEvent", h0.a.s(h0.a.r(f.class, new c(68, e.DEFAULT))));
        t0 = new q4.c("onDeviceExplicitContentCreateLogEvent", h0.a.s(h0.a.r(f.class, new c(70, e.DEFAULT))));
        f7739u0 = new q4.c("onDeviceExplicitContentLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(71, e.DEFAULT))));
        v0 = new q4.c("onDeviceExplicitContentInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(72, e.DEFAULT))));
        f7742w0 = new q4.c("aggregatedOnDeviceExplicitContentLogEvent", h0.a.s(h0.a.r(f.class, new c(73, e.DEFAULT))));
        f7744x0 = new q4.c("onDeviceFaceMeshCreateLogEvent", h0.a.s(h0.a.r(f.class, new c(74, e.DEFAULT))));
        y0 = new q4.c("onDeviceFaceMeshLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(75, e.DEFAULT))));
        z0 = new q4.c("onDeviceFaceMeshLogEvent", h0.a.s(h0.a.r(f.class, new c(76, e.DEFAULT))));
        A0 = new q4.c("aggregatedOnDeviceFaceMeshLogEvent", h0.a.s(h0.a.r(f.class, new c(77, e.DEFAULT))));
        B0 = new q4.c("smartReplyOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(78, e.DEFAULT))));
        C0 = new q4.c("textDetectionOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(80, e.DEFAULT))));
        c cVar4 = new c(81, e.DEFAULT);
        HashMap map4 = new HashMap();
        map4.put(f.class, cVar4);
        D0 = new q4.c("onDeviceImageQualityAnalysisCreateLogEvent", h0.a.s(map4));
        E0 = new q4.c("onDeviceImageQualityAnalysisLoadLogEvent", h0.a.s(h0.a.r(f.class, new c(82, e.DEFAULT))));
        F0 = new q4.c("onDeviceImageQualityAnalysisLogEvent", h0.a.s(h0.a.r(f.class, new c(83, e.DEFAULT))));
        G0 = new q4.c("aggregatedOnDeviceImageQualityAnalysisLogEvent", h0.a.s(h0.a.r(f.class, new c(84, e.DEFAULT))));
        H0 = new q4.c("imageQualityAnalysisOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(88, e.DEFAULT))));
        I0 = new q4.c("imageCaptioningOptionalModuleLogEvent", h0.a.s(h0.a.r(f.class, new c(89, e.DEFAULT))));
        J0 = new q4.c("onDeviceImageCaptioningCreateLogEvent", h0.a.s(h0.a.r(f.class, new c(90, e.DEFAULT))));
        K0 = new q4.c("onDeviceImageCaptioningLoadLogEvent", Collections.unmodifiableMap(new HashMap(h0.a.r(f.class, new c(91, e.DEFAULT)))));
        L0 = new q4.c("onDeviceImageCaptioningInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(92, e.DEFAULT))));
        M0 = new q4.c("aggregatedOnDeviceImageCaptioningInferenceLogEvent", h0.a.s(h0.a.r(f.class, new c(93, e.DEFAULT))));
    }

    @Override // q4.a
    public final void a(Object obj, Object obj2) {
        n7 n7Var = (n7) obj;
        q4.e eVar = (q4.e) obj2;
        eVar.a(f7713b, n7Var.f7787a);
        eVar.a(f7715c, n7Var.f7788b);
        eVar.a(f7716d, null);
        eVar.a(e, null);
        eVar.a(f, null);
        eVar.a(f7718g, null);
        eVar.a(f7719h, null);
        eVar.a(f7721i, null);
        eVar.a(f7723j, null);
        eVar.a(f7724k, null);
        eVar.a(f7725l, null);
        eVar.a(f7727m, null);
        eVar.a(f7729n, null);
        eVar.a(f7731o, null);
        eVar.a(p, null);
        eVar.a(q, null);
        eVar.a(f7734r, null);
        eVar.a(f7736s, null);
        eVar.a(f7738t, null);
        eVar.a(u, null);
        eVar.a(f7740v, null);
        eVar.a(f7741w, null);
        eVar.a(f7743x, null);
        eVar.a(f7745y, null);
        eVar.a(f7746z, null);
        eVar.a(A, null);
        eVar.a(B, null);
        eVar.a(C, null);
        eVar.a(D, null);
        eVar.a(E, null);
        eVar.a(F, null);
        eVar.a(G, null);
        eVar.a(H, null);
        eVar.a(I, null);
        eVar.a(J, null);
        eVar.a(K, null);
        eVar.a(L, null);
        eVar.a(M, null);
        eVar.a(N, null);
        eVar.a(O, null);
        eVar.a(P, null);
        eVar.a(Q, null);
        eVar.a(R, null);
        eVar.a(S, null);
        eVar.a(T, null);
        eVar.a(U, null);
        eVar.a(V, null);
        eVar.a(W, null);
        eVar.a(X, null);
        eVar.a(Y, null);
        eVar.a(Z, null);
        eVar.a(f7712a0, n7Var.f7789c);
        eVar.a(f7714b0, null);
        eVar.a(c0, null);
        eVar.a(d0, null);
        eVar.a(f7717e0, null);
        eVar.a(f0, null);
        eVar.a(g0, null);
        eVar.a(f7720h0, null);
        eVar.a(f7722i0, null);
        eVar.a(j0, null);
        eVar.a(k0, null);
        eVar.a(f7726l0, null);
        eVar.a(f7728m0, null);
        eVar.a(f7730n0, null);
        eVar.a(f7732o0, null);
        eVar.a(p0, null);
        eVar.a(f7733q0, null);
        eVar.a(f7735r0, null);
        eVar.a(f7737s0, null);
        eVar.a(t0, null);
        eVar.a(f7739u0, null);
        eVar.a(v0, null);
        eVar.a(f7742w0, null);
        eVar.a(f7744x0, null);
        eVar.a(y0, null);
        eVar.a(z0, null);
        eVar.a(A0, null);
        eVar.a(B0, null);
        eVar.a(C0, null);
        eVar.a(D0, null);
        eVar.a(E0, null);
        eVar.a(F0, null);
        eVar.a(G0, null);
        eVar.a(H0, null);
        eVar.a(I0, null);
        eVar.a(J0, null);
        eVar.a(K0, null);
        eVar.a(L0, null);
        eVar.a(M0, null);
    }
}
