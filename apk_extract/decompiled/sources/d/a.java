package d;

import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.profileinstaller.ProfileInstaller;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f4252b;

    public /* synthetic */ a(Context context, int i8) {
        this.f4251a = i8;
        this.f4252b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f4251a;
        Context context = this.f4252b;
        switch (i8) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(context);
                break;
            case 1:
                AppCompatDelegate.syncRequestedAndStoredLocales(context);
                break;
            case 2:
                ProfileInstallerInitializer.writeInBackground(context);
                break;
            default:
                ProfileInstaller.writeProfile(context);
                break;
        }
    }
}
