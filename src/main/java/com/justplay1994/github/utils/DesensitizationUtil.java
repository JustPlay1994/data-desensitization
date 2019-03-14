package com.cetc.dbutil.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description：数据脱敏工具
 * Created by luolinjie on 2018/8/29.
 */
public class DesensitizationUtil {

    private static Logger logger = LoggerFactory.getLogger(DesensitizationUtil.class);

    public static void main(String[] args) {
        String name = personNameTransformer("");
        System.out.println(name);
    }

    /**
     * 人名 转换器
     *
     * @param personName
     * @return
     */
    public static String personNameTransformer(String personName) {
        if (personName == null) {
            logger.error("personName can not be null");
            return null;
        } else {
            char[] chars = personName.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                chars[i] = '*';
            }
            return new String(chars);
        }
    }

    /**
     * 企业名称 转换器
     *
     * @param enterpriseName
     * @return
     */
    public static String enterpriseNameTransformer(String enterpriseName) {
        if (enterpriseName == null) {
            logger.error("enterpriseName can not be null");
            return null;
        } else {
            return generatePartialStar(enterpriseName, 3, -1);
        }
    }

    /**
     * 电话号码 转换器
     *
     * @param telephoneNum
     * @return
     */
    public static String telephoneNumformer(String telephoneNum) {
        String s = null;
        if (telephoneNum == null) {
            logger.error("telephoneNum can not be null");
            return null;
        } else if (telephoneNum.length() == 11) {
            s = generatePartialStar(telephoneNum, 3, 7);
        } else if (telephoneNum.length() == 8) {
            s = generatePartialStar(telephoneNum, 4, -1);
        }else {
            s = generatePartialStar(telephoneNum, 4, -1);
        }
        return s;
    }

    /**
     * QQ号码 转换器
     */
    public static String qqNumberTransformer(String qqNumber) {
        if (qqNumber == null) {
            logger.error("qqNumber can not be null");
            return null;
        } else {
            return generatePartialStar(qqNumber, 3, -1);
        }
    }

    /**
     * 身份证号 转换器
     */
    public static String idCardnumtransformer(String idCardNum) {
        if (idCardNum == null) {
            logger.error("IDcardNum can not be null");
            return null;
        } else {
            return generatePartialStar(idCardNum, 6, 14);
        }
    }

    /**
     * 详细地址 转换器
     */
    public static String detailAddressTransformer(String detailAddress) {
        if (detailAddress == null) {
            logger.error("detailAddress can not be null");return "*";
        } else {
            return generateFullStar(detailAddress);
        }

    }

    /**
     * 标准地址  转换器
     */
    public static String standardAddressTransformer(String standardAddress) {
        if (standardAddress == null) {
            logger.error("standardAddress can not be null");  return null;
        } else {
            return generateFullStar(standardAddress);
        }
    }

    /**
     * 经纬度 转换器
     */
    public static String coordinateValueTransformer(String coordinateValue) {
        if (coordinateValue == null) {
            logger.error("coordinateValue can not be null");
            return null;
        } else {
            return generateFullStar(coordinateValue);
        }
    }


    private static String generateFullStar(String srcString) {
        if (srcString == null) {
            logger.error("srcString can not be null");
            return null;
        } else {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < srcString.length(); i++) {
                s.append("*");
            }

            return s.toString();
        }
    }

    private static String generatePartialStar(String srcString, int starStartPosition, int starEndPosition) {
        char[] chars = srcString.toCharArray();
        int endPosition = chars.length;
        if (starEndPosition < chars.length && starEndPosition > starStartPosition) {
            endPosition = starEndPosition;
        }

        for (int i = starStartPosition; i < endPosition; i++) {
            chars[i] = '*';
        }
        return new String(chars);
    }


}
