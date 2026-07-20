package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class UseCaseGroup {

    @NonNull
    private final List<CameraEffect> mEffects;

    @NonNull
    private final List<UseCase> mUseCases;

    @Nullable
    private final ViewPort mViewPort;

    public static final class Builder {
        private static final List<Integer> SUPPORTED_TARGETS = Arrays.asList(1, 4);
        private ViewPort mViewPort;
        private final List<UseCase> mUseCases = new ArrayList();
        private final List<CameraEffect> mEffects = new ArrayList();

        private void checkEffectTargets() {
            HashMap map = new HashMap();
            for (CameraEffect cameraEffect : this.mEffects) {
                int targets = cameraEffect.getTargets();
                if (!SUPPORTED_TARGETS.contains(Integer.valueOf(targets))) {
                    Locale locale = Locale.US;
                    throw new IllegalArgumentException(h0.a.l("Effects target ", getHumanReadableTargets(targets), " is not in the supported list ", getHumanReadableSupportedTargets(), "."));
                }
                if (map.containsKey(Integer.valueOf(cameraEffect.getTargets()))) {
                    Locale locale2 = Locale.US;
                    CameraEffect cameraEffect2 = (CameraEffect) map.get(Integer.valueOf(cameraEffect.getTargets()));
                    Objects.requireNonNull(cameraEffect2);
                    String name = cameraEffect2.getClass().getName();
                    String name2 = cameraEffect.getClass().getName();
                    throw new IllegalArgumentException(h0.a.n(h0.a.p("Effects ", name, " and ", name2, " contain duplicate targets "), getHumanReadableTargets(targets), "."));
                }
                map.put(Integer.valueOf(cameraEffect.getTargets()), cameraEffect);
            }
        }

        public static String getHumanReadableSupportedTargets() {
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = SUPPORTED_TARGETS.iterator();
            while (it.hasNext()) {
                arrayList.add(getHumanReadableTargets(it.next().intValue()));
            }
            return "[" + String.join(", ", arrayList) + "]";
        }

        public static String getHumanReadableTargets(int i8) {
            ArrayList arrayList = new ArrayList();
            if ((i8 & 4) != 0) {
                arrayList.add("IMAGE_CAPTURE");
            }
            if ((i8 & 1) != 0) {
                arrayList.add("PREVIEW");
            }
            if ((i8 & 2) != 0) {
                arrayList.add("VIDEO_CAPTURE");
            }
            return String.join("|", arrayList);
        }

        @NonNull
        public Builder addEffect(@NonNull CameraEffect cameraEffect) {
            this.mEffects.add(cameraEffect);
            return this;
        }

        @NonNull
        public Builder addUseCase(@NonNull UseCase useCase) {
            this.mUseCases.add(useCase);
            return this;
        }

        @NonNull
        public UseCaseGroup build() {
            Preconditions.checkArgument(!this.mUseCases.isEmpty(), "UseCase must not be empty.");
            checkEffectTargets();
            return new UseCaseGroup(this.mViewPort, this.mUseCases, this.mEffects);
        }

        @NonNull
        public Builder setViewPort(@NonNull ViewPort viewPort) {
            this.mViewPort = viewPort;
            return this;
        }
    }

    public UseCaseGroup(@Nullable ViewPort viewPort, @NonNull List<UseCase> list, @NonNull List<CameraEffect> list2) {
        this.mViewPort = viewPort;
        this.mUseCases = list;
        this.mEffects = list2;
    }

    @NonNull
    public List<CameraEffect> getEffects() {
        return this.mEffects;
    }

    @NonNull
    public List<UseCase> getUseCases() {
        return this.mUseCases;
    }

    @Nullable
    public ViewPort getViewPort() {
        return this.mViewPort;
    }
}
