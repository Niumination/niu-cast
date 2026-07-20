package gm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
@im.c(applicableTo = String.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface g {

    public static class a implements im.f<g> {
        @Override // im.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public im.g a(g gVar, Object obj) {
            return Pattern.compile(gVar.value(), gVar.flags()).matcher((String) obj).matches() ? im.g.ALWAYS : im.g.NEVER;
        }
    }

    int flags() default 0;

    @r
    String value();
}
