package androidx.camera.video;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Recorder f1000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Recorder.RecordingRecord f1001c;

    public /* synthetic */ b(Recorder recorder, Recorder.RecordingRecord recordingRecord, int i8) {
        this.f999a = i8;
        this.f1000b = recorder;
        this.f1001c = recordingRecord;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f999a) {
            case 0:
                this.f1000b.lambda$resume$4(this.f1001c);
                break;
            default:
                this.f1000b.lambda$pause$3(this.f1001c);
                break;
        }
    }
}
