create table smartvalve.valve_status
(
    num        int auto_increment
        primary key,
    sw1        int(1) default 0 not null,
    sw2        int(1) default 0 not null,
    on_sw1     datetime         null,
    off_sw1    datetime         null,
    on_sw2     datetime         null,
    off_sw2    datetime         null,
    valve_time int              null,
    cork_time  int              null
);