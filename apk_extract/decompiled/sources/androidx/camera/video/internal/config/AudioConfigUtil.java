package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.internal.AudioSource;
import androidx.camera.video.internal.config.AudioConfigUtil;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import o.d;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class AudioConfigUtil {
    static final int AUDIO_CHANNEL_COUNT_DEFAULT = 1;
    static final int AUDIO_SAMPLE_RATE_DEFAULT = 44100;
    static final int AUDIO_SOURCE_DEFAULT = 5;
    static final int AUDIO_SOURCE_FORMAT_DEFAULT = 2;
    private static final String TAG = "AudioConfigUtil";

    private AudioConfigUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$selectSampleRateOrNearestSupported$0(int i8, Integer num, Integer num2) {
        int iAbs = Math.abs(num.intValue() - i8) - Math.abs(num2.intValue() - i8);
        return (int) (iAbs == 0 ? Math.signum(num.intValue() - num2.intValue()) : Math.signum(iAbs));
    }

    @NonNull
    public static AudioEncoderConfig resolveAudioEncoderConfig(@NonNull MimeInfo mimeInfo, @NonNull Timebase timebase, @NonNull AudioSource.Settings settings, @NonNull AudioSpec audioSpec) {
        return (AudioEncoderConfig) (mimeInfo.getCompatibleCamcorderProfile() != null ? new AudioEncoderConfigCamcorderProfileResolver(mimeInfo.getMimeType(), mimeInfo.getProfile(), timebase, audioSpec, settings, mimeInfo.getCompatibleCamcorderProfile()) : new AudioEncoderConfigDefaultResolver(mimeInfo.getMimeType(), mimeInfo.getProfile(), timebase, audioSpec, settings)).get();
    }

    @NonNull
    public static MimeInfo resolveAudioMimeInfo(@NonNull MediaSpec mediaSpec, @Nullable CamcorderProfileProxy camcorderProfileProxy) {
        boolean z2;
        String strOutputFormatToAudioMime = MediaSpec.outputFormatToAudioMime(mediaSpec.getOutputFormat());
        int iOutputFormatToAudioProfile = MediaSpec.outputFormatToAudioProfile(mediaSpec.getOutputFormat());
        if (camcorderProfileProxy != null) {
            String audioCodecMimeType = camcorderProfileProxy.getAudioCodecMimeType();
            int requiredAudioProfile = camcorderProfileProxy.getRequiredAudioProfile();
            if (audioCodecMimeType == null) {
                Logger.d(TAG, "CamcorderProfile contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + strOutputFormatToAudioMime + "(profile: " + iOutputFormatToAudioProfile + ")]");
            } else {
                z2 = true;
                if (mediaSpec.getOutputFormat() == -1) {
                    Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive AUDIO settings [mime type: " + audioCodecMimeType + "(profile: " + requiredAudioProfile + ")]");
                } else if (Objects.equals(strOutputFormatToAudioMime, audioCodecMimeType) && iOutputFormatToAudioProfile == requiredAudioProfile) {
                    Logger.d(TAG, "MediaSpec audio mime/profile matches CamcorderProfile. Using CamcorderProfile to derive AUDIO settings [mime type: " + audioCodecMimeType + "(profile: " + requiredAudioProfile + ")]");
                } else {
                    Logger.d(TAG, "MediaSpec audio mime or profile does not match CamcorderProfile, so CamcorderProfile settings cannot be used. May rely on fallback defaults to derive AUDIO settings [CamcorderProfile mime type: " + audioCodecMimeType + "(profile: " + requiredAudioProfile + "), chosen mime type: " + strOutputFormatToAudioMime + "(profile: " + iOutputFormatToAudioProfile + ")]");
                }
                strOutputFormatToAudioMime = audioCodecMimeType;
                iOutputFormatToAudioProfile = requiredAudioProfile;
            }
            z2 = false;
        } else {
            z2 = false;
        }
        MimeInfo.Builder profile = MimeInfo.builder(strOutputFormatToAudioMime).setProfile(iOutputFormatToAudioProfile);
        if (z2) {
            profile.setCompatibleCamcorderProfile(camcorderProfileProxy);
        }
        return profile.build();
    }

    public static int resolveAudioSource(@NonNull AudioSpec audioSpec) {
        int source = audioSpec.getSource();
        if (source == -1) {
            Logger.d(TAG, "Using default AUDIO source: 5");
            return 5;
        }
        Logger.d(TAG, "Using provided AUDIO source: " + source);
        return source;
    }

    public static int resolveAudioSourceFormat(@NonNull AudioSpec audioSpec) {
        int sourceFormat = audioSpec.getSourceFormat();
        if (sourceFormat == -1) {
            Logger.d(TAG, "Using default AUDIO source format: 2");
            return 2;
        }
        Logger.d(TAG, "Using provided AUDIO source format: " + sourceFormat);
        return sourceFormat;
    }

    @NonNull
    public static AudioSource.Settings resolveAudioSourceSettings(@NonNull MimeInfo mimeInfo, @NonNull AudioSpec audioSpec) {
        return (AudioSource.Settings) (mimeInfo.getCompatibleCamcorderProfile() != null ? new AudioSourceSettingsCamcorderProfileResolver(audioSpec, mimeInfo.getCompatibleCamcorderProfile()) : new AudioSourceSettingsDefaultResolver(audioSpec)).get();
    }

    public static int scaleAndClampBitrate(int i8, int i9, int i10, int i11, int i12, Range<Integer> range) {
        Rational rational = new Rational(i9, i10);
        int iDoubleValue = (int) (new Rational(i11, i12).doubleValue() * rational.doubleValue() * ((double) i8));
        String strConcat = Logger.isDebugEnabled(TAG) ? String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(iDoubleValue)) : "";
        if (!AudioSpec.BITRATE_RANGE_AUTO.equals(range)) {
            Integer num = (Integer) range.clamp(Integer.valueOf(iDoubleValue));
            iDoubleValue = num.intValue();
            if (Logger.isDebugEnabled(TAG)) {
                strConcat = strConcat.concat(String.format("\nClamped to range %s -> %dbps", range, num));
            }
        }
        Logger.d(TAG, strConcat);
        return iDoubleValue;
    }

    public static int selectSampleRateOrNearestSupported(@NonNull Range<Integer> range, int i8, int i9, final int i10) {
        ArrayList arrayList = null;
        int i11 = 0;
        int iIntValue = i10;
        while (true) {
            if (!range.contains(Integer.valueOf(iIntValue))) {
                Logger.d(TAG, "Sample rate " + iIntValue + "Hz is not in target range " + range);
            } else {
                if (AudioSource.isSettingsSupported(iIntValue, i8, i9)) {
                    return iIntValue;
                }
                StringBuilder sbR = d.r(iIntValue, i8, "Sample rate ", "Hz is not supported by audio source with channel count ", " and source format ");
                sbR.append(i9);
                Logger.d(TAG, sbR.toString());
            }
            if (arrayList == null) {
                Logger.d(TAG, "Trying common sample rates in proximity order to target " + i10 + "Hz");
                arrayList = new ArrayList(AudioSource.COMMON_SAMPLE_RATES);
                Collections.sort(arrayList, new Comparator() { // from class: z.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return AudioConfigUtil.lambda$selectSampleRateOrNearestSupported$0(i10, (Integer) obj, (Integer) obj2);
                    }
                });
            }
            if (i11 >= arrayList.size()) {
                Logger.d(TAG, "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
                return AUDIO_SAMPLE_RATE_DEFAULT;
            }
            iIntValue = ((Integer) arrayList.get(i11)).intValue();
            i11++;
        }
    }
}
