package gm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@im.c
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface i {

    public static class a implements im.f<i> {
        @Override // im.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public im.g a(i iVar, Object obj) {
            return obj == null ? im.g.NEVER : im.g.ALWAYS;
        }
    }

    im.g when() default im.g.ALWAYS;
}
