CREATE TABLE IF NOT EXISTS MENTORING.SESSIONS_TAB
(
    id                             SERIAL,
    worker_id                      INTEGER NOT NULL,
    time_start                     TIMESTAMP[0] NOT NULL,
    time_finish                    TIMESTAMP[0] NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_screenshots_tab
        FOREIGN KEY(worker_id)
            REFERENCES MENTORING.WORKERS_TAB(id)
);