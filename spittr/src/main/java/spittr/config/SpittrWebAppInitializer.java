package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by hg_yi on 17-10-11.
 */
//继承了如下类的任意类都会自动的配置DispatcherServlet和Spring应用上下文
public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    //将一个或多个路径映射到DispatcherServlet上（处理应用的所有请求）
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
