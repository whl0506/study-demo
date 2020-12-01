package com.test;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.test.util.ConstantPropertiesUtil;
import org.junit.Test;

/**
 * 各种java SDK可参照阿里云官网OSS对象存储
 * https://www.aliyun.com/product/oss
 * 对象存储 OSS > SDK 示例 > Java SDK
 */
public class OSSTest {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = ConstantPropertiesUtil.END_POINT;
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
    String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
    String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

    @Test
    public void testCreateBucket() {

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 创建存储空间。
        if (!ossClient.doesBucketExist(bucketName)) {
            ossClient.createBucket(bucketName);
        }
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    @Test
    public void testModifyBucketAcl() {

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 创建存储空间。
        if (ossClient.doesBucketExist(bucketName)) {
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
        }
        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
