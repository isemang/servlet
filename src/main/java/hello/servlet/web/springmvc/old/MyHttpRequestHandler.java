package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("/springmvc/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MyHttpRequestHandler.handleRequest");
    }
}
/*
핸들러 매핑 작동
1. 핸들러 매핑으로 핸들러 조회
- HandlerMapping을 순서대로 실행해서 핸들러를 찾는다
- 이 경우, bean 이름으로 핸들러를 찾아야 하기 때문에, bean 이름으로 핸들러를 찾아주는 BeanNameUrlHandlerMapping이 실행에 성공한 후
    핸들러인 MyHttpRequestHandler를 반환한다
2. 핸들러 어댑터 조회
- handlerAdapter의 supports()를 순서대로 호출한다
- HttpRequestHandlerAdapter가 HttpRequestHandler 인터페이스를 지원하므로 대상이 된다
3. 핸들러 어댑터 실행
- 디스패처 서블릿이 조회한 HttpRequestHandlerAdapter를 실행하면서, 핸들러 정보도 함께 넘겨준다
- HttpServletRequestHandlerAdapter는 핸들러인 MyHttpRequestHandler를 내부에서 실행하고, 그 결과를 반환한다

[결론]
MyHttpRequestHandler 핸들러 매핑, 어댑터
MyHttpRequestHandler를 실행시키면서 사용된 객체는 다음과 같다.
1. HandlerMapping = BeanNameUrlHandlerMapping
2. HandlerAdapter = HttpRequestHandlerAdapter
 */
