package top.tbz.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
//        String requestURI=request.getRequestURI();
//        log.info("MyInterceptor preHandle:{}",requestURI);
//        LocalDateTime beginTime=LocalDateTime.now();
//        request.setAttribute("beginTime",beginTime);
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,Object handler,Exception ex)throws Exception{
//        String beginTime=request.getAttribute("beginTime").toString();
//        log.info("begin Time:{}",beginTime);
//        LocalDateTime endTime=LocalDateTime.now();
//        String requestURI=request.getRequestURI();
//        log.info("拦截器执行结束:{}{}",requestURI,endTime);
//    }



}
