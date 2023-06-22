CREATE TABLE IF NOT EXISTS MENTORING.SCREENSHOTS_TAB
(
    id                          SERIAL,
    session_id                  INTEGER NOT NULL,
    screenshot_reference        VARCHAR(200) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_sessions_tab
        FOREIGN KEY(session_id)
            REFERENCES MENTORING.SESSIONS_TAB(id)
);