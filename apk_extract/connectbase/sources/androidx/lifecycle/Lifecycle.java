package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import in.n;
import java.util.concurrent.atomic.AtomicReference;
import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @l
    private AtomicReference<Object> internalScopeRef = new AtomicReference<>();

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;


        @l
        public static final Companion Companion = new Companion(null);

        public static final class Companion {

            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.CREATED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.STARTED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.RESUMED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.DESTROYED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[State.INITIALIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(w wVar) {
                this();
            }

            @m
            @n
            public final Event downFrom(@l State state) {
                l0.p(state, "state");
                int i10 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i10 == 1) {
                    return Event.ON_DESTROY;
                }
                if (i10 == 2) {
                    return Event.ON_STOP;
                }
                if (i10 != 3) {
                    return null;
                }
                return Event.ON_PAUSE;
            }

            @m
            @n
            public final Event downTo(@l State state) {
                l0.p(state, "state");
                int i10 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i10 == 1) {
                    return Event.ON_STOP;
                }
                if (i10 == 2) {
                    return Event.ON_PAUSE;
                }
                if (i10 != 4) {
                    return null;
                }
                return Event.ON_DESTROY;
            }

            @m
            @n
            public final Event upFrom(@l State state) {
                l0.p(state, "state");
                int i10 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i10 == 1) {
                    return Event.ON_START;
                }
                if (i10 == 2) {
                    return Event.ON_RESUME;
                }
                if (i10 != 5) {
                    return null;
                }
                return Event.ON_CREATE;
            }

            @m
            @n
            public final Event upTo(@l State state) {
                l0.p(state, "state");
                int i10 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i10 == 1) {
                    return Event.ON_CREATE;
                }
                if (i10 == 2) {
                    return Event.ON_START;
                }
                if (i10 != 3) {
                    return null;
                }
                return Event.ON_RESUME;
            }

            private Companion() {
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @m
        @n
        public static final Event downFrom(@l State state) {
            return Companion.downFrom(state);
        }

        @m
        @n
        public static final Event downTo(@l State state) {
            return Companion.downTo(state);
        }

        @m
        @n
        public static final Event upFrom(@l State state) {
            return Companion.upFrom(state);
        }

        @m
        @n
        public static final Event upTo(@l State state) {
            return Companion.upTo(state);
        }

        @l
        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public final boolean isAtLeast(@l State state) {
            l0.p(state, "state");
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    public abstract void addObserver(@l LifecycleObserver lifecycleObserver);

    @MainThread
    @l
    public abstract State getCurrentState();

    @l
    public final AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    @MainThread
    public abstract void removeObserver(@l LifecycleObserver lifecycleObserver);

    public final void setInternalScopeRef(@l AtomicReference<Object> atomicReference) {
        l0.p(atomicReference, "<set-?>");
        this.internalScopeRef = atomicReference;
    }
}
