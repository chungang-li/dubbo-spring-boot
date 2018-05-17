package org.ragdoll.autoconfigure.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(
        value = "spring.dubbo"
)
public class DubboProperties {

    private DubboProperties.Application application = new Application();

    private DubboProperties.Registry registry = new Registry();


    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    /**
     * 应用信息配置
     */
    public static class Application {
        /**
         * 必填
         * 当前应用名称
         */
        private String name;

        /**
         * 可选
         * 当前应用的版本
         */
        private String version;

        /**
         * 可选
         * 应用负责人，用于服务治理，请填写负责人公司邮箱前缀
         */
        private String owner;

        /**
         * 可选
         * 组织名称(BU或部门)，用于注册中心区分服务来源，此配置项建议不要使用autoconfig，
         * 直接写死在配置中，比如china,intl,itu,crm,asc,dw,aliexpress等
         */
        private String organization;

        /**
         * 可选
         * 用于服务分层对应的架构。如，intl、china。不同的架构使用不同的分层。
         */
        private String architecture;

        /**
         * 可选
         * 应用环境，如：develop/test/product，不同环境使用不同的缺省值，以及作为只用于开发测试功能的限制条件
         */
        private String environment;

        /**
         * 可选
         * 缺省值 javassist
         * Java字节码编译器，用于动态类的生成，可选：jdk或javassist
         */
        private String compiler;

        /**
         * 可选
         * 缺省值 slf4j
         * 日志输出方式，可选：slf4j,jcl,log4j,jdk
         */
        private String logger;

        public ApplicationConfig buildConfig() {
            ApplicationConfig config = new ApplicationConfig();
            if (this.name != null) {
                config.setName(name);
            }
            if (this.version != null) {
                config.setVersion(version);
            }
            if (this.architecture != null) {
                config.setArchitecture(architecture);
            }
            if (this.compiler != null) {
                config.setCompiler(compiler);
            }
            if (this.environment != null) {
                config.setEnvironment(environment);
            }
            if (this.logger != null) {
                config.setLogger(logger);
            }
            if (this.organization != null) {
                config.setOrganization(organization);
            }
            if (this.owner != null) {
                config.setOwner(owner);
            }
            return config;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getOrganization() {
            return organization;
        }

        public void setOrganization(String organization) {
            this.organization = organization;
        }

        public String getArchitecture() {
            return architecture;
        }

        public void setArchitecture(String architecture) {
            this.architecture = architecture;
        }

        public String getEnvironment() {
            return environment;
        }

        public void setEnvironment(String environment) {
            this.environment = environment;
        }

        public String getCompiler() {
            return compiler;
        }

        public void setCompiler(String compiler) {
            this.compiler = compiler;
        }

        public String getLogger() {
            return logger;
        }

        public void setLogger(String logger) {
            this.logger = logger;
        }
    }

    /**
     * 注册中心
     */
    public static class Registry {
        /**
         * 可选
         * 注册中心引用BeanId，可以在<dubbo:service registry="">或<dubbo:reference registry="">中引用此ID
         */
        private String id;

        /**
         * 必填
         * <host:port>
         * 注册中心服务器地址，如果地址没有端口缺省为9090，同一集群内的多个地址用逗号分隔，如：ip:port,ip:port，
         * 不同集群的注册中心，请配置多个<dubbo:registry>标签
         */
        private String address;

        /**
         * 可选
         * 缺省值 dubbo
         * 注同中心地址协议，支持dubbo, http, local三种协议，分别表示，dubbo地址，http地址，本地注册中心
         */
        private String protocol;

        /**
         * 可选
         * 缺省值 9090
         * 注册中心缺省端口，当address没有带端口时使用此端口做为缺省值
         */
        private Integer port;

        /**
         * 可选
         * 登录注册中心用户名，如果注册中心不需要验证可不填
         */
        private String username;

        /**
         * 可选
         * 登录注册中心密码，如果注册中心不需要验证可不填
         */
        private String password;

        /**
         * 可选
         * 缺省值 netty
         * 网络传输方式，可选mina,netty
         */
        private String transport;

        /**
         * 可选
         * 缺省值 5000
         * 注册中心请求超时时间(毫秒)
         */
        private Integer timeout;

