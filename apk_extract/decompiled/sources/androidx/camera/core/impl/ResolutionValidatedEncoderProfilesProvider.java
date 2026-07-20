package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class ResolutionValidatedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final EncoderProfilesResolutionValidator mEncoderProfilesResolutionValidator;
    private final EncoderProfilesProvider mProvider;

    public ResolutionValidatedEncoderProfilesProvider(@NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull Quirks quirks) {
        this.mProvider = encoderProfilesProvider;
        this.mEncoderProfilesResolutionValidator = new EncoderProfilesResolutionValidator(quirks.getAll(ProfileResolutionQuirk.class));
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    @Nullable
    public EncoderProfilesProxy getAll(int i8) {
        if (!this.mProvider.hasProfile(i8)) {
            return null;
        }
        EncoderProfilesProxy all = this.mProvider.getAll(i8);
        return this.mEncoderProfilesResolutionValidator.hasQuirk() ? this.mEncoderProfilesResolutionValidator.filterInvalidVideoResolution(all) : all;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i8) {
        if (!this.mProvider.hasProfile(i8)) {
            return false;
        }
        if (!this.mEncoderProfilesResolutionValidator.hasQuirk()) {
            return true;
        }
        return this.mEncoderProfilesResolutionValidator.hasValidVideoResolution(this.mProvider.getAll(i8));
    }
}
