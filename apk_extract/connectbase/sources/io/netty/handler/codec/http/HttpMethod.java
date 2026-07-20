package io.netty.handler.codec.http;

import h.b;
import io.netty.util.AsciiString;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import l.a;
import wj.v0;

/* JADX INFO: loaded from: classes3.dex */
public class HttpMethod implements Comparable<HttpMethod> {
    public static final HttpMethod CONNECT;
    public static final HttpMethod DELETE;
    public static final HttpMethod GET;
    public static final HttpMethod HEAD;
    public static final HttpMethod OPTIONS;
    public static final HttpMethod PATCH;
    public static final HttpMethod POST;
    public static final HttpMethod PUT;
    public static final HttpMethod TRACE;
    private static final EnumNameMap<HttpMethod> methodMap;
    private final AsciiString name;

    public static final class EnumNameMap<T> {
        private final Node<T>[] values;
        private final int valuesMask;

        public static final class Node<T> {
            final String key;
            final T value;

            public Node(String str, T t10) {
                this.key = str;
                this.value = t10;
            }
        }

        public EnumNameMap(Node<T>... nodeArr) {
            Node<T>[] nodeArr2 = new Node[MathUtil.findNextPositivePowerOfTwo(nodeArr.length)];
            this.values = nodeArr2;
            this.valuesMask = nodeArr2.length - 1;
            for (Node<T> node : nodeArr) {
                int iHashCode = hashCode(node.key) & this.valuesMask;
                Node<T>[] nodeArr3 = this.values;
                if (nodeArr3[iHashCode] != null) {
                    StringBuilder sbA = b.a("index ", iHashCode, " collision between values: [");
                    sbA.append(this.values[iHashCode].key);
                    sbA.append(", ");
                    throw new IllegalArgumentException(a.a(sbA, node.key, ']'));
                }
                nodeArr3[iHashCode] = node;
            }
        }

        private static int hashCode(String str) {
            return str.hashCode() >>> 6;
        }

        public T get(String str) {
            Node<T> node = this.values[this.valuesMask & hashCode(str)];
            if (node == null || !node.key.equals(str)) {
                return null;
            }
            return node.value;
        }
    }

    static {
        HttpMethod httpMethod = new HttpMethod("OPTIONS");
        OPTIONS = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("GET");
        GET = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("HEAD");
        HEAD = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod(v0.f19370p);
        POST = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod("PUT");
        PUT = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("PATCH");
        PATCH = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("DELETE");
        DELETE = httpMethod7;
        HttpMethod httpMethod8 = new HttpMethod("TRACE");
        TRACE = httpMethod8;
        HttpMethod httpMethod9 = new HttpMethod("CONNECT");
        CONNECT = httpMethod9;
        methodMap = new EnumNameMap<>(new EnumNameMap.Node(httpMethod.toString(), httpMethod), new EnumNameMap.Node(httpMethod2.toString(), httpMethod2), new EnumNameMap.Node(httpMethod3.toString(), httpMethod3), new EnumNameMap.Node(httpMethod4.toString(), httpMethod4), new EnumNameMap.Node(httpMethod5.toString(), httpMethod5), new EnumNameMap.Node(httpMethod6.toString(), httpMethod6), new EnumNameMap.Node(httpMethod7.toString(), httpMethod7), new EnumNameMap.Node(httpMethod8.toString(), httpMethod8), new EnumNameMap.Node(httpMethod9.toString(), httpMethod9));
    }

    public HttpMethod(String str) {
        String strCheckNonEmptyAfterTrim = ObjectUtil.checkNonEmptyAfterTrim(str, "name");
        for (int i10 = 0; i10 < strCheckNonEmptyAfterTrim.length(); i10++) {
            char cCharAt = strCheckNonEmptyAfterTrim.charAt(i10);
            if (Character.isISOControl(cCharAt) || Character.isWhitespace(cCharAt)) {
                throw new IllegalArgumentException("invalid character in name");
            }
        }
        this.name = AsciiString.cached(strCheckNonEmptyAfterTrim);
    }

    public static HttpMethod valueOf(String str) {
        HttpMethod httpMethod = GET;
        if (str == httpMethod.name()) {
            return httpMethod;
        }
        HttpMethod httpMethod2 = POST;
        if (str == httpMethod2.name()) {
            return httpMethod2;
        }
        HttpMethod httpMethod3 = methodMap.get(str);
        return httpMethod3 != null ? httpMethod3 : new HttpMethod(str);
    }

    public AsciiString asciiName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HttpMethod) {
            return name().equals(((HttpMethod) obj).name());
        }
        return false;
    }

    public int hashCode() {
        return name().hashCode();
    }

    public String name() {
        return this.name.toString();
    }

    public String toString() {
        return this.name.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpMethod httpMethod) {
        if (httpMethod == this) {
            return 0;
        }
        return name().compareTo(httpMethod.name());
    }
}
