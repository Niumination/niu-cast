package oa;

import android.media.AudioPlaybackConfiguration;
import od.z0;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z0 f12121a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static x7.c f12122b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12123c = 2;

    public static ig.b e(String str) {
        if (fc.b.b(str)) {
            z0 z0Var = f12121a;
            if (z0Var != null) {
                return z0Var;
            }
            z0 z0Var2 = new z0();
            f12121a = z0Var2;
            return z0Var2;
        }
        x7.c cVar = f12122b;
        if (cVar != null) {
            return cVar;
        }
        x7.c cVar2 = new x7.c();
        f12122b = cVar2;
        return cVar2;
    }

    public static String g(int i10) {
        return e(fc.b.a.f5986f).a(i10);
    }

    public int a(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return e(fc.b.a.f5984d).b(audioPlaybackConfiguration);
    }

    public int b(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return e(fc.b.a.f5986f).e(audioPlaybackConfiguration);
    }

    public int c(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return e(fc.b.a.f5986f).f(audioPlaybackConfiguration);
    }

    public int d(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return e(fc.b.a.f5986f).d(audioPlaybackConfiguration);
    }

    public boolean f(AudioPlaybackConfiguration audioPlaybackConfiguration) {
        return e(fc.b.a.f5984d).c(audioPlaybackConfiguration);
    }
}
