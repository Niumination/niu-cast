package gm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@im.c(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface h {

    public static class a implements im.f<h> {
        @Override // im.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public im.g a(h hVar, Object obj) {
            if (!(obj instanceof Number)) {
                return im.g.NEVER;
            }
            Number number = (Number) obj;
            return (!(number instanceof Long) ? !(!(number instanceof Double) ? !(!(number instanceof Float) ? number.intValue() < 0 : number.floatValue() < 0.0f) : number.doubleValue() < 0.0d) : number.longValue() < 0) ? im.g.ALWAYS : im.g.NEVER;
        }
    }

    im.g when() default im.g.ALWAYS;
}
