package androidx.camera.video;

import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.config.MimeInfo;
import androidx.camera.video.internal.config.VideoEncoderConfigCamcorderProfileResolver;
import androidx.camera.video.internal.config.VideoEncoderConfigDefaultResolver;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class VideoEncoderSession {
    private static final String TAG = "VideoEncoderSession";
    private final Executor mExecutor;
    private final Executor mSequentialExecutor;
    private final EncoderFactory mVideoEncoderFactory;
    private Encoder mVideoEncoder = null;
    private Surface mActiveSurface = null;
    private SurfaceRequest mSurfaceRequest = null;
    private Executor mOnSurfaceUpdateExecutor = null;
    private Encoder.SurfaceInput.OnSurfaceUpdateListener mOnSurfaceUpdateListener = null;
    private VideoEncoderState mVideoEncoderState = VideoEncoderState.NOT_INITIALIZED;
    private m4.l mReleasedFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Void> mReleasedCompleter = null;
    private m4.l mReadyToReleaseFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Encoder> mReadyToReleaseCompleter = null;

    /* JADX INFO: renamed from: androidx.camera.video.VideoEncoderSession$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState;

        static {
            int[] iArr = new int[VideoEncoderState.values().length];
            $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState = iArr;
            try {
                iArr[VideoEncoderState.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.PENDING_RELEASE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[VideoEncoderState.RELEASED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum VideoEncoderState {
        NOT_INITIALIZED,
        INITIALIZING,
        PENDING_RELEASE,
        READY,
        RELEASED
    }

    public VideoEncoderSession(@NonNull EncoderFactory encoderFactory, @NonNull Executor executor, @NonNull Executor executor2) {
        this.mExecutor = executor2;
        this.mSequentialExecutor = executor;
        this.mVideoEncoderFactory = encoderFactory;
    }

    private void closeInternal() {
        int i8 = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i8 == 1 || i8 == 2) {
            terminateNow();
            return;
        }
        if (i8 == 3 || i8 == 4) {
            Logger.d(TAG, "closeInternal in " + this.mVideoEncoderState + " state");
            this.mVideoEncoderState = VideoEncoderState.PENDING_RELEASE;
            return;
        }
        if (i8 == 5) {
            Logger.d(TAG, "closeInternal in RELEASED state, No-op");
            return;
        }
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    }

    private void configureVideoEncoderInternal(@NonNull final SurfaceRequest surfaceRequest, @NonNull Timebase timebase, @Nullable CamcorderProfileProxy camcorderProfileProxy, @NonNull MediaSpec mediaSpec, @NonNull final CallbackToFutureAdapter.Completer<Encoder> completer) {
        try {
            Encoder encoderCreateEncoder = this.mVideoEncoderFactory.createEncoder(this.mExecutor, resolveVideoEncoderConfig(resolveVideoMimeInfo(camcorderProfileProxy, mediaSpec), timebase, mediaSpec.getVideoSpec(), surfaceRequest.getResolution(), surfaceRequest.getExpectedFrameRate()));
            this.mVideoEncoder = encoderCreateEncoder;
            Encoder.EncoderInput input = encoderCreateEncoder.getInput();
            if (input instanceof Encoder.SurfaceInput) {
                ((Encoder.SurfaceInput) input).setOnSurfaceUpdateListener(this.mSequentialExecutor, new Encoder.SurfaceInput.OnSurfaceUpdateListener() { // from class: androidx.camera.video.l
                    @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput.OnSurfaceUpdateListener
                    public final void onSurfaceUpdate(Surface surface) {
                        this.f1045a.lambda$configureVideoEncoderInternal$5(completer, surfaceRequest, surface);
                    }
                });
            } else {
                completer.setException(new AssertionError("The EncoderInput of video isn't a SurfaceInput."));
            }
        } catch (InvalidConfigException e) {
            Logger.e(TAG, "Unable to initialize video encoder.", e);
            completer.setException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mReleasedCompleter = completer;
        return "ReleasedFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$1(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mReadyToReleaseCompleter = completer;
        return "ReadyToReleaseFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$2(SurfaceRequest surfaceRequest, Timebase timebase, CamcorderProfileProxy camcorderProfileProxy, MediaSpec mediaSpec, CallbackToFutureAdapter.Completer completer) throws Exception {
        configureVideoEncoderInternal(surfaceRequest, timebase, camcorderProfileProxy, mediaSpec, completer);
        return "ConfigureVideoEncoderFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureVideoEncoderInternal$4(Surface surface) {
        this.mOnSurfaceUpdateListener.onSurfaceUpdate(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureVideoEncoderInternal$5(CallbackToFutureAdapter.Completer completer, SurfaceRequest surfaceRequest, Surface surface) {
        Executor executor;
        int i8 = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                if (surfaceRequest.isServiced()) {
                    Logger.d(TAG, "Not provide surface, " + Objects.toString(surfaceRequest, "EMPTY") + " is already serviced.");
                    completer.set(null);
                    closeInternal();
                    return;
                }
                this.mActiveSurface = surface;
                Logger.d(TAG, "provide surface: " + surface);
                surfaceRequest.provideSurface(surface, this.mSequentialExecutor, new f(this, 2));
                this.mVideoEncoderState = VideoEncoderState.READY;
                completer.set(this.mVideoEncoder);
                return;
            }
            if (i8 == 3) {
                if (this.mOnSurfaceUpdateListener != null && (executor = this.mOnSurfaceUpdateExecutor) != null) {
                    executor.execute(new i(2, this, surface));
                }
                Logger.w(TAG, "Surface is updated in READY state: " + surface);
                return;
            }
            if (i8 != 4 && i8 != 5) {
                throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
            }
        }
        Logger.d(TAG, "Not provide surface in " + this.mVideoEncoderState);
        completer.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$terminateNow$3() {
        this.mReleasedCompleter.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceRequestComplete(@NonNull SurfaceRequest.Result result) {
        Logger.d(TAG, "Surface can be closed: " + result.getSurface().hashCode());
        Surface surface = result.getSurface();
        if (surface != this.mActiveSurface) {
            surface.release();
            return;
        }
        this.mActiveSurface = null;
        this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
        closeInternal();
    }

    @NonNull
    private static VideoEncoderConfig resolveVideoEncoderConfig(@NonNull MimeInfo mimeInfo, @NonNull Timebase timebase, @NonNull VideoSpec videoSpec, @NonNull Size size, @Nullable Range<Integer> range) {
        return (VideoEncoderConfig) (mimeInfo.getCompatibleCamcorderProfile() != null ? new VideoEncoderConfigCamcorderProfileResolver(mimeInfo.getMimeType(), timebase, videoSpec, size, mimeInfo.getCompatibleCamcorderProfile(), range) : new VideoEncoderConfigDefaultResolver(mimeInfo.getMimeType(), timebase, videoSpec, size, range)).get();
    }

    private MimeInfo resolveVideoMimeInfo(@Nullable CamcorderProfileProxy camcorderProfileProxy, @NonNull MediaSpec mediaSpec) {
        String strOutputFormatToVideoMime = MediaSpec.outputFormatToVideoMime(mediaSpec.getOutputFormat());
        boolean z2 = false;
        if (camcorderProfileProxy != null) {
            String videoCodecMimeType = camcorderProfileProxy.getVideoCodecMimeType();
            if (videoCodecMimeType == null) {
                Logger.d(TAG, "CamcorderProfile contains undefined VIDEO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + strOutputFormatToVideoMime + "]");
            } else {
                if (mediaSpec.getOutputFormat() == -1) {
                    Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + videoCodecMimeType + "]");
                } else if (Objects.equals(strOutputFormatToVideoMime, videoCodecMimeType)) {
                    Logger.d(TAG, "MediaSpec video mime matches CamcorderProfile. Using CamcorderProfile to derive VIDEO settings [mime type: " + videoCodecMimeType + "]");
                } else {
                    Logger.d(TAG, h0.a.l("MediaSpec video mime does not match CamcorderProfile, so CamcorderProfile settings cannot be used. May rely on fallback defaults to derive VIDEO settings [CamcorderProfile mime type: ", videoCodecMimeType, ", chosen mime type: ", strOutputFormatToVideoMime, "]"));
                }
                strOutputFormatToVideoMime = videoCodecMimeType;
                z2 = true;
            }
        } else {
            Logger.d(TAG, "No CamcorderProfile present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + strOutputFormatToVideoMime + "]");
        }
        MimeInfo.Builder builder = MimeInfo.builder(strOutputFormatToVideoMime);
        if (z2) {
            builder.setCompatibleCamcorderProfile(camcorderProfileProxy);
        }
        return builder.build();
    }

    @NonNull
    public m4.l configure(@NonNull final SurfaceRequest surfaceRequest, @NonNull final Timebase timebase, @NonNull final MediaSpec mediaSpec, @Nullable final CamcorderProfileProxy camcorderProfileProxy) {
        if (AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()] != 1) {
            return Futures.immediateFailedFuture(new IllegalStateException("configure() shouldn't be called in " + this.mVideoEncoderState));
        }
        this.mVideoEncoderState = VideoEncoderState.INITIALIZING;
        this.mSurfaceRequest = surfaceRequest;
        Logger.d(TAG, "Create VideoEncoderSession: " + this);
        final int i8 = 0;
        this.mReleasedFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: androidx.camera.video.j

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VideoEncoderSession f1040b;

            {
                this.f1040b = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                int i9 = i8;
                VideoEncoderSession videoEncoderSession = this.f1040b;
                switch (i9) {
                    case 0:
                        return videoEncoderSession.lambda$configure$0(completer);
                    default:
                        return videoEncoderSession.lambda$configure$1(completer);
                }
            }
        });
        final int i9 = 1;
        this.mReadyToReleaseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: androidx.camera.video.j

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ VideoEncoderSession f1040b;

            {
                this.f1040b = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                int i10 = i9;
                VideoEncoderSession videoEncoderSession = this.f1040b;
                switch (i10) {
                    case 0:
                        return videoEncoderSession.lambda$configure$0(completer);
                    default:
                        return videoEncoderSession.lambda$configure$1(completer);
                }
            }
        });
        m4.l future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.video.k
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f1041a.lambda$configure$2(surfaceRequest, timebase, camcorderProfileProxy, mediaSpec, completer);
            }
        });
        Futures.addCallback(future, new FutureCallback<Encoder>() { // from class: androidx.camera.video.VideoEncoderSession.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th2) {
                Logger.w(VideoEncoderSession.TAG, "VideoEncoder configuration failed.", th2);
                VideoEncoderSession.this.terminateNow();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Encoder encoder) {
            }
        }, this.mSequentialExecutor);
        return Futures.nonCancellationPropagating(future);
    }

    @Nullable
    public Surface getActiveSurface() {
        if (this.mVideoEncoderState != VideoEncoderState.READY) {
            return null;
        }
        return this.mActiveSurface;
    }

    @NonNull
    public m4.l getReadyToReleaseFuture() {
        return Futures.nonCancellationPropagating(this.mReadyToReleaseFuture);
    }

    @Nullable
    public Encoder getVideoEncoder() {
        return this.mVideoEncoder;
    }

    public boolean isConfiguredSurfaceRequest(@NonNull SurfaceRequest surfaceRequest) {
        int i8 = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i8 == 1) {
            return false;
        }
        if (i8 == 2 || i8 == 3) {
            return this.mSurfaceRequest == surfaceRequest;
        }
        if (i8 == 4 || i8 == 5) {
            return false;
        }
        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
    }

    public void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
        this.mOnSurfaceUpdateExecutor = executor;
        this.mOnSurfaceUpdateListener = onSurfaceUpdateListener;
    }

    @NonNull
    public m4.l signalTermination() {
        closeInternal();
        return Futures.nonCancellationPropagating(this.mReleasedFuture);
    }

    public void terminateNow() {
        int i8 = AnonymousClass2.$SwitchMap$androidx$camera$video$VideoEncoderSession$VideoEncoderState[this.mVideoEncoderState.ordinal()];
        if (i8 == 1) {
            this.mVideoEncoderState = VideoEncoderState.RELEASED;
            return;
        }
        if (i8 != 2 && i8 != 3 && i8 != 4) {
            if (i8 != 5) {
                throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
            }
            Logger.d(TAG, "terminateNow in " + this.mVideoEncoderState + ", No-op");
            return;
        }
        this.mVideoEncoderState = VideoEncoderState.RELEASED;
        this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
        this.mSurfaceRequest = null;
        if (this.mVideoEncoder == null) {
            Logger.w(TAG, "There's no VideoEncoder to release! Finish release completer.");
            this.mReleasedCompleter.set(null);
            return;
        }
        Logger.d(TAG, "VideoEncoder is releasing: " + this.mVideoEncoder);
        this.mVideoEncoder.release();
        this.mVideoEncoder.getReleasedFuture().addListener(new Runnable() { // from class: androidx.camera.video.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f1048a.lambda$terminateNow$3();
            }
        }, this.mSequentialExecutor);
        this.mVideoEncoder = null;
    }

    @NonNull
    public String toString() {
        return "VideoEncoderSession@" + hashCode() + " for " + Objects.toString(this.mSurfaceRequest, "SURFACE_REQUEST_NOT_CONFIGURED");
    }
}
