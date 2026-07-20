package x7;

import android.media.AudioRecordingConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class e implements ig.d {
    @Override // ig.d
    public String a(AudioRecordingConfiguration audioRecordingConfiguration) {
        return (String) cc.a.j(cc.a.g(audioRecordingConfiguration.getClass(), "toLogFriendlyString", new Class[0]), null, new Object[0]);
    }

    @Override // ig.d
    public String b(AudioRecordingConfiguration audioRecordingConfiguration) {
        return (String) cc.a.j(cc.a.g(audioRecordingConfiguration.getClass(), "getClientPackageName", new Class[0]), audioRecordingConfiguration, new Object[0]);
    }
}
