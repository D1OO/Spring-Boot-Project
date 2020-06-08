package net.shvdy.nutrition_tracker.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * 06.06.2020
 *
 * @author Dmitriy Storozhenko
 * @version 1.0
 */
//@Order
@Log4j2
public class SectionContainerRequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        if (!Optional.ofNullable(request.getParameter("AJAXrequest")).isPresent()) {

            ((HttpServletRequest) request).getSession().setAttribute("sectionToFetchWithAJAX",
                    ((HttpServletRequest) request).getRequestURI());

            request.getRequestDispatcher("/" +
                    SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                            .stream().findFirst().get().getAuthority().replace("ROLE_", "").toLowerCase())
                    .forward(request, response);
        }
        chain.doFilter(request, response);
    }

}