        /**
         * 可选
         * 缺省值 60000
         * 注册中心会话超时时间(毫秒)，用于检测提供者非正常断线后的脏数据，比如用心跳检测的实现，此时间就是心跳间隔，不同注册中心实现不一样。
         */
        private Integer session;

        /**
         * 可选
         * 使用文件缓存注册中心地址列表及服务提供者列表，应用重启时将基于此文件恢复，注意：两个注册中心不能使用同一文件存储
         */
        private String file;

        /**
         * 可选
         * 缺省值 0
         * 停止时等待通知完成时间(毫秒)
         */
        private Integer wait;

        /**
         * 可选
         * 缺省值 true
         * 注册中心不存在时，是否报错
         */
        private Boolean check;

        /**
         * 可选
         * 缺省值 true
         * 是否向此注册中心注册服务，如果设为false，将只订阅，不注册
         */
        private Boolean register;

        /**
         * 可选
         * 缺省值 true
         * 是否向此注册中心订阅服务，如果设为false，将只注册，不订阅
         */
        private Boolean subscribe;

        /**
         * 可选
         * 缺省值 true
         * 服务是否动态注册，如果设为false，注册后将显示后disable状态，需人工启用，并且服务提供者停止时，也不会自动取消册，需人工禁用。
         */
        private Boolean dynamic;

