package x7;

import android.media.AudioPlaybackConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ig.b {
    @Override // ig.b
    public String a(int i10) {
        return (String) cc.a.j(cc.a.g(cc.a.a("android.media.AudioPlaybackConfiguration"), "toLogFriendlyPlayerType", Integer.TYPE), null, Integer.valueOf(i10));
    }

    @Override // ig.b
    public int b(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return ((Integer) cc.a.j(cc.a.g(audioPlaybackConfiguration.getClass(), "getClientUid", new Class[0]), audioPlaybackConfiguration, new Object[0])).intValue();
    }

    @Override // ig.b
    public boolean c(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return ((Boolean) cc.a.j(cc.a.g(audioPlaybackConfiguration.getClass(), "isActive", new Class[0]), audioPlaybackConfiguration, new Object[0])).booleanValue();
    }

    @Override // ig.b
    public int d(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return ((Integer) cc.a.j(cc.a.g(audioPlaybackConfiguration.getClass(), "getPlayerType", new Class[0]), audioPlaybackConfiguration, new Object[0])).intValue();
    }

    @Override // ig.b
    public int e(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return ((Integer) cc.a.j(cc.a.g(audioPlaybackConfiguration.getClass(), "getPlayerInterfaceId", new Class[0]), null, new Object[0])).intValue();
    }

    @Override // ig.b
    public int f(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return ((Integer) cc.a.j(cc.a.g(audioPlaybackConfiguration.getClass(), "getPlayerState", new Class[0]), audioPlaybackConfiguration, new Object[0])).intValue();
    }
}
