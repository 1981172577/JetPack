package com.migrsoft.jetpack.db;

import android.arch.persistence.room.TypeConverter;

import java.sql.Date;

/**
 * 简介：
 *
 * @author 王强（249346528@qq.com） 2017/8/14.
 */

public class DateConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
