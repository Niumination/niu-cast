package gp;

import jq.e0;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public enum m {
    PLAIN { // from class: gp.m.b
        @Override // gp.m
        @os.l
        public String escape(@os.l String str) {
            l0.p(str, "string");
            return str;
        }
    },
    HTML { // from class: gp.m.a
        @Override // gp.m
        @os.l
        public String escape(@os.l String str) {
            l0.p(str, "string");
            return e0.i2(e0.i2(str, "<", "&lt;", false, 4, null), ">", "&gt;", false, 4, null);
        }
    };

    @os.l
    public abstract String escape(@os.l String str);

    m(w wVar) {
    }
}
