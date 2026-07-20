package qc;

import android.content.pm.PackageInstaller;
import com.transsion.hubsdk.content.pm.TranPackageInstaller;

/* JADX INFO: loaded from: classes2.dex */
public class c implements jf.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranPackageInstaller f13904a = new TranPackageInstaller();

    @Override // jf.c
    public void a(PackageInstaller.SessionParams sessionParams, boolean z10) {
        this.f13904a.setDontKillApp(sessionParams, z10);
    }
}
