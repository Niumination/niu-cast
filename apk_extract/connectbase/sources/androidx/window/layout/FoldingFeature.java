package androidx.window.layout;

import in.f;
import kn.w;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface FoldingFeature extends DisplayFeature {

    public static final class OcclusionType {

        @l
        private final String description;

        @l
        public static final Companion Companion = new Companion(null);

        @f
        @l
        public static final OcclusionType NONE = new OcclusionType("NONE");

        @f
        @l
        public static final OcclusionType FULL = new OcclusionType("FULL");

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            private Companion() {
            }
        }

        private OcclusionType(String str) {
            this.description = str;
        }

        @l
        public String toString() {
            return this.description;
        }
    }

    public static final class Orientation {

        @l
        private final String description;

        @l
        public static final Companion Companion = new Companion(null);

        @f
        @l
        public static final Orientation VERTICAL = new Orientation("VERTICAL");

        @f
        @l
        public static final Orientation HORIZONTAL = new Orientation("HORIZONTAL");

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            private Companion() {
            }
        }

        private Orientation(String str) {
            this.description = str;
        }

        @l
        public String toString() {
            return this.description;
        }
    }

    public static final class State {

        @l
        public static final Companion Companion = new Companion(null);

        @f
        @l
        public static final State FLAT = new State("FLAT");

        @f
        @l
        public static final State HALF_OPENED = new State("HALF_OPENED");

        @l
        private final String description;

        public static final class Companion {
            public /* synthetic */ Companion(w wVar) {
                this();
            }

            private Companion() {
            }
        }

        private State(String str) {
            this.description = str;
        }

        @l
        public String toString() {
            return this.description;
        }
    }

    @l
    OcclusionType getOcclusionType();

    @l
    Orientation getOrientation();

    @l
    State getState();

    boolean isSeparating();
}
