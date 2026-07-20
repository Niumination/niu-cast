package androidx.window.core;

import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class BuildConfig {

    @l
    public static final BuildConfig INSTANCE = new BuildConfig();

    @l
    private static final SpecificationComputer.VerificationMode verificationMode = SpecificationComputer.VerificationMode.QUIET;

    private BuildConfig() {
    }

    @l
    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return verificationMode;
    }
}
