package od;

import android.media.AudioRecordingConfiguration;
import com.transsion.hubsdk.media.TranAudioRecordingConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class b1 implements ig.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12178b = "b1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranAudioRecordingConfiguration f12179a = new TranAudioRecordingConfiguration();

    @Override // ig.d
    public String a(AudioRecordingConfiguration audioRecordingConfiguration) {
        return TranAudioRecordingConfiguration.toLogFriendlyString(audioRecordingConfiguration);
    }

    @Override // ig.d
    public String b(AudioRecordingConfiguration audioRecordingConfiguration) {
        return this.f12179a.getClientPackageName(audioRecordingConfiguration);
    }
}
