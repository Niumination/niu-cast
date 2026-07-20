package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.AudioSource;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class AudioEncoderConfigCamcorderProfileResolver implements Supplier<AudioEncoderConfig> {
    private static final String TAG = "AudioEncCmcrdrPrflRslvr";
    private final int mAudioProfile;
    private final AudioSource.Settings mAudioSourceSettings;
    private final AudioSpec mAudioSpec;
    private final CamcorderProfileProxy mCamcorderProfile;
    private final Timebase mInputTimebase;
    private final String mMimeType;

    public AudioEncoderConfigCamcorderProfileResolver(@NonNull String str, int i8, @NonNull Timebase timebase, @NonNull AudioSpec audioSpec, @NonNull AudioSource.Settings settings, @NonNull CamcorderProfileProxy camcorderProfileProxy) {
        this.mMimeType = str;
        this.mAudioProfile = i8;
        this.mInputTimebase = timebase;
        this.mAudioSpec = audioSpec;
        this.mAudioSourceSettings = settings;
        this.mCamcorderProfile = camcorderProfileProxy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public AudioEncoderConfig get() {
        Logger.d(TAG, "Using resolved AUDIO bitrate from CamcorderProfile");
        return AudioEncoderConfig.builder().setMimeType(this.mMimeType).setProfile(this.mAudioProfile).setInputTimebase(this.mInputTimebase).setChannelCount(this.mAudioSourceSettings.getChannelCount()).setSampleRate(this.mAudioSourceSettings.getSampleRate()).setBitrate(AudioConfigUtil.scaleAndClampBitrate(this.mCamcorderProfile.getAudioBitRate(), this.mAudioSourceSettings.getChannelCount(), this.mCamcorderProfile.getAudioChannels(), this.mAudioSourceSettings.getSampleRate(), this.mCamcorderProfile.getAudioSampleRate(), this.mAudioSpec.getBitrate())).build();
    }
}
