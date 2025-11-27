# Android - InsetsWidget

[![Android](https://img.shields.io/badge/android-23%2B-brightgreen?style=flat-square)](https://developer.android.com)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.takwolf.android.insetswidget/insetswidget?style=flat-square)](https://central.sonatype.com/artifact/io.github.takwolf.android.insetswidget/insetswidget)

一组处理 [在视图中以无边框方式显示内容](https://developer.android.com/develop/ui/views/layout/edge-to-edge?hl=zh-cn) 的组件，用于快速实现沉浸式布局效果。

## Snippets

```kotlin
implementation("androidx.core:core-ktx:1.17.0")
implementation("androidx.activity:activity-ktx:1.12.4")
implementation("io.github.takwolf.android.insetswidget:insetswidget:0.0.1")

// 可选，为 `ConstraintLayout` 添加支持。
implementation("androidx.constraintlayout:constraintlayout:2.2.1")
implementation("io.github.takwolf.android.insetswidget:constraintlayout:0.0.1")
```

## Usage

### Setup

在 `Activity` 中启用「无边框模式」：

```kotlin
class SomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some)
    }
}
```

最后，确保不要在布局中使用 `android:fitsSystemWindows="true"` 属性。

该属性会拦截 `WindowInsets` 事件，从而导致组件失效。

### InsetsView

包括：

- `InsetsView`
- `InsetsSpace`

这个类型的组件尺寸会自动适配窗口附加物类型的尺寸。例如：

```xml
<com.takwolf.android.insetswidget.InsetsView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:isw_insetsType="statusBars" />
```

### InsetsLayout

包括：

- `InsetsFrameLayout`
- `InsetsLinearLayout`
- `InsetsNestedScrollView`  
- `InsetsConstraintLayout`

这个类型的组件，会自动添加 `Padding` 来适配窗口附加物类型的尺寸。也可以额外配置颜色。例如：

```xml
<com.takwolf.android.insetswidget.InsetsLinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    app:isw_insetsType="statusBars|navigationBars"
    app:isw_insetsPaddingBottom="false"
    app:isw_insetsColorTop="@color/translucent_black"
    app:isw_insetsColorBottom="@color/translucent_black">
    
    <YourView />
    
</com.takwolf.android.insetswidget.InsetsLinearLayout>
```

## License

[Apache License 2.0](LICENSE)
