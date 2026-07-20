package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.AudioSource;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class AudioSourceSettingsDefaultResolver implements Supplier<AudioSource.Settings> {
    private static final String TAG = "DefAudioSrcResolver";
    private final AudioSpec mAudioSpec;

    public AudioSourceSettingsDefaultResolver(@NonNull AudioSpec audioSpec) {
        this.mAudioSpec = audioSpec;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public AudioSource.Settings get() {
        int iSelectSampleRateOrNearestSupported;
        int iResolveAudioSource = AudioConfigUtil.resolveAudioSource(this.mAudioSpec);
        int iResolveAudioSourceFormat = AudioConfigUtil.resolveAudioSourceFormat(this.mAudioSpec);
        int channelCount = this.mAudioSpec.getChannelCount();
        if (channelCount == -1) {
            Logger.d(TAG, "Using fallback AUDIO channel count: 1");
            channelCount = 1;
        } else {
            Logger.d(TAG, "Using supplied AUDIO channel count: " + channelCount);
        }
        Range<Integer> sampleRate = this.mAudioSpec.getSampleRate();
        if (AudioSpec.SAMPLE_RATE_RANGE_AUTO.equals(sampleRate)) {
            Logger.d(TAG, "Using fallback AUDIO sample rate: 44100Hz");
            iSelectSampleRateOrNearestSupported = 44100;
        } else {
            iSelectSampleRateOrNearestSupported = AudioConfigUtil.selectSampleRateOrNearestSupported(sampleRate, channelCount, iResolveAudioSourceFormat, ((Integer) sampleRate.getUpper()).intValue());
            Logger.d(TAG, "Using AUDIO sample rate resolved from AudioSpec: " + iSelectSampleRateOrNearestSupported + "Hz");
        }
        return AudioSource.Settings.builder().setAudioSource(iResolveAudioSource).setAudioFormat(iResolveAudioSourceFormat).setChannelCount(channelCount).setSampleRate(iSelectSampleRateOrNearestSupported).build();
    }
}
