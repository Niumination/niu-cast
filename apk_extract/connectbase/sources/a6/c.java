package a6;

import com.transsion.connectx.sdk.AudioConfig;
import com.transsion.connectx.sdk.VideoConfig;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static q4.a a(AudioConfig audioConfig) {
        return new q4.a(audioConfig.getSampleRate(), audioConfig.getChannelConfig(), audioConfig.getAudioFormat(), audioConfig.getEncodeType());
    }

    public static r4.d b(VideoConfig videoConfig) {
        return new r4.d(videoConfig.getName(), videoConfig.getWidth(), videoConfig.getHeight(), videoConfig.getDpi(), videoConfig.getBitrate(), videoConfig.getFrameRate(), videoConfig.getIFrameInterval(), videoConfig.getEncodeType(), videoConfig.getOrientation());
    }
}
