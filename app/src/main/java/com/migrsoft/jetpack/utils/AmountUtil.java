package com.migrsoft.jetpack.utils;

import android.text.TextUtils;
import android.widget.TextView;
import com.migrsoft.jetpack.contant.ParamContant;
import com.migrsoft.jetpack.db.entity.Sparameter;
import com.migrsoft.jetpack.repository.CacheRepository;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * Created by fayou on 2017/9/6.
 */

public class AmountUtil {

    static CacheRepository cacheRepository;
    private static int default_accuracy;
    private static int weight_default_accuracy;
    private static DecimalFormat df;
    private static DecimalFormat weight_df;
    private static double DBL_EPSILON = 1e-8;

    public static void init(CacheRepository c) {
        cacheRepository = c;
    }

    /**
     * 格式化金额精度
     *
     * @param value
     * @return
     */
    public static double convertDouble(double value) {
        try {
            int count = getAmountAccu();
            //double精度问题，eg:3.44，由于计算机解析和原始数据有偏差
            //3.44  =3.4399999999999996447286321199499070644378662109375；
            //+0.000001,使value进位，数据格式化的时候截取剩下的数据而不至于出错
            double temp;
            if (value < 0) {
                temp = value - 0.000001;
            } else {
                temp = value + 0.000001;
            }
            BigDecimal bd = new BigDecimal(temp);
            return bd.setScale(count, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getAmountAccu() {
        int amountAccu = 2;
        if (cacheRepository == null) {
            return amountAccu;
        }
        Sparameter sparameter = cacheRepository.getAsSparameter(ParamContant.sysparam2);
        if (sparameter == null) {
            return amountAccu;
        }
        String amountAcc = null;
        if (sparameter.getUsable() != 0) {
            amountAcc = sparameter.getParamValue();
        }

        try {
            amountAccu = Integer.parseInt(amountAcc);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return amountAccu;
    }

    public static String formatAmount(double d) {
        int count = getAmountAccu();
        StringBuffer sBuffer = new StringBuffer("######0.");
        for (int i = 0; i < count; i++) {
            sBuffer.append("0");
        }
        DecimalFormat df = new DecimalFormat(sBuffer.toString());
        return df.format(d);
    }

    public static Double getBarCodeAmount(String barcode) {
        Double amount = 0d;
        if (!TextUtils.isEmpty(barcode)) {
            try {
                String d = barcode.substring(7, 10);
                String x = barcode.substring(10, 12);
                amount = Double.parseDouble((d + "." + x));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return amount;
    }

    /**
     * 根据未支付金额获取动态快速支付valueList
     *
     * @param value
     * @return
     */
    public static List<Double> getFastValueList(Double value) {
        Set<Double> valueSet = new TreeSet<>();
        valueSet.add(value);
        double get_double;

        if (value > 100) {// 大于100
            double temp = value / 10;
            get_double = Math.ceil(temp) * 10;
            valueSet.add(get_double);

            temp = value / 100;
            get_double = Math.ceil(temp) * 100;
            valueSet.add(get_double);

        } else if (value > 50) {//(50, 100]
            double temp = value / 10;
            get_double = Math.ceil(temp) * 10;
            valueSet.add(get_double);
            valueSet.add(100.00);

        } else if (value > 10) {//(10, 50]
            double temp = value / 10;
            get_double = Math.ceil(temp) * 10;
            valueSet.add(get_double);
            valueSet.add(50.00);
        } else if (value > 5) {//(5, 10]
            valueSet.add(10.00);
            valueSet.add(20.00);
        } else if (value > 1) {//(1, 5]
            valueSet.add(5.00);
            valueSet.add(10.00);
        } else {//(0, 1]
            valueSet.add(1.00);
            valueSet.add(5.00);
            valueSet.add(10.00);
        }

        List<Double> fastValuesList = new ArrayList<>();
        fastValuesList.addAll(valueSet);
        return fastValuesList;

    }


    /**
     * 获取未收
     *
     * @return
     */
    public static double getUnCollect(double should, double already) {
        if (should > already) {
            return convertDouble(should - already);
        }
        return AmountUtil.convertDouble(0d);
    }

    /**
     * 比较 两个double值是否相等
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isEqualValue(double d1, double d2) {
        final double epsilon = 0.001;
        return (Math.abs(d1 - d2) < epsilon);
    }

    /**
     * 格式化金额精度: 获取字符串
     *
     * @param value
     * @return
     */
    public static String convertDouble2String(double value) {
        int count = getAmountAccu();
        String x = "";
        for (int i = 0; i < count; i++) {
            x += "0";
        }
        DecimalFormat df = new DecimalFormat("0." + x);
        return df.format(value);
    }

    /**
     * 格式化金额: 获取字符串[精度：2位]
     *
     * @param value
     * @return
     */
    public static double convert2DefaultAmountAccuDouble(double value) {
        try {
            int count = 2;
            //double精度问题，eg:3.44，由于计算机解析和原始数据有偏差
            //3.44  =3.4399999999999996447286321199499070644378662109375；
            //+0.000001,使value进位，数据格式化的时候截取剩下的数据而不至于出错
            double temp;
            if (value < 0) {
                temp = value - 0.000001;
            } else {
                temp = value + 0.000001;
            }
            BigDecimal bd = new BigDecimal(temp);
            return bd.setScale(count, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 按照精度设置：显示数据
     *
     * @param tv
     * @param value
     */
    public static void setConvertDoubleText(TextView tv, double value) {
        tv.setText(convertDouble2String(value));
    }

    /**
     * 小数点后边为0,去掉小数点后面0，否则显示两位小数
     *
     * @param num
     * @return
     */
    public static String doubleTrans(double num) {
        return doubleTrans(num, 2);
    }

    public static String doubleTrans(double num, int accuracy) {
        if (isZero(Math.round(num) - num)) {
            return String.valueOf(Math.round(num));
        }
        if (default_accuracy != accuracy || df == null) {
            StringBuffer sBuffer = new StringBuffer("######0.");
            for (int i = 0; i < accuracy; i++) {
                sBuffer.append("0");
            }
            df = new DecimalFormat(sBuffer.toString());
        }
        default_accuracy = accuracy;
        return df.format(num);
    }

    public static String weightTrans(double num, int accuracy) {
        if (weight_default_accuracy != accuracy || weight_df == null) {
            StringBuffer sBuffer = new StringBuffer("######000.");
            for (int i = 0; i < accuracy; i++) {
                sBuffer.append("0");
            }
            weight_df = new DecimalFormat(sBuffer.toString());
        }
        weight_default_accuracy = accuracy;
        return weight_df.format(num);
    }

    public static boolean isZero(double aDouble) {
        return Math.abs(aDouble) <= DBL_EPSILON;
    }

    public static boolean isNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.equals(str, "\\.")) {
            return true;
        }
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }


    /**
     * 获取较小数据
     *
     * @param var1
     * @param val2
     * @return
     */
    public static double getLesserVal(double var1, double val2) {
        BigDecimal data1 = new BigDecimal(var1);
        BigDecimal data2 = new BigDecimal(val2);
        if (-1 == data1.compareTo(data2)) {
            return var1;
        } else {
            return val2;
        }
    }
}
