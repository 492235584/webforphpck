package xie.shu.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver{
	   public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
	        UnknowException unknowException;
	        if(ex instanceof UnknowException){
	            unknowException = (UnknowException)ex;
	        }else{
	            unknowException = new UnknowException("未知错误");
	        }

	        //错误信息
	        String message = unknowException.getMessage();

	        ModelAndView modelAndView = new ModelAndView();

	        //将错误信息传到页面
	        modelAndView.addObject("message", message);

	        //指向错误页面
	        modelAndView.setViewName("error");

	        return modelAndView;
	}
}
