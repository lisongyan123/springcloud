//package com.springcloud.lsy.gateway.factory;
//
//import java.net.InetSocketAddress;
//import java.net.URI;
//import java.nio.charset.Charset;
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.OptionalLong;
//import java.util.Locale.LanguageRange;
//import java.util.function.Function;
//import org.springframework.core.MethodParameter;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.core.codec.DecodingException;
//import org.springframework.core.codec.Hints;
//import org.springframework.http.HttpCookie;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpRange;
//import org.springframework.http.MediaType;
//import org.springframework.http.codec.HttpMessageReader;
//import org.springframework.http.codec.multipart.Part;
//import org.springframework.http.server.PathContainer;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.reactive.function.BodyExtractor;
//import org.springframework.web.reactive.function.BodyExtractors;
//import org.springframework.web.reactive.function.UnsupportedMediaTypeException;
//import org.springframework.web.reactive.function.BodyExtractor.Context;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerRequest.Headers;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.ServerWebInputException;
//import org.springframework.web.server.UnsupportedMediaTypeStatusException;
//import org.springframework.web.server.WebSession;
//import org.springframework.web.util.UriBuilder;
//import org.springframework.web.util.UriComponentsBuilder;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//public class DefaultServerRequest implements ServerRequest {
//    private static final Function<UnsupportedMediaTypeException, UnsupportedMediaTypeStatusException> ERROR_MAPPER = (ex) -> {
//        return ex.getContentType() != null ? new UnsupportedMediaTypeStatusException(ex.getContentType(), ex.getSupportedMediaTypes(), ex.getBodyType()) : new UnsupportedMediaTypeStatusException(ex.getMessage());
//    };
//    private static final Function<DecodingException, ServerWebInputException> DECODING_MAPPER = (ex) -> {
//        return new ServerWebInputException("Failed to read HTTP message", (MethodParameter)null, ex);
//    };
//    private final ServerWebExchange exchange;
//    private final Headers headers;
//    private final List<HttpMessageReader<?>> messageReaders;
//
//    DefaultServerRequest(ServerWebExchange exchange, List<HttpMessageReader<?>> messageReaders) {
//        this.exchange = exchange;
//        this.messageReaders = Collections.unmodifiableList(new ArrayList(messageReaders));
//        this.headers = new DefaultServerRequest.DefaultHeaders();
//    }
//
//    public String methodName() {
//        return this.request().getMethodValue();
//    }
//
//    public URI uri() {
//        return this.request().getURI();
//    }
//
//    public UriBuilder uriBuilder() {
//        return UriComponentsBuilder.fromUri(this.uri());
//    }
//
//    public PathContainer pathContainer() {
//        return this.request().getPath();
//    }
//
//    public Headers headers() {
//        return this.headers;
//    }
//
//    public MultiValueMap<String, HttpCookie> cookies() {
//        return this.request().getCookies();
//    }
//
//    public Optional<InetSocketAddress> remoteAddress() {
//        return Optional.ofNullable(this.request().getRemoteAddress());
//    }
//
//    public List<HttpMessageReader<?>> messageReaders() {
//        return this.messageReaders;
//    }
//
//    public <T> T body(BodyExtractor<T, ? super ServerHttpRequest> extractor) {
//        return this.bodyInternal(extractor, Hints.from(Hints.LOG_PREFIX_HINT, this.exchange().getLogPrefix()));
//    }
//
//    public <T> T body(BodyExtractor<T, ? super ServerHttpRequest> extractor, Map<String, Object> hints) {
//        hints = Hints.merge(hints, Hints.LOG_PREFIX_HINT, this.exchange().getLogPrefix());
//        return this.bodyInternal(extractor, hints);
//    }
//
//    private <T> T bodyInternal(BodyExtractor<T, ? super ServerHttpRequest> extractor, final Map<String, Object> hints) {
//        return extractor.extract(this.request(), new Context() {
//            public List<HttpMessageReader<?>> messageReaders() {
//                return DefaultServerRequest.this.messageReaders;
//            }
//
//            public Optional<ServerHttpResponse> serverResponse() {
//                return Optional.of(DefaultServerRequest.this.exchange().getResponse());
//            }
//
//            public Map<String, Object> hints() {
//                return hints;
//            }
//        });
//    }
//
//    public <T> Mono<T> bodyToMono(Class<? extends T> elementClass) {
//        Mono<T> mono = (Mono)this.body(BodyExtractors.toMono(elementClass));
//        return mono.onErrorMap(UnsupportedMediaTypeException.class, ERROR_MAPPER).onErrorMap(DecodingException.class, DECODING_MAPPER);
//    }
//
//    public <T> Mono<T> bodyToMono(ParameterizedTypeReference<T> typeReference) {
//        Mono<T> mono = (Mono)this.body(BodyExtractors.toMono(typeReference));
//        return mono.onErrorMap(UnsupportedMediaTypeException.class, ERROR_MAPPER).onErrorMap(DecodingException.class, DECODING_MAPPER);
//    }
//
//    public <T> Flux<T> bodyToFlux(Class<? extends T> elementClass) {
//        Flux<T> flux = (Flux)this.body(BodyExtractors.toFlux(elementClass));
//        return flux.onErrorMap(UnsupportedMediaTypeException.class, ERROR_MAPPER).onErrorMap(DecodingException.class, DECODING_MAPPER);
//    }
//
//    public <T> Flux<T> bodyToFlux(ParameterizedTypeReference<T> typeReference) {
//        Flux<T> flux = (Flux)this.body(BodyExtractors.toFlux(typeReference));
//        return flux.onErrorMap(UnsupportedMediaTypeException.class, ERROR_MAPPER).onErrorMap(DecodingException.class, DECODING_MAPPER);
//    }
//
//    public Map<String, Object> attributes() {
//        return this.exchange.getAttributes();
//    }
//
//    public MultiValueMap<String, String> queryParams() {
//        return this.request().getQueryParams();
//    }
//
//    public Map<String, String> pathVariables() {
//        return (Map)this.exchange.getAttributeOrDefault(RouterFunctions.URI_TEMPLATE_VARIABLES_ATTRIBUTE, Collections.emptyMap());
//    }
//
//    public Mono<WebSession> session() {
//        return this.exchange.getSession();
//    }
//
//    public Mono<? extends Principal> principal() {
//        return this.exchange.getPrincipal();
//    }
//
//    public Mono<MultiValueMap<String, String>> formData() {
//        return this.exchange.getFormData();
//    }
//
//    public Mono<MultiValueMap<String, Part>> multipartData() {
//        return this.exchange.getMultipartData();
//    }
//
//    private ServerHttpRequest request() {
//        return this.exchange.getRequest();
//    }
//
//    public ServerWebExchange exchange() {
//        return this.exchange;
//    }
//
//    public String toString() {
//        return String.format("HTTP %s %s", this.method(), this.path());
//    }
//
//    private class DefaultHeaders implements Headers {
//        private DefaultHeaders() {
//        }
//
//        private HttpHeaders delegate() {
//            return DefaultServerRequest.this.request().getHeaders();
//        }
//
//        public List<MediaType> accept() {
//            return this.delegate().getAccept();
//        }
//
//        public List<Charset> acceptCharset() {
//            return this.delegate().getAcceptCharset();
//        }
//
//        public List<LanguageRange> acceptLanguage() {
//            return this.delegate().getAcceptLanguage();
//        }
//
//        public OptionalLong contentLength() {
//            long value = this.delegate().getContentLength();
//            return value != -1L ? OptionalLong.of(value) : OptionalLong.empty();
//        }
//
//        public Optional<MediaType> contentType() {
//            return Optional.ofNullable(this.delegate().getContentType());
//        }
//
//        public InetSocketAddress host() {
//            return this.delegate().getHost();
//        }
//
//        public List<HttpRange> range() {
//            return this.delegate().getRange();
//        }
//
//        public List<String> header(String headerName) {
//            List<String> headerValues = this.delegate().get(headerName);
//            return headerValues != null ? headerValues : Collections.emptyList();
//        }
//
//        public HttpHeaders asHttpHeaders() {
//            return HttpHeaders.readOnlyHttpHeaders(this.delegate());
//        }
//
//        public String toString() {
//            return this.delegate().toString();
//        }
//    }
//}
