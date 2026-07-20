package androidx.camera.video.internal;

import a0.g;
import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.compat.Api23Impl;
import androidx.camera.video.internal.compat.Api24Impl;
import androidx.camera.video.internal.compat.Api29Impl;
import androidx.camera.video.internal.compat.Api31Impl;
import androidx.camera.video.internal.compat.quirk.AudioTimestampFramePositionIncorrectQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.encoder.InputBuffer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import m4.l;
import o.e;
import xc.b;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class AudioSource {
    public static final List<Integer> COMMON_SAMPLE_RATES = Collections.unmodifiableList(Arrays.asList(48000, 44100, 22050, 11025, 8000, 4800));
    private static final String TAG = "AudioSource";
    private FutureCallback<InputBuffer> mAcquireBufferCallback;
    final AudioRecord mAudioRecord;
    private AudioManager.AudioRecordingCallback mAudioRecordingCallback;
    AudioSourceCallback mAudioSourceCallback;
    BufferProvider<InputBuffer> mBufferProvider;
    final int mBufferSize;
    final int mBytesPerFrame;
    Executor mCallbackExecutor;
    final Executor mExecutor;
    boolean mIsSendingAudio;
    final int mSampleRate;
    private Observable.Observer<BufferProvider.State> mStateObserver;
    AtomicBoolean mSourceSilence = new AtomicBoolean(false);
    long mTotalFramesRead = 0;
    InternalState mState = InternalState.CONFIGURED;
    BufferProvider.State mBufferProviderState = BufferProvider.State.INACTIVE;

    /* JADX INFO: renamed from: androidx.camera.video.internal.AudioSource$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$video$internal$AudioSource$InternalState;

        static {
            int[] iArr = new int[InternalState.values().length];
            $SwitchMap$androidx$camera$video$internal$AudioSource$InternalState = iArr;
            try {
                iArr[InternalState.CONFIGURED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$AudioSource$InternalState[InternalState.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$camera$video$internal$AudioSource$InternalState[InternalState.RELEASED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @RequiresApi(29)
    public class AudioRecordingApi29Callback extends AudioManager.AudioRecordingCallback {
        public AudioRecordingApi29Callback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRecordingConfigChanged$0(boolean z2) {
            AudioSource.this.mAudioSourceCallback.onSilenced(z2);
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            super.onRecordingConfigChanged(list);
            AudioSource audioSource = AudioSource.this;
            if (audioSource.mCallbackExecutor == null || audioSource.mAudioSourceCallback == null) {
                return;
            }
            for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
                if (Api24Impl.getClientAudioSessionId(audioRecordingConfiguration) == AudioSource.this.mAudioRecord.getAudioSessionId()) {
                    final boolean zIsClientSilenced = Api29Impl.isClientSilenced(audioRecordingConfiguration);
                    if (AudioSource.this.mSourceSilence.getAndSet(zIsClientSilenced) != zIsClientSilenced) {
                        AudioSource.this.mCallbackExecutor.execute(new Runnable() { // from class: androidx.camera.video.internal.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f1015a.lambda$onRecordingConfigChanged$0(zIsClientSilenced);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
        }
    }

    public interface AudioSourceCallback {
        void onError(@NonNull Throwable th2);

        void onSilenced(boolean z2);
    }

    public enum InternalState {
        CONFIGURED,
        STARTED,
        RELEASED
    }

    public static abstract class Settings {

        public static abstract class Builder {
            public abstract Settings autoBuild();

            @NonNull
            public final Settings build() {
                Settings settingsAutoBuild = autoBuild();
                String strB = settingsAutoBuild.getAudioSource() == -1 ? " audioSource" : "";
                if (settingsAutoBuild.getSampleRate() <= 0) {
                    strB = h0.a.B(strB, " sampleRate");
                }
                if (settingsAutoBuild.getChannelCount() <= 0) {
                    strB = h0.a.B(strB, " channelCount");
                }
                if (settingsAutoBuild.getAudioFormat() == -1) {
                    strB = h0.a.B(strB, " audioFormat");
                }
                if (strB.isEmpty()) {
                    return settingsAutoBuild;
                }
                throw new IllegalArgumentException("Required settings missing or non-positive:".concat(strB));
            }

            @NonNull
            public abstract Builder setAudioFormat(int i8);

            @NonNull
            public abstract Builder setAudioSource(int i8);

            @NonNull
            public abstract Builder setChannelCount(@IntRange(from = 1) int i8);

            @NonNull
            public abstract Builder setSampleRate(@IntRange(from = 1) int i8);
        }

        @NonNull
        public static Builder builder() {
            return new AutoValue_AudioSource_Settings.Builder().setAudioSource(-1).setSampleRate(-1).setChannelCount(-1).setAudioFormat(-1);
        }

        public abstract int getAudioFormat();

        public abstract int getAudioSource();

        @IntRange(from = 1)
        public abstract int getChannelCount();

        @IntRange(from = 1)
        public abstract int getSampleRate();

        @NonNull
        public abstract Builder toBuilder();
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    public AudioSource(@NonNull Settings settings, @NonNull Executor executor, @Nullable Context context) throws AudioSourceAccessException {
        if (!isSettingsSupported(settings.getSampleRate(), settings.getChannelCount(), settings.getAudioFormat())) {
            throw new UnsupportedOperationException(String.format("The combination of sample rate %d, channel count %d and audio format %d is not supported.", Integer.valueOf(settings.getSampleRate()), Integer.valueOf(settings.getChannelCount()), Integer.valueOf(settings.getAudioFormat())));
        }
        int minBufferSize = getMinBufferSize(settings.getSampleRate(), settings.getChannelCount(), settings.getAudioFormat());
        Preconditions.checkState(minBufferSize > 0);
        Executor executorNewSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = executorNewSequentialExecutor;
        int i8 = minBufferSize * 2;
        this.mBufferSize = i8;
        this.mSampleRate = settings.getSampleRate();
        try {
            this.mBytesPerFrame = getBytesPerFrame(settings.getAudioFormat(), settings.getChannelCount());
            AudioFormat audioFormatBuild = new AudioFormat.Builder().setSampleRate(settings.getSampleRate()).setChannelMask(channelCountToChannelMask(settings.getChannelCount())).setEncoding(settings.getAudioFormat()).build();
            AudioRecord.Builder builderCreateAudioRecordBuilder = Api23Impl.createAudioRecordBuilder();
            if (context != null) {
                Api31Impl.setContext(builderCreateAudioRecordBuilder, context);
            }
            Api23Impl.setAudioSource(builderCreateAudioRecordBuilder, settings.getAudioSource());
            Api23Impl.setAudioFormat(builderCreateAudioRecordBuilder, audioFormatBuild);
            Api23Impl.setBufferSizeInBytes(builderCreateAudioRecordBuilder, i8);
            AudioRecord audioRecordBuild = Api23Impl.build(builderCreateAudioRecordBuilder);
            this.mAudioRecord = audioRecordBuild;
            if (audioRecordBuild.getState() != 1) {
                audioRecordBuild.release();
                throw new AudioSourceAccessException("Unable to initialize AudioRecord");
            }
            AudioRecordingApi29Callback audioRecordingApi29Callback = new AudioRecordingApi29Callback();
            this.mAudioRecordingCallback = audioRecordingApi29Callback;
            Api29Impl.registerAudioRecordingCallback(audioRecordBuild, executorNewSequentialExecutor, audioRecordingApi29Callback);
        } catch (IllegalArgumentException e) {
            throw new AudioSourceAccessException("Unable to create AudioRecord", e);
        }
    }

    private static int channelCountToChannelConfig(int i8) {
        return i8 == 1 ? 16 : 12;
    }

    private static int channelCountToChannelMask(int i8) {
        return i8 == 1 ? 16 : 12;
    }

    private static long computeInterpolatedTimeUs(int i8, long j8, @NonNull AudioTimestamp audioTimestamp) {
        long nanos = audioTimestamp.nanoTime + ((TimeUnit.SECONDS.toNanos(1L) * (j8 - audioTimestamp.framePosition)) / ((long) i8));
        if (nanos < 0) {
            return 0L;
        }
        return TimeUnit.NANOSECONDS.toMicros(nanos);
    }

    private static int getBytesPerFrame(int i8, int i9) {
        Preconditions.checkState(i9 > 0);
        if (i8 == 2) {
            return i9 * 2;
        }
        if (i8 == 3) {
            return i9;
        }
        if (i8 != 4) {
            if (i8 == 21) {
                return i9 * 3;
            }
            if (i8 != 22) {
                throw new IllegalArgumentException(a1.a.o(i8, "Invalid audio format: "));
            }
        }
        return i9 * 4;
    }

    private static int getMinBufferSize(int i8, int i9, int i10) {
        return AudioRecord.getMinBufferSize(i8, channelCountToChannelConfig(i9), i10);
    }

    private static boolean hasAudioTimestampQuirk() {
        return DeviceQuirks.get(AudioTimestampFramePositionIncorrectQuirk.class) != null;
    }

    public static boolean isSettingsSupported(int i8, int i9, int i10) {
        return i8 > 0 && i9 > 0 && getMinBufferSize(i8, i9, i10) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyError$6(Throwable th2) {
        this.mAudioSourceCallback.onError(th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$3(CallbackToFutureAdapter.Completer completer) {
        try {
            int i8 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$AudioSource$InternalState[this.mState.ordinal()];
            if (i8 == 1 || i8 == 2) {
                resetBufferProvider(null);
                Api29Impl.unregisterAudioRecordingCallback(this.mAudioRecord, this.mAudioRecordingCallback);
                this.mAudioRecord.release();
                stopSendingAudio();
                setState(InternalState.RELEASED);
            }
            completer.set(null);
        } catch (Throwable th2) {
            completer.setException(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$release$4(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new e(25, this, completer));
        return "AudioSource-release";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAudioSourceCallback$5(Executor executor, AudioSourceCallback audioSourceCallback) {
        int i8 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$AudioSource$InternalState[this.mState.ordinal()];
        if (i8 == 1) {
            this.mCallbackExecutor = executor;
            this.mAudioSourceCallback = audioSourceCallback;
        } else if (i8 == 2 || i8 == 3) {
            throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setBufferProvider$0(BufferProvider bufferProvider) {
        int i8 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$AudioSource$InternalState[this.mState.ordinal()];
        if (i8 != 1 && i8 != 2) {
            if (i8 == 3) {
                throw new AssertionError("AudioRecorder is released");
            }
        } else if (this.mBufferProvider != bufferProvider) {
            resetBufferProvider(bufferProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1() {
        int i8 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$AudioSource$InternalState[this.mState.ordinal()];
        if (i8 != 1) {
            if (i8 == 3) {
                throw new AssertionError("AudioRecorder is released");
            }
        } else {
            setState(InternalState.STARTED);
            updateSendingAudio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$2() {
        int i8 = AnonymousClass3.$SwitchMap$androidx$camera$video$internal$AudioSource$InternalState[this.mState.ordinal()];
        if (i8 == 2) {
            setState(InternalState.CONFIGURED);
            updateSendingAudio();
        } else {
            if (i8 != 3) {
                return;
            }
            Logger.w(TAG, "AudioRecorder is released. Calling stop() is a no-op.");
        }
    }

    private void resetBufferProvider(@Nullable final BufferProvider<InputBuffer> bufferProvider) {
        BufferProvider<InputBuffer> bufferProvider2 = this.mBufferProvider;
        if (bufferProvider2 != null) {
            bufferProvider2.removeObserver(this.mStateObserver);
            this.mBufferProvider = null;
            this.mStateObserver = null;
            this.mAcquireBufferCallback = null;
        }
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        updateSendingAudio();
        if (bufferProvider != null) {
            this.mBufferProvider = bufferProvider;
            this.mStateObserver = new Observable.Observer<BufferProvider.State>() { // from class: androidx.camera.video.internal.AudioSource.1
                @Override // androidx.camera.core.impl.Observable.Observer
                public void onError(@NonNull Throwable th2) {
                    AudioSource audioSource = AudioSource.this;
                    if (audioSource.mBufferProvider == bufferProvider) {
                        audioSource.notifyError(th2);
                    }
                }

                @Override // androidx.camera.core.impl.Observable.Observer
                public void onNewData(@Nullable BufferProvider.State state) {
                    if (AudioSource.this.mBufferProvider == bufferProvider) {
                        Logger.d(AudioSource.TAG, "Receive BufferProvider state change: " + AudioSource.this.mBufferProviderState + " to " + state);
                        AudioSource audioSource = AudioSource.this;
                        audioSource.mBufferProviderState = state;
                        audioSource.updateSendingAudio();
                    }
                }
            };
            this.mAcquireBufferCallback = new FutureCallback<InputBuffer>() { // from class: androidx.camera.video.internal.AudioSource.2
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(@NonNull Throwable th2) {
                    if (AudioSource.this.mBufferProvider != bufferProvider) {
                        Logger.d(AudioSource.TAG, "Unable to get input buffer, the BufferProvider could be transitioning to INACTIVE state.");
                        AudioSource.this.notifyError(th2);
                    }
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(InputBuffer inputBuffer) {
                    AudioSource audioSource = AudioSource.this;
                    if (!audioSource.mIsSendingAudio || audioSource.mBufferProvider != bufferProvider) {
                        inputBuffer.cancel();
                        return;
                    }
                    ByteBuffer byteBuffer = inputBuffer.getByteBuffer();
                    AudioSource audioSource2 = AudioSource.this;
                    int i8 = audioSource2.mAudioRecord.read(byteBuffer, audioSource2.mBufferSize);
                    if (i8 > 0) {
                        byteBuffer.limit(i8);
                        inputBuffer.setPresentationTimeUs(AudioSource.this.generatePresentationTimeUs());
                        inputBuffer.submit();
                        AudioSource audioSource3 = AudioSource.this;
                        audioSource3.mTotalFramesRead += (long) (i8 / audioSource3.mBytesPerFrame);
                    } else {
                        Logger.w(AudioSource.TAG, "Unable to read data from AudioRecord.");
                        inputBuffer.cancel();
                    }
                    AudioSource.this.sendNextAudio();
                }
            };
            this.mBufferProvider.addObserver(this.mExecutor, this.mStateObserver);
        }
    }

    private void startSendingAudio() {
        if (this.mIsSendingAudio) {
            return;
        }
        try {
            Logger.d(TAG, "startSendingAudio");
            this.mAudioRecord.startRecording();
            if (this.mAudioRecord.getRecordingState() != 3) {
                throw new IllegalStateException("Unable to start AudioRecord with state: " + this.mAudioRecord.getRecordingState());
            }
            this.mTotalFramesRead = 0L;
            this.mIsSendingAudio = true;
            sendNextAudio();
        } catch (IllegalStateException e) {
            Logger.w(TAG, "Failed to start AudioRecord", e);
            setState(InternalState.CONFIGURED);
            notifyError(new AudioSourceAccessException("Unable to start the audio record.", e));
        }
    }

    private void stopSendingAudio() {
        if (this.mIsSendingAudio) {
            this.mIsSendingAudio = false;
            try {
                Logger.d(TAG, "stopSendingAudio");
                this.mAudioRecord.stop();
                if (this.mAudioRecord.getRecordingState() == 1) {
                    return;
                }
                throw new IllegalStateException("Unable to stop AudioRecord with state: " + this.mAudioRecord.getRecordingState());
            } catch (IllegalStateException e) {
                Logger.w(TAG, "Failed to stop AudioRecord", e);
                notifyError(e);
            }
        }
    }

    public long generatePresentationTimeUs() {
        long jComputeInterpolatedTimeUs;
        if (hasAudioTimestampQuirk()) {
            jComputeInterpolatedTimeUs = -1;
        } else {
            AudioTimestamp audioTimestamp = new AudioTimestamp();
            if (Api24Impl.getTimestamp(this.mAudioRecord, audioTimestamp, 0) == 0) {
                jComputeInterpolatedTimeUs = computeInterpolatedTimeUs(this.mSampleRate, this.mTotalFramesRead, audioTimestamp);
            } else {
                Logger.w(TAG, "Unable to get audio timestamp");
                jComputeInterpolatedTimeUs = -1;
            }
        }
        return jComputeInterpolatedTimeUs == -1 ? TimeUnit.NANOSECONDS.toMicros(System.nanoTime()) : jComputeInterpolatedTimeUs;
    }

    public void notifyError(Throwable th2) {
        Executor executor = this.mCallbackExecutor;
        if (executor == null || this.mAudioSourceCallback == null) {
            return;
        }
        executor.execute(new e(27, this, th2));
    }

    @NonNull
    public l release() {
        return CallbackToFutureAdapter.getFuture(new b(this));
    }

    public void sendNextAudio() {
        Futures.addCallback(this.mBufferProvider.acquireBuffer(), this.mAcquireBufferCallback, this.mExecutor);
    }

    public void setAudioSourceCallback(@NonNull Executor executor, @NonNull AudioSourceCallback audioSourceCallback) {
        this.mExecutor.execute(new g(this, 27, executor, audioSourceCallback));
    }

    public void setBufferProvider(@NonNull BufferProvider<InputBuffer> bufferProvider) {
        this.mExecutor.execute(new e(26, this, bufferProvider));
    }

    public void setState(InternalState internalState) {
        Logger.d(TAG, "Transitioning internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
    }

    public void start() {
        this.mExecutor.execute(new y.a(this, 0));
    }

    public void stop() {
        this.mExecutor.execute(new y.a(this, 1));
    }

    public void updateSendingAudio() {
        if (this.mState == InternalState.STARTED && this.mBufferProviderState == BufferProvider.State.ACTIVE) {
            startSendingAudio();
        } else {
            stopSendingAudio();
        }
    }
}