        public RegistryConfig buildConfig() {
            RegistryConfig config = new RegistryConfig();
            if (this.id != null) {
                config.setId(id);
            }
            if (this.address != null) {
                config.setAddress(address);
            }
            if (this.check != null) {
                config.setCheck(check);
            }
            if (this.dynamic != null) {
                config.setDynamic(dynamic);
            }
            if (this.register != null) {
                config.setRegister(register);
            }
            if (this.subscribe != null) {
                config.setSubscribe(subscribe);
            }
            if (this.file != null) {
                config.setFile(file);
            }
            if (this.port != null) {
                config.setPort(port);
            }
            if (this.username != null) {
                config.setUsername(username);
            }
            if (this.password != null) {
                config.setPassword(password);
            }
            if (this.protocol != null) {
                config.setProtocol(protocol);
            }
            if (this.session != null) {
                config.setSession(session);
            }
            if (this.transport != null) {
                config.setTransport(transport);
            }
            if (this.timeout != null) {
                config.setTimeout(timeout);
            }
            if (this.wait != null) {
                config.setWait(wait);
            }
            return config;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTransport() {
            return transport;
        }

        public void setTransport(String transport) {
            this.transport = transport;
        }

        public Integer getTimeout() {
            return timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

        public Integer getSession() {
            return session;
        }

        public void setSession(Integer session) {
            this.session = session;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public Integer getWait() {
            return wait;
        }

        public void setWait(Integer wait) {
            this.wait = wait;
        }

        public Boolean getCheck() {
            return check;
        }

        public void setCheck(Boolean check) {
            this.check = check;
        }

        public Boolean getRegister() {
            return register;
        }

        public void setRegister(Boolean register) {
            this.register = register;
        }

        public Boolean getSubscribe() {
            return subscribe;
        }

        public void setSubscribe(Boolean subscribe) {
            this.subscribe = subscribe;
        }

        public Boolean getDynamic() {
            return dynamic;
        }

        public void setDynamic(Boolean dynamic) {
            this.dynamic = dynamic;
        }
    }

    /**
     * 提供者
     */
    public static class Provider {

        private String id;

        private String protocol;

        private String host;

        private Integer threads;

        private Integer payload;

        private String path;

        private String server;

        private String client;

        private String codec;

        private String serialization;

        private String d_default;

        private String filter;

        private String listener;

        private String threadpool;

        private String accepts;

        private String version;

        private String group;

        private Integer delay;

        private Integer timeout;

        private Integer retries;

        private Integer connections;

        private String loadbalance;

        private Boolean async;

        private Boolean stub;

        private Boolean mock;

        private Boolean token;

        private String registry;

        private String dynamic;

        private Boolean accesslog;

        private String owner;

        private String document;

        private Integer weight;

        private Integer executes;

        private Integer actives;

        private String proxy;

        private String cluster;

        private Boolean deprecated;

        private Integer queues;

        private String charset;

        private Integer buffer;

        private Integer iothreads;

        private String telnet;

        private String contextpath;

        private String layer;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getThreads() {
            return threads;
        }

        public void setThreads(Integer threads) {
            this.threads = threads;
        }

        public Integer getPayload() {
            return payload;
        }

        public void setPayload(Integer payload) {
            this.payload = payload;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public String getClient() {
            return client;
        }

        public void setClient(String client) {
            this.client = client;
        }

        public String getCodec() {
            return codec;
        }

        public void setCodec(String codec) {
            this.codec = codec;
        }

        public String getSerialization() {
            return serialization;
        }

        public void setSerialization(String serialization) {
            this.serialization = serialization;
        }

        public String getDefault() {
            return d_default;
        }

        public void setDefault(String d_default) {
            this.d_default = d_default;
        }

        public String getFilter() {
            return filter;
        }

        public void setFilter(String filter) {
            this.filter = filter;
        }

        public String getListener() {
            return listener;
        }

        public void setListener(String listener) {
            this.listener = listener;
        }

        public String getThreadpool() {
            return threadpool;
        }

        public void setThreadpool(String threadpool) {
            this.threadpool = threadpool;
        }

        public String getAccepts() {
            return accepts;
        }

        public void setAccepts(String accepts) {
            this.accepts = accepts;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public Integer getDelay() {
            return delay;
        }

        public void setDelay(Integer delay) {
            this.delay = delay;
        }

        public Integer getTimeout() {
            return timeout;
        }

        public void setTimeout(Integer timeout) {
            this.timeout = timeout;
        }

        public Integer getRetries() {
            return retries;
        }

        public void setRetries(Integer retries) {
            this.retries = retries;
        }

        public Integer getConnections() {
            return connections;
        }

        public void setConnections(Integer connections) {
            this.connections = connections;
        }

        public String getLoadbalance() {
            return loadbalance;
        }

        public void setLoadbalance(String loadbalance) {
            this.loadbalance = loadbalance;
        }

        public Boolean getAsync() {
            return async;
        }

        public void setAsync(Boolean async) {
            this.async = async;
        }

        public Boolean getStub() {
            return stub;
        }

        public void setStub(Boolean stub) {
            this.stub = stub;
        }

        public Boolean getMock() {
            return mock;
        }

        public void setMock(Boolean mock) {
            this.mock = mock;
        }

        public Boolean getToken() {
            return token;
        }

        public void setToken(Boolean token) {
            this.token = token;
        }

        public String getRegistry() {
            return registry;
        }

        public void setRegistry(String registry) {
            this.registry = registry;
        }

        public String getDynamic() {
            return dynamic;
        }

        public void setDynamic(String dynamic) {
            this.dynamic = dynamic;
        }

        public Boolean getAccesslog() {
            return accesslog;
        }

        public void setAccesslog(Boolean accesslog) {
            this.accesslog = accesslog;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getDocument() {
            return document;
        }

        public void setDocument(String document) {
            this.document = document;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public Integer getExecutes() {
            return executes;
        }

        public void setExecutes(Integer executes) {
            this.executes = executes;
        }

        public Integer getActives() {
            return actives;
        }

        public void setActives(Integer actives) {
            this.actives = actives;
        }

        public String getProxy() {
            return proxy;
        }

        public void setProxy(String proxy) {
            this.proxy = proxy;
        }

        public String getCluster() {
            return cluster;
        }

        public void setCluster(String cluster) {
            this.cluster = cluster;
        }

        public Boolean isDeprecated() {
            return deprecated;
        }

        public void setDeprecated(Boolean deprecated) {
            this.deprecated = deprecated;
        }

        public Integer getQueues() {
            return queues;
        }

        public void setQueues(Integer queues) {
            this.queues = queues;
        }

        public String getCharset() {
            return charset;
        }

        public void setCharset(String charset) {
            this.charset = charset;
        }

        public Integer getBuffer() {
            return buffer;
        }

        public void setBuffer(Integer buffer) {
            this.buffer = buffer;
        }

        public Integer getIothreads() {
            return iothreads;
        }

        public void setIothreads(Integer iothreads) {
            this.iothreads = iothreads;
        }

        public String getTelnet() {
            return telnet;
        }

        public void setTelnet(String telnet) {
            this.telnet = telnet;
        }

        public String getContextpath() {
            return contextpath;
        }

        public void setContextpath(String contextpath) {
            this.contextpath = contextpath;
        }

        public String getLayer() {
            return layer;
        }

        public void setLayer(String layer) {
            this.layer = layer;
        }
    }
}
