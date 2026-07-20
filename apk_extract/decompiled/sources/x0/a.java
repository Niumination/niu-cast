package x0;

import androidx.profileinstaller.ProfileInstaller;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f10803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10805d;

    public /* synthetic */ a(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i8, Object obj, int i9) {
        this.f10802a = i9;
        this.f10803b = diagnosticsCallback;
        this.f10804c = i8;
        this.f10805d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10802a) {
            case 0:
                this.f10803b.onResultReceived(this.f10804c, this.f10805d);
                break;
            default:
                this.f10803b.onDiagnosticReceived(this.f10804c, this.f10805d);
                break;
        }
    }
}
