
 package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);

    @Override
    public int filterOrder() {
        // TODO Auto-generated method stub
        return 1;
    }

    /** Filtro del tipo pre */
    @Override
    public String filterType() {
        // TODO Auto-generated method stub
        return "pre";
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request enrutado al %s", request.getMethod(), request.getRequestURL().toString()));

        Long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);

        return null;
    }

    @Override
    public boolean shouldFilter() {
        // TODO Auto-generated method stub
        return true;
    }

    
}