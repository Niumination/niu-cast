package androidx.window.core;

import kn.l0;
import kn.w;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class SpecificationComputer<T> {

    @l
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(w wVar) {
            this();
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i10, Object obj2) {
            if ((i10 & 2) != 0) {
                verificationMode = BuildConfig.INSTANCE.getVerificationMode();
            }
            if ((i10 & 4) != 0) {
                logger = AndroidLogger.INSTANCE;
            }
            return companion.startSpecification(obj, str, verificationMode, logger);
        }

        @l
        public final <T> SpecificationComputer<T> startSpecification(@l T t10, @l String str, @l VerificationMode verificationMode, @l Logger logger) {
            l0.p(t10, "<this>");
            l0.p(str, "tag");
            l0.p(verificationMode, "verificationMode");
            l0.p(logger, "logger");
            return new ValidSpecification(t10, str, verificationMode, logger);
        }

        private Companion() {
        }
    }

    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    @m
    public abstract T compute();

    @l
    public final String createMessage(@l Object obj, @l String str) {
        l0.p(obj, "value");
        l0.p(str, "message");
        return str + " value: " + obj;
    }

    @l
    public abstract SpecificationComputer<T> require(@l String str, @l jn.l<? super T, Boolean> lVar);
}
