CREATE TABLE IF NOT EXISTS MENTORING.WORKERS_TAB
(
    id                                  SERIAL,
    fio                                 VARCHAR(100) NOT NULL,
    photo_reference                     VARCHAR(200),
    email                               VARCHAR(100) NOT NULL,
    password                            VARCHAR(50) NOT NULL,
    job                                 VARCHAR(50) NOT NULL,
    city                                VARCHAR(50) NOT NULL,
    time_4screenshots                   TIME[0] DEFAULT '00:01:00',
    PRIMARY KEY(id)
);