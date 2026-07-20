package x6;

import android.content.pm.PackageInstaller;

/* JADX INFO: loaded from: classes2.dex */
public class c implements jf.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20078a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f20079b = cc.a.a("android.content.pm.PackageInstaller$SessionParams");

    @Override // jf.c
    public void a(PackageInstaller.SessionParams sessionParams, boolean z10) {
        cc.a.j(cc.a.g(f20079b, "setDontKillApp", Boolean.TYPE), sessionParams, Boolean.valueOf(z10));
    }
}
