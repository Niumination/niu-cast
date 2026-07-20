package y;

import androidx.camera.video.internal.AudioSource;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioSource f11021b;

    public /* synthetic */ a(AudioSource audioSource, int i8) {
        this.f11020a = i8;
        this.f11021b = audioSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f11020a;
        AudioSource audioSource = this.f11021b;
        switch (i8) {
            case 0:
                audioSource.lambda$start$1();
                break;
            default:
                audioSource.lambda$stop$2();
                break;
        }
    }
}
