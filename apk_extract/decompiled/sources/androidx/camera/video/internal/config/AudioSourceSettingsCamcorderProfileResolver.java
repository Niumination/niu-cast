package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.AudioSource;
import androidx.core.util.Supplier;
import o.d;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class AudioSourceSettingsCamcorderProfileResolver implements Supplier<AudioSource.Settings> {
    private static final String TAG = "AudioSrcCmcrdrPrflRslvr";
    private final AudioSpec mAudioSpec;
    private final CamcorderProfileProxy mCamcorderProfile;

    public AudioSourceSettingsCamcorderProfileResolver(@NonNull AudioSpec audioSpec, @NonNull CamcorderProfileProxy camcorderProfileProxy) {
        this.mAudioSpec = audioSpec;
        this.mCamcorderProfile = camcorderProfileProxy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public AudioSource.Settings get() {
        int iResolveAudioSource = AudioConfigUtil.resolveAudioSource(this.mAudioSpec);
        int iResolveAudioSourceFormat = AudioConfigUtil.resolveAudioSourceFormat(this.mAudioSpec);
        int channelCount = this.mAudioSpec.getChannelCount();
        Range<Integer> sampleRate = this.mAudioSpec.getSampleRate();
        int audioChannels = this.mCamcorderProfile.getAudioChannels();
        if (channelCount == -1) {
            Logger.d(TAG, "Resolved AUDIO channel count from CamcorderProfile: " + audioChannels);
            channelCount = audioChannels;
        } else {
            Logger.d(TAG, d.g(audioChannels, channelCount, "Media spec AUDIO channel count overrides CamcorderProfile [CamcorderProfile channel count: ", ", Resolved Channel Count: ", "]"));
        }
        int audioSampleRate = this.mCamcorderProfile.getAudioSampleRate();
        int iSelectSampleRateOrNearestSupported = AudioConfigUtil.selectSampleRateOrNearestSupported(sampleRate, channelCount, iResolveAudioSourceFormat, audioSampleRate);
        Logger.d(TAG, d.g(iSelectSampleRateOrNearestSupported, audioSampleRate, "Using resolved AUDIO sample rate or nearest supported from CamcorderProfile: ", "Hz. [CamcorderProfile sample rate: ", "Hz]"));
        return AudioSource.Settings.builder().setAudioSource(iResolveAudioSource).setAudioFormat(iResolveAudioSourceFormat).setChannelCount(channelCount).setSampleRate(iSelectSampleRateOrNearestSupported).build();
    }
}
