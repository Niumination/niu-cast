package androidx.camera.video;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.MediaMuxer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.core.impl.MutableStateObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.StateObservable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.utils.ArrayRingBuffer;
import androidx.camera.core.internal.utils.RingBuffer;
import androidx.camera.video.Recorder;
import androidx.camera.video.internal.AudioSource;
import androidx.camera.video.internal.AudioSourceAccessException;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.Api26Impl;
import androidx.camera.video.internal.compat.quirk.DeactivateEncoderSurfaceBeforeStopEncoderQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.config.AudioConfigUtil;
import androidx.camera.video.internal.config.MimeInfo;
import androidx.camera.video.internal.encoder.BufferCopiedEncodedData;
import androidx.camera.video.internal.encoder.EncodeException;
import androidx.camera.video.internal.encoder.EncodedData;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderCallback;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.OutputConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.utils.OutputUtil;
import androidx.camera.video.internal.workaround.CorrectNegativeLatLongForMediaMuxer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class Recorder implements VideoOutput {
    private static final int AUDIO_CACHE_SIZE = 60;
    private static final Executor AUDIO_EXECUTOR;

    @VisibleForTesting
    static final EncoderFactory DEFAULT_ENCODER_FACTORY;
    public static final QualitySelector DEFAULT_QUALITY_SELECTOR;
    private static final String MEDIA_COLUMN = "_data";
    private static final MediaSpec MEDIA_SPEC_DEFAULT;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final Exception PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
    private static final long SOURCE_NON_STREAMING_TIMEOUT_MS = 1000;
    private static final String TAG = "Recorder";
    private static final VideoSpec VIDEO_SPEC_DEFAULT;

    @GuardedBy("mLock")
    RecordingRecord mActiveRecordingRecord;
    Surface mActiveSurface;
    Encoder mAudioEncoder;
    private final EncoderFactory mAudioEncoderFactory;
    Throwable mAudioErrorCause;
    OutputConfig mAudioOutputConfig;
    AudioSource mAudioSource;
    AudioState mAudioState;
    Integer mAudioTrackIndex;
    long mDurationLimitNs;
    private final boolean mEncoderNotUsePersistentInputSurface;
    final List<m4.l> mEncodingFutures;
    private final Executor mExecutor;
    long mFileSizeLimitInBytes;

    @VisibleForTesting
    long mFirstRecordingAudioDataTimeUs;

    @VisibleForTesting
    int mFirstRecordingVideoBitrate;

    @VisibleForTesting
    long mFirstRecordingVideoDataTimeUs;
    private RecordingRecord mInProgressRecording;
    boolean mInProgressRecordingStopping;
    boolean mIsAudioSourceSilenced;

    @GuardedBy("mLock")
    private long mLastGeneratedRecordingId;
    Surface mLatestSurface;
    SurfaceRequest mLatestSurfaceRequest;
    private final Object mLock = new Object();
    MediaMuxer mMediaMuxer;
    final MutableStateObservable<MediaSpec> mMediaSpec;
    private boolean mNeedsReset;

    @GuardedBy("mLock")
    private State mNonPendingState;

    @NonNull
    Uri mOutputUri;

    @NonNull
    final RingBuffer<EncodedData> mPendingAudioRingBuffer;
    EncodedData mPendingFirstVideoData;

    @GuardedBy("mLock")
    RecordingRecord mPendingRecordingRecord;
    long mPreviousRecordingAudioDataTimeUs;
    long mPreviousRecordingVideoDataTimeUs;
    long mRecordingBytes;
    long mRecordingDurationNs;
    int mRecordingStopError;
    Throwable mRecordingStopErrorCause;
    private CamcorderProfileProxy mResolvedCamcorderProfile;
    final Executor mSequentialExecutor;
    ScheduledFuture<?> mSourceNonStreamingTimeout;
    VideoOutput.SourceState mSourceState;

    @GuardedBy("mLock")
    private State mState;

    @GuardedBy("mLock")
    int mStreamId;
    private final MutableStateObservable<StreamInfo> mStreamInfo;
    private SurfaceRequest.TransformationInfo mSurfaceTransformationInfo;
    private final Executor mUserProvidedExecutor;
    Encoder mVideoEncoder;

    @VisibleForTesting
    Range<Integer> mVideoEncoderBitrateRange;
    private final EncoderFactory mVideoEncoderFactory;

    @NonNull
    VideoEncoderSession mVideoEncoderSession;

    @Nullable
    VideoEncoderSession mVideoEncoderSessionToRelease;
    OutputConfig mVideoOutputConfig;
    Timebase mVideoSourceTimebase;
    Integer mVideoTrackIndex;
    private static final Set<State> PENDING_STATES = Collections.unmodifiableSet(EnumSet.of(State.PENDING_RECORDING, State.PENDING_PAUSED));
    private static final Set<State> VALID_NON_PENDING_STATES_WHILE_PENDING = Collections.unmodifiableSet(EnumSet.of(State.CONFIGURING, State.IDLING, State.RESETTING, State.STOPPING, State.ERROR));

    /* JADX INFO: renamed from: androidx.camera.video.Recorder$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$Recorder$AudioState;
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$Recorder$State;

        static {
            int[] iArr = new int[AudioState.values().length];
            $SwitchMap$androidx$camera$video$Recorder$AudioState = iArr;
            try {
                iArr[AudioState.ERROR_ENCODER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$AudioState[AudioState.ERROR_SOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$AudioState[AudioState.ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$AudioState[AudioState.DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$AudioState[AudioState.IDLING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$AudioState[AudioState.INITIALIZING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[State.values().length];
            $SwitchMap$androidx$camera$video$Recorder$State = iArr2;
            try {
                iArr2[State.PAUSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$State[State.RECORDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$State[State.PENDING_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$State[State.PENDING_RECORDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$State[State.RESETTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$State[State.STOPPING.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$State[State.CONFIGURING.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$State[State.ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$androidx$camera$video$Recorder$State[State.IDLING.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public enum AudioState {
        INITIALIZING,
        IDLING,
        DISABLED,
        ACTIVE,
        ERROR_ENCODER,
        ERROR_SOURCE
    }

    @RequiresApi(21)
    public static final class Builder {
        private EncoderFactory mAudioEncoderFactory;
        private Executor mExecutor = null;
        private final MediaSpec.Builder mMediaSpecBuilder;
        private EncoderFactory mVideoEncoderFactory;

        public Builder() {
            EncoderFactory encoderFactory = Recorder.DEFAULT_ENCODER_FACTORY;
            this.mVideoEncoderFactory = encoderFactory;
            this.mAudioEncoderFactory = encoderFactory;
            this.mMediaSpecBuilder = MediaSpec.builder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$setTargetVideoEncodingBitRate$1(int i8, VideoSpec.Builder builder) {
            builder.setBitrate(new Range<>(Integer.valueOf(i8), Integer.valueOf(i8)));
        }

        @NonNull
        public Recorder build() {
            return new Recorder(this.mExecutor, this.mMediaSpecBuilder.build(), this.mVideoEncoderFactory, this.mAudioEncoderFactory);
        }

        @NonNull
        public Builder setAspectRatio(int i8) {
            this.mMediaSpecBuilder.configureVideo(new x.d(i8, 2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setAudioEncoderFactory(@NonNull EncoderFactory encoderFactory) {
            this.mAudioEncoderFactory = encoderFactory;
            return this;
        }

        @NonNull
        public Builder setAudioSource(int i8) {
            this.mMediaSpecBuilder.configureAudio(new x.d(i8, 1));
            return this;
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            Preconditions.checkNotNull(executor, "The specified executor can't be null.");
            this.mExecutor = executor;
            return this;
        }

        @NonNull
        public Builder setQualitySelector(@NonNull QualitySelector qualitySelector) {
            Preconditions.checkNotNull(qualitySelector, "The specified quality selector can't be null.");
            this.mMediaSpecBuilder.configureVideo(new b0.d(qualitySelector, 3));
            return this;
        }

        @NonNull
        public Builder setTargetVideoEncodingBitRate(@IntRange(from = 1) int i8) {
            if (i8 <= 0) {
                throw new IllegalArgumentException(h0.a.h(i8, "The requested target bitrate ", " is not supported. Target bitrate must be greater than 0."));
            }
            this.mMediaSpecBuilder.configureVideo(new x.d(i8, 0));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setVideoEncoderFactory(@NonNull EncoderFactory encoderFactory) {
            this.mVideoEncoderFactory = encoderFactory;
            return this;
        }
    }

    @RequiresApi(21)
    public static abstract class RecordingRecord implements AutoCloseable {
        private final CloseGuardHelper mCloseGuard = CloseGuardHelper.create();
        private final AtomicBoolean mInitialized = new AtomicBoolean(false);
        private final AtomicReference<MediaMuxerSupplier> mMediaMuxerSupplier = new AtomicReference<>(null);
        private final AtomicReference<AudioSourceSupplier> mAudioSourceSupplier = new AtomicReference<>(null);
        private final AtomicReference<Consumer<Uri>> mRecordingFinalizer = new AtomicReference<>(new h());

        /* JADX INFO: renamed from: androidx.camera.video.Recorder$RecordingRecord$2, reason: invalid class name */
        public class AnonymousClass2 implements AudioSourceSupplier {
            public AnonymousClass2() {
            }

            @Override // androidx.camera.video.Recorder.RecordingRecord.AudioSourceSupplier
            @NonNull
            @RequiresPermission("android.permission.RECORD_AUDIO")
            public AudioSource get(@NonNull AudioSource.Settings settings, @NonNull Executor executor) throws AudioSourceAccessException {
                return new AudioSource(settings, executor, null);
            }
        }

        public interface AudioSourceSupplier {
            @NonNull
            @RequiresPermission("android.permission.RECORD_AUDIO")
            AudioSource get(@NonNull AudioSource.Settings settings, @NonNull Executor executor) throws AudioSourceAccessException;
        }

        public interface MediaMuxerSupplier {
            @NonNull
            MediaMuxer get(int i8, @NonNull Consumer<Uri> consumer) throws IOException;
        }

        private void finalizeRecordingInternal(@Nullable Consumer<Uri> consumer, @NonNull Uri uri) {
            if (consumer != null) {
                this.mCloseGuard.close();
                consumer.accept(uri);
            } else {
                throw new AssertionError("Recording " + this + " has already been finalized");
            }
        }

        @NonNull
        public static RecordingRecord from(@NonNull PendingRecording pendingRecording, long j8) {
            return new AutoValue_Recorder_RecordingRecord(pendingRecording.getOutputOptions(), pendingRecording.getListenerExecutor(), pendingRecording.getEventListener(), pendingRecording.isAudioEnabled(), j8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaMuxer lambda$initializeRecording$1(OutputOptions outputOptions, ParcelFileDescriptor parcelFileDescriptor, int i8, Consumer consumer) throws IOException {
            MediaMuxer mediaMuxerCreateMediaMuxer;
            Uri uriInsert = Uri.EMPTY;
            if (outputOptions instanceof FileOutputOptions) {
                File file = ((FileOutputOptions) outputOptions).getFile();
                if (!OutputUtil.createParentFolder(file)) {
                    Logger.w(Recorder.TAG, "Failed to create folder for " + file.getAbsolutePath());
                }
                mediaMuxerCreateMediaMuxer = new MediaMuxer(file.getAbsolutePath(), i8);
                uriInsert = Uri.fromFile(file);
            } else if (outputOptions instanceof FileDescriptorOutputOptions) {
                mediaMuxerCreateMediaMuxer = Api26Impl.createMediaMuxer(parcelFileDescriptor.getFileDescriptor(), i8);
            } else {
                if (!(outputOptions instanceof MediaStoreOutputOptions)) {
                    throw new AssertionError("Invalid output options type: ".concat(outputOptions.getClass().getSimpleName()));
                }
                MediaStoreOutputOptions mediaStoreOutputOptions = (MediaStoreOutputOptions) outputOptions;
                ContentValues contentValues = new ContentValues(mediaStoreOutputOptions.getContentValues());
                contentValues.put("is_pending", (Integer) 1);
                uriInsert = mediaStoreOutputOptions.getContentResolver().insert(mediaStoreOutputOptions.getCollectionUri(), contentValues);
                if (uriInsert == null) {
                    throw new IOException("Unable to create MediaStore entry.");
                }
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = mediaStoreOutputOptions.getContentResolver().openFileDescriptor(uriInsert, "rw");
                mediaMuxerCreateMediaMuxer = Api26Impl.createMediaMuxer(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), i8);
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            consumer.accept(uriInsert);
            return mediaMuxerCreateMediaMuxer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$initializeRecording$2(MediaStoreOutputOptions mediaStoreOutputOptions, Uri uri) {
            if (uri.equals(Uri.EMPTY)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", (Integer) 0);
            mediaStoreOutputOptions.getContentResolver().update(uri, contentValues, null, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$initializeRecording$3(String str, Uri uri) {
            if (uri != null) {
                Logger.d(Recorder.TAG, String.format("File scan completed successfully [path: %s, URI: %s]", str, uri));
                return;
            }
            Logger.e(Recorder.TAG, "File scanning operation failed [path: " + str + "]");
        }

        private static /* synthetic */ void lambda$initializeRecording$4(MediaStoreOutputOptions mediaStoreOutputOptions, Context context, Uri uri) {
            if (uri.equals(Uri.EMPTY)) {
                return;
            }
            String absolutePathFromUri = OutputUtil.getAbsolutePathFromUri(mediaStoreOutputOptions.getContentResolver(), uri, Recorder.MEDIA_COLUMN);
            if (absolutePathFromUri != null) {
                MediaScannerConnection.scanFile(context, new String[]{absolutePathFromUri}, null, new g());
                return;
            }
            Logger.d(Recorder.TAG, "Skipping media scanner scan. Unable to retrieve file path from URI: " + uri);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$initializeRecording$5(ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                Logger.e(Recorder.TAG, "Failed to close dup'd ParcelFileDescriptor", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$new$0(Uri uri) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateVideoRecordEvent$6(VideoRecordEvent videoRecordEvent) {
            getEventListener().accept(videoRecordEvent);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            finalizeRecording(Uri.EMPTY);
        }

        public void finalize() throws Throwable {
            try {
                this.mCloseGuard.warnIfOpen();
                Consumer<Uri> andSet = this.mRecordingFinalizer.getAndSet(null);
                if (andSet != null) {
                    finalizeRecordingInternal(andSet, Uri.EMPTY);
                }
            } finally {
                super.finalize();
            }
        }

        public void finalizeRecording(@NonNull Uri uri) {
            if (this.mInitialized.get()) {
                finalizeRecordingInternal(this.mRecordingFinalizer.getAndSet(null), uri);
            }
        }

        @Nullable
        public abstract Executor getCallbackExecutor();

        @Nullable
        public abstract Consumer<VideoRecordEvent> getEventListener();

        @NonNull
        public abstract OutputOptions getOutputOptions();

        public abstract long getRecordingId();

        public abstract boolean hasAudioEnabled();

        public void initializeRecording(@NonNull final Context context) throws IOException {
            if (this.mInitialized.getAndSet(true)) {
                throw new AssertionError("Recording " + this + " has already been initialized");
            }
            final OutputOptions outputOptions = getOutputOptions();
            boolean z2 = outputOptions instanceof FileDescriptorOutputOptions;
            f fVar = null;
            final ParcelFileDescriptor parcelFileDescriptorDup = z2 ? ((FileDescriptorOutputOptions) outputOptions).getParcelFileDescriptor().dup() : null;
            this.mCloseGuard.open("finalizeRecording");
            this.mMediaMuxerSupplier.set(new MediaMuxerSupplier() { // from class: androidx.camera.video.e
                @Override // androidx.camera.video.Recorder.RecordingRecord.MediaMuxerSupplier
                public final MediaMuxer get(int i8, Consumer consumer) {
                    return Recorder.RecordingRecord.lambda$initializeRecording$1(outputOptions, parcelFileDescriptorDup, i8, consumer);
                }
            });
            if (hasAudioEnabled()) {
                this.mAudioSourceSupplier.set(new AudioSourceSupplier() { // from class: androidx.camera.video.Recorder.RecordingRecord.1
                    @Override // androidx.camera.video.Recorder.RecordingRecord.AudioSourceSupplier
                    @NonNull
                    @RequiresPermission("android.permission.RECORD_AUDIO")
                    public AudioSource get(@NonNull AudioSource.Settings settings, @NonNull Executor executor) throws AudioSourceAccessException {
                        return new AudioSource(settings, executor, context);
                    }
                });
            }
            if (outputOptions instanceof MediaStoreOutputOptions) {
                fVar = new f((MediaStoreOutputOptions) outputOptions, 0);
            } else if (z2) {
                fVar = new f(parcelFileDescriptorDup, 1);
            }
            if (fVar != null) {
                this.mRecordingFinalizer.set(fVar);
            }
        }

        @NonNull
        @RequiresPermission("android.permission.RECORD_AUDIO")
        public AudioSource performOneTimeAudioSourceCreation(@NonNull AudioSource.Settings settings, @NonNull Executor executor) throws AudioSourceAccessException {
            if (!hasAudioEnabled()) {
                throw new AssertionError("Recording does not have audio enabled. Unable to create audio source for recording " + this);
            }
            AudioSourceSupplier andSet = this.mAudioSourceSupplier.getAndSet(null);
            if (andSet != null) {
                return andSet.get(settings, executor);
            }
            throw new AssertionError("One-time audio source creation has already occurred for recording " + this);
        }

        @NonNull
        public MediaMuxer performOneTimeMediaMuxerCreation(int i8, @NonNull Consumer<Uri> consumer) throws IOException {
            if (!this.mInitialized.get()) {
                throw new AssertionError("Recording " + this + " has not been initialized");
            }
            MediaMuxerSupplier andSet = this.mMediaMuxerSupplier.getAndSet(null);
            if (andSet != null) {
                return andSet.get(i8, consumer);
            }
            throw new AssertionError("One-time media muxer creation has already occurred for recording " + this);
        }

        public void updateVideoRecordEvent(@NonNull VideoRecordEvent videoRecordEvent) {
            if (!Objects.equals(videoRecordEvent.getOutputOptions(), getOutputOptions())) {
                throw new AssertionError("Attempted to update event listener with event from incorrect recording [Recording: " + videoRecordEvent.getOutputOptions() + ", Expected: " + getOutputOptions() + "]");
            }
            String strConcat = "Sending VideoRecordEvent ".concat(videoRecordEvent.getClass().getSimpleName());
            if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
                VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) videoRecordEvent;
                if (finalize.hasError()) {
                    StringBuilder sbS = o.d.s(strConcat);
                    sbS.append(" [error: " + VideoRecordEvent.Finalize.errorToString(finalize.getError()) + "]");
                    strConcat = sbS.toString();
                }
            }
            Logger.d(Recorder.TAG, strConcat);
            if (getCallbackExecutor() == null || getEventListener() == null) {
                return;
            }
            try {
                getCallbackExecutor().execute(new i(0, this, videoRecordEvent));
            } catch (RejectedExecutionException e) {
                Logger.e(Recorder.TAG, "The callback executor is invalid.", e);
            }
        }
    }

    public enum State {
        CONFIGURING,
        PENDING_RECORDING,
        PENDING_PAUSED,
        IDLING,
        RECORDING,
        PAUSED,
        STOPPING,
        RESETTING,
        ERROR
    }

    static {
        Quality quality = Quality.FHD;
        QualitySelector qualitySelectorFromOrderedList = QualitySelector.fromOrderedList(Arrays.asList(quality, Quality.HD, Quality.SD), FallbackStrategy.higherQualityOrLowerThan(quality));
        DEFAULT_QUALITY_SELECTOR = qualitySelectorFromOrderedList;
        VideoSpec videoSpecBuild = VideoSpec.builder().setQualitySelector(qualitySelectorFromOrderedList).setAspectRatio(-1).build();
        VIDEO_SPEC_DEFAULT = videoSpecBuild;
        MEDIA_SPEC_DEFAULT = MediaSpec.builder().setOutputFormat(-1).setVideoSpec(videoSpecBuild).build();
        PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE = new RuntimeException("The video frame producer became inactive before any data was received.");
        DEFAULT_ENCODER_FACTORY = new e0.b(11);
        AUDIO_EXECUTOR = CameraXExecutors.newSequentialExecutor(CameraXExecutors.ioExecutor());
    }

    public Recorder(@Nullable Executor executor, @NonNull MediaSpec mediaSpec, @NonNull EncoderFactory encoderFactory, @NonNull EncoderFactory encoderFactory2) {
        this.mEncoderNotUsePersistentInputSurface = DeviceQuirks.get(EncoderNotUsePersistentInputSurfaceQuirk.class) != null;
        this.mState = State.CONFIGURING;
        this.mNonPendingState = null;
        this.mStreamId = 0;
        this.mActiveRecordingRecord = null;
        this.mPendingRecordingRecord = null;
        this.mLastGeneratedRecordingId = 0L;
        this.mInProgressRecording = null;
        this.mInProgressRecordingStopping = false;
        this.mSurfaceTransformationInfo = null;
        this.mResolvedCamcorderProfile = null;
        this.mEncodingFutures = new ArrayList();
        this.mAudioTrackIndex = null;
        this.mVideoTrackIndex = null;
        this.mLatestSurface = null;
        this.mActiveSurface = null;
        this.mMediaMuxer = null;
        this.mAudioSource = null;
        this.mVideoEncoder = null;
        this.mVideoOutputConfig = null;
        this.mAudioEncoder = null;
        this.mAudioOutputConfig = null;
        this.mAudioState = AudioState.INITIALIZING;
        this.mOutputUri = Uri.EMPTY;
        this.mRecordingBytes = 0L;
        this.mRecordingDurationNs = 0L;
        this.mFirstRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mFirstRecordingVideoBitrate = 0;
        this.mVideoEncoderBitrateRange = null;
        this.mFirstRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mFileSizeLimitInBytes = 0L;
        this.mDurationLimitNs = 0L;
        this.mRecordingStopError = 1;
        this.mRecordingStopErrorCause = null;
        this.mPendingFirstVideoData = null;
        this.mPendingAudioRingBuffer = new ArrayRingBuffer(AUDIO_CACHE_SIZE);
        this.mAudioErrorCause = null;
        this.mIsAudioSourceSilenced = false;
        this.mSourceState = VideoOutput.SourceState.INACTIVE;
        this.mSourceNonStreamingTimeout = null;
        this.mNeedsReset = false;
        this.mVideoEncoderSessionToRelease = null;
        this.mUserProvidedExecutor = executor;
        executor = executor == null ? CameraXExecutors.ioExecutor() : executor;
        this.mExecutor = executor;
        Executor executorNewSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mSequentialExecutor = executorNewSequentialExecutor;
        this.mMediaSpec = MutableStateObservable.withInitialState(composeRecorderMediaSpec(mediaSpec));
        this.mStreamInfo = MutableStateObservable.withInitialState(StreamInfo.of(this.mStreamId, internalStateToStreamState(this.mState)));
        this.mVideoEncoderFactory = encoderFactory;
        this.mAudioEncoderFactory = encoderFactory2;
        this.mVideoEncoderSession = new VideoEncoderSession(encoderFactory, executorNewSequentialExecutor, executor);
    }

    private void clearPendingAudioRingBuffer() {
        while (!this.mPendingAudioRingBuffer.isEmpty()) {
            this.mPendingAudioRingBuffer.dequeue();
        }
    }

    @NonNull
    private MediaSpec composeRecorderMediaSpec(@NonNull MediaSpec mediaSpec) {
        MediaSpec.Builder builder = mediaSpec.toBuilder();
        if (mediaSpec.getVideoSpec().getAspectRatio() == -1) {
            builder.configureVideo(new i0.a(2));
        }
        return builder.build();
    }

    private void configureInternal(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        if (surfaceRequest.isServiced()) {
            Logger.w(TAG, "Ignore the SurfaceRequest since it is already served.");
            return;
        }
        surfaceRequest.setTransformationInfoListener(this.mSequentialExecutor, new a4.b(this, 26));
        Size resolution = surfaceRequest.getResolution();
        VideoCapabilities videoCapabilitiesFrom = VideoCapabilities.from(surfaceRequest.getCamera().getCameraInfo());
        Quality qualityFindHighestSupportedQualityFor = videoCapabilitiesFrom.findHighestSupportedQualityFor(resolution);
        Logger.d(TAG, "Using supported quality of " + qualityFindHighestSupportedQualityFor + " for surface size " + resolution);
        if (qualityFindHighestSupportedQualityFor != Quality.NONE) {
            CamcorderProfileProxy profile = videoCapabilitiesFrom.getProfile(qualityFindHighestSupportedQualityFor);
            this.mResolvedCamcorderProfile = profile;
            if (profile == null) {
                throw new AssertionError("Camera advertised available quality but did not produce CamcorderProfile for advertised quality.");
            }
        }
        setupVideo(surfaceRequest, timebase);
    }

    private void finalizePendingRecording(@NonNull RecordingRecord recordingRecord, int i8, @Nullable Throwable th2) {
        Uri uri = Uri.EMPTY;
        recordingRecord.finalizeRecording(uri);
        recordingRecord.updateVideoRecordEvent(VideoRecordEvent.finalizeWithError(recordingRecord.getOutputOptions(), RecordingStats.of(0L, 0L, AudioStats.of(1, this.mAudioErrorCause)), OutputResults.of(uri), i8, th2));
    }

    @NonNull
    private List<EncodedData> getAudioDataToWriteAndClearCache(long j8) {
        ArrayList arrayList = new ArrayList();
        while (!this.mPendingAudioRingBuffer.isEmpty()) {
            EncodedData encodedDataDequeue = this.mPendingAudioRingBuffer.dequeue();
            if (encodedDataDequeue.getPresentationTimeUs() >= j8) {
                arrayList.add(encodedDataDequeue);
            }
        }
        return arrayList;
    }

    private void initEncoderAndAudioSourceCallbacks(@NonNull final RecordingRecord recordingRecord) {
        final int i8 = 0;
        this.mEncodingFutures.add(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: androidx.camera.video.c

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Recorder f1003b;

            {
                this.f1003b = this;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                switch (i8) {
                    case 0:
                        return this.f1003b.lambda$initEncoderAndAudioSourceCallbacks$10(recordingRecord, completer);
                    default:
                        return this.f1003b.lambda$initEncoderAndAudioSourceCallbacks$12(recordingRecord, completer);
                }
            }
        }));
        if (isAudioEnabled()) {
            final int i9 = 1;
            this.mEncodingFutures.add(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(this) { // from class: androidx.camera.video.c

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Recorder f1003b;

                {
                    this.f1003b = this;
                }

                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    switch (i9) {
                        case 0:
                            return this.f1003b.lambda$initEncoderAndAudioSourceCallbacks$10(recordingRecord, completer);
                        default:
                            return this.f1003b.lambda$initEncoderAndAudioSourceCallbacks$12(recordingRecord, completer);
                    }
                }
            }));
        }
        Futures.addCallback(Futures.allAsList(this.mEncodingFutures), new FutureCallback<List<Void>>() { // from class: androidx.camera.video.Recorder.7
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th2) {
                Logger.d(Recorder.TAG, "Encodings end with error: " + th2);
                Recorder recorder = Recorder.this;
                recorder.finalizeInProgressRecording(recorder.mMediaMuxer == null ? 8 : 6, th2);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable List<Void> list) {
                Logger.d(Recorder.TAG, "Encodings end successfully.");
                Recorder recorder = Recorder.this;
                recorder.finalizeInProgressRecording(recorder.mRecordingStopError, recorder.mRecordingStopErrorCause);
            }
        }, CameraXExecutors.directExecutor());
    }

    private int internalAudioStateToAudioStatsState(@NonNull AudioState audioState) {
        int i8 = AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$AudioState[audioState.ordinal()];
        if (i8 == 1) {
            return 3;
        }
        if (i8 == 2) {
            return 4;
        }
        if (i8 == 3) {
            return this.mIsAudioSourceSilenced ? 2 : 0;
        }
        if (i8 == 4 || i8 == 6) {
            return 1;
        }
        throw new AssertionError("Invalid internal audio state: " + audioState);
    }

    @NonNull
    private StreamInfo.StreamState internalStateToStreamState(@NonNull State state) {
        return (state == State.RECORDING || (state == State.STOPPING && ((DeactivateEncoderSurfaceBeforeStopEncoderQuirk) DeviceQuirks.get(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class)) == null)) ? StreamInfo.StreamState.ACTIVE : StreamInfo.StreamState.INACTIVE;
    }

    private static boolean isSameRecording(@NonNull Recording recording, @Nullable RecordingRecord recordingRecord) {
        return recordingRecord != null && recording.getRecordingId() == recordingRecord.getRecordingId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$composeRecorderMediaSpec$8(VideoSpec.Builder builder) {
        builder.setAspectRatio(VIDEO_SPEC_DEFAULT.getAspectRatio());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureInternal$6(SurfaceRequest.TransformationInfo transformationInfo) {
        this.mSurfaceTransformationInfo = transformationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$initEncoderAndAudioSourceCallbacks$10(final RecordingRecord recordingRecord, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mVideoEncoder.setEncoderCallback(new EncoderCallback() { // from class: androidx.camera.video.Recorder.4
            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeError(@NonNull EncodeException encodeException) {
                completer.setException(encodeException);
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeStart() {
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeStop() {
                completer.set(null);
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodedData(@NonNull EncodedData encodedData) {
                boolean z2;
                Recorder recorder = Recorder.this;
                if (recorder.mMediaMuxer != null) {
                    try {
                        recorder.writeVideoData(encodedData, recordingRecord);
                        if (encodedData != null) {
                            encodedData.close();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        if (encodedData != null) {
                            try {
                                encodedData.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
                if (recorder.mInProgressRecordingStopping) {
                    Logger.d(Recorder.TAG, "Drop video data since recording is stopping.");
                    encodedData.close();
                    return;
                }
                EncodedData encodedData2 = recorder.mPendingFirstVideoData;
                if (encodedData2 != null) {
                    encodedData2.close();
                    Recorder.this.mPendingFirstVideoData = null;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!encodedData.isKeyFrame()) {
                    if (z2) {
                        Logger.d(Recorder.TAG, "Dropped cached keyframe since we have new video data and have not yet received audio data.");
                    }
                    Logger.d(Recorder.TAG, "Dropped video data since muxer has not yet started and data is not a keyframe.");
                    Recorder.this.mVideoEncoder.requestKeyFrame();
                    encodedData.close();
                    return;
                }
                Recorder recorder2 = Recorder.this;
                recorder2.mPendingFirstVideoData = encodedData;
                if (!recorder2.isAudioEnabled() || !Recorder.this.mPendingAudioRingBuffer.isEmpty()) {
                    Logger.d(Recorder.TAG, "Received video keyframe. Starting muxer...");
                    Recorder.this.setupAndStartMediaMuxer(recordingRecord);
                } else if (z2) {
                    Logger.d(Recorder.TAG, "Replaced cached video keyframe with newer keyframe.");
                } else {
                    Logger.d(Recorder.TAG, "Cached video keyframe while we wait for first audio sample before starting muxer.");
                }
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onOutputConfigUpdate(@NonNull OutputConfig outputConfig) {
                Recorder.this.mVideoOutputConfig = outputConfig;
            }
        }, this.mSequentialExecutor);
        return "videoEncodingFuture";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initEncoderAndAudioSourceCallbacks$11(CallbackToFutureAdapter.Completer completer, Throwable th2) {
        if (this.mAudioErrorCause == null) {
            if (th2 instanceof EncodeException) {
                setAudioState(AudioState.ERROR_ENCODER);
            } else {
                setAudioState(AudioState.ERROR_SOURCE);
            }
            this.mAudioErrorCause = th2;
            updateInProgressStatusEvent();
            completer.set(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$initEncoderAndAudioSourceCallbacks$12(final RecordingRecord recordingRecord, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final h1.a aVar = new h1.a(3, this, completer);
        this.mAudioSource.setAudioSourceCallback(this.mSequentialExecutor, new AudioSource.AudioSourceCallback() { // from class: androidx.camera.video.Recorder.5
            @Override // androidx.camera.video.internal.AudioSource.AudioSourceCallback
            public void onError(@NonNull Throwable th2) {
                Logger.e(Recorder.TAG, "Error occurred after audio source started.", th2);
                if (th2 instanceof AudioSourceAccessException) {
                    aVar.accept(th2);
                }
            }

            @Override // androidx.camera.video.internal.AudioSource.AudioSourceCallback
            public void onSilenced(boolean z2) {
                Recorder recorder = Recorder.this;
                if (recorder.mIsAudioSourceSilenced != z2) {
                    recorder.mIsAudioSourceSilenced = z2;
                    recorder.mAudioErrorCause = z2 ? new IllegalStateException("The audio source has been silenced.") : null;
                    Recorder.this.updateInProgressStatusEvent();
                } else {
                    Logger.w(Recorder.TAG, "Audio source silenced transitions to the same state " + z2);
                }
            }
        });
        this.mAudioEncoder.setEncoderCallback(new EncoderCallback() { // from class: androidx.camera.video.Recorder.6
            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeError(@NonNull EncodeException encodeException) {
                if (Recorder.this.mAudioErrorCause == null) {
                    aVar.accept(encodeException);
                }
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeStart() {
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodeStop() {
                completer.set(null);
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onEncodedData(@NonNull EncodedData encodedData) {
                Recorder recorder = Recorder.this;
                if (recorder.mAudioState == AudioState.DISABLED) {
                    throw new AssertionError("Audio is not enabled but audio encoded data is produced.");
                }
                if (recorder.mMediaMuxer == null) {
                    if (recorder.mInProgressRecordingStopping) {
                        Logger.d(Recorder.TAG, "Drop audio data since recording is stopping.");
                    } else {
                        recorder.mPendingAudioRingBuffer.enqueue(new BufferCopiedEncodedData(encodedData));
                        if (Recorder.this.mPendingFirstVideoData != null) {
                            Logger.d(Recorder.TAG, "Received audio data. Starting muxer...");
                            Recorder.this.setupAndStartMediaMuxer(recordingRecord);
                        } else {
                            Logger.d(Recorder.TAG, "Cached audio data while we wait for video keyframe before starting muxer.");
                        }
                    }
                    encodedData.close();
                    return;
                }
                try {
                    recorder.writeAudioData(encodedData, recordingRecord);
                    if (encodedData != null) {
                        encodedData.close();
                    }
                } catch (Throwable th2) {
                    if (encodedData != null) {
                        try {
                            encodedData.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }

            @Override // androidx.camera.video.internal.encoder.EncoderCallback
            public void onOutputConfigUpdate(@NonNull OutputConfig outputConfig) {
                Recorder.this.mAudioOutputConfig = outputConfig;
            }
        }, this.mSequentialExecutor);
        return "audioEncodingFuture";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAndStartMediaMuxer$9(Uri uri) {
        this.mOutputUri = uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupVideo$7(SurfaceRequest surfaceRequest, Timebase timebase) {
        if (!surfaceRequest.isServiced() && !this.mVideoEncoderSession.isConfiguredSurfaceRequest(surfaceRequest)) {
            final VideoEncoderSession videoEncoderSession = new VideoEncoderSession(this.mVideoEncoderFactory, this.mSequentialExecutor, this.mExecutor);
            m4.l lVarConfigure = videoEncoderSession.configure(surfaceRequest, timebase, (MediaSpec) getObservableData(this.mMediaSpec), this.mResolvedCamcorderProfile);
            this.mVideoEncoderSession = videoEncoderSession;
            Futures.addCallback(lVarConfigure, new FutureCallback<Encoder>() { // from class: androidx.camera.video.Recorder.1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th2) {
                    Logger.d(Recorder.TAG, "VideoEncoder Setup error: " + th2);
                    Recorder.this.onEncoderSetupError(th2);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(@Nullable Encoder encoder) {
                    Logger.d(Recorder.TAG, "VideoEncoder is created. " + encoder);
                    if (encoder == null) {
                        return;
                    }
                    Preconditions.checkState(Recorder.this.mVideoEncoderSession == videoEncoderSession);
                    Preconditions.checkState(Recorder.this.mVideoEncoder == null);
                    Recorder.this.onVideoEncoderReady(videoEncoderSession);
                    Recorder.this.onConfigured();
                }
            }, this.mSequentialExecutor);
            return;
        }
        Logger.w(TAG, "Ignore the SurfaceRequest " + surfaceRequest + " isServiced: " + surfaceRequest.isServiced() + " VideoEncoderSession: " + this.mVideoEncoderSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$2() {
        SurfaceRequest surfaceRequest = this.mLatestSurfaceRequest;
        if (surfaceRequest == null) {
            throw new AssertionError("surface request is required to retry initialization.");
        }
        configureInternal(surfaceRequest, this.mVideoSourceTimebase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$5(RecordingRecord recordingRecord, long j8) {
        stopInternal(recordingRecord, j8, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopInternal$13(Encoder encoder) {
        Logger.d(TAG, "The source didn't become non-streaming before timeout. Waited 1000ms");
        if (DeviceQuirks.get(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class) != null) {
            notifyEncoderSourceStopped(encoder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopInternal$14(Encoder encoder) {
        this.mSequentialExecutor.execute(new m.c(encoder, 19));
    }

    @NonNull
    @GuardedBy("mLock")
    private RecordingRecord makePendingRecordingActiveLocked(@NonNull State state) {
        boolean z2;
        if (state == State.PENDING_PAUSED) {
            z2 = true;
        } else {
            if (state != State.PENDING_RECORDING) {
                throw new AssertionError("makePendingRecordingActiveLocked() can only be called from a pending state.");
            }
            z2 = false;
        }
        if (this.mActiveRecordingRecord != null) {
            throw new AssertionError("Cannot make pending recording active because another recording is already active.");
        }
        RecordingRecord recordingRecord = this.mPendingRecordingRecord;
        if (recordingRecord == null) {
            throw new AssertionError("Pending recording should exist when in a PENDING state.");
        }
        this.mActiveRecordingRecord = recordingRecord;
        this.mPendingRecordingRecord = null;
        if (z2) {
            setState(State.PAUSED);
        } else {
            setState(State.RECORDING);
        }
        return recordingRecord;
    }

    public static void notifyEncoderSourceStopped(@NonNull Encoder encoder) {
        if (encoder instanceof EncoderImpl) {
            ((EncoderImpl) encoder).signalSourceStopped();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0032 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x0005, B:6:0x0009, B:9:0x001c, B:44:0x009d, B:15:0x002c, B:17:0x0032, B:20:0x0045, B:22:0x0049, B:24:0x004f, B:28:0x0057, B:29:0x0061, B:31:0x0065, B:33:0x0077, B:35:0x007b, B:37:0x0081, B:41:0x0089, B:42:0x0093, B:58:0x00c6, B:59:0x00d9, B:60:0x00da, B:61:0x00e1), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0045 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x0005, B:6:0x0009, B:9:0x001c, B:44:0x009d, B:15:0x002c, B:17:0x0032, B:20:0x0045, B:22:0x0049, B:24:0x004f, B:28:0x0057, B:29:0x0061, B:31:0x0065, B:33:0x0077, B:35:0x007b, B:37:0x0081, B:41:0x0089, B:42:0x0093, B:58:0x00c6, B:59:0x00d9, B:60:0x00da, B:61:0x00e1), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0049 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x0005, B:6:0x0009, B:9:0x001c, B:44:0x009d, B:15:0x002c, B:17:0x0032, B:20:0x0045, B:22:0x0049, B:24:0x004f, B:28:0x0057, B:29:0x0061, B:31:0x0065, B:33:0x0077, B:35:0x007b, B:37:0x0081, B:41:0x0089, B:42:0x0093, B:58:0x00c6, B:59:0x00d9, B:60:0x00da, B:61:0x00e1), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x0061 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x0005, B:6:0x0009, B:9:0x001c, B:44:0x009d, B:15:0x002c, B:17:0x0032, B:20:0x0045, B:22:0x0049, B:24:0x004f, B:28:0x0057, B:29:0x0061, B:31:0x0065, B:33:0x0077, B:35:0x007b, B:37:0x0081, B:41:0x0089, B:42:0x0093, B:58:0x00c6, B:59:0x00d9, B:60:0x00da, B:61:0x00e1), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0065 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:4:0x0005, B:6:0x0009, B:9:0x001c, B:44:0x009d, B:15:0x002c, B:17:0x0032, B:20:0x0045, B:22:0x0049, B:24:0x004f, B:28:0x0057, B:29:0x0061, B:31:0x0065, B:33:0x0077, B:35:0x007b, B:37:0x0081, B:41:0x0089, B:42:0x0093, B:58:0x00c6, B:59:0x00d9, B:60:0x00da, B:61:0x00e1), top: B:64:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x001c. Please report as an issue. */
    private void onRecordingFinalized(@NonNull RecordingRecord recordingRecord) {
        RecordingRecord recordingRecordMakePendingRecordingActiveLocked;
        boolean z2;
        boolean z3;
        int i8;
        boolean z5;
        boolean z10;
        RecordingRecord recordingRecord2;
        Exception exc;
        SurfaceRequest surfaceRequest;
        synchronized (this.mLock) {
            try {
                if (this.mActiveRecordingRecord != recordingRecord) {
                    throw new AssertionError("Active recording did not match finalized recording on finalize.");
                }
                recordingRecordMakePendingRecordingActiveLocked = null;
                exc = null;
                recordingRecordMakePendingRecordingActiveLocked = null;
                recordingRecordMakePendingRecordingActiveLocked = null;
                recordingRecordMakePendingRecordingActiveLocked = null;
                recordingRecordMakePendingRecordingActiveLocked = null;
                recordingRecordMakePendingRecordingActiveLocked = null;
                this.mActiveRecordingRecord = null;
                int i9 = AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()];
                if (i9 == 9) {
                    throw new AssertionError("Unexpected state on finalize of recording: " + this.mState);
                }
                boolean z11 = true;
                z2 = false;
                switch (i9) {
                    case 1:
                    case 2:
                    case 6:
                        if (!this.mEncoderNotUsePersistentInputSurface) {
                            setState(State.IDLING);
                            recordingRecord2 = null;
                            exc = null;
                            z3 = false;
                            i8 = 0;
                            z5 = false;
                        } else {
                            this.mActiveSurface = null;
                            SurfaceRequest surfaceRequest2 = this.mLatestSurfaceRequest;
                            if (surfaceRequest2 == null || surfaceRequest2.isServiced()) {
                                z11 = false;
                            }
                            setState(State.CONFIGURING);
                            z3 = z11;
                            i8 = 0;
                            z5 = false;
                            recordingRecord2 = recordingRecordMakePendingRecordingActiveLocked;
                        }
                        break;
                    case 3:
                        z10 = true;
                        if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                            if (this.mEncoderNotUsePersistentInputSurface) {
                                this.mActiveSurface = null;
                                surfaceRequest = this.mLatestSurfaceRequest;
                                if (surfaceRequest != null || surfaceRequest.isServiced()) {
                                    z11 = false;
                                }
                                updateNonPendingState(State.CONFIGURING);
                                z5 = z10;
                                i8 = 0;
                                z3 = z11;
                            } else if (this.mVideoEncoder != null) {
                                recordingRecord2 = null;
                                exc = null;
                                z5 = z10;
                                z3 = false;
                                i8 = 0;
                            } else {
                                z5 = z10;
                                z3 = false;
                                i8 = 0;
                                recordingRecordMakePendingRecordingActiveLocked = makePendingRecordingActiveLocked(this.mState);
                            }
                            recordingRecord2 = recordingRecordMakePendingRecordingActiveLocked;
                        } else {
                            recordingRecord2 = this.mPendingRecordingRecord;
                            this.mPendingRecordingRecord = null;
                            setState(State.CONFIGURING);
                            exc = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
                            i8 = 4;
                            z5 = z10;
                            z3 = false;
                        }
                        break;
                    case 4:
                        z10 = false;
                        if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                            if (this.mEncoderNotUsePersistentInputSurface) {
                                this.mActiveSurface = null;
                                surfaceRequest = this.mLatestSurfaceRequest;
                                if (surfaceRequest != null) {
                                    z11 = false;
                                } else {
                                    z11 = false;
                                }
                                updateNonPendingState(State.CONFIGURING);
                                z5 = z10;
                                i8 = 0;
                                z3 = z11;
                            } else if (this.mVideoEncoder != null) {
                                recordingRecord2 = null;
                                exc = null;
                                z5 = z10;
                                z3 = false;
                                i8 = 0;
                            } else {
                                z5 = z10;
                                z3 = false;
                                i8 = 0;
                                recordingRecordMakePendingRecordingActiveLocked = makePendingRecordingActiveLocked(this.mState);
                            }
                            recordingRecord2 = recordingRecordMakePendingRecordingActiveLocked;
                        } else {
                            recordingRecord2 = this.mPendingRecordingRecord;
                            this.mPendingRecordingRecord = null;
                            setState(State.CONFIGURING);
                            exc = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
                            i8 = 4;
                            z5 = z10;
                            z3 = false;
                        }
                        break;
                    case 5:
                        z3 = false;
                        i8 = 0;
                        z5 = false;
                        z2 = true;
                        recordingRecord2 = recordingRecordMakePendingRecordingActiveLocked;
                        break;
                    default:
                        recordingRecord2 = null;
                        exc = null;
                        z3 = false;
                        i8 = 0;
                        z5 = false;
                        break;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z3) {
            configureInternal(this.mLatestSurfaceRequest, this.mVideoSourceTimebase);
            return;
        }
        if (z2) {
            reset();
            return;
        }
        if (recordingRecordMakePendingRecordingActiveLocked != null) {
            if (this.mEncoderNotUsePersistentInputSurface) {
                throw new AssertionError("Attempt to start a pending recording while the Recorder is waiting for a new surface request.");
            }
            startRecording(recordingRecordMakePendingRecordingActiveLocked, z5);
        } else if (recordingRecord2 != null) {
            finalizePendingRecording(recordingRecord2, i8, exc);
        }
    }

    private void onReset() {
        synchronized (this.mLock) {
            try {
                switch (AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                        setState(State.CONFIGURING);
                        break;
                    case 3:
                    case 4:
                        updateNonPendingState(State.CONFIGURING);
                        break;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.mNeedsReset = false;
        SurfaceRequest surfaceRequest = this.mLatestSurfaceRequest;
        if (surfaceRequest == null || surfaceRequest.isServiced()) {
            return;
        }
        configureInternal(this.mLatestSurfaceRequest, this.mVideoSourceTimebase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onSurfaceRequestedInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$onSurfaceRequested$0(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        SurfaceRequest surfaceRequest2 = this.mLatestSurfaceRequest;
        if (surfaceRequest2 != null && !surfaceRequest2.isServiced()) {
            this.mLatestSurfaceRequest.willNotProvideSurface();
        }
        this.mLatestSurfaceRequest = surfaceRequest;
        this.mVideoSourceTimebase = timebase;
        configureInternal(surfaceRequest, timebase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: pauseInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$pause$3(@NonNull RecordingRecord recordingRecord) {
        if (this.mInProgressRecording != recordingRecord || this.mInProgressRecordingStopping) {
            return;
        }
        if (isAudioEnabled()) {
            this.mAudioEncoder.pause();
        }
        this.mVideoEncoder.pause();
        RecordingRecord recordingRecord2 = this.mInProgressRecording;
        recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.pause(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
    }

    @NonNull
    private PendingRecording prepareRecordingInternal(@NonNull Context context, @NonNull OutputOptions outputOptions) {
        Preconditions.checkNotNull(outputOptions, "The OutputOptions cannot be null.");
        return new PendingRecording(context, this, outputOptions);
    }

    private void releaseCurrentAudioSource() {
        final AudioSource audioSource = this.mAudioSource;
        if (audioSource == null) {
            throw new AssertionError("Cannot release null audio source.");
        }
        this.mAudioSource = null;
        Logger.d(TAG, String.format("Releasing audio source: 0x%x", Integer.valueOf(audioSource.hashCode())));
        Futures.addCallback(audioSource.release(), new FutureCallback<Void>() { // from class: androidx.camera.video.Recorder.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th2) {
                Logger.d(Recorder.TAG, String.format("An error occurred while attempting to release audio source: 0x%x", Integer.valueOf(audioSource.hashCode())));
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r7) {
                Logger.d(Recorder.TAG, String.format("Released audio source successfully: 0x%x", Integer.valueOf(audioSource.hashCode())));
            }
        }, CameraXExecutors.directExecutor());
    }

    private void reset() {
        if (this.mAudioEncoder != null) {
            Logger.d(TAG, "Releasing audio encoder.");
            this.mAudioEncoder.release();
            this.mAudioEncoder = null;
            this.mAudioOutputConfig = null;
        }
        tryReleaseVideoEncoder();
        if (this.mAudioSource != null) {
            releaseCurrentAudioSource();
        }
        setAudioState(AudioState.INITIALIZING);
        onReset();
    }

    @GuardedBy("mLock")
    private void restoreNonPendingState() {
        if (PENDING_STATES.contains(this.mState)) {
            setState(this.mNonPendingState);
        } else {
            throw new AssertionError("Cannot restore non-pending state when in state " + this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: resumeInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$resume$4(@NonNull RecordingRecord recordingRecord) {
        if (this.mInProgressRecording != recordingRecord || this.mInProgressRecordingStopping) {
            return;
        }
        if (isAudioEnabled()) {
            this.mAudioEncoder.start();
        }
        this.mVideoEncoder.start();
        RecordingRecord recordingRecord2 = this.mInProgressRecording;
        recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.resume(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
    }

    @NonNull
    private m4.l safeToCloseVideoEncoder() {
        Logger.d(TAG, "Try to safely release video encoder: " + this.mVideoEncoder);
        return this.mVideoEncoderSession.signalTermination();
    }

    @GuardedBy("mLock")
    private void setStreamId(int i8) {
        if (this.mStreamId == i8) {
            return;
        }
        Logger.d(TAG, "Transitioning streamId: " + this.mStreamId + " --> " + i8);
        this.mStreamId = i8;
        this.mStreamInfo.setState(StreamInfo.of(i8, internalStateToStreamState(this.mState)));
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    private void setupAudio(@NonNull RecordingRecord recordingRecord) throws AudioSourceAccessException, InvalidConfigException {
        MediaSpec mediaSpec = (MediaSpec) getObservableData(this.mMediaSpec);
        MimeInfo mimeInfoResolveAudioMimeInfo = AudioConfigUtil.resolveAudioMimeInfo(mediaSpec, this.mResolvedCamcorderProfile);
        Timebase timebase = Timebase.UPTIME;
        AudioSource.Settings settingsResolveAudioSourceSettings = AudioConfigUtil.resolveAudioSourceSettings(mimeInfoResolveAudioMimeInfo, mediaSpec.getAudioSpec());
        if (this.mAudioSource != null) {
            releaseCurrentAudioSource();
        }
        AudioSource audioSource = setupAudioSource(recordingRecord, settingsResolveAudioSourceSettings);
        this.mAudioSource = audioSource;
        Logger.d(TAG, String.format("Set up new audio source: 0x%x", Integer.valueOf(audioSource.hashCode())));
        Encoder encoderCreateEncoder = this.mAudioEncoderFactory.createEncoder(this.mExecutor, AudioConfigUtil.resolveAudioEncoderConfig(mimeInfoResolveAudioMimeInfo, timebase, settingsResolveAudioSourceSettings, mediaSpec.getAudioSpec()));
        this.mAudioEncoder = encoderCreateEncoder;
        Encoder.EncoderInput input = encoderCreateEncoder.getInput();
        if (!(input instanceof Encoder.ByteBufferInput)) {
            throw new AssertionError("The EncoderInput of audio isn't a ByteBufferInput.");
        }
        this.mAudioSource.setBufferProvider((Encoder.ByteBufferInput) input);
    }

    @NonNull
    @RequiresPermission("android.permission.RECORD_AUDIO")
    private AudioSource setupAudioSource(@NonNull RecordingRecord recordingRecord, @NonNull AudioSource.Settings settings) throws AudioSourceAccessException {
        return recordingRecord.performOneTimeAudioSourceCreation(settings, AUDIO_EXECUTOR);
    }

    private void setupVideo(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        safeToCloseVideoEncoder().addListener(new x.b(this, surfaceRequest, timebase, 1), this.mSequentialExecutor);
    }

    private void startInternal(@NonNull RecordingRecord recordingRecord) {
        if (this.mInProgressRecording != null) {
            throw new AssertionError("Attempted to start a new recording while another was in progress.");
        }
        if (recordingRecord.getOutputOptions().getFileSizeLimit() > 0) {
            this.mFileSizeLimitInBytes = Math.round(recordingRecord.getOutputOptions().getFileSizeLimit() * 0.95d);
            Logger.d(TAG, "File size limit in bytes: " + this.mFileSizeLimitInBytes);
        } else {
            this.mFileSizeLimitInBytes = 0L;
        }
        if (recordingRecord.getOutputOptions().getDurationLimitMillis() > 0) {
            this.mDurationLimitNs = TimeUnit.MILLISECONDS.toNanos(recordingRecord.getOutputOptions().getDurationLimitMillis());
            Logger.d(TAG, "Duration limit in nanoseconds: " + this.mDurationLimitNs);
        } else {
            this.mDurationLimitNs = 0L;
        }
        this.mInProgressRecording = recordingRecord;
        switch (AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$AudioState[this.mAudioState.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new AssertionError("Incorrectly invoke startInternal in audio state " + this.mAudioState);
            case 5:
                setAudioState(recordingRecord.hasAudioEnabled() ? AudioState.ACTIVE : AudioState.DISABLED);
                break;
            case 6:
                if (recordingRecord.hasAudioEnabled()) {
                    if (!isAudioSupported()) {
                        throw new AssertionError("The Recorder doesn't support recording with audio");
                    }
                    try {
                        setupAudio(recordingRecord);
                        setAudioState(AudioState.ACTIVE);
                    } catch (AudioSourceAccessException | InvalidConfigException e) {
                        Logger.e(TAG, "Unable to create audio resource with error: ", e);
                        setAudioState(e instanceof InvalidConfigException ? AudioState.ERROR_ENCODER : AudioState.ERROR_SOURCE);
                        this.mAudioErrorCause = e;
                    }
                }
                break;
        }
        initEncoderAndAudioSourceCallbacks(recordingRecord);
        if (isAudioEnabled()) {
            this.mAudioSource.start();
            this.mAudioEncoder.start();
        }
        this.mVideoEncoder.start();
        RecordingRecord recordingRecord2 = this.mInProgressRecording;
        recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.start(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
    }

    private void startRecording(@NonNull RecordingRecord recordingRecord, boolean z2) {
        startInternal(recordingRecord);
        if (z2) {
            lambda$pause$3(recordingRecord);
        }
    }

    private static int supportedMuxerFormatOrDefaultFrom(@Nullable CamcorderProfileProxy camcorderProfileProxy, int i8) {
        if (camcorderProfileProxy != null) {
            int fileFormat = camcorderProfileProxy.getFileFormat();
            if (fileFormat == 1) {
                return 2;
            }
            if (fileFormat == 2) {
                return 0;
            }
            if (fileFormat == 9) {
                return 1;
            }
        }
        return i8;
    }

    private void tryReleaseVideoEncoder() {
        VideoEncoderSession videoEncoderSession = this.mVideoEncoderSessionToRelease;
        if (videoEncoderSession == null) {
            safeToCloseVideoEncoder();
            return;
        }
        Preconditions.checkState(videoEncoderSession.getVideoEncoder() == this.mVideoEncoder);
        Logger.d(TAG, "Releasing video encoder: " + this.mVideoEncoder);
        this.mVideoEncoderSessionToRelease.terminateNow();
        this.mVideoEncoderSessionToRelease = null;
        this.mVideoEncoder = null;
        this.mVideoOutputConfig = null;
        setLatestSurface(null);
    }

    @GuardedBy("mLock")
    private void updateNonPendingState(@NonNull State state) {
        if (!PENDING_STATES.contains(this.mState)) {
            throw new AssertionError("Can only updated non-pending state from a pending state, but state is " + this.mState);
        }
        if (!VALID_NON_PENDING_STATES_WHILE_PENDING.contains(state)) {
            throw new AssertionError("Invalid state transition. State is not a valid non-pending state while in a pending state: " + state);
        }
        if (this.mNonPendingState != state) {
            this.mNonPendingState = state;
            this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, internalStateToStreamState(state)));
        }
    }

    public void finalizeInProgressRecording(int i8, @Nullable Throwable th2) {
        if (this.mInProgressRecording == null) {
            throw new AssertionError("Attempted to finalize in-progress recording, but no recording is in progress.");
        }
        MediaMuxer mediaMuxer = this.mMediaMuxer;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
                this.mMediaMuxer.release();
            } catch (IllegalStateException e) {
                Logger.e(TAG, "MediaMuxer failed to stop or release with error: " + e.getMessage());
                if (i8 == 0) {
                    i8 = 1;
                }
            }
            this.mMediaMuxer = null;
        } else if (i8 == 0) {
            i8 = 8;
        }
        this.mInProgressRecording.finalizeRecording(this.mOutputUri);
        OutputOptions outputOptions = this.mInProgressRecording.getOutputOptions();
        RecordingStats inProgressRecordingStats = getInProgressRecordingStats();
        OutputResults outputResultsOf = OutputResults.of(this.mOutputUri);
        this.mInProgressRecording.updateVideoRecordEvent(i8 == 0 ? VideoRecordEvent.finalize(outputOptions, inProgressRecordingStats, outputResultsOf) : VideoRecordEvent.finalizeWithError(outputOptions, inProgressRecordingStats, outputResultsOf, i8, th2));
        RecordingRecord recordingRecord = this.mInProgressRecording;
        this.mInProgressRecording = null;
        this.mInProgressRecordingStopping = false;
        this.mAudioTrackIndex = null;
        this.mVideoTrackIndex = null;
        this.mEncodingFutures.clear();
        this.mOutputUri = Uri.EMPTY;
        this.mRecordingBytes = 0L;
        this.mRecordingDurationNs = 0L;
        this.mFirstRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mFirstRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingVideoDataTimeUs = Long.MAX_VALUE;
        this.mPreviousRecordingAudioDataTimeUs = Long.MAX_VALUE;
        this.mRecordingStopError = 1;
        this.mRecordingStopErrorCause = null;
        this.mAudioErrorCause = null;
        clearPendingAudioRingBuffer();
        int i9 = AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$AudioState[this.mAudioState.ordinal()];
        if (i9 == 1 || i9 == 2) {
            setAudioState(AudioState.INITIALIZING);
        } else if (i9 == 3 || i9 == 4) {
            setAudioState(AudioState.IDLING);
            this.mAudioSource.stop();
        } else if (i9 == 5) {
            throw new AssertionError("Incorrectly finalize recording when audio state is IDLING");
        }
        onRecordingFinalized(recordingRecord);
    }

    public int getAspectRatio() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getAspectRatio();
    }

    public int getAudioSource() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getAudioSpec().getSource();
    }

    @Nullable
    public Executor getExecutor() {
        return this.mUserProvidedExecutor;
    }

    @NonNull
    public RecordingStats getInProgressRecordingStats() {
        return RecordingStats.of(this.mRecordingDurationNs, this.mRecordingBytes, AudioStats.of(internalAudioStateToAudioStatsState(this.mAudioState), this.mAudioErrorCause));
    }

    @Override // androidx.camera.video.VideoOutput
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Observable<MediaSpec> getMediaSpec() {
        return this.mMediaSpec;
    }

    public <T> T getObservableData(@NonNull StateObservable<T> stateObservable) {
        try {
            return (T) stateObservable.fetchData().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    @NonNull
    public QualitySelector getQualitySelector() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getQualitySelector();
    }

    @Override // androidx.camera.video.VideoOutput
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Observable<StreamInfo> getStreamInfo() {
        return this.mStreamInfo;
    }

    public int getTargetVideoEncodingBitRate() {
        return ((Integer) ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getBitrate().getLower()).intValue();
    }

    public boolean isAudioEnabled() {
        return this.mAudioState == AudioState.ACTIVE;
    }

    public boolean isAudioSupported() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getAudioSpec().getChannelCount() != 0;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0041 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0005, B:5:0x0011, B:26:0x005c, B:7:0x0015, B:10:0x0020, B:11:0x0026, B:15:0x002f, B:16:0x0036, B:19:0x003a, B:22:0x0041, B:24:0x0047, B:25:0x0052, B:32:0x0069, B:33:0x007c), top: B:36:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0047 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0005, B:5:0x0011, B:26:0x005c, B:7:0x0015, B:10:0x0020, B:11:0x0026, B:15:0x002f, B:16:0x0036, B:19:0x003a, B:22:0x0041, B:24:0x0047, B:25:0x0052, B:32:0x0069, B:33:0x007c), top: B:36:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0052 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0005, B:5:0x0011, B:26:0x005c, B:7:0x0015, B:10:0x0020, B:11:0x0026, B:15:0x002f, B:16:0x0036, B:19:0x003a, B:22:0x0041, B:24:0x0047, B:25:0x0052, B:32:0x0069, B:33:0x007c), top: B:36:0x0005 }] */
    public void onConfigured() {
        RecordingRecord recordingRecordMakePendingRecordingActiveLocked;
        boolean z2;
        int i8;
        Throwable th2;
        synchronized (this.mLock) {
            try {
                recordingRecordMakePendingRecordingActiveLocked = null;
                switch (AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()]) {
                    case 1:
                    case 2:
                    case 5:
                    case 9:
                        throw new AssertionError("Incorrectly invoke onConfigured() in state " + this.mState);
                    case 3:
                        z2 = true;
                        if (this.mActiveRecordingRecord != null) {
                            i8 = 0;
                            th2 = recordingRecordMakePendingRecordingActiveLocked;
                        } else if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                            recordingRecordMakePendingRecordingActiveLocked = this.mPendingRecordingRecord;
                            this.mPendingRecordingRecord = null;
                            restoreNonPendingState();
                            th2 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
                            i8 = 4;
                        } else {
                            i8 = 0;
                            th2 = null;
                            recordingRecordMakePendingRecordingActiveLocked = makePendingRecordingActiveLocked(this.mState);
                            recordingRecordMakePendingRecordingActiveLocked = null;
                        }
                        break;
                    case 4:
                        z2 = false;
                        if (this.mActiveRecordingRecord != null) {
                            i8 = 0;
                            th2 = recordingRecordMakePendingRecordingActiveLocked;
                        } else if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                            recordingRecordMakePendingRecordingActiveLocked = this.mPendingRecordingRecord;
                            this.mPendingRecordingRecord = null;
                            restoreNonPendingState();
                            th2 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
                            i8 = 4;
                        } else {
                            i8 = 0;
                            th2 = null;
                            recordingRecordMakePendingRecordingActiveLocked = makePendingRecordingActiveLocked(this.mState);
                            recordingRecordMakePendingRecordingActiveLocked = null;
                        }
                        break;
                    case 6:
                        if (!this.mEncoderNotUsePersistentInputSurface) {
                            throw new AssertionError("Unexpectedly invoke onConfigured() in a STOPPING state when it's not waiting for a new surface.");
                        }
                        z2 = false;
                        i8 = 0;
                        th2 = recordingRecordMakePendingRecordingActiveLocked;
                        break;
                    case 7:
                        setState(State.IDLING);
                        z2 = false;
                        i8 = 0;
                        th2 = recordingRecordMakePendingRecordingActiveLocked;
                        break;
                    case 8:
                        Logger.e(TAG, "onConfigured() was invoked when the Recorder had encountered error");
                        z2 = false;
                        i8 = 0;
                        th2 = recordingRecordMakePendingRecordingActiveLocked;
                        break;
                    default:
                        z2 = false;
                        i8 = 0;
                        th2 = recordingRecordMakePendingRecordingActiveLocked;
                        break;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (recordingRecordMakePendingRecordingActiveLocked != null) {
            startRecording(recordingRecordMakePendingRecordingActiveLocked, z2);
        } else if (recordingRecordMakePendingRecordingActiveLocked != null) {
            finalizePendingRecording(recordingRecordMakePendingRecordingActiveLocked, i8, th2);
        }
    }

    public void onEncoderSetupError(@Nullable Throwable th2) {
        RecordingRecord recordingRecord;
        synchronized (this.mLock) {
            recordingRecord = null;
            switch (AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()]) {
                case 1:
                case 2:
                case 5:
                case 6:
                case 9:
                    throw new AssertionError("Encountered encoder setup error while in unexpected state " + this.mState + ": " + th2);
                case 3:
                case 4:
                    RecordingRecord recordingRecord2 = this.mPendingRecordingRecord;
                    this.mPendingRecordingRecord = null;
                    recordingRecord = recordingRecord2;
                case 7:
                    setStreamId(-1);
                    setState(State.ERROR);
                    break;
                case 8:
                default:
                    break;
            }
        }
        if (recordingRecord != null) {
            finalizePendingRecording(recordingRecord, 7, th2);
        }
    }

    public void onInProgressRecordingInternalError(@NonNull RecordingRecord recordingRecord, int i8, @Nullable Throwable th2) {
        boolean z2;
        if (recordingRecord != this.mInProgressRecording) {
            throw new AssertionError("Internal error occurred on recording that is not the current in-progress recording.");
        }
        synchronized (this.mLock) {
            try {
                z2 = false;
                switch (AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()]) {
                    case 1:
                    case 2:
                        setState(State.STOPPING);
                        z2 = true;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (recordingRecord != this.mActiveRecordingRecord) {
                            throw new AssertionError("Internal error occurred for recording but it is not the active recording.");
                        }
                        break;
                    case 7:
                    case 8:
                    case 9:
                        throw new AssertionError("In-progress recording error occurred while in unexpected state: " + this.mState);
                    default:
                        break;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z2) {
            stopInternal(recordingRecord, -1L, i8, th2);
        }
    }

    @Override // androidx.camera.video.VideoOutput
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onSourceStateChanged(@NonNull VideoOutput.SourceState sourceState) {
        this.mSequentialExecutor.execute(new o.e(22, this, sourceState));
    }

    /* JADX INFO: renamed from: onSourceStateChangedInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$onSourceStateChanged$1(@NonNull VideoOutput.SourceState sourceState) {
        ScheduledFuture<?> scheduledFuture;
        Encoder encoder;
        VideoOutput.SourceState sourceState2 = this.mSourceState;
        this.mSourceState = sourceState;
        if (sourceState2 == sourceState) {
            Logger.d(TAG, "Video source transitions to the same state: " + sourceState);
            return;
        }
        Logger.d(TAG, "Video source has transitioned to state: " + sourceState);
        if (sourceState != VideoOutput.SourceState.INACTIVE) {
            if (sourceState != VideoOutput.SourceState.ACTIVE_NON_STREAMING || (scheduledFuture = this.mSourceNonStreamingTimeout) == null || !scheduledFuture.cancel(false) || (encoder = this.mVideoEncoder) == null) {
                return;
            }
            notifyEncoderSourceStopped(encoder);
            return;
        }
        if (this.mActiveSurface == null) {
            requestReset(4, null);
            return;
        }
        this.mNeedsReset = true;
        RecordingRecord recordingRecord = this.mInProgressRecording;
        if (recordingRecord != null) {
            onInProgressRecordingInternalError(recordingRecord, 4, null);
        }
    }

    @Override // androidx.camera.video.VideoOutput
    public void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest) {
        onSurfaceRequested(surfaceRequest, Timebase.UPTIME);
    }

    public void onVideoEncoderReady(@NonNull final VideoEncoderSession videoEncoderSession) {
        Encoder videoEncoder = videoEncoderSession.getVideoEncoder();
        this.mVideoEncoder = videoEncoder;
        this.mVideoEncoderBitrateRange = ((VideoEncoderInfo) videoEncoder.getEncoderInfo()).getSupportedBitrateRange();
        this.mFirstRecordingVideoBitrate = this.mVideoEncoder.getConfiguredBitrate();
        Surface activeSurface = videoEncoderSession.getActiveSurface();
        this.mActiveSurface = activeSurface;
        setLatestSurface(activeSurface);
        videoEncoderSession.setOnSurfaceUpdateListener(this.mSequentialExecutor, new Encoder.SurfaceInput.OnSurfaceUpdateListener() { // from class: x.a
            @Override // androidx.camera.video.internal.encoder.Encoder.SurfaceInput.OnSurfaceUpdateListener
            public final void onSurfaceUpdate(Surface surface) {
                this.f10793a.setLatestSurface(surface);
            }
        });
        Futures.addCallback(videoEncoderSession.getReadyToReleaseFuture(), new FutureCallback<Encoder>() { // from class: androidx.camera.video.Recorder.2
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th2) {
                Logger.d(Recorder.TAG, "Error in ReadyToReleaseFuture: " + th2);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Encoder encoder) {
                Encoder encoder2;
                Logger.d(Recorder.TAG, "VideoEncoder can be released: " + encoder);
                if (encoder == null) {
                    return;
                }
                ScheduledFuture<?> scheduledFuture = Recorder.this.mSourceNonStreamingTimeout;
                if (scheduledFuture != null && scheduledFuture.cancel(false) && (encoder2 = Recorder.this.mVideoEncoder) != null && encoder2 == encoder) {
                    Recorder.notifyEncoderSourceStopped(encoder2);
                }
                Recorder recorder = Recorder.this;
                recorder.mVideoEncoderSessionToRelease = videoEncoderSession;
                recorder.setLatestSurface(null);
                Recorder.this.requestReset(4, null);
            }
        }, this.mSequentialExecutor);
    }

    public void pause(@NonNull Recording recording) {
        synchronized (this.mLock) {
            try {
                if (!isSameRecording(recording, this.mPendingRecordingRecord) && !isSameRecording(recording, this.mActiveRecordingRecord)) {
                    Logger.d(TAG, "pause() called on a recording that is no longer active: " + recording.getOutputOptions());
                    return;
                }
                int i8 = AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()];
                if (i8 == 2) {
                    setState(State.PAUSED);
                    this.mSequentialExecutor.execute(new b(this, this.mActiveRecordingRecord, 1));
                } else if (i8 == 4) {
                    setState(State.PENDING_PAUSED);
                } else if (i8 == 7 || i8 == 9) {
                    throw new IllegalStateException("Called pause() from invalid state: " + this.mState);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public PendingRecording prepareRecording(@NonNull Context context, @NonNull FileOutputOptions fileOutputOptions) {
        return prepareRecordingInternal(context, fileOutputOptions);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void requestReset(int i8, @Nullable Throwable th2) {
        boolean z2;
        boolean z3;
        synchronized (this.mLock) {
            try {
                z2 = true;
                z3 = false;
                switch (AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()]) {
                    case 1:
                    case 2:
                        if (this.mActiveRecordingRecord != this.mInProgressRecording) {
                            throw new AssertionError("In-progress recording does not match the active recording. Unable to reset encoder.");
                        }
                        setState(State.RESETTING);
                        z3 = z2;
                        z2 = false;
                        break;
                    case 3:
                    case 4:
                        updateNonPendingState(State.RESETTING);
                        break;
                    case 5:
                    default:
                        z2 = false;
                        break;
                    case 6:
                        z2 = false;
                        setState(State.RESETTING);
                        z3 = z2;
                        z2 = false;
                        break;
                    case 7:
                    case 8:
                    case 9:
                        break;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z2) {
            reset();
        } else if (z3) {
            stopInternal(this.mInProgressRecording, -1L, i8, th2);
        }
    }

    public void resume(@NonNull Recording recording) {
        synchronized (this.mLock) {
            try {
                if (!isSameRecording(recording, this.mPendingRecordingRecord) && !isSameRecording(recording, this.mActiveRecordingRecord)) {
                    Logger.d(TAG, "resume() called on a recording that is no longer active: " + recording.getOutputOptions());
                    return;
                }
                int i8 = AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()];
                if (i8 == 1) {
                    setState(State.RECORDING);
                    this.mSequentialExecutor.execute(new b(this, this.mActiveRecordingRecord, 0));
                } else if (i8 == 3) {
                    setState(State.PENDING_RECORDING);
                } else if (i8 == 7 || i8 == 9) {
                    throw new IllegalStateException("Called resume() from invalid state: " + this.mState);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setAudioState(@NonNull AudioState audioState) {
        Logger.d(TAG, "Transitioning audio state: " + this.mAudioState + " --> " + audioState);
        this.mAudioState = audioState;
    }

    public void setLatestSurface(@Nullable Surface surface) {
        int iHashCode;
        if (this.mLatestSurface == surface) {
            return;
        }
        this.mLatestSurface = surface;
        synchronized (this.mLock) {
            if (surface != null) {
                try {
                    iHashCode = surface.hashCode();
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                iHashCode = 0;
            }
            setStreamId(iHashCode);
        }
    }

    @GuardedBy("mLock")
    public void setState(@NonNull State state) {
        if (this.mState == state) {
            throw new AssertionError("Attempted to transition to state " + state + ", but Recorder is already in state " + state);
        }
        Logger.d(TAG, "Transitioning Recorder internal state: " + this.mState + " --> " + state);
        Set<State> set = PENDING_STATES;
        StreamInfo.StreamState streamStateInternalStateToStreamState = null;
        if (set.contains(state)) {
            if (!set.contains(this.mState)) {
                if (!VALID_NON_PENDING_STATES_WHILE_PENDING.contains(this.mState)) {
                    throw new AssertionError("Invalid state transition. Should not be transitioning to a PENDING state from state " + this.mState);
                }
                State state2 = this.mState;
                this.mNonPendingState = state2;
                streamStateInternalStateToStreamState = internalStateToStreamState(state2);
            }
        } else if (this.mNonPendingState != null) {
            this.mNonPendingState = null;
        }
        this.mState = state;
        if (streamStateInternalStateToStreamState == null) {
            streamStateInternalStateToStreamState = internalStateToStreamState(state);
        }
        this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, streamStateInternalStateToStreamState));
    }

    public void setupAndStartMediaMuxer(@NonNull RecordingRecord recordingRecord) {
        if (this.mMediaMuxer != null) {
            throw new AssertionError("Unable to set up media muxer when one already exists.");
        }
        if (isAudioEnabled() && this.mPendingAudioRingBuffer.isEmpty()) {
            throw new AssertionError("Audio is enabled but no audio sample is ready. Cannot start media muxer.");
        }
        EncodedData encodedData = this.mPendingFirstVideoData;
        if (encodedData == null) {
            throw new AssertionError("Media muxer cannot be started without an encoded video frame.");
        }
        try {
            this.mPendingFirstVideoData = null;
            List<EncodedData> audioDataToWriteAndClearCache = getAudioDataToWriteAndClearCache(encodedData.getPresentationTimeUs());
            long size = encodedData.size();
            Iterator<EncodedData> it = audioDataToWriteAndClearCache.iterator();
            while (it.hasNext()) {
                size += it.next().size();
            }
            long j8 = this.mFileSizeLimitInBytes;
            if (j8 != 0 && size > j8) {
                Logger.d(TAG, String.format("Initial data exceeds file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)));
                onInProgressRecordingInternalError(recordingRecord, 2, null);
                encodedData.close();
                return;
            }
            try {
                MediaSpec mediaSpec = (MediaSpec) getObservableData(this.mMediaSpec);
                MediaMuxer mediaMuxerPerformOneTimeMediaMuxerCreation = recordingRecord.performOneTimeMediaMuxerCreation(mediaSpec.getOutputFormat() == -1 ? supportedMuxerFormatOrDefaultFrom(this.mResolvedCamcorderProfile, MediaSpec.outputFormatToMuxerFormat(MEDIA_SPEC_DEFAULT.getOutputFormat())) : MediaSpec.outputFormatToMuxerFormat(mediaSpec.getOutputFormat()), new b0.d(this, 2));
                SurfaceRequest.TransformationInfo transformationInfo = this.mSurfaceTransformationInfo;
                if (transformationInfo != null) {
                    mediaMuxerPerformOneTimeMediaMuxerCreation.setOrientationHint(transformationInfo.getRotationDegrees());
                }
                Location location = recordingRecord.getOutputOptions().getLocation();
                if (location != null) {
                    try {
                        Pair<Double, Double> pairAdjustGeoLocation = CorrectNegativeLatLongForMediaMuxer.adjustGeoLocation(location.getLatitude(), location.getLongitude());
                        mediaMuxerPerformOneTimeMediaMuxerCreation.setLocation((float) ((Double) pairAdjustGeoLocation.first).doubleValue(), (float) ((Double) pairAdjustGeoLocation.second).doubleValue());
                    } catch (IllegalArgumentException e) {
                        mediaMuxerPerformOneTimeMediaMuxerCreation.release();
                        onInProgressRecordingInternalError(recordingRecord, 5, e);
                        encodedData.close();
                        return;
                    }
                }
                this.mVideoTrackIndex = Integer.valueOf(mediaMuxerPerformOneTimeMediaMuxerCreation.addTrack(this.mVideoOutputConfig.getMediaFormat()));
                if (isAudioEnabled()) {
                    this.mAudioTrackIndex = Integer.valueOf(mediaMuxerPerformOneTimeMediaMuxerCreation.addTrack(this.mAudioOutputConfig.getMediaFormat()));
                }
                mediaMuxerPerformOneTimeMediaMuxerCreation.start();
                this.mMediaMuxer = mediaMuxerPerformOneTimeMediaMuxerCreation;
                writeVideoData(encodedData, recordingRecord);
                Iterator<EncodedData> it2 = audioDataToWriteAndClearCache.iterator();
                while (it2.hasNext()) {
                    writeAudioData(it2.next(), recordingRecord);
                }
                encodedData.close();
            } catch (IOException e4) {
                onInProgressRecordingInternalError(recordingRecord, 5, e4);
                encodedData.close();
            }
        } catch (Throwable th2) {
            if (encodedData != null) {
                try {
                    encodedData.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @NonNull
    public Recording start(@NonNull PendingRecording pendingRecording) {
        long j8;
        RecordingRecord recordingRecord;
        int i8;
        RecordingRecord recordingRecord2;
        IOException e;
        Preconditions.checkNotNull(pendingRecording, "The given PendingRecording cannot be null.");
        synchronized (this.mLock) {
            try {
                j8 = this.mLastGeneratedRecordingId + 1;
                this.mLastGeneratedRecordingId = j8;
                recordingRecord = null;
                i8 = 0;
                switch (AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()]) {
                    case 1:
                    case 2:
                        recordingRecord2 = this.mActiveRecordingRecord;
                        recordingRecord = recordingRecord2;
                        e = null;
                        break;
                    case 3:
                    case 4:
                        recordingRecord2 = (RecordingRecord) Preconditions.checkNotNull(this.mPendingRecordingRecord);
                        recordingRecord = recordingRecord2;
                        e = null;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        State state = this.mState;
                        State state2 = State.IDLING;
                        if (state == state2) {
                            Preconditions.checkState(this.mActiveRecordingRecord == null && this.mPendingRecordingRecord == null, "Expected recorder to be idle but a recording is either pending or in progress.");
                        }
                        try {
                            RecordingRecord recordingRecordFrom = RecordingRecord.from(pendingRecording, j8);
                            recordingRecordFrom.initializeRecording(pendingRecording.getApplicationContext());
                            this.mPendingRecordingRecord = recordingRecordFrom;
                            State state3 = this.mState;
                            if (state3 == state2) {
                                setState(State.PENDING_RECORDING);
                                final int i9 = 0;
                                this.mSequentialExecutor.execute(new Runnable(this) { // from class: x.c

                                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ Recorder f10799b;

                                    {
                                        this.f10799b = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int i10 = i9;
                                        Recorder recorder = this.f10799b;
                                        switch (i10) {
                                            case 0:
                                                recorder.tryServicePendingRecording();
                                                break;
                                            default:
                                                recorder.lambda$start$2();
                                                break;
                                        }
                                    }
                                });
                            } else if (state3 == State.ERROR) {
                                setState(State.PENDING_RECORDING);
                                final int i10 = 1;
                                this.mSequentialExecutor.execute(new Runnable(this) { // from class: x.c

                                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                                    public final /* synthetic */ Recorder f10799b;

                                    {
                                        this.f10799b = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        int i11 = i10;
                                        Recorder recorder = this.f10799b;
                                        switch (i11) {
                                            case 0:
                                                recorder.tryServicePendingRecording();
                                                break;
                                            default:
                                                recorder.lambda$start$2();
                                                break;
                                        }
                                    }
                                });
                            } else {
                                setState(State.PENDING_RECORDING);
                            }
                            e = null;
                        } catch (IOException e4) {
                            e = e4;
                            i8 = 5;
                        }
                        break;
                    default:
                        e = null;
                        break;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (recordingRecord != null) {
            throw new IllegalStateException("A recording is already in progress. Previous recordings must be stopped before a new recording can be started.");
        }
        if (i8 == 0) {
            return Recording.from(pendingRecording, j8);
        }
        Logger.e(TAG, "Recording was started when the Recorder had encountered error " + e);
        finalizePendingRecording(RecordingRecord.from(pendingRecording, j8), i8, e);
        return Recording.createFinalizedFrom(pendingRecording, j8);
    }

    public void stop(@NonNull Recording recording) {
        synchronized (this.mLock) {
            try {
                if (!isSameRecording(recording, this.mPendingRecordingRecord) && !isSameRecording(recording, this.mActiveRecordingRecord)) {
                    Logger.d(TAG, "stop() called on a recording that is no longer active: " + recording.getOutputOptions());
                    return;
                }
                RecordingRecord recordingRecord = null;
                switch (AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()]) {
                    case 1:
                    case 2:
                        setState(State.STOPPING);
                        final long micros = TimeUnit.NANOSECONDS.toMicros(System.nanoTime());
                        final RecordingRecord recordingRecord2 = this.mActiveRecordingRecord;
                        this.mSequentialExecutor.execute(new Runnable() { // from class: androidx.camera.video.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f1005a.lambda$stop$5(recordingRecord2, micros);
                            }
                        });
                        break;
                    case 3:
                    case 4:
                        Preconditions.checkState(isSameRecording(recording, this.mPendingRecordingRecord));
                        RecordingRecord recordingRecord3 = this.mPendingRecordingRecord;
                        this.mPendingRecordingRecord = null;
                        restoreNonPendingState();
                        recordingRecord = recordingRecord3;
                        break;
                    case 5:
                    case 6:
                        Preconditions.checkState(isSameRecording(recording, this.mActiveRecordingRecord));
                        break;
                    case 7:
                    case 9:
                        throw new IllegalStateException("Calling stop() while idling or initializing is invalid.");
                }
                if (recordingRecord != null) {
                    finalizePendingRecording(recordingRecord, 8, new RuntimeException("Recording was stopped before any data could be produced."));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void stopInternal(@NonNull RecordingRecord recordingRecord, long j8, int i8, @Nullable Throwable th2) {
        if (this.mInProgressRecording != recordingRecord || this.mInProgressRecordingStopping) {
            return;
        }
        this.mInProgressRecordingStopping = true;
        this.mRecordingStopError = i8;
        this.mRecordingStopErrorCause = th2;
        if (isAudioEnabled()) {
            clearPendingAudioRingBuffer();
            this.mAudioEncoder.stop(j8);
        }
        EncodedData encodedData = this.mPendingFirstVideoData;
        if (encodedData != null) {
            encodedData.close();
            this.mPendingFirstVideoData = null;
        }
        if (this.mSourceState != VideoOutput.SourceState.ACTIVE_NON_STREAMING) {
            this.mSourceNonStreamingTimeout = CameraXExecutors.mainThreadExecutor().schedule(new o.e(21, this, this.mVideoEncoder), SOURCE_NON_STREAMING_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        } else {
            notifyEncoderSourceStopped(this.mVideoEncoder);
        }
        this.mVideoEncoder.stop(j8);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    public void tryServicePendingRecording() {
        int i8;
        boolean z2;
        RecordingRecord recordingRecordMakePendingRecordingActiveLocked;
        boolean z3;
        RecordingRecord recordingRecord;
        Exception exc;
        synchronized (this.mLock) {
            try {
                int i9 = AnonymousClass8.$SwitchMap$androidx$camera$video$Recorder$State[this.mState.ordinal()];
                i8 = 4;
                z2 = false;
                i8 = 0;
                recordingRecordMakePendingRecordingActiveLocked = null;
                exc = null;
                recordingRecordMakePendingRecordingActiveLocked = null;
                recordingRecordMakePendingRecordingActiveLocked = null;
                if (i9 != 3) {
                    if (i9 == 4) {
                        z3 = false;
                    }
                    recordingRecord = recordingRecordMakePendingRecordingActiveLocked;
                } else {
                    z3 = true;
                }
                if (this.mActiveRecordingRecord != null || this.mNeedsReset) {
                    i8 = 0;
                    recordingRecord = null;
                    z2 = z3;
                    exc = null;
                } else if (this.mSourceState == VideoOutput.SourceState.INACTIVE) {
                    recordingRecord = this.mPendingRecordingRecord;
                    this.mPendingRecordingRecord = null;
                    restoreNonPendingState();
                    z2 = z3;
                    exc = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
                } else if (this.mVideoEncoder != null) {
                    z2 = z3;
                    recordingRecordMakePendingRecordingActiveLocked = makePendingRecordingActiveLocked(this.mState);
                    recordingRecord = recordingRecordMakePendingRecordingActiveLocked;
                } else {
                    i8 = 0;
                    recordingRecord = null;
                    z2 = z3;
                    exc = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (recordingRecordMakePendingRecordingActiveLocked != null) {
            startRecording(recordingRecordMakePendingRecordingActiveLocked, z2);
        } else if (recordingRecord != null) {
            finalizePendingRecording(recordingRecord, i8, exc);
        }
    }

    public void updateInProgressStatusEvent() {
        RecordingRecord recordingRecord = this.mInProgressRecording;
        if (recordingRecord != null) {
            recordingRecord.updateVideoRecordEvent(VideoRecordEvent.status(recordingRecord.getOutputOptions(), getInProgressRecordingStats()));
        }
    }

    public void writeAudioData(@NonNull EncodedData encodedData, @NonNull RecordingRecord recordingRecord) {
        long size = encodedData.size() + this.mRecordingBytes;
        long j8 = this.mFileSizeLimitInBytes;
        if (j8 != 0 && size > j8) {
            Logger.d(TAG, String.format("Reach file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)));
            onInProgressRecordingInternalError(recordingRecord, 2, null);
            return;
        }
        long presentationTimeUs = encodedData.getPresentationTimeUs();
        long j10 = this.mFirstRecordingAudioDataTimeUs;
        if (j10 == Long.MAX_VALUE) {
            this.mFirstRecordingAudioDataTimeUs = presentationTimeUs;
            Logger.d(TAG, String.format("First audio time: %d (%s)", Long.valueOf(presentationTimeUs), DebugUtils.readableUs(this.mFirstRecordingAudioDataTimeUs)));
        } else {
            TimeUnit timeUnit = TimeUnit.MICROSECONDS;
            long nanos = timeUnit.toNanos(presentationTimeUs - Math.min(this.mFirstRecordingVideoDataTimeUs, j10));
            Preconditions.checkState(this.mPreviousRecordingAudioDataTimeUs != Long.MAX_VALUE, "There should be a previous data for adjusting the duration.");
            long nanos2 = timeUnit.toNanos(presentationTimeUs - this.mPreviousRecordingAudioDataTimeUs) + nanos;
            long j11 = this.mDurationLimitNs;
            if (j11 != 0 && nanos2 > j11) {
                Logger.d(TAG, String.format("Audio data reaches duration limit %d > %d", Long.valueOf(nanos2), Long.valueOf(this.mDurationLimitNs)));
                onInProgressRecordingInternalError(recordingRecord, 9, null);
                return;
            }
        }
        this.mMediaMuxer.writeSampleData(this.mAudioTrackIndex.intValue(), encodedData.getByteBuffer(), encodedData.getBufferInfo());
        this.mRecordingBytes = size;
        this.mPreviousRecordingAudioDataTimeUs = presentationTimeUs;
    }

    public void writeVideoData(@NonNull EncodedData encodedData, @NonNull RecordingRecord recordingRecord) {
        if (this.mVideoTrackIndex == null) {
            throw new AssertionError("Video data comes before the track is added to MediaMuxer.");
        }
        long size = encodedData.size() + this.mRecordingBytes;
        long j8 = this.mFileSizeLimitInBytes;
        long j10 = 0;
        if (j8 != 0 && size > j8) {
            Logger.d(TAG, String.format("Reach file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)));
            onInProgressRecordingInternalError(recordingRecord, 2, null);
            return;
        }
        long presentationTimeUs = encodedData.getPresentationTimeUs();
        long j11 = this.mFirstRecordingVideoDataTimeUs;
        if (j11 == Long.MAX_VALUE) {
            this.mFirstRecordingVideoDataTimeUs = presentationTimeUs;
            Logger.d(TAG, String.format("First video time: %d (%s)", Long.valueOf(presentationTimeUs), DebugUtils.readableUs(this.mFirstRecordingVideoDataTimeUs)));
        } else {
            TimeUnit timeUnit = TimeUnit.MICROSECONDS;
            long nanos = timeUnit.toNanos(presentationTimeUs - Math.min(j11, this.mFirstRecordingAudioDataTimeUs));
            Preconditions.checkState(this.mPreviousRecordingVideoDataTimeUs != Long.MAX_VALUE, "There should be a previous data for adjusting the duration.");
            long nanos2 = timeUnit.toNanos(presentationTimeUs - this.mPreviousRecordingVideoDataTimeUs) + nanos;
            long j12 = this.mDurationLimitNs;
            if (j12 != 0 && nanos2 > j12) {
                Logger.d(TAG, String.format("Video data reaches duration limit %d > %d", Long.valueOf(nanos2), Long.valueOf(this.mDurationLimitNs)));
                onInProgressRecordingInternalError(recordingRecord, 9, null);
                return;
            }
            j10 = nanos;
        }
        this.mMediaMuxer.writeSampleData(this.mVideoTrackIndex.intValue(), encodedData.getByteBuffer(), encodedData.getBufferInfo());
        this.mRecordingBytes = size;
        this.mRecordingDurationNs = j10;
        this.mPreviousRecordingVideoDataTimeUs = presentationTimeUs;
        updateInProgressStatusEvent();
    }

    @Override // androidx.camera.video.VideoOutput
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        synchronized (this.mLock) {
            try {
                Logger.d(TAG, "Surface is requested in state: " + this.mState + ", Current surface: " + this.mStreamId);
                if (this.mState == State.ERROR) {
                    setState(State.CONFIGURING);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.mSequentialExecutor.execute(new x.b(this, surfaceRequest, timebase, 0));
    }

    @NonNull
    @RequiresApi(26)
    public PendingRecording prepareRecording(@NonNull Context context, @NonNull FileDescriptorOutputOptions fileDescriptorOutputOptions) {
        return prepareRecordingInternal(context, fileDescriptorOutputOptions);
    }

    @NonNull
    public PendingRecording prepareRecording(@NonNull Context context, @NonNull MediaStoreOutputOptions mediaStoreOutputOptions) {
        return prepareRecordingInternal(context, mediaStoreOutputOptions);
    }
}
