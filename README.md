### 智慧劳务集成步骤

### 当前最新版本：V1.0.3

##### 1. 项目根目录build.gradle添加，如下：

<pre><p>
    allprojects {
     repositories {
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
                    abiFilters "armeabi-v7a", "x86"
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
               compile "rn-android-basic:rn-mingonghui:1.0.2"
    }

</p></pre>


#####  3. 打开智慧劳务，调用代码如下：

<pre><p>
      MingonghuiManager.getInstance()
		                //设置运行环境：true   生产环境   false  测试环境
                        .setIsProduct(false)
                        //uid
                        .setUid("uid")
                        //渠道id
                        .setChannelId("channelId")
                        .open(application,activity);

</p></pre>


#####  测试账号：

####### 11112018111 123456
####### 11112018112 123456