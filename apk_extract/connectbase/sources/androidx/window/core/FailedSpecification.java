package androidx.window.core;

import kn.l0;
import lm.i0;
import nm.r;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
final class FailedSpecification<T> extends SpecificationComputer<T> {

    @l
    private final WindowStrictModeException exception;

    @l
    private final Logger logger;

    @l
    private final String message;

    @l
    private final String tag;

    @l
    private final T value;

    @l
    private final SpecificationComputer.VerificationMode verificationMode;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FailedSpecification(@l T t10, @l String str, @l String str2, @l Logger logger, @l SpecificationComputer.VerificationMode verificationMode) {
        l0.p(t10, "value");
        l0.p(str, "tag");
        l0.p(str2, "message");
        l0.p(logger, "logger");
        l0.p(verificationMode, "verificationMode");
        this.value = t10;
        this.tag = str;
        this.message = str2;
        this.logger = logger;
        this.verificationMode = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(createMessage(t10, str2));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        l0.o(stackTrace, "stackTrace");
        Object[] array = r.l9(stackTrace, 2).toArray(new StackTraceElement[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        windowStrictModeException.setStackTrace((StackTraceElement[]) array);
        this.exception = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    @m
    public T compute() throws WindowStrictModeException {
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()];
        if (i10 == 1) {
            throw this.exception;
        }
        if (i10 == 2) {
            this.logger.debug(this.tag, createMessage(this.value, this.message));
            return null;
        }
        if (i10 == 3) {
            return null;
        }
        throw new i0();
    }

    @l
    public final WindowStrictModeException getException() {
        return this.exception;
    }

    @l
    public final Logger getLogger() {
        return this.logger;
    }

    @l
    public final String getMessage() {
        return this.message;
    }

    @l
    public final String getTag() {
        return this.tag;
    }

    @l
    public final T getValue() {
        return this.value;
    }

    @l
    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    @Override // androidx.window.core.SpecificationComputer
    @l
    public SpecificationComputer<T> require(@l String str, @l jn.l<? super T, Boolean> lVar) {
        l0.p(str, "message");
        l0.p(lVar, "condition");
        return this;
    }
}
