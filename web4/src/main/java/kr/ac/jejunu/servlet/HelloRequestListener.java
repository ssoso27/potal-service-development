package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

// 각 리스너마다 처리할게 다르므로 인터페이스 생긴게 다름
@Slf4j
public class HelloRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("---------------request listener init");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("---------------request listener destroy");
    }
}
