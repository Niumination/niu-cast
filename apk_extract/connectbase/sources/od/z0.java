package od;

import android.media.AudioPlaybackConfiguration;
import com.transsion.hubsdk.media.TranAudioPlaybackConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class z0 implements ig.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12274b = "z0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranAudioPlaybackConfiguration f12275a = new TranAudioPlaybackConfiguration();

    @Override // ig.b
    public String a(int i10) {
        return TranAudioPlaybackConfiguration.toLogFriendlyPlayerType(i10);
    }

    @Override // ig.b
    public int b(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return this.f12275a.getClientUid(audioPlaybackConfiguration);
    }

    @Override // ig.b
    public boolean c(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return this.f12275a.isActive(audioPlaybackConfiguration);
    }

    @Override // ig.b
    public int d(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return this.f12275a.getPlayerType(audioPlaybackConfiguration);
    }

    @Override // ig.b
    public int e(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return this.f12275a.getPlayerInterfaceId(audioPlaybackConfiguration);
    }

    @Override // ig.b
    public int f(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return this.f12275a.getPlayerState(audioPlaybackConfiguration);
    }
}
