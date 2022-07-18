package util;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//异常处理类 实现一个spring提供的异常处理类
@Component
public class ResolveExcetion implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //判断下接收到的异常是我们的吗
        ModelAndView mv = new ModelAndView();
        if(e instanceof MyExcetion){
            mv.addObject("message",e.getMessage());
            mv.setViewName("erroe.jsp");
        }
       return mv;
    }

    //

}
