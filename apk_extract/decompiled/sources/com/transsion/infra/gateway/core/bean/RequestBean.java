package com.transsion.infra.gateway.core.bean;

/* JADX INFO: loaded from: classes2.dex */
public class RequestBean {
    private String accept;
    private String body;
    private String contentType;
    private GatewaySignKey key;
    private String method;
    private String url;

    public static class Builder {
        private String accept;
        private String body;
        private String contentType;
        private GatewaySignKey key;
        private String method;
        private String url;

        public Builder accept(String str) {
            this.accept = str;
            return this;
        }

        public Builder body(String str) {
            this.body = str;
            return this;
        }

        public RequestBean build() {
            return new RequestBean(this);
        }

        public Builder contentType(String str) {
            this.contentType = str;
            return this;
        }

        public Builder key(GatewaySignKey gatewaySignKey) {
            this.key = gatewaySignKey;
            return this;
        }

        public Builder method(String str) {
            this.method = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    public RequestBean(Builder builder) {
        this.method = builder.method;
        this.accept = builder.accept;
        this.contentType = builder.contentType;
        this.url = builder.url;
        this.body = builder.body;
        this.key = builder.key;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAccept() {
        return this.accept;
    }

    public String getBody() {
        return this.body;
    }

    public String getContentType() {
        return this.contentType;
    }

    public GatewaySignKey getKey() {
        return this.key;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "RequestBean{method='" + this.method + "', accept='" + this.accept + "', contentType='" + this.contentType + "', url='" + this.url + "', body='" + this.body + "', key=" + this.key + '}';
    }
}
