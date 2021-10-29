package com.anyexception;

/**
 * 定义常见的状态码和业务返回
 * <p>
 * 如果有官方定义，状态码和返回消息尽可能按照官方返回
 */
enum AnyExceptionEnum {

    UNKNOW_ERROR("unknown", -1, "UnknowError", "未知错误"),

    /**
     * 客户端应当继续发送请求。这个临时响应是用来通知客户端它的部分请求已经被服务器接收，且仍未被拒绝。
     * 客户端应当继续发送请求的剩余部分，或者如果请求已经完成，忽略这个响应。
     * 服务器必须在请求完成后向客户端发送一个最终响应。
     */
    HTTP_100("http", 100, "HttpTmpRes", "HTTP临时响应"),

    /**
     * 客户端应当继续发送请求。这个临时响应是用来通知客户端它的部分请求已经被服务器接收，
     * 且仍未被拒绝。客户端应当继续发送请求的剩余部分，或者如果请求已经完成，忽略这个响应。
     * 服务器必须在请求完成后向客户端发送一个最终响应。
     */
    HTTP_101("http", 101, "HttpAgreeChange", "HTTP协议切换"),

    /**
     * 由WebDAV（RFC 2518）扩展的状态码，代表处理将被继续执行。
     */
    HTTP_102("http", 102, "HttpContinueExe", "WebDAV（RFC 2518）继续执行"),

    /**
     * 请求已成功，请求所希望的响应头或数据体将随此响应返回。
     */
    HTTP_200("http", 200, "SUCCESS", "响应成功"),

    /**
     * 请求已经被实现，而且有一个新的资源已经依据请求的需要而建立，
     * 且其 URI 已经随Location 头信息返回。假如需要的资源无法及时建立的话，应当返回 '202 Accepted'。
     */
    HTTP_201("http", 201, "", "请求已经被实现"),

    /**
     * 服务器已接受请求，但尚未处理。正如它可能被拒绝一样，最终该请求可能会也可能不会被执行。
     * 在异步操作的场合下，没有比发送这个状态码更方便的做法了。
     * 返回202状态码的响应的目的是允许服务器接受其他过程的请求
     * （例如某个每天只执行一次的基于批处理的操作），而不必让客户端一直保持与服务器的连接直到批处理操作全部完成。
     * 在接受请求处理并返回202状态码的响应应当在返回的实体中包含一些指示处理当前状态的信息，
     * 以及指向处理状态监视器或状态预测的指针，以便用户能够估计操作是否已经完成。
     */
    HTTP_202("http", 202, "", "服务器已接受请求，但尚未处理"),

    /**
     * 服务器已成功处理了请求，但返回的实体头部元信息不是在原始服务器上有效的确定集合，
     * 而是来自本地或者第三方的拷贝。当前的信息可能是原始版本的子集或者超集。
     * 例如，包含资源的元数据可能导致原始服务器知道元信息的超级。使用此状态码不是必须的，
     * 而且只有在响应不使用此状态码便会返回200 OK的情况下才是合适的。
     */
    HTTP_203("http", 203, "", "实体头部元信息不确定"),

    /**
     * 服务器成功处理了请求，但不需要返回任何实体内容，并且希望返回更新了的元信息。
     * 响应可能通过实体头部的形式，返回新的或更新后的元信息。如果存在这些头部信息，
     * 则应当与所请求的变量相呼应。如果客户端是浏览器的话，那么用户浏览器应保留发送了该请求的页面，
     * 而不产生任何文档视图上的变化，即使按照规范新的或更新后的元信息应当被应用到用户浏览器活动视图中的文档。
     * 由于204响应被禁止包含任何消息体，因此它始终以消息头后的第一个空行结尾。
     */
    HTTP_204("http",204,"","响应禁止包含响应体"),



    /**
     * 获取资源所需要的策略并没有没满足。（RFC 2774）
     */
    HTTP_510("http", 510, "", "获取资源所需策略并没有满足(FRC2774)"),

    MYSQL_1005("mysql", 1005, "创建表失败", "创建表失败");


    /**
     * 业务分类
     */
    public String item;

    /**
     * 状态吗
     */
    public Integer code;

    /**
     * 自定义描述（可能和msg一致）
     */
    public String desc;

    /**
     * 官方消息描述
     */
    private String msg;

    AnyExceptionEnum(String item, Integer code, String desc, String msg) {
        this.item = item;
        this.code = code;
        this.desc = desc;
        this.msg = msg;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
