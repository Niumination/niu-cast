package io.netty.handler.codec.http;

import h.a;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class DefaultCookie extends io.netty.handler.codec.http.cookie.DefaultCookie implements Cookie {
    private String comment;
    private String commentUrl;
    private boolean discard;
    private Set<Integer> ports;
    private Set<Integer> unmodifiablePorts;
    private int version;

    public DefaultCookie(String str, String str2) {
        super(str, str2);
        Set<Integer> setEmptySet = Collections.emptySet();
        this.ports = setEmptySet;
        this.unmodifiablePorts = setEmptySet;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String comment() {
        return this.comment;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String commentUrl() {
        return this.commentUrl;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getComment() {
        return comment();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getCommentUrl() {
        return commentUrl();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getDomain() {
        return domain();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public long getMaxAge() {
        return maxAge();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getName() {
        return name();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getPath() {
        return path();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public Set<Integer> getPorts() {
        return ports();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public String getValue() {
        return value();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public int getVersion() {
        return version();
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public boolean isDiscard() {
        return this.discard;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public Set<Integer> ports() {
        if (this.unmodifiablePorts == null) {
            this.unmodifiablePorts = Collections.unmodifiableSet(this.ports);
        }
        return this.unmodifiablePorts;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setComment(String str) {
        this.comment = validateValue("comment", str);
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setCommentUrl(String str) {
        this.commentUrl = validateValue("commentUrl", str);
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setDiscard(boolean z10) {
        this.discard = z10;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setPorts(int... iArr) {
        ObjectUtil.checkNotNull(iArr, "ports");
        int[] iArr2 = (int[]) iArr.clone();
        if (iArr2.length == 0) {
            Set<Integer> setEmptySet = Collections.emptySet();
            this.ports = setEmptySet;
            this.unmodifiablePorts = setEmptySet;
            return;
        }
        TreeSet treeSet = new TreeSet();
        for (int i10 : iArr2) {
            if (i10 <= 0 || i10 > 65535) {
                throw new IllegalArgumentException(a.a("port out of range: ", i10));
            }
            treeSet.add(Integer.valueOf(i10));
        }
        this.ports = treeSet;
        this.unmodifiablePorts = null;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setVersion(int i10) {
        this.version = i10;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public int version() {
        return this.version;
    }

    @Override // io.netty.handler.codec.http.Cookie
    @Deprecated
    public void setPorts(Iterable<Integer> iterable) {
        TreeSet treeSet = new TreeSet();
        for (Integer num : iterable) {
            int iIntValue = num.intValue();
            if (iIntValue > 0 && iIntValue <= 65535) {
                treeSet.add(num);
            } else {
                throw new IllegalArgumentException(a.a("port out of range: ", iIntValue));
            }
        }
        if (treeSet.isEmpty()) {
            Set<Integer> setEmptySet = Collections.emptySet();
            this.ports = setEmptySet;
            this.unmodifiablePorts = setEmptySet;
        } else {
            this.ports = treeSet;
            this.unmodifiablePorts = null;
        }
    }
}
