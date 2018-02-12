package com.mengzhidu.jetty.demo.x001;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 最简单的应用
 * 这里我们定制了自己的处理器，即HelloHandler
 * 这个处理器输出了一段内容，然后告诉服务器说处理完成
 *
 * 这里我们为了简单，把处理器和应用类写到一个文件中
 * 在之后我们都会分开写的
 *
 * 使用方法:
 * 1.启动这里的main方法
 * 2.打开浏览器，输入localhost:8080
 */
public class App {
    public static void main(String[] args) throws Exception{
        // 我们监听的端口
        int port = 8080;
        // 新建一个服务器类，我们这里给它指定了端口
        Server server = new Server(port);
        // 设置处理器
        server.setHandler(new MyHandler());
        // 启动程序...
        server.start();
        server.join();
    }
}

/**
 * 我们自定义的handler
 * 它用于在终端输出一段文本信息
 */
class MyHandler extends AbstractHandler {

    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        // 设置字符集，避免乱码
        httpServletResponse.setCharacterEncoding("UTF-8");
        // 输出我们想要显示的问候语
        httpServletResponse.getWriter().println("hello jetty，我是辛星 ^_^");
        // 表示请求处理完成
        request.setHandled(true);

    }
}

