# springboot-mybatis





解决办法

检查你的应用是否设置了没有 ActionBar 的主题Theme，或者直接设置了 NoActionBar或NoTitleBar 属性，主要要检查这几点：检查 AndroidManifest.xml 中的 标签中的theme属性，然后检查各个 Activity 标签中是否有不同的 Theme 导致这个界面的 ActionBar 无法显示，@android:style/Theme.NoTitleBar和<item name="windowActionBar">false</item> 
<item name="android:windowNoTitle">true</item>这样的属性都会使应用中的 ActionBar消失，切记，如果你要使用ActionBar,则一定要清除掉这些Theme属性设置，如果你的项目中 res 目录下除了 values 目录外，还有其他的res/values-v11，style/values-v14等，则这些目录中的 styles.xml 都需要检查一下，最后再检查下 Activity 代码中是否动态设置了全屏或者不显示TitleBar,代码如下： 
//requestWindowFeature(Window.FEATURE_NO_TITLE); 
//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 

上面的两句代码，上面一句设置Activity不显示TitleBar, 下一句则设置Activity为全屏模式，这两句代码都会导致 ActionBar 
无法显示，从而使 getActionBar()获取失败，如果你的项目中的 Activity 有父一级别的 Activity,则也需要将父一级别的Activity中的NoTitle和全屏代码注释掉；.
如果你不确定你的应用所用的主题 Theme 是否支持 ActionBar，可以在 res/values.xml 文件中设置为Theme.AppCompat,这是 AppCompat 中的Theme主题，可以保证低版本Android上也可以使用 ActionBar（注意：res/values,res/values-v11,res/values-v14等目录中的style都要进行style设置，并且都要注意：不要设置成第1条中会禁止ActionBar显示的主题，但可以设置为不同种类的主题），另外，在 Acticity 中获取 ActionBar 的时候（getActionBar()或getSupportBar()）, 需要在 setContentView(R.layout.main)之后调用；
如果你的项目使用的是 android.app.ActionBar，则需要把你应用的最低支持版本改为11（Android 3.0），使用 getActionBar() 来获取ActionBar，如果你的项目要支持Android 3.0以下，则你的项目需要引入最新的 AppCompat 兼容包，然后将 ActionBar引用改为 android.support.v7.app.ActionBar,并使用 getSupportActionBar 来获取 ActionBar；
除了以上的原因可能导致 ActionBar 获取为空的话，还有其他的原因导致 getActionBar() 获取失败，例如我在网上查找的时候，有人的项目是在Android SDK 2.2上新建的，当他使用 ActionBar 的时候将 AndroidManifest.xml 中的 minSdkVersion设置为11后()，发现 getActionBar() 获取失败是因为项目中没有 res/values-v11和res/values-v14和其中的style.xml文件，我最近遇到的 getActionBar() 为null是在 Eclipse 中导入了一个别人发给我的项目，但是在他的电脑上编译运行的apk getActionBar(), 但在我的电脑上则不行，试了上面的几种方法也不行，最后，我把这个项目导入到了 Android Studio 中，终于可以正常运行了。
如果大家有其他的有关 getActionBar() 为null的问题，方法和经验，欢迎讨论交流。

#########################################################

先看看你的工程中有没有values-v11或者v14的包，没有的话就去其他工程中copy一份过来。
然后排出以下几点：
1.活动类及其父类中，不要设置为全屏：
//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  
2.配置清单中，添加的主题：
android:theme="@style/AppTheme" >  
其父主题要具有ActionBar，例如：
<style name="AppTheme" parent="@android:style/Theme.Holo.Light">  
3.getActionBar()写在setContentView()后面。


