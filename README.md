### 智慧劳务集成步骤

### 当前最新版本：V1.1.1

##### 1. 项目根目录build.gradle添加，如下：

<pre><p>
    allprojects {
     repositories {
		//如果提示下载glide失败，建议添加阿里的公共仓库地址
		maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
        ......
        maven { url "https://jitpack.io" }
        maven {
            url "http://mvn.gemantic.com:19909/content/repositories/releases"
        }
     }
    }
</p></pre>

#####  2. app的build.gradle添加，如下配置：

<pre><p>
     android {
           ......
           defaultConfig {
                ......
                ndk {
                    abiFilters "armeabi-v7a"
                }
          }
    }
    //recyclerview和annotations版本号要大于等于24.0.0
    configurations.all {
         resolutionStrategy {
             force 'com.android.support:support-annotations:24.0.0'
             force 'com.android.support:recyclerview-v7:24.0.0'
         }
    }
    dependencies {
              ......
               compile （"rn-android-basic:rn-mingonghui:1.1.1"）{
                    exclude module: 'support-v4'
                    exclude group: 'com.android.support', module: 'design'
			   }
    }

</p></pre>


#####  3. 打开智慧劳务，调用代码如下：

<pre><p>
      MingonghuiManager.getInstance()
		                //设置运行环境：true   生产环境   false  测试环境
                        .setIsProduct(false)
                        //uid:基座uid
                        .setUid("uid")
                        //channelId：云码通在统一账户的渠道id
                        .setChannelId("channelId")
                        .open(application,activity);

</p></pre>

##### 注意事项：

###### 如遇部分手机闪退，就把sample里jniLibs-rn里面的so文件拷贝到主项目中

#####  测试账号：

####### 11112018111 123456
####### 11112018112 123456