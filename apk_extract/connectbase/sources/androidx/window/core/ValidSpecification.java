package androidx.window.core;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
final class ValidSpecification<T> extends SpecificationComputer<T> {

    @l
    private final Logger logger;

    @l
    private final String tag;

    @l
    private final T value;

    @l
    private final SpecificationComputer.VerificationMode verificationMode;

    public ValidSpecification(@l T t10, @l String str, @l SpecificationComputer.VerificationMode verificationMode, @l Logger logger) {
        l0.p(t10, "value");
        l0.p(str, "tag");
        l0.p(verificationMode, "verificationMode");
        l0.p(logger, "logger");
        this.value = t10;
        this.tag = str;
        this.verificationMode = verificationMode;
        this.logger = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    @l
    public T compute() {
        return this.value;
    }

    @l
    public final Logger getLogger() {
        return this.logger;
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
        return lVar.invoke(this.value).booleanValue() ? this : new FailedSpecification(this.value, this.tag, str, this.logger, this.verificationMode);
    }
}
