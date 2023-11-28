package task;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.trace("log trace");
        log.debug("log debug");
        log.info("log info");
        log.warn("Log warn");
        log.error("log error");
    }
}